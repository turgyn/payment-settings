package kz.bank.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "provider_limit", schema = "payment")
public class ProviderLimit {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "key_limit_amount")
    private double keyLimitAmount;

    @Column(name = "key_limit_value")
    private String keyLimitValue;

    @Column(name = "max_amount")
    private double maxAmount;

    @Column(name = "min_amount")
    private double minAmount;




}