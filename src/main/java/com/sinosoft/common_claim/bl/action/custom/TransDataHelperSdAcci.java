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
 * ɽ�������շ���Ԥ��ƽ̨���ݷ�װ��
 * @author Administrator
 *
 */
public class TransDataHelperSdAcci {
	/**
	 * �����Ǽǽӿڱ������ݷ�װ
	 * @throws SQLException 
	 */
	public CIAcciSdClaimRequestInDto getClaim(DBManager dbManager,String claimNo,String serialNo,String groupFlag) throws SQLException{
		CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto = new CIAcciSdClaimRequestInDto();
		String claimNumber = "";//������
		String groupClaimNo = "";//�����ⰸ��
		String claimType = "";//�ⰸ����
		Date claimDate = null;//��������
		Date lossDate = null;//��������
		String lossCause = "";//����ԭ��
		String lossArea = "";//���յص�
		String name = "";//����������
		String gender = "";//�������Ա�
		String birthday = "";;//�����˳�������
		String credentialType = "";//������֤������
		String credentialNo = "";//������֤������
		String lossResult = "";//���ս��
		Date lossResultDate = null;//���ս������
		String isCancelClaim = "";//�Ƿ�������
		Date cancelDate = null;//������������
		ResultSet resultSet = null;
		String identifytype = "";
	    try {
			PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(claimNo);
			if(prpLclaimDto !=null){
				if("1".equals(groupFlag)){
					claimNumber = prpLclaimDto.getClaimNo()+"-"+serialNo;
					groupClaimNo = prpLclaimDto.getClaimNo();
					claimType = "01";//�����ⰸ
					credentialType = "01";//Ĭ�����֤
				}else if("0".equals(groupFlag)){
					claimNumber = prpLclaimDto.getClaimNo();
					claimType = "02";//�����ⰸ
					String strSql = "SELECT identifytype from prpcinsured  WHERE policyno='"+prpLclaimDto.getPolicyNo()+"' AND insuredflag='1'";
					resultSet = dbManager.executeQuery(strSql);
					while(resultSet.next()){
						identifytype = resultSet.getString(1);
					}
					credentialType = transIdentifyType(identifytype);
				}
				claimDate = prpLclaimDto.getClaimTime();
				lossDate = prpLclaimDto.getDamageStartDate();
				if(prpLclaimDto.getDamageName().indexOf("����")>-1){
					lossCause = "01";//����
				}else{
					lossCause = "99";//����
				}
				lossArea = prpLclaimDto.getDamageAddress();
				if(prpLclaimDto.getDamageTypeName().indexOf("���")>-1){
					lossResult = "01";//���
				}else if(prpLclaimDto.getDamageTypeName().indexOf("�߲�")>-1){
					lossResult = "02";//�߲�
				}else if(prpLclaimDto.getDamageTypeName().indexOf("�˲�")>-1){
					lossResult = "03";//�˲�
				}else{
					lossResult = "99";//����
				}
				lossResultDate = prpLclaimDto.getClaimTime();
				if(prpLclaimDto.getCancelDate().toString()==null || "".equals(prpLclaimDto.getCancelDate().toString())){
					isCancelClaim = "0";//��
				}else{
					isCancelClaim = "1";//��
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
					    if("1".equals(prpLacciPersonDto.getSex())){//��
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//Ů
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//����
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
	 * �᰸�Ǽǽӿڱ������ݷ�װ
	 * @throws SQLException 
	 */
    public CIAcciSdEndcaseRequestInDto getEndcase(DBManager dbManager,String claimNo,String serialNo,String groupFlag,String acciName) throws SQLException{
    	CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto = new CIAcciSdEndcaseRequestInDto();
    	String claimNumber = "";//������
		String groupClaimNo = "";//�����ⰸ��
		String claimType = "";//�ⰸ����
		Date claimDate = null;//��������
		Date lossDate = null;//��������
		String lossCause = "";//����ԭ��
		String lossArea = "";//���յص�
		String name = "";//����������
		String gender = "";//�������Ա�
		String birthday = "";//�����˳�������
		String credentialType = "";//������֤������
		String credentialNo = "";//������֤������
		String lossResult = "";//���ս��
		Date lossResultDate = null;//���ս������
		Date endcaseDate = null;//�᰸����
		double sumPaid = 0d;//�������
		String caseResult = "";//�������
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
					claimType = "01";//�����ⰸ
					credentialType = "01";//Ĭ�����֤
				}else{
					claimNumber = prpLclaimDto.getClaimNo();
					claimType = "02";//�����ⰸ
					String certiSql = "SELECT identifytype from prpcinsured  WHERE policyno='"+prpLclaimDto.getPolicyNo()+"' AND insuredflag='1'";
					resultSet2 = dbManager.executeQuery(certiSql);
					while(resultSet2.next()){
						identifytype = resultSet2.getString(1);
					}
					credentialType = transIdentifyType(identifytype);
				}
				claimDate = prpLclaimDto.getClaimTime();
				lossDate = prpLclaimDto.getDamageStartDate();
				if(prpLclaimDto.getDamageName().indexOf("����")>-1){
					lossCause = "01";//����
				}else{
					lossCause = "99";//����
				}
				lossArea = prpLclaimDto.getDamageAddress();
				if(prpLclaimDto.getDamageTypeName().indexOf("���")>-1){
					lossResult = "01";//���
				}else if(prpLclaimDto.getDamageTypeName().indexOf("�߲�")>-1){
					lossResult = "02";//�߲�
				}else if(prpLclaimDto.getDamageTypeName().indexOf("�˲�")>-1){
					lossResult = "03";//�˲�
				}else{
					lossResult = "99";//����
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
					caseResult = "01";//����
				}else if(prpLclaimDto.getCancelDate().toString()!=null && "1".equals(prpLclaimDto.getCaseType())){
					caseResult = "04";//����
				}else{
					caseResult = "99";//����
				}
				String conditions = " 1=1 and certino='"+prpLclaimDto.getRegistNo()+"' and serialno='"+serialNo+"' ";
				Collection acciPersonList = new BLPrpLaccipersonFacade().findByConditions(conditions);
				if(acciPersonList !=null && acciPersonList.size()>0){
					Iterator it = acciPersonList.iterator();
					while(it.hasNext()){
						PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)it.next();
						name = prpLacciPersonDto.getAcciName();
					    if("1".equals(prpLacciPersonDto.getSex())){//��
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//Ů
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//����
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
				//������Ϣ��������Ϣ
				CIAcciSdEndcasePolicyInfoDto ciAcciSdEndcasePolicyInfoDto = new CIAcciSdEndcasePolicyInfoDto();
				ciAcciSdEndcasePolicyInfoDto.setPolicyNo(prpLclaimDto.getPolicyNo());
				//ciAcciSdEndcaeCoverageInfoDto.setComCoverageCode(prpLclaimDto.getRiskCode());
				//ciAcciSdEndcaeCoverageInfoDto.setCovClaimAmount(sumPaid);//�����⸶���
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
								ciAcciSdEndcaeCoverageInfoDto.setCovClaimAmount(kindCodeAmount[k]);//�����⸶��� ��Ӧҵ��ϵͳ���ձ��⸶���
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
     * ������ղ�ѯ�ӿ�
     */
    public CIAcciSdRiskRequestInDto getRiskInformation(DBManager dbManager,String claimNo,String serialNo){
    	CIAcciSdRiskRequestInDto ciAcciSdRiskRequestInDto = new CIAcciSdRiskRequestInDto();
    	String insuredName = "";//����������
    	String gender = "";//�������Ա�
    	String birthday = "";//�����˳�������
    	String credentialType = "";//������֤������
    	String credentialNo = "";//������֤������
    	String lossDate = "";//��������
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
					    if("1".equals(prpLacciPersonDto.getSex())){//��
					    	gender = "0";
					    }else if("2".equals(prpLacciPersonDto.getSex())){//Ů
					    	gender = "1";
					    }else if("9".equals(prpLacciPersonDto.getSex())){//����
					    	gender = "2";
					    }else{
					    	gender = "2";
					    }
					    credentialType = prpLacciPersonDto.getIdentifyType();//Ĭ�����֤
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
	 * ����֤������ת��
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
