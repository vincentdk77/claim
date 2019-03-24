package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prplprop�Ʋ��˶�����ϸ�嵥������ݴ��������<br>
 * ������ 2004-4-5 15:31:56<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpropDto extends PrpLpropDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpropDto����
     */
    public PrpLpropDto(){
    }

    /** ���� **/
    Collection propList;
    /** �����ձ����� */
    private String kindName = "";
    /** �ұ����� */
    private String currencyName = "";
    /** �ƶ��豸���к� add by wangxinyang 2018/6/15 */
    private String imei = "";

    public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**�õ��Ʋ��˶�����ϸ�嵥����
    * @return �Ʋ��˶�����ϸ�嵥������Ϣ
    */
    public Collection getPropList() {
      return  propList;
    }

  public String getCurrencyName() {
    return currencyName;
  }

  /**���òƲ��˶�����ϸ�嵥����
    * @param propList �Ʋ��˶�����ϸ�嵥����
    */
    public void setPropList(Collection propList) {
      this.propList = propList;
    }

  public void setCurrencyName(String currencyName) {
    this.currencyName = currencyName;
  }

}
