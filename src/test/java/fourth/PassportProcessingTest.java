package fourth;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PassportProcessingTest {

    @Test
    public void should_return_amount_of_valid_passports() {
        assertEquals(215, PassportProcessing.validPassports("fourthDecember.txt"));
    }

    @Test
    public void should_return_amount_of_valid_passports_little() {
        assertEquals(2, PassportProcessing.validPassports("passportTest.txt"));
    }

    @Test
    public void should_return_amount_of_valid_passports_little_little() {
        assertEquals(11, PassportProcessing.validPassports("anothertest.txt"));
    }


}