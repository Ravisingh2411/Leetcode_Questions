class Solution {
    // public int majorityElement(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int num : nums) {
    //         map.put(num, map.getOrDefault(num, 0) + 1);
    //     }
    //     int maj = nums.length/2;
    //     for(int key : map.keySet()){
    //         int freq = map.get(key);
    //         if(freq > maj) return key;
    //     }
    //     return -1;
    // }


    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}