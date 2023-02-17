package kz.bank.model;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 27.04.2022
 */


public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;




    private  String user;
    private  String error;
    private  String accessToken;
    private  String refreshToken;
    private  int status;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(){
    }



    public JwtResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }
    public JwtResponse(String user, String accessToken, String refreshToken, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.authorities = authorities;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUser() {
        return user;
    }
    public String getToken() {
        return this.accessToken;

    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}