<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>

<%
%>

<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
     name="CommerceImg" onclick="showPage(this,spanCommerce);">商业三者综合保险(A款)<br>
     <span  id="spanCommerce" style="display">   
 <table  class="common" id="PersonLossCareFee" cellspacing="1" cellpadding="0">
                 <thead>
                        <tr>
                          <td class="centertitle" style="width:9%" align="center">项目</td>
                          <td class="centertitle" style="width:8%" align="center">总损失</td>
                          <td class="centertitle" style="width:9%" align="center">强三限额</td>
                          <td class="centertitle" style="width:9%" align="center">超强三金额</td>
                          <td class="centertitle" style="width:10%" align="center">事故责任比例</td>
                          <td class="centertitle" style="width:9%" align="center">核定赔偿金</td>
                          <td class="centertitle" style="width:9%" align="center">赔偿限额</td>
                          <td class="centertitle" style="width:9%" align="center">事故免赔率</td>
                          <td class="centertitle" style="width:9%" align="center">绝对免赔率</td>
                          <td class="centertitle" style="width:9%" align="center">实赔金额</td>
                          <td class="centertitle" style="width:10%" align="center">总实赔金额</td>
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
