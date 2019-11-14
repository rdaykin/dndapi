package daykin.rob.dndapi.service;


import daykin.rob.dndapi.model.Character;
import daykin.rob.dndapi.model.Skill;
import daykin.rob.dndapi.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CharacterServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @Mock
    SkillService skillService;

    CharacterService characterService;

    Character jason;

    String[] skillsString = new String[]{"Acrobatics","History"};

    Skill acrobatics = Skill.builder().name("Acrobatics").governingStat("Dexterity").build();
    Skill history = Skill.builder().name("History").governingStat("Intelligence").build();

    List skillsList = new ArrayList<Skill>();

    @BeforeEach
    public void setup(){
        skillsList.add(acrobatics);
        skillsList.add(history);
        MockitoAnnotations.initMocks(this);
        characterService = new CharacterService(characterRepository, skillService);
        jason = Character.builder().strength(1).dexterity(2).constitution(3).intelligence(4).wisdom(5).charisma(6).hitpoints(7).name("Jason").speed(8).proficiencyBonus(9).skills(new HashSet<>()).build();
        when(characterRepository.findOneByName("Jason")).thenReturn(jason);
        when(skillService.getSkills(skillsString)).thenReturn(skillsList);
    }

    @Test
    public void testCreateCharacterSendsCorrectCharacterToRepo(){
        characterService.createCharacter("Jason", 1, 2, 3, 4, 5, 6, 7, 8, 9);
        verify(characterRepository).save(eq(jason));
    }

    @Test
    public void testGetCharacterasJsonReturnsCorrectJson(){
        characterService.createCharacter("Jason", 1, 2, 3, 4, 5, 6, 7, 8, 9);
        String jasonJson =  characterService.getCharacterAsJson("Jason");
        assertEquals(jasonJson, "{\"name\":\"Jason\",\"strength\":1,\"dexterity\":2,\"constitution\":3,\"intelligence\":4,\"wisdom\":5,\"charisma\":6,\"hitpoints\":7,\"speed\":8,\"proficiencyBonus\":9,\"skills\":[]}");
    }

    @Test
    public void testAllocateSkillsToCharacterAllocatesCorrectSkills(){
        characterService.allocateSkillsToCharacter("Jason", skillsString);
        assert(jason.getSkills().equals(new HashSet<>(skillsList)));
    }

}
