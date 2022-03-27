import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class CompetitionTests
{

    @Test
    public void testDijkstraConstructor() throws IOException
    {
        CompetitionDijkstra one = new CompetitionDijkstra("tinyEWD.txt", 1, 1, 1);
        one.printGraph();
        //TODO
    }

    @Test
    public void testFWConstructor()
    {
        //TODO
    }

    //TODO - more tests

}