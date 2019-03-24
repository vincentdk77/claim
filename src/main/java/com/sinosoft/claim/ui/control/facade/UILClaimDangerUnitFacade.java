
package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.dto.custom.NewDangerUnitDto;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.Str;
/**
 * 分发HTTP GET 立案前生成危险单位请求
 * <p>
 * Title: 立案前生成危险单位信息
 * </p>
 * 
 * @author 国元项目组
 * @version 1.0
 */
public class UILClaimDangerUnitFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String policyNo = request.getParameter("prpLclaimPolicyNo"); // 保单号
        String prpLclaimDamageStartDate = request.getParameter("prpLclaimDamageStartDate");//出险时间
        String[] arrkindCode=  request.getParameterValues("prpLclaimLossKindCode"); //险别代码	
        String[] arrsumloss=  request.getParameterValues("prpLclaimLossSumClaim"); //估损金额
        String[] registNo = request.getParameterValues("prpLclaimRegistNo");// 报案号
        String[] arrItemKindNo = request.getParameterValues("prpLclaimLossItemKindNo"); //标的序号
        String editType=request.getParameter("prpLdangerRiskeditType"); // 修改立案
        String[] ClaimLossFlag=request.getParameterValues("ClaimLossFlag"); // 修改立案新增标志位
        String[] prpLclaimLossInputDate=request.getParameterValues("prpLclaimLossInputDate");//输入日期
        String[] arrsumlossNew=  request.getParameterValues("prpLclaimLossSumClaim"); //修改立案的估损金额
        String prpLclaimRegistNo = request.getParameter("prpLclaimRegistNo");//  修改立案报案号
        String policyNoNew = request.getParameter("policyno"); // 保单号 
        
        String forward = ""; // 向前
        List prpdangerUnitList = new ArrayList();
		
        
        try {
        		Map kindMap = new HashMap();
                DBPrpPhead dbPrpPhead = new DBPrpPhead();
                BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
                
                if ("modifyDetail".equals(editType)) {
                	String wherepart=" policyno='"+policyNoNew+"' and validdate <= date '"+prpLclaimDamageStartDate+"' and underwriteflag in ('1','3') ";
                	int count=dbPrpPhead.getCount(wherepart);
                	//根据标的序号查询数据库危险单位信息
                	for(int i = 1; i< arrItemKindNo.length;i++){
                		if((ClaimLossFlag!=null&&"I".equals(ClaimLossFlag[i]))||(prpLclaimLossInputDate!=null&&"".equals(prpLclaimLossInputDate[i]))){
                			if(kindMap.containsKey(arrItemKindNo[i])){
                				String tempSumLoss="";
                				tempSumLoss=String.valueOf((Double.parseDouble(arrsumlossNew[i])+Double.parseDouble("" + kindMap.get(arrItemKindNo[i]))));
   	       				  		kindMap.put(arrItemKindNo[i], tempSumLoss);
                			}else{
                				if(count==0){
   	                           		List prpdangerUnitTempList=blDangerFacade.getPrpCdangerUnit(policyNoNew,arrItemKindNo[i]);
   	                           		prpdangerUnitList.addAll(prpdangerUnitTempList);
                				}else{
   	                           		List prpdangerUnitTempList=blDangerFacade.getPrpPdangerUnit(prpLclaimRegistNo, policyNoNew, arrItemKindNo[i]);
   	                           		prpdangerUnitList.addAll(prpdangerUnitTempList);
                				}
   	                    	   	kindMap.put(arrItemKindNo[i], arrsumlossNew[i]);
                			}
                		}
                	} 
                }else{
                	//如果在出险时间之前存在批改，则取pdangunit表的数据，否则取cdangunit表的数据
                    String wherepart=" policyno='"+policyNo+"' and validdate <= date '"+prpLclaimDamageStartDate+"' and underwriteflag in ('1','3') ";
                    int count=dbPrpPhead.getCount(wherepart);
                    
                    //根据标的序号查询数据库危险单位信息
            		for(int i = 1; i< arrkindCode.length;i++){
            			  if(kindMap.containsKey(arrItemKindNo[i])){
               				 String tempSumLoss=String.valueOf((Double.parseDouble(arrsumloss[i])+Double.parseDouble("" + kindMap.get(arrItemKindNo[i]))));
               				 kindMap.put(arrItemKindNo[i], tempSumLoss);
               			  }else{
                               if(count==0){
    	                           	List prpdangerUnitTempList=blDangerFacade.getPrpCdangerUnit(policyNo,arrItemKindNo[i]);
    	                           	prpdangerUnitList.addAll(prpdangerUnitTempList);
                               }else{
    	                           	List prpdangerUnitTempList=blDangerFacade.getPrpPdangerUnit(registNo[0], policyNo, arrItemKindNo[i]);
    	                           	prpdangerUnitList.addAll(prpdangerUnitTempList);
                               }
               			  	   kindMap.put(arrItemKindNo[i], arrsumloss[i]);
               			  }
            		}
                }
        		
        			 //危险单位估损金额按照标的序号最后一位减法原则处理
        			  double dbSumLoss = 0D;
                      double dbshare = 0D;
                      double tempSumLoss=0D;
                     //判断标的序号是否是此危险单位的最后一个
                      boolean flag = false;
                  	  NewDangerUnitDto  newDangerUnitDto=null;
                	  NewDangerUnitDto  newDangerUnitDtoTemp=null;
                      for(int i=0;i<prpdangerUnitList.size();i++){
                    	  newDangerUnitDto= (NewDangerUnitDto)prpdangerUnitList.get(i);
                      	  dbSumLoss = Double.parseDouble(Str.chgStrZero("" + kindMap.get(newDangerUnitDto.getItemkindno())));
                          dbshare = Double.parseDouble(Str.chgStrZero(newDangerUnitDto.getDangerkindshare()));
                      	  flag = false;
                      
                          for(int j=i+1;j<prpdangerUnitList.size();j++){
                        	  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(i);
                              if (newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())) {
      						    flag = true;
      						    break;
      					     }
                          }
                          if(flag){
                              dbSumLoss = Str.round((dbSumLoss * (dbshare/100)),2); 
                          	  newDangerUnitDto.setDangerkindAmount(""+dbSumLoss);
                          }else{
                      		tempSumLoss = 0;
                      		for(int k=0;k<i;k++){
                      		  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(k);
                      		   if(newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())){
                     				 tempSumLoss+=Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindAmount())); 
                     		    } 
                          	}
                      		newDangerUnitDto.setDangerkindAmount(""+Str.round((dbSumLoss-tempSumLoss),2));
                          }
                      }
        		
                
             request.setAttribute("prpdangerUnitList", prpdangerUnitList);
             forward = "success";
             saveToken(request);
             
        } catch (UserException usee) {
            usee.printStackTrace();
            // 错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimDangerUnit.NewRiskUnit");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            request.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(request, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            // 错误信息处理
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimDangerUnit.NewRiskUnit");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            request.setAttribute("errorMessage", e.getMessage());
            saveErrors(request, errors);
            forward = "error";
        } finally {
        }

        return actionMapping.findForward(forward);
    }
}
