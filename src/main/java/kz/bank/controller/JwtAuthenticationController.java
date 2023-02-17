package kz.bank.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import kz.bank.model.JwtRequest;
import kz.bank.model.JwtResponse;
import kz.bank.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;

/**
 * Платежная система *
 *
 * @author u11549
 * @Date 27.04.2022
 */


@Tag(name = "Авторизация", description = "Авторизация c использованием JWT токена")
@RestController
@RequestMapping(value = "/v1/auth/")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;



    @Autowired
    private JwtUserDetailsService userDetailsService;


    @Operation(summary = "Создание авторизационного токена",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

        final JwtResponse token = userDetailsService.login(authenticationRequest);

        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }




    @Operation(summary = "Получение нового access-token",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody JwtRequest request) {
        final JwtResponse token = userDetailsService.getAccessToken(request.getRefreshToken());
        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }


    @Operation(summary = "Получение нового access-token",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "refresh")
    public ResponseEntity<?> getNewRefreshToken(@RequestBody JwtRequest request) throws AuthException {

        final JwtResponse token = userDetailsService.refresh(request.getRefreshToken());
        if (token.getError()!=null){
            return  new ResponseEntity<>(
                    token, HttpStatus.FORBIDDEN);
        }

        return  new ResponseEntity<>(
                token, HttpStatus.OK);
    }



}