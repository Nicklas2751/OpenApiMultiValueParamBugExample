package eu.wiegandt.OpenApiMultiValueParamBugExample.api;

import eu.wiegandt.OpenApiMultiValueParamBugExample.UserService;
import eu.wiegandt.OpenApiMultiValueParamBugExample.model.User;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersApiImpl implements UsersApiDelegate{

    private final UserService userService;

    public UsersApiImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<List<User>> getUsersFiltered(Map<String, List<String>> filters) {
        return ResponseEntity.ok(userService.getUsersFiltered(filters));
    }
}
