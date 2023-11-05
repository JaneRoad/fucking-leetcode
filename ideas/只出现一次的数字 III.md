# 题目

类型：bitManipulation

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635573917344-3cabcc49-d084-4bbb-99f5-feffd2ff4573.png)



# 解题思路

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635573934597-073f87ad-0fa5-46cb-8abe-0552fd196199.png)



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635573948664-90711b32-0ba4-4331-a6ca-bf0a50e01ada.png)





一个数和它本身的负数做按位与的运算后可以得到这个数二进制中最低位的那个1。

比如说6&-6，结果是2，6的二进制位0110，最低位的1就是2。



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635575349493-bf8c2f9d-3dbe-41a1-9cc5-bfd38ee1d7a2.png)

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635575393275-d3177453-637a-40cb-8daa-15e8d34e1df3.png)

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635575363248-bcab7ba8-9c2f-44cf-b9c3-676ec286f0f1.png)

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1635575943424-7437313a-d64c-4aa0-8110-542cdabdcbff.png)

# 代码

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
```

