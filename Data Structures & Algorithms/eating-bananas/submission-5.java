class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p : piles) max = Math.max(max, p);

        int start = 1;
        int end = max;
        int output = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int hours = 0;
            for (int b : piles) {
                hours += Math.ceil((double) b / mid);
            }
            if (hours <= h) {
                output = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return output;
    }
}
