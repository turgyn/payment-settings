package kz.bank.repositories;


import kz.bank.entity.ProviderChannel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface ChannelRepository extends JpaRepository<ProviderChannel, Long> {

}
