package com.sinosoft.claim.ui.control.action;


//import com.sinosoft.function.workflow.ejb.client.SharkFactory;
//import com.sinosoft.function.workflow.ejb.shark.SharkClientInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.model.ClaimStatusGetStatCommand;
import com.sinosoft.claim.ui.model.SwfConditionExecuteResultCommand;
import com.sinosoft.claim.ui.model.SwfConditionFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfFlowMainFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.SwfFlowMainGetCountCommand;
import com.sinosoft.claim.ui.model.SwfFlowMainUpdateCommand;
import com.sinosoft.claim.ui.model.SwfLogDeleteByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfLogFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfLogFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.SwfLogGetCountCommand;
import com.sinosoft.claim.ui.model.SwfLogGetMaxLogNoCommand;
import com.sinosoft.claim.ui.model.SwfLogGetNodeMaxLogNoCommand;
import com.sinosoft.claim.ui.model.SwfLogGetNodeStatusStatCommand;
import com.sinosoft.claim.ui.model.SwfLogGetNodeUserStatusStatCommand;
import com.sinosoft.claim.ui.model.SwfLogStoreFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfLogStoreGetCountCommand;
import com.sinosoft.claim.ui.model.SwfLogStoreUpdateCommand;
import com.sinosoft.claim.ui.model.SwfLogUpdateCommand;
import com.sinosoft.claim.ui.model.SwfLogupdateFlowStatusCommand;
import com.sinosoft.claim.ui.model.SwfNodeFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfNodeFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.SwfNotionMaxLineNoCommand;
import com.sinosoft.claim.ui.model.SwfPathFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfPathLogFindByConditionsCommand;
import com.sinosoft.claim.ui.model.SwfPathLogGetMaxPathNoCommand;
import com.sinosoft.claim.ui.model.WorkFlowCreateFlowCommand;
import com.sinosoft.claim.ui.model.WorkFlowDealCommand;
import com.sinosoft.claim.ui.model.WorkFlowGetModelNoCommand;
import com.sinosoft.claim.ui.model.WorkFlowSubmitNodeCommand;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * 工作流操作逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔工作流接口程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */
public class UIWorkFlowAction
{
  public static String NODESTATUSSUBMIT = "04"; //节点状态 ，提交
  public static String CURRENCYCODE = "CurrencyCode"; //币别


  /**
   * 获取当前系统工作流模板号，从模板分配表中，利用险种和所属机构
   * @param riskCode String
   * @param comCode String
   * @throws Exception     
   * @return int
   */
  public int getModelNo(String riskCode,String comCode) throws Exception {
    WorkFlowGetModelNoCommand workFlowGetModelNoCommand= new WorkFlowGetModelNoCommand(riskCode,comCode);
    return ((Integer)workFlowGetModelNoCommand.execute()).intValue()  ;

  }
 /**
   * 获取wfLog表当前flowID相同的最大的LogNo 的maxNo
   * @param flowID String
   * @throws Exception
   * @return int
   */
  public int getSwfLogMaxLogNo(String flowID) throws Exception {
    SwfLogGetMaxLogNoCommand swfLogGetMaxLogNoCommand= new SwfLogGetMaxLogNoCommand(flowID);
    return ((Integer)swfLogGetMaxLogNoCommand.execute()).intValue()  ;
  }

  /**
   * 获取wfLog表当前flowID相同的最大LogNo 的节点名称
   * @param flowID String
   * @throws Exception
   * @return int
   */
  public int getSwfLogMaxNodeName(String flowID) throws Exception {
    SwfLogGetMaxLogNoCommand swfLogGetMaxLogNoCommand= new SwfLogGetMaxLogNoCommand(flowID);
    return ((Integer)swfLogGetMaxLogNoCommand.execute()).intValue()  ;
  }
  /**
 * 获取wfPathLog表当前最大的PathNo 的maxNo
 * @param flowID String
 * @throws Exception
 * @return String
 */
public int getSwfPathLogMaxPathNo(String flowID) throws Exception {
  SwfPathLogGetMaxPathNoCommand swfPathLogGetMaxPathNoCommand= new SwfPathLogGetMaxPathNoCommand(flowID);
  return ((Integer)swfPathLogGetMaxPathNoCommand.execute()).intValue()  ;
}

 /**
   * 创建工作流程
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public String createFlow(WorkFlowDto workFlowDto) throws Exception {
    //创建工作流成的步骤:
    //1.读取模板的号码 不成功直接报错
    //2.查询出模板的第1个开始节点
    //3.从wfflowMain表中取得flowId的值，
    //4。在wflog表建立和模板的nodeNo相同值的节点，
    //5。设置wflog表该数据的该节点的状态为正在处理。

      WorkFlowCreateFlowCommand workFlowCreateFlowCommand= new WorkFlowCreateFlowCommand(workFlowDto);
      return (String) workFlowCreateFlowCommand .execute();
    }

    /**
      * 处理整个工作流程(这个是整个工作流处理的基础)
      * @param formalPars：变量定义和内容
      * @throws Exception
      * @return String
      */
     public void deal(WorkFlowDto workFlowDto) throws Exception {
          WorkFlowDealCommand workFlowDealCommand= new WorkFlowDealCommand(workFlowDto);
          workFlowDealCommand .execute();
          return ;
       }

