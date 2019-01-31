# 使用spring validation完成数据后端校验

## 一、两种校验方式

- 在@Controller中框架集成自动校验数据 `com.sauzny.sbvalidationdemo.controller.Foo01Controller`
- 自定义ValidatorUtil手动校验数据 `com.sauzny.sbvalidationdemo.test.ValidatorTest`

## 二、延伸用法

- 分组验证 `com.sauzny.sbvalidationdemo.controller.Foo01Controller`，对比其中的两个方法
- 自定义注解，自定义校验 `com.sauzny.sbvalidationdemo.test.ValidatorTest`，其中 `StudentInfo` 的 `money` 属性

## 三、校验注解

### JSR提供的校验注解：

注解 | 意义
-- | --
@Null | 被注释的元素必须为 null
@NotNull | 被注释的元素必须不为 null
@AssertTrue | 被注释的元素必须为 true
@AssertFalse | 被注释的元素必须为 false
@Min(value) | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value) | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value) | 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value) | 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max=, min=) | 被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction) | 被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past | 被注释的元素必须是一个过去的日期
@Future | 被注释的元素必须是一个将来的日期
@Pattern(regex=,flag=) | 被注释的元素必须符合指定的正则表达式

### Hibernate Validator提供的校验注解：

注解 | 意义
-- | --
@NotBlank(message =) | 验证字符串非null，且长度必须大于0
@Email | 被注释的元素必须是电子邮箱地址
@Length(min=,max=) | 被注释的字符串的大小必须在指定的范围内
@NotEmpty |  被注释的字符串的必须非空
@Range(min=,max=,message=) | 被注释的元素必须在合适的范围内
