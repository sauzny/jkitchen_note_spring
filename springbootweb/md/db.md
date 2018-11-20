# 数据库相关

- 主键设计，int
  - 自增，int还是bigint？int的最大值是20亿+，对我的表来说足够大了
- 时间类型使用，datetime(3)，可以精确到毫秒
  - datetime，1000-01-01 00:00:00 ~ 9999-12-31 23:59:59
  - timestamp，1970-01-01 08:00:01 ~ 2038-01-19 11:14:07，实际存储的是按照UTC时间，查询返回的结果会按照数据库的时区进行转换。
  - long，纯数字
  - 从MySQL 5.6.5开始，Automatic Initialization and Updating同时适用于TIMESTAMP和DATETIME，且不限制数量。更新的字段不能精确到毫秒(3)
