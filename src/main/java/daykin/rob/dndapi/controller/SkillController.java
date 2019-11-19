package daykin.rob.dndapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/skill")
    public void createSkill(@RequestBody Skill skill){
        skillService.addSkill(skill);
    }

    @RequestMapping("/skills")
    public String displaySkills() throws JsonProcessingException {
        List<Skill> skills = skillService.getSkills();
        return objectMapper.writeValueAsString(skills);
    }

}
