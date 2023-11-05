# 题目

**类型：位运算**



![img](https://cdn.nlark.com/yuque/0/2022/png/2941598/1647137907049-ff76d7be-6744-4b73-9c43-d794bda07a76.png)



# 解题思路

从前往后处理每个 data[i] ，先统计 data[i] 从第 7 位开始往后有多少位连续的 1，代表这是一个几字节的字符，记为 cntcnt ：



- 如果 cntcnt 为 1 或者大于 4 均违反编码规则（与字符长度为 1 时的编码规则 和 字符长度只能是 1 到 4 冲突），返回 False；
- 如果位置 i 后面不足 cnt - 1  也返回 False；

- 否则检查下标范围为 [i + 1, i + cnt - 1]  的数是否满足前两位为 10 的要求，若不满足返回 False。



如果上述过程满足要求，跳到下一个检查点进行检查，整个 data 都没有冲突则返回 True。











# 代码

```java
class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        //0 <= data[i] <= 255(二进制中为11111111，8bit=1byte)，所以每个data[i]占1个字节
        //满足条件的头字节有：0xxxxxxx 110xxxxx 1110xxxx 11110xxx
        for (int i = 0 ; i < n ; ) {
            int t = data[i];
            //1.校验头字节
            int j = 7, cnt = 0; //cnt为头字节中开头1的数量
            while(j >= 0 && ((t >> j) & 1) == 1 && ++cnt >= 0) j--;
            //开头要么是0个1(即1个0)，要么是2-4个1
            if (cnt == 1 || cnt > 4) return false;
            //2.头字节后面的字节数小于 cnt-1个
            if (i + cnt - 1 >= n) return false;
            //3.判断头字节后的cnt-1个字节前两位开头是否为10
            for (int k = i + 1 ; k < i + cnt ; k++) {
                if (((data[k] >> 7) & 1) == 1 && ((data[k] >> 6) & 1) == 0) continue;
                return false;
            }
            //4.当前的字符满足规则，继续向后判断
            //如果cnt=0，即为题目说的1字节的字符，则当前data[i]为一个有效的unicode
            if (cnt == 0) i++;
            //cnt不为0，向后移动cnt个字符
            else i += cnt;
        }
        return true;
    }
}
```