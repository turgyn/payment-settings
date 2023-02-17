package kz.bank.services;

import kz.bank.entity.Category;

import kz.bank.repositories.CategoriesRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepository;

    public List<Category> getCategories() {

        return categoriesRepository.findAllByOrderByCategoryIdAsc();
    }

    public long addCategories(Category category){
        long id=0;
        if (!categoriesRepository.existsByParentIdAndCategoryNameRu(category.getParentId(), category.getCategoryNameRu())){
            id=categoriesRepository.save(category).getCategoryId();
        }
        return id;
    }



    public void Delete(Category category) {
        categoriesRepository.delete(category);
    }

    public void update(Category category) {
       Category newCategory=categoriesRepository.findById(category.getCategoryId()).orElse(category);
        newCategory.setCategoryNameEn(category.getCategoryNameEn());
        newCategory.setCategoryNameRu(category.getCategoryNameRu());
        newCategory.setCategoryNameKz(category.getCategoryNameKz());
        categoriesRepository.save(newCategory);
    }
}
