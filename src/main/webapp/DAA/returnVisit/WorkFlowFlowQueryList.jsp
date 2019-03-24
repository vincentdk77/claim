<%--
****************************************************************************
* DESC       : 工作流流程列表
* AUTHOR     ：weishixin  
* CREATEDATE ：2004-09-03
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.SwfLogDto"%>
<%@page import="com.sinosoft.claim.dto.domain.SwfPathLogDto"%>
<%@page import="com.sinosoft.claim.dto.domain.SwfFlowMainDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpDcodeDto"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.util.*"%>

<%@page import="java.util.*"%>
<%
  int beforeLayerDeep = 0 ;    //前一层
  int currLayerDeep   = 0 ;    //当前层

  int posX            = 0 ;    //X坐标
  int posY            = 0 ;    //Y坐标
  String nodeName     = "" ;   //节点名称
  String deptName   = "" ;   //处理部门名称
  String nodeType     ="";     //节点的类型
  String nodeDispName ="";     //节点最终的显示内容
  String insureCarFlag="" ;    //是否是保单车辆，如果1，表示是主车，其它都为三者
  String typeFlag="";          //如果是特殊赔案，那么里面的三种情况的显示
  String nodeStatus   = "" ;   //节点状态
  int nodePosLayer    = 0  ;   //节点位置
  int nodeCount       = 0  ;   //层节点数
  int startPosX       = 0  ;   //横轴开始
  int endPosX         = 0  ;   //横轴结束
  int startPosY       = 0  ;   //纵轴开始
  int endPosY         = 0  ;   //纵轴结束
  int startNodeNo     = 0 ;    //路径始节点
  int endNodeNo       = 0 ;    //路径终节点
  String nodeColor    = "" ;   //节点颜色
  String nodeStatusColor = "" ;//节点状态颜色
  String nodeTitle    = "";    //节点title
  String licenseNo ="";        //车牌号码
  String riskCode ="";         //险种
  //工作流程说明
  String wfDetail1="";         //正常流转说明
  String wfDetail1Color="#FF8040"; //正常流转字颜色

  String wfDetail2="";         //是否包含特殊赔案说明
  String wfDetail3="";         //创建日期
  String wfDetail4="";         //关闭日期

  //modify by lixiang add 20050310 start
//reason:流程显示-图中每个节点增加链接，链到此节点的详细信息
  String strInfoLink="";       //链接
  //added by zhangli 20070424
  String compensateStrInfoLink = "";  //计算书连接
  String flowStr="";           //工作流上的链接条件
//modify by lixiang add 20050310 end

  //工作流主信息对象
  SwfFlowMainDto swfFlowMainDto = (SwfFlowMainDto)request.getAttribute("swfFlowMainDto");

  if (swfFlowMainDto.getFlowStatus().equals("0")) wfDetail1="流转结束";
  if (swfFlowMainDto.getFlowStatus().equals("1")) wfDetail1="正常流转";
  if (swfFlowMainDto.getFlowStatus().equals("9")) wfDetail1="流转异常";

  wfDetail2="非特殊赔案";
  wfDetail3=swfFlowMainDto.getCreatDate()+"创建";

  if (swfFlowMainDto.getFlowStatus().equals("0")) wfDetail4=swfFlowMainDto.getCloseDate()+"关闭";

  SwfLogDto swfLogTreeDto = (SwfLogDto)request.getAttribute("swfLogDto");

  ArrayList treeSwfLogList = (ArrayList)swfLogTreeDto.getSwfLogList();

  //路径信息
  ArrayList treePathLogList = (ArrayList)request.getAttribute("swfPathLogList");
  //得到节点状态列表
  ArrayList claimStatusList = (ArrayList)request.getAttribute("claimStatus");

