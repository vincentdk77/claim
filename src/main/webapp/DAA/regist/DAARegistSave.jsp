<!--�ڲ�ͬ״̬�£�    ��ť�������ǲ�ͬ�ģ�-->
 <%-- (1)ADD,EDIT     "�ݴ�" "�ύ/��һ��" "ȡ��"
      (2)SHOW ���ύ  "����"
 --%>

<script language='javascript'>
function printWindow(bizNo,strWindowName,bizType)
      {if(isEmptyField(fm.prpLregistDamageStartDate)){
           alert("����ʱ�䲻��Ϊ�գ�");
           return false;
        }else{
	        if(bizType == null ){
	            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo; 
	        }else if(bizType == "P"){
	            var reportorName = fm.prpLregistReportorName.value;//������
	            var damageStartDate = fm.prpLregistDamageStartDate.value;//����ʱ��
	            var damageStartHour = fm.prpLregistDamageStartHour.value;//����Сʱ
	            var licenseNo = fm.prpLthirdPartyLicenseNo[1].value;//���ƺ���
	            var mainPolicyNo = fm.mainPolicyNo.value;
	            strUrl = "/claim/DAA/print/DAARegistNoneFormatPrint.jsp?printType=Regist&PolicyNo=" + bizNo + "&bizType=" + bizType ;
	            strUrl += "&damageStartDate=" + damageStartDate;
	            strUrl += "&damageStartHour=" + damageStartHour;  
	            strUrl += "&licenseNo=" + licenseNo
	            strUrl += "&mainPolicyNo=" + mainPolicyNo; 
	        }else{
	            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo;
	        }       
	        var pageWidth=screen.availWidth-10;
	        var pageHeight=screen.availHeight-30;
	        
	        if (pageWidth<100 )
	          pageWidth = 100;
	      
	        if (pageHeight<100 )
	          pageHeight = 100;
	      
	        var newWindow = window.open(strUrl,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
	        newWindow.focus();
	        return newWindow;
        }
      }
/*
    //�����������������ʾ�ѳ�ʱ������Ϣ
    function info() {
        var date1 = fm.prpLregistDamageStartDate.value;
        var date2 = fm.prpLregistReportDate.value;
        
        var hour1 = parseInt(fm.prpLregistReportHour.value);
        var hour2 = parseInt(fm.prpLregistDamageStartHour.value);
        
        var strValue1 = date1.split(DATE_DELIMITER);
        var strValue2 = date2.split(DATE_DELIMITER);
        var msg = "";
        var sum = (parseInt(strValue2[2]) - parseInt(strValue1[2]))*24 + (hour1-hour2);
        
        if ((parseInt(strValue2[0]) - parseInt(strValue1[0])) > 1) {
           window.alert("��ע�⣺����ʱ���ѳ�������ʱ��48Сʱ��");
        } else if ((parseInt(strValue2[1]) - parseInt(strValue1[1])) > 1) {
           window.alert("��ע�⣺����ʱ���ѳ�������ʱ��48Сʱ��");
        } else if (sum > 48) {
            window.alert("��ע�⣺����ʱ���ѳ�������ʱ��48Сʱ��");
        }
        return true;
    }
*/

function submit1(){
        var vAction = fm.action;
        var vTarget = fm.target;
          fm.action="/claim/common/regist/RegistBeforeQueryEdit.jsp?nodeType=regis";
          fm.submit();
          fm.action=vAction
          fm.target=vTarget
}

</script>

<%  
  String editTypeTemp=request.getParameter("editType");
%>
<table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:">
   <tr>
       <input type="hidden" name=buttonSaveType value="1">
       <html:select name="swfPathDto" property="nextNodeNoList" style="width:0px;height:0px" multiple="true" >
            <html:options collection="userSelectList" property="endNodeNo"  labelProperty="endNodeName" />          
       </html:select>  

<%
  if(!editTypeTemp.equals("ADD")){
%>
<%--���Ӵ�ӡ������¼�������İ�ť����ʵ�ֱ�����¼�������ӵ��ȵ��鿱��Ա 
            <td class="button"  align="center" style="width:30%">
               <input type="button" name="print" class='bigbutton' value="��ӡ������¼������"  onclick="printWindow('<bean:write name='prpLregistDto' property='registNo'/>', '��ӡ1');">
            </td>--%> 
<%
  }
%>            
<%// �ж��ǲ���Ϊ�����޸ı�����״̬��������������Ӧ��Ĭ���¸��ڵ��ѡ��%>
<logic:notEqual name="prpLregistDto" property="status" value="4">

 <td class=button style="width:20%" align="center">
           <!--���水ť-->
            <input type="button" name=buttonSave class='button' value="�� ��" onclick=" return saveForm(this,'2');">
         </td>
       
<% //�ж���ת������
  UserDto user = (UserDto) session.getAttribute("user");
  String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
  String comCodeTemp = user.getComCode().substring(0,4);
  System.out.println("------�Զ���ת�ж�-----"+strSchedule+"---comCode---"+comCodeTemp+"---index---"+strSchedule.indexOf(comCodeTemp));
  if(strSchedule.indexOf(comCodeTemp)>=0){
    //��Ҫ�Զ���ת  
%>
         <%-- ���������ı��水ť���ĸ��ı�־--%>
        <input type="hidden" name=nextHandlerCode value="<%=user.getUserCode() %>" >
        <td class=button style="width:20%" align="center">
           <!--���水ť-->
            <input type="button" name=buttonSave class='button' value="��һ��" onclick="return saveForm(this,'4');">
         </td>
<%    
  }else{
    //����Ҫ�Զ���ת
%>
        <td class=button style="width:20%" align="center"> 
          <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
        </td>
 
         <td class=button style="width:40%" align="center">
           <!--ȡ����ť-->
           <input type=button name=buttonCancel class='button' value="����" onclick=" return submit1();" >
         </td>
<%  
  } 
%> 
        </logic:notEqual> 
                            
        <logic:equal name="prpLregistDto" property="status" value="4">  
<% // �ж��ǲ�����ʾ���²���˵��
  String updateExt=request.getParameter("updateExt");
  if("true".equals(updateExt)){
%>                          
       <td class=button style="width:40%" align="center"> 
         <!--���水ť-->      
         <%--modify by liujianbo modify 20050316 start--%>
         <%--resson:��ť̫С--%>
          <%--<input type="button" name=buttonSave class='bigbutton' value="���²���˵��" onclick="return saveForm(this,'4');">--%>
         <%--modify by liujianbo modify 20050316 end--%>
       </td>
<%
  }
%>   
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="�� ��" onclick="window.close();">
            </td>
<%
  }else{
%>
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="�� ��" onclick="history.go(-1);">
          </td>
<%
  }
%>
          </logic:equal>
        </tr>
      </table>