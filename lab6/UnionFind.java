public class UnionFind {

    private int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i += 1) {
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex < 0 || vertex >= parent.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        return -parent(find(v1));
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        int rootOfv1 = find(v1);
        int rootOfv2 = find(v2);
        return rootOfv1 == rootOfv2;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int rootOfv1 = find(v1);
        int rootOfv2 = find(v2);
        if (parent(rootOfv1) < parent(rootOfv2)) {
            parent[rootOfv1] += parent(rootOfv2);
            parent[rootOfv2] = rootOfv1;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        int rootOfVertex = vertex;
        while (parent(rootOfVertex) >= 0) {
            rootOfVertex = parent(rootOfVertex);
        }
        while (vertex != rootOfVertex) {
            parent[vertex] = rootOfVertex;
            vertex = parent(vertex);
        }
        return rootOfVertex;
    }

}
