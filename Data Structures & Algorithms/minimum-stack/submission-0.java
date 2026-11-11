class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty()) minst.push(val);
        else minst.push(Math.min(val,minst.peek()));
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
        if(!minst.isEmpty()){
            minst.pop();
        }

    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
