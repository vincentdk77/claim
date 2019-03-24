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


import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.ui.control.facade.UIClaimPlanting31SettleLoadFacade;
import com.gyic.claim.ui.control.facade.UIClaimPlanting3224SettleLoadFacade;
import com.gyic.claim.ui.control.facade.UIClaimTemblor0311SettleLoadFacade;
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
 * �ַ�HTTP GET �������ɱ����Ϣ����
 * <p>
 * Title: �������ɱ����Ϣ
 * </p>
 * 
 * @author ��Ԫ��Ŀ��
 * @version 1.0
 */
public class UILCompensate0311LlossFacade extends Action {
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
    	BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
        //BLPlanting31SettleListFacade blPlanting31SettleListFacade=new BLPlanting31SettleListFacade();
        PrpLcompensateDto prpLcompensateDto=null;
        TemblorsettlelistDto TemblorsettlelistDto = null;
        TemblorsettlelistDto TemblorsettlelistDtoTemp = null;
        
        //Planting31SettleListDto planting31SettleListDto=null;
        //Planting31SettleListDto Planting31SettleListDtoTemp=null;
        UICompensateAction uiCompensateAction = new UICompensateAction();
        String conditions="";
        String policyConditions="";
        String forward = ""; // ��ǰ
        List prpCompensateLossList = new ArrayList();
        
