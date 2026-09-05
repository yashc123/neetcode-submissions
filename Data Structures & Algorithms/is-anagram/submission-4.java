class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() != s.length()){
            return false;
        }

        Map<Character,Integer> list = new HashMap<>();
        for(int i=0; i < s.length(); i++){
            if(list.keySet().contains(s.charAt(i))){
                list.put(s.charAt(i), list.get(s.charAt(i)) + 1);
            }
            else{
                list.put(s.charAt(i), 1);
            }
        }

        for(int j=0; j < t.length(); j++){
            if(!list.keySet().contains(t.charAt(j))){
                return false;
            }
            else{
                list.put(t.charAt(j), list.get(t.charAt(j)) - 1);
                if(list.get(t.charAt(j)) < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
