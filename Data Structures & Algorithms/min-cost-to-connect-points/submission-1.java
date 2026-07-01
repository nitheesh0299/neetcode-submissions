class DSU{
    int[] size;
    int[] parent;

    public DSU(int n){
        size = new int[n];
        parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] =i;
        }
        Arrays.fill(size,1);
    }

    public int find(int i){
        if(parent[i]!=i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)
            return false;
        
        if(size[pu] < size[pv]){
            parent[pu] =pv;
            size[pv] += size[pu];
        }else{
            parent[pv] =pu;
            size[pu] += size[pv];
        }

        return true;
    }

}

class Solution {

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = Math.abs(points[i][0]-points[j][0]) + 
                    Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }

        edges.sort((a,b) -> Integer.compare(a[0],b[0]));
        DSU dsu = new DSU(n);

        int ans =0;
        for(int[] edge:edges){
            if(dsu.union(edge[1],edge[2])){
                ans += edge[0];
            }
        }

        return ans;
    }
}
