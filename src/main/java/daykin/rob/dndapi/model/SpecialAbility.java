package daykin.rob.dndapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="special_abilities")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialAbility {

    @Id
    @GeneratedValue
    private Integer id;
    @JsonAlias("desc")
    @Column(length = 2047)
    private String description;
    private String name;
    private String character_id;
    private int damage_bonus;
    private int attack_bonus;
    private String damage_dice;

}
