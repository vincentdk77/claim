package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpCmainLoanDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.prpall.dto.domain.PrpCmainOriginDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * �Զ��屣�����ݴ������
 * <p>Title: �������Ᵽ��DTO</p>
 * <p>Description: �������Ᵽ����������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class PolicyDto implements Serializable
{
  /** ��������Ϣ*/
  private PrpCmainDto prpCmainDto;
  /**ԭʼ������Ϣ**/
  private PrpCmainOriginDto prpCmainOriginDto;
  /** ������Ϣ*/
  private PrpCfeeDto  prpCfeeDto ;
  /** ������Ϣ*/
  private ArrayList  prpCfeeDtoList ;
  /** ���ձ����Ϣ*/
  private ArrayList prpCitemKindDtoList;
  /** ���յ�ַ��Ϣ*/
  private ArrayList prpCaddressDtoList;
  /** �����ͻ���Ϣ*/
  private ArrayList prpCinsuredDtoList;
  /** ������Ϣ*/
  private ArrayList prpCitemCarDtoList;
  /** �Ż���Ϣ��*/
  private ArrayList prpCprofitDtoList;
  /** �Ż��ۿ���ϸ����Ϣ*/
  private ArrayList prpCprofitDetailDtoList;
  /** ���Ѽƻ���Ϣ*/
  private ArrayList prpCplanDtoList;
  /** �ر�Լ����Ϣ*/
  private ArrayList  prpCengageDtoList ;
  /** ��ʻԱ��Ϣ*/
  private ArrayList prpCcarDriverDtoList;
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;

  //modify by wangwei add start 20050601
  /**�����ձ�����Ϣ*/
  private PrpCmainCargoDto prpCmainCargoDto;
  //modify by wangwei add end 20050601
  //modify by qinyongli add start 20050718
  
//add by liuyanmei 20060224 start
  /**�������޶���Ϣ*/
  private ArrayList prpClimitDtoList;
//add by liuyanmei 20060224 end
  
  /**����������׷����*/
  private DateTime liabStartDate;
  //modify by wangwei add end 20050718
  
  //add by miaowenjun 20060430
  /**�����շ�����Ϣ*/
  private ArrayList prpCitemHouseDtoList;
  private PrpCmainLoanDto prpCmainLoanDto;
  //add end by miaowenjun 20060430
  
  //add by lym 20060204  for ǿ�� ---- start
  /** ����������Ϣ*/
  private ArrayList prpCmainSubDtoList;
  /** ��������Ϣ*/
  private ArrayList prpLRegistRPolicyDtoList;
  
  //add by lym 20060204  for ǿ�� ---- end

  private ArrayList prpCcoinsDtoList ;
  private ArrayList prpCcoinsDetailDtoList ;
  public PolicyDto()
  {
  }

//add by liuyanmei 20060224 start
  /**�������޶���Ϣ*/
  public ArrayList getPrpClimitDtoList()
  {
    return prpClimitDtoList;
  }

  public void setPrpClimitDtoList(ArrayList prpClimitDtoList)
  {
     this.prpClimitDtoList=prpClimitDtoList;
  }
  //modify by wangwei add end 20050718
  
  
  
  //add by lym 20060204  for ǿ�� ---- start 
  /**�õ�������������Ϣ
   * @return ������������Ϣ
   */
  public ArrayList getPrpCmainSubDtoList()
  {
    return prpCmainSubDtoList;
  }

  /**���ñ�����������Ϣ
   * @param prpCmainDto ������������Ϣ
   */
  public void setPrpCmainSubDtoList(ArrayList prpCmainSubDtoList)
  {
     this.prpCmainSubDtoList = prpCmainSubDtoList;
  }
  
  /**�õ�������������Ϣ
   * @return ������������Ϣ
   */
  public ArrayList getPrpLRegistRPolicyDtoList()
  {
    return prpLRegistRPolicyDtoList;
  }

  /**���ñ�����������Ϣ
   * @param prpCmainDto ������������Ϣ
   */
  public void setPrpLRegistRPolicyDtoList(ArrayList prpLRegistRPolicyDtoList)
  {
     this.prpLRegistRPolicyDtoList= prpLRegistRPolicyDtoList;
  }
  
  //add by lym 20060204  for ǿ�� ---- end 
  
   
  
  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpCmainDto getPrpCmainDto()
  {
    return prpCmainDto;
  }

  /**���ñ���������Ϣ
   * @param prpCmainDto ����������Ϣ
   */
  public void setPrpCmainDto(PrpCmainDto prpCmainDto)
  {
     this.prpCmainDto = prpCmainDto;
  }

  /**�õ�������Ϣ
   * @return  ������Ϣ
   */
  public PrpCfeeDto getPrpCfeeDto()
  {
    return prpCfeeDto;
  }
  /**���÷ѱ���Ϣ
   * @param PrpCfeeDto ���ѱ���Ϣ
   */
  public void setPrpCfeeDto(PrpCfeeDto prpCfeeDto)
  {
    this.prpCfeeDto = prpCfeeDto;
  }

  /**�õ�itemkind��Ϣ
   * @return  itemkind��Ϣ
   */
  public ArrayList getPrpCitemKindDtoList()
  {
    return prpCitemKindDtoList;
  }
  /**����itemkind��Ϣ
   * @param prpCitemKindDtoList itemkind����Ϣ
   */
  public void setPrpCitemKindDtoList(ArrayList prpCitemKindDtoList)
  {
    this.prpCitemKindDtoList = prpCitemKindDtoList;
  }

  /**�õ�address��Ϣ
   * @return  address ��Ϣ
   */
  public ArrayList getPrpCaddressDtoList()
  {
    return prpCaddressDtoList;
  }
  /**����address��Ϣ
   * @param prpCaddressDtoList address����Ϣ
   */
  public void setPrpCaddressDtoList(ArrayList prpCaddressDtoList)
  {
    this.prpCaddressDtoList = prpCaddressDtoList;
  }

  /**�õ�insured��Ϣ
   * @return  insured ��Ϣ
   */
  public ArrayList getPrpCinsuredDtoList()
  {
    return prpCinsuredDtoList;
  }
  /**����insured��Ϣ
   * @param prpCinsuredDtoList insured����Ϣ
   */
  public void setPrpCinsuredDtoList(ArrayList prpCinsuredDtoList)
  {
    this.prpCinsuredDtoList = prpCinsuredDtoList;
  }

  /**�õ�PrpCitem_car��Ϣ
   * @return  itemcar ��Ϣ PrpCitemCarDto
   */
  public ArrayList getPrpCitemCarDtoList()
  {
    return prpCitemCarDtoList;
  }
  /**����itemcar��Ϣ
   * @param PrpCitemCarDtoList itemcar����Ϣ
   */
  public void setPrpCitemCarDtoList(ArrayList prpCitemCarDtoList)
  {
    this.prpCitemCarDtoList = prpCitemCarDtoList;
  }


  /**�õ�carDriver��Ϣ
   * @return  carDriver ��Ϣ
   */
  public ArrayList getPrpCcarDriverDtoList()
  {
    return prpCcarDriverDtoList;
  }

  /**�õ���������״̬��Ϣ
    * @return ��������״̬��Ϣ
    */

  public PrpLclaimStatusDto getPrpLclaimStatusDto() {
    return prpLclaimStatusDto;
  }

  public ArrayList getPrpCprofitDetailDtoList() {
    return prpCprofitDetailDtoList;
  }

  public ArrayList getPrpCplanDtoList() {
    return prpCplanDtoList;
  }

  /**����insured��Ϣ
   * @param prpCinsuredDtoList insured����Ϣ
   */
  public void setPrpCcarDriverDtoList(ArrayList prpCcarDriverDtoList)
  {
    this.prpCcarDriverDtoList = prpCcarDriverDtoList;
  }
  /**������������״̬��Ϣ
   * @param prpLclaimStuatsDto ��������״̬��Ϣ
   */
  public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto) {
    this.prpLclaimStatusDto = prpLclaimStatusDto;
  }

  public void setPrpCprofitDetailDtoList(ArrayList prpCprofitDetailDtoList) {
    this.prpCprofitDetailDtoList = prpCprofitDetailDtoList;
  }

  public void setPrpCplanDtoList(ArrayList prpCplanDtoList) {
    this.prpCplanDtoList = prpCplanDtoList;
  }

  /**�õ��ر�Լ����Ϣ
   * @return �ر�Լ����Ϣ
   */
  public ArrayList getPrpCengageDtoList() {
    return prpCengageDtoList;
  }

  public ArrayList getPrpCprofitDtoList() {
    return prpCprofitDtoList;
  }

  public ArrayList getPrpCfeeDtoList() {
    return prpCfeeDtoList;
  }

  /**�����ر�Լ����Ϣ
   * @param prpCengageDtoList �ر�Լ����Ϣ
   */
  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
    this.prpCengageDtoList = prpCengageDtoList;
  }

  public void setPrpCprofitDtoList(ArrayList prpCprofitDtoList) {
    this.prpCprofitDtoList = prpCprofitDtoList;
  }

  public void setPrpCfeeDtoList(ArrayList prpCfeeDtoList) {
    this.prpCfeeDtoList = prpCfeeDtoList;
  }
  
  //modify by wangwei add start 20050601
  /**���û����ձ�����Ϣ
   * @return �����ձ�����Ϣ 
   * */
  public PrpCmainCargoDto getPrpCmainCargoDto() {
      return this.prpCmainCargoDto;
  }
  
  /**�õ������ձ�����Ϣ
   * @param prpCmain_cargoDto �����ձ�����Ϣ
   * */
  public void setPrpCmainCargoDto(PrpCmainCargoDto prpCmainCargoDto) {
  	  this.prpCmainCargoDto = prpCmainCargoDto;
  }
  //modify by wangwei add end 20050601

	//modify by qinyongli add start 20050718
	/**����������׷����
	 * @return ������׷���� 
	 * */
	public DateTime getLiabStartDate() {
	    return this.liabStartDate;
	}
	
	/**�õ�������׷����
	 * @param  ������׷����
	 * */
	public void setLiabStartDate(DateTime liabStartDate) {
		  this.liabStartDate = liabStartDate;
	}
	//modify by wangwei add end 20050718

	public ArrayList getPrpCitemHouseDtoList() {
		return prpCitemHouseDtoList;
	}

	public void setPrpCitemHouseDtoList(ArrayList prpCitemHouseDtoList) {
		this.prpCitemHouseDtoList = prpCitemHouseDtoList;
	}

	public PrpCmainLoanDto getPrpCmainLoanDto() {
		return prpCmainLoanDto;
	}

	public void setPrpCmainLoanDtoList(PrpCmainLoanDto prpCmainLoanDto) {
		this.prpCmainLoanDto = prpCmainLoanDto;
	}

	public PrpCmainOriginDto getPrpCmainOriginDto() {
		return prpCmainOriginDto;
	}

	public void setPrpCmainOriginDto(PrpCmainOriginDto prpCmainOriginDto) {
		this.prpCmainOriginDto = prpCmainOriginDto;
	}

	public ArrayList getPrpCcoinsDtoList() {
		return prpCcoinsDtoList;
	}

	public void setPrpCcoinsDtoList(ArrayList prpCcoinsDtoList) {
		this.prpCcoinsDtoList = prpCcoinsDtoList;
	}

	public ArrayList getPrpCcoinsDetailDtoList() {
		return prpCcoinsDetailDtoList;
	}

	public void setPrpCcoinsDetailDtoList(ArrayList prpCcoinsDetailDtoList) {
		this.prpCcoinsDetailDtoList = prpCcoinsDetailDtoList;
	}
	
	}


