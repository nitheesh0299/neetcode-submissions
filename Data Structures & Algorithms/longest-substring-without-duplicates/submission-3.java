class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n =s.length();
        if (n<=1)
            return n;
        int maxLen = 0;
        int[] index = new int[128];
        Arrays.fill(index,-1);
        int i=0,j=0;
        while(j<n){
            char c = s.charAt(j);
            if(index[c]>=i){
                i = index[c]+1;
            }
                index[c] = j;

            if(j-i+1>maxLen)
                maxLen = j-i+1;
            j++;
        }

        return maxLen;
    }
}
