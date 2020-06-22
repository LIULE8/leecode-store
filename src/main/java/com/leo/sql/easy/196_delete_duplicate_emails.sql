# 196. 删除重复的电子邮箱

# 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# Id 是这个表的主键。
# 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
#
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+
#  
#
# 提示： 执行 SQL 之后，输出是整个 Person 表。


# mysql中You can't specify target table for update in FROM clause错误的意思是说，不能先select出同一表中的某些值，再update这个表(在同一语句中)
delete from person where Id not in (select min(Id)
                                    from Person
                                    group by email);

# sql 修改如下
delete from person where Id not in (select Pm.Id from (select min(Id) as Id
                                                     from Person
                                                     group by email) Pm);
# 执行用时：1176 ms, 在所有 MySQL 提交中击败了54.72%的用户
# 内存消耗：0B, 在所有 MySQL 提交中击败了100.00%的用户