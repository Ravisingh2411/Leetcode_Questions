class Solution {
    public char findTheDifference(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        while(i < s.length()){
            if(arr1[i] == arr2[i]){
                i++;
            } 
            else{
                return arr2[i];
            }
        }
        return arr2[arr2.length - 1];
    }
}