package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleCompany--����������ʾ��Ϣ���ñ�����ݴ��������<br>
 * ������ 2005-08-08 21:52:05.033<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyDto extends PrpLscheduleCompanyDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleCompanyDto����
     */
    public PrpLscheduleCompanyDto(){
    }
    
     /** ������ʾ������Ϣ */
    private String promptTitle = "";
    /** ���Ե�������������Ϣ */
    private String comName = "";
    
    /** �б�*/ 
    Collection scheduleMobileList ;
    
    /**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getScheduleMobileList(){
      return scheduleMobileList;
    }
    
    /**
     * �����б�
     * @param registList �����õ��б�
     */
    public void setScheduleMobileList(Collection scheduleMobileList) {
      this.scheduleMobileList = scheduleMobileList;
    }
    
     /**
     * ����������ʾ������Ϣ
     * @param promptTitle �����õ�������ʾ������Ϣ��ֵ
     */
    public void setPromptTitle(String promptTitle){
        this.promptTitle = StringUtils.rightTrim(promptTitle);
    }

    /**
     * ��ȡ������ʾ������Ϣ
     * @return ������ʾ������Ϣ��ֵ
     */
    public String getPromptTitle(){
        return promptTitle;
    }
    
  
     /**
     * �������Ե�������������Ϣ
     * @param comName �����õ����Ե�������������Ϣ��ֵ
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * ��ȡ���Ե�������������Ϣ
     * @return ���Ե�������������Ϣ��ֵ
     */
    public String getComName(){
        return comName;
    }
}
