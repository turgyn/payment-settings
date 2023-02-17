package kz.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "region-entity-graph",
                includeAllAttributes = true

        )
})
@Entity
@Table(name = "region", schema = "payment")
public class Region implements Serializable {

    @Id
    @SequenceGenerator(name = "region_sequence_generator", sequenceName = "region_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_sequence_generator")
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "translation_content_id", nullable = false)
    private Long translationContentId;

    @Column(name = "code", length = 15)
    private String code;

    @Column(name = "priority", nullable = false, columnDefinition = "long default 25")
    private Long priority;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id", referencedColumnName = "translation_content_id", updatable = false, insertable = false)
    private List<Translation> translations;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getTranslationContentId() {
        return translationContentId;
    }

    public void setTranslationContentId(Long translationContentId) {
        this.translationContentId = translationContentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
    public List<Translation> getTranslations() {
        return translations;
    }

    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}