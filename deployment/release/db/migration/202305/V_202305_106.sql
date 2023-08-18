/**
 * 目的: 新建表 t_monkey_article 文章表
 */
CREATE TABLE IF NOT EXISTS `t_panda_article`  (
    `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
    `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文章标题',
    `article` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '文章内容',
    `audit` tinyint UNSIGNED NULL DEFAULT 1 COMMENT '审核字段；\r\n1：审核中；\r\n2：审核通过；\r\n3：审核不通过',
    `deleted` tinyint NULL DEFAULT 0 COMMENT '逻辑删除',
    `created_time` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
    `updated_time` datetime(6) NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文章表' ROW_FORMAT = Dynamic;