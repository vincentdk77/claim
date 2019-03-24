package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;

/**
 * �Զ����⽡�յ������ݴ������
 * <p>Title: �⽡�յ���DTO</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author wangwei
 * @version 1.0
 */
public class AcciCheckDto implements Serializable
{
	 /** ��������Ϣ */
    private ArrayList prpLchargeDtoList;
	
	/**�⽡�յ�������Ϣ*/
	private PrpLacciCheckDto prpLacciCheckDto;
	/**����յ����ı���Ϣ*/
	private PrpLacciCheckTextDto prpLacciCheckTextDto;
	/**����յ����ı���Ϣ�����У�*/
	private ArrayList prpLacciCheckTextDtoList;
	/**���ñ�����Ϣ*/
	private PrpLregistDto prpLregistDto;
	
	/**
	 * �⽡��ʱ�ĵ�������б�
	 */
	private Collection prpLAcciCheckChargeDtoList = new ArrayList();
	
//add by liuyanmei 20051221	start
	
	 public ArrayList getPrpLchargeDtoList() {
        return prpLchargeDtoList;
    }
	 public void setPrpLchargeDtoList(ArrayList prpLchargeDtoList) {
        this.prpLchargeDtoList = prpLchargeDtoList;
    }
// add by liuyanmei 20051221 end
	/**
	 * ���ñ�����Ϣ
	 * @param ���ñ�����Ϣ*/
	public void setPrpLregistDto(PrpLregistDto prpLregistDto) {
	    this.prpLregistDto = prpLregistDto;
	}
	/**
	 * ��ñ�����Ϣ
	 * @return ��ñ�����Ϣ*/
	public PrpLregistDto getPrpLregistDto() {
		return this.prpLregistDto;
	}
	
	/**
	 * �����⽡�յ�������Ϣ
	 * @param prpLacciCheckDto �⽡�յ�������Ϣ*/
	public void setPrpLacciCheckDto(PrpLacciCheckDto prpLacciCheckDto) {
		this.prpLacciCheckDto = prpLacciCheckDto;
	}
	/**
	 * ����⽡�յ�������Ϣ
	 * @return �⽡�յ�������Ϣ*/
	public PrpLacciCheckDto getPrpLacciCheckDto( ) {
		return this.prpLacciCheckDto;
	}
	
	/**
	 * ��������յ����ı���Ϣ�����У�
	 * @param prpLacciCheckTextDto*/
	public void setPrpLacciCheckTextDtoList(ArrayList prpLacciCheckTextDtoList) {
		this.prpLacciCheckTextDtoList = prpLacciCheckTextDtoList;
	}
	/**
	 * �������յ����ı���Ϣ�����У�
	 * @return ����յ����ı���Ϣ*/
	public ArrayList getPrpLacciCheckTextDtoList() {
		return this.prpLacciCheckTextDtoList;
	}
	
	/**
	 * ��������յ����ı���Ϣ
	 * @param prpLacciCheckTextDto*/
	public void setPrpLacciCheckTextDto(PrpLacciCheckTextDto prpLacciCheckTextDto) {
		this.prpLacciCheckTextDto = prpLacciCheckTextDto;
	}
	/**
	 * �������յ����ı���Ϣ
	 * @return ����յ����ı���Ϣ*/
	public PrpLacciCheckTextDto getPrpLacciCheckTextDto() {
		return this.prpLacciCheckTextDto;
	}
	/**�����⽡�յ�������б�
	 * @param prpLAcciCheckChargeDtoList �⽡�յ�������б�
	 */
	
	public void setPrpLAcciCheckChargeDtoList(Collection prpLAcciCheckChargeDtoList) {
		this.prpLAcciCheckChargeDtoList = prpLAcciCheckChargeDtoList;
	}
	
	/**����⽡�յ�������б�
	 * @return  prpLAcciCheckChargeDtoList �⽡�յ�������б�
	 */
	
	public Collection getPrpLAcciCheckChargeDtoList() {
		return prpLAcciCheckChargeDtoList;
	}
}