  /**
   * 修改工作流本身的状态信息
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public void updateFlow(SwfLogDto swfLogDto) throws Exception {
       SwfLogUpdateCommand swfLogUpdateCommand=new SwfLogUpdateCommand(swfLogDto);
       swfLogUpdateCommand.execute() ;
  }
  
  /**
   * 修改工作流本身的状态信息
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public void updateFlow(ArrayList swfLogDtoList) throws Exception {
       SwfLogUpdateCommand swfLogUpdateCommand=new SwfLogUpdateCommand(swfLogDtoList);
       swfLogUpdateCommand.execute() ;
  }
  /**
   * 修改工作流本身的状态信息
   * @param formalPars：变量定义和内容
   * @throws Exception
   * @return String
   */
  public void updateStoreFlow(SwfLogStoreDto swfLogStoreDto) throws Exception {
	  SwfLogStoreUpdateCommand swfLogUpdateCommand=new SwfLogStoreUpdateCommand(swfLogStoreDto);
       swfLogUpdateCommand.execute() ;
  }
  /**
   * 完成工作流节点，并向下一个节点流转
   * @param null
   * @throws Exception
   * @return String
   */
  public String submitNode(WorkFlowDto workFlowDto) throws Exception {
    WorkFlowSubmitNodeCommand workFlowSubmitNodeCommand= new WorkFlowSubmitNodeCommand(workFlowDto);
    return (String) workFlowSubmitNodeCommand .execute();
  }

  /**
   * 检查工作流是否关闭
   * @param null
   * @throws Exception
   * @return String
   */
  public boolean checkFlowClose(String flowID) throws Exception {
    String condtions= "flowid ='"+flowID+"' and FLOWSTATUS='0'";
    SwfFlowMainGetCountCommand swfFlowMainGetCountCommand=new SwfFlowMainGetCountCommand(condtions);
    Integer intRet = new Integer(0);
     intRet= (Integer)swfFlowMainGetCountCommand.execute() ;
    boolean retBln =false;
    if (intRet.intValue() > 0) retBln =true;
    return retBln;
   }

  /**
   * 根据流程节点的流程号和logno查询具体信息
   * @param null
   * @throws Exception
   * @return String
   */
  public SwfLogDto findNodeByPrimaryKey(String flowID,int logNo) throws Exception {

  SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);

   return (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();

  }

  /**
   * 根据流程号码查询wfflowMain的具体信息
   * @param null
   * @throws Exception
   * @return String
   */
  public SwfFlowMainDto findFlowMainByPrimaryKey(String flowID) throws Exception {

  SwfFlowMainFindByPrimaryKeyCommand swfFlowMainFindByPrimaryKeyCommand= new SwfFlowMainFindByPrimaryKeyCommand(flowID);

   return (SwfFlowMainDto) swfFlowMainFindByPrimaryKeyCommand.execute();

  }

  /**
    * 查找符合条件的流程节点信息
    * @param condition 条件
    * @throws Exception
    * @return String
    */
   public Collection findNodesByConditions(String condition) throws Exception {

    SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition);
    return (Collection) swfLogFindByConditionsCommand.execute();

   }

   /**
    * 查找符合条件的流程节点信息
    * @param condition 条件
    * @throws Exception
    * @return String
    */
   public Collection findStoreNodesByConditions(String condition) throws Exception {
	   SwfLogStoreFindByConditionsCommand swfLogStoreFindByConditionsCommand= new SwfLogStoreFindByConditionsCommand(condition);
    return (Collection) swfLogStoreFindByConditionsCommand.execute();
    }
  /**
      * 查找符合条件的流程节点信息(翻页)
      * @param condition 条件
      * @throws Exception
      * @return String
      */
     public PageRecord findNodesByConditions(String condition,int pageNo,int recordPerPage) throws Exception {
       SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition, pageNo,recordPerPage);
       return (PageRecord) swfLogFindByConditionsCommand.execute();
     } 
     /**
      * 查找符合条件的流程节点信息(翻页)
      * @param condition 条件
      * @throws Exception
      * @return String
      */
     public PageRecord findStoreNodesByConditions(String condition,int pageNo,int recordPerPage) throws Exception {
    	 SwfLogStoreFindByConditionsCommand swfLogStoreFindByConditionsCommand= new SwfLogStoreFindByConditionsCommand(condition, pageNo,recordPerPage);
      return (PageRecord) swfLogStoreFindByConditionsCommand.execute();
     }   

  /**
   * 查找当前处理的节点的节点信息
   * @param null
   * @throws Exception
   * @return String
   */
  public Collection findCurrentNode(String BussinessNo,String nodeType) throws Exception {
    String condition = " BUSINESSNO='"+BussinessNo+"' And "
        + " NodeType ='" + nodeType +"' And (NodeStatus<'4' )";
    SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
    return (ArrayList)  swfLogFindByConditionsCommand.execute();
  }
