package eu.wiegandt.OpenApiMultiValueParamBugExample;

import eu.wiegandt.OpenApiMultiValueParamBugExample.model.User;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public List<User> getUsersFiltered(Map<String, List<String>> filters) {
        return Collections.emptyList();
    }
}
