class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] times = new double[position.length][2];

        for(int i = 0; i < position.length; i++){
            times[i][0] = position[i];
            times[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(times, (a,b) -> Double.compare(b[0], a[0]));

        Deque<Double> stack = new ArrayDeque<>();
        for(int i = 0; i < position.length; i++){
            if(stack.isEmpty() || times[i][1] > stack.peek()){
                stack.push(times[i][1]);
            }
        }

        return stack.size();
    }
}
