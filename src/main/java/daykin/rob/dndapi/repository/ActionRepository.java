package daykin.rob.dndapi.repository;

import daykin.rob.dndapi.model.Action;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action, Integer> {

    Action findOneByTitle(String title);

}
