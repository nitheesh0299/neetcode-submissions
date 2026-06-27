class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite: prerequisites){
            if(!adj.containsKey(prerequisite[0])){
                adj.put(prerequisite[0], new ArrayList<>());
            }
            indegree[prerequisite[1]]++;
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int[] res = new int[numCourses];
        int finished =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            finished++;
            res[numCourses - finished] =curr;
            if(!adj.containsKey(curr))
                continue;
            for(int i: adj.get(curr)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }

        if(finished !=numCourses) 
            return new int[0];

        return res;
    }
}