        System.err.println("settleListCode:"+settleListCode);
        try {
        	//��ȡ����ڵ������е������嵥
            if(!"".equals(settleListCode)&&null!=settleListCode){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
            }
            ArrayList arr=(ArrayList)blTemblorsettlelistFacade.findByConditions(conditions);
            lossCount=blTemblorsettlelistFacade.getCount(conditions);

            if(arr.size()<1){
            	conditions=" settleListCode='"+settleListCode+"' and nodeType='"+NodeType1+"' and validity='1'";
            	arr=(ArrayList)blTemblorsettlelistFacade.findByConditions(conditions);
            	lossCount=blTemblorsettlelistFacade.getCount(conditions);
            }

            damageInsured=blTemblorsettlelistFacade.getDamageInsured(conditions);

            System.err.println("damageInsured:"+damageInsured);
            
            TemblorsettlelistDto=new TemblorsettlelistDto();
           
			Map prpLlossDtoAmountMap = new HashMap();
			Map prpLlossDtoSumRealPayMap = new HashMap();
			Map prpLlossDtoSettleAreaMap = new HashMap();
			Map prpLlossDtoInsureAreaMap = new HashMap();
			Map settleAreaAllMap = new HashMap();
			Map deductibleRateMap = new HashMap();//����������  �洢��ʽ�� kindCode_itemCode:����������
			Map deductibleMap = new HashMap();//��������� �洢��ʽ�� kindCode_itemCode:���������
			Map franchiseDeductibleRateMap = new HashMap();//��������� �洢��ʽ�� kindCode_itemCode:���������
			Map franchiseDeductibleMap = new HashMap();//�������� �洢��ʽ�� kindCode_itemCode:��������
			Map triggerPointeMap = new HashMap();//����� �洢��ʽ�� kindCode_itemCode:�����
			Map totalLossRatePointMap = new HashMap();//ȫ����� �洢��ʽ�� kindCode_itemCode:ȫ�����
			Map itemCodeIndexMap = new HashMap();//������ �洢��ʽ�� kindCode_itemCode:������
			
			//��ȡ��ǰ���������еı����Ϣ����ȡ���е���������ʣ�����������������ʣ���������������ŵ�requset�С�
            if(!"".equals(policyNo)&&null!=policyNo&&null!=TemblorsettlelistDto){
            	policyConditions=" policyno='"+policyNo+"' ";
            }
			BLPrpCitemKind blPrpCitemKind = new BLPrpCitemKind();
            blPrpCitemKind.query(policyConditions);
            System.err.println("damageInsured:"+damageInsured);
            if(null != blPrpCitemKind && blPrpCitemKind.getSize() > 0){
            	System.err.println("size2:"+blPrpCitemKind.getSize());
            	UIClaimTemblor0311SettleLoadFacade uiClaimTemblor0311SettleLoadFacade = new UIClaimTemblor0311SettleLoadFacade();
	            //UIClaimPlanting31SettleLoadFacade uiClaimPlanting31SettleLoadFacade = new UIClaimPlanting31SettleLoadFacade();
            	for(int index=0; index < blPrpCitemKind.getSize(); index++){
		            PrpCitemKindSchema prpCitemKindSchema = (PrpCitemKindSchema)blPrpCitemKind.getArr(index);
		            String strKindCode=prpCitemKindSchema.getKindCode();
		            String strItemCode=prpCitemKindSchema.getItemCode();
	            	//double deductibleRate = uiClaimPlanting3224SettleLoadFacade.getDeductibleRate(prpCitemKindSchema);
		            //deductibleRateMap.put(""+strKindCode+"_"+strItemCode, deductibleRate);
		            //double deductible = uiClaimPlanting3224SettleLoadFacade.getDeductible(prpCitemKindSchema);
		            //deductibleMap.put(""+strKindCode+"_"+strItemCode, deductible);
		            //double franchiseDeductible = uiClaimPlanting3224SettleLoadFacade.getFranchiseDeductible(prpCitemKindSchema);
		            //franchiseDeductibleMap.put(""+strKindCode+"_"+strItemCode, franchiseDeductible);
		            //double franchiseDeductibleRate = uiClaimPlanting3224SettleLoadFacade.getFranchiseDeductibleRate(prpCitemKindSchema);
		            //franchiseDeductibleRateMap.put(""+strKindCode+"_"+strItemCode, franchiseDeductibleRate);
		            //double triggerPoint = uiClaimPlanting3224SettleLoadFacade.getTriggerPoint(prpCitemKindSchema);
		            //triggerPointeMap.put(""+strKindCode+"_"+strItemCode, triggerPoint);
		            double totalLossRatePoint = uiClaimTemblor0311SettleLoadFacade.getTotalLossRatePoint(prpCitemKindSchema);
		            totalLossRatePointMap.put(""+strKindCode+"_"+strItemCode, totalLossRatePoint);
		            String itemCodeIndex = prpCitemKindSchema.getItemKindNo();
		            System.err.println(itemCodeIndex);
		            itemCodeIndexMap.put(""+strKindCode+"_"+strItemCode, itemCodeIndex);
            	}
            	request.setAttribute("deductibleRateMap", deductibleRateMap);
            	request.setAttribute("deductibleMap", deductibleMap);
            	request.setAttribute("franchiseDeductibleMap", franchiseDeductibleMap);
            	request.setAttribute("franchiseDeductibleRateMap", franchiseDeductibleRateMap);
            	request.setAttribute("itemCodeIndexMap", itemCodeIndexMap);
            	request.setAttribute("totalLossRatePointMap", totalLossRatePointMap);
            }
            //�Է�����ܳ����������嵥���������Ѱ��պ��ı�ı��е�ȫ���壬��ȫ����ʧ�����ձ𣬱���ٴλ��ܡ�
//            sumByLossRate(arrPlanting31SettleList,totalLossRatePointMap);
            //����ȫ���ũ���������ձ𣬱�ĵ������ܣ���ֹͬһũ��ͬ�ձ�ͬ��ı����ظ����㡣
//            sumOfTotalInsured(totalLossRatePointMap, arrPlanting31SettleList, settleListCode);
            
            //�������嵥���ݽ��л���
            lossCount=arr.size();
            System.err.println("lossCount:"+lossCount);
			for(int i=0;i<lossCount;i++){
				TemblorsettlelistDto=new TemblorsettlelistDto();
				TemblorsettlelistDto=(TemblorsettlelistDto)arr.get(i);
				TemblorsettlelistDto.setRiskcode(getRiskCodeFromPolicyNo(policyNo));
				//���ձ𣬱�ģ���ʧ�ʼ����⸶������������������
				//calculateLossAreaSum(TemblorsettlelistDto,prpLlossDtoSettleAreaMap, totalLossRatePointMap);
				//���ձ𣬱�ģ���ʧ�ʼ���б����
				//calculateInsuredAreaSum(TemblorsettlelistDto,prpLlossDtoInsureAreaMap, totalLossRatePointMap);
				//���ձ𣬱�ģ���ʧ�ʼ����������⳥���
				calculateLossRealPaySum(TemblorsettlelistDto,prpLlossDtoSumRealPayMap, totalLossRatePointMap);
				//���ձ𣬱�ģ���ʧ�ʼ������������ս��
				calculateLossAmountSum(TemblorsettlelistDto,prpLlossDtoAmountMap, totalLossRatePointMap);
			}
			//�����⸶���
			//double settleArea = calculateTotalLossAreaSum(conditions);
			System.err.println("lossCount:"+lossCount);
			//request.setAttribute("SettleAreaAll", ""+settleArea);
			//����������
			//double noProductionArea = calculateNoProductionArea(arr,totalLossRatePointMap);
    	    //request.setAttribute("NoProductionArea", ""+noProductionArea);

			//�����ؿ�����start
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
            	//ͳ�ƻ���strat
            	ArrayList insuredList=new ArrayList();
            	double damageInsured1=0;
            	Map damageInsuredMapAll = new HashMap();
            	Map damageInsuredMapPrevious = new HashMap();
            	Map fIdCardMap = new HashMap();
                String damageInsuredAllCondtion=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and nodeType='"+NodeType+"' and validity='1'";
                List arrListAll = (ArrayList)blTemblorsettlelistFacade.getGroupedSumDataByFcode(damageInsuredAllCondtion);
                String damageInsuredPreviousCondtion=" settleListCode in (select settleListCode from settlemainlist where policyno='"+policyNo+"' and reportcode='"+registNo+"') and settleListCode<>'"+settleListCode+"' and nodeType='"+NodeType+"' and validity='1'";
                List arrListPrevious = (ArrayList)blTemblorsettlelistFacade.getGroupedSumDataByFcode(damageInsuredPreviousCondtion);
                List fIdCardList = new ArrayList();
                List kindCodeList = new ArrayList();
                List itemCodeList = new ArrayList();
                List lossRateList = new ArrayList();
                List keyList = new ArrayList();
                if(arrListPrevious.size()>0){
                	//�����ؿ�������������滧����������
                	for(int i =0; i < arrListAll.size(); i++){
                		TemblorsettlelistDto=new TemblorsettlelistDto();
                		TemblorsettlelistDto=(TemblorsettlelistDto)arrListAll.get(i);
	                	if(TemblorsettlelistDto.getSettlesum()!=0){
		    				damageInsuredMapAll.put(""+TemblorsettlelistDto.getIdcard()+"_"+TemblorsettlelistDto.getKindcode()+"_"+TemblorsettlelistDto.getItemcode()+"_"+TemblorsettlelistDto.getLossrate(), TemblorsettlelistDto.getSettlesum());
		    				fIdCardMap.put(""+TemblorsettlelistDto.getIdcard()+"_"+TemblorsettlelistDto.getKindcode()+"_"+TemblorsettlelistDto.getItemcode()+"_"+TemblorsettlelistDto.getLossrate(), TemblorsettlelistDto.getIdcard());
		    				keyList.add(""+TemblorsettlelistDto.getIdcard()+"_"+TemblorsettlelistDto.getKindcode()+"_"+TemblorsettlelistDto.getItemcode()+"_"+TemblorsettlelistDto.getLossrate());
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
//	                		//���ȶ���Ҫ�������Ļ���ͳ�Ƴ���
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
//	                		//ͳ����Ҫ���ӷ��Ļ���
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
	                //ͳ�ƻ���end
	            	prpLcompensateDto=(PrpLcompensateDto)collection.get(0);
//	            	if(!"".equals(NoProductionAreaMap.get(100))&&null!=NoProductionAreaMap.get(100)){
//	            	    NoProductionArea=Double.parseDouble(NoProductionAreaMap.get(100).toString());
//	            	}else{
//	            		NoProductionArea=0;
//	            	}
	            	if(!prpLcompensateDto.getUnderWriteFlag().equals("1")){
	            		throw new Exception("����\"" + claimNo + "\"��δ�᰸�������ؿ��ⰸ");	
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
            //�����ؿ�����end
           request.setAttribute("prpCompensateLossList", arr);
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
//    //���ձ𣬱�ģ���ʧ�ʼ�����ʧ�����
//    public void calculateLossAreaSum(TemblorsettlelistDto TemblorsettlelistDto,Map prpLlossDtoSettleAreaMap, Map totalLossRatePointMap){
//    	String kindCode = TemblorsettlelistDto.getKindcode();
//    	String itemCode = TemblorsettlelistDto.getItemcode();
//    	String key = ""+kindCode+"_"+itemCode;
//    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
//    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
//    	if(TemblorsettlelistDto.getLossrate()>=totalLossRatePoint){//����ȫ�����
//    		key+="100"; 
//			if(prpLlossDtoSettleAreaMap.containsKey(key)){
//				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(key)))+TemblorsettlelistDto.getSettlearea();
//				prpLlossDtoSettleAreaMap.put(key,sumSettlearea);
//			}else{
//				prpLlossDtoSettleAreaMap.put(key, TemblorsettlelistDto.getSettlearea());
//			}
//		}else{//���㲿����ʧ���
//			double lossRate = TemblorsettlelistDto.getLossrate();
//			key += lossRate;
//			if(prpLlossDtoSettleAreaMap.containsKey(key)){
//				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSettleAreaMap.get(key)))+TemblorsettlelistDto.getSettlearea();
//				prpLlossDtoSettleAreaMap.put(key,sumSettlearea);
//			}else{
//				prpLlossDtoSettleAreaMap.put(key, TemblorsettlelistDto.getSettlearea());
//			}
//		}
//    }
//    //�������⸶���
//    //�������ֲ�ͬ��ÿ�����ձ����������Ҫ�Զ���һ���ձ𣬱�Ļ�������Ϊ�⸶�����
//    public double calculateTotalLossAreaSum(String conditions)throws Exception{
//		double settleArea = 0;
//    	try {
//			//ʹ�����⸶����ľ���ֵ������Ϊ���⸶�����
//    		BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
//			//BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
//			Collection resultList = blTemblorsettlelistFacade.getGroupedSumData(conditions, true, true, false, false);
//			double settleAreaSum = 0;
//			if(null!= resultList && resultList.size()>0){
//				Iterator it = resultList.iterator();
//				TemblorsettlelistDto TemblorsettlelistDtoTemp = new TemblorsettlelistDto();
//				//Planting31SettleListDto planting31SettleListDtoTemp = new Planting31SettleListDto();
//				while(it.hasNext()){
//					TemblorsettlelistDtoTemp = (TemblorsettlelistDto)it.next();
//					double sum = TemblorsettlelistDtoTemp.getSettlearea();
//					if(Math.abs(sum)>Math.abs(settleAreaSum))
//						settleAreaSum = sum;
//				}
//				settleArea = settleAreaSum;
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return settleArea;
//    }
//    //���ձ𣬱�ģ���ʧ�ʼ���б����
//    public void calculateInsuredAreaSum(TemblorsettlelistDto TemblorsettlelistDto,Map prpLlossDtoInsureAreaMap, Map totalLossRatePointMap){
//    	String kindCode = TemblorsettlelistDto.getKindcode();
//    	String itemCode = TemblorsettlelistDto.getItemcode();
//    	String key = ""+kindCode+"_"+itemCode;
//    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
//    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
//    	if(TemblorsettlelistDto.getLossrate()>=totalLossRatePoint){//����ȫ�����
//    		key+="100"; 
//			if(prpLlossDtoInsureAreaMap.containsKey(key)){
//				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoInsureAreaMap.get(key)))+TemblorsettlelistDto.getSettlearea();
//				prpLlossDtoInsureAreaMap.put(key,sumSettlearea);
//			}else{
//				//prpLlossDtoInsureAreaMap.put(key, TemblorsettlelistDto.getSettlearea());
//			}
//		}else{//���㲿����ʧ���
//			double lossRate = TemblorsettlelistDto.getLossrate();
//			key += lossRate;
//			if(prpLlossDtoInsureAreaMap.containsKey(key)){
//				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoInsureAreaMap.get(key)))+TemblorsettlelistDto.getSettlearea();
//				prpLlossDtoInsureAreaMap.put(key,sumSettlearea);
//			}else{
//				//prpLlossDtoInsureAreaMap.put(key, TemblorsettlelistDto.getSettlearea());
//			}
//		}
//    }
    //���ձ𣬱�ģ���ʧ�ʼ������������ս��
    public void calculateLossRealPaySum(TemblorsettlelistDto TemblorsettlelistDto,Map prpLlossDtoSumRealPayMap, Map totalLossRatePointMap){
    	String kindCode = TemblorsettlelistDto.getKindcode();
    	String itemCode = TemblorsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(TemblorsettlelistDto.getLossrate()>=totalLossRatePoint){//����ȫ�����
    		key+="100"; 
			if(prpLlossDtoSumRealPayMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSumRealPayMap.get(key)))+TemblorsettlelistDto.getSettlesum();
				prpLlossDtoSumRealPayMap.put(key,sumSettlearea);
			}else{
				//prpLlossDtoSumRealPayMap.put(key, TemblorsettlelistDto.getSettlearea());
			}
		}else{//���㲿����ʧ���
			double lossRate = TemblorsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoSumRealPayMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoSumRealPayMap.get(key)))+TemblorsettlelistDto.getSettlesum();
				prpLlossDtoSumRealPayMap.put(key,sumSettlearea);
			}else{
				//prpLlossDtoSumRealPayMap.put(key, TemblorsettlelistDto.getSettlearea());
			}
		}
    }
	//���ձ𣬱�ģ���ʧ�ʼ������������ս��
    public void calculateLossAmountSum(TemblorsettlelistDto TemblorsettlelistDto,Map prpLlossDtoAmountMap, Map totalLossRatePointMap){
    	String kindCode = TemblorsettlelistDto.getKindcode();
    	String itemCode = TemblorsettlelistDto.getItemcode();
    	String key = ""+kindCode+"_"+itemCode;
    	String strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	double totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint);
    	if(TemblorsettlelistDto.getLossrate()>=totalLossRatePoint){//����ȫ�����
    		key+="_100"; 
			if(prpLlossDtoAmountMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoAmountMap.get(key)))+TemblorsettlelistDto.getSuminsured();
				prpLlossDtoAmountMap.put(key,sumSettlearea);
			}else{
				//prpLlossDtoAmountMap.put(key, TemblorsettlelistDto.getSettlearea());
			}
		}else{//���㲿����ʧ���
			double lossRate = TemblorsettlelistDto.getLossrate();
			key += lossRate;
			if(prpLlossDtoAmountMap.containsKey(key)){
				double sumSettlearea=Double.parseDouble(String.valueOf(prpLlossDtoAmountMap.get(key)))+TemblorsettlelistDto.getSuminsured();
				prpLlossDtoAmountMap.put(key,sumSettlearea);
			}else{
				//prpLlossDtoAmountMap.put(key, TemblorsettlelistDto.getSettlearea());
			}
		}
    }
    //��ȫ�������������ϲ���
    public void sumByLossRate(List arrPlanting31SettleList, Map totalLossRatePointMap){
    	if(null!=arrPlanting31SettleList && null!=totalLossRatePointMap){
    		TemblorsettlelistDto TemblorsettlelistDto;
    		TemblorsettlelistDto TemblorsettlelistDtoTemp;
    		
    		
    		//Planting31SettleListDto planting31SettleListDto;
    		//Planting31SettleListDto planting31SettleListDtoTemp;
    		String kindCode = "";
    		String itemCode = "";
    		String key = "";
    		String strTotalLossRatePoint = "";
    		double totalLossRatePoint = 100;
    		for(int i=0;i<arrPlanting31SettleList.size();i++){
    			TemblorsettlelistDto = (TemblorsettlelistDto)arrPlanting31SettleList.get(i);
    			kindCode = TemblorsettlelistDto.getKindcode();
    	    	itemCode = TemblorsettlelistDto.getItemcode();
    	    	key = ""+kindCode+"_"+itemCode;
    	    	strTotalLossRatePoint = String.valueOf(totalLossRatePointMap.get(key));
    	    	totalLossRatePoint = transformStringToDouble(strTotalLossRatePoint)*100;
    	    	if(0==totalLossRatePoint)
    	    		totalLossRatePoint = 100;
    	    	if(TemblorsettlelistDto.getLossrate()>=totalLossRatePoint){
    	    		TemblorsettlelistDto.setLossrate(100);
    	    		key+="100";
    	    		for(int j=0;j<i;j++){
    	    			TemblorsettlelistDtoTemp = (TemblorsettlelistDto)arrPlanting31SettleList.get(j);
    	    			if(TemblorsettlelistDto.getItemcode().equals(TemblorsettlelistDtoTemp.getItemcode()) && TemblorsettlelistDto.getKindcode().equals(TemblorsettlelistDtoTemp.getKindcode()) && TemblorsettlelistDto.getClaimrate() == TemblorsettlelistDtoTemp.getClaimrate() && TemblorsettlelistDtoTemp.getLossrate()>=totalLossRatePoint){
    	    				//TemblorsettlelistDtoTemp.setSettlearea(TemblorsettlelistDto.getSettlearea()+TemblorsettlelistDtoTemp.getSettlearea());
    	    				TemblorsettlelistDtoTemp.setSettlesum(TemblorsettlelistDto.getSettlesum()+TemblorsettlelistDtoTemp.getSettlesum());
    	    				arrPlanting31SettleList.remove(i);
    	    				i--;
    	    				break;
    	    			}
    	    		}
    			}
    		}
    	}
    }
    //����ũ������ȫ��ı��ս���ֹͬһũ�����ظ�����
    public void sumOfTotalInsured(Map totalLossRatePointMap, List arrPlanting31SettleList, String settleListCode)throws Exception{
    	try {
			if(null != arrPlanting31SettleList && arrPlanting31SettleList.size()>0){
				TemblorsettlelistDto TemblorsettlelistDto;
				//Planting31SettleListDto planting31SettleListDto;
				BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
				//BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
				String key = "";
				String fKey = "";
				String strTotalLossRatePoint = "";
				String kindCode = "";
				String itemCode = "";
				double claimRate = 0;
				double totalLossRate = 100;
				for(int i = 0; i< arrPlanting31SettleList.size(); i++){
					TemblorsettlelistDto = (TemblorsettlelistDto)arrPlanting31SettleList.get(i);
					double lossRate = TemblorsettlelistDto.getLossrate();
					if(100==lossRate){
						kindCode = TemblorsettlelistDto.getKindcode();
				    	itemCode = TemblorsettlelistDto.getItemcode();
				    	key = ""+kindCode+"_"+itemCode;
				    	claimRate = TemblorsettlelistDto.getClaimrate();
				    	if(null!=totalLossRatePointMap.get(key))
				    		totalLossRate = Double.parseDouble(String.valueOf(totalLossRatePointMap.get(key)))*100;
				    	if(0==totalLossRate)
				    		totalLossRate = 100;
				    	String sqlCondition = " settleListCode = '"+settleListCode+"' and kindCode = '"+kindCode +"' and itemCode = '"+itemCode+"' and claimRate = '"+claimRate+"' and nodeType = 'compe' and validity = '1' and lossRate >= '"+totalLossRate+"'";
				    	Collection planting31SettleListTemp = blTemblorsettlelistFacade.findByConditions(sqlCondition);
				    	if(null != planting31SettleListTemp && planting31SettleListTemp.size()>0){
							Map fCodeMap = new HashMap();
							Iterator it = planting31SettleListTemp.iterator();
							double sumInsured = 0;
							while(it.hasNext()){
								TemblorsettlelistDto planting31SettleListDtoTemp = (TemblorsettlelistDto)it.next();
						    	fKey = planting31SettleListDtoTemp.getIdcard();
								if(!fCodeMap.containsKey(fKey)){
					    			fCodeMap.put(fKey, fKey);
					    			sumInsured += planting31SettleListDtoTemp.getSuminsured();
					    		}
							}
							if(0!=sumInsured)
								TemblorsettlelistDto.setSuminsured(sumInsured);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //ȡ����������о����������
//    public double calculateNoProductionArea(List arrPlanting31SettleList, Map totalLossRatePointMap){
//    	double noProductionArea = 0;
//    	Map noProductionAreaMap = new HashMap();
//    	List keyList = new ArrayList();
//    	if(null != arrPlanting31SettleList && arrPlanting31SettleList.size() > 0 ){
//    		for(int i =0;i<arrPlanting31SettleList.size();i++){
//    			TemblorsettlelistDto TemblorsettlelistDto = (TemblorsettlelistDto)arrPlanting31SettleList.get(i);
//    			String key = ""+TemblorsettlelistDto.getKindcode()+"_"+TemblorsettlelistDto.getItemcode();
//    			if(totalLossRatePointMap.containsKey(key) && null != totalLossRatePointMap.get(key) && !"".equals(totalLossRatePointMap.get(key))){
//    				double totalLossRatePoint = Double.parseDouble(String.valueOf(totalLossRatePointMap.get(key)));
//    				if(TemblorsettlelistDto.getLossrate() >= totalLossRatePoint){
//    					keyList.add(key);
//    					if(noProductionAreaMap.containsKey(key))
//    						noProductionAreaMap.put(key, TemblorsettlelistDto.getSettlearea()+Double.parseDouble(String.valueOf(noProductionAreaMap.get(key))));
//    					else
//    						noProductionAreaMap.put(key, TemblorsettlelistDto.getSettlearea());
//    				}
//    			}
//    		}
//    	}
//    	if(null != keyList && keyList.size() > 0){
//    		for(int i = 0; i < keyList.size(); i++){
//    			String key = String.valueOf(keyList.get(i));
//	    		Iterator it = noProductionAreaMap.entrySet().iterator();
//    			double settleArea = Double.parseDouble(String.valueOf(noProductionAreaMap.get(key)));
//    			if(Math.abs(settleArea)>Math.abs(noProductionArea))
//    				noProductionArea = settleArea;
//    		}
//    	}
//    	return noProductionArea;
//    }
	//���ַ���������ת��֤���������ݡ�
	private double transformStringToDouble(String stringValue){
		double doubleValue = 0.0;
		if(null!=stringValue && !"".equals(stringValue)){
			stringValue = trimAllSpace(stringValue);
			doubleValue = Double.parseDouble(stringValue);
		}
		return doubleValue;
	}
	
	public static String trimAllSpace(String str) {
		//return str == null ? str : str.replaceAll("^[\\s��]*|[\\s��]*$", "");  
		return str == null ? str : str.replaceAll("^[\\s��]*|����������������������������|[\\s��]*$", "");  
	}
	//���ݱ����Ż�ȡ���ִ���
	private String getRiskCodeFromPolicyNo (String policyNo){
		String strRiskCode = "";
		if(null != policyNo && policyNo.length()>6){
			strRiskCode = policyNo.substring(1,5);//ȥ�������е�1-4λΪ�ձ���롣
		}
		return strRiskCode;
	}
}
