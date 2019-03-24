package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;

/**
 * �Զ����������ݴ������
 * <p>
 * Title: ������������DTO
 * </p>
 * <p>
 * Description: ��������������������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author lijiyuan
 * @version 1.0
 */

public class ClaimDto implements Serializable {
	/** ��������Ϣ */
	private PrpLclaimDto prpLclaimDto;
	//add by lym 20060809 start for �������ⰸ����֧����
	private ArrayList prpLprepayDtoList;
	//add by lym 20060809 end for �������ⰸ����֧����
	/** �ر�Լ����Ϣ */
	private ArrayList prpCengageDtoList;

	/** ���߳�����Ϣ */
	private ArrayList prpLthirdPartyDtoList;

	/** ��ʻԱ��Ϣ */
	private ArrayList prpLdriverDtoList;
	
	/** ��������Ϣ */
	private ArrayList prpLacciPersonDtoList;
	
	/** �¹�����Ϣ */
	private ArrayList prplacciBenPersonDtoList;
	
	/** �ձ������ */
	private ArrayList prpLclaimLossDtoList;

	/** ������ */
	private ArrayList prpLclaimFeeDtoList;

	/** ��֤��Ϣ */
	private ArrayList prpLdocDtoList;

	/** �ı���Ϣ */
	private ArrayList prpLltextDtoList;

	/** ��ʧ��λ��Ϣ */
	private ArrayList prpLthirdCarLossDtoList;

	/** ��ʧ��λ��Ϣ */
	private ArrayList prpLthirdPropDtoList;

	/** ����״̬��Ϣ */
	private PrpLclaimStatusDto prpLclaimStatusDto;

	//modify by wangwei add start 2005-06-16
	//ԭ����ӳ�����Ա��Ϣ
	/** ������Ա��Ϣ�� */
	private PrpLacciPersonDto prpLacciPersonDto;

	/** ������Ϣ����˵�� */
	private ArrayList prpLregistExtDtoList;

	/** ��Ա����������Ϣ 2005-07-26 */
	private ArrayList prpLpersonTraceDtoList;

	/** ���յ�λ��Ϣ 2005-08-16 by qinyongli */
	private ArrayList prpLRiskUnitDtoList;
    
    /** ������Ϣ��չ�� 2005-09-23 by qinyongli */
    private PrpLextDto prpLextDto;
    
    
    /** ������ 2006-06-09 by lym for ǿ��  */
    private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
    
    //add by kangzhen 20070522 start �洢��סԺҽ�Ʋ��������е�סԺ������Ϣ
    private ArrayList prpLpersonDtoList;
    
    /** �����������Ϣ�� 2011-08-15 by Pao*/
    private ArrayList prpLcompensateeartDtoList;
    
    /**��ϸ����ԭ����Ϣ*/
    private ArrayList prpLltextDtoList3;
    
    /**	�����Σ�յ�λ��Ϣ�� 2011-01-14  */
	private ArrayList PrpLdangerItemDtoList;
    
    /**	�������ڱ���Σ�յ�λ���ϼ���Ϣ�� 2011-01-14  */
	private ArrayList PrpLdangerTotDtoList;   
    
	/**Ԥ�������Ϣ*/
	private ArrayList PrpLpreChargeDtoList;
	
	private ArrayList prplCompensateHouseDtoList;
   
    public ArrayList getPrpLltextDtoList3() {
		return prpLltextDtoList3;
	}

	public void setPrpLltextDtoList3(ArrayList prpLltextDtoList3) {
		this.prpLltextDtoList3 = prpLltextDtoList3;
	}

	public ArrayList getPrpLpersonDtoList(){
    	return prpLpersonDtoList;
    }
	
	  public ArrayList getPrplCompensateHouseDtoList() {
		  	return prplCompensateHouseDtoList;
		  }
		  /**���ö������ʧ�嵥
		   * @param prplCompensateEarDtoList �������ʧ�嵥
		   */
		  public void setPrplCompensateHouseDtoList(ArrayList prplCompensateHouseDtoList) {
		    this.prplCompensateHouseDtoList = prplCompensateHouseDtoList;
		  }
    
    public void setPrpLpersonDtoList(ArrayList prpLpersonDtoList){
    	this.prpLpersonDtoList = prpLpersonDtoList;
    }
    //add by kangzhen 20070522 end

    /** �õ����˸�����Ϣ
	 * @return ���˸��� ��Ϣ
	 */
	public ArrayList getPrpLpersonTraceDtoList() {
		return prpLpersonTraceDtoList;
	}

