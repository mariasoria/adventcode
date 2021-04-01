package second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class PasswordPhilosophy {

    /*
    * --- Day 2: Password Philosophy ---
    Your flight departs in a few days from the coastal airport; the easiest way down to the coast from here is via toboggan.

    The shopkeeper at the North Pole Toboggan Rental Shop is having a bad day. "Something's wrong with our computers; we can't
    * log in!" You ask if you can take a look.

    Their password database seems to be a little corrupted: some of the passwords wouldn't have been allowed by the Official
    * Toboggan Corporate Policy that was in effect when they were chosen.

    To try to debug the problem, they have created a list (your puzzle input) of passwords (according to the corrupted database)
    * and the corporate policy when that password was set.

    For example, suppose you have the following list:

    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc
    Each line gives the password policy and then the password. The password policy indicates the lowest and highest number
    * of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must
    * contain a at least 1 time and at most 3 times.

    In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but
    * needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of
    * their respective policies.

    How many passwords are valid according to their policies?
    * */
    public static int countValidPasswords(String filename) {
        InputStream is = PasswordPhilosophy.class.getClassLoader().getResourceAsStream(filename);
        int cont = 0;
        if (is == null) {
            throw new IllegalArgumentException("file not found: " + filename);
        } else {
            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineSplit = line.split(" ");
                    String[] range = lineSplit[0].split("-");
                    int min = Integer.valueOf(range[0]);
                    int max = Integer.valueOf(range[1]);
                    char letter = lineSplit[1].charAt(0);
                    String password = lineSplit[2];
                    cont = checkValidityOfPassword(cont, min, max, letter, password);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cont;
        }
    }

    private static int checkValidityOfPassword(int cont, int min, int max, char letter, String password) {
        int innerCont = 0;
        for (int i = 0; i < password.length(); i++) {
            if (letter == password.charAt(i)) {
                innerCont++;
            }
        }
        if(innerCont >= min && innerCont <= max){
            cont++;
        }
        return cont;
    }

    /*
    * --- Part Two ---
    While it appears you validated the passwords correctly, they don't seem to be what the Official
    * Toboggan Corporate Authentication System is expecting.

    The shopkeeper suddenly realizes that he just accidentally explained the password policy rules
    * from his old job at the sled rental place down the street! The Official Toboggan Corporate
    * Policy actually works a little differently.

    Each policy actually describes two positions in the password, where 1 means the first character,
    * 2 means the second character, and so on. (Be careful; Toboggan Corporate Policies have no concept
    * of "index zero"!) Exactly one of these positions must contain the given letter. Other occurrences
    * of the letter are irrelevant for the purposes of policy enforcement.

    Given the same example list from above:

    1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.

    How many passwords are valid according to the new interpretation of the policies?
     */
    public static int countValidPasswordLetterNotRepeated(String filename){
        InputStream is = PasswordPhilosophy.class.getClassLoader().getResourceAsStream(filename);

        int cont = 0;
        if (is == null) {
            throw new IllegalArgumentException("file not found: " + filename);
        } else {

            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] lineSplit = line.split(" ");
                    String[] pos = lineSplit[0].split("-");
                    int pos1 = Integer.valueOf(pos[0]);
                    int pos2 = Integer.valueOf(pos[1]);
                    char letter = lineSplit[1].charAt(0);
                    String password = lineSplit[2];

                    cont = addValidPasswordIfConditionsPassed(cont, pos1, pos2, letter, password);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cont;
        }
    }

    private static int addValidPasswordIfConditionsPassed(int cont, int pos1, int pos2, char letter, String password) {
        if(password.charAt(pos1 -1) == letter) {
            if(password.charAt(pos2 -1) != letter) {
                cont++;
            }
        } else if (password.charAt(pos2 -1) == letter) {
            cont++;
        }
        return cont;
    }

}
