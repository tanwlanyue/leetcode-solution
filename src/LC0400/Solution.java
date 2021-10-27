package LC0400;

/**
 * 注意d * num造成的大数越界
 * @author zhanglei211 on 2021/10/27.
 */
class Solution {
    public int findNthDigit(int n) {
        long d = 1;
        long num = 9;
        int startNum = 1;
        long totalNum = n;
        while (true) {
            long releaseNum = totalNum - d * num;
            if (releaseNum > 0) {
                totalNum = releaseNum;
                d++;
                num *= 10;
            } else {
                break;
            }
        }
        for (int i = 0; i < d - 1; i++) {
            startNum = startNum * 10;
        }
        long targetNum = startNum + (totalNum - 1) / d;
        long offset = (totalNum - 1) % d;
        char c = String.valueOf(targetNum).charAt((int) offset);
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(2147483647));
    }
}