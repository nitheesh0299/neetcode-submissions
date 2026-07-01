class Solution {
    public int swimInWater(int[][] grid) {

        int n =grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a->a[0])
        );

        pq.add(new int[]{grid[0][0],0,0});


        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        boolean[][] visit = new boolean[n][n];

        int ans = grid[0][0];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            if(curr[1]==n-1 && curr[2] ==n-1){
                return curr[0];
            }
            for(int[] direction: directions){
                int px = curr[1] + direction[0];
                int py = curr[2] + direction[1];
                if(px>=0 && py>=0 && px<n && py<n && !visit[px][py]){
                    visit[px][py] = true;
                    pq.offer(new int[]{Math.max(curr[0],grid[px][py])
                                    ,px,py});
                }
            } 
        }

        return ans;
    }
}
