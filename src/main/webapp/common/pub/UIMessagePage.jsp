<%--
 *************************************************************************
 * ��������: MessagePage.jsp
 * ������: ��Ϣ����ҳ��
 * ���������: ������
 * ��ע: ����Picture:"S"��ʾ�ɹ�,"F"��ʾʧ��,"C"��ʾһ����Ϣ;
 *       ����Content:���ݡ�
 * �����������: 2001-11-29
 ****************************************************************************
--%>

<html>
<head>
  <title>��Ϣ����</title>
  <%--ҳ����ʽ--%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<%
  String SUCCESS    = "S";  //�ɹ�
  String FAILURE    = "F";  //ʧ��
  String COMMON     = "C";  //һ����Ϣ

  String Picture    = request.getParameter("Picture");
  String Content    = request.getParameter("Content");
  String strPicture ="";
%>

</head>
<body class="interface">

   <table class=common align=center>
     <tr>
       <td class=formtitle colspan="2">ϵͳ��ʾ</td>
     </tr>

<%
  if(Picture==null)
    Picture = COMMON;

  if(Picture.equalsIgnoreCase(SUCCESS))
    strPicture ="success.gif";
  else if (Picture.equalsIgnoreCase(FAILURE))
    strPicture ="failure.gif";
  else
    strPicture ="common.gif";
%>

    <tr>
      <td  align=center>
        <img src='/claim/images/<%=strPicture%>'>
      </td>
      <td class="common">
        <%=Content%>
      </td>
    </tr>
  </table>

</body>
</html>