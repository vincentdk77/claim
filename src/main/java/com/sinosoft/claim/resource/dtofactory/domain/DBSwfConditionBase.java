package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfCondition-���������������������������ݷ��ʶ������<br>
 * ������ 2005-04-26 15:20:37.578<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfConditionBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfConditionBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfConditionBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void insert(SwfConditionDto swfConditionDto) throws Exception{
        String mainStatement = " Insert Into SwfCondition (" + 
                           " ModelNo," + 
                           " PathNo," + 
                           " ConditionNo," + 
                           " SerialNo," + 
                           " ComCode," + 
                           " ValidStatus," + 
                           " ConfigType," + 
                           " ConfigText," + 
                           " BusinessKey," + 
                           " DBName," + 
                           " TableName," + 
                           " DataType," + 
                           " ColumnName," + 
                           " ColumnDesc," + 
                           " Operator," + 
                           " Value," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + swfConditionDto.getModelNo() + "," + 
                           "" + swfConditionDto.getPathNo() + "," + 
                           "" + swfConditionDto.getConditionNo() + "," + 
                           "" + swfConditionDto.getSerialNo() + "," + 
                           "'" + swfConditionDto.getComCode() + "'," + 
                           "'" + swfConditionDto.getValidStatus() + "'," + 
                           "'" + swfConditionDto.getConfigType() + "'," + 
                           "'" + swfConditionDto.getConfigText() + "'," + 
                           "'" + swfConditionDto.getBusinessKey() + "'," + 
                           "'" + swfConditionDto.getDBName() + "'," + 
                           "'" + swfConditionDto.getTableName() + "'," + 
                           "'" + swfConditionDto.getDataType() + "'," + 
                           "'" + swfConditionDto.getColumnName() + "'," + 
                           "'" + swfConditionDto.getColumnDesc() + "'," + 
                           "'" + swfConditionDto.getOperator() + "'," + 
                           "'" + swfConditionDto.getValue() + "'," + 
                           "'" + swfConditionDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,swfConditionDto.getModelNo());
        dbManager.setInt(2,swfConditionDto.getPathNo());
        dbManager.setInt(3,swfConditionDto.getConditionNo());
        dbManager.setInt(4,swfConditionDto.getSerialNo());
        dbManager.setString(5,swfConditionDto.getComCode());
        dbManager.setString(6,swfConditionDto.getValidStatus());
        dbManager.setString(7,swfConditionDto.getConfigType());
        dbManager.setString(8,swfConditionDto.getConfigText());
        dbManager.setString(9,swfConditionDto.getBusinessKey());
        dbManager.setString(10,swfConditionDto.getDBName());
        dbManager.setString(11,swfConditionDto.getTableName());
        dbManager.setString(12,swfConditionDto.getDataType());
        dbManager.setString(13,swfConditionDto.getColumnName());
        dbManager.setString(14,swfConditionDto.getColumnDesc());
        dbManager.setString(15,swfConditionDto.getOperator());
        dbManager.setString(16,swfConditionDto.getValue());
        dbManager.setString(17,swfConditionDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfConditionBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfCondition (" + 
                           " ModelNo," + 
                           " PathNo," + 
                           " ConditionNo," + 
                           " SerialNo," + 
                           " ComCode," + 
                           " ValidStatus," + 
                           " ConfigType," + 
                           " ConfigText," + 
                           " BusinessKey," + 
                           " DBName," + 
                           " TableName," + 
                           " DataType," + 
                           " ColumnName," + 
                           " ColumnDesc," + 
                           " Operator," + 
                           " Value," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfConditionDto swfConditionDto = (SwfConditionDto)i.next();
            dbManager.setInt(1,swfConditionDto.getModelNo());
            dbManager.setInt(2,swfConditionDto.getPathNo());
            dbManager.setInt(3,swfConditionDto.getConditionNo());
            dbManager.setInt(4,swfConditionDto.getSerialNo());
            dbManager.setString(5,swfConditionDto.getComCode());
            dbManager.setString(6,swfConditionDto.getValidStatus());
            dbManager.setString(7,swfConditionDto.getConfigType());
            dbManager.setString(8,swfConditionDto.getConfigText());
            dbManager.setString(9,swfConditionDto.getBusinessKey());
            dbManager.setString(10,swfConditionDto.getDBName());
            dbManager.setString(11,swfConditionDto.getTableName());
            dbManager.setString(12,swfConditionDto.getDataType());
            dbManager.setString(13,swfConditionDto.getColumnName());
            dbManager.setString(14,swfConditionDto.getColumnDesc());
            dbManager.setString(15,swfConditionDto.getOperator());
            dbManager.setString(16,swfConditionDto.getValue());
            dbManager.setString(17,swfConditionDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfConditionBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        String statement = " Delete From SwfCondition" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ? And " + 
                           " ConditionNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfCondition Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " PathNo = " + pathNo + " And " + 
                           " ConditionNo = " + conditionNo + " And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,pathNo);
        dbManager.setInt(3,conditionNo);
        dbManager.setInt(4,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfConditionBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfConditionDto swfConditionDto
     * @throws Exception
     */
    public void update(SwfConditionDto swfConditionDto) throws Exception{
        String statement = " Update SwfCondition Set ComCode = ?," + 
                           " ValidStatus = ?," + 
                           " ConfigType = ?," + 
                           " ConfigText = ?," + 
                           " BusinessKey = ?," + 
                           " DBName = ?," + 
                           " TableName = ?," + 
                           " DataType = ?," + 
                           " ColumnName = ?," + 
                           " ColumnDesc = ?," + 
                           " Operator = ?," + 
                           " Value = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ? And " + 
                           " ConditionNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfCondition Set " + 
                           " ModelNo = " + swfConditionDto.getModelNo() + "," + 
                           " PathNo = " + swfConditionDto.getPathNo() + "," + 
                           " ConditionNo = " + swfConditionDto.getConditionNo() + "," + 
                           " SerialNo = " + swfConditionDto.getSerialNo() + "," + 
                           " ComCode = '" + swfConditionDto.getComCode() + "'," + 
                           " ValidStatus = '" + swfConditionDto.getValidStatus() + "'," + 
                           " ConfigType = '" + swfConditionDto.getConfigType() + "'," + 
                           " ConfigText = '" + swfConditionDto.getConfigText() + "'," + 
                           " BusinessKey = '" + swfConditionDto.getBusinessKey() + "'," + 
                           " DBName = '" + swfConditionDto.getDBName() + "'," + 
                           " TableName = '" + swfConditionDto.getTableName() + "'," + 
                           " DataType = '" + swfConditionDto.getDataType() + "'," + 
                           " ColumnName = '" + swfConditionDto.getColumnName() + "'," + 
                           " ColumnDesc = '" + swfConditionDto.getColumnDesc() + "'," + 
                           " Operator = '" + swfConditionDto.getOperator() + "'," + 
                           " Value = '" + swfConditionDto.getValue() + "'," + 
                           " Flag = '" + swfConditionDto.getFlag() + "'" + 
			               " Where " +
                           " ModelNo = " + swfConditionDto.getModelNo() + " And " + 
                           " PathNo = " + swfConditionDto.getPathNo() + " And " + 
                           " ConditionNo = " + swfConditionDto.getConditionNo() + " And " + 
                           " SerialNo = " + swfConditionDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfConditionDto.getComCode());
        dbManager.setString(2,swfConditionDto.getValidStatus());
        dbManager.setString(3,swfConditionDto.getConfigType());
        dbManager.setString(4,swfConditionDto.getConfigText());
        dbManager.setString(5,swfConditionDto.getBusinessKey());
        dbManager.setString(6,swfConditionDto.getDBName());
        dbManager.setString(7,swfConditionDto.getTableName());
        dbManager.setString(8,swfConditionDto.getDataType());
        dbManager.setString(9,swfConditionDto.getColumnName());
        dbManager.setString(10,swfConditionDto.getColumnDesc());
        dbManager.setString(11,swfConditionDto.getOperator());
        dbManager.setString(12,swfConditionDto.getValue());
        dbManager.setString(13,swfConditionDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(14,swfConditionDto.getModelNo());
        dbManager.setInt(15,swfConditionDto.getPathNo());
        dbManager.setInt(16,swfConditionDto.getConditionNo());
        dbManager.setInt(17,swfConditionDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfConditionBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @return SwfConditionDto
     * @throws Exception
     */
    public SwfConditionDto findByPrimaryKey(int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        String mainStatement = " Select ModelNo," + 
                           " PathNo," + 
                           " ConditionNo," + 
                           " SerialNo," + 
                           " ComCode," + 
                           " ValidStatus," + 
                           " ConfigType," + 
                           " ConfigText," + 
                           " BusinessKey," + 
                           " DBName," + 
                           " TableName," + 
                           " DataType," + 
                           " ColumnName," + 
                           " ColumnDesc," + 
                           " Operator," + 
                           " Value," + 
                           " Flag From SwfCondition";
        String statement = mainStatement + " Where " +
                           " ModelNo = ? And " + 
                           " PathNo = ? And " + 
                           " ConditionNo = ? And " + 
                           " SerialNo = ?";
        SwfConditionDto swfConditionDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " PathNo = " + pathNo + " And " + 
                           " ConditionNo = " + conditionNo + " And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setInt(2,pathNo);
        dbManager.setInt(3,conditionNo);
        dbManager.setInt(4,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfConditionDto = new SwfConditionDto();
            swfConditionDto.setModelNo(dbManager.getInt(resultSet,1));
            swfConditionDto.setPathNo(dbManager.getInt(resultSet,2));
            swfConditionDto.setConditionNo(dbManager.getInt(resultSet,3));
            swfConditionDto.setSerialNo(dbManager.getInt(resultSet,4));
            swfConditionDto.setComCode(dbManager.getString(resultSet,5));
            swfConditionDto.setValidStatus(dbManager.getString(resultSet,6));
            swfConditionDto.setConfigType(dbManager.getString(resultSet,7));
            swfConditionDto.setConfigText(dbManager.getString(resultSet,8));
            swfConditionDto.setBusinessKey(dbManager.getString(resultSet,9));
            swfConditionDto.setDBName(dbManager.getString(resultSet,10));
            swfConditionDto.setTableName(dbManager.getString(resultSet,11));
            swfConditionDto.setDataType(dbManager.getString(resultSet,12));
            swfConditionDto.setColumnName(dbManager.getString(resultSet,13));
            swfConditionDto.setColumnDesc(dbManager.getString(resultSet,14));
            swfConditionDto.setOperator(dbManager.getString(resultSet,15));
            swfConditionDto.setValue(dbManager.getString(resultSet,16));
            swfConditionDto.setFlag(dbManager.getString(resultSet,17));
            logger.info("DBSwfConditionBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfConditionBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfConditionDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ModelNo," + 
                           " PathNo," + 
                           " ConditionNo," + 
                           " SerialNo," + 
                           " ComCode," + 
                           " ValidStatus," + 
                           " ConfigType," + 
                           " ConfigText," + 
                           " BusinessKey," + 
                           " DBName," + 
                           " TableName," + 
                           " DataType," + 
                           " ColumnName," + 
                           " ColumnDesc," + 
                           " Operator," + 
                           " Value," + 
                           " Flag From SwfCondition Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfConditionDto swfConditionDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            swfConditionDto = new SwfConditionDto();
            swfConditionDto.setModelNo(dbManager.getInt(resultSet,1));
            swfConditionDto.setPathNo(dbManager.getInt(resultSet,2));
            swfConditionDto.setConditionNo(dbManager.getInt(resultSet,3));
            swfConditionDto.setSerialNo(dbManager.getInt(resultSet,4));
            swfConditionDto.setComCode(dbManager.getString(resultSet,5));
            swfConditionDto.setValidStatus(dbManager.getString(resultSet,6));
            swfConditionDto.setConfigType(dbManager.getString(resultSet,7));
            swfConditionDto.setConfigText(dbManager.getString(resultSet,8));
            swfConditionDto.setBusinessKey(dbManager.getString(resultSet,9));
            swfConditionDto.setDBName(dbManager.getString(resultSet,10));
            swfConditionDto.setTableName(dbManager.getString(resultSet,11));
            swfConditionDto.setDataType(dbManager.getString(resultSet,12));
            swfConditionDto.setColumnName(dbManager.getString(resultSet,13));
            swfConditionDto.setColumnDesc(dbManager.getString(resultSet,14));
            swfConditionDto.setOperator(dbManager.getString(resultSet,15));
            swfConditionDto.setValue(dbManager.getString(resultSet,16));
            swfConditionDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(swfConditionDto);
        }
        resultSet.close();
        logger.info("DBSwfConditionBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From SwfCondition Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfConditionBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfCondition Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfConditionBase.getCount() success!");
        return count;
    }
}
