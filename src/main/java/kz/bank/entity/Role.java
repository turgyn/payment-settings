package kz.bank.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;



@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "role-entity-graph",
                includeAllAttributes = true
        )
})
@Entity
@Table(name = "role")
public class Role {



    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private  List<User> users;


    public Role(){}
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}