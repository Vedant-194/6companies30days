class Solution {
    
    public class Node {
        int val;
        double prob;
        
        public Node (int val, double prob) {
            this.val = val;
            this.prob = prob;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            double prob = -1 * Math.log(succProb[i]);
            graph.get(src).add(new Node(dest, prob));
            graph.get(dest).add(new Node(src, prob));
        }
        
        double distance[] = new double[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Arrays.fill(distance, Double.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a, b) -> Double.compare(a.prob, b.prob));
        
        Node src = new Node(start, 0.00);
        pq.add(src);
        
        distance[start] = 0.00;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            
            if (curr.val == end) return Math.exp(-distance[curr.val]);
            
            ArrayList<Node> currList = graph.get(curr.val);
            for (Node node : currList) {
                if (!visited[node.val]) {
                    if (distance[node.val] > distance[curr.val] + node.prob) {
                        distance[node.val] = distance[curr.val] + node.prob;
                        pq.add(new Node(node.val, distance[node.val]));
                    }
                }
            } 
            
            visited[curr.val] = true;
        }
        
        return 0;
        
    }
}
