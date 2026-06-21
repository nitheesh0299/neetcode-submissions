class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0],a[0])
        );

        int length = nums.length;
        int[] result= new int[length-k+1];
        for(int i=0;i<k;i++){
            maxHeap.add(new int[]{nums[i],i});  
        }

        result[0] = maxHeap.peek()[0];
        for(int i=k;i<length;i++){
            maxHeap.add(new int[]{nums[i],i});  
            while(maxHeap.peek()[1]<i-k+1){
                maxHeap.poll();
            }
            result[i-k+1] = maxHeap.peek()[0];
        }

        return result;

    }
}
