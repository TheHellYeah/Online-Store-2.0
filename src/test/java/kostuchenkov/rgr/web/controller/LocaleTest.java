package kostuchenkov.rgr.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LocaleTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MainController mainController;

    @Test
    public void defaultLocale() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(content()
                        .string(containsString("Pages")));
    }

    @Test
    public void localeRU() throws Exception {
        this.mockMvc.perform(get("/?lang=ru"))
                .andExpect(content()
                        .string(containsString("Активировать")));
    }

    @Test
    public void localeEN() throws Exception {
        this.mockMvc.perform(get("/?lang=en"))
                .andExpect(content()
                        .string(containsString("Activate")));
    }
}