	/**
	 * �������˸�����Ϣ
	 * 
	 * @param PrpLpersonTraceDtoList
	 *            ���˸��ٱ���Ϣ
	 */
	public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList) {
		this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
	}

	/**
	 * @return Returns the prpLregistExtDtoList.
	 */
	public ArrayList getPrpLregistExtDtoList() {
		return prpLregistExtDtoList;
	}

	/**
	 * @param prpLregistExtDtoList
	 *            The prpLregistExtDtoList to set.
	 */
	public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
		this.prpLregistExtDtoList = prpLregistExtDtoList;
	}

	/**
	 * ���ó�����Ա��Ϣ��
	 * 
	 * @param prpLacciPersonDto
	 *            ������Ա��Ϣ��
	 */
	public void setPrpLacciPersonDto(PrpLacciPersonDto prpLacciPersonDto) {
		this.prpLacciPersonDto = prpLacciPersonDto;
	}

	/**
	 * �õ�������Ա��Ϣ��
	 * 
	 * @return ������Ա��Ϣ��
	 */
	public PrpLacciPersonDto getPrpLacciPersonDto() {
		return this.prpLacciPersonDto;
	}

	//modify by wangwei add end 2005-06-15

	public ClaimDto() {
	}

	/**
	 * �õ�����������Ϣ
	 * 
	 * @return ����������Ϣ
	 */
	public PrpLclaimDto getPrpLclaimDto() {
		return prpLclaimDto;
	}

	/**
	 * ��������������Ϣ
	 * 
	 * @param prpLclaimDto
	 *            ����������Ϣ
	 */
	public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
		this.prpLclaimDto = prpLclaimDto;
	}

	//add by lym 20060609 for ǿ��  ---start 
	/**
	 * �õ�ǿ����������Ϣ
	 * @return 
	 */
	public PrpLRegistRPolicyDto getPrpLRegistRPolicyDto() {
		return prpLRegistRPolicyDto;
	}

	/**
	 * ����ǿ����������Ϣ
	 * @param prpLclaimDto
	 */
	public void setPrpLRegistRPolicyDto(PrpLRegistRPolicyDto prpLRegistRPolicyDto) {
		this.prpLRegistRPolicyDto = prpLRegistRPolicyDto;
	}
