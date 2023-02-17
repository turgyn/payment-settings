package kz.bank.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    List<String> value;
}
