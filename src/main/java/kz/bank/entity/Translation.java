package kz.bank.entity;

import kz.bank.enums.Lang;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "translations", schema = "payment")
public class Translation implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique =true, nullable = false)
    private Long id;

    @Column(name = "content_id", nullable = false)
    private Long contentId;

    @Column(name = "language_id", nullable = false)
    private Lang languageId;

    @Column(name = "translation_name", nullable = false)
    private String translationName;

    @Column(name = "translation_helper")
    private String translationHelper;



    public Translation(Long contentId, Lang languageId, String translationName, String translationHelper) {
        this.contentId = contentId;
        this.languageId = languageId;
        this.translationName = translationName;
        this.translationHelper = translationHelper;
    }

}