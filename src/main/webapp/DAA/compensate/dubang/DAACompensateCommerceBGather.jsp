<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%
%>

<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
     name="CommerceImg" onclick="showPage(this,spanCommerce);">��ҵ�����ۺϱ���(A��)<br>
     <span  id="spanCommerce" style="display">   
 <table  class="common" id="PersonLossCareFee" cellspacing="1" cellpadding="0">
                 <thead>
                        <tr>
                          <td class="centertitle" style="width:9%" align="center">��Ŀ</td>
                          <td class="centertitle" style="width:8%" align="center">����ʧ</td>
                          <td class="centertitle" style="width:9%" align="center">ǿ���޶�</td>
                          <td class="centertitle" style="width:9%" align="center">��ǿ�����</td>
                          <td class="centertitle" style="width:10%" align="center">�¹����α���</td>
                          <td class="centertitle" style="width:9%" align="center">�˶��⳥��</td>
                          <td class="centertitle" style="width:9%" align="center">�⳥�޶�</td>
                          <td class="centertitle" style="width:9%" align="center">�¹�������</td>
                          <td class="centertitle" style="width:9%" align="center">����������</td>
                          <td class="centertitle" style="width:9%" align="center">ʵ����</td>
                          <td class="centertitle" style="width:10%" align="center">��ʵ����</td>
                        </tr>
                  </thead>
          <tbody>
              <tr>

<%
String[] titles = {"wealth","medical","diedeformity"};
int row=11,column=3;
String Kindcode="A";
if (Kindcode.equals("A")){

	for(int j=0;j<column;j++){
	%>
				<tr>
				<%
				for(int i=0;i<row;i++){
				%>
				<%
					if((i>3)&&j>0) continue;
						if((i>3)){
				%>
				                <td class="input"  rowspan="3" style="width:9%" align="center">
				                  <input type="text" name="<%=titles[j]%>"  class="readonly" align="center" readonly style="width:100%"  >                                
				<%
							}else{
				%>
				                <td class="input"  style="width:9%" align="center">
				                  <input type="text" name="<%=titles[j]%>"  class="readonly" align="center"  readonly style="width:100%" >                
				<%}%>                
				                

				                </td>
				<%}%>

				</tr>

				<%}%>






<%
}else{

for(int j=0;j<column;j++){
%>
			<tr>
			<%
			for(int i=0;i<row;i++){
			%>
			<%
				if((i==5||i==10)&&j>0) continue;
					if((i==5||i==10)){
			%>
			                <td class="input"  rowspan="3" style="width:9%" align="center">
			                  <input type="text" name="<%=titles[j]%>"  class="readonly" align="center" readonly style="width:100%"  >                                
			<%
						}else{
			%>
			                <td class="input"  style="width:9%" align="center">
			                  <input type="text" name="<%=titles[j]%>"  class="readonly" align="center"  readonly style="width:100%" >                
			<%}%>                
			                

			                </td>
			<%}%>

			</tr>

			<%}%>





<%}%>


                
          </tbody>
</table>
</span>
