package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLthirdpartyStatusDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLthirdpartyStatus-���������ҵ��Ϣ������Ϣ״̬������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.015<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdpartyStatusBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLthirdpartyStatusBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLthirdpartyStatusBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void insert(PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        String mainStatement = " Insert Into PrpLthirdpartyStatus (" + 
                           " BusinessNo," + 
                           " BUSINESSTYPE," + 
                           " SerialNo," + 
                           " ALTERNATETYPE," + 
                           " ALTERNATEFLAG," + 
                           " ERRORNO," + 
                           " ALTERNATEDATE," + 
                           " ALTERNATEHOUR," + 
                           " ERRORMESSAGE," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLthirdpartyStatusDto.getBusinessNo() + "'," + 
                           "'" + prpLthirdpartyStatusDto.getBUSINESSTYPE() + "'," + 
                           "" + prpLthirdpartyStatusDto.getSerialNo() + "," + 
                           "'" + prpLthirdpartyStatusDto.getALTERNATETYPE() + "'," + 
                           "'" + prpLthirdpartyStatusDto.getALTERNATEFLAG() + "'," + 
                           "'" + prpLthirdpartyStatusDto.getERRORNO() + "'," + 
                           "'" + prpLthirdpartyStatusDto.getALTERNATEDATE() + "'," + 
                           "" + prpLthirdpartyStatusDto.getALTERNATEHOUR() + "," + 
                           "'" + prpLthirdpartyStatusDto.getERRORMESSAGE() + "'," + 
                           "'" + prpLthirdpartyStatusDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLthirdpartyStatusDto.getBusinessNo());
        dbManager.setString(2,prpLthirdpartyStatusDto.getBUSINESSTYPE());
        dbManager.setInt(3,prpLthirdpartyStatusDto.getSerialNo());
        dbManager.setString(4,prpLthirdpartyStatusDto.getALTERNATETYPE());
        dbManager.setString(5,prpLthirdpartyStatusDto.getALTERNATEFLAG());
        dbManager.setString(6,prpLthirdpartyStatusDto.getERRORNO());
        dbManager.setDateTime(7,prpLthirdpartyStatusDto.getALTERNATEDATE());
        dbManager.setInt(8,prpLthirdpartyStatusDto.getALTERNATEHOUR());
        dbManager.setString(9,prpLthirdpartyStatusDto.getERRORMESSAGE());
        dbManager.setString(10,prpLthirdpartyStatusDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdpartyStatusBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLthirdpartyStatus (" + 
                           " BusinessNo," + 
                           " BUSINESSTYPE," + 
                           " SerialNo," + 
                           " ALTERNATETYPE," + 
                           " ALTERNATEFLAG," + 
                           " ERRORNO," + 
                           " ALTERNATEDATE," + 
                           " ALTERNATEHOUR," + 
                           " ERRORMESSAGE," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = (PrpLthirdpartyStatusDto)i.next();
            dbManager.setString(1,prpLthirdpartyStatusDto.getBusinessNo());
            dbManager.setString(2,prpLthirdpartyStatusDto.getBUSINESSTYPE());
            dbManager.setInt(3,prpLthirdpartyStatusDto.getSerialNo());
            dbManager.setString(4,prpLthirdpartyStatusDto.getALTERNATETYPE());
            dbManager.setString(5,prpLthirdpartyStatusDto.getALTERNATEFLAG());
            dbManager.setString(6,prpLthirdpartyStatusDto.getERRORNO());
            dbManager.setDateTime(7,prpLthirdpartyStatusDto.getALTERNATEDATE());
            dbManager.setInt(8,prpLthirdpartyStatusDto.getALTERNATEHOUR());
            dbManager.setString(9,prpLthirdpartyStatusDto.getERRORMESSAGE());
            dbManager.setString(10,prpLthirdpartyStatusDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLthirdpartyStatusBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLthirdpartyStatus" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLthirdpartyStatus Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLthirdpartyStatusBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLthirdpartyStatusDto prpLthirdpartyStatusDto
     * @throws Exception
     */
    public void update(PrpLthirdpartyStatusDto prpLthirdpartyStatusDto) throws Exception{
        String statement = " Update PrpLthirdpartyStatus Set BUSINESSTYPE = ?," + 
                           " ALTERNATETYPE = ?," + 
                           " ALTERNATEFLAG = ?," + 
                           " ERRORNO = ?," + 
                           " ALTERNATEDATE = ?," + 
                           " ALTERNATEHOUR = ?," + 
                           " ERRORMESSAGE = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLthirdpartyStatus Set " + 
                           " BusinessNo = '" + prpLthirdpartyStatusDto.getBusinessNo() + "'," + 
                           " BUSINESSTYPE = '" + prpLthirdpartyStatusDto.getBUSINESSTYPE() + "'," + 
                           " SerialNo = " + prpLthirdpartyStatusDto.getSerialNo() + "," + 
                           " ALTERNATETYPE = '" + prpLthirdpartyStatusDto.getALTERNATETYPE() + "'," + 
                           " ALTERNATEFLAG = '" + prpLthirdpartyStatusDto.getALTERNATEFLAG() + "'," + 
                           " ERRORNO = '" + prpLthirdpartyStatusDto.getERRORNO() + "'," + 
                           " ALTERNATEDATE = '" + prpLthirdpartyStatusDto.getALTERNATEDATE() + "'," + 
                           " ALTERNATEHOUR = " + prpLthirdpartyStatusDto.getALTERNATEHOUR() + "," + 
                           " ERRORMESSAGE = '" + prpLthirdpartyStatusDto.getERRORMESSAGE() + "'," + 
                           " Flag = '" + prpLthirdpartyStatusDto.getFlag() + "'" + 
			               " Where " +
                           " BusinessNo = '" + prpLthirdpartyStatusDto.getBusinessNo() + "' And " + 
                           " SerialNo = " + prpLthirdpartyStatusDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLthirdpartyStatusDto.getBUSINESSTYPE());
        dbManager.setString(2,prpLthirdpartyStatusDto.getALTERNATETYPE());
        dbManager.setString(3,prpLthirdpartyStatusDto.getALTERNATEFLAG());
        dbManager.setString(4,prpLthirdpartyStatusDto.getERRORNO());
        dbManager.setDateTime(5,prpLthirdpartyStatusDto.getALTERNATEDATE());
        dbManager.setInt(6,prpLthirdpartyStatusDto.getALTERNATEHOUR());
        dbManager.setString(7,prpLthirdpartyStatusDto.getERRORMESSAGE());
        dbManager.setString(8,prpLthirdpartyStatusDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpLthirdpartyStatusDto.getBusinessNo());
        dbManager.setInt(10,prpLthirdpartyStatusDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLthirdpartyStatusBase.update() success!");
    }

    /**
     * ����������һ������
     * @param businessNo ����ҵ�����
     * @param serialNo ���
     * @return PrpLthirdpartyStatusDto
     * @throws Exception
     */
    public PrpLthirdpartyStatusDto findByPrimaryKey(String businessNo,int serialNo) throws Exception{
        String mainStatement = " Select BusinessNo," + 
                           " BUSINESSTYPE," + 
                           " SerialNo," + 
                           " ALTERNATETYPE," + 
                           " ALTERNATEFLAG," + 
                           " ERRORNO," + 
                           " ALTERNATEDATE," + 
                           " ALTERNATEHOUR," + 
                           " ERRORMESSAGE," + 
                           " Flag From PrpLthirdpartyStatus";
        String statement = mainStatement + " Where " +
                           " BusinessNo = ? And " + 
                           " SerialNo = ?";
        PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BusinessNo = '" + businessNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLthirdpartyStatusDto = new PrpLthirdpartyStatusDto();
            prpLthirdpartyStatusDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLthirdpartyStatusDto.setBUSINESSTYPE(dbManager.getString(resultSet,2));
            prpLthirdpartyStatusDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdpartyStatusDto.setALTERNATETYPE(dbManager.getString(resultSet,4));
            prpLthirdpartyStatusDto.setALTERNATEFLAG(dbManager.getString(resultSet,5));
            prpLthirdpartyStatusDto.setERRORNO(dbManager.getString(resultSet,6));
            prpLthirdpartyStatusDto.setALTERNATEDATE(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLthirdpartyStatusDto.setALTERNATEHOUR(dbManager.getInt(resultSet,8));
            prpLthirdpartyStatusDto.setERRORMESSAGE(dbManager.getString(resultSet,9));
            prpLthirdpartyStatusDto.setFlag(dbManager.getString(resultSet,10));
            logger.info("DBPrpLthirdpartyStatusBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLthirdpartyStatusBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLthirdpartyStatusDto;
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
        String statement = "Select BusinessNo," + 
                           " BUSINESSTYPE," + 
                           " SerialNo," + 
                           " ALTERNATETYPE," + 
                           " ALTERNATEFLAG," + 
                           " ERRORNO," + 
                           " ALTERNATEDATE," + 
                           " ALTERNATEHOUR," + 
                           " ERRORMESSAGE," + 
                           " Flag From PrpLthirdpartyStatus Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLthirdpartyStatusDto prpLthirdpartyStatusDto = null;
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

            prpLthirdpartyStatusDto = new PrpLthirdpartyStatusDto();
            prpLthirdpartyStatusDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLthirdpartyStatusDto.setBUSINESSTYPE(dbManager.getString(resultSet,2));
            prpLthirdpartyStatusDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLthirdpartyStatusDto.setALTERNATETYPE(dbManager.getString(resultSet,4));
            prpLthirdpartyStatusDto.setALTERNATEFLAG(dbManager.getString(resultSet,5));
            prpLthirdpartyStatusDto.setERRORNO(dbManager.getString(resultSet,6));
            prpLthirdpartyStatusDto.setALTERNATEDATE(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpLthirdpartyStatusDto.setALTERNATEHOUR(dbManager.getInt(resultSet,8));
            prpLthirdpartyStatusDto.setERRORMESSAGE(dbManager.getString(resultSet,9));
            prpLthirdpartyStatusDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpLthirdpartyStatusDto);
        }
        resultSet.close();
        logger.info("DBPrpLthirdpartyStatusBase.findByConditions() success!");
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
        String statement = "Delete From PrpLthirdpartyStatus Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLthirdpartyStatusBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLthirdpartyStatus Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLthirdpartyStatusBase.getCount() success!");
        return count;
    }
}
