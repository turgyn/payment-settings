package kz.bank.repositories;

import kz.bank.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 03.05.2022
 */
public interface CategoriesRepository extends JpaRepository<Category, Long> {
    boolean existsByParentIdAndCategoryNameRu(int ParentId, String CategoryNameRu);

    List<Category> findAllByOrderByCategoryIdAsc();

}
