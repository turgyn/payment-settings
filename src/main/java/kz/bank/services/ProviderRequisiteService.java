package kz.bank.services;

import kz.bank.entity.ProviderRequisite;
import kz.bank.repositories.ProviderRequisiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ProviderRequisiteService {

    private ProviderRequisiteRepository providerRequisiteRepository;


    public List<ProviderRequisite> getRequisites(long providerId) {
        return providerRequisiteRepository.findByProviderId(providerId);
    }


    public List<ProviderRequisite> changeRequisite(List<ProviderRequisite> providerRequisites) {
        return  providerRequisiteRepository.saveAll(providerRequisites);
    }


}
