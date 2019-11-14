package daykin.rob.dndapi.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    GsonBuilder builder = new GsonBuilder();

    public CharacterService(@Autowired CharacterRepository characterRepository, @Autowired SkillService skillService){
        this.characterRepository = characterRepository;
        this.skillService = skillService;
    }

    public CharacterService(){

    }

    public String getCharacterAsJson(String name){
        Gson gson = builder.create();
        Character character = characterRepository.findOneByName(name);
        return gson.toJson(character);
    }

    public void createCharacter(String name, int str, int dex, int con, int intel, int wis, int cha, int hp, int speed, int prof) {
        Character character = buildCharacter(name, str, dex, con, intel, wis, cha, hp, speed, prof);
        characterRepository.save(character);
    }

    Character buildCharacter(String name, int str, int dex, int con, int intel, int wis, int cha, int hp, int speed, int prof){
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
                .skills(new HashSet<>())
                .build();
    }

    public void allocateSkillsToCharacter(String name, List<Skill> skills){
        Character character = characterRepository.findOneByName(name);
        character.getSkills().addAll(skills);
        characterRepository.save(character);
    }

    public void allocateSkillsToCharacter(String name, String[] skills){
        List<Skill> realSkills = skillService.getSkills(skills);
        allocateSkillsToCharacter(name, realSkills);
    }
}
