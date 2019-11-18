package daykin.rob.dndapi.repository;

import daykin.rob.dndapi.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {

    List<Skill> findByNameIn(String[] nameIn);

}
