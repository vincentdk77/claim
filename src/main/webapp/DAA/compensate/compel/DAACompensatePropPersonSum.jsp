<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>


<%
//String  configCode=(String) request.getAttribute("configCode");
%>
  <input type="hidden" name="configCode" value="<%= configCode %>">   
<%
   Map limitMap =new HashMap();
   limitMap =(Map) request.getAttribute("limitMap");
   String limitType= "";
   String limitFee= "";
   Set limitMapKey = limitMap.keySet();
   if (limitMapKey !=null&& limitMapKey.size()>0){
       for (Iterator limit = limitMapKey.iterator();limit.hasNext();) {
      	    limitType = (String)limit.next(); 
      	    limitFee  = (String) limitMap.get(limitType);
  %>    	    
     <input type="hidden" name="limitType" value="<%= limitType %>">   	 
     <input type="hidden" name="limitFee" value="<%= limitFee %>">   	 
 <%
     }
 }
  %>
<table class="common" align="center"  id="tabLossCareFee">
<tr>
<td>
<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
     name="CommerceImg" onclick="showPage(this,spanCommerce);">ǿ�Ʊ�����������Ϣ<br>
 <span  id="spanCommerce" style="display">   
 <table  class="common" id="PersonLossCareFee" cellspacing="1" cellpadding="0" style="padding-left: 5px;">
                 <thead>
                        <tr>
                          <td class="centertitle" style="width:10%" align="center">��ʧ��Ŀ</td>
                          <td class="centertitle" style="width:15%" align="center">��ʧ�ϼ�</td>
                          <td class="centertitle" style="width:15%" align="center">��ֵ�ϼ�</td>
                          <td class="centertitle" style="width:15%" align="center">�˶��⳥��</td>
                          <td class="centertitle" style="width:15%" align="center">ǿ�Ʊ����޶�</td>
                          <td class="centertitle" style="width:15%" align="center">�����</td>
                          <td class="centertitle" style="width:15%" align="center">ʵ����</td>                          
                        </tr>
                  </thead>
          <tbody>
              <tr>

<%
String[] titles = {"wealth","medical","diedeformity","noduty","noinsp","noinsm","noinsd"};
int row=7,column=7;

for(int j=0;j<column;j++){
%>
			<tr>
			<%
			for(int k=0;k<row;k++){
			if(k==6&&j>0) continue;
			if(k==6&&j==0) {
%>
			                <td class="input"  rowspan="7" 	style="width:9%" align="center">
			                  <input type="text" name="totalPay"  class="readonly" align="center"  readonly style="width:100%" >                
			                </td>

		  <%}else{%>
			                <td class="input"  style="width:9%" align="center">
			                  <input type="text" name="<%=titles[j]%>"  class="readonly" align="center"  readonly style="width:100%" >                
		                </td>
			<%}}%>

			</tr>

<%}%>  


                
          </tbody>
</table>

</span>
</td>
</tr>
</table>