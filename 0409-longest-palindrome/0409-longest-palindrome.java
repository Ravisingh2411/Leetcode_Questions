class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int odd = 0;
        for(int freq : map.values()){
            if(freq % 2 == 0){
                len += freq;
            } 
            else{
                if(odd == 0){
                    len += freq;
                    odd++;
                } 
                else len += freq-1;
            }
        }
        return len;
    }
}