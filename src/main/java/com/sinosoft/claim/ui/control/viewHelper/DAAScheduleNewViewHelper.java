package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.claim.ui.control.action.UIScheduleNewAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * <p>Title: ScheduleNewViewHelper</p>
 * <p>Description:理赔节点新案件提示ViewHelper类，在该类中完成页面数据的整理</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 lixiang
 * @version 1.0
 * <br>
 */

 public class DAAScheduleNewViewHelper extends ScheduleNewViewHelper
 {
   /**
    * 默认构造方法
    */
    public DAAScheduleNewViewHelper()
    {
    }

    /**
     * 根据节点种类和操作状态和办理人员编码查询查勘信息
     * @param httpServletRequest 返回给页面的request
     * @param userCode       办理人员编码
     * @throws Exception
     */
    public void getScheduleNewTaskList(HttpServletRequest httpServletRequest,String userCode) throws Exception
    {
      //根据输入的状态，用户ID生成SQL where 子句
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      //引入工作流
      //conditions = "(OperatorCode = '" + userCode + "' or OperatorCode='' ) and ScheduleFlag<>'1' and registno in (select distinct BUSINESSNO from wfLog where nodestatus='0') " ;
      conditions = "(OperatorCode = '" + userCode + "' or OperatorCode='' ) and ScheduleFlag<>'1'and riskcode like '2006/06/12'";

      //modify by lixiang add 20050310 start
      //reason:待调度登记增加调度停留时间排序

      conditions =conditions + " order by operatedate,registno";
      //modify by lixiang add 20050310 end

      //查询理赔节点新案件提示信息,目前没有做相应的调度算法，
      //只根据处理的人员将相应调度任务取出
      //System.out.println(conditions);
      UIScheduleNewAction uiScheduleNewAction = new UIScheduleNewAction();

      //得到多行报案主表信息
      Collection scheduleNewList = new ArrayList();
      Collection scheduleNewChangeList = new ArrayList();
      scheduleNewList  = (Collection)uiScheduleNewAction.findByConditions(conditions) ;
      PrpLscheduleNewDto prpLscheduleNewDto = new PrpLscheduleNewDto();
  //modify by lixiang add 20050316 start
//reason:待调度登记增加调度停留时间
      int afterDay=0;        //等待天计算时间的方式，采取用flowinTime和现在的时间做
      int afterHour=0;       //等待时
      int afterMin=0;        //等待分
      int nowHour=0;         //当前操作时间的小时
      int nowMin=0;          //当前操作时间的分钟
      String timeCount="";   //等待时间的显示
      String operateDate=""; //操作时间
      Iterator it = scheduleNewList.iterator() ;
      while (it.hasNext() )
      {
          timeCount="";
          PrpLscheduleNewDto prpLscheduleNewTempDto = new PrpLscheduleNewDto();
          prpLscheduleNewTempDto = (PrpLscheduleNewDto)it.next() ;
          operateDate=prpLscheduleNewTempDto.getOperateDate() ;
          if (operateDate==null||operateDate.equals("") )
          {
            scheduleNewChangeList.add(prpLscheduleNewTempDto) ;
            continue;
          }
          //DateTime.i
          nowHour=new DateTime(operateDate,DateTime.YEAR_TO_SECOND ).getHour() ;
          nowMin=new DateTime(operateDate,DateTime.YEAR_TO_SECOND ).getMinute() ;
          afterDay=DateTime.intervalDay(new DateTime(operateDate,DateTime.YEAR_TO_DAY),nowHour,new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY) ,DateTime.current().getHour() ) ;
          //我也不知道为什么会多一天。。
          afterDay= afterDay-1;
          //计算小时
          afterHour=DateTime.current().getHour()-nowHour;
           //计算分钟
          afterMin=DateTime.current().getMinute() -nowMin;

         if (afterMin<0)
           {
             afterHour=afterHour-1;
             afterMin=afterMin+60;
           }

          if (afterHour<0)
          {
            afterDay=afterDay-1;
            afterHour=afterHour+24;
          }

          if (afterDay<0) afterDay=0;
          timeCount=afterDay+"天"+afterHour+"小时"+afterMin+"分";
          prpLscheduleNewTempDto.setWaitTime(timeCount) ;
          scheduleNewChangeList.add(prpLscheduleNewTempDto) ;
      }

       prpLscheduleNewDto.setScheduleNewList(scheduleNewChangeList);
     //modify by lixiang add 20050316 end

      System.out.println("finish add list");

      /*
      prpLscheduleNewDto.setEditType((String)httpServletRequest.getAttribute("editType")) ;
      prpLscheduleNewDto.setStatus(status);
      prpLscheduleNewDto.setNodeType(nodeType);
      prpLscheduleNewDto.setHandlerCode(userCode);
      */
      prpLscheduleNewDto.setOperatorCode(userCode);
      //将查询出来的 任务列表放到界面上显示
      httpServletRequest.setAttribute("prpLscheduleNewDto",prpLscheduleNewDto) ;
    }
 }
