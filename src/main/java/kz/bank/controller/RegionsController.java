package kz.bank.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.Region;
import kz.bank.model.RegionRequest;
import kz.bank.model.RegionResponse;
import kz.bank.services.RegionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3003", maxAge = 3600)
@Tag(name = "Настройка регионов"
        , description = "Ну настройка регионов")
@RestController
@RequestMapping("/v1/region")
public class RegionsController {

    @Autowired
    private RegionsService regionsService;

    @Operation(summary = "Получение всех регионов",
            description = "Список регионов")
    @RequestMapping(method = RequestMethod.GET)
    public List<RegionResponse> getRegions() {
        return regionsService.getRegions();
    }



    @Operation(summary = "Добавление региона")
    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    public ResponseEntity<?> addRegion(@RequestBody RegionRequest request) {
            return  ResponseEntity.ok(regionsService.addRegion(request));


    }

    @Operation(summary = "Удаление региона")
    @RequestMapping(method = RequestMethod.DELETE, headers = "Content-Type=application/json")
    public void deleteRegion(@RequestBody Region regions) {
        regionsService.Delete(regions);
    }

    @Operation(summary = "Изминение региона")
    @RequestMapping(method = RequestMethod.PUT, headers = "Content-Type=application/json")
    public void updateRegion(@RequestBody RegionRequest regions) {
        regionsService.Update(regions);
    }
}
