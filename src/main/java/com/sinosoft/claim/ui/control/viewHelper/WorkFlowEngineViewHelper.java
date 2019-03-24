package com.sinosoft.claim.ui.control.viewHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>Title: ScheduleViewHelper</p>c
 * <p>Description:����������ViewHelper�࣬�ڸ��������ҳ�����ݵ�����</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� lixiang
 * @version 1.0
 * <br>
 */

 public  class WorkFlowEngineViewHelper
 {
   /**
    * Ĭ�Ϲ��췽��
    */
   public WorkFlowEngineViewHelper()
   {//COM.IIDIDispatch
   }
   /*========================��һ���֣�������������/�������========================*/

   /**
    * ��������������������,�˺����������й�������ת��������ڣ�
    * ��֪���������������ת�ģ��������������ɡ�
    * @param user UserDto �û�dto
    * @param swfLogFunctionInDto ������
    * @throws Exception
    * @return WorkFlowDto �����������ݴ������ݽṹ
    */
   public WorkFlowDto viewToDto(UserDto user,SwfLogDto swfLogFunctionInDto) throws Exception
    {
      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
      WorkFlowDto workFlowDto = new WorkFlowDto();
      WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
      SwfLogDto   swfLogDto   = null;
      SwfLogDto   swfLogDtoTemp   = null;
      Collection  swfFlowNodeList  = new ArrayList();
      ArrayList   submitLogList  = new ArrayList();
      ArrayList   submitPathLogList  = new ArrayList();
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
          
      String swfLogFlowID=swfLogFunctionInDto.getFlowID(); //���̺���
      int swfLogLogNo=swfLogFunctionInDto.getLogNo();      //�����еĽڵ����
      //һ�����������Ǳ����
      String nodeStatus=swfLogFunctionInDto.getNodeStatus();  //���������� 2,4,5,3Ŀǰֻ���⼸�� 
      String nextBusinessNo = swfLogFunctionInDto.getNextBusinessNo() ;
      String keyIn =swfLogFunctionInDto.getKeyIn() ;
      
     
      String keyOut=swfLogFunctionInDto.getKeyOut() ;
      
     //--------------------�����������õĲ���--------------------//
      boolean createWorkFlow=swfLogFunctionInDto.getCreateFlow() ; //True ��������������
      String riskCode = swfLogFunctionInDto.getRiskCode() ;
      String comCode =swfLogFunctionInDto.getComCode() ;
      String policyNo = swfLogFunctionInDto.getPolicyNo() ;
     //--------------------�����������õĲ���--------------------//
      
      String businessNo = swfLogFunctionInDto.getBusinessNo()  ;//ֻ�е�flowidû��ʱ������
      String nodeType=swfLogFunctionInDto.getNodeType() ;     //���ΪT���ͻ���û��flowidʱ����
      
      String conditionBusinessNo = swfLogFunctionInDto.getConditionBusinessNo();
      String typeFlag = swfLogFunctionInDto.getTypeFlag() ;
      String handlerRange=swfLogFunctionInDto.getHandlerRange(); //��һ�ڵ���Ա��������
      String exigenceGree=swfLogFunctionInDto.getExigenceGree(); //��һ�ڵ�����̶ȼ���
      

      //��������õ����Ϸ�������ֻ��Ҫ��ѯ�������ڵ��е����ݾͿ�����
      int logMaxNo=0;  //���ȡLogNo�ŵ�����
      int pathMaxNo=0; //���ȡpathNo�ŵ�����

    //1.������������/����������Ϣ
    if (createWorkFlow) {
      workFlowDto = createFlowInfo(user, businessNo,comCode, riskCode,policyNo,swfLogFunctionInDto.getInsuredName(),swfLogFunctionInDto.getLossItemName());
      if (workFlowDto.getOperateResult() <0)
      {
        //û��ȡ��ģ��ĺ���
        return workFlowDto;
      }

      //���õ�ǰ�ڵ������
      swfLogDto = workFlowDto.getCreateSwfLogDto();
      logMaxNo = 2;
      pathMaxNo = 1;
    }
    else { //��ѯ������������/���ҵ�ǰ�ڵ�
      if (!swfLogFlowID.equals("")&& swfLogLogNo>0){  //��������flowid,LogNo�鹤���ڵ�
      swfFlowNodeList = uiWorkFlowAction.findCurrentNode(swfLogFlowID, swfLogLogNo);
      }else
      {//��������businessNo, nodeType�鹤���ڵ�
      swfFlowNodeList = uiWorkFlowAction.findCurrentNode(businessNo, nodeType);
      }
      if (swfFlowNodeList.iterator().hasNext()) {
        //��õ�ǰ�������̵���Ϣ
        swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
        //��ȡ�ù������ϵ�ͱߵ�������
        logMaxNo = uiWorkFlowAction.getSwfLogMaxLogNo(swfLogDto.getFlowID());
        pathMaxNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(swfLogDto.getFlowID());

      }
    }
    //�������ж��Ƿ���Բ���
    if (swfLogDto != null) { //�й������̲�ѯ����
    //Ҫ�жϹ��������Ƿ��������������ˣ�����Ķ�����Ҫ������
    if (uiWorkFlowAction.checkFlowClose(swfLogDto.getFlowID() ))
      {
          //�������Ѿ��ر���
          workFlowDto.setCheckClose(true);
          return workFlowDto;
       }
    //�ж��ǲ���Ҫ���������������Ժ���ͬ��M��������Ĵ��� M�����󣬺�������������һ����
    //���㻷��ע��/������Ҫ����
    
      if (swfLogDto.getTaskType().equals("M")&&!nodeStatus.equals("5")) {
          if("compe".equals(swfLogFunctionInDto.getNodeType())&&swfLogFunctionInDto.getSwfLogList() != null && swfLogFunctionInDto.getSwfLogList().size() > 0){
             //����ע�����ⲻ��Ҫ����������ڵ� 
          }else{
        //�������������
        swfLogDto.setBusinessNo(nextBusinessNo);
       
        swfLogDto.setKeyIn(businessNo);
        workFlowDtoTemp = getSubmitFlowInfo(user, swfLogDto, keyIn, logMaxNo,
                                            pathMaxNo);
        logMaxNo=logMaxNo+1;
        pathMaxNo=pathMaxNo+1;

        workFlowDto.setSubmit(true);
        workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
        workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
        //���ô�����������Ϊ��ǰ����Ҫ���������ڵ�
        swfFlowNodeList.clear();
        swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();

        if (swfFlowNodeList.iterator().hasNext()) {
          swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
          swfLogDto.setHandlerCode(user.getUserCode());
          swfLogDto.setHandlerName(user.getUserName());
          //M���ͳ������ӽڵ�ֱ������keyOut,�����Ƿ��ύ
          swfLogDto.setKeyOut(keyOut);
 
        }
          }
      }
       //����Ĳ�������ΪT�������͵Ľڵ�
       if (swfLogFunctionInDto.getTaskType().equals("T")) {
         //�����½ڵ�
         //ΪT���͵Ľڵ��������������ͨ·������������־�жϵ�ʱ����������ڲ���־����ʾT���ͣ�����AddNewNode��ͬ��T
        swfLogDto.setTaskType("AddNewNode");
        workFlowDtoTemp = getSubmitFlowInfo(user, swfLogDto, keyIn, logMaxNo,
                                            pathMaxNo);
        
        System.out.println("��ѯ�ύ������"+swfLogDto.getLogNo()  );
        if (workFlowDtoTemp.getSubmitSwfLogDtoList()==null)
        {//���������û�нڵ�ġ�����ֱ���׳�
          return workFlowDto;
        }
        
        //��Ϊ�ڵ�����ˣ�����������
        logMaxNo=logMaxNo+1;
        pathMaxNo=pathMaxNo+1;
        workFlowDto.setSubmit(true);
        workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
        workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
        //���ô�����������Ϊ��ǰ����Ҫ���������ڵ�
        swfFlowNodeList.clear();
        swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();

        if (swfFlowNodeList.iterator().hasNext()) {
          swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
          swfLogDto.setHandlerCode(user.getUserCode());
          swfLogDto.setHandlerName(user.getUserName());

          swfLogDto.setTypeFlag(typeFlag);//��Ϊ�ؿ���Ҫ��
          //T���ͳ������ӽڵ�ֱ������keyOut,�����Ƿ��ύ
          swfLogDto.setKeyOut(keyOut);
        }
       }
       //���ж��ύ������������ύ���Ǿ͸�Ϊ�������

      //2.�޸Ĺ�����0/1/2/3�����޸Ĺ�����
      if (nodeStatus.equals("0") || nodeStatus.equals("1") ||
          nodeStatus.equals("2") || nodeStatus.equals("3")) {
        //�޸Ĺ�����
        swfLogDto.setNodeStatus(nodeStatus);
        swfLogDto.setHandlerCode(user.getUserCode());
        swfLogDto.setHandlerName(user.getUserName());
        swfLogDto.setKeyOut(keyOut);
        swfLogDto.setLossItemCode(swfLogFunctionInDto.getLossItemCode());
        //modify by weishixin modify 20050227 start
        //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
        swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
        //modify by weishixin modify 20050227 end
        if (typeFlag!=null&&typeFlag.length()>0)
        {
        swfLogDto.setTypeFlag(typeFlag);
        }
        //�����M���͵Ľӵ㣬����Ҫ����update���//�Ż�������
        if (workFlowDto.getSubmit()) {
          ArrayList submitLogMList = new ArrayList();
          submitLogMList.add(swfLogDto);
          workFlowDto.setSubmitSwfLogDtoList(submitLogMList);
      }
        else {
          //�жϵ�ǰ��Ϣ���Ƿ��й������Ĵ��ڡ���
          if (swfLogDto.getLogNo() > 0) {
            workFlowDto.setUpdate(true);
            workFlowDto.setUpdateSwfLogDto(swfLogDto);
          }

        }
      }
      
      //3���ύ������
      if (nodeStatus.equals("4")) {
      	
        //�ж��Ƿ���Ҫ��Ϊ�Ľ���,��Ϊ����ֻҪ���ô���Ĳ���Ϊendflag=1�����ˡ�
        if (swfLogFunctionInDto.getEndFlag().equals("1") )
        {
        swfLogDto.setEndFlag("1");
        }
        //�ж��Ƿ�����ڵ����ύ���������ҳ�����Ѿ������ж���
        //WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper ();
        //workFlowViewHelper.checkNodeSubmit(swfLogDto);
       
        //�޸Ĺ�����nodeStatus=4
        swfLogDto.setNodeStatus(nodeStatus);
        swfLogDto.setKeyOut(keyOut);  //
        //add by lym for :������������ֻ��һ��������ʱֻ����ҵ����������
        //�Ӷ�����������֧��ʱ����������Ҫȡ��Ӧ��ǿ�������ŵ�ǿ�Ʊ��������Բ����ö���ʱ�ı�����
        if(swfLogFunctionInDto!=null&& swfLogFunctionInDto.getPolicyNo()!=null &&!swfLogFunctionInDto.getPolicyNo().equals("")){
        	swfLogDto.setPolicyNo(swfLogFunctionInDto.getPolicyNo());
        }
        //add by lym for end---------------------------------------------
        //�����ύ��ʱ��
        //modify by weishixin modify 20050227 start
        //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
        swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()) ;
        //modify by weishixin modify 20050227 end
        //����Ҫ��������
        swfLogDto.setConditionBusinessNo(conditionBusinessNo);
        //�����Ƿ���typeFlag
        if ((typeFlag!=null) && (typeFlag.length()>0))
        {
          swfLogDto.setTypeFlag(typeFlag) ;
        }
        
        //�������ύ�Ĳ���
        workFlowDtoTemp = submitWorkFlow(user, swfLogDto, swfLogFunctionInDto,
                                          logMaxNo,
                                          pathMaxNo);
        workFlowDto.setUpdate(workFlowDtoTemp.getUpdate());
        workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto());
        workFlowDto.setUpdateSwfLog2Dto(workFlowDtoTemp.getUpdateSwfLog2Dto());
        
        submitLogList = workFlowDtoTemp.getSubmitSwfLogDtoList();
        if (submitLogList==null) submitLogList = new ArrayList(); //���ǵ���ʱ���ύ�����ǿյ�,�����
        submitPathLogList = workFlowDtoTemp.getSubmitSwfPathLogDtoList();
        if (submitPathLogList==null) submitPathLogList = new ArrayList(); //���ǵ���ʱ���ύ�����ǿյ�,�����
        //ԭ���������ӵ����ݣ���Ҫ�ϲ��Ľڵ��·�����������Ż���ǰ�����M��T�����γɵ��½ڵ㡣
        if (workFlowDto.getSubmit()) {
          Iterator it = workFlowDto.getSubmitSwfLogDtoList().iterator();
          while (it.hasNext()) {
            submitLogList.add(it.next());
          }

          Iterator it1 = workFlowDto.getSubmitSwfPathLogDtoList().iterator();
          while (it1.hasNext()) {
            submitPathLogList.add(it1.next());
          }

          //����Ѿ����ύ��������
        }
        
        workFlowDto.setSubmit(workFlowDtoTemp.getSubmit());
        workFlowDto.setSubmitSwfLogDtoList(submitLogList);
        workFlowDto.setSubmitSwfPathLogDtoList(submitPathLogList);
        workFlowDto.setClose(workFlowDtoTemp.getClose());
        workFlowDto.setCloseSwfFlowMainDto(workFlowDtoTemp.getCloseSwfFlowMainDto());

        workFlowDto.setStatus(workFlowDtoTemp.getStatus());
      } //�ж����ύ�����Ľ���
      //�Ż�������
      if (workFlowDto.getCreate() && workFlowDto.getUpdate()) {
        //�´����Ĺ�����ֱ�Ӵ������Ͳ�����udpateһ����
        workFlowDto.setCreateSwfLogDto(workFlowDto.getUpdateSwfLogDto());
        workFlowDto.setUpdate(false);
      }
      
      //�Ż������������������ʱ��ͬʱ�����˹رղ�������رյ�����ʱһ���ǿյģ�����
      if (workFlowDto.getCreate() && workFlowDto.getClose()) {
        //�´����Ĺ�����ֱ�Ӵ������ر�ҲҪ����������
        SwfFlowMainDto swfFlowMainDto = workFlowDto.getCreateSwfFlowMainDto();
        swfFlowMainDto.setFlowStatus("0");
		workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto );
      
      }

      //4�����˹�����
      if (nodeStatus.equals("5")) {
        //Ŀǰֻ�к��𡢶�����õõ������������ﶨ�𣬲�����Ա���ϸ��ڵ��ϵ���Ա
        //���Ȳ��Ҷ���Ľڵ㣬�ӻ��˵Ľڵ��ϲ�ѯ����Ϊ����Ľڵ㣬��������ΪtypeFlag��ͬ�Ľڵ�
        //�ɺ���ǰ���в�ѯ����Ŀǰֻ�к��𡢺˼ۺ����˺���������
//lijiyuan add 2005-11-4
        if (swfLogDto.getNodeType().equals("verip") || swfLogDto.getNodeType().equals("verif") || swfLogDto.getNodeType().equals("veriw") ||
		swfLogDto.getNodeType().equals("propv")||swfLogDto.getNodeType().equals("compe")) //������˻�,������˻�
        {
            workFlowDto=backWorkFlow(user,swfLogDto.getFlowID() ,swfLogDto.getLogNo(),swfLogFunctionInDto);
        }else
        {
            throw new UserException(1,3,"������","û�з��ֿ��Ի��˵Ĺ������ڵ�");
        }
     }
   }
 return workFlowDto;
}
   
   
	   public WorkFlowDto viewToDtoMedical(UserDto user,SwfLogDto swfLogFunctionInDto) throws Exception
	   {
	     //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
	     WorkFlowDto workFlowDto = new WorkFlowDto();
	     WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
	     SwfLogDto   swfLogDto   = null;
	     SwfLogDto   swfLogDtoTemp   = null;
	     Collection  swfFlowNodeList  = new ArrayList();
	     ArrayList   submitLogList  = new ArrayList();
	     ArrayList   submitPathLogList  = new ArrayList();
	     UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
	         
	     String swfLogFlowID=swfLogFunctionInDto.getFlowID(); //���̺���
	     int swfLogLogNo=swfLogFunctionInDto.getLogNo();      //�����еĽڵ����
	     //һ�����������Ǳ����
	     String nodeStatus=swfLogFunctionInDto.getNodeStatus();  //���������� 2,4,5,3Ŀǰֻ���⼸�� 
	     String nextBusinessNo = swfLogFunctionInDto.getNextBusinessNo() ;
	     String keyIn =swfLogFunctionInDto.getKeyIn() ;
	     
	    
	     String keyOut=swfLogFunctionInDto.getKeyOut() ;
	     
	    //--------------------�����������õĲ���--------------------//
	     boolean createWorkFlow=swfLogFunctionInDto.getCreateFlow() ; //True ��������������
	     String riskCode = swfLogFunctionInDto.getRiskCode() ;
	     String comCode =swfLogFunctionInDto.getComCode() ;
	     String policyNo = swfLogFunctionInDto.getPolicyNo() ;
	    //--------------------�����������õĲ���--------------------//
	     
	     String businessNo = swfLogFunctionInDto.getBusinessNo()  ;//ֻ�е�flowidû��ʱ������
	     String nodeType=swfLogFunctionInDto.getNodeType() ;     //���ΪT���ͻ���û��flowidʱ����
	     
	     String conditionBusinessNo = swfLogFunctionInDto.getConditionBusinessNo();
	     String typeFlag = swfLogFunctionInDto.getTypeFlag() ;
	     String handlerRange=swfLogFunctionInDto.getHandlerRange(); //��һ�ڵ���Ա��������
	     String exigenceGree=swfLogFunctionInDto.getExigenceGree(); //��һ�ڵ�����̶ȼ���
	     
	
	     //��������õ����Ϸ�������ֻ��Ҫ��ѯ�������ڵ��е����ݾͿ�����
	     int logMaxNo=0;  //���ȡLogNo�ŵ�����
	     int pathMaxNo=0; //���ȡpathNo�ŵ�����
	
	   //1.������������/����������Ϣ
	   if (createWorkFlow) {
	     workFlowDto = createFlowInfo(user, businessNo,comCode, riskCode,policyNo,swfLogFunctionInDto.getInsuredName(),swfLogFunctionInDto.getLossItemName());
	     if (workFlowDto.getOperateResult() <0)
	     {
	       //û��ȡ��ģ��ĺ���
	       return workFlowDto;
	     }
	
	     //���õ�ǰ�ڵ������
	     swfLogDto = workFlowDto.getCreateSwfLogDto();
	     logMaxNo = 2;
	     pathMaxNo = 1;
	   }
	   else { //��ѯ������������/���ҵ�ǰ�ڵ�
	     if (!swfLogFlowID.equals("")&& swfLogLogNo>0){  //��������flowid,LogNo�鹤���ڵ�
	     swfFlowNodeList = uiWorkFlowAction.findCurrentNode(swfLogFlowID, swfLogLogNo);
	     }else
	     {//��������businessNo, nodeType�鹤���ڵ�
	     swfFlowNodeList = uiWorkFlowAction.findCurrentNode(businessNo, nodeType);
	     }
	     if (swfFlowNodeList.iterator().hasNext()) {
	       //��õ�ǰ�������̵���Ϣ
	       swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	       //��ȡ�ù������ϵ�ͱߵ�������
	       logMaxNo = uiWorkFlowAction.getSwfLogMaxLogNo(swfLogDto.getFlowID());
	       pathMaxNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(swfLogDto.getFlowID());
	
	     }
	   }
	   //�������ж��Ƿ���Բ���
	   if (swfLogDto != null) { //�й������̲�ѯ����
	   //Ҫ�жϹ��������Ƿ��������������ˣ�����Ķ�����Ҫ������
	   if (uiWorkFlowAction.checkFlowClose(swfLogDto.getFlowID() ))
	     {
	         //�������Ѿ��ر���
	         workFlowDto.setCheckClose(true);
	         return workFlowDto;
	      }
	   //�ж��ǲ���Ҫ���������������Ժ���ͬ��M��������Ĵ��� M�����󣬺�������������һ����
	   //���㻷��ע��/������Ҫ����
	   
	     if (swfLogDto.getTaskType().equals("M")&&!nodeStatus.equals("5")) {
	         if("compe".equals(swfLogFunctionInDto.getNodeType())&&swfLogFunctionInDto.getSwfLogList() != null && swfLogFunctionInDto.getSwfLogList().size() > 0){
	            //����ע�����ⲻ��Ҫ����������ڵ� 
	         }else{
	       //�������������
	       swfLogDto.setBusinessNo(nextBusinessNo);
	      
	       swfLogDto.setKeyIn(businessNo);
	       workFlowDtoTemp = getSubmitFlowInfoMedical(user, swfLogDto, keyIn, logMaxNo,
	                                           pathMaxNo);
	       logMaxNo=logMaxNo+1;
	       pathMaxNo=pathMaxNo+1;
	
	       workFlowDto.setSubmit(true);
	       workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
	       workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
	       //���ô�����������Ϊ��ǰ����Ҫ���������ڵ�
	       swfFlowNodeList.clear();
	       swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();
	
	       if (swfFlowNodeList.iterator().hasNext()) {
	         swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	         swfLogDto.setHandlerCode(user.getUserCode());
	         swfLogDto.setHandlerName(user.getUserName());
	         //M���ͳ������ӽڵ�ֱ������keyOut,�����Ƿ��ύ
	         swfLogDto.setKeyOut(keyOut);
	
	       }
	         }
	     }
	      //����Ĳ�������ΪT�������͵Ľڵ�
	      if (swfLogFunctionInDto.getTaskType().equals("T")) {
	        //�����½ڵ�
	        //ΪT���͵Ľڵ��������������ͨ·������������־�жϵ�ʱ����������ڲ���־����ʾT���ͣ�����AddNewNode��ͬ��T
	       swfLogDto.setTaskType("AddNewNode");
	       workFlowDtoTemp = getSubmitFlowInfoMedical(user, swfLogDto, keyIn, logMaxNo,
	                                           pathMaxNo);
	       
	       System.out.println("��ѯ�ύ������"+swfLogDto.getLogNo()  );
	       if (workFlowDtoTemp.getSubmitSwfLogDtoList()==null)
	       {//���������û�нڵ�ġ�����ֱ���׳�
	         return workFlowDto;
	       }
	       
	       //��Ϊ�ڵ�����ˣ�����������
	       logMaxNo=logMaxNo+1;
	       pathMaxNo=pathMaxNo+1;
	       workFlowDto.setSubmit(true);
	       workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
	       workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
	       //���ô�����������Ϊ��ǰ����Ҫ���������ڵ�
	       swfFlowNodeList.clear();
	       swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();
	
	       if (swfFlowNodeList.iterator().hasNext()) {
	         swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	         swfLogDto.setHandlerCode(user.getUserCode());
	         swfLogDto.setHandlerName(user.getUserName());
	
	         swfLogDto.setTypeFlag(typeFlag);//��Ϊ�ؿ���Ҫ��
	         //T���ͳ������ӽڵ�ֱ������keyOut,�����Ƿ��ύ
	         swfLogDto.setKeyOut(keyOut);
	       }
	      }
	      //���ж��ύ������������ύ���Ǿ͸�Ϊ�������
	
	     //2.�޸Ĺ�����0/1/2/3�����޸Ĺ�����
	     if (nodeStatus.equals("0") || nodeStatus.equals("1") ||
	         nodeStatus.equals("2") || nodeStatus.equals("3")) {
	       //�޸Ĺ�����
	       swfLogDto.setNodeStatus(nodeStatus);
	       swfLogDto.setHandlerCode(user.getUserCode());
	       swfLogDto.setHandlerName(user.getUserName());
	       swfLogDto.setKeyOut(keyOut);
	       swfLogDto.setLossItemCode(swfLogFunctionInDto.getLossItemCode());
	       //modify by weishixin modify 20050227 start
	       //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
	       swfLogDto.setHandleTime(new DateTime(swfLogFunctionInDto.getHandleTime(),DateTime.YEAR_TO_SECOND ).toString());
	       //modify by weishixin modify 20050227 end
	       if (typeFlag!=null&&typeFlag.length()>0)
	       {
	       swfLogDto.setTypeFlag(typeFlag);
	       }
	       //�����M���͵Ľӵ㣬����Ҫ����update���//�Ż�������
	       if (workFlowDto.getSubmit()) {
	         ArrayList submitLogMList = new ArrayList();
	         submitLogMList.add(swfLogDto);
	         workFlowDto.setSubmitSwfLogDtoList(submitLogMList);
	     }
	       else {
	         //�жϵ�ǰ��Ϣ���Ƿ��й������Ĵ��ڡ���
	         if (swfLogDto.getLogNo() > 0) {
	           workFlowDto.setUpdate(true);
	           workFlowDto.setUpdateSwfLogDto(swfLogDto);
	         }
	
	       }
	     }
	     
	     //3���ύ������
	     if (nodeStatus.equals("4")) {
	     	
	       //�ж��Ƿ���Ҫ��Ϊ�Ľ���,��Ϊ����ֻҪ���ô���Ĳ���Ϊendflag=1�����ˡ�
	       if (swfLogFunctionInDto.getEndFlag().equals("1") )
	       {
	       swfLogDto.setEndFlag("1");
	       }
	       //�ж��Ƿ�����ڵ����ύ���������ҳ�����Ѿ������ж���
	       //WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper ();
	       //workFlowViewHelper.checkNodeSubmit(swfLogDto);
	      
	       //�޸Ĺ�����nodeStatus=4
	       swfLogDto.setNodeStatus(nodeStatus);
	       swfLogDto.setKeyOut(keyOut);  //
	       //add by lym for :������������ֻ��һ��������ʱֻ����ҵ����������
	       //�Ӷ�����������֧��ʱ����������Ҫȡ��Ӧ��ǿ�������ŵ�ǿ�Ʊ��������Բ����ö���ʱ�ı�����
	       if(swfLogFunctionInDto!=null&& swfLogFunctionInDto.getPolicyNo()!=null &&!swfLogFunctionInDto.getPolicyNo().equals("")){
	       	swfLogDto.setPolicyNo(swfLogFunctionInDto.getPolicyNo());
	       }
	       //add by lym for end---------------------------------------------
	       //�����ύ��ʱ��
	       //modify by weishixin modify 20050227 start
	       //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
	       swfLogDto.setSubmitTime(new DateTime(swfLogFunctionInDto.getSubmitTime(),DateTime.YEAR_TO_SECOND ).toString()) ;
	       //modify by weishixin modify 20050227 end
	       //����Ҫ��������
	       swfLogDto.setConditionBusinessNo(conditionBusinessNo);
	       //�����Ƿ���typeFlag
	       if ((typeFlag!=null) && (typeFlag.length()>0))
	       {
	         swfLogDto.setTypeFlag(typeFlag) ;
	       }
	       
	       //�������ύ�Ĳ���
	       workFlowDtoTemp = submitWorkFlowMedical(user, swfLogDto, swfLogFunctionInDto,
	                                         logMaxNo,
	                                         pathMaxNo);
	       workFlowDto.setUpdate(workFlowDtoTemp.getUpdate());
	       workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto());
	       workFlowDto.setUpdateSwfLog2Dto(workFlowDtoTemp.getUpdateSwfLog2Dto());
	       
	       submitLogList = workFlowDtoTemp.getSubmitSwfLogDtoList();
	       if (submitLogList==null) submitLogList = new ArrayList(); //���ǵ���ʱ���ύ�����ǿյ�,�����
	       submitPathLogList = workFlowDtoTemp.getSubmitSwfPathLogDtoList();
	       if (submitPathLogList==null) submitPathLogList = new ArrayList(); //���ǵ���ʱ���ύ�����ǿյ�,�����
	       //ԭ���������ӵ����ݣ���Ҫ�ϲ��Ľڵ��·�����������Ż���ǰ�����M��T�����γɵ��½ڵ㡣
	       if (workFlowDto.getSubmit()) {
	         Iterator it = workFlowDto.getSubmitSwfLogDtoList().iterator();
	         while (it.hasNext()) {
	           submitLogList.add(it.next());
	         }
	
	         Iterator it1 = workFlowDto.getSubmitSwfPathLogDtoList().iterator();
	         while (it1.hasNext()) {
	           submitPathLogList.add(it1.next());
	         }
	
	         //����Ѿ����ύ��������
	       }
	       
	       workFlowDto.setSubmit(workFlowDtoTemp.getSubmit());
	       workFlowDto.setSubmitSwfLogDtoList(submitLogList);
	       workFlowDto.setSubmitSwfPathLogDtoList(submitPathLogList);
	       workFlowDto.setClose(workFlowDtoTemp.getClose());
	       workFlowDto.setCloseSwfFlowMainDto(workFlowDtoTemp.getCloseSwfFlowMainDto());
	
	       workFlowDto.setStatus(workFlowDtoTemp.getStatus());
	     } //�ж����ύ�����Ľ���
	     //�Ż�������
	     if (workFlowDto.getCreate() && workFlowDto.getUpdate()) {
	       //�´����Ĺ�����ֱ�Ӵ������Ͳ�����udpateһ����
	       workFlowDto.setCreateSwfLogDto(workFlowDto.getUpdateSwfLogDto());
	       workFlowDto.setUpdate(false);
	     }
	     
	     //�Ż������������������ʱ��ͬʱ�����˹رղ�������رյ�����ʱһ���ǿյģ�����
	     if (workFlowDto.getCreate() && workFlowDto.getClose()) {
	       //�´����Ĺ�����ֱ�Ӵ������ر�ҲҪ����������
	       SwfFlowMainDto swfFlowMainDto = workFlowDto.getCreateSwfFlowMainDto();
	       swfFlowMainDto.setFlowStatus("0");
			workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto );
	     
	     }
	
	     //4�����˹�����
	     if (nodeStatus.equals("5")) {
	       //Ŀǰֻ�к��𡢶�����õõ������������ﶨ�𣬲�����Ա���ϸ��ڵ��ϵ���Ա
	       //���Ȳ��Ҷ���Ľڵ㣬�ӻ��˵Ľڵ��ϲ�ѯ����Ϊ����Ľڵ㣬��������ΪtypeFlag��ͬ�Ľڵ�
	       //�ɺ���ǰ���в�ѯ����Ŀǰֻ�к��𡢺˼ۺ����˺���������
	//lijiyuan add 2005-11-4
	       if (swfLogDto.getNodeType().equals("verip") || swfLogDto.getNodeType().equals("verif") || swfLogDto.getNodeType().equals("veriw") ||
			swfLogDto.getNodeType().equals("propv")||swfLogDto.getNodeType().equals("compe")) //������˻�,������˻�
	       {
	           workFlowDto=backWorkFlow(user,swfLogDto.getFlowID() ,swfLogDto.getLogNo(),swfLogFunctionInDto);
	       }else
	       {
	           throw new UserException(1,3,"������","û�з��ֿ��Ի��˵Ĺ������ڵ�");
	       }
	    }
	  }
	return workFlowDto;
	}
   
   
   
   /**
    *  ����һ���µĹ���������
    * @param user UserDto      ��¼�û���Ϣ
    * @param BusinessNo String ҵ����룬��Ҫ������Ǳ����ڵ㿪ʼ�ģ���ô�Ǳ�������
    * @param comCode String    ��ǰ�Ĺ��������Ĵ���
    * @param RiskCode String   ��ǰ������
    * @throws Exception
    * @return WorkFlowDto
    */
   protected WorkFlowDto createFlowInfo(UserDto user,String BusinessNo,String comCode,String RiskCode,String policyNo,String insuredName,String lossItemName)
        throws Exception
    {
      //1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      WorkFlowDto workFlowDto = new WorkFlowDto();
      int year = DateTime.current().getYear() ;
      String strTitle="������������";
      String tableName = "swfflowmain";
      UIBillAction uiBillAction = new UIBillAction();
      //Ĭ�ϴ����������ǳ�����DAA��
      if (RiskCode.equals("") )
      {
        UICodeAction uiCodeAction = new UICodeAction(); 
      RiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
      }
      /*---2.ȡ������������-*/
      String flowID = uiBillAction.getNo(tableName, RiskCode, comCode, year);
      //String flowID="200000000010305000015"; 
      /*---3.ȡ��������ģ���,��swfmodeluse��ȡ����ӳ��ģ�����õĺ���*/
      int modelNo= uiWorkFlowAction.getModelNo(RiskCode,comCode);
     //���û��ȡ�ù��������룬��ô�򷵻�һ���յ����ݼ��ϣ�֪ͨ���øú����ĳ���
      //add by lixiang start at 2006-1-20 
      //reason:���Ҳ��������ģ��ʱ��������ʾ������Ҫ��Ȼ��������
      
      if (modelNo< 0)
      { 
      	throw new UserException(1,3,"������","û�з�������Ϊ'"+RiskCode+"'������Ϊ'"+comCode+"'�����õ�����ģ�壬��͹���Ա��ϵ��");
      }
      /*4.д---------------------����������wfFlowMain------------------------------------*/
      SwfFlowMainDto swfFlowMainDto = new SwfFlowMainDto();
      swfFlowMainDto.setFlowID(flowID);
      swfFlowMainDto.setFlowName(BusinessNo);
      swfFlowMainDto.setFlowStatus("1");
      swfFlowMainDto.setPolicyNo(policyNo);
      swfFlowMainDto.setCreatDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY));
      swfFlowMainDto.setModelNo(modelNo);
      swfFlowMainDto.setFlag("");

      workFlowDto.setCreateSwfFlowMainDto(swfFlowMainDto);

      /*5.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/
      //�������е�ģ���һ���ڵ�ĺ������1
      int nodeNo = 1;
      SwfNodeDto swfNodeDto = new SwfNodeDto();
      swfNodeDto = uiWorkFlowAction.findModelNodeByPrimaryKey(modelNo, nodeNo);

      /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
      SwfLogDto swfLogDto = new SwfLogDto();
      swfLogDto.setFlowID(flowID);
      swfLogDto.setLogNo(1);
      swfLogDto.setModelNo(modelNo);
      swfLogDto.setNodeNo(nodeNo);
      swfLogDto.setNodeName(swfNodeDto.getNodeName() );
      swfLogDto.setBusinessNo(BusinessNo);
      swfLogDto.setHandleDept(user.getComCode() );
      swfLogDto.setHandlerCode(user.getUserCode() );
      swfLogDto.setHandlerName(user.getUserName() );
      
//    ������Ĳ�ѯ���������ӱ����ţ��������ˣ����ƺ�(��������Ҫ���)
      swfLogDto.setInsuredName(insuredName);
      swfLogDto.setLossItemName(lossItemName);
      swfLogDto.setRegistNo(BusinessNo );
      //swfLogDto.setFlowInTime	  ();
      //modify by weishixin modify 20050227 start
      //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
      swfLogDto.setTimeLimit(swfNodeDto.getTimeLimit() );
      swfLogDto.setHandleTime(new DateTime(DateTime.current(),
                                           DateTime.YEAR_TO_SECOND).toString());
      //modify by weishixin modify 20050227 end
      //swfLogDto.setSubmitTime    ();
      swfLogDto.setNodeStatus("1");
      swfLogDto.setFlowStatus("1");
      swfLogDto.setPackageID("0");
      swfLogDto.setFlag(swfNodeDto.getFlag() );
      swfLogDto.setTaskNo(swfNodeDto.getTaskNo());
      swfLogDto.setTaskType(swfNodeDto.getTaskType() );
      swfLogDto.setNodeType(swfNodeDto.getNodeType() );
      swfLogDto.setTitleStr(strTitle);
      //swfLogDto.setBusinessType   (businessType);
      swfLogDto.setRiskCode(RiskCode);
      swfLogDto.setKeyIn(BusinessNo);
      swfLogDto.setKeyOut("");
      swfLogDto.setDeptName(user.getComName() );
      swfLogDto.setSubFlowID("0");
      swfLogDto.setMainFlowID("0");
      swfLogDto.setPosX(0);
      swfLogDto.setPosY	(0);
      swfLogDto.setEndFlag(swfNodeDto.getEndFlag() );
      //modify by weishixin modify 20050227 start
      //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
      swfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
      //modify by weishixin modify 20050227 end
      swfLogDto.setPolicyNo(policyNo);
      swfLogDto.setComCode(comCode );
      //�ӵ�Dto��
      workFlowDto.setCreateSwfLogDto(swfLogDto);
      workFlowDto.setCreate(true);
      //�����������Ĺ��� ���������ݣ�ֻд���ݵ�workFlowDto��
      return workFlowDto;
    }

    /**
        *�ύ������
         * @param httpServletRequest HttpServletRequest
         * @param SwfLogDto ��ǰ����ڵ�
         * @param KeyIN   �����ҵ�����
         * @param KeyOut  �����ҵ�����
         * @throws Exception
         * @return WorkFlowDto
         */
    protected WorkFlowDto getSubmitFlowInfo(UserDto user,SwfLogDto swfLogFunctionInDto,String KeyIn,int logNo, int pathNo)
         throws Exception
     {
       //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
       //1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       WorkFlowDto workFlowDto = new WorkFlowDto();
       //2.ȡ����������
       String flowID = swfLogFunctionInDto.getFlowID() ;
       /*---3.ȡ��������ģ���*/
       int modelNo= swfLogFunctionInDto.getModelNo() ;
       int nodeNo = swfLogFunctionInDto.getNodeNo() ;
       String TNodeType= swfLogFunctionInDto.getNodeType() ; //�����Tָ���¸��ڵ�Ļ�����ô����
       //��������Ϊ�ع��ʱ�������Ϊ��־B,�����жϺ�ֱ�Ӱ�ֵ�ָ���"S"
       if (swfLogFunctionInDto.getTaskType().equals("B"))
       {
          nodeNo=swfLogFunctionInDto.getTaskNo() ;
          swfLogFunctionInDto.setTaskType("S");
       }
       /*4.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/

       Collection wfNodeDtoList = new ArrayList();  //ģ��Ľڵ�
       ArrayList wfLogDtoList = new ArrayList();    //�������Ҫ�²���Ĺ������̽ڵ�
       ArrayList wfPathLogDtoList = new ArrayList();//�������Ҫ�²���Ĺ������̱�

       //����Ƕ�����Ľڵ㣬ֻ���ϵ������������
       if (swfLogFunctionInDto.getTaskType().equals("M"))
       { 
         int nextNodeNo = swfLogFunctionInDto.getTaskNo();
         SwfNodeDto wfNodeDto = new SwfNodeDto(); 
         wfNodeDto=uiWorkFlowAction.findModelNodeByPrimaryKey(modelNo,nextNodeNo);
         if (wfNodeDto!=null) wfNodeDtoList.add(wfNodeDto);

         //���M�����������Ľڵ�����ύ���أ����������أ�
       }//AddNewNode=T,C��T���ͽڵ�������ڲ���ʾ
       else if (swfLogFunctionInDto.getTaskType().equals("AddNewNode")  )
       {
             	wfNodeDtoList = uiWorkFlowAction.findModelNextTNodes(modelNo,nodeNo);
        }else
       {
         //��ѯ�˽ڵ������еĽڵ���Ϣ�������ڵ�taskType =S ������ڵ㣩
         //Ŀǰû��ȷ��ִ�б�������ҵ�����ʲô������swfLogFunctionInDto.getConditionBusinessNo(),�ӽڵ��ϴ�����
         wfNodeDtoList = uiWorkFlowAction.findModelNextNodes(modelNo, nodeNo,swfLogFunctionInDto.getConditionBusinessNo() );
       }
      /*5.-----------------�����¸��������ڵ�д�������̵ĵ���ߵ�����----------------*/

       if (wfNodeDtoList.iterator() .hasNext() )
       {
         Iterator it = wfNodeDtoList.iterator();
         //��ȡwflog����flowID������logno�Ŀ�ʼֵ
         //int logNo = uiWorkFlowAction.getSwfLogMaxLogNo(flowID);
         //int pathNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);

         while (it.hasNext()) {

           SwfNodeDto wfNodeDto = new SwfNodeDto();
           wfNodeDto = (SwfNodeDto) it.next();
           //�ж���û�д����ָ����typeflag,��Ҫ��swflog�ġ�
           if (swfLogFunctionInDto.getTypeFlag().length() >0 ) wfNodeDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag());

           /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
           SwfLogDto wfLogDtoTemp = new SwfLogDto();
           //����wfLogDtoTemp

          //�ж��Ƿ��ڵ�ǰ�������У��Ѿ��б�����ɸýڵ�Ĵ��ڣ�����״̬Ϊ0,û�д���������ڵ㣬����Ǻ���ʵ���أ���Ϊ�������ύ��
          //����У��Ͳ����ٲ������ݿ���
           Collection wfLogHasSaveList = new ArrayList();
           //�طò���Ҫ����ǲ������ظ��Ľڵ�
           if (!wfNodeDto.getNodeType().equals("backv")&&!wfNodeDto.getNodeType().equals("compp")&&!wfNodeDto.getNodeType().equals("veric")&&!wfNodeDto.getNodeType().equals("verif")){
           wfLogHasSaveList =  uiWorkFlowAction.findNoDealNodeByModelNodeNo(flowID,wfNodeDto.getNodeNo(),wfNodeDto.getNodeType() );
           }
           
           //add by lixiang start at 2006-6-6
           //����ǿ���ļ��룬��Ҫ����һ�£�����᰸�ǰ����������᰸�ģ���ô��Ҫ�������
           //�������������riskcode�����ֽ᰸��Ȼ������ͬ�Ľ᰸������
           if (wfNodeDto.getNodeType().equals("endca")){
           	  ArrayList wfLogHasSaveListTemp =(ArrayList)wfLogHasSaveList;
           	  wfLogHasSaveList = new ArrayList();
           	
           	//ֻҪ�ж��Ѿ������Ľ᰸������ riskcode=�����riskCode�����ݣ�����Բ����µĽ᰸
            	for (int i =0;i<wfLogHasSaveListTemp.size() ;i++){
           		  String riskCode = ((SwfLogDto)wfLogHasSaveListTemp.get(i)).getRiskCode();
           		 
           		 if ( swfLogFunctionInDto.getRiskCode().equals( riskCode) ){
           		
           			  wfLogHasSaveList.add( (SwfLogDto)wfLogHasSaveListTemp.get(i));
           			   break;
           	    	 }
             	}
          }
           //add by lixiang end at 2006-6-6
          
           if(wfLogHasSaveList.iterator().hasNext())
              {
               
                //������ۺϵ�ʱ�򣬲����˴����Ķ���ڵ������
                wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.iterator().next();
                //����������������ݣ�����Ҫ����wflog��ֻҪ��wfPathlog��������Ӧ�ı߾Ϳ�����
                /*7.---------------------д�����߱�wfPathLog-----------------------------*/
              }
             else
            {
             	wfNodeDto.setInsureCarFlag(swfLogFunctionInDto.getInsureCarFlag() );
             	wfNodeDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree());
             	getSwfLogDtoInfoBySwfNode(wfLogDtoTemp,wfNodeDto,user,flowID,modelNo,logNo,"0",KeyIn,swfLogFunctionInDto);
                //����Ĭ��ֵ
                wfLogDtoTemp.setLossItemCode(swfLogFunctionInDto.getLossItemCode());
                wfLogDtoTemp.setLossItemName(swfLogFunctionInDto.getLossItemName());
                wfLogDtoTemp.setTypeFlag(swfLogFunctionInDto.getTypeFlag());
                //�ڵ��ϵĸ�����Ϣ ��ǰԤ����,�Ժ�Ҳ���������ģ�ֻ�������¸��ڵ������õ�
                //Ĭ��Ϊ���ڵ����ݵĸ������ݣ���������ⲿ�������µ�ֵ�������µ�Ϊ׼
               
                wfLogDtoList.add(wfLogDtoTemp);
                logNo++;
             }
           /*7.---------------------д�����߱�wfPathLog---------------------------------*/

           SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
           getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
           wfPathLogDtoList.add(swfPathLogDto);
           pathNo++;
         }
          workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
          workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
          workFlowDto.setSubmit(true);
       }
       else
       {
           //����ǵ�����ڵ㣬���Ǻ����Ѿ�û�нڵ��ˣ���ѯ�ǲ���M�ĺ����ڵ㣬����ǣ�������taskNo>0����
       if (swfLogFunctionInDto.getTaskType().equals("S")&& swfLogFunctionInDto.getTaskNo()>1)
         {
         //�ع����ߣ�Ϊ�˷�ֹ�ظ��ݹ飬��������Ϊֻ������һ��,���ҹ�ϵֻ����һ��,��ʵ�����޸������е�����
         //swfLogFunctionInDto.setNodeNo(swfLogFunctionInDto.getTaskNo());
         //���ٴεݹ���ñ����ʱ��Ӹ���־λ���ڴ��жϵ�ʱ�򣬻���û�S
         swfLogFunctionInDto.setTaskType("B");
         //swfLogFunctionInDto.setTaskNo(0);
         //swfLogFunctionInDto.setBusinessNo(swfLogFunctionInDto.getBusinessNo() );
         swfLogFunctionInDto.setNextBusinessNo(swfLogFunctionInDto.getNextBusinessNo() );
         swfLogFunctionInDto.setKeyOut(swfLogFunctionInDto.getKeyOut());
         swfLogFunctionInDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
         //�ع����ߵ�bussnessno
              workFlowDto = getSubmitFlowInfo(user,swfLogFunctionInDto,KeyIn,logNo,pathNo);
         }
         else
         {
         //������������������ô������ û����������������Ҳû���κ���һ���ڵ�ļ�¼����Ҫ��ʾ����Ա�������޷�������ȥ
         workFlowDto.setStatus("9"); //�����쳣
         }

       }
       return workFlowDto;
    }
    
    
    
    /**
     *�ύ������
      * @param httpServletRequest HttpServletRequest
      * @param SwfLogDto ��ǰ����ڵ�
      * @param KeyIN   �����ҵ�����
      * @param KeyOut  �����ҵ�����
      * @throws Exception
      * @return WorkFlowDto
      */
 protected WorkFlowDto getSubmitFlowInfoMedical(UserDto user,SwfLogDto swfLogFunctionInDto,String KeyIn,int logNo, int pathNo)
      throws Exception
  {
    //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
    //1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
    UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
    WorkFlowDto workFlowDto = new WorkFlowDto();
    //2.ȡ����������
    String flowID = swfLogFunctionInDto.getFlowID() ;
    /*---3.ȡ��������ģ���*/
    int modelNo= swfLogFunctionInDto.getModelNo() ;
    int nodeNo = swfLogFunctionInDto.getNodeNo() ;
    String TNodeType= swfLogFunctionInDto.getNodeType() ; //�����Tָ���¸��ڵ�Ļ�����ô����
    //��������Ϊ�ع��ʱ�������Ϊ��־B,�����жϺ�ֱ�Ӱ�ֵ�ָ���"S"
    if (swfLogFunctionInDto.getTaskType().equals("B"))
    {
       nodeNo=swfLogFunctionInDto.getTaskNo() ;
       swfLogFunctionInDto.setTaskType("S");
    }
    /*4.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/

    Collection wfNodeDtoList = new ArrayList();  //ģ��Ľڵ�
    ArrayList wfLogDtoList = new ArrayList();    //�������Ҫ�²���Ĺ������̽ڵ�
    ArrayList wfPathLogDtoList = new ArrayList();//�������Ҫ�²���Ĺ������̱�

    //����Ƕ�����Ľڵ㣬ֻ���ϵ������������
    if (swfLogFunctionInDto.getTaskType().equals("M"))
    { 
      int nextNodeNo = swfLogFunctionInDto.getTaskNo();
      SwfNodeDto wfNodeDto = new SwfNodeDto(); 
      wfNodeDto=uiWorkFlowAction.findModelNodeByPrimaryKey(modelNo,nextNodeNo);
      if (wfNodeDto!=null) wfNodeDtoList.add(wfNodeDto);

      //���M�����������Ľڵ�����ύ���أ����������أ�
    }//AddNewNode=T,C��T���ͽڵ�������ڲ���ʾ
    else if (swfLogFunctionInDto.getTaskType().equals("AddNewNode")  )
    {
          	wfNodeDtoList = uiWorkFlowAction.findModelNextTNodes(modelNo,nodeNo);
     }else
    {
      //��ѯ�˽ڵ������еĽڵ���Ϣ�������ڵ�taskType =S ������ڵ㣩
      //Ŀǰû��ȷ��ִ�б�������ҵ�����ʲô������swfLogFunctionInDto.getConditionBusinessNo(),�ӽڵ��ϴ�����
      wfNodeDtoList = uiWorkFlowAction.findModelNextNodes(modelNo, nodeNo,swfLogFunctionInDto.getConditionBusinessNo() );
    }
   /*5.-----------------�����¸��������ڵ�д�������̵ĵ���ߵ�����----------------*/

    if (wfNodeDtoList.iterator() .hasNext() )
    {
      Iterator it = wfNodeDtoList.iterator();
      //��ȡwflog����flowID������logno�Ŀ�ʼֵ
      //int logNo = uiWorkFlowAction.getSwfLogMaxLogNo(flowID);
      //int pathNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);

      while (it.hasNext()) {

        SwfNodeDto wfNodeDto = new SwfNodeDto();
        wfNodeDto = (SwfNodeDto) it.next();
        //�ж���û�д����ָ����typeflag,��Ҫ��swflog�ġ�
        if (swfLogFunctionInDto.getTypeFlag().length() >0 ) wfNodeDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag());

        /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
        SwfLogDto wfLogDtoTemp = new SwfLogDto();
        //����wfLogDtoTemp

       //�ж��Ƿ��ڵ�ǰ�������У��Ѿ��б�����ɸýڵ�Ĵ��ڣ�����״̬Ϊ0,û�д���������ڵ㣬����Ǻ���ʵ���أ���Ϊ�������ύ��
       //����У��Ͳ����ٲ������ݿ���
        Collection wfLogHasSaveList = new ArrayList();
        //�طò���Ҫ����ǲ������ظ��Ľڵ�
        if (!wfNodeDto.getNodeType().equals("backv")&&!wfNodeDto.getNodeType().equals("compp")&&!wfNodeDto.getNodeType().equals("veric")&&!wfNodeDto.getNodeType().equals("verif")){
        wfLogHasSaveList =  uiWorkFlowAction.findNoDealNodeByModelNodeNo(flowID,wfNodeDto.getNodeNo(),wfNodeDto.getNodeType() );
        }
        
        //add by lixiang start at 2006-6-6
        //����ǿ���ļ��룬��Ҫ����һ�£�����᰸�ǰ����������᰸�ģ���ô��Ҫ�������
        //�������������riskcode�����ֽ᰸��Ȼ������ͬ�Ľ᰸������
        if (wfNodeDto.getNodeType().equals("endca")){
        	  ArrayList wfLogHasSaveListTemp =(ArrayList)wfLogHasSaveList;
        	  wfLogHasSaveList = new ArrayList();
        	
        	//ֻҪ�ж��Ѿ������Ľ᰸������ riskcode=�����riskCode�����ݣ�����Բ����µĽ᰸
         	for (int i =0;i<wfLogHasSaveListTemp.size() ;i++){
        		  String riskCode = ((SwfLogDto)wfLogHasSaveListTemp.get(i)).getRiskCode();
        		 
        		 if ( swfLogFunctionInDto.getRiskCode().equals( riskCode) ){
        		
        			  wfLogHasSaveList.add( (SwfLogDto)wfLogHasSaveListTemp.get(i));
        			   break;
        	    	 }
          	}
       }
        //add by lixiang end at 2006-6-6
       
        if(wfLogHasSaveList.iterator().hasNext())
           {
            
             //������ۺϵ�ʱ�򣬲����˴����Ķ���ڵ������
             wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.iterator().next();
             //����������������ݣ�����Ҫ����wflog��ֻҪ��wfPathlog��������Ӧ�ı߾Ϳ�����
             /*7.---------------------д�����߱�wfPathLog-----------------------------*/
           }
          else
         {
          	wfNodeDto.setInsureCarFlag(swfLogFunctionInDto.getInsureCarFlag() );
          	wfNodeDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree());
          	getSwfLogDtoInfoBySwfNodeMedical(wfLogDtoTemp,wfNodeDto,user,flowID,modelNo,logNo,"0",KeyIn,swfLogFunctionInDto);
             //����Ĭ��ֵ
             wfLogDtoTemp.setLossItemCode(swfLogFunctionInDto.getLossItemCode());
             wfLogDtoTemp.setLossItemName(swfLogFunctionInDto.getLossItemName());
             wfLogDtoTemp.setTypeFlag(swfLogFunctionInDto.getTypeFlag());
             //�ڵ��ϵĸ�����Ϣ ��ǰԤ����,�Ժ�Ҳ���������ģ�ֻ�������¸��ڵ������õ�
             //Ĭ��Ϊ���ڵ����ݵĸ������ݣ���������ⲿ�������µ�ֵ�������µ�Ϊ׼
            
             wfLogDtoList.add(wfLogDtoTemp);
             logNo++;
          }
        /*7.---------------------д�����߱�wfPathLog---------------------------------*/

        SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
        getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
        wfPathLogDtoList.add(swfPathLogDto);
        pathNo++;
      }
       workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
       workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
       workFlowDto.setSubmit(true);
    }
    else
    {
        //����ǵ�����ڵ㣬���Ǻ����Ѿ�û�нڵ��ˣ���ѯ�ǲ���M�ĺ����ڵ㣬����ǣ�������taskNo>0����
    if (swfLogFunctionInDto.getTaskType().equals("S")&& swfLogFunctionInDto.getTaskNo()>1)
      {
      //�ع����ߣ�Ϊ�˷�ֹ�ظ��ݹ飬��������Ϊֻ������һ��,���ҹ�ϵֻ����һ��,��ʵ�����޸������е�����
      //swfLogFunctionInDto.setNodeNo(swfLogFunctionInDto.getTaskNo());
      //���ٴεݹ���ñ����ʱ��Ӹ���־λ���ڴ��жϵ�ʱ�򣬻���û�S
      swfLogFunctionInDto.setTaskType("B");
      //swfLogFunctionInDto.setTaskNo(0);
      //swfLogFunctionInDto.setBusinessNo(swfLogFunctionInDto.getBusinessNo() );
      swfLogFunctionInDto.setNextBusinessNo(swfLogFunctionInDto.getNextBusinessNo() );
      swfLogFunctionInDto.setKeyOut(swfLogFunctionInDto.getKeyOut());
      swfLogFunctionInDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
      //�ع����ߵ�bussnessno
           workFlowDto = getSubmitFlowInfoMedical(user,swfLogFunctionInDto,KeyIn,logNo,pathNo);
      }
      else
      {
      //������������������ô������ û����������������Ҳû���κ���һ���ڵ�ļ�¼����Ҫ��ʾ����Ա�������޷�������ȥ
      workFlowDto.setStatus("9"); //�����쳣
      }

    }
    return workFlowDto;
 }

        /**
         * �ύ������(�˵��˵�)��
         * @param user UserDto
         * @param swfLogFunctionInDto SwfLogDto //���ڵ����Ϣ
         * @param swfLogFunctionInOldDto SwfLogDto//��������Ĳ���
         * @param logNo int
         * @param pathNo int
         * @throws Exception
         * @return WorkFlowDto
         */
        protected WorkFlowDto getSubmitFlowInfo(UserDto user,SwfLogDto swfLogFunctionInDto,SwfLogDto swfLogFunctionInOldDto,int logNo, int pathNo)
         throws Exception
     {
       //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
       //1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
       UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
       WorkFlowDto workFlowDto = new WorkFlowDto();
       //2.ȡ����������
       String flowID = swfLogFunctionInDto.getFlowID() ;
       /*---3.ȡ��������ģ���*/
       int modelNo= swfLogFunctionInDto.getModelNo() ;
       /*4.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/

       Collection wfNodeDtoList = new ArrayList();  //ģ��Ľڵ�
       ArrayList wfLogDtoList = new ArrayList();    //�������Ҫ�²���Ĺ������̽ڵ�
       ArrayList wfPathLogDtoList = new ArrayList();//�������Ҫ�²���Ĺ������̱�
       Collection swfNodeNextList = new ArrayList();//��Ŵӽ��洫��������Ҫ�͵Ķ���ڵ�

       swfNodeNextList = swfLogFunctionInOldDto.getSwfLogList() ;
       //��ѯ�ڵ����ϸ����
       //��һ���ڵ㶨�������
       Iterator itn = swfNodeNextList.iterator() ;
       int nextNodeNo = 0;
       String nodeType="";
       while (itn.hasNext() )
       {
         //swfLogNext ��һ���ڵ�ӽ��洫���Ķ���
          SwfLogDto swfLogNext = (SwfLogDto)itn.next() ;
          nextNodeNo = swfLogNext.getNodeNo() ;
          nodeType=swfLogNext.getNodeType() ;
          //�쳣�жϣ����nextNodeNo=0 ˵��û�ҵ���,��Ŀǰֻ���ǲ���������¸��ڵ��ˡ��Ժ�����
          //Ŀǰ��������nodeType���д������ݵ�
          //��facadeֻ���ڵ����ͽ��빤�����оͿ��Եġ�
           SwfNodeDto swfNodeDto = new SwfNodeDto();
          if ((nextNodeNo==0)&&(!nodeType.equals("")))
          {
              swfNodeDto=getFirstNodeTypeNode(modelNo,nodeType);
          }else
          {
              if (nextNodeNo==0) continue;
              swfNodeDto=uiWorkFlowAction.findModelNodeByPrimaryKey(modelNo,nextNodeNo);
          }
          if (swfNodeDto!=null) //������ȷ��ѯ����һ���ڵ��ϵ���Ϣ.
       {
           if (swfLogNext.getHandlerCode().length()>0)
           {
              swfNodeDto.setHandlerCode(swfLogNext.getHandlerCode() );
              swfNodeDto.setHandlerName(swfLogNext.getHandlerName() );
           }
          //�ڵ��ϵĸ�����Ϣ ��ǰԤ����,�Ժ�Ҳ���������ģ�ֻ�������¸��ڵ������õ�
          //Ĭ��Ϊ���ڵ����ݵĸ������ݣ���������ⲿ�������µ�ֵ�������µ�Ϊ׼
          swfNodeDto.setScheduleID(swfLogFunctionInDto.getScheduleID() );
          swfNodeDto.setLossItemCode(swfLogFunctionInDto.getLossItemCode() );
          swfNodeDto.setLossItemName(swfLogFunctionInDto.getLossItemName() );
          swfNodeDto.setInsureCarFlag(swfLogFunctionInDto.getInsureCarFlag() ) ;
          swfNodeDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag() ) ;
          swfNodeDto.setHandlerRange(swfLogFunctionInDto.getHandlerRange() ) ;
          swfNodeDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree() ) ;
          swfNodeDto.setHandleDept(swfLogFunctionInDto.getNewHandleDept() );
          swfNodeDto.setDeptName(swfLogFunctionInDto.getNewDeptName() );
            

          if (swfLogNext.getScheduleID()>0) swfNodeDto.setScheduleID(swfLogNext.getScheduleID() );
          if (!swfLogNext.getLossItemCode().equals("")) swfNodeDto.setLossItemCode(swfLogNext.getLossItemCode() );
          if (!swfLogNext.getLossItemName().equals("")) swfNodeDto.setLossItemName(swfLogNext.getLossItemName() );
          if (!swfLogNext.getInsureCarFlag().equals("")) swfNodeDto.setInsureCarFlag(swfLogNext.getInsureCarFlag() ) ;
          if (!swfLogNext.getTypeFlag().equals("")) swfNodeDto.setTypeFlag(swfLogNext.getTypeFlag() ) ;
          if (!swfLogNext.getHandlerRange().equals("")) swfNodeDto.setHandlerRange(swfLogNext.getHandlerRange() ) ;
          if (!swfLogNext.getExigenceGree().equals("")) swfNodeDto.setExigenceGree(swfLogNext.getExigenceGree() ) ;
          if (!swfLogNext.getNewHandleDept ().equals("")) swfNodeDto.setHandleDept (swfLogNext.getNewHandleDept ()) ;
          if (!swfLogNext.getNewDeptName ().equals("")) swfNodeDto.setDeptName (swfLogNext.getNewDeptName ()) ;
          //add by lixiang start 2006-6-4 
          //reason : ����ǿ������֧�������ǰ��ղ�ͬ�ı�������
          if (swfNodeDto.getNodeType().equals( "claim")||swfNodeDto.getNodeType().equals( "compe")||swfNodeDto.getNodeType().equals( "cance")){
             if (!swfLogNext.getPolicyNo ().equals("")) swfNodeDto.setPolicyNo (swfLogNext.getPolicyNo ()) ;
             if (!swfLogNext.getRiskCode ().equals("")) swfNodeDto.setRiskCode(swfLogNext.getRiskCode ()) ;
             if (!swfLogNext.getKeyIn().equals(""))   swfNodeDto.setKeyIn  (swfLogNext.getKeyIn() );
             if (!swfLogNext.getBusinessNo().equals(""))   swfNodeDto.setBusinessNo  (swfLogNext.getBusinessNo() );
           
          }
//        add by lixiang end 2006-6-4 
          wfNodeDtoList.add(swfNodeDto);
         }
       }
      /*5.-----------------�����¸��������ڵ�д�������̵ĵ���ߵ�����----------------*/

       if (wfNodeDtoList.iterator() .hasNext() )
       {
         Iterator it = wfNodeDtoList.iterator();
         while (it.hasNext()) {
           SwfNodeDto wfNodeDto = new SwfNodeDto();
           wfNodeDto = (SwfNodeDto) it.next();

           /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
           SwfLogDto wfLogDtoTemp = new SwfLogDto();
           //����wfLogDtoTemp

          //�ж��Ƿ��ڵ�ǰ�������У��Ѿ��б�����ɸýڵ�Ĵ��ڣ�����״̬Ϊ0,û�д���������ڵ㣬����Ǻ���ʵ���أ���Ϊ�������ύ��
          //����У��Ͳ����ٲ������ݿ���
           Collection wfLogHasSaveList = new ArrayList();
          //��֤�ڵ㲻Ӧ���д����Ķ���ڵ㣬��Ҫ�ۺϵġ��������Ķ������Ҳ��Ҫ�ϲ���
           if (wfNodeDto.getNodeType().equals("certi") ||wfNodeDto.getNodeType().equals("compe"))
           {
           	//����ǿ���ļ��룬�Ƿ���Կ��ǣ�һ�������ϵĽڵ��ǲ����ظ��ġ������絥֤������������Ϊ������ͬ������һ������һ����  
        	   	wfLogHasSaveList =  uiWorkFlowAction.findNoDealNodeByModelNodeNoByPerson(flowID,wfNodeDto.getNodeNo(),wfNodeDto.getNodeType(),wfNodeDto.getPolicyNo(),swfLogFunctionInOldDto.getRiskCode());
           }
           if(wfLogHasSaveList.iterator().hasNext())
              {
                //������ۺϵ�ʱ�򣬲����˴����Ķ���ڵ������
                //�����ݿ��в�ѯ���Ѿ����ڵĽڵ㣬���������ó�Ҫȥ�Ľڵ�
                wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.iterator().next();
                //����������������ݣ�����Ҫ����wflog��ֻҪ��wfPathlog��������Ӧ�ı߾Ϳ�����
               /*7.---------------------д�����߱�wfPathLog-----------------------------*/
              }
             else
            {
                //�����ǰ�ڵ�Ϊ���ȣ����õ�ǰ�ڵ�ĸ�����Ϣ
                //��ʼ����һ���ڵ�ĸ�����Ϣ
                getSwfLogDtoInfoBySwfNode(wfLogDtoTemp,wfNodeDto,user,flowID,modelNo,logNo,"0",swfLogFunctionInOldDto.getKeyIn(),swfLogFunctionInDto);
                //ɾ��sched�ڵ��ϵĸ�����Ϣ

                //����wfLogDtoTemp�µĽڵ�Ĳ���Ա
                //wfLogDtoTemp.setHandlerCode(swfLogFunctionInOldDto.getHandlerCode() );
                //wfLogDtoTemp.setHandlerName(swfLogFunctionInOldDto.getHandlerName());

                wfLogDtoList.add(wfLogDtoTemp);
                logNo++;
             }
           /*7.---------------------д�����߱�wfPathLog---------------------------------*/
           SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
           getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
           wfPathLogDtoList.add(swfPathLogDto);
           pathNo++;
         }
          workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
          workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
          workFlowDto.setSubmit(true);
       }
       else
       {
         workFlowDto.setStatus("9"); //�����쳣
       }
       return workFlowDto;
    }
        
        
        protected WorkFlowDto getSubmitFlowInfoMedical(UserDto user,SwfLogDto swfLogFunctionInDto,SwfLogDto swfLogFunctionInOldDto,int logNo, int pathNo)
        throws Exception
    {
      //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
      //1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      WorkFlowDto workFlowDto = new WorkFlowDto();
      //2.ȡ����������
      String flowID = swfLogFunctionInDto.getFlowID() ;
      /*---3.ȡ��������ģ���*/
      int modelNo= swfLogFunctionInDto.getModelNo() ;
      /*4.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/

      Collection wfNodeDtoList = new ArrayList();  //ģ��Ľڵ�
      ArrayList wfLogDtoList = new ArrayList();    //�������Ҫ�²���Ĺ������̽ڵ�
      ArrayList wfPathLogDtoList = new ArrayList();//�������Ҫ�²���Ĺ������̱�
      Collection swfNodeNextList = new ArrayList();//��Ŵӽ��洫��������Ҫ�͵Ķ���ڵ�

      swfNodeNextList = swfLogFunctionInOldDto.getSwfLogList() ;
      //��ѯ�ڵ����ϸ����
      //��һ���ڵ㶨�������
      Iterator itn = swfNodeNextList.iterator() ;
      int nextNodeNo = 0;
      String nodeType="";
      while (itn.hasNext() )
      {
        //swfLogNext ��һ���ڵ�ӽ��洫���Ķ���
         SwfLogDto swfLogNext = (SwfLogDto)itn.next() ;
         nextNodeNo = swfLogNext.getNodeNo() ;
         nodeType=swfLogNext.getNodeType() ;
         //�쳣�жϣ����nextNodeNo=0 ˵��û�ҵ���,��Ŀǰֻ���ǲ���������¸��ڵ��ˡ��Ժ�����
         //Ŀǰ��������nodeType���д������ݵ�
         //��facadeֻ���ڵ����ͽ��빤�����оͿ��Եġ�
          SwfNodeDto swfNodeDto = new SwfNodeDto();
         if ((nextNodeNo==0)&&(!nodeType.equals("")))
         {
             swfNodeDto=getFirstNodeTypeNode(modelNo,nodeType);
         }else
         {
             if (nextNodeNo==0) continue;
             swfNodeDto=uiWorkFlowAction.findModelNodeByPrimaryKey(modelNo,nextNodeNo);
         }
         if (swfNodeDto!=null) //������ȷ��ѯ����һ���ڵ��ϵ���Ϣ.
      {
          if (swfLogNext.getHandlerCode().length()>0)
          {
             swfNodeDto.setHandlerCode(swfLogNext.getHandlerCode() );
             swfNodeDto.setHandlerName(swfLogNext.getHandlerName() );
          }
         //�ڵ��ϵĸ�����Ϣ ��ǰԤ����,�Ժ�Ҳ���������ģ�ֻ�������¸��ڵ������õ�
         //Ĭ��Ϊ���ڵ����ݵĸ������ݣ���������ⲿ�������µ�ֵ�������µ�Ϊ׼
         swfNodeDto.setScheduleID(swfLogFunctionInDto.getScheduleID() );
         swfNodeDto.setLossItemCode(swfLogFunctionInDto.getLossItemCode() );
         swfNodeDto.setLossItemName(swfLogFunctionInDto.getLossItemName() );
         swfNodeDto.setInsureCarFlag(swfLogFunctionInDto.getInsureCarFlag() ) ;
         swfNodeDto.setTypeFlag(swfLogFunctionInDto.getTypeFlag() ) ;
         swfNodeDto.setHandlerRange(swfLogFunctionInDto.getHandlerRange() ) ;
         swfNodeDto.setExigenceGree(swfLogFunctionInDto.getExigenceGree() ) ;
         swfNodeDto.setHandleDept(swfLogFunctionInDto.getNewHandleDept() );
         swfNodeDto.setDeptName(swfLogFunctionInDto.getNewDeptName() );
           

         if (swfLogNext.getScheduleID()>0) swfNodeDto.setScheduleID(swfLogNext.getScheduleID() );
         if (!swfLogNext.getLossItemCode().equals("")) swfNodeDto.setLossItemCode(swfLogNext.getLossItemCode() );
         if (!swfLogNext.getLossItemName().equals("")) swfNodeDto.setLossItemName(swfLogNext.getLossItemName() );
         if (!swfLogNext.getInsureCarFlag().equals("")) swfNodeDto.setInsureCarFlag(swfLogNext.getInsureCarFlag() ) ;
         if (!swfLogNext.getTypeFlag().equals("")) swfNodeDto.setTypeFlag(swfLogNext.getTypeFlag() ) ;
         if (!swfLogNext.getHandlerRange().equals("")) swfNodeDto.setHandlerRange(swfLogNext.getHandlerRange() ) ;
         if (!swfLogNext.getExigenceGree().equals("")) swfNodeDto.setExigenceGree(swfLogNext.getExigenceGree() ) ;
         if (!swfLogNext.getNewHandleDept ().equals("")) swfNodeDto.setHandleDept (swfLogNext.getNewHandleDept ()) ;
         if (!swfLogNext.getNewDeptName ().equals("")) swfNodeDto.setDeptName (swfLogNext.getNewDeptName ()) ;
         //add by lixiang start 2006-6-4 
         //reason : ����ǿ������֧�������ǰ��ղ�ͬ�ı�������
         if (swfNodeDto.getNodeType().equals( "claim")||swfNodeDto.getNodeType().equals( "compe")||swfNodeDto.getNodeType().equals( "cance")){
            if (!swfLogNext.getPolicyNo ().equals("")) swfNodeDto.setPolicyNo (swfLogNext.getPolicyNo ()) ;
            if (!swfLogNext.getRiskCode ().equals("")) swfNodeDto.setRiskCode(swfLogNext.getRiskCode ()) ;
            if (!swfLogNext.getKeyIn().equals(""))   swfNodeDto.setKeyIn  (swfLogNext.getKeyIn() );
            if (!swfLogNext.getBusinessNo().equals(""))   swfNodeDto.setBusinessNo  (swfLogNext.getBusinessNo() );
          
         }
//       add by lixiang end 2006-6-4 
         wfNodeDtoList.add(swfNodeDto);
        }
      }
     /*5.-----------------�����¸��������ڵ�д�������̵ĵ���ߵ�����----------------*/

      if (wfNodeDtoList.iterator() .hasNext() )
      {
        Iterator it = wfNodeDtoList.iterator();
        while (it.hasNext()) {
          SwfNodeDto wfNodeDto = new SwfNodeDto();
          wfNodeDto = (SwfNodeDto) it.next();

          /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
          SwfLogDto wfLogDtoTemp = new SwfLogDto();
          //����wfLogDtoTemp

         //�ж��Ƿ��ڵ�ǰ�������У��Ѿ��б�����ɸýڵ�Ĵ��ڣ�����״̬Ϊ0,û�д���������ڵ㣬����Ǻ���ʵ���أ���Ϊ�������ύ��
         //����У��Ͳ����ٲ������ݿ���
          Collection wfLogHasSaveList = new ArrayList();
         //��֤�ڵ㲻Ӧ���д����Ķ���ڵ㣬��Ҫ�ۺϵġ��������Ķ������Ҳ��Ҫ�ϲ���
          if (wfNodeDto.getNodeType().equals("certi") ||wfNodeDto.getNodeType().equals("compe"))
          {
          	//����ǿ���ļ��룬�Ƿ���Կ��ǣ�һ�������ϵĽڵ��ǲ����ظ��ġ������絥֤������������Ϊ������ͬ������һ������һ����  
       	   	wfLogHasSaveList =  uiWorkFlowAction.findNoDealNodeByModelNodeNoByPerson(flowID,wfNodeDto.getNodeNo(),wfNodeDto.getNodeType(),wfNodeDto.getPolicyNo(),swfLogFunctionInOldDto.getRiskCode());
          }
          if(wfLogHasSaveList.iterator().hasNext())
             {
               //������ۺϵ�ʱ�򣬲����˴����Ķ���ڵ������
               //�����ݿ��в�ѯ���Ѿ����ڵĽڵ㣬���������ó�Ҫȥ�Ľڵ�
               wfLogDtoTemp = (SwfLogDto) wfLogHasSaveList.iterator().next();
               //����������������ݣ�����Ҫ����wflog��ֻҪ��wfPathlog��������Ӧ�ı߾Ϳ�����
              /*7.---------------------д�����߱�wfPathLog-----------------------------*/
             }
            else
           {
               //�����ǰ�ڵ�Ϊ���ȣ����õ�ǰ�ڵ�ĸ�����Ϣ
               //��ʼ����һ���ڵ�ĸ�����Ϣ
               getSwfLogDtoInfoBySwfNodeMedical(wfLogDtoTemp,wfNodeDto,user,flowID,modelNo,logNo,"0",swfLogFunctionInOldDto.getKeyIn(),swfLogFunctionInDto);
               //ɾ��sched�ڵ��ϵĸ�����Ϣ

               //����wfLogDtoTemp�µĽڵ�Ĳ���Ա
               //wfLogDtoTemp.setHandlerCode(swfLogFunctionInOldDto.getHandlerCode() );
               //wfLogDtoTemp.setHandlerName(swfLogFunctionInOldDto.getHandlerName());

               wfLogDtoList.add(wfLogDtoTemp);
               logNo++;
            }
          /*7.---------------------д�����߱�wfPathLog---------------------------------*/
          SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
          getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogFunctionInDto,wfLogDtoTemp,flowID,modelNo,pathNo);
          wfPathLogDtoList.add(swfPathLogDto);
          pathNo++;
        }
         workFlowDto.setSubmitSwfLogDtoList(wfLogDtoList);
         workFlowDto.setSubmitSwfPathLogDtoList(wfPathLogDtoList);
         workFlowDto.setSubmit(true);
      }
      else
      {
        workFlowDto.setStatus("9"); //�����쳣
      }
      return workFlowDto;
   }    



    /**
    * ���ݹ�����ģ���ϵ���ͬ�ڵ㶨�壬дwflog���������̽ڵ�Ĳ�������
    * @param swfLogDto SwfLogDto
    * @param swfNodeDto SwfNodeDto
    * @param user UserDto
    * @param flowID String
    * @param modelNo int
    * @param logNo int
    * @param nodeStatus String
    * @param keyIn String
    * @param swfLogFunctionIn SwfLogDto ����ǰ�������ڵ㣩
    * @throws Exception
    * @return SwfLogDto
    */
   private SwfLogDto getSwfLogDtoInfoBySwfNode(SwfLogDto swfLogDto,SwfNodeDto swfNodeDto,UserDto user,String flowID,int modelNo,int logNo,String nodeStatus,String keyIn,SwfLogDto swfLogFunctionIn)
        throws Exception
    {
      swfLogDto.setFlowID(flowID);
      swfLogDto.setLogNo(logNo);
      swfLogDto.setModelNo(modelNo);
      swfLogDto.setNodeNo(swfNodeDto.getNodeNo());
      swfLogDto.setNodeName(swfNodeDto.getNodeName());
      swfLogDto.setBusinessNo(swfLogFunctionIn.getBusinessNo()  );
      /*--1����������Ĳ������������Ҫ������swfLogFunctionIn.��NextBusinessNo*/
      if (swfNodeDto.getNodeType().equals("endca") )
      { swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo()  );
      }      
      swfLogDto.setBeforeHandlerCode(user.getUserCode());
      swfLogDto.setBeforeHandlerName(user.getUserName());
      //swfLogDto.setFlowInTime	();
      swfLogDto.setTimeLimit(swfNodeDto.getTimeLimit());
      //modify by weishixin modify 20050227 start
      //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
      swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
      //modify by weishixin modify 20050227 end
      //swfLogDto.setSubmitTime	();
      swfLogDto.setNodeStatus(nodeStatus);
      swfLogDto.setFlowStatus("1");
      swfLogDto.setPackageID("0");
      swfLogDto.setFlag(swfNodeDto.getFlag() ) ;
      swfLogDto.setTaskNo(swfNodeDto.getTaskNo());
      swfLogDto.setTaskType(swfNodeDto.getTaskType());
      swfLogDto.setNodeType(swfNodeDto.getNodeType());
      
      //������Ĳ�ѯ���������ӱ����ţ��������ˣ����ƺ�(��������Ҫ���)
      swfLogDto.setRegistNo(swfLogFunctionIn.getRegistNo());
      swfLogDto.setInsuredName(swfLogFunctionIn.getInsuredName());
      swfLogDto.setLossItemName(swfLogFunctionIn.getLossItemName());
      //swfLogDto.setTitleStr();
      //swfLogDto.setBusinessType (businessType);
      swfLogDto.setRiskCode	    (swfLogFunctionIn.getRiskCode() );
      swfLogDto.setKeyIn(keyIn );
      /*--���ڵ�֤,���𣬺����ʱ��keyin��registno,��������£�����keyin��ֵ���������Ϊû�취���keyin��ͬ�ģ����л�����*/
      if (swfLogDto.getNodeType().equals("certi")||swfLogDto.getNodeType().equals("certa")||swfLogDto.getNodeType().equals("verip")||swfLogDto.getNodeType().equals("verpo")||swfLogDto.getNodeType().equals("verif")  )
      {   swfLogDto.setKeyIn(swfLogFunctionIn.getKeyIn()  );
      }
      /*--����ʵ�������£�����claimno,buesssno*/

      if (swfLogDto.getNodeType().equals("compe"))
      {
     
      	 swfLogDto.setKeyIn(swfLogDto.getBusinessNo());
    	//swfLogDto.setKeyIn(swfLogDto.getKeyIn());
      }
      /*-����ڵ��Ǻ���ڵ㣬��ôҪ������ı�־λ����ȥ--*/
      /*
      if (swfLogDto.getNodeType().equals("verif"))
      {
      swfLogDto.setTypeFlag(swfLogFunctionIn.getTypeFlag() );
      }
*/    swfLogDto.setTypeFlag(swfNodeDto.getTypeFlag() );
      swfLogDto.setKeyOut("");
      
      swfLogDto.setSubFlowID("0");
      swfLogDto.setMainFlowID("0");
      swfLogDto.setPosX(0);
      swfLogDto.setPosY(0);
      swfLogDto.setEndFlag(swfNodeDto.getEndFlag() );
      //��������ʱ��
      //modify by weishixin modify 20050227 start
      //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
      swfLogDto.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
      //modify by weishixin modify 20050227 end
      //���ýڵ������
      String titleAttr =swfNodeDto.getNodeName()+"�ڵ�"+"����ʱ�䣺"+swfLogDto.getFlowInTime() +" ��һ�ڵ������:"+ user.getUserName() ;
      swfLogDto.setTitleStr(titleAttr);

      //���ñ�������
      swfLogDto.setPolicyNo	    (swfLogFunctionIn.getPolicyNo() );
      //����Ĭ�Ͻڵ��ϵ���Ա
      swfLogDto.setHandlerCode(swfNodeDto.getHandlerCode() );
      swfLogDto.setHandlerName(swfNodeDto.getHandlerName() );
      swfLogDto.setComCode(swfLogFunctionIn.getComCode() );
      //���ø�������
      swfLogDto.setScheduleID(swfNodeDto.getScheduleID()) ;
      swfLogDto.setLossItemCode(swfNodeDto.getLossItemCode());
      swfLogDto.setLossItemName(swfNodeDto.getLossItemName());
      swfLogDto.setInsureCarFlag(swfNodeDto.getInsureCarFlag() );
      swfLogDto.setHandlerRange(swfNodeDto.getHandlerRange() );
      swfLogDto.setExigenceGree (swfNodeDto.getExigenceGree() );
      swfLogDto.setHandleDept(swfNodeDto.getHandleDept() );
      swfLogDto.setDeptName(swfNodeDto.getDeptName());
      
      if (swfLogDto.getNodeType().equals("claim") && swfLogDto.getHandleDept().equals("")){
    	  swfLogDto.setHandleDept(swfLogFunctionIn.getComCode());
      }else{
    	  if (swfLogDto.getHandleDept().equals("")) swfLogDto.setHandleDept(swfLogFunctionIn.getNewHandleDept() );
          if (swfLogDto.getHandleDept().equals("")) swfLogDto.setHandleDept(user.getComCode());
      }
      if (swfLogDto.getDeptName().equals("")) swfLogDto.setDeptName(swfLogFunctionIn.getNewDeptName() );
      if (swfLogDto.getDeptName().equals("")) swfLogDto.setDeptName(user.getComName());
      //if (swfLogDto.getInsureCarFlag().equals("")) swfLogDto.setInsureCarFlag(swfLogFunctionIn.getInsureCarFlag() );
      
      //    add by lixiang start at 2006-6-4
      //resason :�������������ݵ�֧��
     
      if (swfLogDto.getNodeType().equals("claim")||swfLogDto.getNodeType().equals("compe")||swfLogDto.getNodeType().equals("cance"))
      {
        //swfLogDto.setTimeLimit(DateTime.current().getHour() );
         if (!swfNodeDto.getRiskCode().equals(""))  swfLogDto.setRiskCode  (swfNodeDto.getRiskCode() );
         if (!swfNodeDto.getPolicyNo().equals(""))   swfLogDto.setPolicyNo  (swfNodeDto.getPolicyNo() );
         if (!swfNodeDto.getKeyIn().equals(""))   swfLogDto.setKeyIn  (swfNodeDto.getKeyIn() );
         if (!swfNodeDto.getBusinessNo().equals(""))   swfLogDto.setBusinessNo  (swfNodeDto.getBusinessNo() );
          
        //add by lixiang end at 2006-6-4
      }

      return swfLogDto;
    }
   
   
   private SwfLogDto getSwfLogDtoInfoBySwfNodeMedical(SwfLogDto swfLogDto,SwfNodeDto swfNodeDto,UserDto user,String flowID,int modelNo,int logNo,String nodeStatus,String keyIn,SwfLogDto swfLogFunctionIn)
   throws Exception
	{
	 swfLogDto.setFlowID(flowID);
	 swfLogDto.setLogNo(logNo);
	 swfLogDto.setModelNo(modelNo);
	 swfLogDto.setNodeNo(swfNodeDto.getNodeNo());
	 swfLogDto.setNodeName(swfNodeDto.getNodeName());
	 swfLogDto.setBusinessNo(swfLogFunctionIn.getBusinessNo()  );
	 /*--1����������Ĳ������������Ҫ������swfLogFunctionIn.��NextBusinessNo*/
	 if (swfNodeDto.getNodeType().equals("endca") )
	 { swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo()  );
	 }      
	 swfLogDto.setBeforeHandlerCode(user.getUserCode());
	 swfLogDto.setBeforeHandlerName(user.getUserName());
	 //swfLogDto.setFlowInTime	();
	 swfLogDto.setTimeLimit(swfNodeDto.getTimeLimit());
	 //modify by weishixin modify 20050227 start
	 //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
	 swfLogDto.setHandleTime(new DateTime(swfLogFunctionIn.getHandleTime(),DateTime.YEAR_TO_SECOND).toString());
	 //modify by weishixin modify 20050227 end
	 //swfLogDto.setSubmitTime	();
	 swfLogDto.setNodeStatus(nodeStatus);
	 swfLogDto.setFlowStatus("1");
	 swfLogDto.setPackageID("0");
	 swfLogDto.setFlag(swfNodeDto.getFlag() ) ;
	 swfLogDto.setTaskNo(swfNodeDto.getTaskNo());
	 swfLogDto.setTaskType(swfNodeDto.getTaskType());
	 swfLogDto.setNodeType(swfNodeDto.getNodeType());
	 
	 //������Ĳ�ѯ���������ӱ����ţ��������ˣ����ƺ�(��������Ҫ���)
	 swfLogDto.setRegistNo(swfLogFunctionIn.getRegistNo());
	 swfLogDto.setInsuredName(swfLogFunctionIn.getInsuredName());
	 swfLogDto.setLossItemName(swfLogFunctionIn.getLossItemName());
	 //swfLogDto.setTitleStr();
	 //swfLogDto.setBusinessType (businessType);
	 swfLogDto.setRiskCode	    (swfLogFunctionIn.getRiskCode() );
	 swfLogDto.setKeyIn(keyIn );
	 /*--���ڵ�֤,���𣬺����ʱ��keyin��registno,��������£�����keyin��ֵ���������Ϊû�취���keyin��ͬ�ģ����л�����*/
	 if (swfLogDto.getNodeType().equals("certi")||swfLogDto.getNodeType().equals("certa")||swfLogDto.getNodeType().equals("verip")||swfLogDto.getNodeType().equals("verpo")||swfLogDto.getNodeType().equals("verif")  )
	 {   swfLogDto.setKeyIn(swfLogFunctionIn.getKeyIn()  );
	 }
	 /*--����ʵ�������£�����claimno,buesssno*/
	
	 if (swfLogDto.getNodeType().equals("compe"))
	 {
	
	 	 swfLogDto.setKeyIn(swfLogDto.getBusinessNo());
		//swfLogDto.setKeyIn(swfLogDto.getKeyIn());
	 }
	 /*-����ڵ��Ǻ���ڵ㣬��ôҪ������ı�־λ����ȥ--*/
	 /*
	 if (swfLogDto.getNodeType().equals("verif"))
	 {
	 swfLogDto.setTypeFlag(swfLogFunctionIn.getTypeFlag() );
	 }
	*/    swfLogDto.setTypeFlag(swfNodeDto.getTypeFlag() );
	 swfLogDto.setKeyOut("");
	 
	 swfLogDto.setSubFlowID("0");
	 swfLogDto.setMainFlowID("0");
	 swfLogDto.setPosX(0);
	 swfLogDto.setPosY(0);
	 swfLogDto.setEndFlag(swfNodeDto.getEndFlag() );
	 //��������ʱ��
	 //modify by weishixin modify 20050227 start
	 //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
	 swfLogDto.setFlowInTime(new DateTime(swfLogFunctionIn.getFlowInTime(),DateTime.YEAR_TO_SECOND).toString());
	 //modify by weishixin modify 20050227 end
	 //���ýڵ������
	 String titleAttr =swfNodeDto.getNodeName()+"�ڵ�"+"����ʱ�䣺"+swfLogDto.getFlowInTime() +" ��һ�ڵ������:"+ user.getUserName() ;
	 swfLogDto.setTitleStr(titleAttr);
	
	 //���ñ�������
	 swfLogDto.setPolicyNo	    (swfLogFunctionIn.getPolicyNo() );
	 //����Ĭ�Ͻڵ��ϵ���Ա
	 swfLogDto.setHandlerCode(swfNodeDto.getHandlerCode() );
	 swfLogDto.setHandlerName(swfNodeDto.getHandlerName() );
	 swfLogDto.setComCode(swfLogFunctionIn.getComCode() );
	 //���ø�������
	 swfLogDto.setScheduleID(swfNodeDto.getScheduleID()) ;
	 swfLogDto.setLossItemCode(swfNodeDto.getLossItemCode());
	 swfLogDto.setLossItemName(swfNodeDto.getLossItemName());
	 swfLogDto.setInsureCarFlag(swfNodeDto.getInsureCarFlag() );
	 swfLogDto.setHandlerRange(swfNodeDto.getHandlerRange() );
	 swfLogDto.setExigenceGree (swfNodeDto.getExigenceGree() );
	 swfLogDto.setHandleDept(swfNodeDto.getHandleDept() );
	 swfLogDto.setDeptName(swfNodeDto.getDeptName());
	 
	 if (swfLogDto.getNodeType().equals("claim") && swfLogDto.getHandleDept().equals("")){
		  swfLogDto.setHandleDept(swfLogFunctionIn.getComCode());
	 }else{
		  if (swfLogDto.getHandleDept().equals("")) swfLogDto.setHandleDept(swfLogFunctionIn.getNewHandleDept() );
	     if (swfLogDto.getHandleDept().equals("")) swfLogDto.setHandleDept(user.getComCode());
	 }
	 if (swfLogDto.getDeptName().equals("")) swfLogDto.setDeptName(swfLogFunctionIn.getNewDeptName() );
	 if (swfLogDto.getDeptName().equals("")) swfLogDto.setDeptName(user.getComName());
	 //if (swfLogDto.getInsureCarFlag().equals("")) swfLogDto.setInsureCarFlag(swfLogFunctionIn.getInsureCarFlag() );
	 
	 //    add by lixiang start at 2006-6-4
	 //resason :�������������ݵ�֧��
	
	 if (swfLogDto.getNodeType().equals("claim")||swfLogDto.getNodeType().equals("compe")||swfLogDto.getNodeType().equals("cance"))
	 {
	   //swfLogDto.setTimeLimit(DateTime.current().getHour() );
	    if (!swfNodeDto.getRiskCode().equals(""))  swfLogDto.setRiskCode  (swfNodeDto.getRiskCode() );
	    if (!swfNodeDto.getPolicyNo().equals(""))   swfLogDto.setPolicyNo  (swfNodeDto.getPolicyNo() );
	    if (!swfNodeDto.getKeyIn().equals(""))   swfLogDto.setKeyIn  (swfNodeDto.getKeyIn() );
	    if (!swfNodeDto.getBusinessNo().equals(""))   swfLogDto.setBusinessNo  (swfNodeDto.getBusinessNo() );
	     
	   //add by lixiang end at 2006-6-4
	 }
	
	 return swfLogDto;
	}
   /**
    * дwfPathlog�����������ߵĲ�������
    * @param swfPathLogDto SwfPathLogDto �¹���������·���ڵ�
    * @param swfLogCurrDto SwfLogDto  ��ǰ�ڵ�
    * @param swfLogNextDto SwfLogDto  ��һ���ڵ�
    * @param flowID String ����������
    * @param modelNo int  ����ģ���
    * @param pathNo int  ��������·����
    * @throws Exception
    * @return SwfPathLogDto
    */
   protected SwfPathLogDto getSwfPathLogDtoInfoBySwfLog(SwfPathLogDto swfPathLogDto,SwfLogDto swfLogCurrDto,SwfLogDto swfLogNextDto,String flowID,int modelNo,int pathNo)
        throws Exception
    {
    	String pathName ="";
	swfPathLogDto.setFlowID(flowID);
        swfPathLogDto.setPathNo(pathNo);
        swfPathLogDto.setModelNo(modelNo);
        pathName = "�� " + swfLogCurrDto.getNodeName() + " �� " +
        swfLogNextDto.getNodeName();
        swfPathLogDto.setPathName(pathName);
        swfPathLogDto.setStartNodeNo(swfLogCurrDto.getLogNo()); //ֻ��¼���
        swfPathLogDto.setStartNodeName(swfLogCurrDto.getNodeName());
        swfPathLogDto.setEndNodeNo(swfLogNextDto.getLogNo()); //�����Ѿ�����ģ�嶨��ĺ���
        swfPathLogDto.setEndNodeName(swfLogNextDto.getNodeName());
        swfPathLogDto.setFlag("");
        return swfPathLogDto;
    }

    /**
     * ���ݵ�ǰ�ڵ�����ݣ��ύ������������Ľڵ�
     * @param httpServletRequest HttpServletRequest
     * @param swfLogDto SwfLogDto ��ǰ�������̽ڵ���Ϣ
     * @param NextBusinessNo String �¸��ڵ��businessno
     * @param conditionBusinessNo String ���������µ�bussinessno
     * @param KeyIN String ��һ���ڵ��keyIn��ʲô
     * @param nodeStatus String ���ڵ���Ҫ���õ�״̬
     * @param KeyOut String ���ڵ��keyOut
     * @throws Exception
     */
    private WorkFlowDto submitWorkFlow(UserDto user,SwfLogDto swfLogDto,SwfLogDto swfLogFunctionIn,int logNo,int pathNo)
       throws Exception
   {
       UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
       WorkFlowDto workFlowDto = new WorkFlowDto();
       WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
       //�����ǰ�ڵ��״̬

       //��ʱ������ǰ�����ڵ����Ϣ,��Ϊ���������ύ����ĵ�ǰ�ڵ�����
       SwfLogDto swfLogDtoTemp = new SwfLogDto();
       swfLogDtoTemp = swfLogDto;
        //����н�����־�ĵ㣬���ۺ������κε����ã���Ҫ���������������ж�����Ľڵ�͹�ϵ�ȵ�
       if (swfLogDto.getEndFlag().equals("1"))
       {
            //����������
            //���Ƚ����ýڵ�ǰ��ʧ��ڵ� ,Ϊ�����ף��Ȳ�ѯ�����̵�taskType='M'���͵Ľ�����
            workFlowDto.setUpdate(true);
            swfLogDtoTemp.setHandlerCode(user.getUserCode() );
            swfLogDtoTemp.setHandlerName(user.getUserName() );
            workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
            
            //add by lixiang start at 2006-6-7
            //reason :���ڽ᰸�ǿ����ж���᰸�ģ����Ե��жϻ�����û�йرյĽ᰸�������̲�������
            //�ȴ����еĽ᰸�����ʱ�����̲Ž�����
            if (swfLogDtoTemp.getNodeType() .equals("endca" ) || swfLogDtoTemp.getNodeType() .equals("cance" )){
//            	2�������Ƿ�ֻ��һ��������㣬������㳬��1�������ܹر�����
         		String conditonss   = "flowId='"+swfLogDtoTemp.getFlowID() +"' and nodeType='claim' and nodestatus <> '6'";
         		String conditions1  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and endflag='1' and nodestatus = '4'";
         		String conditions2  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and nodeType='compe' and nodestatus <> '5'";
         		String conditions3  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and endflag='1' ";
         		//���Ҹð��������ڵ���
         		ArrayList claimList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditonss);
         		//���Ҹð����ѽ����Ľڵ���
         		ArrayList endList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions1);
         		//��������ڵ���
         		ArrayList compeList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions2);
         		//���ҽ᰸�ڵ���
         		ArrayList endList1 = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions3);
         		
         		//���跢�ֻ�û�н��갸�ӵ����̣��򲻽����̽�����
         		//ֻ�ǹرյ�Ŀǰ��������ص��Ǹ����㣬ֱ�ӷ������е�workFlowDto.         		
         		if ( (claimList !=null && endList != null && claimList.size() - endList.size() >1) ||
         			 (compeList !=null && endList != null && compeList.size() - endList.size() >1 ||
         			 (endList1 != null && endList != null && endList1.size() - endList.size() > 1))
         			){
         			/* �㲻���
         			for (int i=0;i<claimList .size() ;i++){
         				SwfLogDto swfLogDtoCompe = new SwfLogDto();
         				 swfLogDtoCompe = (SwfLogDto)claimList.get(i);
         				if (swfLogDtoCompe.getKeyIn().equals(swfLogDtoTemp.getKeyIn()) ){
         					swfLogDtoCompe.setNodeStatus( "4");//�ر�����
         					workFlowDto.setUpdateSwfLog2Dto(swfLogDtoCompe);
         					
         					break;
         				}
         			}
         			*/
         			workFlowDto.setClose(false);
         			return workFlowDto ;
         		}

            }
