class NumberOfPair 
{
	 private int SHIFT = 30000;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        BIT bit = new BIT(SHIFT * 2);
        long res = 0L;
        for (int i = 0; i < n; i++) {
            int ndiff = nums1[i] - nums2[i];
            res += bit.get(ndiff + diff + SHIFT);
            bit.add(ndiff + SHIFT);
        }
        return res;
    }
   
    private class BIT {
        private int[] bit;
        public BIT(int n) {
            bit = new int[n+1];
        }
        
        public void add(int val) {
            if (val <= 0) return;
            for (int i = val; i < bit.length; i += (i & -i)) bit[i]++;
        }
        
        public int get(int val) {
            int res = 0;
            for (int i = val; i > 0; i -= (i & -i)) res += bit[i];
            return res;
        }
    }
}
