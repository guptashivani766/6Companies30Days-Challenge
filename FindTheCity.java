class FindTheCity 
{
	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        float[][] dp = new float[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
			/* If int[][] Arrays.fill(dp[i],12345); */
            dp[i][i] = 0;
        }
        for(int[] edge : edges){
            dp[edge[0]][edge[1]] = edge[2];
            dp[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] + dp[k][j]);
                }
            }
        }
        int maxVisits = n+1;
        int result = -1;
        
        for(int i = 0; i < n; i++) {
            int visit = 0;
            for(int j = 0; j < n; j++) {
                if(dp[i][j] <= distanceThreshold) visit++;
            }
            if(visit <= maxVisits){
                result = i;
                maxVisits = Math.min(maxVisits,visit);
            }
        }
        return result;
    }
}
