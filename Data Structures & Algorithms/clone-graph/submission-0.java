/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        Queue<Node> queue = new LinkedList<>();
        Map<Node,Node> copy  = new HashMap<>();
        if(node != null){
            copy.put(node, new Node(node.val));    
            queue.add(node);
        }

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node neighbor: curr.neighbors){
                if(!copy.containsKey(neighbor)){
                    copy.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                copy.get(curr).neighbors.add(copy.get(neighbor));

            }

        }

        return copy.get(node);
    }
}