class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] dp =new int[n];
        Arrays.fill(dp,1);
        int maxlen = 0;

        String res ="";
        for(int i=0;i<n;i++){
            int l = i, r=i;

            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>=maxlen){
                    res = s.substring(l,r+1);
                    maxlen = r-l+1;
                }
                l--;r++;
            }

            l = i;
            r=i+1;

            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                if(r-l+1>=maxlen){
                    res = s.substring(l,r+1);
                    maxlen = r-l+1;
                }
                l--;r++;
            }
        }

        return res;
    }
}
