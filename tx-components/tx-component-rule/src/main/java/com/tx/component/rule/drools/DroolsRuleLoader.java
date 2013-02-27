/*
 * 描          述:  <描述>
 * 修  改   人:  PengQingyang
 * 修改时间:  2013-2-28
 * <修改描述:>
 */
package com.tx.component.rule.drools;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.tx.component.rule.context.RuleLoader;
import com.tx.component.rule.model.Rule;


 /**
  * <功能简述>
  * <功能详细描述>
  * 
  * @author  PengQingyang
  * @version  [版本号, 2013-2-28]
  * @see  [相关类/方法]
  * @since  [产品/模块版本]
  */
public class DroolsRuleLoader implements RuleLoader,ApplicationContextAware{
    
    private ApplicationContext applicationContext;
    
    /**
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * @return
     */
    @Override
    public List<Rule> load() {
        
        return null;
    }
    
}
