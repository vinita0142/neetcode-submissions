class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = {0, 0, 0};

        for (int[] trip : triplets) {
            if (trip[0] > target[0] || trip[1] > target[1] || trip[2] > target[2]) {
                continue;
            }

            res[0] = Math.max(res[0], trip[0]);
            res[1] = Math.max(res[1], trip[1]);
            res[2] = Math.max(res[2], trip[2]);
        }

        return res[0]==target[0] && res[1]==target[1] && res[2]==target[2];
    }
}
