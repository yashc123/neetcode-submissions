class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> finalList = new ArrayList<>();
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).add(i);
            }
            else{
                map.put(s.charAt(i), new ArrayList<>(List.of(i)));
            }
        }

        int start = 0;
        int endSplit = 0;

        for(int i = 0; i < s.length(); i++){
            int size = map.get(s.charAt(i)).size();
            if(map.get(s.charAt(i)).size() == 1 || i == map.get(s.charAt(i)).get(size - 1)){
                if(i == endSplit){
                    finalList.add((endSplit - start) + 1);
                    start = i + 1;
                    endSplit = i + 1;
                }
            }
            else{
                int end = map.get(s.charAt(i)).get(size - 1);

                endSplit = Math.max(endSplit, end);
            }
        }

        if(start < s.length() - 1){
            finalList.add((endSplit - start) + 1);
        }

        return finalList;
        

    }
}
