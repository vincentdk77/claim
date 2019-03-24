package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.AbstractDto;
import com.sinosoft.claim.dto.custom.AnaRepCommonDto;
import com.sinosoft.claim.dto.custom.AnaResultDto;
import com.sinosoft.claim.ui.control.action.UIManageReportAction;
import com.sinosoft.claim.ui.control.viewHelper.ManageReportViewHelper;

public class UIManageReportFacade extends Action
{
  /**
   * 1、获得AnaRepCommonDto，以获得条件查询条件信息、配置项信息等
   * 2、获得由页面上的值的查询的结果，结果是AnaResultDto的集合
   * 3、设置AbstractDto的PageCount、RowsCount属性
   * 4、将获得的结果放入session中，为了以后的操作中能够直接获得相关值或对象
   * 5、intQueryStyle不为0时，调用公共的方法生成Excel
   */
  public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
         throws Exception
  {
System.out.println("UIManageReportFacade:1==========");
    UICommonFacade uiCommonFacade = new UICommonFacade();
    UIManageReportAction uiManageReportAction = new UIManageReportAction();
    ManageReportViewHelper manageReportViewHelper = new ManageReportViewHelper();
    AnaRepCommonDto anaRepCommonDto = new AnaRepCommonDto();
    AnaResultDto anaResultDto = null;

    String strQueryStyle = "";
    String strCondition = "";

    int intQueryStyle = 0;
System.out.println("UIManageReportFacade:2==========");

    try
    {
      strQueryStyle = httpServletRequest.getParameter("QueryStyle");

      if(strQueryStyle==null||strQueryStyle.equals("6"))
        intQueryStyle = 0;
      else
        intQueryStyle = 1;
    }
    catch(NullPointerException npe) //如果QueryStyle为空的话,说明是从查询条件页面链接到结果显示页面,否则是从结果显示页面自身提交过来的
    {
    }

System.out.println("UIManageReportFacade:3==========");
System.out.println("QueryStyle:"+strQueryStyle);
    //1、获得“查询条件”信息
    //2、获得“显示选项”信息
    anaRepCommonDto = manageReportViewHelper.requestToDto(httpServletRequest);
    //根据anaRepCommonDto查询数据库，返回AnaResultDto(rowsCount,collection(HashMap的集合))
    anaResultDto = uiManageReportAction.findByDto(anaRepCommonDto);

    if(intQueryStyle==0)
    {
System.out.println("UIManageReportFacade:4==========");
      //设置AbstractDto的PageCount、RowsCount属性
      AbstractDto abstractDto = null;
      abstractDto = uiCommonFacade.genPage(anaRepCommonDto,anaResultDto.getRowsCount());
      anaRepCommonDto.setAbstractDto(abstractDto);
      //1、将anaResultDto.collection放入httpServletRequest中：Results
      //2、将获得的显示选项界面上的信息放入session中：CollectionSum、CollectionDetail
      //3、将anaRepCommonDto放入httpServletRequest中：AnaRepCommonDto
      //4、将abstractDto放入httpServletRequest中：AbstractDto
      manageReportViewHelper.dtoToRequest(httpServletRequest,anaResultDto.getCollection(),anaRepCommonDto);

System.out.println("UIManageReportFacade:5==========");
      return actionMapping.findForward("success");
    }
    else //生成EXCEL
    {
System.out.println("UIManageReportFacade:6==========");
      ArrayList arrConfigsSum = null;
      Vector vecConfigs = new Vector();

      vecConfigs = (Vector)anaRepCommonDto.getConfigs();
      arrConfigsSum = (ArrayList)vecConfigs.get(1);
      uiCommonFacade.exportExcel((ArrayList)anaResultDto.getCollection(),arrConfigsSum,intQueryStyle,httpServletResponse);

System.out.println("UIManageReportFacade:7==========");
      return null;
    }
  }
}

