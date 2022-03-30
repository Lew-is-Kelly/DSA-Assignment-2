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
 *     The city is a ylection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 *
 * @author Lewis Kelly 20335015
 */

import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;

public class CompetitionDijkstra
{
    double[][] graph;
    private final int speedOfA;
    private final int speedOfB;
    private final int speedOfC;
    private final String fileName;
    private int numOfVert;
    private int numOfEdge;
    List<Integer> speeds = new ArrayList<>();
    double[][] distances;


    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
    CompetitionDijkstra(String filename, int sA, int sB, int sC)
    {
        this.fileName = filename;
        this.speedOfA = sA;
        this.speedOfB = sB;
        this.speedOfC = sC;

        try
        {
            if (fileName == null)
            {
                return;
            }

            File file = new File(fileName);
            Scanner input = new Scanner(file);
            int line = 0;
            numOfVert = 0;
            numOfEdge = 0;
            while (input.hasNextInt())
            {
                if (line == 0)
                {
                    numOfVert = input.nextInt();
                    graph = new double[numOfVert][numOfVert];
                    for (int i = 0; i < numOfVert; i++)
                        for (int j = 0; j < numOfVert; j++)
                            graph[i][j] = -2;
                    line++;
                } else if (line == 1)
                {
                    this.numOfEdge = input.nextInt();
                    line++;
                } else
                {
                    if (numOfVert > 0)
                    {
                        for (int i = 0; i < this.numOfEdge; i++)
                        {
                            int v1 = input.nextInt();
                            int v2 = input.nextInt();
                            double weight = input.nextDouble();
                            graph[v1][v2] = weight;
                        }
                    }
                }
            }
            input.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    int timeRequiredforCompetition()
    {
        if (getMinDis() == -1 || fileName == null)
        {
            return -1;
        }
        if (speedOfA < 50 || speedOfA > 100 ||
                speedOfB < 50 || speedOfB > 100 ||
                speedOfC < 50 || speedOfC > 100 ||
                numOfVert <= 2)
        {
            return -1;
        }
        int total;
        double longestDist = Double.MIN_VALUE;

        for (double[] distRow : distances)
        {
            for (double val : distRow)
            {
                if (val > longestDist)
                {
                    longestDist = val;
                }
            }
        }

        speeds.add(speedOfA);
        speeds.add(speedOfB);
        speeds.add(speedOfC);
        int slowestSpeed = Collections.min(speeds);

        longestDist *= 1000;

        total = (int) Math.ceil(longestDist / slowestSpeed);

        return total;
    }

    int getMinVert(double[] mst, LinkedList<Integer> keyPath)
    {
        double min = Double.MAX_VALUE;
        int mindex = -1;
        for (int i = 0; i < numOfVert; i++)
        {
            if (mst[i] < min && !keyPath.contains(i))
            {
                min = mst[i];
                mindex = i;
            }
        }
        return mindex;
    }

    public int getMinDis()
    {
        distances = new double[numOfVert][numOfVert];

        for (int x = 0; x < distances.length; x++)
        {
            for (int y = 0; y < distances[x].length; y++)
            {
                if (x != y)
                {
                    distances[x][y] = Double.MAX_VALUE;
                } else
                {
                    distances[x][y] = 0;
                }
            }
        }

        LinkedList<Integer> vertPath = new LinkedList<>();

        for (int i = 0; i < numOfVert; i++)
        {
            vertPath.clear();

            while (vertPath.size() != numOfVert)
            {
                int vert_U = getMinVert(distances[i], vertPath);
                vertPath.add(vert_U);

                for (int vert_V = 0; vert_V < numOfVert; vert_V++)
                {
                    if (vert_U != -1)
                    {
                        if (graph[vert_U][vert_V] != -2)
                        {
                            if (distances[i][vert_V] > graph[vert_U][vert_V] + distances[i][vert_U])
                            {
                                distances[i][vert_V] = graph[vert_U][vert_V] + distances[i][vert_U];
                            }
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
}