//          add by lixiang start at 2006-6-7
            workFlowDto.setClose(true);
            SwfFlowMainDto swfFlowMainDto = new  SwfFlowMainDto();
            
            //����ǵ�һ���ڵ㣬���ڻ�û�й��������������أ����Բ���Ҫ��ѯ�ġ�
            swfFlowMainDto = uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogDto.getFlowID().trim());
           if ( swfFlowMainDto!=null)
           {  
             swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ));
             swfFlowMainDto.setFlowStatus("0");
           }
            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto) ;
            return workFlowDto ;
       }
       
        //һ������£�NextBusinessNo��BusinessNo������ͬ��
           //������������Ľڵ�
           if (!swfLogDto.getNodeType().equals("compp"))
           {  swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
            }
           swfLogDto.setNextBusinessNo(swfLogFunctionIn.getNextBusinessNo());
           String nodeType = "";
           ArrayList SwfLogDtoList = (ArrayList)swfLogFunctionIn.getSwfLogList();
           if(SwfLogDtoList!=null){
	           for(int i=0;i<SwfLogDtoList.size();i++){
	        	   SwfLogDto swfLogDto1 = (SwfLogDto)SwfLogDtoList.get(i);
	        	   nodeType = swfLogDto1.getNodeType();
	           }
           }
           if("speci".equals(nodeType)){
        	   swfLogDto.setRiskCode(swfLogDto.getBusinessNo().substring(1, 5));
           }
           //�ύ������ba
           //������Щ�ڵ��keyin keyout�����ϸ��ڵ�����룬����ֻ�õ�����keyin
           //�ж��ǲ����˵��˵��ύ,�������õı�־nextNodeListType
           if (swfLogFunctionIn.getNextNodeListType().equals("1") )
         {
           //֧��ָ����

           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn,logNo,pathNo) ;
         }  else
         { //֧�ִ�ģ����ȡ��
         	swfLogDto.setNewHandleDept(swfLogFunctionIn.getNewHandleDept()); 
           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn.getKeyIn() ,logNo,pathNo) ;
         }

           //���ô�����Ա
           swfLogDtoTemp.setHandlerCode(user.getUserCode() );
           swfLogDtoTemp.setHandlerName(user.getUserName() );
           if("speci".equals(nodeType)){
        	   swfLogDtoTemp.setRiskCode(swfLogDtoTemp.getBusinessNo().substring(1, 5));
           }
           //����ж���Ļ������ö�������
           if (swfLogFunctionIn.getTypeFlag()!=null&&swfLogFunctionIn.getTypeFlag().length()>0)
           {
           swfLogDtoTemp.setTypeFlag(swfLogFunctionIn.getTypeFlag());
          }
           if (workFlowDto.equals("9") )
           {
               //���ù�����������ڵ�Ϊ�쳣
               swfLogDtoTemp.setNodeStatus("9");
            }
           else
           {
              //������ת��û�������쳣
              workFlowDto.setUpdate(true);
              //����ʵ��
              if (workFlowDtoTemp.getUpdate()) //��ʾ�����ύ���������Խ��к���Ľڵ㣬ֻҪ�����������
                 {
                  workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto() );
                 }
                else
              {
              workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
              workFlowDto.setSubmit(true);
              workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList()) ;
              workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList()) ;
              }
          }
       
       return workFlowDto ;
    }
    
    
    private WorkFlowDto submitWorkFlowMedical(UserDto user,SwfLogDto swfLogDto,SwfLogDto swfLogFunctionIn,int logNo,int pathNo)
    throws Exception
{
    UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
    WorkFlowDto workFlowDto = new WorkFlowDto();
    WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
    //�����ǰ�ڵ��״̬

    //��ʱ������ǰ�����ڵ����Ϣ,��Ϊ���������ύ����ĵ�ǰ�ڵ�����
    SwfLogDto swfLogDtoTemp = new SwfLogDto();
    swfLogDtoTemp = swfLogDto;
     //����н�����־�ĵ㣬���ۺ������κε����ã���Ҫ���������������ж�����Ľڵ�͹�ϵ�ȵ�
    if (swfLogDto.getEndFlag().equals("1"))
    {
         //����������
         //���Ƚ����ýڵ�ǰ��ʧ��ڵ� ,Ϊ�����ף��Ȳ�ѯ�����̵�taskType='M'���͵Ľ�����
         workFlowDto.setUpdate(true);
         swfLogDtoTemp.setHandlerCode(user.getUserCode() );
         swfLogDtoTemp.setHandlerName(user.getUserName() );
         workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
         
         //add by lixiang start at 2006-6-7
         //reason :���ڽ᰸�ǿ����ж���᰸�ģ����Ե��жϻ�����û�йرյĽ᰸�������̲�������
         //�ȴ����еĽ᰸�����ʱ�����̲Ž�����
         if (swfLogDtoTemp.getNodeType() .equals("endca" ) || swfLogDtoTemp.getNodeType() .equals("cance" )){
//         	2�������Ƿ�ֻ��һ��������㣬������㳬��1�������ܹر�����
      		String conditonss   = "flowId='"+swfLogDtoTemp.getFlowID() +"' and nodeType='claim' and nodestatus <> '6'";
      		String conditions1  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and endflag='1' and nodestatus = '4'";
      		String conditions2  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and nodeType='compe' and nodestatus <> '5'";
      		String conditions3  = "flowId='"+swfLogDtoTemp.getFlowID() +"' and endflag='1' ";
      		//���Ҹð��������ڵ���
      		ArrayList claimList = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditonss);
      		//���Ҹð����ѽ����Ľڵ���
      		ArrayList endList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions1);
      		//��������ڵ���
      		ArrayList compeList   = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions2);
      		//���ҽ᰸�ڵ���
      		ArrayList endList1 = (ArrayList)uiWorkFlowAction.findNodesByConditions(conditions3);
      		
      		//���跢�ֻ�û�н��갸�ӵ����̣��򲻽����̽�����
      		//ֻ�ǹرյ�Ŀǰ��������ص��Ǹ����㣬ֱ�ӷ������е�workFlowDto.         		
      		if ( (claimList !=null && endList != null && claimList.size() - endList.size() >1) ||
      			 (compeList !=null && endList != null && compeList.size() - endList.size() >1 ||
      			 (endList1 != null && endList != null && endList1.size() - endList.size() > 1))
      			){
      			/* �㲻���
      			for (int i=0;i<claimList .size() ;i++){
      				SwfLogDto swfLogDtoCompe = new SwfLogDto();
      				 swfLogDtoCompe = (SwfLogDto)claimList.get(i);
      				if (swfLogDtoCompe.getKeyIn().equals(swfLogDtoTemp.getKeyIn()) ){
      					swfLogDtoCompe.setNodeStatus( "4");//�ر�����
      					workFlowDto.setUpdateSwfLog2Dto(swfLogDtoCompe);
      					
      					break;
      				}
      			}
      			*/
      			workFlowDto.setClose(false);
      			return workFlowDto ;
      		}

         }
