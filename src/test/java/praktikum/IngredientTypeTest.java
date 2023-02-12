package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters(name = "{index} - type: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void checkValueOf() {
        assertEquals("Результат не совпадает", type, IngredientType.valueOf(type).toString());
    }
}
