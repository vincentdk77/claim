
<%--
****************************************************************************
* DESC       ��ͨ�ô����ѯ����ҳ��,���������صĿ����,���������Ҫ��ʾ�����嵥ʱ���ô�ҳ��
*            ����ҳ��Ҫ���������쳣�����Բ����б�����󣬲����׳��κ��쳣
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2002-12-23
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*                lixiang     2004-6-17
****************************************************************************
*ת�����������£�
*             1�����Ŵ����ת��
*             2���ұ�����ת��
*             3���ձ�����ת��
*             4����������ת��
*             5������ԭ������ת��
*             6��������������ת��
*             7���¹����ʹ����ת��
*             8����֤�����ת��
*             9���Ӱ��� ������
*             10���¹ʴ�����
*             11���б���˾
*             12������Ͷ���ձ�
*             13�����ô���
*             14�����յ�ַ
*             15�����ȶ���
*             16����ʧ����ת��
*             17�����ڵ���ת��
*             18��������ҵת��
*             19������Ͷ���ձ� for ����ĲƲ�����
*             20������Ͷ���ձ� for �������Ա����
*             21. ��Ա�������ת��
*             22. ����ת��
*             23. ��������λ��ת�� CarPartCode
*             24. �ͻ����ϼ���ת���������ţ�  HandleUnit
*             25����������
*             26. ���ִ���
*             27. �鿱��Ա��Ϣ
*             28. ����ѯ����Ա��Ϣ
--%>
<%@page contentType="text/html; charset=GBK"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.utility.string.*"%>
<%@page import="com.sinosoft.sysframework.common.util.*"%>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.platform.dto.domain.PrpDliabDto"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLkindItemDto"%>
<%@page import="com.sinosoft.claim.resource.dtofactory.domain.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCinsuredNatureFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade"%>
<%@page import="com.sinosoft.prpall.schema.PrpCvirturlItemSchema"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcompany"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade"%>
<%@page import="com.sinosoft.nyx.schema.*"%>
<%@page import="com.sinosoft.nyx.dbsvr.*"%>
<%@page import="com.sinosoft.nyx.blsvr.*"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<%@page import="com.sinosoft.platform.ui.control.action.UIPowerAction"%>
<%@page import="com.sinosoft.sysframework.common.Constants"%>
<%@page import="com.sinosoft.utility.SysConfig"%>
<%@page import="com.sinosoft.claim.bl.facade.*"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCvirturlItem" %>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainCasualtySchema"%>
<%@page import="com.gyic.claim.bl.facade.BLZh03PolicyListFacade"%>
<%@page import="com.gyic.claim.dto.domain.Zh03PolicyListDto"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper"%>
<%@page import="com.gyic.claim.dto.domain.HerdpolicylistDto"%>
<%@page import="com.gyic.claim.dto.domain.HousepolicylistDto"%>
<%@page import="com.gyic.claim.dto.domain.InsuremainlistDto"%>
<%@page import="com.gyic.claim.bl.facade.BLHerdpolicylistFacade"%>
<%@page import="com.gyic.claim.bl.facade.BLHousepolicylistFacade"%>
<%@page import="com.gyic.claim.bl.facade.BLInsuremainlistFacade"%>
<%@page import="com.sinosoft.prpall.bl.facade.BLPrpCmainFacade"%>
<%@page import="com.sinosoft.prpall.dto.domain.PrpCmainDto"%>
<%@page import="com.gyic.claim.bl.facade.BLPrplcompensateearFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade"%>

<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", 0); 
%>
<%
  String codeindex = StringUtils.rightTrim(request.getParameter("codeindex"));
  String codevalue = StringUtils.rightTrim(request.getParameter("codevalue"));
  String rowlength = StringUtils.rightTrim(request.getParameter("rowlength"));
  String codetype  = StringUtils.rightTrim(request.getParameter("codetype" ));
  
  String relation  = StringUtils.rightTrim(request.getParameter("relation" ));
  String inputtype = StringUtils.rightTrim(request.getParameter("inputtype"));
  String querytype = StringUtils.rightTrim(request.getParameter("querytype"));
  String limit     = StringUtils.rightTrim(request.getParameter("limit"    ));
  String method    = StringUtils.rightTrim(request.getParameter("method"   ));
  String fieldsign = StringUtils.rightTrim(request.getParameter("fieldsign"));
  String other     = StringUtils.rightTrim(request.getParameter("other"    ));
  String liabDetailCode = StringUtils.rightTrim(request.getParameter("LiabDetailCode"));
  String damageStartDate  = StringUtils.rightTrim(request.getParameter("damageStartDate"));
  UIPowerInterface uiPowerInterface= new UIPowerInterface();   //Ȩ��У��

  //codevalue = new String(codevalue.getBytes("ISO8859-1")); //ת�� //delete by wuxiaodong 050907 reasion ����ѡ�����뺺�ֲ�ѯʱ�Ὣ����ת��Ϊ����
  StringBuffer buffer         = new StringBuffer(); // װ�ش����ѯ���
  String queryResult          = "";
  String errorMessage         = "";   // ������Ϣ
  int    recordSize           = -1;   // ��¼������Ϣ -1--null, 0--����0, 1--����0
  int    i                    = 0;
  int index = 0;
  String[] arrRelation;
  String[] arrCodeName        = new String[0];
  //�õ�����ҳ��ķ�ʽ,��ȷ���ǳ�������ҳ��,����ͨ��ҳ���ѯ����
  String submitMethod = request.getMethod();
  //���ִӻ�����ȡ��������
  String strRiskCode  = StringUtils.rightTrim(request.getParameter("riskcode"));
  UICodeAction uicodeAction = new UICodeAction();
	String strRiskType = uicodeAction.translateRiskCodetoRiskType(strRiskCode);
  String strProvinceCode  = StringUtils.rightTrim(request.getParameter("provinceCode"));
  if (strRiskCode.length()==0)
  {
     strRiskCode = "0000";
  }
  //���ִӻ�����ȡ��������
  String strLanguage = "C";

  //����Ͷ�����ֵĶ�ȡ����Ҫ����policy�Ĵ��룬������

  String strPolicyNo  = StringUtils.rightTrim(request.getParameter("policyno"));
  if (strPolicyNo.length()==0)
  {
     strPolicyNo = "";
  }
%>

