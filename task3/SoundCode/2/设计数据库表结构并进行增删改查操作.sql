/*drop database test_db;
1、设计一个数据表，表名为t_students，分别含有stu_id，stu_name，stu_age，stu_gender,stu_adress等字段内容。
*/
drop database test_db;
create database test_db;

use test_db;

CREATE TABLE t_students (
    stu_id INT PRIMARY KEY AUTO_INCREMENT,
    stu_name VARCHAR(20),
    stu_age TINYINT DEFAULT 18,
    stu_gender CHAR DEFAULT '男',
    stu_adress VARCHAR(100) NULL
);


/*2、使用SQL语句向数据表写入十条不同的数据*/
insert into t_students(stu_name,stu_age,stu_gender,stu_adress) values('张三','20','男','广东'),
('李红红','22','女','北京'),
('周松','35','男','浙SELECT `studentinfo`.`id`,
    `studentinfo`.`nickname`,
    `studentinfo`.`name`,
    `studentinfo`.`gender`,
    `studentinfo`.`date`,
    `studentinfo`.`specialty`,
    `studentinfo`.`course`,
    `studentinfo`.`interset`,
    `studentinfo`.`remark`
FROM `jkxystudent`.`studentinfo`;
INSERT INTO `poem`.`tang`
(`id`,
`title`,
`author`,
`content`)
VALUES
(<{id: }>,
<{title: }>,
<{author: }>,
<{content: }>);
江'),
('李雅婷','45','女','上海'),
('唐李','60','女','西安'),
('张伯','55','男','西藏'),
('刘萱','33','女','香港'),
('刘莹','18','女','澳门'),
('古柏','25','男','珠海'),
('曾健','27','男','广州');


/* 3、使用SQL语句查询年龄大于15岁的男生 */
SELECT 
    *
FROM
    t_students
WHERE
    stu_age > 15 AND stu_gender = '男';
    
/*4、使用SQL语句删除所有男生的数据*/    

DELETE FROM t_students 
WHERE stu_gender = '男';

select stu_id,stu_name,stu_age,stu_gender,stu_adress from t_students where stu_age>15 and stu_gender='男'
