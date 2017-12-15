package com.pf.org.cms.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: pf
 * @Date: 2017/12/13 16:40
 * @Description:
 */
public class ParamUtils {

    public static Map<String, Object> handleServletParameter(HttpServletRequest request) {
        Map<String, String[]> parameter = request.getParameterMap();
        Map<String, Object> rParams = new HashMap<String, Object>(0);
        for (Map.Entry<String, String[]> m : parameter.entrySet()) {
            String key = m.getKey();
            String[] obj = parameter.get(key);
            rParams.put(key, (obj.length > 1) ? obj : obj[0]);
        }
        return rParams;
    }
}
