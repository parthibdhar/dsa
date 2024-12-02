package LearningProgram.Graph.DisjointSet;

import java.util.ArrayList;

// this problem is helps us to learn krukal's algo easily
// union by rank
public class DisjointSet {
    ArrayList<Integer> parents = new ArrayList<>();
    ArrayList<Integer> ranks = new ArrayList<>();

    public DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parents.add(i);
            ranks.add(0);
        }
    }

    public int findUltimateParent(int node){
        if(node == parents.get(node)) return node;

        int ultimateParent = findUltimateParent(parents.get(node));
        parents.set(node, ultimateParent);
        return parents.get(node);
    }

    public void unionByRank(int u, int v){
        int ulP_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);

        if(ulp_v == ulP_u) return;

        if(ranks.get(ulp_v) < ranks.get(ulP_u)) parents.set(ulp_v, ulP_u);

        else if (ranks.get(ulP_u) < ranks.get(ulp_v)) parents.set(ulP_u, ulp_v);

        else {
            parents.set(ulp_v, ulP_u);
            int rank_u = ranks.get(ulP_u);
            ranks.set(ulP_u, rank_u+1);
        }
    }
}
