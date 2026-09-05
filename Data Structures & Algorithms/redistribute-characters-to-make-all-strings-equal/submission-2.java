class Solution {
    public boolean makeEqual(String[] words) {
        int[] result = new int[26];

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                result[words[i].charAt(j) - 'a']++;
            }
        }

        for(int i = 0; i < result.length; i++){
            if(result[i] != 0 && result[i] % words.length != 0){
                return false;
            }
        }

        return true;
    }
}