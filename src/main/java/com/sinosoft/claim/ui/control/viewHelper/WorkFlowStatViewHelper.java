package com.sinosoft.claim.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.StatStatusDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * <p>Title: WorkFlwoStatViewHelper</p>c
 * <p>Description:工作流一些统计的整理类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 lixiang
 * @version 1.0
 * <br>
 */

 public  class WorkFlowStatViewHelper
 {
   /**
    * 默认构造方法
    */
   public WorkFlowStatViewHelper()
   {//COM.IIDIDispatch
   }
     /*========================第五部分：工作流统计操作========================*/
        /**
        * 工作流统计--节点状态：统计工作流节点状态数量的功能
        * @param httpServletRequest HttpServletRequest
        * @param strStartDate String
        * @param strEndDate String
        * @throws Exception
        * @return StatStatusDto
        */

       public StatStatusDto getNodeStatusStat(HttpServletRequest httpServletRequest,String strStartDate,String strEndDate)
        throws Exception
    {
        //计算日期间隔
        String endDateLast = new DateTime(strEndDate).addDay(1).toString() ;

        String conditions =" handleTime>='"+strStartDate+"' and handleTime<'"+endDateLast+"' ";
        StatStatusDto statStatusDto = new StatStatusDto();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
        Collection statStatusDtoList = new ArrayList();
        statStatusDtoList = uiWorkFlowAction.getNodeStatusStat(conditions);
        statStatusDto.setStatStatusList(statStatusDtoList);
        statStatusDto.setStartDate(strStartDate);
        statStatusDto.setEndDate(strEndDate);
        //将查询的结果放入到结果集中
        httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;

        //将所有状态数据查询出来
        UICodeAction uiCodeAction = new UICodeAction();
        Collection claimStatusList = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
        httpServletRequest.setAttribute("claimStatusList", claimStatusList);

        return statStatusDto;
    }
      /**
       * 工作流统计--用户节点状态：统计工作流节点用户状态数量的功能
       * @param httpServletRequest HttpServletRequest
       * @param strStartDate String
       * @param strEndDate String
       * @throws Exception
       * @return StatStatusDto
       */
      public StatStatusDto getNodeUserStatusStat(HttpServletRequest httpServletRequest,String strStartDate,String strEndDate)
       throws Exception
   {
       //计算日期间隔
       String endDateLast = new DateTime(strEndDate).addDay(1).toString() ;

       String conditions =" handleTime>='"+strStartDate+"' and handleTime<'"+endDateLast+"' ";
       StatStatusDto statStatusDto = new StatStatusDto();
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
       Collection statStatusDtoList = new ArrayList();
       statStatusDtoList = uiWorkFlowAction.getNodeUserStatusStat(conditions);
       statStatusDto.setStatStatusList(statStatusDtoList);
       statStatusDto.setStartDate(strStartDate);
       statStatusDto.setEndDate(strEndDate);
       //将查询的结果放入到结果集中
       httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;
       return statStatusDto;
   }

     /**
      * 工作流查询--超时工作流查看：按条件查询超时案件的信息
      * @param httpServletRequest HttpServletRequest
      * @param conditions String 查询条件
      * @throws Exception
      * @return Collection
      */

     public Collection getNodeTimeOutInfo(HttpServletRequest httpServletRequest,String conditions)
      throws Exception
  {
      Collection swfLogDtoList = new ArrayList();
      Collection swfLogDtoLastList = new ArrayList();
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      UICodeAction  uiCodeAction = new UICodeAction();

      SwfLogDto swfLogDto = new SwfLogDto();
      swfLogDtoList = uiWorkFlowAction.findNodesByConditions(conditions);
      Iterator it = swfLogDtoList.iterator() ;
      String riskCodeName ="";
      String nodeStatusName ="";
      String nodeTypeName ="";
      int count=0;

      while (it.hasNext() )
      {
        //转换名称
          SwfLogDto swfLogDtoTemp = new SwfLogDto();
          swfLogDtoTemp = (SwfLogDto)it.next() ;
        //计算超时的时间长度
        //public static int intervalDay(DateTime startDate, int startHour, DateTime endDate, int endHour) { return 0;}
        count =DateTime.intervalDay(new DateTime(swfLogDtoTemp.getHandleTime(),DateTime.YEAR_TO_DAY ),0,new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ) ,0) -1;
        //-1是为了出掉最后统计的当天
        swfLogDtoTemp.setTimeLimit(count);
         //转换名称
         riskCodeName =  uiCodeAction.translateRiskCode(swfLogDtoTemp.getRiskCode(),true);
         swfLogDtoTemp.setRiskCodeName(riskCodeName);
         nodeStatusName =uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp.getNodeStatus() ,true);
         swfLogDtoTemp.setNodeStatusName(nodeStatusName);
         nodeTypeName=uiCodeAction.translateCodeCode("ClaimNodeType",swfLogDtoTemp.getNodeType() ,true);
         swfLogDtoTemp.setNodeTypeName(nodeTypeName) ;
         swfLogDtoLastList.add(swfLogDtoTemp);
      }
      swfLogDto.setSwfLogList(swfLogDtoLastList);
      //将查询的结果放入到结果集中
      httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      return swfLogDtoLastList;
  }

     /**
     * 根据节点种类和操作状态和办理人员编码查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param status         操作状态
     * @param user           办理人员/用户对象
     * @param nodeType       节点种类
     * @throws Exception
     */

    public void getWorkFLowNodeStatsStat(HttpServletRequest httpServletRequest,UserDto user,String nodeType) throws Exception
    {
      //根据输入的状态，用户ID生成SQL where 子句
      String conditions = "";
      String riskType = httpServletRequest.getParameter("type"); //add by liuyanmei 20051110
      //实赔和其它节点不同
      if (nodeType.equals("compe") )
      { 
      	//modify by liuyanmei modify 20051110 start 
      	//reason :意健险审核任务统计区分于其他险种的理算任务统计
      	if( nodeType.equals("compe") && (httpServletRequest.getParameter("type") != null && httpServletRequest.getParameter("type").equals("acci")))  {
      	  conditions = conditions
                  + " ((nodeStatus='0' AND NodeType ='compe'"
                  + " and (flowStatus='1' or flowStatus='2') "
                  + " and (riskcode like '07%' or riskCode like '06%'))"
                  + " or (((nodeType='compp'  and  (riskcode like '07%' or riskCode like '06%') "
				  + " and ((flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))"
                  + " or (flowStatus='1' or flowStatus='2'))) and HandlerCode = '" + user.getUserCode()+"'))) " ;	
        }  
        else {  	
          conditions = conditions
                  + " ((nodeStatus='0' AND NodeType ='compe'"
                  + " and (flowStatus='1' or flowStatus='2') "
                  + " and (riskcode not like '07%' and riskCode not like '06%'))"
                  + " or (((nodeType='compp'  and  (riskcode like '07%' or riskCode like '06%') "
				  +" and ((flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))"
                  + " or (flowStatus='1' or flowStatus='2'))) and HandlerCode = '" + user.getUserCode()+"'))) " ;
        }
        //modify by liuyanmei modify 20051110 end	
      
      }else{//其他节点的统计条件

      	//modify by wangwei add start 2005-06-12
      	//原因：根据不同的查询条件，进行意健险和非意健险的区别查询.
      	if (httpServletRequest.getParameter("type") != null && httpServletRequest.getParameter("type").equals("acci")) {

      		//以下条件为意键险查询条件
            conditions = conditions + " ((HandlerCode = '" + user.getUserCode()
                           + "') or (handlerCode is Null and nodeStatus='0')or (handlerCode= '' and nodeStatus='0')) AND (NodeType = '"
                           +  nodeType+"') and (flowStatus='1' or flowStatus='2' or "
                           + "(flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))) "
						   + " and (riskcode like '07%' or riskCode like '06%')" ;
            System.out.println("=============以下条件为意键险查询条件" + conditions);
      	} else {

            //以下条件为非意键险查询条件
      		if(nodeType.equals("verip")){ //核价要包括向外询价任务
      		conditions = conditions + " ((HandlerCode = '" + user.getUserCode()
                           + "') or (handlerCode is Null and nodeStatus='0')or (handlerCode= '' and nodeStatus='0')) AND (NodeType = 'verip'"
                           +  " or NodeType = 'verpo') and (flowStatus='1' or flowStatus='2' or "
                           + "(flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))) "
						   + " and riskcode not like '07%' and riskCode not like '06%'";
      		}else{
          		conditions = conditions + " ((HandlerCode = '" + user.getUserCode()
                + "') or (handlerCode is Null and nodeStatus='0')or (handlerCode= '' and nodeStatus='0')) AND (NodeType = '"
                +  nodeType+"') and (flowStatus='1' or flowStatus='2' or "
                + "(flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))) "
				   + " and riskcode not like '07%' and riskCode not like '06%'";      			
      		}
      		
      		System.out.println("=============以下条件为非意键险查询条件" + conditions);
      	}
        //modify by wangwei add end 2005-06-12
      }
      //起始时间
      String statStartDate = httpServletRequest.getParameter("statStartDate");

      if(statStartDate != null && statStartDate.trim().length()>0){
        conditions = conditions +" AND HandleTime >= '" + statStartDate +"'";
      }
      //结束时间
      String statEndDate = httpServletRequest.getParameter("statEndDate");
      if(statEndDate != null && statEndDate.trim().length()>0){
        conditions = conditions +" AND HandleTime <= '" + statEndDate +"'";
      }
	    
      //增加险种权限控制
      /**UIPrpPersonLimitAction uiPrpPersonLimitAction = new UIPrpPersonLimitAction();
      String conditionRisk = uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
      conditions = conditions + conditionRisk;*/
      
      //拼权限
      //modify by zhaolu 20060816 start
      UIPowerInterface uiPowerInterface = new UIPowerInterface();
      UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),com.sinosoft.claim.util.BusinessRuleUtil.transTaskCode(nodeType),"swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
      //modify by zhaolu 20060816 end 
      //查询理赔节点状态信息
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

      //得到多行报案主表信息
      ArrayList claimStatusStatList = new ArrayList();
      ArrayList claimNodeListLast = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      String statusCode="";
      String statusName="";
      String oldStatus="";
      String nowStatus="";
      System.out.println("搜索前.");

      claimStatusStatList  = (ArrayList)uiWorkFlowAction.getStatStatus(conditions) ;
      int intRetrun=0;
      System.out.println("搜索后.");
      Iterator it = claimStatusStatList.iterator() ;
      while (it.hasNext())
      {
        StatStatusDto statStatusDtoTemp = new StatStatusDto();
        statStatusDtoTemp = (StatStatusDto)it.next() ;
        statusCode = statStatusDtoTemp.getStatus() ;

        //if (statusCode.equals("0") &&statStatusDtoTemp.getUserCode()!=null) statusCode="1";
        statusName=uiCodeAction.translateCodeCode("ClaimStatus",statusCode,true);
        //重新设置统计中的部分数据内容
        if(statusCode.equals("0")||statusCode.equals("1")){
        statStatusDtoTemp.setStatusName("待处理");
        } else {
        statStatusDtoTemp.setStatusName(statusName);
       }
       if(statusCode.equals("3")){intRetrun=statStatusDtoTemp.getCount();
       System.out.println("-------intRetrun---------"+intRetrun);}
        //statStatusDtoTemp.setStatusName(statusName);
        statStatusDtoTemp.setStatus(statusCode);
        statStatusDtoTemp.setUserCode( user.getUserCode());
        statStatusDtoTemp.setUserName( user.getUserName());
        claimNodeListLast.add(statStatusDtoTemp);
      }
      for (int i = 0; i < claimNodeListLast.size(); i++) {
       StatStatusDto  statStatusDtoTemp1 = (StatStatusDto)claimNodeListLast.get(i);
       if(statStatusDtoTemp1.getStatus().equals("0"))statStatusDtoTemp1.setCount(statStatusDtoTemp1.getCount()+intRetrun);
      }
      StatStatusDto statStatusDto = new StatStatusDto();
      statStatusDto.setStatStatusList(claimNodeListLast);
      System.out.println("finish add list");

      statStatusDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      statStatusDto.setNodeType(nodeType);
      statStatusDto.setUserCode(user.getUserCode());
      httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;

      Collection claimStatusList = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", "0000");
      httpServletRequest.setAttribute("claimStatusList", claimStatusList);
      httpServletRequest.setAttribute("riskType", riskType);
    }
    /*========================（工作流统计操作）结束============================*/

 }
