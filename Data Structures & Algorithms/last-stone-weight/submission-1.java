class Solution {
    public int lastStoneWeight(int[] stones) {
        int length = stones.length;
        int ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<length;i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int remaining =pq.poll()-pq.poll(); 
            if(remaining!=0)
                pq.add(remaining);
        }
        return pq.size()==0?0:pq.poll();
    }
}
