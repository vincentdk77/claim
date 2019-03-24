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
 * <p>Description:������һЩͳ�Ƶ������࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public  class WorkFlowStatViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
   public WorkFlowStatViewHelper()
   {//COM.IIDIDispatch
   }
     /*========================���岿�֣�������ͳ�Ʋ���========================*/
        /**
        * ������ͳ��--�ڵ�״̬��ͳ�ƹ������ڵ�״̬�����Ĺ���
        * @param httpServletRequest HttpServletRequest
        * @param strStartDate String
        * @param strEndDate String
        * @throws Exception
        * @return StatStatusDto
        */

       public StatStatusDto getNodeStatusStat(HttpServletRequest httpServletRequest,String strStartDate,String strEndDate)
        throws Exception
    {
        //�������ڼ��
        String endDateLast = new DateTime(strEndDate).addDay(1).toString() ;

        String conditions =" handleTime>='"+strStartDate+"' and handleTime<'"+endDateLast+"' ";
        StatStatusDto statStatusDto = new StatStatusDto();
        UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
        Collection statStatusDtoList = new ArrayList();
        statStatusDtoList = uiWorkFlowAction.getNodeStatusStat(conditions);
        statStatusDto.setStatStatusList(statStatusDtoList);
        statStatusDto.setStartDate(strStartDate);
        statStatusDto.setEndDate(strEndDate);
        //����ѯ�Ľ�����뵽�������
        httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;

        //������״̬���ݲ�ѯ����
        UICodeAction uiCodeAction = new UICodeAction();
        Collection claimStatusList = (ArrayList)uiCodeAction.getCodeType("ClaimStatus", BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
        httpServletRequest.setAttribute("claimStatusList", claimStatusList);

        return statStatusDto;
    }
      /**
       * ������ͳ��--�û��ڵ�״̬��ͳ�ƹ������ڵ��û�״̬�����Ĺ���
       * @param httpServletRequest HttpServletRequest
       * @param strStartDate String
       * @param strEndDate String
       * @throws Exception
       * @return StatStatusDto
       */
      public StatStatusDto getNodeUserStatusStat(HttpServletRequest httpServletRequest,String strStartDate,String strEndDate)
       throws Exception
   {
       //�������ڼ��
       String endDateLast = new DateTime(strEndDate).addDay(1).toString() ;

       String conditions =" handleTime>='"+strStartDate+"' and handleTime<'"+endDateLast+"' ";
       StatStatusDto statStatusDto = new StatStatusDto();
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction ();
       Collection statStatusDtoList = new ArrayList();
       statStatusDtoList = uiWorkFlowAction.getNodeUserStatusStat(conditions);
       statStatusDto.setStatStatusList(statStatusDtoList);
       statStatusDto.setStartDate(strStartDate);
       statStatusDto.setEndDate(strEndDate);
       //����ѯ�Ľ�����뵽�������
       httpServletRequest.setAttribute("statStatusDto",statStatusDto) ;
       return statStatusDto;
   }

     /**
      * ��������ѯ--��ʱ�������鿴����������ѯ��ʱ��������Ϣ
      * @param httpServletRequest HttpServletRequest
      * @param conditions String ��ѯ����
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
        //ת������
          SwfLogDto swfLogDtoTemp = new SwfLogDto();
          swfLogDtoTemp = (SwfLogDto)it.next() ;
        //���㳬ʱ��ʱ�䳤��
        //public static int intervalDay(DateTime startDate, int startHour, DateTime endDate, int endHour) { return 0;}
        count =DateTime.intervalDay(new DateTime(swfLogDtoTemp.getHandleTime(),DateTime.YEAR_TO_DAY ),0,new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ) ,0) -1;
        //-1��Ϊ�˳������ͳ�Ƶĵ���
        swfLogDtoTemp.setTimeLimit(count);
         //ת������
         riskCodeName =  uiCodeAction.translateRiskCode(swfLogDtoTemp.getRiskCode(),true);
         swfLogDtoTemp.setRiskCodeName(riskCodeName);
         nodeStatusName =uiCodeAction.translateCodeCode("ClaimStatus",swfLogDtoTemp.getNodeStatus() ,true);
         swfLogDtoTemp.setNodeStatusName(nodeStatusName);
         nodeTypeName=uiCodeAction.translateCodeCode("ClaimNodeType",swfLogDtoTemp.getNodeType() ,true);
         swfLogDtoTemp.setNodeTypeName(nodeTypeName) ;
         swfLogDtoLastList.add(swfLogDtoTemp);
      }
      swfLogDto.setSwfLogList(swfLogDtoLastList);
      //����ѯ�Ľ�����뵽�������
      httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
      return swfLogDtoLastList;
  }

     /**
     * ���ݽڵ�����Ͳ���״̬�Ͱ�����Ա�����ѯ�鿱��Ϣ
     * @param httpServletRequest ���ظ�ҳ���request
     * @param status         ����״̬
     * @param user           ������Ա/�û�����
     * @param nodeType       �ڵ�����
     * @throws Exception
     */

    public void getWorkFLowNodeStatsStat(HttpServletRequest httpServletRequest,UserDto user,String nodeType) throws Exception
    {
      //���������״̬���û�ID����SQL where �Ӿ�
      String conditions = "";
      String riskType = httpServletRequest.getParameter("type"); //add by liuyanmei 20051110
      //ʵ��������ڵ㲻ͬ
      if (nodeType.equals("compe") )
      { 
      	//modify by liuyanmei modify 20051110 start 
      	//reason :�⽡���������ͳ���������������ֵ���������ͳ��
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
      
      }else{//�����ڵ��ͳ������

      	//modify by wangwei add start 2005-06-12
      	//ԭ�򣺸��ݲ�ͬ�Ĳ�ѯ�����������⽡�պͷ��⽡�յ������ѯ.
      	if (httpServletRequest.getParameter("type") != null && httpServletRequest.getParameter("type").equals("acci")) {

      		//��������Ϊ����ղ�ѯ����
            conditions = conditions + " ((HandlerCode = '" + user.getUserCode()
                           + "') or (handlerCode is Null and nodeStatus='0')or (handlerCode= '' and nodeStatus='0')) AND (NodeType = '"
                           +  nodeType+"') and (flowStatus='1' or flowStatus='2' or "
                           + "(flowStatus='0' and (nodeStatus='4' or nodeStatus='5' ))) "
						   + " and (riskcode like '07%' or riskCode like '06%')" ;
            System.out.println("=============��������Ϊ����ղ�ѯ����" + conditions);
      	} else {

            //��������Ϊ������ղ�ѯ����
      		if(nodeType.equals("verip")){ //�˼�Ҫ��������ѯ������
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
      		
      		System.out.println("=============��������Ϊ������ղ�ѯ����" + conditions);
      	}
        //modify by wangwei add end 2005-06-12
      }
      //��ʼʱ��
      String statStartDate = httpServletRequest.getParameter("statStartDate");

      if(statStartDate != null && statStartDate.trim().length()>0){
        conditions = conditions +" AND HandleTime >= '" + statStartDate +"'";
      }
      //����ʱ��
      String statEndDate = httpServletRequest.getParameter("statEndDate");
      if(statEndDate != null && statEndDate.trim().length()>0){
        conditions = conditions +" AND HandleTime <= '" + statEndDate +"'";
      }
	    
      //��������Ȩ�޿���
      /**UIPrpPersonLimitAction uiPrpPersonLimitAction = new UIPrpPersonLimitAction();
      String conditionRisk = uiPrpPersonLimitAction.findByUsercode(user.getUserCode());
      conditions = conditions + conditionRisk;*/
      
      //ƴȨ��
      //modify by zhaolu 20060816 start
      UIPowerInterface uiPowerInterface = new UIPowerInterface();
      UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
      //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),com.sinosoft.claim.util.BusinessRuleUtil.transTaskCode(nodeType),"swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
      conditions = conditions + uiPowerInterface.addPower(userDto,"swflog","","ComCode");
      //modify by zhaolu 20060816 end 
      //��ѯ����ڵ�״̬��Ϣ
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

      //�õ����б���������Ϣ
      ArrayList claimStatusStatList = new ArrayList();
      ArrayList claimNodeListLast = new ArrayList();
      UICodeAction uiCodeAction = new UICodeAction();
      String statusCode="";
      String statusName="";
      String oldStatus="";
      String nowStatus="";
      System.out.println("����ǰ.");

      claimStatusStatList  = (ArrayList)uiWorkFlowAction.getStatStatus(conditions) ;
      int intRetrun=0;
      System.out.println("������.");
      Iterator it = claimStatusStatList.iterator() ;
      while (it.hasNext())
      {
        StatStatusDto statStatusDtoTemp = new StatStatusDto();
        statStatusDtoTemp = (StatStatusDto)it.next() ;
        statusCode = statStatusDtoTemp.getStatus() ;

        //if (statusCode.equals("0") &&statStatusDtoTemp.getUserCode()!=null) statusCode="1";
        statusName=uiCodeAction.translateCodeCode("ClaimStatus",statusCode,true);
        //��������ͳ���еĲ�����������
        if(statusCode.equals("0")||statusCode.equals("1")){
        statStatusDtoTemp.setStatusName("������");
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
    /*========================��������ͳ�Ʋ���������============================*/

 }
