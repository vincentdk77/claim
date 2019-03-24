
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
public class UILClaimDangerUnitFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String policyNo = request.getParameter("prpLclaimPolicyNo"); // ������
        String prpLclaimDamageStartDate = request.getParameter("prpLclaimDamageStartDate");//����ʱ��
        String[] arrkindCode=  request.getParameterValues("prpLclaimLossKindCode"); //�ձ����	
        String[] arrsumloss=  request.getParameterValues("prpLclaimLossSumClaim"); //������
        String[] registNo = request.getParameterValues("prpLclaimRegistNo");// ������
        String[] arrItemKindNo = request.getParameterValues("prpLclaimLossItemKindNo"); //������
        String editType=request.getParameter("prpLdangerRiskeditType"); // �޸�����
        String[] ClaimLossFlag=request.getParameterValues("ClaimLossFlag"); // �޸�����������־λ
        String[] prpLclaimLossInputDate=request.getParameterValues("prpLclaimLossInputDate");//��������
        String[] arrsumlossNew=  request.getParameterValues("prpLclaimLossSumClaim"); //�޸������Ĺ�����
        String prpLclaimRegistNo = request.getParameter("prpLclaimRegistNo");//  �޸�����������
        String policyNoNew = request.getParameter("policyno"); // ������ 
        
        String forward = ""; // ��ǰ
        List prpdangerUnitList = new ArrayList();
		
        
        try {
        		Map kindMap = new HashMap();
                DBPrpPhead dbPrpPhead = new DBPrpPhead();
                BLDangerUnitFacade blDangerFacade=new BLDangerUnitFacade();
                
                if ("modifyDetail".equals(editType)) {
                	String wherepart=" policyno='"+policyNoNew+"' and validdate <= date '"+prpLclaimDamageStartDate+"' and underwriteflag in ('1','3') ";
                	int count=dbPrpPhead.getCount(wherepart);
                	//���ݱ����Ų�ѯ���ݿ�Σ�յ�λ��Ϣ
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
                	//����ڳ���ʱ��֮ǰ�������ģ���ȡpdangunit������ݣ�����ȡcdangunit�������
                    String wherepart=" policyno='"+policyNo+"' and validdate <= date '"+prpLclaimDamageStartDate+"' and underwriteflag in ('1','3') ";
                    int count=dbPrpPhead.getCount(wherepart);
                    
                    //���ݱ����Ų�ѯ���ݿ�Σ�յ�λ��Ϣ
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
        		
        			 //Σ�յ�λ������ձ��������һλ����ԭ����
        			  double dbSumLoss = 0D;
                      double dbshare = 0D;
                      double tempSumLoss=0D;
                     //�жϱ������Ƿ��Ǵ�Σ�յ�λ�����һ��
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
