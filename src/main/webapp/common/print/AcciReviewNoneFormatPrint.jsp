<%--

****************************************************************************

* DESC       ����ʾ(�ǳ���)�����Ǽǵ��ձ������ҳ��

* AUTHOR     ��luqin

* CREATEDATE ��2005-06-19

* MODIFYLIST ��   Name       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************

--%>

<%@ page contentType="text/html; charset=GBK" %>

<%-- ��ʼ�� --%>

<%@include file="AcciReviewNoneFormatPrintIni.jsp"%>



<html>

<body onload="loadForm();">



<p>��</p>

<div align="center">

  <center>

  <table border="0" cellpadding="0" cellspacing="0" width="96%">

    <tr>

      <td width="100%">��

        <div align="center">

          <center>

          <table border="0" cellpadding="0" cellspacing="0" width="96%" height="186">

            <tr>

              <td width="10%" height="36">��ӡ������</td>

              <td width="23%" id="tdTimes">��&nbsp; �δ�ӡ</td>    

              <td width="10%">���ⰸ���ţ�</td>

              <td width="24%" id="tdCompensateNo"></td>

              <td width="10%">ҵ��Ա������</td>

              <td width="23%" id="tdOperatorName"></td>

            </tr>

            <tr>

              <td width="10%" height="36">��ӡʱ�䣺</td>

              <td width="23%" id="tdPrintTime"></td>

              <td width="10%">�����ţ�</td>

              <td width="24%" id="tdPolicyNo"></td>

              <td width="10%">ҵ��Ա���룺</td>

              <td width="23%" id="tdOperatorCode"></td>

            </tr>

            <tr>

              <td width="10%" height="36">�����룺</td>

              <td width="23%"></td>

              <td width="10%">�ͻ��ţ�</td>

              <td width="24%" id="tdInsuredCode"></td>

              <td width="10%">ҵ��Ա���ţ�</td>

              <td width="23%" id="tdComName"></td>

            </tr>

            <tr>

              <td width="10%" height="36">ͨѶ��ַ��</td>

              <td width="57%" colspan="3" id="tdPostAddress"></td>

              <td width="10%">ϵͳ��¼�ţ�</td>

              <td width="23%"></td>

            </tr>

            <tr>

              <td width="16%" height="36">��ϵ�绰��</td>

              <td width="50%" colspan="3" id="tdPhoneNumber"></td>

              <td width="17%">��ѯ�绰��</td>

              <td width="17%"></td>

            </tr>

          </table>

          </center>

        </div>

        <p align="center"><font size="5"><b>�˱�����֪ͨ��</b></font></p>

        <p>�𾴵Ŀͻ�&nbsp;<%=strLinkerName%>&nbsp;     

        ������Ůʿ��</p>

        <p>&nbsp;&nbsp;&nbsp;     

        ��л���Ա���˾�����Σ��ڱ���˾Ͷ�����򱻱����˽���״�������ط����ı䣬����˾����һ��ȶԱ���&nbsp;<%=strPolicyNo%>&nbsp;    

        ��һ���ڶ�����������������������������ȵı������β��䡣</p>

        <p>��</p>

        <table border="0" cellpadding="0" cellspacing="0" width="96%">

          <tr>

            <td width="20%" height="36">�ͻ�</td>

            <td width="20%">����</td>

            <td width="20%">������</td>

            <td width="20%">ԭ��</td>

            <td width="20%">��Чʱ��</td>

          </tr>

          <tr>

            <td width="20%" height="108"></td>

            <td width="20%"></td>

            <td width="20%"></td>

            <td width="20%"></td>

            <td width="20%"></td>

          </tr>

          <tr>

            <td width="20%" height="36"></td>

            <td width="20%"></td>

            <td width="20%"></td>

            <td width="20%">

        <p> 

        �ֹ�˾�⽡�ղ�</p>

        <p>��˾ǩ�� </p>

            </td>

            <td width="20%">

            </td>

          </tr>

        </table>

        <p>&nbsp; ��������д��Ч��</p>   

        <p>&nbsp;�� ܰ �� ʾ</p>  

        <p>��Ϊ�����ı���Ȩ�治���𺦣��յ���֪ͨ��������ϸ�Ķ��������ݣ�������Ӧ���촦���о������������ˡ���&nbsp;&nbsp;   

        ��&nbsp; ��&nbsp;   

        ��֮ǰ�������˻�ί�б���˾ҵ��Ա���ҹ�˾�ظ����Ĵ�����������벦����ѯ�绰&nbsp;&nbsp;&nbsp;   

        ԤԼ����˾������Ա������ȡ������δ�ظ��������������˾��Ϊ����������������һ��������������ֽ�������ֹ��<o:p>

        </p>

        <p>������������һ�������ֵ���һ��ȵ�������������˾����һ������Ƚ������ṩ�����ֵı��ϣ��Ҳ���ȡ�����ֵ���һ��ȱ��ѡ�<o:p>

        </p>

        <p>���������Ϊһ�������֣����������ڲ���������ķ��գ�����˾�Խ���Ը����ֵ����ڳб���������������ˡ��¸�������ȵ������������Ա���˾�¸��������ǰ���µĺ˱�����Ϊ׼�������ڳб����������仯ʱ����Ҫ���ٴ�ȷ�ϡ�<o:p>

        </p>

        <p>������ͬ�������˱�����������˾������ͬԼ����ȡ��һ��ȱ��ѡ�<o:p>

        </p>

        ������������Ϊһ�������֡��������˱�����Ϊ�ܱ����򱾹�˾���������˱�������Чʱ���������������֡�

        <p align="center"><font size="3"><b>�ͻ������</b></font></p>

        <p>�����ܺ˱�����<o:p>

        </p>

        <p>�������ܺ˱�������ԭ��</p>

        <p>��</p>

        <p>��</p>

        <p>��</p>

        <div align="center">

          <center>

          <table border="0" cellpadding="0" cellspacing="0" width="96%">

            <tr>

              <td width="16%" height="36"> Ͷ����ǩ�֣�</td>

              <td width="12%"></td>

              <td width="22%">��������/�໤��ǩ�֣�</td>

              <td width="13%"></td>

              <td width="26%">������������/�໤��ǩ�֣�</td>

              <td width="11%"></td>

            </tr>

            <tr>

              <td width="16%" height="36">ǩ�����ڣ�</td>

              <td width="12%"></td>

              <td width="22%">ǩ�����ڣ�</td>

              <td width="13%"></td>

              <td width="26%">ǩ�����ڣ�</td>

              <td width="11%"></td>

            </tr>

            <tr>

              <td width="16%" height="36">��˾��ַ��</td>

              <td width="47%" colspan="3"></td>

              <td width="26%">�ʱࣺ</td>

              <td width="11%"></td>

            </tr>

          </table>

          </center>

        </div>

      </td>

    </tr>

  </table>

  </center>

</div>

  <!--include��ӡ��ť-->

  <jsp:include page="/common/print/PrintButton.jsp" /> 

</body>

</html>

