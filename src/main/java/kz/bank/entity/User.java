package kz.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "user-entity-graph",
                includeAllAttributes = true

        )
})
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;



    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "username")
    private String username;


    @NotNull
    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer role;



    @Column(name = "enable")
    private boolean enable;

    @Column(name = "locked")
    private boolean locked;
    @Column(name = "expired")
    private boolean expired;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Role roles;

    public User(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}