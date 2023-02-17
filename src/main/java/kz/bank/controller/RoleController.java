package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.Role;
import kz.bank.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Платежная система *
 *
 * @author u11549
 * @Date 27.04.2022
 */


@Tag(name = "Роль", description = "Управления ролями")
@RestController
@CrossOrigin
@RequestMapping("/v1/role")
public class RoleController {



    @Autowired
    private RoleService roleService;

    @Operation(summary = "Получение данных о ролях",
            description = "")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getRoles(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(roleService.getRoles(token));
    }


    @Operation(summary = "Создание нового роля",
            description = "")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    @Operation(summary = "Удаление роля")
    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteRole(@RequestBody Role role) {
        roleService.Delete(role);
    }

    @Operation(summary = "Изминение роля")
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateRole(@RequestBody Role role) {
        roleService.Update(role);
    }


    @Operation(summary = "Привязка  роля к поставщикам услуг",
            description = "")
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<?> addProviderToRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }



}