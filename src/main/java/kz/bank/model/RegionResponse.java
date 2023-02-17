package kz.bank.model;

import lombok.Data;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 29.04.2022
 */
@Data
public class RegionResponse {

    public Long id;
    public boolean published;
    public String regionCode;
    public long priority;
    public long translationContentId;
    public String regionNameRu;
    public String regionNameKz;
    public String regionNameEn;
    public String descriptionRu;
    public String descriptionKz;
    public String descriptionEn;

    public RegionResponse(){}

    public RegionResponse(long id, boolean published) {
        this.id = id;
        this.published = published;
    }












}
