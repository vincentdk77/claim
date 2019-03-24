package com.sinosoft.claim.ui.control.action;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.platform.ui.control.action.UIPrpDriskConfigAction;
import com.sinosoft.reins.out.bl.facade.BLPrpCdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.dto.domain.PrpCdangerUnitDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
/**
 * ���յ�λ��ѯ
 * <p>Title: ���յ�λaction  </p>
 * <p>Description: ���յ�λaction</p>
 * <p>Copyright: Copyright (c) 2005/8/16</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 * ****************��ע�⣺�ڴ����У������Ų�ͬ�Ŀ��
 * ǰ����������ѯ���ݴӣ�prpCdangerUnit; Ȼ�󣬽����ݲ��뵽��prpLdangerUnit,��������������ѯ���ݴ�prpLdangerUnit
 */
public class UIRiskUnitAction
{
  /**
   * ����������ѯ���յ�λ��Ϣ,��PrpCdangerUnit�в���
   * @param policyno
   * @param dangerNo
   * @return PrpCdangerUnitDto
   * @throws Exception
   */
  public PrpCdangerUnitDto findByPrimaryKeyFromPrpCdangerUnit(String policyno,int dangerNo,HttpServletRequest request,String riskCode) throws Exception{
         PrpCdangerUnitDto prpCdangerUnitDto = new PrpCdangerUnitDto();
         
         boolean display = this.checkConfigValue(request,riskCode);
         if(display){
             request.setAttribute("display","display");
         }else{
         	 request.setAttribute("display","");
         }
         BLPrpCdangerUnitFacade blPrpCdangerUnitFacadeBase = new BLPrpCdangerUnitFacade();
         prpCdangerUnitDto = blPrpCdangerUnitFacadeBase.findByPrimaryKey(policyno,dangerNo);
         return prpCdangerUnitDto;
  }
  /**
   * �����������ҷ��յ�λ��Ϣ��������ݱ����Ų���,��PrpCdangerUnit�в���
   * @param condition
   * @return Collection
   * @throws Exception
   */
  public Collection findByConditionFromPrpCDangerUnit(String condition,HttpServletRequest request,String riskCode) throws Exception{
         Collection riskUnitList = null;
         
         boolean display = this.checkConfigValue(request,riskCode);
         if(display){
             request.setAttribute("display","display");
         }else{
         	 request.setAttribute("display","");
         }
         BLPrpCdangerUnitFacade blPrpCdangerUnitFacadeBase = new BLPrpCdangerUnitFacade();
         riskUnitList = blPrpCdangerUnitFacadeBase.findByConditions(condition);
         return riskUnitList;
  }
  /**
   * ����һ�����ݵ�PrpLDangerUnit
   * @param prpCdangerUnitDto
   * @throws Exception
   */
  public void insertToPrpLDangerUnitDto(PrpLdangerUnitDto prpLdangerUnitDto) throws Exception{
         BLPrpLdangerUnitFacade blPrpLdangerUnitFacadeBase = new BLPrpLdangerUnitFacade();
         
         String certiNo = prpLdangerUnitDto.getCertiNo();
         int dangerNo = prpLdangerUnitDto.getDangerNo();
         this.deleteByPrimaryKey(certiNo,dangerNo);
         blPrpLdangerUnitFacadeBase.insert(prpLdangerUnitDto);
  }
  /**
   * �������Σ�յ�λ��Ϣ��PrpLDangerUnit
   * @param dangerUnitDtoList
   * @throws Exception
   */
  public void inserAllToPrpLDangerUnitDto(Collection dangerUnitDtoList)throws Exception{
        
         BLPrpLdangerUnitFacade blPrpLdangerUnitFacadeBase = new BLPrpLdangerUnitFacade();
         PrpLdangerUnitDto prpLdangerUnitDto = new PrpLdangerUnitDto();
         Iterator dangerUnit = dangerUnitDtoList.iterator(); 
     
         while(dangerUnit.hasNext()){
                prpLdangerUnitDto =(PrpLdangerUnitDto)dangerUnit.next();
                String certiNo = prpLdangerUnitDto.getCertiNo();
                int dangerNo = prpLdangerUnitDto.getDangerNo();
                this.deleteByPrimaryKey(certiNo,dangerNo);
                blPrpLdangerUnitFacadeBase.insert(prpLdangerUnitDto);
         }   
  }
  /**
   * ����������ѯ���յ�λ��Ϣ,��PrpLdangerUnit�в���
   * @param policyno
   * @param dangerNo
   * @return PrpCdangerUnitDto
   * @throws Exception
   */
  public PrpLdangerUnitDto findByPrimaryKeyFromPrpLdangerUnit(String certyNo,int dangerNo,HttpServletRequest request,String riskCode,int ClaimAddTimes) throws Exception{
         PrpLdangerUnitDto prpLdangerUnitDto = new PrpLdangerUnitDto();
         
         boolean display = this.checkConfigValue(request,riskCode);
         if(display){
             request.setAttribute("display","display");
         }else{
         	 request.setAttribute("display","");
         }
         BLPrpLdangerUnitFacade blPrpLdangerUnitFacadeBase = new BLPrpLdangerUnitFacade();
         prpLdangerUnitDto = blPrpLdangerUnitFacadeBase.findByPrimaryKey(certyNo,dangerNo,ClaimAddTimes);
         return prpLdangerUnitDto;
  }
  /**
   * �����������ҷ��յ�λ��Ϣ����PrpLdangerUnit�в���
   * @param condition
   * @return Collection
   * @throws Exception
   */
  public Collection findByConditionFromPrpLDangerUnit(String condition,HttpServletRequest request,String riskCode) throws Exception{
         Collection riskUnitList = null;
         
         boolean display = this.checkConfigValue(request,riskCode);
         if(display){
             request.setAttribute("display","display");
         }else{
         	 request.setAttribute("display","");
         }
         BLPrpLdangerUnitFacade blPrpLdangerUnitFacadeBase = new BLPrpLdangerUnitFacade();
         riskUnitList = blPrpLdangerUnitFacadeBase.findByConditions(condition);
         return riskUnitList;
  }
  /**
   * 
   * @param certiNo
   * @param dangerNo
   * @throws Exception
   */
  public void deleteByPrimaryKey(String certiNo,int dangerNo) throws Exception{
         BLPrpLdangerUnitFacade blPrpLdangerUnitFacadeBase = new BLPrpLdangerUnitFacade();
         blPrpLdangerUnitFacadeBase.delete(certiNo,dangerNo);
  }
  /**
   * ��ȡ�Ƿ�������Σ�յ�λ����Ϣ
   * @param request
   * @param riskCode
   * @return 
   * @throws Exception
   */
  public boolean checkConfigValue(HttpServletRequest request,String riskCode)throws Exception{
         String configName = "RISK_UNIT_FLAG";
         HttpSession session = request.getSession();
  	     UserDto user =(UserDto)session.getAttribute("user");
  	     //modify by   ��Ŀ��  ������  �ܻ��������Ϊ2000000000
  	     String comCode = "0000000000";
  	     
  	     //String comCode = "2000000000";
  	     if(user!=null&&!user.equals("")){
  	         comCode = user.getComCode();
  	     }
  		 PrpDriskConfigDto prpDriskConfigDto = new PrpDriskConfigDto();
  		 prpDriskConfigDto = UIPrpDriskConfigAction.queryRiskConfig(comCode,riskCode,configName);
  		 if(prpDriskConfigDto!=null&&prpDriskConfigDto.getConfigValue().equals("1")){
  		     return true;
  		 }	
  		 else{
  		     return true;  //��Ϊ����һ�ڣ����У����ֶ���Ҫ�󻮷�Σ�յ�λ�����ǣ���Ҫ��̯���㣬���ԣ������ﶼ��ʾΣ�յ�λ��Ϣ��
  		 } 
  }
  
}
