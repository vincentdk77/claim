package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfModelMain-ģ�����������������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.828<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfModelMainDtoBase implements Serializable{
    /** ����ModelNo */
    private int modelNo = 0;
    /** ����ModelName */
    private String modelName = "";
    /** ����AuthorCode */
    private String authorCode = "";
    /** ����RightId */
    private String rightId = "";
    /** ����CreateDate */
    private DateTime createDate = new DateTime();
    /** ����ModifyDate */
    private DateTime modifyDate = new DateTime();
    /** ����ModelType */
    private String modelType = "";
    /** ����ModelAttr */
    private String modelAttr = "";
    /** ����ModelStatus */
    private String modelStatus = "";
    /** ����CloseService */
    private String closeService = "";
    /** ����ActiveService */
    private String activeService = "";
    /** ����Flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfModelMainDtoBase����
     */
    public SwfModelMainDtoBase(){
    }

    /**
     * ��������ModelNo
     * @param modelNo �����õ�����ModelNo��ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ModelNo
     * @return ����ModelNo��ֵ
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * ��������ModelName
     * @param modelName �����õ�����ModelName��ֵ
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * ��ȡ����ModelName
     * @return ����ModelName��ֵ
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * ��������AuthorCode
     * @param authorCode �����õ�����AuthorCode��ֵ
     */
    public void setAuthorCode(String authorCode){
        this.authorCode = StringUtils.rightTrim(authorCode);
    }

    /**
     * ��ȡ����AuthorCode
     * @return ����AuthorCode��ֵ
     */
    public String getAuthorCode(){
        return authorCode;
    }

    /**
     * ��������RightId
     * @param rightId �����õ�����RightId��ֵ
     */
    public void setRightId(String rightId){
        this.rightId = StringUtils.rightTrim(rightId);
    }

    /**
     * ��ȡ����RightId
     * @return ����RightId��ֵ
     */
    public String getRightId(){
        return rightId;
    }

    /**
     * ��������CreateDate
     * @param createDate �����õ�����CreateDate��ֵ
     */
    public void setCreateDate(DateTime createDate){
        this.createDate = createDate;
    }

    /**
     * ��ȡ����CreateDate
     * @return ����CreateDate��ֵ
     */
    public DateTime getCreateDate(){
        return createDate;
    }

    /**
     * ��������ModifyDate
     * @param modifyDate �����õ�����ModifyDate��ֵ
     */
    public void setModifyDate(DateTime modifyDate){
        this.modifyDate = modifyDate;
    }

    /**
     * ��ȡ����ModifyDate
     * @return ����ModifyDate��ֵ
     */
    public DateTime getModifyDate(){
        return modifyDate;
    }

    /**
     * ��������ModelType
     * @param modelType �����õ�����ModelType��ֵ
     */
    public void setModelType(String modelType){
        this.modelType = StringUtils.rightTrim(modelType);
    }

    /**
     * ��ȡ����ModelType
     * @return ����ModelType��ֵ
     */
    public String getModelType(){
        return modelType;
    }

    /**
     * ��������ModelAttr
     * @param modelAttr �����õ�����ModelAttr��ֵ
     */
    public void setModelAttr(String modelAttr){
        this.modelAttr = StringUtils.rightTrim(modelAttr);
    }

    /**
     * ��ȡ����ModelAttr
     * @return ����ModelAttr��ֵ
     */
    public String getModelAttr(){
        return modelAttr;
    }

    /**
     * ��������ModelStatus
     * @param modelStatus �����õ�����ModelStatus��ֵ
     */
    public void setModelStatus(String modelStatus){
        this.modelStatus = StringUtils.rightTrim(modelStatus);
    }

    /**
     * ��ȡ����ModelStatus
     * @return ����ModelStatus��ֵ
     */
    public String getModelStatus(){
        return modelStatus;
    }

    /**
     * ��������CloseService
     * @param closeService �����õ�����CloseService��ֵ
     */
    public void setCloseService(String closeService){
        this.closeService = StringUtils.rightTrim(closeService);
    }

    /**
     * ��ȡ����CloseService
     * @return ����CloseService��ֵ
     */
    public String getCloseService(){
        return closeService;
    }

    /**
     * ��������ActiveService
     * @param activeService �����õ�����ActiveService��ֵ
     */
    public void setActiveService(String activeService){
        this.activeService = StringUtils.rightTrim(activeService);
    }

    /**
     * ��ȡ����ActiveService
     * @return ����ActiveService��ֵ
     */
    public String getActiveService(){
        return activeService;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
