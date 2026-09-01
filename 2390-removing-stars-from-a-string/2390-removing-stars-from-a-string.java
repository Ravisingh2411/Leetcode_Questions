class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i <= s.length()-1){
            if(s.charAt(i) != '*'){
                st.push(s.charAt(i));
            }
            else{
                st.pop();
            }
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        while(st.size() != 0){
            char ch = st.pop();
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }
}