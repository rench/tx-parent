/*
 * 描          述:  <描述>
 * 修  改   人:  brady
 * 修改时间:  2013-9-22
 * <修改描述:>
 */
package com.tx.component.servicelog.defaultimpl;

import java.util.Date;


 /**
  * 基础业务日志类
  * <功能详细描述>
  * 
  * @author  brady
  * @version  [版本号, 2013-9-22]
  * @see  [相关类/方法]
  * @since  [产品/模块版本]
  */
public class BaseServiceLog implements ServiceLog{
    
    /** 业务日志id */
    private String id;
    
    /** 当前操作员虚中心id,允许为空 */
    private String vcid;
    
    /** 当前组织id,允许为空 */
    private String organizationId;
    
    /** 当前操作人员,允许为空 */
    private String operatorId;
    
    /** 访问客户端ip地址 */
    private String clientIpAddress;
    
    /** 业务日志记录时间 */
    private Date createDate;
    
    /** 业务日志消息体 */
    private String message;
    
    /**
     * @return 返回 message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param 对message进行赋值
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return 返回 id
     */
    public String getId() {
        return id;
    }

    /**
     * @param 对id进行赋值
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return 返回 vcid
     */
    public String getVcid() {
        return vcid;
    }

    /**
     * @param 对vcid进行赋值
     */
    public void setVcid(String vcid) {
        this.vcid = vcid;
    }

    /**
     * @return 返回 organizationId
     */
    public String getOrganizationId() {
        return organizationId;
    }

    /**
     * @param 对organizationId进行赋值
     */
    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return 返回 operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param 对operatorId进行赋值
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return 返回 clientIpAddress
     */
    public String getClientIpAddress() {
        return clientIpAddress;
    }

    /**
     * @param 对clientIpAddress进行赋值
     */
    public void setClientIpAddress(String clientIpAddress) {
        this.clientIpAddress = clientIpAddress;
    }

    /**
     * @return 返回 createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param 对createDate进行赋值
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}