class Solution {

    public void combinationSumHelper(int[] nums, int target, int i, List<Integer> res,
        List<List<Integer>> ans){
        if(i==nums.length){
            return;
        }

        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }

        if(target-nums[i]>=0){
            res.add(nums[i]);
            combinationSumHelper(nums,target-nums[i],i,res,ans);
            res.remove(res.size()-1);
        }
        combinationSumHelper(nums,target,i+1,res,ans);
        
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(nums,target,0,res,ans);
        return ans;

    }
}