/**
 * 根据businessNo查找已处理完的节点信息
 */
  public Collection findCurNodeByBusinessNo(String bussinessNO,String nodeType,String nodeStatus,String flowStatus) throws Exception {
	  String condition = 
		     " BUSINESSNO='"+ bussinessNO + 
	         "' AND NODETYPE ='" + nodeType +
	         "' AND NODESTATUS = '"  + nodeStatus +
	         "' AND FLOWSTATUS = '" + flowStatus +"'";
	  SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
	  return (ArrayList)  swfLogFindByConditionsCommand.execute();
  }
  /**
     * 查找当前处理的节点的节点信息
     * @param null
     * @throws Exception
     * @return String
     */
    public Collection findCurrentNode(String flowID,int logNo) throws Exception {
      String condition = " flowid='"+flowID+"' And "
          + " LogNo="+logNo;
      SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
      return (ArrayList)  swfLogFindByConditionsCommand.execute();
    }

  /**
     * 查找当前流程的节点中是否存在NodeNo相同，并且状态为0未处理的Log节点
     * @param null
     * @throws Exception
     * @return String
     */
    public Collection findNoDealNodeByModelNodeNo(String flowID,int nodeNo,String nodeType) throws Exception {

      Collection resultList = new ArrayList();

      //核赔不用合并的。。
      if (nodeType.equals("veric")) return resultList;

      String  condition="flowID='"+flowID+"' And "
          + " NodeNo="+ nodeNo +" and NodeStatus <'4'";
      SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
      return (ArrayList)  swfLogFindByConditionsCommand.execute();
    }

    /**
       * 查找当前流程的节点中是否存在NodeNo相同，并且状态为0未处理的Log节点(人到人的方式下的)
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findNoDealNodeByModelNodeNoByPerson(String flowID,int nodeNo,String nodeType,String policyNo,String riskCode) throws Exception {
        String condition="";
        //没有被处理的，不仅仅是待处理的，还应该包括正在处理的，因为比如单证节点，应该就是只能一个节点被操作，并且是聚合性质的
        //并且一个保单上的数据必须是保证一个聚合的。
        condition = "flowID='"+flowID+"' And "
            + "  NodeStatus<'4' and NodeNo='"+ nodeNo+"' and riskCode='"+riskCode+"'";
        //add by lixiang start at 2006-6-8
        //由于强三的问题。。所以用这个方式 先聚合吧。。
        if (policyNo!=null&&policyNo.length() >1){
        	condition =condition + " and policyNo='"+policyNo+"'";	
        }
        //add by lixiang end at 2006-6-8
        
        SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
        return (ArrayList)  swfLogFindByConditionsCommand.execute();
      }

      /**
       * 查找符合一个工作流上的所有节点信息
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findNodesByFlowID(String flowID) throws Exception {
        String conditon ="flowid ='"+flowID+"' ORDER BY nodeno";
        return findNodesByConditions(conditon );
      }
      /**
       * 查找符合一个工作流上的所有节点信息
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findStoreNodesByFlowID(String flowID) throws Exception {
        String conditon ="flowid ='"+flowID+"' ORDER BY nodeno";
        return findStoreNodesByConditions(conditon );
      }  
      
  /**
   * 查找模板的一个节点的详细信息
   * @param null
   * @throws Exception
   * @return String
   */
  public SwfNodeDto findModelNodeByPrimaryKey(int modelNo,int nodeNo) throws Exception {
    //WfNodeFindByPrimaryKeyCommand
    SwfNodeFindByPrimaryKeyCommand swfNodeFindByPrimaryKeyCommand= new SwfNodeFindByPrimaryKeyCommand(modelNo,nodeNo);
      return (SwfNodeDto) swfNodeFindByPrimaryKeyCommand.execute();
  }

  /**
 * 查找模板的第一个符合条件的节点的详细信息
 * @param null
 * @throws Exception
 * @return String
 */
