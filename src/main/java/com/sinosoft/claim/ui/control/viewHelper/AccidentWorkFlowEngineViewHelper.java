
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
 * <p>Description:工作流引擎ViewHelper类，在该类中完成页面数据的整理 注：此类专为意健险使用</p>
 * <p>Copyright: Copyright 中科软科技股份有限公司(c) 2004</p>
 * @author 车险理赔项目组 wangli
 * @version 1.0
 * <br>
 */
public class AccidentWorkFlowEngineViewHelper extends WorkFlowEngineViewHelper{

	
	
	public AccidentWorkFlowEngineViewHelper(){
		
	}
	
	
	
	
	/**
	    * 操作工作流的数据整理,此函数就是所有工作流流转的引擎入口，
	    * 想知道工作流是如何运转的，从这个函数看起吧。
	    * @param user UserDto 用户dto
	    * @param swfLogFunctionInDto 传参数
	    * @throws Exception
	    * @return WorkFlowDto 工作流程数据传输数据结构
	    */
	 
	 public WorkFlowDto viewToDto(UserDto user,SwfLogDto swfLogFunctionInDto) throws Exception
	    {
	 	
	    System.out.println("2222222 begin-------------------------"); 
	      //取得当前用户信息，写操作员信息到Dto中
	      WorkFlowDto workFlowDto = new WorkFlowDto();
	      WorkFlowDto workFlowDtoTemp = new WorkFlowDto();
	      SwfLogDto   swfLogDto   = null;
	      Collection  swfFlowNodeList  = new ArrayList();
	      ArrayList   submitLogList  = new ArrayList();
	      ArrayList   submitPathLogList  = new ArrayList();
	      UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
	      
	      String swfLogFlowID=swfLogFunctionInDto.getFlowID(); //流程号码
	      int swfLogLogNo=swfLogFunctionInDto.getLogNo();      //流程中的节点号码
	      //一般以上两个是必须的
	      String nodeStatus=swfLogFunctionInDto.getNodeStatus();  //操作是哪种 2,4,5,3目前只有这几种 
	      String nextBusinessNo = swfLogFunctionInDto.getNextBusinessNo() ;
	      String keyIn =swfLogFunctionInDto.getKeyIn() ;
	      
	     
	      String keyOut=swfLogFunctionInDto.getKeyOut() ;
	      
	     //--------------------创建工作流用的参数--------------------//
	      boolean createWorkFlow=swfLogFunctionInDto.getCreateFlow() ; //True 创建工作流功能
	      String riskCode = swfLogFunctionInDto.getRiskCode() ;
	      String comCode =swfLogFunctionInDto.getComCode() ;
	      String policyNo = swfLogFunctionInDto.getPolicyNo() ;
	     //--------------------创建工作流用的参数--------------------//
	      
	      String businessNo = swfLogFunctionInDto.getBusinessNo()  ;//只有当flowid没有时起作用
	      String nodeType=swfLogFunctionInDto.getNodeType() ;     //如果为T类型或者没有flowid时有用
	      
	      String conditionBusinessNo = swfLogFunctionInDto.getConditionBusinessNo();
	      String typeFlag = swfLogFunctionInDto.getTypeFlag() ;
	      String handlerRange=swfLogFunctionInDto.getHandlerRange(); //下一节点人员操作级别
	      String exigenceGree=swfLogFunctionInDto.getExigenceGree(); //下一节点紧急程度级别
	      

	      //如果是利用的如上方法，则只需要查询工作流节点中的内容就可以了
	      int logMaxNo=0;  //解决取LogNo号的问题
	      int pathMaxNo=0; //解决取pathNo号的问题

	    //1.创建工作流程/查找流程信息
	    if (createWorkFlow) {
	      workFlowDto = createFlowInfo(user, businessNo,comCode, riskCode,policyNo,swfLogFunctionInDto.getInsuredName(),swfLogFunctionInDto.getLossItemName());
	      if (workFlowDto.getOperateResult() <0)
	      {
	        //没有取得模板的号码
	        return workFlowDto;
	      }

	      //设置当前节点的内容
	      swfLogDto = workFlowDto.getCreateSwfLogDto();
	      logMaxNo = 2;
	      pathMaxNo = 1;
	    }
	    else { //查询出工作流数据/查找当前节点
	      if (!swfLogFlowID.equals("")&& swfLogLogNo>0){  //利用主键flowid,LogNo查工作节点
	      swfFlowNodeList = uiWorkFlowAction.findCurrentNode(swfLogFlowID, swfLogLogNo);
	      }else
	      {//利用主键businessNo, nodeType查工作节点
	      swfFlowNodeList = uiWorkFlowAction.findCurrentNode(businessNo, nodeType);
	      }
	      if (swfFlowNodeList.iterator().hasNext()) {
	        //获得当前工作流程的信息
	        swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	        //并取得工作流上点和边的最大号码
	        logMaxNo = uiWorkFlowAction.getSwfLogMaxLogNo(swfLogDto.getFlowID());
	        pathMaxNo = uiWorkFlowAction.getSwfPathLogMaxPathNo(swfLogDto.getFlowID());

	      }
	    }
	    //工作流判断是否可以操作
	    if (swfLogDto != null) { //有工作流程查询出来
	    //要判断工作流程是否结束，如果结束了，下面的都不需要操作的
	    if (uiWorkFlowAction.checkFlowClose(swfLogDto.getFlowID() ))
	      {
	          //工作流已经关闭了
	          workFlowDto.setCheckClose(true);
	          return workFlowDto;
	       }
	    //判断是不是要创建创建子任务，以后都相同的M类型任务的处理 M创建后，和正常的流程是一样的
	      if (swfLogDto.getTaskType().equals("M")) {
	      	//System.out.println("This is father  M code%%%%%%%%%%%%%%%%%%%%%%%% :"); 
	        //创建子任务过程
	        swfLogDto.setBusinessNo(nextBusinessNo);
	       
	        swfLogDto.setKeyIn(businessNo);
	        workFlowDtoTemp = getSubmitFlowInfo(user, swfLogDto, keyIn, logMaxNo,
	                                            pathMaxNo);
	        logMaxNo=logMaxNo+1;
	        pathMaxNo=pathMaxNo+1;

	        workFlowDto.setSubmit(true);
	        workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
	        workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
	        //设置创建的子任务为当前的需要处理的任务节点
	        swfFlowNodeList.clear();
	        swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();

	        if (swfFlowNodeList.iterator().hasNext()) {
	          swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	          swfLogDto.setHandlerCode(user.getUserCode());
	          swfLogDto.setHandlerName(user.getUserName());
	          //M类型出来的子节点直接设置keyOut,不管是否提交
	          swfLogDto.setKeyOut(keyOut);
	        }
	      }
	       //传入的参数类型为T特殊类型的节点
	       if (swfLogFunctionInDto.getTaskType().equals("T")) {
	         //创建新节点
	         //为T类型的节点可以正常的走普通路径，所以做标志判断的时候该用其他内部标志，表示T类型，比如AddNewNode等同于T
	        swfLogDto.setTaskType("AddNewNode");
	        workFlowDtoTemp = getSubmitFlowInfo(user, swfLogDto, keyIn, logMaxNo,
	                                            pathMaxNo);
	      
	        System.out.println("查询提交的数据"+swfLogDto.getLogNo()  );
	        if (workFlowDtoTemp.getSubmitSwfLogDtoList()==null)
	        {//查出后续是没有节点的。。。直接抛出
	          System.out.println("查出后续是没有节点的。。。直接抛出");
	          return workFlowDto;
	        }
	        
	        //因为节点产生了，所以增加了
	        logMaxNo=logMaxNo+1;
	        pathMaxNo=pathMaxNo+1;
	        workFlowDto.setSubmit(true);
	        workFlowDto.setSubmitSwfLogDtoList(workFlowDtoTemp.getSubmitSwfLogDtoList());
	        workFlowDto.setSubmitSwfPathLogDtoList(workFlowDtoTemp.getSubmitSwfPathLogDtoList());
	        //设置创建的子任务为当前的需要处理的任务节点
	        swfFlowNodeList.clear();
	        swfFlowNodeList = workFlowDto.getSubmitSwfLogDtoList();

	        if (swfFlowNodeList.iterator().hasNext()) {
	          swfLogDto = (SwfLogDto) swfFlowNodeList.iterator().next();
	          swfLogDto.setHandlerCode(user.getUserCode());
	          swfLogDto.setHandlerName(user.getUserName());

	          swfLogDto.setTypeFlag(typeFlag);//因为回勘的要求
	          //T类型出来的子节点直接设置keyOut,不管是否提交
	          swfLogDto.setKeyOut(keyOut);
	        }
	       }
	       //做判断提交，如果不可以提交，那就改为保存操作

	      //2.修改工作流0/1/2/3都是修改工作流
	      if (nodeStatus.equals("0") || nodeStatus.equals("1") ||
	          nodeStatus.equals("2") || nodeStatus.equals("3")) {
	        //修改工作流
	        swfLogDto.setNodeStatus(nodeStatus);
	        swfLogDto.setHandlerCode(user.getUserCode());
	        swfLogDto.setHandlerName(user.getUserName());
	        swfLogDto.setKeyOut(keyOut);
	        //modify by weishixin modify 20050227 start
	        //reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
	        swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
	        //modify by weishixin modify 20050227 end
	        if (typeFlag!=null&&typeFlag.length()>0)
	        {
	        swfLogDto.setTypeFlag(typeFlag);
	        }
	        //如果是M类型的接点，则不需要处理update情况//优化工作流
	        if (workFlowDto.getSubmit()) {
	          ArrayList submitLogMList = new ArrayList();
	          submitLogMList.add(swfLogDto);
	          workFlowDto.setSubmitSwfLogDtoList(submitLogMList);
	      }
	        else {
	          //判断当前信息中是否有工作流的存在。。
	          if (swfLogDto.getLogNo() > 0) {
	            workFlowDto.setUpdate(true);
	            workFlowDto.setUpdateSwfLogDto(swfLogDto);
	          }

	        }
	      }
	      
	      //3。提交工作流
	      if (nodeStatus.equals("4")) {
	        //判断是否需要人为的结束,人为结束只要设置传入的参数为endflag=1就行了。
	        System.out.println("swfLogFunctionInDto.getEndFlag()"+swfLogFunctionInDto.getEndFlag());
	        if (swfLogFunctionInDto.getEndFlag().equals("1") )
	        {
	        swfLogDto.setEndFlag("1");
	        }
	        //判断是否允许节点能提交？？这个在页面上已经进行判断了
	        //WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper ();
	        //workFlowViewHelper.checkNodeSubmit(swfLogDto);
	       
	        //修改工作流nodeStatus=4
	        swfLogDto.setNodeStatus(nodeStatus);
	        swfLogDto.setKeyOut(keyOut);  //
	        //设置提交的时间
	        //modify by weishixin modify 20050227 start
	        //reason:日期改成时分秒后，存入数据也是YEAR_TO_SECOND
	        swfLogDto.setSubmitTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()) ;
	        //modify by weishixin modify 20050227 end
	        //还需要设置条件
	        swfLogDto.setConditionBusinessNo(conditionBusinessNo);
	        //设置是否有typeFlag
	        if ((typeFlag!=null) && (typeFlag.length()>0))
	        {
	          swfLogDto.setTypeFlag(typeFlag) ;
	        }
	        //正是做提交的操作

	        workFlowDtoTemp = submitWorkFlow(user, swfLogDto, swfLogFunctionInDto,
	                                          logMaxNo,
	                                          pathMaxNo);

	        workFlowDto.setUpdate(workFlowDtoTemp.getUpdate());
	        workFlowDto.setUpdateSwfLogDto(workFlowDtoTemp.getUpdateSwfLogDto());
	        
	        submitLogList = workFlowDtoTemp.getSubmitSwfLogDtoList();
	        if (submitLogList==null) submitLogList = new ArrayList(); //考虑到有时候提交后面是空的,允许的
	        submitPathLogList = workFlowDtoTemp.getSubmitSwfPathLogDtoList();
	        if (submitPathLogList==null) submitPathLogList = new ArrayList(); //考虑到有时候提交后面是空的,允许的
	        //原来有新增加的数据，需要合并的节点和路径的这里是优化，前面进行M和T操作形成的新节点。
	        if (workFlowDto.getSubmit()) {
	          Iterator it = workFlowDto.getSubmitSwfLogDtoList().iterator();
	          while (it.hasNext()) {
	            submitLogList.add(it.next());
	          }

	          Iterator it1 = workFlowDto.getSubmitSwfPathLogDtoList().iterator();
	          while (it1.hasNext()) {
	            submitPathLogList.add(it1.next());
	          }

	          //如果已经有提交的数据了
	        }
	        
	        workFlowDto.setSubmit(workFlowDtoTemp.getSubmit());
	        workFlowDto.setSubmitSwfLogDtoList(submitLogList);
	        workFlowDto.setSubmitSwfPathLogDtoList(submitPathLogList);
	        workFlowDto.setClose(workFlowDtoTemp.getClose());
	        workFlowDto.setCloseSwfFlowMainDto(workFlowDtoTemp.getCloseSwfFlowMainDto());

	        System.out.println("工作流状态" + workFlowDtoTemp.getStatus());
	        workFlowDto.setStatus(workFlowDtoTemp.getStatus());
	      } //判断是提交操作的结束
	      //优化工作流
	      if (workFlowDto.getCreate() && workFlowDto.getUpdate()) {
	        //新创建的工作流直接创建，就不用在udpate一把了
	        workFlowDto.setCreateSwfLogDto(workFlowDto.getUpdateSwfLogDto());
	        workFlowDto.setUpdate(false);
	      }
	      
	      //优化工作流，如果报案的时候同时进行了关闭操作，则关闭的主表当时一定是空的，所以
	      if (workFlowDto.getCreate() && workFlowDto.getClose()) {
	        //新创建的工作流直接创建，关闭也要进行修整的
	        SwfFlowMainDto swfFlowMainDto = workFlowDto.getCreateSwfFlowMainDto();
	        swfFlowMainDto.setFlowStatus("0");
			workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto );
	      
	      }

