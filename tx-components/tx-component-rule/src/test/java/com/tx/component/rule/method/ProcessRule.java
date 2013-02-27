/*
 * 描          述:  <描述>
 * 修  改   人:  PengQingyang
 * 修改时间:  2013-2-27
 * <修改描述:>
 */
package com.tx.component.rule.method;


 /**
  * <功能简述>
  * <功能详细描述>
  * 
  * @author  PengQingyang
  * @version  [版本号, 2013-2-27]
  * @see  [相关类/方法]
  * @since  [产品/模块版本]
  */
public class ProcessRule {
    
    private String name;
    
    /** <默认构造函数> */
    public ProcessRule(String name) {
        this.name = name;
    }

    /**
     * @return 返回 name
     */
    public String getName() {
        return name;
    }

    /**
     * @param 对name进行赋值
     */
    public void setName(String name) {
        this.name = name;
    }
}
