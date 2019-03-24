package com.sinosoft.claim.ui.control.viewHelper;

import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.*;

import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.dto.domain.NyxpolicylistDto;
import com.gyic.claim.dto.domain.TemblorpolicylistDto;
import com.sinosoft.claim.bl.action.custom.BLEndorseAction;
import com.sinosoft.claim.dto.custom.*;
import com.sinosoft.claim.dto.domain.*;
import com.sinosoft.claim.ui.control.action.*;
import com.sinosoft.claim.resource.dtofactory.domain.*;
import com.sinosoft.nyx.blsvr.BLHerdEndorChgDetail;
import com.sinosoft.nyx.blsvr.BLHerdEndorHead;
import com.sinosoft.nyx.blsvr.BLPlanting31EndorChgDetail;
import com.sinosoft.nyx.blsvr.BLPlantingEndorChgDetail;
import com.sinosoft.nyx.blsvr.BLPlantingEndorHead;
import com.sinosoft.nyx.blsvr.BLNyxEndorHead;
import com.sinosoft.nyx.blsvr.BLNyxEndorChgDetail;

import com.sinosoft.nyx.schema.HerdEndorChgDetailSchema;
import com.sinosoft.nyx.schema.HerdEndorHeadSchema;
import com.sinosoft.nyx.schema.Planting31EndorChgDetailSchema;
import com.sinosoft.nyx.schema.PlantingEndorChgDetailSchema;
import com.sinosoft.nyx.schema.NyxEndorChgDetailSchema;
import com.sinosoft.nyx.schema.NyxEndorHeadSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.temblor.blsvr.misc.BLTemblorEndorChgDetail;
import com.sinosoft.temblor.blsvr.misc.BLTemblorEndorHead;
import com.sinosoft.temblor.schema.TemblorEndorChgDetailSchema;

