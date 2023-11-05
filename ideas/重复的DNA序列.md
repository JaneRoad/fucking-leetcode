# 题目

**类型：**数组、滑动窗口

![img](https://cdn.jsdelivr.net/gh/JaneRoad/upic@main/Upic/2023/11/05/1633702528270-b0cba423-1baa-46f9-8ad0-84039727ac4f.png)

# 解题思路

这道题的拍脑袋解法比较简单粗暴，我直接穷举所有长度为 10 的子串，然后借助哈希集合寻找那些重复的子串就行了，代码如下：

```java
List<String> findRepeatedDnaSequences(String s) {
    int n = s.length();
    // 记录出现过的子串
    HashSet<String> seen = new HashSet();
    // 记录那些重复出现多次的子串
    // 注意要用哈希集合，防止记录重复的结果
    HashSet<String> res = new HashSet<>();

    for (int i = 0; i + 10 <= n; i++) {
        String subStr = s.substring(i, i + 10);
        if (seen.contains(subStr)){
            // 之前出现过，找到一个重复的
            res.add(subStr);
        } else {
            // 之前没出现过，加入集合
            seen.add(subStr);
        }
    }
    return new LinkedList<>(res);
}
```

这个算法肯定是没问题的，只是时间复杂度略高。假设 s 的长度为 N，目标子串的长度为 L（本题 L = 10），for 循环遍历 s 的 O(N) 个字符，对每个字符都要截取长度为 L 的子字符串，所以这个算法的时间复杂是 O(NL)。



遍历整个 s 肯定是免不了的，问题是我们能不能不要每次都调用 substring 去截取子字符串？

你注意我们这个匹配过程实际上就是维护了一个长度为 L = 10 的定长窗口在从左向右滑动，是否可以借鉴滑动窗口算法框架中的做法，只维护 left, right 指针来划定子字符串区间？

其实可以的，直接套用滑动窗口算法框架写出伪码思路

```java
int L = 10;
HashSet<String> seen;

// 滑动窗口代码框架
CharWindow window;
int left = 0, right = 0;
while (right < s.size()) {
    // 扩大窗口，移入字符
    window.addRight(s[right]);
    right++;

    // 当子串的长度达到要求
    if (right - left == L) {
        // 把窗口中的字符变成字符串，还是需要 O(L) 的时间
        String windowStr = window.toString();
        if (seen.contains(windowStr)) {
            print("找到一个重复子串: ", windowStr);
        } else {
            seen.add(windowHash);
        }

        // 缩小窗口，移出字符
        window.removeLeft();
        left++;
    }
}
```



注意这个解法**依然需要将窗口中的字符转化成字符串然后去 seen 集合判断是否存在重复**，你一旦想把字符转化成字符串，就难免需要 O(L) 的时间来操作。所以这个算法的时间复杂度还是没有降低，依然是 O(NL)。



把 AGCT 四种字符等价为 0123 四个数字，那么**长度为 L = 10 的一个碱基序列其实就可以等价为一个十位数**，这个数字可以唯一标识一个子串。而且窗口移动的过程，其实就是给这个数字的最低位添加数字，并删除最高位数字的过程



添加和删除数字的运算就是两个公式，可以在 O(1) 的时间完成。

```java
/* 在最低位添加一个数字 */
int number = 8264;
// number 的进制
int R = 10;
// 想在 number 的最低位添加的数字
int appendVal = 3;
// 运算，在最低位添加一位
number = R * number + appendVal;
// 此时 number = 82643
```



```java
/* 在最高位删除一个数字 */
int number = 8264;
// number 的进制
int R = 10;
// number 最高位的数字
int removeVal = 8;
// 此时 number 的位数
int L = 4;
// 运算，删除最高位数字
number = number - removeVal * R^(L-1);
// 此时 number = 264
```

然后，我们不要在哈希集合中直接存储子串了，而是存储子串对应的十位数。因为一个十位数可以唯一标识一个子串，所以也可以起到识别重复的作用。

这样，我们就避免了直接生成子串存入集合，而是生成一个十位数来表示子串，而且生成这个十位数的时间花费为 O(1)，从而降低了匹配算法的时间复杂度。



其实你想下，你把一个字符串对象转化成了一个数字，这是什么？这就是你设计的一个哈希算法，生成的数字就可以认为是字符串的哈希值。在滑动窗口中快速计算窗口中元素的哈希值，叫做滑动哈希技巧。





```java
int L = 10;
// 集合中不要存储字符串了，而是存储字符串对应的哈希值
HashSet<Integer> seen;

// 滑动窗口代码框架
CharWindow window;
int left = 0, right = 0;
while (right < s.size()) {
    // 扩大窗口，移入字符
    window.addRight(s[right]);
    right++;

    // 当子串的长度达到要求
    if (right - left == L) {
        // 获取当前窗口内字符串的哈希值，时间 O(1)
        int windowHash = window.hash();
        // 根据哈希值判断是否曾经出现过相同的子串
        if (seen.contains(windowHash)) {
            // 当前窗口中的子串是重复出现的
            print("找到一个重复子串: ", window.toString());
        } else {
            // 当前窗口中的子串之前没有出现过，记下来
            seen.add(windowHash);
        }

        // 缩小窗口，移出字符
        window.removeLeft();
        left++;
    }
}
```

进一步，我们用一个 10 位数来标识一个长度为 10 的碱基字符序列，这需要 long 类型存储，int 存不下 10 位数。但你注意这个 10 位数中所有的数字只会局限于 0,1,2,3，是不是有些浪费？

换句话说，我们需要存储的其实只是一个四进制下的十位数（共包含 4^10 个数字），却用了十进制的十位数（可以包含 10^10 个数字）来保存，显然是有些浪费的。

因为 4^10 = 1048576 < 10^8，所以只要我们在四进制的运算规则下进行运算，十进制的八位数就能存下，这样的话 int 类型就够用了，不需要 long 类型。

具体来说，只要改变我们之前那两个公式的进制 R 就行了：



```java
/* 在最低位添加一个数字 */
// number 的进制
int R = 4;
// 想在 number 的最低位添加的数字
int appendVal = 0~3 中的任意数字;
// 运算，在最低位添加一位
number = R * number + appendVal;

/* 在最高位删除一个数字 */
// number 的进制
int R = 4;
// number 最高位的数字
int removeVal = 0~3 中的任意数字;
// 此时 number 的位数
int L = ?;
// 运算，删除最高位数字
number = number - removeVal * R^(L-1);
```

结合数字最高/最低位的处理技巧和滑动窗口代码框架，我们就可以轻松地写出最终的解法代码：

```java
List<String> findRepeatedDnaSequences(String s) {
    // 先把字符串转化成四进制的数字数组
    int[] nums = new int[s.length()];
    for (int i = 0; i < nums.length; i++) {
        switch (s.charAt(i)) {
            case 'A':
                nums[i] = 0;
                break;
            case 'G':
                nums[i] = 1;
                break;
            case 'C':
                nums[i] = 2;
                break;
            case 'T':
                nums[i] = 3;
                break;
        }
    }
    // 记录重复出现的哈希值
    HashSet<Integer> seen = new HashSet<>();
    // 记录重复出现的字符串结果
    HashSet<String> res = new HashSet<>();

    // 数字位数
    int L = 10;
    // 进制
    int R = 4;
    // 存储 R^(L - 1) 的结果
    int RL = (int) Math.pow(R, L - 1);
    // 维护滑动窗口中字符串的哈希值
    int windowHash = 0;

    // 滑动窗口代码框架，时间 O(N)
    int left = 0, right = 0;
    while (right < nums.length) {
        // 扩大窗口，移入字符，并维护窗口哈希值（在最低位添加数字）
        windowHash = R * windowHash + nums[right];
        right++;

        // 当子串的长度达到要求
        if (right - left == L) {
            // 根据哈希值判断是否曾经出现过相同的子串
            if (seen.contains(windowHash)) {
                // 当前窗口中的子串是重复出现的
                res.add(s.substring(left, right));
            } else {
                // 当前窗口中的子串之前没有出现过，记下来
                seen.add(windowHash);
            }
            // 缩小窗口，移出字符，并维护窗口哈希值（删除最高位数字）
            windowHash = windowHash - nums[left] * RL;
            left++;
        }
    }
    // 转化成题目要求的 List 类型
    return new LinkedList<>(res);
}
```















# 代码

```java
public class RepeatedDNASequences {
    // 定义动态规划数组。1e5+10是数学中的一种表示方法，它表示1万乘以10再加上10。
    static int N = (int)1e5+10;

    //这是一个质数，用于计算哈希值。每次计算都会将前一个字符的哈希值乘以131313，并加上当前字符的ASCII码。这样就可以得到当前位置的哈希值。
    // 使用质数作为乘法因子可以避免出现哈希值为0的情况。
    // 在计算哈希值时，还需要记录每个哈希值出现的次数，以便后续判断是否有重复的子序列。
    static int P = 131313;

    // h数组用于保存根据DNA序列计算得到的哈希值。在计算哈希值时
    // 每次将前一个字符的哈希值乘以一个质数（131313），然后加上当前字符的ASCII码，得到当前位置的哈希值。h数组的每个元素表示对应位置的哈希值
    int[] h = new int[N];

    //p数组用于保存计算哈希值时的当前索引值。在每次计算哈希值时，p数组的当前索引值表示从起始位置到当前位置的DNA序列的长度。
    // 在计算下一个位置的哈希值时，会使用p数组的当前索引值。p数组的每个元素表示对应位置的当前索引值。
    int[] p = new int[N];

    public List<String> findRepeatedDnaSequences(String s) {
        // 计算DNA序列的长度
        int n = s.length();
        // 创建一个答案列表
        List<String> ans = new ArrayList<>();
        // 初始化p数组的第一个元素为1
        p[0] = 1;
        // 根据DNA序列计算哈希值
        for (int i = 1; i <= n; i++) {
            // 计算哈希值h[i]
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            // 计算p数组的当前索引值
            p[i] = p[i - 1] * P;
        }
        // 创建一个哈希记录集合n
        Map<Integer, Integer> map = new HashMap<>();
        // 大小为 10 的滑动窗口，查找重复的子序列
        for (int i = 1; i + 10 - 1 <= n; i++) {
            // 根据公式hash = h[j] - h[i-1] * p[j-i+1]来计算子序列哈希值
            int j = i + 10 - 1;
            int hash = h[j] - h[i - 1] * p[j - i + 1];
            // 获取哈希值的出现次数，如果出现两次则添加到答案列表中
            int cnt = map.getOrDefault(hash, 0);
            if (cnt == 1) ans.add(s.substring(i - 1, i + 10 - 1));
            // 记录哈希值的出现次数
            map.put(hash, cnt + 1);
        }
        // 返回答案列表
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences(s));
    }
}
```