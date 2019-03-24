package com.sinosoft.common_claim.bl.action.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonLossFacade;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdClaimPolicyInfoDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcaeCoverageInfoDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcasePolicyInfoDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdRiskRequestInDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 山东意外险风险预警平台数据封装类
 * @author Administrator
 *
 */
public class TransDataHelperSdAcci {
	/**
	 * 立案登记接口报文数据封装
	 * @throws SQLException 
	 */
	public CIAcciSdClaimRequestInDto getClaim(DBManager dbManager,String claimNo,String serialNo,String groupFlag) throws SQLException{
		CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto = new CIAcciSdClaimRequestInDto();
		String claimNumber = "";//立案号
		String groupClaimNo = "";//团体赔案号
		String claimType = "";//赔案类型
		Date claimDate = null;//立案日期
		Date lossDate = null;//出险日期
		String lossCause = "";//出险原因
		String lossArea = "";//出险地点
		String name = "";//出险人姓名
		String gender = "";//出险人性别
		String birthday = "";;//出险人出生日期
		String credentialType = "";//出险人证件类型
		String credentialNo = "";//出险人证件号码
		String lossResult = "";//出险结果
		Date lossResultDate = null;//出险结果日期
		String isCancelClaim = "";//是否撤销案件
		Date cancelDate = null;//案件撤销日期
		ResultSet resultSet = null;
		String identifytype = "";
	    try {
			PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
			if(prpLclaimDto !=null){
				if("1".equals(groupFlag)){
					claimNumber = prpLclaimDto.getClaimNo()+"-"+serialNo;
					groupClaimNo = prpLclaimDto.getClaimNo();
					claimType = "01";//团体赔案
					credentialType = "01";//默认身份证
				}else if("0".equals(groupFlag)){
					claimNumber = prpLclaimDto.getClaimNo();
					claimType = "02";//个体赔案
					String strSql = "SELECT identifytype from prpcinsured  WHERE policyno='"+prpLclaimDto.getPolicyNo()+"' AND insuredflag='1'";
					resultSet = dbManager.executeQuery(strSql);
					while(resultSet.next()){
						identifytype = resultSet.getString(1);
					}
					credentialType = transIdentifyType(identifytype);
				}
				claimDate = prpLclaimDto.getClaimTime();
				lossDate = prpLclaimDto.getDamageStartDate();
				if(prpLclaimDto.getDamageName().indexOf("意外")>-1){
					lossCause = "01";//意外
				}else{
					lossCause = "99";//其他
				}
				lossArea = prpLclaimDto.getDamageAddress();
				if(prpLclaimDto.getDamageTypeName().indexOf("身故")>-1){
					lossResult = "01";//身故
				}else if(prpLclaimDto.getDamageTypeName().indexOf("高残")>-1){
					lossResult = "02";//高残
				}else if(prpLclaimDto.getDamageTypeName().indexOf("伤残")>-1){
					lossResult = "03";//伤残
				}else{
					lossResult = "99";//其他
				}
				lossResultDate = prpLclaimDto.getClaimTime();
				if(prpLclaimDto.getCancelDate().toString()==null || "".equals(prpLclaimDto.getCancelDate().toString())){
					isCancelClaim = "0";//否
				}else{
					isCancelClaim = "1";//是
				}
				if("1".equals(isCancelClaim)){
					cancelDate = prpLclaimDto.getCancelDate();
				}
				CIAcciSdClaimPolicyInfoDto ciAcciSdClaimPolicyInfoDto = new CIAcciSdClaimPolicyInfoDto();
				ciAcciSdClaimPolicyInfoDto.setPolicyNo(prpLclaimDto.getPolicyNo());
				String conditions = " 1=1 and certino='"+prpLclaimDto.getRegistNo()+"' and serialno='"+serialNo+"' ";
				Collection acciPersonList = new BLPrpLaccipersonFacade().findByConditions(conditions);
				if(acciPersonList !=null && acciPersonList.size()>0){
					Iterator it = acciPersonList.iterator();
					while(it.hasNext()){
						PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)it.next();
						name = prpLacciPersonDto.getAcciName();
					    if("1".equals(prpLacciPersonDto.getSex())){//男
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//女
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//不详
					    	gender = "2";
					    }else{
					    	gender = "2";
					    }
					    credentialNo = prpLacciPersonDto.getIdentifyNumber();
					    if(credentialNo.length()==18){
					    	birthday = credentialNo.substring(6, 14);
					    }else if(credentialNo.length()==15){
					    	birthday = "19"+credentialNo.substring(6, 12);
					    }else{
					    	birthday = "19990101";
					    }
					    if("".equals(credentialNo) || credentialNo==null){
					    	credentialNo = "370102199901010015";
					    }
					}
				}
				ciAcciSdClaimRequestInDto.setClaimNo(claimNumber);
				ciAcciSdClaimRequestInDto.setGroupClaimNo(groupClaimNo);
				ciAcciSdClaimRequestInDto.setClaimType(claimType);
				ciAcciSdClaimRequestInDto.setClaimDate(new SimpleDateFormat("yyyyMMddHH").format(claimDate));
				ciAcciSdClaimRequestInDto.setLossDate(new SimpleDateFormat("yyyyMMdd").format(lossDate)+prpLclaimDto.getDamageStartHour().substring(0,2));
				ciAcciSdClaimRequestInDto.setLossCause(lossCause);
				ciAcciSdClaimRequestInDto.setLossArea(lossArea);
				ciAcciSdClaimRequestInDto.setName(name);
				ciAcciSdClaimRequestInDto.setGender(gender);
				ciAcciSdClaimRequestInDto.setBirthday(birthday);
				ciAcciSdClaimRequestInDto.setCredentialType(credentialType);
				ciAcciSdClaimRequestInDto.setCredentialNo(credentialNo);
				ciAcciSdClaimRequestInDto.setLossResult(lossResult);
				ciAcciSdClaimRequestInDto.setLossResultDate(new SimpleDateFormat("yyyyMMddHH").format(lossResultDate));
				ciAcciSdClaimRequestInDto.setIsCancelClaim(isCancelClaim);
				ciAcciSdClaimRequestInDto.setCancelDate(cancelDate==null?"":new SimpleDateFormat("yyyyMMddHH").format(cancelDate));
				ciAcciSdClaimRequestInDto.getCiAcciSdClaimPolisyList().add(ciAcciSdClaimPolicyInfoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet !=null){
				resultSet.close();
			}
		}
		return ciAcciSdClaimRequestInDto;
		
	}
	
