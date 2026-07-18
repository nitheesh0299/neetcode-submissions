class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int dp[] = new int[n];

        if (n==0) return 0;
        if (n==1)return nums[0];

        for(int i=0;i<n-1;i++){
            int first = i-2>=0? dp[i-2]:0;
            int second = i-1>=0? dp[i-1]:0;

            dp[i] = Math.max(first+nums[i], second);
        }
        int dp1[] = new int[n];

        for(int i=1;i<n;i++){
            int first = i-2>0? dp1[i-2]:0;
            int second = i-1>0? dp1[i-1]:0;

            dp1[i] = Math.max(first+nums[i], second);
        }

        return Math.max(dp1[n-1],dp[n-2]);


    }
}