public SwfNodeDto findModelFirstNodeByCondition(String condition) throws Exception {
  //WfNodeFindByPrimaryKeyCommand
  Collection swfNodeDtoList= new ArrayList();
  SwfNodeFindByConditionsCommand swfNodeFindByConditionsCommand= new SwfNodeFindByConditionsCommand(condition);
  swfNodeDtoList= (Collection) swfNodeFindByConditionsCommand.execute();
  Iterator it = swfNodeDtoList.iterator() ;
  SwfNodeDto swfNodeDto= new SwfNodeDto ();
  while (it.hasNext())
  {
    swfNodeDto=(SwfNodeDto) it.next() ;
    break;
  }
    return swfNodeDto;
}

  /**
  * 查找模板的符合节点类型的第一个节点的详细信息
  * @param null
  * @throws Exception
  * @return String
  */
 public SwfNodeDto findModelNodeByNodeType(int modelNo,String nodeType) throws Exception {
   String strSql = "modelNo="+ modelNo+" and nodeType='"+nodeType+"'";
   return findModelFirstNodeByCondition(strSql);
 }

  /**
   * 查找模板的下多个节点的详细信息
   * @param modelNo int 模板号码
   * @param nodeNo int  模板上的节点号码
   * @param iBusinessNo String 当前业务号码
   * @throws Exception
   * @return Collection
   */
  public Collection findModelNextNodes(int modelNo,int nodeNo,String iBusinessNo) throws Exception {
    String strSql ="";
    String nodeConditions = "  (modelno =" + modelNo +" and startnodeno ="+ nodeNo+")";
    String strWhere ="";
    boolean blnResult=true;
    Collection wfPathDtoList = new ArrayList();
    Collection wfNodeDtoList = new ArrayList();

    //思路是先取得所有符合条件的路径，然后判断路径上的条件是不是满足，只要有一个条件不满足，就不能用这个路径了。
    //最后把符合条件的路径上的最后一个点都可以用的。。
   //获得所有的path数据
    SwfPathFindByConditionsCommand swfPathFindByConditionCommand  = new SwfPathFindByConditionsCommand (nodeConditions);
    wfPathDtoList =(Collection) swfPathFindByConditionCommand.execute();
    Iterator it =wfPathDtoList.iterator();

    while (it.hasNext())
    {
      //由于条件的引入，需要过滤掉不符合wfcondition条件的数据记录，通过pathno来进行。
      SwfPathDto swfPathDto = new SwfPathDto();
      swfPathDto =(SwfPathDto) it.next() ;

      //首先过滤掉是用来选择用的节点
      if (swfPathDto.getDefaultFlag().equals("3")  ) continue;

      //没有条件限制的情况下
      if (swfPathDto.getConditionStatus().equals("1"))
      {
      }else
      {
        strSql =strSql+","+swfPathDto.getEndNodeNo();
        continue;
      }
      //有条件约束的情况下，首先要取得所以的条件，一一甄别
      blnResult=checkPathCondition(swfPathDto,iBusinessNo);
      if (blnResult) strSql =strSql+","+swfPathDto.getEndNodeNo();
    }
     // 判断有没有符合条件的nodeNo
     if (strSql.length() > 1)
     {
       strWhere = strSql;
       if(modelNo==1||modelNo==12||modelNo==14||modelNo==87 || modelNo==89)
       {
    	   strSql =  " modelno =" + modelNo + " and nodeNo in ("+strWhere.substring(1,strWhere.length() ) +") order by decode(nodeNo,-99, "+strWhere.substring(1,strWhere.length() ) +")";
       }
       else
       {
    	   strSql =  " modelno =" + modelNo + " and nodeNo in ("+strWhere.substring(1,strWhere.length() ) +")";
       }
       //strSql =  " modelno =" + modelNo + " and nodeNo in ("+strWhere.substring(1,strWhere.length() ) +")";
       System.err.println("strSql="+strSql);
      SwfNodeFindByConditionsCommand swfNodeFindByConditionsCommand= new SwfNodeFindByConditionsCommand(strSql);
      wfNodeDtoList= (Collection) swfNodeFindByConditionsCommand.execute();
     }
  return wfNodeDtoList;
  }

  /**
 * 查找模板的下多个节点的详细信息
 * @param modelNo int 模板号码
 * @param nodeNo int  模板上的节点号码
 * @param iBusinessNo String 当前业务号码
 * @throws Exception
 * @return Collection
 */