//       add by lixiang start at 2006-6-7
         workFlowDto.setClose(true);
         SwfFlowMainDto swfFlowMainDto = new  SwfFlowMainDto();
         
         //����ǵ�һ���ڵ㣬���ڻ�û�й��������������أ����Բ���Ҫ��ѯ�ġ�
         swfFlowMainDto = uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogDto.getFlowID().trim());
        if ( swfFlowMainDto!=null)
        {  
          swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ));
          swfFlowMainDto.setFlowStatus("0");
        }
         workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto) ;
         return workFlowDto ;
    }
    
     //һ������£�NextBusinessNo��BusinessNo������ͬ��
        //������������Ľڵ�
        if (!swfLogDto.getNodeType().equals("compp"))
        {  swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
         }
        swfLogDto.setNextBusinessNo(swfLogFunctionIn.getNextBusinessNo());
        String nodeType = "";
        ArrayList SwfLogDtoList = (ArrayList)swfLogFunctionIn.getSwfLogList();
        if(SwfLogDtoList!=null){
	           for(int i=0;i<SwfLogDtoList.size();i++){
	        	   SwfLogDto swfLogDto1 = (SwfLogDto)SwfLogDtoList.get(i);
	        	   nodeType = swfLogDto1.getNodeType();
	           }
        }
        if("speci".equals(nodeType)){
     	   swfLogDto.setRiskCode(swfLogDto.getBusinessNo().substring(1, 5));
        }
        //�ύ������ba
        //������Щ�ڵ��keyin keyout�����ϸ��ڵ�����룬����ֻ�õ�����keyin
        //�ж��ǲ����˵��˵��ύ,�������õı�־nextNodeListType
        if (swfLogFunctionIn.getNextNodeListType().equals("1") )
      {
        //֧��ָ����

        workFlowDtoTemp=getSubmitFlowInfoMedical(user,swfLogDto,swfLogFunctionIn,logNo,pathNo) ;
      }  else
      { //֧�ִ�ģ����ȡ��
      	swfLogDto.setNewHandleDept(swfLogFunctionIn.getNewHandleDept()); 
        workFlowDtoTemp=getSubmitFlowInfoMedical(user,swfLogDto,swfLogFunctionIn.getKeyIn() ,logNo,pathNo) ;
      }

        //���ô�����Ա
        swfLogDtoTemp.setHandlerCode(user.getUserCode() );
        swfLogDtoTemp.setHandlerName(user.getUserName() );
        if("speci".equals(nodeType)){
     	   swfLogDtoTemp.setRiskCode(swfLogDtoTemp.getBusinessNo().substring(1, 5));
        }
        //����ж���Ļ������ö�������
        if (swfLogFunctionIn.getTypeFlag()!=null&&swfLogFunctionIn.getTypeFlag().length()>0)
        {
        swfLogDtoTemp.setTypeFlag(swfLogFunctionIn.getTypeFlag());
       }
        if (workFlowDto.equals("9") )
        {
            //���ù�����������ڵ�Ϊ�쳣
            swfLogDtoTemp.setNodeStatus("9");
         }
        else
        {
           //������ת��û�������쳣
           workFlowDto.setUpdate(true);
           //����ʵ��
           if (workFlowDtoTemp.getUpdate()) //��ʾ�����ύ���������Խ��к���Ľڵ㣬ֻҪ�����������
              {
               workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto() );
              }
             else
           {
           workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
           workFlowDto.setSubmit(true);
           workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList()) ;
           workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList()) ;
           }
       }
    
    return workFlowDto ;
 }


     /**
     * ��ѯָ����ģ���У���ָ�����͵ĵ�һ���ڵ�
     * @param modelNo String ģ�����
     * @param nodeType String  �ڵ�����
     * @throws Exception
     * @return Collection
     */
    private SwfNodeDto getFirstNodeTypeNode(int modelNo,String nodeType) throws Exception
    {   //����˼·��
        //---------------------------------------------------
        //����ģ����룬�ڵ����Ͳ�ѯ��swfNodeDto����
        //---------------------------------------------------

        SwfNodeDto swfNodeDto = new SwfNodeDto();
        UIWorkFlowAction uiWorkFlowAction  = new UIWorkFlowAction ();
        String conditions="modelNo="+modelNo+" and nodeType='"+nodeType+"'";
        swfNodeDto = uiWorkFlowAction.findModelFirstNodeByCondition(conditions) ;
        return swfNodeDto;
    }
  /*========================����������ad���������������============================*/
    /*========================�ڶ����֣������������������========================*/

    private WorkFlowDto backWorkFlow(UserDto user,String flowID,int logNo,SwfLogDto swfLogFunctionInDto)
    throws Exception
	{
        WorkFlowDto workFlowDto = new WorkFlowDto();
        //System.err.println("size:" + swfLogFunctionInDto.getSwfLogList().size());
        if(swfLogFunctionInDto.getNextNodeListType().equals("1")){
        	if (swfLogFunctionInDto.getSwfLogList()!=null&&swfLogFunctionInDto.getSwfLogList().size() >0){
               //ָ���˻ؽڵ㼯�ϣ�ͨ�ã�,lixiang����һ��ֱ��ָ��flowid,logno���е��˻ط�ʽ ����ΪNextNodeList��Ϊnull��\

        		workFlowDto = getBackFlowInfoByNextNodeList(user,flowID,logNo,swfLogFunctionInDto);
        	}else{
        		
      		    String riskcode = swfLogFunctionInDto.getRiskCode();
      		    
      			//��89��ģ������� start==
      			BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
      	        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
      	        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//ȡ��89��ģ�������
      	        String riskcodeStr = "";//��89��ģ������ֵ��ַ���
      	        String[] classCodeArr = classCodeStr.split(",");
      	        String conditions = "";
      	        if(classCodeArr != null){
      	        	conditions += " classcode in('";
      	        	for(int i=0;i<classCodeArr.length;i++){
      	        		conditions += classCodeArr[i]+"',";
      	        	}
      	        	conditions = conditions.substring(0,conditions.length()-1);//ɾ������","��
      	        	conditions += ")";
      	        	
      	        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
      	        }
      	        if(prpDriskDtos != null && prpDriskDtos.size()>0){
      	        	for(int i=0;i<prpDriskDtos.size();i++){
      	        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
      	        		riskcodeStr += prpDriskDto.getRiskCode()+";";
      	        	}
      	        }
      	        //��89��ģ�������  end===
      	        
        		if("0310".equals(riskcode)||"0312".equals(riskcode)|| riskcodeStr.indexOf(riskcode)>0 )
        		{
        			workFlowDto = getBackFlowInfoByVeriffor0310(user,flowID,logNo,swfLogFunctionInDto);
        		}
        		else
        		{
        			  workFlowDto = getBackFlowInfoByVerif(user,flowID,logNo,swfLogFunctionInDto);
        		}
                //ָ���˻ؽڵ�(����ǰLogNo�𼶵ݼ��ҵ���һ��Ҫ�˻صĽڵ�) ����ר��
        	  
        		
            	 
            }
        }else{
        	//���ݹ�������־swflog����л��ˣ����˻��Ե�ǰ�ڵ�logNoΪ�յ���������logNo��Ӧ�Ľڵ�
        	workFlowDto = getBackFlowInfo(user, flowID, logNo);
        }
		    	
	    return workFlowDto; 
	}
    
    /**
        * ���˵Ĺ�����(����ģ����л���)
        * @param httpServletRequest HttpServletRequest
        * @param flowID String ���������̱���
        * @param logNo int     ����������˳���
        * @param keyOut String ��¼�½ڵ��KeyOut��ֵ�������˻ص����ݾͿ���ֱ�Ӱ�ҵ��ĺ����޸�
        * @throws Exception
        * @return WorkFlowDto
        */
       public WorkFlowDto getBackFlowInfo(HttpServletRequest httpServletRequest,String flowID,int logNo,String keyOut)
        throws Exception
    {
      //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
      /*---1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��*/
      HttpSession session = httpServletRequest.getSession();
      UserDto   user     = (UserDto)session.getAttribute("user");
      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      WorkFlowDto workFlowDto = new WorkFlowDto();
      /*---2.��ѯ��ǰ�ڵ㹤��������-*/
      SwfLogDto swfLogDto = new SwfLogDto();
      swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID,logNo) ;
      /*---3.ȡ��������ģ���*/
      int modelNo= swfLogDto.getModelNo() ;
      int nodeNo = swfLogDto.getNodeNo() ;
      /*4.---------------------��ѯ�ڵ��wfNode�Ķ���------------------------------------*/
      //��ѯ�˽ڵ�ǰ�����еĽڵ���Ϣ
      Collection swfNodeDtoList = new ArrayList();
      swfNodeDtoList = uiWorkFlowAction.findModelPerviousNodes(modelNo,nodeNo);
      //��������ݿ�
      if (swfNodeDtoList!=null)
      {
          Iterator it =swfNodeDtoList.iterator() ;
          //��ȡwflog����flowID������logno�Ŀ�ʼֵ
          int llogNo=uiWorkFlowAction.getSwfLogMaxLogNo(flowID) ;
          int pathNo =uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);
          ArrayList swfLogDtoList = new ArrayList();
          ArrayList swfPathLogDtoList = new ArrayList();

          while (it.hasNext())
          {
          SwfNodeDto swfNodeDto = new SwfNodeDto();
          swfNodeDto =(SwfNodeDto) it.next() ;
          /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
          SwfLogDto swfLogDtoTemp =new SwfLogDto()  ;
          //���ݶ��壬��ԭ���Ľڵ������γ��µĽڵ�

          getSwfLogDtoInfoBySwfNode(swfLogDtoTemp,swfNodeDto,user,flowID,modelNo,llogNo,"7",swfLogDto.getBusinessNo(),swfLogDto);
          //���˲������е�����,���ǻ��˲������Ǹ�����˭��??
          swfLogDtoTemp.setKeyOut(keyOut);
          swfLogDtoTemp.setHandleDept(swfLogDto.getHandleDept() );
          swfLogDtoTemp.setHandlerCode(swfLogDto.getBeforeHandlerCode() );
          swfLogDtoTemp.setHandlerName(swfLogDto.getBeforeHandlerName() );
          swfLogDtoTemp.setHandleTime(swfLogDto.getHandleTime()) ;
          
          
          swfLogDtoList.add(swfLogDtoTemp);
          /*7.---------------------д�����߱�wfPathLog------------------------------------*/
          SwfPathLogDto swfPathLogDto =new SwfPathLogDto()  ;
          getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogDto,swfLogDtoTemp,flowID,modelNo,pathNo);
          swfPathLogDtoList.add(swfPathLogDto);

          llogNo ++;
          pathNo ++ ;
         }
         //�ӵ�Dto��
         workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
         workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
         workFlowDto.setSubmit(true);
         swfLogDto.setNodeStatus("5");//����Ϊ�ѻ���
         workFlowDto.setUpdate(true);
         workFlowDto.setUpdateSwfLogDto(swfLogDto);

      }
       return workFlowDto;
    }
       
    /**
        * ���˵Ĺ�����(���ݹ�������־swflog����л��ˣ����˻��Ե�ǰ�ڵ�logNoΪ�յ���������logNo��Ӧ�Ľڵ�)
        * @param httpServletRequest HttpServletRequest
        * @param flowID String ���������̱���
        * @param logNo int     ����������˳���        
        * @throws Exception
        * @return WorkFlowDto
        */
       public WorkFlowDto getBackFlowInfo(UserDto user,String flowID,int logNo)
        throws Exception
    {
      //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
      /*---1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��*/

      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      WorkFlowDto workFlowDto = new WorkFlowDto();
      /*---2.��ѯ��ǰ�ڵ㹤��������-*/
      SwfLogDto swfLogDto = new SwfLogDto();
      swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID,logNo) ;

      /*---3.ȡ��������ģ���*/
      int modelNo=swfLogDto.getModelNo() ;
      /*4.---------------------��ѯ�ڵ��swfPath������Ӧ���ϸ��ڵ�Ķ���------------------------------------*/
      //��ѯ�˽ڵ�ǰ�����еĽڵ���Ϣ
      Collection swfLogDtoBackList = new ArrayList();
      swfLogDtoBackList = uiWorkFlowAction.findPerviousNodes(flowID,logNo);
      //��������ݿ�
      if (swfLogDtoBackList!=null)
      {
          Iterator it =swfLogDtoBackList.iterator() ;
          //��ȡwflog����flowID������logno�Ŀ�ʼֵ
          int llogNo=uiWorkFlowAction.getSwfLogMaxLogNo(flowID) ;
          int pathNo =uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);
          ArrayList swfLogDtoList = new ArrayList();
          ArrayList swfPathLogDtoList = new ArrayList();

          while (it.hasNext())
          {
          SwfLogDto swfLogDtoTemp =new SwfLogDto()  ;
          swfLogDtoTemp =(SwfLogDto) it.next() ;
          /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
          //���ݶ��壬��ԭ���Ľڵ������γ��µĽڵ�
          swfLogDtoTemp.setLogNo(llogNo);
          //modify by weishixin modify 20050227 start
          //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
          swfLogDtoTemp.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
          //modify by weishixin modify 20050227 end
          swfLogDtoTemp.setNodeStatus("3");//��ʾ�˻ص�
          //���ýڵ������
          String titleAttr =swfLogDtoTemp.getNodeName()+"�ڵ�"+"����ʱ�䣺"+swfLogDto.getFlowInTime() +" ��һ�ڵ������:"+ user.getUserName() ;
          swfLogDtoTemp.setTitleStr(titleAttr);
          swfLogDtoTemp.setBeforeHandlerCode(user.getUserCode()) ;
          swfLogDtoTemp.setBeforeHandlerName(user.getUserName()) ;

          swfLogDtoList.add(swfLogDtoTemp);
          //���˲������е�����,���ǻ��˲������Ǹ�����˭��??
          /*7.---------------------д�����߱�wfPathLog------------------------------------*/
          SwfPathLogDto swfPathLogDto =new SwfPathLogDto()  ;
          getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogDto,swfLogDtoTemp,flowID,modelNo,pathNo);
          swfPathLogDtoList.add(swfPathLogDto);

          llogNo ++;
          pathNo ++ ;
         }
       //�ӵ�Dto��
         workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
         workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
         workFlowDto.setSubmit(true);
         swfLogDto.setNodeStatus("5");//����Ϊ�ѻ���
         //modify by weishixin modify 20050227 start
          //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
         swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());//�ύʱ��
         //modify by weishixin modify 20050227 end

         workFlowDto.setUpdate(true);
         workFlowDto.setUpdateSwfLogDto(swfLogDto);

      }
       return workFlowDto;
    }
       /**
        * ���˵Ĺ�����(����ָ���Ľڵ����)
        * @param httpServletRequest HttpServletRequest
        * @param flowID String ���������̱���
        * @param logNo int     ����������˳���        
        * @throws Exception
        * @return WorkFlowDto
        */
       public WorkFlowDto getBackFlowInfoByNextNodeList(UserDto user,String flowID,int logNo,SwfLogDto swfLogFunctionInDto)
        throws Exception
    {
      //˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
      /*---1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��*/

      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
      WorkFlowDto workFlowDto = new WorkFlowDto();
      /*---2.��ѯ��ǰ�ڵ㹤��������-*/
      SwfLogDto swfLogDto = new SwfLogDto();
      swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID,logNo) ;
      
      
      //���չ��������ʱ��,�����˻ص�ʱ��,��ҵ�պͽ�ǿ��ͬʱ�˻�
      SwfLogDto swfLogDto2 = null;
      if(swfLogDto.getNodeType().equals("compe")){
    	  String condition = "flowID ='" + flowID + "' and nodetype='compe' and nodestatus < '4' and flowstatus != '0'";
    	  Collection swfLogList = uiWorkFlowAction.findNodesByConditions(condition);
    	  Iterator itSwf = swfLogList.iterator();
    	  while(itSwf.hasNext()){
    		  SwfLogDto tmpSwfLog = (SwfLogDto)itSwf.next();
    		  if(tmpSwfLog.getLogNo() != logNo){
    			  swfLogDto2 = tmpSwfLog;
    			  break;
    		  }
    	  }
      }
      
      /*---3.ȡ��������ģ���*/
      int modelNo=swfLogDto.getModelNo() ;
      /*4.---------------------��ѯ�ڵ��swfPath������Ӧ���ϸ��ڵ�Ķ���------------------------------------*/
      //�����ָ���ڵ㿪ʼ�����
      Collection swfNodeNextList = swfLogFunctionInDto.getSwfLogList();
      if (swfNodeNextList!=null)
      {
          Iterator it =swfNodeNextList.iterator() ;
          //��ȡwflog����flowID������logno�Ŀ�ʼֵ
          int llogNo=uiWorkFlowAction.getSwfLogMaxLogNo(flowID) ;
          int pathNo =uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);
          ArrayList swfLogDtoList = new ArrayList();
          ArrayList swfPathLogDtoList = new ArrayList();
          //����ָ���Ľڵ�Ž��л��˵Ĳ�����
          while (it.hasNext())
          {
          	SwfLogDto swfLogDtoTemp =	new SwfLogDto()  ; //�ⲿ����
          	swfLogDtoTemp=(SwfLogDto) it.next() ;
          /*6.---------------------д���̽ڵ��wfLog------------------------------------*/
          //���ݶ��壬��ԭ���Ľڵ������γ��µĽڵ�
          swfLogDtoTemp.setLogNo(llogNo);
          //modify by weishixin modify 20050227 start
          //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
          swfLogDtoTemp.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());
          swfLogDtoTemp.setHandleTime (swfLogDtoTemp.getFlowInTime());
          
          swfLogDtoTemp.setSubmitTime("" );
          //modify by weishixin modify 20050227 end
          swfLogDtoTemp.setNodeStatus("3");//��ʾ�˻ص�
          //���ýڵ������
          String titleAttr =swfLogDtoTemp.getNodeName()+"�ڵ�"+"����ʱ�䣺"+swfLogDto.getFlowInTime() +" ��һ�ڵ������:"+ user.getUserName() ;
          swfLogDtoTemp.setTitleStr(titleAttr);
          swfLogDtoTemp.setBeforeHandlerCode(user.getUserCode()) ;
          swfLogDtoTemp.setBeforeHandlerName(user.getUserName()) ;
          //���ô��ĸ��ڵ���˵ı�־
          swfLogDtoTemp.setBusinessType( swfLogDto.getNodeType() );//�����²����Ľڵ�֪���Ǵ������˻�����
          swfLogDtoList.add(swfLogDtoTemp);
          //���˲������е�����,���ǻ��˲������Ǹ�����˭��??
          /*7.---------------------д�����߱�wfPathLog------------------------------------*/
          SwfPathLogDto swfPathLogDto =new SwfPathLogDto()  ;
          getSwfPathLogDtoInfoBySwfLog(swfPathLogDto,swfLogDto,swfLogDtoTemp,flowID,modelNo,pathNo);
          swfPathLogDtoList.add(swfPathLogDto);
          if(swfLogDto2 != null){
        	  pathNo ++ ;
        	  SwfPathLogDto swfPathLogDto2 =new SwfPathLogDto()  ;
              getSwfPathLogDtoInfoBySwfLog(swfPathLogDto2,swfLogDto2,swfLogDtoTemp,flowID,modelNo,pathNo);
              swfPathLogDtoList.add(swfPathLogDto2);
              
          }

          llogNo ++;
          pathNo ++ ;
         }
       //�ӵ�Dto��
         workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
         workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
         workFlowDto.setSubmit(true);
         swfLogDto.setNodeStatus("5");//����Ϊ�ѻ���
         //modify by weishixin modify 20050227 start
          //reason:���ڸĳ�ʱ����󣬴�������Ҳ��YEAR_TO_SECOND
         swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());//�ύʱ��
         //modify by weishixin modify 20050227 end

         workFlowDto.setUpdate(true);
         workFlowDto.setUpdateSwfLogDto(swfLogDto);
         if(swfLogDto2 != null){
        	  swfLogDto2.setNodeStatus("5");//����Ϊ�ѻ���
              swfLogDto2.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND).toString());//�ύʱ��
              workFlowDto.setUpdateSwfLog2Dto(swfLogDto2);
         }
      }
       return workFlowDto;
    }


       /**
        * ���˵Ĺ�����(ָ���˻ؽڵ�,����ǰLogNo�𼶵ݼ��ҵ���һ��Ҫ�˻صĽڵ�)
        * @param httpServletRequest HttpServletRequest
        * @param flowID String ���������̱���
        * @param logNo int     ����������˳���
        * @param swfLogFunctionInDto SwfLogDto 
        * @throws Exception
        * @return WorkFlowDto
        */
       public WorkFlowDto getBackFlowInfoByVerif(UserDto user,String flowID,int logNo,SwfLogDto swfLogFunctionInDto)
        throws Exception
    {
		//˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
		/*---1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��*/

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		WorkFlowDto workFlowDto = new WorkFlowDto();
		/*---2.��ѯ��ǰ�ڵ㹤��������-*/
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID, logNo);

        /*---3.ȡ��������ģ���*/
		int modelNo = swfLogDto.getModelNo();

		/* 4.---------------------��ѯ��һ��Ҫ���˵Ľڵ�����Ӧ��swflog------------------------------------ */
		//��ѯ�˽ڵ�ǰ�����еĽڵ���Ϣ
		SwfLogDto swfLogNextNode = new SwfLogDto();
		
		//��ѯ��һ��Ҫ���˵Ľڵ�����Ӧ��swflog����LogNo�𼶵ݼ��ҵ���һ��Ҫ���˵Ľڵ㣩
		for (int i = logNo - 1; i > 0; i--) {
			swfLogNextNode = uiWorkFlowAction.findNodeByPrimaryKey(flowID, i);
			if (swfLogNextNode.getNodeType().trim().equals(
					swfLogFunctionInDto.getNodeType()) && swfLogNextNode.getLossItemCode().trim().equals(
							swfLogFunctionInDto.getLossItemCode().trim())) {
				break;
			}
		}
				
		/* 5.---------------------��ȡwflog����flowID������logno�Ŀ�ʼֵ-----------*/
		int llogNo = uiWorkFlowAction.getSwfLogMaxLogNo(flowID);
		int pathNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);
		ArrayList swfLogDtoList = new ArrayList();
		ArrayList swfPathLogDtoList = new ArrayList();

		/* 6.---------------------д���̽ڵ��wfLog------------------------------------ */
		//���ݶ��壬��ԭ���Ľڵ������γ��µĽڵ�
		swfLogNextNode.setLogNo(llogNo);
		swfLogNextNode.setFlowInTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());
		swfLogNextNode.setSubmitTime("");
		swfLogNextNode.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
		swfLogNextNode.setNodeStatus("3");//��ʾ�˻ص�
		//���ýڵ������
		String titleAttr = swfLogNextNode.getNodeName() + "�ڵ�" + "����ʱ�䣺"
				+ swfLogDto.getFlowInTime() + " ��һ�ڵ������:" + user.getUserName();
		swfLogNextNode.setTitleStr(titleAttr);
		swfLogNextNode.setBeforeHandlerCode(user.getUserCode());
		swfLogNextNode.setBeforeHandlerName(user.getUserName());
		//���𻷽��˻ص�����д���˻�Դ�ڵ�
		if ( swfLogFunctionInDto.getBusinessType()!=null && !swfLogFunctionInDto.getBusinessType().equals("")) {
			swfLogNextNode.setBusinessType(swfLogFunctionInDto.getBusinessType());
		}

        swfLogDtoList.add(swfLogNextNode);
		
		/*7.---------------------д�����߱�wfPathLog------------------------------------*/
		SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
		getSwfPathLogDtoInfoBySwfLog(swfPathLogDto, swfLogDto, swfLogNextNode,
				flowID, modelNo, pathNo);
		swfPathLogDtoList.add(swfPathLogDto);

		//�ӵ�Dto��
		workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
		workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
		workFlowDto.setSubmit(true);
		swfLogDto.setNodeStatus("5");//����Ϊ�ѻ���
		swfLogDto.setSubmitTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());//�ύʱ��

		workFlowDto.setUpdate(true);
		workFlowDto.setUpdateSwfLogDto(swfLogDto);

		return workFlowDto;
    }

       
       public WorkFlowDto getBackFlowInfoByVeriffor0310(UserDto user,String flowID,int logNo,SwfLogDto swfLogFunctionInDto)
       throws Exception
   {
		//˼·�����ݵ�ǰ�ڵ����Ϣ����������Ľڵ㡣���γ��µ�wfLog����,wfpathLog������
		/*---1�� ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��*/

		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		WorkFlowDto workFlowDto = new WorkFlowDto();
		/*---2.��ѯ��ǰ�ڵ㹤��������-*/
		SwfLogDto swfLogDto = new SwfLogDto();
		swfLogDto = uiWorkFlowAction.findNodeByPrimaryKey(flowID, logNo);

       /*---3.ȡ��������ģ���*/
		int modelNo = swfLogDto.getModelNo();

		/* 4.---------------------��ѯ��һ��Ҫ���˵Ľڵ�����Ӧ��swflog------------------------------------ */
		//��ѯ�˽ڵ�ǰ�����еĽڵ���Ϣ
		
		SwfLogDto swfLogNextNode = new SwfLogDto();
		//��ѯ��һ��Ҫ���˵Ľڵ�����Ӧ��swflog����LogNo�𼶵ݼ��ҵ���һ��Ҫ���˵Ľڵ㣩
		for (int i = logNo - 1; i > 0; i--) {
			swfLogNextNode = uiWorkFlowAction.findNodeByPrimaryKey(flowID, i);
			if (swfLogNextNode.getNodeType().trim().equals(
					swfLogFunctionInDto.getNodeType())) {
				break;
			}
		}
				
		/* 5.---------------------��ȡwflog����flowID������logno�Ŀ�ʼֵ-----------*/
		int llogNo = uiWorkFlowAction.getSwfLogMaxLogNo(flowID);
		int pathNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(flowID);
		ArrayList swfLogDtoList = new ArrayList();
		ArrayList swfPathLogDtoList = new ArrayList();

		/* 6.---------------------д���̽ڵ��wfLog------------------------------------ */
		//���ݶ��壬��ԭ���Ľڵ������γ��µĽڵ�
		swfLogNextNode.setLogNo(llogNo);
		swfLogNextNode.setFlowInTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());
		swfLogNextNode.setHandleTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());
		swfLogNextNode.setSubmitTime("");
		swfLogNextNode.setNodeStatus("3");//��ʾ�˻ص�
		//���ýڵ������
		String titleAttr = swfLogNextNode.getNodeName() + "�ڵ�" + "����ʱ�䣺"
				+ swfLogDto.getFlowInTime() + " ��һ�ڵ������:" + user.getUserName();
		swfLogNextNode.setTitleStr(titleAttr);
		swfLogNextNode.setBeforeHandlerCode(user.getUserCode());
		swfLogNextNode.setBeforeHandlerName(user.getUserName());
		//���𻷽��˻ص�����д���˻�Դ�ڵ�
		if ( swfLogFunctionInDto.getBusinessType()!=null && !swfLogFunctionInDto.getBusinessType().equals("")) {
			swfLogNextNode.setBusinessType(swfLogFunctionInDto.getBusinessType());
		}

       swfLogDtoList.add(swfLogNextNode);
		
		/*7.---------------------д�����߱�wfPathLog------------------------------------*/
		SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
		getSwfPathLogDtoInfoBySwfLog(swfPathLogDto, swfLogDto, swfLogNextNode,
				flowID, modelNo, pathNo);
		swfPathLogDtoList.add(swfPathLogDto);

		//�ӵ�Dto��
		workFlowDto.setSubmitSwfLogDtoList(swfLogDtoList);
		workFlowDto.setSubmitSwfPathLogDtoList(swfPathLogDtoList);
		workFlowDto.setSubmit(true);
		swfLogDto.setNodeStatus("5");//����Ϊ�ѻ���
		swfLogDto.setSubmitTime(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND).toString());//�ύʱ��

		workFlowDto.setUpdate(true);
		workFlowDto.setUpdateSwfLogDto(swfLogDto);

		return workFlowDto;
   }
    /*========================�������������������������============================*/

 }