import org.apache.commons.beanutils.PropertyUtils;
/**
 * <p>Title: ClaimStatusViewHelper</p>
 * <p>Description:����ڵ�״̬ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� liubvo
 * @version 1.0
 * <br>
 */

 public class EndorseViewHelper
 {

    /**
    * Ĭ�Ϲ��췽��
    */
    public EndorseViewHelper()
    {
    }
    private PolicyDto policyDto = null;
    private HerdpolicylistDto herdpolicylistDto = null;
    /**
     * ���������Чǰ���±���
     * @param policyNo
     * @return �Զ��屣������
     * @throws SQLException
     * @throws Exception
     */
    public PolicyDto findForEndorBefore(String policyNo)
      throws SQLException,Exception
    {      
        PolicyDto policyDtoRe = null;
        String curHour =String.valueOf(DateTime.current().getHour());
        DateTime curDate = new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY);
        
        return findForEndorBefore(policyNo,curDate.toString(),curHour);
    }  
    
    /**
     * ���������Чǰ���±���  
     * @param policyNo
     * @return �Զ��屣������
     * @throws SQLException
     * @throws Exception
     * add by qinyongli �Ա����Ļ�ԭ���뾫ȷ��Сʱ
     */
    public PolicyDto findForEndorBefore(String strPolicyNo,String strDamageDate)
      throws SQLException,Exception
    {      
    	String curHour =String.valueOf(DateTime.current().getHour());	
        return findForEndorBefore(strPolicyNo,strDamageDate,curHour);
    }
    
    /**
    *STUB-ONLY����Գ��ձ����Ļص�
    *@param     �������ڻ�������������
    *@return    ���1������֮ǰ�ı�������Ϣ
    *@throws UserException
    *@throws Exception
    *modify by qinyongli start 2005-8-5   reason:����Сʱ�ж�
    */
    public PolicyDto findForEndorBefore(String strPolicyNo,String strDamageDate,String strDamageHour) throws Exception
    {
      PolicyDto policyDtoRe = null;
      //ȡ�õ�ǰ��������Ϣ
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
      //���ַ���ת��������
      int theDamageHour = 0;
      if(strDamageHour!=null&&!strDamageHour.equals("")&&strDamageHour.length()>1){
          theDamageHour = Integer.parseInt(strDamageHour.substring(0,2));
      }
      //modify by qinyongli start 2005-8-5 
      //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
      if(strDamageDate!=null&&!strDamageDate.equals("")&&strDamageDate.length()>9){
      	strDamageDate = strDamageDate.substring(0,10);
      }     
      //modify by qinyongli end 2005-8-5
     
      PrpPheadDto  prpPheadDto = new PrpPheadDto();
      //ȡ��������Ϣ����Ϣ
      UIEndorseAction uiEndorseAction = new UIEndorseAction();
      String iWherePart = "PolicyNo = '"+strPolicyNo+"'"
				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
				        + " AND UnderWriteFlag in ('1', '3') "
				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
      System.out.println("iWherePart start iWherePart="+iWherePart);
      ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
      System.out.println("iWherePart end");
      //û���ҵ����������������򷵻ص�ǰ����
      if (listTemp==null||listTemp.size()<1){
        policyDtoRe = policyDto;
      }
      else{
        //�ҵ����𼶻ع�������Ϣ
        for (int i = 0; i < listTemp.size(); i++) {
          prpPheadDto = (PrpPheadDto)listTemp.get(i);
          backWard(prpPheadDto.getEndorseNo());
        }
        policyDtoRe = policyDto;
      }
      return policyDtoRe;
    }

    /**
    *STUB-ONLY��
    
    *@param  �ص�����
    *@return ��
    *@throws UserException
    *@throws Exception
    */
    public void backWard(String strEndorseNo) throws Exception
    {
      //��ȡ���ı仯��Ϣ
      UIEndorseAction uiEndorseAction = new UIEndorseAction();
      EndorseDto endorseDto = uiEndorseAction.findByPrimaryKey(strEndorseNo);
      //this.getData(strEndorseNo);
      //��Ҫ PrpCmainDto��PrpCitemCarDtoList,prpCitemKindDtoList,prpCprofitDtoList,prpCengageDtoList,prpCfeeDto
      //System.out.println("--------backWard-----------1---------");
      policyDto.setPrpCmainDto(backWardPrpCmain(policyDto.getPrpCmainDto(),endorseDto));
      //System.out.println("--------backWard-----------2---------");
      policyDto.setPrpCitemCarDtoList(this.backWardPrpCitem_car(policyDto.getPrpCitemCarDtoList(),endorseDto));
      //System.out.println("--------backWard-----------3---------");
      policyDto.setPrpCprofitDtoList(this.backWardPrpCprofit(policyDto.getPrpCprofitDtoList(),endorseDto));
      //System.out.println("--------backWard-----------4---------");
      policyDto.setPrpCengageDtoList(this.backWardPrpCengage(policyDto.getPrpCengageDtoList(),endorseDto));
      //System.out.println("--------backWard-----------5---------");
      policyDto.setPrpCitemKindDtoList(this.backWardPrpCitemKind(policyDto.getPrpCitemKindDtoList(),endorseDto));
      //System.out.println("--------backWard-----------6---------");
      policyDto.setPrpCfeeDtoList(this.backWardPrpCfee(policyDto.getPrpCfeeDtoList(),endorseDto));
      //System.out.println("--------backWard-----------7---------");
      policyDto.setPrpCcoinsDtoList(this.backWardPrpCcoins(policyDto.getPrpCcoinsDtoList(), endorseDto));
      //blPolicy.setBLPrpCmain(this.getBLPrpPmain().backWard(blPolicy.getBLPrpCmain()));
      //blPolicy.setBLPrpCitem_car(this.getBLPrpPitemCar().backWard(blPolicy.getBLPrpCitem_car()));
      //blPolicy.setBLPrpCprofit(this.getBLPrpPprofit().backWard(blPolicy.getBLPrpCprofit()));
      //blPolicy.setBLPrpCengage(this.getBLPrpPengage().backWard(blPolicy.getBLPrpCengage()));
      //blPolicy.setBLPrpCitemKind(this.getBLPrpPitemKind().backWard(blPolicy.getBLPrpCitemKind()));
      //blPolicy.setBLPrpCfee(this.getBLPrpPfee().backWard(blPolicy.getBLPrpCfee()));
    }
    /**
     *STUB-ONLY����Գ��ձ����Ļص�
     *@param     �������ڻ�������������
     *@return    ����ʱ��Ч���嵥��Ϣ
     *@throws UserException
     *@throws Exception
     */
    
     public HerdpolicylistDto findForEndorHerdpolicylistBefore(HerdpolicylistDto herdpolicylistDto,String kindCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception
     {
    	this.herdpolicylistDto = herdpolicylistDto;
       //���ַ���ת��������
       int theDamageHour = 0;
       if(strDamageHour!=null&&strDamageHour.length()>0){
           theDamageHour = Integer.parseInt(strDamageHour);
       }
       //modify by qinyongli start 2005-8-5 
       //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
       if(strDamageDate!=null&&strDamageDate.length()>9){
    	   strDamageDate = strDamageDate.substring(0,10);
       }     
       //modify by qinyongli end 2005-8-5
      
       PrpPheadDto  prpPheadDto = new PrpPheadDto();
       //ȡ��������Ϣ����Ϣ
       /**
        *modify by GYIC�ž��� �Զ������İ���������Ž�������
        */
       UIEndorseAction uiEndorseAction = new UIEndorseAction();
       String iWherePart = "PolicyNo = '"+policyNo+"'"
 				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
 						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
 				        + " AND UnderWriteFlag in ('1', '3') "
 				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
       ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
       //û���ҵ����������������򷵻ص�ǰ�嵥
       if (listTemp == null || listTemp.size() == 0){
    	   	return this.herdpolicylistDto;
       }
       for (int i = 0; i < listTemp.size(); i++) {
			prpPheadDto = (PrpPheadDto)listTemp.get(i);
	    	//�ҵ����𼶻ع��嵥��Ϣ
			//��ʼ����ͷ��
			BLHerdEndorHead blHerdEndorHead = new BLHerdEndorHead();
			blHerdEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' and ENDORFLAG ='29'");
			if (blHerdEndorHead == null || blHerdEndorHead.getSize() == 0){
				continue;
			}
			if (blHerdEndorHead.getSize() > 1){
				throw new UserException(1,3,"������:" + blHerdEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
			}
			//��ʼ���ı仯����
			BLHerdEndorChgDetail blHerdEndorChgDetail = new BLHerdEndorChgDetail();
			blHerdEndorChgDetail.query("ENDORSENO = '" + blHerdEndorHead.getArr(0).getEndorseNo() +
			"' and EARLABEL = '" + herdpolicylistDto.getEarlabel() +
			"' and INUSRELISTCODE ='" + herdpolicylistDto.getInusrelistcode() +
			"' and KINDCODE ='" + herdpolicylistDto.getKindcode() +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
			if (blHerdEndorChgDetail == null || blHerdEndorChgDetail.getSize() == 0){
				continue;
			}
			if (blHerdEndorChgDetail.getSize() > 1){
				throw new UserException(1,3,"������:" + blHerdEndorHead.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
			}
			backWard(blHerdEndorChgDetail.getArr(0));
       }
       return this.herdpolicylistDto;
       /**
        *modify by GYIC�ž��� ɾ���Զ������İ���������Чʱ���������
        */
       /*UIEndorseAction uiEndorseAction = new UIEndorseAction();
       *       String iWherePart = "PolicyNo = '"+strPolicyNo+"'"
       * 				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
       * 						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
       * 				        + " AND UnderWriteFlag in ('1', '3') "
       * 				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
       *       ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
       *       //û���ҵ����������������򷵻ص�ǰ�嵥
       *       if (listTemp==null||listTemp.size()<1){
       *    	   herdpolicylistDtoRe = herdpolicylistDto;
       *       }
       *       else{
       *           //�ҵ����𼶻ع��嵥��Ϣ
       *           for (int i = 0; i < listTemp.size(); i++) {
       *             prpPheadDto = (PrpPheadDto)listTemp.get(i);
       *             BLHerdEndorHead blHerdEndorHead = new BLHerdEndorHead();
       *             blHerdEndorHead.query("EndorseNo ='" + prpPheadDto.getEndorseNo() + "' and ENDORFLAG ='0'");
       *             if( blHerdEndorHead.getSize() > 1 )
       *            	 throw new UserException(-98,-1000,this.getClass().getName());
       *             else if(blHerdEndorHead.getSize() == 0)
       *            	 continue;
       *             else
       *             {
       *            	 BLHerdEndorChgDetail blHerdEndorChgDetail = new BLHerdEndorChgDetail();
       *            	 blHerdEndorChgDetail.query("INUSRELISTCODE = '" + blHerdEndorHead.getArr(0).getInusreListCode()+
       *            			 "' and earlabel = '"+herdpolicylistDto.getEarlabel()+
       *            			 "' and kindcode ='"+herdpolicylistDto.getKindcode()+
       *            			 "' and VALIDITY = '1'");
       *            	 if( blHerdEndorChgDetail.getSize() > 1 )
       *                	 throw new UserException(-98,-1000,this.getClass().getName());
       *            	 else if(blHerdEndorChgDetail.getSize() == 0)
       *            		 continue;
       *                 else
       *                 {
       *                	 backWard(blHerdEndorChgDetail.getArr(0));
       *                	 herdpolicylistDtoRe = this.herdpolicylistDto;
       *                 }
       *             }
       *           }
       *         }
       */
     }
     /**
      *STUB-ONLY��
      
      *@param  �ص��嵥,ֻ�ع����
      *@return ��
      *@throws UserException
      *@throws Exception
      */
      public void backWard(HerdEndorChgDetailSchema herdEndorChgDetailSchema) throws Exception
      {
    	  if("D".equals(herdEndorChgDetailSchema.getFlag()))//ɾ�������������˽����Ϊ��Ч
		  {
    		//this.herdpolicylistDto.setInusrelistcode(herdEndorChgDetailSchema.getInusreListCode());
    		//this.herdpolicylistDto.setEarlabel(herdEndorChgDetailSchema.getEarLabel());
    		//this.herdpolicylistDto.setKindcode(herdEndorChgDetailSchema.getKindCode());
    		//this.herdpolicylistDto.setIndexcode(herdEndorChgDetailSchema.getIndexCode());
    		//this.herdpolicylistDto.setFcode(herdEndorChgDetailSchema.getFCode());
    		//this.herdpolicylistDto.setFname(herdEndorChgDetailSchema.getFName());
    		//this.herdpolicylistDto.setFidcard(herdEndorChgDetailSchema.getFIdCard());
    		//this.herdpolicylistDto.setBreedingareacode(herdEndorChgDetailSchema.getBreedingAreaCode());
    		//this.herdpolicylistDto.setSpecies(herdEndorChgDetailSchema.getSpecies());
    		//this.herdpolicylistDto.setBreedingkind(herdEndorChgDetailSchema.getBreedingKind());
    		//this.herdpolicylistDto.setBank(herdEndorChgDetailSchema.getBank());
    		//this.herdpolicylistDto.setBankcard(herdEndorChgDetailSchema.getBankCard());
    		//this.herdpolicylistDto.setInsurenumber(Long.valueOf(herdEndorChgDetailSchema.getInsureNumber()));
    		//this.herdpolicylistDto.setAmount(Double.valueOf(herdEndorChgDetailSchema.getAmount()));
    		//this.herdpolicylistDto.setRate(Double.valueOf(herdEndorChgDetailSchema.getRate()));
    		//this.herdpolicylistDto.setShortrateflag(herdEndorChgDetailSchema.getShortRateFlag());
    		//this.herdpolicylistDto.setShortrate(Double.valueOf(herdEndorChgDetailSchema.getShortRate()));
    		//this.herdpolicylistDto.setSumamount(Double.valueOf(herdEndorChgDetailSchema.getSumAmount()));
    		//this.herdpolicylistDto.setSumpremium(Double.valueOf(herdEndorChgDetailSchema.getSumPremium()));
    		//this.herdpolicylistDto.setStartdate(new DateTime(herdEndorChgDetailSchema.getStartDate(),DateTime.YEAR_TO_DAY));
    		//this.herdpolicylistDto.setEnddate(new DateTime(herdEndorChgDetailSchema.getEndDate(),DateTime.YEAR_TO_DAY));
    		//this.herdpolicylistDto.setCalculateflag(herdEndorChgDetailSchema.getCalculateFlag());
    		//this.herdpolicylistDto.setOpcode(herdEndorChgDetailSchema.getOpCode());
    		//this.herdpolicylistDto.setOptime(new DateTime(herdEndorChgDetailSchema.getOpTime(),DateTime.YEAR_TO_MINUTE));
    		//this.herdpolicylistDto.setValidity(herdEndorChgDetailSchema.getValidity());
    		//this.herdpolicylistDto.setRemark(herdEndorChgDetailSchema.getRemark());
    		//this.herdpolicylistDto.setBreedingnumber(Long.valueOf(""));//Long.valueOf(herdEndorChgDetailSchema.getBreedingnumber())
    		//this.herdpolicylistDto.setBreedingareaname(herdEndorChgDetailSchema.getBreedingAreaName());
    		//this.herdpolicylistDto.setStarttime(herdEndorChgDetailSchema.getStartDate());
    		//this.herdpolicylistDto.setEndtime(herdEndorChgDetailSchema.getEndDate());
    		//this.herdpolicylistDto.setPhone("");
    		//this.herdpolicylistDto.setSettlenumber(Long.valueOf(""));//Long.valueOf(herdEndorChgDetailSchema.gets)
            //herdpolicylistDto.setINSUREPREMIUM
    		  this.herdpolicylistDto.setInsurenumber(this.herdpolicylistDto.getInsurenumber()-Long.valueOf(herdEndorChgDetailSchema.getChgInsureNumber()));
			  this.herdpolicylistDto.setSumamount(this.herdpolicylistDto.getSumamount()-Double.valueOf(herdEndorChgDetailSchema.getChgSumAmount()));
			  this.herdpolicylistDto.setSumpremium(this.herdpolicylistDto.getSumpremium()-Double.valueOf(herdEndorChgDetailSchema.getChgSumPremium()));
    		  this.herdpolicylistDto.setValidity("1");
		  }	
    	  else if("I".equals(herdEndorChgDetailSchema.getFlag()))//���������������˽����Ϊ��Ч
    	  {
    		  this.herdpolicylistDto.setInsurenumber(this.herdpolicylistDto.getInsurenumber()-Long.valueOf(herdEndorChgDetailSchema.getChgInsureNumber()));
			  this.herdpolicylistDto.setSumamount(this.herdpolicylistDto.getSumamount()-Double.valueOf(herdEndorChgDetailSchema.getChgSumAmount()));
			  this.herdpolicylistDto.setSumpremium(this.herdpolicylistDto.getSumpremium()-Double.valueOf(herdEndorChgDetailSchema.getChgSumPremium()));
    		  this.herdpolicylistDto.setValidity("0");
    	  }	
    	  else if("U".equals(herdEndorChgDetailSchema.getFlag()))//�޸Ĳ��������޸Ľ�������Ϣ�������л���
    	  {
    		//this.herdpolicylistDto.setFname(herdEndorChgDetailSchema.getFName());
      		//this.herdpolicylistDto.setFidcard(herdEndorChgDetailSchema.getFIdCard());
    		//this.herdpolicylistDto.setBank(herdEndorChgDetailSchema.getBank());
      		//this.herdpolicylistDto.setBankcard(herdEndorChgDetailSchema.getBankCard());
    	  }
    	  else
    		  throw new UserException(1,-1007,this.getClass().getName());
      }
      /**
       * add by Li, Yang. 2011 11 17.
       * ���ݳ���ʱ���ũ�����룬�ع������ũ���ĳб���Ϣ������ʱ��ʱ��
       *STUB-ONLY����Գ��ձ����Ļص�
       *@param     �������ڻ�������������
       *@return    ����ʱ��Ч���嵥��Ϣ
       *@throws UserException
       *@throws Exception
       */
      
       public PlantingpolicylistDto findForEndorPlantinpolicylistBefore(PlantingpolicylistDto plantingPolicyListDto, String riskCode,String kindCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception
       {
         //���ַ���ת��������
         int theDamageHour = 0;
         if(strDamageHour!=null&&strDamageHour.length()>0){
             theDamageHour = Integer.parseInt(strDamageHour.substring(0, 2));
         }
         //modify by qinyongli start 2005-8-5 
         //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
         if(strDamageDate!=null&&strDamageDate.length()>9){
      	   strDamageDate = strDamageDate.substring(0,10);
         }     
         //modify by qinyongli end 2005-8-5
        
         PrpPheadDto  prpPheadDto = new PrpPheadDto();
         //ȡ��������Ϣ����Ϣ
         /**
          *modify by GYIC Li, Yang ����¼�����ںͳ��մ�����������
          */
         UIEndorseAction uiEndorseAction = new UIEndorseAction();
         String iWherePart = "PolicyNo = '"+policyNo+"'"
   				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
   						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
   				        + " AND UnderWriteFlag in ('1', '3') "
   				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
         ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
         //û���ҵ����������������򷵻ص�ǰ�嵥
         if (listTemp == null || listTemp.size() == 0){
      	   	return plantingPolicyListDto;
         }
         for (int i = 0; i < listTemp.size(); i++) {
  			prpPheadDto = (PrpPheadDto)listTemp.get(i);
  	    	//�ҵ����𼶻ع��嵥��Ϣ
  			//��ʼ����ͷ��
  			BLPlantingEndorHead blPlantingEndorHead = new BLPlantingEndorHead();
  			blPlantingEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' and (ENDORFLAG like '93' or ENDORFLAG like '14')");
  			if (blPlantingEndorHead == null || blPlantingEndorHead.getSize() == 0){
  				continue;
  			}
  			if (blPlantingEndorHead.getSize() > 1){
  				throw new UserException(1,3,"������:" + blPlantingEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
  			}
  			//��ʼ���ı仯����
  			BLPlantingEndorChgDetail blPlantingEndorChgDetail = new BLPlantingEndorChgDetail();
  			blPlantingEndorChgDetail.query("ENDORSENO = '" + blPlantingEndorHead.getArr(0).getEndorseNo() +"' "+
  			" and FCODE like '" + plantingPolicyListDto.getFcode() +"' "+
  			" and INUSRELISTCODE like '" + plantingPolicyListDto.getInusrelistcode() +"' "+
  			" and KINDCODE like '" + plantingPolicyListDto.getKindcode() +"' "+
  			" and RISKCODE like '" + plantingPolicyListDto.getRiskcode() +"' "+
  			" and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
  			if ( null == blPlantingEndorChgDetail || blPlantingEndorChgDetail.getSize() == 0){
  				continue;
  			}
  			if (blPlantingEndorChgDetail.getSize() > 1){
  				throw new UserException(1,3,"������:" + blPlantingEndorChgDetail.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
  			}
  			backWardPlantingPolicyList(plantingPolicyListDto,blPlantingEndorChgDetail.getArr(0));
         }
         return plantingPolicyListDto;
       }
       /**
        *STUB-ONLY��
        
        *@param  �ع���ֲ�ձ����嵥��
        *@return ��
        *@throws UserException
        *@throws Exception
        */
        public PlantingpolicylistDto backWardPlantingPolicyList(PlantingpolicylistDto plantingPolicyListDto, PlantingEndorChgDetailSchema plantingEndorChgDetailSchema) throws Exception{
      	  if("D".equals(plantingEndorChgDetailSchema.getFlag())){//ɾ�������������˽����Ϊ��Ч
      		plantingPolicyListDto.setSumamount(plantingPolicyListDto.getSumamount()-plantingEndorChgDetailSchema.getChgSumAmount().doubleValue());
      		plantingPolicyListDto.setInsurearea(plantingPolicyListDto.getInsurearea()-plantingEndorChgDetailSchema.getChgInsureArea().doubleValue());
      		plantingPolicyListDto.setValidity("1");
  		  }
      	  else if("I".equals(plantingEndorChgDetailSchema.getFlag())){//���������������˽����Ϊ��Ч
        	plantingPolicyListDto.setSumamount(plantingPolicyListDto.getSumamount()-plantingEndorChgDetailSchema.getChgSumAmount().doubleValue());
          	plantingPolicyListDto.setInsurearea(plantingPolicyListDto.getInsurearea()-plantingEndorChgDetailSchema.getChgInsureArea().doubleValue());
      		plantingPolicyListDto.setValidity("0");
      	  }
      	  else if("U".equals(plantingEndorChgDetailSchema.getFlag())){//�޸Ĳ��������޸Ľ�������Ϣ�������л���
      		plantingPolicyListDto.setSumamount(plantingPolicyListDto.getSumamount()-plantingEndorChgDetailSchema.getChgSumAmount().doubleValue());
        	plantingPolicyListDto.setInsurearea(plantingPolicyListDto.getInsurearea()-plantingEndorChgDetailSchema.getChgInsureArea().doubleValue());
      		
      	  }
      	  else throw new UserException(1,-1007,this.getClass().getName());
      	  return plantingPolicyListDto;
       }
        /**
         * add by Li, Yang. 2012 08 04.
         * ���ݳ���ʱ���ũ�����룬�ع������ũ���ĳб���Ϣ������ʱ��ʱ��
         *STUB-ONLY����Գ��ձ����Ļص�
         *@param     �������ڻ�������������
         *@return    ����ʱ��Ч���嵥��Ϣ
         *@throws UserException
         *@throws Exception
         */
        
         public Planting31PolicyListDto findForEndorPlantin31PolicyListBefore(Planting31PolicyListDto planting31PolicyListDto, String riskCode,String kindCode,String itemCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception
         {
           //���ַ���ת��������
           int theDamageHour = 0;
           if(strDamageHour!=null&&strDamageHour.length()>0){
               theDamageHour = Integer.parseInt(strDamageHour.substring(0, 2));
           }
           //modify by qinyongli start 2005-8-5 
           //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
           if(strDamageDate!=null&&strDamageDate.length()>9){
        	   strDamageDate = strDamageDate.substring(0,10);
           }     
           //modify by qinyongli end 2005-8-5
          
           PrpPheadDto  prpPheadDto = new PrpPheadDto();
           //ȡ��������Ϣ����Ϣ
           /**
            *modify by GYIC Li, Yang ����¼�����ںͳ��մ�����������
            */
           UIEndorseAction uiEndorseAction = new UIEndorseAction();
           String iWherePart = "PolicyNo = '"+policyNo+"'"
     				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
     						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
     				        + " AND UnderWriteFlag in ('1', '3') "
     				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
           ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
           //û���ҵ����������������򷵻ص�ǰ�嵥
           if (listTemp == null || listTemp.size() == 0){
        	   	return planting31PolicyListDto;
           }
           for (int i = 0; i < listTemp.size(); i++) {
    			prpPheadDto = (PrpPheadDto)listTemp.get(i);
    	    	//�ҵ����𼶻ع��嵥��Ϣ
    			//��ʼ����ͷ��
    			BLPlantingEndorHead blPlantingEndorHead = new BLPlantingEndorHead();
    			blPlantingEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' and (ENDORFLAG like '93' or ENDORFLAG like '14')");
    			if (blPlantingEndorHead == null || blPlantingEndorHead.getSize() == 0){
    				continue;
    			}
    			if (blPlantingEndorHead.getSize() > 1){
    				throw new UserException(1,3,"������:" + blPlantingEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
    			}
    			//��ʼ���ı仯����
    			BLPlanting31EndorChgDetail blPlanting31EndorChgDetail = new BLPlanting31EndorChgDetail();
    			blPlanting31EndorChgDetail.query("ENDORSENO = '" + blPlantingEndorHead.getArr(0).getEndorseNo() +"' "+
    			" and FIDCARD = '" + planting31PolicyListDto.getFidCard() +"' "+
    			" and INUSRELISTCODE = '" + planting31PolicyListDto.getInusreListCode() +"' "+
    			" and KINDCODE = '" + planting31PolicyListDto.getKindCode() +"' "+
    			" and RISKCODE = '" + planting31PolicyListDto.getRiskCode() +"' "+
    			" and ITEMCODE = '" + planting31PolicyListDto.getItemCode() +"' "+
    			" and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
    			if ( null == blPlanting31EndorChgDetail || blPlanting31EndorChgDetail.getSize() == 0){
    				continue;
    			}
    			if (blPlanting31EndorChgDetail.getSize() > 1){
    				throw new UserException(1,3,"������:" + blPlanting31EndorChgDetail.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
    			}
    			backWardPlanting31PolicyList(planting31PolicyListDto,blPlanting31EndorChgDetail.getArr(0));
           }
           return planting31PolicyListDto;
         }
         
         public NyxpolicylistDto findForEndorPlantin3224PolicyListBefore(NyxpolicylistDto planting31PolicyListDto, String riskCode,String kindCode,String itemCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception
         {
           //���ַ���ת��������
           int theDamageHour = 0;
           if(strDamageHour!=null&&strDamageHour.length()>0){
               theDamageHour = Integer.parseInt(strDamageHour.substring(0, 2));
           }
           //modify by qinyongli start 2005-8-5 
           //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
           if(strDamageDate!=null&&strDamageDate.length()>9){
        	   strDamageDate = strDamageDate.substring(0,10);
           }     
           //modify by qinyongli end 2005-8-5
          
           PrpPheadDto  prpPheadDto = new PrpPheadDto();
           //ȡ��������Ϣ����Ϣ
           /**
            *modify by GYIC Li, Yang ����¼�����ںͳ��մ�����������
            */
           UIEndorseAction uiEndorseAction = new UIEndorseAction();
           String iWherePart = "PolicyNo = '"+policyNo+"'"
     				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
     						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
     				        + " AND UnderWriteFlag in ('1', '3') "
     				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
           ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
           //û���ҵ����������������򷵻ص�ǰ�嵥
           if (listTemp == null || listTemp.size() == 0){
        	   	return planting31PolicyListDto;
           }
           for (int i = 0; i < listTemp.size(); i++) {
    			prpPheadDto = (PrpPheadDto)listTemp.get(i);
    	    	//�ҵ����𼶻ع��嵥��Ϣ
    			//��ʼ����ͷ��
    			BLNyxEndorHead blNyxEndorHead = new BLNyxEndorHead();
    			blNyxEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' and (ENDORFLAG like '29' )");
    			if (blNyxEndorHead == null || blNyxEndorHead.getSize() == 0){
    				continue;
    			}
    			if (blNyxEndorHead.getSize() > 1){
    				throw new UserException(1,3,"������:" + blNyxEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
    			}
    			//��ʼ���ı仯����
    			
    			BLNyxEndorChgDetail blNyxEndorChgDetail = new BLNyxEndorChgDetail();
    			blNyxEndorChgDetail.query("ENDORSENO = '" + blNyxEndorHead.getArr(0).getEndorseNo() +"' "+
    			" and FIDCARD = '" + planting31PolicyListDto.getFidcard() +"' "+
    			" and INUSRELISTCODE = '" + planting31PolicyListDto.getInusrelistcode() +"' "+
    			" and KINDCODE = '" + planting31PolicyListDto.getKindcode() +"' "+
    			" and RISKCODE = '" + planting31PolicyListDto.getRiskcode() +"' "+
    			" and ITEMCODE = '" + planting31PolicyListDto.getItemcode() +"' "+
    			" and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
    			if ( null == blNyxEndorChgDetail || blNyxEndorChgDetail.getSize() == 0){
    				continue;
    			}
    			if (blNyxEndorChgDetail.getSize() > 1){
    				throw new UserException(1,3,"������:" + blNyxEndorChgDetail.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
    			}
    			backWardPlanting3224PolicyList(planting31PolicyListDto,blNyxEndorChgDetail.getArr(0));
           }
           return planting31PolicyListDto;
         }
         
         public TemblorpolicylistDto findForEndorTemblor0311PolicyListBefore(TemblorpolicylistDto temblorpolicylistDto, String riskCode,String kindCode,String itemCode,String policyNo,String strDamageDate,String strDamageHour) throws Exception
         {
           //���ַ���ת��������
           int theDamageHour = 0;
           if(strDamageHour!=null&&strDamageHour.length()>0){
               theDamageHour = Integer.parseInt(strDamageHour.substring(0, 2));
           }
           //modify by qinyongli start 2005-8-5 
           //reason:��ԭ����ʱ��㾫ȷ����,���ҽ��и�ʽ����
           if(strDamageDate!=null&&strDamageDate.length()>9){
        	   strDamageDate = strDamageDate.substring(0,10);
           }     
           //modify by qinyongli end 2005-8-5
          
           PrpPheadDto  prpPheadDto = new PrpPheadDto();
           //ȡ��������Ϣ����Ϣ
           /**
            *modify by GYIC Li, Yang ����¼�����ںͳ��մ�����������
            */
           UIEndorseAction uiEndorseAction = new UIEndorseAction();
           String iWherePart = "PolicyNo = '"+policyNo+"'"
     				        + " AND (ValidDate > sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd')"
     						         + " OR (ValidDate=sinosoft_to_date('"+strDamageDate+"','yyyy-mm-dd') AND ValidHour>"+theDamageHour +"))"
     				        + " AND UnderWriteFlag in ('1', '3') "
     				        + " ORDER BY InputDate DESC,EndorseTimes DESC ";
           ArrayList listTemp = (ArrayList)uiEndorseAction.findByPrpPheadConditions(iWherePart);
           //û���ҵ����������������򷵻ص�ǰ�嵥
           if (listTemp == null || listTemp.size() == 0){
        	   	return temblorpolicylistDto;
           }
           for (int i = 0; i < listTemp.size(); i++) {
    			prpPheadDto = (PrpPheadDto)listTemp.get(i);
    	    	//�ҵ����𼶻ع��嵥��Ϣ
    			//��ʼ����ͷ��
    			BLTemblorEndorHead blTemblorEndorHead = new BLTemblorEndorHead();
    			blTemblorEndorHead.query("ENDORSENO = '" + prpPheadDto.getEndorseNo() + "' and (ENDORFLAG like '29' )");
    			if (blTemblorEndorHead == null || blTemblorEndorHead.getSize() == 0){
    				continue;
    			}
    			if (blTemblorEndorHead.getSize() > 1){
    				throw new UserException(1,3,"������:" + blTemblorEndorHead.getArr(0).getEndorseNo() + "��Ӧ������ͷ���¼����Ψһ");
    			}
    			//��ʼ���ı仯����
    			
    			BLTemblorEndorChgDetail blTemblorEndorChgDetail = new BLTemblorEndorChgDetail();
    			blTemblorEndorChgDetail.query("ENDORSENO = '" + blTemblorEndorHead.getArr(0).getEndorseNo() +"' "+
    			" and IDCARD = '" + temblorpolicylistDto.getIdcard() +"' "+
    			" and INUSRELISTCODE = '" + temblorpolicylistDto.getInusrelistcode() +"' "+
    			" and ADDRESS = '" +temblorpolicylistDto.getAddress() +"' "+
    			" and KINDCODE = '" + temblorpolicylistDto.getKindcode() +"' "+
    			" and RISKCODE = '" + temblorpolicylistDto.getRiskcode() +"' "+
    			" and ITEMCODE = '" + temblorpolicylistDto.getItemcode() +"' "+
    			" and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))");
    			if ( null == blTemblorEndorChgDetail || blTemblorEndorChgDetail.getSize() == 0){
    				continue;
    			}
    			if (blTemblorEndorChgDetail.getSize() > 1){
    				throw new UserException(1,3,"������:" + blTemblorEndorChgDetail.getArr(0).getEndorseNo() + "��Ӧ�����ı仯�����¼����Ψһ");
    			}
    			backWardTemblor0311PolicyList(temblorpolicylistDto,blTemblorEndorChgDetail.getArr(0));
           }
           return temblorpolicylistDto;
         }
         
         
         /**
          *STUB-ONLY��
          
          *@param  �ع���ֲ�ձ����嵥��
          *@return ��
          *@throws UserException
          *@throws Exception
          */
          public Planting31PolicyListDto backWardPlanting31PolicyList(Planting31PolicyListDto planting31PolicyListDto, Planting31EndorChgDetailSchema planting31EndorChgDetailSchema) throws Exception{
        	  if("D".equals(planting31EndorChgDetailSchema.getFlag())){//ɾ�������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumAmount(planting31PolicyListDto.getSumAmount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsureArea(planting31PolicyListDto.getInsureArea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("1");
    		  }
        	  else if("I".equals(planting31EndorChgDetailSchema.getFlag())){//���������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumAmount(planting31PolicyListDto.getSumAmount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsureArea(planting31PolicyListDto.getInsureArea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("0");
        	  }
        	  else if("U".equals(planting31EndorChgDetailSchema.getFlag())){//�޸Ĳ��������޸Ľ�������Ϣ�������л���
        		  planting31PolicyListDto.setSumAmount(planting31PolicyListDto.getSumAmount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsureArea(planting31PolicyListDto.getInsureArea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		
        	  }
        	  else throw new UserException(1,-1007,this.getClass().getName());
        	  return planting31PolicyListDto;
         }
          
          
          public NyxpolicylistDto backWardPlanting3224PolicyList(NyxpolicylistDto planting31PolicyListDto, NyxEndorChgDetailSchema planting31EndorChgDetailSchema) throws Exception{
        	  if("D".equals(planting31EndorChgDetailSchema.getFlag())){//ɾ�������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("1");
    		  }
        	  else if("I".equals(planting31EndorChgDetailSchema.getFlag())){//���������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("0");
        	  }
        	  else if("U".equals(planting31EndorChgDetailSchema.getFlag())){//�޸Ĳ��������޸Ľ�������Ϣ�������л���
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumAmount().doubleValue());
        		  planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		
        	  }
        	  else throw new UserException(1,-1007,this.getClass().getName());
        	  return planting31PolicyListDto;
         }
          
          
          public TemblorpolicylistDto backWardTemblor0311PolicyList(TemblorpolicylistDto planting31PolicyListDto, TemblorEndorChgDetailSchema planting31EndorChgDetailSchema) throws Exception{
        	  if("D".equals(planting31EndorChgDetailSchema.getFlag())){//ɾ�������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumamount().doubleValue());
        		  //planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("1");
    		  }
        	  else if("I".equals(planting31EndorChgDetailSchema.getFlag())){//���������������˽����Ϊ��Ч
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumamount().doubleValue());
        		 // planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		  planting31PolicyListDto.setValidity("0");
        	  }
        	  else if("U".equals(planting31EndorChgDetailSchema.getFlag())){//�޸Ĳ��������޸Ľ�������Ϣ�������л���
        		  planting31PolicyListDto.setSumamount(planting31PolicyListDto.getSumamount()-planting31EndorChgDetailSchema.getChgSumamount().doubleValue());
        		 // planting31PolicyListDto.setInsurearea(planting31PolicyListDto.getInsurearea()-planting31EndorChgDetailSchema.getChgInsureArea().doubleValue());
        		
        	  }
        	  else throw new UserException(1,-1007,this.getClass().getName());
        	  return planting31PolicyListDto;
         }
    /**
    * �ص�����������Ϣ
    *@param  �����������
    *@return ��
    */
    public PrpCmainDto backWardPrpCmain(PrpCmainDto prpCmainDto,EndorseDto endorseDto) throws Exception 
    {
      try{
        PrpPmainDto prpPmainDto = new PrpPmainDto();
        //PrpCmainDto prpCmainDto = new PrpCmainDto();
        if(endorseDto.getPrpPmainDto()!=null){
          prpPmainDto = endorseDto.getPrpPmainDto();
          PropertyUtils.copyProperties(prpCmainDto,prpPmainDto);
        }
      }catch(Exception ex){
      ex.printStackTrace();
      }
      return prpCmainDto;
    }

    /**
    * �ص�������Ϣ��Ϣ
    *@param  �����������
    *@return ��
    */
    public ArrayList backWardPrpCitem_car(ArrayList prpCitemcarDtoList,EndorseDto endorseDto) throws Exception 
    {
      try{
        PrpPitemCarDto prpPitem_carDto = new PrpPitemCarDto();
        PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
        if(prpCitemcarDtoList!=null&&prpCitemcarDtoList.size()>0){
          PrpCitemCarDto = (PrpCitemCarDto) prpCitemcarDtoList.get(0);
        }
        if(endorseDto.getPrpPitem_carDtoList()!=null&&endorseDto.getPrpPitem_carDtoList().size()>0){
          prpPitem_carDto = (PrpPitemCarDto)(endorseDto.getPrpPitem_carDtoList().get(0));
          PropertyUtils.copyProperties(PrpCitemCarDto,prpPitem_carDto);
        }
      }catch(Exception ex){
      ex.printStackTrace();
      }
      return prpCitemcarDtoList;
    }

     /**
      * �ص��Ż���Ϣ
      *@param  ��������
      *@return ��
      */
     public ArrayList backWardPrpCprofit(ArrayList prpCprofitDtoList,EndorseDto endorseDto) throws Exception {
       PrpPprofitDto prpPprofitDto = new PrpPprofitDto();
       PrpCprofitDto prpCprofitDto = new PrpCprofitDto();
       int strcurr = 0;
       int iFindFlag = 0;
       if(endorseDto.getPrpPprofitDtoList()!=null){
         for (int i = 0; i < endorseDto.getPrpPprofitDtoList().size(); i++) {
           prpPprofitDto = (PrpPprofitDto)endorseDto.getPrpPprofitDtoList().get(i);
           if (!prpPprofitDto.getFlag().trim().equals("")) {
             if (prpPprofitDto.getFlag().substring(0, 1).equals("U")) {
               prpCprofitDto = new PrpCprofitDto();
               strcurr = this.searchPrpCprofit(prpPprofitDto.getProfitType(),
                                             prpPprofitDto.getItemkindNo(),prpCprofitDtoList);
               if (strcurr >= 0) {
                 PropertyUtils.copyProperties(prpCprofitDto,prpPprofitDto);
                 prpCprofitDtoList.set(strcurr,prpCprofitDto);
                 //prpCprofitDto = blPrpCprofit.PEvaluateC(prpPprofitDto);
                 //blPrpCprofit.setArr(strcurr, prpCprofitDto);
               }
             }
             if (prpPprofitDto.getFlag().substring(0, 1).equals("I")) {
               prpCprofitDto = new PrpCprofitDto();
               strcurr = this.searchPrpCprofit(prpPprofitDto.getProfitType(),
                                             prpPprofitDto.getItemkindNo(),prpCprofitDtoList);

               if (strcurr >= 0) {
                 prpCprofitDtoList.remove(strcurr);
               }
             }
           }
         }
       }

       return prpCprofitDtoList;
     }
     /**
     *�����ձ���ż��ۿ�����Ѱ���±�
     *@param itemkindno �ձ����
     *@param profittype �ۿ�����
     *@return �±�
     */
      public int searchPrpCprofit(String iProfitType,int iItemKindNo,ArrayList listTemp) throws Exception
      {
        int icurr =0;
        int iFindFlag = 0;
        if (listTemp != null) {
          for (int i = 0; i < listTemp.size(); i++) {
            PrpCprofitDto prpCprofitDto = (PrpCprofitDto)listTemp.get(i);
            if ((prpCprofitDto.getItemkindNo()==iItemKindNo) &&
                prpCprofitDto.getProfitType().trim().equals(iProfitType)) {
              icurr = i;
              iFindFlag = 1;
            }
          }
        }
        if (iFindFlag ==0)
         { icurr = -1;}
      return icurr;
      }

     /**
      * �ص��ر�Լ����Ϣ
      *@param  ������ַ�Ķ���
      *@return ��
      */
     public ArrayList backWardPrpCengage(ArrayList prpCengageList,EndorseDto endorseDto) throws Exception {
       PrpPengageDto prpPengageDto = new PrpPengageDto();
       PrpCengageDto prpCengageDto = new PrpCengageDto();
       int strcurr = 0;
       int iFindFlag = 0;
       if(endorseDto.getPrpPengageDtoList()!=null){
         for (int i = 0; i < endorseDto.getPrpPengageDtoList().size(); i++) {
           prpPengageDto = (PrpPengageDto)endorseDto.getPrpPengageDtoList().get(i);
           if (prpPengageDto.getFlag().substring(0, 1).equals("U")) {
             prpCengageDto = new PrpCengageDto();
             strcurr = this.searchPrpCengage(prpPengageDto.getSerialNo(),
                                           prpPengageDto.getLineNo(),prpCengageList);
           if (strcurr >= 0) {
             PropertyUtils.copyProperties(prpCengageDto, prpPengageDto);
             //prpCengageDto = blPrpCengage.PEvaluateC(prpPengageDto);
             prpCengageList.set(strcurr, prpCengageDto);
           }
         }
         if (prpPengageDto.getFlag().substring(0, 1).equals("I")) {
             prpCengageDto = new PrpCengageDto();
           strcurr = this.searchPrpCengage(prpPengageDto.getSerialNo(),
                                         prpPengageDto.getLineNo(),prpCengageList);
             if (strcurr >= 0) {
               prpCengageList.remove(strcurr);
             }
           }
           if (prpPengageDto.getFlag().substring(0, 1).equals("D")) {
             prpCengageDto = new PrpCengageDto();
             //������Ų��Ҳ����
             for (int j = 0; j < prpCengageList.size(); j++) {
               prpCengageDto = (PrpCengageDto)prpCengageList.get(j);
               if (prpPengageDto.getSerialNo() <prpCengageDto.getSerialNo()) {
                 strcurr = j;
                 iFindFlag = 1;
                 break;
               }
             }
             if (iFindFlag == 0)
             //û�ҵ������Ϊ���
             {
               strcurr = prpCengageList.size();
             }
             //��p��¼תΪc��¼
             PropertyUtils.copyProperties(prpCengageDto, prpPengageDto);
             //prpCengageDto = blPrpCengage.PEvaluateC(prpPengageDto);
             //��ָ��λ�ò���
             Vector vector = new Vector();

             prpCengageList.add(strcurr, prpCengageDto);
           }
           if (prpPengageDto.getFlag().substring(0, 1).equals("B")) {
             prpCengageDto = new PrpCengageDto();
             strcurr = this.searchPrpCengage(prpPengageDto.getSerialNo(),
                                             prpPengageDto.getLineNo(),
                                             prpCengageList);

             if (strcurr >= 0) {
               PropertyUtils.copyProperties(prpCengageDto, prpPengageDto);
              // prpCengageDto = blPrpCengage.PEvaluateC(prpPengageDto);
               prpCengageList.set(strcurr, prpCengageDto);
             }
           }
         }

       }
       return prpCengageList;
     }

     /**
     *���ݵ�ַ���Ѱ���±�
     *@param SerialNo
     *@param LineNo
     *@return �±�
     */
    public int searchPrpCengage(int iSerialNo,int iLineNo,ArrayList listTemp) throws Exception
    {
        int icurr =0;
        int iFindFlag = 0;
        if(listTemp!=null){
          for (int i = 0; i < listTemp.size(); i++) {
            PrpCengageDto prpCengageDto = (PrpCengageDto)listTemp.get(i);
            if ((prpCengageDto.getSerialNo()==iSerialNo) &&
                ((prpCengageDto.getLineNo()==iLineNo))) {
              icurr = i;
              iFindFlag = 1;
            }
          }
        }
        if (iFindFlag ==0)
         { icurr = -1;}
     return icurr;
    }

     /**
     * �ص������Ϣ
     *@param  ������Ķ���
     *@return ��
     */
     public ArrayList backWardPrpCitemKind(ArrayList prpCitemKindList,EndorseDto endorseDto) throws Exception
     {
       //System.out.println("--------�𼶻ع�������-------backWardPrpCitemKind---");
       PrpPitemKindDto prpPitemKindDto = new PrpPitemKindDto();
       PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
       //DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind();
       int strcurr = 0;
       int iFindFlag = 0;
       if(endorseDto.getPrpPitemKindDtoList()!=null){
         for (int i = 0; i < endorseDto.getPrpPitemKindDtoList().size(); i++) {
           prpPitemKindDto = (PrpPitemKindDto)endorseDto.getPrpPitemKindDtoList().get(i);
           //System.out.println("------------prpPitemKindDto---"+prpPitemKindDto.getEndorseNo());
           if (prpPitemKindDto.getFlag().substring(0, 1).equals("U")) {
             prpCitemKindDto = new PrpCitemKindDto();
             strcurr = this.searchPrpCitemKind(prpPitemKindDto.getItemKindNo(),prpCitemKindList);
             if (strcurr >= 0) {
               PropertyUtils.copyProperties(prpCitemKindDto, prpPitemKindDto);
               //prpCitemKindDto = blPrpCitemKind.PEvaluateC(prpPitemKindDto);
               prpCitemKindList.set(strcurr, prpCitemKindDto);
             }
           }
           if (prpPitemKindDto.getFlag().substring(0, 1).equals("I")) {
             prpCitemKindDto = new PrpCitemKindDto();
             strcurr = this.searchPrpCitemKind(prpPitemKindDto.getItemKindNo(),prpCitemKindList);
             if (strcurr >= 0) {
               prpCitemKindList.remove(strcurr);
             }
           }
           if (prpPitemKindDto.getFlag().substring(0, 1).equals("D")) {
             prpCitemKindDto = new PrpCitemKindDto();
             //������Ų��Ҳ����
             for (int j = 0; j < prpCitemKindList.size(); j++) {
               prpCitemKindDto = (PrpCitemKindDto)prpCitemKindList.get(j);
               if (prpPitemKindDto.getItemKindNo() <prpCitemKindDto.getItemKindNo()) {
                 strcurr = j;
                 iFindFlag = 1;
               }
             }
             if (iFindFlag == 0)
             //û�ҵ������Ϊ���
             {
               strcurr = prpCitemKindList.size();
             }
             //��p��¼תΪc��¼
             PropertyUtils.copyProperties(prpCitemKindDto, prpPitemKindDto);
             //prpCitemKindDto = blPrpCitemKind.PEvaluateC(prpPitemKindDto);
             //��ָ��λ�ò���
             prpCitemKindList.add(strcurr, prpCitemKindDto);
           }
           if (prpPitemKindDto.getFlag().substring(0, 1).equals("B")) {
             prpCitemKindDto = new PrpCitemKindDto();
             //System.out.println("------B------getItemKindNo---"+prpPitemKindDto.getItemKindNo());
             strcurr = this.searchPrpCitemKind(prpPitemKindDto.getItemKindNo(),prpCitemKindList);
             //System.out.println("------B------strcurr---"+strcurr);
             if (strcurr >= 0) {
               PropertyUtils.copyProperties(prpCitemKindDto, prpPitemKindDto);
               //prpCitemKindDto = blPrpCitemKind.PEvaluateC(prpPitemKindDto);
               prpCitemKindList.set(strcurr, prpCitemKindDto);
             }
           }
         }
       }
       return prpCitemKindList;
      }
     /**
      * �ص������Ϣ
      *@param  ������Ķ���
      *@return ��
      */
      public ArrayList backWardPrpCcoins(ArrayList prpCcoinsList,
			EndorseDto endorseDto) throws Exception {
		PrpCcoinsDto prpCcoinsDto = new PrpCcoinsDto();
		PrpPcoinsDto prpPcoinsDto = new PrpPcoinsDto();
		int strcurr = 0;
		int iFindFlag = 0;
		if (endorseDto.getPrpPCoinsDtoList() != null) {
			for (int i = 0; i < endorseDto.getPrpPCoinsDtoList().size(); i++) {
				prpPcoinsDto = (PrpPcoinsDto) endorseDto.getPrpPCoinsDtoList()
						.get(i);
				if (prpPcoinsDto.getFlag().substring(0, 1).equals("U")) {
					prpCcoinsDto = new PrpCcoinsDto();
					strcurr = this.searchPrpCcoins(prpPcoinsDto.getSerialNo(),
							prpCcoinsList);
					if (strcurr >= 0) {
						PropertyUtils
								.copyProperties(prpCcoinsDto, prpPcoinsDto);
						prpCcoinsList.set(strcurr, prpCcoinsDto);
					}
				}
				if (prpPcoinsDto.getFlag().substring(0, 1).equals("I")) {
					prpCcoinsDto = new PrpCcoinsDto();
					strcurr = this.searchPrpCcoins(prpPcoinsDto.getSerialNo(),
							prpCcoinsList);
					if (strcurr >= 0) {
						prpCcoinsList.remove(strcurr);
					}
				}
				if (prpPcoinsDto.getFlag().substring(0, 1).equals("D")) {
					prpCcoinsDto = new PrpCcoinsDto();
					// ������Ų��Ҳ����
					for (int j = 0; j < prpCcoinsList.size(); j++) {
						prpCcoinsDto = (PrpCcoinsDto) prpCcoinsList.get(j);
						if (prpPcoinsDto.getSerialNo() < prpCcoinsDto
								.getSerialNo()) {
							strcurr = j;
							iFindFlag = 1;
						}
					}
					if (iFindFlag == 0)
					// û�ҵ������Ϊ���
					{
						strcurr = prpCcoinsList.size();
					}
					// ��p��¼תΪc��¼
					PropertyUtils.copyProperties(prpCcoinsDto, prpPcoinsDto);
					// ��ָ��λ�ò���
					prpCcoinsList.add(strcurr, prpCcoinsDto);
				}
				if (prpPcoinsDto.getFlag().substring(0, 1).equals("B")) {
					prpCcoinsDto = new PrpCcoinsDto();
					strcurr = this.searchPrpCcoins(prpPcoinsDto.getSerialNo(),
							prpCcoinsList);
					if (strcurr >= 0) {
						PropertyUtils
								.copyProperties(prpCcoinsDto, prpPcoinsDto);
						prpCcoinsList.set(strcurr, prpCcoinsDto);
					}
				}
			}
		}
		return prpCcoinsList;
	}

      /**
      *�����ձ����Ѱ���±�
      *@param itemkindno �ձ����
      *@return �±�
      */
     public int searchPrpCitemKind(int iItemKindNo,ArrayList listTemp) throws Exception
     {
       int icurr = 0;
       int iFindFlag = 0;
       if (listTemp != null) {
         for (int i = 0; i < listTemp.size(); i++) {
           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) listTemp.get(i);
           if (prpCitemKindDto.getItemKindNo() == iItemKindNo) {
             icurr = i;
             iFindFlag = 1;
           }
         }
       }
       if (iFindFlag == 0) {
         icurr = -1;
       }
       return icurr;
     }
     public int searchPrpCcoins( int  serialNo ,ArrayList listTemp) throws Exception
     {
       int icurr = 0;
       int iFindFlag = 0;
       if (listTemp != null) {
         for (int i = 0; i < listTemp.size(); i++) {
           PrpCcoinsDto prpCcoinsDto = (PrpCcoinsDto) listTemp.get(i);
           if (serialNo == prpCcoinsDto.getSerialNo()) {
             icurr = i;
             iFindFlag = 1;
           }
         }
       }
       if (iFindFlag == 0) {
         icurr = -1;
       }
       return icurr;
     }


      /**
      * �ص������Ϣ
      *@param  ����������
      *@return ��
      */
     public ArrayList backWardPrpCfee(ArrayList prpCfeeList, EndorseDto endorseDto) throws Exception {
       PrpPfeeDto prpPfeeDto = new PrpPfeeDto();
       PrpCfeeDto prpCfeeDto = new PrpCfeeDto();
       double dblChgAmount = 0;
       double dblAmount = 0;
       double dblChgPremium = 0;
       double dblPremium = 0;
       if(endorseDto.getPrpPfeeDtoList()!=null){
         for (int i = 0; i < endorseDto.getPrpPfeeDtoList().size(); i++) {
           prpPfeeDto = (PrpPfeeDto)endorseDto.getPrpPfeeDtoList().get(i);
           for (int j = 0; j < prpCfeeList.size(); j++) {
             prpCfeeDto = (PrpCfeeDto)prpCfeeList.get(j);
             if (prpCfeeDto.getCurrency().equals(prpPfeeDto.getCurrency())) {
               dblChgAmount = prpPfeeDto.getChgAmount();
               dblAmount = prpCfeeDto.getAmount();
               dblAmount = dblAmount - dblChgAmount;
               dblChgPremium = prpPfeeDto.getChgPremium();
               dblPremium = prpCfeeDto.getPremium();
               dblPremium = dblPremium - dblChgPremium;
               prpCfeeDto.setAmount(dblAmount);
               prpCfeeDto.setPremium(dblPremium);
               prpCfeeList.set(j, prpCfeeDto);
             }
           }
         }
       }
       return prpCfeeList;
     }

  /**
   * ���ת����ı�������ձ�
   * param blPrpCitemKind����������ձ�
   * param iClauseType���������
   * return ���ת����ı�������ձ�
   * throws UserException,Exception
   */
  public ArrayList TransKind(ArrayList prpCitemKindList,String iClauseType) throws Exception
  {
    String strKindCode = "";

   if(prpCitemKindList!=null){
    for (int i = 0 ; i < prpCitemKindList.size() ; i++)
    {
      PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindList.get(i);
      strKindCode = prpCitemKindDto.getKindCode();
      if (strKindCode.equals("A"))
      {
        if (iClauseType.equals("F22"))
          strKindCode = "BF22";
        else
          strKindCode = strKindCode + iClauseType;
      }else if (strKindCode.equals("B"))
      {
        if (iClauseType.equals("F31")
            || iClauseType.equals("F32")
            || iClauseType.equals("F33")
            || iClauseType.equals("F34")
            || iClauseType.equals("F35")
            || iClauseType.equals("F36")
            )
        {
          strKindCode = "BF22";
        }else
        {
          strKindCode = strKindCode + iClauseType;
        }
      }else
      {
      }
      prpCitemKindDto.setKindCode(strKindCode);
    } // end of for
   }
    return prpCitemKindList;
  }

   public void setPolicyDto(PolicyDto policyDto) {
     this.policyDto = policyDto;
   }

   public PolicyDto getPolicyDto() {
     return policyDto;
   }


 }
