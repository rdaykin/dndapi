package daykin.rob.dndapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daykin.rob.dndapi.model.Character;
import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    SkillService skillService;

    ObjectMapper mapper = new ObjectMapper();
    public CharacterService(CharacterRepository characterRepository, SkillService skillService){
        this.characterRepository = characterRepository;
        this.skillService = skillService;
    }

    public CharacterService(){

    }

    public void saveCharacter(Character character){
        characterRepository.save(character);
    }

    public String getCharacterAsJson(String name) throws JsonProcessingException {
        Character character = characterRepository.findOneByName(name);
        return mapper.writeValueAsString(character);
    }

    public void createCharacter(String name, int str, int dex, int con, int intel, int wis, int cha, int hp, String speed, int prof,
            int armourClass,
            int challengeRating) {
        Character character = buildCharacter(name, str, dex, con, intel, wis, cha, hp, speed, prof, armourClass, challengeRating);
        characterRepository.save(character);
    }

    Character buildCharacter(String name, int str, int dex, int con, int intel, int wis, int cha, int hp, String speed, int prof,
                             int armourClass,
                             int challengeRating){
        return Character.builder()
                .name(name)
                .strength(str)
                .dexterity(dex)
                .constitution(con)
                .intelligence(intel)
                .wisdom(wis)
                .charisma(cha)
                .hitpoints(hp)
                .speed(speed)
                .proficiencyBonus(prof)
                .armourClass(armourClass)
                .challengeRating(challengeRating)
                .build();
    }

    public void allocateSkillsToCharacter(String name, List<Skill> skills){
        Character character = characterRepository.findOneByName(name);
        characterRepository.save(character);
    }

    public void allocateSkillsToCharacter(String name, String[] skills){
        List<Skill> realSkills = skillService.getSkills(skills);
        allocateSkillsToCharacter(name, realSkills);
    }
}
