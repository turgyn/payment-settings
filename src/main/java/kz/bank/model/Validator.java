package kz.bank.model;

import lombok.Data;

@Data
public class Validator {
    private String Type;
    private String Message;
    private int Parameter;
}
