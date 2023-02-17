package kz.bank.services;

import kz.bank.entity.ProviderSkill;
import kz.bank.repositories.SkillsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class SkillsService {


    private SkillsRepository skillsRepository;



    public void addSkills(ProviderSkill providerSkill){
        if (!skillsRepository.existsById(providerSkill.getId())){
            skillsRepository.save(providerSkill);
        }
    }

    public List<ProviderSkill> getProviderSkills() {

        return skillsRepository.findAll();
    }

    public void Delete(ProviderSkill providerSkill) {
        skillsRepository.delete(providerSkill);
    }

    public void Update(ProviderSkill providerSkill) {
        skillsRepository.save(providerSkill);
    }
}
