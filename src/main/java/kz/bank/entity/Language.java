package kz.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages", schema = "payment")
public class Language {
    @Id
    @Column(name = "language_id", nullable = false)
    private Long id;

    @Column(name = "language_name", nullable = false, length = 30)
    private String languageName;

    @Column(name = "language_code", nullable = false, length = 15)
    private String languageCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

}