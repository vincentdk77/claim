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


import com.gyic.claim.bl.facade.BLPlanting31SettleListFacade;
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.ui.control.facade.UIClaimPlanting31SettleLoadFacade;
import com.gyic.claim.ui.control.facade.UIClaimPlanting3224SettleLoadFacade;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemKind;
import com.sinosoft.prpall.schema.PrpCitemKindSchema;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 理算生成标的信息请求
 * <p>
 * Title: 理算生成标的信息
 * </p>
 * 
 * @author 国元项目组
 * @version 1.0
 */
public class UILCompensate3224LlossFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.err.println("555");
    	String settleListCode=request.getParameter("SettleListCode");
    	String policyNo=request.getParameter("policyNo");
    	String claimNo=request.getParameter("claimNo");
    	String conditions1 = " ClaimNo='" + claimNo + "' order by compensateNo DESC";
    	String NodeType="compe";
    	String NodeType1="claim";
    	double damageInsured=0; 
    	double NoProductionArea=0; 
    	double settleAreaAll=0; 
    	int lossCount=0;
    	String Flag="0";
    	BLNyxsettlelistFacade blNyxsettlelistFacade = new BLNyxsettlelistFacade();
        //BLPlanting31SettleListFacade blPlanting31SettleListFacade=new BLPlanting31SettleListFacade();
        PrpLcompensateDto prpLcompensateDto=null;
        NyxsettlelistDto nyxsettlelistDto = null;
        NyxsettlelistDto nyxsettlelistDtoTemp = null;
        
        //Planting31SettleListDto planting31SettleListDto=null;
        //Planting31SettleListDto Planting31SettleListDtoTemp=null;
        UICompensateAction uiCompensateAction = new UICompensateAction();
        String conditions="";
        String policyConditions="";
        String forward = ""; // 向前
        List prpCompensateLossList = new ArrayList();
        
        System.err.println("settleListCode:"+settleListCode);
        try {
        	//获取理算节点下所有的理赔清单
            if(!"".equals(settleListCode)&&null!=settleListCode){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
            }
            List arrPlanting3224SettleList=(ArrayList)blNyxsettlelistFacade.getGroupedSumData(conditions, true, true, true, true);
            
           
            if(arrPlanting3224SettleList.size()<1){
            	//如果理算节点下没有理赔清单，则将立案节点的清单导入到理算环节。
            	blNyxsettlelistFacade.dumpByNodeType(settleListCode, NodeType1, NodeType);
            	//获取立案节点下所有的理赔清单
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType1+"' and validity='1'";
            	arrPlanting3224SettleList=(ArrayList)blNyxsettlelistFacade.getGroupedSumData(conditions, true, true, true, true);
            }
            
            System.err.println("size:"+arrPlanting3224SettleList.size());
            
            damageInsured=blNyxsettlelistFacade.getDamageInsured(conditions);//出险户次
            System.err.println("damageInsured:"+damageInsured);
            
            nyxsettlelistDto=new NyxsettlelistDto();
           
			Map prpLlossDtoAmountMap = new HashMap();
			Map prpLlossDtoSumRealPayMap = new HashMap();
			Map prpLlossDtoSettleAreaMap = new HashMap();
			Map prpLlossDtoInsureAreaMap = new HashMap();
			Map settleAreaAllMap = new HashMap();
			Map deductibleRateMap = new HashMap();//绝对免赔率  存储方式： kindCode_itemCode:绝对免赔率
			Map deductibleMap = new HashMap();//绝对免赔额 存储方式： kindCode_itemCode:绝对免赔额
			Map franchiseDeductibleRateMap = new HashMap();//相对免赔率 存储方式： kindCode_itemCode:相对免赔率
			Map franchiseDeductibleMap = new HashMap();//相对免赔额 存储方式： kindCode_itemCode:相对免赔额
			Map triggerPointeMap = new HashMap();//起赔点 存储方式： kindCode_itemCode:起赔点
			Map totalLossRatePointMap = new HashMap();//全赔起点 存储方式： kindCode_itemCode:全赔起点
			Map itemCodeIndexMap = new HashMap();//标的序号 存储方式： kindCode_itemCode:标的序号
			
			//获取当前保单下所有的标的信息，获取其中的相对免赔率，相对免赔额，绝对免赔率，绝对免赔额，并将其放到requset中。
            if(!"".equals(policyNo)&&null!=policyNo&&null!=nyxsettlelistDto){
            	policyConditions=" policyno='"+policyNo+"' ";
            }
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
            blPrpCitemKind.query(policyConditions);
            System.err.println("damageInsured:"+damageInsured);
            if(null != blPrpCitemKind && blPrpCitemKind.getSize() > 0){
            	System.err.println("size2:"+blPrpCitemKind.getSize());
            	UIClaimPlanting3224SettleLoadFacade uiClaimPlanting3224SettleLoadFacade = new UIClaimPlanting3224SettleLoadFacade();
	            //UIClaimPlanting31SettleLoadFacade uiClaimPlanting31SettleLoadFacade = new UIClaimPlanting31SettleLoadFacade();
            	for(int index=0; index < blPrpCitemKind.getSize(); index++){
		            PrpCitemKindSchema prpCitemKindSchema = (PrpCitemKindSchema)blPrpCitemKind.getArr(index);
		            String strKindCode=prpCitemKindSchema.getKindCode();
		            String strItemCode=prpCitemKindSchema.getItemCode();
	            	double deductibleRate = uiClaimPlanting3224SettleLoadFacade.getDeductibleRate(prpCitemKindSchema);
		            deductibleRateMap.put(""+strKindCode+"_"+strItemCode, deductibleRate);
		            double deductible = uiClaimPlanting3224SettleLoadFacade.getDeductible(prpCitemKindSchema);
		            deductibleMap.put(""+strKindCode+"_"+strItemCode, deductible);
		            double franchiseDeductible = uiClaimPlanting3224SettleLoadFacade.getFranchiseDeductible(prpCitemKindSchema);
		            franchiseDeductibleMap.put(""+strKindCode+"_"+strItemCode, franchiseDeductible);
		            double franchiseDeductibleRate = uiClaimPlanting3224SettleLoadFacade.getFranchiseDeductibleRate(prpCitemKindSchema);
		            franchiseDeductibleRateMap.put(""+strKindCode+"_"+strItemCode, franchiseDeductibleRate);
		            double triggerPoint = uiClaimPlanting3224SettleLoadFacade.getTriggerPoint(prpCitemKindSchema);
		            triggerPointeMap.put(""+strKindCode+"_"+strItemCode, triggerPoint);
		            double totalLossRatePoint = uiClaimPlanting3224SettleLoadFacade.getTotalLossRatePoint(prpCitemKindSchema);
		            totalLossRatePointMap.put(""+strKindCode+"_"+strItemCode, totalLossRatePoint);
		            String itemCodeIndex = prpCitemKindSchema.getItemKindNo();
		            itemCodeIndexMap.put(""+strKindCode+"_"+strItemCode, itemCodeIndex);
            	}
            	request.setAttribute("deductibleRateMap", deductibleRateMap);
            	request.setAttribute("deductibleMap", deductibleMap);
            	request.setAttribute("franchiseDeductibleMap", franchiseDeductibleMap);
            	request.setAttribute("franchiseDeductibleRateMap", franchiseDeductibleRateMap);
            	request.setAttribute("itemCodeIndexMap", itemCodeIndexMap);
            	request.setAttribute("totalLossRatePointMap", totalLossRatePointMap);
            }
            //对分类汇总出来的理赔清单进行整理，把按照核心标的表中的全损定义，把全损损失按照险别，标的再次汇总。
//            sumByLossRate(arrPlanting31SettleList,totalLossRatePointMap);
            //对于全损的农户，按照险别，标的单独汇总，防止同一农户同险别同标的保额重复计算。
//            sumOfTotalInsured(totalLossRatePointMap, arrPlanting31SettleList, settleListCode);
            
            //对理赔清单数据进行汇总
            lossCount=arrPlanting3224SettleList.size();
            System.err.println("lossCount:"+lossCount);
			for(int i=0;i<lossCount;i++){
				nyxsettlelistDto=new NyxsettlelistDto();
				nyxsettlelistDto=(NyxsettlelistDto)arrPlanting3224SettleList.get(i);
				nyxsettlelistDto.setRiskcode(getRiskCodeFromPolicyNo(policyNo));
				//分险别，标的，损失率计算赔付面积（包含绝产面积）
				calculateLossAreaSum(nyxsettlelistDto,prpLlossDtoSettleAreaMap, totalLossRatePointMap);
				//分险别，标的，损失率计算承保面积
				calculateInsuredAreaSum(nyxsettlelistDto,prpLlossDtoInsureAreaMap, totalLossRatePointMap);
				//分险别，标的，损失率计算出险面积赔偿金额
				calculateLossRealPaySum(nyxsettlelistDto,prpLlossDtoSumRealPayMap, totalLossRatePointMap);
				//分险别，标的，损失率计算出险面积保险金额
				calculateLossAmountSum(nyxsettlelistDto,prpLlossDtoAmountMap, totalLossRatePointMap);
			}
			//计算赔付面积
			double settleArea = calculateTotalLossAreaSum(conditions);
			System.err.println("lossCount:"+lossCount);
			request.setAttribute("SettleAreaAll", ""+settleArea);
			//计算绝产面积
			double noProductionArea = calculateNoProductionArea(arrPlanting3224SettleList,totalLossRatePointMap);
    	    request.setAttribute("NoProductionArea", ""+noProductionArea);

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
            	double damageInsured1=0;
            	Map damageInsuredMapAll = new HashMap();
            	Map damageInsuredMapPrevious = new HashMap();
            	Map fIdCardMap = new HashMap();
                String damageInsuredAllCondtion=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and nodeType='"+NodeType+"' and validity='1'";
                List arrListAll = (ArrayList)blNyxsettlelistFacade.getGroupedSumDataByFcode(damageInsuredAllCondtion);
                String damageInsuredPreviousCondtion=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and settleListCode<>'"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
                List arrListPrevious = (ArrayList)blNyxsettlelistFacade.getGroupedSumDataByFcode(damageInsuredPreviousCondtion);
                List fIdCardList = new ArrayList();
                List kindCodeList = new ArrayList();
                List itemCodeList = new ArrayList();
                List lossRateList = new ArrayList();
                List keyList = new ArrayList();
                if(arrListPrevious.size()>0){
                	//案后重开的情况。对受益户次做修正。
                	for(int i =0; i < arrListAll.size(); i++){
                		nyxsettlelistDto=new NyxsettlelistDto();
                		nyxsettlelistDto=(NyxsettlelistDto)arrListAll.get(i);
	                	if(nyxsettlelistDto.getSettlesum()!=0){
		    				damageInsuredMapAll.put(""+nyxsettlelistDto.getFidcard()+"_"+nyxsettlelistDto.getKindcode()+"_"+nyxsettlelistDto.getItemcode()+"_"+nyxsettlelistDto.getLossrate(), nyxsettlelistDto.getSettlesum());
		    				fIdCardMap.put(""+nyxsettlelistDto.getFidcard()+"_"+nyxsettlelistDto.getKindcode()+"_"+nyxsettlelistDto.getItemcode()+"_"+nyxsettlelistDto.getLossrate(), nyxsettlelistDto.getFidcard());
		    				keyList.add(""+nyxsettlelistDto.getFidcard()+"_"+nyxsettlelistDto.getKindcode()+"_"+nyxsettlelistDto.getItemcode()+"_"+nyxsettlelistDto.getLossrate());
	                	}
                	}
                	Map fIdCardCountedMap = new HashMap();
                	if(keyList.size()>0){
                		for(int indexKey =0; indexKey < keyList.size(); indexKey++){
                			String key = keyList.get(indexKey).toString();
                			double settleSum = Double.parseDouble(damageInsuredMapAll.get(key).toString());
                			String strFIdCard = fIdCardMap.get(key).toString();
                			if(null == fIdCardCountedMap || fIdCardCountedMap.get(fIdCardMap) == null){
                				fIdCardCountedMap.put(fIdCardMap, fIdCardMap);
                				if(settleSum>0)
                					damageInsured1 ++;
                				else damageInsured1 --;
                			}
                		}
                	}
//                	for(int i=0;i<arrListPrevious.size();i++){
//	                	planting31SettleListDto=new Planting31SettleListDto();
//	                	planting31SettleListDto=(Planting31SettleListDto)arrListPrevious.get(i);
//	    				damageInsuredMapPrevious.put(""+planting31SettleListDto.getFidCard()+"_"+planting31SettleListDto.getKindCode()+"_"+planting31SettleListDto.getItemCode()+"_"+planting31SettleListDto.getLossRate(), planting31SettleListDto.getSettleArea());
//	    				fIdCardList.add(planting31SettleListDto.getFidCard());
//	    				kindCodeList.add(planting31SettleListDto.getKindCode());
//	    				itemCodeList.add(planting31SettleListDto.getItemCode());
//	    				lossRateList.add(planting31SettleListDto.getLossRate());
//	                }
//                	if(null !=fIdCardList && null != kindCodeList && null != itemCodeList && null != lossRateList){
//                		String key = "";
//                		boolean needMinus = true;
//                		boolean needAdd = true;
//	                	for(int iFcodeIndex=0;iFcodeIndex<fIdCardList.size();iFcodeIndex++){
//	                		//首先对需要做减法的户数统计出来
//	                		needMinus = true;
//	                		for(int iKindCodeIndex = 0; iKindCodeIndex < kindCodeList.size(); iKindCodeIndex ++){
//	                			for(int iItemCodeIndex = 0; iItemCodeIndex < itemCodeList.size(); iItemCodeIndex ++){
//		                			for(int iLossRateIndex = 0; iLossRateIndex < lossRateList.size(); iLossRateIndex ++){
//		                				key = ""+fIdCardList.get(iFcodeIndex)+"_"+kindCodeList.get(iKindCodeIndex)+"_"+itemCodeList.get(iItemCodeIndex)+"_"+lossRateList.get(iLossRateIndex);
//		                				if(null != damageInsuredMapAll.get(key) && Double.parseDouble(damageInsuredMapAll.get(key).toString())!=0){
//		                					needMinus = false;
//		                				}
//		                			}
//	                			}
//	                		}
//	                		if(needMinus){
//	                			damageInsured1=damageInsured1-1;
//	                		}
//	                		//统计需要做加法的户数
//	                		needAdd = true;
//	                		if(!needMinus){
//	                			for(int iKindCodeIndex = 0; iKindCodeIndex < kindCodeList.size(); iKindCodeIndex ++){
//		                			for(int iItemCodeIndex = 0; iItemCodeIndex < itemCodeList.size(); iItemCodeIndex ++){
//			                			for(int iLossRateIndex = 0; iLossRateIndex < lossRateList.size(); iLossRateIndex ++){
//			                				key = ""+fIdCardList.get(iFcodeIndex)+"_"+kindCodeList.get(iKindCodeIndex)+"_"+itemCodeList.get(iItemCodeIndex)+"_"+lossRateList.get(iLossRateIndex);
//			                				if((damageInsuredMapPrevious.containsKey(key) && Double.parseDouble(damageInsuredMapPrevious.get(key).toString())==0)&&damageInsuredMapAll.containsKey(key)&&Double.parseDouble(damageInsuredMapAll.get(key).toString())!=0){
//				                    			
//				                    		}else if(!damageInsuredMapPrevious.containsKey(key)){
//				                    		}else{
//				                    			needAdd = false;
//				                    		}
//			                			}
//		                			}
//		                		}
//	                			if(needAdd){
//	                				damageInsured1=damageInsured1+1;
//	                			}
//	                		}
//	                    }
//                	}
                	damageInsured=damageInsured1;
	                //统计户次end
	            	prpLcompensateDto=(PrpLcompensateDto)collection.get(0);
//	            	if(!"".equals(NoProductionAreaMap.get(100))&&null!=NoProductionAreaMap.get(100)){
//	            	    NoProductionArea=Double.parseDouble(NoProductionAreaMap.get(100).toString());
//	            	}else{
//	            		NoProductionArea=0;
//	            	}
	            	if(!prpLcompensateDto.getUnderWriteFlag().equals("1")){
	            		throw new Exception("立案\"" + claimNo + "\"还未结案，不能重开赔案");	
	            	}else{
	            		Flag="1";
	            	    request.setAttribute("prpLcompensateDto", prpLcompensateDto);
	            	    request.setAttribute("DamageInsured", String.valueOf(damageInsured1));
	            	    request.setAttribute("Flag", String.valueOf(Flag));
	            	}
                }else{
                	request.setAttribute("DamageInsured", String.valueOf(damageInsured));
            	    request.setAttribute("Flag", String.valueOf(Flag));
                }
            	
            }else{
            	    request.setAttribute("DamageInsured", String.valueOf(damageInsured));
            	    request.setAttribute("Flag", String.valueOf(Flag));
            }
            //案后重开处理end
           request.setAttribute("prpCompensateLossList", arrPlanting3224SettleList);
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
    //分险别，标的，损失率计算损失面积。
    public void calculateLossAreaSum(NyxsettlelistDto nyxsettlelistDto,Map prpLlossDtoSettleAreaMap, Map totalLossRatePointMap){
    	String kindCode = nyxsettlelistDto.getKindcode();
    	String itemCode = nyxsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(nyxsettlelistDto.getLossrate()>=totalLossRatePoint){//计算全损面积
    		key+="100"; 
			if(prpLlossDtoSettleAreaMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(key)))+nyxsettlelistDto.getSettlearea();
				prpLlossDtoSettleAreaMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoSettleAreaMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}else{//计算部分损失面积
			double lossRate = nyxsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoSettleAreaMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(key)))+nyxsettlelistDto.getSettlearea();
				prpLlossDtoSettleAreaMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoSettleAreaMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}
    }
    //计算总赔付面积
    //根据险种不同，每个多险别多标的险种需要自定义一个险别，标的汇总来作为赔付面积。
    public double calculateTotalLossAreaSum(String conditions)throws Exception{
		double settleArea = 0;
    	try {
			//使用总赔付面积的绝对值最大的作为总赔付面积。
    		BLNyxsettlelistFacade blNyxsettlelistFacade = new BLNyxsettlelistFacade();
			//BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
			Collection resultList = blNyxsettlelistFacade.getGroupedSumData(conditions, true, true, false, false);
			double settleAreaSum = 0;
			if(null!= resultList && resultList.size()>0){
				Iterator it = resultList.iterator();
				NyxsettlelistDto nyxsettlelistDtoTemp = new NyxsettlelistDto();
				//Planting31SettleListDto planting31SettleListDtoTemp = new Planting31SettleListDto();
				while(it.hasNext()){
					nyxsettlelistDtoTemp = (NyxsettlelistDto)it.next();
					double sum = nyxsettlelistDtoTemp.getSettlearea();
					if(Math.abs(sum)>Math.abs(settleAreaSum))
						settleAreaSum = sum;
				}
				settleArea = settleAreaSum;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return settleArea;
    }
    //分险别，标的，损失率计算承保面积
    public void calculateInsuredAreaSum(NyxsettlelistDto nyxsettlelistDto,Map prpLlossDtoInsureAreaMap, Map totalLossRatePointMap){
    	String kindCode = nyxsettlelistDto.getKindcode();
    	String itemCode = nyxsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(nyxsettlelistDto.getLossrate()>=totalLossRatePoint){//计算全损面积
    		key+="100"; 
			if(prpLlossDtoInsureAreaMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoInsureAreaMap.get(key)))+nyxsettlelistDto.getSettlearea();
				prpLlossDtoInsureAreaMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoInsureAreaMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}else{//计算部分损失面积
			double lossRate = nyxsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoInsureAreaMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoInsureAreaMap.get(key)))+nyxsettlelistDto.getSettlearea();
				prpLlossDtoInsureAreaMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoInsureAreaMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}
    }
    //分险别，标的，损失率计算出险面积保险金额
    public void calculateLossRealPaySum(NyxsettlelistDto nyxsettlelistDto,Map prpLlossDtoSumRealPayMap, Map totalLossRatePointMap){
    	String kindCode = nyxsettlelistDto.getKindcode();
    	String itemCode = nyxsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(nyxsettlelistDto.getLossrate()>=totalLossRatePoint){//计算全损面积
    		key+="100"; 
			if(prpLlossDtoSumRealPayMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSumRealPayMap.get(key)))+nyxsettlelistDto.getSettlesum();
				prpLlossDtoSumRealPayMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoSumRealPayMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}else{//计算部分损失面积
			double lossRate = nyxsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoSumRealPayMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSumRealPayMap.get(key)))+nyxsettlelistDto.getSettlesum();
				prpLlossDtoSumRealPayMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoSumRealPayMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}
    }
	//分险别，标的，损失率计算出险面积保险金额
    public void calculateLossAmountSum(NyxsettlelistDto nyxsettlelistDto,Map prpLlossDtoAmountMap, Map totalLossRatePointMap){
    	String kindCode = nyxsettlelistDto.getKindcode();
    	String itemCode = nyxsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(nyxsettlelistDto.getLossrate()>=totalLossRatePoint){//计算全损面积
    		key+="_100"; 
			if(prpLlossDtoAmountMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoAmountMap.get(key)))+nyxsettlelistDto.getSuminsured();
				prpLlossDtoAmountMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoAmountMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}else{//计算部分损失面积
			double lossRate = nyxsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoAmountMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoAmountMap.get(key)))+nyxsettlelistDto.getSuminsured();
				prpLlossDtoAmountMap.put(key,sumSettlearea);
			}else{
				prpLlossDtoAmountMap.put(key, nyxsettlelistDto.getSettlearea());
			}
		}
    }
    //将全损的理赔金额面积合并。
    public void sumByLossRate(List arrPlanting31SettleList, Map totalLossRatePointMap){
    	if(null!=arrPlanting31SettleList && null!=totalLossRatePointMap){
    		NyxsettlelistDto nyxsettlelistDto;
    		NyxsettlelistDto nyxsettlelistDtoTemp;
    		
    		
    		//Planting31SettleListDto planting31SettleListDto;
    		//Planting31SettleListDto planting31SettleListDtoTemp;
    		String kindCode = "";
    		String itemCode = "";
    		String key = "";
    		String strTotalLossRatePoint = "";
    		double totalLossRatePoint = 100;
    		for(int i=0;i<arrPlanting31SettleList.size();i++){
    			nyxsettlelistDto = (NyxsettlelistDto)arrPlanting31SettleList.get(i);
    			kindCode = nyxsettlelistDto.getKindcode();
    	    	itemCode = nyxsettlelistDto.getItemcode();
    	    	key = ""+kindCode+"_"+itemCode;
    	    	strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	    	totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint)*100;
    	    	if(0==totalLossRatePoint)
    	    		totalLossRatePoint = 100;
    	    	if(nyxsettlelistDto.getLossrate()>=totalLossRatePoint){
    	    		nyxsettlelistDto.setLossrate(100);
    	    		key+="100";
    	    		for(int j=0;j<i;j++){
    	    			nyxsettlelistDtoTemp = (NyxsettlelistDto)arrPlanting31SettleList.get(j);
    	    			if(nyxsettlelistDto.getItemcode().equals(nyxsettlelistDtoTemp.getItemcode()) && nyxsettlelistDto.getKindcode().equals(nyxsettlelistDtoTemp.getKindcode()) && nyxsettlelistDto.getClaimrate() == nyxsettlelistDtoTemp.getClaimrate() && nyxsettlelistDtoTemp.getLossrate()>=totalLossRatePoint){
    	    				nyxsettlelistDtoTemp.setSettlearea(nyxsettlelistDto.getSettlearea()+nyxsettlelistDtoTemp.getSettlearea());
    	    				nyxsettlelistDtoTemp.setSettlesum(nyxsettlelistDto.getSettlesum()+nyxsettlelistDtoTemp.getSettlesum());
    	    				arrPlanting31SettleList.remove(i);
    	    				i--;
    	    				break;
    	    			}
    	    		}
    			}
    		}
    	}
    }
    //按照农户汇总全损的保险金额，防止同一农户的重复汇总
    public void sumOfTotalInsured(Map totalLossRatePointMap, List arrPlanting31SettleList, String settleListCode)throws Exception{
    	try {
			if(null != arrPlanting31SettleList && arrPlanting31SettleList.size()>0){
				NyxsettlelistDto nyxsettlelistDto;
				//Planting31SettleListDto planting31SettleListDto;
				BLNyxsettlelistFacade blNyxsettlelistFacade = new BLNyxsettlelistFacade();
				//BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
				String key = "";
				String fKey = "";
				String strTotalLossRatePoint = "";
				String kindCode = "";
				String itemCode = "";
				double claimRate = 0;
				double totalLossRate = 100;
				for(int i = 0; i< arrPlanting31SettleList.size(); i++){
					nyxsettlelistDto = (NyxsettlelistDto)arrPlanting31SettleList.get(i);
					double lossRate = nyxsettlelistDto.getLossrate();
					if(100==lossRate){
						kindCode = nyxsettlelistDto.getKindcode();
				    	itemCode = nyxsettlelistDto.getItemcode();
				    	key = ""+kindCode+"_"+itemCode;
				    	claimRate = nyxsettlelistDto.getClaimrate();
				    	if(null!=totalLossRatePointMap.get(key))
				    		totalLossRate = Double.parseDouble(String.valueOf(totalLossRatePointMap.get(key)))*100;
				    	if(0==totalLossRate)
				    		totalLossRate = 100;
				    	String sqlCondition = " settleListCode = '"+settleListCode+"' and kindCode = '"+kindCode +"' and itemCode = '"+itemCode+"' and claimRate = '"+claimRate+"' and nodeType = 'compe' and validity = '1' and lossRate >= '"+totalLossRate+"'";
				    	Collection planting31SettleListTemp = blNyxsettlelistFacade.findByConditions(sqlCondition);
				    	if(null != planting31SettleListTemp && planting31SettleListTemp.size()>0){
							Map fCodeMap = new HashMap();
							Iterator it = planting31SettleListTemp.iterator();
							double sumInsured = 0;
							while(it.hasNext()){
								Planting31SettleListDto planting31SettleListDtoTemp = (Planting31SettleListDto)it.next();
						    	fKey = planting31SettleListDtoTemp.getFidCard();
								if(!fCodeMap.containsKey(fKey)){
					    			fCodeMap.put(fKey, fKey);
					    			sumInsured += planting31SettleListDtoTemp.getSumInsured();
					    		}
							}
							if(0!=sumInsured)
								nyxsettlelistDto.setSuminsured(sumInsured);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //取出各个标的中绝产最多的面积
    public double calculateNoProductionArea(List arrPlanting31SettleList, Map totalLossRatePointMap){
    	double noProductionArea = 0;
    	Map noProductionAreaMap = new HashMap();
    	List keyList = new ArrayList();
    	if(null != arrPlanting31SettleList && arrPlanting31SettleList.size() > 0 ){
    		for(int i =0;i<arrPlanting31SettleList.size();i++){
    			NyxsettlelistDto nyxsettlelistDto = (NyxsettlelistDto)arrPlanting31SettleList.get(i);
    			String key = ""+nyxsettlelistDto.getKindcode()+"_"+nyxsettlelistDto.getItemcode();
    			if(totalLossRatePointMap.containsKey(key) && null != totalLossRatePointMap.get(key) && !"".equals(totalLossRatePointMap.get(key))){
    				double totalLossRatePoint = Double.parseDouble(String.valueOf(totalLossRatePointMap.get(key)));
    				if(nyxsettlelistDto.getLossrate() >= totalLossRatePoint){
    					keyList.add(key);
    					if(noProductionAreaMap.containsKey(key))
    						noProductionAreaMap.put(key, nyxsettlelistDto.getSettlearea()+Double.parseDouble(String.valueOf(noProductionAreaMap.get(key))));
    					else
    						noProductionAreaMap.put(key, nyxsettlelistDto.getSettlearea());
    				}
    			}
    		}
    	}
    	if(null != keyList && keyList.size() > 0){
    		for(int i = 0; i < keyList.size(); i++){
    			String key = String.valueOf(keyList.get(i));
	    		Iterator it = noProductionAreaMap.entrySet().iterator();
    			double settleArea = Double.parseDouble(String.valueOf(noProductionAreaMap.get(key)));
    			if(Math.abs(settleArea)>Math.abs(noProductionArea))
    				noProductionArea = settleArea;
    		}
    	}
    	return noProductionArea;
    }
	//将字符串型数据转化证浮点型数据。
	private double transformStringToDouble(String stringValue){
		double doubleValue = 0.0;
		if(null!=stringValue && !"".equals(stringValue)){
			stringValue = trimAllSpace(stringValue);
			doubleValue = Double.parseDouble(stringValue);
		}
		return doubleValue;
	}
	
	public static String trimAllSpace(String str) {
		//return str == null ? str : str.replaceAll("^[\\s　]*|[\\s　]*$", "");  
		return str == null ? str : str.replaceAll("^[\\s　]*|，。？：；‘’！“”—……、|[\\s　]*$", "");  
	}
	//根据保单号获取险种代码
	private String getRiskCodeFromPolicyNo (String policyNo){
		String strRiskCode = "";
		if(null != policyNo && policyNo.length()>6){
			strRiskCode = policyNo.substring(1,5);//去保单号中的1-4位为险别代码。
		}
		return strRiskCode;
	}
}
