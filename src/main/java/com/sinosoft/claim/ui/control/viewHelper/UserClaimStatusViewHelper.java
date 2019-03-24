package com.sinosoft.claim.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
/**
 * <p>Title: ScheduleViewHelper</p>c
 * <p>Description:调度ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 lixiang
 * @version 1.0
 * <br>
 */

 public  class UserClaimStatusViewHelper
 {
   /**
    * 默认构造方法
    */
   public UserClaimStatusViewHelper()
   {
   }

     /**
     * 根据节点种类和操作状态和办理人员编码查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param status         操作状态
     * @param user           办理人员/用户对象
     * @param nodeType       节点种类
     * @throws Exception
     */

    public void getAllStatsStat(HttpServletRequest httpServletRequest,UserDto user) throws Exception
    {
	  //根据输入的状态，用户ID生成SQL where 子句
      String conditions = "";
      //实赔和其它节点不同
      conditions = conditions + " (HandlerCode = '" + user.getUserCode()
                 + "' or (NVL(handlerCode ,'NULL_VALUE') = 'NULL_VALUE' and nodeStatus = '0') ) and (flowStatus='1' or flowStatus='2' ) " ;
      
      UIPowerInterface uiPowerInterface = new UIPowerInterface();
      UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //modify by zhaolu 20060816 start
      conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
     // conditions = conditions + uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",null);
      //modify by zhaolu 20060816 end
//      conditions = conditions +ExtraConditions(userDto.getUserCode());

System.out.println("lijiyuan"+conditions);
      //查询理赔节点状态信息
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction(); 
 
      //得到多行报案主表信息
      Collection claimStatusStatList = new ArrayList();
      Collection claimNodeListLast = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      String statusCode="";
      String nodestatus="";
      String statusName="";
      String oldStatus="";
      String nowStatus="";
      int wstatus=0,pstatus=0,nosstatus=0,sstatus=0,bstatus=0;
      System.out.println("搜索前.");

      claimStatusStatList  = (Collection)uiWorkFlowAction.getStatStatus(conditions) ;

      System.out.println("搜索后.");
      Iterator it = claimStatusStatList.iterator() ;
      int i =0;
      while (it.hasNext())
      {
        StatStatusDto statStatusDtoTemp = (StatStatusDto)it.next() ;
        statusCode = statStatusDtoTemp.getStatus() ;

        //if (statusCode.equals("0") &&statStatusDtoTemp.getUserCode()!=null) statusCode="1";
        //0=未分配，1＝未处理，2＝正处理，3＝回退处理，4＝已提交，5＝已回退，6＝已撤消
        if (statusCode.equals("0")||statusCode.equals("3")) wstatus=wstatus+statStatusDtoTemp.getCount();
        if (statusCode.equals("2")) pstatus=pstatus+statStatusDtoTemp.getCount();
        if (statusCode.equals("3")) nosstatus=nosstatus+statStatusDtoTemp.getCount();
        if (statusCode.equals("4")) {
          sstatus=sstatus+statStatusDtoTemp.getCount();
        }
        if (statusCode.equals("5")) bstatus=bstatus+statStatusDtoTemp.getCount();
        i++;
      }

        StatStatusDto statStatusDto = new StatStatusDto();
        statStatusDto.setWaitStatusCount(wstatus);
        statStatusDto.setProcStatusCount(pstatus);
        statStatusDto.setNoSubmitStatusCount(nosstatus);
        statStatusDto.setSubmitStatusCount(sstatus);
        statStatusDto.setBackStatusCount(bstatus);

        statStatusDto.setUserCode(user.getUserCode());
 
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("statStatusDto", statStatusDto);
	}
/*	 
    public static String ExtraConditions(String userCode){	 


 	       BusinessRuleUtil   businessRuleUtil  = new BusinessRuleUtil();	  
		   
//		   businessRuleUtil.transNodeType(userCode)



	 }
*/	 
 }

