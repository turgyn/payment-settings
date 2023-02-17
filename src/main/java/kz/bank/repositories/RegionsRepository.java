package kz.bank.repositories;

import kz.bank.entity.Region;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface RegionsRepository extends JpaRepository<Region, Long> {

    boolean existsByCode(String code);


    @Query(value = "select nextval('payment.region_id_seq')", nativeQuery = true)
    long getNextValRegionSequence();


    @EntityGraph(value = "region-entity-graph")
    List<Region> findAllByOrderByPriorityDesc();


}
