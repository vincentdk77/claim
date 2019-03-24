package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckExt-�鿱/���鿱��չ��(�޸�)�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckExtBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcheckExtBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcheckExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void insert(PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        String mainStatement = " Insert Into PrpLcheckExt (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag," + 
                           " ReferSerialNo)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcheckExtDto.getRegistNo() + "'," + 
                           "'" + prpLcheckExtDto.getClaimNo() + "'," + 
                           "'" + prpLcheckExtDto.getRiskCode() + "'," + 
                           "'" + prpLcheckExtDto.getPolicyNo() + "'," + 
                           "" + prpLcheckExtDto.getSerialNo() + "," + 
                           "'" + prpLcheckExtDto.getColumnName() + "'," + 
                           "'" + prpLcheckExtDto.getDisplayName() + "'," + 
                           "'" + prpLcheckExtDto.getColumnValue() + "'," + 
                           "'" + prpLcheckExtDto.getFlag() + "'," + 
                           "" + prpLcheckExtDto.getReferSerialNo() + ")";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcheckExtDto.getRegistNo());
        dbManager.setString(2,prpLcheckExtDto.getClaimNo());
        dbManager.setString(3,prpLcheckExtDto.getRiskCode());
        dbManager.setString(4,prpLcheckExtDto.getPolicyNo());
        dbManager.setInt(5,prpLcheckExtDto.getSerialNo());
        dbManager.setString(6,prpLcheckExtDto.getColumnName());
        dbManager.setString(7,prpLcheckExtDto.getDisplayName());
        dbManager.setString(8,prpLcheckExtDto.getColumnValue());
        dbManager.setString(9,prpLcheckExtDto.getFlag());
        dbManager.setInt(10,prpLcheckExtDto.getReferSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckExtBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcheckExt (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag," + 
                           " ReferSerialNo)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcheckExtDto prpLcheckExtDto = (PrpLcheckExtDto)i.next();
            dbManager.setString(1,prpLcheckExtDto.getRegistNo());
            dbManager.setString(2,prpLcheckExtDto.getClaimNo());
            dbManager.setString(3,prpLcheckExtDto.getRiskCode());
            dbManager.setString(4,prpLcheckExtDto.getPolicyNo());
            dbManager.setInt(5,prpLcheckExtDto.getSerialNo());
            dbManager.setString(6,prpLcheckExtDto.getColumnName());
            dbManager.setString(7,prpLcheckExtDto.getDisplayName());
            dbManager.setString(8,prpLcheckExtDto.getColumnValue());
            dbManager.setString(9,prpLcheckExtDto.getFlag());
            dbManager.setInt(10,prpLcheckExtDto.getReferSerialNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcheckExtBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @throws Exception
     */
    public void delete(String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        String statement = " Delete From PrpLcheckExt" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ? And " + 
                           " ReferSerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcheckExt Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " ColumnName = '" + columnName + "' And " + 
                           " ReferSerialNo = " + referSerialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        dbManager.setInt(4,referSerialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcheckExtBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void update(PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        String statement = " Update PrpLcheckExt Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " DisplayName = ?," + 
                           " ColumnValue = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ? And " + 
                           " ReferSerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcheckExt Set " + 
                           " RegistNo = '" + prpLcheckExtDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLcheckExtDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLcheckExtDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLcheckExtDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLcheckExtDto.getSerialNo() + "," + 
                           " ColumnName = '" + prpLcheckExtDto.getColumnName() + "'," + 
                           " DisplayName = '" + prpLcheckExtDto.getDisplayName() + "'," + 
                           " ColumnValue = '" + prpLcheckExtDto.getColumnValue() + "'," + 
                           " Flag = '" + prpLcheckExtDto.getFlag() + "'," + 
                           " ReferSerialNo = " + prpLcheckExtDto.getReferSerialNo() + "" + 
			               " Where " +
                           " RegistNo = '" + prpLcheckExtDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLcheckExtDto.getSerialNo() + " And " + 
                           " ColumnName = '" + prpLcheckExtDto.getColumnName() + "' And " + 
                           " ReferSerialNo = " + prpLcheckExtDto.getReferSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLcheckExtDto.getClaimNo());
        dbManager.setString(2,prpLcheckExtDto.getRiskCode());
        dbManager.setString(3,prpLcheckExtDto.getPolicyNo());
        dbManager.setString(4,prpLcheckExtDto.getDisplayName());
        dbManager.setString(5,prpLcheckExtDto.getColumnValue());
        dbManager.setString(6,prpLcheckExtDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpLcheckExtDto.getRegistNo());
        dbManager.setInt(8,prpLcheckExtDto.getSerialNo());
        dbManager.setString(9,prpLcheckExtDto.getColumnName());
        dbManager.setInt(10,prpLcheckExtDto.getReferSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckExtBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ��������
     * @param serialNo ���
     * @param columnName �鿱��Ŀ����
     * @param referSerialNo �������⳵�����
     * @return PrpLcheckExtDto
     * @throws Exception
     */
    public PrpLcheckExtDto findByPrimaryKey(String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag," + 
                           " ReferSerialNo From PrpLcheckExt";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ? And " + 
                           " ReferSerialNo = ?";
        PrpLcheckExtDto prpLcheckExtDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " ColumnName = '" + columnName + "' And " + 
                           " ReferSerialNo = " + referSerialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        dbManager.setInt(4,referSerialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcheckExtDto = new PrpLcheckExtDto();
            prpLcheckExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckExtDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckExtDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckExtDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckExtDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcheckExtDto.setColumnName(dbManager.getString(resultSet,6));
            prpLcheckExtDto.setDisplayName(dbManager.getString(resultSet,7));
            prpLcheckExtDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcheckExtDto.setFlag(dbManager.getString(resultSet,9));
            prpLcheckExtDto.setReferSerialNo(dbManager.getInt(resultSet,10));
            logger.info("DBPrpLcheckExtBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcheckExtBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcheckExtDto;
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
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag," + 
                           " ReferSerialNo From PrpLcheckExt Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcheckExtDto prpLcheckExtDto = null;
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

            prpLcheckExtDto = new PrpLcheckExtDto();
            prpLcheckExtDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckExtDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckExtDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckExtDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckExtDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcheckExtDto.setColumnName(dbManager.getString(resultSet,6));
            prpLcheckExtDto.setDisplayName(dbManager.getString(resultSet,7));
            prpLcheckExtDto.setColumnValue(dbManager.getString(resultSet,8));
            prpLcheckExtDto.setFlag(dbManager.getString(resultSet,9));
            prpLcheckExtDto.setReferSerialNo(dbManager.getInt(resultSet,10));
            collection.add(prpLcheckExtDto);
        }
        resultSet.close();
        logger.info("DBPrpLcheckExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcheckExt Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcheckExtBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcheckExt Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcheckExtBase.getCount() success!");
        return count;
    }
}
