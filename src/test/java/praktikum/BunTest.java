package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {
    Bun bun = new Bun("Краторная булка", 1250);
    @Test
    public void getName() {
        String expectedResult = "Краторная булка";
        assertEquals("Результат не совпадает", expectedResult, bun.getName());
    }
    @Test
    public void getPrice() {
        float expectedResult = 1250;
        assertEquals(expectedResult, bun.getPrice(), 0);
    }
}