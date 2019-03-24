package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtCodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utiprtcode�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPrtCodeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiPrtCodeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiPrtCodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void insert(UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        String statement = " Insert Into UtiPrtCode(" + 
                           " InstructType," + 
                           " InstructCode," + 
                           " InstructName," + 
                           " CtrlCode," + 
                           " Flag) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPrtCodeDto.getInstructType());
        dbManager.setString(2,utiPrtCodeDto.getInstructCode());
        dbManager.setString(3,utiPrtCodeDto.getInstructName());
        dbManager.setString(4,utiPrtCodeDto.getCtrlCode());
        dbManager.setString(5,utiPrtCodeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtCodeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPrtCodeDto utiPrtCodeDto = (UtiPrtCodeDto)i.next();
            insert(utiPrtCodeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param instructType instructtype
     * @param instructCode instructcode
     * @throws Exception
     */
    public void delete(String instructType,String instructCode) throws Exception{
        String statement = " Delete From UtiPrtCode Where " +
                           " InstructType = ? And " + 
                           " InstructCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,instructType);
        dbManager.setString(2,instructCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPrtCodeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiPrtCodeDto utiPrtCodeDto
     * @throws Exception
     */
    public void update(UtiPrtCodeDto utiPrtCodeDto) throws Exception{
        String statement = " Update UtiPrtCode Set InstructName = ?," + 
                           " CtrlCode = ?," + 
                           " Flag = ? Where " +
                           " InstructType = ? And " + 
                           " InstructCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiPrtCodeDto.getInstructName());
        dbManager.setString(2,utiPrtCodeDto.getCtrlCode());
        dbManager.setString(3,utiPrtCodeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,utiPrtCodeDto.getInstructType());
        dbManager.setString(5,utiPrtCodeDto.getInstructCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtCodeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param instructType instructtype
     * @param instructCode instructcode
     * @return UtiPrtCodeDto
     * @throws Exception
     */
    public UtiPrtCodeDto findByPrimaryKey(String instructType,String instructCode) throws Exception{
        String statement = " Select InstructType," + 
                           " InstructCode," + 
                           " InstructName," + 
                           " CtrlCode," + 
                           " Flag From UtiPrtCode Where " +
                           " InstructType = ? And " + 
                           " InstructCode = ?";
        UtiPrtCodeDto utiPrtCodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,instructType);
        dbManager.setString(2,instructCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPrtCodeDto = new UtiPrtCodeDto();
            utiPrtCodeDto.setInstructType(dbManager.getString(resultSet,1));
            utiPrtCodeDto.setInstructCode(dbManager.getString(resultSet,2));
            utiPrtCodeDto.setInstructName(dbManager.getString(resultSet,3));
            utiPrtCodeDto.setCtrlCode(dbManager.getString(resultSet,4));
            utiPrtCodeDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        log.info("DBUtiPrtCodeBase.findByPrimaryKey() success!");
        return utiPrtCodeDto;
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
        String statement = "Select InstructType," + 
                           " InstructCode," + 
                           " InstructName," + 
                           " CtrlCode," + 
                           " Flag From UtiPrtCode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPrtCodeDto utiPrtCodeDto = null;
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

            utiPrtCodeDto = new UtiPrtCodeDto();
            utiPrtCodeDto.setInstructType(dbManager.getString(resultSet,1));
            utiPrtCodeDto.setInstructCode(dbManager.getString(resultSet,2));
            utiPrtCodeDto.setInstructName(dbManager.getString(resultSet,3));
            utiPrtCodeDto.setCtrlCode(dbManager.getString(resultSet,4));
            utiPrtCodeDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(utiPrtCodeDto);
        }
        resultSet.close();
        log.info("DBUtiPrtCodeBase.findByConditions() success!");
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
        String statement = "Delete From UtiPrtCode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPrtCodeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiPrtCode Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPrtCodeBase.getCount() success!");
        return count;
    }
}