%>
<html xmlns:v="urn:schemas-microsoft-com:vml">

  <STYLE>
    v\:* { BEHAVIOR: url(#default#VML) }
  </STYLE>

  <script src="/claim/workflow/flow/js/WorkFlowFlowShow.js"> </script>


<form name="fm">
      <input type="hidden" name="prpLregistRegistNo" value="<%= request.getParameter("wfLogBusinessNo") %>">
      <input type="hidden" name="prpLregistPolicyNo" value="<%= request.getParameter("policyNo") %>">
      <input type="hidden" name="prpLregistRiskCode" value="<%= request.getParameter("riskCode") %>">
      <input type="hidden" name="prpLclaimClaimNo" value="">
</form>

  <table class=common >
  <tr><td> <input type="button" class=button name="messageView" value="查看留言" onclick="openWinQuery()"></td> </tr>
  </table>

        <table class=common border="0" cellpadding="5" cellspacing="1">
          <tr>

            <td colspan=4 class="formtitle">工作流流程图</td>

          </tr>
        </table>


  <v:group ID="workflowGroup" style="position:relative;WIDTH:8000px;HEIGHT:8500px;" coordsize = "21600,25600">

<%
	  for(int i=0;i<treeSwfLogList.size();i++)
	  {
	    SwfLogDto swfLogNodeDto = (SwfLogDto)treeSwfLogList.get(i);
	    currLayerDeep = swfLogNodeDto.getTreeLayer();
	    nodePosLayer  = swfLogNodeDto.getNodePosLayer();
	    //名称的变化
	    nodeName      = swfLogNodeDto.getNodeName();
	    if("verip,verpo".indexOf(swfLogNodeDto.getNodeType())>-1){
	      if (swfLogNodeDto.getFlag()!=null&&"a".equals(swfLogNodeDto.getFlag())) {
			nodeName=nodeName.replace("核价", "询价");
		  }
	    }
	   
	    deptName    = swfLogNodeDto.getDeptName();
	    nodeType      = swfLogNodeDto.getNodeType();
	    insureCarFlag =swfLogNodeDto.getInsureCarFlag();
	    
	    //因为意健险的查勘文字信息叫调查,在此进行转换. 2005-09-03
	    if (swfLogNodeDto.getNodeType().equals("check")) {
	        if ("07".equals(swfLogNodeDto.getRiskCode().substring(0,2)) 
	               || "06".equals(swfLogNodeDto.getRiskCode().substring(0,2))) {
	            nodeDispName = "调查";
	        } else {
	            nodeDispName  = nodeName;  //显示内容默认为节点的名称，但是查勘目前除外
	        }
	    } else {
    	    nodeDispName  = nodeName;  //显示内容默认为节点的名称，但是查勘目前除外
	    }
      
      //add by lixiang start at 2006-6-5
      //reason:区分强三立案
      if ((swfLogNodeDto.getNodeType().equals("claim")||
           swfLogNodeDto.getNodeType().equals("compe")||
           swfLogNodeDto.getNodeType().equals("cance")||
           swfLogNodeDto.getNodeType().equals("endca"))
           && (swfLogNodeDto.getRiskCode().equals("0507")
        		   ||swfLogNodeDto.getRiskCode().equals("0577")
        		   ||swfLogNodeDto.getRiskCode().equals("0587"))){
      nodeDispName=nodeDispName+"[强三]";
      }
      //add by lixiang end at 2006-6-5
     
	    licenseNo = swfLogNodeDto.getLossItemName();
	    riskCode=swfLogNodeDto.getRiskCode();
	    typeFlag =swfLogNodeDto.getTypeFlag();

	    //modify by lixiang add 20050310 start
            //reason:流程显示-图中每个节点增加链接，链到此节点的详细信息
            //根据节点不同，进行不同的联接
            flowStr="&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()
              +"&status="+swfLogNodeDto.getNodeStatus()
              +"&riskCode="+swfLogNodeDto.getRiskCode()
              +"&editType=SHOW"
              +"&nodeType="+swfLogNodeDto.getNodeType()
              +"&businessNo="+swfLogNodeDto.getBusinessNo()
              +"&policyNo="+swfLogNodeDto.getPolicyNo()
              +"&modelNo="+swfLogNodeDto.getModelNo()
              +"&nodeNo="+swfLogNodeDto.getNodeNo()
	    	  +"&registNo="+swfLogNodeDto.getRegistNo();
              

             if (nodeType.equals("regis")){
             strInfoLink="/claim/carregistFinishQueryList.do?prpLregistRegistNo="+swfLogNodeDto.getBusinessNo()+flowStr;

             }
             //查勘信息
             if (nodeType.equals("check") || nodeType.equals("surve")){
             strInfoLink="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+swfLogNodeDto.getKeyIn()
                                                 +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                 +flowStr
             									 +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
             									 +"&lossItemName="+swfLogNodeDto.getLossItemName();
             }
             //定损信息
             if (nodeType.equals("certa")){
             strInfoLink="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogNodeDto.getKeyIn()
                                                   +"&lossTypeFlag="+swfLogNodeDto.getTypeFlag()
                                                   +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
                                                   +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                   +flowStr
             									  +"&lossItemName="+swfLogNodeDto.getLossItemName();
             }
             //核价信息
             if (nodeType.equals("verip") || nodeType.equals("verpo")){
             strInfoLink="/claim/verifyPriceFinishQueryList.do?prpLverifyLossRegistNo="+swfLogNodeDto.getKeyIn()
                                                   +"&lossTypeFlag="+swfLogNodeDto.getTypeFlag()
                                                   +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
                                                   +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                   +flowStr
             									   +"&lossItemName="+swfLogNodeDto.getLossItemName();	
             }

             //核损信息
             if (nodeType.equals("verif")){
            	 strInfoLink="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=certa&encodePargrm=";
             }
             //立案信息
             if (nodeType.equals("claim")){
             //strInfoLink="/newclaim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogNodeDto.getKeyOut()+flowStr;
			 strInfoLink="/claim/claimBeforeEdit.do?RegistNo="+swfLogNodeDto.getRegistNo()+flowStr;
             }
             //结案信息
             if (nodeType.equals("endca")){

             strInfoLink="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+swfLogNodeDto.getKeyIn()+flowStr;

             }
             //单证信息
             if (nodeType.equals("certi")){
             strInfoLink="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+swfLogNodeDto.getKeyIn()+flowStr;
             }
             //实赔信息
             if (nodeType.equals("compe")){
             strInfoLink="javascript:alert('请查看具体的计算书信息')";
             }
             if(nodeType.equals("veric")){
            	 strInfoLink="javascript:alert('请查看具体的核赔信息')";
             }
             //调度信息
             if (nodeType.equals("sched")){
                strInfoLink="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo="+swfLogNodeDto.getBusinessNo()
                                                +"&prpLscheduleMainWFScheduleID=1&scheduleType=sched"+flowStr;
             }
             //人伤跟踪信息
             if (nodeType.equals("wound")){
               strInfoLink="/claim/woundPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=wound&encodePargrm=";
             }
             //财产定损信息
              if (nodeType.equals("propc")){
            	  if(swfLogNodeDto.getLossItemCode().equals("-1")){
            		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=0&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
            	  }else{
            		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=0&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
            	  }
             }
             //财产核损信息
              if (nodeType.equals("propv")){
               		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
             }
             
             
             //注销/拒赔信息
             if (nodeType.equals("cance")){
             strInfoLink="/claim/claimBeforeCancel.do?businessNo="+swfLogNodeDto.getKeyIn()+"&editType=UNCANCEL&nodeType=certi&riskCode="+swfLogNodeDto.getRiskCode()+flowStr;
             //strInfoLink="/newclaim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogNodeDto.getKeyIn()+"&RegistNo="+swfLogNodeDto.getRegistNo()+flowStr;

             }
             //人伤复核
             if(nodeType.equals("rview")){
            	 strInfoLink="/claim/reCheckPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=rview&encodePargrm=";
             }
             //人伤核损信息
             if (nodeType.equals("veriw")){
                           strInfoLink="/claim/woundPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=wound&encodePargrm=";
             }
             //计算书信息
             if (nodeType.equals("compp")){
             strInfoLink="/claim/prpllossAdd.do?businessNo="+swfLogNodeDto.getKeyOut()+flowStr;
             compensateStrInfoLink = "/claim/prpllossAdd.do?businessNo="+swfLogNodeDto.getKeyOut()+flowStr;
             }
             //特殊赔案信息
             if (nodeType.equals("speci")){
               if (typeFlag.equals("7") || typeFlag.equals("8") || typeFlag.equals("5")){
                   strInfoLink="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogNodeDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
                   
               }else {
                   strInfoLink="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogNodeDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
               }
             }
            //复勘信息
             if ("rchk,rchkd".indexOf(nodeType)>-1){
             strInfoLink="/claim/rcheckBeforeEditGet.do?rcheckFlag=true&rcheckStatus=4&rcheckSeachType=&RegistNo="+swfLogNodeDto.getRegistNo()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+flowStr;
             }
             if (swfLogNodeDto.getNodeStatus().equals("0")){
             strInfoLink="javascript:alert('该节点目前没有信息')";
             }



            //modify by lixiang add 20050310 end
            
            //modify by lixiang add 20051107 start
           //立案，注销后也不显示任何信息 (暂时什么都不显示)     
       if (swfLogNodeDto.getNodeStatus().equals("6")
          &&(swfLogNodeDto.getNodeType().equals("check")
             ||swfLogNodeDto.getNodeType().equals("wound") 
             ||swfLogNodeDto.getNodeType().equals("certa") 
             ||swfLogNodeDto.getNodeType().equals("propc") 
             ||swfLogNodeDto.getNodeType().equals("claim") 
             )) {
        strInfoLink="javascript:alert('该节点目前已被撤消，没有信息')";
      }  

	    if (nodeType.equals("certa") || nodeType.equals("verip") || nodeType.equals("verpo"))
	    {
			 UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(swfLogNodeDto.getRiskCode());
	        if (("D").equals(strRiskType))
	        {
	            if (insureCarFlag.equals("1"))
	            {
	                //nodeDispName= licenseNo+"\n"+nodeDispName+"标的";
	                //modify by lixiang remark 20050309 start
                        //reason:流程图显示-查勘/定损显示车牌号，原显示主车改成标的车
                          if(nodeType.equals("verpo")){
                            nodeDispName= nodeDispName+" 标的:"+licenseNo;
                          }else
                          {
                            nodeDispName= nodeDispName+" 标的:"+licenseNo;
                          }
                        //modify by lixiang remark 20050309 end
	            }
	            else
	            {
	             //modify by lixiang remark 20050309 start
                        //reason:流程图显示-查勘/定损显示车牌号，原显示主车改成标的车
	                //nodeDispName= licenseNo+"\n"+ nodeDispName+"(三者车)";
                  if(nodeType.equals("verpo")){
                    nodeDispName= nodeDispName+"("+deptName+") 三者:"+licenseNo;
                  }else
                  {
                    nodeDispName= nodeDispName+" 三者:"+licenseNo;
                  }
	                
	                //modify by lixiang remark 20050309 end
	            }	            
	        }
	    }
	    if("propc".equals(nodeType) || "propv".equals(nodeType)){
	    	nodeDispName= nodeDispName+":"+licenseNo;
	    }
	    if (nodeType.equals("speci"))
	    {
	         wfDetail2="特殊赔案";
	            if (typeFlag.equals("3"))
	            {
	                nodeDispName= nodeDispName+"(通融)";
	            }
	             if (typeFlag.equals("4"))
	            {
	                nodeDispName= nodeDispName+"(预付)";
	            }
	            if (typeFlag.equals("6"))
	            {
	                nodeDispName= nodeDispName+"(其它)";
	            }
	             if (typeFlag.equals("5"))
	            {
	                nodeDispName= nodeDispName+"(预赔)";
	            }
	             if (typeFlag.equals("7"))
	            {
	                nodeDispName= nodeDispName+"(支付抢救费)";
	            }
	             if (typeFlag.equals("8"))
	            {
	                nodeDispName= nodeDispName+"(垫付抢救费)";
	            }
	    }

      //modify by liujianbo modify 20050310 start
      //reason:流程图显示BUG已分配人员的定损显示为未分配（BUG）应显示已分配
	    if (swfLogNodeDto.getNodeStatus().equals("0") && swfLogNodeDto.getHandlerCode()!=null&&swfLogNodeDto.getHandlerCode().trim().length()>0) swfLogNodeDto.setNodeStatus("1");
	    UICodeAction uiCodeAction = new UICodeAction();
	    swfLogNodeDto.setNodeStatusName(uiCodeAction.translateCodeCode("ClaimStatus",swfLogNodeDto.getNodeStatus(),true));
      //modify by liujianbo modify 20050310 end

	    nodeStatus    = swfLogNodeDto.getNodeStatus();
	    nodeCount     = swfLogNodeDto.getCountNode();
	    posY          = currLayerDeep * 250;
	    posX          = nodePosLayer * 400;
	    //根据状态确定颜色
	    nodeStatusColor    = "sysconst.ClaimStatus" + nodeStatus;
	    nodeColor     = AppConfig.get(nodeStatusColor);
	    nodeTitle     = "业务号:" + swfLogNodeDto.getBusinessNo() + "\n处理人员:"+swfLogNodeDto.getHandlerName()+ "\n流入时间:"+swfLogNodeDto.getFlowInTime()+ "\n处理时间:"+swfLogNodeDto.getHandleTime()+ "\n流出时间:"+swfLogNodeDto.getSubmitTime();

	    //System.out.println("----X="+posX+ "|Y="+posY+"|treeLayer=" + currLayerDeep + "|nodePosLayer=" +  nodePosLayer+ "|nodeCount="+nodeCount + "|nodeStatus=" + nodeStatus +"######");

	    //根据节点信息画节点
	%>
         <%
         //modify by lixiang add 20050311 start
          //reason:显示流程图里的联接/人员处理时间显示得也不对
          %>

	  <v:rect style='position:relative;top:<%=posY %>;left:<%=posX %>;width:300;height:50;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='blue' title="<%=nodeTitle%>">
	  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=strInfoLink%>><%=nodeDispName%></a></v:TextBox></center>
 	  </v:rect>
	  <v:rect style='position:relative;top:<%=posY+45 %>;left:<%=posX %>;width:300;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
	  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><%=swfLogNodeDto.getHandlerName()%> <%= swfLogNodeDto.getStopTimeDesc() %></v:TextBox></center>
 	  </v:rect>
	 <%//modify by lixiang add 20050311 end
     //add by lixiang start at 2005-12-30
	   //reason:去掉理算让人不理解的状态显示
	  if (nodeType.equals("compe")) //去掉状态显示
	    {
	      
	      swfLogNodeDto.setNodeStatusName("");
 	   }
    	//add by lixiang end at 2005-12-30
          %>

	  <v:rect style='position:relative;top:<%=posY+100 %>;left:<%=posX %>;width:300;height:50;z-index:8;' strokeColor='blue' title="<%=nodeTitle%>">
	  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><%= swfLogNodeDto.getNodeStatusName() %></v:TextBox></center>
 	  </v:rect>

	<%
	}
	
	  %>
%>
<%
    int bigTreeLayer = 0 ;   //最大的层
    int bigNodePosLayer = 0; //最大节点位置
	  for(int i=0;i<treePathLogList.size();i++)
	  {
	    //得到路径
	    SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)treePathLogList.get(i);
	    startNodeNo = swfPathLogNodeDto.getStartNodeNo();
	    //得到路径对应起节点

	    for(int j=0;j<treeSwfLogList.size();j++)
	    {
	        SwfLogDto swfLogStartDto = (SwfLogDto)treeSwfLogList.get(j);

	        if(startNodeNo==swfLogStartDto.getLogNo())
	        {
				    currLayerDeep   = swfLogStartDto.getTreeLayer();
				    nodePosLayer    = swfLogStartDto.getNodePosLayer();
			      startPosY       = currLayerDeep * 250 + 150;
				    startPosX       = nodePosLayer * 400 +  150;
				    beforeLayerDeep = currLayerDeep;
				    break;
          }
     }

         //得到路径对应终节点

      endNodeNo = swfPathLogNodeDto.getEndNodeNo();
	    for(int k=0;k<treeSwfLogList.size();k++)
	    {
	        SwfLogDto swfLogEndDto = (SwfLogDto)treeSwfLogList.get(k);

	        if(endNodeNo==swfLogEndDto.getLogNo())
	        {
				    currLayerDeep = swfLogEndDto.getTreeLayer();
				    //得到最大的层
				    if(currLayerDeep>bigTreeLayer)
				    {
				        bigTreeLayer = currLayerDeep;
				    }

				    nodePosLayer  = swfLogEndDto.getNodePosLayer();
				    //得到最大的节点位置
				    if(nodePosLayer>bigNodePosLayer)
				    {
				        bigNodePosLayer = nodePosLayer ;
				    }
			      endPosY       = currLayerDeep * 250;
			      if(currLayerDeep - beforeLayerDeep==1)
			      {
			        endPosX       = nodePosLayer * 400 +150;
				    }
				    else
				    {
				       //如果是跨层的线易重叠,做了偏移
				       endPosX       = nodePosLayer * 400 +150-50;
				    }
				    break;
          }

     }

	    //根据节点信息画线
	%>
       <v:line style="POSITION: relative;z-index:9"  from="<%=startPosX%>,<%=startPosY%>" to="<%=endPosX%>,<%=endPosY%>"><v:stroke endarrow = "classic"></v:stroke></v:line>
	<%

	}

	//节点标题颜色说明
%>
<!--added by zhangli 20070427 给出理算书的支付状态-->
 <%   
      ArrayList payTotalList = new ArrayList();
      if(request.getAttribute("payTotalList")!=null){
         payTotalList = (ArrayList)request.getAttribute("payTotalList");
      }      
      if(payTotalList.size()>0){
         int posXcur = posX;
         Iterator it = payTotalList.iterator();  
         while(it.hasNext()){
           ArrayList payList = new ArrayList();
           payList = (ArrayList)it.next();
           //payList里依次放的是理算书号,被保险人名称,本理算书支付总金额,本理算书支付最后日期 
           String compensateNo = "";
           String insuredName = "";
           String payedFee = "";
           String payedDate = "";
           compensateNo = (String)payList.get(0);
           insuredName =  (String)payList.get(1);
           payedFee = (String)payList.get(2);
           payedDate = (String)payList.get(3);
           
           %>
           <%
           if(("".equals(payedFee))||("0.0".equals(payedFee))||("0.00".equals(payedFee))||payedFee==null){
           %>
           <v:rect style='position:relative;top:<%=posY +300%>;left:<%=posXcur%>;width:600;height:60;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='red' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=compensateStrInfoLink%>>未支付</a></v:TextBox></center>
		 	</v:rect> 
           <%}else {%>
		    <v:rect style='position:relative;top:<%=posY +300%>;left:<%=posXcur%>;width:600;height:60;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=compensateStrInfoLink%>>已支付</a></v:TextBox></center>
		 	</v:rect> 
		 	<%}%>
		     <v:rect style='position:relative;top:<%=posY +300+55 %>;left:<%=posXcur %>;width:600;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>计算书号：<%=compensateNo%></v:TextBox></center>
		 	</v:rect>
		     <v:rect style='position:relative;top:<%=posY +300+110 %>;left:<%=posXcur %>;width:600;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>被保险人：<%=insuredName%></v:TextBox></center>
		 	</v:rect>
		    <v:rect style='position:relative;top:<%=posY +300+160 %>;left:<%=posXcur %>;width:600;height:50;z-index:8;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>该计算书已支付赔款总额：<%=payedFee%>元</v:TextBox></center>
		 	</v:rect>
		 	 <%
           if(("".equals(payedFee))||("0.0".equals(payedFee))||("0.00".equals(payedFee))||payedFee==null){}else{
           %>
		    <v:rect style='position:relative;top:<%=posY +300+210 %>;left:<%=posXcur %>;width:600;height:50;z-index:8;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>最后支付日期：<%=payedDate%></v:TextBox></center>
		 	</v:rect>               
 <%       }
          posXcur = posXcur+650;  
         }       
      
     }
 %>     


<v:rect style='position:relative;top:100;left:1630;width:350;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 100.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '13pt,2pt,0pt,0pt'>节点标题颜色说明</v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>

  <v:rect style='position:relative;top:150;left:1630;width:350;height:<%=claimStatusList.size()*45+100%>;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '10pt,0pt,0pt,0pt'></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>

<%

    for(int n=0;n<claimStatusList.size();n++)
    {

       PrpDcodeDto prpDcodeDto = (PrpDcodeDto)claimStatusList.get(n);
       nodeStatusColor         = "sysconst.ClaimStatus" + prpDcodeDto.getCodeCode();
       nodeColor               = AppConfig.get(nodeStatusColor);
       posX                    = 1680;
       posY                    = 200+n*45 ;

%>
	<v:rect style='position:relative;top:<%=posY%>;left:<%=posX%>;width:120;height:40;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='blue'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 20.687pt' inset = '40pt,0pt,0pt,0pt'><%=prpDcodeDto.getCodeCName()%></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>
<%
    }

     wfDetail1="1."+wfDetail1;
     wfDetail2="2."+wfDetail2;
     wfDetail3="3."+wfDetail3;
     int topWfDetail=100;
     int hightWfDetail=220;
     if (!wfDetail4.equals("")) hightWfDetail=hightWfDetail+50;
%>
<%//工作流程相关说明%>
  <v:rect style='position:relative;top:<%=topWfDetail%>;left:20;width:350;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 100.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '20pt,2pt,0pt,0pt'>工作流程说明</v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>

  <v:rect style='position:relative;top:<%=topWfDetail+50%>;left:20;width:350;height:<%=hightWfDetail%>;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '5pt,2pt,0pt,0pt'></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>

	<v:rect style='position:relative;top:<%=topWfDetail+80%>;left:65;width:300;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='#FFFFFF'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt;COLOR:#804040' inset = '0pt,2pt,0pt,0pt'><%=wfDetail1%></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>

	</v:rect>
	<v:rect style='position:relative;top:<%=topWfDetail+130%>;left:65;width:300;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='#FFFFFF'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt;COLOR:#804040' inset = '0pt,2pt,0pt,0pt'><%=wfDetail2%></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>
	<v:rect style='position:relative;top:<%=topWfDetail+180%>;left:65;width:300;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='#FFFFFF'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt;COLOR:#804040' inset = '0pt,2pt,0pt,0pt'><%=wfDetail3%></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>


	<% if (!wfDetail4.equals("")) {%>
	<v:rect style='position:relative;top:<%=topWfDetail+230%>;left:65;width:300;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='#FFFFFF'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt;COLOR:#804040' inset = '0pt,2pt,0pt,0pt'><%="4."+wfDetail4%></v:TextBox>
	  <v:Extrusion backdepth='5pt' on='false'/>
	</v:rect>
	<%}%>

	<%
	//计算最佳的展现尺寸
	if (bigTreeLayer>2)
	{
	   bigTreeLayer = bigTreeLayer - 2 ;
	}
	else
	{
	   bigTreeLayer = 2 ;
	}

	if(bigNodePosLayer>4)
	{
	   bigNodePosLayer = bigNodePosLayer - 4 ;
	}
	else
	{
	   bigNodePosLayer =  0 ;
	}
	%>
		
		<v:rect style="WIDTH:<%=2000 + bigNodePosLayer*400%>px;HEIGHT:<%=bigTreeLayer*300+900%>px" fillcolor="#F4F9FF">
		  <v:shadow on="t" type="single" color="silver" offset="5pt,5pt"></v:shadow>
	  </v:rect>
	 
  </v:group>






  <table  class="common" cellpadding="5" cellspacing="1" style="border:1px solid #3A81C8">
   <tr><td colspan=8 class="formtitle">工作流流程列表</td></tr>
     <tr class=listtitle>
        <td align="center">节点号</td>
        <td align="center">节点名称</td>
        <td align="center">业务号</td>
        <td align="center">处理人员</td>
        <td align="center">流入时间</td>
        <td align="center">处理时间</td>
        <td align="center">流出时间</td>
        <td align="center">当前状态</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogList1"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common>  <td align="center"><bean:write name='swfLogList1' property='nodeNo'/></td>
        <td align="center"><bean:write name="swfLogList1" property="nodeName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="keyOut"/></td>
        <td align="center"><bean:write name="swfLogList1" property="handlerName"/></td>
        <td align="center"><bean:write name="swfLogList1" property="flowInTime"/></td>
        <td align="center"><bean:write name="swfLogList1" property="handleTime"/></td>
        <td align="center"><bean:write name="swfLogList1" property="submitTime"/></td>
        <!-- modify by liyanjie 20051022 replace nodeStatus with nodeStatusName 
        <!-- <td align="center"><bean:write name="swfLogList1" property="nodeStatus"/></td> -->
        <td align="center"><bean:write name="swfLogList1" property="nodeStatusName"/></td>

      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
        <td colspan="8">
         共查询出<%= index %>条满足条件的记录
        </td>
      </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">

</script>
</html>