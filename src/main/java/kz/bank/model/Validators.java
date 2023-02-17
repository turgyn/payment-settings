package kz.bank.model;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Validators implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Validator> Validator;
}
