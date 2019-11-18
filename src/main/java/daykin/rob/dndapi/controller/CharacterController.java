package daykin.rob.dndapi.controller;


import daykin.rob.dndapi.service.CharacterService;
import daykin.rob.dndapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/character/{name}")
    public String getCharacter(@PathVariable("name") String name){
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

}
