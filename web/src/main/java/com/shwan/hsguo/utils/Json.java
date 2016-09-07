package com.shwan.hsguo.utils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
public class Json {
    // 全局共享，重复使用效率更好
    public static ObjectMapper mapper = new ObjectMapper();
    /**
     * 将对象转为JSON字符串
     *
     * @param obj
     * @return
     */
    public static String objToJsonString(Object obj) {
        String s = null;
        try {
            s = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
     * 输出Map Json数据
     *
     * @param response
     * @param result
     */
    public static void outPutMap(HttpServletResponse response, Map result) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(objToJsonString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.flush();
            printWriter.close();
        }
    }
    /**
     * 输出Object Json数据
     *
     * @param response
     * @param result
     */
    public static void outPutObject(HttpServletResponse response, Object result) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
            printWriter.print(objToJsonString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.flush();
            printWriter.close();
        }
    }
    /**
     * JSON到Map转化
     *
     * @param url
     * @return
     */
    public static Map jsonStringToMap(String srcStr) throws Exception {
        Map map = null;
        if (srcStr != null && !"".equals(srcStr))
            map = mapper.readValue(srcStr, TypeFactory.type(Map.class));
        return map;
    }
    /**
     * JSON到LIST转化
     *
     * @param url
     * @return
     */
    public static List jsonStringToList(String content) throws Exception {
        List list = null;
        list = mapper.readValue(content, TypeFactory.type(List.class));
        return list;
    }

}
