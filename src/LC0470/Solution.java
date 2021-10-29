package LC0470;

/**
 * @author zhanglei211 on 2021/10/29.
 */
class Solution extends SolBase {
    public int rand10() {
        int a = rand7();
        int b = rand7();
        // 【1，6】
        while (a == 7) {
            a = rand7();
        }
        // 【1，5】
        while (b > 5) {
            b = rand7();
        }
        return ((a & 1) == 0 ? 0 : 5) + b;
    }

    // public int rand10() {
    // int i;
    // do {
    // i = (rand7() - 1) * 7 + rand7();
    // } while (i > 40);
    // return i % 10;
    // }
}

abstract class SolBase {
    /**
     * 可生成 1 到 7 范围内的均匀随机整数
     * 
     * @return
     */
    public int rand7() {
        return 0;
    }
}