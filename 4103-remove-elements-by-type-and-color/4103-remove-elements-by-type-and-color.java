class Solution {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        int[][] newed = {types, colors, groupSize};

        int n = newed[0].length;
        int[] sttype = new int[n];
        int[] stcolor = new int[n];
        int[] stcount = new int[n];

        int top = -1;

        for(int i = 0; i < n; i++){
            int a = newed[0][i];
            int b = newed[1][i];
            int c = newed[2][a];

    if(top >= 0 && sttype[top] == a && stcolor[top] == b){
        stcount[top]++;
    }
    else{
        top++;
        sttype[top] = a;
        stcolor[top] = b;
        stcount[top] = 1;
    }
    if(stcount[top] == c){
        top--;
    }
        }
return top == -1;
    }
}