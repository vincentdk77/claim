<%--
****************************************************************************
* DESC       ����ʾ��������ҳ��(1����ժҪ/2�鿱����/3�᰸����)��Ҫ������TextType
* AUTHOR     ��lixiang
* CREATEDATE ��2004-06-17
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*������Ҫ��������texttype��ֵ���бȽ����ص�����
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLltextDto" %>
<%@page import="com.sinosoft.claim.dto.custom.ClaimDto"%>
<%@page import="java.util.Collection" %>
<%@page import="java.util.Iterator" %>
<%
	ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto_"+indexClaimLoss);
	request.setAttribute("claimDto",claimDto);
	Collection prpLltextDtoList = claimDto.getPrpLltextDtoList();
	Iterator iteratorPrpLltextDto = prpLltextDtoList.iterator();
	PrpLltextDto prpLltextDto = null;
	if(prpLltextDtoList != null){
		while(iteratorPrpLltextDto.hasNext()){
			prpLltextDto = (PrpLltextDto)iteratorPrpLltextDto.next();
		}
	}
	if(null == prpLltextDtoList)
		prpLltextDto = (PrpLltextDto)request.getAttribute("prpLltextDto");
 %>
   <table class="common" align="center" width="100%">
    <tr>
      <td class="subformtitle" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
           name="LtextImg" onclick="showPage(this,document.getElementById('Ltext_<%=indexClaimLoss %>'),'<%=indexClaimLoss %>')">
           <logic:equal name="prpLltextDto" property="textType" value="1">
             <bean:message key="db.prpLltext.text1"/>  <%-- �鿱����--%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="2">
             <bean:message key="db.prpLltext.text2"/>    <%--�᰸����--%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="3">
             <bean:message key="db.prpLltext.text3"/>   <%--[texttype=1] ����ժҪ--%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="4">
             <bean:message key="db.prpLltext.text4"/>   <%-- ��������--%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="5">
             <bean:message key="db.prpLltext.text5"/>   <%-- ׷����ת������--%> 
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="08"> 
             <bean:message key="db.prpLltext.text08"/>   <%-- �᰸�Ǽ��ϵĽ᰸���� --%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="09">
             <bean:message key="db.prpLltext.text09"/>   <%-- ����ժҪ --%>
           </logic:equal>
           <logic:equal name="prpLltextDto" property="textType" value="10">
             <bean:message key="db.prpLltext.text10"/>   <%-- ע��/�����ı� --%>
           </logic:equal> 
           <br>
          <table class="common" align="center" id="Ltext_<%=indexClaimLoss %>" style="display:none">
            <tbody>
              <tr>
                <td class="title" style="text-align:center;"> 
<textarea style="wrap:hard" rows="15" cols="80" name="prpLltextContextInnerHTML_<%=indexClaimLoss %>"><bean:write name="prpLltextDto" property="context"/></textarea>                              
                </td>
              </tr>
            </tbody>
          </table>  
      </td> 
    </tr>
  </table>
  <%indexClaimText++;%>