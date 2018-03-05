DELIMITER $$
DROP PROCEDURE IF EXISTS  test_sp1 $$
CREATE PROCEDURE test_sp1( )
    BEGIN
    DECLARE t_error INTEGER DEFAULT 0;
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;

        START TRANSACTION;
            INSERT INTO test VALUES(NULL, 'test sql 001');
            INSERT INTO test VALUES('1', 'test sql 002');

        IF t_error = 1 THEN
            ROLLBACK;
        ELSE
            COMMIT;
        END IF;

    END$$
DELIMITER ;