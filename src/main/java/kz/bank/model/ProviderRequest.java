package kz.bank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.bank.entity.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 30.05.2022
 */

@Data
public class ProviderRequest {
    @JsonProperty("provider")
    private Provider provider;

    private  String findText;










}
