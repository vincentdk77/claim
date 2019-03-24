package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;

/**
 * �Զ��屨�����ݴ������
 * <p>Title: �������ⱨ��DTO</p>
 * <p>Description: �������ⱨ����������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class RegistDto implements Serializable
{
  /** ��������Ϣ*/
  private PrpLregistDto prpLregistDto;
  private PrplregisthisDto prplregisthisDto;
  /** ���߳�����Ϣ*/
  private ArrayList  prpLthirdPartyDtoList ;
  /** ��ʻԱ��Ϣ*/
  private ArrayList prpLdriverDtoList;
  /** ��ʧ��λ��Ϣ*/
  private ArrayList prpLthirdCarLossDtoList;
  /** ��Ա����������Ϣ*/
  private ArrayList prpLpersonTraceDtoList;
  /** ������Ϣ����˵��*/
  private ArrayList prpLregistExtDtoList;
  /** �ı���Ϣ*/
  private ArrayList prpLregistTextDtoList;
  /** ����״̬��Ϣ*/
  private PrpLclaimStatusDto prpLclaimStatusDto;
  /**�±�����ʾ�����������*/
  private PrpLscheduleNewDto prpLscheduleNewDto;
  /** �ر�Լ����Ϣ*/
  private ArrayList  prpCengageDtoList ;
  /** ����������Ϣ*/
  private PrpLscheduleMainWFDto prpLscheduleMainWFDto;
  /** ���ȱ����Ϣ*/
  private ArrayList  prpLscheduleItemDtoList ;

  /** ���ձ����Ϣ*/
  private ArrayList prpCitemKindDtoList;

  /** ��ʧ��λ��Ϣ*/
  private ArrayList prpLthirdPropDtoList;
  
  /****/
  //���Ķ�����嵥�б� Ϊ prpLcompensateEarDtoList  20110810 by GYIC ���� End!
  private ArrayList prpLcompensateEarDtoList;
  
  private ArrayList prpLearDtoList;
  //���Ķ�����嵥�б� Ϊ prpLcompensateEarDtoList  20110810 by GYIC ���� End!
  //modify by wangwei add strat 2005-06-18
  //ԭ����ӵ�����Ϣ
  private AcciCheckDto acciCheckDto;
  
  //modify by wangwei add start 20050601
  //ԭ��������ϵ����Ϣ
  private ArrayList prpLrelatePersonDtoList;
  //modify by wangwei add end 20050601
  
  //modify by wangwei add start 2005-06-14
  //ԭ�����ӳ��ڻ����˵ļ���������
  private String identifierName = "";
  
  //modify by wangwei add start 2005-06-16
  //ԭ����ӳʱ���Ϣ
  /** �ı���Ϣ*/
  private ArrayList prpLregistTextDtoList2;
  
  /**������Ա��Ϣ��*/
  private PrpLacciPersonDto prpLacciPersonDto;
  
  /** ������չ��Ϣ�� */
  private PrpLextDto prpLextDto;
  /** ������ 2006-06-09 by lym for ǿ��  */
  private PrpLRegistRPolicyDto prpLRegistRPolicyDto;
  /** �¹�����Ϣģ�� */
  private ArrayList prplacciBenPersonDtoList;
  /**����ԭ����ϸ��Ϣ*/
  private ArrayList prpLregistTextDtoList3;
  
  private ArrayList prplCompensateHouseDtoList;
  

	/**
	 * �õ��¹�����Ϣ
	 * 
	 * @return �¹��� ��Ϣ
	 */
	public ArrayList getPrplacciBenPersonDtoList() {
		return prplacciBenPersonDtoList;
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

	/**
	 * �����¹�����Ϣ
	 * 
	 * @param prplacciBenPersonDtoList
	 *            �¹�����Ϣ
	 */
	public void setPrplacciBenPersonDtoList(ArrayList prplacciBenPersonDtoList) {
		this.prplacciBenPersonDtoList = prplacciBenPersonDtoList;
	}
	
 //add by lym 20060605  for ǿ�� ---start ----
  
  /** ǿ��������Ϣ*/
  private List prpLRegistRPolicyList = new ArrayList();
 
  public void setPrpLRegistRPolicyList(List prpLRegistRPolicyList) {
  	  this.prpLRegistRPolicyList = prpLRegistRPolicyList;
  }
  
  public List getPrpLRegistRPolicyList() {
  	  return this.prpLRegistRPolicyList;
  }
  
  
  
  /** 
   * ��ù�����ǿ�Ʊ���������Ϣ
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyDtoOfCompel() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if ("0".equals(prpLRegistRPolicyDto.getRegistFlag())) {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }  
  /** 
   * ��ù�����ǿ�Ʊ���������Ϣ
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyBZ() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if(("0507".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0577".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0587".equals(prpLRegistRPolicyDto.getRiskCode()))&&"1".equals(prpLRegistRPolicyDto.getValidStatus()))
		  {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }
  /** 
   * ��ù�������ҵ�ձ���������Ϣ
   * @return
   */
  public PrpLRegistRPolicyDto getPrpLRegistRPolicyBusiness() {
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if(("0506".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0576".equals(prpLRegistRPolicyDto.getRiskCode())
				  ||"0586".equals(prpLRegistRPolicyDto.getRiskCode()))&&"1".equals(prpLRegistRPolicyDto.getValidStatus()))
		  {
			  return prpLRegistRPolicyDto;
		  }
	  }
	  return null;
  }
  
  /**
   * ��ñ����Ĺ�����������
   * @return
   * RegistDto.BUSINESS_COMPEL_POLICY:��ҵ����ǿ�Ʊ�����������
   * RegistDto.SING_BUSINESS_POLICY  :����ҵ��������
   * RegistDto.SING_COMPEL_POLICY    :��ǿ�Ʊ�������
   * RegistDto.NONE_RELATION_DATA    :���������޹�����������
   */
  public String getRegistType(){
	  boolean isHaveCompelPolicy = false;
	  boolean isHaveBusinessPolicy = false;
	  for (Iterator iter = prpLRegistRPolicyList.iterator(); iter.hasNext();) {
		  PrpLRegistRPolicyDto prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) iter.next();
		  if (PrpLRegistRPolicyDto.COMPEL_POLICY.equals(prpLRegistRPolicyDto.getPolicyType())) {
			  isHaveCompelPolicy = true;
		  }
		  if (PrpLRegistRPolicyDto.BUSINESS_POLICY.equals(prpLRegistRPolicyDto.getPolicyType())) {
			  isHaveBusinessPolicy = true;
		  }
	  }
	  if(isHaveBusinessPolicy&&isHaveCompelPolicy){
		  return BUSINESS_COMPEL_POLICY;
	  }
	  if(isHaveBusinessPolicy&&!isHaveCompelPolicy){
		  return SING_BUSINESS_POLICY;
	  }
	  if(!isHaveBusinessPolicy&&isHaveCompelPolicy){
		  return SING_COMPEL_POLICY;
	  }
	  if(!isHaveBusinessPolicy&&!isHaveCompelPolicy){
		  return NONE_RELATION_DATA;
	  }
	  return null;
  }
  
  
  //add by lym 20060605  for ǿ�� ---end ----
 
  /**���ó�����Ա��Ϣ��
   * @param prpLacciPersonDto ������Ա��Ϣ��
   */
  public void setPrpLacciPersonDto(PrpLacciPersonDto prpLacciPersonDto) {
  	  this.prpLacciPersonDto = prpLacciPersonDto;
  }
  
  /**�õ�������Ա��Ϣ��
   * @return  ������Ա��Ϣ��
   */
  public PrpLacciPersonDto getPrpLacciPersonDto() {
  	  return this.prpLacciPersonDto;
  }
  /**�õ��ʱ��ı���Ϣ
   * @return  �����ı���Ϣ
   */
  public ArrayList getPrpLregistTextDtoList2()
  {
    return prpLregistTextDtoList2;
  }
  /**���óʱ��ı���Ϣ
   * @param prpLregistTextDtoList �����ı���Ϣ
   */
  public void setPrpLregistTextDtoList2(ArrayList prpLregistTextDtoList2)
  {
    this.prpLregistTextDtoList2 = prpLregistTextDtoList2;
  }
  //modify by wangwei add end 2005-06-16
  
  /**
   * ��û�����Ϣ
   * @return ��û���Ϣ*/
  public String getIdentifierName() {
  	  return this.identifierName;
  }
  
  /**
   * ���û�����Ϣ
   * @param ������Ϣ*/
  public void setIdentifierName(String identifierName) {
  	  this.identifierName = identifierName;
  }
  //modify by wangwei add end 2005-06-14

  public RegistDto()
  {
  }

  /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLregistDto getPrpLregistDto()
  {
    return prpLregistDto;
  }

  /**���ñ���������Ϣ
   * @param prpLregistDto ����������Ϣ
   */
  public void setPrpLregistDto(PrpLregistDto prpLregistDto)
  {
     this.prpLregistDto = prpLregistDto;
  }

  /**�õ������ı���Ϣ
   * @return  �����ı���Ϣ
   */
  public ArrayList getPrpLregistTextDtoList()
  {
    return prpLregistTextDtoList;
  }
  /**���ñ����ı���Ϣ
   * @param prpLregistTextDtoList �����ı���Ϣ
   */
  public void setPrpLregistTextDtoList(ArrayList prpLregistTextDtoList)
  {
    this.prpLregistTextDtoList = prpLregistTextDtoList;
  }

  /**�õ����߳�����Ϣ
   * @return  ���߳�����Ϣ
   */
  public ArrayList getPrpLthirdPartyDtoList()
  {
    return prpLthirdPartyDtoList;
  }
  /**�������߳�����Ϣ
   * @param PrpLthirdPartyDtoList ���߳�������Ϣ
   */
  public void setPrpLthirdPartyDtoList(ArrayList prpLthirdPartyDtoList)
  {
    this.prpLthirdPartyDtoList = prpLthirdPartyDtoList;
  }

  /**�õ���ԦԱ��Ϣ
   * @return  ��ԦԱ ��Ϣ
   */
  public ArrayList getPrpLdriverDtoList()
  {
    return prpLdriverDtoList;
  }
  /**���ü�ԦԱ��Ϣ
   * @param PrpLdriverDtoList ��ԦԱ����Ϣ
   */
  public void setPrpLdriverDtoList(ArrayList prpLdriverDtoList)
  {
    this.prpLdriverDtoList = prpLdriverDtoList;
  }
  /**�õ���������״̬��Ϣ
    * @return ��������״̬��Ϣ
    */
   public PrpLclaimStatusDto getPrpLclaimStatusDto()
   {
     return prpLclaimStatusDto;
   }

   /**������������״̬��Ϣ
    * @param prpLclaimStuatsDto ��������״̬��Ϣ
    */
   public void setPrpLclaimStatusDto(PrpLclaimStatusDto prpLclaimStatusDto)
   {
      this.prpLclaimStatusDto = prpLclaimStatusDto;
   }

    /**�õ��±�����ʾ����Ϣ
    * @return �±�����ʾ����Ϣ
    */
   public PrpLscheduleNewDto getPrpLscheduleNewDto()
   {
     return prpLscheduleNewDto;
   }

  public ArrayList getPrpLthirdCarLossDtoList() {
    return prpLthirdCarLossDtoList;
  }

  /**�����±�����ʾ����Ϣ
    * @param prpLscheduleNewDto �±�����ʾ����Ϣ
    */
   public void setPrpLscheduleNewDto(PrpLscheduleNewDto prpLscheduleNewDto)
   {
      this.prpLscheduleNewDto = prpLscheduleNewDto;
   }

  public void setPrpLthirdCarLossDtoList(ArrayList prpLthirdCarLossDtoList) {
    this.prpLthirdCarLossDtoList = prpLthirdCarLossDtoList;
  }

    /**�õ����˸�����Ϣ
   * @return  ���˸��� ��Ϣ
   */
  public ArrayList getPrpLpersonTraceDtoList()
  {
    return prpLpersonTraceDtoList;
  }

  public ArrayList getPrpLregistExtDtoList() {
    return prpLregistExtDtoList;
  }

  /**�������˸�����Ϣ
   * @param PrpLpersonTraceDtoList ���˸��ٱ���Ϣ
   */
  public void setPrpLpersonTraceDtoList(ArrayList prpLpersonTraceDtoList)
  {
    this.prpLpersonTraceDtoList = prpLpersonTraceDtoList;
  }

  public void setPrpLregistExtDtoList(ArrayList prpLregistExtDtoList) {
    this.prpLregistExtDtoList = prpLregistExtDtoList;
  }

 //modify by lixiang add 20050315 start
