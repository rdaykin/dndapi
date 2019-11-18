package daykin.rob.dndapi.service;

import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;

    public SkillService(@Autowired SkillRepository skillRepository){
        this.skillRepository = skillRepository;
    }

    public List<Skill> getSkills(String[] skills){
        return skillRepository.findByNameIn(skills);
    }

    public List<Skill> getSkills(){
        return (List) skillRepository.findAll();
    }

    public void addSkill(String name, String governingStat){
        Skill skill = Skill.builder().name(name).governingStat(governingStat).build();
        addSkill(skill);
    }

    public void addSkill(Skill skill){
        skillRepository.save(skill);
    }

}
