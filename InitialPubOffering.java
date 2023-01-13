class InitialPubOffering 
{
	 public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        
        PriorityQueue<int[]> minCapitalProjects = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a,b) -> b - a);
        
		// Building the minHeap pair of capital and profits, sorted in ascending order of capital        
        for(int i=0; i<Capital.length; i++)
            minCapitalProjects.add(new int[]{Capital[i], Profits[i]});
        
        // Check until k projects are completed
        for (int i=0; i < k; i++){
            // Pick up all projects that meets current cummulative capital and store it in a maxHeap of profits
            while(!minCapitalProjects.isEmpty() && minCapitalProjects.peek()[0] <= W)
                maxProfits.add(minCapitalProjects.poll()[1]);
            if(maxProfits.isEmpty()) 
                return W;
            // Update the capital by polling the highest profit element from the maxHeap of profits
            W += maxProfits.poll();
        }
        return W;
    }
}