<%
  //�����POST��ʽ����ҳ��,˵����Ҫͨ��ҳ���ѯ����,ִ�����²�ѯ����,����ֱ�ӷ���Ĭ��ҳ��
  if(submitMethod.equals("POST"))              // ��POST��ʽ����
  {
    Collection collection = new ArrayList();
    String conditions = "";  //�����ѯ����
    UICodeAction   uiCodeAction = new UICodeAction();
    //���ݲ�ͬ�Ĵ������ͽ��в�ѯ
    try
    {
      //���Ŵ���
      if(codetype.equals("ComCode"))                              //1�����Ŵ����ת��
      {
        if(method.equals("select"))
        {
          if(inputtype.equals("code"))
          {
            conditions = " comcode like '%" + codevalue + "%'";
          }
          else
          {
            conditions = " comcname like '%" + codevalue + "%'";
          }
        }
        else
        {
          if(inputtype.equals("code"))
          {
            conditions = " comcode like '%" + codevalue + "%'";
          }
          else
          {
            conditions = " comcname like '%" + codevalue + "%'";
          }
        }
        conditions = conditions+"  order by  comlevel,comcode ";
        collection = uiCodeAction.findByConditions(UICodeAction.COMCODE,conditions,0,0);
        recordSize=collection.size();
        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcompanyDto.getComCName());
          buffer.append("'>");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("-");
          buffer.append(prpDcompanyDto.getComCName());
        }
      }
      else if(codetype.equals("ComCodeByProvinceCode"))
      {
    	strProvinceCode = strProvinceCode.substring(0,6);
      	String baseCondition=" (";
      	baseCondition += "(";
      	baseCondition += "substr(comtype, 6, 1) is null  or substr(comtype, 6, 1)='' or substr(comtype, 6, 1) = '0'";
      	baseCondition += ")";
      	baseCondition += " and ";
      	baseCondition += " substr(comcode, 1, 6) = '"+strProvinceCode+"'";
      	baseCondition += ")";

      	baseCondition += " or ";
      	
      	baseCondition += "(";
      	baseCondition += " substr(comtype, 6, 1) = '1' ";
      	baseCondition += " and ";
      	baseCondition += "substr(uppercomcode, 1, 6) = '"+strProvinceCode+"'";
      	baseCondition += ")";
      	
      	conditions = " ("+baseCondition+") and (";
        if(method.equals("select"))
        {
          if(inputtype.equals("code"))
          {
            conditions += " comcode like '%" + codevalue + "%'" + ")";
          }
          else
          {
            conditions += " comcname like '%" + codevalue + "%'" + ")";
          }
        }
        else
        {
          if(inputtype.equals("code"))
          {
            conditions += " comcode like '%" + codevalue + "%'" +")";
          }
          else
          {
            conditions += " comcname like '%" + codevalue + "%'" + ")";
          }
        }
        
        conditions = conditions+"  order by  comlevel,comcode ";
        collection = uiCodeAction.findByConditions(UICodeAction.COMCODE,conditions,0,0);
        recordSize=collection.size();
        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcompanyDto.getComCName());
          buffer.append("'>");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("-");
          buffer.append(prpDcompanyDto.getComCName());
        }      
      }
      else if(codetype.equals("ComCodeByComLevel"))
      {
      	String baseCondition=" ComCode like '%000000000' ";
      	
      	conditions = " (" + baseCondition + ") and (";
      	
        if(method.equals("select"))
        {
          if(inputtype.equals("code"))
          {
            conditions += " comcode like '%" + codevalue + "%'" + ")";
          }
          else
          {
            conditions += " comcname like '%" + codevalue + "%'" + ")";
          }
        }
        else
        {
          if(inputtype.equals("code"))
          {
            conditions += " comcode like '%" + codevalue + "%'" +")";
          }
          else
          {
            conditions += " comcname like '%" + codevalue + "%'" + ")";
          }
        }
        conditions = conditions+"  order by  comlevel,comcode ";
        collection = uiCodeAction.findByConditions(UICodeAction.COMCODE,conditions,0,0);
        recordSize=collection.size();
        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcompanyDto.getComCName());
          buffer.append("'>");
          buffer.append(prpDcompanyDto.getComCode());
          buffer.append("-");
          buffer.append(prpDcompanyDto.getComCName());
        }      
      }
      else if(codetype.equals("Currency"))                  //2���ұ�����ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = " currencycode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " currencycname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = " currencycode like '%" + codevalue + "%'";
            }
            else
            {
               conditions = " currencycname like '%" + codevalue + "%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.CURRENCYCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcurrencyDto.getCurrencyCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcurrencyDto.getCurrencyCName());
           buffer.append("'>");
           buffer.append(prpDcurrencyDto.getCurrencyCode());
           buffer.append("-");
           buffer.append(prpDcurrencyDto.getCurrencyCName());
         }
      }
      else if(codetype.equals("KindCode"))                    //3���ձ�����ת��
      {
         conditions = "riskcode='"+strRiskCode+"' AND ValidStatus='1'";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = conditions + " AND kindcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = conditions + " AND kindcname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = conditions + " AND kindcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = conditions + " AND kindcname like '%"+codevalue +"%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.KINDCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDkindDto prpDkindDto = (PrpDkindDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDkindDto.getKindCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDkindDto.getKindCName());
           buffer.append("'>");
           buffer.append(prpDkindDto.getKindCode());
           buffer.append("-");
           buffer.append(prpDkindDto.getKindCName());
         }
      }
      else if(codetype.equals("ClauseCode"))                  //4����������ת��
      {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ClauseCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ClauseName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ClauseCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " ClauseName = '" + codevalue + "'";
            }
         }
         conditions = conditions +" AND LineNo=1"+" AND ValidStatus='1'"
                       + " AND ClauseCode IN"
                       + "( SELECT CodeCode FROM PrpDcodeRisk "
                       + " WHERE CodeType='ClauseCode'"
                       + " AND ( RiskCode='"+ strRiskCode
                       + "' OR RiskCode='0000' )" + " )"
                       + " ORDER BY ClauseCode";
         collection = uiCodeAction.findByConditions(UICodeAction.CLAUSECODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDclauseDto prpDclauseDto = (PrpDclauseDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDclauseDto.getClauseCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDclauseDto.getClauseName());
           buffer.append("'>");
           buffer.append(prpDclauseDto.getClauseCode());
           buffer.append("-");
           buffer.append(prpDclauseDto.getClauseName());
         }
     }
     else if(codetype.equals("DamageCode")) //5������ԭ������ת��
      {
         //���ݳ���ԭ�������в���
         String[] theMain= StringUtils.split(codevalue.trim(),"|");
         conditions = "";
         if(theMain[0].equals("9500")){
             // conditions = conditions + "codecode like '95%' and";
                conditions = conditions + "codecode like '50%' and";
         }else if(theMain[0].equals("9600")){
             // conditions = conditions + "codecode like '96%' and";
               conditions = conditions + "codecode like '60%' and";
         }else if(theMain[0].equals("9700")){
             // conditions = conditions + "codecode like '97%' and";
               conditions = conditions + "codecode like '70%' and";
         }else{
              //��ѯ����
         }
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = conditions+ " a.CodeCode like '%" + theMain[1] + "%'";
            }
            else
            {
             	conditions =conditions+  " a.CodeCName like '%" + theMain[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions =conditions+  " a.CodeCode = '" + theMain[1] + "'";
            }
            else
            {
              conditions =conditions+  " a.CodeCName = '" + theMain[1] + "'";
            }
         }

         conditions = "select a.CodeType,a.CodeCode,a.CodeCName,a.CodeEName,a.NewCodeCode,a.ValidStatus,a.Flag " +
         			  "from prpdcode a, prpdcoderisk b where a.codecode = b.codecode and a.codetype = b.codetype " +
         			  "and b.codetype = 'DamageCode' and b.riskcode='"+strRiskCode +"' and "+ conditions + " order by b.flag";
         collection = uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
      }
     else if(codetype.equals("DamageAreaCode")) //6��������������ת��
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


         collection = uiCodeAction.findByConditions(UICodeAction.DAMAGEAREACODE,conditions,0,0);

         recordSize=collection.size();



         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if (codetype.equals("HospitalCode")){//�Ϻ��ϴ�ƽ̨����ҽԺ����
    	 conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         } 
         
         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


         collection = uiCodeAction.findByConditions(UICodeAction.HOSPITALCODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
     }
     else if(codetype.equals("DiseaseCode")){//�Ϻ��ϴ�ƽ̨��������
    	 conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         } 
         
         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


         collection = uiCodeAction.findByConditions(UICodeAction.DISEASECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }
     }
     else if(codetype.equals("CancelReason")) //6��ע��ԭ������ת��
     {

        conditions = "";

        if(method.equals("select"))
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode like '%" + codevalue + "%'";
           }
           else
           {
               conditions = " CodeCName like '%" + codevalue + "%'";
           }
        }
        else
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode = '" + codevalue + "'";
           }
           else
           {
             conditions = " CodeCName = '" + codevalue + "'";
           }
        }


        conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


        collection = uiCodeAction.findByConditions(UICodeAction.DAMAGEAREACODE,conditions,0,0);

        recordSize=collection.size();



        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcodeDto.getCodeCName());
          buffer.append("'>");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("-");
          buffer.append(prpDcodeDto.getCodeCName());
        }

     }
     else if(codetype.equals("DamageTypeCode")) //7���¹����ʹ����ת��
      {
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         //conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
          conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where (riskcode='"+strRiskCode+"'  OR riskcode='0000') and codetype='"+codetype+"') and "+ conditions+" order by codecode";

         collection = uiCodeAction.findByConditions(UICodeAction.DAMAGETYPECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if(codetype.equals("claimType")) //7���¹����ʹ����ת��
     {
        conditions = "";

        if(method.equals("select"))
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode like '%" + codevalue + "%'";
           }
           else
           {
               conditions = " CodeCName like '%" + codevalue + "%'";
           }
        }
        else
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode = '" + codevalue + "'";
           }
           else
           {
             conditions = " CodeCName = '" + codevalue + "'";
           }
        }


        //conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
         conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where (riskcode='"+strRiskCode+"'  OR riskcode='0000') and codetype='"+codetype+"') and "+ conditions+" order by codecode";

        collection = uiCodeAction.findByConditions(UICodeAction.CASECODE,conditions,0,0);

        recordSize=collection.size();

        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcodeDto.getCodeCName());
          buffer.append("'>");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("-");
          buffer.append(prpDcodeDto.getCodeCName());
        }

     }
      else if(codetype.equals("InjuryGrade")) //�˲еȼ���
      {

         conditions = "";
         String[] arrInjuryGrade = StringUtils.split(codevalue.trim(),"|");
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + arrInjuryGrade[1] + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + arrInjuryGrade[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + arrInjuryGrade[1] + "'";
            }
            else
            {
              conditions = " CodeCName = '" + arrInjuryGrade[1] + "'";
            }
         }

         //ֻ���˲������β���ѡ���˲еȼ�
         //modify by miaowenjun 2007-1-31 22:50 ������ʱȥ��
         //if(arrInjuryGrade[0]==null || arrInjuryGrade[0].length()<3 || arrInjuryGrade[0].substring(1,2).equals("1"))
         //{
              //conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
              conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where (riskcode='"+strRiskCode+"'  OR riskcode='0000') and codetype='"+codetype+"') and "+ conditions+" order by codecode";
         //}
         //else
         //{
         //      conditions="1=2";
         //} 
         collection = uiCodeAction.findByConditions(UICodeAction.INJURYGRADE,conditions,0,0);
         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }


     else if(codetype.equals("DocCode")) //8����֤�����ת��
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


         collection = uiCodeAction.findByConditions(UICodeAction.DOCCODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if(codetype.equals("HanderCode")) //9���Ӱ��� ������
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " UserCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " UserName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " UserCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " UserCName = '" + codevalue + "'";
            }
         }

         UserDto       userDto      = (UserDto)session.getAttribute("user");          
         String        comCode      = userDto.getComCode();

         conditions = "  ValidStatus='1' and comcode like '" + comCode.substring(0,3) + "%' and "
                    +  conditions+" order by usercode";
        
         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDuserDto.getUserCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDuserDto.getUserName());
           buffer.append("'>");
           buffer.append(prpDuserDto.getUserCode());
           buffer.append("-");
           buffer.append(prpDuserDto.getUserName());
         }

      }
     else if(codetype.equals("HandleUnit")) //10���¹ʴ�����
      {
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ComCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ComCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ComCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " ComCName = '" + codevalue + "'";
            }
         }


         conditions = " ComLevel ='5'  and "+ conditions+" order by comlevel,ComCode";


         collection = uiCodeAction.findByConditions(UICodeAction.HANDLEUNIT,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcompanyDto.getComCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcompanyDto.getComCName());
           buffer.append("'>");
           buffer.append(prpDcompanyDto.getComCode());
           buffer.append("-");
           buffer.append(prpDcompanyDto.getComCName());
         }

      }
     else if(codetype.equals("InsureComCode")) //11���б���˾
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ComCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ComCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ComCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " ComCName = '" + codevalue + "'";
            }
         }


         conditions = " ValidStatus='1'  and "+ conditions+" order by comlevel,ComCode";


         collection = uiCodeAction.findByConditions(UICodeAction.INSURECOMCODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcompanyDto prpDcompanyDto = (PrpDcompanyDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcompanyDto.getComCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcompanyDto.getComCName());
           buffer.append("'>");
           buffer.append(prpDcompanyDto.getComCode());
           buffer.append("-");
           buffer.append(prpDcompanyDto.getComCName());
         }

      }
      else if(codetype.equals("PolicyKindCodeOfPerson")) //����ĳ�ֻ��ڱ�����Ͷ�����ձ�
      {
            conditions = "";
            String strFlag = "";
            String[] arrPolicyKind = StringUtils.split(codevalue.trim(),"|");
            int familyNo=Integer.parseInt(arrPolicyKind[0]);    
            
            if(method.equals("select"))
            {
                if(inputtype.equals("code"))
                {
                    conditions = " KindCode like '%" + arrPolicyKind[1] + "%'";
                }
                else
                {
             	      conditions = " KindName like '%" + arrPolicyKind[1] + "%'";
                }
            }
            else
            {
                if(inputtype.equals("code"))
                {
                    conditions = " KindCode = '" + arrPolicyKind[1] + "'";
                }
                else
                {
                    conditions = " KindName = '" + arrPolicyKind[1] + "'";
                }
            }
              conditions = " PolicyNo ='"+ strPolicyNo +"' and FAMILYNO =" + familyNo + " and "
                      + conditions+" order by Kindcode"; //���Ӳ�ѯ���� 2005-09-20
               conditions = SqlUtils.getWherePartForGetCount(conditions);
            collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);
            recordSize=collection.size();
            for(Iterator iterator = collection.iterator();iterator.hasNext();)
            {
                 PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
                 if(prpCitemKindDto.getFamilyNo()!=familyNo)
                 {
                     continue;
                 }
                 buffer.append("<option value='");
                 buffer.append(prpCitemKindDto.getKindCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getKindName());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemKindNo());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemDetailName());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getAmount());
                 buffer.append("'>");
                 buffer.append(prpCitemKindDto.getKindCode());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getKindName());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getItemCode());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getItemDetailName());
            }
            
      }
      else if(codetype.equals("PolicyKindCodeOfAgri"))
      {
            conditions = "";
            String strFlag = "";
            int familyNo= 0;
            String strModel = "";
            String[] arrPolicyKind = StringUtils.split(codevalue.trim(),"|");
               
            if(!arrPolicyKind[0].equals("")){
              familyNo=Integer.parseInt(arrPolicyKind[0]); 
            }
            if(!arrPolicyKind[2].equals("")){
              strModel=arrPolicyKind[2];  
            }
           
            if(method.equals("select"))
            {
                if(inputtype.equals("code"))
                {
                    conditions = " KindCode like '%" + arrPolicyKind[1] + "%'";
                }
                else
                {
             	      conditions = " KindName like '%" + arrPolicyKind[1] + "%'";
                }
            }
            else
            {
                if(inputtype.equals("code"))
                {
                    conditions = " KindCode = '" + arrPolicyKind[1] + "'";
                }
                else
                {
                    conditions = " KindName = '" + arrPolicyKind[1] + "'";
                }
            }
            
            if(familyNo>0){
               conditions = " PolicyNo ='"+ strPolicyNo +"' and FAMILYNO =" + familyNo + " and "
                      + conditions+" order by Kindcode"; 
            }
            else{
               if(!strModel.equals("")){
                  conditions = " PolicyNo ='"+ strPolicyNo +"' and model like '%" + strModel + "%' and "
                      + conditions+" order by Kindcode"; 
               }else{
                  conditions = " PolicyNo ='"+ strPolicyNo +"' and "
                      + conditions+" order by Kindcode";
               }
            }
          
            collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);
            recordSize=collection.size();
            for(Iterator iterator = collection.iterator();iterator.hasNext();)
            {
                 PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
                 buffer.append("<option value='");
                 buffer.append(prpCitemKindDto.getKindCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getKindName());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemKindNo());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getItemDetailName());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpCitemKindDto.getAmount());
                 buffer.append("'>");
                 buffer.append(prpCitemKindDto.getKindCode());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getKindName());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getItemCode());
                 buffer.append("-");
                 buffer.append(prpCitemKindDto.getItemDetailName());
            }
            
      }
      else if(codetype.equals("PrpDliab")) //�������ֺ��ձ�����������
      {
            conditions = "";
            String strFlag = "";
            String[] arrValue= StringUtils.split(codevalue.trim(),"|");
            String kindCode =arrValue[0];
            //modify by chenrenda begin 20070705
            //������������ֺ��ձ�ȥ����
            if(method.equals("select"))
            {
                if(inputtype.equals("code"))
                {
                    conditions = " ItemCode like '%" + arrValue[1] + "%'";
                }
                else
                {
             	      conditions = " ItemCName like '%" + arrValue[1] + "%'";
                }
            }
            else
            {
                if(inputtype.equals("code"))
                {
                    conditions = " ItemCode = '" + arrValue[1] + "'";
                }
                else
                {
                    conditions = " ItemCName = '" + arrValue[1] + "'";
                }
            }
            //modify by miaowenjun ��ʱ����Ӧ�ձ�
            
            conditions = " riskCode ='"+ strRiskCode +"' AND kindcode='"+arrValue[0]+"' and "
                      + conditions+" order by itemcode";
                      
            collection = uiCodeAction.findByConditions(UICodeAction.LIABCODE,conditions,0,0);
            recordSize=collection.size();
            for(Iterator iterator = collection.iterator();iterator.hasNext();)
            {
                 PrpLkindItemDto prpLkindItemDto = (PrpLkindItemDto)iterator.next(); 
                 buffer.append("<option value='");
                 buffer.append(prpLkindItemDto.getItemCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpLkindItemDto.getItemCName());
                 buffer.append("'>");
                 buffer.append(prpLkindItemDto.getItemCode());
                 buffer.append("-");
                 buffer.append(prpLkindItemDto.getItemCName());
            }
            //modify by chenrenda end 20070705
             
       
      }  
      
      
      
 //------------------------------------------------------------------------------
   else   if(codetype.equals("ModelCode"))   //���ʹ���
      {
       String[] arrModel = StringUtils.split(codevalue.trim(),"|");
       
        conditions = "validstatus='1' ";
        if(method.equals("select"))
        {
          if(inputtype.equals("code"))
          {
            if(!arrModel[3].trim().equals(""))
              conditions += " AND ModelCode like '%" + arrModel[3] + "%'";
            if(!arrModel[1].trim().equals(""))
              conditions += " AND CarStyle like '%" + arrModel[1] + "%'";
          }
          else
          {
            if(!arrModel[2].trim().equals(""))
              conditions += " AND ModelCode like '%" + arrModel[2] + "%'";
            if(!arrModel[3].trim().equals(""))
              conditions += " AND ModelName like '%" + arrModel[3] + "%'";
            if(!arrModel[1].trim().equals(""))
              conditions += " AND CarStyle like '%" + arrModel[1] + "%'";
          }
        }
        else
        {
          if(inputtype.equals("code"))
            conditions = conditions + " AND ModelCode = '" + arrModel[3] + "'";
          else
            conditions = conditions + " AND ModelName = '" + arrModel[3] + "'";
        }

        codevalue = arrModel[3];
       
       /* 
         if(strRiskCode!=null && strRiskCode.equals("0502"))
        {
           conditions+=" AND carkind='Ħ�г���'";
           if(inputtype.equals("select"))
           {
                conditions+=" or ModelCode ='9999999999'";
           }
        }
        */
        
        conditions += " ORDER BY ModelCode";
  
         collection = uiCodeAction.findByConditions("ModelCode",conditions,0,0);
            recordSize=collection.size();
      
      
            if(recordSize>300){  %>
             <script language='javascript'> 
             alert('��ѯ�������300��������������������ѯ');
           
             </script>   
           <% }
            else {
            for(Iterator iterator = collection.iterator();iterator.hasNext();)
            {
                 PrpDcarModelDto  prpDcarModelDto = (PrpDcarModelDto)iterator.next(); 
                 buffer.append("<option value='");
                 buffer.append(prpDcarModelDto.getModelCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpDcarModelDto.getModelName());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpDcarModelDto.getSeatCount());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(new DecimalFormat("###0.00").format(prpDcarModelDto.getTonCount()));//���ʹ���
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(prpDcarModelDto.getPurchasePrice()); 
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append(new DecimalFormat("###0.00").format(prpDcarModelDto.getPurchasePrice()));
                 buffer.append("'>");
                 buffer.append(prpDcarModelDto.getModelCode());
                 buffer.append("-");
                 buffer.append(prpDcarModelDto.getModelName());
                 
                 if(!prpDcarModelDto.getCarSeriesName().trim().equals(""))
                  {
                    buffer.append("-");
                    buffer.append(prpDcarModelDto.getCarSeriesName());
                  } 
            }
        }    
     }        
      
 //-------------------------------------------------------------------------------
      
      else if(codetype.equals("PolicyKindCode")) //12������Ͷ���ձ� ��Ҫ�ѱ���������Ϊת������
      {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         String PolicyBzNo = arrValue[2];
         String startDate = arrValue[0];
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }
         
         conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" order by Kindcode";
              conditions = SqlUtils.getWherePartForGetCount(conditions);           
                    
          EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
         PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,startDate);
         collection = policyDto.getPrpCitemKindDtoList();
         //add by qinyongli 2006-06-06 begin ����ǿ�Ʊ����ձ���Ϣ
         if(PolicyBzNo!=null&&!PolicyBzNo.equals("")){
            policyDto = endorseViewHelper.findForEndorBefore(PolicyBzNo,startDate);
            collection.addAll(policyDto.getPrpCitemKindDtoList());
         }
         //add by qinyongli 
         recordSize=collection.size();
         if(strRiskCode.trim().equals("QAA")){  
           for(Iterator iterator = collection.iterator();iterator.hasNext();)
           {
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             if(prpCitemKindDto.getRiskCode().equals("1003")){
            	 if((StringUtils.leftTrim(prpCitemKindDto.getFlag())).equals("1")){
	            	 buffer.append("<option value='");
	                 buffer.append(prpCitemKindDto.getKindCode());
	                 buffer.append("_FIELD_SEPARATOR_");
	                 buffer.append(prpCitemKindDto.getKindName());
	                 buffer.append("_FIELD_SEPARATOR_");
	                 buffer.append(prpCitemKindDto.getItemKindNo());
	                 buffer.append("'>");
	                 buffer.append(prpCitemKindDto.getKindCode());
	                 buffer.append("-");
	                 buffer.append(prpCitemKindDto.getKindName());
            	 }
             }else{
	             buffer.append("<option value='");
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getKindName());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemKindNo());
	             buffer.append("'>");
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getKindName());
             }
           }
         }else{    
           for(Iterator iterator = collection.iterator();iterator.hasNext();)
           {    
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
	            if (querytype.equals("selectb")){
                 if (!prpCitemKindDto.getKindCode().trim().equals("B")&&!prpCitemKindDto.getKindCode().trim().equals("BZ")
                     &&!prpCitemKindDto.getKindCode().trim().equals("001")&&!prpCitemKindDto.getKindCode().trim().equals("003")
                 	 &&!prpCitemKindDto.getKindCode().trim().equals("H")    
                 ){
			               
			  	             continue;
              	 }
              }
	            if (querytype.equals("selectforcar")){
	                 if ( prpCitemKindDto.getKindCode().trim().equals("D3")
	                     || prpCitemKindDto.getKindCode().trim().equals("D4") || prpCitemKindDto.getKindCode().trim().equals("D2")){
	                           
	                             continue;
	                 }
	              }
              if (querytype.equals("selectnotb")){
                
                   if (prpCitemKindDto.getKindCode().trim().equals("B")||prpCitemKindDto.getKindCode().trim().equals("BZ")){
			                 
			  	             continue;
              	   }
	  	           }
	  	    if(prpCitemKindDto.getRiskCode().equals("1003")){
	  	    	if((StringUtils.leftTrim(prpCitemKindDto.getFlag())).equals("1")){
	  	    	 buffer.append("<option value='");
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getKindName());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemKindNo());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getAmount());
	             buffer.append("'>"); 
	             buffer.append(prpCitemKindDto.getItemKindNo());
		         buffer.append("-");	             
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getKindName());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getItemCode());
	  	    	}
	  	    }else if("0122".equals(prpCitemKindDto.getRiskCode())){
	  	    	if("K03".equals(StringUtils.leftTrim(prpCitemKindDto.getKindCode()))){
	  	    		continue;
	  	    	}else{
	  	    	     buffer.append("<option value='");
		             buffer.append(prpCitemKindDto.getKindCode());
		             buffer.append("_FIELD_SEPARATOR_");
		             buffer.append(prpCitemKindDto.getKindName());
		             buffer.append("_FIELD_SEPARATOR_");
		             buffer.append(prpCitemKindDto.getItemKindNo());
		             buffer.append("_FIELD_SEPARATOR_");
		             buffer.append(prpCitemKindDto.getItemCode());
		             buffer.append("_FIELD_SEPARATOR_");
		             buffer.append(prpCitemKindDto.getItemDetailName());
		             buffer.append("_FIELD_SEPARATOR_");
		             buffer.append(prpCitemKindDto.getAmount());
		             buffer.append("'>");
		             buffer.append(prpCitemKindDto.getItemKindNo());
		             buffer.append("-");
		             buffer.append(prpCitemKindDto.getKindCode());
		             buffer.append("-");
		             buffer.append(prpCitemKindDto.getKindName());
		             buffer.append("-");
		             buffer.append(prpCitemKindDto.getItemCode());
		             buffer.append("-");
		             buffer.append(prpCitemKindDto.getItemDetailName());
	  	    	}
	  	    }else if("0313".equals(prpCitemKindDto.getRiskCode())){
				buffer.append("<option value='");
	            buffer.append(prpCitemKindDto.getKindCode());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getKindName());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getItemKindNo());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getItemCode());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getItemDetailName());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getRemark());
	            buffer.append("_FIELD_SEPARATOR_");
	            buffer.append(prpCitemKindDto.getAmount());
	            buffer.append("'>");
	            buffer.append(prpCitemKindDto.getItemKindNo());
	            buffer.append("-");
	            buffer.append(prpCitemKindDto.getKindCode());
	            buffer.append("-");
	            buffer.append(prpCitemKindDto.getKindName());
	            buffer.append("-");
	            buffer.append(prpCitemKindDto.getItemCode());
	            buffer.append("-");
	            buffer.append(prpCitemKindDto.getItemDetailName());
	            buffer.append("-");
	            buffer.append(prpCitemKindDto.getRemark());
	  	    }else{
	  	    	
	             buffer.append("<option value='");
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getKindName());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemKindNo());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getItemDetailName());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCitemKindDto.getAmount());
	             buffer.append("'>");
	             buffer.append(prpCitemKindDto.getItemKindNo());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getKindCode());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getKindName());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getItemCode());
	             buffer.append("-");
	             buffer.append(prpCitemKindDto.getItemDetailName());
	  	    }
           }
         }

      }
      //Modify by chenrenda begin 20070707
      //reason:����������ŵ���������ģ��б��ձ�ѡ��Ӧ���Ϸֻ��������
      else if(codetype.equals("AcciPolicyKindCode")) 
      {
         String strType = "AcciPolicyKindCode";
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[2];
         String familyNo = arrValue[3];

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }
         conditions = " PolicyNo ='"+ strPolicyNo +"' and familyno in "+familyNo+" and "
                    + conditions+" order by Kindcode";
                         conditions = SqlUtils.getWherePartForGetCount(conditions);
         collection = uiCodeAction.findByConditions(strType,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
              PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
              buffer.append("<option value='");
              buffer.append(prpCitemKindDto.getKindCode());
              buffer.append("_FIELD_SEPARATOR_");
              buffer.append(prpCitemKindDto.getKindName());
              buffer.append("_FIELD_SEPARATOR_");
              buffer.append(prpCitemKindDto.getItemKindNo());
              buffer.append("'>");
              buffer.append(prpCitemKindDto.getKindCode());
              buffer.append("-");
              buffer.append(prpCitemKindDto.getKindName());
              
         }
         //������֯codevalueֵ,���ڴ��к��е����ţ�js�����
         codevalue = arrValue[0]+"|"+arrValue[1]+"|"+arrValue[2];
   
      }
      
      //�������ձ�˫����
      else if(codetype.equals("PolicyKindCodeVirturlItem")) 
      {
         String strType = "AcciPolicyKindCode";
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[2];

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
              conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }

         conditions = " PolicyNo ='"+ strPolicyNo +"' and  "
                    + conditions+" order by Kindcode";
                         conditions = SqlUtils.getWherePartForGetCount(conditions);

         collection = uiCodeAction.findByConditions(strType,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
              PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
              buffer.append("<option value='");
              buffer.append(prpCitemKindDto.getKindCode());
              buffer.append("_FIELD_SEPARATOR_");
              buffer.append(prpCitemKindDto.getKindName());
              buffer.append("_FIELD_SEPARATOR_");
              buffer.append(prpCitemKindDto.getItemKindNo());
              buffer.append("'>");
              buffer.append(prpCitemKindDto.getItemKindNo());
              buffer.append("-");
              buffer.append(prpCitemKindDto.getKindCode());
              buffer.append("-");
              buffer.append(prpCitemKindDto.getKindName());
              
         }
         //������֯codevalueֵ,���ڴ��к��е����ţ�js�����
         codevalue = arrValue[0]+"|"+arrValue[1]+"|"+arrValue[2];
   
      }
      
      else if(codetype.equals("PolicyKindCode2")) //�ŵ���Ҫ���ӷֻ����Ʋ�ѯ��������Ȼ���γɴ����
      {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[2];
         String startDate = arrValue[0];
         String strBenAcciPerson = arrValue[3];
         
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }
         if("3202".equals(strRiskCode)){
             if(strBenAcciPerson!=null&&!strBenAcciPerson.equals("")){
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and model like '"+strBenAcciPerson+"' order by Kindcode";
             }else{
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" order by Kindcode";
             }
         }else{
             conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and familyname like '"+strBenAcciPerson+"' order by Kindcode"; 
         }
         conditions = SqlUtils.getWherePartForGetCount(conditions);
          
         BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
         collection = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {    
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             
	         buffer.append("<option value='");
             buffer.append(prpCitemKindDto.getKindCode());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getKindName());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getItemKindNo());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getAmount());
             buffer.append("'>");
             buffer.append(prpCitemKindDto.getKindCode());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getKindName());
         }
      }
      //�޸Ĳ�ѯ�ֻ���Ϣ�Ǵ�prpcvirturlitem������  add by ��Ԫ��Ŀ�� Τ����  start
      else if(codetype.equals("KindCodeVirturlItem")) 
      {
    	 conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[1];
         String thisValue =  arrValue[0];
         String strBenAcciPerson = arrValue[2];
         
         GroupProposalService groupProposalService = new GroupProposalService();
         //�Ƿ����ŵ��ı�־
         boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
 
         
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + thisValue + "%'";
            }
            else
            {
              conditions = " KindName like '%" + thisValue + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + thisValue + "'";
            }
            else
            {
              conditions = " KindName = '" + thisValue + "'";
            }
         }
         
         
	     if("9999".equals(strRiskCode)){
	         if(strBenAcciPerson!=null&&!strBenAcciPerson.equals("")){
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and model like '"+strBenAcciPerson+"' order by Kindcode";
             }else{
               conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" order by Kindcode";
             }
         }else{
             conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" and familyno = '"+strBenAcciPerson+"'  order by Kindcode"; 
         }
         conditions = SqlUtils.getWherePartForGetCount(conditions);
         BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
	     BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new  BLPrpCitemKindAgriFacade();    
	      if(isVirturlItemRisk){
	           collection = (ArrayList)blPrpCitemKindFacade.findVirturlItemByConditions(conditions);
	           recordSize=collection.size();
	           int itemKindNo=0;
		         for(Iterator iterator = collection.iterator();iterator.hasNext();)
		         {    
		           PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)iterator.next();
		           String ciSQL = " PolicyNo ='"+ strPolicyNo +"' and KindCode = '"+prpCvirturlItemSchema.getKindCode()+"' ";
		           if(prpCvirturlItemSchema.getRationType()!=null && !"".equals(prpCvirturlItemSchema.getRationType()))
	        	   {
		        	   ciSQL +=" and RationType ='"+prpCvirturlItemSchema.getRationType()+"' ";
	        	   }
		           double sumAmount = blPrpCitemKindFacade.getSumAmount(ciSQL);
		           if("2714".equals(strRiskCode)){
		        	    itemKindNo=  blPrpCitemKindFacade.getItemKindNo(ciSQL);
		           }else
			           if("3204".equals(strRiskCode)){
			        	    itemKindNo=  blPrpCitemKindFacade.getItemKindNo(" PolicyNo ='"+ strPolicyNo +"' and KindCode = '"+prpCvirturlItemSchema.getKindCode() +"' and ItemCode = '"+prpCvirturlItemSchema.getItemCode()+"' ");
			           }
		           else{
		        	    itemKindNo=  blPrpCitemKindFacade.getItemKindNo(" PolicyNo ='"+ strPolicyNo +"' and KindCode = '"+prpCvirturlItemSchema.getKindCode()+"' ");
		           }
		          
		           DecimalFormat idecimalFormat = new DecimalFormat("0.00");
		           if("3102".equals(strRiskCode) && prpCvirturlItemSchema.getKindCode().equals("001")
		        		   						 && prpCvirturlItemSchema.getItemCode().equals("0032")){
	            	   String querySql = " policyNo="+prpCvirturlItemSchema.getPolicyNo() +
	            	   					 " and kindCode='001' and times > 0" +
	            	   					 " and stratDate <= to_date('"+damageStartDate+"','yyyy-MM-dd')" +
	            	   					 " and endDate   >= to_date('"+damageStartDate+"','yyyy-MM-dd')";
	            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
	            	   if(agris.size() > 0){
	            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
	            		   double amount = Double.parseDouble(prpCvirturlItemSchema.getAmount());
	            		   prpCvirturlItemSchema.setAmount(String.valueOf(agriDto.getDistributingRate()*amount/100));
	            	   }
	               }	
		         buffer.append("<option value='");
	             buffer.append(prpCvirturlItemSchema.getKindCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCvirturlItemSchema.getKindName());
	             buffer.append("_FIELD_SEPARATOR_");
	             if("2606".equals(strRiskCode)|| "2609".equals(strRiskCode)){
	            	 //buffer.append(prpCvirturlItemSchema.getItemKindNo());
	            	 buffer.append(itemKindNo);
	             }else{
	            	 buffer.append(itemKindNo);
	             }
	             buffer.append("_FIELD_SEPARATOR_");
	             //��ֲ�����ڼ��㹫ʽ�޸ģ���Ҫ��λ������ձ��ܱ���
	             if("31".equals(strRiskCode.substring(0,2)) || "3219".equals(strRiskCode) || "3221".equals(strRiskCode)){
					 //���������ֻ���Ϊ�¹�����Ϣ���򲻴ӷֻ��嵥ȡ����ֻ����ֱ��ȡ��������
		             if("1".equals(prpCvirturlItemSchema.getVirturlFlag()))
		             {
		            	 buffer.append(prpCvirturlItemSchema.getUnitAmount()+"-"+idecimalFormat.format(sumAmount));
		             }else
		             {
		            	 buffer.append(prpCvirturlItemSchema.getUnitAmount()+"-"+prpCvirturlItemSchema.getAmount());
		             }
	             }else{
					 //���������ֻ���Ϊ�¹�����Ϣ���򲻴ӷֻ��嵥ȡ����ֻ����ֱ��ȡ��������
		             if("1".equals(prpCvirturlItemSchema.getVirturlFlag()))
		             {
		            	 buffer.append(idecimalFormat.format(sumAmount));
		             }else
		             {
		            	 buffer.append(prpCvirturlItemSchema.getAmount());
		             }
	             }
	             
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCvirturlItemSchema.getItemCode());
	             buffer.append("_FIELD_SEPARATOR_");
	             buffer.append(prpCvirturlItemSchema.getItemDetailName());
	             buffer.append("'>");
	             if("2606".equals(strRiskCode)||"3204".equals(strRiskCode)||"2609".equals(strRiskCode)){
	            	 buffer.append(prpCvirturlItemSchema.getItemKindNo());
	             }else{
	            	 buffer.append(itemKindNo);
	             }
	             buffer.append("-");
	             buffer.append(prpCvirturlItemSchema.getKindCode());
	             buffer.append("-");
	             buffer.append(prpCvirturlItemSchema.getKindName());
	             buffer.append("-");
	             buffer.append(prpCvirturlItemSchema.getItemDetailName());
	           }
         }
         else{
        	   collection = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
             recordSize=collection.size();
             for(Iterator iterator = collection.iterator();iterator.hasNext();)
             {    
               PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
               
               if("3102".equals(strRiskCode) && prpCitemKindDto.getKindCode().equals("001") 
            		   						 && prpCitemKindDto.getItemCode().equals("0032")){
            	   String querySql = " policyNo="+prpCitemKindDto.getPolicyNo() +
            	   					 " and kindCode='001' and times > 0" +
            	   					 " and stratDate <= to_date('"+damageStartDate+"','yyyy-MM-dd')" +
            	   					 " and endDate   >= to_date('"+damageStartDate+"','yyyy-MM-dd')";
            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
            	   if(agris.size() > 0){
            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
            		   prpCitemKindDto.setAmount(agriDto.getTimesAmount());
            	   }
               }
               
               buffer.append("<option value='");
               buffer.append(prpCitemKindDto.getKindCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpCitemKindDto.getKindName());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpCitemKindDto.getItemKindNo());
               buffer.append("_FIELD_SEPARATOR_");
	           //��ֲ�����ڼ��㹫ʽ�޸ģ���Ҫ��λ������ձ��ܱ���
	           if("31".equals(strRiskCode.substring(0,2))){
	            	 buffer.append(prpCitemKindDto.getUnitAmount()+"-"+prpCitemKindDto.getAmount());
	             }else{
	            	 buffer.append(prpCitemKindDto.getAmount());
	           }
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpCitemKindDto.getItemCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpCitemKindDto.getItemDetailName());
               buffer.append("'>");
               buffer.append(prpCitemKindDto.getKindCode());
               buffer.append("-");
               buffer.append(prpCitemKindDto.getKindName());
               buffer.append("-");
               buffer.append(prpCitemKindDto.getItemDetailName());
             }
        	 
         }
         
      }
      //�޸Ĳ�ѯ�ֻ���Ϣ�Ǵ�prpcvirturlitem������  add by ��Ԫ��Ŀ�� Τ����  end
     
      else if(codetype.equals("PolicyKindCode1"))
      {
         conditions = "";
         
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String startDate = arrValue[0];
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {  
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }
         
         conditions = " PolicyNo ='"+ strPolicyNo +"'  and "
                    + conditions+" order by Kindcode";
                         conditions = SqlUtils.getWherePartForGetCount(conditions);
         EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
         PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,startDate);
         collection = policyDto.getPrpCitemKindDtoList();
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
           {
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             buffer.append("<option value='");
             buffer.append(prpCitemKindDto.getKindCode());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getKindName());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getItemKindNo());
             buffer.append("'>");
             buffer.append(prpCitemKindDto.getItemKindNo());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getKindCode());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getKindName());
             
           }
      }
      else if(codetype.equals("PolicyItemCode")) //21���������� ��Ҫ�ѱ����������ձ���Ϊת������
      {
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ItemCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ItemDetailName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ItemCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " ItemDetailName = '" + codevalue + "'";
            }
         }
         conditions = " PolicyNo ='"+ strPolicyNo + "' AND KindCode ='"+ other +"' and "
                    + conditions+" order by Itemcode";
         collection = uiCodeAction.findByConditions(UICodeAction.POLICYITEMCODE,conditions,0,0);

         recordSize=collection.size();
         if(strRiskCode.trim().equals("QAA")){
           for(Iterator iterator = collection.iterator();iterator.hasNext();)
           {
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             buffer.append("<option value='");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getItemDetailName());
             buffer.append("'>");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getItemDetailName());
           }
         }else{
           for(Iterator iterator = collection.iterator();iterator.hasNext();)
           {
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             buffer.append("<option value='");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getItemDetailName());
             buffer.append("'>");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getItemDetailName());
           }
         }

      }
      else if(codetype.equals("PolicyItemCode2")) //�ŵ���Ҫ���ӷֻ����Ʋ�ѯ����
      {
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[2];
         String startDate = arrValue[0];
         String strBenAcciPerson = arrValue[3];
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ItemCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " ItemDetailName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ItemCode = '" + arrValue[1]+ "'";
            }
            else
            {
              conditions = " ItemDetailName = '" + arrValue[1] + "'";
            }
         }
         
         if("3202".equals(strRiskCode)){
             if(strBenAcciPerson!=null&&!strBenAcciPerson.equals("")){
                conditions = " PolicyNo ='"+ strPolicyNo + "' AND KindCode ='"+ other +"' and "
                    + conditions+" and model like '%"+strBenAcciPerson+"%' order by Itemcode";
             }else{
                conditions = " PolicyNo ='"+ strPolicyNo + "' AND KindCode ='"+ other +"' and "
                    + conditions+" order by Itemcode";
             }
         }else{
             conditions = " PolicyNo ='"+ strPolicyNo + "' AND KindCode ='"+ other +"' and "
                    + conditions+" and familyname like '%"+strBenAcciPerson+"%' order by Itemcode";
         }
         collection = uiCodeAction.findByConditions(UICodeAction.POLICYITEMCODE,conditions,0,0);

         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
             PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
             buffer.append("<option value='");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("_FIELD_SEPARATOR_");
             buffer.append(prpCitemKindDto.getItemDetailName());
             buffer.append("'>");
             buffer.append(prpCitemKindDto.getItemCode());
             buffer.append("-");
             buffer.append(prpCitemKindDto.getItemDetailName());
         }
     }
     else if(codetype.equals("PolicyKindCodeForProp")) //19������Ͷ���ձ� for ���� ��Ҫ�ѱ���������Ϊת������
      {

         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[0];
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }

         conditions = "( PolicyNo ='"+ strPolicyNo +"' or PolicyNo ='"+ PolicyBzNo +"'  ) and "
                   
                    + conditions+" and (KindCode='H' or kindCode='K6' or KindCode='B' or KindCode='D2' or KindCode='M1'  or kindCode='G0' or   KindCode='BZ' ) order by Kindcode";
         
         collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);
         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpCitemKindDto.getKindCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpCitemKindDto.getKindName());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpCitemKindDto.getItemKindNo());
           buffer.append("'>");
           buffer.append(prpCitemKindDto.getKindCode());
           buffer.append("-");
           buffer.append(prpCitemKindDto.getKindName());
         }

      }

     else if(codetype.equals("PolicyKindCodeForPerson")) //20������Ͷ���ձ� for ���� ��Ҫ�ѱ���������Ϊת������
      {

         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         String PolicyBzNo = arrValue[0];
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode like '%" + arrValue[1] + "%'";
            }
            else
            {
             	conditions = " KindName like '%" + arrValue[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " KindCode = '" + arrValue[1] + "'";
            }
            else
            {
              conditions = " KindName = '" + arrValue[1] + "'";
            }
         }

         conditions = "( PolicyNo ='"+ strPolicyNo +"' or PolicyNo ='"+ PolicyBzNo +"') and "
                   
                    + conditions+" and (KindCode='BZ' or KindCode='B' or KindCode='D1' or KindCode='D3' or KindCode='H' or KindCode='D4'or KindCode='001' or KindCode='003' or KindCode='004' or KindCode ='R') order by Kindcode";
                         conditions = SqlUtils.getWherePartForGetCount(conditions);
      
      
         collection = uiCodeAction.findByConditions(UICodeAction.POLICYKINDCODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
           
           buffer.append("<option value='");
           buffer.append(prpCitemKindDto.getKindCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpCitemKindDto.getKindName());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpCitemKindDto.getItemKindNo());
           buffer.append("'>");
           buffer.append(prpCitemKindDto.getKindCode());
           buffer.append("-");
           buffer.append(prpCitemKindDto.getKindName());
         }

      } else if(codetype.equals("PropertyFeeType"))  //22. �Ʋ�����ת��
      {
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }

         conditions = " ValidStatus='1' and "+ conditions+" order by codecode";
	
         collection = uiCodeAction.findByConditions("PropertyFeeType",conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }

     else if(codetype.equals("PersonFeeType"))  //21. �µ����˷�������ת��
      {
         conditions = "riskcode='"+strRiskCode+"' AND ValidStatus='1'";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " feecode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " name like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " code = '" + codevalue + "'";
            }
            else
            {
              conditions = " name = '" + codevalue + "'";
            }
         }
        
         collection = UIPersonFeeAction.getInstance().findAllCodeList(strRiskCode);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDpersonFeeCodeRiskDto prpDpersonFeeCodeRiskDto = (PrpDpersonFeeCodeRiskDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDpersonFeeCodeRiskDto.getFeeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDpersonFeeCodeRiskDto.getFeeName());
            buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDpersonFeeCodeRiskDto.getFeeCategory());
           buffer.append("'>");
           buffer.append(prpDpersonFeeCodeRiskDto.getFeeCode());
           buffer.append("-");
           buffer.append(prpDpersonFeeCodeRiskDto.getFeeName());
         }

      }

     else if(codetype.equals("PersonFeeTypeCode"))  //22. ��Ա����ת��(�ǳ��յ��ã�
      {
         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }

      //add  start reason����������Ա����ʾ�������Ŀ�б�        
        conditions =" ValidStatus='1' AND codeType ='FeePersonCode' AND " 
                 +  conditions + " AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype='"
                 + "FeePersonCode' AND (riskcode='"+ strRiskCode +"' OR riskcode='0000') )";       
      //add end   
         collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if(codetype.equals("ChargeCode")) //13�����ô���
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }
         
         //modify by weishixin add 20041026 begin
         //reason:�������ֹ��˲�ͬ����
         conditions =" ValidStatus='1' AND codeType ='"+ codetype +"' AND "+  conditions + " AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype='"+ codetype +"' AND (riskcode='"+ strRiskCode +"' OR riskcode='0000') )";
        
         //conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
         //modify by weishixin add 20041026 end

         collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }


     else if(codetype.equals("ChargeCode1")) //13�����ô���
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }

         //modify by weishixin add 20041026 begin
         //reason:�������ֹ��˲�ͬ����
          conditions =" ValidStatus='1' AND codeType ='ChargeCode' AND "+  conditions + " AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype='ChargeCode' AND (riskcode='"+ strRiskCode +"' OR riskcode='0000') )";
 
         //conditions = " codeType ='ChargeCode' and "+ conditions+" order by codecode";
         //modify by weishixin add 20041026 end

         collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if(codetype.equals("ChargeCode2")) //Ԥ�����ô���
     {

        conditions = "";

        if(method.equals("select"))
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode like '%" + codevalue + "%'";
           }
           else
           {
            	conditions = " CodeCName like '%" + codevalue + "%'";
           }
        }
        else
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode = '" + codevalue + "'";
           }
           else
           {
             conditions = " CodeCName = '" + codevalue + "'";
           }
        }

        //modify by weishixin add 20041026 begin
        //reason:�������ֹ��˲�ͬ����
         conditions =" ValidStatus='1' AND codeType ='ChargeCode' and codecode <>'14' AND "+  conditions + " AND codecode in (SELECT codecode FROM prpdcoderisk WHERE codetype='ChargeCode' AND (riskcode='"+ strRiskCode +"' OR riskcode='0000') )";

        //conditions = " codeType ='ChargeCode' and "+ conditions+" order by codecode";
        //modify by weishixin add 20041026 end

        collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

        recordSize=collection.size();

        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcodeDto.getCodeCName());
          buffer.append("'>");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("-");
          buffer.append(prpDcodeDto.getCodeCName());
        }

     }


     else if(codetype.equals("DamageAddress")) //14�����յ�ַ
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";


         collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
     else if(codetype.equals("ScheduleObject")) //15�����ȶ���
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " ScheduleObjectID like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " ScheduleObjectName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " ScheduleObjectID= '" + codevalue + "'";
            }
            else
            {
              conditions = "ScheduleObjectName = '" + codevalue + "'";
            }
         }


         conditions =  conditions+" order by ScheduleObjectID";


         collection = uiCodeAction.findByConditions(UICodeAction.SCHEDULEOBJECT,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpLscheduleObjectDto prpLscheduleObjectDto = (PrpLscheduleObjectDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpLscheduleObjectDto.getScheduleObjectID());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpLscheduleObjectDto.getScheduleObjectName());
           buffer.append("'>");
           buffer.append(prpLscheduleObjectDto.getScheduleObjectID());
           buffer.append("-");
           buffer.append(prpLscheduleObjectDto.getScheduleObjectName());
         }

      }
     else if(codetype.equals("CompCode")||codetype.equals("BusinessSource")||codetype.equals("DamageDistrict")||codetype.equals("CarPartCode")||codetype.equals("AcciCheckChargeType"))
      //16����ʧ����ת��
      //17�����ڵ���ת��
      //18��������ҵת��
      //23����������λ��ת��
      {

         conditions = "";

         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
         collection = uiCodeAction.findByConditions(UICodeAction.CHARGECODE,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }

     else if(codetype.equals("ClamCode"))
     {
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
               conditions = " claimcode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " longname like '%"+codevalue +"%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
               conditions = " reinscode like '%"+codevalue +"%'";
            }
            else
            {
               conditions = " longname  like '%"+codevalue +"%'";
            }
         }
         collection = uiCodeAction.findByConditions(UICodeAction.REINSCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           //PrpDreinsDto prpDreinsDto = (PrpDreinsDto)iterator.next();
           //buffer.append("<option value='");
           //buffer.append(prpDreinsDto.getPrpDreinsReinsCode());
           //buffer.append("_FIELD_SEPARATOR_");
           //buffer.append(prpDreinsDto.getPrpDreinsLongName());
           //buffer.append("'>");
           //buffer.append(prpDreinsDto.getPrpDreinsReinsCode());
           //buffer.append("-");
           //buffer.append(prpDreinsDto.getPrpDreinsLongName());
         }
      }


        else if(codetype.equals("KindCode4")) //BLPrpCitemKind �б������е��ձ�
      {

         
         EndorseViewHelper endorseViewHelper = new EndorseViewHelper();

         PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,damageStartDate);
         collection =  (ArrayList)policyDto.getPrpCitemKindDtoList();
         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
            buffer.append("<option value='");
            buffer.append(prpCitemKindDto.getKindCode());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getKindName());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getItemKindNo());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getItemDetailName());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getAmount());     //==itemValue
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getQuantity());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getUnitAmount());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getDeductible());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getDeductibleRate());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getAmount());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getFamilyName());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getItemCode());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpCitemKindDto.getCurrency());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(uiCodeAction.translateCodeCode(strRiskCode,prpCitemKindDto.getItemCode(),true));
            buffer.append("'>");
            buffer.append(prpCitemKindDto.getKindCode());
            buffer.append("-");
            buffer.append(prpCitemKindDto.getKindName());

         }

      } else if(codetype.equals("CustomerUnit")){      //�ͻ�����

         conditions = "  customercode like '%" + codevalue + "%'";
         collection = uiCodeAction.findByConditions(UICodeAction.CustomerUnit,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
          PrpDcustomerUnitDto prpDcustomerUnitDto = (PrpDcustomerUnitDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcustomerUnitDto.getCustomerCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcustomerUnitDto.getCustomerCName());
          buffer.append("'>");
          buffer.append(prpDcustomerUnitDto.getCustomerCode());
          buffer.append("-");
          buffer.append(prpDcustomerUnitDto.getCustomerCName());
         }
      } else if(codetype.equals("HandleUnitCar")) //�¹ʴ�����(���ڳ��գ�
      {

         //ԭ����ӳ��յ��¹ʴ����Ų�ѯ���룬��prpDcode�в�ѯ��
         conditions = " codetype = 'HandleUnit'";

         collection = uiCodeAction.findByConditions(UICodeAction.HandleUnitCar,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcode = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcode.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcode.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcode.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcode.getCodeCName());
         }
      } else if(codetype.equals("CaseCode")) {                //25.��������

      //ԭ���������յİ�������
          conditions = "";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where riskcode='"+strRiskCode+"' and codetype='"+codetype+"') and "+ conditions+" order by codecode";
         //conditions = " riskcode='"+strRiskCode+"' and codeType ='"+ codetype +"' and "+ conditions+" order by codecode";

         collection = uiCodeAction.findByConditions(UICodeAction.CASECODE, conditions, 0, 0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }else if(codetype.equals("CatastropheCode")) {                //26.���ִ���

      //ԭ����Ӿ��ִ���
          conditions = "";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode like '%" + codevalue + "%'";
            }
            else
            {
             	conditions = " CodeCName like '%" + codevalue + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions = " CodeCode = '" + codevalue + "'";
            }
            else
            {
              conditions = " CodeCName = '" + codevalue + "'";
            }
         }


         conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where riskcode='0000' and codetype='"+codetype+"') and "+ conditions+" order by codecode";
         //conditions = " riskcode='"+strRiskCode+"' and codeType ='"+ codetype +"' and "+ conditions+" order by codecode";

         collection = uiCodeAction.findByConditions(UICodeAction.CATASTROPHECODE, conditions, 0, 0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCode());
           buffer.append("-");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
      //���Ӳ�ѯ�����Ϣ�����ݱ����ź��ձ�
      else if(codetype.equals("PolicyItemKindCode")) {
          String[] theKindCode= StringUtils.split(codevalue.trim(),"|");
          PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
          String startDate = theKindCode[2];
          EndorseViewHelper endorseViewHelper = new EndorseViewHelper();     
          PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,startDate);   
          
          Collection itemKindList = policyDto.getPrpCitemKindDtoList();
          recordSize=itemKindList.size();       
          for(Iterator iterator = itemKindList.iterator();iterator.hasNext();){
              prpCitemKindDto =(PrpCitemKindDto)iterator.next(); 
             // modify by kangzhen
             // if (prpCitemKindDto.getKindCode().equals(theKindCode[0])) {
                   buffer.append("<option value='");
                   buffer.append(prpCitemKindDto.getItemCode());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(prpCitemKindDto.getItemDetailName());
                   if("0313".equals(strRiskCode)){
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getRemark());
                   }
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(new DecimalFormat("#,##0.00").format(prpCitemKindDto.getAmount()).toString());
                   //System.err.println(new BigDecimal(prpCitemKindDto.getAmount()).toString());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(new DecimalFormat("###0.00").format(prpCitemKindDto.getAmount()).toString());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(prpCitemKindDto.getDeductibleRate());
                   buffer.append("'>");
                   buffer.append(prpCitemKindDto.getItemCode());
                   buffer.append("-");
                   buffer.append(prpCitemKindDto.getItemDetailName());
                   if("0313".equals(strRiskCode)){
	                   buffer.append("-");
	                   buffer.append(prpCitemKindDto.getRemark());
                   }
              // }
          }
      }  else if(codetype.equals("PolicyItemKindCode1")){   //���Ӳ�ѯ�����Ϣ�����ݱ����ź��ձ� 2005-9-29
          String[] theKindCode= StringUtils.split(codevalue.trim(),"|");
          PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
          String startDate = theKindCode[2];
          EndorseViewHelper endorseViewHelper = new EndorseViewHelper();     
          PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,startDate);   
          
          Collection itemKindList = policyDto.getPrpCitemKindDtoList();
          recordSize=itemKindList.size();           
          for(Iterator iterator = itemKindList.iterator();iterator.hasNext();){
              prpCitemKindDto =(PrpCitemKindDto)iterator.next(); 
              if (prpCitemKindDto.getKindCode().equals(theKindCode[0])) {
                   buffer.append("<option value='");
                   buffer.append(prpCitemKindDto.getItemCode());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(prpCitemKindDto.getItemDetailName());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(NumberFormat.getInstance().format(prpCitemKindDto.getAmount()));
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(prpCitemKindDto.getAmount());
                   buffer.append("'>");
                   buffer.append(prpCitemKindDto.getItemCode());
                   buffer.append("-");
                   buffer.append(prpCitemKindDto.getItemDetailName());
               }
          }
      }      //���Ӳ�ѯ�����Ϣ�����ݱ�����(���ձ��޹�)
      else if(codetype.equals("PolicyItemKindCodeNoRisk")) {
          String[] theKindCode= StringUtils.split(codevalue.trim(),"|");
          PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
          String startDate = theKindCode[1];
          EndorseViewHelper endorseViewHelper = new EndorseViewHelper();     
          PolicyDto policyDto = endorseViewHelper.findForEndorBefore(strPolicyNo,startDate);   
          
          Collection itemKindList = policyDto.getPrpCitemKindDtoList();
          recordSize=itemKindList.size(); 
		  //0313����ȡ��ȥ��
		  if("0313".equals(strRiskCode)){
			for(Iterator iter = itemKindList.iterator(); iter.hasNext();){
				prpCitemKindDto = (PrpCitemKindDto)iter.next();
				buffer.append("<option value='");
				buffer.append(prpCitemKindDto.getItemCode());
				buffer.append("_FIELD_SEPARATOR_");
				buffer.append(prpCitemKindDto.getItemDetailName());
				buffer.append("_FIELD_SEPARATOR_");
				buffer.append(prpCitemKindDto.getRemark());
				buffer.append("_FIELD_SEPARATOR_");
				buffer.append(NumberFormat.getInstance().format(prpCitemKindDto.getAmount()));
				buffer.append("_FIELD_SEPARATOR_");
				buffer.append(prpCitemKindDto.getAmount());
				buffer.append("_FIELD_SEPARATOR_");
				buffer.append(prpCitemKindDto.getDeductibleRate());
				buffer.append("'>");
				buffer.append(prpCitemKindDto.getItemCode());
				buffer.append("-");
				buffer.append(prpCitemKindDto.getItemDetailName());
				buffer.append("-");
				buffer.append(prpCitemKindDto.getRemark());
			}
		  }else{
	          //ȥ���ظ��ı��
	          Map itemKindMap = new HashMap();          
	          for(Iterator iterator = itemKindList.iterator();iterator.hasNext();){
		          prpCitemKindDto =(PrpCitemKindDto)iterator.next(); 
		          if(prpCitemKindDto.getItemCode()!=null&&prpCitemKindDto.getItemCode().length()!=0){
		          	itemKindMap.put(prpCitemKindDto.getItemCode()+prpCitemKindDto.getItemDetailName(),prpCitemKindDto);
		          }
	          }
	    	  Set itemKindSet = itemKindMap.keySet();
	          for (Iterator iter = itemKindSet.iterator(); iter.hasNext();) {
				String Key = (String) iter.next();
				prpCitemKindDto =(PrpCitemKindDto)itemKindMap.get(Key);
//          for(Iterator iterator = itemKindList.iterator();iterator.hasNext();){
//              prpCitemKindDto =(PrpCitemKindDto)iterator.next(); 
//              if (prpCitemKindDto.getKindCode().equals(theKindCode[0])) {
	            if(prpCitemKindDto.getRiskCode().equals("0907")){  
	                   buffer.append("<option value='");
	                   buffer.append(prpCitemKindDto.getItemCode());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getItemDetailName());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getItemKindNo());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(NumberFormat.getInstance().format(prpCitemKindDto.getAmount()));
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getAmount());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getDeductibleRate());
	                   buffer.append("'>");
	                   buffer.append(prpCitemKindDto.getItemKindNo());
	                   buffer.append("-");
	                   buffer.append(prpCitemKindDto.getItemCode());
	                   buffer.append("-");
	                   buffer.append(prpCitemKindDto.getItemDetailName());
	            }else{
	            	   buffer.append("<option value='");
	                   buffer.append(prpCitemKindDto.getItemCode());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getItemDetailName());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(NumberFormat.getInstance().format(prpCitemKindDto.getAmount()));
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getAmount());
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCitemKindDto.getDeductibleRate());
	                   buffer.append("'>");
	                   buffer.append(prpCitemKindDto.getItemCode());
	                   buffer.append("-");
	                   buffer.append(prpCitemKindDto.getItemDetailName());
	            }
               //}
              // }
          	  }
		  }
      }else if(codetype.equals("PayObject")) //30��֧���������
      {

         conditions = "";
         
         String[] thePayObject= StringUtils.split(codevalue.trim(),"|");
         String payObjectType=thePayObject[0];
         String payObjectName=thePayObject[1];   
            
         if(method.equals("select"))
         {
           
             	conditions = " PayObjectName like '%" + payObjectName+ "%'";
         }
         else
         {
              conditions = " PayObjectName = '" + payObjectName + "'";
         }

         conditions =" ValidStatus='1' AND PayObjectType='"+payObjectType+"' And "+  conditions ;
         
 
         collection = uiCodeAction.findByConditions(UICodeAction.PAYOBJECT,conditions,0,0);

         recordSize=collection.size();

         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpLpayObjectDto prpLpayObjectDto = (PrpLpayObjectDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpLpayObjectDto.getPayObjectCode());
           buffer.append("_FIELD_SEPARATOR_");
           buffer.append(prpLpayObjectDto.getPayObjectName());
           buffer.append("'>");
           buffer.append(prpLpayObjectDto.getPayObjectCode());
           buffer.append("-");
           buffer.append(prpLpayObjectDto.getPayObjectName());
         }

      }else if(codetype.equals("prpCinsured")) {
				//modify by miaowenjun �⽡���¹��˴���ģ����ѯ
      //ԭ������⽡�յĲ�ѯ���룬��PrpCinsured�в�ѯ��
         UIPolicyAction uiPolicyAction = new UIPolicyAction();
         conditions = " policyno='"+strPolicyNo+"'";
         if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and insuredcode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and insuredname like '%" + codevalue+ "%'";	
      	  }
    	  }
    	  
         collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);

         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
             PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
             if(prpCinsuredDto.getInsuredFlag().equals("1") ||prpCinsuredDto.getInsuredFlag().equals("1")) {
                 //add by qinyongli start 2005-8-2 ���뱣������ϸ��Ϣ
                 String policyNo = prpCinsuredDto.getPolicyNo();
                 int    serialNo = prpCinsuredDto.getSerialNo();
                 BLPrpCinsuredNatureFacade blPrpCinsuredNatureFacade = new BLPrpCinsuredNatureFacade();
                 PrpCinsuredNatureDto prpCinsuredNatureDto = blPrpCinsuredNatureFacade.findByPrimaryKey(policyNo,serialNo);
                 //ֻ��ʾ�����������˺ͱ�����
                 buffer.append("<option value='");
                 buffer.append( prpCinsuredDto.getInsuredCode());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append( prpCinsuredDto.getInsuredName());
                 buffer.append("_FIELD_SEPARATOR_");
                 //modify by miaowenjun prpCinsuredNatureDto�п���Ϊnull������
                   if(prpCinsuredNatureDto != null){
	                 buffer.append( prpCinsuredNatureDto.getSex());
	                 buffer.append("_FIELD_SEPARATOR_");
	                 buffer.append( prpCinsuredNatureDto.getAge());
	                 buffer.append("_FIELD_SEPARATOR_");
	               }else{
	                 buffer.append("0");
	                 buffer.append("_FIELD_SEPARATOR_");
	                 buffer.append(0);
	                 buffer.append("_FIELD_SEPARATOR_");
	               }
                 
                 buffer.append( prpCinsuredDto.getIdentifyNumber());
                 buffer.append("_FIELD_SEPARATOR_");
                 buffer.append( serialNo);
                 buffer.append("'>");
                 buffer.append( prpCinsuredDto.getInsuredCode());
                 buffer.append("-");
                 buffer.append(prpCinsuredDto.getInsuredName());
           }
         }
      }
      else if(codetype.equals("prpCinsuredVirturlItem")) {
    	   //add by   ��Ԫ��Ŀ�� Τ����  2008-05-26   start
         //��Ԫ�ķֻ���Ϣ������prpcvirtutlitem�����Ҫ��������ȥȡֵ 
           UIPolicyAction uiPolicyAction = new UIPolicyAction();
           GroupProposalService groupProposalService = new GroupProposalService();
           //�Ƿ����ŵ��ı�־
           boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
           conditions = " policyno='"+strPolicyNo+"'";
           
           //���2743���ֵĸ��Ի�����
           if("2743".equals(strRiskCode)){
				String policyType="";
        	    BLPrpCmainFacade blPrpCmainFacade=new BLPrpCmainFacade();
        	    Collection prpCmainCollection=blPrpCmainFacade.findByConditions(conditions); 
        	    Iterator prpCmainIterator=prpCmainCollection.iterator();
        	    while(prpCmainIterator.hasNext()){
        	    	PrpCmainDto prpCmainDto=(PrpCmainDto)prpCmainIterator.next();
        	    	policyType=prpCmainDto.getPolicyType();
        	    	break;
        	    }
        	    if("01".equals(policyType)){//����
        	    	isVirturlItemRisk=false;
        	    }else if("02".equals(policyType)){//�ŵ�
        	    	isVirturlItemRisk=true;
        	    }
           }
           
          if(isVirturlItemRisk){
        	  if(!codevalue.trim().equals("")){   
        	    if(method.equals("select")){
	                 	conditions = conditions + " and familyname like '%" + codevalue+ "%'"; 
	            }
	            else{
	            		conditions = conditions + " and familyname = '" + codevalue+ "'"; 
	            }
        	  }
	           collection = uiPolicyAction.findPrpCinsuredViturlItemDtoByConditions(conditions);
			   
	           recordSize=collection.size();
	           for(Iterator iterator = collection.iterator();iterator.hasNext();)
	           {
	        	   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
	        	   
	                   buffer.append("<option value='");
	                   buffer.append( prpCvirturlItemSchema.getFamilyNo());//�ֻ����
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append( prpCvirturlItemSchema.getFamilyName());//�ֻ�����
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCvirturlItemSchema.getFamilySex());//�ֻ��Ա�
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append( prpCvirturlItemSchema.getFamilyAge());//�ֻ�����
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append( prpCvirturlItemSchema.getIdentifyNumber());//�ֻ����֤��
	                   buffer.append("_FIELD_SEPARATOR_");
                       buffer.append("0000");//�ŵ��ֻ��Ŀͻ�����ͳһдΪ0000
	                   buffer.append("'>");
	                   buffer.append( prpCvirturlItemSchema.getFamilyName());//�ֻ�������ʾ��
	                   buffer.append("---");
	                   buffer.append(prpCvirturlItemSchema.getIdentifyNumber());//�ֻ����֤����ʾ��
              }
	          
          }else{
        	  if(!codevalue.trim().equals("")){ 
       	    	if(method.equals("select")){
       	      		conditions = conditions + " and insuredname like '%" + codevalue+ "%'"; 
       	    	}
       	    	else{
       	    		conditions = conditions + " and insuredname = '" + codevalue+ "'"; 
       	    	}
        	  }
        	      collection = uiPolicyAction.findPrpCinsuredDtoByConditions(conditions);
                recordSize=collection.size();
	              for(Iterator iterator = collection.iterator();iterator.hasNext();)
	              {
	            	  PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) iterator.next();
	            	  if(prpCinsuredDto.getInsuredFlag().equals("1") ||prpCinsuredDto.getInsuredFlag().equals("1")) {
			            	    String policyNo = prpCinsuredDto.getPolicyNo();
			                  int    serialNo = prpCinsuredDto.getSerialNo();
			                  BLPrpCinsuredNatureFacade blPrpCinsuredNatureFacade = new BLPrpCinsuredNatureFacade();
			                  PrpCinsuredNatureDto prpCinsuredNatureDto = blPrpCinsuredNatureFacade.findByPrimaryKey(policyNo,serialNo);
	                
	                      buffer.append("<option value='");
	                      buffer.append( serialNo);//������������кţ��ŵ������familyno
	                      buffer.append("_FIELD_SEPARATOR_");
	                      buffer.append( prpCinsuredDto.getInsuredName());//�ֻ�����
	                      buffer.append("_FIELD_SEPARATOR_");
	                      
	                      if(prpCinsuredNatureDto != null){
	                          buffer.append( prpCinsuredNatureDto.getSex());//�ֻ��Ա�
	                          buffer.append("_FIELD_SEPARATOR_");
	                          buffer.append( prpCinsuredNatureDto.getAge());//�ֻ�����
	                          buffer.append("_FIELD_SEPARATOR_");
	                        }else{
	                          buffer.append("0");
	                          buffer.append("_FIELD_SEPARATOR_");
	                          buffer.append(0);
	                          buffer.append("_FIELD_SEPARATOR_");
	                        }
	                      
	                      buffer.append( prpCinsuredDto.getIdentifyNumber());//�ֻ����֤��
	                      buffer.append("_FIELD_SEPARATOR_");
	                      buffer.append( prpCinsuredDto.getInsuredCode());//�ֻ����룬���ŵ�û�д�ֵ�������д�ֵ
	                      buffer.append("'>");
	                      buffer.append( prpCinsuredDto.getInsuredName());//�ֻ�������ʾ��
	                      buffer.append("---");
	                      buffer.append(prpCinsuredDto.getIdentifyNumber());//�ֻ����֤����ʾ��
	                }
              }
          }
        }//���ɲ���ϱ��հ��������պͼҲ���,�ֱ��˺ͻ�
      else if(codetype.equals("prpCinsuredVirturlItem1")){
        	UIPolicyAction uiPolicyAction = new UIPolicyAction();
            GroupProposalService groupProposalService = new GroupProposalService();
            //�Ƿ����ŵ��ı�־
            boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
            conditions = " policyno='"+strPolicyNo+"'";
            
           if(isVirturlItemRisk){
         	  if(!codevalue.trim().equals("")){   
         	    if(method.equals("select")){
 	                 	conditions = conditions + " and familyname like '%" + codevalue+ "%'"; 
 	            }
 	            else{
 	            		conditions = conditions + " and familyname = '" + codevalue+ "'"; 
 	            }
         	  }
         	  if(!"".equals(other)){
         		 conditions = conditions + " and kindcode = '" + other+ "'"; 
         	  }
 	           //collection = uiPolicyAction.findPrpCinsuredViturlItemDtoByConditions(conditions);
 	          collection = uiPolicyAction.findViturlItemDtoByConditions(conditions);
 	          
 	           recordSize=collection.size();
 	           for(Iterator iterator = collection.iterator();iterator.hasNext();)
 	           {
 	        	   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
 	        	   
 	                   buffer.append("<option value='");
 	                   buffer.append( prpCvirturlItemSchema.getFamilyNo());//�ֻ����
 	                   buffer.append("_FIELD_SEPARATOR_");
 	                   buffer.append( prpCvirturlItemSchema.getFamilyName());//�ֻ�����
 	                   buffer.append("_FIELD_SEPARATOR_");
 	                   buffer.append(prpCvirturlItemSchema.getAmount());
	                   buffer.append("_FIELD_SEPARATOR_");
                        buffer.append("0000");//�ŵ��ֻ��Ŀͻ�����ͳһдΪ0000
 	                   buffer.append("'>");
                   	   buffer.append(prpCvirturlItemSchema.getHouseNumber());
                   	   buffer.append("---");
 	                   buffer.append( prpCvirturlItemSchema.getFamilyName());//�ֻ�������ʾ��
 	                   buffer.append("---");
 	                   buffer.append(prpCvirturlItemSchema.getIdentifyNumber());//�ֻ����֤����ʾ��
               }
           }
        }
    //���г����������α���
      else if(codetype.equals("prpCinsuredVirturlItem2")){
      	UIPolicyAction uiPolicyAction = new UIPolicyAction();
          GroupProposalService groupProposalService = new GroupProposalService();
          //�Ƿ����ŵ��ı�־
          boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
          conditions = " policyno='"+strPolicyNo+"'";
          
         if(isVirturlItemRisk){
       	  if(!codevalue.trim().equals("")){   
       	        if(method.equals("select")){
	       	         if(inputtype.equals("code"))
	                 {
	                   conditions = " brandCode like '%" + codevalue + "%'";
	                 }
	                 else
	                 {
	                  	conditions = " carnumber like '%" + codevalue + "%'";
	                 }
       	        	
	            }
	            else{
	                if(inputtype.equals("code"))
	                {
	                  conditions = " brandCode like '%" + codevalue + "%'";
	                }
	                else
	                {
	                 	conditions = " carnumber like '%" +codevalue+ "%'";
	                }
	            }
       	  }
       	  if(!"".equals(other)){
       		 conditions = conditions + " and kindcode = '" + other+ "'"; 
       	  }
	          collection = uiPolicyAction.findViturlItemDtoByConditions(conditions);
	          
	           recordSize=collection.size();
	           for(Iterator iterator = collection.iterator();iterator.hasNext();)
	           {
	        	   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) iterator.next();
	        	   
	                   buffer.append("<option value='");
	                   buffer.append( prpCvirturlItemSchema.getBrandCode());//���������ͺ�
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCvirturlItemSchema.getCarNumber());//�������
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append( prpCvirturlItemSchema.getFamilyNo());//�ֻ����
	                   buffer.append("_FIELD_SEPARATOR_");
	                   buffer.append(prpCvirturlItemSchema.getAmount());
	                   buffer.append("_FIELD_SEPARATOR_");
                       buffer.append("0000");//�ŵ��ֻ��Ŀͻ�����ͳһдΪ0000
	                   buffer.append("'>");
                 	   buffer.append(prpCvirturlItemSchema.getFamilyNo());
                 	   buffer.append("---");
                       buffer.append(prpCvirturlItemSchema.getBrandCode());//���������ͺ�
	                   buffer.append("---");
	                   buffer.append(prpCvirturlItemSchema.getCarNumber());//�������
             }
         } 
      }
      
      //��Ӳ鿱��Ա��Ϣ
      else if(codetype.equals("CheckPerson"))          //27.�鿱��Ա��Ϣ
      {
         String  checkCode    = "" ;//У�����
	     String  taskCode     = "" ;//�õ��������
	     boolean checkPower = false ; //�Ƿ�ͨ��У��
	     checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	     taskCode      = AppConfig.get("sysconst.TASKCODE_LP");

         conditions = "";

        //��ѯ�������µ�������Աprpduser��
       //  conditions = "  ValidStatus='1' "
        //               + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
         //              + "' Connect By Prior comCode =  uppercomCode"
        //               + " and prior comcode != comcode and validstatus='1')";
        //add by guolei 20070613 begin 
       String dbType=SysConfig.getProperty("DBTYPE");     
       if(dbType.equals("DB2")){
           String db2RecursionDown  =" with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
          "where root.COMCODE='"+other+"'"+
          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
          "select COMCODE from temptable  ORDER BY ComCode";
          String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
          conditions = "  ValidStatus='1' "
                       + " AND comCode in ("+comcodes+")";
          }
          //add by guolei 20070613 end 
        //��ѯ�������µ�������Աprpduser��
      else{
         conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                       + "' Connect By Prior comCode =  uppercomCode"
                       + " and prior comcode != comcode and validstatus='1')";
           }
        
    
        if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
      	  }
    	  }
         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
	       //�Բ�ѯ������Ա����Ȩ��У��
	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
	       com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
	       BLPrpDcompany prpDcompany = new BLPrpDcompany();   
           String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
         //�˴���ֵ�����⣬��Ӧʹ����Ա����������ϼ�������Ϊ��¼������Ӧʹ�ô���Ļ���������Ϊ����Ȩ�޼��������
	       //platformPrpDuserDto.setLoginComCode(upperComCode);
	       platformPrpDuserDto.setLoginComCode(other);
	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
	       checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
	       if (checkPower) {
               buffer.append("<option value='");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpDuserDto.getUserName());
               buffer.append("'>");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("-");
               buffer.append(prpDuserDto.getUserName());
           }
         }
      }
      //���������ϵ��
      else if(codetype.equals("JobManagerLinker")){
          conditions = "";
          String dbType=SysConfig.getProperty("DBTYPE");     
       	  if(dbType.equals("DB2")){
	          String db2RecursionDown  =" with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
	          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
	          "where root.COMCODE='"+other+"'"+
	          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
	          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
	          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
	          "select COMCODE from temptable  ORDER BY ComCode";
	          String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
	          conditions = "  ValidStatus='1'  AND comCode in ("+comcodes+")";
          }
          //add by guolei 20070613 end 
          //��ѯ�������µ�������Աprpduser��
          else{
        	  conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                       + "' Connect By Prior comCode =  uppercomCode"
                       + " and prior comcode != comcode and validstatus='1')";
           }
       	  if(!codevalue.trim().equals("")){
	      	  if(inputtype.equals("code")){
	      	  	conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
	      	  }
	      	  else{
	      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
	      	  }
    	  }
          collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
          recordSize=collection.size();
          for(Iterator iterator = collection.iterator();iterator.hasNext();){
        	//�Բ�ѯ������Ա����Ȩ��У��
	       	PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
            buffer.append("<option value='");
            buffer.append(prpDuserDto.getUserCode());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpDuserDto.getUserName());
            buffer.append("_FIELD_SEPARATOR_");
            buffer.append(prpDuserDto.getMobile());
            buffer.append("'>");
            buffer.append(prpDuserDto.getUserCode());
            buffer.append("-");
            buffer.append(prpDuserDto.getUserName());
            System.err.println(prpDuserDto.getUserCode()+"--"+prpDuserDto.getUserName()+"--"+prpDuserDto.getMobile());
         }
      }
      
      //����������Ա��Ϣ
      else if(codetype.equals("CertaJobCode")){
 	      boolean checkPower = false ; //�Ƿ�ͨ��У��
          conditions = "";
          String dbType=SysConfig.getProperty("DBTYPE");
	       if(dbType.equals("DB2")){
	    	   String db2RecursionDown  = " with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
								          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
								          "where root.COMCODE='"+other+"'"+
								          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
								          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
								          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
								          "select COMCODE from temptable  ORDER BY ComCode";
	    	   String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
	           conditions = "  ValidStatus='1' "
	                        + " AND comCode in ("+comcodes+")";
	       }
           //add by guolei 20070613 end 
           //��ѯ�������µ�������Աprpduser��
	      else{
	         conditions = "  ValidStatus='1' "
	                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
	                       + "' Connect By Prior comCode =  uppercomCode"
	                       + " and prior comcode != comcode and validstatus='1')";
	      }
          if(!codevalue.trim().equals("")){ 
	      	  if(inputtype.equals("code")){
	      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
	      	  }else{
	      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
	      	  }
    	  }
          //for test
          System.err.println("conditions==="+conditions);
          collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
          recordSize=collection.size();
          System.err.println("recordSize==="+recordSize);
          for(Iterator iterator = collection.iterator();iterator.hasNext();){
	 	       //�Բ�ѯ������Ա����Ȩ��У��
	 	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
	 		   //modify bu zhaolu 20060815 start
	 		   com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
	 		   com.sinosoft.utiall.blsvr.BLPrpDcompany prpDcompany = new com.sinosoft.utiall.blsvr.BLPrpDcompany();	
	 		   String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
	 	       platformPrpDuserDto.setLoginComCode(upperComCode);
	 	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
	 		   checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
	           if (checkPower) {
	               buffer.append("<option value='");
	               buffer.append(prpDuserDto.getUserCode());
	               buffer.append("_FIELD_SEPARATOR_");
	               buffer.append(prpDuserDto.getUserName());
	               buffer.append("'>");
	               buffer.append(prpDuserDto.getUserCode());
	               buffer.append("-");
	               buffer.append(prpDuserDto.getUserName());
	           }
         }
          //System.err.println("buffer::::"+buffer.toString());
      }
      else if(codetype.equals("CertaHanderCode"))          //50.������Ա��Ϣ
      {
         String  checkCode    = "" ;//У�����
	     String  taskCode     = "" ;//�õ��������
	     boolean checkPower = false ; //�Ƿ�ͨ��У��
	     checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	     taskCode      = "lpds";

         conditions = "";

        //��ѯ�������µ�������Աprpduser��
         //conditions = "  ValidStatus='1' "
                      // + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                      // + "' Connect By Prior comCode =  uppercomCode"
                      // + " and prior comcode != comcode and validstatus='1')";
                      
       String dbType=SysConfig.getProperty("DBTYPE");     
       if(dbType.equals("DB2")){
           String db2RecursionDown  =" with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
          "where root.COMCODE='"+other+"'"+
          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
          "select COMCODE from temptable  ORDER BY ComCode";
          String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
          conditions = "  ValidStatus='1' "
                       + " AND comCode in ("+comcodes+")";
          }
          //add by guolei 20070613 end 
        //��ѯ�������µ�������Աprpduser��
      else{
         conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                       + "' Connect By Prior comCode =  uppercomCode"
                       + " and prior comcode != comcode and validstatus='1')";
           }
        
                    
    
        if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
      	  }
    	  }
        
         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
	       //�Բ�ѯ������Ա����Ȩ��У��
	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
		   //modify bu zhaolu 20060815 start
		     com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
		   com.sinosoft.utiall.blsvr.BLPrpDcompany prpDcompany = new BLPrpDcompany();	
		   String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
		 //�˴���ֵ�����⣬��Ӧʹ����Ա����������ϼ�������Ϊ��¼������Ӧʹ�ô���Ļ���������Ϊ����Ȩ�޼��������
	       //platformPrpDuserDto.setLoginComCode(upperComCode);
	       platformPrpDuserDto.setLoginComCode(other);
	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
		    checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CERTAINLOSS);
			//modify by zhaolu 20060815 end
	       //checkPower=uiPowerInterface.checkPower(prpDuserDto.getUserCode(),taskCode,checkCode,"0501");
           if (checkPower) {
               buffer.append("<option value='");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpDuserDto.getUserName());
               buffer.append("'>");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("-");
               buffer.append(prpDuserDto.getUserName());
           }
         }
      }
     else if(codetype.equals("WoundHanderCode"))          //50.���˶�����Ա��Ϣ
      {
         String  checkCode    = "" ;//У�����
	     String  taskCode     = "" ;//�õ��������
	     boolean checkPower = false ; //�Ƿ�ͨ��У��
	     checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	     taskCode      = "lprd";

         conditions = "";

        //��ѯ�������µ�������Աprpduser��
        // conditions = "  ValidStatus='1' "
          //             + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
            //           + "' Connect By Prior comCode =  uppercomCode"
              //         + " and prior comcode != comcode and validstatus='1')";
         String dbType=SysConfig.getProperty("DBTYPE");     
       if(dbType.equals("DB2")){
           String db2RecursionDown  =" with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
          "where root.COMCODE='"+other+"'"+
          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
          "select COMCODE from temptable  ORDER BY ComCode";
          String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
          conditions = "  ValidStatus='1' "
                       + " AND comCode in ("+comcodes+")";
          }
          //add by guolei 20070613 end 
        //��ѯ�������µ�������Աprpduser��
      else{
         conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                       + "' Connect By Prior comCode =  uppercomCode"
                       + " and prior comcode != comcode and validstatus='1')";
           }
        
    
    
        if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
      	  }
    	  }
        
         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
	       //�Բ�ѯ������Ա����Ȩ��У��
	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
	        //add by zhaolu 20060815 start
		     com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
		   BLPrpDcompany prpDcompany = new BLPrpDcompany();   
	       String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
	       platformPrpDuserDto.setLoginComCode(upperComCode);
	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
		    checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
			 //add by zhaolu 20060815 end
	      // checkPower=uiPowerInterface.checkPower(prpDuserDto.getUserCode(),taskCode,checkCode,"0501");
           if (checkPower) {
               buffer.append("<option value='");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpDuserDto.getUserName());
               buffer.append("'>");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("-");
               buffer.append(prpDuserDto.getUserName());
           }
         }
      }
           else if(codetype.equals("PropHanderCode"))          //50.���˶�����Ա��Ϣ
      {
         String  checkCode    = "" ;//У�����
	     String  taskCode     = "" ;//�õ��������
	     boolean checkPower = false ; //�Ƿ�ͨ��У��
	     checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	     taskCode      = "lpcd";

         conditions = "";

        //��ѯ�������µ�������Աprpduser��
        // conditions = "  ValidStatus='1' "
          //             + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
            //           + "' Connect By Prior comCode =  uppercomCode"
              //         + " and prior comcode != comcode and validstatus='1')";
       String dbType=SysConfig.getProperty("DBTYPE");     
       if(dbType.equals("DB2")){
           String db2RecursionDown  =" with temptable(COMCODE,UPPERCOMCODE,Validstatus) "+
          " as  (select root.COMCODE,root.UPPERCOMCODE,root.Validstatus from PRPDCOMPANY root "+
          "where root.COMCODE='"+other+"'"+
          "union all select sub.COMCODE,sub.UPPERCOMCODE,sub.Validstatus from "+
          " PRPDCOMPANY sub,temptable super where sub.UPPERCOMCODE=super.comcode and "+
          " sub.comcode<>super.comcode and sub.Validstatus = '1')"+     
          "select COMCODE from temptable  ORDER BY ComCode";
          String comcodes= uiCodeAction.getRecursionComCode(db2RecursionDown);
          conditions = "  ValidStatus='1' "
                       + " AND comCode in ("+comcodes+")";
          }
          //add by guolei 20070613 end 
        //��ѯ�������µ�������Աprpduser��
      else{
         conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
                       + "' Connect By Prior comCode =  uppercomCode"
                       + " and prior comcode != comcode and validstatus='1')";
           }
        
    
    
        if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
      	  }
    	  }
        
         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
	       //�Բ�ѯ������Ա����Ȩ��У��
	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
	        //add by zhaolu 20060815 start
		     com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
		   BLPrpDcompany prpDcompany = new BLPrpDcompany();   
	       String upperComCode = prpDcompany.getCenterCode(prpDuserDto.getComCode());
	       platformPrpDuserDto.setLoginComCode(upperComCode);
	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
		    checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
			 //add by zhaolu 20060815 end
			
	       //checkPower=uiPowerInterface.checkPower(prpDuserDto.getUserCode(),taskCode,checkCode,"0501");
           if (checkPower) {
               buffer.append("<option value='");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpDuserDto.getUserName());
               buffer.append("'>");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("-");
               buffer.append(prpDuserDto.getUserName());
           }
         }
      }
      //�������ѯ����Ա��Ϣ
      else if(codetype.equals("VerifyPricePerson"))          //28.����ѯ����Ա��Ϣ
      {
        String  checkCode    = "" ;//У�����
	      String  taskCode     = "" ;//�õ��������
	      boolean checkPower = false ; //�Ƿ�ͨ��У��
	      checkCode     = AppConfig.get("sysconst.CHECKCODE_EXE");
	      taskCode      = AppConfig.get("sysconst.TASKCODE_LPHJ");

        conditions = "";

        //��ѯ�������µ�������Աprpduser��
      //  conditions = "  ValidStatus='1' "
        //               + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + other
          //             + "' Connect By Prior comCode =  uppercomCode"
            //           + " and prior comcode != comcode and validstatus='1')";

        conditions = "  ValidStatus='1' "
                       + " AND comCode in ( select ComCode from prpdCompany where ComCode like '" + other.substring(0,3)
                       + "%' and validstatus='1')";

        if(!codevalue.trim().equals("")){ 
      	  if(inputtype.equals("code")){
      	    conditions = conditions + " and UserCode like '%" + codevalue+ "%'";	
      	  }
      	  else{
      	    conditions = conditions + " and UserName like '%" + codevalue+ "%'";	
      	  }
    	  }

         collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE,conditions,0,0);
         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
	       //�Բ�ѯ������Ա����Ȩ��У��
	       PrpDuserDto prpDuserDto = (PrpDuserDto)iterator.next();
		   //add by zhaolu 20060815 start
		     com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
	       platformPrpDuserDto.setLoginComCode(prpDuserDto.getComCode());
	       platformPrpDuserDto.setUserCode(prpDuserDto.getUserCode());
		    checkPower=UIPowerAction.checkPowerReturn(platformPrpDuserDto,Constants.TASK_CLAIM_CHECK);
			//add by zhaolu 20060815 end
	       //checkPower=uiPowerInterface.checkPower(prpDuserDto.getUserCode(),taskCode,checkCode,"0501");
           if (checkPower) {
               buffer.append("<option value='");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("_FIELD_SEPARATOR_");
               buffer.append(prpDuserDto.getUserName());
               buffer.append("'>");
               buffer.append(prpDuserDto.getUserCode());
               buffer.append("-");
               buffer.append(prpDuserDto.getUserName());
           }
         }
      }else if(codetype.equals("IdentifyType")){
           uiCodeAction = new UICodeAction();
           conditions = "1=1";
           conditions = conditions + " and codeType ='"+ codetype +"' ";     
           collection = uiCodeAction.findByConditions("IdentifyType",conditions,0,0);
           recordSize=collection.size();
           if(collection!=null&&collection.size()>0){
               Iterator iterator = collection.iterator();
               while(iterator.hasNext()){
                    PrpDcodeDto codeDto =(PrpDcodeDto) iterator.next();
                    buffer.append("<option value='");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("_FIELD_SEPARATOR_");
                    buffer.append(codeDto.getCodeCName());
                    buffer.append("'>");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("-");
                    buffer.append(codeDto.getCodeCName());
               }
           }
      }else if(codetype.equals("frameType")){
    	  String registNo  = request.getParameter("codevalue");
    	  String carkindName = "";
    	  BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
          conditions = "1=1";
          conditions = conditions + " and registno ='"+ registNo +"' ";     
          collection = blPrpLthirdPartyFacade.findByConditions(conditions);
          recordSize=collection.size();
          if(collection!=null&&collection.size()>0){
              Iterator iterator = collection.iterator();
              while(iterator.hasNext()){
            	   PrpLthirdPartyDto prpLthirdPartyDto =(PrpLthirdPartyDto) iterator.next();
            	   if("1".equals(prpLthirdPartyDto.getInsureCarFlag()))
            	   {
            		   carkindName = "��ĳ�";
            	   }else
            	   {
            		   carkindName = "���߳�";
            	   }
                   buffer.append("<option value='");
                   buffer.append(prpLthirdPartyDto.getFrameNo());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(prpLthirdPartyDto.getLicenseNo());
                   buffer.append("_FIELD_SEPARATOR_");
                   buffer.append(carkindName);
                   buffer.append("'>");
                   buffer.append(prpLthirdPartyDto.getFrameNo());
                   buffer.append("-");
                   buffer.append(prpLthirdPartyDto.getLicenseNo());
                   buffer.append("-");
                   buffer.append(carkindName);
              }
          }
     }else if(codetype.equals("CompanyCode")){
           uiCodeAction = new UICodeAction();
           conditions = "1=1";
           conditions = conditions + " and codeType ='"+ codetype +"' ";     
           collection = uiCodeAction.findByConditions("CompanyCode",conditions,0,0);
           recordSize=collection.size();
           if(collection!=null&&collection.size()>0){
               Iterator iterator = collection.iterator();
               while(iterator.hasNext()){
                    PrpDcodeDto codeDto =(PrpDcodeDto) iterator.next();
                    buffer.append("<option value='");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("_FIELD_SEPARATOR_");
                    buffer.append(codeDto.getCodeCName());
                    buffer.append("'>");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("-");
                    buffer.append(codeDto.getCodeCName());
               }
           }
      }
       else if(codetype.equals("CompensateFormula")) //5������ԭ������ת��
      {
         //���ݳ���ԭ�������в���
 /*       String[] theMain= StringUtils.split(codevalue.trim(),"|");
         conditions = "";
         if(method.equals("select"))
         {
            if(inputtype.equals("code"))
            {
              conditions = conditions+ " CodeCode like '%" + theMain[1] + "%'";
            }
            else
            {
             	conditions =conditions+  " CodeCName like '%" + theMain[1] + "%'";
            }
         }
         else
         {
            if(inputtype.equals("code"))
            {
              conditions =conditions+  " CodeCode = '" + theMain[1] + "'";
            }
            else
            {
              conditions =conditions+  " CodeCName = '" + theMain[1] + "'";
            }
         }

*/
        conditions = " codeType ='"+ codetype +"' and codecode in (select codecode from PrpDcodeRisk where riskcode='"+strRiskCode+"' and codetype='"+codetype+"') ";
       //conditions = " riskcode='"+strRiskCode+"' and codeType ='"+ codetype +"' and "+ conditions+" order by codecode";
         collection = uiCodeAction.findByConditions(conditions);

         recordSize=collection.size();
         for(Iterator iterator = collection.iterator();iterator.hasNext();)
         {
           PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
           buffer.append("<option value='");
           buffer.append(prpDcodeDto.getCodeCName());
           buffer.append("'>");
           buffer.append(prpDcodeDto.getCodeCName());
         }

      }
      // �೵�����������չ�˾
       else if(codetype.equals("InsurerCompany"))
		{
			conditions = "codetype = 'InsurerCompany' and ";

			//conditions = "";
			if(method.equals("select"))
			 {
				if(inputtype.equals("code"))
				{
				  conditions += " codecode like '%" + codevalue + "%'";
				}
				else
				{
					conditions += " codecname like '%" + codevalue + "%'";
				}
			 }
			 else
			 {
				if(inputtype.equals("code"))
				{
				  conditions += " codecode = '" + codevalue + "'";
				}
				else
				{
				  conditions += " codecname = '" + codevalue + "'";
				}
			 }

			 conditions = " ValidStatus='1' and "+ conditions+" order by codecode";  
			 collection = uiCodeAction.findByConditions("InsurerCompany",conditions,0,0);

			 recordSize=collection.size();

			 for(Iterator iterator = collection.iterator();iterator.hasNext();)
			 {
			   PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
			   buffer.append("<option value='");
			   buffer.append(prpDcodeDto.getCodeCode());
			   buffer.append("_FIELD_SEPARATOR_");
			   buffer.append(prpDcodeDto.getCodeCName());
			   buffer.append("'>");
			   buffer.append(prpDcodeDto.getCodeCode());
			   buffer.append("-");
			   buffer.append(prpDcodeDto.getCodeCName());
			 }

		}
      // �ޱ��մ�����ʧ��Ŀ
      else if(codetype.equals("paidType"))
		{
			conditions = "codetype = 'paidType' and ";
			if(method.equals("select"))
			 {
				if(inputtype.equals("code"))
				{
				  conditions += " codecode like '%" + codevalue + "%'";
				}
				else
				{
					conditions += " codecname like '%" + codevalue + "%'";
				}
			 }
			 else
			 {
				if(inputtype.equals("code"))
				{
				  conditions += " codecode = '" + codevalue + "'";
				}
				else
				{
				  conditions += " codecname = '" + codevalue + "'";
				}
			 }

			 conditions = " ValidStatus='1' and "+ conditions+" order by codecode";  
			 collection = uiCodeAction.findByConditions("paidType",conditions,0,0);

			 recordSize=collection.size();

			 for(Iterator iterator = collection.iterator();iterator.hasNext();)
			 {
			   PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
			   buffer.append("<option value='");
			   buffer.append(prpDcodeDto.getCodeCode());
			   buffer.append("_FIELD_SEPARATOR_");
			   buffer.append(prpDcodeDto.getCodeCName());
			   buffer.append("'>");
			   buffer.append(prpDcodeDto.getCodeCode());
			   buffer.append("-");
			   buffer.append(prpDcodeDto.getCodeCName());
			 }

	}else if(codetype.equals("PlatFormComCode"))  //�б���˾����
    {
        conditions = "";

        if(method.equals("select"))
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode like '%" + codevalue + "%'";
           }
           else
           {
               conditions = " CodeCName like '%" + codevalue + "%'";
           }
        }
        else
        {
           if(inputtype.equals("code"))
           {
             conditions = " CodeCode = '" + codevalue + "'";
           }
           else
           {
             conditions = " CodeCName = '" + codevalue + "'";
           }
        }

        conditions = " ValidStatus='1' and "+ conditions+" order by codecode";
   
        collection = uiCodeAction.findByConditions("CompanyCode",conditions,0,0);

        recordSize=collection.size();

        for(Iterator iterator = collection.iterator();iterator.hasNext();)
        {
          PrpDcodeDto prpDcodeDto = (PrpDcodeDto)iterator.next();
          buffer.append("<option value='");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("_FIELD_SEPARATOR_");
          buffer.append(prpDcodeDto.getCodeCName());
          buffer.append("'>");
          buffer.append(prpDcodeDto.getCodeCode());
          buffer.append("-");
          buffer.append(prpDcodeDto.getCodeCName());
        }

     }else if(codetype.equals("ZH03prpLlossFamilyName"))//����ZH03ũ�Ҹ������ݱ����ţ��ֻ��Ų�ѯ��������
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[1];
         String strFamilyNo = arrValue[0];
         BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
   		 blPrpCmainCasualty.getData(strPolicyNo);
   		 if(null != blPrpCmainCasualty && blPrpCmainCasualty.getSize()==1){
   		 	PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
   		 	String insureListCode = prpCmainCasualtySchema.getRemark();
   		 	if(null!=strFamilyNo && !"".equals(strFamilyNo)){
   		 		//while(strFamilyNo.length() <7)
   		 		//	strFamilyNo = "0"+strFamilyNo;
   		 	}
   		 	if(null!=insureListCode && insureListCode.length() > 0){
   		 		conditions = " INUSRELISTCODE = '"+ insureListCode + "' "+//���������Ᵽ����ɸѡ���еı�����������
   								" and FAMILYNO = '"+ strFamilyNo + "' and KINDCODE = '2742001' ";
   				BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	   	   		collection = blZH03PolicyListFacade.findByConditions(conditions);
	   	   		recordSize = collection.size();
		        for(Iterator iterator = collection.iterator();iterator.hasNext();){
	   	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)iterator.next();
	   	   			buffer.append("<option value='");
	   	   			buffer.append(zh03PolicyListDto.getName());
          			buffer.append("'>");
	   	   			buffer.append(zh03PolicyListDto.getName());
          			buffer.append("</option>");
	   	   		}
   		 	}
   		 }
      }
     else if(codetype.equals("ZH03prpLlossFamilyNo"))//����ZH03ũ�Ҹ������ݱ����ţ��ֻ��Ų�ѯ��������
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         String strFamilyNo = arrValue[1];

         BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
   		 blPrpCmainCasualty.getData(strPolicyNo);
   		 if(null != blPrpCmainCasualty && blPrpCmainCasualty.getSize()==1){
   		 	PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
   		 	String insureListCode = prpCmainCasualtySchema.getRemark();
   		 	if(null!=insureListCode && insureListCode.length() > 0){
   		 		conditions = " INUSRELISTCODE = '"+ insureListCode + "' "+//���������Ᵽ����ɸѡ���еı�����������
   		 			" AND FamilyNo LIKE '%"+strFamilyNo+"%'  " +
   							" and KINDCODE = '2742001' and personno='1'";
   				BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	   	   		collection = blZH03PolicyListFacade.findByConditions(conditions);
	   	   		recordSize = collection.size();
		        for(Iterator iterator = collection.iterator();iterator.hasNext();){
	   	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)iterator.next();
		   	   		buffer.append("<option value='");
	   	   			buffer.append(zh03PolicyListDto.getFamilyNo());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(zh03PolicyListDto.getFamilyNo());
	      			buffer.append("'>");
	      			buffer.append(zh03PolicyListDto.getFamilyNo());
	   	   		 	buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getPersonNo());
	   	   		 	buffer.append("-");
	   	   		 	buffer.append(zh03PolicyListDto.getFamilyName());
	   	   		 	buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getFamilyFIdCard());
	   	   			buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getName());
	      			buffer.append("</option>");
	   	   		}
   		 	}
   		 }
     }
      else if(codetype.equals("ZH03prpLlossFamilyNo1"))//����ZH03ũ�Ҹ������ݱ����ţ��ֻ��Ų�ѯ��������
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         String strName = arrValue[1];
         BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
   		 blPrpCmainCasualty.getData(strPolicyNo);
   		 if(null != blPrpCmainCasualty && blPrpCmainCasualty.getSize()==1){
   		 	PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
   		 	String insureListCode = prpCmainCasualtySchema.getRemark();
   		 	if(null!=insureListCode && insureListCode.length() > 0){
   		 		conditions = " INUSRELISTCODE = '"+ insureListCode + "' "+//���������Ᵽ����ɸѡ���еı�����������
   							" AND NAME LIKE '%"+strName+"%' and KINDCODE = '2742001' ";
   				BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	   	   		collection = blZH03PolicyListFacade.findByConditions(conditions);
	   	   		recordSize = collection.size();
		        for(Iterator iterator = collection.iterator();iterator.hasNext();){
	   	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)iterator.next();
		   	   		buffer.append("<option value='");
	   	   			buffer.append(zh03PolicyListDto.getFamilyNo());
	   	   			buffer.append("_FIELD_SEPARATOR_");
				   	buffer.append(zh03PolicyListDto.getName());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(zh03PolicyListDto.getFamilyNo());

	      			buffer.append("'>");
	      			buffer.append(zh03PolicyListDto.getFamilyNo());
	   	   		 	buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getPersonNo());
	   	   		 	buffer.append("-");
	   	   		 	buffer.append(zh03PolicyListDto.getFamilyName());
	   	   		 	buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getFamilyFIdCard());
	   	   			buffer.append("-");
	   	   			buffer.append(zh03PolicyListDto.getName());
	      			buffer.append("</option>");
	   	   		}
   		 	}
   		 }
     }
       else if(codetype.equals("prpLRegistEarNoCheck"))//
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         String earlabel = arrValue[1];
         String kindCode = arrValue[2];
         String strDamageDate = arrValue[3];
         String strDamageHour = arrValue[4];
         ArrayList insureMainListDtoList = new ArrayList();
         InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + strPolicyNo + "' and VALIDITY in ('2','3') " +
				"and (STARTTIME <= to_date('"+strDamageDate+"','yyyy-mm-dd') " +
				"and ENDTIME >= to_date('"+strDamageDate+"','yyyy-mm-dd'))"; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
	
		if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
			BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
			insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
			String herdpolicylistDtoConditions = "Earlabel like'%" + earlabel + 
			"%' and kindcode = '" + kindCode +
			"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
			"' and VALIDITY = '1" +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd'))";
			collection = (ArrayList)bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions); 
			recordSize = collection.size();
		    for(Iterator iterator = collection.iterator();iterator.hasNext();){
		    	HerdpolicylistDto herdpolicylist = (HerdpolicylistDto)iterator.next();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper.findForEndorHerdpolicylistBefore(
						herdpolicylist,kindCode,strPolicyNo,strDamageDate,strDamageHour);
				
					buffer.append("<option value='");
					buffer.append(endorHerdpolicylistDto.getInusrelistcode());
					buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getFidcard());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   		 	buffer.append(endorHerdpolicylistDto.getFname());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBank());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBankcard());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getSumamount());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getAmount());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getFcode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getKindcode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBreedingareacode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBreedingareaname());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append("false");
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
	   	   			if(bLPrplcompensateearFacade.getInprocessCount(strPolicyNo,endorHerdpolicylistDto.getEarlabel())>0)
	   	   				buffer.append("Y");
	   	   			else
	   	   				buffer.append("N");
	      			buffer.append("'>");
	      			
	   	   			buffer.append(endorHerdpolicylistDto.getFcode());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getFidcard());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getFname());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	      			buffer.append("</option>");
      			
			}
		}
		else throw new UserException(1,3,"������:" + strPolicyNo + "��Ӧ���嵥�����쳣");
     }
     else if(codetype.equals("prpLRegistEarNoCheck1"))//
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         String earlabel = arrValue[1];
         String kindCode = arrValue[2];
         String strDamageDate = arrValue[3];
         String strDamageHour = arrValue[4];
         String strName = arrValue[5];
         ArrayList insureMainListDtoList = new ArrayList();
         InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + strPolicyNo + "' and VALIDITY in ('2','3') " +
				"and (STARTTIME <= to_date('"+strDamageDate+"','yyyy-mm-dd') " +
				"and ENDTIME >= to_date('"+strDamageDate+"','yyyy-mm-dd'))"; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
	
		if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
			BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
			insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
			String herdpolicylistDtoConditions = "Earlabel like'%" + earlabel + 
			"%' and fname like'%" + strName +
			"%' and kindcode = '" + kindCode +
			"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
			"' and VALIDITY = '1" +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd')) order by fname,earlabel";
			System.err.println(herdpolicylistDtoConditions);
			collection = (ArrayList)bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions); 
			recordSize = collection.size();
		    for(Iterator iterator = collection.iterator();iterator.hasNext();){
		    	HerdpolicylistDto herdpolicylist = (HerdpolicylistDto)iterator.next();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper.findForEndorHerdpolicylistBefore(
						herdpolicylist,kindCode,strPolicyNo,strDamageDate,strDamageHour);
				
					buffer.append("<option value='");
					buffer.append(endorHerdpolicylistDto.getInusrelistcode());
					buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getFidcard());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   		 	buffer.append(endorHerdpolicylistDto.getFname());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBank());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBankcard());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getSumamount());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getAmount());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getFcode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getKindcode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBreedingareacode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getBreedingareaname());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append("false");
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			BLPrplcompensateearFacade bLPrplcompensateearFacade = new BLPrplcompensateearFacade();
	   	   			if(bLPrplcompensateearFacade.getInprocessCount(strPolicyNo,endorHerdpolicylistDto.getEarlabel())>0)
	   	   				buffer.append("Y");
	   	   			else
	   	   				buffer.append("N");
	      			buffer.append("'>");
	      			
	   	   			buffer.append(endorHerdpolicylistDto.getFcode());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getFidcard());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getFname());
	   	   			buffer.append("-");
	   	   			buffer.append(endorHerdpolicylistDto.getEarlabel());
	      			buffer.append("</option>");
      			
			}
		}
		else throw new UserException(1,3,"������:" + strPolicyNo + "��Ӧ���嵥�����쳣");
     }
     else if(codetype.equals("prpLRegistHouseIdcardNoCheck"))//
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         String idcard = arrValue[1];
         String kindCode = arrValue[2];
         String strDamageDate = arrValue[3];
         String strDamageHour = arrValue[4];
         ArrayList insureMainListDtoList = new ArrayList();
         InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HousepolicylistDto housepolicylistDto = new HousepolicylistDto(); 
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + strPolicyNo + "' and VALIDITY in ('2','3') " +
				"and (STARTTIME <= to_date('"+strDamageDate+"','yyyy-mm-dd') " +
				"and ENDTIME >= to_date('"+strDamageDate+"','yyyy-mm-dd'))"; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
	
		if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
			BLHousepolicylistFacade bLHousepolicylistFacade = new BLHousepolicylistFacade();
			insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
			String housepolicylistDtoConditions = "idcard like'%" + idcard + 
			"%' and kindcode = '" + kindCode +
			"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
			"' and VALIDITY = '1" +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd')) and rownum<100";
			collection = (ArrayList)bLHousepolicylistFacade.findByConditions(housepolicylistDtoConditions); 
			recordSize = collection.size();
		    for(Iterator iterator = collection.iterator();iterator.hasNext();){
		    	HousepolicylistDto housepolicylist = (HousepolicylistDto)iterator.next();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				//HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper.findForEndorHerdpolicylistBefore(
						//housepolicylist,kindCode,strPolicyNo,strDamageDate,strDamageHour);
				
					buffer.append("<option value='");
					buffer.append(housepolicylist.getInusrelistcode());
					buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getIdcard());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   		 	buffer.append(housepolicylist.getName());
	   	   		 	buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getHukoubu());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getPhone());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getAddress());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getRemark());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append(housepolicylist.getKindcode());
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			buffer.append("false");
	   	   			buffer.append("_FIELD_SEPARATOR_");
	   	   			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
	   	   			if(bLPrplcompensatehouseFacade.getInprocessCount(strPolicyNo,housepolicylist.getIdcard())>0)
	   	   				buffer.append("Y");
	   	   			else
	   	   				buffer.append("N");
	      			buffer.append("'>");
	   	   			buffer.append(housepolicylist.getIdcard());
	   	   			buffer.append("-");
	   	   			buffer.append(housepolicylist.getName());
	      			buffer.append("</option>");
      			
			}
		}
		else throw new UserException(1,3,"������:" + strPolicyNo + "��Ӧ���嵥�����쳣");
     }
     else if(codetype.equals("prpLRegistHouseIdcardCheck1"))//
     {
         conditions = "";
         String[] arrValue= StringUtils.split(codevalue.trim(),"|");
         
         strPolicyNo = arrValue[0];
         System.err.println("codevalue:"+codevalue.trim());
         String idcard = arrValue[1];
         String kindCode = arrValue[2];
         String strDamageDate = arrValue[3];
         String strDamageHour = arrValue[4];
         String strName = arrValue[5];
         ArrayList insureMainListDtoList = new ArrayList();
         InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
		HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
		
		BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
		String insuremainlistConditions = "policyno = '" + strPolicyNo + "' and VALIDITY in ('2','3') " +
				"and (STARTTIME <= to_date('"+strDamageDate+"','yyyy-mm-dd') " +
				"and ENDTIME >= to_date('"+strDamageDate+"','yyyy-mm-dd'))"; 
		insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
	
		if(insureMainListDtoList != null && insureMainListDtoList.size() == 1){
			BLHousepolicylistFacade bLHousepolicylistFacade = new BLHousepolicylistFacade();
			insuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(0);
			String housepolicylistDtoConditions = "Idcard like'%" + idcard + 
			"%' and name like'%" + strName +
			"%' and kindcode = '" + kindCode +
			"' and INUSRELISTCODE = '" + insuremainlistDto.getInusrelistcode() +
			"' and VALIDITY = '1" +
			"' and (STARTDATE <= to_date('"+strDamageDate+"','yyyy-mm-dd')  and ENDDATE >= to_date('"+strDamageDate+"','yyyy-mm-dd')) and rownum<100 order by idcard";
			System.err.println(housepolicylistDtoConditions);
			collection = (ArrayList)bLHousepolicylistFacade.findByConditions(housepolicylistDtoConditions); 
			recordSize = collection.size();
		    for(Iterator iterator = collection.iterator();iterator.hasNext();){
		    	HousepolicylistDto housepolicylist = (HousepolicylistDto)iterator.next();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
//				HerdpolicylistDto endorHerdpolicylistDto = endorseViewHelper.findForEndorHerdpolicylistBefore(
//						housepolicylist,kindCode,strPolicyNo,strDamageDate,strDamageHour);
				
				buffer.append("<option value='");
				//buffer.append(housepolicylist.getInusrelistcode());
				//buffer.append("_FIELD_SEPARATOR_");
				buffer.append(housepolicylist.getName());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getIdcard());
   	   		 	buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getHukoubu());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getAddress());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getPhone());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getRemark());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
   	   			if(bLPrplcompensatehouseFacade.getInprocessCount(strPolicyNo,housepolicylist.getIdcard())>0)
   	   				buffer.append("Y");
   	   			else
   	   				buffer.append("N");
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getFloor());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getBuildingnumber());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getZhuannumber());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getWanumber());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getOthernumber());
   	   			buffer.append("_FIELD_SEPARATOR_");
   	   			buffer.append(housepolicylist.getKitchennumber());
      			buffer.append("'>");
   	   			buffer.append(housepolicylist.getIdcard());
   	   			buffer.append("-");
   	   			buffer.append(housepolicylist.getName());
      			buffer.append("</option>");

      			
			}
		}
		else throw new UserException(1,3,"������:" + strPolicyNo + "��Ӧ���嵥�����쳣");
     }

     else if (codetype.equals("AreasProvince") || codetype.equals("AreasCity") || codetype.equals("AreasTown")|| codetype.equals("AreasCountry")|| codetype.equals("AreasVillage")){
         String strCodeName          = "";
         String arrValue= codevalue.trim();
         int    intSize              = -1;
   	  if("AreasProvince".equals(codetype)){
   		conditions = " super_code = '0' And remark = '1' "; 
      	  }else if("AreasCity".equals(codetype)){
      		conditions = " super_code = '" +arrValue+ "' And remark='1' ";
     	  }else if("AreasTown".equals(codetype)){
     		 conditions = " super_code = '" +arrValue+ "' And remark='1' ";
   	  }else if("AreasCountry".equals(codetype)){
   		conditions = " super_code = '" +arrValue+ "' And remark='1' ";
   	  }else if("AreasVillage".equals(codetype)){
   		conditions = " super_code = '" +arrValue+ "' And remark='1' ";
   	  }
   	  BLAreas blAreas = new BLAreas();
   	conditions +=" ORDER BY AREA_CODE";
   	System.err.println(conditions);
         blAreas.query(conditions,0);
         recordSize=blAreas.getSize();       
         for(i=0;i<recordSize;i++){
             buffer.append("<option value='");
             buffer.append(blAreas.getArr(i).getArea_Code());
             buffer.append("_FIELD_SEPARATOR_");
             strCodeName = blAreas.getArr(i).getArea_Name();
             strCodeName = Str.encode(strCodeName);
             buffer.append(strCodeName);
             buffer.append("'>");
             buffer.append(blAreas.getArr(i).getArea_Code());
             buffer.append("-");
             buffer.append(strCodeName);   
         }
         System.err.println(buffer);
     }

     //�Դ���¼����е���������prpdcode�Ĳ��ͳһ����else�н��д���
     else{
           uiCodeAction = new UICodeAction();
           conditions = "1=1";
           conditions = conditions + " and codeType ='"+ codetype +"' ";     
           collection = uiCodeAction.findByConditions(null,conditions,0,0);
           recordSize=collection.size();
           if(collection!=null&&collection.size()>0){
               Iterator iterator = collection.iterator();
               while(iterator.hasNext()){
                    PrpDcodeDto codeDto =(PrpDcodeDto) iterator.next();
                    buffer.append("<option value='");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("_FIELD_SEPARATOR_");
                    buffer.append(codeDto.getCodeCName());
                    buffer.append("'>");
                    buffer.append(codeDto.getCodeCode());
                    buffer.append("-");
                    buffer.append(codeDto.getCodeCName());
               }
           }
      }
    }catch(Exception exception)
    {
      exception.printStackTrace();
      
      errorMessage = "��ѯʧ��";
    }
    queryResult = buffer.toString();
    //�����ѯ�����Ľ��Ϊ�գ����д��¼��
   if(queryResult ==null || "".equals(queryResult)){
    	recordSize = 0 ;
    }
    
     
  }
