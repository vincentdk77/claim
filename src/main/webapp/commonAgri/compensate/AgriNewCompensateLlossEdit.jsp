<%--
****************************************************************************
* DESC       ���⸶�����Ϣҳ��
* AUTHOR     ��qianxiantao
* CREATEDATE �� 2011-10-31
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>

<%--���������Զ���JavaScript������--%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade"%>
<%@page import="com.sinosoft.prpall.schema.PrpCvirturlItemSchema"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto"%>
<%@page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<%@page import="com.gyic.claim.ui.control.facade.UIClaimPlantingSettleLoadFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
  <%
  UIClaimPlantingSettleLoadFacade uIClaimPlantingSettleLoadFacade = new UIClaimPlantingSettleLoadFacade();
  String policyNoForHn= request.getParameter("policyNo");
     String settleListCode=(String)request.getAttribute("settleListCode");
     String disabledFlag="";
     String disableEditSettleList = "disabled";
     String disableViewSettleList = "disabled";
  if(editType.equals("SHOW")){
     disabledFlag="disabled";
     disableViewSettleList = "";
  %>
     <jsp:include page="/commonAgri/compensate/AgriNewCompensateLlossEditIni.jsp"/>
  <%  
  }else if(editType.equals("EDIT")){
  	disableEditSettleList = "";
  %>
     <jsp:include page="/commonAgri/compensate/AgriNewCompensateLlossEditIni.jsp"/>
  <%
  }else if("ADD".equalsIgnoreCase(editType))  	
  	disableEditSettleList = "";
  %>
