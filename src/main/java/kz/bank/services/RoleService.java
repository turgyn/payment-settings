package kz.bank.services;

import kz.bank.entity.Role;
import kz.bank.entity.User;
import kz.bank.repositories.RoleRepository;
import kz.bank.repositories.UserRepository;
import kz.bank.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtTokenUtil;




    public List<Role> getRoles(String token) {

        String username=jwtTokenUtil.getUsernameFromToken(token.substring(7),0);

        User user= userRepository.findByUsername(username);

        if (user.getRole()==1){
            return roleRepository.findAll();

        }else {
            //List<Integer> showRoleByUser= new ArrayList<>();
            // showRoleByUser.add(user.getRole()+1);
            return roleRepository.findByIdGreaterThanEqual(user.getRole()+1);
        }

    }



    public Role addRole(Role role){


        return roleRepository.save(role);
    }

    public void Delete(Role role) {

        roleRepository.delete(role);
    }


    public void Update(Role role) {
        roleRepository.save(role);
    }







}
