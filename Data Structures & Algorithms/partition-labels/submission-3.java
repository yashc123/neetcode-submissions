
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> finalList = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int endSplit = 0;

        for (int i = 0; i < s.length(); i++) {
            endSplit = Math.max(endSplit, map.get(s.charAt(i)));

            if (i == endSplit) {
                finalList.add(endSplit - start + 1);
                start = i + 1;
            }
        }

        return finalList;
    }
}