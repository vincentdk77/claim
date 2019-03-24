package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBWorkFlow;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfFlowMain;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * 理赔案件工作流模板处理action
 * <p>Title: 车险理赔 理赔案件工作流模板处理acton</p>
 * <p>Description: 车险理赔 理赔案件工作流模板处理acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLWorkFlowCombineAction
{
  private static Log logger = LogFactory.getLog(BLWorkFlowCombineAction.class);

    /**
     * 构造函数
     */
    public BLWorkFlowCombineAction(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,WorkFlowDto workFlowDto) throws Exception{
       // DBWorkFlow dbWorkFlow = new DBWorkFlow(dbManager);
        //插入记录
        //dbWorkFlow.insert(workFlowDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //删除记录
       // dbWorkFlow.delete(conditionNo, serialNo);
    }
    /**
     * 按主键删除一条节点数据wfLog
     * @param dbManager DBManager
     * @param flowID String
     * @param logNo int
     * @throws Exception
     */
    public void deleteNode(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //删除记录
        dbWorkFlow.deleteNode(dbManager,flowID, logNo);
    }


   /**
     * 按报案号删除所有工作流
     * @param dbManager DBManager
     * @param registNo
     * @throws Exception
     */
    public void deleteByRegistNo(DBManager dbManager,String registNo) throws Exception{

        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //删除记录
        String flowId ="";
       String condition ="  businessno ='" + registNo +"' and nodeType='regis'";
       Collection swfLogList = new ArrayList();
       SwfLogDto swfLogDto = new SwfLogDto();
       DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
       DBSwfPathLog dbSwfPathLog  = new DBSwfPathLog (dbManager);
       DBSwfFlowMain dbSwfFlowMain  = new DBSwfFlowMain (dbManager);

       swfLogList =dbSwfLog.findByConditions(condition,0,0) ;
       Iterator it = swfLogList.iterator() ;
       while (it.hasNext() )
       { swfLogDto = (SwfLogDto)it.next();
         flowId = swfLogDto.getFlowID();
       }
       if (!flowId.equals(""))
       {
       String deleteStr = "flowid ='"+ flowId+"'";
       dbSwfPathLog.deleteByConditions(deleteStr) ;
       dbSwfLog.deleteByConditions(deleteStr) ;
       dbSwfFlowMain.delete(flowId)  ;

       }

    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //按条件删除记录
        //dbWorkFlow.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void update(DBManager dbManager,WorkFlowDto workFlowDto) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //更新记录
        //dbWorkFlow.update(workFlowDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @return workFlowDto workFlowDto
     * @throws Exception
     */
    public WorkFlowDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //声明DTO
        WorkFlowDto workFlowDto = null;
        //查询数据,赋值给DTO
        //workFlowDto = dbWorkFlow.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return workFlowDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

       // int count = dbWorkFlow.getCount(SqlUtils.getWherePartForGetCount(conditions));
       // collection = dbWorkFlow.findByConditions(conditions,pageNo,rowsPerPage);
       // PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);

       PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,collection);
       return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含workFlowDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

     //   collection = dbWorkFlow.findByConditions(conditions,0,0);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions)
        throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count=0;
       // int count = dbWorkFlow.getCount(conditions);
        return count;
    }

    /**
     * 创建工作流
     * @param dbManager DBManager
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     */

    public String createFlow(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         String  flowID="";
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

       flowID= dbWorkFlow.createFlow(dbManager,workFlowDto);
        return flowID;
    }

    /**
     * 关闭工作流
     * @param dbManager DB管理器
     * @param flowID 工作流号码
     * @return //
     * @throws Exception
     */
    public void closeFlow(DBManager dbManager,String flowID)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

        dbWorkFlow.closeFlow(dbManager,flowID);
        return ;
    }

    /**
     * 3.4.3.   收回工作流
     * @param dbManager DB管理器
     * @param workFlowDto workFlowDto
     * @return //
     * @throws Exception
     */
    public void recycleFlow(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

        dbWorkFlow.recycleFlow(dbManager,workFlowDto);
        return ;
    }
    /**
      * 关闭工作流
      * @param dbManager DBManager
      * @param workFlowDto WorkFlowDto
      * @throws Exception
      */

   public void closeFlow(DBManager dbManager,WorkFlowDto workFlowDto)
       throws Exception{
       DBWorkFlow dbWorkFlow = new DBWorkFlow();
       dbWorkFlow.closeFlow(dbManager,workFlowDto);
       return ;
   }

   /**
    * 关闭并转储工作流
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */
   public void closeAndStoreFlow(DBManager dbManager,WorkFlowDto workFlowDto)
   throws Exception{
	   DBWorkFlow dbWorkFlow = new DBWorkFlow();
       dbWorkFlow.closeAndStoreFlow(dbManager,workFlowDto);
       return ;
   }
   /**
    * 转储工作流
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */

 public void storeFlow(DBManager dbManager,WorkFlowDto workFlowDto)
     throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.storeFlow(dbManager,workFlowDto);
     return ;
 }
   /**
    * 重开工作流
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */

 public void reOpenFlow(DBManager dbManager,WorkFlowDto workFlowDto)
     throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.reOpenFlow(dbManager,workFlowDto);
     return ;
 }
   /**
        * 工作流提交节点信息
        * @param dbManager DBManager
        * @param workFlowDto WorkFlowDto
        * @throws Exception
        */

    public String submitNode(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         String  flowID="";
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

       flowID= dbWorkFlow.submitNode(dbManager,workFlowDto);
        return flowID;
    }
    /**
     * 工作流更新节点信息
     * @param dbManager DBManager
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     */
    public void updateNode(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();
         dbWorkFlow.updateNode(dbManager,workFlowDto);
         return;
    }
