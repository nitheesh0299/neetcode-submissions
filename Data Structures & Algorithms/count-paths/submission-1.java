class Solution {
    public int uniquePaths(int m, int n) {
        int[] countArray = new int[n];
        countArray[0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(j-1>=0)
                    countArray[j] += countArray[j-1];
            }
        }

        return countArray[n-1];
    }
}
