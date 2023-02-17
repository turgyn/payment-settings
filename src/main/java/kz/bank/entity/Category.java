package kz.bank.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @SequenceGenerator(name = "categories_sequence_generator", sequenceName = "categories_categoriesid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categories_sequence_generator")
    @Column(name = "id", nullable = false)
    private long categoryId;

    @Column(name = "name_ru")
    private String categoryNameRu;

    @Column(name = "name_kz")
    private String categoryNameKz;

    @Column(name = "name_en")
    private String categoryNameEn;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "priority")
    private long priority;




}