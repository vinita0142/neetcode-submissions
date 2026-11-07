class Solution {

    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(0,target,candidates,0,new ArrayList<>());
        return new ArrayList<>(res);

    }

    private void bt(int csum, int target, int[] nums, int start, List<Integer> path){


        if(csum==target){
            res.add(new ArrayList<>(path));
            return;
        }


        for(int j=start;j<nums.length;j++){


            if(j>start && nums[j]==nums[j-1]){
                continue;
            }

            if(csum+nums[j]>target){
                break;
            }

            path.add(nums[j]);
            bt(csum+nums[j],target,nums,j+1,path);
            path.remove(path.size()-1);
        }

    }
}
