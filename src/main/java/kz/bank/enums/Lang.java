package kz.bank.enums;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 23.05.2022
 */
public enum Lang {

    KZ(0),
    RU(1),
    EN(2);

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private  int code;
    Lang(int i) {
        this.code=i;
    }
}
