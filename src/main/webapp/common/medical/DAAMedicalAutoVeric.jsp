<%--
****************************************************************************
* DESC       ：大病医疗保险自动理赔触发页面
* AUTHOR     ： Pao
* CREATEDATE ： 2014-12-25
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

<%@page import="com.sinosoft.utility.SysConfig"%>
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
String strConditions = "";
String ClaimVericUploadRiskCode = SysConfig.getProperty("ClaimVericUploadRiskCode","claim");
if(!"".equals(ClaimVericUploadRiskCode)){
	strConditions = "  and m.registno ='"+ClaimVericUploadRiskCode+"'";
}

try {
	String condition = " select e.compensateno,e.claimno,m.registno ,w.submittime "+
					   " 	from prplcompensate e, swflog g, prplclaim m, gyic.wflogstore w "+
					   "   where e.compensateno = g.businessno    "+
					   " 	 and e.claimno = m.claimno            "+
					   " 	 and w.businessno = e.compensateno    "+
					   " 	 and w.nodename = '审核通过'            "+
					   "     and e.underwriteflag in ('1', '3')   "+
					   " 	 and g.nodetype = 'veric'             "+
					   " 	 and g.nodestatus not in ('5', '4')   "+
					  // "     and m.registno ='428013412222014000018'"+
					   strConditions +
					   "     and m.riskcode in ('2801') "+
					   "     order by m.registno";
	
	prpLinterRequestList = blPrpLinterRequestFacade.findBySQL(condition);
	
	
	System.err.println("prpLinterRequestList==="+prpLinterRequestList.size());
	if(prpLinterRequestList!=null&&!prpLinterRequestList.isEmpty()&&prpLinterRequestList.size()>0){
		Iterator it = prpLinterRequestList.iterator();
		String id = "";
		while (it.hasNext()){
			PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto) it.next();
			String registNo = prpLinterRequestDto.getRegistno();
			System.err.println("registNo==="+registNo);
			try{
				ArrayList autoClaimDetailList = (ArrayList)blPrplinterAutoClaimDetailFacade.findByConditions("registno ='"+registNo+"'");
				if(autoClaimDetailList!=null&&!autoClaimDetailList.isEmpty()&&autoClaimDetailList.size()>0){
					PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = (PrplinterAutoClaimDetailDto)autoClaimDetailList.get(0);
					id = prplinterAutoClaimDetailDto.getId();
					PrpLinterRequestDto interRequestDto = blPrpLinterRequestFacade.findByPrimaryKey(id);
					interRequestDto.setRegistno(prpLinterRequestDto.getRegistno());
					interRequestDto.setRelationRegistNo(prpLinterRequestDto.getRegistno());
					interRequestDto.setPrplinterAutoClaimDetailDto(prplinterAutoClaimDetailDto);
					
					//核赔环节
					prpLinterRequestDto = new UIMedicalAutoVericSubViewHelper().autoVericUpload(interRequestDto);
					//结案环节
					prpLinterRequestDto = new UIMedicalAutoEndcaSubViewHelper().autoEndca(interRequestDto);
					
					new BLPrplinterrelationFacade().finishSynchron(interRequestDto);
				}
				
				
				
				String registNotemp = prpLinterRequestDto.getRegistno();
				returnStr=returnStr+"“"+ registNotemp+"”，";
				
			}catch(Exception e ){
				e.printStackTrace();
				returnStr2=returnStr2+"“"+id+"”，";
			}
		}
	}
} catch (Exception e) {
	e.printStackTrace();
}

%>

<body  >
<form name="fm" action=""  method="post"  target ="sub">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=2 class="formtitle">大病医疗自动核赔补传</td></tr>
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



