class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int bigCharacterCount = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            bigCharacterCount = Math.max(bigCharacterCount, map.get(s.charAt(i)));

            if(i - start + 1 - bigCharacterCount > k){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            else{
                longest = Math.max(longest, i - start + 1);
            }

            
        }

        return longest;

    }
}
