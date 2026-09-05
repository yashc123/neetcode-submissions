class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }

        Map<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int counter = 0;
        Map<Character, Integer> newMap = new HashMap<>();

        for(int l = 0; l < s2.length() - s1.length() + 1; l++){
            for(int i = 0; i < s1.length(); i++){
                if(mp.containsKey(s2.charAt(l + i))){
                    newMap.put(s2.charAt(l+i),newMap.getOrDefault(s2.charAt(l+i), 0) + 1);
                }
            }
            if(mp.equals(newMap)){
                return true;
            }
            newMap.clear();
        }

        return false;
    }
}