	      //4。回退工作流
	      if (nodeStatus.equals("5")) {
	        //目前只有核损才用得到，无条件到达定损，并且人员是上个节点上的人员
	        //首先查找定损的节点，从回退的节点上查询属性为定损的节点，处理类型为typeFlag相同的节点
	        //由后向前进行查询。（目前只有核损和人伤核损两个）
	        if (swfLogDto.getNodeType().equals("verif") || swfLogDto.getNodeType().equals("veriw")) //核损的退回
	        {
	          workFlowDto=getBackFlowInfo(user,swfLogDto.getFlowID() ,swfLogDto.getLogNo() );
	        }else
	        {
	            throw new UserException(1,3,"工作流","没有发现可以回退的工作流节点");
	        }
	     }
	   }
	    System.out.println("2222222 end-------------------------"); 
	    
	 return workFlowDto;
	}
	
	
	    /**
	     * 根据当前节点的内容，提交工作流的下面的节点
	     * @param httpServletRequest HttpServletRequest
	     * @param swfLogDto SwfLogDto 当前工作流程节点信息
	     * @param NextBusinessNo String 下个节点的businessno
	     * @param conditionBusinessNo String 如有条件下的bussinessno
	     * @param KeyIN String 下一个节点的keyIn是什么
	     * @param nodeStatus String 本节点需要设置的状态
	     * @param KeyOut String 本节点的keyOut
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
	       //变更当前节点的状态

	       //暂时保留当前工作节点的信息,作为工作流的提交保存的当前节点内容
	       SwfLogDto swfLogDtoTemp = new SwfLogDto();
	       swfLogDtoTemp = swfLogDto;
	    //   System.out.println("2222222  swfLogDto.getEndFlag()"+swfLogDto.getEndFlag()+"设置");
	        //如果有结束标志的点，无论后面有任何的设置，都要立即结束，不用判断下面的节点和关系等等
	       if (swfLogDto.getEndFlag().equals("1"))
	       {
	            //结束工作流
	            //首先结束该节点前的失陪节点 ,为了稳妥，先查询此流程的taskType='M'类型的结束吧
	            System.out.println("swfLogDto.getEndFlag()"+swfLogDto.getEndFlag()+"设置2");
	            workFlowDto.setUpdate(true);
	            swfLogDtoTemp.setHandlerCode(user.getUserCode() );
	            swfLogDtoTemp.setHandlerName(user.getUserName() );
	            workFlowDto.setUpdateSwfLogDto(swfLogDtoTemp);
	            workFlowDto.setClose(true);
	            SwfFlowMainDto swfFlowMainDto = new  SwfFlowMainDto();
	            
	            //如果是第一个节点，现在还没有工作流主表内容呢，所以不需要查询的。
	            swfFlowMainDto = uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogDto.getFlowID().trim());
	           if ( swfFlowMainDto!=null)
	           {  
	             swfFlowMainDto.setCloseDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_DAY ));
	             swfFlowMainDto.setFlowStatus("0");
	           }
	            workFlowDto.setCloseSwfFlowMainDto(swfFlowMainDto) ;
	            return workFlowDto ;
	       }
	       
	        //一般情况下，NextBusinessNo和BusinessNo都是相同的
	           //除了赔款计算书的节点
	           if (!swfLogDto.getNodeType().equals("compp"))
	           {
	       //    	System.out.println("222222222 warning : go to compp 333333333");
	           	// swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	            swfLogDto.setBusinessNo(swfLogFunctionIn.getKeyIn());
	            //swfLogDto.setBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	            }
	          swfLogDto.setNextBusinessNo(swfLogFunctionIn.getNextBusinessNo());
	         //  swfLogDto.setNextBusinessNo(swfLogFunctionIn.getKeyIn());
	           //提交工作流ba
	           //由于有些节点的keyin keyout不是上个节点的流入，所以只得单独加keyin
	           //判断是不是人到人的提交,根据设置的标志nextNodeListType
	           if (swfLogFunctionIn.getNextNodeListType().equals("1") )
	         {
	           //支持指定的
	       //    System.out.println("22222222指定节点的信息");

	           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn,logNo,pathNo) ;
	         }  else
	         { //支持从模板上取得
	      //   	System.out.println("222222222指定模板上取得的信息");
	           workFlowDtoTemp=getSubmitFlowInfo(user,swfLogDto,swfLogFunctionIn.getKeyIn() ,logNo,pathNo) ;
	         }

	           //设置处理人员
	           swfLogDtoTemp.setHandlerCode(user.getUserCode() );
	           swfLogDtoTemp.setHandlerName(user.getUserName() );
	           //如果有定损的话，设置定损类型
	           if (swfLogFunctionIn.getTypeFlag()!=null&&swfLogFunctionIn.getTypeFlag().length()>0)
	           {
	           swfLogDtoTemp.setTypeFlag(swfLogFunctionIn.getTypeFlag());
	          }
	           if (workFlowDto.equals("9") )
	           {
	               //设置工作流的这个节点为异常
	               swfLogDtoTemp.setNodeStatus("9");
	            }
	           else
	           {
	              //正常流转，没有任务异常
	              workFlowDto.setUpdate(true);
	              //核损，实赔
	              if (workFlowDtoTemp.getUpdate()) //表示经过提交操作发现以近有后面的节点，只要保存操作即可
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
