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
 * 风险单位查询
 * <p>Title: 风险单位action  </p>
 * <p>Description: 风险单位action</p>
 * <p>Copyright: Copyright (c) 2005/8/16</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 * ****************请注意：在此类中，操作着不同的库表！
 * 前两个方法查询数据从：prpCdangerUnit; 然后，将数据插入到：prpLdangerUnit,后面两个方法查询数据从prpLdangerUnit
 */
public class UIRiskUnitAction
{
  /**
   * 根据主键查询风险单位信息,从PrpCdangerUnit中查找
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
   * 根据条件查找风险单位信息，例如根据保单号查找,从PrpCdangerUnit中查找
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
   * 插入一条数据到PrpLDangerUnit
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
   * 插入多行危险单位信息到PrpLDangerUnit
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
   * 根据主键查询风险单位信息,从PrpLdangerUnit中查找
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
   * 根据条件查找风险单位信息，从PrpLdangerUnit中查找
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
   * 获取是否允许划分危险单位的信息
   * @param request
   * @param riskCode
   * @return 
   * @throws Exception
   */
  public boolean checkConfigValue(HttpServletRequest request,String riskCode)throws Exception{
         String configName = "RISK_UNIT_FLAG";
         HttpSession session = request.getSession();
  	     UserDto user =(UserDto)session.getAttribute("user");
  	     //modify by   项目组  孙兆云  总机构代码该为2000000000
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
  		     return true;  //因为阳光一期，所有，险种都不要求划分危险单位，但是，又要分摊试算，所以，在这里都显示危险单位信息！
  		 } 
  }
  
}
