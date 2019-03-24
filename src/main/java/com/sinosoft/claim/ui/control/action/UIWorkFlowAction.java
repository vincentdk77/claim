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
 * �����������߼�
 * <p>Title: ��������</p>
 * <p>Description: �������⹤�����ӿڳ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class UIWorkFlowAction
{
  public static String NODESTATUSSUBMIT = "04"; //�ڵ�״̬ ���ύ
  public static String CURRENCYCODE = "CurrencyCode"; //�ұ�


  /**
   * ��ȡ��ǰϵͳ������ģ��ţ���ģ�������У��������ֺ���������
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
   * ��ȡwfLog��ǰflowID��ͬ������LogNo ��maxNo
   * @param flowID String
   * @throws Exception
   * @return int
   */
  public int getSwfLogMaxLogNo(String flowID) throws Exception {
    SwfLogGetMaxLogNoCommand swfLogGetMaxLogNoCommand= new SwfLogGetMaxLogNoCommand(flowID);
    return ((Integer)swfLogGetMaxLogNoCommand.execute()).intValue()  ;
  }

  /**
   * ��ȡwfLog��ǰflowID��ͬ�����LogNo �Ľڵ�����
   * @param flowID String
   * @throws Exception
   * @return int
   */
  public int getSwfLogMaxNodeName(String flowID) throws Exception {
    SwfLogGetMaxLogNoCommand swfLogGetMaxLogNoCommand= new SwfLogGetMaxLogNoCommand(flowID);
    return ((Integer)swfLogGetMaxLogNoCommand.execute()).intValue()  ;
  }
  /**
 * ��ȡwfPathLog��ǰ����PathNo ��maxNo
 * @param flowID String
 * @throws Exception
 * @return String
 */
public int getSwfPathLogMaxPathNo(String flowID) throws Exception {
  SwfPathLogGetMaxPathNoCommand swfPathLogGetMaxPathNoCommand= new SwfPathLogGetMaxPathNoCommand(flowID);
  return ((Integer)swfPathLogGetMaxPathNoCommand.execute()).intValue()  ;
}

 /**
   * ������������
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public String createFlow(WorkFlowDto workFlowDto) throws Exception {
    //�����������ɵĲ���:
    //1.��ȡģ��ĺ��� ���ɹ�ֱ�ӱ���
    //2.��ѯ��ģ��ĵ�1����ʼ�ڵ�
    //3.��wfflowMain����ȡ��flowId��ֵ��
    //4����wflog������ģ���nodeNo��ֵͬ�Ľڵ㣬
    //5������wflog������ݵĸýڵ��״̬Ϊ���ڴ���

      WorkFlowCreateFlowCommand workFlowCreateFlowCommand= new WorkFlowCreateFlowCommand(workFlowDto);
      return (String) workFlowCreateFlowCommand .execute();
    }

    /**
      * ����������������(�������������������Ļ���)
      * @param formalPars���������������
      * @throws Exception
      * @return String
      */
     public void deal(WorkFlowDto workFlowDto) throws Exception {
          WorkFlowDealCommand workFlowDealCommand= new WorkFlowDealCommand(workFlowDto);
          workFlowDealCommand .execute();
          return ;
       }

  /**
   * �޸Ĺ����������״̬��Ϣ
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public void updateFlow(SwfLogDto swfLogDto) throws Exception {
       SwfLogUpdateCommand swfLogUpdateCommand=new SwfLogUpdateCommand(swfLogDto);
       swfLogUpdateCommand.execute() ;
  }
  
  /**
   * �޸Ĺ����������״̬��Ϣ
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public void updateFlow(ArrayList swfLogDtoList) throws Exception {
       SwfLogUpdateCommand swfLogUpdateCommand=new SwfLogUpdateCommand(swfLogDtoList);
       swfLogUpdateCommand.execute() ;
  }
  /**
   * �޸Ĺ����������״̬��Ϣ
   * @param formalPars���������������
   * @throws Exception
   * @return String
   */
  public void updateStoreFlow(SwfLogStoreDto swfLogStoreDto) throws Exception {
	  SwfLogStoreUpdateCommand swfLogUpdateCommand=new SwfLogStoreUpdateCommand(swfLogStoreDto);
       swfLogUpdateCommand.execute() ;
  }
  /**
   * ��ɹ������ڵ㣬������һ���ڵ���ת
   * @param null
   * @throws Exception
   * @return String
   */
  public String submitNode(WorkFlowDto workFlowDto) throws Exception {
    WorkFlowSubmitNodeCommand workFlowSubmitNodeCommand= new WorkFlowSubmitNodeCommand(workFlowDto);
    return (String) workFlowSubmitNodeCommand .execute();
  }

  /**
   * ��鹤�����Ƿ�ر�
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
   * �������̽ڵ�����̺ź�logno��ѯ������Ϣ
   * @param null
   * @throws Exception
   * @return String
   */
  public SwfLogDto findNodeByPrimaryKey(String flowID,int logNo) throws Exception {

  SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);

   return (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();

  }

  /**
   * �������̺����ѯwfflowMain�ľ�����Ϣ
   * @param null
   * @throws Exception
   * @return String
   */
  public SwfFlowMainDto findFlowMainByPrimaryKey(String flowID) throws Exception {

  SwfFlowMainFindByPrimaryKeyCommand swfFlowMainFindByPrimaryKeyCommand= new SwfFlowMainFindByPrimaryKeyCommand(flowID);

   return (SwfFlowMainDto) swfFlowMainFindByPrimaryKeyCommand.execute();

  }

  /**
    * ���ҷ������������̽ڵ���Ϣ
    * @param condition ����
    * @throws Exception
    * @return String
    */
   public Collection findNodesByConditions(String condition) throws Exception {

    SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition);
    return (Collection) swfLogFindByConditionsCommand.execute();

   }

   /**
    * ���ҷ������������̽ڵ���Ϣ
    * @param condition ����
    * @throws Exception
    * @return String
    */
   public Collection findStoreNodesByConditions(String condition) throws Exception {
	   SwfLogStoreFindByConditionsCommand swfLogStoreFindByConditionsCommand= new SwfLogStoreFindByConditionsCommand(condition);
    return (Collection) swfLogStoreFindByConditionsCommand.execute();
    }
  /**
      * ���ҷ������������̽ڵ���Ϣ(��ҳ)
      * @param condition ����
      * @throws Exception
      * @return String
      */
     public PageRecord findNodesByConditions(String condition,int pageNo,int recordPerPage) throws Exception {
       SwfLogFindByConditionsCommand swfLogFindByConditionsCommand= new SwfLogFindByConditionsCommand(condition, pageNo,recordPerPage);
       return (PageRecord) swfLogFindByConditionsCommand.execute();
     } 
     /**
      * ���ҷ������������̽ڵ���Ϣ(��ҳ)
      * @param condition ����
      * @throws Exception
      * @return String
      */
     public PageRecord findStoreNodesByConditions(String condition,int pageNo,int recordPerPage) throws Exception {
    	 SwfLogStoreFindByConditionsCommand swfLogStoreFindByConditionsCommand= new SwfLogStoreFindByConditionsCommand(condition, pageNo,recordPerPage);
      return (PageRecord) swfLogStoreFindByConditionsCommand.execute();
     }   

  /**
   * ���ҵ�ǰ����Ľڵ�Ľڵ���Ϣ
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
 * ����businessNo�����Ѵ�����Ľڵ���Ϣ
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
     * ���ҵ�ǰ����Ľڵ�Ľڵ���Ϣ
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
     * ���ҵ�ǰ���̵Ľڵ����Ƿ����NodeNo��ͬ������״̬Ϊ0δ�����Log�ڵ�
     * @param null
     * @throws Exception
     * @return String
     */
    public Collection findNoDealNodeByModelNodeNo(String flowID,int nodeNo,String nodeType) throws Exception {

      Collection resultList = new ArrayList();

      //���ⲻ�úϲ��ġ���
      if (nodeType.equals("veric")) return resultList;

      String  condition="flowID='"+flowID+"' And "
          + " NodeNo="+ nodeNo +" and NodeStatus <'4'";
      SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
      return (ArrayList)  swfLogFindByConditionsCommand.execute();
    }

    /**
       * ���ҵ�ǰ���̵Ľڵ����Ƿ����NodeNo��ͬ������״̬Ϊ0δ�����Log�ڵ�(�˵��˵ķ�ʽ�µ�)
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findNoDealNodeByModelNodeNoByPerson(String flowID,int nodeNo,String nodeType,String policyNo,String riskCode) throws Exception {
        String condition="";
        //û�б�����ģ��������Ǵ�����ģ���Ӧ�ð������ڴ���ģ���Ϊ���絥֤�ڵ㣬Ӧ�þ���ֻ��һ���ڵ㱻�����������Ǿۺ����ʵ�
        //����һ�������ϵ����ݱ����Ǳ�֤һ���ۺϵġ�
        condition = "flowID='"+flowID+"' And "
            + "  NodeStatus<'4' and NodeNo='"+ nodeNo+"' and riskCode='"+riskCode+"'";
        //add by lixiang start at 2006-6-8
        //����ǿ�������⡣�������������ʽ �Ⱦۺϰɡ���
        if (policyNo!=null&&policyNo.length() >1){
        	condition =condition + " and policyNo='"+policyNo+"'";	
        }
        //add by lixiang end at 2006-6-8
        
        SwfLogFindByConditionsCommand swfLogFindByConditionsCommand =new SwfLogFindByConditionsCommand(condition);
        return (ArrayList)  swfLogFindByConditionsCommand.execute();
      }

      /**
       * ���ҷ���һ���������ϵ����нڵ���Ϣ
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findNodesByFlowID(String flowID) throws Exception {
        String conditon ="flowid ='"+flowID+"' ORDER BY nodeno";
        return findNodesByConditions(conditon );
      }
      /**
       * ���ҷ���һ���������ϵ����нڵ���Ϣ
       * @param null
       * @throws Exception
       * @return String
       */
      public Collection findStoreNodesByFlowID(String flowID) throws Exception {
        String conditon ="flowid ='"+flowID+"' ORDER BY nodeno";
        return findStoreNodesByConditions(conditon );
      }  
      
  /**
   * ����ģ���һ���ڵ����ϸ��Ϣ
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
 * ����ģ��ĵ�һ�����������Ľڵ����ϸ��Ϣ
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
  * ����ģ��ķ��Ͻڵ����͵ĵ�һ���ڵ����ϸ��Ϣ
  * @param null
  * @throws Exception
  * @return String
  */
 public SwfNodeDto findModelNodeByNodeType(int modelNo,String nodeType) throws Exception {
   String strSql = "modelNo="+ modelNo+" and nodeType='"+nodeType+"'";
   return findModelFirstNodeByCondition(strSql);
 }

  /**
   * ����ģ����¶���ڵ����ϸ��Ϣ
   * @param modelNo int ģ�����
   * @param nodeNo int  ģ���ϵĽڵ����
   * @param iBusinessNo String ��ǰҵ�����
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

    //˼·����ȡ�����з���������·����Ȼ���ж�·���ϵ������ǲ������㣬ֻҪ��һ�����������㣬�Ͳ��������·���ˡ�
    //���ѷ���������·���ϵ����һ���㶼�����õġ���
   //������е�path����
    SwfPathFindByConditionsCommand swfPathFindByConditionCommand  = new SwfPathFindByConditionsCommand (nodeConditions);
    wfPathDtoList =(Collection) swfPathFindByConditionCommand.execute();
    Iterator it =wfPathDtoList.iterator();

    while (it.hasNext())
    {
      //�������������룬��Ҫ���˵�������wfcondition���������ݼ�¼��ͨ��pathno�����С�
      SwfPathDto swfPathDto = new SwfPathDto();
      swfPathDto =(SwfPathDto) it.next() ;

      //���ȹ��˵�������ѡ���õĽڵ�
      if (swfPathDto.getDefaultFlag().equals("3")  ) continue;

      //û���������Ƶ������
      if (swfPathDto.getConditionStatus().equals("1"))
      {
      }else
      {
        strSql =strSql+","+swfPathDto.getEndNodeNo();
        continue;
      }
      //������Լ��������£�����Ҫȡ�����Ե�������һһ���
      blnResult=checkPathCondition(swfPathDto,iBusinessNo);
      if (blnResult) strSql =strSql+","+swfPathDto.getEndNodeNo();
    }
     // �ж���û�з���������nodeNo
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
 * ����ģ����¶���ڵ����ϸ��Ϣ
 * @param modelNo int ģ�����
 * @param nodeNo int  ģ���ϵĽڵ����
 * @param iBusinessNo String ��ǰҵ�����
 * @throws Exception
 * @return Collection
 */
