package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;

import com.sinosoft.claim.bl.facade.BLPrpDriskFacade;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfLogStoreDto;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfFlowMain;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLogStore;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelUse;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔工作流流程处理处理数据库管理对象
 * <p>
 * Title: 车险理赔理赔工作流流程处理处理数据管理
 * </p>
 * <p>
 * Description: 车险理赔理赔工作流流程处理处理数据管理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * @author liubvo
 * @version 1.0
 */
public class DBWorkFlow {
    private DBManager dbManager = null; // 资源管理类

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBWorkFlow() {
    }

    /**
     * 理赔工作流流程处理处理取消的方法
     * @param workFlowDto 理赔工作流流程处理处理任务取消的对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void cancelWorkFlow(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        cancelInfo(dbManager, workFlowDto);
        updateWorkFlowNew(dbManager, workFlowDto, "0");

    }

    /**
     * 理赔工作流流程处理处理任务取回并保存的方法
     * @param workFlowDto 理赔工作流流程处理处理任务取回并保存的对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void getBackUpdate(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        deleteSubInfo(dbManager, workFlowDto);
        insert(dbManager, workFlowDto);
    }

    /**
     * 理赔工作流流程处理处理保存方法
     * @param workFlowDto 理赔工作流流程处理处理对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void insert(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        if (workFlowDto.getSwfFlowMainDto() == null) {
            throw new Exception();
        }

        // 首先删除原来的相关数据
        // deleteSubInfo(dbManager,workFlowDto);
        if (workFlowDto.getSwfFlowMainDto() != null) {
            new DBSwfFlowMain(dbManager)
                    .insert(workFlowDto.getSwfFlowMainDto());

            // 还需要保存需要查勘的信息到相应的查勘信息表中

        }

        // 进行新案件提示表的案件状态改变

        updateWorkFlowNew(dbManager, workFlowDto, "1");
    }

    /**
     * 理赔工作流流程处理处理删除子表信息
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // 示例未完成
        String statement = "";
        if (workFlowDto.getSwfFlowMainDto() != null) {
            // 先删除workFlowItem的内容

            String condition3 = " registNo='";
            statement = " DELETE FROM prpLworkFlowItem Where " + condition3;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM prpLcheckItem Where " + condition3;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM WfFlowMain Where " + condition3;
            dbManager.executeUpdate(statement);
        }
    }

    /**
     * 状态删除
     * @param fcoWorkFlowNewNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String registNo)
            throws SQLException, Exception {
        // 示例未完成
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo)
                + "'";
        // 示例未完成
        // statement = " DELETE FROM WfFlowMaint Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /**
     * 状态删除
     * @param fcoWorkFlowMainticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, int workFlowID, String registNo)
            throws SQLException, Exception {
        // 示例未完成
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo)
                + "'" + " AND workFlowId =" + workFlowID + " ";
        // 示例未完成
        statement = " DELETE FROM WfFlowMain Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /*
     * 理赔工作流流程处理处理查询方法 @param workFlowDto 理赔工作流流程处理处理对象 @throws SQLException
     * @throws Exception @return 无
     */
    public WorkFlowDto findByPrimaryKey(DBManager dbManager, int workFlowID,
            String registNo) throws SQLException, Exception {
        String conditions = " registNo= '" + registNo + "' AND workFlowID="
                + workFlowID;
        WorkFlowDto workFlowDto = new WorkFlowDto();

        return workFlowDto;
    }

