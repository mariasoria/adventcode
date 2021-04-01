package third;

import second.PasswordPhilosophy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


public class TobogganTrajectory {

    /*
    * With the toboggan login problems resolved, you set off toward the airport. While travel by toboggan might
    * be easy, it's certainly not safe: there's very minimal steering and the area is covered in trees. You'll need
    * to see which angles will take you near the fewest trees.

    Due to the local geology, trees in this area only grow on exact integer coordinates in a grid. You make a map
    * (your puzzle input) of the open squares (.) and trees (#) you can see. For example:

    ..##.......
    #...#...#..
    .#....#..#.
    ..#.#...#.#
    .#...##..#.
    ..#.##.....
    .#.#.#....#
    .#........#
    #.##...#...
    #...##....#
    .#..#...#.#
    These aren't the only trees, though; due to something you read about once involving arboreal genetics and
    * biome stability, the same pattern repeats to the right many times:

    ..##.........##.........##.........##.........##.........##.......  --->
    #...#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
    .#....#..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
    ..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
    .#...##..#..#...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
    ..#.##.......#.##.......#.##.......#.##.......#.##.......#.##.....  --->
    .#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
    .#........#.#........#.#........#.#........#.#........#.#........#
    #.##...#...#.##...#...#.##...#...#.##...#...#.##...#...#.##...#...
    #...##....##...##....##...##....##...##....##...##....##...##....#
    .#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
    You start on the open square (.) in the top-left corner and need to reach the bottom (below the bottom-most
    * row on your map).

    The toboggan can only follow a few specific slopes (you opted for a cheaper model that prefers rational numbers)
    * start by counting all the trees you would encounter for the slope right 3, down 1:

    From your starting position at the top-left, check the position that is right 3 and down 1. Then, check the
    * position that is right 3 and down 1 from there, and so on until you go past the bottom of the map.

    The locations you'd check in the above example are marked here with O where there was an open square and X
    * where there was a tree:

    ..##.........##.........##.........##.........##.........##.......  --->
    #..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
    .#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
    ..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
    .#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
    ..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##.....  --->
    .#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
    .#........#.#........X.#........#.#........#.#........#.#........#
    #.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
    #...##....##...##....##...#X....##...##....##...##....##...##....#
    .#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
    In this example, traversing the map using this slope would cause you to encounter 7 trees.

    Starting at the top-left corner of your map and following a slope of right 3 and down 1, how many trees
    * would you encounter?
    * */
    public static int tobogganTrajectory(String filename){
        InputStream is = PasswordPhilosophy.class.getClassLoader().getResourceAsStream(filename);

        int cont = 0;
        if (is == null) {
            throw new IllegalArgumentException("file not found: " + filename);
        } else {

            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                List<String> matrix = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    matrix.add(line);
                }
                int indexInLine = 0;
                for(int i = 0; i < matrix.size(); i++) {
                    boolean isATree = String.valueOf(matrix.get(i).charAt(indexInLine)).contains("#");
                    if(isATree) {
                        cont++;
                    }
                    indexInLine = indexInLine + 3;
                    boolean outOfBounds = indexInLine >= matrix.get(i).length();
                    if(outOfBounds) {
                        indexInLine = indexInLine - matrix.get(i).length();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return cont;
        }
    }

    /*
    Time to check the rest of the slopes - you need to minimize the probability of a sudden arboreal stop, after all.

    Determine the number of trees you would encounter if, for each of the following slopes, you start at the top-left
    corner and traverse the map all the way to the bottom:

    Right 1, down 1.
    Right 3, down 1. (This is the slope you already checked.)
    Right 5, down 1.
    Right 7, down 1.
    Right 1, down 2.
    In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively; multiplied together,
    these produce the answer 336.

    What do you get if you multiply together the number of trees encountered on each of the listed slopes?
     */
    public static double tobogganTrajectoryWithSlopes (String filename) {
        InputStream is = PasswordPhilosophy.class.getClassLoader().getResourceAsStream(filename);

        int cont = 0;
        if (is == null) {
            throw new IllegalArgumentException("file not found: " + filename);
        } else {
            double slopes = 1;
            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                List<String> matrix = new ArrayList<>();
                while ((line = reader.readLine()) != null) {
                    matrix.add(line);
                }
                cont = getTrees(matrix, 1, 1);
                slopes *= cont;
                cont = getTrees(matrix, 3, 1);
                slopes *= cont;
                cont = getTrees(matrix, 5, 1);
                slopes *= cont;
                cont = getTrees(matrix, 7, 1);
                slopes *= cont;
                cont = getTrees(matrix, 1, 2);
                slopes *= cont;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return slopes;
        }
    }

    private static int getTrees(List<String> matrix, int incrementH, int incrementV) {
        int indexInLine = 0;
        int cont = 0;
        for (int i = 0; i < matrix.size(); i = i + incrementV) {
            boolean isATree = String.valueOf(matrix.get(i).charAt(indexInLine)).contains("#");
            if (isATree) {
                cont++;
            }
            indexInLine += incrementH;
            boolean outOfBounds = indexInLine >= matrix.get(i).length();
            if (outOfBounds) {
                indexInLine = indexInLine - matrix.get(i).length();
            }
        }
        return cont;
    }

}
