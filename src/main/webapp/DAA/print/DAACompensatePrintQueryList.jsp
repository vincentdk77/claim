<html>
<head>
  <script language="javascript">
  
  </script>
</head>
<%
    String[] PrintNo   = request.getParameterValues("PrintNo");
%>
<body >
<%
  for(int i=0;i<PrintNo.length;i++){

    
%>  
  <iframe name="frames" frameborder="no" width="100%" scrolling="no" height="1000px" src="/claim/ClaimPrint.do?printType=Compensate&CompensateNo=<%=PrintNo[i]%>&PrintFlag=1&compensateFlag=1" >
  </iframe>
<%
    }
%>  
<jsp:include page="/common/print/PrintButton.jsp" />
</body>
</html>