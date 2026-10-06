class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        int connected = 0;
        int start = 0;

        while(visited.size() < n){
            dfs(start, adj, visited);
            connected++;

            for(int i = 0; i < n; i++){
                if(!visited.contains(i)){
                    start = i;
                    break;
                }
            }
        }

        return connected;

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
