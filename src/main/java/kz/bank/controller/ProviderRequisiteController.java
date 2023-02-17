package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.ProviderRequisite;
import kz.bank.services.ProviderRequisiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Параметры провайдера"
        , description = "")
@RestController
@RequestMapping("v1/requisite")
@AllArgsConstructor
public class ProviderRequisiteController {

    private ProviderRequisiteService providerRequisiteService;

    @Operation(summary = "Получение реквизитного состава провайдера",
            description = "Реквизитный состав провайдера TODO добавить описание полей"
    )
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getRequisites(@RequestParam("ProviderId") Long ProviderId) {
        return ResponseEntity.ok(providerRequisiteService.getRequisites(ProviderId));
    }


    @Operation(summary = "Добавление или change параметров провайдера",
            description = "Реквизитный состав провайдера TODO добавить описание полей"
    )
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> changeRequisite(@RequestBody List<ProviderRequisite> providerRequisite) {
        return ResponseEntity.ok(providerRequisiteService.changeRequisite(providerRequisite));
    }



}
