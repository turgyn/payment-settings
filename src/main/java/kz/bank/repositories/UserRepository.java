package kz.bank.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import kz.bank.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 29.04.2022
 */

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {


        @EntityGraph(value = "user-entity-graph")
        User findByUsername(String username);


        @Query("from User u inner join Role r on r.id = u.role")
        List<User> allUsers();


        @Query("from User u inner join Role r on r.id = u.role where  u.role > :roles")
        List<User> findAllByRoleInOrderById(@Param("roles") List<Integer> Role);


        boolean existsByUsername(String Username);

        @Modifying(clearAutomatically = true)
        @Query("UPDATE User SET description = :description, " +
                "role= :role, " +
                "enable=:enable , locked=:locked , expired = :expired, " +
                "username = :username  " +
                "WHERE username = :username\n")
        void updateUser(@Param("description")String description,
                        @Param("role")int role,
                        @Param("enable")boolean enable,@Param("locked")boolean locked,@Param("expired")boolean expired,
                        @Param("username")String username
                        );


        @Modifying(clearAutomatically = true)
        @Query("UPDATE User SET password= :password   WHERE username = :username\n")
        void updatePassword(@Param("password")String password, @Param("username")String username
        );

}


