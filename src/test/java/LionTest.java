import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;
    @Test
    public void checkHasManeException() {
        try {
            Lion lion = new Lion(feline, "Male");
            lion.doesHaveMane();
            Assert.fail("Передано некорректное значение. Исключение отсутствует");
        }
        catch (Exception exception) {
            String expectedTextException = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedTextException, exception.getMessage());
        }
    }
    @Test
    public void checkLionKittensCount() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(2);
        int actualLionKittensCount = lion.getKittens();
        int expectedLionKittensCount = 2;
        assertEquals(expectedLionKittensCount, actualLionKittensCount);
    }
    @Spy
    Feline felineNew;
    @Test
    public void checkLionFood() throws Exception {
        Lion lion = new Lion(felineNew, "Самец");
        List<String> actualLionFood = lion.getFood();
        Mockito.verify(felineNew).getFood("Хищник");
        List<String> expectedLionFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedLionFood, actualLionFood);
    }
}