package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.Category;
import kz.bank.model.CategoryResponse;
import kz.bank.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:3003", maxAge = 3600)
@Tag(name = "Настройка категорий"
        , description = "Настройка категорий думаю и так ясно")
@RestController
@RequestMapping("/v1/category")
public class CategoriesController {

    @Autowired
    public CategoriesService categoriesService;

    @Operation(summary = "Получение всех категорий",
            description = "Список категорий")
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoriesService.getCategories();
    }

    @Operation(summary = "Добавление категорий",
            description = "")
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public CategoryResponse addCategories(@RequestBody Category category) {

        try {
            long id=categoriesService.addCategories(category);
            return  new CategoryResponse(id, true);
        }catch (Exception e){
            return  new CategoryResponse(0, false);
        }
    }

    @Operation(summary = "Удаление категорий",
            description = "")
    @RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCategories(@RequestBody Category category) {
        categoriesService.Delete(category);
    }

    @Operation(summary = "Изминение категорий",
            description = "")
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json",name = "update")
    public void updateCategories(@RequestBody Category category) {
        categoriesService.update(category);
    }
}
