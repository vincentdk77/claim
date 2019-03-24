<%@ page contentType="text/html; charset=GBK" %>
<%	
	try{
		UIUtiCodeTransferAction uiUtiCodeTransferAction = new UIUtiCodeTransferAction();
		ArrayList transferList = (ArrayList) uiUtiCodeTransferAction
				.findByConditions(" 1=1");
		session.setAttribute("transferList",transferList);
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
		//呼叫中心链接时须传system参数
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
		//转换用户名称，用户相关部门等等信息
		String userName = uiCodeAction.translateUserCode(usercode,true);
		UICompanyAction uiCompanyAction = new UICompanyAction();
		PrpDcompanyDto prpDcompanyDto = null;
		prpDcompanyDto = uiCompanyAction.findByPrimaryKey(comCode);
		user.setUserName(userName);
		user.setSysAreaCode(prpDcompanyDto.getSysAreaCode());
		//设置岗位权限列表
		BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
		UtiGradeTaskDto utiGradeTaskDto = null;
		Map gradeCodeMap = new HashMap();
		String gradecodes = "";
		String heiPeiGrade = AppConfig.get("sysconst.HEPEIGRADE");//核赔岗位
		String condition = " taskcode like 'claim%' and gradecode in " +//只查询理赔系统的权限代码
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
		//转换部门名称
		
		String comName = uiCodeAction.translateComCode(user
				.getComCode(), true);
		user.setComName(comName);
		user.setLoginSystem("claim");
		
		session = request.getSession();
		session.setMaxInactiveInterval(Integer.parseInt(AppConfig
				.get("sysconst.SESSION_EXPIRED_SECONDS")));
		
		session.setAttribute("user", user);
		//车型查询时用到comCode
		session.putValue("ComCode", comCode);
		//Modify by zengzhu 2001016 start
		//修改理由：依赖关系应该是：claim依赖于platform而不是反之，因此从UserDto到PrpDuserDto的转换
		//应该在此处完成，而不应该在platform系统中完成。这个改动将解除platform对claim的依赖。
		session.setAttribute("prpDuserDto",prpDuserDto);
		//Modify by zengzhu 2001016 end
		
		//MenuFuncViewHelper menuFuncViewHelper = new MenuFuncViewHelper();
		//menuFuncViewHelper.initMenu(httpServletRequest);
		
		//查询用户任务状态
		UserClaimStatusViewHelper userClaimStatusViewHelper = new UserClaimStatusViewHelper();
		userClaimStatusViewHelper.getAllStatsStat(request, user);
	}catch(Exception e){
		throw new Exception("权限校验失败");
	}


	String registNo = request.getParameter("registNo");
	String flag = "0";//1:案件存在，0：案件不存在
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
<title>工作流程</title>
	
<script type="text/javascript">

	function init(){
			var url = document.getElementById("hrefUrl").value;
			var flag = document.getElementById("flag").value;
			if(flag=='1'){
				window.location.href=url;
			}else{
				alert("案件流程不存在");
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