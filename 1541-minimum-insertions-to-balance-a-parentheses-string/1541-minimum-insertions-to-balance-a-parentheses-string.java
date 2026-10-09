class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push('(');
            }

            else {
                // Current character is ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (!st.isEmpty()) {
                        st.pop();
                    } else {
                        ans++; // Insert missing '('
                    }
                    i++; // Consume the second ')'
                }

                else {
                    // Only one ')' is available
                    if (!st.isEmpty()) {
                        st.pop();
                        ans++; // Insert one missing ')'
                    } else {
                        ans += 2; // Insert '(' and another ')'
                    }
                }
            }
        }

        ans += 2 * st.size();
        return ans;
    }
}