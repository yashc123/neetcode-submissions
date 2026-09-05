class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> daSet = new HashSet<>();
        int l = 0;
        int maxCounter = 0;

        for (int r = 0; r < s.length(); r++) {
            while (daSet.contains(s.charAt(r))) {
                daSet.remove(s.charAt(l));
                l++;
            }
            daSet.add(s.charAt(r));
            maxCounter = Math.max(maxCounter, r - l + 1);
        }

        return maxCounter;
    }
}
