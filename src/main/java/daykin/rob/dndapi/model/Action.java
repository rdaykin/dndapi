package daykin.rob.dndapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Action {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @JsonAlias("desc")
    @Column(length = 2047)
    private String description;
    private int damage_bonus;
    private int attack_bonus;
    private String damage_dice;
}
