package com.leo.algorithm.easy;

/**
 * 1185. 一周中的第几天
 *
 * <p>给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * <p>输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * <p>您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
 * "Saturday"}。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：day = 31, month = 8, year = 2019 输出："Saturday" 示例 2：
 *
 * <p>输入：day = 18, month = 7, year = 1999 输出："Sunday" 示例 3：
 *
 * <p>输入：day = 15, month = 8, year = 1993 输出："Sunday"
 *
 * <p>提示：
 *
 * <p>给出的日期一定是在 1971 到 2100 年之间的有效日期。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DayOfTheWeek {
  public static void main(String[] args) {
    String s = new Solution().dayOfTheWeek(31, 8, 2019);
    System.out.println(s);
  }

  static class Solution {
    /**
     * 蔡勒公式的 其他公式 w=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400+1)%7
     *
     * @param day d
     * @param month m: 取值是[3,14] 某年的1,2月份要看作上一年的13,14月份来计算，如：2003年1月1日看作2002年13月1日来计算
     * @param year y
     * @return
     */
    public String dayOfTheWeek(int day, int month, int year) {
      if (month == 1) {
        month = 13;
        year--;
      } else if (month == 2) {
        month = 14;
        year--;
      }
      String[] week = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
      };
      return week[
          (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1)
              % 7];
    }
  }
}
