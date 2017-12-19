INSERT INTO `cms_user_info` VALUES (1, 'admin', '管理员', 'd0970714757783e6cf17b26fb8e2298f', '测试备注', 'admin', '2017-12-8 20:32:02', 'admin', '2017-12-8 20:32:09', 0, 1);
INSERT INTO `cms_user_info` VALUES (2, '17040406', '张三', 'd0970714757783e6cf17b26fb8e2298f', '测试备注', 'admin', '2017-12-8 20:32:02', 'admin', '2017-12-8 20:32:09', 1, 1);

INSERT INTO `cms_role_info` VALUES (1, 'admin', '系统管理员', 'admin', '2017-12-8 19:06:35', 'admin', '2017-12-8 19:06:39', 0, 1);
INSERT INTO `cms_role_info` VALUES (2, 'guest', '客人', 'admin', '2017-12-8 19:06:35', 'admin', '2017-12-8 19:06:35', 1, 1);

INSERT INTO `cms_user_role_r` VALUES (1, 'admin', 'admin', 'admin', '2017-12-8 20:19:34', 'admin', '2017-12-8 20:19:34', 0, 1);
INSERT INTO `cms_user_role_r` VALUES (2, '17040406', 'guest', 'admin', '2017-12-8 20:19:34', 'admin', '2017-12-8 20:19:34', 0, 1);

INSERT INTO `cms_function_info` VALUES (1, '1', '系统管理', '-1', '', 0, 'admin', '2017-12-8 20:25:00', 'admin', '2017-12-8 20:25:00', 0, 1);
INSERT INTO `cms_function_info` VALUES (2, '1-1', '用户管理', '1', '', 1, 'admin', '2017-12-8 20:25:00', 'admin', '2017-12-8 20:25:00', 0, 1);
INSERT INTO `cms_function_info` VALUES (3, '1-2', '角色管理', '1', '', 1, 'admin', '2017-12-8 20:25:00', 'admin', '2017-12-8 20:25:00', 1, 1);
INSERT INTO `cms_function_info` VALUES (4, '2', '客人测试', '-1', '', 0, 'admin', '2017-12-8 20:25:00', 'admin', '2017-12-8 20:25:00', 1, 1);
INSERT INTO `cms_function_info` VALUES (5, '2-1', '权限测试', '4', '', 1, 'admin', '2017-12-8 20:25:00', 'admin', '2017-12-8 20:25:00', 0, 1);
