# 197. 上升的温度
# 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
#
# +---------+------------------+------------------+
# | Id(INT) | RecordDate(DATE) | Temperature(INT) |
# +---------+------------------+------------------+
# |       1 |       2015-01-01 |               10 |
# |       2 |       2015-01-02 |               25 |
# |       3 |       2015-01-03 |               20 |
# |       4 |       2015-01-04 |               30 |
# +---------+------------------+------------------+
# 例如，根据上述给定的 Weather 表格，返回如下 Id:
#
# +----+
# | Id |
# +----+
# |  2 |
# |  4 |
# +----+


# mysql日期相加函数 date_add()
select t.Id
from Weather t left join Weather y on t.RecordDate = date_add(y.RecordDate, interval 1 day)
where t.Temperature > y.Temperature

# 执行用时：333 ms, 在所有 MySQL 提交中击败了73.09%的用户
# 内存消耗：0B, 在所有 MySQL 提交中击败了100.00%的用户


# 相关知识
# https://www.cnblogs.com/winner-0715/p/6132838.html