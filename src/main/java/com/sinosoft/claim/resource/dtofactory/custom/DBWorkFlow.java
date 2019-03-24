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
 * ���⹤�������̴��������ݿ�������
 * <p>
 * Title: �����������⹤�������̴��������ݹ���
 * </p>
 * <p>
 * Description: �����������⹤�������̴��������ݹ���
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
    private DBManager dbManager = null; // ��Դ������

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBWorkFlow() {
    }

    /**
     * ���⹤�������̴�����ȡ���ķ���
     * @param workFlowDto ���⹤�������̴���������ȡ���Ķ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void cancelWorkFlow(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        cancelInfo(dbManager, workFlowDto);
        updateWorkFlowNew(dbManager, workFlowDto, "0");

    }

    /**
     * ���⹤�������̴���������ȡ�ز�����ķ���
     * @param workFlowDto ���⹤�������̴���������ȡ�ز�����Ķ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void getBackUpdate(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        deleteSubInfo(dbManager, workFlowDto);
        insert(dbManager, workFlowDto);
    }

    /**
     * ���⹤�������̴������淽��
     * @param workFlowDto ���⹤�������̴��������
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void insert(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        if (workFlowDto.getSwfFlowMainDto() == null) {
            throw new Exception();
        }

        // ����ɾ��ԭ�����������
        // deleteSubInfo(dbManager,workFlowDto);
        if (workFlowDto.getSwfFlowMainDto() != null) {
            new DBSwfFlowMain(dbManager)
                    .insert(workFlowDto.getSwfFlowMainDto());

            // ����Ҫ������Ҫ�鿱����Ϣ����Ӧ�Ĳ鿱��Ϣ����

        }

        // �����°�����ʾ��İ���״̬�ı�

        updateWorkFlowNew(dbManager, workFlowDto, "1");
    }

    /**
     * ���⹤�������̴�����ɾ���ӱ���Ϣ
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void deleteSubInfo(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // ʾ��δ���
        String statement = "";
        if (workFlowDto.getSwfFlowMainDto() != null) {
            // ��ɾ��workFlowItem������

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
     * ״̬ɾ��
     * @param fcoWorkFlowNewNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, String registNo)
            throws SQLException, Exception {
        // ʾ��δ���
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo)
                + "'";
        // ʾ��δ���
        // statement = " DELETE FROM WfFlowMaint Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /**
     * ״̬ɾ��
     * @param fcoWorkFlowMainticeNo
     * @throws SQLException
     * @throws Exception
     */
    public void delete(DBManager dbManager, int workFlowID, String registNo)
            throws SQLException, Exception {
        // ʾ��δ���
        String statement = "";

        String condition = " registNo = '" + StringUtils.rightTrim(registNo)
                + "'" + " AND workFlowId =" + workFlowID + " ";
        // ʾ��δ���
        statement = " DELETE FROM WfFlowMain Where " + condition;
        dbManager.executeUpdate(statement);
    }

    /*
     * ���⹤�������̴������ѯ���� @param workFlowDto ���⹤�������̴�������� @throws SQLException
     * @throws Exception @return ��
     */
    public WorkFlowDto findByPrimaryKey(DBManager dbManager, int workFlowID,
            String registNo) throws SQLException, Exception {
        String conditions = " registNo= '" + registNo + "' AND workFlowID="
                + workFlowID;
        WorkFlowDto workFlowDto = new WorkFlowDto();

        return workFlowDto;
    }

    /**
     * ������Ⱥ���°�����ʾ��״̬�ķ���
     * @param workFlowDto ���ȶ���
     * @throws SQLException
     * @throws Exception
     * @return ��
     */
    public void updateWorkFlowNew(DBManager dbManager, WorkFlowDto workFlowDto,
            String workFlowFlag) throws SQLException, Exception {

        // ʾ��δ���
        String statement = " Update prplworkFlowNew set ";

        dbManager.executeUpdate(statement);

    }

    /**
     * ���⹤�������̴��������ӱ���Ϣ
     * @param fcoClaimNoticeNo
     * @throws SQLException
     * @throws Exception
     */
    private void cancelInfo(DBManager dbManager, WorkFlowDto workFlowDto)
            throws SQLException, Exception {
        // ʾ��δ���
        String statement = "";
        if (workFlowDto.getSwfFlowMainDto() != null) {
            // ��ɾ��workFlowItem������

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
        // 1.��ȡģ��ĺ��� ���ɹ�ֱ�ӱ���
        // 2.��ѯ��ģ��ĵ�1����ʼ�ڵ�,��ʱ��Ϊ��ʼ�ڵ�Ϊ 1
        // 3.��wfflowMain����ȡ��flowId��ֵ��
        // 4����wflog������ģ���nodeNo��ֵͬ�Ľڵ㣬
        // 5������wflog������ݵĸýڵ��״̬Ϊ���ڴ���

        // ����������������̣�֮��Ľ��ֻ��Ҫ�����ݿ�Ϳ����ˡ���
        // ������������Ҫ����ı���1��wfFlowMain
        // (2) wfLog

        String flowID = "";
        // WfNodeDto wfNodeDto = new WfNodeDto();
        // wfNodeDto = new DBWfNode(dbManager).findByPrimaryKey(modelNo,nodeNo)
        // ;

        // workFlowDto.getWfFlowMainDto().

        // ��ѯ����ģ������ĵ�һ����¼

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
            // 1.����ת��
            storeFlow(dbManager, workFlowDto);
            // 2.��������������״̬λ��
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
		// 1.��������������״̬λ��
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
    // ���ݹ�����������
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
                // reason:�洢�����flowstatus������Ӧ��Ϊ0�ġ�����
                swfLogDto.setFlowStatus("0");
                // ��������ڵ�ҲӦ��Ϊ�ύ��״̬
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
        // 1.��������������״̬λ��
        if (workFlowDto.getCloseSwfFlowMainDto() != null) {
            new DBSwfFlowMain(dbManager).delete(workFlowDto
                    .getCloseSwfFlowMainDto().getFlowID());
            new DBSwfFlowMain(dbManager).insert(workFlowDto
                    .getCloseSwfFlowMainDto());
            // ����ʱ�����е�=0�����ݶ������4��
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
			//1.��������������״̬λ��
			new DBSwfFlowMain(dbManager).delete(workFlowDto
					.getReOpenSwfFlowMainDto().getFlowID());
			workFlowDto.getReOpenSwfFlowMainDto().setStoreFlag("0");
			new DBSwfFlowMain(dbManager).insert(workFlowDto
					.getReOpenSwfFlowMainDto());
			//2.��ת����ȡ���ݲ�����Swflog��
			String statement = " flowid ='" + workFlowDto.getReOpenSwfFlowMainDto().getFlowID() + "'";
			ArrayList swfLogStoreList = (ArrayList) new DBSwfLogStore(dbManager)
            	.findByConditions(statement);
			for(int i = 0; i < swfLogStoreList.size(); i++){
				SwfLogDto swfLogDto = (SwfLogDto) swfLogStoreList.get(i);
	            swfLogDto.setFlowStatus("1");
			}
			new DBSwfLog(dbManager).insertAll(swfLogStoreList);
			//3.ɾ��ת��������
			statement = " DELETE FROM SwfLogStore Where flowID='" + workFlowDto.getReOpenSwfFlowMainDto().getFlowID() + "'";
			dbManager.executeUpdate(statement);

		}

		return;
	}


    /**
	 * �ջع�����<br>
	 * ʵ���߼�Ϊ��ע�����в���������һ����������,��swfPathLog�е�startNodeNo/endNodeNoʵ�ʴ洢�Ĳ���nodeNo����logNo��<br>
	 * <li>���У��ѡ�м�¼��ǰ�ڵ㣬���ݵ�ǰ�ڵ��ȡ���к����ڵ�,���û�к����ڵ����׳��쳣��û���¼��ڵ㣬�����ջء�
	 * <li>���ݵ�ǰ�ڵ��ȡ���к����ڵ��Ƿ�Ϊ������״̬��swfLog.nodestatus=��0��δ������������Ѵ���ģ����׳��쳣����һ�ڵ����ڴ��������ջء�
	 * <li>ɾ��Swflog��ǰ�ڵ�����к����ڵ����ݣ�
	 * <li>ɾ��swfpathlog���к����ڵ�����
	 * <li>��Swflog��ǰ�ڵ�Ľڵ�״̬nodestatus����Ϊ��2�����ڴ���
	 * <li>���±�PrpLclaimStatus
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
            throw new Exception("û���¼��ڵ㣬�����ջأ�");
        }

        result = dbSwfLog.findByConditions(conditions + " AND nodestatus!='0'",
                1, 1);
        if (result.size() > 0) {
            throw new Exception("��һ�ڵ����ڴ��������ջأ�");
        }
        
        //�����жϵ�֤�Ĺ���
        
        if (swfLogDto.getNodeType ().equals( "certi")){
        	//����ǵ�֤ģʽ����Ҫ����Ƿ��ѳ������飬������ˣ����ܽ��л��ղ���
        	
        	result = dbSwfLog.findByConditions("flowID = '" + flowID + "' AND nodetype='compp' ");
            if (result.size() > 0) {
                throw new Exception("�ѳ��������飬�����ջأ�");
            }
        }

        dbSwfLog.deleteByConditions(conditions);

        conditions = "flowID = '" + flowID + "' AND startNodeNo = " + logNo;
        new DBSwfPathLog(dbManager).deleteByConditions(conditions);
        String statement = " update SWfLog set  nodeStatus='2' "
                + " Where flowID='" + flowID + "' and logNo = " + logNo;
        dbManager.executeUpdate(statement);
        // ���±�PrpLclaimStatus
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
     * ���½ڵ��״̬ ��keyOut ��logno��
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
        //reason:���ӹ���updateʱ�򣬿���ͬʱ��������dto������
        if (workFlowDto.getUpdateSwfLog2Dto() !=null)
        {
        new DBSwfLog(dbManager).delete(workFlowDto.getUpdateSwfLog2Dto().getFlowID(),workFlowDto.getUpdateSwfLog2Dto().getLogNo() );
        new DBSwfLog(dbManager).insert(workFlowDto.getUpdateSwfLog2Dto()) ;
     	  
        }
        //add by lixiang end 2006-6-8
        // ����������
        if (workFlowDto.getSwfNotionDtoList() != null
                && workFlowDto.getSwfNotionDtoList().size() > 0) {
            new DBSwfNotion(dbManager).insertAll(workFlowDto
                    .getSwfNotionDtoList());
        }

    }

    /**
     * �ͷ�����ռ�ţ�Ҫ��updateSwfLog�������õĺ�
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
     * ״̬һ���ڵ�����
     * @param dbManager DBManager
     * @param flowID String
     * @param logNo int
     * @throws SQLException
     * @throws Exception
     */
    public void deleteNode(DBManager dbManager, String flowID, int logNo)
            throws SQLException, Exception {
        // ʾ��δ���
        new DBSwfLog(dbManager).delete(flowID, logNo);

    }

    /**
     * ��ȡ��ǰϵͳʹ�õ�ģ�����
     * @param dbManager DBManager
     * @param riskCode
     * @param comCode
     * @throws SQLException
     * @throws Exception
     */
    public int getModelNo(DBManager dbManager, String riskCode, String comCode)
            throws SQLException, Exception {
        // ʾ��δ���
        int modelNo = -1;
        SwfModelUseDto swfModelUseDto = null;
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        // swfModelUserDto = dbSwfModelUse.findByPrimaryKey(riskCode,)
        String condition = " riskCode ='" + riskCode + "' and comCode='"
                + comCode + "'" + " and modelType='01' ";
        //modified by dongkun //��89��ģ������� start==
        ArrayList<SwfModelUseDto> modelUseList = (ArrayList)dbSwfModelUse.findByConditions(condition);
        
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
        
        for(int i=0;i<modelUseList.size();i++){
        	swfModelUseDto = modelUseList.get(i);
            modelNo = swfModelUseDto.getModelNo();
            if( riskcodeStr.indexOf(riskCode)>0 && modelNo==89){//��֤��ǰ��modelno=1�İ��ӿ�����
            	modelNo=89;
            	break;
            }
        }

        return modelNo;
    }

}
