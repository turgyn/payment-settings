package kz.bank.model;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 29.04.2022
 */
public class CategoryResponse {

    public long id;
    public boolean published;

    public CategoryResponse(){}
    public CategoryResponse(long id, boolean published) {
        this.id=id;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }










}
