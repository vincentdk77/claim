<%--
***************************************************************************
* Description: ������Ϣ��ѯ
* UpdateLog��  Name       Date            Reason/Contents
            WuZheng        20080628       ����excel��������
****************************************************************************
--%>
<%@page import = "com.sinosoft.claim.dto.domain.PrpdBankBranchDto"%> 
<%@page import = "java.util.ArrayList"%> 
<%@page import = "java.util.List"%> 
<%@page import = "com.sinosoft.utility.database.DbPool"%> 
<%@page import = "com.sinosoft.utility.SysConfig"%> 
<%@page import = "java.sql.ResultSet"%> 

<%
	String excelFlag = request.getParameter("ExcelFlag");
	String isAllFlag = request.getParameter("isAllFlag");
	String isSF = request.getParameter("isSF");
	if("1".equals(excelFlag)){
	    response.setContentType("application/vnd.ms-excel; charset=GBK");
	}else{
	    response.setContentType("text/html;charset=GBK");
	}
	String provSign = request.getParameter("provSign");
	String provName = request.getParameter("provname");
	String citySign = request.getParameter("citySign");
	String cityName = request.getParameter("cityname");
	String bankClassSign = request.getParameter("bankclassSign");
	String bankClass = request.getParameter("bankclass");
	String bankBranchSign = request.getParameter("bankbranchSign");
	String bankBranchName = request.getParameter("bankbranchname");
	List<PrpdBankBranchDto> prpdbankbranchList = new ArrayList<PrpdBankBranchDto>();
	String condition = "select * from prpdbankbranch where 1=1 ";
	DbPool dbPool = new DbPool();
	ResultSet rs = null;
	if(!"1".equals(isAllFlag)){
		if(provName!=null&&!"".equals(provName)){
			if("=".equals(provSign)){
				condition += " and prov_name = '"+provName+"' "; 
			}else{
				condition += " and prov_name like '%"+provName+"%' "; 
			}
		}
		if(cityName!=null&&!"".equals(cityName)){
			if("=".equals(citySign)){
				condition += " and city_name = '"+cityName+"' "; 
			}else{
				condition += " and city_name like '%"+cityName+"%' "; 
			}
		}
		if(bankClass!=null&&!"".equals(bankClass)){
			if("=".equals(bankClassSign)){
				condition += " and belong_bank_name = '"+bankClass+"' "; 
			}else{
				condition += " and belong_bank_name like '%"+bankClass+"%' "; 
			}
		}
		if(bankBranchName!=null&&!"".equals(bankBranchName)){
			if("=".equals(bankBranchSign)){
				condition += " and bank_name = '"+bankBranchName+"' "; 
			}else{
				condition += " and bank_name like '%"+bankBranchName+"%' "; 
			}
		}
	}
	condition +=" order by prov_name,city_name,belong_bank_name,bank_name,bank_number";
	try{
		dbPool.open(SysConfig.getProperty("DDCCDATASOURCE"));
		rs = dbPool.query(condition);
		while(rs.next()){
			PrpdBankBranchDto prpdBankBranchDto = new PrpdBankBranchDto();
			prpdBankBranchDto.setBank_number(rs.getString("bank_number"));
			prpdBankBranchDto.setBank_name(rs.getString("bank_name"));
			prpdBankBranchDto.setProv_code(rs.getString("prov_code"));
			prpdBankBranchDto.setProv_name(rs.getString("prov_name"));
			prpdBankBranchDto.setBelong_bank_value(rs.getString("belong_bank_value"));
			prpdBankBranchDto.setBelong_bank_name(rs.getString("belong_bank_name"));
			prpdBankBranchDto.setCity_code(rs.getString("city_code"));
			prpdBankBranchDto.setCity_name(rs.getString("city_name"));
			prpdBankBranchDto.setCountry(rs.getString("country"));
			prpdbankbranchList.add(prpdBankBranchDto);
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			dbPool.close();
			rs.close();
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
%>


<html>
	<head>
	<title>������Ϣ��ѯ�������</title>
        <!--ҳ����-->
<%  if("1".equals(excelFlag)){
       //��������css  
%>
<%  
    }else{
%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<%

    }
%>  
    <!-- ���ú��� -->
    <script src="/account/common/pub/BLCommonCommon.js"></script>
    <!-- ҳ����ʽ -->
<script language="javascript">
  //ҳ����ת
  function exportExcel(){
      fm.ExcelFlag.value = '1';
      fm.action="BankQueryList.jsp";
      fm.submit();
      fm.ExcelFlag.value = '0';
  }
  function exportAllExcel(){
      fm.ExcelFlag.value = '1';
      fm.isAllFlag.value = '1';
      fm.action="BankQueryList.jsp";
      fm.submit();
      fm.ExcelFlag.value = '0';
  }
  
  
</script>
	</head>
	<body>
  <form name="fm" >
      <!-- ���������� -->
    <input type="hidden" name="ExcelFlag" value=0 description="������־��1��ʾ����">
    <input type="hidden" name="isAllFlag" value=0 description="�Ƿ�ȫ������">
    <input type="hidden" name="provSign" value="<%=(String)request.getParameter("provSign") %>" >
    <input type="hidden" name="provname" value="<%=(String)request.getParameter("provname") %>" >
    <input type="hidden" name="citySign" value="<%=(String)request.getParameter("citySign") %>">
    <input type="hidden" name="cityname" value="<%=(String)request.getParameter("cityname") %>" >
    <input type="hidden" name="bankclassSign" value="<%=(String)request.getParameter("bankclassSign") %>" >
    <input type="hidden" name="bankclass" value="<%=(String)request.getParameter("bankclass") %>" >
    <input type="hidden" name="bankbranchSign" value="<%=(String)request.getParameter("bankbranchSign") %>" >
    <input type="hidden" name="bankbranchname" value="<%=(String)request.getParameter("bankbranchname") %>" >
<%if(!"1".equals(excelFlag)){ %>  
  <table class="common" align=center cellpadding="5" cellspacing="1">
<%}else{ %>
  <table  align=center width="100%"  border="1" cellspacing="0" cellpadding="0" bordercolor="#111111" style="border-collapse: collapse; font-family:����; font-size:9pt;" >
<%} %>
    <tr>
	    <td class=formtitle align=center colspan="6">��ѯ������Ϣ</td>
	  </tr>
    <tr class=listtitle>
      <td align="center">ʡ��</td>
      <td align="center">����</td>
      <td align="center">���д���</td>
      <td align="center">����֧������</td>
      <td align="center">���к�</td>
      <!-- <td align="center">���й��Ҵ���</td> -->
    </tr>
<%
	for(int i=0;i<prpdbankbranchList.size();i++){
		PrpdBankBranchDto prpdBankBranchDtotemp = prpdbankbranchList.get(i);
		String bankNumber = prpdBankBranchDtotemp.getBank_number();
		String bankName = prpdBankBranchDtotemp.getBank_name();
		String Prov = prpdBankBranchDtotemp.getProv_name();
		String city = prpdBankBranchDtotemp.getCity_name();
		String bankCL = prpdBankBranchDtotemp.getBelong_bank_name();
		String country = prpdBankBranchDtotemp.getCountry();
		
%>
	<tr class=common>
		<td align="center"><%=Prov%></td>
		<td align="center"><%=city%></td>
		<td align="center"><%=bankCL%></td>
		<td align="center"><%=bankName%></td>
<%
	if(!"1".equals(excelFlag)){
%>
		<td align="center"><%=bankNumber%></td>
<%	
	}else{
%>
		<td style="vnd.ms-excel.numberformat:###0" align="center"><%=bankNumber%></td>
<%	
	}
 %>
		<%-- <td align="center"><%=country%></td> --%>
	</tr>
<%		
	}
%>

      </table>
      
      <table class="common" align="center">
        <tr>
            <td align="center">
                <Input name="buttonExcel" type="button" alt="����Excel" class="button" value="����Excel" onclick="exportExcel()">
            </td>
            <td align="center">
                <Input name="buttonExcel" type="button" alt="ȫ������" class="button" value="ȫ������" onclick="exportAllExcel()">
            </td>
            <% 
            if(!"1".equals(isSF)){
            %>
            	<td align="center">
                	<Input name="buttonBack" type="button" alt="����" class="button" value="����" onclick="history.back();">
            	</td>
            <%
            }
            %>
        </tr>
      </table>
  </form>
  </body>
</html>
