# Write your MySQL query statement below
select d.name as Department, e.name as Employee, Salary from employee as e join department as d on e.departmentId = d.id WHERE (e.departmentId, e.salary) IN (
    SELECT departmentId, MAX(salary)
    FROM Employee
    GROUP BY departmentId
);