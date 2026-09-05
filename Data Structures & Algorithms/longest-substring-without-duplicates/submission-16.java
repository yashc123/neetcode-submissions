class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            else{
                start = Math.max(map.get(s.charAt(i)) + 1, start);
                map.put(s.charAt(i), i);
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
