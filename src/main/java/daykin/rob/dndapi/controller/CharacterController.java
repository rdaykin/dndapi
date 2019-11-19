package daykin.rob.dndapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import daykin.rob.dndapi.service.CharacterService;
import daykin.rob.dndapi.model.Character;
import daykin.rob.dndapi.service.MonsterProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @Autowired
    MonsterProductionService monsterProductionService;

    @GetMapping("/character/{name}")
    public String getCharacter(@PathVariable("name") String name) throws JsonProcessingException {
        return characterService.getCharacterAsJson(name);
    }

    @PostMapping("/character")
    public void createCharacter(@RequestBody Character character){
        characterService.saveCharacter(character);
    }

    @PostMapping("/character/{name}/setskills/{skills}")
    public void addSkillsToCharacter(@PathVariable("name") String name, @PathVariable("skills") String skills){
        characterService.allocateSkillsToCharacter(name, skills.split(","));
    }

    @PostMapping("/monstermash")
    public void fillTheZoo() throws IOException, URISyntaxException {
        List<Character> monsterManual = new LinkedList<>();
        for(int i=1; i <= 325; i++){
            Character monster = MonsterProductionService.readCharacterFromApi(i);
            monsterManual.add(monster);
            characterService.saveCharacter(monster);
        }
    }


}
