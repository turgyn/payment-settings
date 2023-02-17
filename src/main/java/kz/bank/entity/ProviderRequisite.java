package kz.bank.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import kz.bank.model.Menu;
import kz.bank.model.Validators;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "provider_requisite", schema = "payment")
@TypeDefs(
        {@TypeDef(name= "json", typeClass = JsonType.class)}
)
public class ProviderRequisite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "provider_id", nullable = false)
    private long providerId;

    @Column(name = "name_visible")
    private String nameVisible;
    @Column(name = "name_technical",nullable = false)
    private String nameTechnical;
    @Column(name = "description")
    private String description;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "is_visible")
    private boolean isVisible;
    @Column(name = "is_key")
    private boolean isKey;
    @Column(name = "is_editable")
    private boolean isEditable;
    @Column(name = "is_sum")
    private boolean isSum;
    @Column(name = "min_length")
    private int minLength;
    @Column(name = "max_length")
    private int maxLength;
    @Column(name = "entered_data")
    private String enteredData;
    @Column(name = "mask")
    private String mask;


    @Column(name = "menu", columnDefinition = "json")
    @Type(type = "json")
    private Menu menu;

    @Column(name = "validators",columnDefinition = "json" )
    @Type(type = "json")
    private Validators validators;




}
