package daykin.rob.dndapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@Table(name="characters")
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue
    Integer id;
    @Column(unique = true)
    String name;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    int hitpoints;
    int speed;
    int swimSpeed;
    int flySpeed;
    int proficiencyBonus;
    int armourClass;
    int legendaryResistanceCount;
    int challengeRating;
    String languages;
    String resistances;
    String immunities;
    String senses;

    @OneToMany
    @JoinColumn(name = "character_id")
    Set<Action> actions;

    @OneToMany
    @JoinTable(
            name="characterProficiencies",
            joinColumns = @JoinColumn(name="character_id"),
            inverseJoinColumns = @JoinColumn(name="proficiency")
    )
    Set<Skill> skills;

    @Override
    public boolean equals(Object object){
        if(object == null || object.getClass() != Character.class){
            return false;
        }
        Character character = (Character) object;
        return character.getStrength() == strength
                && character.getDexterity() == dexterity
                && character.getConstitution() == constitution
                && character.getIntelligence() == intelligence
                && character.getWisdom() == wisdom
                && character.getCharisma() == charisma
                && character.getHitpoints() == hitpoints
                && character.getSpeed() == speed
                && character.getProficiencyBonus() == proficiencyBonus;
    }
}
