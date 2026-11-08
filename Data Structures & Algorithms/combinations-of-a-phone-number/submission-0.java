class Solution {

     List<String> res=new ArrayList<>();
       String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };


    public List<String> letterCombinations(String digits) {
       
        if(digits.length()==0){
            return res;
        }

        backtrack(0,digits,new StringBuilder());

        return res;



    }




    private void backtrack(int index, String digits, StringBuilder path){
        if(index==digits.length()){
            res.add(path.toString());
            return;
        }


        String letters=map[digits.charAt(index)-'0'];

        for(int i=0;i<letters.length();i++){
            path.append(letters.charAt(i));
            backtrack(index+1,digits,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
