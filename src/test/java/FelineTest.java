import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Test
    public void checkFelineEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actualFelineFood = feline.eatMeat();
        List<String> expectedFelineFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFelineFood, actualFelineFood);
    }
    @Test
    public void checkFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, actualFamily);
    }
    @Spy
    private Feline feline;
    @Test
    public void checkFelineKittensCountWithParam() {
        feline.getKittens(7);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
    }
    @Test
    public void checkFelineKittensCountNoParam() {
        feline.getKittens();
        Mockito.verify(feline).getKittens();
    }
}