<script language="javascript">
      //��������뱾ҳ�Զ����JavaScript����
       /*
       *����ձ�Ķ������ս��֮���Ƿ񳬹��˸��ձ�ı���
       */
       function checkKindAmount(field,times){  
 
            //��������ձ�����˫�����¼������´����������������times����first�����粻������жϣ�����˫���ձ��ǿ��ܻᵯ��������ͬ����ʾ          
            if(times == "first"){
                field.select();
                field.focus();
                return false;           
            }
            var kindCode ;          //�ձ�
            var kindName ;          //�ձ�����
            var amount = 0;     
            var allAmount = 0;      //���ս��
            var allAmountTemp = 0;
            var lossSerialNo = 0;   //���
            var lossItemCode ;      //��ʧ��Ĵ���
            var lossItemName ;      //��ʧ�������
            var strClassCode = fm.classcodeM.value; 
            for(var i = 0;i < fm.all(field.name).length;i++){                
                if(field == fm.all("prpLlossDtoAmount")[i]){ 
                    if(strClassCode == '31' || fm.prpLcompensateRiskCode.value == "3219" || fm.prpLcompensateRiskCode.value == "3221"){
                     var test = fm.all("prpLlossDtoAmountDisplay")[i].value;
                     var n = test.split("-");
                     allAmount  = parseFloat(n[1]);
                    }else{                                       
                    allAmount  = parseFloat(fm.all("prpLlossDtoAmountDisplay")[i].value);
                    }
                    if(isNaN(allAmount))
                        allAmount = 0;
                    kindCode = fm.all("prpLlossDtoKindCode")[i].value;
                    kindName = fm.all("prpLlossDtoKindName")[i].value;
                    lossSerialNo = fm.all("prpLlossSerialNo")[i].value;
                    lossItemCode = fm.all("prpLlossDtoItemCode")[i].value;
                    lossItemName = fm.all("prpLlossDtoLossName")[i].value;
                }
            }
            //����ҳ��������ĸ�����ʧ��Ϣ�ı��ս��ĺ�
            for(var i = 0 ;i < fm.all(field.name).length;i++){                
                if(  fm.all("prpLlossSerialNo")[i].value    == lossSerialNo 
                  && fm.all("prpLlossDtoKindCode")[i].value == kindCode
                  && fm.all("prpLlossDtoItemCode")[i].value == lossItemCode){
                    amount = parseFloat(fm.all("prpLlossDtoAmount")[i].value);
                    if(isNaN(amount))
                        amount = 0;
                    allAmountTemp = allAmountTemp + amount;                    
                }
            }            
            if(allAmountTemp > allAmount){
              field.select();
                field.focus();
                alert("�������� ��" + fm.all("prpLlossDtoFamilyName")[lossSerialNo].value + "�� " + kindName + "��" + lossItemName +"��" + "������ʧ��Ϣ�ı��ս��֮�ͣ�\n"
                        + "�����˸��ձ�ı��ս�"+ allAmount + "��");
                
                return false;
            }
            
       }
       function calBackMainAgri(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("�������ɱ����Ϣ��");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
         if(SettleAreaAll==""||SettleAreaAll==null){
         for(var i=0;i<fm.all("prpLlossDtoSettleArea").length;i++){       
             SettleArea=parseFloat(fm.all("prpLlossDtoSettleArea")[i].value);  
             if(isNaN(SettleArea)){
             SettleArea=0;
             }
             SettleAreaTemp=SettleAreaTemp+SettleArea
         }
         fm.prpLcompensateLossesNumber.value=round(SettleAreaTemp,3);
         fm.prpLcompensateAffectedArea.value=round(SettleAreaTemp,3);
         fm.prpLcompensateDisasterArea.value=round(SettleAreaTemp,3);
         }else{
         fm.prpLcompensateLossesNumber.value=round(parseFloat(SettleAreaAll),3);
         fm.prpLcompensateAffectedArea.value=round(parseFloat(SettleAreaAll),3);
         fm.prpLcompensateDisasterArea.value=round(parseFloat(SettleAreaAll),3);
         }
         if(NoProductionArea==""||NoProductionArea==null){
         for(var i=0;i<fm.all("prpLlossDtoSettleArea").length;i++){
             if(fm.all("indemnityDutyRate")[i].value>=80){
             ProductionArea=ProductionArea+parseFloat(fm.all("prpLlossDtoSettleArea")[i].value);  
             }
         }
         fm.prpLcompensateNoProductionArea.value=round(ProductionArea,3);
         }else{
          fm.prpLcompensateNoProductionArea.value=round(parseFloat(NoProductionArea),3);
         }
         fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       function flashCompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("���������嵥��");
            return false;
          }
          if(checkCoinsPaidLossType() == false ){
			  return false ; 
		  }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim//CompensateNewLoss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       
       function checkFamilyName(){
        var FamilyName =fm.prpLlossDtoFamilyName.value;
        if(FamilyName==null || trim(FamilyName)==""){
             alert("�������˲���Ϊ�գ�");
             fm.creatCompensateLlossFlag.value="0";
             fm.prpLlossDtoFamilyName.focus();
             return false;
        }else{
             return true;
        }
       }
       /**
      * Ԥ�����嵥ҳ�浯��
      */
      function openCompensateSettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/settleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      /**
      * ������������ũ��Ԥ�����嵥ҳ�浯��
      */
      function openCompensate31SettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/planting31SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      
       /**
      * ������������ũ��Ԥ�����嵥ҳ�浯��
      */
      function openCompensate3224SettleListPage(editType,nodeType){
        var policyNo = fm.policyno.value;
    	var registNo = fm.registno.value;
    	var claimNo = fm.prpLcompensateClaimNo.value;
    	var compensateNo = fm.prpLcompensateCompensateNo.value;
      	var newWindow = window.open("/claim/planting3224SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst='isFirst'&compensateNo="+compensateNo+"&claimNo="+claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
      /**
      * ������������ũ�������⸶�����Ϣ
      */
         function flash31CompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("���������嵥��");
            return false;
          }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim/CompensatePlanting31Loss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       
          function flash3224CompensateLoss(policyNo,claimNo,settleListCode){
          fm.creatCompensateLlossFlag.value="1";
          if(checkFamilyName()==false){
            return false;
          }
          var policyno=policyNo.value;
          var claimno=claimNo.value;
          var settlelistCode=settleListCode.value;
          if(settlelistCode==null || trim(settlelistCode)==""){
            alert("���������嵥��");
            return false;
          }
          var oldAction = fm.action;
          var oldTarget = fm.target;
          fm.action='/claim/CompensatePlanting3224Loss.do?claimNo='+claimno+'&policyNo='+policyno+'&SettleListCode='+settlelistCode;
          fm.target="fraSubmit";
          fm.submit();
          fm.action=oldAction;
          fm.target=oldTarget;  
       }
       /**
       * ������������ũ�ջ����⸶�����Ϣ
       */
       function calBackMainAgriPlanting31(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("�������ɱ����Ϣ��");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
         
         fm.prpLcompensateLossesNumber.value=fm.SettleAreaAll.value;
         fm.prpLcompensateAffectedArea.value=fm.SettleAreaAll.value;
         fm.prpLcompensateDisasterArea.value=fm.SettleAreaAll.value;
         
         
         fm.prpLcompensateNoProductionArea.value=fm.NoProductionArea.value;
         fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       
        function calBackMainAgriPlanting3224(){
         var SettleArea=0;
         var SettleAreaTemp=0;
         var ProductionArea=0;
         var SettleAreaAll=fm.SettleAreaAll.value;
         var NoProductionArea=fm.NoProductionArea.value;
         fm.calBackMainAgriFlag.value="1";
         if(fm.creatCompensateLlossFlag.value=="0"){
            alert("�������ɱ����Ϣ��");
            fm.calBackMainAgriFlag.value="0";
            return false;
          }
         
         fm.prpLcompensateLossesNumber.value=fm.SettleAreaAll.value;
         fm.prpLcompensateAffectedArea.value=fm.SettleAreaAll.value;
         fm.prpLcompensateDisasterArea.value=fm.SettleAreaAll.value;
         
         
         fm.prpLcompensateNoProductionArea.value=fm.NoProductionArea.value;
         fm.prpLcompensateDamageInsured.value=fm.DamageInsured.value; 
       }
       
       
          </script>

<table class="common" align="center">
  <!--��ʾ��ʾ���е�-->

  <%
    PrpDexchDto prpDexchDto;
    Collection prpdexchDtoList = (Collection) request
        .getAttribute("prpdexchDtoList");
    if (prpdexchDtoList != null) {
      Iterator itprpdexch = prpdexchDtoList.iterator();
      while (itprpdexch.hasNext()) {
        prpDexchDto = (PrpDexchDto) itprpdexch.next();
        out
        .println("  <input type=\"hidden\" name=\"baseCurrency\""
        + " value=\""
        + prpDexchDto.getBaseCurrency()
        + "\""
        + "\">");
        out
        .println("  <input type=\"hidden\" name=\"exchCurrency\""
        + " value=\""
        + prpDexchDto.getExchCurrency()
        + "\""
        + "\">");
        out.println("  <input type=\"hidden\" name=\"exchRate\""
        + " value=\"" + prpDexchDto.getExchRate() + "\""
        + "\">");
      }
    }
  %>
 
  <tr>
    <td class="subformtitle" colspan="4" style="text-align: left"><img
      style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
      name="lLossImg" onclick="showPage(this,spanlLoss)">�⸶�����Ϣ<br>
    <span id="spanlLoss" style="display: none"> <%-- ��������չ���� --%>
    <table id="lLoss" class="common" align="center" cellspacing="1"
      cellpadding="0">
      <thead>       
      <%if( null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(restrRiskCode) > -1 ){ %>
      <tr>
        <td class="title" colspan=2 style="width: 100%">
          <logic:notEmpty name="prpLacciPersonDto"
          property="prpLagriPersonList">
          <logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
            property="prpLagriPersonList" length="1" offset="0">
            <tr>
              <div align="center"><input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
              </div>
              <td class="subformtitle" style="width: 100%">
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
                    <input type="hidden" name="prpLlossDtoFamilyNo"
                      value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex"
                    value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonAge"
                    value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
                    value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flash31CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgriPlanting31();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px"
                    value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensate31SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate31SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </tr>
          </logic:iterate>
          </logic:notEmpty>
          <logic:empty name="prpLacciPersonDto" property="prpLagriPersonList">
            <tr>            
              <td class="subformtitle" style="width: 100%" colspan="2">
              <input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="1"/>
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode">
                    <input type="hidden" name="prpLlossDtoFamilyNo">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex">
                  <input type="hidden" name="prpLclaimAcciPersonAge">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flash31CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgriPlanting31();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td align="center">        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensate31SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td align="center">
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate31SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </td>
                </tr>
          </logic:empty>
                </thead>
          <tfoot>
          <%if("C".equalsIgnoreCase(versionType) &&"3141".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ��ܺ���Ĥ���⳥��<br>
           &emsp;&emsp;��λ���� �� ��ʧ�̶� �� ��ʧ���<br>
           �߲�ȫ���⸶��<br>
          &emsp;&emsp;��λ���� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⳥���� �� (1- ����������)<br>
           �߲˲�����ʧ�⸶��<br>
           &emsp;&emsp;��λ���� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⳥���� �� ��ʧ�̶� �� (1- ����������)<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("3140".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ��ܺ���Ĥ���⳥��<br>
           &emsp;&emsp;��λ���� �� ��ʧ�̶� �� ��ʧ���<br>
           �߲�ȫ���⸶��<br>
          &emsp;&emsp;��λ���� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⳥����<br>
           �߲˲�����ʧ�⸶��<br>
           &emsp;&emsp;��λ���� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⳥���� �� (��ʧ�̶� - ����������)<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else { %>
          <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;�����ս��-��ֵ���� �⸶���� ����1-�����ʣ�-�����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;�����ս��-��ֵ���� �⸶���� �� ��ʧ�� ����1-�����ʣ�-�����<br>
           </font>
           </td>
           </tr>
           <%} %>
           </tfoot>
           </td>
        </tr>
      <%}else if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(restrRiskCode) > -1)
      {
      %>
      
         <tr>
        <td class="title" colspan=2 style="width: 100%">
          <logic:notEmpty name="prpLacciPersonDto"
          property="prpLagriPersonList">
          <logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
            property="prpLagriPersonList" length="1" offset="0">
            <tr>
              <div align="center"><input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
              </div>
              <td class="subformtitle" style="width: 100%">
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
                    <input type="hidden" name="prpLlossDtoFamilyNo"
                      value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex"
                    value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonAge"
                    value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
                    value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flash3224CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgriPlanting3224();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px"
                    value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensate3224SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate3224SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </tr>
          </logic:iterate>
          </logic:notEmpty>
          <logic:empty name="prpLacciPersonDto" property="prpLagriPersonList">
            <tr>            
              <td class="subformtitle" style="width: 100%" colspan="2">
              <input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="1"/>
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode">
                    <input type="hidden" name="prpLlossDtoFamilyNo">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex">
                  <input type="hidden" name="prpLclaimAcciPersonAge">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flash3224CompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgriPlanting3224();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px">
                  </td>
                </tr>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td align="center">        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensate3224SettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td align="center">
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate3224SettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
                </table>
                </td>
                </tr>
          </logic:empty>
                </thead>
          <tfoot>
          <tr>
          <td class="title" colspan=2 style="width: 100%">
          <% if(restrRiskCode.equals("3173") && !"B".equalsIgnoreCase(versionType) ) {%>
          <font color="#ED1B24">
           (����)ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           (����)������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ�� ����1-�����ʣ�<br>
            (��Ĥ/���)�⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           </font>
           <% } else if(restrRiskCode.equals("3173") && "B".equalsIgnoreCase(versionType) ) {%>
          <font color="#ED1B24">
           (����ֲ��)�⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           (���ѹ�ʵ)��ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ�� ����1-�����ʣ�<br>
           </font>
           <% } else if(restrRiskCode.equals("3130")) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��1 - ���������ʣ�<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ����ʧ�� - ���������ʣ�<br>
           </font>
          <% } else if(restrRiskCode.equals("3232")) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ�� ����1-���������ʣ�<br>
           </font>
           <% } else if(restrRiskCode.equals("3160")) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           </font>
        	  <% } else if(restrRiskCode.equals("3134")) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶���� ����1-���������ʣ�<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶���� ������ʧ��-���������ʣ�<br>
           </font>
            <% } else if(restrRiskCode.equals("3169")) {%>
        	  <font color="#ED1B24">
          �⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��ʧ�� �� �⸶����<br>
           </font>
           <% } else if(restrRiskCode.equals("3102") && "D".equalsIgnoreCase(versionType)) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶���� �� ��ʧ��<br>
           </font>
            <% }
        	  else if(restrRiskCode.equals("3163")) {%>
        	  <font color="#ED1B24">
          (ʳ�þ�)ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶���� <br>
           (ʳ�þ�)������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� ��Ӧ��α��ս��ֲ����� �� �⸶���� �� ��ʧ��<br>
          (��Ĥ/���)�⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           </font>
            <% }
        	  else if(restrRiskCode.equals("3105") && "D".equalsIgnoreCase(versionType)) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���ս�� �� ��ʧ��� �� �⸶���� �� ��ʧ��<br>
           </font>
          <%}
        	  else if(restrRiskCode.equals("3182") ) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��ͬ�����ڵ�����⳥��׼�������������1-���������ʣ�<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��ͬ�����ڵ�����⳥��׼����ʧ�ʡ������������1-���������ʣ�<br>
           </font>
             <%}
        	  else if(restrRiskCode.equals("3183") ||restrRiskCode.equals("3180")) {%>
        	  <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��ͬ�����ڵ�����⳥��׼���������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��ͬ�����ڵ�����⳥��׼����ʧ�ʡ��������<br>
           </font>
          <%}
            else {%>
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;�����ս��-��ֵ���� �⸶���� ����1-�����ʣ�-�����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;�����ս��-��ֵ���� �⸶���� �� ��ʧ�� ����1-�����ʣ�-�����<br>
           </font>
          
          <% }%>
          
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
      <%
      }
      else{ %>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
          <logic:notEmpty name="prpLacciPersonDto"
          property="prpLagriPersonList">
          <logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
            property="prpLagriPersonList">
            <tr>
              <div align="center"><input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
              </div>
              <td class="subformtitle" style="width: 100%">
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
                    <input type="hidden" name="prpLlossDtoFamilyNo"
                      value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex"
                    value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonAge"
                    value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
                    value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flashCompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgri();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px"
                    value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
                  </td>
                </tr>
                <%if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3159,3139,3167,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td>        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensateSettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td>
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensateSettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>
		        <%}%>
		        
                </table>
                </tr>
          </logic:iterate>
          </logic:notEmpty>
          <logic:empty name="prpLacciPersonDto" property="prpLagriPersonList">
            <tr>            
              <td class="subformtitle" style="width: 100%" colspan="2">
              <input class="readonlyNo" type="hidden"
                name="prpLlossDtoSerialNo" description="���"
                value="1"/>
              <table cellpadding="0" cellspacing="1" class="common"
                style="width: 100%">
                <tr>
                  <td class="title" style="width: 15%">�������ˣ�</td>
                  <td class="input" style="width: 35%">
                    <input type="hidden" name="prpLclaimLossAcciCode">
                    <input type="hidden" name="prpLlossDtoFamilyNo">
                  <input type=text name="prpLlossDtoFamilyName" title="������������"
                    style="width: 180px" class="codecode" title="������������"
                    ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                    onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type="hidden" name="prpLclaimAcciPersonSex">
                  <input type="hidden" name="prpLclaimAcciPersonAge">
                  <input type="hidden" name="prpLclaimAcciPersonIdentifyNumber">

                  </td>                  
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="flashCompensateLoss(fm.prpLcompensatePolicyNo,fm.prpLcompensateClaimNo,fm.settleListCode);calFund();" >
                  <input type="hidden" name="creatCompensateLlossFlag" value="0"/>
                  </td>
                  <td> 
                  <input type=button class="bigbutton" style="cursor: hand" name="creatCompensateLloss" value="�����⸶�����Ϣ" <%=disabledFlag%> onclick="calBackMainAgri();calFund();" >
                  <input type="hidden" name="calBackMainAgriFlag" value="0"/>
                  </td>
                  <td class="title" style="width:15%;display:none">ţ�ţ�</td>
                  <td class="input" style="width: 35%"><%--��ũ���ó��ƺ��ֶ��ݴ�ţ��--%>
                  <input type="hidden" name="prpLlossDtoLicenseNo" description="ţ��"
                    class="common" onblur="checkInteger(this)"
                    style="width: 180px">
                  </td>
                </tr>
                <%if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3159,3139,3167,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176".indexOf(restrRiskCode) > -1){%>
		       <tr>
		        	<td class="title" style="width: 15%">
		        		�����嵥��
		        	</td>
		        	<td class="input" style="width: 35%">
		        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
		              <input type="hidden" name="editSettleListFlag" value="1"/>
		        	</td>
		        	<td align="center">        		
		              <input type="button" name="editSettleListButton" class='bigbutton' value="���������嵥" <%=disableEditSettleList%> onclick="openCompensateSettleListPage('edit','compe'); return false;"/>
		            </td>
		        	<td align="center">
		        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensateSettleListPage('view','compe'); return false;"/>
		        	</td>
		        </tr>  
        		<%}%>
                </table>
                </td>
                </tr>
          </logic:empty>
                </thead>
          <tfoot>
           <%if("3101,3107,3108,3122,3114,3126,3143,3145,3152,3153,3154,3155,3156,3194,3193".indexOf(restrRiskCode) > -1 && !"B".equalsIgnoreCase(versionType)){%>
          <tr>
           <!-- yx -->
        <%if(("3101".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3101","3101",policyNoForHn))
        		||	("3107".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3107","3107",policyNoForHn))	
        		||	("3108".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3108","3108",policyNoForHn))	
        	||	("3114".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3114","3114",policyNoForHn))	
        || ("3122".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3122","3122",policyNoForHn))
        || ("3151".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3151","3151",policyNoForHn))
        || ("3197".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3197","3197",policyNoForHn))
        || ("3152".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3152","3152",policyNoForHn))
        || ("3155".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3155","3155",policyNoForHn))
        || ("3156".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3156","3156",policyNoForHn))
         ||("3126".equals(restrRiskCode)&& !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN3126","3126",policyNoForHn))
        ){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           �⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������*��ʧ��<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%}else{%>
        
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;�����ս��-��ֵ���� �⸶��������1-�����ʣ�-�����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;�����ս��-��ֵ���� �⸶����������ʧ��-�����ʣ�-�����<br>
           &emsp;��<br>
           &emsp;&emsp;����ʧ���-��ֵ���� �⸶����������ʧ��-�����ʣ�-�����<br>  
           </font>
           </td>
           </tr>
        		<%} }else if("B".equalsIgnoreCase(versionType) &&(("3107".equals(restrRiskCode)&&uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN","3107",policyNoForHn))
        				||("3114".equals(restrRiskCode)&&uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN","3114",policyNoForHn))
        				|| "3185".equals(restrRiskCode))){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������*��1-�����ʣ�<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������*��1-�����ʣ�<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
          <%} else if("B".equalsIgnoreCase(versionType) 
        		  &&(("3107".equals(restrRiskCode)&&!uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN","3107",policyNoForHn))
        				  ||("3114".equals(restrRiskCode)&&!uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEHN","3114",policyNoForHn)))){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if(("B".equalsIgnoreCase(versionType) &&("3149".equals(restrRiskCode))|| ("3149".equals(restrRiskCode) && !uIClaimPlantingSettleLoadFacade.checkRiskVersion("CLAIM_VERSIONDATEAH3149","3149",policyNoForHn)))){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("3178".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("3158".equals(restrRiskCode) || "3179".equals(restrRiskCode)|| "3159".equals(restrRiskCode)|| "3139".equals(restrRiskCode)|| "3167".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("A".equalsIgnoreCase(versionType) &&"3149".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ���� �� ��ʧ���<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ���� �� ��ʧ�� �� ��ʧ��� ����1�����������ʣ�<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("3190".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;��λ����*�⸶����*�������<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("C".equalsIgnoreCase(versionType) &&"3177".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           �⸶��<br>
           &emsp;&emsp;��λ����*��ʧ��*�������*Ͷ�����<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%} else if("D".equalsIgnoreCase(versionType) &&"3177".equals(restrRiskCode)){%>
           <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
        &emsp;&emsp;��λ���� * �������<br>
         ������ʧ�⸶��<br>
         &emsp;&emsp;��λ���� * ��ʧ�� * �������<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%}else if("3132".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;��λ����*�⸶����*�������<br>
         ������ʧ�⸶��<br>
         &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������*��1-�����ʣ�<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      <%}else if("3157".equals(restrRiskCode)){%>
      <tr>
      <td class="title" colspan=2 style="width: 100%">
      <font color="#ED1B24">
       ȫ���⸶��<br>
      &emsp;&emsp;��λ����*�⸶����*�������<br>
       ������ʧ�⸶��<br>
       &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
       </font>
       </td>
       </tr>
       </tfoot>
       </td>
    </tr>
    <%}else if("3181".equals(restrRiskCode)){%>
      <tr>
      <td class="title" colspan=2 style="width: 100%">
      <font color="#ED1B24">
       ȫ���⸶��<br>
      &emsp;&emsp;��λ����*�⸶����*�������<br>
       ������ʧ�⸶��<br>
       &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
       </font>
       </td>
       </tr>
       </tfoot>
       </td>
    </tr>
    <%}else if("3170".equals(restrRiskCode)){%>
      <tr>
      <td class="title" colspan=2 style="width: 100%">
      <font color="#ED1B24">
       ȫ���⸶��<br>
      &emsp;&emsp;��λ����*�⸶����*�������<br>
       ������ʧ�⸶��<br>
       &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
       </font>
       </td>
       </tr>
       </tfoot>
       </td>
    </tr>
    <%}else if("31A6".equals(restrRiskCode)){%>
      <tr>
      <td class="title" colspan=2 style="width: 100%">
      <font color="#ED1B24">
       ȫ���⸶��<br>
      &emsp;&emsp;��λ����*�⸶����*�������<br>
       ������ʧ�⸶��<br>
       &emsp;&emsp;��λ����*�⸶����*��ʧ��*�������<br>
       </font>
       </td>
       </tr>
       </tfoot>
       </td>
    </tr>
    <%}else if("3191".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� ��  ��ʧ��� ����1��10%�� �� �⳥��� = ��λ���ս��  �� ��ʧ��� �� 1000
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� �� ��ʧ�� �� ��ʧ��� ����1��10%�� �� �⳥��� = ��λ���ս�� �� ��ʧ�� �� ��ʧ��� �� 1000
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      <%}else if("3172".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� ��  �⸶���� �� ��ʧ���
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� ��  �⸶���� �� ��ʧ�� �� ��ʧ��� ����1�����������ʣ� 
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
       <%}else if("3151".equals(restrRiskCode) && !"C".equalsIgnoreCase(versionType)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���� �� �⸶���� �� �������
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� �� �⸶���� �� ��ʧ�ʡ� ��ʧ���
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
          </tr>
       <%}else if(("3151".equals(restrRiskCode) && "C".equalsIgnoreCase(versionType)) || "3165".equals(restrRiskCode)|| "3166".equals(restrRiskCode)|| "3184".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ��ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� �� �⸶���� �� ��ʧ�� �� ��ʧ���
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      <%}else if("3197".equals(restrRiskCode) && "C".equalsIgnoreCase(versionType)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
        ȫ���⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���� �� �⸶���� �� �������
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ��λ���ս�� �� �⸶���� �� ��ʧ�ʡ� ��ʧ���
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      <%}else if("3187".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;��1-4����ĵ�����⳥��� = ��λ���ս�� �� ��ʧ�� �� ��ʧ���<br>
        &emsp;&emsp;��5����������ĵ�����⳥��� = ��λ���ս�� �� �⸶���� �� ��ʧ�� �� ��ʧ���
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;��1-4����ĵ�����⳥��� = ��λ���ս�� �� ��ʧ�� �� ��ʧ��� �� ��1 - ���������ʣ�<br> 
        &emsp;&emsp;��5����������ĵ�����⳥��� = ��λ���ս�� �� �⸶���� �� ��ʧ�� �� ��ʧ��� �� ��1 - ���������ʣ�
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      <%}else if("3176".equals(restrRiskCode)){%>
        <tr>
        <td class="title" colspan=2 style="width: 100%">
        <font color="#ED1B24">
         ȫ���⸶��<br>
        &emsp;&emsp;�⳥��� = ÿĶ���ս�� �� ��ʧ���
<br>
         ������ʧ�⸶��<br>
        &emsp;&emsp;�⳥��� = ÿĶ���ս�� �� ��ʧ�� �� ��ʧ���
<br>
         </font>
         </td>
         </tr>
         </tfoot>
         </td>
      </tr>
      	<%} else{%>
         <tr>
          <td class="title" colspan=2 style="width: 100%">
          <font color="#ED1B24">
           ȫ���⸶��<br>
          &emsp;&emsp;�����ս��-��ֵ���� �⸶���� ����1-�����ʣ�-�����<br>
           ������ʧ�⸶��<br>
           &emsp;&emsp;�����ս��-��ֵ���� �⸶���� �� ��ʧ�� ����1-�����ʣ�-�����<br>
           </font>
           </td>
           </tr>
           </tfoot>
           </td>
        </tr>
        <%}} %>
  <tr>
  <td style="width: 100%" colspan="2">
  <input type="hidden" name="classcodeM"  value="<bean:write name='prpLcompensateDto' property='classCode' />">
  <input type="hidden" name="DamageInsured"  >
  <input type="hidden" name="NoProductionArea"  >
  <input type="hidden" name="SettleAreaAll"  >
  <table class="common" style="display: none" id="LossDetail_Data"
    cellspacing="1" cellpadding="0">
    <tbody>
      <tr>
          <td class="inputsubsub">
            <input type="text" name="prpLlossDtoItemKindNo" class="readonly" readonly="readonly" style="width: 30px"> 
          </td>
        <td class="inputsubsub">
          <input type='hidden'name="prpLlossDtoFeeTypeCode"> 
        <input type='hidden'name="prpLlossDtoFeeTypeName">
        <input type='hidden'name='prpLlossDtoItemAddress'> 
        <input type='hidden'name='prpLlossDtoBuyDate' value="2004/12/12"> 
        <input type='hidden' name='prpLlossDtoDepreRate'> 
        <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />">
          <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type='hidden' name='prpLlossDtoUnit'> 
        <input type="hidden" name="prpLlossDtoLossQuantity"> 
        <input type="hidden" name="prpLlossDtoUnitPrice">
          <input type="hidden" name="prpLlossDtoIndemnityDutyRate"> 
          <input type="hidden" name="prpLlossDtoCurrency2"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrency2Name"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type="hidden" name="prpLlossDtoCurrency3"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrency3Name"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type="hidden" name="prpLlossDtoCurrency"
          value="<bean:write name='prpLcompensateDto' property='currency' />">
        <input type="hidden" name="prpLlossDtoCurrencyName"
          value="<bean:write name='prpLcompensateDto' property='currencyName' />">
        <input type='hidden' name='LossItemCode'>
        <input type='hidden' name="LossItemName" class='readonly' readonly>
        <input type="hidden" name="prpLlossDtoKindCode" description="�б��ձ�">
        <input type="input" name="prpLlossDtoKindName" class="codename"
          style="width: 150px"
          ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem1','-1,-21,5,6','always','none','post');"
          onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem1','-1,-21,5,6','always','none','post');">
        <input type="hidden" name="prpLlossMaxPaid"> 
        <input type="hidden" name="prpLlossHisPaid"></td>
        <td class="inputsubsub">
        <input type="hidden" name="prpLlossDetailSerialNo"> 
        <input type="hidden" name="prpLlossSerialNo">
        <input type="hidden" name="prpLlossDtoItemCode" > 
        <input name="prpLlossDtoLossName" class="readonly" readonly
          style="width: 110px"></td>
        <select name="calaType" style="display:none"
          class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
          <option value='1'>ȫ���⸶</option>
          <option value='2'>������ʧ�⸶</option>
          </select>   
        <select name="cala" style="display:none"
          class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
          <option value='1'>���ս�����</option>
          <option value='2'>�˶���ʧ����</option>
          </select> 
        <td class="inputsubsub">
            <input name="prpLlossDtoSettleArea" class="common" readonly style="width: 60px">
        </td>  
        <td class="inputsubsub">
            <input name="prpLlossDtoAmount" class="common"  readonly style="width: 60px"  >
           <input type="hidden" name="prpLlossDtoAmountDisplay" >
        </td>
          <input name="prpLlossDtoSumLoss" type="hidden"
          class="common" style="width: 60px"> 
        <td class="inputsubsub"><input name="prpLlossDtoClaimRate" readonly
          class="common" style="width: 40px" value="100">%
        </td>
        <!-- ��ʧ�� -->
        <td class="inputsubsub"><input name="indemnityDutyRate" readonly
                    class="common" style="width: 60px" >%</td>
        <td class="inputsubsub"><input name="prpLlossDtoDeductibleRate" readonly
          class="common" style="width: 40px" value="0.0">%</td>
          <input name="prpLlossDtoDeductible" type="hidden"
          type='text' class="input" style="width: 50px" value="0.0">
        <input name="prpLlossDtoSumRest" type="hidden"
          class="common" style="width: 60px">
        <td class="inputsubsub"><input name="prpLlossDtoSumRealPay"
          style="width: 80px" class='input' readonly onchange="calFund();calClaimRate(this);"></td>
        <logic:notEmpty name="coinsFlag"  >
			<logic:equal name='coinsFlag' value="2">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
			<logic:equal name='coinsFlag' value="1">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
		</logic:notEmpty>
      </tr>
    </tbody>
  </table>

  <table id="LossDetail" name="LossDetail" class="common" align="center" cellspacing="1" cellpadding="0" style="width: 100%">
             <thead>

                <tr>
                  <td class="centertitle">������</td>
                  <td class="centertitle">�б��ձ�</td>
                  <td class="centertitle">��ʧ���</td>
                  <td class="centertitle">�⸶���</td>
                  <td class="centertitle">����������ս��</td>
                  <td class="centertitle">�⸶����%</td>
                  <td class="centertitle">��ʧ��%</td>
                  <td class="centertitle">������%</td>
                  <td class="centertitle">�⳥���</td>
        
				<logic:notEmpty name="coinsFlag"  >
					<logic:equal name='coinsFlag' value="2">
                       <td class="centertitle">�������⳥���</br>�����ҷ�����������������</td>
					</logic:equal>
					<logic:equal name='coinsFlag' value="1">
                       <td class="centertitle">�������⳥���</br>�����ҷ�����������������</td>
					</logic:equal>
				</logic:notEmpty>
                </tr>
              </thead>
              <tfoot>
            </tfoot>
           <tbody>
          </tbody>
  </table>
  </td>
  </tr> 
  </table>
  </span>
  </td>
  </tr>
</table>  