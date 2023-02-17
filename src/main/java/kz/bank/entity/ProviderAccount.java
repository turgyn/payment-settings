package kz.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "provider_account", schema = "payment")
public class ProviderAccount implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "bik")
    private String bik;

    @Column(name = "bin")
    private long bin;

    @Column(name = "account")
    private String account;

    @Column(name = "knp")
    private int knp;

    @Column(name = "cod")
    private String cod;

    @Column(name = "vo")
    private String vo;

    @Column(name = "kbe")
    private int kbe;

    @Column(name = "kod")
    private int kod;

    @Column(name = "compensation")
    private boolean compensation;

    @Column(name = "group_criteria")
    private String groupCriteria;

    @Column(name = "code_template")
    private String codeTemplate;

    @Column(name = "equip_number")
    private int equipNumber;

    @Column(name = "kbk")
    private String kbk;

    @Column(name = "fio_director")
    private String fioDirector;

    @Column(name = "fio_founder")
    private String fioFounder;

    @Column(name = "iin_director")
    private long iinDirector;


}