package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxUseDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpmaxuse��֤��ʹ�õǼǱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpMaxUseBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpMaxUseBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpMaxUseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpMaxUseDto prpMaxUseDto
     * @throws Exception
     */
    public void insert(PrpMaxUseDto prpMaxUseDto) throws Exception{
        String statement = " Insert Into PrpMaxUse(" + 
                           " GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " TtyName," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpMaxUseDto.getGroupNo());
        dbManager.setString(2,prpMaxUseDto.getMaxNo());
        dbManager.setString(3,prpMaxUseDto.getTableName());
        dbManager.setString(4,prpMaxUseDto.getTtyName());
        dbManager.setString(5,prpMaxUseDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpMaxUseBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpMaxUseDto prpMaxUseDto = (PrpMaxUseDto)i.next();
            insert(prpMaxUseDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param groupNo ����
     * @param maxNo ���
     * @param tableName ����
     * @throws Exception
     */
    public void delete(String groupNo,String maxNo,String tableName) throws Exception{
        String statement = " Delete From PrpMaxUse Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,maxNo);
        dbManager.setString(3,tableName);
        dbManager.executePreparedUpdate();
        log.info("DBPrpMaxUseBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpMaxUseDto prpMaxUseDto
     * @throws Exception
     */
    public void update(PrpMaxUseDto prpMaxUseDto) throws Exception{
        String statement = " Update PrpMaxUse Set TtyName = ?," + 
                           " Flag = ? Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpMaxUseDto.getTtyName());
        dbManager.setString(2,prpMaxUseDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpMaxUseDto.getGroupNo());
        dbManager.setString(4,prpMaxUseDto.getMaxNo());
        dbManager.setString(5,prpMaxUseDto.getTableName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpMaxUseBase.update() success!");
    }

    /**
     * ����������һ������
     * @param groupNo ����
     * @param maxNo ���
     * @param tableName ����
     * @return PrpMaxUseDto
     * @throws Exception
     */
    public PrpMaxUseDto findByPrimaryKey(String groupNo,String maxNo,String tableName) throws Exception{
        String statement = " Select GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " TtyName," + 
                           " Flag From PrpMaxUse Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        PrpMaxUseDto prpMaxUseDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,maxNo);
        dbManager.setString(3,tableName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpMaxUseDto = new PrpMaxUseDto();
            prpMaxUseDto.setGroupNo(dbManager.getString(resultSet,1));
            prpMaxUseDto.setMaxNo(dbManager.getString(resultSet,2));
            prpMaxUseDto.setTableName(dbManager.getString(resultSet,3));
            prpMaxUseDto.setTtyName(dbManager.getString(resultSet,4));
            prpMaxUseDto.setFlag(dbManager.getString(resultSet,5));
        }
        log.info("DBPrpMaxUseBase.findByPrimaryKey() success!");
        return prpMaxUseDto;
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
        String statement = "Select GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " TtyName," + 
                           " Flag From PrpMaxUse Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpMaxUseDto prpMaxUseDto = null;
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

            prpMaxUseDto = new PrpMaxUseDto();
            prpMaxUseDto.setGroupNo(dbManager.getString(resultSet,1));
            prpMaxUseDto.setMaxNo(dbManager.getString(resultSet,2));
            prpMaxUseDto.setTableName(dbManager.getString(resultSet,3));
            prpMaxUseDto.setTtyName(dbManager.getString(resultSet,4));
            prpMaxUseDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpMaxUseDto);
        }
        log.info("DBPrpMaxUseBase.findByConditions() success!");
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
        String statement = "Delete From PrpMaxUse Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpMaxUseBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpMaxUse Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpMaxUseBase.getCount() success!");
        return count;
    }
}
