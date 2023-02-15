package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredientFilling;
    @Mock
    Ingredient ingredientSauce;
    @Before

    public void set() {
        when(bun.getPrice()).thenReturn(1000F);
        when(bun.getName()).thenReturn("Краторная булка");
        when(ingredientFilling.getPrice()).thenReturn(100F);
        when(ingredientFilling.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientFilling.getName()).thenReturn("Соус традиционный галактический");
        when(ingredientSauce.getPrice()).thenReturn(3000F);
        when(ingredientSauce.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientSauce.getName()).thenReturn("Говяжий метеорит (отбивная)");
    }
    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals("Результат не соответствует ожидаемому", bun, burger.bun);
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredientFilling);
        assertEquals("Результат не соответствует ожидаемому", 1, burger.ingredients.size());
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredientFilling);
        burger.removeIngredient(0);
        assertEquals("Результат не соответствует ожидаемому", 0, burger.ingredients.size());
    }
    @Test
    public void moveIngredient() {
        ingredientFilling = new Ingredient(IngredientType.FILLING, ingredientFilling.getName(), ingredientFilling.getPrice());
        ingredientSauce = new Ingredient(IngredientType.SAUCE, ingredientSauce.getName(), ingredientSauce.getPrice());
        List<Ingredient> expectedResult = List.of(ingredientSauce, ingredientFilling);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0, 1);
        List<Ingredient> actualResult = burger.ingredients;
        assertEquals("Результат не соответствует ожидаемому", expectedResult, actualResult);
    }
    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        float actualResult = burger.getPrice();
        assertEquals("Результат не соответствует ожидаемому", 2100F, actualResult, 0);
    }
    @Test
    public void getReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        String actualResult = burger.getReceipt();
        String expectedResult = String.format("(==== Краторная булка ====)%n" +
                "= sauce Соус традиционный галактический =%n" +
                "= filling Говяжий метеорит (отбивная) =%n" +
                "(==== Краторная булка ====)%n" +
                "%n" + "Price: 5100,000000%n");
        assertEquals("Результат не соответствует ожидаемому", expectedResult, actualResult);
    }
}