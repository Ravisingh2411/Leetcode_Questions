class Solution {
    public int minSwaps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int swaps = 0;
        int open = 0;
        int close = 0;
        int j = sb.length()-1;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '[') open++;

            if(sb.charAt(i) == ']') close++;

            if(close > open){
                while(j > i && s.charAt(j) != '[') j--;
                sb.setCharAt(i, '[');
                sb.setCharAt(j, ']');
                swaps++;
                open++;
                close--;
                j--;
            }
        }
        return swaps;
    }
}