    /**
     * 变更调度后的新案件提示表状态的方法
     * @param workFlowDto 调度对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void updateWorkFlowNew(DBManager dbManager, WorkFlowDto workFlowDto,
            String workFlowFlag) throws SQLException, Exception {

        // 示例未完成
        String statement = " Update prplworkFlowNew set ";

        dbManager.executeUpdate(statement);

    }

    /**
     * 理赔工作流流程处理处理撤消子表信息
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void cancelInfo(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // 示例未完成
        String statement = "";
        if (workFlowDto.getSwfFlowMainDto() != null) {
            // 先删除workFlowItem的内容

            String condition3 = " registNo='";
            statement = " DELETE FROM prpLworkFlowItem Where " + condition3;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM prpLcheckItem Where " + condition3;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM WfFlowMain Where " + condition3;
            dbManager.executeUpdate(statement);

            String condition4 = " BusinessNo='";

            statement = " DELETE FROM prpLclaimStatus Where " + condition4;

            dbManager.executeUpdate(statement);

        }
    }

    public String createFlow(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // 1.读取模板的号码 不成功直接报错
        // 2.查询出模板的第1个开始节点,暂时认为开始节点为 1
        // 3.从wfflowMain表中取得flowId的值，
        // 4。在wflog表建立和模板的nodeNo相同值的节点，
        // 5。设置wflog表该数据的该节点的状态为正在处理。

        // 以上是数据整理过程，之后的结果只需要插数据库就可以了。。
        // 创建工作流需要保存的表：（1）wfFlowMain
        // (2) wfLog

        String flowID = "";
        // WfNodeDto wfNodeDto = new WfNodeDto();
        // wfNodeDto = new DBWfNode(dbManager).findByPrimaryKey(modelNo,nodeNo)
        // ;

        // workFlowDto.getWfFlowMainDto().

        // 查询出该模板任务的第一条记录

        if (workFlowDto.getCreateSwfFlowMainDto() != null) {
            new DBSwfFlowMain(dbManager).insert(workFlowDto
                    .getCreateSwfFlowMainDto());

            if (workFlowDto.getCreateSwfLogDto() != null) {
                new DBSwfLog(dbManager)
                        .insert(workFlowDto.getCreateSwfLogDto());
            }

            flowID = workFlowDto.getCreateSwfFlowMainDto().getFlowID();
        }
        return flowID;
    }

    public void closeAndStoreFlow(DBManager dbManager,WorkFlowDto workFlowDto)
            throws SQLException, Exception {
    	if(workFlowDto.getCloseSwfFlowMainDto() != null){
        	String flowID = workFlowDto.getCloseSwfFlowMainDto().getFlowID();
            // 1.数据转储
            storeFlow(dbManager, workFlowDto);
            // 2.变更工作流主表的状态位置
            String statement = " update SWfFlowMain set  FlowStatus='0',StoreFlag='1' Where flowID='"
                    + flowID + "'";
            dbManager.executeUpdate(statement);
            // statement = " update SWflog set FlowStatus='0' Where flowID='" +
            // flowID+"'";
            statement = " DELETE FROM SwfLog Where flowID='" + flowID + "'";
            dbManager.executeUpdate(statement);
            //statement = " DELETE FROM SwfPathLog Where flowID='" + flowID + "'";
            //dbManager.executeUpdate(statement);
    	}
    }

    public void closeFlow(DBManager dbManager, String flowID)
			throws SQLException, Exception {
		// 1.变更工作流主表的状态位置
		//storeFlow(dbManager, workFlowDto);
		String statement = " update SWfFlowMain set  FlowStatus='0',StoreFlag='1' Where flowID='"
				+ flowID + "'";
		dbManager.executeUpdate(statement);
		// statement = " update SWflog set FlowStatus='0' Where flowID='" +
		// flowID+"'";
		statement = " DELETE FROM SwfLog Where flowID='" + flowID + "'";
		dbManager.executeUpdate(statement);
		// statement = " DELETE FROM SwfPathLog Where flowID='" + flowID + "'";
		// dbManager.executeUpdate(statement);
	}
    // 备份工作流的数据
    public void storeFlow(DBManager dbManager,WorkFlowDto workFlowDto )
            throws SQLException, Exception {
    	if(workFlowDto.getCloseSwfFlowMainDto() != null){
    		String flowID = workFlowDto.getCloseSwfFlowMainDto().getFlowID();
            String conditions = " flowid ='" + flowID + "'";
            ArrayList swfLogList = (ArrayList) new DBSwfLog(dbManager)
                    .findByConditions(conditions);
            //ArrayList swfPathLogList = (ArrayList) new DBSwfPathLog(dbManager)
            //        .findByConditions(conditions);
            ArrayList swfLogStoreList = new ArrayList();
            //ArrayList swfPathLogStoreList = new ArrayList();
            for (int i = 0; i < swfLogList.size(); i++) {
                SwfLogDto swfLogDto = (SwfLogDto) swfLogList.get(i);
                // reason:存储表里的flowstatus的数据应该为0的。。。
                swfLogDto.setFlowStatus("0");
                // 并且理算节点也应该为提交的状态
                if (swfLogDto.getTaskType().equals("M"))
                    swfLogDto.setNodeStatus("4");
                // add by lixiang add 20050624 end

                SwfLogStoreDto swfLogStoreDto = new SwfLogStoreDto();
                PropertyUtils.copyProperties(swfLogStoreDto, swfLogDto);
                swfLogStoreList.add(swfLogStoreDto);
            }

           /* for (int i = 0; i < swfPathLogList.size(); i++) {
                SwfPathLogDto swfPathLogDto = (SwfPathLogDto) swfPathLogList.get(i);
                SwfPathLogDto swfPathLogStoreDto = new SwfPathLogDto();

                PropertyUtils.copyProperties(swfPathLogStoreDto, swfPathLogDto);
                swfPathLogStoreList.add(swfPathLogStoreDto);
            }*/

