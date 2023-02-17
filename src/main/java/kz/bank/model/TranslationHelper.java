package kz.bank.model;

import kz.bank.enums.Lang;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 02.06.2022
 */

@Data
@AllArgsConstructor
public class TranslationHelper {

    private Lang lang;
    private String Text;
    private String HelpText;

}
