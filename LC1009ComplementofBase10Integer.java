class Solution {
    public int bitwiseComplement(int N) {
        int mask = 0;
        int shift = (int)(Math.log(N) / Math.log(2)) + 1;
        
        // for(int i = 0; i < shift; i++){
        //     mask = 1 | (mask << 1);
        //     System.out.println(Integer.toBinaryString(mask));
        // }
        mask = mask | (1 << shift);
        // System.out.println(Integer.toBinaryString(mask));
        return N ^ (mask - 1);
    }
}
