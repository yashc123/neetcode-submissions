class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }
        
        int[] first = new int[26];
        int [] second = new int[26];

        for(int i = 0; i < s1.length(); i++){
            first[s1.charAt(i) - 'a']++;
            second[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(first, second)){
            return true;
        }


        for(int i = s1.length(); i < s2.length(); i++){
            second[s2.charAt(i - s1.length()) - 'a']--;
            second[s2.charAt(i) - 'a']++;

            if(Arrays.equals(first, second)){
                return true;
            }
        }

        return false;
    }
}
