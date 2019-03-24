<%--
****************************************************************************
* DESC       �������ⰸ������Ϣ����ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2005-04-17
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************

--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>

<head>
    <!--��title����-->

<html:html locale="true">
 <!--�����ⰸ������Ϣ�������-->
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <script language=javascript>
  
      function saveForm()
      {
       var context = fm.Context.value;
        var boxCheckFlag='0';
           if(typeof document.all["haveClaimNo"] == "undefined")
            {
           errorMessage("Ԥ�ⰸ����֮ǰ��������!");
            fm.Context.focus();
          return false;
        }else{
            var claimNoBox = document.getElementsByName("claimNoBox");
            for(var i=1;i<claimNoBox.length;i++){
                if(fm.claimNoBox[i].checked){
                  boxCheckFlag='1';
                   break;
                }
            }
            if(boxCheckFlag=='0'){
              errorMessage("��ѡ��������!");
                   fm.Context.focus();
                   return false;
              }
        }
        
        if(!checkList()){
          fm.Context.focus();
          return false;
        }
        context=rightTrim(context);
        context=leftTrim(context);
        if(context.length<1)
        {
           errorMessage("Ԥ�ⰸ����ԭ����Ϊ��!");
          fm.Context.focus();
          return false;
        }
        fm.buttonSave.disabled = true;
        fm.submit();

      }
      //add by zhangyingrui start at 20060808
      /**
       *@description �������������嵥 
       *@param       businessNo 
       */
       function doCertifyDirect(businessNo,nodeType){      
          window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
        }  
       //add by zhangyingrui start at 20060808
      
      function checkPrepay(obj){
           if (typeof document.all["claimNoBox"] == "undefined"){
               errorMessage("Ԥ�ⰸ����֮ǰ��������!");
               return false;
           }else{
                  var configCode = document.getElementsByName("configCode");
                  var claimNoFlag = document.getElementsByName("claimNoFlag");
                  for(var i=1;i<configCode.length;i++){
                    var riskCode = fm.riskCode.value;//add by kangzhen  061116
                      if(i == parseInt(obj.value,10)){
                          fm.claimNoFlag[i].value = '1';
                      }else{
                          fm.claimNoFlag[i].value = '0' ; 
                      }                           
                      /*ע�͵���
                      if(i == parseInt(obj.value,10) && configCode[i].value != 'RISKCODE_DAZ' && obj.checked
                        &&riskCode.substring(0,2) != '01'){//modify by kangzhen 061116
                          alert(riskCode.substring(0,2));
                          alert(parseInt(obj.value,10));
                          alert(configCode[i].value);
                          alert(riskCode.substring(0,2));
                          errorMessage("��ҵ���ղ��ɽ���"+fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].text+"����!");
                          return false;
                      }
                      */
                      //�����ʲô��˼ѽ�� obj.value,10������
                      /*
                      if(configCode[i].value == 'RISKCODE_DAZ' && obj.checked&&fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].value=="5"){
                          
                          errorMessage("ǿ�Ʊ��ղ��ɽ���"+fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].text+"������!");
                          return false;
                      }
                      */
                  }
              }
      }
      function checkList(){
        if (typeof document.all["claimNoBox"] != "undefined"){
            var configCode = document.getElementsByName("configCode");
            var claimNoBox = document.getElementsByName("claimNoBox"); 
            for(var i=1;i<configCode.length;i++){
                if(configCode[i].value != 'RISKCODE_DAZ'&&configCode[i].value != 'RISKCODE_DAY'&&configCode[i].value != 'RISKCODE_DAU' && fm.claimNoBox[i].checked&&fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].value!="5"){
                    errorMessage("��ҵ���ղ��ɽ���"+fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].text+"����!");
                    return false;
                }
                /* 
                if(configCode[i].value == 'RISKCODE_DAZ' && fm.claimNoBox[i].checked&&fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].value=="5"){
                    errorMessage("ǿ�Ʊ��ղ��ɽ���"+fm.specialCaseCaseType.options[fm.specialCaseCaseType.selectedIndex].text+"����!");
                    return false;
                }
                */
            }
            return true;
        }
      }
      
      function getClaimNo()
      {
        var configCode = document.getElementsByName("configCode");
        var claimNoBox = document.getElementsByName("claimNoBox"); 
        for (var i = 1;i<configCode.length;i++){
            if(fm.claimNoBox[i].checked){
              fm.prpLclaimNo.value = fm.ClaimNo[i].value;
              }
          }
      }
      
      
    </script>
  </head>

<%
    List  prpLclaimDtoList = (ArrayList)request.getAttribute("prpLclaimDtoList");
    UICodeAction   uiCodeAction    = new UICodeAction();
%>

