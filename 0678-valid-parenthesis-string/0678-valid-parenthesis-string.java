class Solution {
    // Recursion:-
    // public boolean helper(String s, int ind, int count){
    //     int n = s.length();
    //     if(count < 0) return false;
    //     if(ind == n) return count == 0;
    //     if(s.charAt(ind) == '(') return helper(s, ind+1, count+1);
    //     else if(s.charAt(ind) == ')') return helper(s, ind+1, count-1);
    //     else{
    //         return ((helper(s, ind+1, count+1)) || (helper(s, ind+1, count-1)) || (helper(s, ind+1, count)));
    //     }
    // }
    // public boolean checkValidString(String s) {
    //     return helper(s,0,0);
    // }


// Memoization:-
// public boolean helper(String s, int ind, int count,
//                       int n, boolean[][] dp, boolean[][] visited) {
//     if(count < 0)
//         return false;
//     if(ind == n)
//         return count == 0;
//     if(visited[ind][count])
//         return dp[ind][count];
//     visited[ind][count] = true;

//     if(s.charAt(ind) == '(') {
//         return dp[ind][count] =
//             helper(s, ind + 1, count + 1, n, dp, visited);
//     }

//     else if(s.charAt(ind) == ')') {
//         return dp[ind][count] =
//             helper(s, ind + 1, count - 1, n, dp, visited);
//     }

//     else {return dp[ind][count] =
//         helper(s, ind + 1, count + 1, n, dp, visited) ||
//         helper(s, ind + 1, count - 1, n, dp, visited) ||
//         helper(s, ind + 1, count, n, dp, visited);
//     }
// }
// public boolean checkValidString(String s) {
//     int n = s.length();
//     boolean[][] dp = new boolean[n][n + 1];
//     boolean[][] visited = new boolean[n][n + 1];
//     return helper(s, 0, 0, n, dp, visited);
// }


// Greedy:-
public boolean checkValidString(String s) {
    int n = s.length();
    int min = 0, max = 0;
    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
            min++;
            max++;
        } 
        else if (ch == ')') {
            min--;
            max--;
        } 
        else { 
            min--;  
            max++;  
        }
        if (min < 0) {
            min = 0;
        }
        if (max < 0) {
            return false;
        }
    }
    return min == 0;
}
}