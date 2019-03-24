package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����MidResultConfig���ҳ�����ñ�����ݴ���������<br>
 * ������ 2005-03-13 11:18:20.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class MidResultConfigDtoBase implements Serializable{
    /** �������ù����� */
    private String configOwner = "";
    /** ���Խ��ҳ������ */
    private String resultType = "";
    /** ���Խ��ҳ������ */
    private String resultTypeName = "";
    /** ������Ŀ��� */
    private int itemNo = 0;
    /** ������Ŀ������ */
    private String itemTable = "";
    /** ������Ŀ�ֶ����� */
    private String itemColumn = "";
    /** ������Ŀ�ֶ�˵�� */
    private String itemColumnName = "";
    /** ������Ŀ�ֶ��������� */
    private String dataType = "";
    /** ������Ŀ�ֶ�ѡ������ */
    private String columnType = "";
    /** ���Է����־ */
    private String groupFlag = "";
    /** ������������ */
    private String orderType = "";
    /** ����ѡ���־ */
    private String selectFlag = "";
    /** ������ʾ״̬ */
    private String showStatus = "";
    /** ������ʾλ�� */
    private String showAlign = "";
    /** ������ʾ��� */
    private int showWidth = 0;
    /** �������ӱ�־ */
    private String linkFlag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�MidResultConfigDtoBase����
     */
    public MidResultConfigDtoBase(){
    }

    /**
     * �����������ù�����
     * @param configOwner �����õ��������ù����ߵ�ֵ
     */
    public void setConfigOwner(String configOwner){
        this.configOwner = StringUtils.rightTrim(configOwner);
    }

    /**
     * ��ȡ�������ù�����
     * @return �������ù����ߵ�ֵ
     */
    public String getConfigOwner(){
        return configOwner;
    }

    /**
     * �������Խ��ҳ������
     * @param resultType �����õ����Խ��ҳ�����͵�ֵ
     */
    public void setResultType(String resultType){
        this.resultType = StringUtils.rightTrim(resultType);
    }

    /**
     * ��ȡ���Խ��ҳ������
     * @return ���Խ��ҳ�����͵�ֵ
     */
    public String getResultType(){
        return resultType;
    }

    /**
     * �������Խ��ҳ������
     * @param resultTypeName �����õ����Խ��ҳ�����Ƶ�ֵ
     */
    public void setResultTypeName(String resultTypeName){
        this.resultTypeName = StringUtils.rightTrim(resultTypeName);
    }

    /**
     * ��ȡ���Խ��ҳ������
     * @return ���Խ��ҳ�����Ƶ�ֵ
     */
    public String getResultTypeName(){
        return resultTypeName;
    }

    /**
     * ����������Ŀ���
     * @param itemNo �����õ�������Ŀ��ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ������Ŀ���
     * @return ������Ŀ��ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * ����������Ŀ������
     * @param itemTable �����õ�������Ŀ�������ֵ
     */
    public void setItemTable(String itemTable){
        this.itemTable = StringUtils.rightTrim(itemTable);
    }

    /**
     * ��ȡ������Ŀ������
     * @return ������Ŀ�������ֵ
     */
    public String getItemTable(){
        return itemTable;
    }

    /**
     * ����������Ŀ�ֶ�����
     * @param itemColumn �����õ�������Ŀ�ֶ����Ƶ�ֵ
     */
    public void setItemColumn(String itemColumn){
        this.itemColumn = StringUtils.rightTrim(itemColumn);
    }

    /**
     * ��ȡ������Ŀ�ֶ�����
     * @return ������Ŀ�ֶ����Ƶ�ֵ
     */
    public String getItemColumn(){
        return itemColumn;
    }

    /**
     * ����������Ŀ�ֶ�˵��
     * @param itemColumnName �����õ�������Ŀ�ֶ�˵����ֵ
     */
    public void setItemColumnName(String itemColumnName){
        this.itemColumnName = StringUtils.rightTrim(itemColumnName);
    }

    /**
     * ��ȡ������Ŀ�ֶ�˵��
     * @return ������Ŀ�ֶ�˵����ֵ
     */
    public String getItemColumnName(){
        return itemColumnName;
    }

    /**
     * ����������Ŀ�ֶ���������
     * @param dataType �����õ�������Ŀ�ֶ��������͵�ֵ
     */
    public void setDataType(String dataType){
        this.dataType = StringUtils.rightTrim(dataType);
    }

    /**
     * ��ȡ������Ŀ�ֶ���������
     * @return ������Ŀ�ֶ��������͵�ֵ
     */
    public String getDataType(){
        return dataType;
    }

    /**
     * ����������Ŀ�ֶ�ѡ������
     * @param columnType �����õ�������Ŀ�ֶ�ѡ�����͵�ֵ
     */
    public void setColumnType(String columnType){
        this.columnType = StringUtils.rightTrim(columnType);
    }

    /**
     * ��ȡ������Ŀ�ֶ�ѡ������
     * @return ������Ŀ�ֶ�ѡ�����͵�ֵ
     */
    public String getColumnType(){
        return columnType;
    }

    /**
     * �������Է����־
     * @param groupFlag �����õ����Է����־��ֵ
     */
    public void setGroupFlag(String groupFlag){
        this.groupFlag = StringUtils.rightTrim(groupFlag);
    }

    /**
     * ��ȡ���Է����־
     * @return ���Է����־��ֵ
     */
    public String getGroupFlag(){
        return groupFlag;
    }

    /**
     * ����������������
     * @param orderType �����õ������������͵�ֵ
     */
    public void setOrderType(String orderType){
        this.orderType = StringUtils.rightTrim(orderType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getOrderType(){
        return orderType;
    }

    /**
     * ��������ѡ���־
     * @param selectFlag �����õ�����ѡ���־��ֵ
     */
    public void setSelectFlag(String selectFlag){
        this.selectFlag = StringUtils.rightTrim(selectFlag);
    }

    /**
     * ��ȡ����ѡ���־
     * @return ����ѡ���־��ֵ
     */
    public String getSelectFlag(){
        return selectFlag;
    }

    /**
     * ����������ʾ״̬
     * @param showStatus �����õ�������ʾ״̬��ֵ
     */
    public void setShowStatus(String showStatus){
        this.showStatus = StringUtils.rightTrim(showStatus);
    }

    /**
     * ��ȡ������ʾ״̬
     * @return ������ʾ״̬��ֵ
     */
    public String getShowStatus(){
        return showStatus;
    }

    /**
     * ����������ʾλ��
     * @param showAlign �����õ�������ʾλ�õ�ֵ
     */
    public void setShowAlign(String showAlign){
        this.showAlign = StringUtils.rightTrim(showAlign);
    }

    /**
     * ��ȡ������ʾλ��
     * @return ������ʾλ�õ�ֵ
     */
    public String getShowAlign(){
        return showAlign;
    }

    /**
     * ����������ʾ���
     * @param showWidth �����õ�������ʾ��ȵ�ֵ
     */
    public void setShowWidth(int showWidth){
        this.showWidth = showWidth;
    }

    /**
     * ��ȡ������ʾ���
     * @return ������ʾ��ȵ�ֵ
     */
    public int getShowWidth(){
        return showWidth;
    }

    /**
     * �����������ӱ�־
     * @param linkFlag �����õ��������ӱ�־��ֵ
     */
    public void setLinkFlag(String linkFlag){
        this.linkFlag = StringUtils.rightTrim(linkFlag);
    }

    /**
     * ��ȡ�������ӱ�־
     * @return �������ӱ�־��ֵ
     */
    public String getLinkFlag(){
        return linkFlag;
    }
}

