package com.sinosoft.ciplatform.bl.action.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.custom.Iconstants;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��ʱ�����Զ��ϴ�����ƽ̨��
 * @author sinosoft
 * @����ʱ�䣺2010-04-20
 */
public class BLCISYXAutoUploadAction {
	private static Log logger = LogFactory.getLog(BLCISYXAutoUploadAction.class);
	private static final String UPLOADSTARTDATE = "2010-06-21";
	private static BLCISYXAutoUploadAction instance = new BLCISYXAutoUploadAction();
	/**
	 * ���췽��
	 */
	private BLCISYXAutoUploadAction(){
		//��ֹ����
	}
	
	/**
	 * ��ȡʵ��
	 */
	public static BLCISYXAutoUploadAction getInstance(){
		return instance;
	}
	
	/**
	 * ��ʱ�����Զ��ϴ�
	 * @throws Exception
	 */
	public void autoUpload()throws Exception{
		
			BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
			CIPlatformConfigDto cIPlatformConfigDto = bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", "34", "0506");
			if(cIPlatformConfigDto!=null
					&&cIPlatformConfigDto.getUrl()!=null
					&&!"".equals(cIPlatformConfigDto.getUrl())){
				String comCode=cIPlatformConfigDto.getComCode();
				String riskCode=cIPlatformConfigDto.getRiskCode();
				String registDate="2011-06-08";
				Collection dataCollection = new ArrayList();
					//1.�����ϴ�
					dataCollection = findRegistUploadData(comCode,riskCode,registDate);
					BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
					String strPolicyNo =  null;
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						try{
							//strPolicyNo =  blPrpLregistFacade.findByPrimaryKey(uploadData.getRegistNo()).getPolicyNo();
							BLCIClaimSYXPlatFormInterfaceFacade.getInstance().upload(
									Iconstants.ZJRequstType.REGIST_SYX,
										uploadData.getRegistNo(),true,cIPlatformConfigDto,"1","");
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�����ϴ�)�������ţ�" + uploadData.getRegistNo());
							}
						}						
					}
					//2.�����ϴ�
					dataCollection = findClaimUploadData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						
						try{
							
							BLCIClaimSYXPlatFormInterfaceFacade
							.getInstance().upload(Iconstants.ZJRequstType.CLAIM_SYX,
									uploadData.getClaimNo(),
									true,cIPlatformConfigDto,"1","");
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�����ϴ�)�������ţ�" + uploadData.getClaimNo());
							}
						}
					}
					//3.�᰸�ϴ�
					dataCollection = findEndcaseUploadData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						try{
							BLCIClaimSYXPlatFormInterfaceFacade
							.getInstance().upload(Iconstants.ZJRequstType.ENDCASE_SYX,
									uploadData.getClaimNo(),
									true,cIPlatformConfigDto,"1","");
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�᰸�ϴ�)�������ţ�" + uploadData.getClaimNo());
							}
						}
					}
					//4.����ע���ϴ�
					dataCollection = findCancelCaseUploadData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						
						try{
							BLCIClaimSYXPlatFormInterfaceFacade
							.getInstance().upload(Iconstants.ZJRequstType.CANCEL_CASE,
									uploadData.getClaimNo(),
									true,cIPlatformConfigDto,"1","");
							
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(����ע��)�������ţ�" + uploadData.getClaimNo());
							}
						}
					}
					//5.�᰸׷���ϴ�
