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

        compDijk = new CompetitionDijkstra(tiny, 50, 50, 50);
        assertEquals("Valid", 38, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(tiny, 49, 50, 50);
        assertEquals("Slow", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 49, 50);
        assertEquals("Slow", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 50, 49);
        assertEquals("Slow", -1, compDijk.timeRequiredforCompetition());

        compDijk = new CompetitionDijkstra(tiny, 101, 50, 50);
        assertEquals("Fast", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 101, 50);
        assertEquals("Fast", -1, compDijk.timeRequiredforCompetition());
        compDijk = new CompetitionDijkstra(tiny, 50, 50, 101);
        assertEquals("Fast", -1, compDijk.timeRequiredforCompetition());
    }

    @Test
    public void testFWConstructor()
    {
        CompetitionFloydWarshall compFW = new CompetitionFloydWarshall("", 50, 50, 50);
        assertEquals("Didn't return -1 for null file name", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(empty, 50, 50, 50);
        assertEquals("Invalid", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 50);
        assertEquals("Valid", 38, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 49, 50, 50);
        assertEquals("Slow", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 49, 50);
        assertEquals("Slow", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 49);
        assertEquals("Slow", -1, compFW.timeRequiredforCompetition());

        compFW = new CompetitionFloydWarshall(tiny, 101, 50, 50);
        assertEquals("Fast", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 101, 50);
        assertEquals("Fast", -1, compFW.timeRequiredforCompetition());
        compFW = new CompetitionFloydWarshall(tiny, 50, 50, 101);
        assertEquals("Fast", -1, compFW.timeRequiredforCompetition());
    }
}