class  SortAnArray
{
	 public int[] sortArray(int[] nums) {
     mergesort(nums, 0, nums.length-1);
     return nums;
    }
	
    public void mergesort(int[] nums, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergesort(nums, start, mid);
            mergesort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }
    
    public void merge(int[] nums, int start, int mid, int end){
    int i= start,  j= mid+1, k=0;
    int[] temp = new int[end-start+1];
    while( i <= mid && j<= end)
    {
        if (nums[i] < nums[j])
            temp[k++] = nums[i++];
        else
            temp[k++] = nums[j++];
    }
    while (i <= mid) { temp[k++] = nums[i++]; } //copy remaining elements
    while (j <= end) { temp[k++] = nums[j++]; } //copy remaining elements
    for (int pointer = start; pointer <= end; pointer++){
        nums[pointer] = temp[pointer-start];
    }
  }
}
