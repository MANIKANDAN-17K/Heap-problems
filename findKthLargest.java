class Solution {
    private Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
      int l = 0;
      int r = nums.length - 1;
      while(true){
        int pivotIdx = RandomPivot(l,r);
        pivotIdx = pivotAndReturn(nums,pivotIdx,l,r);
        if(pivotIdx == k - 1){
            return nums[pivotIdx];
        }else if(pivotIdx > k-1){
            r = pivotIdx -1;
        }else{
            l = pivotIdx + 1;
        }
      }
    }
    private int RandomPivot(int l,int r){
        return (rand.nextInt(r-l+1)+l);
    }
    private int pivotAndReturn(int nums[],int pivotIdx,int l,int r){
        int pivot = nums[pivotIdx];
        swap(nums,l,pivotIdx);
        int idx = l + 1;
        for(int i = l+1;i<=r;i++){
            if(nums[i] > pivot){
                swap(nums,i,idx);
                idx++;
            }
        }
        swap(nums,l,idx-1);
        return idx - 1;
    }
    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
