class Solution {
    public int fillCups(int[] amount) {
        int res = 0;
        Arrays.sort(amount);
        while(amount[1] != 0 && amount[2] != 0){
            res++;
            amount[1]--;
            amount[2]--;
            Arrays.sort(amount);
        }
        res += amount[2];
        return res;
    }
}
