import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests
{

    @Test
    public void testDijkstraConstructor()
    {
        CompetitionDijkstra compDijk = new CompetitionDijkstra(null, 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 1, 50, 50);
        assertEquals("Didn't return -1 for invalid speed", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 50, 50, 50);
        assertEquals("TinySlow didn't return 38", 38, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("tinyEWD.txt", 100, 100, 100);
        assertEquals("TinyFast didn't return 10", 19, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-A.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for A", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-B.txt", 60, 80, 50);
        assertEquals("Didn't return 10000 for B", 10000, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-C.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for C", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-D.txt", 50, 80, 60);
        assertEquals("Didn't return 19 for D", 38, compDijk.timeRequiredforCompetition());

//        compDijk = new CompetitionDijkstra("input-E.txt", 72, 70, 65);
//        assertEquals("Didn't return 22 for E", 22, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-F.txt", 50, 50, 50);
        assertEquals("Didn't return 1832 for F", -1, compDijk.timeRequiredforCompetition());

//        compDijk = new CompetitionDijkstra("input-G.txt", 50, 50, 50);
//        assertEquals("Didn't return 2000 for G", -1, compDijk.timeRequiredforCompetition());

//        compDijk = new CompetitionDijkstra("input-H.txt", 50, 50, 50);
//        assertEquals("Didn't return -1 for H", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-I.txt", 72, 70, 65);
        assertEquals("Didn't return 180 for I", 185, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-J.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for no path", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-K.txt", 51, 70, 88);
        assertEquals("Didn't return 160 for K", 314, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-L.txt", 50, 50, 50);
        assertEquals("Didn't return 160 for L", 160, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-M.txt", 50, 50, 50);
        assertEquals("Didn't return 300 for M", 300, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-N.txt", 50, 50, 50);
        assertEquals("Didn't return 160 for N", 160, compDijk.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor()
    {
        CompetitionFloydWarshall compFW = new CompetitionFloydWarshall(null, 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall("tinyEWD.txt", 1, 50, 50);
        assertEquals("Didn't return -1 for invalid speed", -1, compFW.timeRequiredforCompetition());

//        compFW = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, 50);
//        assertEquals("TinySlow didn't return 38", 38, compFW.timeRequiredforCompetition());

//        compFW = new CompetitionFloydWarshall("tinyEWD.txt", 100, 100, 100);
//        assertEquals("TinyFast didn't return 10", 19, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall("input-A.txt", 50, 50, 50);
        assertEquals("Didn't return -1 for A", -1, compFW.timeRequiredforCompetition());
//
        compFW = new CompetitionFloydWarshall("input-B.txt", 60, 80, 50);
        assertEquals("Didn't return 10000 for B", 10000, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-C.txt", 50, 50, 50);
//        assertEquals("Didn't return -1 for C", -1, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-D.txt", 50, 80, 60);
//        assertEquals("Didn't return 19 for D", 38, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-E.txt", 72, 70, 65);
//        assertEquals("Didn't return -1 for E", 22, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-F.txt", 50, 50, 50);
//        assertEquals("Didn't return 1832 for F", -1, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-G.txt", 50, 50, 50);
//        assertEquals("Didn't return 2000 for G", -1, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-H.txt", 50, 50, 50);
//        assertEquals("Didn't return -1 for H", -1, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-I.txt", 72, 70, 65);
//        assertEquals("Didn't return 180 for I", 185, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-J.txt", 50, 50, 50);
//        assertEquals("Didn't return -1 for no path", -1, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-K.txt", 51, 70, 88);
//        assertEquals("Didn't return 160 for K", 314, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-L.txt", 50, 50, 50);
//        assertEquals("Didn't return 320 for L", 320, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-M.txt", 50, 50, 50);
//        assertEquals("Didn't return 1460 for M", 1460, compFW.timeRequiredforCompetition());
//
//        compFW = new CompetitionFloydWarshall("input-N.txt", 50, 50, 50);
//        assertEquals("Didn't return 980 for N", 980, compFW.timeRequiredforCompetition());
    }

    //TODO - more tests

}