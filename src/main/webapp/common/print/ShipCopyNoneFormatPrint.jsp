<%--

****************************************************************************

* DESC       �����պ󳭵���ӡҳ��

* AUTHOR     �� wangwei

* CREATEDATE �� 2005-05-27

* MODIFYLIST ��   Name       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************

--%>

<%@ page contentType="text/html; charset=GBK" %>



<%--��ʼ��--%>

<%@include file="ShipCopyNoneFormatPrintIni.jsp"%>



<html>

    <head>

	    <title> �Ʋ����չ�˾��������</title>

    </head>

	

	<body>

	      <p align="center"> �Ʋ����չ�˾</p>

          <p align="center">****�ձ�������</p>

		  <hr align="center" width="90%" size="4"/>



	    <table align="center" width="90%">

		    <tr><td colspan="2">�����ţ�<%= strRegistNo %></td></tr>

            <tr></tr><td colspan="2">���յ��ţ�<%= strPolicyNo %></td></tr>

            <tr></tr><td colspan="2">�����������ƣ�<%= strPolicyName %></td></tr>

			<tr></tr><td colspan="2">�������˵�ַ��<%= strPolicyAddress %></td></tr>

			<tr></tr><td colspan="2">���ս�<%= strSumAmount %></td></tr>

			<tr></tr><td colspan="2">���ձ�ģ�<%= strLossName %></td></tr>

			<tr></tr><td colspan="2">���ձ�ĵ�ַ��</td></tr>

			<tr></tr><td colspan="2">����˵����</td></tr>

			<tr></tr><td>Ͷ������:<%= strStartDate %></td><td>¼�����ڣ�<%= strInputDate %></td></tr>

			<tr></tr><td>ǩ�����ڣ�<%= strOperateDate %></td><td>�������ڣ�<%= strInputDate %></td></tr>

			<tr></tr><td colspan="2">�����ڼ䣺<%= strEndDate %></td></tr>

			<tr></tr><td colspan="2">�Ƿ��漰�ٱ���������������<%= strCoinsFlag %></td></tr>

			<tr></tr><td colspan="2">�ر�Լ����</td></tr>

			<tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>

			<tr><td colspan="2">�����գ�</td></tr>

			                        

			<tr>

			    <td colspan="2">

				    <table width="90%" align="center">

					    <tr>

						    <td align="center">����   </td>

							<td align="center"> ����/�޶�  </td>

							<td align="center">ÿ���⳥�޶�</td>

							<td align="center">˵��</td>

						</tr>

						<tr><td colspan="4"><hr align="center" width="90%" style="direction:inherit "/></td></tr>

					</table>

				</td>

			</tr>

			                                           

			<tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>

			<tr><td colspan="2">���������</td></tr> 

			

			                        

			<tr>

			    <td colspan="2">

				    <table width="90%" align="center">

					    <tr>

						    <td align="center">������   </td>

							<td align="center"> ����ԭ��  </td>

							<td align="center">����ʱ��</td>

							<td align="center">�˱���</td>

						</tr>

						<tr><td colspan="4"><hr width="90%" align="center" style="direction:inherit "/></td></tr>

					</table>

				</td>

			</tr>

			

			<tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>

			<tr><td colspan="2">���ѵ��������</td></tr>

			                                                                

			<tr>

			    <td colspan="2">

				    <table width="90%" align="center">

					    <tr>

						    <td align="center">��������   </td>

							<td align="center">������  </td>

							<td align="center">Ӧ��</td>

							<td align="center">ʵ��</td>

							<td align="center">��������</td>

						</tr>

					</table>

				</td>

			</tr>

			                                           

			<tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>

			<tr><td colspan="2">��ʷ�⸶��¼��</td></tr> 

			

			          

                           

              

			<tr>

			    <td colspan="2">

				    <table width="90%" align="center">

					    <tr>

						    <td align="center">�鵵��   </td>

							<td align="center"> ����ʱ��  </td>

							<td align="center">δ�����</td>

							<td align="center">�⸶���</td>

						    <td align="center">�᰸����</td>

							<td align="center">������</td>

							<td align="center">�⸶����</td>

						</tr>

						<tr><td colspan="7"><hr width="90%" align="center" style="direction:inherit "/></td></tr>

					</table>

				</td>

			</tr>

			<tr><td colspan="2"><hr align="center" width="90%" size="4"/></td></tr>

			<tr><td>�����ˣ�</td><td>�������ڣ�</td></tr>

		</table>

		

		 <!--include��ӡ��ť-->

  <jsp:include page="/common/print/PrintButton.jsp" />

	</body>

</html>

