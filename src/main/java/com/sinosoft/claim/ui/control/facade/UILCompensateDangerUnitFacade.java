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
 * 分发HTTP GET 理算前生成危险单位请求
 * <p>
 * Title: 理算前生成危险单位信息
 * </p>
 * 
 * @author 国元项目组
 * @version 1.0
 */
public class UILCompensateDangerUnitFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String policyNo = request.getParameter("prpLcompensatePolicyNo"); // 保单号
        String prpLclaimDamageStartDate = request.getParameter("prpLcompensateDamageStartDate").substring(0,10);//车险日期
        String[] prpLlossDtoKindCode=  request.getParameterValues("prpLlossDtoKindCode"); //财物的险别代码	
        String[] prpLlossDtoSumRealPay=  request.getParameterValues("prpLlossDtoSumRealPay"); //财物的赔付金额
        
        String[] registNo = request.getParameterValues("prpLcompensateRegistNo");// 报案号
        
        String[] prpLpersonLossKindCode = request.getParameterValues("prpLpersonLossKindCode");//人员的险别代码
        String[] prpLpersonLossSumRealPay = request.getParameterValues("prpLpersonLossSumRealPay");//人员的赔付金额
        String[] prpLpersonLossSumRealPay1 = request.getParameterValues("prpLpersonLossSumRealPay1");//人员的赔付合计
        
        String[] prpLlossDtoItemKindNoForCharge = request.getParameterValues("prpLlossDtoItemKindNoForCharge");//费用的标的序号
        String[] prpLchargeKindCode = request.getParameterValues("prpLchargeKindCode");//费用的险别代码
        String[] prpLchargeSumRealPay = request.getParameterValues("prpLchargeSumRealPay");//费用的赔付金额
        String[] prpLchargeChargeAmount = request.getParameterValues("prpLchargeChargeAmount");//费用的实际费用
        
        String prpLcompensateRiskCode = request.getParameter("prpLcompensateRiskCode");//险种代码	
        String prpLcompensateSumPaid=request.getParameter("prpLcompensateSumPaid");//总赔付金额
        String prpLcompensateClassCode=request.getParameter("prpLcompensateClassCode");//险类代码
        String registno = request.getParameter("registno");//报案号
        String[] arrItemKindNo=request.getParameterValues("prpLlossDtoItemKindNo");//标的代码
        String[] arrItemKindNoE=request.getParameterValues("prpLpersonLossItemKindNo");//意健险或车险标的代码
        
        String prpLdangerRiskCompensate = request.getParameter("prpLdangerRiskCompensate");//理算标志
               
        String forward = ""; // 向前
        List prpdangerUnitList = new ArrayList();
        
        
        try {
               
			Map kindMap = new HashMap();
			//拼接标的序号使用
			String strKindCodeList = "";
			
			//拼标的序号代码和计算赔付金额 start
			if ("0506,0576,0586".indexOf(prpLcompensateRiskCode) > -1) {
				for (int i = 1; i < arrItemKindNo.length; i++) {
					if (kindMap.containsKey(arrItemKindNo[i])) {
						String tempSumLoss = String.valueOf((Double.parseDouble(prpLlossDtoSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNo[i]))));
						kindMap.put(arrItemKindNo[i], tempSumLoss);
					} else {
							if (i != 1) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + arrItemKindNo[i] + "'";
					    	kindMap.put(arrItemKindNo[i],prpLlossDtoSumRealPay[i]);
					}
				}
				for (int i = 1; i < prpLpersonLossKindCode.length; i++) {
					if (kindMap.containsKey(arrItemKindNoE[i])) {
						String tempSumLoss = String.valueOf((Double.parseDouble(prpLpersonLossSumRealPay1[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNoE[i]))));
						kindMap.put(arrItemKindNoE[i], tempSumLoss);
					} else {
						if (!kindMap.isEmpty()) {
							strKindCodeList += ",";
						}
						strKindCodeList += "'" + arrItemKindNoE[i]+ "'";
						kindMap.put(arrItemKindNoE[i],prpLpersonLossSumRealPay1[i]);

					}
				}
			
				for (int i = 1; i < prpLchargeKindCode.length; i++) {
					String tempSumLoss = "";
					if (kindMap.containsKey(prpLlossDtoItemKindNoForCharge[i])) {
						if (prpLchargeSumRealPay[i].equals("")||Double.parseDouble(prpLchargeSumRealPay[i]) == 0) {
							tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
						} else {
							tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
						}

						kindMap.put(prpLlossDtoItemKindNoForCharge[i], tempSumLoss);
					} else {
						if (!kindMap.isEmpty()) {
							strKindCodeList += ",";
						}
						strKindCodeList += "'" + prpLlossDtoItemKindNoForCharge[i] + "'";
						if (prpLchargeSumRealPay[i].equals("")||Double.parseDouble(prpLchargeSumRealPay[i]) == 0) {
							kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
						} else {
							kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
						}
						
					}
				}
			}
			if("15".indexOf(prpLcompensateClassCode) > -1){
				for (int i = 1; i < arrItemKindNo.length; i++) {
					if (kindMap.containsKey(arrItemKindNo[i])) {
						String tempSumLoss = String.valueOf((Double.parseDouble(prpLlossDtoSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNo[i]))));
						kindMap.put(arrItemKindNo[i], tempSumLoss);
					} else {
							if (i != 1) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + arrItemKindNo[i] + "'";
					    	kindMap.put(arrItemKindNo[i],prpLlossDtoSumRealPay[i]);
					}
				}
				for (int i = 1; i < prpLpersonLossKindCode.length; i++) {
					if (kindMap.containsKey(arrItemKindNoE[i])) {
						String tempSumLoss = String.valueOf((Double.parseDouble(prpLpersonLossSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNoE[i]))));
						kindMap.put(arrItemKindNoE[i], tempSumLoss);
					} else {
						if (!kindMap.isEmpty()) {
							strKindCodeList += ",";
						}
						strKindCodeList += "'" + arrItemKindNoE[i]+ "'";
						kindMap.put(arrItemKindNoE[i],prpLpersonLossSumRealPay[i]);

					}
				}
			
				for (int i = 1; i < prpLchargeKindCode.length; i++) {
					String tempSumLoss = "";
					if (kindMap.containsKey(prpLlossDtoItemKindNoForCharge[i])) {
						if (prpLchargeSumRealPay[i].equals("")||Double.parseDouble(prpLchargeSumRealPay[i]) == 0) {
							tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
						} else {
							tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
						}

						kindMap.put(prpLlossDtoItemKindNoForCharge[i], tempSumLoss);
					} else {
						if (!kindMap.isEmpty()) {
							strKindCodeList += ",";
						}
						strKindCodeList += "'" + prpLlossDtoItemKindNoForCharge[i] + "'";
						if (prpLchargeSumRealPay[i].equals("")||Double.parseDouble(prpLchargeSumRealPay[i]) == 0) {
							kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
						} else {
							kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
						}
						
					}
				}
			}
			
			if ("0507,0577,0587".indexOf(prpLcompensateRiskCode) > -1) {
				for (int i = 1; i < prpLlossDtoItemKindNoForCharge.length; i++) {
					if (kindMap.containsKey(prpLlossDtoItemKindNoForCharge[i])) {
						continue;
					} else {
						if (i != 1) {
							strKindCodeList += ",";
						}
						strKindCodeList += "'" + prpLlossDtoItemKindNoForCharge[i] + "'";
						kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLcompensateSumPaid);
					}
				}
			}
			
				if ("27,26,28".indexOf(prpLcompensateClassCode) > -1) {
					for (int i = 1; i < prpLchargeKindCode.length; i++) {
						if (kindMap.containsKey(prpLlossDtoItemKindNoForCharge[i])) {
							String tempSumLoss="";
							if(prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								
							}else if(!prpLchargeSumRealPay[i].equals("")&&prpLchargeChargeAmount[i].equals("")){
								tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
							}else if(prpLchargeChargeAmount[i].equals("")&&prpLchargeSumRealPay[i].equals("")){
								tempSumLoss ="0";
							}else if(!prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								if (Double.parseDouble(prpLchargeChargeAmount[i])<Double.parseDouble(prpLchargeSumRealPay[i])) {
									tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								} else {
									tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								}
							}
							kindMap.put(prpLlossDtoItemKindNoForCharge[i], tempSumLoss);
						} else {
							if (i != 1) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + prpLlossDtoItemKindNoForCharge[i] + "'";
							if(prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
								
							}else if(!prpLchargeSumRealPay[i].equals("")&&prpLchargeChargeAmount[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
							}else if(prpLchargeChargeAmount[i].equals("")&&prpLchargeSumRealPay[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],0);
							}else if(!prpLchargeChargeAmount[i].equals("")&&!prpLchargeSumRealPay[i].equals("")){
								if (Double.parseDouble(prpLchargeChargeAmount[i])<Double.parseDouble(prpLchargeSumRealPay[i])) {
									kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
								} else {
									kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
								}
							}
						}
					}
					
					for (int i = 1; i < prpLpersonLossKindCode.length; i++) {
						if (kindMap.containsKey(arrItemKindNoE[i])) {
							String tempSumLoss = String.valueOf((Double.parseDouble(prpLpersonLossSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNoE[i]))));
							kindMap.put(arrItemKindNoE[i], tempSumLoss);
						} else {
							if (!kindMap.isEmpty()) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + arrItemKindNoE[i]+ "'";
							kindMap.put(arrItemKindNoE[i],prpLpersonLossSumRealPay[i]);

						}
					}
				}
				if("01,03,04,08,09,10,11,22,31,32,YA,ZH,21".indexOf(prpLcompensateClassCode) > -1){
					for (int i = 1; i < prpLchargeKindCode.length; i++) {
						if (kindMap.containsKey(prpLlossDtoItemKindNoForCharge[i])) {
							String tempSumLoss="";
							if(prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								
							}else if(!prpLchargeSumRealPay[i].equals("")&&prpLchargeChargeAmount[i].equals("")){
								tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
							}else if(prpLchargeChargeAmount[i].equals("")&&prpLchargeSumRealPay[i].equals("")){
								tempSumLoss ="0";
							}else if(!prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								if (Double.parseDouble(prpLchargeChargeAmount[i])<Double.parseDouble(prpLchargeSumRealPay[i])) {
									tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								} else {
									tempSumLoss = String.valueOf((Double.parseDouble(prpLchargeChargeAmount[i]) + Double.parseDouble(""+ kindMap.get(prpLlossDtoItemKindNoForCharge[i]))));
								}
							}
							kindMap.put(prpLlossDtoItemKindNoForCharge[i], tempSumLoss);
						} else {
							if (i != 1) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + prpLlossDtoItemKindNoForCharge[i] + "'";
							if(prpLchargeSumRealPay[i].equals("")&&!prpLchargeChargeAmount[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
								
							}else if(!prpLchargeSumRealPay[i].equals("")&&prpLchargeChargeAmount[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
							}else if(prpLchargeChargeAmount[i].equals("")&&prpLchargeSumRealPay[i].equals("")){
								kindMap.put(prpLlossDtoItemKindNoForCharge[i],0);
							}else if(!prpLchargeChargeAmount[i].equals("")&&!prpLchargeSumRealPay[i].equals("")){
								if (Double.parseDouble(prpLchargeChargeAmount[i])<Double.parseDouble(prpLchargeSumRealPay[i])) {
									kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeSumRealPay[i]);
								} else {
									kindMap.put(prpLlossDtoItemKindNoForCharge[i],prpLchargeChargeAmount[i]);
								}
							}
						}
					}
					for (int i = 1; i < prpLlossDtoKindCode.length; i++) {
						if (kindMap.containsKey(arrItemKindNo[i])) {
							String tempSumLoss = String.valueOf((Double.parseDouble(prpLlossDtoSumRealPay[i]) + Double.parseDouble(""+ kindMap.get(arrItemKindNo[i]))));
							kindMap.put(arrItemKindNo[i], tempSumLoss);
						} else {
							if (!kindMap.isEmpty()) {
								strKindCodeList += ",";
							}
							strKindCodeList += "'" + arrItemKindNo[i]+ "'";
							kindMap.put(arrItemKindNo[i],prpLlossDtoSumRealPay[i]);
						}
					}
				}
		
			
			    //根据标的代码查询数据库危险单位信息  start
			    DBPrpPhead dbPrpPhead = new DBPrpPhead();
				BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
				// 如果在出险时间之前存在批改，则取pdangunit表的数据，否则取cdangunit表的数据
				String wherepart = " policyno='" + policyNo
						+ "' and validdate <= date '"
						+ prpLclaimDamageStartDate + "' "
						+"  and underwriteflag in ('1','3')";
				int count = dbPrpPhead.getCount(wherepart);
				
				if (count == 0) {
						prpdangerUnitList = blDangerFacade.getCompensatePrpCdangerUnit( policyNo, strKindCodeList);
				}else{
					if ("05".indexOf(prpLcompensateClassCode) >-1) {
						prpdangerUnitList = blDangerFacade.getCompensatePrpPdangerUnit(registNo[0], policyNo, strKindCodeList);
					}else{
						prpdangerUnitList = blDangerFacade.getCompensatePrpPdangerUnit(registno, policyNo, strKindCodeList);
					}
				}
				//根据标的代码查询数据库危险单位信息  end

				
			    double dbSumLoss = 0D;
	            double dbshare = 0D;
	            double tempSumLoss=0D;
	            //危险单位估损金额按照标的序号最后一位减法原则处理
	            boolean flag = false;
	            NewDangerUnitDto  newDangerUnitDto=null;
	            for(int i=0;i<prpdangerUnitList.size();i++){
	            	newDangerUnitDto= (NewDangerUnitDto)prpdangerUnitList.get(i);
	            	dbSumLoss = Double.parseDouble(Str.chgStrZero("" + kindMap.get(newDangerUnitDto.getItemkindno())));
	            	dbshare = Double.parseDouble(Str.chgStrZero(newDangerUnitDto.getDangerkindshare()));
	            	flag = false;
	                for(int j=i+1;j<prpdangerUnitList.size();j++){
	                	NewDangerUnitDto  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(i);
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
	            		 NewDangerUnitDto  newDangerUnitDtoTemp= (NewDangerUnitDto)prpdangerUnitList.get(k);
	            		 if(newDangerUnitDtoTemp.getItemkindno().equals(newDangerUnitDto.getItemkindno())){
	           				 tempSumLoss+=Double.parseDouble(Str.chgStrZero(newDangerUnitDtoTemp.getDangerkindAmount())); 
	           			 } 
	                	}
	            		newDangerUnitDto.setDangerkindAmount(""+Str.round((dbSumLoss-tempSumLoss),2));
	                }
	            }
		  

                
           request.setAttribute("prpdangerUnitList", prpdangerUnitList);
           request.setAttribute("prpLdangerRiskCompensate", prpLdangerRiskCompensate);
           request.setAttribute("prpLcompensateRiskCode", prpLcompensateRiskCode);
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
