package kz.bank.entity;

import kz.bank.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Entity
@Table(name = "provider_status", schema = "payment")
public class ProviderStatus implements Serializable {
    @Id

    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description_content_id")
    private Long descriptionContentId;



    @Column(name = "off_date")
    private Timestamp offDate;



    @Column(name = "on_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp onDate;


    @Column(name = "status")
    private Status status;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id", referencedColumnName = "description_content_id")
    private List<Translation> translation;


}