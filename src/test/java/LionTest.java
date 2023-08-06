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
    @Test
    public void checkHasManeException() {
        try {
            Lion lion = new Lion("Male");
            lion.doesHaveMane();
            Assert.fail("Передано некорректное значение. Исключение отсутствует");
        }
        catch (Exception exception) {
            String expectedTextException = "Используйте допустимые значения пола животного - самец или самка";
            assertEquals(expectedTextException, exception.getMessage());
        }
    }
    @Mock
    Feline feline;
    @Test
    public void checkLionKittensCount() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        int actualLionKittensCount = lion.getKittens();
        int expectedLionKittensCount = 2;
        assertEquals(expectedLionKittensCount, actualLionKittensCount);
    }
    @Spy
    Feline feline2;
    @Test
    public void checkLionFood() throws Exception {
        Lion lion = new Lion(feline2);
        List<String> actualLionFood = lion.getFood();
        Mockito.verify(feline2).getFood("Хищник");
        List<String> expectedLionFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedLionFood, actualLionFood);
    }
}