%>
<html>
	<head>
		<title>�����ѯ</title>
		<app:css />
		<script language="Javascript" src="/claim/common/js/Common.js"></script>
		<script language="Javascript" src="/claim/common/js/InputCode.js"></script>
		<script language="Javascript" src="/claim/common/js/PrivateInputCode.js"></script>
		<script language='javascript'>
        var fmInput;
        var fraInterface;
        try
        {
            //fraInterface= parent.fraMenu.fraInterface;
            //fmInput =fraInterface.fm;
            fmInput = parent.fraInterface.fm;
        }catch(E){

        }
    </script>
	</head>
	<body class="interface">
		<%--��ѯ�����󣬽���ѯ�������input�򴫻ص��ͻ��ˣ������ػ�ҳ�棬ʹ��ָ�����ʼ״̬--%>
		<form name='fm' action="/claim/common/pub/InputCode.jsp" method='POST'>
			<input type="hidden" name=codeindex value='<%=codeindex%>'>
			<input type="hidden" name=codevalue value='<%=codevalue%>'>
			<input type="hidden" name=rowlength value='<%=rowlength%>'>
			<input type="hidden" name=codetype value='<%=codetype%>'>
			<input type="hidden" name=relation value='<%=relation%>'>
			<input type="hidden" name=inputtype value='<%=inputtype%>'>
			<input type="hidden" name=querytype value='<%=querytype%>'>
			<input type="hidden" name=limit value='<%=limit%>'>
			<input type="hidden" name=method value='<%=method%>'>
			<input type="hidden" name=fieldsign value='<%=fieldsign%>'>
			<input type="hidden" name=other value='<%=other%>'>
			<input type="hidden" name=riskcode value='<%=strRiskCode%>'>
			<input type="hidden" name="provinceCode" value='<%=strProvinceCode%>'>
			<input type="hidden" name=policyno value='<%=strPolicyNo%>'>
			<input type="hidden" name="damageStartDate" value = '<%=damageStartDate%>'>
			<%
    try
    {
        if(submitMethod.equals("POST")){//�����POST����
            out.println("<script language='javascript'>            ");
                
                if(!errorMessage.equals("")){//��ѯ����ʧ��
                out.println("    //fm.elements["+codeindex+"].focus();");
                out.println("    window.status='��ѯ����ʧ��\t';");
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
            else if(method.equals("change") && recordSize>0){//��ѯ����ɹ���methodΪchange
            	if(queryResult!=null && !queryResult.equals("")){
	                queryResult = queryResult.substring(queryResult.indexOf("<option value='") + ("<option value='").length(),queryResult.indexOf("'>"));
	                arrCodeName = StringUtils.split(queryResult,"_FIELD_SEPARATOR_");
	                out.println("    window.status='��ѯ����<" + codevalue + ">�ɹ�';");
	                out.println("    if(parent.fraInterface.getSign()==fm.fieldsign.value){");
	               
	                if(inputtype.equals("name")){
	                
	                    arrRelation = StringUtils.split("0,"+relation,",");
	                    arrRelation[0] = arrRelation[1];
	                    arrRelation[1] = "0";      
	                    for(i=0;i<arrRelation.length;i++){
	                    
	                      
	                        index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));
	                        
	                       
	                        if(querytype.equals("need") && i!=0){
	                            out.println("        if(isEmpty(fmInput.elements["+ index +"])){");
	                        }
	                        if(i>arrCodeName.length-1){
	                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[arrCodeName.length-1]+"';");
	                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[arrCodeName.length-1]+"';");
	                        }
	                        else{
	                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[i]+"';");
	                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[i]+"';");
	                        }
	                        out.println("            try");
	                        out.println("            {");
	                        out.println("                if(fmInput.elements["+ index +"].onchange!=null){");
	                        out.println("                    fmInput.elements["+ index +"].onchange();");
	                        out.println("                }");
	                        out.println("            }catch(Ex1){");
	                        out.println("            }");
	                        if(querytype.equals("need") && i!=0){
	                        out.println("        }");
	                        }
	                    }
	                }
	                else{ //inputtype is 
	                
	                    arrRelation = StringUtils.split("0,"+relation,",");
	                    
	                    for(i=0;i<arrRelation.length;i++){
	                    	
	                        index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex)); 
	                        
	                        if(querytype.equals("need") && i!=0){
	                            out.println("        if(isEmpty(fmInput.elements["+ index +"])){");
	                        }
	                        if(i>arrCodeName.length-1){
	                            out.println("            fmInput.elements["+ index + "].value = '"+arrCodeName[arrCodeName.length-1]+"';");
	                            out.println("            fmInput.elements["+ index + "].tag = '"+arrCodeName[arrCodeName.length-1]+"';");
	                        }
	                        else{
	                            out.println("            fmInput.elements["+ index +"].value = '"+arrCodeName[i]+"';");
	                            out.println("            fmInput.elements["+ index +"].tag = '"+arrCodeName[i]+"';");
	                        }
	                        out.println("            try");
	                        out.println("            {");
	                        out.println("                if(fmInput.elements["+ index +"].onchange!=null){");
	                        out.println("                    fmInput.elements["+ index +"].onchange();");
	                        out.println("                }");
	                        out.println("            }catch(Ex1){");
	                        out.println("            }");
	                        if(querytype.equals("need") && i!=0){
	                            out.println("        }");
	                        }
	                    }
	                }
	
	                out.println("    }");
            	}
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(false);");
            }
            else if(recordSize==0){//û�в鵽��������������
                arrRelation = StringUtils.split("0,"+relation,",");
                if (limit.equals("must") && !codevalue.equals("")){
                    out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");
                    out.println("        fmInput.elements[" + codeindex + "].focus();");
                    out.println("        window.status='����<" + codevalue + ">�����ڣ�����������';");
                    out.println("    }");
                }
                else{
                    if (limit.equals("clear") || (limit.equals("must") && codevalue.equals(""))){
                        out.println("    window.status='����<" + codevalue + ">�����ڣ���������';");
                        out.println("    if(parent.fraInterface.getSign() == fm.fieldsign.value){");

                        for(i=0;i<arrRelation.length;i++){
                            index = Integer.parseInt(arrRelation[i]) + Integer.parseInt(DataUtils.nullToZero(codeindex));

                            out.println("        fmInput.elements[" + index + "].value = '';");
                            out.println("        fmInput.elements[" + index + "].tag = '';");
                        }
                        out.println("    }");
                    }
                    else if(limit.equals("none")){
                        out.println("    window.status='����<" + codevalue + ">������';");
                    }
                }
                out.println("    parent.fraInterface.setInquery(false);");
                out.println("    parent.fraInterface.setQueryError(true);");
            }
          
            out.println("</script>");
            if(errorMessage.equals("") &&  (method.equals("multSelect")||method.equals("select")) && recordSize>0){ //methodΪselect�Ҳ�ѯ�����
%>
			<table class="common" style="width:100%" align="center">
				<tr>
					<td style="width:30%">
					</td>
					<%if(querytype.equals("multSelect"))
            		{
%>
					<td style="width:20%" align="center">
						<%// ȷ����ť%>
						<input type=button name=SelectIt class="button" value="<%--<bean:message key='button.save.value' />--%>ȷ��" onclick='setMultiFieldValue()'></input>
					</td>
					<%}else {
%>
					<td style="width:20%" align="center">
						<%// ȷ����ť%>
						<input type=button name=SelectIt class="button" value="<%--<bean:message key='button.save.value' />--%>ȷ��" onclick='setFieldValue()'></input>
					</td>
					<%}%>
					<td style="width:20%" align="center">
						<input type=button name=CancelIt class="button" value="<bean:message key='button.cancel.value' />" onclick='cancelFieldValue()'></input>
					</td>
					<td style="width:30%">
					</td>
				</tr>
				<tr>
					<td colspan=4 align="center" style="width:100%">
						<%
            if(codetype.equals("ItemCode1") && (codevalue.equals("*") || codevalue.length()<=4) || (codetype.equals("ItemCode2") && (codevalue.equals("*") || codevalue.length()<=4)))
            {
%>
						<select name=codeselect class="code" style='width:480px' size=8 onkeypress=fieldOnKeyPress() ondblclick="continueQueryItemCode()">
							<%=buffer.toString()%>
						</select>
						<%
            }else if(querytype.equals("multSelect"))
            {
%>
						<select multiple="multiple"  name=codeselect class="code" style='width:480px' size=8 onkeypress=fieldOnKeyPress() ondblclick="setMultiFieldValue()">
							<%=buffer.toString()%>
						</select>
						<%
            }else{
%>
<select name=codeselect class="code" style='width:480px' size=8 onkeypress=fieldOnKeyPress() ondblclick="setFieldValue()">
							<%=buffer.toString()%>
						</select>
<%}%>
					</td>
				</tr>
			</table>
			<script language='javascript'>
          window.status='��ѯ����<<%=codevalue%>>�ɹ�';
          parent.fraRight.rows = "50%,0%,*";
          fm.codeselect.options.selectedIndex=0;
          fm.codeselect.focus();

          function continueQueryItemCode()
          {

             fm.codevalue.value = fm.codeselect.options[fm.codeselect.options.selectedIndex].value + "*";
             arrCodeValue = fm.codevalue.value.split(FIELD_SEPARATOR);
             fm.codevalue.value = arrCodeValue[0] + "*";
             fm.submit();
          }
        </script>
			<%
            }
        }
    }catch(Exception e2)
    {
        e2.printStackTrace();
    }
%>
		</form>
	</body>
</html>
