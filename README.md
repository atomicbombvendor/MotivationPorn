# MotivationPorn
> 毒鸡汤个人网站项目

## 设想
1. 仿 http://www.nows.fun/

## 系统设计
1. spring-boot + spring-security
2. mangoDB
    1. 使用mangoDB数据先存储在内存中，在持久化到硬盘的特性。方便查询
    2. 使用mangoDB的内嵌模型，保存每条毒鸡汤的评论
    3. 使用mangoDB的引用模型，保存毒鸡汤的用户
3. Vue.js作为前端框架
    1. 为了练手
4. 后端UI界面，使用thymleaf或者其他后台管理
    1. http://x.xuebingsi.com/x-admin/v2.2/
