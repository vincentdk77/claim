<%--
****************************************************************************
* DESC       : �����������б�
* AUTHOR     ��weishixin  
* CREATEDATE ��2004-09-03
* MODIFYLIST ��   id       Date            Reason/Contents
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
  int beforeLayerDeep = 0 ;    //ǰһ��
  int currLayerDeep   = 0 ;    //��ǰ��

  int posX            = 0 ;    //X����
  int posY            = 0 ;    //Y����
  String nodeName     = "" ;   //�ڵ�����
  String deptName   = "" ;   //����������
  String nodeType     ="";     //�ڵ������
  String nodeDispName ="";     //�ڵ����յ���ʾ����
  String insureCarFlag="" ;    //�Ƿ��Ǳ������������1����ʾ��������������Ϊ����
  String typeFlag="";          //����������ⰸ����ô����������������ʾ
  String nodeStatus   = "" ;   //�ڵ�״̬
  int nodePosLayer    = 0  ;   //�ڵ�λ��
  int nodeCount       = 0  ;   //��ڵ���
  int startPosX       = 0  ;   //���Ὺʼ
  int endPosX         = 0  ;   //�������
  int startPosY       = 0  ;   //���Ὺʼ
  int endPosY         = 0  ;   //�������
  int startNodeNo     = 0 ;    //·��ʼ�ڵ�
  int endNodeNo       = 0 ;    //·���սڵ�
  String nodeColor    = "" ;   //�ڵ���ɫ
  String nodeStatusColor = "" ;//�ڵ�״̬��ɫ
  String nodeTitle    = "";    //�ڵ�title
  String licenseNo ="";        //���ƺ���
  String riskCode ="";         //����
  //��������˵��
  String wfDetail1="";         //������ת˵��
  String wfDetail1Color="#FF8040"; //������ת����ɫ

  String wfDetail2="";         //�Ƿ���������ⰸ˵��
  String wfDetail3="";         //��������
  String wfDetail4="";         //�ر�����

  //modify by lixiang add 20050310 start
//reason:������ʾ-ͼ��ÿ���ڵ��������ӣ������˽ڵ����ϸ��Ϣ
  String strInfoLink="";       //����
  //added by zhangli 20070424
  String compensateStrInfoLink = "";  //����������
  String flowStr="";           //�������ϵ���������
//modify by lixiang add 20050310 end

  //����������Ϣ����
  SwfFlowMainDto swfFlowMainDto = (SwfFlowMainDto)request.getAttribute("swfFlowMainDto");

  if (swfFlowMainDto.getFlowStatus().equals("0")) wfDetail1="��ת����";
  if (swfFlowMainDto.getFlowStatus().equals("1")) wfDetail1="������ת";
  if (swfFlowMainDto.getFlowStatus().equals("9")) wfDetail1="��ת�쳣";

  wfDetail2="�������ⰸ";
  wfDetail3=swfFlowMainDto.getCreatDate()+"����";

  if (swfFlowMainDto.getFlowStatus().equals("0")) wfDetail4=swfFlowMainDto.getCloseDate()+"�ر�";

  SwfLogDto swfLogTreeDto = (SwfLogDto)request.getAttribute("swfLogDto");

  ArrayList treeSwfLogList = (ArrayList)swfLogTreeDto.getSwfLogList();

  //·����Ϣ
  ArrayList treePathLogList = (ArrayList)request.getAttribute("swfPathLogList");
  //�õ��ڵ�״̬�б�
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
  <tr><td> <input type="button" class=button name="messageView" value="�鿴����" onclick="openWinQuery()"></td> </tr>
  </table>

        <table class=common border="0" cellpadding="5" cellspacing="1">
          <tr>

            <td colspan=4 class="formtitle">����������ͼ</td>

          </tr>
        </table>


  <v:group ID="workflowGroup" style="position:relative;WIDTH:8000px;HEIGHT:8500px;" coordsize = "21600,25600">

