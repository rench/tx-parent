/*
 * 描          述:  <描述>
 * 修  改   人:  
 * 修改时间:  
 * <修改描述:>
 */
package com.tx.component.rule.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.tx.component.rule.dao.SimpleRulePropertyByteDao;
import com.tx.component.rule.model.SimpleRuleParamEnum;
import com.tx.component.rule.model.SimpleRulePropertyByte;
import com.tx.core.exceptions.argument.NullArgException;

/**
 * SimpleRulePropertyByte的业务层
 * <功能详细描述>
 * 
 * @author  
 * @version  [版本号, ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component("simpleRulePropertyByteService")
public class SimpleRulePropertyByteService {
    
    @SuppressWarnings("unused")
    private Logger logger = LoggerFactory.getLogger(SimpleRulePropertyByteService.class);
    
    @SuppressWarnings("unused")
    //@Resource(name = "serviceLogger")
    private Logger serviceLogger;
    
    @Resource(name = "simpleRulePropertyByteDao")
    private SimpleRulePropertyByteDao simpleRulePropertyByteDao;
    
    /**
      * 根据SimpleRulePropertyByte实体列表
      *     1、根据规则id查询对应的规则属性值映射map
      * 
      * <功能详细描述>
      * @return [参数说明]
      * 
      * @return List<SimpleRulePropertyByte> [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    public MultiValueMap<SimpleRuleParamEnum, SimpleRulePropertyByte> querySimpleRulePropertyByteMultiMap(
            String ruleId) {
        if (StringUtils.isEmpty(ruleId)) {
            throw new NullArgException("ruleId is emtpy.");
        }
        
        //生成查询条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ruleId", ruleId);
        
        //根据实际情况，填入排序字段等条件，根据是否需要排序，选择调用dao内方法
        List<SimpleRulePropertyByte> resList = this.simpleRulePropertyByteDao.querySimpleRulePropertyByteList(params);
        
        //返回的map映射
        MultiValueMap<SimpleRuleParamEnum, SimpleRulePropertyByte> resMap = new LinkedMultiValueMap<SimpleRuleParamEnum, SimpleRulePropertyByte>();
        if (resList != null) {
            //排序
            Collections.sort(resList);
            for (SimpleRulePropertyByte srpbTemp : resList) {
                //压入multiMap
                resMap.add(srpbTemp.getSimpleRulePropertyParam(), srpbTemp);
            }
        }
        return resMap;
    }
    
    /**
      * 保存规则属性值
      * <功能详细描述>
      * @param propertyValuesMap [参数说明]
      * 
      * @return void [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
     */
    @Transactional
    public void saveSimpleRulePropertyByte(String ruleId,
            MultiValueMap<SimpleRuleParamEnum, SimpleRulePropertyByte> propertyValuesMap){
        if (StringUtils.isEmpty(ruleId)) {
            throw new NullArgException(
                    "ruleId is empty.");
        }
        
        if(propertyValuesMap == null || propertyValuesMap.size() == 0){
            return ;
        }
        
        List<SimpleRulePropertyByte> addByteProValueList = new ArrayList<SimpleRulePropertyByte>();
        //如果存在需要插入的数据
        for(Entry<SimpleRuleParamEnum, List<SimpleRulePropertyByte>> entryTemp : propertyValuesMap.entrySet()){
            SimpleRuleParamEnum paramTemp = entryTemp.getKey();
            List<SimpleRulePropertyByte> byteListTemp = entryTemp.getValue();
            //如果对应的链为空,或size为0
            if(byteListTemp == null || byteListTemp.size() == 0){
                continue;
            }
            //如果只有单值
            if(byteListTemp.size() == 1){
                SimpleRulePropertyByte byteTemp = byteListTemp.get(0);
                byteTemp.setRuleId(ruleId);
                byteTemp.setParamKey(paramTemp.getKey());
                byteTemp.setParamValueOrdered(0);
                byteTemp.setSimpleRulePropertyParam(paramTemp);
                
                addByteProValueList.add(byteTemp);
            }else{
                int newIndex = 0;
                for(SimpleRulePropertyByte byteTemp : byteListTemp){
                    byteTemp.setRuleId(ruleId);
                    byteTemp.setParamKey(paramTemp.getKey());
                    byteTemp.setParamValueOrdered(newIndex++);
                    byteTemp.setSimpleRulePropertyParam(paramTemp);
                    
                    addByteProValueList.add(byteTemp);
                }
            }
        }
        //数据库进行持久
        deleteByRuleId(ruleId);
        this.simpleRulePropertyByteDao.batchInsertSimpleRulePropertyByte(addByteProValueList);
    }
    
    /**
      * 根据ruleId删除simpleRulePropertyByte实例
      * 1、如果入参数为空，则抛出异常
      * 2、执行删除后，将返回数据库中被影响的条数
      * @param ruleId
      * @return 返回删除的数据条数，<br/>
      * 有些业务场景，如果已经被别人删除同样也可以认为是成功的
      * 这里讲通用生成的业务层代码定义为返回影响的条数
      * @return int [返回类型说明]
      * @exception throws 可能存在数据库访问异常DataAccessException
      * @see [类、类#方法、类#成员]
     */
    @Transactional
    public int deleteByRuleId(String ruleId) {
        if (StringUtils.isEmpty(ruleId)) {
            throw new NullArgException(
                    "SimpleRulePropertyByteService.deleteByRuleId ruleId isEmpty.");
        }
        
        SimpleRulePropertyByte condition = new SimpleRulePropertyByte();
        condition.setRuleId(ruleId);
        return this.simpleRulePropertyByteDao.deleteSimpleRulePropertyByte(condition);
    }
}
