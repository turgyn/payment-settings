package kz.bank.modify;

import kz.bank.entity.*;
import kz.bank.interfaces.CreateProvider;
import kz.bank.repositories.*;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 30.05.2022
 */



@Service
@NoArgsConstructor
public class ModifyProvider  implements CreateProvider {



    private StatusRepository statusRepository;
    private ChannelRepository channelRepository;
    private LimitRepository limitRepository;
    private SkillsRepository skillsRepository;




    @Override
    public Long addStatus(ProviderStatus providerStatus) {
        return statusRepository.save(providerStatus).getDescriptionContentId();
    }

    @Override
    public Long addChannel(ProviderChannel providerChannel) {
        return channelRepository.save(providerChannel).getId();
    }

    @Override
    public Long addLimit(ProviderLimit providerLimit) {
        return limitRepository.save(providerLimit).getId();
    }

    @Override
    public Long addSkill(ProviderSkill providerSkill) {
        return skillsRepository.save(providerSkill).getId();
    }

    @Override
    public void addRegionBuffer() {

    }

    @Override
    public void addCategoryBuffer() {

    }
}
