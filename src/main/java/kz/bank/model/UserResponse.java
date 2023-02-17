package kz.bank.model;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 29.04.2022
 */
public class UserResponse {

    public int status;
    public String error;
    public String message;
    public String fio;
    public int role;
    public String user;
    public UserResponse(){}
    public UserResponse(String fio, int role, String user) {
        this.fio = fio;
        this.role = role;
        this.user=user;

    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user= user;
    }



}
