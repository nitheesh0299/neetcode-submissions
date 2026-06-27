class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] prerequisite : prerequisites){
            if(!adj.containsKey(prerequisite[0])){
                adj.put(prerequisite[0], new ArrayList<>());
            }
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        boolean vis[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && !dfs(adj,i,vis))
                return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adj, int curr, boolean[] vis){
        if(!adj.containsKey(curr)) 
            return true;
        if(vis[curr]){
            return false;
        }
        vis[curr] = true;
        for(int node:adj.get(curr)){
             if(!dfs(adj,node,vis)){
                return false;
             }
        }
        vis[curr] = false;

        return true;
    }
}
