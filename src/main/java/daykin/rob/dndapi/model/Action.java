package daykin.rob.dndapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class Action {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

}
