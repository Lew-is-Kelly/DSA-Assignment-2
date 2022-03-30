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

        compDijk = new CompetitionDijkstra("input-A.txt", 50, 50, 50);
        assertEquals("Didn't return 3000 for A", 3000, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-B.txt", 50, 50, 50);
        assertEquals("Didn't return 5000 for B", 5000, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-C.txt", 50, 50, 50);
        assertEquals("Didn't return 4000 for C", 4000, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-D.txt", 50, 50, 50);
        assertEquals("Didn't return 19 for D", 19, compDijk.timeRequiredforCompetition());

//        compDijk = new CompetitionDijkstra("input-E.txt", 50, 50, 50);
//        assertEquals("Didn't return x for E", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-F.txt", 50, 50, 50);
        assertEquals("Didn't return 1832 for F", 1832, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-G.txt", 50, 50, 50);
        assertEquals("Didn't return 2000 for G", 2000, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-H.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for H", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-I.txt", 50, 50, 50);
        assertEquals("Didn't return 180 for I", 180, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-J.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for no path", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-K.txt", 50, 50, 50);
        assertEquals("Didn't return 160 for K", 160, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-L.txt", 50, 50, 50);
        assertEquals("Didn't return 320 for L", 320, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-M.txt", 50, 50, 50);
        assertEquals("Didn't return 1460 for M", 1460, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-N.txt", 50, 50, 50);
        assertEquals("Didn't return 980 for N", 980, compDijk.timeRequiredforCompetition());

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