//reason:���뱣�ձ����Ϣ�����ݣ������Ͽ���ֱ����ʾ�б��ձ�

   /**�õ�itemkind��Ϣ
   * @return  itemkind��Ϣ
   */
  public ArrayList getPrpCitemKindDtoList()
  {
    return prpCitemKindDtoList;
  }

  public ArrayList getPrpCengageDtoList() {
    return prpCengageDtoList;
  }

  /**����itemkind��Ϣ
   * @param prpCitemKindDtoList itemkind����Ϣ
   */
  public void setPrpCitemKindDtoList(ArrayList prpCitemKindDtoList)
  {
    this.prpCitemKindDtoList = prpCitemKindDtoList;
  }

  public void setPrpCengageDtoList(ArrayList prpCengageDtoList) {
    this.prpCengageDtoList = prpCengageDtoList;
  }

 /**�õ�����������Ϣ
   * @return ����������Ϣ
   */
  public PrpLscheduleMainWFDto getPrpLscheduleMainWFDto()
  {
    return prpLscheduleMainWFDto;
  }

  /**���õ���������Ϣ
   * @param prpLscheduleMainWFDto ����������Ϣ
   */
  public void setPrpLscheduleMainWFDto(PrpLscheduleMainWFDto prpLscheduleMainWFDto)
  {
     this.prpLscheduleMainWFDto = prpLscheduleMainWFDto;
  }

 /**�õ����ȱ����Ϣ
   * @return  ���ȱ����Ϣ
   */
  public ArrayList getPrpLscheduleItemDtoList()
  {
    return prpLscheduleItemDtoList;
  }
  /**���õ��ȱ����Ϣ
   * @param PrpLscheduleItemDto���ȱ����Ϣ
   */
  public void setPrpLscheduleItemDtoList(ArrayList prpLscheduleItemDtoList)
  {
    this.prpLscheduleItemDtoList = prpLscheduleItemDtoList;
  }

  /**����������ʧ��Ϣ
   * @param prpLthirdPropDtoList ������ʧ��Ϣ
   */

  public void setPrpLthirdPropDtoList(ArrayList prpLthirdPropDtoList) {
    this.prpLthirdPropDtoList = prpLthirdPropDtoList;
  }

  /**�õ�������ʧ��Ϣ
   * @return  ������ʧ��Ϣ
   */

   public ArrayList getPrpLthirdPropDtoList() {
     return prpLthirdPropDtoList;
   }
   
   /**������ϵ����Ϣ
    * @param prpLrelatePersonDtoList ��ϵ����Ϣ
    * */
   public void setPrpLrelatePersonDtoList(ArrayList prpLrelatePersonDtoList) {
   	   this.prpLrelatePersonDtoList = prpLrelatePersonDtoList;
   }
   
   /**�õ���ϵ����Ϣ
    * @return �õ���ϵ����Ϣ
    * */
   public ArrayList getPrpLrelatePersonDtoList() {
   	   return this.prpLrelatePersonDtoList;
   }
   
   /**
    * ���õ�����Ϣ
    * @param acciCheckDto ������Ϣ
    * */
   public void setAcciCheckDto(AcciCheckDto acciCheckDto) {
   	  this.acciCheckDto = acciCheckDto;
   }
   
   /**
    * ��õ�����Ϣ
    *@return ������Ϣ
    **/
   public AcciCheckDto getAcciCheckDto( ) {
   	  return this.acciCheckDto;
   }
   
   /**
    * ����������չ��Ϣ
    * @param acciCheckDto ������չ��Ϣ
    * */
   public void setPrpLextDto(PrpLextDto prpLextDto){
   	  this.prpLextDto = prpLextDto;
   }
   /**
    * �õ�������չ��Ϣ
    * @return �õ�������չ��Ϣ
    * */
   public PrpLextDto getPrpLextDto(){
   	  return prpLextDto;
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
    * ����ҵ��������
    */
   public static final String SING_BUSINESS_POLICY = "10";
   /**
    * ��ǿ�Ʊ�������
    */
   public static final String SING_COMPEL_POLICY = "01";
   /**
    * ��ҵ����ǿ�Ʊ����������� 
    */
   public static final String BUSINESS_COMPEL_POLICY = "11";
   /**
    * ���������޹�����������
    */
   public static final String NONE_RELATION_DATA = "00";


   public ArrayList getPrpLearDtoList() {
	   return prpLearDtoList;
   }

   public void setPrpLearDtoList(ArrayList prpLearDtoList) {
	   this.prpLearDtoList = prpLearDtoList;
   }
   
   public ArrayList getPrpLcompensateEarDtoList() {
	   return prpLcompensateEarDtoList;
   }

   public void setPrpLcompensateEarDtoList(ArrayList prpLcompensateEarDtoList) {
	   this.prpLcompensateEarDtoList = prpLcompensateEarDtoList;
   }
   
   public ArrayList getPrpLregistTextDtoList3() {
	   return prpLregistTextDtoList3;
   }

   public void setPrpLregistTextDtoList3(ArrayList prpLregistTextDtoList3) {
	   this.prpLregistTextDtoList3 = prpLregistTextDtoList3;
   }

/**
 * @return the prplregisthisDto
 */
public PrplregisthisDto getPrplregisthisDto() {
	return prplregisthisDto;
}

/**
 * @param prplregisthisDto the prplregisthisDto to set
 */
public void setPrplregisthisDto(PrplregisthisDto prplregisthisDto) {
	this.prplregisthisDto = prplregisthisDto;
}

}
