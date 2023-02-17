package kz.bank.controller;



import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.bank.entity.Provider;
import kz.bank.model.ProviderRequest;
import kz.bank.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Tag(description = "TODO Description",
        name = "Provider Resource")
@RestController
@RequestMapping("/v1/provider")
@AllArgsConstructor
public class ProviderController {


    private ProviderService providerService;

    @Operation(summary = "Получение всех провайдеров",
            description = "")
    @RequestMapping(method = RequestMethod.GET)
    public List<Provider> getProviders() {
        return providerService.getAllProviders();
    }


    @Operation(summary = "Поиск провайдера по ключевому имений",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "/find")
    public List<Provider> findProviders(@RequestBody ProviderRequest request) {
        return providerService.findProviders(request.getFindText());
    }


    @Operation(summary = "Поиск провайдера по Id",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "/byId")
    public Provider providerById(@RequestBody ProviderRequest request) {


        return providerService.ProviderById(request.getProvider().getId());
    }

    @Operation(summary = "Изминение статуса провайдера",
            description = "")
    @RequestMapping(method = RequestMethod.POST, path = "/status")
    public void statusProvider(@RequestBody ProviderRequest request) {
         providerService.changeStatus(request.getProvider());

    }


    @Operation(summary = "Добавление провайдера",
            description = "")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProvider(@RequestBody ProviderRequest request) {
        return ResponseEntity.ok(providerService.addProvider(request));
    }


    @Operation(summary = "Удаление провайдера",
            description = "")
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProvider(@RequestBody ProviderRequest request) {
        providerService.deleteProvider(request.getProvider());
        return ResponseEntity.ok("");
    }

}
