package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utigroup�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiGroupBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiGroupBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void insert(UtiGroupDto utiGroupDto) throws Exception{
        String statement = " Insert Into UtiGroup(" + 
                           " GroupCode," + 
                           " GroupName," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiGroupDto.getGroupCode());
        dbManager.setString(2,utiGroupDto.getGroupName());
        dbManager.setString(3,utiGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiGroupBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiGroupDto utiGroupDto = (UtiGroupDto)i.next();
            insert(utiGroupDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param groupCode groupcode
     * @throws Exception
     */
    public void delete(String groupCode) throws Exception{
        String statement = " Delete From UtiGroup Where " +
                           " GroupCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiGroupBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiGroupDto utiGroupDto
     * @throws Exception
     */
    public void update(UtiGroupDto utiGroupDto) throws Exception{
        String statement = " Update UtiGroup Set GroupName = ?," + 
                           " Flag = ? Where " +
                           " GroupCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiGroupDto.getGroupName());
        dbManager.setString(2,utiGroupDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,utiGroupDto.getGroupCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiGroupBase.update() success!");
    }

    /**
     * ����������һ������
     * @param groupCode groupcode
     * @return UtiGroupDto
     * @throws Exception
     */
    public UtiGroupDto findByPrimaryKey(String groupCode) throws Exception{
        String statement = " Select GroupCode," + 
                           " GroupName," + 
                           " Flag From UtiGroup Where " +
                           " GroupCode = ?";
        UtiGroupDto utiGroupDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiGroupDto = new UtiGroupDto();
            utiGroupDto.setGroupCode(dbManager.getString(resultSet,1));
            utiGroupDto.setGroupName(dbManager.getString(resultSet,2));
            utiGroupDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBUtiGroupBase.findByPrimaryKey() success!");
        return utiGroupDto;
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
        String statement = "Select GroupCode," + 
                           " GroupName," + 
                           " Flag From UtiGroup Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiGroupDto utiGroupDto = null;
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

            utiGroupDto = new UtiGroupDto();
            utiGroupDto.setGroupCode(dbManager.getString(resultSet,1));
            utiGroupDto.setGroupName(dbManager.getString(resultSet,2));
            utiGroupDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(utiGroupDto);
        }
        resultSet.close();
        log.info("DBUtiGroupBase.findByConditions() success!");
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
        String statement = "Delete From UtiGroup Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiGroup Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiGroupBase.getCount() success!");
        return count;
    }
}
