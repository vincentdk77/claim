<%--
****************************************************************************
* DESC       ：大病医疗保险自动理赔触发页面
* AUTHOR     ： chu
* CREATEDATE ： 2014-04-17
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="java.util.*" %>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRequest"%>
<%@page import="com.sinosoft.sysframework.reference.DBManager"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterAutoClaimDetail"%>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterRecaseDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<html:html locale="true">
<head>
  <title>大病医疗自动理赔</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<%


Collection prpLinterRequestList = new ArrayList();
BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
UIMedicalAutoClaimViewHelper uiMedicalAutoClaimViewHelper = new UIMedicalAutoClaimViewHelper();
UIMedicalAutoRegistSubViewHelper uiMedicalAutoRegistSubViewHelper = new UIMedicalAutoRegistSubViewHelper();
UIMedicalAutoSchedSubViewHelper uiMedicalAutoSchedSubViewHelper = new UIMedicalAutoSchedSubViewHelper();
UIMedicalAutoCheckSubViewHelper uiMedicalAutoCheckSubViewHelper = new UIMedicalAutoCheckSubViewHelper();
UIMedicalAutoClaimSubViewHelper uiMedicalAutoClaimSubViewHelper = new UIMedicalAutoClaimSubViewHelper();
UIMedicalAutoCertiSubViewHelper uiMedicalAutoCertiSubViewHelper = new UIMedicalAutoCertiSubViewHelper();
UIMedicalAutoCompeSubViewHelper uiMedicalAutoCompeSubViewHelper = new UIMedicalAutoCompeSubViewHelper();
UIMedicalAutoVericSubViewHelper uiMedicalAutoVericSubViewHelper = new UIMedicalAutoVericSubViewHelper();
UIMedicalAutoEndcaSubViewHelper uiMedicalAutoEndcaSubViewHelper = new UIMedicalAutoEndcaSubViewHelper();
BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
String returnStr = "";
String returnStr2 = "";
DBManager dbManager = new DBManager();
try {
	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	String sql =" insert into prplhandletask(registno,nodetype,lossitemcode) values('1','1','1')";
	dbManager.beginTransaction();
	dbManager.executeUpdate(sql);
	dbManager.commitTransaction();
	
	String condition = " mutualflag='1' and not exists (select 1 "+
			" from prplinterrelation rel "+
			" where rel.id = prplinterrequest.id "+
			" and rel.outid = prplinterrequest.outid "+
			" and rel.synchronflag = '1') ";
	
	prpLinterRequestList = blPrpLinterRequestFacade.findByConditionsWithChild(condition);
	
	if(prpLinterRequestList!=null&&!prpLinterRequestList.isEmpty()&&prpLinterRequestList.size()>0){
		Iterator it = prpLinterRequestList.iterator();
		while (it.hasNext()){
			PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto) it.next();
			String id = prpLinterRequestDto.getId();
			
			try{
				boolean startWithZero = false;
				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = null;
				prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
				
				if(prplinterAutoClaimDetailDto==null||!"1".equals(prplinterAutoClaimDetailDto.getRegistSuccFlag())){
					startWithZero = true;
				}
				/***********给中间表重复标识duplicateflag赋值，为1：已处理过的 开始***********/
				//prpLinterRequestDto.setDuplicateFlag("1");
				//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
				//DBPrpLinterRequest dbPrpLinterRequest = new DBPrpLinterRequest(dbManager);
				
				//PrpLinterRequestDto prpLinterRequestTmp = dbPrpLinterRequest.findByPrimaryKey(prpLinterRequestDto.getId());
				//if("1".equals(prpLinterRequestTmp.getDuplicateFlag())){
				//	continue;
				//}
				//dbManager.beginTransaction();
				//dbPrpLinterRequest.update(prpLinterRequestDto);
				//dbManager.commitTransaction();
				/***********给中间表重复标识duplicateflag赋值，为1：已处理过的 结束***********/
				String ClaimAutoFlag = prpLinterRequestDto.getClaimAutoFlag();
			    String CompeAutoFlag = prpLinterRequestDto.getCompeAutoFlag();
			    String RegistAutoFlag = prpLinterRequestDto.getRegistAutoFlag();
				if(startWithZero){
					//uiMedicalAutoClaimViewHelper.autoClaimMain(prpLinterRequestDto);
				    
				    if("1".equals(ClaimAutoFlag)){
				    	
				    	//自动报案方法
						prpLinterRequestDto = new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
						//自动调度
						prpLinterRequestDto = new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
						//自动查勘
						prpLinterRequestDto = new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
						//自动立案
						prpLinterRequestDto = new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
						//单证环节
						prpLinterRequestDto = new UIMedicalAutoCertiSubViewHelper().autoCerti(prpLinterRequestDto);
						//理算环节
						prpLinterRequestDto = new UIMedicalAutoCompeSubViewHelper().autoCompe(prpLinterRequestDto);
						//核赔环节
						prpLinterRequestDto = new UIMedicalAutoVericSubViewHelper().autoVeric(prpLinterRequestDto);
						//结案环节
						prpLinterRequestDto = new UIMedicalAutoEndcaSubViewHelper().autoEndca(prpLinterRequestDto);
						//需要把交互成功的标志值为1：prplinterrelation.SYNCHRONFLAG
						new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
				    }else if(!"1".equals(ClaimAutoFlag)&&"1".equals(CompeAutoFlag)){
				    	//自动报案方法
						prpLinterRequestDto = new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
						//自动调度
						prpLinterRequestDto = new UIMedicalAutoSchedSubViewHelper().autoSched(prpLinterRequestDto);
						//自动查勘
						prpLinterRequestDto = new UIMedicalAutoCheckSubViewHelper().autoCheck(prpLinterRequestDto);
						//自动立案
						prpLinterRequestDto = new UIMedicalAutoClaimSubViewHelper().autoClaim(prpLinterRequestDto);
				    }else if(!"1".equals(CompeAutoFlag)&&"1".equals(RegistAutoFlag)){
				    	prpLinterRequestDto = new UIMedicalAutoRegistSubViewHelper().autoRegist(prpLinterRequestDto);
				    }
				}else{
					if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getSchedSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoSchedSubViewHelper.autoSched(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCheckSubViewHelper.autoCheck(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCertiSubViewHelper.autoCerti(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCompeSubViewHelper.autoCompe(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}else if(!"1".equals(ClaimAutoFlag)&&"1".equals(CompeAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoSchedSubViewHelper.autoSched(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCheckSubViewHelper.autoCheck(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto); 
						}else if(!"1".equals(CompeAutoFlag)&&"1".equals(RegistAutoFlag)){
							 
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getCheckSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoCheckSubViewHelper.autoCheck(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCertiSubViewHelper.autoCerti(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCompeSubViewHelper.autoCompe(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}else if(!"1".equals(ClaimAutoFlag)&&"1".equals(CompeAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoCheckSubViewHelper.autoCheck(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto);
						}else if(!"1".equals(CompeAutoFlag)&&"1".equals(RegistAutoFlag)){
							 
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getClaimSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCertiSubViewHelper.autoCerti(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCompeSubViewHelper.autoCompe(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}else if(!"1".equals(ClaimAutoFlag)&&"1".equals(CompeAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoClaimSubViewHelper.autoClaim(prpLinterRequestDto);
						}else if(!"1".equals(CompeAutoFlag)&&"1".equals(RegistAutoFlag)){
							 
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getCertiSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoCertiSubViewHelper.autoCerti(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoCompeSubViewHelper.autoCompe(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}else if(!"1".equals(ClaimAutoFlag)&&"1".equals(CompeAutoFlag)){
					
						}else if(!"1".equals(CompeAutoFlag)&&"1".equals(RegistAutoFlag)){
							 
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getComppSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoCompeSubViewHelper.autoCompe(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getVericSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoVericSubViewHelper.autoVeric(prpLinterRequestDto);
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}
					}else if(prplinterAutoClaimDetailDto!=null&&!"1".equals(prplinterAutoClaimDetailDto.getEndcaSuccFlag())){
						if("1".equals(ClaimAutoFlag)){
							prpLinterRequestDto = uiMedicalAutoEndcaSubViewHelper.autoEndca(prpLinterRequestDto);
							new BLPrplinterrelationFacade().finishSynchron(prpLinterRequestDto);
						}
					}
				}
				String registNotemp = prpLinterRequestDto.getRelationRegistNo();
				returnStr=returnStr+"“"+ registNotemp+"”，";
				
			}catch(Exception e ){
				e.printStackTrace();
				returnStr2=returnStr2+"“"+id+"”，";
			}
		}
	}
	String sqlDel =" delete from prplhandletask where registno='1' and nodetype='1' and lossitemcode='1'";
	dbManager.beginTransaction();
	dbManager.executeUpdate(sqlDel);
	dbManager.commitTransaction();
} catch (Exception e) {
	dbManager.rollbackTransaction();
	e.printStackTrace();
}finally{
	dbManager.close();
}


Collection prpLinterRecaseRequestList = new ArrayList();
BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
DBManager dbManager2 = new DBManager();
try {
	dbManager2.open(AppConfig.get("sysconst.DBJNDI"));
	String sql =" insert into prplhandletask(registno,nodetype,lossitemcode) values('2','2','2')";
	dbManager2.beginTransaction();
	dbManager2.executeUpdate(sql);
	dbManager2.commitTransaction();
	
	String condition = " mutualflag='1' and not exists (select 1 "+
			" from prplinterrecasedetail detail "+
			" where detail.id = prplinterrecaserequest.id "+
			" and detail.endcasuccflag = '1')";
	
	prpLinterRecaseRequestList = blPrpLinterRecaseRequestFacade.findByConditionsWithChild(condition);
	
	if(prpLinterRecaseRequestList!=null&&!prpLinterRecaseRequestList.isEmpty()&&prpLinterRecaseRequestList.size()>0){
		Iterator iter = prpLinterRecaseRequestList.iterator();
		while (iter.hasNext()){
			PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) iter.next();
			//数据转换，获取前期的关联数据
			prpLinterRecaseRequestDto = new UIMedicalClaimRecaseViewHelper().getRecaseDtoMain(prpLinterRecaseRequestDto);
			String id = prpLinterRecaseRequestDto.getId();
			try{
				boolean startWithZero = false;
				PrpLinterRecaseDetailDto prpLinterRecaseDetailDto = null;
				prpLinterRecaseDetailDto = prpLinterRecaseRequestDto.getPrpLinterRecaseDetailDto();
				System.out.println("!!!!!!!!!!!开始重开赔案!!!!!!!!!!"+prpLinterRecaseRequestDto.getId());
				/**********************************/
				if(prpLinterRecaseDetailDto==null||!"1".equals(prpLinterRecaseDetailDto.getRecaseSuccFlag())){
					startWithZero = true;
				}
				if(startWithZero){
					//重开申请环节
					prpLinterRecaseRequestDto = new UIMedicalAutoRecaseSubViewHelper().autoRecase(prpLinterRecaseRequestDto);
					//重开审批
					prpLinterRecaseRequestDto = new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
					//理算环节
					prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoCompeSubViewHelper().autoCompeRecase(prpLinterRecaseRequestDto);
					//核赔环节
					prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
					//结案环节
					prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
				}else{
					if(prpLinterRecaseDetailDto!=null&&!"1".equals(prpLinterRecaseDetailDto.getAppovlSuccFlag())){
						//重开审批
						prpLinterRecaseRequestDto = new UIMedicalAutoRecaseApprovSubViewHelper().autoRecaseApprov(prpLinterRecaseRequestDto);
						//理算环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoCompeSubViewHelper().autoCompeRecase(prpLinterRecaseRequestDto);
						//核赔环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
						//结案环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
					}else if(prpLinterRecaseDetailDto!=null&&!"1".equals(prpLinterRecaseDetailDto.getComppSuccFlag())){
						//理算环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoCompeSubViewHelper().autoCompeRecase(prpLinterRecaseRequestDto);
						//核赔环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
						//结案环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
					}else if(prpLinterRecaseDetailDto!=null&&!"1".equals(prpLinterRecaseDetailDto.getVericSuccFlag())){
						//核赔环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoVericSubViewHelper().autoVericRecase(prpLinterRecaseRequestDto);
						//结案环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
					}else if(prpLinterRecaseDetailDto!=null&&!"1".equals(prpLinterRecaseDetailDto.getEndcaSuccFlag())){
						//结案环节
						prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto) new UIMedicalAutoEndcaSubViewHelper().autoEndcaRecase(prpLinterRecaseRequestDto);
					}
				}
				
				String registNotemp = prpLinterRecaseRequestDto.getRelationRegistNo();
				returnStr=returnStr+"“"+ registNotemp+"”，";
				
			}catch(Exception e ){
				e.printStackTrace();
				returnStr2=returnStr2+"“"+id+"”，";
			}
		}
	}
	String sqlDel =" delete from prplhandletask where registno='2' and nodetype='2' and lossitemcode='2'";
	dbManager2.beginTransaction();
	dbManager2.executeUpdate(sqlDel);
	dbManager2.commitTransaction();
} catch (Exception e) {
	dbManager2.rollbackTransaction();
	e.printStackTrace();
}finally{
	dbManager2.close();
}

%>

<body  >
<form name="fm" action=""  method="post"  target ="sub">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=2 class="formtitle">大病医疗自动理赔</td></tr>
        <tr>
        <td class='button' colspan=2>
          	案件（<%=returnStr %>） 交互成功
        </td>
      </tr>
      <tr>
        <td class='button' colspan=2>
          id（<%=returnStr2 %> ）同步失败
        </td>
      </tr>
    </table>
  </form>
</body>
</html:html>



