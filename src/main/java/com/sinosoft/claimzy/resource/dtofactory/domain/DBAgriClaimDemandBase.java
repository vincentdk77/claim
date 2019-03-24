package com.sinosoft.claimzy.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class DBAgriClaimDemandBase {
	 /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = new DBManager();
    private static Logger logger = Logger.getLogger(DBAgriClaimDemandBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBAgriClaimDemandBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param aGRICLAIMUPLOADLOGDto aGRICLAIMUPLOADLOGDto
     * @throws Exception
     */
    public void insert(AgriClaimDemandDto agriClaimDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO AGRICLAIMDEMAND (");
        buffer.append("claimCode,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("claimUploadFlag,");
        buffer.append("caseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("prepaidUploadFlag,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("responseCode,");
        buffer.append("batchNo");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(agriClaimDemandDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getCaseNo()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getPreCompensateNo()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getClaimUploadFlag()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getCaseUploadFlag()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getCancelUploadFlag()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getPrepaidUploadFlag()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getResponseCode()).append("',");
            debugBuffer.append("'").append(agriClaimDemandDto.getBatchNo()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,agriClaimDemandDto.getClaimCode());
        dbManager.setString(2,agriClaimDemandDto.getRegistNo());
        dbManager.setString(3,agriClaimDemandDto.getClaimNo());
        dbManager.setString(4,agriClaimDemandDto.getCaseNo());
        dbManager.setString(5,agriClaimDemandDto.getPreCompensateNo());
        dbManager.setString(6,agriClaimDemandDto.getClaimUploadFlag());
        dbManager.setString(7,agriClaimDemandDto.getCaseUploadFlag());
        dbManager.setString(8,agriClaimDemandDto.getCancelUploadFlag());
        dbManager.setString(9,agriClaimDemandDto.getPrepaidUploadFlag());
        dbManager.setString(10,agriClaimDemandDto.getRiskCode());
        dbManager.setString(11,agriClaimDemandDto.getPolicyNo());
        dbManager.setString(12,agriClaimDemandDto.getResponseCode());
        dbManager.setString(13,agriClaimDemandDto.getBatchNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO AGRICLAIMDEMAND (");
        buffer.append("claimCode,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("claimUploadFlag,");
        buffer.append("caseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("prepaidUploadFlag,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("responseCode,");
        buffer.append("batchNo");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	AgriClaimDemandDto agriClaimDemandDto = (AgriClaimDemandDto)i.next();
        	dbManager.prepareStatement(buffer.toString());
            dbManager.setString(1,agriClaimDemandDto.getClaimCode());
            dbManager.setString(2,agriClaimDemandDto.getRegistNo());
            dbManager.setString(3,agriClaimDemandDto.getClaimNo());
            dbManager.setString(4,agriClaimDemandDto.getCaseNo());
            dbManager.setString(5,agriClaimDemandDto.getPreCompensateNo());
            dbManager.setString(6,agriClaimDemandDto.getClaimUploadFlag());
            dbManager.setString(7,agriClaimDemandDto.getCaseUploadFlag());
            dbManager.setString(8,agriClaimDemandDto.getCancelUploadFlag());
            dbManager.setString(9,agriClaimDemandDto.getPrepaidUploadFlag());
            dbManager.setString(10,agriClaimDemandDto.getRiskCode());
            dbManager.setString(11,agriClaimDemandDto.getPolicyNo());
            dbManager.setString(12, agriClaimDemandDto.getResponseCode());
            dbManager.setString(13, agriClaimDemandDto.getBatchNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param claimCode �������
     * @throws Exception
     */
    public void delete(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM AGRICLAIMDEMAND ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("batchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,batchNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param AgriClaimDemandDto AgriClaimDemandDto
     * @throws Exception
     */
    public void update(AgriClaimDemandDto AgriClaimDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE AGRICLAIMDEMAND SET ");
        buffer.append("registNo = ?, ");
        buffer.append("claimNo = ?, ");
        buffer.append("caseNo = ?, ");
        buffer.append("preCompensateNo = ?, ");
        buffer.append("claimUploadFlag = ?, ");
        buffer.append("caseUploadFlag = ?, ");
        buffer.append("cancelUploadFlag = ?, ");
        buffer.append("prepaidUploadFlag = ?, ");
        buffer.append("riskCode = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("responseNo = ?, ");
        buffer.append("batchNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE AGRICLAIMDEMAND SET ");
            debugBuffer.append("claimNo = '" + AgriClaimDemandDto.getClaimNo() + "', ");
            debugBuffer.append("registNo = '" + AgriClaimDemandDto.getRegistNo() + "', ");
            debugBuffer.append("caseNo = '" + AgriClaimDemandDto.getCaseNo() + "', ");
            debugBuffer.append("preCompensateNo = '" + AgriClaimDemandDto.getPreCompensateNo() + "', ");
            debugBuffer.append("claimUploadFlag = '" + AgriClaimDemandDto.getClaimUploadFlag() + "', ");
            debugBuffer.append("caseUploadFlag = '" + AgriClaimDemandDto.getCaseUploadFlag() + "', ");
            debugBuffer.append("cancelUploadFlag = '" + AgriClaimDemandDto.getCancelUploadFlag() + "', ");
            debugBuffer.append("prepaidUploadFlag = '" + AgriClaimDemandDto.getPrepaidUploadFlag() + "', ");
            debugBuffer.append("riskCode = '" + AgriClaimDemandDto.getRiskCode() + "', ");
            debugBuffer.append("policyNo = '" + AgriClaimDemandDto.getPolicyNo() + "', ");
            debugBuffer.append("responseCode = '" + AgriClaimDemandDto.getResponseCode() + "', ");
            debugBuffer.append("batchNo = '" + AgriClaimDemandDto.getBatchNo() + "");
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(AgriClaimDemandDto.getBatchNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("batchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,AgriClaimDemandDto.getClaimNo());
        dbManager.setString(2,AgriClaimDemandDto.getRegistNo());
        dbManager.setString(3,AgriClaimDemandDto.getCaseNo());
        dbManager.setString(4,AgriClaimDemandDto.getPreCompensateNo());
        dbManager.setString(5,AgriClaimDemandDto.getClaimUploadFlag());
        dbManager.setString(6,AgriClaimDemandDto.getCaseUploadFlag());
        dbManager.setString(7,AgriClaimDemandDto.getCancelUploadFlag());
        dbManager.setString(8,AgriClaimDemandDto.getPrepaidUploadFlag());
        dbManager.setString(9,AgriClaimDemandDto.getRiskCode());
        dbManager.setString(10,AgriClaimDemandDto.getPolicyNo());
        dbManager.setString(11,AgriClaimDemandDto.getResponseCode());
        dbManager.setString(12,AgriClaimDemandDto.getBatchNo());
        //���������ֶ�;
        dbManager.setString(13,AgriClaimDemandDto.getClaimCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param claimCode �������
     * @return AgriClaimDemandDto
     * @throws Exception
     */
    public AgriClaimDemandDto findByPrimaryKey(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("claimCode,");
        buffer.append("registNo");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("claimUploadFlag,");
        buffer.append("caseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("prepaidUploadFlag,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("responseCode,");
        buffer.append("batchNo");
        buffer.append("FROM AGRICLAIMDEMAND ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("batchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("batchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,batchNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        AgriClaimDemandDto AgriClaimDemandDto = null;
        if(resultSet.next()){
            AgriClaimDemandDto = new AgriClaimDemandDto();
            AgriClaimDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            AgriClaimDemandDto.setRegistNo(dbManager.getString(resultSet, 2));
            AgriClaimDemandDto.setClaimNo(dbManager.getString(resultSet,3));
            AgriClaimDemandDto.setCaseNo(dbManager.getString(resultSet,4));
            AgriClaimDemandDto.setPreCompensateNo(dbManager.getString(resultSet,5));
            AgriClaimDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,6));
            AgriClaimDemandDto.setCaseUploadFlag(dbManager.getString(resultSet,7));
            AgriClaimDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,8));
            AgriClaimDemandDto.setPrepaidUploadFlag(dbManager.getString(resultSet,9));
            AgriClaimDemandDto.setRiskCode(dbManager.getString(resultSet,10));
            AgriClaimDemandDto.setPolicyNo(dbManager.getString(resultSet,11));
            AgriClaimDemandDto.setResponseCode(dbManager.getString(resultSet,12));
            AgriClaimDemandDto.setBatchNo(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        return AgriClaimDemandDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("claimCode,");
        buffer.append("registNo");
        buffer.append("claimNo,");
        buffer.append("caseNo,");
        buffer.append("preCompensateNo,");
        buffer.append("claimUploadFlag,");
        buffer.append("caseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("prepaidUploadFlag,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("responseCode,");
        buffer.append("batchNo");
        buffer.append("FROM AGRICLAIMDEMAND WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        AgriClaimDemandDto AgriClaimDemandDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            AgriClaimDemandDto = new AgriClaimDemandDto();
            AgriClaimDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            AgriClaimDemandDto.setRegistNo(dbManager.getString(resultSet,2));
            AgriClaimDemandDto.setClaimNo(dbManager.getString(resultSet,3));
            AgriClaimDemandDto.setCaseNo(dbManager.getString(resultSet,4));
            AgriClaimDemandDto.setPreCompensateNo(dbManager.getString(resultSet,5));
            AgriClaimDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,6));
            AgriClaimDemandDto.setCaseUploadFlag(dbManager.getString(resultSet,7));
            AgriClaimDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,8));
            AgriClaimDemandDto.setPrepaidUploadFlag(dbManager.getString(resultSet,9));
            AgriClaimDemandDto.setRiskCode(dbManager.getString(resultSet,10));
            AgriClaimDemandDto.setPolicyNo(dbManager.getString(resultSet,11));
            AgriClaimDemandDto.setResponseCode(dbManager.getString(resultSet,12));
            AgriClaimDemandDto.setBatchNo(dbManager.getString(resultSet,13));
            collection.add(AgriClaimDemandDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM AGRICLAIMDEMAND WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM AGRICLAIMDEMAND WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
