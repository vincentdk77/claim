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
   * 获取页面上信息：
   * 1、AbstractDto(PageNo/RowsPerPage)
   * 2、AnaRepCommonDto(abstractDto/configs/arrParameter(页面上查询信息、隐含查询信息)/queryFlag/resultType/queryStyle/logonUser)
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

    ArrayList arrParameter = new ArrayList(); //ParameterDto的集合，对应于AnaRepCommonDto.arrParameter
    Vector vecConfigs = new Vector(); //页面配置项信息
    HttpSession session = httpServletRequest.getSession();

    String strQueryFlag = ""; //AnaRepCommonDto的私有属性
    String strResultType = ""; //AnaRepCommonDto的私有属性
    String strLogonUser = ""; //AnaRepCommonDto的私有属性
    String strQueryStyle = ""; //AnaRepCommonDto的私有属性
    //页面查询项
    String strConfigOwner = ""; //隐含条件
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
    //对应ParameterDto参数
    String strItemColumn = ""; //出现在WHERE部分的字段信息
    String strParameterValue = ""; //出现在WHERE部分的字段的值

    int intQueryStyle = 0;
    int intPageNo = 0;
    int intRowsPerPage = 0;

    //生成AnaRepCommmonDto
    if(httpServletRequest.getParameter("RowsPerPage")!=null)
    {
      anaRepCommonDto = (AnaRepCommonDto)session.getAttribute("AnaRepCommonDto");
    }
    else
    {
System.out.println("ManageReportViewHelper:2==========");
      //获得页面项信息
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
      catch(NullPointerException npe) //如果QueryStyle为空的话,说明是从查询条件页面链接到结果显示页面,否则是从结果显示页面自身提交过来的
      {
      }

System.out.println("ManageReportViewHelper:3==========");
      //获得分页信息
      if(httpServletRequest.getParameter("PageNo")!=null) //获得分页显示的参数
        intPageNo = Integer.parseInt(httpServletRequest.getParameter("PageNo"));
      else
        intPageNo = 1;

      intRowsPerPage = Integer.parseInt("10");

      abstractDto.setPageNo(intPageNo);
      abstractDto.setRowsPerPage(intRowsPerPage);
System.out.println("ManageReportViewHelper:4==========");

      //获得选择后的配置项信息
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

      //根据页面上的值生成的条件
//依据      
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
         strDateStart!=null&&strDateStart.length()>0&& //页面上应该控制日期的起始、终止时间都不能为空
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
//其它处理
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
   * setAttribute：
   * 1、CollectionSum
   * 2、Results
   * 3、AbstractDto
   * 4、AnaRepCommonDto
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