public Collection findModelPathNodes(String nodeConditions) throws Exception {
   Collection wfPathDtoList = new ArrayList();
 //获得所有的path数据
  SwfPathFindByConditionsCommand swfPathFindByConditionCommand  = new SwfPathFindByConditionsCommand (nodeConditions);
  wfPathDtoList =(Collection) swfPathFindByConditionCommand.execute();

return wfPathDtoList;
}

  /**
   * 寻找nodeNo为当前NodeNo的T类型的节点
   * @param modelNo int 模板号码
   * @param nodeNo int 当前的NodeNo的值
   * @throws Exception
   * @return Collection
   */
  public Collection findModelNextTNodes(int modelNo,int nodeNo) throws Exception {
      String nodeConditions = "  (modelno =" + modelNo +" and taskType ='T' and taskNo="+ nodeNo+")";
      Collection swfNodeDtoList = new ArrayList();
      //思路是先取得所有=T类型的，并且taskNo=指定nodeNo的节点数据作为新的下一个节点数据
      SwfNodeFindByConditionsCommand swfNodeFindByConditionsCommand= new SwfNodeFindByConditionsCommand(nodeConditions);
      swfNodeDtoList= (Collection) swfNodeFindByConditionsCommand.execute();
      return swfNodeDtoList;

  }

  /**
     * 查找模板的上多个节点的详细信息
     * @param null
     * @throws Exception
     * @return String
     */
    public Collection findModelPerviousNodes(int modelNo,int nodeNo) throws Exception {
      //WfNodeFindByPrimaryKeyCommand
      String conditions = " modelno =" + modelNo
          +" and nodeNo in ( select startnodeno from wfpath where modelno ="
          + modelNo +" and endnodeno ="+ nodeNo+")";
      SwfNodeFindByConditionsCommand swfNodeFindByConditionsCommand= new SwfNodeFindByConditionsCommand(conditions);
        return (Collection) swfNodeFindByConditionsCommand.execute();

    }
    /**
         * 查找工作流的某点之前上多个节点的详细信息
         * @param null
         * @throws Exception
         * @return String
         */
        public Collection findPerviousNodes(String flowID,int logNo) throws Exception {
          //WfNodeFindByPrimaryKeyCommand
          String conditions = " flowID ='" + flowID
              +"' and logNo in ( select startnodeno from swfpathLog where flowID ='"
              + flowID +"' and endnodeno ="+ logNo+")";

          SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(conditions);
            return (Collection) swfLogFindByConditionsCommand.execute();
        }

    /**
     * 根据业务号查询工作流流程日志信息
     * @param businessNo String
     * @throws Exception
     * @return Collection
     */
    public Collection findFlowLogByBuessionNo(String businessNo) throws Exception
    {
       String conditions = "  flowid in (select flowid from swfLog where businessNo='" + businessNo + "' AND nodetype='regis') ORDER BY nodeno" ;
       SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(conditions);
        return (Collection) swfLogFindByConditionsCommand.execute();
    }

    /**
     * 根据流程号查询工作流流程路径信息
     * @param flowID String
     * @throws Exception
     * @return Collection
     */
    public Collection findFlowPathLogByFlowID(String flowID) throws Exception
    {
       String conditions = " flowID='" + flowID + "'" ;
       SwfPathLogFindByConditionsCommand swfPathLogFindByConditionsCommand= new SwfPathLogFindByConditionsCommand(conditions);
        return (Collection) swfPathLogFindByConditionsCommand.execute();
    }
    
    /**
     * 根据流程号查询工作流流程路径信息
     * @param flowID String
     * @throws Exception
     * @return Collection
     */
    public Collection findStoreFlowPathLogByFlowID(String flowID) throws Exception
    {
       String conditions = " flowID='" + flowID + "' " ;
       SwfPathLogFindByConditionsCommand swfPathLogStoreFindByConditionsCommand= new SwfPathLogFindByConditionsCommand(conditions);
        return (Collection) swfPathLogStoreFindByConditionsCommand.execute(); 
    }
    /**
     * 
     * @param swfPathDto
     * @param iBusinessNo
     * @return
     * @throws Exception
     */
    /**
     * 检验是不是满足路径上的条件
     * @param wfPathDto WfPathDto
     * @param iBusinessNo String
     * @throws Exception
     * @return boolean
     */
    public boolean checkPathCondition(SwfPathDto swfPathDto,String iBusinessNo) throws Exception
    {
      String conditions = " ( modelno =" + swfPathDto.getModelNo()+" and Pathno ="+ swfPathDto.getPathNo() +")";
      Collection wfConditionDtoList = new ArrayList();
      boolean blnResult = true;

      SwfConditionFindByConditionsCommand swfConditionFindByConditionCommand  = new SwfConditionFindByConditionsCommand (conditions);
      wfConditionDtoList =(Collection) swfConditionFindByConditionCommand.execute();
      Iterator itcc =wfConditionDtoList.iterator();
      //必须设置开始的条件检验为 true

      while (itcc.hasNext())
      {
        SwfConditionDto swfConditionDto = new SwfConditionDto();
        swfConditionDto= (SwfConditionDto) itcc.next() ;

        //根据业务号码，判断业务数据库中是否满足路径上的条件，如果都满足，则说明可以通过

       //.0/1简单条件
       if (swfConditionDto.getConfigType().equals("0")||swfConditionDto.getConfigType().equals("1"))
        {
          String strWhere = swfConditionDto.getBusinessKey().trim()+ "='" + iBusinessNo.trim() + "' AND " + swfConditionDto.getConfigText().trim();
          String strTemp= "SELECT COUNT(*) FROM " + swfConditionDto.getTableName().trim() + " WHERE " + strWhere.trim();
          SwfConditionExecuteResultCommand  wfConditionExecuteResultCommand = new SwfConditionExecuteResultCommand(strTemp);
          blnResult =((Boolean) wfConditionExecuteResultCommand.execute()).booleanValue()   ;

        }
        // 2高级条件或者是function
        if (swfConditionDto.getConfigType().equals("2"))
        {
        //目前没有设置function (保留)
         }
         //如果不符合条件,立即跳出循环
         if (!blnResult) break;
      }
      return blnResult;
    }

        /**
         * 根据流程号和节点进行独占操作
         * @param flowID String
         * @param LogNo int
         * @throws Exception
         * @return boolean
         */
        public SwfLogDto holdNode(String flowID,int logNo,String userCode,String userName) throws Exception
        {
           //占号操作  (默认是没有占号，没有获得分配权)
           boolean retHold =false;

           //从数据库中查询符合条件的工作流节点
           SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
           SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
           if (swfLogDto.getFlowStatus().equals("2") )
           {
             //如果工作流已经被占用了，检查是不是同一个人
             if (swfLogDto.getHandlerCode().equals(userCode)) retHold=true;
             
             if (swfLogDto.getHandlerCode().equals("")) retHold=true;
           }
           else
           {
             //没有分配的情况下，独占该工作节点
           	 if (!swfLogDto.getHandlerCode().equals(userCode)){
                //如果不是指定人的，就占号，如果是指定人的，不改变flowStatus,保持1的状态
           	 	swfLogDto.setFlowStatus("2");
           	 }
             swfLogDto.setHandlerCode(userCode);
             swfLogDto.setHandlerName(userName);
             swfLogDto.setHandleTime(new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND ).toString()  );
             
             WorkFlowDto workFlowDto = new WorkFlowDto();
             workFlowDto.setFreeHoldNode(true);
             workFlowDto.setUpdate (true);
             workFlowDto.setUpdateSwfLogDto(swfLogDto);
             deal(workFlowDto);
             //再次判断是不是本人占用的???
             swfLogDto =findHoldNode(flowID,logNo,userCode);
             retHold = swfLogDto.getHoldNode() ;

           }
           swfLogDto.setHoldNode(retHold);
           return swfLogDto;
          }
        /**
         * 根据流程号和节点进行独占操作
         * @param flowID String
         * @param LogNo int
         * @throws Exception
         * @return boolean
         */
        public SwfLogDto holdNodeCombine(String flowID,int logNo,String userCode,String userName) throws Exception
        {
           //占号操作  (默认是没有占号，没有获得分配权)
           boolean retHold =false;

           //从数据库中查询符合条件的工作流节点
           SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
           SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
           if (swfLogDto.getFlowStatus().equals("2") )
           {
             //如果工作流已经被占用了，检查是不是同一个人
             if (swfLogDto.getHandlerCode().equals(userCode)) retHold=true;
             
             if (swfLogDto.getHandlerCode().equals("")) retHold=true;
           }
           else
           {
             //没有分配的情况下，独占该工作节点
           	 if (!swfLogDto.getHandlerCode().equals(userCode)){
                //如果不是指定人的，就占号，如果是指定人的，不改变flowStatus,保持1的状态
           	 	swfLogDto.setFlowStatus("2");
           	 }
             swfLogDto.setHandlerCode(userCode);
             swfLogDto.setHandlerName(userName);
             swfLogDto.setHandleTime(new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND ).toString()  );
             
             WorkFlowDto workFlowDto = new WorkFlowDto();
             workFlowDto.setFreeHoldNode(false);
             workFlowDto.setUpdate (true);
             workFlowDto.setUpdateSwfLogDto(swfLogDto);
             deal(workFlowDto);
             //再次判断是不是本人占用的???
             swfLogDto =findHoldNode(flowID,logNo,userCode);
             retHold = swfLogDto.getHoldNode() ;

           }
           swfLogDto.setHoldNode(retHold);
           return swfLogDto;
          }

          /**
          * 根据流程号和节点进行释放操作
          * @param flowID String
          * @param LogNo int
          * @throws Exception
          * @return boolean
          */
         public void freeNode(String flowID,int logNo) throws Exception
         {
            //无条件释放

            SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
            SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
            swfLogDto.setFlowStatus("1");
            swfLogDto.setHandlerCode("");
            swfLogDto.setHandlerName("");
            WorkFlowDto workFlowDto = new WorkFlowDto();
            workFlowDto.setUpdate(true);
            workFlowDto.setUpdateSwfLogDto(swfLogDto);
            deal(workFlowDto);
            return ;
           }
           /**
             * 根据流程号和节点判断用户是否具有独占操作
             * @param flowID String
             * @param LogNo int
             * @throws Exception
             * @return boolean
             */
            public SwfLogDto findHoldNode(String flowID,int logNo,String userCode) throws Exception
            {  boolean retBln=false;

               SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
               SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
               //如果占用等于本人，返回true; 不用区分是flowstatus的状况
               if (swfLogDto.getHandlerCode().equals(userCode))
               {
                 retBln =true;
               }

               swfLogDto.setHoldNode(retBln);
               return swfLogDto;
              }

      /**
        * 统计工作流节点状态数量的功能
        * @param conditions String
        * @throws Exception
        * @return StatStatusDto
        */
       public Collection getNodeStatusStat(String condition)
        throws Exception
    {
      SwfLogGetNodeStatusStatCommand swfLogGetNodeStatusStatCommand= new SwfLogGetNodeStatusStatCommand(condition);
      return (Collection) swfLogGetNodeStatusStatCommand.execute();

    }
      /**
        * 统计工作流节点用户状态数量的功能
        * @param conditions String
        * @throws Exception
        * @return StatStatusDto
        */
       public Collection getNodeUserStatusStat(String condition)
        throws Exception
    {
      SwfLogGetNodeUserStatusStatCommand swfLogGetNodeUserStatusStatCommand= new SwfLogGetNodeUserStatusStatCommand(condition);
      return (Collection) swfLogGetNodeUserStatusStatCommand.execute();
   }
   /**
        * 根据报案号码删除工作流数据
        * @param registNo String
        * @throws Exception
        * @return StatStatusDto
        */
       public String findFlowIDByRegistNo(String registNo)
        throws Exception
    {
      String flowId ="";
      String condition ="  businessno ='" + registNo +"' and nodeType='regis'";
      Collection swfLogList = new ArrayList();
      SwfLogDto swfLogDto = new SwfLogDto();

      SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition);
      swfLogList =(Collection) swfLogFindByConditionsCommand.execute();
      Iterator it = swfLogList.iterator() ;

      while (it.hasNext() )
      { swfLogDto = (SwfLogDto)it.next();
        flowId = swfLogDto.getFlowID();    }

      return flowId;
    }