/**
 * 释放所有该用户的占号信息
 * @param dbManager
 * @param workFlowDto
 * @throws Exception
 */
    public void freeAllHoldNode(DBManager dbManager,WorkFlowDto workFlowDto)
    throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.freeAllHoldNode(dbManager,workFlowDto);
     return;
}
	
    /**
     * 工作流处理主过程
     * @param dbManager DBManager DB管理器
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     * @return String
     */
    public void deal(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
    	
    	
    	ArrayList workFlowDtoList = workFlowDto.getWorkFlowDtoList();
    	for(int i=0;i<workFlowDtoList.size();i++){
    		WorkFlowDto workFlowDto2 = (WorkFlowDto)workFlowDtoList.get(i);
	       //DBWorkFlow dbWorkFlow = new DBWorkFlow();
	       //创建工作流
	       if (workFlowDto2.getCreate() )
	       {
	         createFlow(dbManager,workFlowDto2);
	       }
	      //     重开工作流程
	       if (workFlowDto2.getReOpen() )
	       {
	       	reOpenFlow(dbManager,workFlowDto2);
	       }
	       //提交-工作流 (先提交，后修改？？)
	       if (workFlowDto2.getSubmit() )
	       {
	         submitNode(dbManager,workFlowDto2);
	       }
	       //判断是不是释放所有占号的操作
	       if (workFlowDto2.getFreeHoldNode () )
	       {
	         freeAllHoldNode(dbManager,workFlowDto2);
	       }
	       //修改工作流
	       if (workFlowDto2.getUpdate() )
	       {
	         updateNode(dbManager,workFlowDto2);
	       }
	       //关闭-工作流
	       if (workFlowDto2.getClose() )
	       {
	    	   closeAndStoreFlow(dbManager,workFlowDto2);
	       }
	       //收回-工作流
	       if (workFlowDto2.getRecycle() )
	       {
	         recycleFlow(dbManager,workFlowDto2);
	       }
       }
    }

    /**
    * 按主键查找当前系统所使用的工作流的模板号码
    * @param dbManager DB管理器
    * @param riskCode 险种编码
    * @param comCode 归属机构编码

    * @return modelNo
    * @throws Exception
    */
   public int getModelNo(DBManager dbManager,String riskCode,String comCode) throws Exception{

       int modelNo=-1;
       DBWorkFlow dbWorkFlow = new DBWorkFlow();
       //查询数据,赋值给DTO
       modelNo = dbWorkFlow.getModelNo(dbManager,riskCode,comCode);
       return modelNo;
   }

   /**
     * 按条件统计数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @throws Exception
     */
    public Collection getStatStatus(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        return collection = dbSwfLog.getStatStatus(conditions);
    }

  /**
     * 删除注销/拒赔任务（即为退回注销/拒赔任务）add 2005-11-24
     * @param flowID 流程号
     * @param logNo  序号
     * @throws Exception
     * */
    public void cancelBack(DBManager dbManager, String flowID, int logNo) throws Exception {
        String strSwfPathLog = " FlowID='" + flowID + "' and EndNodeNo=" + logNo;
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
        SwfLogDto swfLogDto = new SwfLogDto();
        UIWorkFlowAction uiWorkFlowAction =new UIWorkFlowAction();
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        String notion = "";
        PrpDuserDto prpDuser = new PrpDuserDto();
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        
        //找到注销/拒赔的这条边
        ArrayList swfPathLogList = (ArrayList) dbSwfPathLog.findByConditions(strSwfPathLog);
        if (swfPathLogList != null && swfPathLogList.size() > 0) {
            swfPathLogDto = (SwfPathLogDto) swfPathLogList.get(0);
        } else {
            throw new Exception("由于数据问题不能回退，请检查数据！");
        }
        
        //找到申请注销/拒赔的这个节点
        swfLogDto = (SwfLogDto) dbSwfLog.findByPrimaryKey(flowID, swfPathLogDto.getStartNodeNo());
        String strPrpLclaimStatus = " BusinessNo='" + swfLogDto.getKeyOut() + "' and NodeType='claim'";
        ArrayList prpLclaimStatusList = (ArrayList) dbPrpLclaimStatus.findByConditions(strPrpLclaimStatus);
        if (prpLclaimStatusList != null && prpLclaimStatusList.size() > 0) {
            prpLclaimStatusDto = (PrpLclaimStatusDto) prpLclaimStatusList.get(0);
        }
       
        if (swfLogDto.getNodeType().equals("claim")) {
            swfLogDto.setNodeStatus("2");
            swfLogDto.setBusinessNo(swfLogDto.getKeyIn());
            if (prpLclaimStatusDto != null) {
                prpLclaimStatusDto.setStatus("2");
            }
        } else {
            swfLogDto.setNodeStatus("0");
            swfLogDto.setKeyOut(null);
            swfLogDto.setHandlerCode(null);
            swfLogDto.setHandlerName(null);
            swfLogDto.setSubmitTime(null);
        }
        
        //保存日志信息
        int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(flowID,logNo);
        SwfNotionDto swfNotionDto = new SwfNotionDto();
        swfNotionDto.setFlowID(flowID);
        swfNotionDto.setLogNo(logNo);
        swfNotionDto.setLineNo(maxLineNo);
        notion = swfLogDto.getHandlerName() + "在" + swfLogDto.getNodeName() + "节点的案件" 
                 + swfLogDto.getKeyIn()
                 + "被回退";
        if (notion.length() >35) {
            notion=notion.substring(0,35)+"...";
        }
        
        swfNotionDto.setHandleText(notion);
        dbSwfNotion.insert(swfNotionDto);
        dbSwfLog.delete(flowID, logNo);
        dbSwfPathLog.delete(flowID, swfPathLogDto.getPathNo());
        dbSwfLog.update(swfLogDto);
        dbPrpLclaimStatus.update(prpLclaimStatusDto);
    }

}
