# 596. 超过5名学生的课

# 有一个courses 表 ，有: student (学生) 和 class (课程)。
#
# 请列出所有超过或等于5名学生的课。
#
# 例如,表:
#
# +---------+------------+
# | student | class      |
# +---------+------------+
# | A       | Math       |
# | B       | English    |
# | C       | Math       |
# | D       | Biology    |
# | E       | Math       |
# | F       | Computer   |
# | G       | Math       |
# | H       | Math       |
# | I       | Math       |
# +---------+------------+
# 应该输出:
#
# +---------+
# | class   |
# +---------+
# | Math    |
# +---------+
# Note: 学生在每个课中不应被重复计算。


select class
from courses
group by class
having count(distinct student) >= 5;

# 执行用时：310 ms, 在所有 MySQL 提交中击败了11.82%的用户
# 内存消耗：0B, 在所有 MySQL 提交中击败了100.00%的用户