select * from user_session;

select * from session;

truncate table session;

select * from user LEFT JOIN user_role ON user.NAME = 'pcl' and user.ID = user_role.USER_ID;


    ;

select * from  (select id,NAME,password from user where name='pcl') u LEFT JOIN user_role ur
    ON u.ID = ur.USER_ID;


#查询单个用户的所有信息
select DISTINCT USER_ID,a.user_name,ROLE_ID,role_name,PERMISSIONS_ID,PERMISSIONS_NAME
from (
    select USER_ID,u.name as user_name,r.ID as ROLE_ID,r.NAME as role_name,PERMISSIONS_ID,p.name as PERMISSIONS_NAME
    from user u,user_role ur,role r,permissions p ,role_permissions rp
    where u.NAME ='pcl' and u.ID = ur.USER_ID and r.ID = rp.ROLE_ID and p.ID = rp.PERMISSIONS_ID
    ) a;