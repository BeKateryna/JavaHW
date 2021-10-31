package Family.HW7;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class HumanTest {
    @Test
    public void should__return__correct__age() {
        Human human = new Woman("Mimi", "Ivanovich", 1988);
        int result = human.getYear();
        int expected = 1988;
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void should__return__exact__greeting () {
        Human human = new Woman("Sveta", "Ivanovich", 1990);
        String result = "Human{name='Sveta', surname='Ivanovich', year=1990, iq=0, schedule=null}";
        Assertions.assertTrue(result.equals(human.toString()));
    }
}