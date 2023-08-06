import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionHasManeParameterizedTest {
    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean hasManeExpected;
    @Parameterized.Parameters(name = "{0} имеет гриву: {1}")
    public static Object[][] params() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void checkHasMane() throws Exception {
        Lion lion = new Lion(sex);
        boolean hasManeActual = lion.doesHaveMane();
        assertEquals(hasManeExpected, hasManeActual);
    }
}