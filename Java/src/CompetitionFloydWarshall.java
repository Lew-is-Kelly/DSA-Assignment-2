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
 * This class implements the competition using Floyd-Warshall algorithm
 *
 * @author Lewis Kelly
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CompetitionFloydWarshall
{
    double[][] graph;
    private final int speedOfA;
    private final int speedOfB;
    private final int speedOfC;
    private final String fileName;
    private int numOfVert;
    List<Integer> speeds = new ArrayList<>();

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,sB,sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall(String filename, int sA, int sB, int sC)
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
            int numOfEdge = 0;
            while (input.hasNextInt())
            {
                if (line == 0)
                {
                    numOfVert = input.nextInt();
                    graph = new double[numOfVert][numOfVert];
                    for (int i = 0; i < numOfVert; i++)
                        for (int j = 0; j < numOfVert; j++)
                            graph[i][j] = 0;
                    line++;
                } else if (line == 1)
                {
                    numOfEdge = input.nextInt();
                    line++;
                } else
                {
                    if (numOfVert > 0)
                    {
                        for (int i = 0; i < numOfEdge; i++)
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
    public int timeRequiredforCompetition()
    {
        if (speedOfA < 50 || speedOfA > 100 ||
                speedOfB < 50 || speedOfB > 100 ||
                speedOfC < 50 || speedOfC > 100 ||
                numOfVert <= 0)
        {
            return -1;
        }

        double[][] dist = new double[numOfVert][numOfVert];

        for (int i = 0; i < numOfVert; i++)
        {
            for (int j = 0; j < numOfVert; j++)
            {
                if (graph[i][j] != 0)
                {
                    dist[i][j] = graph[i][j];
                }
                else dist[i][j] = Double.MAX_VALUE;
            }
        }
        for (int k = 0; k < numOfVert; k++)
        {
            for (int i = 0; i < numOfVert; i++)
            {
                for (int j = 0; j < numOfVert; j++)
                {
                    if(dist[i][k] != Double.MAX_VALUE && dist[k][j] != Double.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j])
                    {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int total;
        double longestDist = Double.MIN_VALUE;
        for (double[] dists : dist)
        {
            for (double val : dists)
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

}