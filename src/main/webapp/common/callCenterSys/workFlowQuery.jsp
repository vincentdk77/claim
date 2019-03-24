<%@ page contentType="text/html; charset=GBK" %>
<%	
	try{
		UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
		ArrayList transferList = (ArrayList) uiUtiCodeTransferAction
				.findByConditions(" 1=1");
		session.setAttribute("transferList",transferList);
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
		//������������ʱ�봫system����
		String strSystem = request.getParameter("system");
		request.setAttribute("system", strSystem);
		
        
		String usercode = request.getParameter("usercode");
		String comCode = request.getParameter("comCode");
		
		PrpDuserDto prpDuserDto = new PrpDuserDto();
        prpDuserDto.setUserCode(usercode);
        prpDuserDto.setLoginComCode(comCode);
        prpDuserDto.setLoginSystemCode("claim");
        
		UserDto user = new UserDto();	
		user.setUserCode(usercode);
		user.setComCode(comCode);
		//ת���û����ƣ��û���ز��ŵȵ���Ϣ
		String userName = uiCodeAction.translateUserCode(usercode,true);
		UICompanyAction uiCompanyAction = new UICompanyAction();
		PrpDcompanyDto prpDcompanyDto = null;
		prpDcompanyDto = uiCompanyAction.findByPrimaryKey(comCode);
		user.setUserName(userName);
		user.setSysAreaCode(prpDcompanyDto.getSysAreaCode());
		//���ø�λȨ���б�
		BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
		UtiGradeTaskDto utiGradeTaskDto = null;
		Map gradeCodeMap = new HashMap();
		String gradecodes = "";
		String heiPeiGrade = AppConfig.get("sysconst.HEPEIGRADE");//�����λ
		String condition = " taskcode like 'claim%' and gradecode in " +//ֻ��ѯ����ϵͳ��Ȩ�޴���
				           "(select gradecode from utiusergradepower " +
				           "where usercode='" + usercode + "') and gradecode<>'"+heiPeiGrade+"'";
		ArrayList gradeList = (ArrayList)blUtiGradeTaskFacade.findByConditions(condition);
		for(int i = 0; i < gradeList.size(); i ++){
			utiGradeTaskDto = (UtiGradeTaskDto)gradeList.get(i);
			if(!gradeCodeMap.containsKey(utiGradeTaskDto.getGradeCode())){
				gradeCodeMap.put(utiGradeTaskDto.getGradeCode(), utiGradeTaskDto.getGradeCode());
				gradecodes += "," + utiGradeTaskDto.getGradeCode();
			}
		}
		if(gradecodes.length() > 1){
			gradecodes = gradecodes.substring(1,gradecodes.length());
		}					
		user.setLoginGradeCodes(gradecodes);
		prpDuserDto.setLoginGradeCodes(gradecodes);
		//ת����������
		
		String comName = uiCodeAction.translateComCode(user
				.getComCode(), true);
		user.setComName(comName);
		user.setLoginSystem("claim");
		
		session = request.getSession();
		session.setMaxInactiveInterval(Integer.parseInt(AppConfig
				.get("sysconst.SESSION_EXPIRED_SECONDS")));
		
		session.setAttribute("user", user);
		//���Ͳ�ѯʱ�õ�comCode
		session.putValue("ComCode", comCode);
		//Modify by zengzhu 2001016 start
		//�޸����ɣ�������ϵӦ���ǣ�claim������platform�����Ƿ�֮����˴�UserDto��PrpDuserDto��ת��
		//Ӧ���ڴ˴���ɣ�����Ӧ����platformϵͳ����ɡ�����Ķ������platform��claim��������
		session.setAttribute("prpDuserDto",prpDuserDto);
		//Modify by zengzhu 2001016 end
		
		//MenuFuncViewHelper menuFuncViewHelper = new MenuFuncViewHelper();
		//menuFuncViewHelper.initMenu(httpServletRequest);
		
		//��ѯ�û�����״̬
		UserClaimStatusViewHelper userClaimStatusViewHelper = new UserClaimStatusViewHelper();
		userClaimStatusViewHelper.getAllStatsStat(request, user);
	}catch(Exception e){
		throw new Exception("Ȩ��У��ʧ��");
	}


	String registNo = request.getParameter("registNo");
	String flag = "0";//1:�������ڣ�0������������
	String flowid = ""; 
	BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
	ArrayList<SwfLogDto>  swfLogDtoList = (ArrayList<SwfLogDto>)blSwfLogFacade.findByConditions(" registno = '"+registNo+"' ");
	if(swfLogDtoList.size()>0){
		SwfLogDto swfLogDto = swfLogDtoList.get(0);
		flowid = swfLogDto.getFlowID();
		flag = "1";
	}else{
		BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
		ArrayList<SwfLogDto>  swfLogStoreDtoList = (ArrayList<SwfLogDto>)blSwfLogStoreFacade.findByConditions(" registno = '"+registNo+"' ");
		if(swfLogStoreDtoList.size()>0){
			SwfLogDto swfLogDto = swfLogStoreDtoList.get(0);
			flowid = swfLogDto.getFlowID();
			flag = "1";
		}
	}
	String href = "/claim/swfFlowBeforeQuery.do?swfLogFlowID="+flowid+"&swfList=swfFlowQuery&svgFlag=0";
%>

<%@page import="com.sinosoft.claim.dto.domain.SwfLogDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade"%>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICompanyAction"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcompanyDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<%@page import="com.sinosoft.platform.bl.facade.BLUtiGradeTaskFacade"%>
<%@page import="com.sinosoft.platform.dto.domain.UtiGradeTaskDto"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIUtiCodeTransferAction"%>
<%@page import="com.sinosoft.claim.ui.view.formbean.LogonForm"%>
<%@page import="com.sinosoft.platform.dto.domain.PrpDuserDto"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.UserClaimStatusViewHelper"%>
<%@page import="com.sinosoft.claim.bl.facade.BLSwfLogFacade"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>��������</title>
	
<script type="text/javascript">

	function init(){
			var url = document.getElementById("hrefUrl").value;
			var flag = document.getElementById("flag").value;
			if(flag=='1'){
				window.location.href=url;
			}else{
				alert("�������̲�����");
				window.opener = null;
				window.close();
			}
	}
	</script>	
</head>
<body onload = "init();">
	<input type="hidden" value="<%=href %>" id = "hrefUrl" />
	<input type="hidden" value="<%=flag %>" id = "flag" />
</body>
</html>