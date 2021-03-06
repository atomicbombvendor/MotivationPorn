package com.practice.motivationporn.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.practice.motivationporn.common.ResponseStatusEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应操作结果
 * <pre>
 *  {
 *      code： 错误码，
 *      message：错误消息，
 *      data：  响应数据
 *  }
 * </pre>
 *
 * <p>
 * 错误码：
 * <ul>
 * <li> 0，成功；
 * <li> 4xx，前端错误，说明前端开发者需要重新了解后端接口使用规范：
 * <ul>
 * <li> 401，参数错误，即前端没有传递后端需要的参数；
 * <li> 402，参数值错误，即前端传递的参数值不符合后端接收范围。
 * </ul>
 * <li> 5xx，后端错误，除501外，说明后端开发者应该继续优化代码，尽量避免返回后端错误码：
 * <ul>
 * <li> 501，验证失败，即后端要求用户登录；
 * <li> 502，系统内部错误，即没有合适命名的后端内部错误；
 * <li> 503，业务不支持，即后端虽然定义了接口，但是还没有实现功能；
 * <li> 504，更新数据失效，即后端采用了乐观锁更新，而并发更新时存在数据更新失效；
 * <li> 505，更新数据失败，即后端数据库更新失败（正常情况应该更新成功）。
 * </ul>
 * <li> 6xx，后端业务错误码，
 * 具体见litemall-admin-api模块的AdminResponseCode。
 * <li> 7xx，管理后台后端业务错误码，
 * 具体见litemall-wx-api模块的WxResponseCode。
 * </ul>
 */
public class ResponseUtil {
    public static Object ok() {
        Map<String, Object> obj = new HashMap<>(2);
        obj.put("code", ResponseStatusEnum.SUCCESS.getCode());
        obj.put("message", "成功");
        return obj;
    }

    public static Object ok(Object data) {

        Map<String, Object> obj = new HashMap<>(3);
        obj.put("code", ResponseStatusEnum.SUCCESS.getCode());
        obj.put("message", "success");
        obj.put("data", data);
        return obj;
    }

    public static Object result(Integer code, String message, Object data) {

        Map<String, Object> obj = new HashMap<>(3);
        obj.put("code", code);
        obj.put("message", message);
        obj.put("data", data);
        return obj;
    }

    public static Object result(ResponseStatusEnum statusEnum, Object data) {

        Map<String, Object> obj = new HashMap<>(3);
        obj.put("code", statusEnum.getCode());
        obj.put("message", statusEnum.getMsg());
        obj.put("data", data);
        return obj;
    }

    public static Object okList(List list) {

        Map<String, Object> data = new HashMap<>();
        data.put("list", list);

        if (list instanceof Page) {
            Page page = (Page) list;
            data.put("total", page.getTotal());
//            data.put("page", page.getPageNum());
//            data.put("limit", page.getPageSize());
            data.put("pages", page.getPages());
        } else {
            data.put("total", list.size());
            data.put("page", 1);
            data.put("limit", list.size());
            data.put("pages", 1);
        }

        return ok(data);
    }

    public static Object okList(List list, List pagedList) {

        Map<String, Object> data = new HashMap<>();
        data.put("list", list);

        if (pagedList instanceof Page) {
            Page page = (Page) pagedList;
            data.put("total", page.getTotal());
//            data.put("page", page.getPageNum());
//            data.put("limit", page.getPageSize());
            data.put("pages", page.getPages());
        } else {
            data.put("total", pagedList.size());
            data.put("page", 1);
            data.put("limit", pagedList.size());
            data.put("pages", 1);
        }

        return ok(data);
    }

    public static Object fail() {
        Map<String, Object> obj = new HashMap<>(2);
        obj.put("code", -1);
        obj.put("message", "错误");
        return obj;
    }

    public static Object fail(int errno, String message) {
        Map<String, Object> obj = new HashMap<>(2);
        obj.put("code", errno);
        obj.put("message", message);
        return obj;
    }
    public static Object fail(ResponseStatusEnum failStatus) {
        Map<String, Object> obj = new HashMap<>(2);
        obj.put("code", failStatus.getCode());
        obj.put("message", failStatus.getMsg());
        return obj;
    }
}

