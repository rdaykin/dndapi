package daykin.rob.dndapi.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired
    GsonBuilder gsonBuilder;

    @RequestMapping("/skill")
    public void createSkill(@RequestParam("name") String name, @RequestParam("stat") String governingStat){
        skillService.addSkill(name, governingStat);
    }

    @RequestMapping("/skills")
    public String displaySkills(){
        Gson gson = new Gson();
        List<Skill> skills = skillService.getSkills();
        return gson.toJson(skills);
    }

}