//modify by liuyanmei add 20051102 start 
   public String findFlowIDBybusinessNo(String businessNo)
       throws Exception
   {
     String flowId ="";
     String condition ="  businessno ='" + businessNo +"'";
     Collection swfLogList = new ArrayList();
     SwfLogDto swfLogDto = new SwfLogDto();

     SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition);
     swfLogList =(Collection) swfLogFindByConditionsCommand.execute();
     Iterator it = swfLogList.iterator() ;

     while (it.hasNext() )
     { swfLogDto = (SwfLogDto)it.next();
       flowId = swfLogDto.getFlowID();    }

     return flowId;
   }
   /**
    * 从转储表通过业务号取flowid
    * @param businessNo
    * @return
    * @throws Exception
    */
   public String findStoreFlowIDBybusinessNo(String businessNo)
			throws Exception {
		String flowId = "";
		String condition = "  businessno ='" + businessNo + "'";
		Collection swfLogList = new ArrayList();
		SwfLogDto swfLogDto = new SwfLogDto();

		SwfLogStoreFindByConditionsCommand swfLogStoreFindByConditionsCommand = new SwfLogStoreFindByConditionsCommand(
				condition);
		swfLogList = (Collection) swfLogStoreFindByConditionsCommand.execute();
		Iterator it = swfLogList.iterator();

		while (it.hasNext()) {
			swfLogDto = (SwfLogDto) it.next();
			flowId = swfLogDto.getFlowID();
		}

		return flowId;
	}
