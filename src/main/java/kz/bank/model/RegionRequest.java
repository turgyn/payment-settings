package kz.bank.model;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 29.04.2022
 */
public class RegionRequest {

    public long id;
    public String regionCode;

    public long priority;
    public String regionNameRu;
    public String regionNameKz;
    public String regionNameEn;
    public String descriptionRu;
    public String descriptionKz;
    public String descriptionEn;
    public long translationContentId;

    public RegionRequest(String regionCode, long priority, String regionNameRu, String regionNameKz, String regionNameEn, String descriptionRu, String descriptionKz, String descriptionEn) {
        this.regionCode = regionCode;
        this.priority = priority;
        this.regionNameRu = regionNameRu;
        this.regionNameKz = regionNameKz;
        this.regionNameEn = regionNameEn;
        this.descriptionRu = descriptionRu;
        this.descriptionKz = descriptionKz;
        this.descriptionEn = descriptionEn;
    }

    public RegionRequest(){}


    public RegionRequest(long id,  String regionCode, long priority, String regionNameRu, String regionNameKz, String regionNameEn, String descriptionRu, String descriptionKz, String descriptionEn) {
        this.id = id;

        this.regionCode=regionCode;
        this.priority=priority;
        this.regionNameRu = regionNameRu;
        this.regionNameKz = regionNameKz;
        this.regionNameEn = regionNameEn;
        this.descriptionRu = descriptionRu;
        this.descriptionKz = descriptionKz;
        this.descriptionEn = descriptionEn;
    }

    public long getTranslationContentId() {
        return translationContentId;
    }

    public void setTranslationContentId(long translationContentId) {
        this.translationContentId = translationContentId;
    }
    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }


    public String getRegionNameRu() {
        return regionNameRu;
    }

    public void setRegionNameRu(String regionNameRu) {
        this.regionNameRu = regionNameRu;
    }

    public String getRegionNameKz() {
        return regionNameKz;
    }

    public void setRegionNameKz(String regionNameKz) {
        this.regionNameKz = regionNameKz;
    }

    public String getRegionNameEn() {
        return regionNameEn;
    }

    public void setRegionNameEn(String regionNameEn) {
        this.regionNameEn = regionNameEn;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getDescriptionKz() {
        return descriptionKz;
    }

    public void setDescriptionKz(String descriptionKz) {
        this.descriptionKz = descriptionKz;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }











}
