class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
               Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] numPre = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            if(!adjList.containsKey(prerequisites[i][1])){
                adjList.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            numPre[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++){
            if(numPre[i] == 0){
                queue.add(i);
            }
        }

        int completed = 0;
        int[] finalResult = new int[numCourses];

        while(!queue.isEmpty()){
            int num = queue.poll();
            finalResult[completed] = num;
            completed++;

            if(adjList.containsKey(num)){
                for(int a : adjList.get(num)){
                    numPre[a]--;

                    if(numPre[a] == 0){
                        queue.add(a);
                    }
                }
            }
        }

        if(completed == numCourses){
            return finalResult;
        }

        return new int[0];
    }
}
