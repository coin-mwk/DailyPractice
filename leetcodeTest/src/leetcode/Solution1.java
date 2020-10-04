package leetcode;

/**
 * @author Fitz
 * @create 2020-10-04-10:17 上午
 */
public class Solution1 {

    public static int minCount(int[] coins) {
        int count = 0;
        for(int temp : coins) {
            if (temp%2 != 0){
                count += 1 ;
            }
            count += temp / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] aa = {2,3,10};
        System.out.println(minCount(aa));
    }
}