<body  onload="initPage();">
<form name=fm action="/claim/specailCaseSave.do" method="post" onsubmit="return validateForm(this);" onload="getClaimNo()">
       <!--add by zhangyingrui start at 20060808-->
   <table  cellpadding="0" cellspacing="0" class="common" align="center">
       <tr>
       <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
       <!-- modify by zhaolu 20060902 start-->
       <td width="20%"><input type="button" name="prpLmessageSave" class="bigbutton" value="���⹵ͨ" onclick="openWinSaveQuery(fm.RegistNo.value,fm.policyNo.value,fm.riskCode.value,'certi',fm.ClaimNo.value,'registNo',fm.RegistNo.value);"></td>
       <!-- modify by zhaolu 20060902 end-->
       <td width="20%"><input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.RegistNo.value,'certi',fm.swfLogLogNo.value);"></td> 
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="�����嵥" onClick="doCertifyDirect(fm.RegistNo.value,'certi')"></td> 
       <td align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>       
      </tr>
  </table>

  <!--add by zhangyingrui end at 20060808-->

    <input type="hidden" name="configCode" class="common" value="">
    <input type="checkbox" name="claimNoBox" style="display:none" class="common" value="">
    <input type="hidden" name="ClaimNo" class="common" value="">
    <input type="hidden" name="claimNoFlag" class="common" value="">
      <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
         <tr><td class="formtitle" colspan="4">������Ϣ����</td></tr>
         <tr>
            <td class="title" colspan="4">Ԥ�ⰸ������Ϣ����
                <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
                <input type="hidden" name="nodeStatus" class="common" value="<%=request.getParameter("status")%>">

           </td>

         </tr>

         <tr>
            <td class="title" ><bean:message key="db.prpLclaim.claimNo" />:</td>
            <td class="input" colspan=3 >
              <%
              if(prpLclaimDtoList != null && prpLclaimDtoList.size()>0){%>
              <input type="hidden" name="haveClaimNo" class="common" value="">
              <%
                  String policyNo = "";
                  String configCode = "";
                  String flag = "";   //�ж��Ƿ�ע��
            for(int i=0;i<prpLclaimDtoList.size();i++){
                    PrpLclaimDto prpLclaimDto =new PrpLclaimDto();
                    prpLclaimDto = (PrpLclaimDto)prpLclaimDtoList.get(i);
                    policyNo = prpLclaimDto.getPolicyNo();
              configCode = uiCodeAction.translateRiskCodetoConfigCode(prpLclaimDto.getRiskCode());
              if("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode))
              {
        %>
                    <input type="radio" name="claimNoBox" title="������" maxlength="22" value="<%=i+1%>" onblur="checkPrepay(this);getClaimNo()"><%=prpLclaimDto.getClaimNo()%>&nbsp;&nbsp;&nbsp;&nbsp;�����ţ�<%=policyNo%><br>
                          <input type="hidden" name="ClaimNo" class="common" value="<%=prpLclaimDto.getClaimNo()%>">
                          <!--add by zhaolu 20060902 start -->
                          <input type="hidden" name="policyNo" value="<%=policyNo%>">
                          <input type="hidden" name="riskCode" value="<%=request.getParameter("riskCode")%>">
                          <!--add by zhaolu 20060902 end -->
                          <input type="hidden" name="claimNoFlag" class="common" value="0">
                          <input type="hidden" name="configCode" class="common" value="<%=configCode%>">
              
        <%
                            }       
              else
              { 
        %>
                   <input type="radio" name="claimNoBox" title="������" maxlength="22" value="<%=i+1%>" onblur="checkPrepay(this);getClaimNo()"><%=prpLclaimDto.getClaimNo()%>&nbsp;&nbsp;&nbsp;&nbsp;�����ţ�<%=policyNo%><br>
                   <!--add by zhaolu 20060902 start -->
                   <input type="hidden" name="policyNo" value="<%=policyNo%>">
                   <input type="hidden" name="riskCode" value="<%=request.getParameter("riskCode")%>">
                  <!--add by zhaolu 20060902 end -->
                   <input type="hidden" name="ClaimNo" class="common" value="<%=prpLclaimDto.getClaimNo()%>">
                   <input type="hidden" name="claimNoFlag" class="common" value="0">
                   <input type="hidden" name="configCode" class="common" value="<%=configCode%>">
                  <%
            }
          }
              }
              %>
            </td>
         </tr>
           
           <input type="hidden" name="prpLclaimNo">
     
         <tr>

            <td class="title" > �ⰸ����ѡ��
            </td>
            <td class="input" >
             <input type="hidden" name="prplclaimClaimNo" class="common" value="">

             <!--modify by zhangyingrui start at 20060807-->
             <select name="specialCaseCaseType" property="<bean:write name='swfLogDto' property='typeFlag' filter='true' />" onblur="checkList()" >
               <!-- <option value="3" >ͨ��</option>-->
                <!--  <option value="4" >Ԥ������</option> -->
                 <!-- <option value="6" >����</option>-->
                
                <option value="7" >Ԥ-֧�����ȷ�</option>
                <option value="8" >�渶���ȷ�</option>
                
                
                <option value="5" >Ԥ��</option>
             </select>
             <!--modify by zhangyingrui end at 20060807-->
            </td>
            <td class="title" ><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" >
               <input type="text" name="RegistNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
            </td>
         </tr>

          <tr>


            <td class="title">����ʱ�䣺</td>
            <td class="input" >
                <input type=text name="specialCaseflowInTime" title="����ʱ��" class="readonly"  value="<bean:write name='swfLogDto' property='flowInTime' filter='true' />">

            </td>
            <td class="title" >������:</td>
            <td class="input">
               <input type="hidden" name="specialCaseDealerCode" title="�ⰸ������" class="readonly" value="<bean:write name='swfLogDto' property='handlerCode' filter='true' />">
               <input type=text name="specialCaseDealerName" title="�ⰸ������" class="readonly" value="<bean:write name='swfLogDto' property='handlerName' filter='true' />">

            </td>
         </tr>

         <tr>
             <td class="title" colspan="4">
              ����ԭ��
             </td>
         </tr>
         <tr>
           <td class="input" colspan="4" align="center">
             <textarea name='Context' wrap="hard" rows=15 cols=80 class=common ><bean:write name='swfLogDto' property='titleStr' filter='true' /></textarea>
           </td>


         </tr>
     </table>



  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">����Ԥ�ⰸ��Ϣ</td></tr>
     <tr>
        <td class="centertitle" >���</td>
        <td class="centertitle" >״̬</td>
        <td class="centertitle" >����</td>
        <td class="centertitle" >ҵ���</td>
        <td class="centertitle" >Ԥ�ⰸ��</td>
        <td class="centertitle" >������</td>

     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogDtoList1"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
     <tr> <td align="center"><%=index+1%></td>
      <td align="center">
        <logic:equal name="swfLogDtoList1" property="nodeStatus" value='0' >
         δ����
        </logic:equal>
        <logic:equal name="swfLogDtoList1" property="nodeStatus" value='2' >
         ������
        </logic:equal>
        <logic:equal name="swfLogDtoList1" property="nodeStatus" value='4' >
         ���ύ
        </logic:equal>
      </td>

      <td align="center">
      <logic:equal name="swfLogDtoList1" property="typeFlag" value="3">ͨ��</logic:equal>
      <logic:equal name="swfLogDtoList1" property="typeFlag" value="4">Ԥ��</logic:equal>
      <logic:equal name="swfLogDtoList1" property="typeFlag" value="5">Ԥ��</logic:equal>
      <logic:equal name="swfLogDtoList1" property="typeFlag" value="7">Ԥ-֧�����ȷ�</logic:equal>
      <logic:equal name="swfLogDtoList1" property="typeFlag" value="8">�渶���ȷ�</logic:equal>
      </td>
        <td align="center"><bean:write name="swfLogDtoList1" property="keyIn"/></td>
        <td align="center"><bean:write name="swfLogDtoList1" property="keyOut"/> </td>
        <td align="center"><bean:write name="swfLogDtoList1" property="policyNo"/></td>

      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
   <tr class="listtail">
     <td colspan="6">
       ����ѯ��<%= index %>�����������ļ�¼
     </td>
   </tr>
    </table>
    </tr>
  </table>


     <table class="common" align="center" width="80%">
        <tr>
          <%String dfFlag=request.getParameter("dfFlag");
      
        if("Y".equals(dfFlag) ){
        %>  
         <td class=button style="width:33%" align="center">
              <!--ȡ����ť-->
              <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
            </td>
           <% }else {%> 
           <td class=button style="width:50%" align="center">
              <!--ȷ ����ť-->
              <input type=submit name=buttonSave class='button' value="<bean:message key='button.submit.value' />" onclick="return saveForm();getClaimNo()">

           </td>
           <td class=button style="width:25%" align="center">
           <!--ȡ����ť-->
            <input type="button" name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >

           </td>

        <!--ȡ����ť-->
         <td class=button style="width:25%" align="center">
        <input type=hidden name="nodeType" title="�ڵ�����" class="readonly" value="<%=request.getParameter("nodeType")%>">
        <input type=hidden name="businessNo" title="ҵ�����" class="readonly" value="<%=request.getParameter("bussinessNo")%>">

           </td>
           <% }%>    
  </tr>
     </table>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
