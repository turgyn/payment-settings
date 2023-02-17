package kz.bank.repositories;

import kz.bank.entity.CategoryBuffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface CategoryBufferRepository extends JpaRepository<CategoryBuffer, Long> {


}
