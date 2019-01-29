package Tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
@SuppressWarnings({"WeakerAccess","unused","unchecked"})

public class ListTests {
    @Test
    public void createIntegerList() {
        List<Boolean> expected = Arrays.asList(true, true, true, true, true, false, false, false);
        int from = 0;
        int until = 4;
        int size = 8;

        //List<Boolean> actual = dummy.createBooleanList(from, until, size);
        //Assert.assertEquals(expected, actual);
    }
}
