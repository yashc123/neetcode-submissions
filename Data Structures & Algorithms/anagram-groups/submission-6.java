class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>, List<String>> daMap = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            Map<Character, Integer> newMap = new HashMap<>();
            for(int j=0; j < strs[i].length(); j++){
                char daOne = strs[i].charAt(j);
                newMap.put(daOne, newMap.getOrDefault(daOne,0) + 1);
            }

            if(daMap.containsKey(newMap)){
                List<String> daList = daMap.get(newMap);
                daList.add(strs[i]);
                daMap.put(newMap, daList);
            }
            else{
                List<String> daList = new ArrayList<>();
                daList.add(strs[i]);
                daMap.put(newMap, daList);
            }
        }

        List<List<String>> finalBoss = new ArrayList<>();
        for(List<String> newList : daMap.values()){
            finalBoss.add(newList);
        }

        return finalBoss;
    }
}
