package id.choniyuazwan.onion.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.choniyuazwan.onion.infrastructure.rest.DTO.UserDTO;
import id.choniyuazwan.onion.service.UserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRest.class)
public class UserRestTest {
  private static final String PATH = "/users";

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @MockBean
  private UserManager userManager;

  @Test
  public void addUser() throws Exception {
    UserDTO userDTO = new UserDTO("aa", "aa", "aa");

    Mockito.when(userManager.createUser(userDTO.getUsername(), userDTO.getFullname(), userDTO.getPassword())).thenReturn(true);

    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(this.mapper.writeValueAsString(userDTO));

    mockMvc.perform(mockRequest)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$", is("ok")));
  }
}
