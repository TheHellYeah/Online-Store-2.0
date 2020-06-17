package kostuchenkov.rgr.web.controller;

import kostuchenkov.rgr.mocks.WithMockAdmin;
import kostuchenkov.rgr.model.domain.user.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AdminController adminController;

    @Test
    @WithMockAdmin
    public void accessGained() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Панель администратора")))
                .andExpect(content().string(containsString("admin")));
    }

    @Test
    @WithMockUser
    public void accessDenied() throws Exception {
        this.mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}