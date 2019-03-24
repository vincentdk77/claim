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
 * <p>Description:����ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public  class UserClaimStatusViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
   public UserClaimStatusViewHelper()
   {
   }

     /**
     * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param status         ����״̬
     * @param user           ������Ա/�û�����
     * @param nodeType       �ڵ�����
     * @throws Exception
     */

    public void getAllStatsStat(HttpServletRequest httpServletRequest,UserDto user) throws Exception
    {
	  //���������״̬���û�ID����SQL where �Ӿ�
      String conditions = "";
      //ʵ��������ڵ㲻ͬ
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
      //��ѯ����ڵ�״̬��Ϣ
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction(); 
 
      //�õ����б���������Ϣ
      Collection claimStatusStatList = new ArrayList();
      Collection claimNodeListLast = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      String statusCode="";
      String nodestatus="";
      String statusName="";
      String oldStatus="";
      String nowStatus="";
      int wstatus=0,pstatus=0,nosstatus=0,sstatus=0,bstatus=0;
      System.out.println("����ǰ.");

      claimStatusStatList  = (Collection)uiWorkFlowAction.getStatStatus(conditions) ;

      System.out.println("������.");
      Iterator it = claimStatusStatList.iterator() ;
      int i =0;
      while (it.hasNext())
      {
        StatStatusDto statStatusDtoTemp = (StatStatusDto)it.next() ;
        statusCode = statStatusDtoTemp.getStatus() ;

        //if (statusCode.equals("0") &&statStatusDtoTemp.getUserCode()!=null) statusCode="1";
        //0=δ���䣬1��δ����2��������3�����˴���4�����ύ��5���ѻ��ˣ�6���ѳ���
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

