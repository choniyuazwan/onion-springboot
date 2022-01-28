package id.choniyuazwan.onion.infrastructure.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.choniyuazwan.onion.infrastructure.rest.DTO.PasswordDTO;
import id.choniyuazwan.onion.service.PasswordManager;
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
@WebMvcTest(PasswordRest.class)
public class PasswordRestTest {
  private static final String PATH = "/passwords";

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper mapper;

  @MockBean
  private PasswordManager passwordManager;

  @Test
  public void changePassword() throws Exception {
    PasswordDTO passwordDTO = new PasswordDTO("aa", "aa", "aa");

    Mockito.when(passwordManager.changePassword(passwordDTO.getUsername(), passwordDTO.getCurrentPassword(), passwordDTO.getNewPassword())).thenReturn(true);

    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(PATH)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(this.mapper.writeValueAsString(passwordDTO));

    mockMvc.perform(mockRequest)
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()))
        .andExpect(jsonPath("$", is("ok")));
  }
}
