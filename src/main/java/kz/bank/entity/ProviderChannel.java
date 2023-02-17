package kz.bank.entity;

import javax.persistence.*;

@Entity
@Table(name = "provider_channel", schema = "payment")
public class ProviderChannel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "another", nullable = false)
    private Boolean another = false;

    @Column(name = "atm", nullable = false)
    private Boolean atm = false;

    @Column(name = "kassa", nullable = false)
    private Boolean kassa = false;

    @Column(name = "mobile_banking", nullable = false)
    private Boolean mobileBanking = false;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAnother() {
        return another;
    }

    public void setAnother(Boolean another) {
        this.another = another;
    }

    public Boolean getAtm() {
        return atm;
    }

    public void setAtm(Boolean atm) {
        this.atm = atm;
    }

    public Boolean getKassa() {
        return kassa;
    }

    public void setKassa(Boolean kassa) {
        this.kassa = kassa;
    }

    public Boolean getMobileBanking() {
        return mobileBanking;
    }

    public void setMobileBanking(Boolean mobileBanking) {
        this.mobileBanking = mobileBanking;
    }

}