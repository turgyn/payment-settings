package kz.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "provider_skill", schema = "payment")
public class ProviderSkill {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "А", nullable = false)
    private Boolean abp = false;

    @Column(name = "auto_pay", nullable = false)
    private Boolean autoPay = false;

    @Column(name = "favorites", nullable = false)
    private Boolean favorites = false;

    @Column(name = "pattern", nullable = false)
    private Boolean pattern = false;

    @Column(name = "push", nullable = false)
    private Boolean push = false;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAbp() {
        return abp;
    }

    public void setAbp(Boolean abp) {
        this.abp = abp;
    }

    public Boolean getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Boolean autoPay) {
        this.autoPay = autoPay;
    }

    public Boolean getFavorites() {
        return favorites;
    }

    public void setFavorites(Boolean favorites) {
        this.favorites = favorites;
    }

    public Boolean getPattern() {
        return pattern;
    }

    public void setPattern(Boolean pattern) {
        this.pattern = pattern;
    }

    public Boolean getPush() {
        return push;
    }

    public void setPush(Boolean push) {
        this.push = push;
    }

}