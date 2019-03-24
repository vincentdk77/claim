package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtRecordDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtrecord�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPrtRecordBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiPrtRecordBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPrtRecordBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void insert(UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        String statement = " Insert Into UtiPrtRecord(" + 
                           " CertiNo," + 
                           " CertiType," + 
                           " UserName," + 
                           " PrtDate," + 
                           " PrtCount," + 
                           " Note," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPrtRecordDto.getCertiNo());
        dbManager.setString(2,utiPrtRecordDto.getCertiType());
        dbManager.setString(3,utiPrtRecordDto.getUserName());
        dbManager.setString(4,utiPrtRecordDto.getPrtDate());
        dbManager.setInt(5,utiPrtRecordDto.getPrtCount());
        dbManager.setString(6,utiPrtRecordDto.getNote());
        dbManager.setString(7,utiPrtRecordDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtRecordBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPrtRecordDto utiPrtRecordDto = (UtiPrtRecordDto)i.next();
            insert(utiPrtRecordDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param certiNo certino
     * @throws Exception
     */
    public void delete(String certiNo) throws Exception{
        String statement = " Delete From UtiPrtRecord Where " +
                           " CertiNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPrtRecordBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiPrtRecordDto utiPrtRecordDto
     * @throws Exception
     */
    public void update(UtiPrtRecordDto utiPrtRecordDto) throws Exception{
        String statement = " Update UtiPrtRecord Set CertiType = ?," + 
                           " UserName = ?," + 
                           " PrtDate = ?," + 
                           " PrtCount = ?," + 
                           " Note = ?," + 
                           " Flag = ? Where " +
                           " CertiNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiPrtRecordDto.getCertiType());
        dbManager.setString(2,utiPrtRecordDto.getUserName());
        dbManager.setString(3,utiPrtRecordDto.getPrtDate());
        dbManager.setInt(4,utiPrtRecordDto.getPrtCount());
        dbManager.setString(5,utiPrtRecordDto.getNote());
        dbManager.setString(6,utiPrtRecordDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,utiPrtRecordDto.getCertiNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtRecordBase.update() success!");
    }

    /**
     * ����������һ������
     * @param certiNo certino
     * @return UtiPrtRecordDto
     * @throws Exception
     */
    public UtiPrtRecordDto findByPrimaryKey(String certiNo) throws Exception{
        String statement = " Select CertiNo," + 
                           " CertiType," + 
                           " UserName," + 
                           " PrtDate," + 
                           " PrtCount," + 
                           " Note," + 
                           " Flag From UtiPrtRecord Where " +
                           " CertiNo = ?";
        UtiPrtRecordDto utiPrtRecordDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPrtRecordDto = new UtiPrtRecordDto();
            utiPrtRecordDto.setCertiNo(dbManager.getString(resultSet,1));
            utiPrtRecordDto.setCertiType(dbManager.getString(resultSet,2));
            utiPrtRecordDto.setUserName(dbManager.getString(resultSet,3));
            utiPrtRecordDto.setPrtDate(dbManager.getString(resultSet,4));
            utiPrtRecordDto.setPrtCount(dbManager.getInt(resultSet,5));
            utiPrtRecordDto.setNote(dbManager.getString(resultSet,6));
            utiPrtRecordDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBUtiPrtRecordBase.findByPrimaryKey() success!");
        return utiPrtRecordDto;
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
        String statement = "Select CertiNo," + 
                           " CertiType," + 
                           " UserName," + 
                           " PrtDate," + 
                           " PrtCount," + 
                           " Note," + 
                           " Flag From UtiPrtRecord Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPrtRecordDto utiPrtRecordDto = null;
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

            utiPrtRecordDto = new UtiPrtRecordDto();
            utiPrtRecordDto.setCertiNo(dbManager.getString(resultSet,1));
            utiPrtRecordDto.setCertiType(dbManager.getString(resultSet,2));
            utiPrtRecordDto.setUserName(dbManager.getString(resultSet,3));
            utiPrtRecordDto.setPrtDate(dbManager.getString(resultSet,4));
            utiPrtRecordDto.setPrtCount(dbManager.getInt(resultSet,5));
            utiPrtRecordDto.setNote(dbManager.getString(resultSet,6));
            utiPrtRecordDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(utiPrtRecordDto);
        }
        resultSet.close();
        log.info("DBUtiPrtRecordBase.findByConditions() success!");
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
        String statement = "Delete From UtiPrtRecord Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPrtRecordBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiPrtRecord Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPrtRecordBase.getCount() success!");
        return count;
    }
}
