package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLmenu-�˵���(����)�����ݴ���������<br>
 * ������ 2005-05-08 15:15:50.687<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLmenuDtoBase implements Serializable{
    /** ���Բ˵����ܴ��� */
    private String funcID = "";
    /** ���Բ˵����� */
    private String funcLevel = "";
    /** ������һ���˵� */
    private String parentID = "";
    /** ������������ */
    private String funcCName = "";
    /** ����Ӣ������ */
    private String funcEName = "";
    /** ���Թ������� */
    private String funcType = "";
    /** ����ʹ�ñ�־ */
    private String useFlag = "";
    /** ���Բ˵�����ͼƬ */
    private String image = "";
    /** ����չ���˵���ͼƬ */
    private String imageExpand = "";
    /** ���Ժ��ϲ˵���ͼƬ */
    private String imageCollapse = "";
    /** ����������� */
    private String taskCode = "";
    /** ����Ȩ�޼������ */
    private String checkCode = "";
    /** ����չ���˵���ͼ�� */
    private String iconExpand = "";
    /** ���Ժ��ϲ˵���ͼ�� */
    private String iconCollapse = "";
    /** ���Բ��� */
    private String param = "";
    /** ����ģ������ */
    private String modelName = "";
    /** �������� */
    private int sortNo = 0;
    /** ����Flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLmenuDtoBase����
     */
    public PrpLmenuDtoBase(){
    }

    /**
     * �������Բ˵����ܴ���
     * @param funcID �����õ����Բ˵����ܴ����ֵ
     */
    public void setFuncID(String funcID){
        this.funcID = StringUtils.rightTrim(funcID);
    }

    /**
     * ��ȡ���Բ˵����ܴ���
     * @return ���Բ˵����ܴ����ֵ
     */
    public String getFuncID(){
        return funcID;
    }

    /**
     * �������Բ˵�����
     * @param funcLevel �����õ����Բ˵������ֵ
     */
    public void setFuncLevel(String funcLevel){
        this.funcLevel = StringUtils.rightTrim(funcLevel);
    }

    /**
     * ��ȡ���Բ˵�����
     * @return ���Բ˵������ֵ
     */
    public String getFuncLevel(){
        return funcLevel;
    }

    /**
     * ����������һ���˵�
     * @param parentID �����õ�������һ���˵���ֵ
     */
    public void setParentID(String parentID){
        this.parentID = StringUtils.rightTrim(parentID);
    }

    /**
     * ��ȡ������һ���˵�
     * @return ������һ���˵���ֵ
     */
    public String getParentID(){
        return parentID;
    }

    /**
     * ����������������
     * @param funcCName �����õ������������Ƶ�ֵ
     */
    public void setFuncCName(String funcCName){
        this.funcCName = StringUtils.rightTrim(funcCName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getFuncCName(){
        return funcCName;
    }

    /**
     * ��������Ӣ������
     * @param funcEName �����õ�����Ӣ�����Ƶ�ֵ
     */
    public void setFuncEName(String funcEName){
        this.funcEName = StringUtils.rightTrim(funcEName);
    }

    /**
     * ��ȡ����Ӣ������
     * @return ����Ӣ�����Ƶ�ֵ
     */
    public String getFuncEName(){
        return funcEName;
    }

    /**
     * �������Թ�������
     * @param funcType �����õ����Թ������͵�ֵ
     */
    public void setFuncType(String funcType){
        this.funcType = StringUtils.rightTrim(funcType);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ������͵�ֵ
     */
    public String getFuncType(){
        return funcType;
    }

    /**
     * ��������ʹ�ñ�־
     * @param useFlag �����õ�����ʹ�ñ�־��ֵ
     */
    public void setUseFlag(String useFlag){
        this.useFlag = StringUtils.rightTrim(useFlag);
    }

    /**
     * ��ȡ����ʹ�ñ�־
     * @return ����ʹ�ñ�־��ֵ
     */
    public String getUseFlag(){
        return useFlag;
    }

    /**
     * �������Բ˵�����ͼƬ
     * @param image �����õ����Բ˵�����ͼƬ��ֵ
     */
    public void setImage(String image){
        this.image = StringUtils.rightTrim(image);
    }

    /**
     * ��ȡ���Բ˵�����ͼƬ
     * @return ���Բ˵�����ͼƬ��ֵ
     */
    public String getImage(){
        return image;
    }

    /**
     * ��������չ���˵���ͼƬ
     * @param imageExpand �����õ�����չ���˵���ͼƬ��ֵ
     */
    public void setImageExpand(String imageExpand){
        this.imageExpand = StringUtils.rightTrim(imageExpand);
    }

    /**
     * ��ȡ����չ���˵���ͼƬ
     * @return ����չ���˵���ͼƬ��ֵ
     */
    public String getImageExpand(){
        return imageExpand;
    }

    /**
     * �������Ժ��ϲ˵���ͼƬ
     * @param imageCollapse �����õ����Ժ��ϲ˵���ͼƬ��ֵ
     */
    public void setImageCollapse(String imageCollapse){
        this.imageCollapse = StringUtils.rightTrim(imageCollapse);
    }

    /**
     * ��ȡ���Ժ��ϲ˵���ͼƬ
     * @return ���Ժ��ϲ˵���ͼƬ��ֵ
     */
    public String getImageCollapse(){
        return imageCollapse;
    }

    /**
     * ���������������
     * @param taskCode �����õ�������������ֵ
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * ��������Ȩ�޼������
     * @param checkCode �����õ�����Ȩ�޼�������ֵ
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * ��ȡ����Ȩ�޼������
     * @return ����Ȩ�޼�������ֵ
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * ��������չ���˵���ͼ��
     * @param iconExpand �����õ�����չ���˵���ͼ���ֵ
     */
    public void setIconExpand(String iconExpand){
        this.iconExpand = StringUtils.rightTrim(iconExpand);
    }

    /**
     * ��ȡ����չ���˵���ͼ��
     * @return ����չ���˵���ͼ���ֵ
     */
    public String getIconExpand(){
        return iconExpand;
    }

    /**
     * �������Ժ��ϲ˵���ͼ��
     * @param iconCollapse �����õ����Ժ��ϲ˵���ͼ���ֵ
     */
    public void setIconCollapse(String iconCollapse){
        this.iconCollapse = StringUtils.rightTrim(iconCollapse);
    }

    /**
     * ��ȡ���Ժ��ϲ˵���ͼ��
     * @return ���Ժ��ϲ˵���ͼ���ֵ
     */
    public String getIconCollapse(){
        return iconCollapse;
    }

    /**
     * �������Բ���
     * @param param �����õ����Բ�����ֵ
     */
    public void setParam(String param){
        this.param = StringUtils.rightTrim(param);
    }

    /**
     * ��ȡ���Բ���
     * @return ���Բ�����ֵ
     */
    public String getParam(){
        return param;
    }

    /**
     * ��������ģ������
     * @param modelName �����õ�����ģ�����Ƶ�ֵ
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * ��ȡ����ģ������
     * @return ����ģ�����Ƶ�ֵ
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * ������������
     * @param sortNo �����õ����������ֵ
     */
    public void setSortNo(int sortNo){
        this.sortNo = sortNo;
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public int getSortNo(){
        return sortNo;
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
