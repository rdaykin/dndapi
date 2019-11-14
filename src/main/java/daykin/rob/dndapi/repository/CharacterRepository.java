package daykin.rob.dndapi.repository;

import daykin.rob.dndapi.model.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {

    Character findOneByName(String name);

}
