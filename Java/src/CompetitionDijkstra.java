/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city numOfVert. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the numOfVert at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a ylection of numOfVert in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 *
 * @author Lewis Kelly 20335015
 */

import java.io.File;
import java.util.*;

public class CompetitionDijkstra
{

    String fileName;
    int speedOfA;
    int speedOfB;
    int speedOfC;

    int numOfVert = 0;
    int numOfEdge = 0;
    boolean valid = true;

    ArrayList<String> graphString;
    double[][] graph;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA,       sB, sC: speeds for 3 contestants
     */
    CompetitionDijkstra(String filename, int sA, int sB, int sC)
    {
        this.fileName = filename;
        this.speedOfA = sA;
        this.speedOfB = sB;
        this.speedOfC = sC;
        this.graphString = new ArrayList<>();
        parseFile(fileScanner(fileName));
    }

    private Scanner fileScanner(String fileName)
    {
        try
        {
            return new Scanner(new File(fileName));
        } catch (Exception e)
        {
            valid = false;
            return null;
        }
    }

    private void parseFile(Scanner file)
    {
        if (valid)
        {
            try
            {
                this.numOfVert = file.nextInt();
                this.numOfEdge = file.nextInt();
                file.nextLine();
                while (file.hasNextLine())
                {
                    graphString.add(file.nextLine());
                }
            } catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }

    private double[][] buildGraph()
    {
        double[][] graph = new double[this.numOfVert][this.numOfVert];
        for (int i = 0; i < this.numOfVert; i++)
        {
            for (int j = 0; j < this.numOfVert; j++)
            {
                graph[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        for (int i = 0; i < this.numOfVert; i++)
        {
            graph[i][i] = 0;
        }

        for (String s : this.graphString)
        {
            Scanner lineScanner = new Scanner(s);
            int street = lineScanner.nextInt();
            int connectingStreet = lineScanner.nextInt();
            double dist = lineScanner.nextDouble();

            graph[street][connectingStreet] = dist;
            lineScanner.close();
        }

        return graph;
    }

    private double dijkstra()
    {
        double currentMaxDist = 0;
        for (int i = 0; i < this.numOfVert; i++)
        {
            int queueSize = 1;
            double[] dist = new double[this.numOfVert];
            boolean[] mark = new boolean[this.numOfVert];

            for (int j = 0; j < this.numOfVert; j++)
            {
                dist[j] = Double.POSITIVE_INFINITY;
                mark[j] = false;
            }

            dist[i] = 0;
            

            while (queueSize > 0)
            {
                int indexOfShort = getShortestPath(dist, mark);
                for (int j = 0; j < numOfVert; j++)
                {
                    if (((graph[indexOfShort][j] + dist[indexOfShort]) < dist[j]) && (!mark[j]))
                    {
                        dist[j] = (graph[indexOfShort][j] + dist[indexOfShort]);
                        queueSize++;
                    }
                }

                mark[indexOfShort] = true;
                queueSize--;
            }

            double max = getHighestValue(dist);
            if (max == Double.POSITIVE_INFINITY)
            {
                return -1;
            }
            if (max > currentMaxDist)
            {
                currentMaxDist = max;
            }
        }
        return currentMaxDist;
    }

    private double getHighestValue(double[] dist)
    {
        double highest = 0;
        for (double v : dist) highest = Math.max(v, highest);
        return highest;
    }

    private int getShortestPath(double[] dist, boolean[] mark)
    {
        int shortest = 0;
        for (int i = 1; i < dist.length; i++)
            if ((dist[i] < dist[shortest] && !mark[i]) || mark[shortest])
            {
                shortest = i;
            }
        return shortest;
    }

    /**
     * @return int: minimum minutes that will pass before the three contestants can
     * meet
     */
    public int timeRequiredforCompetition()
    {
        if (!valid || this.numOfVert == 0
                || ((speedOfA > 100 || speedOfA < 50)
                || (speedOfB > 100 || speedOfB < 50)
                || (speedOfC > 100 || speedOfC < 50)))
            return -1;

        List<Integer> slowest = new ArrayList<>();
        slowest.add(speedOfA);
        slowest.add(speedOfB);
        slowest.add(speedOfC);
        int slowestSpeed = Collections.min(slowest);

        graph = buildGraph();
        double maxDist = dijkstra();

        if (maxDist == -1)
            return -1;
        else return (int) ((Math.ceil((maxDist * 1000) / slowestSpeed)));
    }

}
