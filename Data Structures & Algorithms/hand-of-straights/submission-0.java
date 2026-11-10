class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int num : map.keySet()) {
            minheap.offer(num);
        }

        while (!minheap.isEmpty()) {
            int start = minheap.peek();

            for (int i = start; i < start + groupSize; i++) {
                if (!map.containsKey(i))
                    return false;

                map.put(i, map.get(i) - 1);

                if (map.get(i) == 0) {
                    if (i != minheap.peek()) {
                        return false;
                    }
                minheap.poll();
                }
            }
        }

        return true;
    }
}
