package kz.bank.repositories;

import kz.bank.entity.ProviderRequisite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderRequisiteRepository extends JpaRepository<ProviderRequisite, Long> {


    List<ProviderRequisite> findByProviderId(long providerId);
}