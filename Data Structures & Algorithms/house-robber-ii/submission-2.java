class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int dp[] = new int[n];
        int dp1[] = new int[n];

        if (n==0) return 0;
        if (n==1)return nums[0];

        for(int i=0;i<n-1;i++){
            int first = i-2>=0? dp[i-2]:0;
            int second = i-1>=0? dp[i-1]:0;

            dp[i] = Math.max(first+nums[i], second);
            int j =i+1;
            first = j-2>0? dp1[j-2]:0;
            second = j-1>0? dp1[j-1]:0;

            dp1[j] = Math.max(first+nums[j], second);
        }


        return Math.max(dp1[n-1],dp[n-2]);


    }
}
