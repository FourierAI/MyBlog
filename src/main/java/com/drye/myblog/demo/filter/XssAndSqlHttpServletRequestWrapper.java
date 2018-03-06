package com.drye.myblog.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.regex.Pattern;

/**
 * @program: MyBlogVersion1
 * @description: 包装类
 * @author: GeekYe
 * @create: 2018-03-06 18:24
 **/
public class XssAndSqlHttpServletRequestWrapper  extends HttpServletRequestWrapper {
    public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public String[] getParameterValues(String parameter)
    {
        String[] values = super.getParameterValues(parameter);
        if (values==null)
        {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++)
        {
            encodedValues[i] = cleanXSS(values[i]);
        }
        return encodedValues;
    }

    @Override
    public String getParameter(String parameter)
    {
        String value = super.getParameter(parameter);
        if (value == null)
        {
            return null;
        }
        return cleanXSS(value);
    }

    @Override
    public String getHeader(String name)
    {
        String value = super.getHeader(name);
        if (value == null){
            return null;
        }
        return cleanXSS(value);
    }

    /**
     * @Title: cleanXSS
     * @Description: You'll need to remove the spaces from the html entities below
     * @param @param value
     * @param @return
     * @return String
     */
    private String cleanXSS(String value)
    {
        value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
        value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
        value = value.replaceAll("'", "& #39;");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("script", "");
        return value;
    }

}