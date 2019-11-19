package daykin.rob.dndapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    @Id
    @JsonAlias("_id")
    String id;
    @Column(unique = true, length = 2047)
    String name;
    int strength;
    int dexterity;
    int constitution;
    int intelligence;
    int wisdom;
    int charisma;
    @JsonAlias("hit_points")
    int hitpoints;
    int proficiencyBonus;
    @JsonAlias("armor_class")
    int armourClass;
    @JsonAlias("challenge_rating")
    int challengeRating;
    String size;
    String type;
    String subtype;
    String alignment;
    String speed;
    @Column(length = 2047)
    String senses;

    @JsonAlias("damage_vulnerabilities")
    @Column(length = 2047)
    String vulnerabilities;

    @JsonAlias("damage_resistances")
    @Column(length = 2047)
    String resistances;

    @JsonAlias("damage_immunities")
    @Column(length = 2047)
    String immunities;

    @JsonAlias("condition_immunities")
    @Column(length = 2047)
    String conditionImmunities;

    @Column(length = 2047)
    String languages;
    int athletics;
    int acrobatics;
    @JsonAlias("sleight_of_hand")
    int sleightOfHand;
    int stealth;
    int Arcana;
    int history;
    int investigation;
    int nature;
    int religion;
    @JsonAlias("animal_handling")
    int animalHandling;
    int insight;
    int medicine;
    int perception;
    int survival;
    int deception;
    int intimidation;
    int performance;
    int persuasion;

    @JsonAlias("strength_save")
    int strengthSave;
    @JsonAlias("dexterity_save")
    int dexteritySave;
    @JsonAlias("constitution_save")
    int constitutionSave;
    @JsonAlias("intelligence_save")
    int intelligenceSave;
    @JsonAlias("wisdom_save")
    int wisdomSave;
    @JsonAlias("charisma_save")
    int charismaSave;
    @JsonAlias("hit_dice")
    String hitDice;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "character_id")
    Set<Action> actions;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "character_id")
    Set<SpecialAbility> legendaryActions;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "character_id")
    Set<SpecialAbility> specialAbilities;

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
