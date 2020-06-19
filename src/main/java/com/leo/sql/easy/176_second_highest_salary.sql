# 176. 第二高的薪水
# 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
#
# +---------------------+
# | SecondHighestSalary |
# +---------------------+
# | 200                 |
# +---------------------+


#  这句已经能找到第二高的薪水，但是没找到时不能输出null
select distinct salary as SecondHighestSalary
from Employee
order by salary desc
limit 1,1;

# 外面嵌套一层
select (select distinct salary from Employee order by salary desc limit 1,1) as SecondHighestSalary;


# 执行用时：162 ms, 在所有 MySQL 提交中击败了47.17%的用户
# 内存消耗：0B, 在所有 MySQL 提交中击败了100.00%的用户