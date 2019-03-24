package com.sinosoft.claimciplatform.bl.action.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.bz.common.BZAppConfig;
import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.action.custom.BLCISYXAutoUploadAction;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��ʱ�����Զ��ϴ�����ƽ̨��
 * @author sinosoft
 * @����ʱ�䣺2010-04-20
 */
public class BLCIAutoUploadAction {
	private static Log logger = LogFactory.getLog(BLCIAutoUploadAction.class);
	private static final String UPLOADSTARTDATE = "2010-06-21";
	private static BLCIAutoUploadAction instance = new BLCIAutoUploadAction();
	/**
	 * ���췽��
	 */
	private BLCIAutoUploadAction(){
		//��ֹ����
	}
	
	/**
	 * ��ȡʵ��
	 */
	public static BLCIAutoUploadAction getInstance(){
		return instance;
	}
	
	/**
	 * ��ʱ�����Զ��ϴ�
	 * @throws Exception
	 */
	public void autoUpload()throws Exception{
		//1.ѭ����ʡ��
		Map comMap = BZAppConfig.getUrlMap();
		for(Iterator i = comMap.keySet().iterator(); i.hasNext();){
			String comCode = (String)i.next();
			PlatFormParam platFormParam = new PlatFormParam();
			platFormParam.setComCode(comCode);
			platFormParam.setUrl(BZAppConfig.getProperty(comCode, "URL"));
			platFormParam.setUseFlag(BZAppConfig.getProperty(comCode, "USEFLAG"));
			platFormParam.setRiskcode(BZAppConfig.getProperty(comCode, "RISKCODE"));
			platFormParam.setRegistDate(BZAppConfig.getProperty(comCode, "REGISTDATE"));
			boolean isUpload = false;
			if("Y".equals(platFormParam.getUseFlag())){
				Collection dataCollection = new ArrayList();
				//1.�����ϴ�
				dataCollection = findRegistUploadData(comCode,platFormParam.getRiskcode(),platFormParam.getRegistDate());
				BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
				String strPolicyNo =  null;
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					try{
						strPolicyNo =  blPrpLregistFacade.findByPrimaryKey(uploadData.getRegistNo()).getPolicyNo();
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForRegist(strPolicyNo, uploadData.getRegistNo());
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.REGIST_SIGN,
									uploadData.getRegistNo(),"", true,"1");
						}
						
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�����ϴ�)�������ţ�" + uploadData.getRegistNo());
						}
					}
					
				}
				//2.�����ϴ�
				dataCollection = findClaimUploadData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					
					try{
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaim(uploadData.getClaimNo());
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CLAIM_SIGN,
									uploadData.getClaimNo(), "",true,"1");
						}
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�����ϴ�)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
				//3.�᰸�ϴ�
				dataCollection = findEndcaseUploadData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					try{
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForEndCase(uploadData.getClaimNo());
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.ENDCASE_SIGN,
									uploadData.getClaimNo(), "",true,"1");
						}
						
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�᰸�ϴ�)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
				//4.����ע���ϴ�
				dataCollection = findCancelCaseUploadData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					
					try{
						if(uploadData.getClaimNo().indexOf("5") == 0){
							//����ע��
							isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaimCancel(uploadData.getPolicyNo(), uploadData.getRegistNo());
						}else{
							//����ע��
							isUpload = true;
						}
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CASE_CANCEL,
									uploadData.getClaimNo(),"", true,"1");
						}
						
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(����ע��)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
//				//5.�᰸׷���ϴ�
////				dataCollection = findCaseAppendUploadData(comCode,platFormParam.getRiskcode());
////				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
////					UploadData uploadData = (UploadData)iter.next();
////					try{
////						BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
////								RequestType.ENDCASE_APPEND,
////								uploadData.getClaimNo(), "",true,"1");
////					}catch(Exception e){
////						e.printStackTrace();
////						if(logger.isDebugEnabled()){
////							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�᰸׷��)�������ţ�" + uploadData.getClaimNo());
////						}
////					}
////				}
				//5.�����ؿ��ϴ�
				dataCollection = findRecaseUploadData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					try{
						BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
								RequestType.RECASE_SIGN,
								uploadData.getClaimNo(), uploadData.getSerlalNo(),"",true,"1","");
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�����ؿ�)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
				//�⸶�Ǽ�-Ԥ��
				dataCollection = findPayRefForPrePayData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					try{
						BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
								RequestType.CASE_PAYREF,
								uploadData.getClaimNo(), uploadData.getPayrefNo(),true,"1");
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(ʵ���Ǽ�)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
				//�⸶�Ǽ�-ʵ��
				dataCollection = findPayRefData(comCode,platFormParam.getRiskcode());
				for(Iterator iter = dataCollection.iterator();iter.hasNext();){
					UploadData uploadData = (UploadData)iter.next();
					try{
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForPayref(uploadData.getClaimNo());
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CASE_PAYREF,
									uploadData.getClaimNo(), uploadData.getPayrefNo(),true,"1");
						}
						
					}catch(Exception e){
						e.printStackTrace();
						if(logger.isDebugEnabled()){
							logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(ʵ���Ǽ�)�������ţ�" + uploadData.getClaimNo());
						}
					}
				}
			}
		}
		
	}
	
	/**
	 * �����Զ��ϴ�
	 * @throws Exception
	 */
	public void registUpload()throws Exception{
		
	}
	
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨�ı�������
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findRegistUploadData(String comCode,String riskCode,String registDate)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("Select prplregistrpolicy.registno From prpcmain,			                   	");
		buffer.append("  prplregist,                                                                ");
		buffer.append("  prplregistrpolicy,                                                          ");
		buffer.append("  prpcitemcar                                                                ");
		buffer.append("Where prpcmain.policyno=prplregistrpolicy.policyno                           ");
		buffer.append(" 	 And prpcitemcar.policyno=prplregistrpolicy.policyno					");
		buffer.append(" 	 And prpcitemcar.carkindcode Not Like 'M%'          					");
		buffer.append(" 	 And prpcitemcar.carkindcode Not Like 'J%'          					");
		buffer.append("      And prplregist.registno=prplregistrpolicy.registno                     ");
		buffer.append("      And  prpcmain.comcode Like '" + comCode + "%'                          ");
		buffer.append("      And Not exists(                                                        ");
		buffer.append("          Select 1 From ciclaimdemand                                        ");
		buffer.append("                 Where ciclaimdemand.registno=prplregistrpolicy.registno     ");
		buffer.append("                 And ciclaimdemand.registuploadflag='1'                      ");
		buffer.append("      			And ciclaimdemand.riskcode In (" + strRiskCode + ")         ");
		buffer.append("      )                                                                      ");
		buffer.append("      And prplregistrpolicy.riskcode in (" + strRiskCode + ")                                                                      ");
		buffer.append("      And prplregist.inputdate > Date '" + registDate + "'         ");
		buffer.append("      and (exists (select 1                                        ");
		buffer.append("                      from swflog g                                ");
		buffer.append("                     where g.registno = prplregist.registno        ");
		buffer.append("                       and g.dataflag is null) or exists           ");
		buffer.append("            (select 1                                              ");
		buffer.append("               from swflogstore e                                  ");
		buffer.append("              where e.registno = prplregist.registno               ");
		buffer.append("                and e.dataflag is null))                           ");

		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setRegistNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨����������
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findClaimUploadData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("Select prplclaim.claimno From prplclaim,                 ");
		buffer.append("     prplclaimstatus                                     ");
		buffer.append("Where prplclaim.claimno=prplclaimstatus.businessno       ");
		buffer.append("     And prplclaimstatus.nodetype='claim'                ");
		buffer.append("     And prplclaimstatus.status='4'                      ");
		buffer.append("     And  exists(                                        ");
		buffer.append("         Select 1 From ciclaimdemand                     ");
		buffer.append("         Where ciclaimdemand.registNo=prplclaim.registNo   ");
		buffer.append("               And ciclaimdemand.claimuploadflag Is Null ");
		buffer.append("               And ciclaimdemand.registuploadflag='1'    ");
		buffer.append("     		  And ciclaimdemand.riskcode In (" + strRiskCode + ")   ");
		buffer.append("     )                                                   ");
		buffer.append("     And prplclaim.comcode Like '" + comCode + "%'       ");
		buffer.append("     And prplclaim.riskcode in (" + strRiskCode  + ")      ");
		buffer.append("      and (exists (select 1                                       ");
		buffer.append("                      from swflog g                               ");
		buffer.append("                     where g.registno = prplclaim.registno        ");
		buffer.append("                       and g.dataflag is null) or exists          ");
		buffer.append("            (select 1                                             ");
		buffer.append("               from swflogstore e                                 ");
		buffer.append("              where e.registno = prplclaim.registno               ");
		buffer.append("                and e.dataflag is null))                          ");
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨�Ľ᰸����
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findEndcaseUploadData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("Select prplclaim.claimno From prplclaim     	                 ");
		buffer.append("Where  exists(                                                ");
		buffer.append("         Select 1 From ciclaimdemand                          ");
		buffer.append("         Where ciclaimdemand.claimno=prplclaim.claimno        ");
		buffer.append("               And ciclaimdemand.endcaseuploadflag Is Null    ");
		buffer.append("               And ciclaimdemand.claimuploadflag='1'          ");
		buffer.append("     		  And ciclaimdemand.riskcode In (" + strRiskCode + ")        ");
		buffer.append("     )                                                        ");
		buffer.append("     And prplclaim.canceldate Is Null                         ");
		buffer.append("     And prplclaim.endcasedate Is Not Null                    ");
		
		buffer.append("     and (not exists (select 1 from prplrecase re              ");
		buffer.append("     where re.claimno = prplclaim.claimno) or not exists (select 1 ");
		buffer.append("     from prplrecase re where re.claimno = prplclaim.claimno and re.closecasedate is null)) ");

		
		buffer.append("     And prplclaim.comcode Like '" + comCode + "%'            ");
		buffer.append("      and (exists (select 1                                       ");
		buffer.append("                      from swflog g                               ");
		buffer.append("                     where g.registno = prplclaim.registno        ");
		buffer.append("                       and g.dataflag is null) or exists          ");
		buffer.append("            (select 1                                             ");
		buffer.append("               from swflogstore e                                 ");
		buffer.append("              where e.registno = prplclaim.registno               ");
		buffer.append("                and e.dataflag is null))                          ");
		
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨�İ���ע������
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findCancelCaseUploadData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("Select 	                                                      	");
		buffer.append(" decode(prplregistrpolicy.claimno,Null,                          ");
		buffer.append(" prplregistrpolicy.registno,                                     ");
		buffer.append(" prplregistrpolicy.claimno) As bussinessNo,                      ");
		buffer.append(" prplregistrpolicy.policyno,                                     ");
		buffer.append(" prplregistrpolicy.registno                                      ");
		buffer.append(" From prplregist,                                                ");
		buffer.append("     prplregistrpolicy,                                          ");
		buffer.append("     prpcmain                                                    ");
		buffer.append("Where prplregist.registno=prplregistrpolicy.registno             ");
		buffer.append("      And prpcmain.policyno=prplregistrpolicy.policyno           ");
		buffer.append("      And exists(                                                ");
		buffer.append("          Select 1 From ciclaimdemand                            ");
		buffer.append("          Where ciclaimdemand.registno=prplregist.registno       ");
		buffer.append("                And ciclaimdemand.registuploadflag='1'           ");
		buffer.append("                And ciclaimdemand.canceluploadflag Is Null       ");
		buffer.append("      		   And ciclaimdemand.riskcode In (" + strRiskCode + ")  ");
		buffer.append("      )                                                          ");
		buffer.append("      And  prpcmain.comcode Like '" + comCode + "%'              ");
		buffer.append("      And prplregistrpolicy.validstatus='0'                      ");
		buffer.append("      And prplregistrpolicy.riskcode in (" + strRiskCode + ")    ");
		buffer.append("      and (exists (select 1                                      ");
		buffer.append("                      from swflog g                              ");
		buffer.append("                     where g.registno = prplregist.registno      ");
		buffer.append("                       and g.dataflag is null) or exists         ");
		buffer.append("            (select 1                                            ");
		buffer.append("               from swflogstore e                                ");
		buffer.append("              where e.registno = prplregist.registno             ");
		buffer.append("                and e.dataflag is null))                         ");
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				uploadData.setPolicyNo(dbManager.getString(resultSet, 2));
				uploadData.setRegistNo(dbManager.getString(resultSet, 3));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨�Ľ᰸׷������
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findCaseAppendUploadData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		
		buffer.append("Select a.claimno From (																		");
		buffer.append("       Select ca.claimno,Count(*) As casecount             ");
		buffer.append("       From prplrecase ca,                                 ");
		buffer.append("            prplclaim cl                                   ");
		buffer.append("       Where ca.claimno=cl.claimno                         ");
		buffer.append("       And cl.comcode Like '" + comCode + "%'              ");
		buffer.append("       And cl.riskcode In (" + strRiskCode + ")            ");
		buffer.append("       And ca.closecasedate Is Not Null                    ");
		buffer.append("       Group By ca.claimno                                 ");
		buffer.append(") a,                                                       ");
		buffer.append("(      Select g.businessno As claimno,Count(*) As casecount"); 
		buffer.append("       From ciclaimuploadlog g                             ");
		buffer.append("       Where g.uploadtype In ('52','53')                   ");
		buffer.append("       And g.flag=1                                        ");
		buffer.append("       Group By  g.businessno                              ");
		buffer.append(" ) b                                                       ");
		buffer.append("Where a.claimno=b.claimno                                  ");
		buffer.append("And a.casecount>=b.casecount								  ");
		buffer.append(" and (exists (select 1                                     ");
		buffer.append("                      from swflog g                         ");
		buffer.append("                     where g.businessno = a.claimno         ");
		buffer.append("                       and g.dataflag is null) or exists    ");
		buffer.append("            (select 1                                       ");
		buffer.append("               from swflogstore e                           ");
		buffer.append("              where e.businessno = a.claimno                ");
		buffer.append("                and e.dataflag is null))                    ");

		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨�İ����ؿ�
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findRecaseUploadData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("Select prplrecase.claimno,prplrecase.serialno From prplrecase,prplclaim                 ");
		buffer.append("     Where prplclaim.claimno= prplrecase.claimno                  ");
		buffer.append("     And prplclaim.comcode Like '" + comCode + "%'                ");
		buffer.append("     And prplclaim.riskcode In (" + strRiskCode + ")              ");
		buffer.append("     And prplrecase.closecasedate is null                           ");
		buffer.append("     And (prplrecase.flag ='1'  or    prplrecase.flag is null)        ");
		buffer.append("     And prplrecase.recaseuploadflag is null                        ");
		buffer.append(" and (exists (select 1                                     ");
		buffer.append("                      from swflog g                         ");
		buffer.append("                     where g.businessno = prplclaim.claimno         ");
		buffer.append("                       and g.dataflag is null) or exists    ");
		buffer.append("            (select 1                                       ");
		buffer.append("               from swflogstore e                           ");
		buffer.append("              where e.businessno = prplclaim.claimno                ");
		buffer.append("                and e.dataflag is null))                    ");
		
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				uploadData.setSerlalNo(dbManager.getInt(resultSet, 2));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	
	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨���⸶�Ǽ�(Ԥ��)����
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findPayRefForPrePayData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		
		buffer.append(" select Distinct y.claimno,re.payrefno From prplprepay y, ");
		buffer.append(" prpjpayrefrec re                                         ");
		buffer.append(" Where re.certino=y.precompensateno                       ");
		buffer.append(" And re.comcode Like '" + comCode + "%'                   ");
		buffer.append(" And y.riskcode  In (" + strRiskCode + ")                 ");
		buffer.append(" And y.underwriteflag In ('1','3')                        ");
		buffer.append(" And y.payrefdate Is Not Null                             ");
		buffer.append(" And y.uploadserialno Is Null                             ");
		
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				uploadData.setPayrefNo(dbManager.getString(resultSet, 2));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	
	
	

	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨���⸶�Ǽ�(ʵ��)����
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public Collection findPayRefData(String comCode,String riskCode)throws Exception{
		String[] arrRiskCode = riskCode.split(",");
		String   strRiskCode = "";
		for(int i = 0; i < arrRiskCode.length; i++){
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0,strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		
		buffer.append(" select Distinct y.claimno,re.payrefno From prplcompensate y, ");
		buffer.append(" prpjpayrefrec re,prpcitemcar rr                              ");
		buffer.append(" Where re.certino=y.compensateno                       ");
		buffer.append(" And re.comcode Like '" + comCode + "%'                   ");
		buffer.append(" And y.riskcode  In (" + strRiskCode + ")                 ");
		buffer.append(" And y.underwriteflag In ('1','3')                        ");
		buffer.append(" And y.payrefdate Is Not Null                             ");
		buffer.append(" And y.uploadserialno Is Null                             ");
		buffer.append(" And rr.carkindcode Not like 'M%'                         ");
		buffer.append(" And rr.carkindcode Not like 'J%'                         ");
		buffer.append(" And rr.policyno = y.policyno                             ");
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			resultSet = dbManager.executeQuery(strWhere);
			while(resultSet.next()){
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				uploadData.setPayrefNo(dbManager.getString(resultSet, 2));
				resultList.add(uploadData);
			}
		}catch(Exception exception){
            throw exception;
        }finally{
        	if(resultSet != null){
        		resultSet.close();
        	}
            dbManager.close();
        }
		return resultList;
	}
	
	
	
	
	
	
	/**
	 * ��ѯ����Ҫ�ϴ���������
	 * @author sinosoft
	 *
	 */
	private class UploadData{
		/*���� ������*/
		private String registNo = "";
		/*���� ������*/
		private String claimNo = "";
		/*���� ������*/
		private String policyNo = "";
		/*���� ֧������*/
		private String payrefNo = "";
		/*���� �ؿ��ⰸ���*/
		private int serlalNo = 0;
		public UploadData(){
			
		}

		/**
		 * ��ȡ���� registNo
		 * @return the registNo
		 */
		public String getRegistNo() {
			return registNo;
		}

		/**
		 * �������� registNo
		 * @param registNo the registNo to set
		 */
		public void setRegistNo(String registNo) {
			this.registNo = registNo;
		}

		/**
		 * ��ȡ���� claimNo
		 * @return the claimNo
		 */
		public String getClaimNo() {
			return claimNo;
		}

		/**
		 * �������� claimNo
		 * @param claimNo the claimNo to set
		 */
		public void setClaimNo(String claimNo) {
			this.claimNo = claimNo;
		}

		public String getPolicyNo() {
			return policyNo;
		}

		public void setPolicyNo(String policyNo) {
			this.policyNo = policyNo;
		}

		public String getPayrefNo() {
			return payrefNo;
		}

		public void setPayrefNo(String payrefNo) {
			this.payrefNo = payrefNo;
		}

		/**
		 * @return the serlalNo
		 */
		public int getSerlalNo() {
			return serlalNo;
		}

		/**
		 * @param serlalNo the serlalNo to set
		 */
		public void setSerlalNo(int serlalNo) {
			this.serlalNo = serlalNo;
		}
		
		
	}
}
