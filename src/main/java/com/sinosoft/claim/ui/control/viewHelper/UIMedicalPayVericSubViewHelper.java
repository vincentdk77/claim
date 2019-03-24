 package com.sinosoft.claim.ui.control.viewHelper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPayDetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayNoticeListAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.facade.UIWorkFlowApprovalInterFaceFacade;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;
import com.sinosoft.prpall.blsvr.jf.BLPrpJpayRefRec;
import com.sinosoft.prpall.blsvr.jf.BLPrpJpayRefRecCoins;
import com.sinosoft.sff.blsvr.BLPrpJcommissionFlog;
import com.sinosoft.sff.blsvr.BLPrpJplanFee;
import com.sinosoft.sff.blsvr.BLPrpJplanFeeCoins;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.webservice.newpayment.cli.SavePaymentInfoUtil;
import com.sinosoft.webservice.newpayment.cli.XStreamDto2XmlUtil;
import com.sinosoft.webservice.newpayment.req.PrpqBaseBodyDto;
import com.sinosoft.webservice.newpayment.req.PrpqBaseDto;
import com.sinosoft.webservice.newpayment.req.PrpqBaseHeadDto;
import com.sinosoft.webservice.newpayment.req.PrpqPayDto;
import com.sinosoft.webservice.newpayment.req.PrpqPayMainDto;
import com.sinosoft.webservice.newpayment.res.PrpqRepBaseDto;

/**
 * 三方支付自动审核类
 * */
public class UIMedicalPayVericSubViewHelper {
	
