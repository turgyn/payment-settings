package kz.bank.services;


import kz.bank.entity.*;

import kz.bank.model.ProviderRequest;
import kz.bank.model.ProviderResponse;

import kz.bank.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class ProviderService {
    private static Long ProviderId = null;

    private TranslationRepository translationRepository;
    private ProviderRepository providerRepository;
    private CategoryBufferRepository categoryBufferRepository;
    private RegionBufferRepository regionBufferRepository;
    private ProviderAccountRepository providerAccountRepository;
    private ProviderRequisiteRepository providerRequisiteRepository;


    public List<Provider> getAllProviders(){

        return providerRepository.findAll();
    }


    public List<Provider> findProviders(String findText){
        //TODO use Hibernate Search
        return providerRepository.findProviders(findText.toLowerCase());



    }

    public Provider ProviderById(long id){

        return providerRepository.findById(id).get();



    }

    public void changeStatus(Provider provider){


        log.info("getId {}",provider.getId());
        log.info("getStatus {}", provider.getStatus());
         providerRepository.changeProviderStatus(provider.getId(), provider.getStatus());
    }


    public ProviderResponse addProvider(ProviderRequest request) {
        try {
            long providerContentId=translationRepository.getNextValTranslationSequence();
            long providerStatusContentId=translationRepository.getNextValTranslationSequence();

            long providerId=providerRepository.createProvider(
                    request.getProvider().getGroupKey(),
                    request.getProvider().getPriority(),
                    providerContentId,
                    providerContentId,
                    request.getProvider().getStatus().getCode(),
                    request.getProvider().getFindText(),
                    providerStatusContentId,
                    request.getProvider().getProviderChannel().getAnother(),
                    request.getProvider().getProviderChannel().getAtm(),
                    request.getProvider().getProviderChannel().getKassa(),
                    request.getProvider().getProviderChannel().getMobileBanking(),
                    request.getProvider().getProviderLimit().getKeyLimitAmount(),
                    request.getProvider().getProviderLimit().getKeyLimitValue(),
                    request.getProvider().getProviderLimit().getMaxAmount(),
                    request.getProvider().getProviderLimit().getMinAmount(),
                    request.getProvider().getProviderSkill().getAbp(),
                    request.getProvider().getProviderSkill().getAutoPay(),
                    request.getProvider().getProviderSkill().getFavorites(),
                    request.getProvider().getProviderSkill().getPattern(),
                    request.getProvider().getProviderSkill().getPush()
            );

            for (int i = 0; i <request.getProvider().getTranslation().size() ; i++) {
                request.getProvider().getTranslation().get(i).setContentId(providerContentId);
            }
            request.getProvider().getProviderStatus().setDescriptionContentId(providerStatusContentId);
            for (int s = 0; s <request.getProvider().getProviderStatus().getTranslation().size() ; s++) {
                request.getProvider().getProviderStatus().getTranslation().get(s).setContentId(providerStatusContentId);

            }

            //TODO learn Transactional annotations and use simple insert


            if (providerId>0){

                request.getProvider().getCategoryBuffers().iterator().next().setProviderId(providerId);
                log.info("CategoryBuffers providerId {}",  request.getProvider().getCategoryBuffers().iterator().next().getProviderId());
                categoryBufferRepository.saveAll(request.getProvider().getCategoryBuffers());
                request.getProvider().getRegionBuffers().iterator().next().setProviderId(providerId);
                log.info("RegionBuffers providerId {}",  request.getProvider().getRegionBuffers().iterator().next().getProviderId());

                request.getProvider().getProviderAccount().setId(providerId);
                providerAccountRepository.save(request.getProvider().getProviderAccount());

                request.getProvider().getProviderRequisites().iterator().next().setProviderId(providerId);
                providerRequisiteRepository.saveAll(request.getProvider().getProviderRequisites());

                regionBufferRepository.saveAll(request.getProvider().getRegionBuffers());
                translationRepository.saveAll(request.getProvider().getTranslation());
                translationRepository.saveAll(request.getProvider().getProviderStatus().getTranslation());
            }
            return new ProviderResponse(null,0, providerId);
        }catch (Exception ex){
            log.error("Method addProvider {}",ex);
            return new ProviderResponse(ex.getMessage(), -1,null);
        }
    }

    public void deleteProvider(Provider provider){

        translationRepository.deleteProviderSingleAndGroupName(provider.getId());
        translationRepository.deleteProviderStatusName(provider.getId());
        providerRepository.deleteProvider(provider.getId());
    }

}
