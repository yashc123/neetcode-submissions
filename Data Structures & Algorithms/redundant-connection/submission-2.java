class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];

        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            if(rootA == rootB){
                return edge;
            }

            parent[rootA] = rootB;
        }

        return new int[]{};
    }

    public int find(int node){
        while(parent[node] != node){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }
}