	/**
	 * 自动审核逻辑
	 * @param prpLinterPayRequestDto
	 * @return prpLinerPayRequestDto
	 * @throws Exception
	 * */
	public PrpLinterPayRequestDto autoPayVeric(PrpLinterPayRequestDto prpLinterPayRequestDto) throws Exception{
		UserDto user = new UserDto();
		user.setUserCode(prpLinterPayRequestDto.getOperatorCode());
		user.setUserName(prpLinterPayRequestDto.getOperatorName());
		user.setComCode(prpLinterPayRequestDto.getMakeCom());
		user.setComName(prpLinterPayRequestDto.getMakeComName());
		PrpLinterPayDetailDto prpLinterPayDetailDto = prpLinterPayRequestDto.getPrpLinterPayDetailDto();
		BLPrpLinterPayDetailAction blPrpLinterPayDetailAction = new BLPrpLinterPayDetailAction();
		String paymentNo = prpLinterPayDetailDto.getPaymentNo();
		try {
			UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
			//调用双核端方法处理支付审批逻辑
			String uwFlowID = uiWorkFlowApprovalInterFaceFacade. submitApprovalPlatform("MedicalAutoPaymentApprov","00",
					"00",paymentNo,"2801","28",user.getComCode(),user.getUserCode(),prpLinterPayRequestDto.getMakeCom(),
					user.getUserCode(), user.getUserCode(), prpLinterPayRequestDto.getHandleText());
			
			if(!"SUCCESS".equals(uwFlowID)){
				throw new Exception("支付审批处理失败!");
			}
			//创建数据库管理对象
		    DBManager dbManager = new DBManager();
		    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
		    BLPrplpayAction blPrplpayAction=new BLPrplpayAction();
		    BLPrpLpaymainAction blPrpLpaymainAction=new BLPrpLpaymainAction();
			try {
				//开始事务
				dbManager.beginTransaction();
				PrpLpaymainDto prplpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager,paymentNo);
				String noticeNo = mergerIssued(dbManager,paymentNo, user.getUserCode(), prplpaymainDto.getComCode(),
						prplpaymainDto.getReceiverFullName());
				prplpaymainDto.setNoticeNo(noticeNo);
				prplpaymainDto.setVflag("8");
				prplpaymainDto.setVerifyFlag("0");//审核方式 0 自动审核
				if(prplpaymainDto.getPayAmount()<0){
					prplpaymainDto.setThirdPayFlag("a");//更新第三方支付标识，a标示什么
				}else{
					/*if("1".equals(AppConfig.get("sysconst.NEWPAYMENT"))){
						prplpaymainDto.setThirdPayFlag("f");//更新第三方支付标识，f
					}else{
					prplpaymainDto.setThirdPayFlag("3");//更新第三方支付标识，3表示支付中心待处理
					}*/
					prplpaymainDto.setThirdPayFlag("3");//更新第三方支付标识，3表示支付中心待处理
				}
				blPrpLpaymainAction.update(dbManager, prplpaymainDto);
				blPrplpayAction.updateVFlag(dbManager,"8",paymentNo);
				//流程状态表赋值
				prpLinterPayDetailDto.setVericSuccFlag("1");
				blPrpLinterPayDetailAction.update(dbManager, prpLinterPayDetailDto);
				dbManager.commitTransaction();
				if("3".equals(prplpaymainDto.getThirdPayFlag())&&"1".equals(AppConfig.get("sysconst.NEWPAYMENT"))){
		            try {
		        		BLPrplpayFacade blPrpLpayFacade = new BLPrplpayFacade();
		        		List<PrpLpaymainDto> mainList = new ArrayList<PrpLpaymainDto>();
		        		mainList.add(prplpaymainDto);
		        		PrpqPayMainDto prpqPayMainDto = null;
		        		BLPrpDuserFacade facade = new BLPrpDuserFacade();
		        		HashMap<String, String> nameMap = new HashMap<String, String>();
		        		BLPrpJplanFee blPrpJplanFeenew = new BLPrpJplanFee(); 
						BLPrpJplanFeeCoins blPrpJplanFeeCoinsnew = new BLPrpJplanFeeCoins(); 
		        		for(PrpLpaymainDto prpLpaymainDto : mainList){
		        			prpqPayMainDto = new PrpqPayMainDto();
			        		if(prpLpaymainDto.getPayAmount()>0&&"1".equals(prpLpaymainDto.getPayWay())){
			        			prpqPayMainDto.setRoutenum(prpLpaymainDto.getRouteNum());//支付行号
			        			prpqPayMainDto.setPayPurpose(prpLpaymainDto.getPayPurpose());//用途说明
			        			prpqPayMainDto.setVisaserialno(prpLpaymainDto.getPaymentNo());//结算单号
			        			prpqPayMainDto.setSettleType("C");//结算类型
			            		prpqPayMainDto.setReceiverfullname(prpLpaymainDto.getReceiverFullName());//出款人
			            		prpqPayMainDto.setBankaccount(prpLpaymainDto.getBankAccount());//银行账号
			            		prpqPayMainDto.setBanktype(prpLpaymainDto.getBankType());
			            		prpqPayMainDto.setBank(prpLpaymainDto.getBank());
			            		prpqPayMainDto.setBankprov(prpLpaymainDto.getProvinceCode());//开户省份
			            		prpqPayMainDto.setBankcity(prpLpaymainDto.getCityCode());//开户城市
			            		prpqPayMainDto.setAccounttype(prpLpaymainDto.getAccountType());//账户属性
			            		if(nameMap.containsKey(prpLpaymainDto.getOperatorCode())){
			            			prpqPayMainDto.setOperatename(nameMap.get(prpLpaymainDto.getOperatorCode()));//操作人名称
			                		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//操作人代码
			            		} else {
			            			com.sinosoft.claim.dto.domain.PrpDuserDto userDto = facade.findByPrimaryKey(prpLpaymainDto.getOperatorCode());
			            			if(userDto!=null){
			            				prpqPayMainDto.setOperatename(userDto.getUserName());//操作人名称
			                    		prpqPayMainDto.setOperatorcode(prpLpaymainDto.getOperatorCode());//操作人代码
			                    		nameMap.put(prpLpaymainDto.getOperatorCode(), userDto.getUserName());
			            			}
			            		}
			            		prpqPayMainDto.setComcode(prpLpaymainDto.getComCode());//操作机构
			            		prpqPayMainDto.setAccountflag(prpLpaymainDto.getAccountFlag());
			            		prpqPayMainDto.setCertifyno(prpLpaymainDto.getCertifNo());//证件
			            		prpqPayMainDto.setCertifytype(prpLpaymainDto.getCertifType());//证件类型
			            		prpqPayMainDto.setReceivertype(prpLpaymainDto.getReceiverTypeOther());//赔款人类型
			            		prpqPayMainDto.setOfficephone(prpLpaymainDto.getOfficePhone());//办公室电话
			            		prpqPayMainDto.setMobilephone(prpLpaymainDto.getMobilePhone());//手机号码
			            		prpqPayMainDto.setFamilyphone(prpLpaymainDto.getFamilyPhone());//固话
			            		prpqPayMainDto.setAddress(prpLpaymainDto.getAddress());
			            		prpqPayMainDto.setQqnumber(prpLpaymainDto.getQqNumber());
			            		prpqPayMainDto.setEmail(prpLpaymainDto.getEmail());
			            		prpqPayMainDto.setUnitlink(prpLpaymainDto.getUnitLink());
			            		prpqPayMainDto.setPostcode(prpLpaymainDto.getPostCode());
			            		prpqPayMainDto.setUrgenttype(prpLpaymainDto.getUrgentType());
			            		prpqPayMainDto.setPayamount(String.valueOf(prpLpaymainDto.getPayAmount()));
			            		prpqPayMainDto.setThridpayflag(prpLpaymainDto.getPayWay());
			            		prpqPayMainDto.setFlag("3");
			            		prpqPayMainDto.setBusinessno1("");
			            		prpqPayMainDto.setBusinessno2("");
			            		prpqPayMainDto.setBusinessno3("");
			            		prpqPayMainDto.setBusinessno4("");
			            		prpqPayMainDto.setBusinessno5("");
			            		String time1 = new SimpleDateFormat("yyyyMMddHHmmss").format(prpLpaymainDto.getInputDate());
			            		prpqPayMainDto.setOperatedate(time1);//操作时间
			            		List<PrplpayDto> prplpayDtos = (ArrayList<PrplpayDto>)blPrpLpayFacade.findByConditions("serialno = '"+prpLpaymainDto.getPaymentNo()+"'");
			            		PrpqPayDto prpqPayDto = null;
			            		List<PrpqPayDto> list = new ArrayList<PrpqPayDto>();
			            		Map<String, Double> amountCheckMap = new HashMap<String, Double>();
			            		Map<String, Double> amountCoinsCheckMap = new HashMap<String, Double>();
			            		String key  = "";
			            		for(PrplpayDto prpLpayDto : prplpayDtos){
			            			if("GS60".equals(prpLpayDto.getPaymenttype())){
			            				key = prpLpayDto.getCompensateno()+"_"+prpLpayDto.getPaymenttype()+"_"+prpLpayDto.getCoinsCode();
			                			if(amountCoinsCheckMap.containsKey(key)){
			                				amountCoinsCheckMap.put(key, prpLpayDto.getPayamount()+amountCoinsCheckMap.get(key));
			                			} else {
			                				amountCoinsCheckMap.put(key, prpLpayDto.getPayamount());
			                			}
			            			} else {
			            				key = prpLpayDto.getCompensateno()+"_"+prpLpayDto.getPaymenttype();
			                			if(amountCheckMap.containsKey(key)){
			                				amountCheckMap.put(key, prpLpayDto.getPayamount()+amountCheckMap.get(key));
			                			} else {
			                				amountCheckMap.put(key, prpLpayDto.getPayamount());
			                			}
			            			}
			            		}
			            		boolean checkResult = true;
			            		String [] certyNoAndPayrefreason=null;
			            		for(String innerKey : amountCheckMap.keySet()){
			            			certyNoAndPayrefreason=innerKey.split("_");
			            			String condition = " certiType in ('Y','C','Z')  and certiNo = '"+certyNoAndPayrefreason[0]+"' and payrefreason = '"+certyNoAndPayrefreason[1]+"'";
			            			blPrpJplanFeenew.query(condition);
			            			double sumPlanfee = 0.0d;
			            			if(blPrpJplanFeenew.getSize()>0){
			            				sumPlanfee = Double.parseDouble(blPrpJplanFeenew.getArr(0).getPlanFee());//总的应付金额
			            			}
			            			DBManager dbManagernew = new DBManager();
			            			double payAmount = 0.0d;
			            			try{
			            				
			                			dbManagernew.open(AppConfig.get("sysconst.DBJNDI"));
			                			ResultSet resultSet=dbManagernew.executeQuery("  select sum(payAmount) as payAmount from (select amount as payAmount" +
			                            		" from thirdpay_platform.prpqpay where certino = '"+certyNoAndPayrefreason[0]+"' and payreason = '"+certyNoAndPayrefreason[1]+"'" +
			                            				" union all select amount as payAmount from thirdpay_platform.prpqpayhis q" +
			                            				" where certino = '"+certyNoAndPayrefreason[0]+"'" +
			                            				" and payreason = '"+certyNoAndPayrefreason[1]+"'" +
			                            				" and exists (select 1 from THIRDPAY_PLATFORM.PRPQPACKDETAIL D " +
			                            				"  WHERE D.VISASERIALNO = Q.VISASERIALNO " +
			                            				" AND D.APPROVEFLAG = '4' )"+
							                			" union all select amount as payAmount from thirdpay_platform.prpqpayhis q" +
							            				" where certino = '"+certyNoAndPayrefreason[0]+"'" +
							            				" and payreason = '"+certyNoAndPayrefreason[1]+"'" +
							            				" and exists (select 1 from THIRDPAY_PLATFORM.prpqpaymainHIS D " +
							            				"  WHERE D.VISASERIALNO = Q.VISASERIALNO " +
							            				" AND D.FLAG in ('10', '13' ))) ");
			                			if(resultSet.next()){
			                				payAmount=resultSet.getDouble("payAmount");
			                			}
			                			resultSet.close();
			                			//校验支付金额
				                		BigDecimal bg=new BigDecimal(payAmount+amountCheckMap.get(innerKey));
				                		Double totalPayAmount=bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//实际支付金额
				                		BigDecimal bgPlanfee=new BigDecimal(sumPlanfee);
				                		Double totalPlanfee=bgPlanfee.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//应该支付金额
				            			if(totalPayAmount>totalPlanfee){
			            				//支付金额过大，不可同步
			            				//更新prplpaymain bcflag='3'
			            				dbManagernew.beginTransaction();
			            				dbManagernew.executeUpdate(" update prplpaymain set sendflag='3' where paymentno='"+prpLpaymainDto.getPaymentNo()+"'");//支存在重复支付的数据  即支付金额大于应付金额
			            				dbManagernew.commitTransaction();
			            				checkResult = false;
			            			}
			            			} catch (Exception e){
				        				e.printStackTrace();
				        				dbManagernew.rollbackTransaction();
				        			} finally {
				        				dbManagernew.close();
				        			}
			            		}
			            		if(!checkResult){
			            			continue;
			            		}
			            		String [] certyNoAndPayrefreasonCoins=null;
			            		for(String innerKey : amountCoinsCheckMap.keySet()){
			           			 	 certyNoAndPayrefreasonCoins=innerKey.split("_");
				           			 String queryPlanFeeCoinsCode= " certiType in ('Y','C','Z')  and certiNo = '"+certyNoAndPayrefreasonCoins[0]+"' and payrefreason = '"+certyNoAndPayrefreasonCoins[1]+"'";
				     				 String iCoinsCode = certyNoAndPayrefreasonCoins[2];
				     				 if(null!=iCoinsCode && !"".equals(iCoinsCode)){
				     						queryPlanFeeCoinsCode += " and coinscode = '"+iCoinsCode+"'";
				     				 }
				     				blPrpJplanFeeCoinsnew.query(queryPlanFeeCoinsCode);
				     				double sumPlanfee_coins=0.0d;
				     				if(blPrpJplanFeeCoinsnew.getSize()>0){
			    						sumPlanfee_coins =  Double.parseDouble(blPrpJplanFeeCoinsnew.getArr(0).getPlanFee());
			    					}
				     				//查询已支付和待支付
				     				DBManager dbManagercoins = new DBManager();
				     				double payAmount = 0.0d;
				     				try{
			                			dbManagercoins.open(AppConfig.get("sysconst.DBJNDI"));
			                			ResultSet resultSet=dbManagercoins.executeQuery("  select sum(payAmount) as payAmount from (select amount as payAmount" +
			                            		" from thirdpay_platform.prpqpay where certino = '"+certyNoAndPayrefreasonCoins[0]+"' and payreason = '"+certyNoAndPayrefreasonCoins[1]+"' and articlecode24 = '"+certyNoAndPayrefreasonCoins[2]+"'" +
			                            				" union all select amount as payAmount from thirdpay_platform.prpqpayhis Q " +
			                            				" where certino = '"+certyNoAndPayrefreasonCoins[0]+"'" +
			                            				" and payreason = '"+certyNoAndPayrefreasonCoins[1]+"'" +
			                            				" and articlecode24 = '"+certyNoAndPayrefreasonCoins[2]+"'" +
			                            				" and exists (select 1 from THIRDPAY_PLATFORM.PRPQPACKDETAIL D " +
			                            				" WHERE D.VISASERIALNO = Q.VISASERIALNO  " +
			                            				"  AND D.APPROVEFLAG = '4' )"+
							                			" union all select amount as payAmount from thirdpay_platform.prpqpayhis q" +
							            				" where certino = '"+certyNoAndPayrefreasonCoins[0]+"'" +
							            				" and payreason = '"+certyNoAndPayrefreasonCoins[1]+"'" +
							            				" and articlecode24 = '"+certyNoAndPayrefreasonCoins[2]+"'" +
							            				" and exists (select 1 from THIRDPAY_PLATFORM.prpqpaymainHIS D " +
							            				"  WHERE D.VISASERIALNO = Q.VISASERIALNO " +
							            				" AND D.FLAG in ('10', '13' ))) ");
			                			if(resultSet.next()){
			                				payAmount=resultSet.getDouble("payAmount");
			                			}
			                			resultSet.close();
			                			BigDecimal bg=new BigDecimal(payAmount+amountCoinsCheckMap.get(innerKey));
				                		Double totalPayAmount=bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//实际支付金额
				                		BigDecimal bgPlanfee=new BigDecimal(sumPlanfee_coins);
				                		Double totalPlanfee=bgPlanfee.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//应该支付金额
				            			if(totalPayAmount>totalPlanfee){
			            				//支付金额过大，不可同步
			            				//更新prplpaymain bcflag='3'
				     					dbManagercoins.beginTransaction();
				     					dbManagercoins.executeUpdate(" update prplpaymain set sendflag='3' where paymentno='"+prpLpaymainDto.getPaymentNo()+"'");//支存在重复支付的数据  即支付金额大于应付金额
				     					dbManagercoins.commitTransaction();
				     					checkResult = false;
			            			}
				     				} catch (Exception e){
				        				e.printStackTrace();
				        				dbManagercoins.rollbackTransaction();
				        			} finally {
				        				dbManagercoins.close();
				        			}
			            		}
			            		if(!checkResult){
			            			continue;
			            		}
			            		for(PrplpayDto prpLpayDto : prplpayDtos){
			            			prpqPayDto = new PrpqPayDto();
			            			prpqPayDto.setCertino(prpLpayDto.getCompensateno());
			                		prpqPayDto.setCertitype("C");
			                		prpqPayDto.setPayno("1");
			                		prpqPayDto.setPolicyno(prpLpayDto.getPolicyno());
			                		prpqPayDto.setPayreason(prpLpayDto.getPaymenttype());
			                		prpqPayDto.setAmount(String.valueOf(prpLpayDto.getPayamount()));
			                		prpqPayDto.setFlag1("");
			                		prpqPayDto.setFlag2("");
			                		prpqPayDto.setFlag3("");
//			                		prpqPayDto.setFlag4("");
			                		prpqPayDto.setFlag5("");
			            			if("GS60".equals(prpLpayDto.getPaymenttype())){
			                			BLPrpJpayRefRecCoins blPrpJpayRefRecCoins = new BLPrpJpayRefRecCoins();
			                			blPrpJpayRefRecCoins.query("CERTINO='"+prpLpayDto.getCompensateno()+"' and CERTITYPE in ('Y','C','Z') and payrefreason='"+prpLpayDto.getPaymenttype()+"' and CoinsCode='"+prpLpayDto.getCoinsCode()+"'");
			                			prpqPayDto.setComcode(blPrpJpayRefRecCoins.getArr(0).getComCode());
			                			prpqPayDto.setArticleCode28(blPrpJpayRefRecCoins.getArr(0).getComCode());
			                			prpqPayDto.setArticleCode05(blPrpJpayRefRecCoins.getArr(0).getRiskCode());
			                    		prpqPayDto.setArticleCode24(blPrpJpayRefRecCoins.getArr(0).getCoinsCode());
			                    		prpqPayDto.setFlag4(blPrpJpayRefRecCoins.getArr(0).getSerialNo());
			                    		if(prpqPayMainDto.getUppercomcode()==null || "".equals(prpqPayMainDto.getUppercomcode())){
			                    			BLPrpJcommissionFlog blPrpJcommissionFlog = new BLPrpJcommissionFlog();
			                    			blPrpJcommissionFlog.query("flowid='"+blPrpJpayRefRecCoins.getArr(0).getVisaSerialNo()+"' and flowstatus='1'");
			                    			if(blPrpJcommissionFlog.getSize()>0){
			                    				prpqPayMainDto.setUppercomcode(blPrpJcommissionFlog.getArr(0).getDeptCode());
			                    			}
			                    		}
			                		} else {
			                			BLPrpJpayRefRec blprpJpayRefRec = new BLPrpJpayRefRec();
			            				blprpJpayRefRec.query("CERTINO='"+prpLpayDto.getCompensateno()+"' and CERTITYPE in ('Y','C','Z') and payrefreason='"+prpLpayDto.getPaymenttype()+"'");
			            				prpqPayDto.setComcode(blprpJpayRefRec.getArr(0).getComCode());
			            				prpqPayDto.setArticleCode05(blprpJpayRefRec.getArr(0).getRiskCode());//要改动专项
			            				prpqPayDto.setArticleCode28(blprpJpayRefRec.getArr(0).getComCode());
			            				prpqPayDto.setFlag4(blprpJpayRefRec.getArr(0).getSerialNo());
			            				if(prpqPayMainDto.getUppercomcode()==null || "".equals(prpqPayMainDto.getUppercomcode())){
			            					BLPrpJcommissionFlog blPrpJcommissionFlog = new BLPrpJcommissionFlog();
			                    			blPrpJcommissionFlog.query("flowid='"+blprpJpayRefRec.getArr(0).getVisaSerialNo()+"' and flowstatus='1'");
			                    			if(blPrpJcommissionFlog.getSize()>0){
			                    				prpqPayMainDto.setUppercomcode(blPrpJcommissionFlog.getArr(0).getDeptCode());
			                    			}
			            				}
			                		}
			            			list.add(prpqPayDto);
			            		}
			            		PrpqBaseDto request = new PrpqBaseDto();
			            		PrpqBaseBodyDto body = new PrpqBaseBodyDto();
			            		PrpqBaseHeadDto head = new PrpqBaseHeadDto();
			            		Date date = new Date();
			            		SimpleDateFormat mat = new SimpleDateFormat("yyyyMMddHHmmss");
			            		String time = mat.format(date);
			            		head.setChannelCode("Sinosoft");
			            		head.setUserCode(AppConfig.get("sysconst.PAYMENTPLATFORMUSERCODE"));
			            		head.setTransID(time);//time
			            		head.setPassword(AppConfig.get("sysconst.PAYMENTPLATFORMPASSWORD"));
			            		head.setTransType("S");
			            		body.setBasePart(prpqPayMainDto);
			            		body.setDetailInfoList(list);
			            		request.setBody(body);
			            		request.setHead(head);
			            		XStreamDto2XmlUtil xStreamDto2XmlUtil = new XStreamDto2XmlUtil();
			            		String xmlreq = xStreamDto2XmlUtil.Dto2Xml(request);
			            		String respxml = SavePaymentInfoUtil.savePaymentInfo(xmlreq);
			            		System.out.println(respxml);
			            		PrpqRepBaseDto prpqRepBaseDto = new PrpqRepBaseDto();
			            		PrpqRepBaseDto dto = (PrpqRepBaseDto)xStreamDto2XmlUtil.Xml2Dto(prpqRepBaseDto, respxml);
			            		String messagecode = dto.getHead().getErrorCode();
			            		System.out.println(messagecode);
			            		String sendflag = "1";
			            		if("9999".equals(messagecode)){
			            			sendflag = "0";
			            		}
			            		DBManager dbManager1 = new DBManager();
			        			try {
			        				dbManager1.open(AppConfig.get("sysconst.DBJNDI"));
			                        dbManager1.beginTransaction();
			                        //更新记录
			                        String sql = "update prplpaymain set sendflag='"+sendflag+"' where paymentno='"+prpLpaymainDto.getPaymentNo()+"'";
			                        dbManager1.executeUpdate(sql);
			                        dbManager1.commitTransaction();
			        			} catch (Exception e){
			        				e.printStackTrace();
			        				dbManager1.rollbackTransaction();
			        			} finally {
			        				dbManager1.close();
			        			}
			        		}
		        		}
		                //发送结束
		            } catch (Exception ee) {
		            	ee.printStackTrace();
		            	DBManager dbManager1 = new DBManager();
		    			try {
		    				dbManager1.open(AppConfig.get("sysconst.DBJNDI"));
		                    dbManager1.beginTransaction();
		                    //更新记录
		                    String sql = "";
		                    sql = "update prplpaymain set sendflag='0' where paymentno='"+prplpaymainDto.getPaymentNo()+"'";
		                    dbManager1.executeUpdate(sql);
		                    dbManager1.commitTransaction();
		    			} catch (Exception e){
		    				e.printStackTrace();
		    			} finally {
		    				dbManager1.close();
		    			}
		            }
		        }
			} catch (Exception e) {
				e.printStackTrace();
				 //回滚事务
			    dbManager.rollbackTransaction();
			    throw e;
			}finally{
				//关闭数据库连接
			    dbManager.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			prpLinterPayDetailDto.setVericSuccFlag("0");
			new BLPrpLinterPayDetailFacade().update(prpLinterPayDetailDto);
			throw e;
		}
		return prpLinterPayRequestDto;
	}
	
