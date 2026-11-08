class Solution {
    public long countValidSubstrings(String s) {
        int n = s.length();

        int lA = -1;
        int lAB = -1;
        int lBAD = -1;

        long res = 0;

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);

            if(ch == 'a'){
                lA = i;
            }

            else if(ch == 'b'){
                if(lA != -1){
                    lAB = lA;
                }
            }

            else if(ch == 'c'){
                if(lAB != -1){
                    lBAD = Math.max(lBAD, lAB);
                }
            }
            res += i - lBAD;
        }
        return res;
    }
}