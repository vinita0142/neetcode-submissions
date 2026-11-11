class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();

        while(true){
            n=sumOfSquares(n);
            if(n==1) return true;
            else if(set.contains(n)) return false;
            else{
                set.add(n);
            }
        }
    }

    private int sumOfSquares(int num){
        int sum=0;

        while(num!=0){
            int x=num%10;
            num=num/10;
            sum+=x*x;
        }

        return sum;
    }
}
