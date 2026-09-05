class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int num : stones){
            maxHeap.add(num);
        }

        while(maxHeap.size() > 1){
            int one = maxHeap.poll();
            int two = maxHeap.poll();

            if(two < one){
                maxHeap.add(one - two);
            }
        }

        if(!maxHeap.isEmpty()){
            return maxHeap.peek();
        }

        return 0;
    }
}
