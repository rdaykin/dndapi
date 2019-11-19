package daykin.rob.dndapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import daykin.rob.dndapi.model.Character;



@Service
public class MonsterProductionService {

    private static String apiRequest = "http://dnd5eapi.co/api/monsters/";

    public static Character readCharacterFromApi(int i) throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL apiUri = new URL(apiRequest + i);
        Character character = objectMapper.readValue(apiUri, Character.class);
        return character;
    }

}
