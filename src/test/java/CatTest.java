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
    Feline felineNew;
    @Test
    public void checkCatFood () throws Exception {
        Cat cat = new Cat(felineNew);
        List<String> actualCatFood = cat.getFood();
        Mockito.verify(felineNew).getFood("Хищник");
        List<String> expectedCatFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedCatFood, actualCatFood);
    }
}
