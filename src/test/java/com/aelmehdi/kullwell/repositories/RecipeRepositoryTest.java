package com.aelmehdi.kullwell.repositories;

import com.aelmehdi.kullwell.models.Recipe;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class RecipeRepositoryTest {

    @Autowired
    RecipeRepository recipeRepository;

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

    @Test
    void should_save_a_recipe() {
        Recipe savedRecipe = recipeRepository.save(new Recipe(1L, "Fish Tagine",
                "fish, tomato, onion, potato, olive oil, salt, pepper, ginger"));

        assertThat(savedRecipe.getName()).isEqualTo("Fish Tagine");
    }

    @Test
    void should_get_recipe_by_id() {
        Recipe recipe = new Recipe(3L, "Bob", "Matt");

        recipeRepository.save(recipe);

        assertThat(recipeRepository.findById(3L).get()).isEqualTo(recipe);
    }
}