public Collection findModelPathNodes(String nodeConditions) throws Exception {
   Collection wfPathDtoList = new ArrayList();
 //������е�path����
  SwfPathFindByConditionsCommand swfPathFindByConditionCommand  = new SwfPathFindByConditionsCommand (nodeConditions);
  wfPathDtoList =(Collection) swfPathFindByConditionCommand.execute();

return wfPathDtoList;
}

  /**
   * Ѱ��nodeNoΪ��ǰNodeNo��T���͵Ľڵ�
   * @param modelNo int ģ�����
   * @param nodeNo int ��ǰ��NodeNo��ֵ
   * @throws Exception
   * @return Collection
   */
  public Collection findModelNextTNodes(int modelNo,int nodeNo) throws Exception {
      String nodeConditions = "  (modelno =" + modelNo +" and taskType ='T' and taskNo="+ nodeNo+")";
      Collection swfNodeDtoList = new ArrayList();
      //˼·����ȡ������=T���͵ģ�����taskNo=ָ��nodeNo�Ľڵ�������Ϊ�µ���һ���ڵ�����
      SwfNodeFindByConditionsCommand swfNodeFindByConditionsCommand= new SwfNodeFindByConditionsCommand(nodeConditions);
      swfNodeDtoList= (Collection) swfNodeFindByConditionsCommand.execute();
      return swfNodeDtoList;

  }

  /**
     * ����ģ����϶���ڵ����ϸ��Ϣ
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
         * ���ҹ�������ĳ��֮ǰ�϶���ڵ����ϸ��Ϣ
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
     * ����ҵ��Ų�ѯ������������־��Ϣ
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
     * �������̺Ų�ѯ����������·����Ϣ
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
     * �������̺Ų�ѯ����������·����Ϣ
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
     * �����ǲ�������·���ϵ�����
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
      //�������ÿ�ʼ����������Ϊ true

      while (itcc.hasNext())
      {
        SwfConditionDto swfConditionDto = new SwfConditionDto();
        swfConditionDto= (SwfConditionDto) itcc.next() ;

        //����ҵ����룬�ж�ҵ�����ݿ����Ƿ�����·���ϵ���������������㣬��˵������ͨ��

       //.0/1������
       if (swfConditionDto.getConfigType().equals("0")||swfConditionDto.getConfigType().equals("1"))
        {
          String strWhere = swfConditionDto.getBusinessKey().trim()+ "='" + iBusinessNo.trim() + "' AND " + swfConditionDto.getConfigText().trim();
          String strTemp= "SELECT COUNT(*) FROM " + swfConditionDto.getTableName().trim() + " WHERE " + strWhere.trim();
          SwfConditionExecuteResultCommand  wfConditionExecuteResultCommand = new SwfConditionExecuteResultCommand(strTemp);
          blnResult =((Boolean) wfConditionExecuteResultCommand.execute()).booleanValue()   ;

        }
        // 2�߼�����������function
        if (swfConditionDto.getConfigType().equals("2"))
        {
        //Ŀǰû������function (����)
         }
         //�������������,��������ѭ��
         if (!blnResult) break;
      }
      return blnResult;
    }

        /**
         * �������̺źͽڵ���ж�ռ����
         * @param flowID String
         * @param LogNo int
         * @throws Exception
         * @return boolean
         */
        public SwfLogDto holdNode(String flowID,int logNo,String userCode,String userName) throws Exception
        {
           //ռ�Ų���  (Ĭ����û��ռ�ţ�û�л�÷���Ȩ)
           boolean retHold =false;

           //�����ݿ��в�ѯ���������Ĺ������ڵ�
           SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
           SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
           if (swfLogDto.getFlowStatus().equals("2") )
           {
             //����������Ѿ���ռ���ˣ�����ǲ���ͬһ����
             if (swfLogDto.getHandlerCode().equals(userCode)) retHold=true;
             
             if (swfLogDto.getHandlerCode().equals("")) retHold=true;
           }
           else
           {
             //û�з��������£���ռ�ù����ڵ�
           	 if (!swfLogDto.getHandlerCode().equals(userCode)){
                //�������ָ���˵ģ���ռ�ţ������ָ���˵ģ����ı�flowStatus,����1��״̬
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
             //�ٴ��ж��ǲ��Ǳ���ռ�õ�???
             swfLogDto =findHoldNode(flowID,logNo,userCode);
             retHold = swfLogDto.getHoldNode() ;

           }
           swfLogDto.setHoldNode(retHold);
           return swfLogDto;
          }
        /**
         * �������̺źͽڵ���ж�ռ����
         * @param flowID String
         * @param LogNo int
         * @throws Exception
         * @return boolean
         */
        public SwfLogDto holdNodeCombine(String flowID,int logNo,String userCode,String userName) throws Exception
        {
           //ռ�Ų���  (Ĭ����û��ռ�ţ�û�л�÷���Ȩ)
           boolean retHold =false;

           //�����ݿ��в�ѯ���������Ĺ������ڵ�
           SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
           SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
           if (swfLogDto.getFlowStatus().equals("2") )
           {
             //����������Ѿ���ռ���ˣ�����ǲ���ͬһ����
             if (swfLogDto.getHandlerCode().equals(userCode)) retHold=true;
             
             if (swfLogDto.getHandlerCode().equals("")) retHold=true;
           }
           else
           {
             //û�з��������£���ռ�ù����ڵ�
           	 if (!swfLogDto.getHandlerCode().equals(userCode)){
                //�������ָ���˵ģ���ռ�ţ������ָ���˵ģ����ı�flowStatus,����1��״̬
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
             //�ٴ��ж��ǲ��Ǳ���ռ�õ�???
             swfLogDto =findHoldNode(flowID,logNo,userCode);
             retHold = swfLogDto.getHoldNode() ;

           }
           swfLogDto.setHoldNode(retHold);
           return swfLogDto;
          }

          /**
          * �������̺źͽڵ�����ͷŲ���
          * @param flowID String
          * @param LogNo int
          * @throws Exception
          * @return boolean
          */
         public void freeNode(String flowID,int logNo) throws Exception
         {
            //�������ͷ�

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
             * �������̺źͽڵ��ж��û��Ƿ���ж�ռ����
             * @param flowID String
             * @param LogNo int
             * @throws Exception
             * @return boolean
             */
            public SwfLogDto findHoldNode(String flowID,int logNo,String userCode) throws Exception
            {  boolean retBln=false;

               SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
               SwfLogDto swfLogDto= (SwfLogDto) swfLogFindByPrimaryKeyCommand.execute();
               //���ռ�õ��ڱ��ˣ�����true; ����������flowstatus��״��
               if (swfLogDto.getHandlerCode().equals(userCode))
               {
                 retBln =true;
               }

               swfLogDto.setHoldNode(retBln);
               return swfLogDto;
              }

      /**
        * ͳ�ƹ������ڵ�״̬�����Ĺ���
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
        * ͳ�ƹ������ڵ��û�״̬�����Ĺ���
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
        * ���ݱ�������ɾ������������
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
    * ��ת����ͨ��ҵ���ȡflowid
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
     * ����flowID����ɾ����ӳ�Ĺ��������̡�
     * @param flowID String
     * @throws Exception
     */
    public void deleteWorkFlow(String flowID)
        throws Exception
    {

    }
   /**
 * �������ڵ�ͳ����Ϣ
 * @param  conditions����ѯ����
 * @return Collection
 * @throws Exception
 */

 public Collection getStatStatus(String conditions) throws Exception
 {
    ClaimStatusGetStatCommand claimStatusGetStatCommand = new ClaimStatusGetStatCommand(conditions);

    return (Collection)claimStatusGetStatCommand.execute();
 }


 /**
   * ��ȡswfNotion��ǰflowID��ͬ,LogNo��ͬ,lineNo �����ĵ�maxNo
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
   * ���ҷ��������Ľڵ�ĸ���
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
   * ���ҷ��������Ľڵ�ĸ���
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
   * ���ݱ����źͱ�����,���ƺţ�����ʱ�䣬����״̬��ѯ������Ϣ
   * @param httpServletRequest ���ظ�ҳ���request
   * @param registNo       ������
   * @param policyNo       ������
   * @param licenseNo      ���ƺ���
   * @param riskCode       �ձ�
   * @param insuredName    ������������
   * @throws Exception
   */
  public void getWorkFlowList(HttpServletRequest httpServletRequest,
                                          String registNo,
                                          String policyNo,
                                          String licenseNo,
                                          String riskCode,
                                          String insuredName,int intPageNo,int intRecordPerPage) throws Exception
  {
    //��������ı����ţ�����������SQL where �Ӿ�   
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
//   ƴȨ��
     com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
     UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
     conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),httpServletRequest.getParameter("taskCodeC"),"swfLog",null);
     //��ѯ������Ϣ
     UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();

     //�õ����б���������Ϣ
     PageRecord pageRecord = null;
     String caseType   = httpServletRequest.getParameter("caseType");
     if("1".equals(caseType)){
     	pageRecord = (PageRecord)uiWorkFlowAction.findStoreNodesByConditions(conditions ,intPageNo,intRecordPerPage) ;
     }else{
     	pageRecord = (PageRecord)uiWorkFlowAction.findNodesByConditions(conditions ,intPageNo,intRecordPerPage) ;
     }
     ArrayList swfLogList = new ArrayList(); 
     swfLogList=(ArrayList)pageRecord.getResult();
     TurnPageDto turnPageDto = new TurnPageDto();//��ҳ����
       //��ѯ������һҳ�Ľṹ��
       turnPageDto.setResultList(swfLogList);
       //��ǰҳ��
       turnPageDto.setPageNo(pageRecord.getPageNo());
       //һҳ������
       turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
       //��ѯ�����Ľ��������
       turnPageDto.setTotalCount(pageRecord.getCount());
       //�����ܵ�ҳ��
       turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
       //��������
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
  //start********************************�Թ������ڵ����ɾ������,�����ص���**************************************
  //********************************************************************************************************
  /**
   * �ڲ��������ڵ㴦����Ϻ�Ҫ���ڱ����������ɵĹ�������Ϣɾ�� add by qinyongli 2005-09-09
   */
  public void deletWorkFlowForNotGrand(String conditions) throws Exception{
  	  //��ɾ�����������ϸ����
  	  if(!conditions.equals("")){
  	      SwfLogDeleteByConditionsCommand command = new SwfLogDeleteByConditionsCommand(conditions);
  	      command.execute();
  	  }
  }
  
     public void cancelBack(String flowID,int logNo) throws Exception {
        SwfLogFindByPrimaryKeyCommand swfLogFindByPrimaryKeyCommand= new SwfLogFindByPrimaryKeyCommand(flowID,logNo);
        swfLogFindByPrimaryKeyCommand.cancelBack();
    }
  //end********************************�Թ������ڵ����ɾ������,�����ص���****************************************
	public int getCount(String conditions) throws Exception {
		BLSwfLogFacade blSwfLogFacade=new BLSwfLogFacade();
		  return blSwfLogFacade.getCount(conditions);   
	}
}
