class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqS = new HashMap<>();

        for(char c : t.toCharArray()){
            freqT.put(c,freqT.getOrDefault(c,0)+1);
        }
        int found = 0;
        int l=0;
        int len = Integer.MAX_VALUE;
        String ans ="";
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            freqS.put(c, freqS.getOrDefault(c,0)+1);

            if(freqT.getOrDefault(c,0)==freqS.get(c)){
                found++;
            }

            while(found == freqT.size()){
                if(r-l+1<len){
                    len = r-l+1;
                    ans = s.substring(l,r+1);
                }

                char left = s.charAt(l);
                freqS.put(left,freqS.get(left)-1);
                if(freqT.containsKey(left) &&
                    freqT.get(left)>freqS.get(left)){
                    found--;
                }
                l++;
            }
        }

        return ans;
     }
}
