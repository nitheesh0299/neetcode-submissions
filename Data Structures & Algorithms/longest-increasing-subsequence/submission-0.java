class Solution {
    public int lengthOfLIS(int[] nums, int i, int j, int[][] dp){
        if(j==nums.length)
            return 0;
        if(dp[i+1][j]!=-1)
            return dp[i+1][j];
        int len = lengthOfLIS(nums,i,j+1,dp);

        if(i==-1||nums[j]>nums[i]){
            len = Math.max(len,1+ lengthOfLIS(nums,j,j+1,dp));
        }

        return dp[i+1][j] =len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];

        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return lengthOfLIS(nums,-1,0,dp);
        // return dp[n-1][n];
    }
}
