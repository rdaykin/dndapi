package daykin.rob.dndapi.service;

import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.repository.SkillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class SkillServiceTest {

    SkillService skillService;

    @Mock
    SkillRepository skillRepository;

    Skill deception = Skill.builder().name("Deception").governingStat("Charisma").build();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        skillService = new SkillService(skillRepository);
    }

    @Test
    public void testAddSkillAddsSkill(){
        skillService.addSkill("Deception", "Charisma");
        verify(skillRepository, times(1)).save(eq(deception));
    }
}
