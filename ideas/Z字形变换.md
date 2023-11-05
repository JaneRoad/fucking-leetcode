# 题目

![image-20210727002325449](https://gitee.com/janeroad/iamge-cloud/raw/master/NoteImage/image-20210727002325449.png)

# 解题思路

1、下面代码的第一个for循环把一个List<StringBuilder>分成多份空字符串，具体几份取决于numRows，然后每一份代表每一行的字符串

2、第二个for循环来判断每一个字符应该放在哪一行，拼接上去

3、第三个for循环遍历List<StringBuilder>把每一行字符串拼接起来就是结果

4、`curRow += goingDown ? 1 : -1;` 这种写法很骚

# 代码

```java
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
```