package com.sinosoft.claim.ui.control.facade;
/**与配置界面相对应的facade类
 * <p>Title: UIReportConfigFacade</p>
 * <p>Description:新产品统计分析系统程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * <p>@createdate 2004/07/30</p>
 * @author zhangshengli
 * @version 1.0
 */
import java.util.Collection;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.action.UIResultConfigAction;

public class UIReportConfigFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
         throws Exception
  {
System.out.println("UIReportConfigFacade_1==========");
    UIResultConfigAction uiResultConfigAction = new UIResultConfigAction();

    HttpSession session = httpServletRequest.getSession();
    Vector vecConfigs = new Vector();
    Vector vecShowConfigs = new Vector();

	
    Collection collectionSum = null;
    Collection collectionShow = null;	
    Collection collectionDetail = null;

    String strQueryFlag = httpServletRequest.getParameter("QueryFlag");
    String strConfigOwner = httpServletRequest.getParameter("ConfigOwner");
    String strResultType = httpServletRequest.getParameter("ResultType");
    String strResultTypeDetail = httpServletRequest.getParameter("ResultTypeDetail");
    String strLogonUser = httpServletRequest.getParameter("LogonUser");

    String strCondition = "";
    String strConditionSum = "";
    String strConditionDetail = "";
    String strResult = "";
    String strConditionDcode = "";
System.out.println("UIReportConfigFacade_2:QueryFlag=========="+strQueryFlag);
System.out.println("UIReportConfigFacade_3:ResultType=========="+strResultType);

    strCondition = " ConfigOwner='"+strConfigOwner+"'";
    strCondition += " AND ShowStatus='1'";

      //放入汇总查询结果显示项（查询MidResultConfig得到的数据）
      strConditionSum = strCondition+" AND ResultType='"+strResultType+"'  order by itemno";
System.out.println(strConditionSum);	  
      collectionSum = uiResultConfigAction.findByConditions(strConditionSum);

System.out.println("**************************11");	  
      if(collectionSum!=null)
      {
System.out.println("**************************22");	  
        vecConfigs.add("Sum");
        vecConfigs.add(collectionSum);
       }
/*
    //放入明细查询结果显示项（查询MidResultConfig得到的数据）
    if(strResultTypeDetail!=null&&strResultTypeDetail.length()>0)
    {
      strConditionDetail = strCondition+" AND ResultType='"+strResultTypeDetail+"'";
      collectionDetail = uiResultConfigAction.findByConditions(strConditionDetail);
      if(collectionDetail!=null)
      {
        vecConfigs.add("Detail");
        vecConfigs.add(collectionDetail);
      }
System.out.println("**************************11test");	  	  
    }
*/
    //将查询MidResultConfig得到的数据放入session中
    session.setAttribute("Configs",vecConfigs);

/*
    if(strQueryFlag.equals("uwqry"))
      strResult = "uwqry";
    else if(strQueryFlag.equals("sxfqry"))
      strResult = "sxfqry";
    else if(strQueryFlag.equals("unpayrpt"))
      strResult = "unpayrpt";
    else if(strQueryFlag.equals("cerloss"))
      strResult = "cerlossrpt";
    else if(strQueryFlag.equals("check"))
      strResult = "checkrpt";
    else if(strQueryFlag.equals("regist"))
      strResult = "registrpt";
    else if(strQueryFlag.equals("registf"))
      strResult = "registrpt";
*/
      strResult = "success";

System.out.println("UIReportConfigFacade_4:Result=========="+strResult);
    return actionMapping.findForward(strResult);
  }
}

