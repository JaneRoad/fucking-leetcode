package array;

public class NumberOfEmployeesWhoMeetTheTargetWorkingHours {

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }

    private static int dfs(int idx, int workedHours, int[] hours, int target, int[] cumSum, int[][] memo) {
        if (idx == hours.length) {
            // If all employees are considered, return whether target is met
            return workedHours >= target ? 1 : 0;
        }

        if (memo[idx][workedHours] != -1) {
            // If the result is already computed, return it
            return memo[idx][workedHours];
        }

        // Two cases: Employee works 0 hours or works more than 0 hours
        int ans = dfs(idx + 1, workedHours, hours, target, cumSum, memo) + 1;

        for (int i = idx + 1; i <= hours.length; i++) {
            // Calculate cumulative worked hours from current employee to subsequent employees
            workedHours += cumSum[i] - cumSum[idx];
            if (workedHours >= target) {
                // If target is met, continue to the next employee
                ans = Math.min(ans, dfs(i, workedHours, hours, target, cumSum, memo));
            } else {
                // If target is not met, stop because subsequent employees will work longer hours
                break;
            }
        }

        memo[idx][workedHours] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int[] hours = new int[]{5,1,4,2,2};
        int target = 6;
        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }
}
