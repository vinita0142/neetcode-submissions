class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty())
                    return false;

                char opening = st.pop();
                if (ch == ')' && opening != '(') {
                    return false;
                } else if (ch == ']' && opening != '[') {

                    return false;
                } else if (ch == '}' && opening != '{') {

                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
