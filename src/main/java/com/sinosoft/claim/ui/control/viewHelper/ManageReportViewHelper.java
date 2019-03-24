package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.AbstractDto;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.ParameterDto;
import com.sinosoft.claim.ui.control.facade.UICommonFacade;
import com.sinosoft.sysframework.reference.AppConfig;

public class ManageReportViewHelper
{
  public ManageReportViewHelper()
  {
  } 

  /**
   * ��ȡҳ������Ϣ��
   * 1��AbstractDto(PageNo/RowsPerPage)
   * 2��AnaRepCommonDto(abstractDto/configs/arrParameter(ҳ���ϲ�ѯ��Ϣ��������ѯ��Ϣ)/queryFlag/resultType/queryStyle/logonUser)
   * @param  httpServletRequest
   * @return AnaRepCommonDto
   */
  public AnaRepCommonDto requestToDto(HttpServletRequest httpServletRequest)  throws Exception
  {
    System.out.println("ManageReportViewHelper:1==========");
    UICommonFacade uiCommonFacade = new UICommonFacade();
    AbstractDto abstractDto = new AbstractDto();
    AnaRepCommonDto anaRepCommonDto = new AnaRepCommonDto();
    ParameterDto parameterDto = null;

    ArrayList arrParameter = new ArrayList(); //ParameterDto�ļ��ϣ���Ӧ��AnaRepCommonDto.arrParameter
    Vector vecConfigs = new Vector(); //ҳ����������Ϣ
    HttpSession session = httpServletRequest.getSession();

    String strQueryFlag = ""; //AnaRepCommonDto��˽������
    String strResultType = ""; //AnaRepCommonDto��˽������
    String strLogonUser = ""; //AnaRepCommonDto��˽������
    String strQueryStyle = ""; //AnaRepCommonDto��˽������
    //ҳ���ѯ��
    String strConfigOwner = ""; //��������
    String strComCodeSign = "";
    String strComCode = "";
    String strRiskCodeSign = "";
    String strRiskCode = "";
    String strDateType = "";
    String strOverDays = "";
    String strDateStart = "";
    String strDateEnd = "";
    String strReportType = "";
    String strTimeLimit="";	
    String 	strDealTime="";
    String  strHandlerCode="";	
    //��ӦParameterDto����
    String strItemColumn = ""; //������WHERE���ֵ��ֶ���Ϣ
    String strParameterValue = ""; //������WHERE���ֵ��ֶε�ֵ

    int intQueryStyle = 0;
    int intPageNo = 0;
    int intRowsPerPage = 0;

    //����AnaRepCommmonDto
    if(httpServletRequest.getParameter("RowsPerPage")!=null)
    {
      anaRepCommonDto = (AnaRepCommonDto)session.getAttribute("AnaRepCommonDto");
    }
    else
    {
System.out.println("ManageReportViewHelper:2==========");
      //���ҳ������Ϣ
      try
      {
        strQueryFlag = httpServletRequest.getParameter("QueryFlag");
        strResultType = httpServletRequest.getParameter("ResultType");
        strLogonUser = httpServletRequest.getParameter("LogonUser");
        strQueryStyle = httpServletRequest.getParameter("QueryStyle");
        strConfigOwner = httpServletRequest.getParameter("ConfigOwner");
        strComCodeSign = httpServletRequest.getParameter("ComCodeSign");
        strComCode = httpServletRequest.getParameter("ComCode");
        strDateType = httpServletRequest.getParameter("DateType");
        strOverDays = httpServletRequest.getParameter("OverDays");
        strDateStart = httpServletRequest.getParameter("DateStart");
        strDateEnd = httpServletRequest.getParameter("DateEnd");
    	 strReportType= httpServletRequest.getParameter("ReportType");
    	 strTimeLimit= httpServletRequest.getParameter("DealTime");
    	 strHandlerCode=httpServletRequest.getParameter("HandlerCode");
	 
strResultType="strResultType";		
System.out.println("ResultType:"+strResultType);
System.out.println("QueryStyle:"+strQueryStyle);
System.out.println("ComCode:"+strComCode);
System.out.println("DateStart:"+strDateStart);
System.out.println("ReportType:"+strReportType);

        if(strQueryStyle==null||strQueryStyle.equals("6"))
          intQueryStyle = 0;
        else
          intQueryStyle = 1;

        if(strComCode==null||strComCode.length()==0)
          strComCode = AppConfig.get("sysconst.TOP_COMPANY");
      }
      catch(NullPointerException npe) //���QueryStyleΪ�յĻ�,˵���ǴӲ�ѯ����ҳ�����ӵ������ʾҳ��,�����Ǵӽ����ʾҳ�������ύ������
      {
      }

System.out.println("ManageReportViewHelper:3==========");
      //��÷�ҳ��Ϣ
      if(httpServletRequest.getParameter("PageNo")!=null) //��÷�ҳ��ʾ�Ĳ���
        intPageNo = Integer.parseInt(httpServletRequest.getParameter("PageNo"));
      else
        intPageNo = 1;

      intRowsPerPage = Integer.parseInt("10");

      abstractDto.setPageNo(intPageNo);
      abstractDto.setRowsPerPage(intRowsPerPage);
System.out.println("ManageReportViewHelper:4==========");

      //���ѡ������������Ϣ
      if(intQueryStyle==0)
      {
System.out.println("ManageReportViewHelper:5==========");
        anaRepCommonDto = new AnaRepCommonDto();
        anaRepCommonDto.setConfigs((Vector)uiCommonFacade.genConfigs(httpServletRequest));
      }
      else
      {
System.out.println("ManageReportViewHelper:6==========");
        anaRepCommonDto = new AnaRepCommonDto();

        vecConfigs.add("Sum");
        vecConfigs.add((ArrayList)session.getAttribute("CollectionSum"));
        anaRepCommonDto.setConfigs(vecConfigs);
      }
System.out.println("ManageReportViewHelper:7==========");

      //����ҳ���ϵ�ֵ���ɵ�����
//����      
System.out.println("ManageReportViewHelper:7=========="+strComCode);	
      if(strComCode!=null&&strComCode.length()>0)
      {
        if(strComCodeSign==null||strComCodeSign.length()==0)
          strComCodeSign = "=";
        strParameterValue = "'"+strComCode+"'";
        parameterDto = uiCommonFacade.genParameterDto("AND","","ComCode",strComCodeSign,"",strParameterValue,"","");
        arrParameter.add(parameterDto);
      }
System.out.println("ManageReportViewHelper:9==========");
      if(strHandlerCode!=null&&strHandlerCode.length()>0)
      {
        strParameterValue = "'"+strHandlerCode+"'";
        parameterDto = uiCommonFacade.genParameterDto("AND","","HandlerCode","=","",strParameterValue,"","");
        arrParameter.add(parameterDto);
      }



      if(strDateType!=null&&strDateType.length()>0&&
         strDateStart!=null&&strDateStart.length()>0&& //ҳ����Ӧ�ÿ������ڵ���ʼ����ֹʱ�䶼����Ϊ��
         strDateEnd!=null&&strDateEnd.length()>0)
      {
        strItemColumn = ""+strDateType;
        strParameterValue = "'"+strDateStart+"' AND '"+strDateEnd+"'";
        parameterDto = uiCommonFacade.genParameterDto("AND","",strItemColumn,"BETWEEN","",strParameterValue,"","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:10==========");
/*
	if(strDealTime!=null&&strDealTime.length()>0)
        {
        strParameterValue = "'"+strDealTime+"'";
        parameterDto = uiCommonFacade.genParameterDto("AND","","DealTime","=","",strParameterValue,"","");
        arrParameter.add(parameterDto);
        }
*/
        if(strOverDays!=null&&strOverDays.length()>0)
        {
          strItemColumn = "'"+strDateEnd+"'-"+strDateType;
          parameterDto = uiCommonFacade.genParameterDto("AND","",strItemColumn,"1","",strOverDays,"","");
          arrParameter.add(parameterDto);
        }
System.out.println("ManageReportViewHelper:11==========");
      }
//
//��������
System.out.println("ManageReportViewHelper:11=========="+strReportType);

if (strReportType.equals("report_regist")){
        strParameterValue = " nodetype='regis'";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12==========");
}
if (strReportType.equals("report_registf")){
        strParameterValue = " FirstSiteFlag='1' ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12=========="+strReportType);
}
if (strReportType.equals("report_cerloss")){
        strParameterValue = " nodetype='certi' ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12==========");
}
if (strReportType.equals("report_check")){
        strParameterValue = " nodetype='check' ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12==========");
}
if (strReportType.equals("report_bcheck")){
        strParameterValue = " BackVisitType='01' ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12==========");
}

