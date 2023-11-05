# 题目

**类型：String**

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1640493541798-cfdececf-b22e-487c-b342-57cf85346460.png)





# 解题思路

分离text成字符串数组，遍历数组遇到符合题意的加入list中，返回

# 代码

```java
class Solution {
    public String[] findOcurrences(String text, String a, String b) {
        String[] ss = text.split(" ");
        int n = ss.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < n; i++) {
            if (ss[i].equals(a) && ss[i + 1].equals(b)) list.add(ss[i + 2]);
        }
        return list.toArray(new String[list.size()]);
    }
}
```