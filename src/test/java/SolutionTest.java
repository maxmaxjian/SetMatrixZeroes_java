import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[][] input;
    private int[][] expected;
    private Solution soln = new Solution3();

    public SolutionTest(int[][] input, int[][] output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {
                    new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}},
                    new int[][]{
                            {1,0,1},
                            {0,0,0},
                            {1,0,1}}
                },
                {
                    new int[][]{
                        {0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}},
                        new int[][]{
                                {0,0,0,0},
                                {0,4,5,0},
                                {0,3,1,0}}
                },
                {
                    new int[][]{
                            {0,0,0,5},
                            {4,3,1,4},
                            {0,1,1,4},
                            {1,2,1,3},
                            {0,0,1,1}
                    },
                        new int[][]{
                                {0,0,0,0},
                                {0,0,0,4},
                                {0,0,0,0},
                                {0,0,0,3},
                                {0,0,0,0}
                        }
                },
                {
                    new int[][]{
                            {1,0,1,1},
                            {1,1,1,1},
                            {1,1,1,1}
                    },
                        new int[][]{
                                {0,0,0,0},
                                {1,0,1,1},
                                {1,0,1,1}
                        }
                }
        });
    }

    @Test
    public void testFunction() {
        soln.setZeroes(input);
        assert(checkEqual(expected, input));
    }

    private boolean checkEqual(int[][] expected, int[][] actual) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}