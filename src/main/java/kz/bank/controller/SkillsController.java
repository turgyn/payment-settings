package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.ProviderSkill;
import kz.bank.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Дополнительные возможности услуг"
        , description = "")
@RestController
@RequestMapping("v1/skills")
public class SkillsController {

    @Autowired
    private SkillsService skillsService;

    @Operation(summary = "Получение всех возможности у услуг",
            description = "abp - возможность подключения к активной корзина платежей; " +
                    "auto_pay - возможность создания автоплатежа;" +
                    "favorites - возможность добавления в избранное;" +
                    "pattern - возможность создания шаблона ;" +
                    "push - отправка статуса платежа клиенту;"
    )
    @RequestMapping(method = RequestMethod.GET)
    public List<ProviderSkill> getCategories() {
        return skillsService.getProviderSkills();
    }

//    @Operation(summary = "Добавление дополнительной возможности к услуге",
//            description = "")
//    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
//    public void addSkills(@RequestBody ProviderSkill providerSkill) {
//        skillsService.addSkills(providerSkill);
//    }


    @Operation(summary = "Изменение дополнительной возможности у услуги",
            description = "")
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateCategories(@RequestBody ProviderSkill providerSkill) {
        skillsService.Update(providerSkill);
    }
}
