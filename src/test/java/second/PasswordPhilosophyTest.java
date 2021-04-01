package second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordPhilosophyTest {

    PasswordPhilosophy passwordPhilosophy = new PasswordPhilosophy();

    @Test
    public void should_count_valid_passwords(){
        assertEquals(524, passwordPhilosophy.countValidPasswords("secondDecember.txt"));
    }

    @Test
    public void should_count_valid_passwords_letters_not_repeated () {
        assertEquals(485, passwordPhilosophy.countValidPasswordLetterNotRepeated("secondDecember.txt"));
    }
}
