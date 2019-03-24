package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.gyic.claim.bl.facade.BLHerdsettlelistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.model.PrpLendorGetCountCommand;
import com.sinosoft.prpall.blsvr.pg.BLPrpPhead;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.prpall.blsvr.cb.*;

/**
 * <p>
 * Title: EndorViewHelper
 * </p>
 * <p>
 * Description:冲减保额功能状态ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * @author 车险冲减保额项目组 liubvo
 * @version 1.0 <br>
 */

public class EndorViewHelper {
    /**
     * 默认构造方法
     */
    public EndorViewHelper() {
    }

    /**
     * 保存冲减保额功能状态时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
     * @param httpServletRequest
     * @return claimStatusDto 冲减保额功能状态数据传输数据
     * @throws Exception
     */
    public EndorDto viewToDto(HttpServletRequest httpServletRequest)
            throws Exception {
        EndorDto endorDto = new EndorDto();
        // 取得保单号码,赔案号码
        String policyNo = httpServletRequest.getParameter("PolicyNo");
        String claimNo = httpServletRequest.getParameter("ClaimNo");
        String RiskCode = httpServletRequest.getParameter("RiskCode");

        /*---------------------接收冲减保额清单信息   prpLendor------------------------------------*/
        ArrayList prpLendorList = new ArrayList();
        PrpLendorDto prpLendorDto = null;
        // 从界面得到输入数组
        String[] arrCompensateNo = httpServletRequest
                .getParameterValues("CompensateNo");
        String[] arrItemKindNo = httpServletRequest
                .getParameterValues("ItemKindNo");
        String[] arrItemCode = httpServletRequest
                .getParameterValues("ItemCode");
        String[] arrItemName = httpServletRequest
                .getParameterValues("ItemName");
        String[] arrKindCode = httpServletRequest
                .getParameterValues("KindCode");
        String[] arrKindName = httpServletRequest
                .getParameterValues("KindName");
        String[] arrCurrency = httpServletRequest
                .getParameterValues("Currency");
        String[] arrEndorAmount = httpServletRequest
                .getParameterValues("EndorAmount");
        String[] lossRate = httpServletRequest
        .getParameterValues("lossRate");
        String[] arrEndorType = httpServletRequest
        .getParameterValues("EndorType");
        String[] arrEndorGrossQuantity = httpServletRequest
        .getParameterValues("EndorGrossQuantity");

        // 对象赋值
        // 三者车辆部分开始
        if (arrCompensateNo == null) {
        } else {
        	if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3179,3158,3178,3176,3177".indexOf(RiskCode) > -1)){
        		double EndorAmount=0;
        		double EndorGrossQuantity=0;
                for (int index = 0; index < arrCompensateNo.length; index++) {
                	EndorAmount+=Double.parseDouble(DataUtils
                            .nullToZero(arrEndorAmount[index]));
                }
                
                //System.err.println("EndorAmount:"+EndorAmount);
                for (int index = 0; index < arrCompensateNo.length; index++) {
                	EndorGrossQuantity+=Double.parseDouble(DataUtils
                            .nullToZero(arrEndorGrossQuantity[index]));
                }  
                
                //System.err.println("EndorGrossQuantity:"+EndorGrossQuantity);
                prpLendorDto = new PrpLendorDto();
                prpLendorDto.setClaimNo(claimNo);
                prpLendorDto.setCompensateNo(arrCompensateNo[0]);
                prpLendorDto.setPolicyNo(policyNo);
                prpLendorDto.setItemKindNo(Integer.parseInt(DataUtils
                        .nullToZero(arrItemKindNo[0])));
                prpLendorDto.setItemCode(arrItemCode[0]);
                prpLendorDto.setItemName(arrItemName[0]);
                prpLendorDto.setKindCode(arrKindCode[0]);
                prpLendorDto.setKindName(arrKindName[0]);
                prpLendorDto.setCurrency(arrCurrency[0]);
                prpLendorDto.setEndorAmount(EndorAmount);

                prpLendorDto.setInputDate(new DateTime(DateTime.current()
                        .toString(), DateTime.YEAR_TO_DAY));
                prpLendorDto.setFlag("");
                prpLendorDto.setEndorType(arrEndorType[0]);
                prpLendorDto.setEndorGrossQuantity(EndorGrossQuantity);
                prpLendorList.add(prpLendorDto);
        	}else if("3224".equals(RiskCode)||"0311".equals(RiskCode)||"3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169".indexOf(RiskCode) > -1)
        	{
        		HashMap map = new HashMap();
        		
        		for (int index = 0; index < arrCompensateNo.length; index++) {
        			int kindno = Integer.parseInt(DataUtils
                            .nullToZero(arrItemKindNo[index]));
        			if(map.get(kindno) != null)
        			{
        				((PrpLendorDto)map.get(kindno)).setEndorAmount(prpLendorDto.getEndorAmount()+ Double.parseDouble(DataUtils
                        .nullToZero(arrEndorAmount[index])));
        			}
        			else
        			{
        				prpLendorDto = new PrpLendorDto();
        				prpLendorDto.setClaimNo(claimNo);
        	            prpLendorDto.setCompensateNo(arrCompensateNo[index]);
        	            prpLendorDto.setPolicyNo(policyNo);
        	            prpLendorDto.setItemKindNo(Integer.parseInt(DataUtils
        	                        .nullToZero(arrItemKindNo[index])));
        	            prpLendorDto.setItemCode(arrItemCode[index]);
        	            prpLendorDto.setItemName(arrItemName[index]);
        	            prpLendorDto.setKindCode(arrKindCode[index]);
        	            prpLendorDto.setKindName(arrKindName[index]);
        	            prpLendorDto.setCurrency(arrCurrency[index]);
        	            prpLendorDto.setEndorAmount(Double.parseDouble(DataUtils
        	                        .nullToZero(arrEndorAmount[index])));

        	            prpLendorDto.setInputDate(new DateTime(DateTime.current()
        	                        .toString(), DateTime.YEAR_TO_DAY));
        	            prpLendorDto.setFlag("");
        	            prpLendorDto.setEndorType(arrEndorType[index]);
        	            prpLendorDto.setEndorGrossQuantity(Double.parseDouble(DataUtils
        	                        .nullToZero(arrEndorGrossQuantity[index])));
        	            map.put(kindno, prpLendorDto);	
        			}
        		}
                
        		Iterator ite = map.keySet().iterator();
        		while(ite.hasNext())
        		{
        			int key = Integer.parseInt(DataUtils
                            .nullToZero(ite.next().toString())) ;
        			prpLendorList.add((PrpLendorDto)map.get(key));
        		}
        	}
        	else{
            for (int index = 0; index < arrCompensateNo.length; index++) {
                prpLendorDto = new PrpLendorDto();
                prpLendorDto.setClaimNo(claimNo);
                prpLendorDto.setCompensateNo(arrCompensateNo[index]);
                prpLendorDto.setPolicyNo(policyNo);
                prpLendorDto.setItemKindNo(Integer.parseInt(DataUtils
                        .nullToZero(arrItemKindNo[index])));
                prpLendorDto.setItemCode(arrItemCode[index]);
                prpLendorDto.setItemName(arrItemName[index]);
                prpLendorDto.setKindCode(arrKindCode[index]);
                prpLendorDto.setKindName(arrKindName[index]);
                prpLendorDto.setCurrency(arrCurrency[index]);
                prpLendorDto.setEndorAmount(Double.parseDouble(DataUtils
                        .nullToZero(arrEndorAmount[index])));

                prpLendorDto.setInputDate(new DateTime(DateTime.current()
                        .toString(), DateTime.YEAR_TO_DAY));
                prpLendorDto.setFlag("");
                prpLendorDto.setEndorType(arrEndorType[index]);
                prpLendorDto.setEndorGrossQuantity(Double.parseDouble(DataUtils
                        .nullToZero(arrEndorGrossQuantity[index])));
                prpLendorList.add(prpLendorDto);
            }// end for
            // 立案集合中加入三者车辆
        	}
            endorDto.setPrpLendorList(prpLendorList);
         
        }
        return endorDto;
        }
       
    

    /**
     * 填写冲减保额页面及查询立案request的生成.
     * 填写冲减保额时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
     * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
     * @param httpServletRequest 返回给页面的request
     * @param proposalIniDto 取出的初始化信息Dto
     * @throws Exception
     */
    public void prepayDataToView(HttpServletRequest httpServletRequest,
            String claimNo, String compensateNo) throws Exception {
        PrpLlossDto prpLlossDto = new PrpLlossDto();
        ArrayList list = new ArrayList();
        Map numberListBaseOnHerdSettleList = new HashMap();
        String conditions = " ClaimNo='" + claimNo + "'";
        conditions += " and (claimno in (select businessno from swflog where systemflag is null or systemflag<>'agri')";
        conditions += " or claimno in (select businessno from swflogstore where systemflag is null or systemflag<>'agri'))";
        CompensateDto compensateDto = null;
        CompensateDto compensateDtoTemp = null;
        // 查询信息
        UICompensateAction uiCompensateAction = new UICompensateAction();

        if (compensateNo == null || compensateNo.trim().length() == 0) {
            Collection collection = uiCompensateAction
                    .findByConditions(conditions);
            if (collection.size() == 0) {
                throw new Exception("立案\"" + claimNo + "\"未作结案.不能冲减保额");
            }
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto) iterator
                        .next();
                compensateDto = uiCompensateAction
                        .findByPrimaryKey(prpLcompensateDto.getCompensateNo());
                //add by qinyongli 核赔未通过不能冲减保额
                if(!prpLcompensateDto.getUnderWriteFlag().equals("1") && !prpLcompensateDto.getUnderWriteFlag().equals("3")){
                	throw new Exception("立案\"" + claimNo + "\"还未审核通过，不能冲减保额");
                }
                //add by qinyongli 增加冲减保额的条件，标志位为1 2005-10-21
                conditions = "CompensateNo = '"
                        + compensateDto.getPrpLcompensateDto()
                                .getCompensateNo() + "' and flag = '1' ";
                 PrpLendorGetCountCommand command = new PrpLendorGetCountCommand(
                        conditions);
                int count = ((Integer) command.execute()).intValue();
                if (count > 0) {
                    continue;
                }
                
                BLPrpPhead blPrpPhead =new BLPrpPhead();
                blPrpPhead.query("Policyno='"+prpLcompensateDto.getPolicyNo()+"'");
                for(int i= 0;i<blPrpPhead.getSize();i++)
                {
                	if(blPrpPhead.getArr(i).getUnderWriteFlag().equals("0")){
                		throw new Exception("存在未核批通过的计算书不允许再次冲减,业务号码为"+blPrpPhead.getArr(i).getEndorseNo()+"请与业务部联系。");	
                	}
                }
                
                // 扶贫/经营主体系统进来的单子,只能查询到特困户单/经营主体单
                //从session里取扶贫/大户标志
                String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
                BLPrpCmain blPrpCmain =new BLPrpCmain();
                blPrpCmain.query(" Policyno='"+prpLcompensateDto.getPolicyNo()+"'");
                String policytype = "";
                if(blPrpCmain != null && blPrpCmain.getSize() == 1)
                	policytype = blPrpCmain.getArr(0).getPolicyType();
                if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null") && policytype != null && !policytype.equals("")) {
              	  if(strHPflag.equals("Large") && "H24, I28, E2, Q2".indexOf(policytype) < 0) {
              		  throw new Exception("规模经营主体系统无法查询非经营主体业务的保单。");	
              	  }
                  if(strHPflag.equals("Retaol") && "H23, I27, E1, Q1".indexOf(policytype) < 0) {
                	  throw new Exception("扶贫系统无法查询非特困户业务的保单。");
              	  }
                }

                  //list.addAll(compensateDto.getPrpLlossDtoList());
                //加入责任险和意健险的人伤冲减保额处理  add by qinyongli 2005-10-28
                //首先对意健险进行处理
                /*
                if(prpLcompensateDto.getRiskCode().substring(0,2).equals("27")){
                	//将人伤信息存入list中
                	ArrayList personToLossList = null;
                	ArrayList personLossList = compensateDto.getPrpLpersonLossDtoList();
                	Iterator personloss = personLossList.iterator();
                	UICodeAction uiCodeAction = new UICodeAction();
                	while(personloss.hasNext()){
               		    PrpLpersonLossDto  personLossDto =(PrpLpersonLossDto)personloss.next();
                		PrpLlossDto lossDto = new PrpLlossDto();
                        //modify 增加对重复信息的合并  by qinyongli 2005-10-29
                		ArrayList lossListNew = new ArrayList(); //用于保存产生的新的标的损失
                		ArrayList lossListTemp = compensateDto.getPrpLlossDtoList();
                		Iterator lossDtoTemp = lossListTemp.iterator();
                		while(lossDtoTemp.hasNext()){
                			PrpLlossDto lossDtoNew =(PrpLlossDto)lossDtoTemp.next();
                			if(lossDtoNew.getPolicyNo().equals(personLossDto.getPolicyNo())&&
                					lossDtoNew.getItemKindNo()==personLossDto.getItemKindNo()){
                				//表示标的有重复，进行合并，保留标的损失，将人伤合入标的
                				lossDtoNew.setSumRealPay(lossDtoNew.getSumRealPay()+personLossDto.getSumRealPay());
                			}else{
                				//标的无重复，直接加到损失列表中
                				lossDto.setCompensateNo(personLossDto.getCompensateNo());
                        		lossDto.setItemCode(personLossDto.getLiabDetailCode());
                        		lossDto.setLossName(personLossDto.getLiabDetailName());
                        		lossDto.setItemKindNo(personLossDto.getItemKindNo());
                        		lossDto.setKindCode(personLossDto.getKindCode());
                         		lossDto.setRiskCode(personLossDto.getRiskCode());
                        		lossDto.setCurrency(personLossDto.getCurrency());
                        		lossDto.setCurrencyName(personLossDto.getCurrencyName());
                        		lossDto.setSumRealPay(personLossDto.getSumRealPay());
                            	list.add(lossDto); //将人伤信息合入损失列表
                			}//if
                			list.add(lossDtoNew);  	
                		}//while	
                    	//modify end by qinyongli 2005-10-29 	
                	}	
                }*/
                //add by kangzhen 070124 start
                if(prpLcompensateDto.getRiskCode().substring(0,2).equals("27")){
                	ArrayList personLossList = compensateDto.getPrpLpersonLossDtoList();
                	if(personLossList != null){
                		for (int i=0; i<personLossList.size();i++){
                			PrpLlossDto lossDto = new PrpLlossDto();
                			PrpLpersonLossDto personLossDto = (PrpLpersonLossDto)personLossList.get(i);
                			lossDto.setCompensateNo(personLossDto.getCompensateNo());
                			lossDto.setItemCode(personLossDto.getLiabDetailCode());
                			lossDto.setLossName(personLossDto.getLiabDetailName());
                			lossDto.setItemKindNo(personLossDto.getItemKindNo());
                			lossDto.setKindCode(personLossDto.getKindCode());
                			lossDto.setRiskCode(personLossDto.getRiskCode());
                			lossDto.setCurrency(personLossDto.getCurrency());
                			lossDto.setCurrencyName(personLossDto.getCurrencyName());
                			lossDto.setSumRealPay(personLossDto.getSumRealPay());
                			list.add(lossDto);
                		}
                	}
                }
                
                
                
                //add by kangzhen 070124 end
                //add by kangzhen 061123 start 农险冲减保额
                if((prpLcompensateDto.getRiskCode().substring(0,2).equals("31")||prpLcompensateDto.getRiskCode().substring(0,2).equals("32"))&& !prpLcompensateDto.getRiskCode().equals("3119")){
                	if(prpLcompensateDto.getRiskCode().equals("3201")||prpLcompensateDto.getRiskCode().equals("3203")||prpLcompensateDto.getRiskCode().equals("3208")||prpLcompensateDto.getRiskCode().equals("3229")){
                		throw new Exception("险种\"" + prpLcompensateDto.getRiskCode() + "\"不能冲减保额");
                	}
                	//Updated by GYIC LiYang 20110920 根据新的需求，对于在投保时录入耳标号清单的养殖险，在冲减保额是显示理赔清单信息，冲减也要冲减分户，通过分户的冲减来影响保单。其他险种不变。Start！
                	//在查找agriLoss的时候，根据kindCode和claimNo来确定对应的理赔清单，把清单中的死亡数量和扑杀数量累加起来作为冲减数量。
                	String strRiskCodes = SysConfig.getProperty("FamilySplittingFlag","claim");
                	
                	ArrayList agriLossList = compensateDto.getPrpLlossDtoList();
                	if(agriLossList!=null){
                		for (int i=0; i<agriLossList.size(); i++){
                    		PrpLlossDto agriLossDto = (PrpLlossDto)agriLossList.get(i);
                    		String strRiskCode = agriLossDto.getRiskCode();
                    		if(null!=strRiskCodes && !"".equals(strRiskCodes)&& null!=prpLcompensateDto.getRiskCode() && strRiskCodes.indexOf(strRiskCode)>-1){
                        		String conditionsOfFatchSettleMainList = " REGISTERCODE='" + claimNo + "' and VALIDITY = '2' ";
                        		BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
                        		Collection settleMainList = blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
                        		BLHerdsettlelistFacade blHerdSettleListFacade = new BLHerdsettlelistFacade();
                        		if(null!=settleMainList && settleMainList.size()>0){
                        			Iterator it = settleMainList.iterator();
                        			while(it.hasNext()){
                        				SettlemainlistDto settleMainListDto = (SettlemainlistDto)it.next();
                        				String settleListCode = settleMainListDto.getSettlelistcode();
                        				String conditionsOfFatchHerdSettleList = " SETTLELISTCODE = '" + settleListCode +"' ";
                        				Collection herdSettleList = blHerdSettleListFacade.findByConditions(conditionsOfFatchHerdSettleList);
                        				if(null!=herdSettleList && herdSettleList.size()>0){
                        					Object[] herdSettleListDtoArray = herdSettleList.toArray();
                        					if(null!=herdSettleListDtoArray && herdSettleListDtoArray.length>0){
                        						HerdsettlelistDto herdSettleListDtoTemp = (HerdsettlelistDto)herdSettleListDtoArray[0];
//                        						String strKindCodeSettleList = herdSettleListDtoTemp.getKindcode();
                        						String strKindCodeLloss = agriLossDto.getKindCode();
//                        						if(null!=strKindCodeSettleList && strKindCodeSettleList.equals(strKindCodeLloss)){
                        							int reduceNumber = 0;
                        							Iterator iteratorHerdSettle = herdSettleList.iterator();
    	                        					while(iteratorHerdSettle.hasNext()){
    	                        						HerdsettlelistDto herdSettleListDto = (HerdsettlelistDto)iteratorHerdSettle.next();
    	                        						reduceNumber = reduceNumber- 1;// herdSettleListDto.getDeadnumber()- herdSettleListDto.getCullnumber();
    	                        					}
    	                        					numberListBaseOnHerdSettleList.put(prpLcompensateDto.getCompensateNo()+"_"+settleMainListDto.getRiskcode()+"_"+strKindCodeLloss, reduceNumber);
//                        						}
                        					}
                        				}
                        			}
                        		}
                        	}
                        	list.add(agriLossDto);
                    	}
                	}
                	//Updated by GYIC LiYang 20110920 根据新的需求，对于在投保时录入耳标号清单的养殖险，在冲减保额是显示理赔清单信息，冲减也要冲减分户，通过分户的冲减来影响保单。其他险种不变。End！
                }
                //add by kangzhen 061123 end
                //加入对责任险的人伤的处理
                /*
                if(Integer.parseInt(prpLcompensateDto.getRiskCode().substring(0,2))>14&&Integer.parseInt(prpLcompensateDto.getRiskCode().substring(0,2))<20){
                     //将人伤信息存入list中
                	ArrayList personToLossList = null;
                	ArrayList personLossList = compensateDto.getPrpLpersonLossDtoList();
                	Iterator personloss = personLossList.iterator();
                	UICodeAction uiCodeAction = new UICodeAction();
                	while(personloss.hasNext()){
               		    PrpLpersonLossDto  personLossDto =(PrpLpersonLossDto)personloss.next();
                		PrpLlossDto lossDto = new PrpLlossDto();
                        //modify 增加对重复信息的合并  by qinyongli 2005-10-29
                		ArrayList lossListNew = new ArrayList(); //用于保存产生的新的标的损失
                		ArrayList lossListTemp = compensateDto.getPrpLlossDtoList();
                		Iterator lossDtoTemp = lossListTemp.iterator();
                		while(lossDtoTemp.hasNext()){
                			PrpLlossDto lossDtoNew =(PrpLlossDto)lossDtoTemp.next();
                			if(lossDtoNew.getPolicyNo().equals(personLossDto.getPolicyNo())&&
                					lossDtoNew.getItemKindNo()==personLossDto.getItemKindNo()){
                				//表示标的有重复，进行合并，保留标的损失，将人伤合入标的
                				lossDtoNew.setSumRealPay(lossDtoNew.getSumRealPay()+personLossDto.getSumRealPay());
                			}else{
                				//标的无重复，直接加到损失列表中
                				lossDto.setCompensateNo(personLossDto.getCompensateNo());
                        		lossDto.setItemCode(personLossDto.getLiabDetailCode());
                        		lossDto.setLossName(personLossDto.getLiabDetailName());
                        		lossDto.setItemKindNo(personLossDto.getItemKindNo());
                        		lossDto.setKindCode(personLossDto.getKindCode());
                         		lossDto.setRiskCode(personLossDto.getRiskCode());
                        		lossDto.setCurrency(personLossDto.getCurrency());
                        		lossDto.setCurrencyName(personLossDto.getCurrencyName());
                        		lossDto.setSumRealPay(personLossDto.getSumRealPay());
                            	list.add(lossDto); //将人伤信息合入损失列表
                			}//if
                			list.add(lossDtoNew);  	
                		}//while	
                    	//modify end by qinyongli 2005-10-29
                	}	   	
                }
                */
                if(prpLcompensateDto.getRiskCode().substring(0,2).equals("15")||prpLcompensateDto.getRiskCode().substring(0,2).equals("08")){
                    if(compensateDto.getPrpLpersonLossDtoList().size()>0&&compensateDto.getPrpLlossDtoList().size()>0){
                	//将人伤信息存入list中
                	ArrayList personToLossList = null;
                	ArrayList personLossList = compensateDto.getPrpLpersonLossDtoList();
                	Iterator personloss = personLossList.iterator();
                	UICodeAction uiCodeAction = new UICodeAction();
                	while(personloss.hasNext()){
               		    PrpLpersonLossDto  personLossDto =(PrpLpersonLossDto)personloss.next();
                		PrpLlossDto lossDto = new PrpLlossDto();                      
                		ArrayList lossListNew = new ArrayList(); //用于保存产生的新的标的损失
                		ArrayList lossListTemp = compensateDto.getPrpLlossDtoList();
                		Iterator lossDtoTemp = lossListTemp.iterator();
                		while(lossDtoTemp.hasNext()){
                			PrpLlossDto lossDtoNew =(PrpLlossDto)lossDtoTemp.next();
                			if(lossDtoNew.getPolicyNo().equals(personLossDto.getPolicyNo())&&
                					lossDtoNew.getItemKindNo()==personLossDto.getItemKindNo()){
                				//表示标的有重复，进行合并，保留标的损失，将人伤合入标的
                				lossDtoNew.setSumRealPay(lossDtoNew.getSumRealPay()+personLossDto.getSumRealPay());
                			}else{
                				//标的无重复，直接加到损失列表中
                				lossDto.setCompensateNo(personLossDto.getCompensateNo());
                        		lossDto.setItemCode(personLossDto.getLiabDetailCode());
                        		lossDto.setLossName(personLossDto.getLiabDetailName());
                        		lossDto.setItemKindNo(personLossDto.getItemKindNo());
                        		lossDto.setKindCode(personLossDto.getKindCode());
                         		lossDto.setRiskCode(personLossDto.getRiskCode());
                        		lossDto.setCurrency(personLossDto.getCurrency());
                        		lossDto.setCurrencyName(personLossDto.getCurrencyName());
                        		lossDto.setSumRealPay(personLossDto.getSumRealPay());
                            	list.add(lossDto); //将人伤信息合入损失列表
                			}//if
                			list.add(lossDtoNew);  	
                		}//while	
                    	
                	}	   	
                    }
                    if(compensateDto.getPrpLpersonLossDtoList().size()>0&&compensateDto.getPrpLlossDtoList().size()==0){
                    	ArrayList personLossList = compensateDto.getPrpLpersonLossDtoList();
                    	if(personLossList != null){
                    		for (int i=0; i<personLossList.size();i++){
                    			PrpLlossDto lossDto = new PrpLlossDto();
                    			PrpLpersonLossDto personLossDto = (PrpLpersonLossDto)personLossList.get(i);
                    			lossDto.setCompensateNo(personLossDto.getCompensateNo());
                    			lossDto.setItemCode(personLossDto.getLiabDetailCode());
                    			lossDto.setLossName(personLossDto.getLiabDetailName());
                    			lossDto.setItemKindNo(personLossDto.getItemKindNo());
                    			lossDto.setKindCode(personLossDto.getKindCode());
                    			lossDto.setRiskCode(personLossDto.getRiskCode());
                    			lossDto.setCurrency(personLossDto.getCurrency());
                    			lossDto.setCurrencyName(personLossDto.getCurrencyName());
                    			lossDto.setSumRealPay(personLossDto.getSumRealPay());
                    			list.add(lossDto);
                    		}
                    	}
                    }
                    if(compensateDto.getPrpLpersonLossDtoList().size()==0&&compensateDto.getPrpLlossDtoList().size()>0){
                    	ArrayList lossList = compensateDto.getPrpLlossDtoList();
                    	for(int i=0; i<lossList.size(); i++){
                    		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                    		list.add(lossDto);
                    	}
                    }
                }
                if(Integer.parseInt(prpLcompensateDto.getRiskCode().substring(0,2))<14&& !prpLcompensateDto.getRiskCode().substring(0,2).equals("05")&& !prpLcompensateDto.getRiskCode().substring(0,2).equals("08")){
                	ArrayList lossList = compensateDto.getPrpLlossDtoList();
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		list.add(lossDto);
                	}
                }
                if(prpLcompensateDto.getRiskCode().substring(0,2).equals("05")
                		||prpLcompensateDto.getRiskCode().equals("3119")){
                	ArrayList lossList = compensateDto.getPrpLlossDtoList();
                	PrpLlossDto lossDtoA = new PrpLlossDto();
                	PrpLlossDto lossDtoL = new PrpLlossDto();
                	PrpLlossDto lossDtoG = new PrpLlossDto();
                	PrpLlossDto lossDto001 = new PrpLlossDto();
                	PrpLlossDto lossDto002 = new PrpLlossDto();
                	double sumRealPayA = 0d;
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		if(lossDto.getKindCode().equals("A")){
                			sumRealPayA = sumRealPayA + lossDto.getSumLoss();
                			lossDtoA.setCompensateNo(lossDto.getCompensateNo());
                			lossDtoA.setItemCode(lossDto.getItemCode());
                			lossDtoA.setLossName(lossDto.getLossName());
                			lossDtoA.setItemKindNo(lossDto.getItemKindNo());
                			lossDtoA.setKindCode("A");
                			lossDtoA.setRiskCode(lossDto.getRiskCode());
                			lossDtoA.setCurrency(lossDto.getCurrency());
                			lossDtoA.setCurrencyName(lossDto.getCurrencyName());
                			lossDtoA.setSumRealPay(sumRealPayA);
                		}
                	}
                	if(lossDtoA!=null && lossDtoA.getSumRealPay()>0){
                		list.add(lossDtoA);                		
                	}
                	
                	double sumRealPayL = 0d;
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		if(lossDto.getKindCode().equals("L")){
                			sumRealPayL = sumRealPayL + lossDto.getSumLoss();
                			lossDtoL.setCompensateNo(lossDto.getCompensateNo());
                			lossDtoL.setItemCode(lossDto.getItemCode());
                			lossDtoL.setLossName(lossDto.getLossName());
                			lossDtoL.setItemKindNo(lossDto.getItemKindNo());
                			lossDtoL.setKindCode("L");
                			lossDtoL.setRiskCode(lossDto.getRiskCode());
                			lossDtoL.setCurrency(lossDto.getCurrency());
                			lossDtoL.setCurrencyName(lossDto.getCurrencyName());
                			lossDtoL.setSumRealPay(sumRealPayL);
                		}
                	}
                	if(lossDtoL!=null && lossDtoL.getSumRealPay()>0){
                		list.add(lossDtoL);                		
                	}
                	
                	double sumRealPayG = 0d;
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		if(lossDto.getKindCode().equals("G")){
                			sumRealPayG = sumRealPayG + lossDto.getSumLoss();
                			lossDtoG.setCompensateNo(lossDto.getCompensateNo());
                			lossDtoG.setItemCode(lossDto.getItemCode());
                			lossDtoG.setLossName(lossDto.getLossName());
                			lossDtoG.setItemKindNo(lossDto.getItemKindNo());
                			lossDtoG.setKindCode("G");
                			lossDtoG.setRiskCode(lossDto.getRiskCode());
                			lossDtoG.setCurrency(lossDto.getCurrency());
                			lossDtoG.setCurrencyName(lossDto.getCurrencyName());
                			lossDtoG.setSumRealPay(sumRealPayG);
                		}
                	}
                	if(lossDtoG!=null && lossDtoG.getSumRealPay()>0){
                		list.add(lossDtoG);                		
                	}
                	
                	double sumRealPay001 = 0d;
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		if(lossDto.getKindCode().equals("001")){
                			sumRealPay001 = sumRealPay001 + lossDto.getSumLoss();
                			lossDto001.setCompensateNo(lossDto.getCompensateNo());
                			lossDto001.setItemCode(lossDto.getItemCode());
                			lossDto001.setLossName(lossDto.getLossName());
                			lossDto001.setItemKindNo(lossDto.getItemKindNo());
                			lossDto001.setKindCode("001");
                			lossDto001.setRiskCode(lossDto.getRiskCode());
                			lossDto001.setCurrency(lossDto.getCurrency());
                			lossDto001.setCurrencyName(lossDto.getCurrencyName());
                			lossDto001.setSumRealPay(sumRealPay001);
                		}
                	}
                	if(lossDto001!=null && lossDto001.getSumRealPay()>0){
                		list.add(lossDto001);                		
                	}
                	
                	double sumRealPay002 = 0d;
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		if(lossDto.getKindCode().equals("002")){
                			sumRealPay002 = sumRealPay002 + lossDto.getSumLoss();
                			lossDto002.setCompensateNo(lossDto.getCompensateNo());
                			lossDto002.setItemCode(lossDto.getItemCode());
                			lossDto002.setLossName(lossDto.getLossName());
                			lossDto002.setItemKindNo(lossDto.getItemKindNo());
                			lossDto002.setKindCode("002");
                			lossDto002.setRiskCode(lossDto.getRiskCode());
                			lossDto002.setCurrency(lossDto.getCurrency());
                			lossDto002.setCurrencyName(lossDto.getCurrencyName());
                			lossDto002.setSumRealPay(sumRealPay002);
                		}
                	}
                	if(lossDto002!=null && lossDto002.getSumRealPay()>0){
                		list.add(lossDto002);                		
                	}
                }
                //add end by qinyongli 2005-10-28
                prpLlossDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
                prpLlossDto.setRiskCode(prpLcompensateDto.getRiskCode());

                httpServletRequest.setAttribute("claimNo", prpLcompensateDto
                        .getClaimNo());
            }
        } else {
            try {
                compensateDtoTemp = uiCompensateAction
                        .findByPrimaryKey(compensateNo);
            } catch (Exception e) {
                throw new Exception("查询赔案信息失败，请确认赔案\"" + compensateNo + "\"是否存在");
            }

            PrpLcompensateDto prpLcompensateDto = compensateDtoTemp
                    .getPrpLcompensateDto();
                     //add by qinyongli 核赔未通过不能冲减保额
            if(!prpLcompensateDto.getUnderWriteFlag().equals("1")){
            	throw new Exception("计算书\"" + compensateNo + "\"还未审核通过，不能冲减保额");
            }
          
           
            // conditions = "
            // CompensateNo='"+prpLcompensateDto.getCompensateNo()+"' ";
             //list = compensateDtoTemp.getPrpLlossDtoList();
            //加入责任险和意健险的人伤冲减保额处理  add by qinyongli 2005-10-28
            //首先对意健险进行处理
            /*
            if(prpLcompensateDto.getRiskCode().substring(0,2).equals("27")){
            	//将人伤信息存入list中
            	ArrayList personToLossList = null;
            	ArrayList personLossList = compensateDtoTemp.getPrpLpersonLossDtoList();
            	Iterator personloss = personLossList.iterator();
            	UICodeAction uiCodeAction = new UICodeAction();
            	while(personloss.hasNext()){
           		    PrpLpersonLossDto  personLossDto =(PrpLpersonLossDto)personloss.next();
            		PrpLlossDto lossDto = new PrpLlossDto();
                    //modify 增加对重复信息的合并  by qinyongli 2005-10-29
            		ArrayList lossListNew = new ArrayList(); //用于保存产生的新的标的损失
            		ArrayList lossListTemp = compensateDtoTemp.getPrpLlossDtoList();
            		Iterator lossDtoTemp = lossListTemp.iterator();
            		while(lossDtoTemp.hasNext()){
            			PrpLlossDto lossDtoNew =(PrpLlossDto)lossDtoTemp.next();
            			if(lossDtoNew.getPolicyNo().equals(personLossDto.getPolicyNo())&&
            					lossDtoNew.getItemKindNo()==personLossDto.getItemKindNo()){
            				//表示标的有重复，进行合并，保留标的损失，将人伤合入标的
            				lossDtoNew.setSumRealPay(lossDtoNew.getSumRealPay()+personLossDto.getSumRealPay());
            			}else{
            				//标的无重复，直接加到损失列表中
            				lossDto.setCompensateNo(personLossDto.getCompensateNo());
                    		lossDto.setItemCode(personLossDto.getLiabDetailCode());
                    		lossDto.setLossName(personLossDto.getLiabDetailName());
                    		lossDto.setItemKindNo(personLossDto.getItemKindNo());
                    		lossDto.setKindCode(personLossDto.getKindCode());
                     		lossDto.setRiskCode(personLossDto.getRiskCode());
                    		lossDto.setCurrency(personLossDto.getCurrency());
                    		lossDto.setCurrencyName(personLossDto.getCurrencyName());
                    		lossDto.setSumRealPay(personLossDto.getSumRealPay());
                        	list.add(lossDto); //将人伤信息合入损失列表
            			}//if
            			list.add(lossDtoNew);  	
            		}//while	
                	//modify end by qinyongli 2005-10-29
            	}	
            } */
            //add by kangzhen 070124 start
            if(prpLcompensateDto.getRiskCode().substring(0,2).equals("27")){
            	ArrayList personLossList = compensateDtoTemp.getPrpLpersonLossDtoList();
            	if(personLossList != null){
            		for (int i=0; i<personLossList.size();i++){
            			PrpLlossDto lossDto = new PrpLlossDto();
            			PrpLpersonLossDto personLossDto = (PrpLpersonLossDto)personLossList.get(i);
            			lossDto.setCompensateNo(personLossDto.getCompensateNo());
            			lossDto.setItemCode(personLossDto.getLiabDetailCode());
            			lossDto.setLossName(personLossDto.getLiabDetailName());
            			lossDto.setItemKindNo(personLossDto.getItemKindNo());
            			lossDto.setKindCode(personLossDto.getKindCode());
            			lossDto.setRiskCode(personLossDto.getRiskCode());
            			lossDto.setCurrency(personLossDto.getCurrency());
            			lossDto.setCurrencyName(personLossDto.getCurrencyName());
            			lossDto.setSumRealPay(personLossDto.getSumRealPay());
            			list.add(lossDto);
            		}
            	}
            }
            //add by kangzhen 070124 end
            // add by kangzhen 061123 start 农险冲减保额
            if((prpLcompensateDto.getRiskCode().substring(0,2).equals("31")||prpLcompensateDto.getRiskCode().substring(0,2).equals("32"))&& !prpLcompensateDto.getRiskCode().equals("3119")){
            	if(prpLcompensateDto.getRiskCode().equals("3203")||prpLcompensateDto.getRiskCode().equals("3208")){
            		throw new Exception("险种\"" + prpLcompensateDto.getRiskCode() + "\"不能冲减保额");
            	}
            	//Updated by GYIC LiYang 20110920 根据新的需求，对于在投保时录入耳标号清单的养殖险，在冲减保额是显示理赔清单信息，冲减也要冲减分户，通过分户的冲减来影响保单。其他险种不变。Start！
            	//在查找agriLoss的时候，根据kindCode和claimNo来确定对应的理赔清单，把清单中的死亡数量和扑杀数量累加起来作为冲减数量。
            	String strRiskCodes = SysConfig.getProperty("FamilySplittingFlag","claim");
            	
            	ArrayList agriLossList = compensateDtoTemp.getPrpLlossDtoList();
            	if(agriLossList!=null){
            		for (int i=0; i<agriLossList.size(); i++){
                		PrpLlossDto agriLossDto = (PrpLlossDto)agriLossList.get(i);
                		String strRiskCode = agriLossDto.getRiskCode();
                		if(null!=strRiskCodes && !"".equals(strRiskCodes)&& null!=prpLcompensateDto.getRiskCode() && strRiskCodes.indexOf(strRiskCode)>-1){
                    		String conditionsOfFatchSettleMainList = " compensateNo='" + compensateNo + "' and VALIDITY = '2' ";
                    		BLSettlemainlistFacade blSettlemainlistFacade = new BLSettlemainlistFacade();
                    		Collection settleMainList = blSettlemainlistFacade.findByConditions(conditionsOfFatchSettleMainList);
                    		BLHerdsettlelistFacade blHerdSettleListFacade = new BLHerdsettlelistFacade();
                    		if(null!=settleMainList && settleMainList.size()>0){
                    			Iterator it = settleMainList.iterator();
                    			while(it.hasNext()){
                    				SettlemainlistDto settleMainListDto = (SettlemainlistDto)it.next();
                    				String settleListCode = settleMainListDto.getSettlelistcode();
                    				String conditionsOfFatchHerdSettleList = " SETTLELISTCODE = '" + settleListCode +"' ";
                    				Collection herdSettleList = blHerdSettleListFacade.findByConditions(conditionsOfFatchHerdSettleList);
                    				if(null!=herdSettleList && herdSettleList.size()>0){
                    					Object[] herdSettleListDtoArray = herdSettleList.toArray();
                    					if(null!=herdSettleListDtoArray && herdSettleListDtoArray.length>0){
                    						HerdsettlelistDto herdSettleListDtoTemp = (HerdsettlelistDto)herdSettleListDtoArray[0];
//                    						String strKindCodeSettleList = herdSettleListDtoTemp.getKindcode();
                    						String strKindCodeLloss = agriLossDto.getKindCode();
//                    						if(null!=strKindCodeSettleList && strKindCodeSettleList.equals(strKindCodeLloss)){
                    							int reduceNumber = 0;
                    							Iterator iteratorHerdSettle = herdSettleList.iterator();
	                        					while(iteratorHerdSettle.hasNext()){
	                        						HerdsettlelistDto herdSettleListDto = (HerdsettlelistDto)iteratorHerdSettle.next();
	                        						reduceNumber = reduceNumber- 1;//herdSettleListDto.getDeadnumber()- herdSettleListDto.getCullnumber();
	                        					}
	                        					numberListBaseOnHerdSettleList.put(prpLcompensateDto.getCompensateNo()+"_"+settleMainListDto.getRiskcode()+"_"+strKindCodeLloss, reduceNumber);
//                    						}
                    					}
                    				}
                    			}
                    		}
                    	}
                    	list.add(agriLossDto);
                	}
            	}
            	//Updated by GYIC LiYang 20110920 根据新的需求，对于在投保时录入耳标号清单的养殖险，在冲减保额是显示理赔清单信息，冲减也要冲减分户，通过分户的冲减来影响保单。其他险种不变。End！
            }
            //add by kangzhen 061123 end
            //加入对责任险的人伤的处理
            if(prpLcompensateDto.getRiskCode().substring(0,2).equals("15")||prpLcompensateDto.getRiskCode().substring(0,2).equals("08")){
                if(compensateDtoTemp.getPrpLpersonLossDtoList().size()>0&&compensateDtoTemp.getPrpLlossDtoList().size()>0){
            	//将人伤信息存入list中
            	ArrayList personToLossList = null;
            	ArrayList personLossList = compensateDtoTemp.getPrpLpersonLossDtoList();
            	Iterator personloss = personLossList.iterator();
            	UICodeAction uiCodeAction = new UICodeAction();
            	while(personloss.hasNext()){
           		    PrpLpersonLossDto  personLossDto =(PrpLpersonLossDto)personloss.next();
            		PrpLlossDto lossDto = new PrpLlossDto();
                    //modify 增加对重复信息的合并  by qinyongli 2005-10-29
            		ArrayList lossListNew = new ArrayList(); //用于保存产生的新的标的损失
            		ArrayList lossListTemp = compensateDtoTemp.getPrpLlossDtoList();
            		Iterator lossDtoTemp = lossListTemp.iterator();
            		while(lossDtoTemp.hasNext()){
            			PrpLlossDto lossDtoNew =(PrpLlossDto)lossDtoTemp.next();
            			if(lossDtoNew.getPolicyNo().equals(personLossDto.getPolicyNo())&&
            					lossDtoNew.getItemKindNo()==personLossDto.getItemKindNo()){
            				//表示标的有重复，进行合并，保留标的损失，将人伤合入标的
            				lossDtoNew.setSumRealPay(lossDtoNew.getSumRealPay()+personLossDto.getSumRealPay());
            			}else{
            				//标的无重复，直接加到损失列表中
            				lossDto.setCompensateNo(personLossDto.getCompensateNo());
                    		lossDto.setItemCode(personLossDto.getLiabDetailCode());
                    		lossDto.setLossName(personLossDto.getLiabDetailName());
                    		lossDto.setItemKindNo(personLossDto.getItemKindNo());
                    		lossDto.setKindCode(personLossDto.getKindCode());
                     		lossDto.setRiskCode(personLossDto.getRiskCode());
                    		lossDto.setCurrency(personLossDto.getCurrency());
                    		lossDto.setCurrencyName(personLossDto.getCurrencyName());
                    		lossDto.setSumRealPay(personLossDto.getSumRealPay());
                        	list.add(lossDto); //将人伤信息合入损失列表
            			}//if
            			list.add(lossDtoNew);  	
            		}//while	
                	//modify end by qinyongli 2005-10-29
            	}	   	
                }
                if(compensateDtoTemp.getPrpLpersonLossDtoList().size()>0&&compensateDtoTemp.getPrpLlossDtoList().size()==0){
                	ArrayList personLossList = compensateDtoTemp.getPrpLpersonLossDtoList();
                	if(personLossList != null){
                		for (int i=0; i<personLossList.size();i++){
                			PrpLlossDto lossDto = new PrpLlossDto();
                			PrpLpersonLossDto personLossDto = (PrpLpersonLossDto)personLossList.get(i);
                			lossDto.setCompensateNo(personLossDto.getCompensateNo());
                			lossDto.setItemCode(personLossDto.getLiabDetailCode());
                			lossDto.setLossName(personLossDto.getLiabDetailName());
                			lossDto.setItemKindNo(personLossDto.getItemKindNo());
                			lossDto.setKindCode(personLossDto.getKindCode());
                			lossDto.setRiskCode(personLossDto.getRiskCode());
                			lossDto.setCurrency(personLossDto.getCurrency());
                			lossDto.setCurrencyName(personLossDto.getCurrencyName());
                			lossDto.setSumRealPay(personLossDto.getSumRealPay());
                			list.add(lossDto);
                		}
                	}
                }
                if(compensateDtoTemp.getPrpLpersonLossDtoList().size()==0&&compensateDtoTemp.getPrpLlossDtoList().size()>0){
                	ArrayList lossList = compensateDtoTemp.getPrpLlossDtoList();
                	for(int i=0; i<lossList.size(); i++){
                		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
                		list.add(lossDto);
                	}
                }
            }
            if(Integer.parseInt(prpLcompensateDto.getRiskCode().substring(0,2))<14&& !prpLcompensateDto.getRiskCode().substring(0,2).equals("05")&& !prpLcompensateDto.getRiskCode().substring(0,2).equals("08")){
            	ArrayList lossList = compensateDtoTemp.getPrpLlossDtoList();
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		list.add(lossDto);
            	}
            }
            
            if(prpLcompensateDto.getRiskCode().substring(0,2).equals("05")
            		||prpLcompensateDto.getRiskCode().equals("3119")){
            	ArrayList lossList = compensateDtoTemp.getPrpLlossDtoList();
            	PrpLlossDto lossDtoA = new PrpLlossDto();
            	PrpLlossDto lossDtoL = new PrpLlossDto();
            	PrpLlossDto lossDtoG = new PrpLlossDto();
            	PrpLlossDto lossDto001 = new PrpLlossDto();
            	PrpLlossDto lossDto002 = new PrpLlossDto();
            	double sumRealPayA = 0d;
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		if(lossDto.getKindCode().equals("A")){
            			sumRealPayA = sumRealPayA + lossDto.getSumLoss();
            			lossDtoA.setCompensateNo(lossDto.getCompensateNo());
            			lossDtoA.setItemCode(lossDto.getItemCode());
            			lossDtoA.setLossName(lossDto.getLossName());
            			lossDtoA.setItemKindNo(lossDto.getItemKindNo());
            			lossDtoA.setKindCode("A");
            			lossDtoA.setRiskCode(lossDto.getRiskCode());
            			lossDtoA.setCurrency(lossDto.getCurrency());
            			lossDtoA.setCurrencyName(lossDto.getCurrencyName());
            			lossDtoA.setSumRealPay(sumRealPayA);
            		}
            	}
            	if(lossDtoA!=null && lossDtoA.getSumRealPay()>0){
            		list.add(lossDtoA);                		
            	}
            	
            	double sumRealPayL = 0d;
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		if(lossDto.getKindCode().equals("L")){
            			sumRealPayL = sumRealPayL + lossDto.getSumLoss();
            			lossDtoL.setCompensateNo(lossDto.getCompensateNo());
            			lossDtoL.setItemCode(lossDto.getItemCode());
            			lossDtoL.setLossName(lossDto.getLossName());
            			lossDtoL.setItemKindNo(lossDto.getItemKindNo());
            			lossDtoL.setKindCode("L");
            			lossDtoL.setRiskCode(lossDto.getRiskCode());
            			lossDtoL.setCurrency(lossDto.getCurrency());
            			lossDtoL.setCurrencyName(lossDto.getCurrencyName());
            			lossDtoL.setSumRealPay(sumRealPayL);
            		}
            	}
            	if(lossDtoL!=null && lossDtoL.getSumRealPay()>0){
            		list.add(lossDtoL);                		
            	}
            	
            	double sumRealPayG = 0d;
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		if(lossDto.getKindCode().equals("G")){
            			sumRealPayG = sumRealPayG + lossDto.getSumLoss();
            			lossDtoG.setCompensateNo(lossDto.getCompensateNo());
            			lossDtoG.setItemCode(lossDto.getItemCode());
            			lossDtoG.setLossName(lossDto.getLossName());
            			lossDtoG.setItemKindNo(lossDto.getItemKindNo());
            			lossDtoG.setKindCode("G");
            			lossDtoG.setRiskCode(lossDto.getRiskCode());
            			lossDtoG.setCurrency(lossDto.getCurrency());
            			lossDtoG.setCurrencyName(lossDto.getCurrencyName());
            			lossDtoG.setSumRealPay(sumRealPayG);
            		}
            	}
            	if(lossDtoG!=null && lossDtoG.getSumRealPay()>0){
            		list.add(lossDtoG);                		
            	}
            	
            	double sumRealPay001 = 0d;
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		if(lossDto.getKindCode().equals("001")){
            			sumRealPay001 = sumRealPay001 + lossDto.getSumLoss();
            			lossDto001.setCompensateNo(lossDto.getCompensateNo());
            			lossDto001.setItemCode(lossDto.getItemCode());
            			lossDto001.setLossName(lossDto.getLossName());
            			lossDto001.setItemKindNo(lossDto.getItemKindNo());
            			lossDto001.setKindCode("001");
            			lossDto001.setRiskCode(lossDto.getRiskCode());
            			lossDto001.setCurrency(lossDto.getCurrency());
            			lossDto001.setCurrencyName(lossDto.getCurrencyName());
            			lossDto001.setSumRealPay(sumRealPay001);
            		}
            	}
            	if(lossDto001!=null && lossDto001.getSumRealPay()>0){
            		list.add(lossDto001);                		
            	}
            	
            	double sumRealPay002 = 0d;
            	for(int i=0; i<lossList.size(); i++){
            		PrpLlossDto lossDto = (PrpLlossDto)lossList.get(i);
            		if(lossDto.getKindCode().equals("002")){
            			sumRealPay002 = sumRealPay002 + lossDto.getSumLoss();
            			lossDto002.setCompensateNo(lossDto.getCompensateNo());
            			lossDto002.setItemCode(lossDto.getItemCode());
            			lossDto002.setLossName(lossDto.getLossName());
            			lossDto002.setItemKindNo(lossDto.getItemKindNo());
            			lossDto002.setKindCode("002");
            			lossDto002.setRiskCode(lossDto.getRiskCode());
            			lossDto002.setCurrency(lossDto.getCurrency());
            			lossDto002.setCurrencyName(lossDto.getCurrencyName());
            			lossDto002.setSumRealPay(sumRealPay002);
            		}
            	}
            	if(lossDto002!=null && lossDto002.getSumRealPay()>0){
            		list.add(lossDto002);                		
            	}
            }
            
            
            prpLlossDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
            prpLlossDto.setRiskCode(prpLcompensateDto.getRiskCode());

            httpServletRequest.setAttribute("claimNo", prpLcompensateDto
                    .getClaimNo());

            conditions = "CompensateNo = '" + compensateNo + "'"+"and flag='1'";
            PrpLendorGetCountCommand command = new PrpLendorGetCountCommand(
                    conditions);
            int count = ((Integer) command.execute()).intValue();
            if (count > 0) {
                throw new Exception("赔案\"" + compensateNo + "\"已经做过冲减保额，不能再做。");
            }
        }
        
        if(prpLlossDto!=null&&prpLlossDto.getRiskCode()!=null&&prpLlossDto.getRiskCode().length()>2){
           if(prpLlossDto.getRiskCode().substring(0,2).equals("05")){
               Iterator iterator = list.iterator();
               boolean isReduce = false;
               PrpLlossDto lossDtoTemp = new PrpLlossDto();
               while(iterator.hasNext()){
                    lossDtoTemp =(PrpLlossDto)iterator.next();
                     if(lossDtoTemp.getKindCode().equals("A")||lossDtoTemp.getKindCode().equals("L")){
                          isReduce = true;
                     } 
             }
               if(!isReduce){
                   throw new Exception("该车险案件所涉及险别不用冲减保额！");
               }
           }
        }
        prpLlossDto.setPrpLlossList(list);
        if (list.size() == 0) {
            throw new Exception("立案\"" + claimNo + "\"已经做过冲减保额，不能再做。");
        }
        // PrepayDto prepayDto = uiClaimAction.findByPrimaryKey(claimNo);
        // UIClaimAction uiClaimAction = new UIClaimAction();
        // 设置相关代码的中文转换
        changeCodeToName(httpServletRequest, prpLlossDto);
        httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);
        httpServletRequest.setAttribute("numberListBaseOnHerdSettleList", numberListBaseOnHerdSettleList);
    }

    /**
     * 补收保费增加
     */
    public void addPreDataToView(HttpServletRequest httpServletRequest,
            String claimNo, String compensateNo) throws Exception {
    	PrpLcompensateDto prpLcompensateDto = null;
        CompensateDto compensateDto = null;
        List prpLlossList = null;
        PrpLlossDto prpLlossDto = null;
        String conditions = " ClaimNo='" + claimNo + "'";
    	UICompensateAction uiCompensateAction = new UICompensateAction();

        if (compensateNo == null || compensateNo.trim().length() == 0) {
            Collection collection = uiCompensateAction
                    .findByConditions(conditions);
            prpLlossList = new ArrayList();
            List prpLlossListAll = new ArrayList();
            prpLlossDto = new PrpLlossDto();
            if (collection.size() == 0) {
                throw new Exception("立案\"" + claimNo + "\"不存在");
            }
            for (Iterator iter = collection.iterator(); iter.hasNext();) {
            	prpLcompensateDto = (PrpLcompensateDto) iter.next();
            	if(!prpLcompensateDto.getUnderWriteFlag().equals("1") && !prpLcompensateDto.getUnderWriteFlag().equals("3")){
            		//throw new Exception("立案\"" + claimNo + "\"还未审核通过，不能补收保费。");
            	}
            	compensateDto = uiCompensateAction.findByPrimaryKey(prpLcompensateDto.getCompensateNo());
            	prpLlossList = compensateDto.getPrpLlossDtoList();
            	for (Iterator iterator = prpLlossList.iterator(); iterator
						.hasNext();) {
					PrpLlossDto element = (PrpLlossDto) iterator.next();
					prpLlossListAll.add(element);
				}
            	prpLlossDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
            	prpLlossDto.setRiskCode(prpLcompensateDto.getRiskCode());
			}
            prpLlossDto.setPrpLlossList(prpLlossListAll);
            changeCodeToName(httpServletRequest,prpLlossDto);
            httpServletRequest.setAttribute("claimNo", claimNo);
            httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);
        }else{
        	prpLlossList = new ArrayList();
        	prpLlossDto = new PrpLlossDto();
        	compensateDto = uiCompensateAction.findByPrimaryKey(compensateNo);
        	prpLcompensateDto = compensateDto.getPrpLcompensateDto();
        	claimNo = prpLcompensateDto.getClaimNo();
        	if(!prpLcompensateDto.getUnderWriteFlag().equals("1") && !prpLcompensateDto.getUnderWriteFlag().equals("3")){
        		//throw new Exception("立案\"" + claimNo + "\"还未审核通过，不能补收保费。");
        	}
        	prpLlossDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
        	prpLlossDto.setRiskCode(prpLcompensateDto.getRiskCode());
        	prpLlossList = compensateDto.getPrpLlossDtoList();
        	prpLlossDto.setPrpLlossList(prpLlossList);
        	changeCodeToName(httpServletRequest,prpLlossDto);
        	httpServletRequest.setAttribute("claimNo", claimNo);
            httpServletRequest.setAttribute("prpLlossDto", prpLlossDto);
        }
    }
    
    /**
     * 根据PrpPrepayDto中的已经设置的代码内容，对代码进行名称转换
     * @param httpServletRequest 返回给页面的request
     * @param prpPrepayDto 立案的数据类
     * @param PrepayDto 查询出的数据类
     * @throws Exception
     */
    private void changeCodeToName(HttpServletRequest httpServletRequest,
            PrpLlossDto prpLlossDto) throws Exception {
        UICodeAction uiCodeAction = new UICodeAction();
        // (1)条款名称的转换
        if (prpLlossDto.getPrpLlossList() != null) {
            ArrayList list = (ArrayList) prpLlossDto.getPrpLlossList();
            for (int i = 0; i < list.size(); i++) {
                PrpLlossDto prpLlossDtoTemp = (PrpLlossDto) list.get(i);
                prpLlossDtoTemp.setCurrencyName(uiCodeAction
                        .translateCurrencyCode(prpLlossDtoTemp.getCurrency(),
                                true));
                prpLlossDtoTemp.setKindName(uiCodeAction.translateKindCode(
                        prpLlossDtoTemp.getRiskCode(), prpLlossDtoTemp
                                .getKindCode(), true));
            }
        }
    }

}
