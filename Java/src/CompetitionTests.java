import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests
{

    String tiny = "tinyEWD.txt";
    String empty = "empty.txt";

    @Test
    public void testDijkstraConstructor()
    {
        CompetitionDijkstra compDijk = new CompetitionDijkstra("", 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(empty, 50, 50, 50);
        assertEquals("Invalid", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra("input-A.txt", 50, 50, 50);
        assertEquals("No Path", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(tiny, 50, 50, 50);
        assertEquals("Valid", 38, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(tiny, 49, 50, 50);
        assertEquals("Slow A", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 49, 50);
        assertEquals("Slow B", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 50, 49);
        assertEquals("Slow C", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(tiny, 101, 50, 50);
        assertEquals("Fast A", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 101, 50);
        assertEquals("Fast B", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 50, 101);
        assertEquals("Fast C", -1, compDijk.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor()
    {
        CompetitionFloydWarshall compFW = new CompetitionFloydWarshall("", 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(empty, 50, 50, 50);
        assertEquals("Invalid", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall("input-A.txt", 50, 50, 50);
        assertEquals("No Path", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 50);
        assertEquals("Valid", 38, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 49, 50, 50);
        assertEquals("Slow A", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 49, 50);
        assertEquals("Slow B", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 49);
        assertEquals("Slow C", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 101, 50, 50);
        assertEquals("Fast A", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 101, 50);
        assertEquals("Fast B", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 101);
        assertEquals("Fast C", -1, compFW.timeRequiredforCompetition());
    }
}