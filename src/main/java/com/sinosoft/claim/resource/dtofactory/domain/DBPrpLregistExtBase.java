package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLregistExt-������Ϣ����˵�������ݷ��ʶ������<br>
 * ������ 2005-06-24 11:04:04.484<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLregistExtBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLregistExtBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLregistExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLregistExtDto prpLregistExtDto
     * @throws Exception
     */
    public void insert(PrpLregistExtDto prpLregistExtDto) throws Exception{
        String mainStatement = " Insert Into PrpLregistExt (" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Context)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLregistExtDto.getRegistNo() + "'," + 
                           "'" + prpLregistExtDto.getRiskCode() + "'," + 
                           "" + prpLregistExtDto.getSerialNo() + "," + 
                           "'" + prpLregistExtDto.getInputDate() + "'," + 
                           "'" + prpLregistExtDto.getInputHour() + "'," + 
                           "'" + prpLregistExtDto.getOperatorCode() + "'," + 
                           "'" + prpLregistExtDto.getComCode() + "'," + 
                           "'" + prpLregistExtDto.getContext() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLregistExtDto.getRegistNo());
        dbManager.setString(2,prpLregistExtDto.getRiskCode());
        dbManager.setInt(3,prpLregistExtDto.getSerialNo());
        dbManager.setDateTime(4,prpLregistExtDto.getInputDate());
        dbManager.setString(5,prpLregistExtDto.getInputHour());
        dbManager.setString(6,prpLregistExtDto.getOperatorCode());
        dbManager.setString(7,prpLregistExtDto.getComCode());
        dbManager.setString(8,prpLregistExtDto.getContext());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLregistExtBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLregistExtDto prpLregistExtDto = (PrpLregistExtDto)i.next();
            insert(prpLregistExtDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param registNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLregistExt" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLregistExt Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLregistExtBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLregistExtDto prpLregistExtDto
     * @throws Exception
     */
    public void update(PrpLregistExtDto prpLregistExtDto) throws Exception{
        String statement = " Update PrpLregistExt Set RiskCode = ?," + 
                           " InputDate = ?," + 
                           " InputHour = ?," + 
                           " OperatorCode = ?," + 
                           " ComCode = ?," + 
                           " Context = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLregistExt Set " + 
                           " RegistNo = '" + prpLregistExtDto.getRegistNo() + "'," + 
                           " RiskCode = '" + prpLregistExtDto.getRiskCode() + "'," + 
                           " SerialNo = " + prpLregistExtDto.getSerialNo() + "," + 
                           " InputDate = '" + prpLregistExtDto.getInputDate() + "'," + 
                           " InputHour = '" + prpLregistExtDto.getInputHour() + "'," + 
                           " OperatorCode = '" + prpLregistExtDto.getOperatorCode() + "'," + 
                           " ComCode = '" + prpLregistExtDto.getComCode() + "'," + 
                           " Context = '" + prpLregistExtDto.getContext() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLregistExtDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLregistExtDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLregistExtDto.getRiskCode());
        dbManager.setDateTime(2,prpLregistExtDto.getInputDate());
        dbManager.setString(3,prpLregistExtDto.getInputHour());
        dbManager.setString(4,prpLregistExtDto.getOperatorCode());
        dbManager.setString(5,prpLregistExtDto.getComCode());
        dbManager.setString(6,prpLregistExtDto.getContext());
        //���������ֶ�;
        dbManager.setString(7,prpLregistExtDto.getRegistNo());
        dbManager.setInt(8,prpLregistExtDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLregistExtBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ��������
     * @param serialNo ���
     * @return PrpLregistExtDto
     * @throws Exception
     */
    public PrpLregistExtDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Context From PrpLregistExt";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLregistExtDto prpLregistExtDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLregistExtDto = new PrpLregistExtDto();
            prpLregistExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLregistExtDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLregistExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLregistExtDto.setInputHour(dbManager.getString(resultSet,5));
            prpLregistExtDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpLregistExtDto.setComCode(dbManager.getString(resultSet,7));
            prpLregistExtDto.setContext(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        logger.info("DBPrpLregistExtBase.findByPrimaryKey() success!");
        return prpLregistExtDto;
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
        String statement = "Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " InputDate," + 
                           " InputHour," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Context From PrpLregistExt Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLregistExtDto prpLregistExtDto = null;
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

            prpLregistExtDto = new PrpLregistExtDto();
            prpLregistExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLregistExtDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLregistExtDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLregistExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            prpLregistExtDto.setInputHour(dbManager.getString(resultSet,5));
            prpLregistExtDto.setOperatorCode(dbManager.getString(resultSet,6));
            prpLregistExtDto.setComCode(dbManager.getString(resultSet,7));
            prpLregistExtDto.setContext(dbManager.getString(resultSet,8));
            collection.add(prpLregistExtDto);
        }
        resultSet.close();
        logger.info("DBPrpLregistExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpLregistExt Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLregistExtBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLregistExt Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLregistExtBase.getCount() success!");
        return count;
    }
}
