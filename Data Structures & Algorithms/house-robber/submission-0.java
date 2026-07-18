class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        
        for(int i=0;i<n;i++){
            int first = i-2>=0? dp[i-2]:0;
            int second = i-1>=0? dp[i-1]:0;

            dp[i] = Math.max(first+nums[i], second);
        }

        return dp[n-1];
    }
}
