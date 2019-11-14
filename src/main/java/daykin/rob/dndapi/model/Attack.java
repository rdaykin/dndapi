package daykin.rob.dndapi.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attack extends Action {

    int toHit;
    boolean melee;
    String range;
    int targets;
    String damage;
    String damage2;

}
