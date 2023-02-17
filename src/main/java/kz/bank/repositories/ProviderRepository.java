package kz.bank.repositories;

import kz.bank.entity.Provider;
import kz.bank.enums.Status;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    @EntityGraph(value = "provider-entity-graph")
    List<Provider> findAll();

    @Procedure(value = "payment.createProvider")
    long createProvider(@Param("group_key") String groupKey,
                        @Param("priority") int priority,
                        @Param("group_name_content_id") long groupNameContentId,
                        @Param("single_name_content_id") long single_name_content_id,
                        @Param("status") int status,
                        @Param("findText") String findText,
                        @Param("description_content_id") long descriptionContentId,
                        @Param("another") boolean another,
                        @Param("atm") boolean atm,
                        @Param("kassa") boolean kassa,
                        @Param("mobile_banking") boolean mobileBanking,
                        @Param("keylimitamount") double keyLimitAmount,
                        @Param("keylimitvalue") String keyLimitValue,
                        @Param("max_amount") double maxAmount,
                        @Param("min_amount") double minAmount,
                        @Param("abp") boolean abp,
                        @Param("auto_pay") boolean autoPay,
                        @Param("favorites") boolean favorites,
                        @Param("pattern") boolean pattern,
                        @Param("push") boolean push);

   // @EntityGraph(value = "provider-entity-graph")
    @Query("from Provider p where p.findText like %:findText%")
    List<Provider> findProviders(@Param("findText") String findText);

    @Modifying
    @Query("DELETE from Provider p where p.id= :Id")
    void deleteProvider(@Param("Id") Long Id);

    @Modifying
    @Query("Update  Provider  set status=:status where id= :Id")
    void changeProviderStatus(@Param("Id") Long Id, @Param("status")Status status);
}