//					dataCollection = findCaseAppendUploadData(comCode,riskCode);
//					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
//						UploadData uploadData = (UploadData)iter.next();
//						try{
//							BLCIClaimSYXPlatFormInterfaceFacade
//							.getInstance().upload(Iconstants.ZJRequstType.ENDCASE_APPEND_SYX,
//									uploadData.getClaimNo(),
//									true,cIPlatformConfigDto,"1","");
//						}catch(Exception e){
//							e.printStackTrace();
//							if(logger.isDebugEnabled()){
//								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�᰸׷��)�������ţ�" + uploadData.getClaimNo());
//							}
//						}
//					}
					//5.�����ؿ��ϴ�
					dataCollection = findRecaseUploadData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						try{
							BLCIClaimSYXPlatFormInterfaceFacade
							.getInstance().upload(Iconstants.ZJRequstType.RECASE_SYX,
									uploadData.getClaimNo(),uploadData.getSerlalNo(),
									true,cIPlatformConfigDto,"1",uploadData.getCishu(),uploadData.getPolicyNo());
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(�᰸׷��)�������ţ�" + uploadData.getClaimNo());
							}
						}
					}
					//�⸶�Ǽ�-Ԥ��
					dataCollection = findPayRefForPrePayData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						try{
							BLCIClaimSYXPlatFormInterfaceFacade.getInstance().upload(
									Iconstants.ZJRequstType.PAYINFOR_SYX,
									uploadData.getClaimNo(), true,cIPlatformConfigDto,"1",uploadData.getPayrefNo());
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(ʵ���Ǽ�)�������ţ�" + uploadData.getClaimNo());
							}
						}
					}
					//�⸶�Ǽ�-ʵ��
					dataCollection = findPayRefData(comCode,riskCode);
					for(Iterator iter = dataCollection.iterator();iter.hasNext();){
						UploadData uploadData = (UploadData)iter.next();
						try{
							BLCIClaimSYXPlatFormInterfaceFacade.getInstance().upload(
									Iconstants.ZJRequstType.PAYINFOR_SYX,
									uploadData.getClaimNo(), true,cIPlatformConfigDto,"1",uploadData.getPayrefNo());
						}catch(Exception e){
							e.printStackTrace();
							if(logger.isDebugEnabled()){
								logger.debug("����ƽ̨��ʱ�����ϴ�ʧ��(ʵ���Ǽ�)�������ţ�" + uploadData.getClaimNo());
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
		buffer.append("                 And ciclaimdemand.riskcode In (" + strRiskCode + ")         ");
		buffer.append("      )                                                                      ");
		buffer.append("      And prplregist.inputdate > Date '" + registDate + "'         ");
		buffer.append("      And prplregistrpolicy.riskcode In (" + strRiskCode + ")            ");
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
		buffer.append("               And ciclaimdemand.riskcode In (" + strRiskCode + ")   ");
		buffer.append("     )                                                   ");
		buffer.append("     And prplclaim.comcode Like '" + comCode + "%'       ");
		buffer.append("     And prplclaim.riskcode In (" + strRiskCode + ")        ");
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
		buffer.append("               And ciclaimdemand.riskcode In (" + strRiskCode + ")");
		buffer.append("     )                                                        ");
		buffer.append("     And prplclaim.canceldate Is Null                         ");
		buffer.append("     And prplclaim.endcasedate Is Not Null                    ");
		
		buffer.append("     and (not exists (select 1 from prplrecase re              ");
		buffer.append("     where re.claimno = prplclaim.claimno) or not exists (select 1 ");
		buffer.append("     from prplrecase re where re.claimno = prplclaim.claimno and re.closecasedate is null)) ");

		
		buffer.append("     And prplclaim.comcode Like '" + comCode + "%'            ");
		buffer.append("     And prplclaim.riskcode In (" + strRiskCode + ")          ");
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
		buffer.append(" prplregistrpolicy.policyno                                      ");
		buffer.append(" From prplregist,                                                ");
		buffer.append("     prplregistrpolicy,                                          ");
		buffer.append("     prpcmain                                                    ");
		buffer.append("Where prplregist.registno=prplregistrpolicy.registno             ");
		buffer.append("      And prpcmain.policyno=prplregistrpolicy.policyno           ");
		buffer.append("      And exists(                                                ");
		buffer.append("          Select 1 From ciclaimdemand                            ");
		buffer.append("          Where ciclaimdemand.registno=prplregist.registno       ");
		buffer.append("                And ciclaimdemand.registuploadflag='1'           ");
		buffer.append("                And ciclaimdemand.riskcode In (" + strRiskCode + ")  ");
		buffer.append("                And ciclaimdemand.canceluploadflag Is Null       ");
		buffer.append("      )                                                          ");
		buffer.append("      And  prpcmain.comcode Like '" + comCode + "%'              ");		
		buffer.append("      And prplregistrpolicy.validstatus='0'                      ");
		buffer.append("      And prplregistrpolicy.riskcode In (" + strRiskCode + ")    ");
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
		buffer.append("     And prplrecase.flag ='1'                          ");
		buffer.append("     And prplrecase.recaseuploadflag is null                        ");
		buffer.append("     And (exists (select 1                                        ");
		buffer.append("                      from swflog g                               ");
		buffer.append("                     where g.registno = prplclaim.registno        ");
		buffer.append("                       and g.dataflag is null) or exists            ");
		buffer.append("            (select 1                                             ");
		buffer.append("               from swflogstore e                                 ");
		buffer.append("              where e.registno = prplclaim.registno               ");
		buffer.append("                and e.dataflag is null))                            ");
		
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
		buffer.append(" prpjpayrefrec re,prpcitemcar rr                         ");
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
		/*���� */
		private String certiNo = "";
		private int serlalNo = 0;
		//2011�᰸׷�Ӵ���
		private String cishu="";
		//2011���������ϴ��������
		private String claimCode="";
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
		 * @return the certino
		 */
		public String getCertiNo() {
			return certiNo;
		}

		/**
		 * @param certino the certino to set
		 */
		public void setCertiNo(String certiNo) {
			this.certiNo = certiNo;
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

		/**
		 * @return the cishu
		 */
		public String getCishu() {
			return cishu;
		}

		/**
		 * @param cishu the cishu to set
		 */
		public void setCishu(String cishu) {
			this.cishu = cishu;
		}

		/**
		 * @return the claimCode
		 */
		public String getClaimCode() {
			return claimCode;
		}

		/**
		 * @param claimCode the claimCode to set
		 */
		public void setClaimCode(String claimCode) {
			this.claimCode = claimCode;
		}
		
		
	}
}
