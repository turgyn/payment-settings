package kz.bank.repositories;

import kz.bank.entity.ProviderAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderAccountRepository extends JpaRepository<ProviderAccount, Long> {
}