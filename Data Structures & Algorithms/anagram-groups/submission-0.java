class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            if(map.containsKey(sortedString)){
                map.get(sortedString).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedString,list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(String s:map.keySet()){ 
            result.add(map.get(s));
        }

        return result;
    }
}
