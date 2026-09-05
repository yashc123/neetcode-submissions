class Solution {
    public int minExtraChar(String s, String[] dictionary) {
       int n = s.length();
       Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
       int[] dp = new int[n + 1];
       dp[n] = 0;

       for(int i = n - 1; i >= 0; i--){
        dp[i] = dp[i + 1] + 1;
        for(int j = i + 1; j <= n; j++){
            if(dict.contains(s.substring(i, j))){
                dp[i] = Math.min(dp[i], dp[j]);
            }
        }
       }

       return dp[0];
    }
}