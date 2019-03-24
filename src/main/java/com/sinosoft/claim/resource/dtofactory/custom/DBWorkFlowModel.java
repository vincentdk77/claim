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
 * ���⹤����ģ�崦�����ݿ�������
 * <p>
 * Title: �����������⹤����ģ�崦�����ݹ���
 * </p>
 * <p>
 * Description: �����������⹤����ģ�崦�����ݹ���
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
    private DBManager dbManager = null; //��Դ������

    /**
     * ���캯��
     * 
     * @param dbManager ��Դ������
     */
    public DBWorkFlowModel() {
    }

    /**
     * ���⹤����ģ�崦��ȡ���ķ���
     * 
     * @param workFlowModelDto ���⹤����ģ�崦������ȡ���Ķ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void cancelWorkFlowModel(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException,
            Exception {
        cancelInfo(dbManager, workFlowModelDto);
        updateWorkFlowModelNew(dbManager, workFlowModelDto, "0");

    }

    /**
     * ���⹤����ģ�崦������ȡ�ز�����ķ���
     * 
     * @param workFlowModelDto ���⹤����ģ�崦������ȡ�ز�����Ķ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void getBackUpdate(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        deleteSubInfo(dbManager, workFlowModelDto);
        insert(dbManager, workFlowModelDto);
    }

    /**
     * ���⹤����ģ�崦���淽��
     * 
     * @param workFlowModelDto ���⹤����ģ�崦�����
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void insert(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        if (workFlowModelDto.getSwfModelMainDto() == null) {
            throw new Exception();
        }
        int modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        //����ɾ��ԭ�����������
        String statement = " DELETE FROM swfPath Where modelNo = " + modelNo;
        dbManager.executeUpdate(statement);
        statement = " DELETE FROM swfNode Where modelNo = " + modelNo;
        dbManager.executeUpdate(statement);
        //������з������ݣ���ģ�岻���õ�Ҫɾ���ѷ�������
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
     * ���⹤����ģ�崦��ɾ���ӱ���Ϣ
     * 
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        int modelNo = 0; //ģ���
        String modelStatus = "";//ģ��״̬
        modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        modelStatus = workFlowModelDto.getSwfModelMainDto().getModelStatus();
        String statement = "";
        String stateWhere = "";
        if (workFlowModelDto.getSwfModelMainDto() != null) {
            //��ɾ��workFlowModelItem������

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

            //������з������ݣ���ģ�岻���õ�Ҫɾ���ѷ�������
            if (!modelStatus.equals("1")) {
                statement = " DELETE FROM swfModelUse Where " + stateWhere + " AND modelStatus='" + modelStatus + "'";
                System.out.println("dbWorkFlowModel=" + statement);
                dbManager.executeUpdate(statement);
            }

        }
    }

    /**
     * ״̬ɾ��
     * 
     * @param fcoWorkFlowModelNewNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String registNo) throws SQLException, Exception {
        //ʾ��δ���
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'";
        //ʾ��δ���
        //statement = " DELETE FROM prpLWorkFlowModelMaint Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /**
     * ״̬ɾ��
     * 
     * @param fcoWorkFlowModelMainticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, int workFlowModelID, String registNo) throws SQLException, Exception {
        //ʾ��δ���
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo) + "'" + " AND workFlowModelId ="
                + workFlowModelID + " ";
        //ʾ��δ���
        statement = " DELETE FROM prpLWorkFlowModelMain Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /*
     * ���⹤����ģ�崦���ѯ���� @param workFlowModelDto ���⹤����ģ�崦����� @throws SQLException @throws Exception @return ��
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
     * ������ȵĲ���״̬�ķ���
     * 
     * @param workFlowModelDto ���ȶ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void updateClaimStatus(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException,
            Exception {

        //ʾ��δ���
        String statement = "";

    }

    /**
     * ������Ⱥ���°�����ʾ��״̬�ķ���
     * 
     * @param workFlowModelDto ���ȶ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void updateWorkFlowModelNew(DBManager dbManager, WorkFlowModelDto workFlowModelDto, String workFlowModelFlag)
            throws SQLException, Exception {

        //ʾ��δ���
        String statement = " Update prplworkFlowModelNew set WorkFlowModelFlag='" + workFlowModelFlag
                + "' Where registNo='" + workFlowModelDto.getSwfModelMainDto().getModelNo() + "' AND surveyNo=";

        dbManager.executeUpdate(statement);

    }

    /**
     * ���⹤����ģ�崦�����ӱ���Ϣ
     * 
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void cancelInfo(DBManager dbManager, WorkFlowModelDto workFlowModelDto) throws SQLException, Exception {
        int modelNo = 0; //ģ���
        modelNo = workFlowModelDto.getSwfModelMainDto().getModelNo();
        String statement = "";
        String stateWhere = "";
        if (workFlowModelDto.getSwfModelMainDto() != null) {
            //��ɾ��workFlowModelItem������

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
     * ģ���ȡ�÷���
     * 
     * @param DBManager
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public int getModelNo(DBManager dbManager) throws SQLException, Exception {
        return new DBSwfModelMain(dbManager).getModelNo();
    }

}