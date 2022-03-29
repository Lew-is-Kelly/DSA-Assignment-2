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
 *
 * @author Lewis Kelly 20335015
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class CompetitionDijkstra
{
    private final String fileName;
    private int numOfVert;
    private int numOfRoads;
    private final int speedOfA;
    private final int speedOfB;
    private final int speedOfC;
    double[][] roads;
    double[][] dist;
    List<Integer> shortest = new ArrayList<>();

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
    CompetitionDijkstra(String filename, int sA, int sB, int sC) throws IOException
    {
        fileName = filename;
        speedOfA = sA;
        speedOfB = sB;
        speedOfC = sC;

        if (filename == null)
        {
            return;
        }

        BufferedReader buff = new BufferedReader(new FileReader("inputAssignment2/" + fileName));
        numOfVert = parseInt(buff.readLine());
        numOfRoads = parseInt(buff.readLine());

        roads = new double[numOfVert][numOfVert];

        String currLine;
        while ((currLine = buff.readLine()) != null)
        {
            String[] lineArray = currLine.split(" ");
            int vert1 = parseInt(lineArray[0]);
            int vert2 = parseInt(lineArray[1]);
            roads[vert1][vert2] = parseDouble(lineArray[2]);
        }

        buff.close();
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition()
    {
        if (getMinDis() == -1
                || fileName == null
                || speedOfA < 50 || speedOfA > 100
                || speedOfB < 50 || speedOfB > 100
                || speedOfC < 50 || speedOfC > 100
                || numOfVert <= 0)
        {
            return -1;
        }

        int tot;
        double dist1 = Double.MAX_VALUE;

        for (double[] doubles : roads)
        {
            for (double val : doubles)
            {
                if (val > dist1)
                {
                    dist1 = val;
                }
            }
        }
        shortest.add(speedOfA);
        shortest.add(speedOfB);
        shortest.add(speedOfC);

        int longest = Collections.min(shortest);

        dist1 *= 1000;

        tot = (int) Math.ceil(dist1 / longest);

        return tot;
    }

    int getMinVert(double[] path, LinkedList<Integer> vertPath)
    {
        double min = Double.MAX_VALUE;
        int mindex = -1;
        for (int i = 0; i < numOfVert; i++)
            if (!vertPath.contains(i) && path[i] < min)
            {
                min = path[i];
                mindex = i;
            }
        return mindex;
    }

    int getMinDis()
    {
        dist = new double[numOfVert][numOfVert];

        for (int x = 0; x < dist.length; x++)
        {
            for (int y = 0; y < dist[x].length; y++)
            {
                if (x != y)
                {
                    dist[x][y] = Double.MAX_VALUE;
                } else
                {
                    dist[x][y] = 0;
                }
            }
        }

        LinkedList<Integer> vertPath = new LinkedList<>();

        for (int i = 0; i < numOfVert; i++)
        {
            vertPath.clear();

            while (vertPath.size() != numOfVert)
            {
                int vert = getMinVert(dist[i], vertPath);
                vertPath.add(vert);

                for (int j = 0; j < numOfVert; j++)
                {
                    if (vert != -1)
                    {
                        if (roads[vert][j] != -3)
                        {
                            if (dist[i][j] > roads[vert][j] + dist[i][vert])
                                dist[i][j] = roads[vert][j] + dist[i][vert];
                        }
                    } else
                    {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    void printRoads()
    {
        System.out.printf("%d, %d, %d, %d, %d\n", numOfVert, numOfRoads, speedOfA, speedOfB, speedOfC);
        for (int i = 0; i < numOfVert; i++)
        {
            for (int j = 0; j < numOfVert; j++)
            {
                if (roads[i][j] == 0)
                {
                    System.out.print("0 ");
                } else
                {
                    System.out.printf("%.2f ", roads[i][j]);
                }
            }
            System.out.println();
        }
    }
}
