import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Test
    public void checkSound() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        assertEquals(expectedSound, actualSound);
    }
    @Spy
    Feline feline2;
    @Test
    public void checkCatFood () throws Exception {
        Cat cat = new Cat(feline2);
        List<String> actualCatFood = cat.getFood();
        Mockito.verify(feline2).getFood("Хищник");
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedCatFood, actualCatFood);
    }
}
