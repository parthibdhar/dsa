package Algorithms.Graph.MinimumCostSpannigTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair{
    int node, distance;

    Pair(int distance, int node){
        this.node = node;
        this.distance = distance;
    }
}

public class Primms {

    public int SpanningTree(int v,ArrayList<ArrayList<ArrayList<Integer>>> adj){

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));

        int[] visited = new int[v];

        pq.offer(new Pair(0, 0));
        int sum = 0;

        while(!pq.isEmpty()) {
            Pair cell = pq.poll();
            int pNode = cell.node;
            int Pdis = cell.distance;

            if (visited[pNode] == 1) continue;

            visited[pNode] = 1;
            sum += Pdis;

            for(ArrayList<Integer> node: adj.get(pNode)) {
                int adjNode = node.get(0);
                int edgw = node.get(1);

                if(visited[adjNode] == 0){
                    pq.offer(new Pair(edgw, adjNode));
                }
            }
        }
        return sum;
    }
}
