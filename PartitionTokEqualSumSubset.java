class PartitionTokEqualSumSubset 
{
	  public boolean canPartitionKSubsets(int[] a, int k) {
        int sum=0;
	    for(int i=0;i<a.length;i++){
	        sum+=a[i];  //finding sum of elements
	    }
	    
	    if(k==1) return true;
	    if(k>a.length || sum%k!=0) return false; //if sum is not a multiple of K we can't divide
	    boolean visited[]= new boolean[a.length];  
	    Arrays.fill(visited,false);
	    return findPart(a,visited,sum/k,0,0,k);
    }
     public boolean findPart(int arr[], boolean visited[], int target, int curr_sum, int i, int k){
        if(k==1) return true;
        
        if(curr_sum==target) return findPart(arr, visited, target, 0, 0, k-1);
        
        for(int j=i;j<arr.length;j++){
            if(visited[j] || curr_sum+arr[j]>target) continue;
            visited[j]=true;  //do
            if(findPart(arr, visited, target, curr_sum + arr[j], j+1, k))  //recur
                return true;
            visited[j]=false;  //undo
            
        }
        return false;
    }
}
