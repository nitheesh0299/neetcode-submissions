class Solution {

    private int[][] directions ={{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean pacific[][] = new boolean[rows][cols]; 
        boolean atlantic[][] = new boolean[rows][cols]; 

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<rows;i++){
            dfs(i,0,pacific, heights);
            dfs(i,cols-1,atlantic,heights);
        }

        for(int i=0;i<cols;i++){
            dfs(0,i,pacific, heights);
            dfs(rows-1,i,atlantic,heights);
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(List.of(r,c));
                }
            }
        }

        return result;


    }

    public void dfs(int row, int col, boolean[][] visited, int[][] heights){
        visited[row][col] =true;

        for(int i=0;i<4;i++){
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];
            if(newRow>=0 && newRow<heights.length && newCol>=0 &&
                newCol < heights[0].length && !visited[newRow][newCol]
                && heights[newRow][newCol] >= heights[row][col]){
                    dfs(newRow, newCol, visited, heights);
            }
        }
    }
}
