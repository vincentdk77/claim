
package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * <p>Title: AccidentWorkFlowEngineViewHelper</p>c
 * <p>Description:����������ViewHelper�࣬�ڸ��������ҳ�����ݵ����� ע������רΪ�⽡��ʹ��</p>
 * <p>Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004</p>
 * @author ����������Ŀ�� wangli
 * @version 1.0
 * <br>
 */
public class AccidentWorkFlowEngineViewHelper extends WorkFlowEngineViewHelper{

	
	
	public AccidentWorkFlowEngineViewHelper(){
		
	}
	
	
	
	
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
	 	
	    System.out.println("2222222 begin-------------------------"); 
	      //ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��Dto��
	      WorkFlowDto workFlowDto = new WorkFlowDto();
	      WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
	      SwfLogDto   swfLogDto   = null;
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
	      if (swfLogDto.getTaskType().equals("M")) {
	      	//System.out.println("This is father  M code%%%%%%%%%%%%%%%%%%%%%%%% :"); 
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
	          System.out.println("���������û�нڵ�ġ�����ֱ���׳�");
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
	        System.out.println("swfLogFunctionInDto.getEndFlag()"+swfLogFunctionInDto.getEndFlag());
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

	        System.out.println("������״̬" + workFlowDtoTemp.getStatus());
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
	        //Ŀǰֻ�к�����õõ������������ﶨ�𣬲�����Ա���ϸ��ڵ��ϵ���Ա
	        //���Ȳ��Ҷ���Ľڵ㣬�ӻ��˵Ľڵ��ϲ�ѯ����Ϊ����Ľڵ㣬��������ΪtypeFlag��ͬ�Ľڵ�
	        //�ɺ���ǰ���в�ѯ����Ŀǰֻ�к�������˺���������
	        if (swfLogDto.getNodeType().equals("verif") || swfLogDto.getNodeType().equals("veriw")) //������˻�
	        {
	          workFlowDto=getBackFlowInfo(user,swfLogDto.getFlowID() ,swfLogDto.getLogNo() );
	        }else
	        {
	            throw new UserException(1,3,"������","û�з��ֿ��Ի��˵Ĺ������ڵ�");
	        }
	     }
	   }
	    System.out.println("2222222 end-------------------------"); 
	    
	 return workFlowDto;
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
	    //	System.out.println("222222222    swfLogDto.getNodeType()= "+swfLogDto.getNodeType());
	    //	System.out.println("222222222    swfLogFunctionIn.getKeyIn()= "+swfLogFunctionIn.getKeyIn());
	       UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
	       WorkFlowDto workFlowDto = new WorkFlowDto();
	       WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
	       //�����ǰ�ڵ��״̬

	       //��ʱ������ǰ�����ڵ����Ϣ,��Ϊ���������ύ����ĵ�ǰ�ڵ�����
	       SwfLogDto swfLogDtoTemp = new SwfLogDto();
	       swfLogDtoTemp = swfLogDto;
	    //   System.out.println("2222222  swfLogDto.getEndFlag()"+swfLogDto.getEndFlag()+"����");
	        //����н�����־�ĵ㣬���ۺ������κε����ã���Ҫ���������������ж�����Ľڵ�͹�ϵ�ȵ�
	       if (swfLogDto.getEndFlag().equals("1"))
	       {
	            //����������
	            //���Ƚ����ýڵ�ǰ��ʧ��ڵ� ,Ϊ�����ף��Ȳ�ѯ�����̵�taskType='M'���͵Ľ�����
	            System.out.println("swfLogDto.getEndFlag()"+swfLogDto.getEndFlag()+"����2");
	            workFlowDto.setUpdate(true);
	            swfLogDtoTemp.setHandlerCode(user.getUserCode() );
	            swfLogDtoTemp.setHandlerName(user.getUserName() );
	            workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
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
	           {
	       //    	System.out.println("222222222 warning : go to compp 333333333");
	           	// swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	            swfLogDto.setBusinessNo(swfLogFunctionIn.getKeyIn());
	            //swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	            }
	          swfLogDto.setNextBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	         //  swfLogDto.setNextBusinessNo(swfLogFunctionIn.getKeyIn());
	           //�ύ������ba
	           //������Щ�ڵ��keyin keyout�����ϸ��ڵ�����룬����ֻ�õ�����keyin
	           //�ж��ǲ����˵��˵��ύ,�������õı�־nextNodeListType
	           if (swfLogFunctionIn.getNextNodeListType().equals("1") )
	         {
	           //֧��ָ����
	       //    System.out.println("22222222ָ���ڵ����Ϣ");

	           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn,logNo,pathNo) ;
	         }  else
	         { //֧�ִ�ģ����ȡ��
	      //   	System.out.println("222222222ָ��ģ����ȡ�õ���Ϣ");
	           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn.getKeyIn() ,logNo,pathNo) ;
	         }

	           //���ô�����Ա
	           swfLogDtoTemp.setHandlerCode(user.getUserCode() );
	           swfLogDtoTemp.setHandlerName(user.getUserName() );
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
	   

}
