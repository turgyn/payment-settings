package kz.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 30.05.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {

    public ProviderResponse(String error, int status, Long id) {
        this.error = error;
        this.status = status;
        Id = id;
    }

    private  String error;
    private  int status;
    private  Long Id;

    private String findText;


}
