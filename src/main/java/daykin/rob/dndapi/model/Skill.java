package daykin.rob.dndapi.model;

import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue
    private Integer id;
    private String governingStat;
    @Column(unique = true)
    private String name;

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != Skill.class){
            return false;
        }
        Skill skill = (Skill) o;
        return skill.getName().equals(name) && skill.getGoverningStat().equals(governingStat);
    }


}
