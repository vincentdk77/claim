package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;

/**
 * �Զ���ʵ�����ݴ������
 * <p>
 * Title: ��������ʵ��DTO
 * </p>
 * <p>
 * Description: ��������ʵ����������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class CompensateDto implements Serializable {
    /** ������������Ϣ */
    private PrpLcompensateDto prpLcompensateDto;
    /** �ر�Լ����Ϣ */
    private ArrayList prpCengageDtoList;
    
    private ArrayList prpLacciPersonDtoList;
    /** �¹�����Ϣ */
    private ArrayList prpLacciBenPersonList;
    
    //��ũ���ŵ�ʱ����������Ϣ
    private ArrayList prpLagriPersonDtoList;
    
    /** �⸶�����Ϣ */
    private ArrayList prpLlossDtoList;
    /** �⸶��Ա��Ϣ */
    private ArrayList prpLpersonLossDtoList;
    /** ��������Ϣ */
    private ArrayList prpLchargeDtoList;
    /** ���㱨�� */
    private ArrayList prpLctextDtoDtoList;
    /** ������Ϣ */
    private PrpLclaimDto prpLclaimDto;
    /** �޶��������� */
    private ArrayList prpDlimitDtoList;
    /** ��������� */
    private ArrayList prpLcfeeDtoList;
    /** �޶��������� */
    private ArrayList prpClimitDtoList;
    /** ������������ */
    private ArrayList prpLqualityCheckList;
    /** ������Ϣ����˵�� */
    private ArrayList prpLregistExtDtoList;
    /** �᰸���� */
    /**����������Ϣ add by qinyongli 2006-01-10*/
    private ArrayList prpLdeductibleList;
    /**����������Ϣ add by qinyongli 2006-01-10*/
    private ArrayList prpLltextDtoList;
    /**Σ�յ�λadd by qinyongli 2005-8-19 */
    private ArrayList prplRiskUnitDtoList;
    /**����Σ�յ�λ���ϼ���Ϣ add by qinyongli 2005-09-10*/
    private ArrayList prpLprpLdangerTotList;
    /**�����Σ�յ�λ��Ϣ�� add by qinyongli 2005-09-10*/
    private ArrayList prpLprpLdangerItemList;
    
    private ArrayList prpLcfeecoinsList;
    
    private ArrayList prpLhospitalizationPayFeeDtoList;
    /**����ά�޷�Ʊ��Ϣ */
    private ArrayList prpLcomRepairBillDtoList;
    /**������Ϣ */
    private ArrayList prpLcompensateeartDtoList;
    
    private ArrayList prplCompensateHouseDtoList;
    /**
     * �������
     */
    private ArrayList prpLnodutyLossDtoList;
    
    private ArrayList prpLthirdPartyDtoList;
    /**��������ϸ�����Ϣ*/
    private ArrayList prpLinjuryPersonList;
    
    public ArrayList getPrpLthirdPartyDtoList() {
		return prpLthirdPartyDtoList;
	}

	public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList) {
		this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
	}

	public ArrayList getPrpLhospitalizationPayFeeDtoList(){
    	return prpLhospitalizationPayFeeDtoList;
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
    
    public void setPrpLhospitalizationPayFeeDtoList(ArrayList prpLhospitalizationPayFeeDtoList){
    	this.prpLhospitalizationPayFeeDtoList = prpLhospitalizationPayFeeDtoList;
    }
    /**
     * @return Returns the prpLregistExtDtoList.
     */
    public ArrayList getPrpLregistExtDtoList() {
        return prpLregistExtDtoList;
    }
    /**
     * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
     */
    public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
        this.prpLregistExtDtoList = prpLregistExtDtoList;
    }
    
    public ArrayList getPrpLacciPersonDtoList() {
        return prpLacciPersonDtoList;
    }
    /**
     * @param prpLregistExtDtoList The prpLregistExtDtoList to set.
     */
    public void setPrpLacciPersonDtoList(ArrayList prpLacciPersonDtoList) {
        this.prpLacciPersonDtoList = prpLacciPersonDtoList;
    }
    
    public ArrayList getPrpLagriPersonDtoList() {
        return prpLagriPersonDtoList;
    }
 
    public void setPrpLagriPersonDtoList(ArrayList prpLagriPersonDtoList) {
        this.prpLagriPersonDtoList = prpLagriPersonDtoList;
    }
    
    /**
     * @return Returns the prpLqualityCheckList.
     */
    public ArrayList getPrpLqualityCheckList() {
        return prpLqualityCheckList;
    }
    /**
     * @param prpLqualityCheckList The prpLqualityCheckList to set.
     */
    public void setPrpLqualityCheckList(ArrayList prpLqualityCheckList) {
        this.prpLqualityCheckList = prpLqualityCheckList;
    }
    /** ����״̬��Ϣ */
    private PrpLclaimStatusDto prpLclaimStatusDto;

    /**
     * �õ���������Ϣ
     * 
     * @return ��������Ϣ
     */
    public ArrayList getPrpLchargeDtoList() {
        return prpLchargeDtoList;
    }

    /**
     * �õ�������������Ϣ
     * 
     * @return ������������Ϣ
     */
    public PrpLcompensateDto getPrpLcompensateDto() {
        return prpLcompensateDto;
    }

    /**
     * �õ��ر�Լ����Ϣ
     * 
     * @return �ر�Լ����Ϣ
     */
    public ArrayList getPrpCengageDtoList() {
        return prpCengageDtoList;
    }

    /**
     * �õ��⸶��Ա��Ϣ
     * 
     * @return �⸶��Ա��Ϣ
     */
    public ArrayList getPrpLpersonLossDtoList() {
        return prpLpersonLossDtoList;
    }

    /**
     * �õ�����״̬��Ϣ
     * 
     * @return ����״̬��Ϣ
     */
    public PrpLclaimStatusDto getPrpLclaimStatusDto() {
        return prpLclaimStatusDto;
    }

    /**
     * �õ��⸶�����Ϣ
     * 
     * @return �⸶�����Ϣ
     */
    public ArrayList getPrpLlossDtoList() {
        return prpLlossDtoList;
    }

    /**
     * �������㱨��
     * 
     * @param prpLctextDtoDtoList ���㱨��
     */
    public void setPrpLctextDtoDtoList(ArrayList prpLctextDtoDtoList) {
        this.prpLctextDtoDtoList = prpLctextDtoDtoList;
    }

    /**
     * ������������Ϣ
     * 
     * @param prpLchargeDtoList ��������Ϣ
     */
    public void setPrpLchargeDtoList(ArrayList prpLchargeDtoList) {
        this.prpLchargeDtoList = prpLchargeDtoList;
    }

    /**
     * ����������������Ϣ
     * 
     * @param prpLcompensateDto ������������Ϣ
     */
    public void setPrpLcompensateDto(PrpLcompensateDto prpLcompensateDto) {
        this.prpLcompensateDto = prpLcompensateDto;
    }

    /**
     * �����ر�Լ����Ϣ
     * 
     * @param prpCengageDtoList �ر�Լ����Ϣ
     */
    public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
        this.prpCengageDtoList = prpCengageDtoList;
    }

    /**
     * �������߳�����Ϣ
     * 
     * @param PrpLthirdPartyDtoList ���߳�������Ϣ
     */
    public void setPrpLpersonLossDtoList(ArrayList prpLpersonLossDtoList) {
        this.prpLpersonLossDtoList = prpLpersonLossDtoList;
    }

    /**
     * �����⸶��Ա��Ϣ
     * 
     * @param prpLpersonLossDtoList �⸶��Ա��Ϣ
     */
    public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
        this.prpLclaimStatusDto = prpLclaimStatusDto;
    }

    /**
     * �����⸶�����Ϣ
     * 
     * @param prpLlossDtoList �⸶�����Ϣ
     */
    public void setPrpLlossDtoList(ArrayList prpLlossDtoList) {
        this.prpLlossDtoList = prpLlossDtoList;
    }

    /**
     * ����������Ϣ
     * 
     * @param prpLclaimDto ������Ϣ
     */
    public void setPrpLclaimDto(PrpLclaimDto prpLclaimDto) {
        this.prpLclaimDto = prpLclaimDto;
    }

    public void setPrpDlimitDtoList(ArrayList prpDlimitDtoList) {
        this.prpDlimitDtoList = prpDlimitDtoList;
    }

    public void setPrpClimitDtoList(ArrayList prpClimitDtoList) {
        this.prpClimitDtoList = prpClimitDtoList;
    }

    public void setPrpLcfeeDtoList(ArrayList prpLcfeeDtoList) {
        this.prpLcfeeDtoList = prpLcfeeDtoList;
    }

    /**
     * �������㱨��
     * 
     * @param prpLctextDtoDtoList ���㱨��
     */
    public ArrayList getPrpLctextDtoDtoList() {
        return prpLctextDtoDtoList;
    }

    /**
     * �õ�������Ϣ
     * 
     * @return ������Ϣ
     */
    public PrpLclaimDto getPrpLclaimDto() {
        return prpLclaimDto;
    }

    public ArrayList getPrpDlimitDtoList() {
        return prpDlimitDtoList;
    }

    public ArrayList getPrpClimitDtoList() {
        return prpClimitDtoList;
    }

    public ArrayList getPrpLcfeeDtoList() {
        return prpLcfeeDtoList;
    }

    public CompensateDto() {
    }

    public ArrayList getPrpLltextDtoList() {
        return prpLltextDtoList;
    }
    public void setPrpLltextDtoList(ArrayList prpLltextDtoList) {
        this.prpLltextDtoList = prpLltextDtoList;
    }
    /**
     * ����Σ�յ�λ add by qinyongli 2005-8-19
     * @return
     */
    public ArrayList getPrplRiskUnitDtoList() {
        return prplRiskUnitDtoList;
    }
    /**
     * ����Σ�յ�λ add by qinyongli 2005-8-19
     * @param prplRiskUnitDtoList
     */
    public void setPrplRiskUnitDtoList(ArrayList prplRiskUnitDtoList) {
        this.prplRiskUnitDtoList = prplRiskUnitDtoList;
    }
    /**
     * ��������Σ�յ�λ���ϼ���Ϣ add by qinyongli 2005-9-10
     * @return
     */
    public ArrayList getPrpLprpLdangerTotList() {
        return prpLprpLdangerTotList;
    }
    /**
     * ��������Σ�յ�λ���ϼ���Ϣ add by qinyongli 2005-9-10
     * @param prpLprpLdangerTotList
     */
    public void setPrpLprpLdangerTotList(ArrayList prpLprpLdangerTotList) {
        this.prpLprpLdangerTotList = prpLprpLdangerTotList;
    }
    /**
     * ���������Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
     * @return
     */
    public ArrayList getPrpLprpLdangerItemList() {
        return prpLprpLdangerItemList;
    }
    /**
     * ���������Σ�յ�λ��Ϣ add by qinyongli 2005-8-19
     * @param prpLprpLdangerItemList
     */
    public void setPrpLprpLdangerItemList(ArrayList prpLprpLdangerItemList) {
        this.prpLprpLdangerItemList = prpLprpLdangerItemList;
    }

    /**
     * ����������������� add by qinyongli 2006-01-11
     * @return
     */
    public ArrayList getPrpLdeductibleList() {
        return prpLdeductibleList;
    }
    /**
     * ����������������� add by qinyongli 2006-01-11
     * @param prpLdeductibleList
     */
    public void setPrpLdeductibleList(ArrayList prpLdeductibleList) {
        this.prpLdeductibleList = prpLdeductibleList;
    }
    
    public ArrayList getPrpLcfeecoinsList()
    {
        return prpLcfeecoinsList;
    }

    public void setPrpLcfeecoinsList(ArrayList prpLcfeecoinsList)
    {
        this.prpLcfeecoinsList = prpLcfeecoinsList;
    }

	public ArrayList getPrpLnodutyLossDtoList() {
		return prpLnodutyLossDtoList;
	}

	public void setPrpLnodutyLossDtoList(ArrayList prpLnodutyLossDtoList) {
		this.prpLnodutyLossDtoList = prpLnodutyLossDtoList;
	}

	public ArrayList getPrpLacciBenPersonList() {
		return prpLacciBenPersonList;
	}

	public void setPrpLacciBenPersonList(ArrayList prpLacciBenPersonList) {
		this.prpLacciBenPersonList = prpLacciBenPersonList;
	}

	public ArrayList getPrpLcomRepairBillDtoList() {
		return prpLcomRepairBillDtoList;
	}

	public void setPrpLcomRepairBillDtoList(ArrayList prpLcomRepairBillDtoList) {
		this.prpLcomRepairBillDtoList = prpLcomRepairBillDtoList;
	}

	/**
	 * @return the prpLcompensateeartDtoList
	 */
	public ArrayList getPrpLcompensateeartDtoList() {
		return prpLcompensateeartDtoList;
	}

	/**
	 * @param prpLcompensateeartDtoList the prpLcompensateeartDtoList to set
	 */
	public void setPrpLcompensateeartDtoList(ArrayList prpLcompensateeartDtoList) {
		this.prpLcompensateeartDtoList = prpLcompensateeartDtoList;
	}

	public ArrayList getPrpLinjuryPersonList() {
		return prpLinjuryPersonList;
	}

	public void setPrpLinjuryPersonList(ArrayList prpLinjuryPersonList) {
		this.prpLinjuryPersonList = prpLinjuryPersonList;
	}
   
}
