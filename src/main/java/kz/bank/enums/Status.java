package kz.bank.enums;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 23.05.2022
 */
public enum Status {

    
    PAUSE(0),
	ON(1),
    OFF(-1),
    EXPIRED(-2);

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private  int code;


    Status(int i) {
        this.code=i;
    }
}
