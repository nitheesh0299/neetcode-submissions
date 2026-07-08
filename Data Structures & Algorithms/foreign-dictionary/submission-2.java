class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> adj = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(String word:words){
            for(char c: word.toCharArray()){
                adj.put(c,new HashSet<>());
                indegree.put(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int minlen = Math.min(word1.length(),word2.length());
            if(word1.length()>word2.length() 
                && word1.substring(0,minlen).equals(word2.substring(0,minlen))){
                return "";
            }

            for(int j=0;j<minlen;j++){
                if(word1.charAt(j)!= word2.charAt(j) ){
                    if(!adj.get(word1.charAt(j)).contains(word2.charAt(j))){
                        adj.get(word1.charAt(j)).add(word2.charAt(j));
                        indegree.put(word2.charAt(j),indegree.get(word2.charAt(j))+1);
                    }
                    break;
                }
            }
        }

        Queue<Character>  q = new LinkedList<>();
        for(char c:indegree.keySet()){
            if(indegree.get(c)==0){
                q.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(char c: adj.get(curr)){
                indegree.put(c, indegree.get(c)-1);
                if(indegree.get(c)==0){
                    q.add(c);
                }
            }
        }

        return sb.length() != indegree.size()? "":sb.toString();


    }
}
