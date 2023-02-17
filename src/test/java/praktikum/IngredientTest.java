package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {
    private final String name = "Кристаллы марсианских альфа-сахаридов";
    private final float price = 750F;
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, price);
    @Test
    public void getPrice() {
        assertEquals("Результат не совпадает", price, ingredient.getPrice(), 0);
    }
    @Test
    public void getName() {
        assertEquals("Результат не совпадает", name, ingredient.getName());
    }
    @Test
    public void getType() {
        assertEquals("Результат не совпадает", IngredientType.FILLING, ingredient.getType());
    }
}
