<%--
****************************************************************************
* DESC       ���¹�����ǿ�Ʊ��վ���֪ͨ���ӡ
* AUTHOR     ��zhouliu
* CREATEDATE ��2005-12-08
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="java.util.*"%>

<%
	//������������
	String strPolicyNo = ""; //������
	String strInsuredName = ""; //��������
	String strLicenseNo = "";//�����������պ���
	String strDamageAddress = "";//���յص�
	DateTime damageDate=null;//����ʱ��
	Date curdate=new Date();

	//������������
	PrpLregistDto      prpLregistDto      = null;   //RegistDto����

	//�õ�ָ������
	RegistDto registDto = (RegistDto)request.getAttribute("registDto");

	//�õ�prpLregistDto����
     prpLregistDto = registDto.getPrpLregistDto();
	
	//��������ֵ
	strPolicyNo=prpLregistDto.getPolicyNo();
	strInsuredName=prpLregistDto.getInsuredName();
	strLicenseNo=prpLregistDto.getLicenseNo();
	strDamageAddress=prpLregistDto.getDamageAddress();
	damageDate=prpLregistDto.getDamageStartDate();	
%>