package kz.bank.repositories;

import kz.bank.entity.Role;
import kz.bank.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 25.05.2022
 */
@Repository
@Transactional
public interface TranslationRepository extends JpaRepository<Translation, Long> {

    @Query("FROM Translation where contentId = (select translationContentId from Region where id=:ContentId)")
    List<Translation> groupContentId(@Param("ContentId") long ContentId);

    @Modifying
    @Query("DELETE FROM Translation where contentId= :contentId")
    void deleteGroup(@Param("contentId")Long contentId);


    @Query(value = "select nextval('payment.translations_id_seq')", nativeQuery = true)
    long getNextValTranslationSequence();


    void deleteTranslationByContentId(Long contentId);

    @Modifying
    @Query("DELETE FROM Translation t WHERE t.contentId in (select p.singleNameContentId from Provider p where p.id=:providerId)")
    void deleteProviderSingleAndGroupName(@Param("providerId")Long providerId);


    @Modifying
    @Query("DELETE FROM Translation t WHERE t.contentId in (select s.descriptionContentId from ProviderStatus s where s.id=:providerId)")
    void deleteProviderStatusName(@Param("providerId")Long providerId);
}
