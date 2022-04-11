create database ssm;

use ssm;

CREATE TABLE `books`
(
    `bookID`     int(0) NOT NULL AUTO_INCREMENT COMMENT '书id',
    `bookName`   varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书名',
    `bookCounts` int(0) NOT NULL COMMENT '数量',
    `detail`     varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
    INDEX        `bookID`(`bookID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


INSERT INTO `books`
VALUES (1, 'Java', 100, '从入门到放弃');
INSERT INTO `books`
VALUES (2, 'MySQL', 10, '从删库到跑路');
INSERT INTO `books`
VALUES (3, 'Linux', 5, '从进门到进牢');