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
 * �ַ�HTTP GET ����ǰ����Σ�յ�λ����
 * <p>
 * Title: ����ǰ����Σ�յ�λ��Ϣ
 * </p>
 * 
 * @author ��Ԫ��Ŀ��
 * @version 1.0
 */
public class UILCompensateDangerUnitFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String policyNo = request.getParameter("prpLcompensatePolicyNo"); // ������
        String prpLclaimDamageStartDate = request.getParameter("prpLcompensateDamageStartDate").substring(0,10);//��������
        String[] prpLlossDtoKindCode=  request.getParameterValues("prpLlossDtoKindCode"); //������ձ����	
        String[] prpLlossDtoSumRealPay=  request.getParameterValues("prpLlossDtoSumRealPay"); //������⸶���
        
        String[] registNo = request.getParameterValues("prpLcompensateRegistNo");// ������
        
        String[] prpLpersonLossKindCode = request.getParameterValues("prpLpersonLossKindCode");//��Ա���ձ����
        String[] prpLpersonLossSumRealPay = request.getParameterValues("prpLpersonLossSumRealPay");//��Ա���⸶���
        String[] prpLpersonLossSumRealPay1 = request.getParameterValues("prpLpersonLossSumRealPay1");//��Ա���⸶�ϼ�
        
        String[] prpLlossDtoItemKindNoForCharge = request.getParameterValues("prpLlossDtoItemKindNoForCharge");//���õı�����
        String[] prpLchargeKindCode = request.getParameterValues("prpLchargeKindCode");//���õ��ձ����
        String[] prpLchargeSumRealPay = request.getParameterValues("prpLchargeSumRealPay");//���õ��⸶���
        String[] prpLchargeChargeAmount = request.getParameterValues("prpLchargeChargeAmount");//���õ�ʵ�ʷ���
        
        String prpLcompensateRiskCode = request.getParameter("prpLcompensateRiskCode");//���ִ���	
        String prpLcompensateSumPaid=request.getParameter("prpLcompensateSumPaid");//���⸶���
        String prpLcompensateClassCode=request.getParameter("prpLcompensateClassCode");//�������
        String registno = request.getParameter("registno");//������
        String[] arrItemKindNo=request.getParameterValues("prpLlossDtoItemKindNo");//��Ĵ���
        String[] arrItemKindNoE=request.getParameterValues("prpLpersonLossItemKindNo");//�⽡�ջ��ձ�Ĵ���
        
        String prpLdangerRiskCompensate = request.getParameter("prpLdangerRiskCompensate");//�����־
               
        String forward = ""; // ��ǰ
        List prpdangerUnitList = new ArrayList();
        
        
        try {
               
			Map kindMap = new HashMap();
			//ƴ�ӱ�����ʹ��
			String strKindCodeList = "";
			
			//ƴ�����Ŵ���ͼ����⸶��� start
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
		
			
			    //���ݱ�Ĵ����ѯ���ݿ�Σ�յ�λ��Ϣ  start
			    DBPrpPhead dbPrpPhead = new DBPrpPhead();
				BLDangerUnitFacade blDangerFacade = new BLDangerUnitFacade();
				// ����ڳ���ʱ��֮ǰ�������ģ���ȡpdangunit������ݣ�����ȡcdangunit�������
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
				//���ݱ�Ĵ����ѯ���ݿ�Σ�յ�λ��Ϣ  end

				
			    double dbSumLoss = 0D;
	            double dbshare = 0D;
	            double tempSumLoss=0D;
	            //Σ�յ�λ������ձ��������һλ����ԭ����
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
            // ������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError("title.claimDangerUnit.NewRiskUnit");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            request.setAttribute("errorMessage", usee.getErrorMessage());
            saveErrors(request, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            // ������Ϣ����
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
