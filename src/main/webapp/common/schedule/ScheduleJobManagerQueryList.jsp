
<%@page import="com.sinosoft.claim.dto.domain.PrpljobmanagertimeDto"%>
<%@page import="java.util.Iterator"%><%--
****************************************************************************
* DESC       �������Ϣ��ѯ���
* AUTHOR     ��fengchuang
* CREATEDATE ��2012-10-24
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html:html locale="true">
<head>
	<app:css />

	<title>��ѯ���</title>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/showpage.js"> </script>
	<script type="text/javascript">
  ///////////////////////////////////////////////  

  //���ܣ��ϲ����  
  //������tb����Ҫ�ϲ��ı��ID  
  //������colLength������Ҫ��ǰ���н��кϲ������磬  
  //��ϲ�ǰ���У�����������к��Ժϲ���colLengthӦΪ2  
  //ȱʡ��ʾ��ȫ���кϲ�  
  ///////////////////////////////////////////////  
  function uniteTable(tb,colLength){  
  //������Ƿ����  
  if(!checkTable(tb)) return;  
    var i=0;  
    var j=0;  
    var rowCount=tb.rows.length; //����  
    var colCount=tb.rows[0].cells.length; //����  
    var obj1=null;  
    var obj2=null;  
    //Ϊÿ����Ԫ������  
    for(i=0;i<rowCount;i++){  
      for(j=0;j<colCount;j++){  
        tb.rows[i].cells[j].id="tb__" + i.toString() + "_" + j.toString();  
      }  
    }  

    //���м��ϲ�  
	var temp1 = null;
	var temp2 = null;
	var k = 0;
    for(i=colLength-1;i>=0;i--){  
      obj1=document.getElementById("tb__0_"+i.toString())  ;
      if(!i==0){
      	k = i-1;
      }  
      temp1=document.getElementById("tb__0_"+k.toString())  ;
      for(j=1;j<rowCount;j++){  
        obj2=document.getElementById("tb__"+j.toString()+"_"+i.toString());  
        temp2=document.getElementById("tb__"+j.toString()+"_"+k.toString());  
        if(obj1.innerText==obj2.innerText&&temp1.innerText==temp2.innerText){  
          obj1.rowSpan++;  
          obj2.parentNode.removeChild(obj2);  
        }else{  
          obj1=document.getElementById("tb__"+j.toString()+"_"+i.toString());  
          temp1=document.getElementById("tb__"+j.toString()+"_"+k.toString()); 
        }  
      }  
    }  
  }  

   

  /////////////////////////////////////////  

  //���ܣ�������Ƿ����  

  //������tb������Ҫ���ı��ID  
  /////////////////////////////////////////  
  function checkTable(tb){  
    if(tb.rows.length==0) return false;  
    if(tb.rows[0].cells.length==0) return false;  
    for(var i=0;i<tb.rows.length;i++){  
      if(tb.rows[0].cells.length!=tb.rows[i].cells.length) return false;  
    }  
    return true;  
  }  
</script>

	<html:base />
</head>

<body onload="uniteTable(table1,2)">
	<form name="fm" action="/claim/scheduleJobManagerQuery.do" method="post">
		<% 
		PrpljobmanagertimeDto prpljobmanagertimeDto = (PrpljobmanagertimeDto)request.getAttribute("prpljobmanagertimeDto"); 
		  int curPage = prpljobmanagertimeDto.getTurnPageDto().getPageNo(); 
		%> 
		<table class="common" width="99%" id="table1" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8" >

				<tr class="listdragtitle">
					<td class="centertitle">
						����
					</td>
					<td class="centertitle">
						���
					</td>
					<td class="centertitle">
						�鿱��Ա 
					</td>
					<td class="centertitle">
						��ϵ�绰
					</td>
					<td class="centertitle">
						������ɫ
					</td>

				</tr>
				<logic:iterate id="prpljobmanager" name="prpljobmanagerDtoList" indexId="count">
					<tr class=listodd>
						<td >
							${prpljobmanager.time}
						</td>
						<td>
<logic:equal value="AM" name="prpljobmanager" property="datetype">�װ�</logic:equal>
<logic:equal value="PM" name="prpljobmanager" property="datetype">ҹ��</logic:equal>
						</td>
						<td>
							${prpljobmanager.handlername}
						</td>
						<td>
							${prpljobmanager.tel}
						</td>
						<td>
<logic:equal value="1" name="prpljobmanager" property="jobrole">����鿱</logic:equal>
<logic:equal value="2" name="prpljobmanager" property="jobrole">���˲鿱</logic:equal>
<logic:equal value="12" name="prpljobmanager" property="jobrole">����鿱�����˲鿱</logic:equal>
<logic:equal value="3" name="prpljobmanager" property="jobrole">�ǳ��鿱</logic:equal>
						</td>

					</tr>
				</logic:iterate>
				
		</table>
	
		<table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpljobmanagertimeDto" property="turnPageDto"/>  
                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
		<input type="hidden" name="editType" value="SHOW">
	</form>
	<jsp:include page="/common/pub/StaticJavascript.jsp" />

</body>

<script><%--
	
	//ifrom ����Ӧ�߶� showlist ifrom ���� begin
	parent.document.all("showlist").style.width=document.body.scrollWidth; 
	parent.document.all("showlist").style.height=document.body.scrollHeight; 

	var iframe = parent.document.getElementById("showlist");
	var bHeight = iframe.contentWindow.document.body.scrollHeight;
	var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
	//ifrom ����Ӧ�߶� showlist ifrom ���� end
--%></script>
</html:html>