<%
	  for(int i=0;i<treeSwfLogList.size();i++)
	  {
	    SwfLogDto swfLogNodeDto = (SwfLogDto)treeSwfLogList.get(i);
	    currLayerDeep = swfLogNodeDto.getTreeLayer();
	    nodePosLayer  = swfLogNodeDto.getNodePosLayer();
	    //���Ƶı仯
	    nodeName      = swfLogNodeDto.getNodeName();
	    if("verip,verpo".indexOf(swfLogNodeDto.getNodeType())>-1){
	      if (swfLogNodeDto.getFlag()!=null&&"a".equals(swfLogNodeDto.getFlag())) {
			nodeName=nodeName.replace("�˼�", "ѯ��");
		  }
	    }
	   
	    deptName    = swfLogNodeDto.getDeptName();
	    nodeType      = swfLogNodeDto.getNodeType();
	    insureCarFlag =swfLogNodeDto.getInsureCarFlag();
	    
	    //��Ϊ�⽡�յĲ鿱������Ϣ�е���,�ڴ˽���ת��. 2005-09-03
	    if (swfLogNodeDto.getNodeType().equals("check")) {
	        if ("07".equals(swfLogNodeDto.getRiskCode().substring(0,2)) 
	               || "06".equals(swfLogNodeDto.getRiskCode().substring(0,2))) {
	            nodeDispName = "����";
	        } else {
	            nodeDispName  = nodeName;  //��ʾ����Ĭ��Ϊ�ڵ�����ƣ����ǲ鿱Ŀǰ����
	        }
	    } else {
    	    nodeDispName  = nodeName;  //��ʾ����Ĭ��Ϊ�ڵ�����ƣ����ǲ鿱Ŀǰ����
	    }
      
      //add by lixiang start at 2006-6-5
      //reason:����ǿ������
      if ((swfLogNodeDto.getNodeType().equals("claim")||
           swfLogNodeDto.getNodeType().equals("compe")||
           swfLogNodeDto.getNodeType().equals("cance")||
           swfLogNodeDto.getNodeType().equals("endca"))
           && (swfLogNodeDto.getRiskCode().equals("0507")
        		   ||swfLogNodeDto.getRiskCode().equals("0577")
        		   ||swfLogNodeDto.getRiskCode().equals("0587"))){
      nodeDispName=nodeDispName+"[ǿ��]";
      }
      //add by lixiang end at 2006-6-5
     
	    licenseNo = swfLogNodeDto.getLossItemName();
	    riskCode=swfLogNodeDto.getRiskCode();
	    typeFlag =swfLogNodeDto.getTypeFlag();

	    //modify by lixiang add 20050310 start
            //reason:������ʾ-ͼ��ÿ���ڵ��������ӣ������˽ڵ����ϸ��Ϣ
            //���ݽڵ㲻ͬ�����в�ͬ������
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
             //�鿱��Ϣ
             if (nodeType.equals("check") || nodeType.equals("surve")){
             strInfoLink="/claim/checkFinishQueryList.do?prpLcheckCheckNo="+swfLogNodeDto.getKeyIn()
                                                 +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                 +flowStr
             									 +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
             									 +"&lossItemName="+swfLogNodeDto.getLossItemName();
             }
             //������Ϣ
             if (nodeType.equals("certa")){
             strInfoLink="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo="+swfLogNodeDto.getKeyIn()
                                                   +"&lossTypeFlag="+swfLogNodeDto.getTypeFlag()
                                                   +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
                                                   +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                   +flowStr
             									  +"&lossItemName="+swfLogNodeDto.getLossItemName();
             }
             //�˼���Ϣ
             if (nodeType.equals("verip") || nodeType.equals("verpo")){
             strInfoLink="/claim/verifyPriceFinishQueryList.do?prpLverifyLossRegistNo="+swfLogNodeDto.getKeyIn()
                                                   +"&lossTypeFlag="+swfLogNodeDto.getTypeFlag()
                                                   +"&insureCarFlag="+swfLogNodeDto.getInsureCarFlag()
                                                   +"&lossItemCode="+swfLogNodeDto.getLossItemCode()
                                                   +flowStr
             									   +"&lossItemName="+swfLogNodeDto.getLossItemName();	
             }

             //������Ϣ
             if (nodeType.equals("verif")){
            	 strInfoLink="/claim/certainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=certa&encodePargrm=";
             }
             //������Ϣ
             if (nodeType.equals("claim")){
             //strInfoLink="/newclaim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogNodeDto.getKeyOut()+flowStr;
			 strInfoLink="/claim/claimBeforeEdit.do?RegistNo="+swfLogNodeDto.getRegistNo()+flowStr;
             }
             //�᰸��Ϣ
             if (nodeType.equals("endca")){

             strInfoLink="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo="+swfLogNodeDto.getKeyIn()+flowStr;

             }
             //��֤��Ϣ
             if (nodeType.equals("certi")){
             strInfoLink="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+swfLogNodeDto.getKeyIn()+flowStr;
             }
             //ʵ����Ϣ
             if (nodeType.equals("compe")){
             strInfoLink="javascript:alert('��鿴����ļ�������Ϣ')";
             }
             if(nodeType.equals("veric")){
            	 strInfoLink="javascript:alert('��鿴����ĺ�����Ϣ')";
             }
             //������Ϣ
             if (nodeType.equals("sched")){
                strInfoLink="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo="+swfLogNodeDto.getBusinessNo()
                                                +"&prpLscheduleMainWFScheduleID=1&scheduleType=sched"+flowStr;
             }
             //���˸�����Ϣ
             if (nodeType.equals("wound")){
               strInfoLink="/claim/woundPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=wound&encodePargrm=";
             }
             //�Ʋ�������Ϣ
              if (nodeType.equals("propc")){
            	  if(swfLogNodeDto.getLossItemCode().equals("-1")){
            		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=0&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
            	  }else{
            		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=0&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
            	  }
             }
             //�Ʋ�������Ϣ
              if (nodeType.equals("propv")){
               		  strInfoLink="/claim/propCertainLossBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&riskCode="+swfLogNodeDto.getRiskCode()+"&editType=SHOW&nodeType=propc&encodePargrm=";
             }
             
             
             //ע��/������Ϣ
             if (nodeType.equals("cance")){
             strInfoLink="/claim/claimBeforeCancel.do?businessNo="+swfLogNodeDto.getKeyIn()+"&editType=UNCANCEL&nodeType=certi&riskCode="+swfLogNodeDto.getRiskCode()+flowStr;
             //strInfoLink="/newclaim/claimFinishQueryList.do?prpLclaimClaimNo="+swfLogNodeDto.getKeyIn()+"&RegistNo="+swfLogNodeDto.getRegistNo()+flowStr;

             }
             //���˸���
             if(nodeType.equals("rview")){
            	 strInfoLink="/claim/reCheckPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=rview&encodePargrm=";
             }
             //���˺�����Ϣ
             if (nodeType.equals("veriw")){
                           strInfoLink="/claim/woundPersonBeforeEdit.do?RegistNo="+swfLogNodeDto.getKeyIn()+"&swfLogFlowID="+swfLogNodeDto.getFlowID()+"&swfLogLogNo="+swfLogNodeDto.getLogNo()+"&status=4&editType=SHOW&nodeType=wound&encodePargrm=";
             }
             //��������Ϣ
             if (nodeType.equals("compp")){
             strInfoLink="/claim/prpllossAdd.do?businessNo="+swfLogNodeDto.getKeyOut()+flowStr;
             compensateStrInfoLink = "/claim/prpllossAdd.do?businessNo="+swfLogNodeDto.getKeyOut()+flowStr;
             }
             //�����ⰸ��Ϣ
             if (nodeType.equals("speci")){
               if (typeFlag.equals("7") || typeFlag.equals("8") || typeFlag.equals("5")){
                   strInfoLink="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo="+swfLogNodeDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
                   
               }else {
                   strInfoLink="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo="+swfLogNodeDto.getKeyOut()
                                   +"&caseType="+typeFlag+flowStr;
               }
             }
            //������Ϣ
             if ("rchk,rchkd".indexOf(nodeType)>-1){
             strInfoLink="/claim/rcheckBeforeEditGet.do?rcheckFlag=true&rcheckStatus=4&rcheckSeachType=&RegistNo="+swfLogNodeDto.getRegistNo()+"&lossItemCode="+swfLogNodeDto.getLossItemCode()+flowStr;
             }
             if (swfLogNodeDto.getNodeStatus().equals("0")){
             strInfoLink="javascript:alert('�ýڵ�Ŀǰû����Ϣ')";
             }



            //modify by lixiang add 20050310 end
            
            //modify by lixiang add 20051107 start
           //������ע����Ҳ����ʾ�κ���Ϣ (��ʱʲô������ʾ)     
       if (swfLogNodeDto.getNodeStatus().equals("6")
          &&(swfLogNodeDto.getNodeType().equals("check")
             ||swfLogNodeDto.getNodeType().equals("wound") 
             ||swfLogNodeDto.getNodeType().equals("certa") 
             ||swfLogNodeDto.getNodeType().equals("propc") 
             ||swfLogNodeDto.getNodeType().equals("claim") 
             )) {
        strInfoLink="javascript:alert('�ýڵ�Ŀǰ�ѱ�������û����Ϣ')";
      }  

	    if (nodeType.equals("certa") || nodeType.equals("verip") || nodeType.equals("verpo"))
	    {
			 UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(swfLogNodeDto.getRiskCode());
	        if (("D").equals(strRiskType))
	        {
	            if (insureCarFlag.equals("1"))
	            {
	                //nodeDispName= licenseNo+"\n"+nodeDispName+"���";
	                //modify by lixiang remark 20050309 start
                        //reason:����ͼ��ʾ-�鿱/������ʾ���ƺţ�ԭ��ʾ�����ĳɱ�ĳ�
                          if(nodeType.equals("verpo")){
                            nodeDispName= nodeDispName+" ���:"+licenseNo;
                          }else
                          {
                            nodeDispName= nodeDispName+" ���:"+licenseNo;
                          }
                        //modify by lixiang remark 20050309 end
	            }
	            else
	            {
	             //modify by lixiang remark 20050309 start
                        //reason:����ͼ��ʾ-�鿱/������ʾ���ƺţ�ԭ��ʾ�����ĳɱ�ĳ�
	                //nodeDispName= licenseNo+"\n"+ nodeDispName+"(���߳�)";
                  if(nodeType.equals("verpo")){
                    nodeDispName= nodeDispName+"("+deptName+") ����:"+licenseNo;
                  }else
                  {
                    nodeDispName= nodeDispName+" ����:"+licenseNo;
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
	         wfDetail2="�����ⰸ";
	            if (typeFlag.equals("3"))
	            {
	                nodeDispName= nodeDispName+"(ͨ��)";
	            }
	             if (typeFlag.equals("4"))
	            {
	                nodeDispName= nodeDispName+"(Ԥ��)";
	            }
	            if (typeFlag.equals("6"))
	            {
	                nodeDispName= nodeDispName+"(����)";
	            }
	             if (typeFlag.equals("5"))
	            {
	                nodeDispName= nodeDispName+"(Ԥ��)";
	            }
	             if (typeFlag.equals("7"))
	            {
	                nodeDispName= nodeDispName+"(֧�����ȷ�)";
	            }
	             if (typeFlag.equals("8"))
	            {
	                nodeDispName= nodeDispName+"(�渶���ȷ�)";
	            }
	    }

      //modify by liujianbo modify 20050310 start
      //reason:����ͼ��ʾBUG�ѷ�����Ա�Ķ�����ʾΪδ���䣨BUG��Ӧ��ʾ�ѷ���
	    if (swfLogNodeDto.getNodeStatus().equals("0") && swfLogNodeDto.getHandlerCode()!=null&&swfLogNodeDto.getHandlerCode().trim().length()>0) swfLogNodeDto.setNodeStatus("1");
	    UICodeAction uiCodeAction = new UICodeAction();
	    swfLogNodeDto.setNodeStatusName(uiCodeAction.translateCodeCode("ClaimStatus",swfLogNodeDto.getNodeStatus(),true));
      //modify by liujianbo modify 20050310 end

	    nodeStatus    = swfLogNodeDto.getNodeStatus();
	    nodeCount     = swfLogNodeDto.getCountNode();
	    posY          = currLayerDeep * 250;
	    posX          = nodePosLayer * 400;
	    //����״̬ȷ����ɫ
	    nodeStatusColor    = "sysconst.ClaimStatus" + nodeStatus;
	    nodeColor     = AppConfig.get(nodeStatusColor);
	    nodeTitle     = "ҵ���:" + swfLogNodeDto.getBusinessNo() + "\n������Ա:"+swfLogNodeDto.getHandlerName()+ "\n����ʱ��:"+swfLogNodeDto.getFlowInTime()+ "\n����ʱ��:"+swfLogNodeDto.getHandleTime()+ "\n����ʱ��:"+swfLogNodeDto.getSubmitTime();

	    //System.out.println("----X="+posX+ "|Y="+posY+"|treeLayer=" + currLayerDeep + "|nodePosLayer=" +  nodePosLayer+ "|nodeCount="+nodeCount + "|nodeStatus=" + nodeStatus +"######");

	    //���ݽڵ���Ϣ���ڵ�
	%>
         <%
         //modify by lixiang add 20050311 start
          //reason:��ʾ����ͼ�������/��Ա����ʱ����ʾ��Ҳ����
          %>

	  <v:rect style='position:relative;top:<%=posY %>;left:<%=posX %>;width:300;height:50;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='blue' title="<%=nodeTitle%>">
	  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=strInfoLink%>><%=nodeDispName%></a></v:TextBox></center>
 	  </v:rect>
	  <v:rect style='position:relative;top:<%=posY+45 %>;left:<%=posX %>;width:300;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
	  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><%=swfLogNodeDto.getHandlerName()%> <%= swfLogNodeDto.getStopTimeDesc() %></v:TextBox></center>
 	  </v:rect>
	 <%//modify by lixiang add 20050311 end
     //add by lixiang start at 2005-12-30
	   //reason:ȥ���������˲�����״̬��ʾ
	  if (nodeType.equals("compe")) //ȥ��״̬��ʾ
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
    int bigTreeLayer = 0 ;   //���Ĳ�
    int bigNodePosLayer = 0; //���ڵ�λ��
	  for(int i=0;i<treePathLogList.size();i++)
	  {
	    //�õ�·��
	    SwfPathLogDto swfPathLogNodeDto = (SwfPathLogDto)treePathLogList.get(i);
	    startNodeNo = swfPathLogNodeDto.getStartNodeNo();
	    //�õ�·����Ӧ��ڵ�

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

         //�õ�·����Ӧ�սڵ�

      endNodeNo = swfPathLogNodeDto.getEndNodeNo();
	    for(int k=0;k<treeSwfLogList.size();k++)
	    {
	        SwfLogDto swfLogEndDto = (SwfLogDto)treeSwfLogList.get(k);

	        if(endNodeNo==swfLogEndDto.getLogNo())
	        {
				    currLayerDeep = swfLogEndDto.getTreeLayer();
				    //�õ����Ĳ�
				    if(currLayerDeep>bigTreeLayer)
				    {
				        bigTreeLayer = currLayerDeep;
				    }

				    nodePosLayer  = swfLogEndDto.getNodePosLayer();
				    //�õ����Ľڵ�λ��
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
				       //����ǿ��������ص�,����ƫ��
				       endPosX       = nodePosLayer * 400 +150-50;
				    }
				    break;
          }

     }

	    //���ݽڵ���Ϣ����
	%>
       <v:line style="POSITION: relative;z-index:9"  from="<%=startPosX%>,<%=startPosY%>" to="<%=endPosX%>,<%=endPosY%>"><v:stroke endarrow = "classic"></v:stroke></v:line>
	<%

	}

	//�ڵ������ɫ˵��
%>
<!--added by zhangli 20070427 �����������֧��״̬-->
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
           //payList�����ηŵ����������,������������,��������֧���ܽ��,��������֧��������� 
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
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=compensateStrInfoLink%>>δ֧��</a></v:TextBox></center>
		 	</v:rect> 
           <%}else {%>
		    <v:rect style='position:relative;top:<%=posY +300%>;left:<%=posXcur%>;width:600;height:60;z-index:8;' fillcolor='<%=nodeColor%>' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'><a href=<%=compensateStrInfoLink%>>��֧��</a></v:TextBox></center>
		 	</v:rect> 
		 	<%}%>
		     <v:rect style='position:relative;top:<%=posY +300+55 %>;left:<%=posXcur %>;width:600;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>������ţ�<%=compensateNo%></v:TextBox></center>
		 	</v:rect>
		     <v:rect style='position:relative;top:<%=posY +300+110 %>;left:<%=posXcur %>;width:600;height:60;z-index:1;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 85.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>�������ˣ�<%=insuredName%></v:TextBox></center>
		 	</v:rect>
		    <v:rect style='position:relative;top:<%=posY +300+160 %>;left:<%=posXcur %>;width:600;height:50;z-index:8;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>�ü�������֧������ܶ<%=payedFee%>Ԫ</v:TextBox></center>
		 	</v:rect>
		 	 <%
           if(("".equals(payedFee))||("0.0".equals(payedFee))||("0.00".equals(payedFee))||payedFee==null){}else{
           %>
		    <v:rect style='position:relative;top:<%=posY +300+210 %>;left:<%=posXcur %>;width:600;height:50;z-index:8;' strokeColor='blue' title="<%=nodeTitle%>">
			  <center><v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '0.5pt,2.5pt,0.5pt,0.5pt'>���֧�����ڣ�<%=payedDate%></v:TextBox></center>
		 	</v:rect>               
 <%       }
          posXcur = posXcur+650;  
         }       
      
     }
 %>     


<v:rect style='position:relative;top:100;left:1630;width:350;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 100.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '13pt,2pt,0pt,0pt'>�ڵ������ɫ˵��</v:TextBox>
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
<%//�����������˵��%>
  <v:rect style='position:relative;top:<%=topWfDetail%>;left:20;width:350;height:50;z-index:8;' fillcolor='#FFFFFF' strokeColor='green'>
	  <v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 9pt; LEFT:auto; MARGIN-LEFT: 4.562pt; WIDTH: 100.875pt; TOP:auto; HEIGHT: 25.687pt' inset = '20pt,2pt,0pt,0pt'>��������˵��</v:TextBox>
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
	//������ѵ�չ�ֳߴ�
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
   <tr><td colspan=8 class="formtitle">�����������б�</td></tr>
     <tr class=listtitle>
        <td align="center">�ڵ��</td>
        <td align="center">�ڵ�����</td>
        <td align="center">ҵ���</td>
        <td align="center">������Ա</td>
        <td align="center">����ʱ��</td>
        <td align="center">����ʱ��</td>
        <td align="center">����ʱ��</td>
        <td align="center">��ǰ״̬</td>
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
         ����ѯ��<%= index %>�����������ļ�¼
        </td>
      </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">

</script>
</html>