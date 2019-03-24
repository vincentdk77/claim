package com.sinosoft.claim.dto.domain;
import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplthirdparty���⳵����Ϣ�����ݴ��������<br>
 * ������ 2004-4-5 15:31:57<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLthirdPartyDto extends PrpLthirdPartyDtoBase implements Serializable{

   /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLthirdPartyDto����
     */
    public PrpLthirdPartyDto(){
    }

    /** ������ʾ�б�*/
    private Collection thirdPartyList ;
    
    /** ���Ե��ȴ����־ */
    private String scheduleType = "";

    /** �����Ƿ�ѡ���� */
    private String selectSend = "";
    /** �������ĸ��ڵ�ĵ��� */
    private String nodeType = "";
    /** �������ձ�*/
    private String prpLthirdPartyKindCode = "";
    /** ���������߳���ʻԱ���� */
    private String prpLthirdPartyDriveName = "";
    /** ���������߳���ʻԱ�����*/
    private String prpLthirdPartyDriveLicensNo = "";    
    
    public String getPrpLthirdPartyDriveName() {
		return prpLthirdPartyDriveName;
	}

	public void setPrpLthirdPartyDriveName(String prpLthirdPartyDriveName) {
		this.prpLthirdPartyDriveName = prpLthirdPartyDriveName;
	}

	public String getPrpLthirdPartyDriveLicensNo() {
		return prpLthirdPartyDriveLicensNo;
	}

	public void setPrpLthirdPartyDriveLicensNo(
			String prpLthirdPartyDriveLicensNo) {
		this.prpLthirdPartyDriveLicensNo = prpLthirdPartyDriveLicensNo;
	}
	/**
     * ��ȡ�б�
     * @return �����б�
     */
    public Collection getThirdPartyList(){
      return thirdPartyList;
    }
    /**
     * �����б�
     * @param prpLthirdPartyRegistNo �����õ��б�
     */
    public void setThirdPartyList(Collection thirdPartyList) {
      this.thirdPartyList = thirdPartyList;
    }



    /**
     * �������Ե��ȴ����־
     * @param scheduleType �����õ����Ե��ȴ����־��ֵ
     */
    public void setScheduleType(String scheduleType){
        this.scheduleType = StringUtils.rightTrim(scheduleType);
    }

    /**
     * ��ȡ���Ե��ȴ����־
     * @return ���Ե��ȴ����־��ֵ
     */
    public String getScheduleType(){
        return scheduleType;
    }
    
    /**
     * ���������Ƿ�ѡ����
     * @param selectSend �����õ������Ƿ�ѡ���͵�ֵ
     */
    public void setSelectSend(String selectSend){
        this.selectSend = StringUtils.rightTrim(selectSend);
    }

    /**
     * ��ȡ�����Ƿ�ѡ����
     * @return �����Ƿ�ѡ���͵�ֵ
     */
    public String getSelectSend(){
        return selectSend;
    }

 
  /**
     * �������Խڵ�����
     * @param nodeType �����õ����Խڵ����͵�ֵ
     */
    public void setNodeType(String nodeType){
        this.nodeType = StringUtils.rightTrim(nodeType);
    }

    /**
     * ��ȡ���Խڵ�����
     * @return ���Խڵ����͵�ֵ
     */
    public String getNodeType(){
        return nodeType;
    }
    
    /**
     * ���������ձ�����
     * @param prpLthirdPartyKindCode �����õ������ձ����͵�ֵ
     */
    public void setPrpLthirdPartyKindCode(String prpLthirdPartyKindCode){
        this.prpLthirdPartyKindCode = StringUtils.rightTrim(prpLthirdPartyKindCode);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����͵�ֵ
     */
    public String getPrpLthirdPartyKindCode(){
        return prpLthirdPartyKindCode;
    }
}