//modify by liuyanmei add 20051102 end        
    /**
     * 根据flowID号码删除相映的工作流流程。
     * @param flowID String
     * @throws Exception
     */
    public void deleteWorkFlow(String flowID)
        throws Exception
    {

    }
   /**
 * 获得理赔节点统计信息
 * @param  conditions：查询条件
 * @return Collection
 * @throws Exception
 */

 public Collection getStatStatus(String conditions) throws Exception
 {
    ClaimStatusGetStatCommand claimStatusGetStatCommand = new ClaimStatusGetStatCommand(conditions);

    return (Collection)claimStatusGetStatCommand.execute();
 }


 /**
   * 获取swfNotion表当前flowID相同,LogNo相同,lineNo 的最大的的maxNo
   * @param flowID String
   * @throws Exception
   * @return int
   */
  public int getSwfNotionMaxLineNo(String flowID,int logNo) throws Exception {
    SwfNotionMaxLineNoCommand swfNotionMaxLineNoCommand= new SwfNotionMaxLineNoCommand(flowID,logNo);
    return ((Integer)swfNotionMaxLineNoCommand.execute()).intValue()  ;
  }
  
  public  void   UpdateHandlerCode(String flowID,int logNo,String userCode,String userName) throws Exception
  {
     SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
     SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
     swfLogDto.setHandlerCode(userCode);
     swfLogDto.setHandlerName(userName);
     WorkFlowDto workFlowDto = new WorkFlowDto();
     workFlowDto.setUpdate (true);
     workFlowDto.setUpdateSwfLogDto(swfLogDto);
     deal(workFlowDto);
    }
  /**
   * 查找符合条件的节点的个数
   * @param conditon
   * @return
   * @throws Exception
   */
  public int findFlowNodeCountByConditon(String condition)throws Exception
	{
  	int intRet=0;
  	
  	SwfLogGetCountCommand swfLogGetCountCommand = new SwfLogGetCountCommand(condition);
  	
  	intRet =((Integer)swfLogGetCountCommand.execute()).intValue()  ;
  	return intRet;
  }

  /**
   * 查找符合条件的节点的个数
   * @param conditon
   * @return
   * @throws Exception
   */
  public int findFlowStoreNodeCountByConditon(String condition)throws Exception
	{
  	int intRet=0;
  	
  	SwfLogStoreGetCountCommand swfLogStoreGetCountCommand = new SwfLogStoreGetCountCommand(condition);
  	
  	intRet =((Integer)swfLogStoreGetCountCommand.execute()).intValue()  ;
  	return intRet;
  }
  /**
   * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
   * @param httpServletRequest 返回给页面的request
   * @param registNo       报案号
   * @param policyNo       保单号
   * @param licenseNo      车牌号码
   * @param riskCode       险别
   * @param insuredName    被保险人名称
   * @throws Exception
   */
  public void getWorkFlowList(HttpServletRequest httpServletRequest,
                                          String registNo,
                                          String policyNo,
                                          String licenseNo,
                                          String riskCode,
                                          String insuredName,int intPageNo,int intRecordPerPage) throws Exception
  {
    //根据输入的保单号，报案号生成SQL where 子句   
    registNo = StringUtils.rightTrim(registNo) ;  
    policyNo = StringUtils.rightTrim(policyNo) ;
    licenseNo = StringUtils.rightTrim(licenseNo);
    insuredName = StringUtils.rightTrim(insuredName);
    riskCode = StringUtils.rightTrim(riskCode);
    riskCode = StringUtils.rightTrim(riskCode) ;
    insuredName = StringUtils.rightTrim(insuredName);
    
     String conditions = " nodeType='regis' ";
     if(registNo.length()>0)
     {
       conditions = conditions +
           StringConvert.convertString(" registNo", registNo,
                                       httpServletRequest.getParameter(
           "RegistNoSign"));
     }
     if(policyNo.length()>0)
     {
       conditions = conditions +
           StringConvert.convertString(" policyNo", policyNo,
                                       httpServletRequest.getParameter(
           "PolicyNoSign"));
     }
     if(riskCode.length()>0)
     {
       conditions = conditions +
           StringConvert.convertString(" riskCode", riskCode,
                                       httpServletRequest.getParameter(
           "RiskCodeSign"));
     }
     if(insuredName.length()>0)
     {
       conditions = conditions +
           StringConvert.convertString(" insuredName", insuredName,
                                       httpServletRequest.getParameter(
           "InsuredNameSign"));
     }
     if(licenseNo.length()>0)
     {
       conditions = conditions +
           StringConvert.convertString(" lossitemName", licenseNo,
                                       httpServletRequest.getParameter("LicenseNoSign"));
     }
//   拼权限
     com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
     UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
     conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),httpServletRequest.getParameter("taskCodeC"),"swfLog",null);
     //查询流程信息
     UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

     //得到多行报案主表信息
     PageRecord pageRecord = null;
     String caseType   = httpServletRequest.getParameter("caseType");
     if("1".equals(caseType)){
     	pageRecord = (PageRecord)uiWorkFlowAction.findStoreNodesByConditions(conditions ,intPageNo,intRecordPerPage) ;
     }else{
     	pageRecord = (PageRecord)uiWorkFlowAction.findNodesByConditions(conditions ,intPageNo,intRecordPerPage) ;
     }
     ArrayList swfLogList = new ArrayList(); 
     swfLogList=(ArrayList)pageRecord.getResult();
     TurnPageDto turnPageDto = new TurnPageDto();//翻页内容
       //查询出来的一页的结构集
       turnPageDto.setResultList(swfLogList);
       //当前页号
       turnPageDto.setPageNo(pageRecord.getPageNo());
       //一页的条数
       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
       //查询出来的结果的总数
       turnPageDto.setTotalCount(pageRecord.getCount());
       //返回总的页数
       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
       //搜索条件
       turnPageDto.setCondition(conditions);
     SwfLogDto swfLogDto = new SwfLogDto();
    swfLogDto.setSwfLogList(swfLogList);

    swfLogDto.setTurnPageDto(turnPageDto) ;

    httpServletRequest.setAttribute("swfLogDto",swfLogDto) ;
    swfLogDto.setEditType(httpServletRequest.getParameter("editType")) ;
     
  } 

