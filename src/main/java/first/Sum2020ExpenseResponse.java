package first;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum2020ExpenseResponse {

    /*
    *
    * After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.
    The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to
    have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room.
    To save your vacation, you need to get all fifty stars by December 25th.
    Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!
    Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.
    Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

    For example, suppose your expense report contained the following:
    1721
    979
    366
    299
    675
    1456
    In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

    Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?
    * */
    public static int sum2020TwoNumbers(int[] expenses){
        int total = 0;
        for(int i = 0; i < expenses.length;i++) {
            for(int j = 0; j < expenses.length; j++) {
                if(expenses[i]+expenses[j] == 2020) {
                    total = expenses[i] * expenses[j];
                    System.out.println("The result of " + expenses[i] + " times " + expenses[j] + " is: ");
                    System.out.println(total);
                    return total;
                }
            }
        }
        return total;
    }

    /*
    * The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They
    offer you a second one if you can find three numbers in your expense report that meet the same criteria.
    Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.
    In your expense report, what is the product of the three entries that sum to 2020?
    *
    * */
    public static int sum2020ThreeNumbers(int[] expenses){

        ArrayList<Integer> listSortedElements = new ArrayList();
        Arrays.stream(expenses).sorted().forEach(elem -> listSortedElements.add(elem));

        int second;
        int third;
        int total;
        for(int i = 0; i < listSortedElements.size() - 1; i++){
            second = i+1;
            third = listSortedElements.size() - 1;
            while(second < third) {
                int sum = listSortedElements.get(i)+listSortedElements.get(second)+listSortedElements.get(third);
                if( sum == 2020) {
                    total = listSortedElements.get(i) * listSortedElements.get(second) * listSortedElements.get(third);
                    System.out.println("this is the total: " + total);
                    return total;
                } else if (sum < 2020) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        return 0;
    }
}
