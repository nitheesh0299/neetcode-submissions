class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r = nums.length-1;

        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        } 

        int res = binarySearch(nums,target,0,l-1);
        if(res !=-1){
            return res;
        }
        
        return binarySearch(nums,target,l,nums.length-1);
    
    }


    public int binarySearch(int[] nums, int target, int left, int right){
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right =mid-1;
            }
        }

        return -1;
    }
}
