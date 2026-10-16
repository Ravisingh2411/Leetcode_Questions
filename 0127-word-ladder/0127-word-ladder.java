class Solution {
    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();

            String word = p.word;
            int steps = p.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}