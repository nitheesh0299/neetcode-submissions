class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int visited[] = new int[n+1];
        Arrays.fill(visited,Integer.MAX_VALUE);
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int i=1;i<=n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] time:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        visited[k] =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int[] nei: adj.get(curr)){
                int delay = visited[curr]+ nei[1];

                if(delay<visited[nei[0]]){
                    visited[nei[0]] = delay;
                    q.add(nei[0]);
                }
            }
        }

        int delayTime =0;
        for(int i=1;i<=n;i++){
            if(visited[i]==Integer.MAX_VALUE){
                return -1;
            }
            delayTime = Math.max(delayTime, visited[i]);
        }

        return delayTime;

    }
}
