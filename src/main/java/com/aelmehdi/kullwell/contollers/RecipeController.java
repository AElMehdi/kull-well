package com.aelmehdi.kullwell.contollers;

import com.aelmehdi.kullwell.models.Recipe;
import com.aelmehdi.kullwell.repositories.RecipeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("recipes")
    public Iterable<Recipe> all(String ingredients) {
        return recipeRepository.findAll();
    }


}
