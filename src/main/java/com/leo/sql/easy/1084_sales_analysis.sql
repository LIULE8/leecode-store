# 1084. 销售分析III
# Table: Product
#
# +--------------+---------+
# | Column Name  | Type    |
# +--------------+---------+
# | product_id   | int     |
# | product_name | varchar |
# | unit_price   | int     |
# +--------------+---------+
# product_id 是这个表的主键
# Table: Sales
#
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | seller_id   | int     |
# | product_id  | int     |
# | buyer_id    | int     |
# | sale_date   | date    |
# | quantity    | int     |
# | price       | int     |
# +------ ------+---------+
# 这个表没有主键，它可以有重复的行.
# product_id 是 Product 表的外键.
#
#
# 编写一个SQL查询，报告2019年春季才售出的产品。即仅在2019-01-01至2019-03-31（含）之间出售的商品。
#
# 查询结果格式如下所示：
#
# Product table:
# +------------+--------------+------------+
# | product_id | product_name | unit_price |
# +------------+--------------+------------+
# | 1          | S8           | 1000       |
# | 2          | G4           | 800        |
# | 3          | iPhone       | 1400       |
# +------------+--------------+------------+
#
# Sales table:
# +-----------+------------+----------+------------+----------+-------+
# | seller_id | product_id | buyer_id | sale_date  | quantity | price |
# +-----------+------------+----------+------------+----------+-------+
# | 1         | 1          | 1        | 2019-01-21 | 2        | 2000  |
# | 1         | 2          | 2        | 2019-02-17 | 1        | 800   |
# | 2         | 2          | 3        | 2019-06-02 | 1        | 800   |
# | 3         | 3          | 4        | 2019-05-13 | 2        | 2800  |
# +-----------+------------+----------+------------+----------+-------+
#
# Result table:
# +-------------+--------------+
# | product_id  | product_name |
# +-------------+--------------+
# | 1           | S8           |
# +-------------+--------------+
# id为1的产品仅在2019年春季销售，其他两个产品在之后销售。


# 执行用时：871 ms, 在所有 MySQL 提交中击败了39.66%的用户
# 内存消耗：0B, 在所有 MySQL 提交中击败了100.00%的用户
select p.product_id, p.product_name
from Product p inner join (select s.product_id
                           from Sales s
                           group by s.product_id
                           having max(s.sale_date) <= '2019-03-31'
                               and min(s.sale_date) >= '2019-01-01') b on p.product_id = b.product_id;


