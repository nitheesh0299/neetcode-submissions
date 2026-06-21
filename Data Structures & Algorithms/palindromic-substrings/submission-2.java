class Solution {
    public boolean checkPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;
    }

    public int countSubstrings(String s) {
         
         int length = s.length();
         int count =0;

         for(int i=0;i<length;i++){
            int low =i,high =i;
            while(low>=0 && high<length && s.charAt(low)==s.charAt(high)){
                count++;
                low--; high++;
            }
            if(i+1<length && s.charAt(i)==s.charAt(i+1)){
                low =i;
                high =i+1;
                while(low>=0 && high<length && s.charAt(low)==s.charAt(high)){
                    count++;
                    low--; high++;
                }
            }
         }

         return count;
    }
}
