class Solution {
    public boolean isInterleave(int index1, int index2, int index3, 
    String s1, String s2, String s3, Boolean[][] dp){
        if(index3 == s3.length()){
            return (index1 == s1.length() && index2 == s2.length());
        }
        if(dp[index1][index2] != null){
            return dp[index1][index2];
        }

        Boolean result = false;
        if(index1<s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            result = isInterleave(index1+1, index2, index3+1, s1, s2, s3, dp);
        }
        if(index2<s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            result = isInterleave(index1, index2+1, index3+1, s1, s2, s3, dp);
        }
        return dp[index1][index2] = result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return isInterleave(0, 0, 0,s1,s2,s3,dp);
    }
}
