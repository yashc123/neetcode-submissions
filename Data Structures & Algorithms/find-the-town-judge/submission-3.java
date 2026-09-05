class Solution {
    public int findJudge(int n, int[][] trust) {

        Set<Integer> people = new HashSet<>(); 
        int judge = trust[0][1];
        for(int i = 0; i < trust.length; i++){

            if(trust[i][1] != judge && !people.contains(trust[i][0])){
                return -1;
            }
            people.add(trust[i][0]);
        }
        return judge;
        
        
    }
}