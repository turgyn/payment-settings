package kz.bank.entity;

import kz.bank.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "provider-entity-graph",
                includeAllAttributes = true
        )
})
@Entity
@Table(name = "provider", schema = "payment")
public class Provider implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "group_key")
    private String groupKey;

    @Column(name = "group_name_content_id")
    private long groupNameContentId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "single_name_content_id")
    private long singleNameContentId;

    @Column(name = "status")
    private Status status;

    @Column(name = "find_text")
    private String findText;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProviderStatus providerStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProviderChannel providerChannel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProviderLimit providerLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProviderSkill providerSkill;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ProviderAccount providerAccount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "content_id", referencedColumnName = "single_name_content_id")
    private List<Translation> translation;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private Set<CategoryBuffer> categoryBuffers;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private Set<RegionBuffer> regionBuffers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private Set<ProviderRequisite> providerRequisites;
}