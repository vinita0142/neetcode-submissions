class Solution {


    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0,0,nums,target,new ArrayList<>());
        return res;
    }


    private void backtrack(int start,int csum, int[] nums, int target, List<Integer> path){
        if(csum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        

        for(int j=start;j<nums.length;j++){
            if (csum+nums[j]>target){
                continue;
            }

            path.add(nums[j]);
            backtrack(j,csum+nums[j],nums,target,path);
            path.remove(path.size()-1);
        }
    }
}