            new DBSwfLogStore(dbManager).insertAll(swfLogStoreList);
           // new DBSwfPathLog(dbManager).insertAll(swfPathLogStoreList);
    	}
    }

    public void closeFlow(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // 1.变更工作流主表的状态位置
        if (workFlowDto.getCloseSwfFlowMainDto() != null) {
            new DBSwfFlowMain(dbManager).delete(workFlowDto
                    .getCloseSwfFlowMainDto().getFlowID());
            new DBSwfFlowMain(dbManager).insert(workFlowDto
                    .getCloseSwfFlowMainDto());
            // 先暂时把所有的=0的数据都给变成4吧
            // String statement = " update SWfLog set nodeStatus='4' "
            // + " Where flowID='" +
            // workFlowDto.getCloseSwfFlowMainDto().getFlowID()
            // + "' and (taskType='M' or nodeType='certa' or nodeType='verif')
            // ";

            String statement = " update SWfLog set  nodeStatus='4' "
                    + " Where flowID='"
                    + workFlowDto.getCloseSwfFlowMainDto().getFlowID()
                    + "' and (taskType='M')";
            dbManager.executeUpdate(statement);
            statement = " update SWflog set FlowStatus='0' Where flowID='"
                    + workFlowDto.getCloseSwfFlowMainDto().getFlowID() + "'";
            dbManager.executeUpdate(statement);

        }

        return;
    }

    public void reOpenFlow(DBManager dbManager, WorkFlowDto workFlowDto)
			throws SQLException, Exception {
		if (workFlowDto.getReOpenSwfFlowMainDto() != null) {
			//1.变更工作流主表的状态位置
			new DBSwfFlowMain(dbManager).delete(workFlowDto
					.getReOpenSwfFlowMainDto().getFlowID());
			workFlowDto.getReOpenSwfFlowMainDto().setStoreFlag("0");
			new DBSwfFlowMain(dbManager).insert(workFlowDto
					.getReOpenSwfFlowMainDto());
			//2.从转储表取数据并存入Swflog表
			String statement = " flowid ='" + workFlowDto.getReOpenSwfFlowMainDto().getFlowID() + "'";
			ArrayList swfLogStoreList = (ArrayList) new DBSwfLogStore(dbManager)
            	.findByConditions(statement);
			for(int i = 0; i < swfLogStoreList.size(); i++){
				SwfLogDto swfLogDto = (SwfLogDto) swfLogStoreList.get(i);
	            swfLogDto.setFlowStatus("1");
			}
			new DBSwfLog(dbManager).insertAll(swfLogStoreList);
			//3.删除转储表数据
			statement = " DELETE FROM SwfLogStore Where flowID='" + workFlowDto.getReOpenSwfFlowMainDto().getFlowID() + "'";
			dbManager.executeUpdate(statement);

		}

		return;
	}


    /**
	 * 收回工作流<br>
	 * 实现逻辑为（注意下列操作必须在一个事务处理中,并swfPathLog中的startNodeNo/endNodeNo实际存储的不是nodeNo而是logNo）<br>
	 * <li>获得校验选中记录当前节点，根据当前节点获取所有后续节点,如果没有后续节点则抛出异常“没有下级节点，不能收回”
	 * <li>根据当前节点获取所有后续节点是否为待处理状态（swfLog.nodestatus=’0’未处理），如果有已处理的，则抛出异常“下一节点正在处理，不能收回”
	 * <li>删除Swflog表当前节点的所有后续节点数据，
	 * <li>删除swfpathlog所有后续节点数据
	 * <li>将Swflog表当前节点的节点状态nodestatus设置为“2”正在处理
	 * <li>更新表PrpLclaimStatus
	 * 
	 * @param dbManager
	 * @param workFlowDto
	 * @throws SQLException
	 * @throws Exception
	 */
    public void recycleFlow(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        String flowID = workFlowDto.getUpdateSwfLogDto().getFlowID();
        int logNo = workFlowDto.getUpdateSwfLogDto().getLogNo();
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        SwfLogDto swfLogDto = dbSwfLog.findByPrimaryKey(flowID, logNo);
        String conditions = "flowID = '" + flowID + "' AND (logNo in "
                + "(Select endNodeNo from swfPathLog Where flowID = '" + flowID
                + "' AND startNodeNo = " + logNo + "))";
        Collection result = dbSwfLog.findByConditions(conditions, 1, 1);
        if (result.size() == 0) {
            throw new Exception("没有下级节点，不能收回！");
        }

        result = dbSwfLog.findByConditions(conditions + " AND nodestatus!='0'",
                1, 1);
        if (result.size() > 0) {
            throw new Exception("下一节点正在处理，不能收回！");
        }
        
        //增加判断单证的过程
        
        if (swfLogDto.getNodeType ().equals( "certi")){
        	//如果是单证模式，需要检查是否已出计算书，如果出了，则不能进行回收操作
        	
        	result = dbSwfLog.findByConditions("flowID = '" + flowID + "' AND nodetype='compp' ");
            if (result.size() > 0) {
                throw new Exception("已出赔款计算书，不能收回！");
            }
        }

        dbSwfLog.deleteByConditions(conditions);

        conditions = "flowID = '" + flowID + "' AND startNodeNo = " + logNo;
        new DBSwfPathLog(dbManager).deleteByConditions(conditions);
        String statement = " update SWfLog set  nodeStatus='2' "
                + " Where flowID='" + flowID + "' and logNo = " + logNo;
        dbManager.executeUpdate(statement);
        // 更新表PrpLclaimStatus
        statement = " update PrpLclaimStatus set Status='2' "
                + " Where NodeType = '" + swfLogDto.getNodeType()
                + "' AND BusinessNo='" + swfLogDto.getBusinessNo() + "'";
        dbManager.executeUpdate(statement); 
    }

    public String submitNode(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {

        // String flowID=workFlowDto.getWfFlowMainDto().getFlowID() ;

        String flowID = "";

        if (workFlowDto.getSubmitSwfLogDtoList() != null) {
            new DBSwfLog(dbManager).insertAll(workFlowDto
                    .getSubmitSwfLogDtoList());
        }

        if (workFlowDto.getSubmitSwfPathLogDtoList() != null) {
            new DBSwfPathLog(dbManager).insertAll(workFlowDto
                    .getSubmitSwfPathLogDtoList());
        }

        return flowID;
    }

    /**
     * 更新节点的状态 和keyOut 的logno号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public void updateNode(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        if (workFlowDto.getUpdateSwfLogDto() != null) {
            new DBSwfLog(dbManager).delete(workFlowDto.getUpdateSwfLogDto()
                    .getFlowID(), workFlowDto.getUpdateSwfLogDto().getLogNo());
            new DBSwfLog(dbManager).insert(workFlowDto.getUpdateSwfLogDto());
        }
        //add by lixiang start 2006-6-8
        //reason:增加工作update时候，可以同时更新两个dto的能力
        if (workFlowDto.getUpdateSwfLog2Dto() !=null)
        {
        new DBSwfLog(dbManager).delete(workFlowDto.getUpdateSwfLog2Dto().getFlowID(),workFlowDto.getUpdateSwfLog2Dto().getLogNo() );
        new DBSwfLog(dbManager).insert(workFlowDto.getUpdateSwfLog2Dto()) ;
     	  
        }
        //add by lixiang end 2006-6-8
        // 保存办理意见
        if (workFlowDto.getSwfNotionDtoList() != null
                && workFlowDto.getSwfNotionDtoList().size() > 0) {
            new DBSwfNotion(dbManager).insertAll(workFlowDto
                    .getSwfNotionDtoList());
        }

    }

    /**
     * 释放所有占号，要和updateSwfLog进行连用的号
     * @param flowID
     * @return LogNo
     * @throws Exception
     */
    public void freeAllHoldNode(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        if (workFlowDto.getUpdateSwfLogDto() != null) {

            String statement = " update SWfLog set handlerCode=null, "
                    + " handlerName=null,"
                    + " flowStatus='1' "
                    + " Where (nodeStatus='0')"
                    + " and handlerCode='"
                    + workFlowDto.getUpdateSwfLogDto().getHandlerCode()
                    + "' and flowstatus='2'";
            dbManager.executeUpdate(statement);
        }

    }

    /**
     * 状态一个节点内容
     * @param dbManager DBManager
     * @param flowID String
     * @param logNo int
     * @throws SQLException
     * @throws Exception
     */
    public void deleteNode(DBManager dbManager, String flowID, int logNo)
            throws SQLException, Exception {
        // 示例未完成
        new DBSwfLog(dbManager).delete(flowID, logNo);

    }

    /**
     * 获取当前系统使用的模板号码
     * @param dbManager DBManager
     * @param riskCode
     * @param comCode
     * @throws SQLException
     * @throws Exception
     */
    public int getModelNo(DBManager dbManager, String riskCode, String comCode)
            throws SQLException, Exception {
        // 示例未完成
        int modelNo = -1;
        SwfModelUseDto swfModelUseDto = null;
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        // swfModelUserDto = dbSwfModelUse.findByPrimaryKey(riskCode,)
        String condition = " riskCode ='" + riskCode + "' and comCode='"
                + comCode + "'" + " and modelType='01' ";
        //modified by dongkun //走89号模板的险种 start==
        ArrayList<SwfModelUseDto> modelUseList = (ArrayList)dbSwfModelUse.findByConditions(condition);
        
        BLPrpDriskFacade blPrpDriskFacade = new BLPrpDriskFacade();
        ArrayList<PrpDriskDto> prpDriskDtos = new ArrayList<PrpDriskDto>();
        String classCodeStr = AppConfig.get("sysconst.PROP_VERIFY_CLASS").trim();//取走89号模板的险类
        String riskcodeStr = "";//走89号模板的险种的字符串
        String[] classCodeArr = classCodeStr.split(",");
        String conditions = "";
        if(classCodeArr != null){
        	conditions += " classcode in('";
        	for(int i=0;i<classCodeArr.length;i++){
        		conditions += classCodeArr[i]+"',";
        	}
        	conditions = conditions.substring(0,conditions.length()-1);//删除最后的","号
        	conditions += ")";
        	
        	prpDriskDtos = (ArrayList<PrpDriskDto>)blPrpDriskFacade.findByConditions(conditions);
        }
        if(prpDriskDtos != null && prpDriskDtos.size()>0){
        	for(int i=0;i<prpDriskDtos.size();i++){
        		PrpDriskDto prpDriskDto = prpDriskDtos.get(i); 
        		riskcodeStr += prpDriskDto.getRiskCode()+";";
        	}
        }
        
        for(int i=0;i<modelUseList.size();i++){
        	swfModelUseDto = modelUseList.get(i);
            modelNo = swfModelUseDto.getModelNo();
            if( riskcodeStr.indexOf(riskCode)>0 && modelNo==89){//保证以前的modelno=1的案子可以做
            	modelNo=89;
            	break;
            }
        }

        return modelNo;
    }

}
