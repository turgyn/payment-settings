package kz.bank.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 27.04.2022
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Платежи")
                        .description("Платежная система")
                        .version("v1.0")
                       // .contact(new Contact()
                        //        .name("Платежи")
                        //        .url("https://sberbank.kz")
                        //        .email("payregistry@sberbank.kz"))
                        //.termsOfService("TOC")
                        //.license(new License().name("License").url("#"))
                );
    }
}
