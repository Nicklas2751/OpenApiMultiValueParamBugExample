package eu.wiegandt.OpenApiMultiValueParamBugExample.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.wiegandt.OpenApiMultiValueParamBugExample.UserService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
        (controllers = {UsersApi.class, UsersApiDelegate.class,
                UsersApiImpl.class, UsersApiController.class})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserApiImplTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UserService userService;


        @Test
        void getUsersFiltered_get_correct_filters() throws Exception {
            //GIVEN
            when(userService.getUsersFiltered(any())).thenReturn(Collections.emptyList());

            //WHEN
            mockMvc.perform(get("/users")
                            .param("firstName", "Alice")
                            .param("lastName", "Smith")
                            .param("lastName", "Jones")
                    )
                    .andExpect(status().isOk())
                    .andExpect(content().json("[]"));

            //THEN
            verify(userService).getUsersFiltered(Map.of("firstName", List.of("Alice"), "lastName", List.of("Smith", "Jones")));
        }
}