//	add by lym 20060609 for ǿ��  ---end
	
	
	/**
	 * �õ������ı���Ϣ
	 * 
	 * @return �����ı���Ϣ
	 */
	public ArrayList getPrpLltextDtoList() {
		return prpLltextDtoList;
	}

	/**
	 * ���������ı���Ϣ
	 * 
	 * @param prpLclaimTextDtoList
	 *            �����ı���Ϣ
	 */
	public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
		this.prpLltextDtoList = prpLltextDtoList;
	}

	/**
	 * �õ����߳�����Ϣ
	 * 
	 * @return ���߳�����Ϣ
	 */
	public ArrayList getPrpLthirdPartyDtoList() {
		return prpLthirdPartyDtoList;
	}

	/**
	 * �������߳�����Ϣ
	 * 
	 * @param PrpLthirdPartyDtoList
	 *            ���߳�������Ϣ
	 */
	public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
		this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
	}

	/**
	 * �õ���ԦԱ��Ϣ
	 * 
	 * @return ��ԦԱ ��Ϣ
	 */
	public ArrayList getPrpLdriverDtoList() {
		return prpLdriverDtoList;
	}

	/**
	 * ���ü�ԦԱ��Ϣ
	 * 
	 * @param PrpLdriverDtoList
	 *            ��ԦԱ����Ϣ
	 */
	public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList) {
		this.prpLdriverDtoList = prpLdriverDtoList;
	}
	
	/**
	 * �õ�������������Ϣ
	 * 
	 * @return ���������� ��Ϣ
	 */
	public ArrayList getPrpLacciPersonDtoList() {
		return prpLacciPersonDtoList;
	}

	/**
	 * ����������������Ϣ
	 * 
	 * @param PrpLaccipersonDtoList
	 *            ������������Ϣ
	 */
	public void setPrpLacciPersonDtoList(ArrayList prpLacciPersonDtoList) {
		this.prpLacciPersonDtoList = prpLacciPersonDtoList;
	}
    
	/**
	 * �õ��¹�����Ϣ
	 * 
	 * @return �¹��� ��Ϣ
	 */
	public ArrayList getPrplacciBenPersonDtoList() {
		return prplacciBenPersonDtoList;
	}

	/**
	 * �����¹�����Ϣ
	 * 
	 * @param prplacciBenPersonDtoList
	 *            �¹�����Ϣ
	 */
	public void setPrplacciBenPersonDtoList(ArrayList prplacciBenPersonDtoList) {
		this.prplacciBenPersonDtoList = prplacciBenPersonDtoList;
	}
	
	/**
	 * �õ���������Ϣ
	 * 
	 * @return ������ ��Ϣ
	 */
	public ArrayList getPrpLclaimFeeDtoList() {
		return prpLclaimFeeDtoList;
	}

	/**
	 * ���ù�������Ϣ
	 * 
	 * @param PrpLclaimFeeDtoList
	 *            ���������Ϣ
	 */
	public void setPrpLclaimFeeDtoList(ArrayList prpLclaimFeeDtoList) {
		this.prpLclaimFeeDtoList = prpLclaimFeeDtoList;
	}

	/**
	 * �õ���֤��Ϣ
	 * 
	 * @return ��֤��Ϣ
	 */
	public ArrayList getPrpLdocDtoList() {
		return prpLdocDtoList;
	}

	/**
	 * ���õ�֤��Ϣ
	 * 
	 * @param PrpLdocDtoList
	 *            ��֤����Ϣ
	 */
	public void setPrpLdocDtoList(ArrayList prpLdocDtoList) {
		this.prpLdocDtoList = prpLdocDtoList;
	}

	/**
	 * �õ���������״̬��Ϣ
	 * 
	 * @return ��������״̬��Ϣ
	 */
	public PrpLclaimStatusDto getPrpLclaimStatusDto() {
		return prpLclaimStatusDto;
	}

	/**
	 * ������������״̬��Ϣ
	 * 
	 * @param prpLclaimStuatsDto
	 *            ��������״̬��Ϣ
	 */
	public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
		this.prpLclaimStatusDto = prpLclaimStatusDto;
	}

	/**
	 * �õ��ձ��������Ϣ
	 * 
	 * @return �ձ������ ��Ϣ
	 */
	public ArrayList getPrpLclaimLossDtoList() {
		return prpLclaimLossDtoList;
	}

	public ArrayList getPrpCengageDtoList() {
		return prpCengageDtoList;
	}

	/**
	 * �����ձ��������Ϣ
	 * 
	 * @param PrpLclaimLossDtoList
	 *            �ձ���������Ϣ
	 */
	public void setPrpLclaimLossDtoList(ArrayList prpLclaimLossDtoList) {
		this.prpLclaimLossDtoList = prpLclaimLossDtoList;
	}

	public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
		this.prpCengageDtoList = prpCengageDtoList;
	}

	/**
	 * �õ�������ʧ��Ϣ
	 * 
	 * @return ������ʧ ��Ϣ
	 */

	public ArrayList getPrpLthirdCarLossDtoList() {
		return prpLthirdCarLossDtoList;
	}

	/**
	 * ���ò�����ʧ��Ϣ
	 * 
	 * @param prpLthirdCarLossDtoList
	 *            ������ʧ��Ϣ
	 */

	public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
		this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
	}

	/**
	 * ����������ʧ��Ϣ
	 * 
	 * @param prpLthirdPropDtoList
	 *            ������ʧ��Ϣ
	 */

	public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
		this.prpLthirdPropDtoList = prpLthirdPropDtoList;
	}

	/**
	 * �õ�������ʧ��Ϣ
	 * 
	 * @return ������ʧ��Ϣ
	 */

	public ArrayList getPrpLthirdPropDtoList() {
		return prpLthirdPropDtoList;
	}

	/**
	 * @param prpLRiskUnitDtoList
	 */
	public void setPrplRiskUnitDtoList(ArrayList prpLRiskUnitDtoList) {
		this.prpLRiskUnitDtoList = prpLRiskUnitDtoList;
	}

	/**
	 * @return ArrayList
	 */
	public ArrayList getPrpLRiskUnitDtoList() {
		return prpLRiskUnitDtoList;
	}
    /**
     * @param ������Ϣ��չ
     */
    public void setPrpLextDto(PrpLextDto prpLextDto) {
        this.prpLextDto = prpLextDto;
    }

    /**
     * @return ������Ϣ��չ
     */
    public PrpLextDto getPrpLextDto() {
        return prpLextDto;
    }
//  add by lym 20060809 start for �������ⰸ����֧����	
    /**
	 * @return Returns the prpLprepayDtoList.
	 */
	public ArrayList getPrpLprepayDtoList() {
		return prpLprepayDtoList;
	}
	/**
	 * @param prpLprepayDtoList The prpLprepayDtoList to set.
	 */
	public void setPrpLprepayDtoList(ArrayList prpLprepayDtoList) {
		this.prpLprepayDtoList = prpLprepayDtoList;
	}
//	add by lym 20060809 start for �������ⰸ����֧����

	public ArrayList getPrpLdangerItemDtoList() {
		return PrpLdangerItemDtoList;
	}

	public void setPrpLdangerItemDtoList(ArrayList prpLdangerItemDtoList) {
		PrpLdangerItemDtoList = prpLdangerItemDtoList;
	}

	public ArrayList getPrpLdangerTotDtoList() {
		return PrpLdangerTotDtoList;
	}

	public void setPrpLdangerTotDtoList(ArrayList prpLdangerTotDtoList) {
		PrpLdangerTotDtoList = prpLdangerTotDtoList;
	}

	public ArrayList getPrpLcompensateeartDtoList() {
		return prpLcompensateeartDtoList;
	}

	public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
		this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
	}

	public ArrayList getPrpLpreChargeDtoList() {
		return PrpLpreChargeDtoList;
	}

	public void setPrpLpreChargeDtoList(ArrayList prpLpreChargeDtoList) {
		PrpLpreChargeDtoList = prpLpreChargeDtoList;
	}
}
