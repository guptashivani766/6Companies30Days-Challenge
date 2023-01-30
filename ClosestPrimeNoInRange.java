class ClosestPrimeNoInRange 
{
	int[] isPrime(int l, int n) {
        ArrayList<Integer> v = new ArrayList<>();
        boolean[] prime = new boolean[n + 1];
        int[] arr = new int[2];
        for (int i = 2; i * i <= n; i++) {
            if (prime[i] == false) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = true;
                }
            }
        }
        
        for (int i = l; i <= n; i++) {
            if (prime[i] == false) {
                v.add(i);
            }
        }
        if (l<=1) {
            v.remove(0);
        }
        arr[0]=-1;
        arr[1]=-1;
        int min = Integer.MAX_VALUE;
        int j=-1;
        for (int i=0;i<=v.size()-1;i++) {
            if (j==-1) {
                j=i;
            } else if (v.get(i)-v.get(j)<min) {
                arr[0]=v.get(j);
                arr[1]=v.get(i);
                min=v.get(i)-v.get(j);
            }
            j=i;
        }
        return arr;
    }
    public int[] closestPrimes(int left, int right) {
        int[] ans=isPrime(left,right);
        return ans;
    }
}
