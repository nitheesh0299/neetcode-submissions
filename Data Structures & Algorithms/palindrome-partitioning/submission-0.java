class Solution {
    public void partition(
        String s, int start, List<String> partition, List<List<String>> partitions) {
            if(start == s.length()){
                partitions.add(new ArrayList<>(partition));
                return;
            }

            for(int end = start; end<s.length();end++){
                if(isPalindrome(s,start,end)){
                    partition.add(s.substring(start,end+1));
                    partition(s,end+1,partition,partitions);
                    partition.remove(partition.size()-1);
                }
            }
        }
    public List<List<String>> partition(String s) {
        List<String> partition = new ArrayList<>();
        List<List<String>> partitions = new ArrayList<>();

        partition(s,0,partition,partitions);

        return partitions;
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false; 
            }
            start++; 
            end--;
        }
        return true;
    }
}
