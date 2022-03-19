package design;


//2043. 简易银行系统
public class Bank {
    long[] val;
    public Bank(long[] balance) {
        val = balance;
    }

    boolean check(int account) {
        return 1 <= account && account <= val.length;
    }

    public boolean transfer(int a, int b, long c) {
        if (!check(a) || !check(b)) return false;
        if (val[a - 1] >= c) {
            val[a - 1] -= c; val[b - 1] += c;
            return true;
        }
        return false;
    }

    public boolean deposit(int a, long c) {
        if (!check(a)) return false;
        val[a - 1] += c;
        return true;
    }

    public boolean withdraw(int a, long c) {
        if (!check(a)) return false;
        if (val[a - 1] >= c) {
            val[a - 1] -= c;
            return true;
        }
        return false;
    }
}