	/**
	 *
	 * 结案登记接口报文数据封装
	 * @throws SQLException 
	 */
    public CIAcciSdEndcaseRequestInDto getEndcase(DBManager dbManager,String claimNo,String serialNo,String groupFlag,String acciName) throws SQLException{
    	CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto = new CIAcciSdEndcaseRequestInDto();
    	String claimNumber = "";//立案号
		String groupClaimNo = "";//团体赔案号
		String claimType = "";//赔案类型
		Date claimDate = null;//立案日期
		Date lossDate = null;//出险日期
		String lossCause = "";//出险原因
		String lossArea = "";//出险地点
		String name = "";//出险人姓名
		String gender = "";//出险人性别
		String birthday = "";//出险人出生日期
		String credentialType = "";//出险人证件类型
		String credentialNo = "";//出险人证件号码
		String lossResult = "";//出险结果
		Date lossResultDate = null;//出险结果日期
		Date endcaseDate = null;//结案日期
		double sumPaid = 0d;//总赔款金额
		String caseResult = "";//理赔结论
		//ResultSet resultSet =null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		String compensateNo = "";
		double sumAllRealPay = 0d;
		String identifytype = "";
		try{
			PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
			if(prpLclaimDto !=null){
				if("1".equals(groupFlag)){
					claimNumber = prpLclaimDto.getClaimNo()+"-"+serialNo;
					groupClaimNo = prpLclaimDto.getClaimNo();
					claimType = "01";//团体赔案
					credentialType = "01";//默认身份证
				}else{
					claimNumber = prpLclaimDto.getClaimNo();
					claimType = "02";//个体赔案
					String certiSql = "SELECT identifytype from prpcinsured  WHERE policyno='"+prpLclaimDto.getPolicyNo()+"' AND insuredflag='1'";
					resultSet2 = dbManager.executeQuery(certiSql);
					while(resultSet2.next()){
						identifytype = resultSet2.getString(1);
					}
					credentialType = transIdentifyType(identifytype);
				}
				claimDate = prpLclaimDto.getClaimTime();
				lossDate = prpLclaimDto.getDamageStartDate();
				if(prpLclaimDto.getDamageName().indexOf("意外")>-1){
					lossCause = "01";//意外
				}else{
					lossCause = "99";//其他
				}
				lossArea = prpLclaimDto.getDamageAddress();
				if(prpLclaimDto.getDamageTypeName().indexOf("身故")>-1){
					lossResult = "01";//身故
				}else if(prpLclaimDto.getDamageTypeName().indexOf("高残")>-1){
					lossResult = "02";//高残
				}else if(prpLclaimDto.getDamageTypeName().indexOf("伤残")>-1){
					lossResult = "03";//伤残
				}else{
					lossResult = "99";//其他
				}
				lossResultDate = claimDate;
				endcaseDate  = prpLclaimDto.getEndCaseDate();
//				String strSql = "SELECT sumdutypaid,compensateno from prplcompensate WHERE claimno='"+claimNo+"' and times=1";
//				resultSet = dbManager.executeQuery(strSql);
//				while(resultSet.next()){
//					sumPaid = resultSet.getDouble(1);
//					compensateNo = resultSet.getString(2);
//				}
				if(prpLclaimDto.getCancelDate().toString()==null || "".equals(prpLclaimDto.getCancelDate().toString())){
					caseResult = "01";//正常
				}else if(prpLclaimDto.getCancelDate().toString()!=null && "1".equals(prpLclaimDto.getCaseType())){
					caseResult = "04";//拒赔
				}else{
					caseResult = "99";//其他
				}
				String conditions = " 1=1 and certino='"+prpLclaimDto.getRegistNo()+"' and serialno='"+serialNo+"' ";
				Collection acciPersonList = new BLPrpLaccipersonFacade().findByConditions(conditions);
				if(acciPersonList !=null && acciPersonList.size()>0){
					Iterator it = acciPersonList.iterator();
					while(it.hasNext()){
						PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)it.next();
						name = prpLacciPersonDto.getAcciName();
					    if("1".equals(prpLacciPersonDto.getSex())){//男
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//女
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//不详
					    	gender = "2";
					    }else{
					    	gender = "2";
					    }
					    credentialNo = prpLacciPersonDto.getIdentifyNumber();
					    if(credentialNo.length()==18){
					    	birthday = credentialNo.substring(6, 14);
					    }else if(credentialNo.length()==15){
					    	birthday = "19"+credentialNo.substring(6, 12);
					    }else{
					    	birthday = "19990101";
					    }
					    if("".equals(credentialNo) || credentialNo==null){
					    	credentialNo = "370102199901010015";
					    }
					}
				}
				//保单信息、险种信息
				CIAcciSdEndcasePolicyInfoDto ciAcciSdEndcasePolicyInfoDto = new CIAcciSdEndcasePolicyInfoDto();
				ciAcciSdEndcasePolicyInfoDto.setPolicyNo(prpLclaimDto.getPolicyNo());
				//ciAcciSdEndcaeCoverageInfoDto.setComCoverageCode(prpLclaimDto.getRiskCode());
				//ciAcciSdEndcaeCoverageInfoDto.setCovClaimAmount(sumPaid);//险种赔付金额
				//if(!"".equals(compensateNo) && compensateNo!=null){
					String policyNumber ="";
					String kindcode = "";
					String itemKindNo = "";
					double sumrealPay = 0d;
					String comCoverageCode = "";
					String rationtype = "";
					int j = 0;
					int l = 0;
					boolean isExists = true;
					String[] kindCode = new String[50];
					Double[] kindCodeAmount = new Double[50] ;
					String coverageCondition = " loss.compensateno in (SELECT compensateno from prplcompensate WHERE claimno= '"
						+ claimNo
						+ "') and loss.personname = '"
						+ acciName
						+ "' and loss.policyno = ck.policyno and loss.kindcode = ck.kindcode and loss.itemkindno = ck.itemkindno ";
					BLPrpLpersonLossFacade blPrpLpersonLossFacade = new BLPrpLpersonLossFacade();
					PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
					ArrayList<PrpLpersonLossDto> prpLpersonLossDtoList =(ArrayList)blPrpLpersonLossFacade.findByRecase(coverageCondition);
					if(prpLpersonLossDtoList.size()>0){
						for(int i=0;i<prpLpersonLossDtoList.size();i++){
							isExists = true;
							prpLpersonLossDto = prpLpersonLossDtoList.get(i);
//							policyNumber = prpLpersonLossDto.getPolicyNo();
//							kindcode = prpLpersonLossDto.getKindCode();
//							itemKindNo = prpLpersonLossDto.getItemKindNo()+"";
//							sumrealPay = prpLpersonLossDto.getSumRealPay();
							sumAllRealPay +=  prpLpersonLossDto.getSumRealPay();
//							String coverageSql = " select rationtype from prpcitemkind where policyno='"+policyNumber+"' " +
//									"and kindcode='"+kindcode+"' and itemkindno='"+itemKindNo+"' ";
//							resultSet1 = dbManager.executeQuery(coverageSql);
//							while(resultSet1.next()){
//								rationtype = resultSet1.getString(1);
//							}
//							if(!"".equals(rationtype) && rationtype!=null){
//								comCoverageCode = kindcode+rationtype;
//							}else{
//								comCoverageCode = kindcode;
//							}
							if(i==0){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								isExists = false;
								l++;
							}else{
								for(int k = 0;k < kindCode.length;k++){
									
									if(kindCode[k] != null && !"".equals(kindCode[k]) && (kindCode[k]).equals(prpLpersonLossDto.getKindCode())){
										isExists = false;
										kindCodeAmount[k] += prpLpersonLossDto.getSumRealPay();
										k++;
									}
								}
							}
							if(isExists){
								kindCode[j++] = prpLpersonLossDto.getKindCode();
								kindCodeAmount[l] = prpLpersonLossDto.getSumRealPay();
								l++;
							}
						}
						for(int k = 0;k < kindCode.length;k++){
							if(kindCode[k] != null && !"".equals(kindCode[k])){
								CIAcciSdEndcaeCoverageInfoDto ciAcciSdEndcaeCoverageInfoDto = new CIAcciSdEndcaeCoverageInfoDto();
								ciAcciSdEndcaeCoverageInfoDto.setComCoverageCode(kindCode[k]);
								ciAcciSdEndcaeCoverageInfoDto.setCovClaimAmount(kindCodeAmount[k]);//险种赔付金额 对应业务系统的险别赔付金额
								ciAcciSdEndcasePolicyInfoDto.getCiAcciSdEndcaeCoverageInfoDtoList().add(ciAcciSdEndcaeCoverageInfoDto);
							}
						}
					}
				//}
				//end
				ciAcciSdEndcasePolicyInfoDto.setPolClaimAmount(sumAllRealPay);
				ciAcciSdEndcaseRequestInDto.setClaimNo(claimNumber);
				ciAcciSdEndcaseRequestInDto.setGroupClaimNo(groupClaimNo);
				ciAcciSdEndcaseRequestInDto.setClaimType(claimType);
				ciAcciSdEndcaseRequestInDto.setClaimDate(new SimpleDateFormat("yyyyMMddHH").format(claimDate));
				ciAcciSdEndcaseRequestInDto.setLossDate(new SimpleDateFormat("yyyyMMdd").format(lossDate)+prpLclaimDto.getDamageStartHour().substring(0,2));
				ciAcciSdEndcaseRequestInDto.setLossCause(lossCause);
				ciAcciSdEndcaseRequestInDto.setLossArea(lossArea);
				ciAcciSdEndcaseRequestInDto.setName(name);
				ciAcciSdEndcaseRequestInDto.setGender(gender);
				ciAcciSdEndcaseRequestInDto.setBirthday(birthday);
				ciAcciSdEndcaseRequestInDto.setCredentialType(credentialType);
				ciAcciSdEndcaseRequestInDto.setCredentialNo(credentialNo);
				ciAcciSdEndcaseRequestInDto.setLossResult(lossResult);
				ciAcciSdEndcaseRequestInDto.setLossResultDate(new SimpleDateFormat("yyyyMMddHH").format(lossResultDate));
				ciAcciSdEndcaseRequestInDto.setClaimCloseDate(new SimpleDateFormat("yyyyMMddHH").format(endcaseDate));
				ciAcciSdEndcaseRequestInDto.setClaimAmount(sumAllRealPay);
				ciAcciSdEndcaseRequestInDto.setClaimResult(caseResult);
				ciAcciSdEndcaseRequestInDto.getCiAcciSdEndCasePolisyList().add(ciAcciSdEndcasePolicyInfoDto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
//			if(resultSet !=null){
//				resultSet.close();
//			}
			if(resultSet1 !=null){
				resultSet1.close();
			}
			if(resultSet2 !=null){
				resultSet2.close();
			}
		}
		return ciAcciSdEndcaseRequestInDto;
    	
    }
    
    /**
     * 理赔风险查询接口
     */
    public CIAcciSdRiskRequestInDto getRiskInformation(DBManager dbManager,String claimNo,String serialNo){
    	CIAcciSdRiskRequestInDto ciAcciSdRiskRequestInDto = new CIAcciSdRiskRequestInDto();
    	String insuredName = "";//出险人姓名
    	String gender = "";//出险人性别
    	String birthday = "";//出险人出生日期
    	String credentialType = "";//出险人证件类型
    	String credentialNo = "";//出险人证件号码
    	String lossDate = "";//出险日期
    	try {
			PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
			if(prpLclaimDto!=null){
				lossDate = new SimpleDateFormat("yyyyMMdd").format(prpLclaimDto.getDamageStartDate())+prpLclaimDto.getDamageStartHour().substring(0,2);
				String conditions = " 1=1 and certino='"+prpLclaimDto.getRegistNo()+"' and serialno='"+serialNo+"' ";
				Collection acciPersonList = new BLPrpLaccipersonFacade().findByConditions(conditions);
				if(acciPersonList !=null && acciPersonList.size()>0){
					Iterator it = acciPersonList.iterator();
					while(it.hasNext()){
						PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)it.next();
						insuredName = prpLacciPersonDto.getAcciName();
					    if("1".equals(prpLacciPersonDto.getSex())){//男
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//女
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//不详
					    	gender = "2";
					    }else{
					    	gender = "2";
					    }
					    credentialType = prpLacciPersonDto.getIdentifyType();//默认身份证
					    credentialNo = prpLacciPersonDto.getIdentifyNumber();
					    if(credentialNo.length()==18){
					    	birthday = credentialNo.substring(6, 14);
					    }else if(credentialNo.length()==15){
					    	birthday = "19"+credentialNo.substring(6, 12);
					    }
					}
				}
				ciAcciSdRiskRequestInDto.setInsuredName(insuredName);
				ciAcciSdRiskRequestInDto.setBirthday(birthday);
				ciAcciSdRiskRequestInDto.setCredentialNo(credentialNo);
				ciAcciSdRiskRequestInDto.setCredentialType(credentialType);
				ciAcciSdRiskRequestInDto.setGender(gender);
				ciAcciSdRiskRequestInDto.setLossDate(lossDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ciAcciSdRiskRequestInDto;
    	
    }
    
    /**
	 * 个人证件类型转换
	 * @param buf
	 * @param encodeVO
	 */
	
	public String transIdentifyType(String IdentifyType) {
		String CredentialType = "";
		if("01".equals(IdentifyType)){
			CredentialType = "01";
		}else if("02".equals(IdentifyType)){
			CredentialType = "02";
		}else if("03".equals(IdentifyType)){
			CredentialType = "07";
		}else if("04".equals(IdentifyType)){
			CredentialType = "04";
		}else if("05".equals(IdentifyType)){
			CredentialType = "03";
		}else if("06".equals(IdentifyType)){
			CredentialType = "11";
		}else if("26".equals(IdentifyType)){
			CredentialType = "14";
		}else{
			CredentialType = "99";
		}
		return CredentialType;
	}
}
