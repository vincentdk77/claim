package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfCondition;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelMain;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNode;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPath;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔工作流模板处理数据库管理对象
 * <p>
 * Title: 车险理赔理赔工作流模板处理数据管理
 * </p>
 * <p>
 * Description: 车险理赔理赔工作流模板处理数据管理
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class DBWorkFlowModel {
    private DBManager dbManager = null; //资源管理类

    /**
     * 构造函数
     * 
     * @param dbManager 资源管理类
     */
    public DBWorkFlowModel() {
    }

    /**
     * 理赔工作流模板处理取消的方法
     * 
     * @param workFlowModelDto 理赔工作流模板处理任务取消的对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void cancelWorkFlowModel(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException,
            Exception {
        cancelInfo(dbManager, workFlowModelDto);
        updateWorkFlowModelNew(dbManager, workFlowModelDto, "0");

    }

    /**
     * 理赔工作流模板处理任务取回并保存的方法
     * 
     * @param workFlowModelDto 理赔工作流模板处理任务取回并保存的对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void getBackUpdate(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        deleteSubInfo(dbManager, workFlowModelDto);
        insert(dbManager, workFlowModelDto);
    }

    /**
     * 理赔工作流模板处理保存方法
     * 
     * @param workFlowModelDto 理赔工作流模板处理对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void insert(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        if (workFlowModelDto.getSwfModelMainDto() == null) {
            throw new Exception();
        }
        int modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        //首先删除原来的相关数据
        String statement = " DELETE FROM swfPath Where modelNo = " + modelNo;
        dbManager.executeUpdate(statement);
        statement = " DELETE FROM swfNode Where modelNo = " + modelNo;
        dbManager.executeUpdate(statement);
        //如果已有分配数据，当模板不可用的要删除已分配数据
        if (!workFlowModelDto.getSwfModelMainDto().getModelStatus().equals("1")) {
            statement = " DELETE FROM swfModelUse Where modelNo= " + modelNo + " AND modelStatus='"
                    + workFlowModelDto.getSwfModelMainDto().getModelStatus() + "'";
            dbManager.executeUpdate(statement);
        }
        DBSwfModelMain dbSwfModelMain = new DBSwfModelMain(dbManager);
        if (dbSwfModelMain.findByPrimaryKey(modelNo) != null) {
            dbSwfModelMain.update(workFlowModelDto.getSwfModelMainDto());
        } else {
            dbSwfModelMain.insert(workFlowModelDto.getSwfModelMainDto());
        }
        if (workFlowModelDto.getSwfNodeDtoList() != null) {
            new DBSwfNode(dbManager).insertAll(workFlowModelDto.getSwfNodeDtoList());
        }
        if (workFlowModelDto.getSwfPathDtoList() != null) {
            new DBSwfPath(dbManager).insertAll(workFlowModelDto.getSwfPathDtoList());
        }
    }

    /**
     * 理赔工作流模板处理删除子表信息
     * 
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        int modelNo = 0; //模板号
        String modelStatus = "";//模板状态
        modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        modelStatus = workFlowModelDto.getSwfModelMainDto().getModelStatus();
        String statement = "";
        String stateWhere = "";
        if (workFlowModelDto.getSwfModelMainDto() != null) {
            //先删除workFlowModelItem的内容

            stateWhere = "modelNo = " + modelNo;
            statement = " DELETE FROM swfPath Where " + stateWhere;
            System.out.println("dbWorkFlowModel=" + statement);
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM swfNode Where " + stateWhere;
            System.out.println("dbWorkFlowModel=" + statement);
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM swfModelMain Where " + stateWhere;
            System.out.println("dbWorkFlowModel=" + statement);
            dbManager.executeUpdate(statement);

            //如果已有分配数据，当模板不可用的要删除已分配数据
            if (!modelStatus.equals("1")) {
                statement = " DELETE FROM swfModelUse Where " + stateWhere + " AND modelStatus='" + modelStatus + "'";
                System.out.println("dbWorkFlowModel=" + statement);
                dbManager.executeUpdate(statement);
            }

        }
    }

    /**
     * 状态删除
     * 
     * @param fcoWorkFlowModelNewNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String registNo) throws SQLException, Exception {
        //示例未完成
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
        //示例未完成
        //statement = " DELETE FROM prpLWorkFlowModelMaint Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /**
     * 状态删除
     * 
     * @param fcoWorkFlowModelMainticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, int workFlowModelID, String registNo) throws SQLException, Exception {
        //示例未完成
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'" + " AND workFlowModelId ="
                + workFlowModelID + " ";
        //示例未完成
        statement = " DELETE FROM prpLWorkFlowModelMain Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /*
     * 理赔工作流模板处理查询方法 @param workFlowModelDto 理赔工作流模板处理对象 @throws SQLException @throws Exception @return 无
     */
    public WorkFlowModelDto findByPrimaryKey(DBManager dbManager, int modelNo) throws SQLException, Exception {
        String conditions = " modelNo=" + modelNo;
        WorkFlowModelDto workFlowModelDto = new WorkFlowModelDto();
        System.out.println("conditions=" + conditions);
        workFlowModelDto.setSwfModelMainDto(new DBSwfModelMain(dbManager).findByPrimaryKey(modelNo));
        System.out.println("conditions=" + conditions);
        workFlowModelDto.setSwfNodeDtoList((ArrayList) new DBSwfNode(dbManager).findByConditions(conditions));
        workFlowModelDto.setSwfPathDtoList((ArrayList) new DBSwfPath(dbManager).findByConditions(conditions));
        workFlowModelDto.setSwfConditionDtoList((ArrayList) new DBSwfCondition(dbManager).findByConditions(conditions));
        return workFlowModelDto;
    }

    /**
     * 变更调度的操作状态的方法
     * 
     * @param workFlowModelDto 调度对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void updateClaimStatus(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException,
            Exception {

        //示例未完成
        String statement = "";

    }

    /**
     * 变更调度后的新案件提示表状态的方法
     * 
     * @param workFlowModelDto 调度对象
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public void updateWorkFlowModelNew(DBManager dbManager, WorkFlowModelDto workFlowModelDto, String workFlowModelFlag)
            throws SQLException, Exception {

        //示例未完成
        String statement = " Update prplworkFlowModelNew set WorkFlowModelFlag='" + workFlowModelFlag
                + "' Where registNo='" + workFlowModelDto.getSwfModelMainDto().getModelNo() + "' AND surveyNo=";

        dbManager.executeUpdate(statement);

    }

    /**
     * 理赔工作流模板处理撤消子表信息
     * 
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void cancelInfo(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        int modelNo = 0; //模板号
        modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        String statement = "";
        String stateWhere = "";
        if (workFlowModelDto.getSwfModelMainDto() != null) {
            //先删除workFlowModelItem的内容

            stateWhere = "modelNo = " + modelNo;
            statement = " DELETE FROM swfPath Where " + stateWhere;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM swfNode Where " + stateWhere;
            dbManager.executeUpdate(statement);

            statement = " DELETE FROM swfModelMain Where " + stateWhere;
            dbManager.executeUpdate(statement);
        }
    }

    /**
     * 模板号取得方法
     * 
     * @param DBManager
     * @throws SQLException
     * @throws Exception
     * @return 无
     */
    public int getModelNo(DBManager dbManager) throws SQLException, Exception {
        return new DBSwfModelMain(dbManager).getModelNo();
    }

}