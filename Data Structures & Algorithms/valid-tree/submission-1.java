class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }

        List<List<Integer>> daList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            daList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            daList.get(edge[0]).add(edge[1]);
            daList.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        dfs(0, daList, visited);

        return n == visited.size();
    }

    public void dfs(int nodeNum, List<List<Integer>> adj, Set<Integer> visited){
        if(visited.contains(nodeNum)){
            return;
        }

        visited.add(nodeNum);

        for(int neighbor : adj.get(nodeNum)){
            dfs(neighbor, adj, visited);
        }
    }
}
