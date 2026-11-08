class Solution {
        List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(0,s,new ArrayList<>());
        return res;

    }



    private void backtrack(int start, String s, List<String>path){



        if(start==s.length()){
            res.add(new ArrayList<>(path));
        }

        for(int j=start;j<s.length();j++){
            String sub=s.substring(start,j+1);

            if(!isPalindrome(sub)){
                continue;
            }

            path.add(sub);
            backtrack(j+1,s,path);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
