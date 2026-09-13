class Solution {
    public int largestInteger(int num) {
        String s = String.valueOf(num);

        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) even.offer(digit);
            else odd.offer(digit);
        }

        int ans = 0;

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit % 2 == 0) ans = ans * 10 + even.poll();
            else ans = ans * 10 + odd.poll();
        }
        return ans;
    }
}