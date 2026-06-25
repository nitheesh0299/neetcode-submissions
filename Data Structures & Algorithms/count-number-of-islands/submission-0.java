
class DisjointSet{

    private int[] parent,size;

    public DisjointSet(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] =i;
            size[i] =1;
        }
    }

    public int find(int node){
        if(node != parent[node]){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv){
            return false;
        }

        if(size[pu]<= size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pv] += size[pu];
        }
        return true;
    }

}


class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        DisjointSet dsu = new DisjointSet(rows* cols);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int islands = 0;
        for(int r=0;r<rows;r++){
            for(int c =0;c<cols;c++){
                if(grid[r][c] =='1'){
                    islands++;
                    for(int[] direction: directions){
                        int nr = r + direction[0];
                        int nc = c + direction[1];
                        if(nr>=0 && nc>=0 && nr<rows && nc <cols 
                            && grid[nr][nc]=='1' && dsu.union(r*cols +c , nr* cols+nc)){
                                islands--;
                        }
                    }
                }
            }
        }

        return islands;
    }
}
