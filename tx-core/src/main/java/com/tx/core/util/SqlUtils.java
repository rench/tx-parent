/*
 * 描          述:  <描述>
 * 修  改   人:  brady
 * 修改时间:  2013-4-2
 * <修改描述:>
 */
package com.tx.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

/**
 * sql工具类
 * <功能详细描述>
 * 
 * @author  brady
 * @version  [版本号, 2013-4-2]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SqlUtils {
    
    /**
      * 对sql进行处理放置sql注入
      * <功能详细描述>
      * @param srcSql
      * @return [参数说明]
      * 
      * @return String [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    public static String escapeSql(String srcSql) {
        String newSql = StringEscapeUtils.escapeSql(srcSql);
        return newSql;
    }
    
    /**
      * 将sqlContent依据';\s' '/\s'进行分割，分割为多个sql语句
      *     但字符中的特殊符号要允许输入
      *     服务于，读取sql文件后，逐句sql进行执行 
      *<功能详细描述>
      * @param srcSqlContent
      * @return [参数说明]
      * 
      * @return String [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    public static List<String> splitSqlContent(String srcSqlContent) {
        if (StringUtils.isBlank(srcSqlContent)) {
            return new ArrayList<String>();
        }
        String[] res = srcSqlContent.split("[;/]\\s|[;/]$");
        List<String> resList = new ArrayList<String>(res.length);
        for (String sqlTemp : res) {
            if (!StringUtils.isBlank(sqlTemp)) {
                resList.add(sqlTemp);
            }
        }
        return resList;
    }
    
    public static void main(String[] args) {
        String sqlContent = "create table \n (id_ " +
        		"varchar2(32));\n create index xxx;\n/ " +
        		"insert into (id) valuse ('absdsdf;dsfasd;asdf');\n " +
        		"insert into(id) values('test');";
        
        List<String> res = splitSqlContent(sqlContent);
        for (String temp : res) {
            System.out.print("   newSql:");
            System.out.println(temp);
        }
    }
}
