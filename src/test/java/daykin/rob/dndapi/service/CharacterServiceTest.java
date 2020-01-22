package daykin.rob.dndapi.service;


import com.fasterxml.jackson.core.JsonProcessingException;
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
        jason = Character.builder().strength(1).dexterity(2).constitution(3).intelligence(4).wisdom(5).charisma(6).hitpoints(7).name("Jason").speed("8ft").proficiencyBonus(9).challengeRating(5).armourClass(15).build();
        when(characterRepository.findOneByName("Jason")).thenReturn(jason);
        when(skillService.getSkills(skillsString)).thenReturn(skillsList);
    }

    @Test
    public void testCreateCharacterSendsCorrectCharacterToRepo(){
        characterService.createCharacter("Jason", 1, 2, 3, 4, 5, 6, 7, "8ft", 9, 15, 5);
        verify(characterRepository).save(eq(jason));
    }

    @Test
    public void testGetCharacterasJsonReturnsCorrectJson() throws JsonProcessingException {
        characterService.createCharacter("Jason", 1, 2, 3, 4, 5, 6, 7, "8ft", 9, 10, 20);
        String jasonJson =  characterService.getCharacterAsJson("Jason");
        assertEquals(jasonJson, "{\"id\":null,\"name\":\"Jason\",\"strength\":1,\"dexterity\":2,\"constitution\":3,\"intelligence\":4,\"wisdom\":5,\"charisma\":6,\"hitpoints\":7,\"proficiencyBonus\":9,\"armourClass\":15,\"challengeRating\":5,\"size\":null,\"type\":null,\"subtype\":null,\"alignment\":null,\"speed\":\"8ft\",\"senses\":null,\"vulnerabilities\":null,\"resistances\":null,\"immunities\":null,\"conditionImmunities\":null,\"languages\":null,\"athletics\":0,\"acrobatics\":0,\"sleightOfHand\":0,\"stealth\":0,\"history\":0,\"investigation\":0,\"nature\":0,\"religion\":0,\"animalHandling\":0,\"insight\":0,\"medicine\":0,\"perception\":0,\"survival\":0,\"deception\":0,\"intimidation\":0,\"performance\":0,\"persuasion\":0,\"strengthSave\":0,\"dexteritySave\":0,\"constitutionSave\":0,\"intelligenceSave\":0,\"wisdomSave\":0,\"charismaSave\":0,\"hitDice\":null,\"actions\":null,\"legendaryActions\":null,\"specialAbilities\":null,\"arcana\":0}");
    }

}
