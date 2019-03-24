package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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


import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;
import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLClaimStatusFacade;
import com.sinosoft.claim.bl.facade.BLDangerUnitFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.NewDangerUnitDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.prpall.dbsvr.pg.DBPrpPhead;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.string.Str;
/**
 * 分发HTTP GET 理算生成标的信息请求
 * <p>
 * Title: 理算生成标的信息
 * </p>
 * 
 * @author 国元项目组
 * @version 1.0
 */
public class UILCompensateLlossFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

    	String settleListCode=request.getParameter("SettleListCode");
    	String policyNo=request.getParameter("policyNo");
    	String claimNo=request.getParameter("claimNo");
    	String conditions1 = " ClaimNo='" + claimNo + "' order by compensateNo DESC";
    	String NodeType="compe";
    	String NodeType1="claim";
    	String NodeType2="check";
    	double DamageInsured=0; 
    	double NoProductionArea=0; 
    	double SettleAreaAll=0; 
    	int lossCount=0;
    	String Flag="0";
        BLPlantingsettlelistFacade blPlantingsettlelist=new BLPlantingsettlelistFacade();
        PrpLcompensateDto prpLcompensateDto=null;
        PlantingsettlelistDto plantingsettlelistDto=null;
        PlantingsettlelistDto plantingsettlelistDtoTemp=null;
        UICompensateAction uiCompensateAction = new UICompensateAction();
        String conditions="";
        String policyConditions="";
        String forward = ""; // 向前
        List prpCompensateLossList = new ArrayList();
        
        
        try {
            if(null!=settleListCode && !"".equals(settleListCode)){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
            }
            ArrayList arr=(ArrayList)blPlantingsettlelist.findByConditions(conditions);
            lossCount=blPlantingsettlelist.getCount(conditions);
            if(arr.size()<1){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType1+"' and validity='1'";
            	arr=(ArrayList)blPlantingsettlelist.findByConditions(conditions);
            	lossCount=blPlantingsettlelist.getCount(conditions);
            }
            if(arr.size()<1){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType2+"' and validity='1'";
            	arr=(ArrayList)blPlantingsettlelist.findByConditions(conditions);
            	lossCount=blPlantingsettlelist.getCount(conditions);
            }
            DamageInsured=blPlantingsettlelist.getDamageInsured(conditions);
            plantingsettlelistDto=new PlantingsettlelistDto();
			plantingsettlelistDto=(PlantingsettlelistDto)arr.get(0);
           
			Map prpLlossDtoAmountMap = new HashMap();
			Map prpLlossDtoSumRealPayMap = new HashMap();
			Map prpLlossDtoSettleAreaMap = new HashMap();
			Map prpLlossDtoInsureAreaMap = new HashMap();
			Map NoProductionAreaMap = new HashMap();
			Map SettleAreaAllMap = new HashMap();
            double totalLossRate = 80;
            if(!"".equals(policyNo)&&null!=policyNo&&null!=plantingsettlelistDto){
            	policyConditions=" policyno='"+policyNo+"' and kindcode='"+plantingsettlelistDto.getKindcode()+"'";
            }
            BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
            List arrList = (ArrayList)blPrpCitemKindFacade.findByConditions(policyConditions);
            if(arrList.size()>0){
            PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)arrList.get(0);
            if(null!=prpCitemKindDto){
            double DeductibleRate=prpCitemKindDto.getDeductibleRate();
            String KindName=prpCitemKindDto.getKindName();
            String ItemCode=prpCitemKindDto.getItemCode();
            String LossName=prpCitemKindDto.getItemDetailName();
            int itemKindNo=prpCitemKindDto.getItemKindNo();
            totalLossRate = prpCitemKindDto.getTotalLossRatio();
            request.setAttribute("itemKindNo", itemKindNo);
            request.setAttribute("ItemCode", ItemCode);
            request.setAttribute("KindName", KindName);
            request.setAttribute("LossName", LossName);         
            request.setAttribute("DeductibleRate", String.valueOf(DeductibleRate));
            request.setAttribute("TotalLossRate", String.valueOf(totalLossRate));            
            }
            }
            //统计共有几种损失率（个数）
			int lossRateNum=blPlantingsettlelist.getDistinctLossRateCount(conditions);
			//计算绝产面积
			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(plantingsettlelistDto.getLossrate()>=totalLossRate){
				if(NoProductionAreaMap.containsKey(100)){
					double sumSettlearea=Double.parseDouble(String.valueOf(NoProductionAreaMap.get(100)))+plantingsettlelistDto.getSettlearea();
					NoProductionAreaMap.put(100,sumSettlearea);
				}else{
					NoProductionAreaMap.put(100, plantingsettlelistDto.getSettlearea());
				}
				}
			}
			//计算总赔付面积
			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(SettleAreaAllMap.containsKey(SettleAreaAll)){
					double sumSettlearea=Double.parseDouble(String.valueOf(SettleAreaAllMap.get(SettleAreaAll)))+plantingsettlelistDto.getSettlearea();
					SettleAreaAllMap.put(SettleAreaAll,sumSettlearea);
				}else{
					SettleAreaAllMap.put(SettleAreaAll, plantingsettlelistDto.getSettlearea());
				}
			}
			//分损失率计算赔付面积
			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(prpLlossDtoSettleAreaMap.containsKey(plantingsettlelistDto.getLossrate())){
					double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(plantingsettlelistDto.getLossrate())))+plantingsettlelistDto.getSettlearea();
					prpLlossDtoSettleAreaMap.put(plantingsettlelistDto.getLossrate(),sumSettlearea);
				}else{
					prpLlossDtoSettleAreaMap.put(plantingsettlelistDto.getLossrate(), plantingsettlelistDto.getSettlearea());
				}
			}
			//分损失率计算承保面积

			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(prpLlossDtoInsureAreaMap.containsKey(plantingsettlelistDto.getLossrate())){
					double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(plantingsettlelistDto.getLossrate())))+plantingsettlelistDto.getInsurearea();
					prpLlossDtoInsureAreaMap.put(plantingsettlelistDto.getLossrate(),sumSettlearea);
				}else{
					prpLlossDtoInsureAreaMap.put(plantingsettlelistDto.getLossrate(), plantingsettlelistDto.getInsurearea());
				}
			}
			//分损失率计算赔偿金额

			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(prpLlossDtoSumRealPayMap.containsKey(plantingsettlelistDto.getLossrate())){
					String sumSettleSum=String.valueOf(Double.parseDouble(String.valueOf(prpLlossDtoSumRealPayMap.get(plantingsettlelistDto.getLossrate())))+Double.parseDouble(plantingsettlelistDto.getSettlesum()));;
					prpLlossDtoSumRealPayMap.put(plantingsettlelistDto.getLossrate(), sumSettleSum);
				}else{
					prpLlossDtoSumRealPayMap.put(plantingsettlelistDto.getLossrate(), plantingsettlelistDto.getSettlesum());
				}
			}
			//分损失率计算出险面积保险金额

			for(int i=0;i<lossCount;i++){
				plantingsettlelistDto=new PlantingsettlelistDto();
				plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				if(prpLlossDtoAmountMap.containsKey(plantingsettlelistDto.getLossrate())){
					String Suminsured=String.valueOf(Double.parseDouble((String.valueOf(prpLlossDtoAmountMap.get(plantingsettlelistDto.getLossrate()))))+Double.parseDouble(plantingsettlelistDto.getSuminsured()));
					prpLlossDtoAmountMap.put(plantingsettlelistDto.getLossrate(), Suminsured);
				}else{
					prpLlossDtoAmountMap.put(plantingsettlelistDto.getLossrate(), plantingsettlelistDto.getSuminsured());
				}
			}
			//案后重开处理start
			ClaimDto claimDto=new ClaimDto();
			BLClaimFacade blClaimFacade=new BLClaimFacade();
			claimDto=(ClaimDto)blClaimFacade.findByPrimaryKey(claimNo);
			String registNo=claimDto.getPrpLclaimDto().getRegistNo();
            ArrayList collection = (ArrayList)uiCompensateAction.findByConditions(conditions1);
            if(collection.size()>0){
            	prpLcompensateDto=new PrpLcompensateDto();
            	prpLcompensateDto=(PrpLcompensateDto)collection.get(0);
            }
            if(collection.size()>0&&"1".equals(prpLcompensateDto.getUnderWriteFlag())){
            	//统计户次strat
            	ArrayList insuredList=new ArrayList();
            	double DamageInsured1=0;
            	Map damageInsuredMap = new HashMap();
            	Map damageInsuredMap1 = new HashMap();
                String damageInsuredCondtion=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and nodeType='"+NodeType+"' and validity='1'";
                List arrList1 = (ArrayList)blPlantingsettlelist.findByConditions(damageInsuredCondtion);
                String damageInsuredCondtion1=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and settleListCode<>'"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
                List arrList2 = (ArrayList)blPlantingsettlelist.findByConditions(damageInsuredCondtion1);
                if(arrList2.size()>0){
                for(int i=0;i<arrList1.size();i++){
                	plantingsettlelistDto=new PlantingsettlelistDto();
    				plantingsettlelistDto=(PlantingsettlelistDto)arrList1.get(i);
    				if(damageInsuredMap.containsKey(plantingsettlelistDto.getFcode())){
    				   double damageInsured=Double.parseDouble(String.valueOf(damageInsuredMap.get(plantingsettlelistDto.getFcode())))+plantingsettlelistDto.getSettlearea();
    				   damageInsuredMap.put(plantingsettlelistDto.getFcode(), damageInsured);
    				}else{
    				   damageInsuredMap.put(plantingsettlelistDto.getFcode(), plantingsettlelistDto.getSettlearea());  				   
    				}
                }
                for(int i=0;i<arrList2.size();i++){
                	plantingsettlelistDto=new PlantingsettlelistDto();
    				plantingsettlelistDto=(PlantingsettlelistDto)arrList2.get(i);
    				if(damageInsuredMap1.containsKey(plantingsettlelistDto.getFcode())){
    				   double damageInsured=Double.parseDouble(String.valueOf(damageInsuredMap.get(plantingsettlelistDto.getFcode())))+plantingsettlelistDto.getSettlearea();
    				   damageInsuredMap1.put(plantingsettlelistDto.getFcode(), damageInsured);
    				}else{
    				   damageInsuredMap1.put(plantingsettlelistDto.getFcode(), plantingsettlelistDto.getSettlearea());  				   
    				}
                }
                int countNo=0;
                for(int i=0;i<arr.size();i++){
                	plantingsettlelistDto=new PlantingsettlelistDto();
        			plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);       			
        			if(damageInsuredMap.containsKey(plantingsettlelistDto.getFcode())){
//     				   double damageInsured=Double.parseDouble(String.valueOf(damageInsuredMap.get(plantingsettlelistDto.getFcode())))+plantingsettlelistDto.getSettlearea();
//     				   damageInsuredMap.put(plantingsettlelistDto.getFcode(), damageInsured);
        	           if(countNo==0){
        			   insuredList.add(plantingsettlelistDto.getFcode());
        			   countNo=countNo+1;
        	           }else{
      				   for(int j=0;j<insuredList.size();j++){
     					   if( insuredList.contains(plantingsettlelistDto.getFcode())){							 
     					   }else{
          			       insuredList.add(plantingsettlelistDto.getFcode());
     					   }
     				   }
        	           }
     				}else{
//     				   damageInsuredMap.put(plantingsettlelistDto.getFcode(), plantingsettlelistDto.getSettlearea());
         	           if(countNo==0){
            			   insuredList.add(plantingsettlelistDto.getFcode());
            			   countNo=countNo+1;
            	           }else{
          				   for(int j=0;j<insuredList.size();j++){
         					   if(insuredList.contains(plantingsettlelistDto.getFcode())){				   
         					   }else{
              			       insuredList.add(plantingsettlelistDto.getFcode());
         					   }
         				   }
            	           }
     				}
                }
                	for(int i=0;i<insuredList.size();i++){
                    	if(Double.parseDouble(damageInsuredMap.get(insuredList.get(i)).toString())==0){
                    		DamageInsured1=DamageInsured1-1;
                    	}else{
                    		if((damageInsuredMap1.containsKey(insuredList.get(i)) && Double.parseDouble(damageInsuredMap1.get(insuredList.get(i)).toString())==0)&&damageInsuredMap.containsKey(insuredList.get(i))&&Double.parseDouble(damageInsuredMap.get(insuredList.get(i)).toString())!=0){
                    			DamageInsured1=DamageInsured1+1;
                    		}else if(!damageInsuredMap1.containsKey(insuredList.get(i))){
                    			DamageInsured1=DamageInsured1+1;
                    		}else{
                    			//不作处理
                    		}
                    	}
                    }                	
//                DamageInsured1=DamageInsured+DamageInsured1;
                //统计户次end
            	prpLcompensateDto=new PrpLcompensateDto();
            	prpLcompensateDto=(PrpLcompensateDto)collection.get(0);
            	if(!"".equals(NoProductionAreaMap.get(100))&&null!=NoProductionAreaMap.get(100)){
            	    NoProductionArea=Double.parseDouble(NoProductionAreaMap.get(100).toString());
            	}else{
            		NoProductionArea=0;
            	}
            	SettleAreaAll=Double.parseDouble(SettleAreaAllMap.get(SettleAreaAll).toString());
            	if(!prpLcompensateDto.getUnderWriteFlag().equals("1")){
            		throw new Exception("立案\"" + claimNo + "\"还未结案，不能重开赔案");	
            	}else{
            		Flag="1";
            	    request.setAttribute("prpLcompensateDto", prpLcompensateDto);
            	    request.setAttribute("DamageInsured", String.valueOf(DamageInsured1));
            	    request.setAttribute("NoProductionArea", String.valueOf(NoProductionArea));
            	    request.setAttribute("SettleAreaAll", String.valueOf(SettleAreaAll));
            	    request.setAttribute("Flag", String.valueOf(Flag));
            	}
                }else{
                	request.setAttribute("DamageInsured", String.valueOf(DamageInsured));
            	    request.setAttribute("Flag", String.valueOf(Flag));
                }
            	
            }else{
            	    request.setAttribute("DamageInsured", String.valueOf(DamageInsured));
            	    request.setAttribute("Flag", String.valueOf(Flag));
            }
            //案后重开处理end
			List LossRateList = new ArrayList();
			Iterator iter = prpLlossDtoSettleAreaMap.entrySet().iterator(); 
			while (iter.hasNext()) { 
			Map.Entry entry = (Map.Entry) iter.next(); 
			Object key = entry.getKey(); 
			LossRateList.add(key);
			} 
			for(int i=0;i<lossRateNum;i++){
				if(arr.size()>0){
				   plantingsettlelistDto=new PlantingsettlelistDto();
				   plantingsettlelistDto=(PlantingsettlelistDto)arr.get(i);
				}
				plantingsettlelistDtoTemp=new PlantingsettlelistDto();
				plantingsettlelistDtoTemp.setLossrate(Math.round(Double.parseDouble(LossRateList.get(i).toString())));
				plantingsettlelistDtoTemp.setSettlearea(Double.parseDouble(prpLlossDtoSettleAreaMap.get(LossRateList.get(i)).toString()));
				plantingsettlelistDtoTemp.setSuminsured(prpLlossDtoAmountMap.get(LossRateList.get(i)).toString());
				plantingsettlelistDtoTemp.setSettlesum(prpLlossDtoSumRealPayMap.get(LossRateList.get(i)).toString());
				plantingsettlelistDtoTemp.setClaimrate(plantingsettlelistDto.getClaimrate()*100);
				plantingsettlelistDtoTemp.setClasscode(plantingsettlelistDto.getClasscode());
				plantingsettlelistDtoTemp.setFareacode(plantingsettlelistDto.getFareacode());
				plantingsettlelistDtoTemp.setFcode(plantingsettlelistDto.getFcode());
				plantingsettlelistDtoTemp.setFidcard(plantingsettlelistDto.getFidcard());
				plantingsettlelistDtoTemp.setFname(plantingsettlelistDto.getFname());
				plantingsettlelistDtoTemp.setGrowingseason(plantingsettlelistDto.getGrowingseason());
				plantingsettlelistDtoTemp.setIndexofsettle(plantingsettlelistDto.getIndexofsettle());
				plantingsettlelistDtoTemp.setInusrelistcode(plantingsettlelistDto.getInusrelistcode());
				plantingsettlelistDtoTemp.setKindcode(plantingsettlelistDto.getKindcode());
				plantingsettlelistDtoTemp.setNodetype(plantingsettlelistDto.getNodetype());
				plantingsettlelistDtoTemp.setOpcode(plantingsettlelistDto.getOpcode());
				plantingsettlelistDtoTemp.setOptime(plantingsettlelistDto.getOptime());
				plantingsettlelistDtoTemp.setRemark(plantingsettlelistDto.getRemark());
				plantingsettlelistDtoTemp.setRiskcode(plantingsettlelistDto.getRiskcode());
				plantingsettlelistDtoTemp.setSettledate(plantingsettlelistDto.getSettledate());
				plantingsettlelistDtoTemp.setSettlelistcode(plantingsettlelistDto.getSettlelistcode());
				plantingsettlelistDtoTemp.setValidity(plantingsettlelistDto.getValidity());
				plantingsettlelistDtoTemp.setZhibuka(plantingsettlelistDto.getZhibuka());
				plantingsettlelistDtoTemp.setInsurearea(Double.parseDouble(prpLlossDtoInsureAreaMap.get(LossRateList.get(i)).toString()));

				prpCompensateLossList.add(plantingsettlelistDtoTemp);
				
			}
			             
           request.setAttribute("prpCompensateLossList", prpCompensateLossList);
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
