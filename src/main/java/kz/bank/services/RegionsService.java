package kz.bank.services;

import kz.bank.entity.Region;
import kz.bank.entity.Translation;
import kz.bank.enums.Lang;
import kz.bank.model.RegionRequest;
import kz.bank.model.RegionResponse;
import kz.bank.repositories.RegionsRepository;
import kz.bank.repositories.TranslationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class RegionsService {


    private RegionsRepository regionsRepository;

    private TranslationRepository translationRepository;

    public List<RegionResponse> getRegions() {


        List<RegionResponse> regionResponses = new ArrayList<>();


        List<Region> regions = regionsRepository.findAllByOrderByPriorityDesc();
        for (int i = 0; i < regions.size(); i++) {

            RegionResponse regionResponse = new RegionResponse();
            regionResponse.id = regions.get(i).getId();
            regionResponse.regionCode = regions.get(i).getCode();
            regionResponse.priority = regions.get(i).getPriority();
            regionResponse.setTranslationContentId(regions.get(i).getTranslationContentId());
            for (int j = 0; j < regions.get(i).getTranslations().size(); j++) {

                if (regions.get(i).getTranslations().get(j).getLanguageId() == Lang.KZ) {
                    regionResponse.setRegionNameKz(regions.get(i).getTranslations().get(j).getTranslationName());
                    regionResponse.setDescriptionKz(regions.get(i).getTranslations().get(j).getTranslationHelper());
                } else if (regions.get(i).getTranslations().get(j).getLanguageId() == Lang.RU) {
                    regionResponse.setRegionNameRu(regions.get(i).getTranslations().get(j).getTranslationName());
                    regionResponse.setDescriptionRu(regions.get(i).getTranslations().get(j).getTranslationHelper());
                } else if (regions.get(i).getTranslations().get(j).getLanguageId() == Lang.EN) {
                    regionResponse.setRegionNameEn(regions.get(i).getTranslations().get(j).getTranslationName());
                    regionResponse.setDescriptionEn(regions.get(i).getTranslations().get(j).getTranslationHelper());

                }
            }

            regionResponses.add(regionResponse);
        }


        return regionResponses;
    }

    public long addRegion(RegionRequest regions) {

        long seqId = regionsRepository.getNextValRegionSequence();

        if (!regionsRepository.existsByCode(regions.getRegionCode())) {

            Region region = toEntityRegion(regions, 0, seqId);
            region.setTranslations(toEntityTranslation(regions, seqId, null));
           return regionsRepository.save(region).getId();
        }
        return 0;
    }


    public void Delete(Region regions) {

        try {
            log.info(String.valueOf(regions.getTranslationContentId()));
            regionsRepository.delete(regions);
            translationRepository.deleteTranslationByContentId(regions.getTranslationContentId());
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void Update(RegionRequest regions) {

        List<Translation> translations= translationRepository.groupContentId(regions.getId());
        translations=toEntityTranslation(regions, regions.getId(),translations);
        long contextId=translationRepository.saveAll(translations).get(0).getContentId();
        if (contextId>0)   {
            Region region = toEntityRegion(regions, regions.getId(), contextId);
            regionsRepository.save(regionsRepository.save(region)).getTranslationContentId();
        }

    }


    private Region toEntityRegion(RegionRequest regions,long Id, long ContentId) {

        Region region = new Region();
        if (Id != 0) {
            region.setId(Id);
        }

        region.setTranslationContentId(ContentId);
        region.setCode(regions.getRegionCode());
        region.setPriority(regions.getPriority());



        return region;
    }

    private List<Translation> toEntityTranslation(RegionRequest regions, long content_id, List<Translation> translations) {
        List<Translation> translationList = new ArrayList<>();


        if (translations == null) {
            translationList.add(new Translation(content_id, Lang.KZ, regions.getRegionNameKz(), regions.getDescriptionKz()));
            translationList.add(new Translation(content_id, Lang.RU, regions.getRegionNameRu(), regions.getDescriptionRu()));
            translationList.add(new Translation(content_id, Lang.EN, regions.getRegionNameEn(), regions.getDescriptionEn()));

        } else {


            for (int j = 0; j < translations.size(); j++) {

                if (translations.get(j).getLanguageId() == Lang.KZ) {
                    translationList.add(new Translation(
                            translations.get(j).getId(),
                            translations.get(j).getContentId(),
                            translations.get(j).getLanguageId(),
                            regions.getRegionNameKz(),
                            regions.getDescriptionKz()));

                } else if (translations.get(j).getLanguageId() == Lang.RU) {
                    translationList.add(new Translation(
                            translations.get(j).getId(),
                            translations.get(j).getContentId(),
                            translations.get(j).getLanguageId(),
                            regions.getRegionNameRu(),
                            regions.getDescriptionRu()));


                } else if (translations.get(j).getLanguageId() == Lang.EN) {
                    translationList.add(new Translation(
                            translations.get(j).getId(),
                            translations.get(j).getContentId(),
                            translations.get(j).getLanguageId(),
                            regions.getRegionNameEn(),
                            regions.getDescriptionEn()));
                }
            }

        }

        return translationList;
    }
}
