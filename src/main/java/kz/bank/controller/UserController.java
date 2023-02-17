package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import kz.bank.model.UserRequest;
import kz.bank.model.UserResponse;

import kz.bank.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

/**
 * Платежная система *
 *
 * @author u11549
 * @Date 27.04.2022
 */


@Tag(name = "Пользователи", description = "Управления пользователями")
@RestController
@CrossOrigin
@RequestMapping("/v1/user")
public class UserController {



    @Autowired
    private UserService userService;



    @Operation(summary = "Получение данных о пользователях",
            description = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(userService.getUsers(token));
    }

    @Operation(summary = "Регистрация нового пользователя",
            description = "")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody UserRequest user,@RequestHeader("Authorization") String token) {

        UserResponse userResponse = new UserResponse();
        userResponse.status = -1;
        if (userService.addUser(user, token) > 1){
            userResponse.status = 0;
            userResponse.message = "Пользователь " + user.getUsername() + " успешно добавлен";
        }

        return ResponseEntity.ok(userResponse);
    }

    @Operation(summary = "Удаление пользователя")
    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteRegion(@RequestBody UserRequest user) {
        userService.Delete(user);
    }

    @Operation(summary = "Изминение пользователя")
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateRegion(@RequestBody UserRequest user) {
        userService.Update(user);
    }


    @Operation(summary = "Изминение пароля")
    @RequestMapping(path = "/password", method = RequestMethod.POST, headers = "Accept=application/json")
    public void updatePassword(@RequestBody UserRequest user) {
        userService.updatePassword(user);
    }



}