package kz.bank.repositories;


import kz.bank.entity.ProviderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface StatusRepository extends JpaRepository<ProviderStatus, Long> {

}
