package kz.bank.services;

import kz.bank.entity.User;
import kz.bank.model.UserRequest;
import kz.bank.repositories.UserRepository;
import kz.bank.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProvider jwtTokenUtil;




    public List<User> getUsers(String token) {

        String username=jwtTokenUtil.getUsernameFromToken(token.substring(7),0);

        User user= userRepository.findByUsername(username);

        if (user.getRole()==1){
            return userRepository.allUsers();

        }else {
            List<Integer> showUserByRole= new ArrayList<>();
            showUserByRole.add(user.getRole());
            return userRepository.findAllByRoleInOrderById(showUserByRole);
        }

    }



    public long addUser(UserRequest userRequest, String token){
        //TODO реализовать проверку ролей
        long id=0;
        if (!userRepository.existsByUsername(userRequest.getUsername())){

            id= userRepository.save( toEntityUser(userRequest)).getId();
        }

        return id;
    }

    public void Delete(UserRequest userRequest) {

        userRepository.delete(toEntityUser(userRequest));
    }


    public void Update(UserRequest userRequest) {
            userRepository.updateUser(userRequest.getDescription(),
                    userRequest.getRole(),
                    userRequest.isEnable(), userRequest.isLocked(), userRequest.isExpired(),
                    userRequest.getUsername());
    }


    public void updatePassword(UserRequest userRequest) {
        userRepository.updatePassword( passwordEncoder().encode(userRequest.getPassword()),userRequest.getUsername());
    }


    private User toEntityUser(UserRequest userRequest) {
        System.out.println(userRequest.getDescription());

        User user=new User();
        user.setId(userRequest.getId());
        user.setDescription(userRequest.getDescription());
        user.setUsername(userRequest.getUsername());
        user.setEnable(userRequest.isEnable());
        user.setLocked(userRequest.isLocked());
        user.setExpired(userRequest.isExpired());
        user.setRole(userRequest.getRole());
        return  user;
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