	/**
	 * * 单个支付单号合并下发
	 * @param paymentNo 支付编号
	 * @param userCode	操作人员代码
	 * @param comCode	承保机构代码
	 * @param receiverFullName 领款人名称
	 * @return	通知单号
	 * @throws Exception
	 */
	private String mergerIssued(DBManager dbManager,String paymentNo,String userCode,String comCode,String receiverFullName) throws Exception{
		BLBillAction uiBillAction = new BLBillAction();
		BLPrpLpayNoticeAction  blPrpLpayNoticeAction = new BLPrpLpayNoticeAction();
		BLPrpLpayNoticeListAction blPrpLpayNoticeListAction = new BLPrpLpayNoticeListAction();
		String noticeNo = "";
		try{
            int year = DateTime.current().getYear();
            String tableName = "prplpaynotice";
            String riskCode = "2801";
            noticeNo = uiBillAction.getNo(dbManager,tableName, riskCode,comCode, year,"");//生成主键
            //通知单表数据插入
            PrpLpayNoticeListDto prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            PrpLpayNoticeDto prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(noticeNo);
            prpLpayNoticeDto.setNoticeType("0");
            prpLpayNoticeDto.setOpreateCode(userCode);
            prpLpayNoticeDto.setOpreateDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
            prpLpayNoticeDto.setReceiverFullName(receiverFullName);
            blPrpLpayNoticeAction.insert(dbManager, prpLpayNoticeDto);
            //通知单关联表数据插入
            prpLpayNoticeListDto.setNoticeNo(noticeNo);
            prpLpayNoticeListDto.setPaymentNo(paymentNo);
            blPrpLpayNoticeListAction.insert(dbManager, prpLpayNoticeListDto);
		}catch(Exception exception){
			exception.printStackTrace();
            throw exception;
        }
		return noticeNo;
	}

}