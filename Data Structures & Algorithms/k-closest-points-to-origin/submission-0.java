class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[2],a[2])
        );

        for(int[] point:points){
            int distance = (point[0]*point[0]) +(point[1]* point[1]);
            pq.add(new int[]{point[0],point[1],distance});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] result = new int[k][2];

        for(int i=0;i<k;i++){
            int[] temp = pq.poll();
            result[i][0] = temp[0];
            result[i][1] = temp[1]; 
        }

        return result;

    }
}
