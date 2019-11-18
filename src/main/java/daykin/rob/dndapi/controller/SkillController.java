package daykin.rob.dndapi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired
    GsonBuilder gsonBuilder;

    @RequestMapping("/skill")
    public void createSkill(@RequestBody Skill skill){
        skillService.addSkill(skill);
    }

    @RequestMapping("/skills")
    public String displaySkills(){
        Gson gson = new Gson();
        List<Skill> skills = skillService.getSkills();
        return gson.toJson(skills);
    }

}
