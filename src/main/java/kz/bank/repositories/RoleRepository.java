package kz.bank.repositories;

import kz.bank.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    @EntityGraph(value = "role-entity-graph")
    List<Role> findAll();
    @EntityGraph(value = "role-entity-graph")
    List<Role> findByIdGreaterThanEqual(Integer ids);


}
