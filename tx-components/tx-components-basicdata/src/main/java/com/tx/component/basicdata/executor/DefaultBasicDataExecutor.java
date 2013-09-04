/*
 * 描          述:  <描述>
 * 修  改   人:  brady
 * 修改时间:  2013-9-2
 * <修改描述:>
 */
package com.tx.component.basicdata.executor;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.reflection.MetaClass;
import org.hibernate.dialect.Dialect;

import com.tx.component.basicdata.annotation.BasicDataExecutorSQL;
import com.tx.component.basicdata.context.BasicData;
import com.tx.component.basicdata.model.PropertyItemInfo;
import com.tx.core.exceptions.util.AssertUtils;
import com.tx.core.exceptions.util.ExceptionWrapperUtils;
import com.tx.core.paged.model.PagedList;
import com.tx.core.reflection.ReflectionUtils;
import com.tx.core.reflection.exception.ReflectionException;

/**
 * 基础数据容器默认执行器<br/>
 * <功能详细描述>
 * 
 * @author  brady
 * @version  [版本号, 2013-9-2]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class DefaultBasicDataExecutor<T> extends BaseBasicDataExecutor<T> {
    
    private BasicData<T> basicData;
    
    private Dialect dialect;
    
    private String findSql;
    
    private String countSql;
    
    private String insertSql;
    
    private String deleteSql;
    
    private String updateSql;
    
    private String querySql;
    
    /** <默认构造函数> */
    public DefaultBasicDataExecutor(DataSource dataSource, Class<T> type) {
        super(dataSource, type);
        
        for(PropertyItemInfo propertyTemp : basicData.getPropertyItemInfoList()){
            
        }
        
        if(type.isAnnotationPresent(BasicDataExecutorSQL.class)){
            initByBasicDataExecutorSQL(type);
        }else{
            
        }
    }
    
     /** 
      *<功能简述>
      *<功能详细描述>
      * @param type [参数说明]
      * 
      * @return void [返回类型说明]
      * @exception throws [异常类型] [异常说明]
      * @see [类、类#方法、类#成员]
      */
    private void initByBasicDataExecutorSQL(Class<T> type) {
        BasicDataExecutorSQL basicDataExecutorSQL = type.getAnnotation(BasicDataExecutorSQL.class);
        if(basicDataExecutorSQL != null){
            this.findSql = basicDataExecutorSQL.findSql();
            this.querySql = basicDataExecutorSQL.querySql();
            this.insertSql = basicDataExecutorSQL.insertSql();
            this.deleteSql = basicDataExecutorSQL.deleteSql();
            this.updateSql = basicDataExecutorSQL.updateSql();
            this.countSql = basicDataExecutorSQL.countSql();
        }
    }
    
    /**
     * @param pk
     * @return
     */
    @Override
    protected T doGet(String pk) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * @param obj
     * @return
     */
    @Override
    protected T doFind(T obj) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * @param params
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    protected PagedList<T> doQueryPagedList(Map<String, Object> params,
            int pageIndex, int pageSize) {
        return null;
    }
    
    /**
     * @param params
     * @return
     */
    @Override
    protected List<T> doQuery(Map<String, Object> params) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * @param params
     * @return
     */
    @Override
    protected int doCount(Map<String, Object> params) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    /**
     * @param obj
     */
    
    @SuppressWarnings("unchecked")
    @Override
    protected void doInsert(T obj) {
        Map<String, Object> objMap = null;
        try {
            objMap = BeanUtils.describe(obj);
        } catch (Exception e) {
            throw ExceptionWrapperUtils.wrapperSILException(ReflectionException.class,
                    "BeanUtils.describe exception:{},obj:{}",
                    e,
                    obj);
        }
        getNamedJdbcTemplate().update(insertSql, objMap);
    }
    
    /**
     * @param params
     * @return
     */
    @Override
    protected int doUpdate(Map<String, Object> params) {
        int res = getNamedJdbcTemplate().update(updateSql, params);
        return res;
    }
    
    /**
     * @param params
     * @return
     */
    @Override
    protected int doDelete(Map<String, Object> params) {
        int res = getNamedJdbcTemplate().update(deleteSql, params);
        return res;
    }
}