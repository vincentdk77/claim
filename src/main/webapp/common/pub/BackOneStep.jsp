<%--
 *************************************************************************
 * ��������: BackOneStep.jsp
 * ������: ���˽���
 * ���������: weishixin
 * �����������: 2004-08-23
 ****************************************************************************
--%>


<html>
    <head>
        <title>
        </title>
        <STYLE>BODY {
        	BORDER-TOP-WIDTH: 0px; 
        	BORDER-LEFT-WIDTH: 0px; FONT-SIZE: 9pt; 	BORDER-BOTTOM-WIDTH: 0px; 
        	LINE-HEIGHT: 160%; 
        	FONT-FAMILY: "����"; 
        	BORDER-RIGHT-WIDTH: 0px;
           
        }
        </STYLE>
        <link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
        <script language="javascript">
        function windowBackOne()
        {
          <%
            Object compensateFlag = request.getAttribute("strCompensateFlag");
            if(compensateFlag!=null){
          %>
            alert("�ƺ�Ϊ��"+"<%= compensateFlag %>"+" �ĳ��ѳ���������,�������ռ���֤");
          <%
            }
          %>
           window.history.back(1);
        }
        </script>
    </head>
    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="return windowBackOne();">
    </body>
</html>
