class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open=new Stack<>();
        Stack<Integer> stars=new Stack<>();


        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open.push(i);
            }
            else if(ch=='*'){
                stars.push(i);
            }
            else{
                if (!open.isEmpty()) open.pop();
                else if(!stars.isEmpty()) stars.pop();
                else return false;
            }
        }


        while(!open.isEmpty() && !stars.isEmpty()){
            int openIndex=open.pop();
            int starIndex=stars.pop();

            if(openIndex > starIndex) return false;
        }

        return open.isEmpty();
    }
}
