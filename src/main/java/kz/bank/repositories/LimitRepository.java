package kz.bank.repositories;


import kz.bank.entity.ProviderLimit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface LimitRepository extends JpaRepository<ProviderLimit, Long> {

}
