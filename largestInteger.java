class Solution {
    public int largestInteger(int num) {
        char[] n = String.valueOf(num).toCharArray();
        for(int i =0;i<n.length;i++){
            for(int j = i+1;j<n.length;j++){
                if(n[j] > n[i] && (n[j] - n[i])% 2 == 0){
                    char t = n[i];
                    n[i] = n[j];
                    n[j] = t;
                }
            }
        }
        return Integer.parseInt(new String(n));
    }
}
