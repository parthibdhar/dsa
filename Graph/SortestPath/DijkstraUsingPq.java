package Algorithms.Graph.SortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int dist, node;
    Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

public final class DijkstraUsingPq {


    public ArrayList<Integer> findSortestPath(int v, ArrayList<ArrayList<Pair>> adj, int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));

        int[] distance = new int[v];
        Arrays.fill(distance, (int)(1e9));

        pq.offer(new Pair(0, src));

        while(!pq.isEmpty()){
            Pair cell = pq.poll();
            int dis = cell.dist;
            int node = cell.node;

            for(Pair nodePair: adj.get(node)){
                int adjNode = nodePair.dist;
                int edgWt = nodePair.node;
                int totalWt = dis + edgWt;

                if(totalWt < distance[adjNode]){
                    distance[adjNode] = totalWt;
                    pq.offer(new Pair(distance[adjNode], adjNode));
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();

        for(int d: distance) path.add(d);
        return path;
    }
}
