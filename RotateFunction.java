class RotateFunction 
{
	 public int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0, init = 0;
        
        for(int i = 0; i < n; i++)
        {
            sum += A[i];
            init += (A[i] * i);
        }
        
        int ans = init;
        
        for(int k = 1; k < n; k++)
        {
            int newValue = init + (A[k - 1] * (n - 1)) - (sum - A[k - 1]);
            init = newValue;
            ans = Math.max(newValue, ans);
        }
        
        return ans;
    }
}
