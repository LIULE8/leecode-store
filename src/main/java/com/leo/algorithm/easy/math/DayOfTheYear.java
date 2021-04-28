// 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
//
//
//
// 示例 1：
//
// 输入：date = "2019-01-09"
// 输出：9
//
//
// 示例 2：
//
// 输入：date = "2019-02-10"
// 输出：41
//
//
// 示例 3：
//
// 输入：date = "2003-03-01"
// 输出：60
//
//
// 示例 4：
//
// 输入：date = "2004-03-01"
// 输出：61
//
//
//
// 提示：
//
//
// date.length == 10
// date[4] == date[7] == '-'，其他的 date[i] 都是数字。
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
//
// Related Topics 数学
// 1154. 一年中的第几天

package com.leo.algorithm.easy.math;

public class DayOfTheYear {
  public static void main(String[] args) {
    //    int i = new Solution().dayOfYear("2019-01-09");
    //    int i = new Solution().dayOfYear("2012-01-02");
    int i = new Solution().dayOfYear("2004-03-01");
    System.out.println(i);
  }

  static class Solution {
    public int dayOfYear(String date) {
      return method1(date);
    }

    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 9.98% 的用户
     *
     * <p>内存消耗： 39.2 MB , 在所有 Java 提交中击败了 5.21% 的用户
     *
     * @param date
     * @return
     */
    private int method1(String date) {
      int[] res = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      String[] split = date.split("-");
      int days = Integer.parseInt(split[2]);
      int month = Integer.parseInt(split[1]) - 1;
      for (int i = 0; i < month; i++) {
        days += res[i];
      }
      int year = Integer.parseInt(split[0]);
      return (year % 4 == 0 || year % 400 == 0) && month > 1 ? ++days : days;
    }
  }
}
