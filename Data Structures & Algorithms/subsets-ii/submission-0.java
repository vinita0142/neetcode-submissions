class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        backtrack(0,nums,new ArrayList<>());
        return res;
        
    }


    private void backtrack(int start, int[] nums, List<Integer> path){
        res.add(new ArrayList<>(path));



        for(int j=start;j<nums.length;j++){
            if(j>start && nums[j]==nums[j-1]){
                continue;
            }

            path.add(nums[j]);

            backtrack(j+1,nums, path);
            path.remove(path.size()-1);
        }
    }
}
