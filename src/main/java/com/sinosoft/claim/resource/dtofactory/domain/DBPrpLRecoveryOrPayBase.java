package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRecoveryOrPayDto;
import com.sinosoft.claim.dto.domain.PrpLlossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpLRecoveryOrPayBase {
	/**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLRecoveryOrPayBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLRecoveryOrPayBase(DBManager dbManager){
        this.dbManager = dbManager;
    }
    
    /**
     * ����һ������
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void insert(PrpLRecoveryOrPayDto prpLRecoveryOrPayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLRecoveryOrPay (");
        buffer.append("CompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("RecoveryOrPayType,");
        buffer.append("RecoveryOrPayMan,");
        buffer.append("RecoveryCode,");
        buffer.append("RecoveryOrPayAmount,");
        buffer.append("PayMan,");
        buffer.append("RecoveryBackAmount,");
        buffer.append("RecoveryRemark ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLRecoveryOrPayDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLRecoveryOrPayDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLRecoveryOrPayDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLRecoveryOrPayDto.getSerialNo()).append("',");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryOrPayFlag()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryOrPayType()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryOrPayMan()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryCode()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryOrPayAmount()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getPayMan()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryBackAmount()).append(",");
            debugBuffer.append("").append(prpLRecoveryOrPayDto.getRecoveryRemark()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLRecoveryOrPayDto.getCompensateNo());
        dbManager.setString(2,prpLRecoveryOrPayDto.getClaimNo());
        dbManager.setString(3,prpLRecoveryOrPayDto.getRiskCode());
        dbManager.setInt(4,prpLRecoveryOrPayDto.getSerialNo());
        dbManager.setString(5,prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
        dbManager.setString(6,prpLRecoveryOrPayDto.getRecoveryOrPayType());
        dbManager.setString(7,prpLRecoveryOrPayDto.getRecoveryOrPayMan());
        dbManager.setString(8,prpLRecoveryOrPayDto.getRecoveryCode());
        dbManager.setDouble(9,prpLRecoveryOrPayDto.getRecoveryOrPayAmount());
        dbManager.setString(10,prpLRecoveryOrPayDto.getPayMan());
        dbManager.setDouble(11,prpLRecoveryOrPayDto.getRecoveryBackAmount());
        dbManager.setString(12,prpLRecoveryOrPayDto.getRecoveryRemark());
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
        buffer.append("INSERT INTO PrpLRecoveryOrPay (");
        buffer.append("CompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("RecoveryOrPayType,");
        buffer.append("RecoveryOrPayMan,");
        buffer.append("RecoveryCode,");
        buffer.append("RecoveryOrPayAmount,");
        buffer.append("PayMan,");
        buffer.append("RecoveryBackAmount,");
        buffer.append("RecoveryRemark ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrpLRecoveryOrPayDto PprpLRecoveryOrPayDto = (PrpLRecoveryOrPayDto)i.next();
        	dbManager.setString(1,PprpLRecoveryOrPayDto.getCompensateNo());
            dbManager.setString(2,PprpLRecoveryOrPayDto.getClaimNo());
            dbManager.setString(3,PprpLRecoveryOrPayDto.getRiskCode());
            dbManager.setInt(4,PprpLRecoveryOrPayDto.getSerialNo());
            dbManager.setString(5,PprpLRecoveryOrPayDto.getRecoveryOrPayFlag());
            dbManager.setString(6,PprpLRecoveryOrPayDto.getRecoveryOrPayType());
            dbManager.setString(7,PprpLRecoveryOrPayDto.getRecoveryOrPayMan());
            dbManager.setString(8,PprpLRecoveryOrPayDto.getRecoveryCode());
            dbManager.setDouble(9,PprpLRecoveryOrPayDto.getRecoveryOrPayAmount());
            dbManager.setString(10,PprpLRecoveryOrPayDto.getPayMan());
            dbManager.setDouble(11,PprpLRecoveryOrPayDto.getRecoveryBackAmount());
            dbManager.setString(12,PprpLRecoveryOrPayDto.getRecoveryRemark());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @throws Exception
     */
    public void delete(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLRecoveryOrPay ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLlossDto prpLlossDto
     * @throws Exception
     */
    public void update(PrpLRecoveryOrPayDto prpLRecoveryOrPayDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLRecoveryOrPay SET ");
        buffer.append("ClaimNo = ?, ");
        buffer.append("RiskCode = ?, ");
        buffer.append("RecoveryOrPayFlag = ?, ");
        buffer.append("RecoveryOrPayType = ?, ");
        buffer.append("RecoveryOrPayMan = ?, ");
        buffer.append("RecoveryCode = ?, ");
        buffer.append("RecoveryOrPayAmount = ?, ");
        buffer.append("PayMan = ?, ");
        buffer.append("RecoveryBackAmount = ?, ");
        buffer.append("RecoveryRemark = ? ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLRecoveryOrPay SET ");
            debugBuffer.append("ClaimNo = '" + prpLRecoveryOrPayDto.getClaimNo() + "', ");
            debugBuffer.append("RiskCode = '" + prpLRecoveryOrPayDto.getRiskCode() + "', ");
            debugBuffer.append("RecoveryOrPayFlag = " + prpLRecoveryOrPayDto.getRecoveryOrPayFlag() + ", ");
            debugBuffer.append("RecoveryOrPayType = '" + prpLRecoveryOrPayDto.getRecoveryOrPayType() + "', ");
            debugBuffer.append("RecoveryOrPayMan = '" + prpLRecoveryOrPayDto.getRecoveryOrPayMan() + "', ");
            debugBuffer.append("RecoveryCode = '" + prpLRecoveryOrPayDto.getRecoveryCode() + "', ");
            debugBuffer.append("RecoveryOrPayAmount = '" + prpLRecoveryOrPayDto.getRecoveryOrPayAmount() + "', ");
            debugBuffer.append("PayMan = '" + prpLRecoveryOrPayDto.getPayMan() + "', ");
            debugBuffer.append("RecoveryBackAmount = '" + prpLRecoveryOrPayDto.getRecoveryBackAmount() + "', ");
            debugBuffer.append("RecoveryRemark = '" + prpLRecoveryOrPayDto.getRecoveryRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLRecoveryOrPayDto.getCompensateNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLRecoveryOrPayDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLRecoveryOrPayDto.getClaimNo());
        dbManager.setString(2,prpLRecoveryOrPayDto.getRiskCode());
        dbManager.setString(3,prpLRecoveryOrPayDto.getRecoveryOrPayFlag());
        dbManager.setString(4,prpLRecoveryOrPayDto.getRecoveryOrPayType());
        dbManager.setString(5,prpLRecoveryOrPayDto.getRecoveryOrPayMan());
        dbManager.setString(6,prpLRecoveryOrPayDto.getRecoveryCode());
        dbManager.setDouble(7,prpLRecoveryOrPayDto.getRecoveryOrPayAmount());
        dbManager.setString(8,prpLRecoveryOrPayDto.getPayMan());
        dbManager.setDouble(9,prpLRecoveryOrPayDto.getRecoveryBackAmount());
        dbManager.setString(10,prpLRecoveryOrPayDto.getRecoveryRemark());
       
        //���������ֶ�;
        dbManager.setString(11,prpLRecoveryOrPayDto.getCompensateNo());
        dbManager.setInt(12,prpLRecoveryOrPayDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param compensateNo ���������
     * @param serialNo �⸶������
     * @return PrpLlossDto
     * @throws Exception
     */
    public PrpLRecoveryOrPayDto findByPrimaryKey(String compensateNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("RecoveryOrPayType,");
        buffer.append("RecoveryOrPayMan,");
        buffer.append("RecoveryCode,");
        buffer.append("RecoveryOrPayAmount,");
        buffer.append("PayMan,");
        buffer.append("RecoveryBackAmount,");
        buffer.append("RecoveryRemark ");
        buffer.append("FROM PrpLRecoveryOrPay ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(compensateNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        if(resultSet.next()){
        	prpLRecoveryOrPayDto = new PrpLRecoveryOrPayDto();
        	prpLRecoveryOrPayDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLRecoveryOrPayDto.setClaimNo(dbManager.getString(resultSet,2));
        	prpLRecoveryOrPayDto.setRiskCode(dbManager.getString(resultSet,3));
        	prpLRecoveryOrPayDto.setSerialNo(dbManager.getInt(resultSet,4));
        	prpLRecoveryOrPayDto.setRecoveryOrPayFlag(dbManager.getString(resultSet,5));
        	prpLRecoveryOrPayDto.setRecoveryOrPayType(dbManager.getString(resultSet,6));
        	prpLRecoveryOrPayDto.setRecoveryOrPayMan(dbManager.getString(resultSet,7));
        	prpLRecoveryOrPayDto.setRecoveryCode(dbManager.getString(resultSet,8));
        	prpLRecoveryOrPayDto.setRecoveryOrPayAmount(dbManager.getDouble(resultSet,9));
        	prpLRecoveryOrPayDto.setPayMan(dbManager.getString(resultSet, 10));
        	prpLRecoveryOrPayDto.setRecoveryBackAmount(dbManager.getDouble(resultSet, 11));
        	prpLRecoveryOrPayDto.setRecoveryRemark(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLRecoveryOrPayDto;
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
        buffer.append("CompensateNo,");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("RecoveryOrPayFlag,");
        buffer.append("RecoveryOrPayType,");
        buffer.append("RecoveryOrPayMan,");
        buffer.append("RecoveryCode,");
        buffer.append("RecoveryOrPayAmount,");
        buffer.append("PayMan,");
        buffer.append("RecoveryBackAmount,");
        buffer.append("RecoveryRemark ");
        buffer.append("FROM PrpLRecoveryOrPay WHERE ");
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
        PrpLRecoveryOrPayDto prpLRecoveryOrPayDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLRecoveryOrPayDto = new PrpLRecoveryOrPayDto();
        	prpLRecoveryOrPayDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLRecoveryOrPayDto.setClaimNo(dbManager.getString(resultSet,2));
        	prpLRecoveryOrPayDto.setRiskCode(dbManager.getString(resultSet,3));
        	prpLRecoveryOrPayDto.setSerialNo(dbManager.getInt(resultSet,4));
        	prpLRecoveryOrPayDto.setRecoveryOrPayFlag(dbManager.getString(resultSet,5));
        	prpLRecoveryOrPayDto.setRecoveryOrPayType(dbManager.getString(resultSet,6));
        	prpLRecoveryOrPayDto.setRecoveryOrPayMan(dbManager.getString(resultSet,7));
        	prpLRecoveryOrPayDto.setRecoveryCode(dbManager.getString(resultSet,8));
        	prpLRecoveryOrPayDto.setRecoveryOrPayAmount(dbManager.getDouble(resultSet,9));
        	prpLRecoveryOrPayDto.setPayMan(dbManager.getString(resultSet, 10));
        	prpLRecoveryOrPayDto.setRecoveryBackAmount(dbManager.getDouble(resultSet, 11));
        	prpLRecoveryOrPayDto.setRecoveryRemark(dbManager.getString(resultSet,12));
            collection.add(prpLRecoveryOrPayDto);
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
        buffer.append("DELETE FROM PrpLRecoveryOrPay WHERE ");
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
      String  statement ;
        statement = "SELECT count(1) FROM PrpLRecoveryOrPay WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
