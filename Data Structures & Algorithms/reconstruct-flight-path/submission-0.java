class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            if(!adj.containsKey(from)){
                adj.put(from, new PriorityQueue<String>());
            }
            adj.get(from).add(to);
        }

        Stack<String> stack = new Stack<>();
        LinkedList<String> results = new LinkedList<>();

        stack.add("JFK");

        while(!stack.isEmpty()){
            String curr = stack.peek();

            if(adj.containsKey(curr) && !adj.get(curr).isEmpty()){
                stack.add(adj.get(curr).poll());
            }else{
                results.addFirst(stack.pop());
            }
        }
        
        return results;
    }
}
