package third;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TobogganTrajectoryTest {

    @Test
    public void should_say_how_many_trees_in_the_toboggan_trajectory() {
        assertEquals(286, TobogganTrajectory.tobogganTrajectory("thirdDecember.txt"));
    }

    @Test
    public void should_say_how_many_trees_in_the_toboggan_trajectory_with_slopes() {
        assertEquals(3.6386064E9, TobogganTrajectory.tobogganTrajectoryWithSlopes("thirdDecember.txt"), 0);
    }
}