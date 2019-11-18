package daykin.rob.dndapi.repository;

import daykin.rob.dndapi.model.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends CrudRepository<Action, Integer> {

    Action findOneByTitle(String title);

}
