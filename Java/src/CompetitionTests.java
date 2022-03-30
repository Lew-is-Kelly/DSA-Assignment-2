import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests
{

    @Test
    public void testDijkstraConstructor() throws IOException
    {
        CompetitionDijkstra compDijk = new CompetitionDijkstra(null, 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 1, 50, 50);
        assertEquals("Didn't return -1 for invalid speed", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-J.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for no path", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
        assertEquals("TinySlow didn't return 19", 19, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
        assertEquals("TinyFast didn't return 10", 10, compDijk.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor()
    {
        //TODO
    }

    //TODO - more tests

}