# 题目

**类型：Math**



![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1634131268611-d6e7da85-4cf1-481c-893f-0b626412e12b.png)

# 解题思路

![img](https://cdn.nlark.com/yuque/0/2021/png/2941598/1634131289001-408b1a8b-3dde-43c6-8032-551c6bf41922.png)

# 代码

```java
public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }
```