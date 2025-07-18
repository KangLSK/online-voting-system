USE voting_system;

-- 查詢所有投票項目及其票數
DELIMITER $$
CREATE PROCEDURE get_all_vote_items()
BEGIN
    SELECT vi.id, vi.name, COUNT(vr.id) AS voteCount
    FROM vote_item vi
             LEFT JOIN vote_record vr ON vi.id = vr.item_id
    GROUP BY vi.id, vi.name;
END$$
DELIMITER ;

-- 新增投票紀錄
DELIMITER $$
CREATE PROCEDURE insert_vote(IN voterName VARCHAR(100), IN itemId INT)
BEGIN
    INSERT INTO vote_record (voter, item_id) VALUES (voterName, itemId);
END$$
DELIMITER ;

-- 新增投票項目
DELIMITER $$
CREATE PROCEDURE insert_vote_item(IN itemName VARCHAR(100))
BEGIN
    INSERT INTO vote_item (name) VALUES (itemName);
END$$
DELIMITER ;

-- 刪除投票項目及相關投票紀錄
DELIMITER $$
CREATE PROCEDURE delete_vote_item(IN itemId INT)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            ROLLBACK;
        END;

    START TRANSACTION;
    DELETE FROM vote_record WHERE item_id = itemId;
    DELETE FROM vote_item WHERE id = itemId;
    COMMIT;
END$$
DELIMITER ;
