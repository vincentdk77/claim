package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.*;

/**
 * ����֧���������������ݴ��������<br>
 */
public class PrpLpayExttgDto extends PrpLpayExttgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������� */
    private String comCName;
    /** ռ��ʱ�� */
    private String costTime;
    /** ���������� */
    private String operatorCodeName;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayExttgDto����
     */
    public PrpLpayExttgDto(){
    }
    /** �������� */
	public String getComCName() {
		return comCName;
	}
    /** �������� */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}
    /** ռ��ʱ�� */
	public String getCostTime() {
		return costTime;
	}
    /** ռ��ʱ�� */
	public void setCostTime(String costTime) {
		this.costTime = costTime;
	}
    /** ���������� */
	public String getOperatorCodeName() {
		return operatorCodeName;
	}
    /** ���������� */
	public void setOperatorCodeName(String operatorCodeName) {
		this.operatorCodeName = operatorCodeName;
	}
    
}
