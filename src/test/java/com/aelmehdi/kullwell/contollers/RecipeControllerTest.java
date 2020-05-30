package com.aelmehdi.kullwell.contollers;

import com.aelmehdi.kullwell.models.Recipe;
import com.aelmehdi.kullwell.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    private RecipeController recipeController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeRepository recipeRepository;

    @Test
    void should_create_controller_recipe_bean() {
        assertThat(recipeController).isNotNull();
    }

    @Test
    void should_return_recipes() throws Exception {
        when(recipeRepository.findAll())
                .thenReturn(asList(new Recipe(1L, "Fish Tagine", "Fish, Tomato, Onion, Potato")));

        mockMvc.perform(get("/api/recipes").contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("[{\"name\":\"Fish Tagine\", \"ingredients\":\"Fish, Tomato, Onion, Potato\"}]",
                                true));
    }
}