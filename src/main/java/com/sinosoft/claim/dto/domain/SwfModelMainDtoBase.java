package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfModelMain-模板主表（新增）的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfModelMainDtoBase implements Serializable{
    /** 属性ModelNo */
    private int modelNo = 0;
    /** 属性ModelName */
    private String modelName = "";
    /** 属性AuthorCode */
    private String authorCode = "";
    /** 属性RightId */
    private String rightId = "";
    /** 属性CreateDate */
    private DateTime createDate = new DateTime();
    /** 属性ModifyDate */
    private DateTime modifyDate = new DateTime();
    /** 属性ModelType */
    private String modelType = "";
    /** 属性ModelAttr */
    private String modelAttr = "";
    /** 属性ModelStatus */
    private String modelStatus = "";
    /** 属性CloseService */
    private String closeService = "";
    /** 属性ActiveService */
    private String activeService = "";
    /** 属性Flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfModelMainDtoBase对象
     */
    public SwfModelMainDtoBase(){
    }

    /**
     * 设置属性ModelNo
     * @param modelNo 待设置的属性ModelNo的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性ModelNo
     * @return 属性ModelNo的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性ModelName
     * @param modelName 待设置的属性ModelName的值
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * 获取属性ModelName
     * @return 属性ModelName的值
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * 设置属性AuthorCode
     * @param authorCode 待设置的属性AuthorCode的值
     */
    public void setAuthorCode(String authorCode){
        this.authorCode = StringUtils.rightTrim(authorCode);
    }

    /**
     * 获取属性AuthorCode
     * @return 属性AuthorCode的值
     */
    public String getAuthorCode(){
        return authorCode;
    }

    /**
     * 设置属性RightId
     * @param rightId 待设置的属性RightId的值
     */
    public void setRightId(String rightId){
        this.rightId = StringUtils.rightTrim(rightId);
    }

    /**
     * 获取属性RightId
     * @return 属性RightId的值
     */
    public String getRightId(){
        return rightId;
    }

    /**
     * 设置属性CreateDate
     * @param createDate 待设置的属性CreateDate的值
     */
    public void setCreateDate(DateTime createDate){
        this.createDate = createDate;
    }

    /**
     * 获取属性CreateDate
     * @return 属性CreateDate的值
     */
    public DateTime getCreateDate(){
        return createDate;
    }

    /**
     * 设置属性ModifyDate
     * @param modifyDate 待设置的属性ModifyDate的值
     */
    public void setModifyDate(DateTime modifyDate){
        this.modifyDate = modifyDate;
    }

    /**
     * 获取属性ModifyDate
     * @return 属性ModifyDate的值
     */
    public DateTime getModifyDate(){
        return modifyDate;
    }

    /**
     * 设置属性ModelType
     * @param modelType 待设置的属性ModelType的值
     */
    public void setModelType(String modelType){
        this.modelType = StringUtils.rightTrim(modelType);
    }

    /**
     * 获取属性ModelType
     * @return 属性ModelType的值
     */
    public String getModelType(){
        return modelType;
    }

    /**
     * 设置属性ModelAttr
     * @param modelAttr 待设置的属性ModelAttr的值
     */
    public void setModelAttr(String modelAttr){
        this.modelAttr = StringUtils.rightTrim(modelAttr);
    }

    /**
     * 获取属性ModelAttr
     * @return 属性ModelAttr的值
     */
    public String getModelAttr(){
        return modelAttr;
    }

    /**
     * 设置属性ModelStatus
     * @param modelStatus 待设置的属性ModelStatus的值
     */
    public void setModelStatus(String modelStatus){
        this.modelStatus = StringUtils.rightTrim(modelStatus);
    }

    /**
     * 获取属性ModelStatus
     * @return 属性ModelStatus的值
     */
    public String getModelStatus(){
        return modelStatus;
    }

    /**
     * 设置属性CloseService
     * @param closeService 待设置的属性CloseService的值
     */
    public void setCloseService(String closeService){
        this.closeService = StringUtils.rightTrim(closeService);
    }

    /**
     * 获取属性CloseService
     * @return 属性CloseService的值
     */
    public String getCloseService(){
        return closeService;
    }

    /**
     * 设置属性ActiveService
     * @param activeService 待设置的属性ActiveService的值
     */
    public void setActiveService(String activeService){
        this.activeService = StringUtils.rightTrim(activeService);
    }

    /**
     * 获取属性ActiveService
     * @return 属性ActiveService的值
     */
    public String getActiveService(){
        return activeService;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }
}
