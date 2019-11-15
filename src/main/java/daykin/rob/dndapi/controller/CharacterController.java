package daykin.rob.dndapi.controller;


import daykin.rob.dndapi.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @RequestMapping("/character/{name}")
    public String getCharacter(@PathVariable("name") String name){
        return characterService.getCharacterAsJson(name);
    }

    @RequestMapping("/newcharacter/{name}")
    public void createCharacter(@PathVariable("name") String name,
                                @RequestParam(name= "strength") int strength,
                                @RequestParam(name= "dexterity") int dexterity,
                                @RequestParam(name= "constitution") int constitution,
                                @RequestParam(name= "intelligence") int intelligence,
                                @RequestParam(name= "wisdom") int wisdom,
                                @RequestParam(name= "charisma") int charisma,
                                @RequestParam(name="hitpoints") int hitpoints,
                                @RequestParam(name="speed") int speed){
        characterService.createCharacter(name, strength, dexterity, constitution, intelligence, wisdom, charisma, hitpoints, speed, 0, 0, 0, 0, 0, 0);
    }

    @RequestMapping("/character/{name}/setskills/{skills}")
    public void addSkillsToCharacter(@PathVariable("name") String name, @PathVariable("skills") String skills){
        characterService.allocateSkillsToCharacter(name, skills.split(","));
    }

}
