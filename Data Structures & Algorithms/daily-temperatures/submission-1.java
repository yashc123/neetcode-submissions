class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Deque<Integer> stack = new ArrayDeque<>();
       int[] output = new int[temperatures.length];

       for(int i = 0; i < temperatures.length; i++){
        if(i == 0){
            stack.push(temperatures[i]);
        }
        else{
            int counter = 0;
            while(!stack.isEmpty() && temperatures[i] > stack.peek()){
                stack.pop();
                counter++;

                while(output[i-counter] != 0){
                    counter++;
                }

                output[i-counter] = counter;
            }

            stack.push(temperatures[i]);
        }
       }

       return output; 
    }


     
}