//modify by liuyanmei add 20051102 start
  public int getSwfLogMaxNodeLogNo(String flowID,String nodeType,String businessNo) throws Exception {
    SwfLogGetNodeMaxLogNoCommand swfLogGetNodeMaxLogNoCommand= new SwfLogGetNodeMaxLogNoCommand(flowID,nodeType,businessNo);
    return ((Integer)swfLogGetNodeMaxLogNoCommand.execute()).intValue()  ;
  }
  
  public  void   updateFlowStatus(String flowID) throws Exception
  {
     SwfLogupdateFlowStatusCommand swfLogupdateFlowStatusCommand= new SwfLogupdateFlowStatusCommand(flowID);
     swfLogupdateFlowStatusCommand.execute();
  
   }  
  public  void   updateSwfflowMain(SwfFlowMainDto  swfFlowMainDto) throws Exception
  {
    SwfFlowMainUpdateCommand swfFlowMainUpdateCommand= new SwfFlowMainUpdateCommand(swfFlowMainDto);
    swfFlowMainUpdateCommand.execute();
 
  }  
//modify by liuyanmei add 20051102 end
  
  //********************************************************************************************************
  //start********************************对工作流节点进行删除操作,请慎重调用**************************************
  //********************************************************************************************************
  /**
   * 在不予立案节点处理完毕后，要将在报案环节生成的工作流信息删除 add by qinyongli 2005-09-09
   */
  public void deletWorkFlowForNotGrand(String conditions) throws Exception{
  	  //对删除条件进行严格控制
  	  if(!conditions.equals("")){
  	      SwfLogDeleteByConditionsCommand command = new SwfLogDeleteByConditionsCommand(conditions);
  	      command.execute();
  	  }
  }
  
     public void cancelBack(String flowID,int logNo) throws Exception {
        SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
        swfLogFindByPrimaryKeyCommand.cancelBack();
    }
  //end********************************对工作流节点进行删除操作,请慎重调用****************************************
	public int getCount(String conditions) throws Exception {
		BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		  return blSwfLogFacade.getCount(conditions);   
	}
}
