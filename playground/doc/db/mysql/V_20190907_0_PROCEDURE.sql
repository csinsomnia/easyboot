# DELIMITER $$
#
# DROP PROCEDURE IF EXISTS `feidou`.`getEmp` $$
# CREATE PROCEDURE `feidou`.`getEmp`(IN empid INT)
# BEGIN
#     SELECT *
#     FROM EMPLOYEE
#     WHERE ID = empid;
# END $$
# DELIMITER ;


#DbVisualizer里面定义分隔符  使用的是 @delimiter 使用DELIMITER会出现语法错误
-- DELIMITER定义分隔符(//, $$),防止以下内容被误认为是SQL语句

@delimiter %%%;
DROP PROCEDURE IF EXISTS `feidou`.`getEmp` $$
CREATE PROCEDURE `feidou`.`getEmp`(IN empid INT)
BEGIN
    SELECT *
    FROM EMPLOYEE
    WHERE ID = empid;

END;
%%%
@delimiter ;
%%%



@delimiter $$;
DROP PROCEDURE IF EXISTS `feidou`.`getEmp1` $$
CREATE PROCEDURE `feidou`.`getEmp1`(IN empid INT)
BEGIN
    SELECT *
    FROM EMPLOYEE
    WHERE ID = empid;
END;
$$
@delimiter ;
$$



