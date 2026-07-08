class Solution {
    public List<Integer> partitionLabels(String s) {
        int count[] = new int[26];
        int len = s.length();
        for(int i=0;i<len;i++){
            count[s.charAt(i)-'a']= i;
        }

        int start =0;
        int end =0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<len;i++){
            end = Math.max(count[s.charAt(i)-'a'], end);
            if(end == i){
                result.add(end-start+1);
                start = i+1;
            }
        }

        return result;
    }
}
