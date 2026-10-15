# Write your MySQL query statement below
select name from salesperson where sales_id not in
(SELECT o.sales_id
    FROM orders as o
    JOIN company as c
    ON o.com_id = c.com_id
    WHERE c.name = 'RED')