if (strReportType.equals("report_certi")||
	strReportType.equals("report_certip")||
	strReportType.equals("report_compp")||
	strReportType.equals("report_veric")){
        strParameterValue = " Nodestatus='4' or Nodestatus='3' ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
System.out.println("ManageReportViewHelper:12==========");
}

   if (strReportType.equals("report_bvisit")||
		strReportType.equals("report_bvisitp")||
		strReportType.equals("report_bvisitlist")){
        strParameterValue = "  PrpLbackVisitQue.BackVisitID=PrpLbackVisit.BackVisitID ";
        parameterDto = uiCommonFacade.genParameterDto("AND",strParameterValue,"","|","","|","","");
        arrParameter.add(parameterDto);
   	}

      anaRepCommonDto.setAbstractDto(abstractDto);
      anaRepCommonDto.setArrParameter(arrParameter);
      anaRepCommonDto.setQueryFlag(strQueryFlag);
System.out.println("ManageReportViewHelper:13==========");
      anaRepCommonDto.setResultType(strResultType);
      anaRepCommonDto.setLogonUser(strLogonUser);
      anaRepCommonDto.setQueryStyle(intQueryStyle);
      anaRepCommonDto.setReportType(strReportType);
      anaRepCommonDto.setTimeLimit(strTimeLimit);	  
System.out.println("ManageReportViewHelper:14==========");
    }

System.out.println("ManageReportViewHelper:15==========");
    return anaRepCommonDto;
  }

  /**
   * setAttribute��
   * 1��CollectionSum
   * 2��Results
   * 3��AbstractDto
   * 4��AnaRepCommonDto
   */
  public void dtoToRequest(HttpServletRequest httpServletRequest,Collection collection,AnaRepCommonDto anaRepCommonDto)
  {
System.out.println("ManageReportViewHelper:16==========");
    Vector vecConfigs = anaRepCommonDto.getConfigs();
    HttpSession session = httpServletRequest.getSession();

    session.setAttribute("CollectionSum",(Collection)vecConfigs.get(1));
System.out.println("lijiyuanCollectionSum");		
System.out.println(collection.size());	
    httpServletRequest.setAttribute("Results",collection);
    httpServletRequest.setAttribute("AbstractDto",anaRepCommonDto.getAbstractDto());
    httpServletRequest.setAttribute("AnaRepCommonDto",anaRepCommonDto);
System.out.println("ManageReportViewHelper:17==========");
  }
}

