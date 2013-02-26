/*
 * 描          述:  <描述>
 * 修  改   人:  
 * 修改时间:  
 * <修改描述:>
 */
package com.tx.component.rule.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tx.component.rule.dao.SimplePersistenceRuleDao;
import com.tx.component.rule.model.RuleType;
import com.tx.component.rule.model.SimplePersistenceRule;
import com.tx.core.exceptions.parameter.ParameterIsEmptyException;
import com.tx.core.paged.model.PagedList;

/**
 * SimplePersistenceRule的业务层
 * <功能详细描述>
 * 
 * @author  
 * @version  [版本号, ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component("simplePersistenceRuleService")
public class SimplePersistenceRuleService {
    
    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(SimplePersistenceRuleService.class);
    
    @SuppressWarnings("unused")
    //@Resource(name = "serviceLogger")
    private Logger serviceLogger;
    
    @Resource(name = "simplePersistenceRuleDao")
    private SimplePersistenceRuleDao simplePersistenceRuleDao;
    
    /**
     * 根据RuleType查询SimplePersistenceRule实体列表
     * 
     * <功能详细描述>
     * @return [参数说明]
     * 
     * @return List<SimplePersistenceRule> [返回类型说明]
     * @exception throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
    */
    public List<SimplePersistenceRule> querySimplePersistenceRuleListByRuleType(
            RuleType ruleType) {
        //判断条件合法性
        if (ruleType == null) {
            throw new ParameterIsEmptyException(
                    "SimplePersistenceRuleService.querySimplePersistenceRuleListByRuleType ruleType is empty.");
        }
        
        //生成查询条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ruleType", ruleType);
        
        //根据实际情况，填入排序字段等条件，根据是否需要排序，选择调用dao内方法
        List<SimplePersistenceRule> resList = this.simplePersistenceRuleDao.querySimplePersistenceRuleList(params);
        
        return resList;
    }
    
    /**
      * 根据Id查询SimplePersistenceRule实体
      * 1、当id为empty时返回null
      * <功能详细描述>
      * @param id
      * @return [参数说明]
      * 
      * @return SimplePersistenceRule [返回类型说明]
      * @exception throws 可能存在数据库访问异常DataAccessException
      * @see [类、类#方法、类#成员]
     */
    public SimplePersistenceRule findSimplePersistenceRuleById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        
        SimplePersistenceRule condition = new SimplePersistenceRule();
        condition.setId(id);
        return this.simplePersistenceRuleDao.findSimplePersistenceRule(condition);
    }
    
    /**
      * 根据SimplePersistenceRule实体列表
      * TODO:补充说明
      * 
      * <功能详细描述>
      * @return [参数说明]
      * 
      * @return List<SimplePersistenceRule> [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    public List<SimplePersistenceRule> querySimplePersistenceRuleList(/*TODO:自己定义条件*/) {
        //TODO:判断条件合法性
        
        //TODO:生成查询条件
        Map<String, Object> params = new HashMap();
        
        //TODO:根据实际情况，填入排序字段等条件，根据是否需要排序，选择调用dao内方法
        List<SimplePersistenceRule> resList = this.simplePersistenceRuleDao.querySimplePersistenceRuleList(params);
        
        return resList;
    }
    
    /**
     * 分页查询SimplePersistenceRule实体列表
     * TODO:补充说明
     * 
     * <功能详细描述>
     * @return [参数说明]
     * 
     * @return List<SimplePersistenceRule> [返回类型说明]
     * @exception throws [异常类型] [异常说明]
     * @see [类、类#方法、类#成员]
    */
    public PagedList<SimplePersistenceRule> querySimplePersistenceRulePagedList(
    /*TODO:自己定义条件*/int pageIndex, int pageSize) {
        //TODO:判断条件合法性
        
        //TODO:生成查询条件
        Map<String, Object> params = new HashMap<String, Object>();
        
        //TODO:根据实际情况，填入排序字段等条件，根据是否需要排序，选择调用dao内方法
        PagedList<SimplePersistenceRule> resPagedList = this.simplePersistenceRuleDao.querySimplePersistenceRulePagedList(params,
                pageIndex,
                pageSize);
        
        return resPagedList;
    }
    
    /**
      * 查询simplePersistenceRule列表总条数
      * TODO:补充说明
      * <功能详细描述>
      * @return [参数说明]
      * 
      * @return int [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    public int countSimplePersistenceRule(/*TODO:自己定义条件*/) {
        //TODO:判断条件合法性
        
        //TODO:生成查询条件
        Map<String, Object> params = new HashMap<String, Object>();
        
        //TODO:根据实际情况，填入排序字段等条件，根据是否需要排序，选择调用dao内方法
        int res = this.simplePersistenceRuleDao.countSimplePersistenceRule(params);
        
        return res;
    }
    
    /**
      * 将simplePersistenceRule实例插入数据库中保存
      * 1、如果simplePersistenceRule为空时抛出参数为空异常
      * 2、如果simplePersistenceRule中部分必要参数为非法值时抛出参数不合法异常
      * <功能详细描述>
      * @param simplePersistenceRule [参数说明]
      * 
      * @return void [返回类型说明]
      * @exception throws 可能存在数据库访问异常DataAccessException
      * @see [类、类#方法、类#成员]
     */
    @Transactional
    public void insertSimplePersistenceRule(
            SimplePersistenceRule simplePersistenceRule) {
        //TODO:验证参数是否合法，必填字段是否填写，
        //如果没有填写抛出parameterIsEmptyException,
        //如果有参数不合法ParameterIsInvalidException
        if (simplePersistenceRule == null /*TODO:|| 其他参数验证*/) {
            throw new ParameterIsEmptyException(
                    "SimplePersistenceRuleService.insertSimplePersistenceRule simplePersistenceRule isNull.");
        }
        
        this.simplePersistenceRuleDao.insertSimplePersistenceRule(simplePersistenceRule);
    }
    
    /**
      * 根据id删除simplePersistenceRule实例
      * 1、如果入参数为空，则抛出异常
      * 2、执行删除后，将返回数据库中被影响的条数
      * @param id
      * @return 返回删除的数据条数，<br/>
      * 有些业务场景，如果已经被别人删除同样也可以认为是成功的
      * 这里讲通用生成的业务层代码定义为返回影响的条数
      * @return int [返回类型说明]
      * @exception throws 可能存在数据库访问异常DataAccessException
      * @see [类、类#方法、类#成员]
     */
    @Transactional
    public int deleteById(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new ParameterIsEmptyException(
                    "SimplePersistenceRuleService.deleteById id isEmpty.");
        }
        
        SimplePersistenceRule condition = new SimplePersistenceRule();
        condition.setId(id);
        return this.simplePersistenceRuleDao.deleteSimplePersistenceRule(condition);
    }
    
    /**
      * 根据id更新对象
      * <功能详细描述>
      * @param simplePersistenceRule
      * @return [参数说明]
      * 
      * @return boolean [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    @Transactional
    public boolean updateById(SimplePersistenceRule simplePersistenceRule) {
        //TODO:验证参数是否合法，必填字段是否填写，
        //如果没有填写抛出parameterIsEmptyException,
        //如果有参数不合法ParameterIsInvalidException
        if (simplePersistenceRule == null
                || StringUtils.isEmpty(simplePersistenceRule.getId())) {
            throw new ParameterIsEmptyException(
                    "SimplePersistenceRuleService.updateById simplePersistenceRule or simplePersistenceRule.id is empty.");
        }
        
        //TODO:生成需要更新字段的hashMap
        Map<String, Object> updateRowMap = new HashMap<String, Object>();
        updateRowMap.put("id", simplePersistenceRule.getId());
        
        //TODO:需要更新的字段
        updateRowMap.put("ruleType", simplePersistenceRule.getRuleType());
        updateRowMap.put("rule", simplePersistenceRule.getRule());
        updateRowMap.put("state", simplePersistenceRule.getState());
        updateRowMap.put("serviceType", simplePersistenceRule.getServiceType());
        
        int updateRowCount = this.simplePersistenceRuleDao.updateSimplePersistenceRule(updateRowMap);
        
        //TODO:如果需要大于1时，抛出异常并回滚，需要在这里修改
        return updateRowCount >= 1;
    }
}