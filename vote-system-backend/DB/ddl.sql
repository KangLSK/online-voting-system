CREATE DATABASE IF NOT EXISTS voting_system;
USE voting_system;

-- 建立投票項目表
CREATE TABLE vote_item (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(100) NOT NULL
);

-- 建立投票紀錄表
CREATE TABLE vote_record (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             voter VARCHAR(100) NOT NULL,
                             item_id INT NOT NULL,
                             vote_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (item_id) REFERENCES vote_item(id)
);

