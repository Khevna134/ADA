import java.util.*;

public class pr8 {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    static int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    static void union(Subset[] subsets, int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank)
            subsets[rootX].parent = rootY;
        else if (subsets[rootX].rank > subsets[rootY].rank)
            subsets[rootY].parent = rootX;
        else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++)
            edges[i] = new Edge();

        edges[0].src = 0; edges[0].dest = 1; edges[0].weight = 10;
        edges[1].src = 0; edges[1].dest = 2; edges[1].weight = 6;
        edges[2].src = 0; edges[2].dest = 3; edges[2].weight = 5;
        edges[3].src = 1; edges[3].dest = 3; edges[3].weight = 15;
        edges[4].src = 2; edges[4].dest = 3; edges[4].weight = 4;

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        Edge[] result = new Edge[V - 1];
        int e = 0, i = 0;

        while (e < V - 1) {
            Edge next = edges[i++];

            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subsets, x, y);
            }
        }

        int total = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            total += result[i].weight;
        }
        System.out.println("Total Weight: " + total);
    }
}
