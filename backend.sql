-- 创建数据库
CREATE DATABASE IF NOT EXISTS warehouse_management;
USE warehouse_management;

-- 1. 用户表（简化版）
CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `username` varchar(50) NOT NULL, -- 登录用户名
                        `password` varchar(100) NOT NULL, -- 密码
                        `name` varchar(50) NOT NULL, -- 真实姓名
                        `role` varchar(20) NOT NULL, -- 角色：ADMIN/OPERATOR
                        `phone` varchar(20) DEFAULT NULL,
                        `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uk_username` (`username`) -- 用户名不能重复
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2. 商品表（直接用category字段表示分类，无需单独表）
CREATE TABLE `product` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `code` varchar(30) NOT NULL, -- 商品编码
                           `name` varchar(100) NOT NULL, -- 商品名称
                           `category` varchar(50) NOT NULL, -- 直接存储分类名称（如"电子设备"）
                           `specification` varchar(200) DEFAULT NULL, -- 规格
                           `unit` varchar(20) DEFAULT NULL, -- 单位（台/个）
                           `warning_stock` int DEFAULT 10, -- 库存预警值
                           `status` tinyint DEFAULT 1, -- 1-启用，0-禁用
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `uk_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3. 仓库表
CREATE TABLE `warehouse` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(100) NOT NULL, -- 仓库名称
                             `location` varchar(200) DEFAULT NULL, -- 位置
                             `manager` varchar(50) DEFAULT NULL, -- 管理员
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. 库存表（商品在仓库中的库存）
CREATE TABLE `inventory` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `product_id` bigint NOT NULL, -- 关联商品
                             `warehouse_id` bigint NOT NULL, -- 关联仓库
                             `quantity` int NOT NULL DEFAULT 0, -- 库存数量
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `uk_product_warehouse` (`product_id`,`warehouse_id`) -- 同一商品在同一仓库唯一
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 5. 出入库记录表
CREATE TABLE `inventory_record` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `record_no` varchar(50) NOT NULL, -- 记录编号
                                    `product_id` bigint NOT NULL, -- 商品
                                    `warehouse_id` bigint NOT NULL, -- 仓库
                                    `quantity` int NOT NULL, -- 数量（正数入库，负数出库）
                                    `type` varchar(10) NOT NULL, -- IN-入库，OUT-出库
                                    `reason` varchar(200) DEFAULT NULL, -- 原因
                                    `operator_id` bigint NOT NULL, -- 操作人（关联user表id）
                                    `operate_time` datetime DEFAULT CURRENT_TIMESTAMP, -- 操作时间
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `uk_record_no` (`record_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入数据（简化版）
-- 1. 用户表（密码明文存储，方便测试）
INSERT INTO `user` (`username`, `password`, `name`, `role`, `phone`) VALUES
                                                                         ('admin', '123456', '管理员', 'ADMIN', '13800138000'),
                                                                         ('operator', '123456', '操作员', 'OPERATOR', '13900139000');

-- 2. 商品表（直接带分类字段）
INSERT INTO `product` (`code`, `name`, `category`, `specification`, `unit`, `warning_stock`) VALUES
                                                                                                 ('ELEC-001', '笔记本电脑', '电子设备', '联想小新 16G', '台', 5),
                                                                                                 ('ELEC-002', '键盘', '电脑配件', '机械青轴', '个', 10),
                                                                                                 ('ELEC-003', '鼠标', '电脑配件', '无线', '个', 15),
                                                                                                 ('OFFICE-001', '打印机', '办公设备', '惠普M1136', '台', 3),
                                                                                                 ('OFFICE-002', 'A4纸', '办公耗材', '70g 500张', '包', 20);

-- 3. 仓库表
INSERT INTO `warehouse` (`name`, `location`, `manager`) VALUES
                                                            ('主仓库', '北京市海淀区', '张三'),
                                                            ('备用仓库', '北京市朝阳区', '李四');

-- 4. 库存表
INSERT INTO `inventory` (`product_id`, `warehouse_id`, `quantity`) VALUES
                                                                       (1, 1, 20), -- 笔记本电脑在主仓库20台
                                                                       (1, 2, 5),  -- 笔记本电脑在备用仓库5台
                                                                       (2, 1, 30), -- 键盘在主仓库30个
                                                                       (3, 1, 45), -- 鼠标在主仓库45个
                                                                       (4, 1, 8),  -- 打印机在主仓库8台
                                                                       (5, 1, 100); -- A4纸在主仓库100包

-- 5. 出入库记录
INSERT INTO `inventory_record` (`record_no`, `product_id`, `warehouse_id`, `quantity`, `type`, `reason`, `operator_id`) VALUES
                                                                                                                            ('IN-20231001-001', 1, 1, 10, 'IN', '采购入库', 1),
                                                                                                                            ('OUT-20231002-001', 1, 1, -2, 'OUT', '销售', 2),
                                                                                                                            ('IN-20231003-001', 1, 1, 12, 'IN', '补货', 2),
                                                                                                                            ('OUT-20231005-001', 4, 1, -1, 'OUT', '领用', 2);
