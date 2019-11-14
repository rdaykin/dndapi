package daykin.rob.dndapi.repository;

import daykin.rob.dndapi.model.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill, Integer> {

    List<Skill> findByNameIn(String[] nameIn);

}
