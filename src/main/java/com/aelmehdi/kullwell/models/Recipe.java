package com.aelmehdi.kullwell.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "recipe")
public class Recipe {
    @Id
    private Long id;

    private String name;
    private String ingredients;

    public Recipe() {
    }

    public Recipe(Long id, String name, String ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + ingredients + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(id, recipe.id) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ingredients);
    }
}
