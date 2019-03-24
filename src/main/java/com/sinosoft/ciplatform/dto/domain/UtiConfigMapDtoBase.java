package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ������ҵ��ƽ̨���ñ�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class UtiConfigMapDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����ϵͳ�� */
    private String systemName = "";
    /** �������� */
    private String className = "";
    /** ����HashMap�� */
    private String mapName = "";
    /** ���Լ� */
    private String keyValue = "";
    /** ����ֵ */
    private String value = "";
    /** ������Ч״̬ */
    private String validStatus = "";
    /** ����Ԥ����־ */
    private String flag = "";
    /** ����¼��ʱ�� */
    private DateTime inputDate = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiConfigMapDtoBase����
     */
    public UtiConfigMapDtoBase(){
    }

    /**
     * ��������ϵͳ��
     * @param systemName �����õ�����ϵͳ����ֵ
     */
    public void setSystemName(String systemName){
        this.systemName = StringUtils.rightTrim(systemName);
    }

    /**
     * ��ȡ����ϵͳ��
     * @return ����ϵͳ����ֵ
     */
    public String getSystemName(){
        return systemName;
    }

    /**
     * ������������
     * @param className �����õ�����������ֵ
     */
    public void setClassName(String className){
        this.className = StringUtils.rightTrim(className);
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public String getClassName(){
        return className;
    }

    /**
     * ��������HashMap��
     * @param mapName �����õ�����HashMap����ֵ
     */
    public void setMapName(String mapName){
        this.mapName = StringUtils.rightTrim(mapName);
    }

    /**
     * ��ȡ����HashMap��
     * @return ����HashMap����ֵ
     */
    public String getMapName(){
        return mapName;
    }

    /**
     * �������Լ�
     * @param keyValue �����õ����Լ���ֵ
     */
    public void setKeyValue(String keyValue){
        this.keyValue = StringUtils.rightTrim(keyValue);
    }

    /**
     * ��ȡ���Լ�
     * @return ���Լ���ֵ
     */
    public String getKeyValue(){
        return keyValue;
    }

    /**
     * ��������ֵ
     * @param value �����õ�����ֵ��ֵ
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * ��ȡ����ֵ
     * @return ����ֵ��ֵ
     */
    public String getValue(){
        return value;
    }

    /**
     * ����������Ч״̬
     * @param validStatus �����õ�������Ч״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ������Ч״̬
     * @return ������Ч״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������Ԥ����־
     * @param flag �����õ�����Ԥ����־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Ԥ����־
     * @return ����Ԥ����־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������¼��ʱ��
     * @param inputDate �����õ�����¼��ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����¼��ʱ��
     * @return ����¼��ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }
}
