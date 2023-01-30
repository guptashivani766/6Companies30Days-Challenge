class ShuffleAnArray 
{
	  private List<Integer> original;
    private List<Integer> shuffled;
    int[] nums;
    public Solution(int[] nums) {
        this.original = new ArrayList<>();
        this.nums = new int[nums.length];
        for(int i : nums){
            original.add(i);
        }
        this.shuffled = new ArrayList<>(original);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        add(original);
        return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Collections.shuffle(shuffled);
        add(shuffled);
        return this.nums;
    }
    
    
    private void add(List<Integer> list){
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
    }
}
