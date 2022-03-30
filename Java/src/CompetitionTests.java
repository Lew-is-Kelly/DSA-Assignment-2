import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests
{

    @Test
    public void testDijkstraConstructor() throws IOException
    {
        CompetitionDijkstra invalidTiny = new CompetitionDijkstra("tinyEWD.txt", 1, 2, 3);
        assertEquals("Didn't return -1", -1, invalidTiny.timeRequiredforCompetition()); // Test a -1 return

        CompetitionDijkstra tinySlow = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
        assertEquals("TinySlow didn't return 19", 19, tinySlow.timeRequiredforCompetition());

        CompetitionDijkstra tinyFast = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
        assertEquals("TinyFast didn't return 10", 10, tinyFast.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor()
    {
        //TODO
    }

    //TODO - more tests

}