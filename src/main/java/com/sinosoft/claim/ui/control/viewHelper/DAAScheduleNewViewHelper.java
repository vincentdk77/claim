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
 * <p>Description:����ڵ��°�����ʾViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public class DAAScheduleNewViewHelper extends ScheduleNewViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
    public DAAScheduleNewViewHelper()
    {
    }

    /**
     * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param userCode       ������Ա����
     * @throws Exception
     */
    public void getScheduleNewTaskList(HttpServletRequest httpServletRequest,String userCode) throws Exception
    {
      //���������״̬���û�ID����SQL where �Ӿ�
      userCode = StringUtils.rightTrim(userCode) ;

      String conditions = "";
      //���빤����
      //conditions = "(OperatorCode = '" + userCode + "' or OperatorCode='' ) and ScheduleFlag<>'1' and registno in (select distinct BUSINESSNO from wfLog where nodestatus='0') " ;
      conditions = "(OperatorCode = '" + userCode + "' or OperatorCode='' ) and ScheduleFlag<>'1'and riskcode like '2006/06/12'";

      //modify by lixiang add 20050310 start
      //reason:�����ȵǼ����ӵ���ͣ��ʱ������

      conditions =conditions + " order by operatedate,registno";
      //modify by lixiang add 20050310 end

      //��ѯ����ڵ��°�����ʾ��Ϣ,Ŀǰû������Ӧ�ĵ����㷨��
      //ֻ���ݴ������Ա����Ӧ��������ȡ��
      //System.out.println(conditions);
      UIScheduleNewAction uiScheduleNewAction = new UIScheduleNewAction();

      //�õ����б���������Ϣ
      Collection scheduleNewList = new ArrayList();
      Collection scheduleNewChangeList = new ArrayList();
      scheduleNewList  = (Collection)uiScheduleNewAction.findByConditions(conditions) ;
      PrpLscheduleNewDto prpLscheduleNewDto = new PrpLscheduleNewDto();
  //modify by lixiang add 20050316 start
//reason:�����ȵǼ����ӵ���ͣ��ʱ��
      int afterDay=0;        //�ȴ������ʱ��ķ�ʽ����ȡ��flowinTime�����ڵ�ʱ����
      int afterHour=0;       //�ȴ�ʱ
      int afterMin=0;        //�ȴ���
      int nowHour=0;         //��ǰ����ʱ���Сʱ
      int nowMin=0;          //��ǰ����ʱ��ķ���
      String timeCount="";   //�ȴ�ʱ�����ʾ
      String operateDate=""; //����ʱ��
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
          //��Ҳ��֪��Ϊʲô���һ�졣��
          afterDay= afterDay-1;
          //����Сʱ
          afterHour=DateTime.current().getHour()-nowHour;
           //�������
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
          timeCount=afterDay+"��"+afterHour+"Сʱ"+afterMin+"��";
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
      //����ѯ������ �����б�ŵ���������ʾ
      httpServletRequest.setAttribute("prpLscheduleNewDto",prpLscheduleNewDto) ;
    }
 }
