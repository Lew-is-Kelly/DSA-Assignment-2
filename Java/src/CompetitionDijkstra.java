/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CompetitionDijkstra
{
    LinkedList<double[]> roads = new LinkedList<>();

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
    CompetitionDijkstra(String filename, int sA, int sB, int sC) throws IOException
    {
        BufferedReader buff = new BufferedReader(new FileReader("inputAssignment2/" + filename));

        String currLine;
        while ((currLine = buff.readLine()) != null)
        {
            String[] stringArray = currLine.split(" ");
            double[] ar = new double[stringArray.length];
            for (int i = 0; i <= stringArray.length - 1; i++)
            {
                ar[i] = parseDouble(stringArray[i]);
            }
            roads.add(ar);
        }
    }

    public void dijkstra()
    {
        System.out.println(roads);
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition()
    {
        for (int i = 0; i < roads.size(); i++)
        {
            dijkstra();
        }
        //TODO
        return -1;
    }

}
