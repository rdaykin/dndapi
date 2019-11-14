package daykin.rob.dndapi.service;

import daykin.rob.dndapi.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Autowired
    ActionRepository actionRepository;

}
