class Solution {
    int[] indegree ;
    public int[] findOrder(int numCourses, int[][] preq) {
        indegree = new int[numCourses];
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] edge : preq)
        {
            indegree[edge[0]]++;
            if(adj.containsKey(edge[1]) == false)
            {
                List<Integer> list = new ArrayList<>();
                list.add(edge[0]);
                adj.put(edge[1],list);
            }
            else    adj.get(edge[1]).add(edge[0]);               
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(queue.size() >0)
        {
            int curr = queue.poll();
            ans.add(curr);
            if(adj.containsKey(curr) == true)
            {
                for(int i : adj.get(curr))
                {
                    indegree[i]--;
                    if(indegree[i] == 0)
                        queue.add(i);
                }
            }
        }
        if(ans.size() < numCourses)
            return new int[0];
        int[] fin_ans = new int[ans.size()];
        int i=0;
        for(int node : ans)
        {
            fin_ans[i++] = node;
        }
        
        return fin_ans;
    }
}
