package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckItemLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckItemLog-�鿱������Ϣ������־������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.859<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckItemLogBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcheckItemLogBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcheckItemLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void insert(PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        String mainStatement = " Insert Into PrpLcheckItemLog (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " DealFlag," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLcheckItemLogDto.getScheduleID() + "," + 
                           "'" + prpLcheckItemLogDto.getRegistNo() + "'," + 
                           "'" + prpLcheckItemLogDto.getItemNo() + "'," + 
                           "" + prpLcheckItemLogDto.getSerialNo() + "," + 
                           "'" + prpLcheckItemLogDto.getInputDate() + "'," + 
                           "'" + prpLcheckItemLogDto.getCheckFlag() + "'," + 
                           "'" + prpLcheckItemLogDto.getCheckInfo() + "'," + 
                           "'" + prpLcheckItemLogDto.getDealFlag() + "'," + 
                           "'" + prpLcheckItemLogDto.getOperatorCode() + "'," + 
                           "'" + prpLcheckItemLogDto.getOperatorName() + "'," + 
                           "'" + prpLcheckItemLogDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLcheckItemLogDto.getScheduleID());
        dbManager.setString(2,prpLcheckItemLogDto.getRegistNo());
        dbManager.setDouble(3,prpLcheckItemLogDto.getItemNo());
        dbManager.setInt(4,prpLcheckItemLogDto.getSerialNo());
        dbManager.setDateTime(5,prpLcheckItemLogDto.getInputDate());
        dbManager.setString(6,prpLcheckItemLogDto.getCheckFlag());
        dbManager.setString(7,prpLcheckItemLogDto.getCheckInfo());
        dbManager.setString(8,prpLcheckItemLogDto.getDealFlag());
        dbManager.setString(9,prpLcheckItemLogDto.getOperatorCode());
        dbManager.setString(10,prpLcheckItemLogDto.getOperatorName());
        dbManager.setString(11,prpLcheckItemLogDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckItemLogBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcheckItemLog (" + 
                           " ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " DealFlag," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcheckItemLogDto prpLcheckItemLogDto = (PrpLcheckItemLogDto)i.next();
            dbManager.setInt(1,prpLcheckItemLogDto.getScheduleID());
            dbManager.setString(2,prpLcheckItemLogDto.getRegistNo());
            dbManager.setDouble(3,prpLcheckItemLogDto.getItemNo());
            dbManager.setInt(4,prpLcheckItemLogDto.getSerialNo());
            dbManager.setDateTime(5,prpLcheckItemLogDto.getInputDate());
            dbManager.setString(6,prpLcheckItemLogDto.getCheckFlag());
            dbManager.setString(7,prpLcheckItemLogDto.getCheckInfo());
            dbManager.setString(8,prpLcheckItemLogDto.getDealFlag());
            dbManager.setString(9,prpLcheckItemLogDto.getOperatorCode());
            dbManager.setString(10,prpLcheckItemLogDto.getOperatorName());
            dbManager.setString(11,prpLcheckItemLogDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcheckItemLogBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @param serialNo �������
     * @throws Exception
     */
    public void delete(int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLcheckItemLog" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcheckItemLog Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " ItemNo = '" + itemNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setDouble(3,itemNo);
        dbManager.setInt(4,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcheckItemLogBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcheckItemLogDto prpLcheckItemLogDto
     * @throws Exception
     */
    public void update(PrpLcheckItemLogDto prpLcheckItemLogDto) throws Exception{
        String statement = " Update PrpLcheckItemLog Set InputDate = ?," + 
                           " CheckFlag = ?," + 
                           " CheckInfo = ?," + 
                           " DealFlag = ?," + 
                           " OperatorCode = ?," + 
                           " OperatorName = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcheckItemLog Set " + 
                           " ScheduleID = " + prpLcheckItemLogDto.getScheduleID() + "," + 
                           " RegistNo = '" + prpLcheckItemLogDto.getRegistNo() + "'," + 
                           " ItemNo = '" + prpLcheckItemLogDto.getItemNo() + "'," + 
                           " SerialNo = " + prpLcheckItemLogDto.getSerialNo() + "," + 
                           " InputDate = '" + prpLcheckItemLogDto.getInputDate() + "'," + 
                           " CheckFlag = '" + prpLcheckItemLogDto.getCheckFlag() + "'," + 
                           " CheckInfo = '" + prpLcheckItemLogDto.getCheckInfo() + "'," + 
                           " DealFlag = '" + prpLcheckItemLogDto.getDealFlag() + "'," + 
                           " OperatorCode = '" + prpLcheckItemLogDto.getOperatorCode() + "'," + 
                           " OperatorName = '" + prpLcheckItemLogDto.getOperatorName() + "'," + 
                           " Flag = '" + prpLcheckItemLogDto.getFlag() + "'" + 
			               " Where " +
                           " ScheduleID = " + prpLcheckItemLogDto.getScheduleID() + " And " + 
                           " RegistNo = '" + prpLcheckItemLogDto.getRegistNo() + "' And " + 
                           " ItemNo = '" + prpLcheckItemLogDto.getItemNo() + "' And " + 
                           " SerialNo = " + prpLcheckItemLogDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpLcheckItemLogDto.getInputDate());
        dbManager.setString(2,prpLcheckItemLogDto.getCheckFlag());
        dbManager.setString(3,prpLcheckItemLogDto.getCheckInfo());
        dbManager.setString(4,prpLcheckItemLogDto.getDealFlag());
        dbManager.setString(5,prpLcheckItemLogDto.getOperatorCode());
        dbManager.setString(6,prpLcheckItemLogDto.getOperatorName());
        dbManager.setString(7,prpLcheckItemLogDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(8,prpLcheckItemLogDto.getScheduleID());
        dbManager.setString(9,prpLcheckItemLogDto.getRegistNo());
        dbManager.setDouble(10,prpLcheckItemLogDto.getItemNo());
        dbManager.setInt(11,prpLcheckItemLogDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckItemLogBase.update() success!");
    }

    /**
     * ����������һ������
     * @param scheduleID ����ID
     * @param registNo ��������
     * @param itemNo ������
     * @param serialNo �������
     * @return PrpLcheckItemLogDto
     * @throws Exception
     */
    public PrpLcheckItemLogDto findByPrimaryKey(int scheduleID,String registNo,double itemNo,int serialNo) throws Exception{
        String mainStatement = " Select ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " DealFlag," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Flag From PrpLcheckItemLog";
        String statement = mainStatement + " Where " +
                           " ScheduleID = ? And " + 
                           " RegistNo = ? And " + 
                           " ItemNo = ? And " + 
                           " SerialNo = ?";
        PrpLcheckItemLogDto prpLcheckItemLogDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ScheduleID = " + scheduleID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " ItemNo = '" + itemNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,scheduleID);
        dbManager.setString(2,registNo);
        dbManager.setDouble(3,itemNo);
        dbManager.setInt(4,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcheckItemLogDto = new PrpLcheckItemLogDto();
            prpLcheckItemLogDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLcheckItemLogDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLcheckItemLogDto.setItemNo(dbManager.getDouble(resultSet,3));
            prpLcheckItemLogDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLcheckItemLogDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcheckItemLogDto.setCheckFlag(dbManager.getString(resultSet,6));
            prpLcheckItemLogDto.setCheckInfo(dbManager.getString(resultSet,7));
            prpLcheckItemLogDto.setDealFlag(dbManager.getString(resultSet,8));
            prpLcheckItemLogDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLcheckItemLogDto.setOperatorName(dbManager.getString(resultSet,10));
            prpLcheckItemLogDto.setFlag(dbManager.getString(resultSet,11));
            logger.info("DBPrpLcheckItemLogBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcheckItemLogBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcheckItemLogDto;
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
        String statement = "Select ScheduleID," + 
                           " RegistNo," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " CheckFlag," + 
                           " CheckInfo," + 
                           " DealFlag," + 
                           " OperatorCode," + 
                           " OperatorName," + 
                           " Flag From PrpLcheckItemLog Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcheckItemLogDto prpLcheckItemLogDto = null;
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

            prpLcheckItemLogDto = new PrpLcheckItemLogDto();
            prpLcheckItemLogDto.setScheduleID(dbManager.getInt(resultSet,1));
            prpLcheckItemLogDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLcheckItemLogDto.setItemNo(dbManager.getDouble(resultSet,3));
            prpLcheckItemLogDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLcheckItemLogDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLcheckItemLogDto.setCheckFlag(dbManager.getString(resultSet,6));
            prpLcheckItemLogDto.setCheckInfo(dbManager.getString(resultSet,7));
            prpLcheckItemLogDto.setDealFlag(dbManager.getString(resultSet,8));
            prpLcheckItemLogDto.setOperatorCode(dbManager.getString(resultSet,9));
            prpLcheckItemLogDto.setOperatorName(dbManager.getString(resultSet,10));
            prpLcheckItemLogDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpLcheckItemLogDto);
        }
        resultSet.close();
        logger.info("DBPrpLcheckItemLogBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcheckItemLog Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcheckItemLogBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcheckItemLog Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcheckItemLogBase.getCount() success!");
        return count;
    }
}
