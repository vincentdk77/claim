package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredExtDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcinsuredext��ϵ����չ��Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsuredExtBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCinsuredExtBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCinsuredExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void insert(PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        String statement = " Insert Into PrpCinsuredExt(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCinsuredExtDto.getPolicyNo());
        dbManager.setInt(2,prpCinsuredExtDto.getSerialNo());
        dbManager.setString(3,prpCinsuredExtDto.getColumnName());
        dbManager.setString(4,prpCinsuredExtDto.getDisplayName());
        dbManager.setString(5,prpCinsuredExtDto.getColumnValue());
        dbManager.setString(6,prpCinsuredExtDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredExtBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCinsuredExtDto prpCinsuredExtDto = (PrpCinsuredExtDto)i.next();
            insert(prpCinsuredExtDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @param columnName �����ֶ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo,String columnName) throws Exception{
        String statement = " Delete From PrpCinsuredExt Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCinsuredExtBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void update(PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        String statement = " Update PrpCinsuredExt Set DisplayName = ?," + 
                           " ColumnValue = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCinsuredExtDto.getDisplayName());
        dbManager.setString(2,prpCinsuredExtDto.getColumnValue());
        dbManager.setString(3,prpCinsuredExtDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,prpCinsuredExtDto.getPolicyNo());
        dbManager.setInt(5,prpCinsuredExtDto.getSerialNo());
        dbManager.setString(6,prpCinsuredExtDto.getColumnName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredExtBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @param columnName �����ֶ���
     * @return PrpCinsuredExtDto
     * @throws Exception
     */
    public PrpCinsuredExtDto findByPrimaryKey(String policyNo,int serialNo,String columnName) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag From PrpCinsuredExt Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        PrpCinsuredExtDto prpCinsuredExtDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCinsuredExtDto = new PrpCinsuredExtDto();
            prpCinsuredExtDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredExtDto.setColumnName(dbManager.getString(resultSet,3));
            prpCinsuredExtDto.setDisplayName(dbManager.getString(resultSet,4));
            prpCinsuredExtDto.setColumnValue(dbManager.getString(resultSet,5));
            prpCinsuredExtDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.findByPrimaryKey() success!");
        return prpCinsuredExtDto;
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
        String statement = "Select PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag From PrpCinsuredExt Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCinsuredExtDto prpCinsuredExtDto = null;
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

            prpCinsuredExtDto = new PrpCinsuredExtDto();
            prpCinsuredExtDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredExtDto.setColumnName(dbManager.getString(resultSet,3));
            prpCinsuredExtDto.setDisplayName(dbManager.getString(resultSet,4));
            prpCinsuredExtDto.setColumnValue(dbManager.getString(resultSet,5));
            prpCinsuredExtDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCinsuredExtDto);
        }
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpCinsuredExt Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCinsuredExtBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCinsuredExt Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.getCount() success!");
        return count;
    }
}
