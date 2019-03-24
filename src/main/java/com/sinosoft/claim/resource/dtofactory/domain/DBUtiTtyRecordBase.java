package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyRecordDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittyrecord��¼��¼������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiTtyRecordBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiTtyRecordBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiTtyRecordBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void insert(UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        String statement = " Insert Into UtiTtyRecord(" + 
                           " SysTty," + 
                           " UserName," + 
                           " ComCode," + 
                           " Year," + 
                           " RiskCode," + 
                           " TtyCode," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiTtyRecordDto.getSysTty());
        dbManager.setString(2,utiTtyRecordDto.getUserName());
        dbManager.setString(3,utiTtyRecordDto.getComCode());
        dbManager.setString(4,utiTtyRecordDto.getYear());
        dbManager.setString(5,utiTtyRecordDto.getRiskCode());
        dbManager.setString(6,utiTtyRecordDto.getTtyCode());
        dbManager.setString(7,utiTtyRecordDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyRecordBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiTtyRecordDto utiTtyRecordDto = (UtiTtyRecordDto)i.next();
            insert(utiTtyRecordDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param sysTty ϵͳ�豸��
     * @throws Exception
     */
    public void delete(String sysTty) throws Exception{
        String statement = " Delete From UtiTtyRecord Where " +
                           " SysTty = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,sysTty);
        dbManager.executePreparedUpdate();
        log.info("DBUtiTtyRecordBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void update(UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        String statement = " Update UtiTtyRecord Set UserName = ?," + 
                           " ComCode = ?," + 
                           " Year = ?," + 
                           " RiskCode = ?," + 
                           " TtyCode = ?," + 
                           " Flag = ? Where " +
                           " SysTty = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiTtyRecordDto.getUserName());
        dbManager.setString(2,utiTtyRecordDto.getComCode());
        dbManager.setString(3,utiTtyRecordDto.getYear());
        dbManager.setString(4,utiTtyRecordDto.getRiskCode());
        dbManager.setString(5,utiTtyRecordDto.getTtyCode());
        dbManager.setString(6,utiTtyRecordDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,utiTtyRecordDto.getSysTty());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyRecordBase.update() success!");
    }

    /**
     * ����������һ������
     * @param sysTty ϵͳ�豸��
     * @return UtiTtyRecordDto
     * @throws Exception
     */
    public UtiTtyRecordDto findByPrimaryKey(String sysTty) throws Exception{
        String statement = " Select SysTty," + 
                           " UserName," + 
                           " ComCode," + 
                           " Year," + 
                           " RiskCode," + 
                           " TtyCode," + 
                           " Flag From UtiTtyRecord Where " +
                           " SysTty = ?";
        UtiTtyRecordDto utiTtyRecordDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,sysTty);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiTtyRecordDto = new UtiTtyRecordDto();
            utiTtyRecordDto.setSysTty(dbManager.getString(resultSet,1));
            utiTtyRecordDto.setUserName(dbManager.getString(resultSet,2));
            utiTtyRecordDto.setComCode(dbManager.getString(resultSet,3));
            utiTtyRecordDto.setYear(dbManager.getString(resultSet,4));
            utiTtyRecordDto.setRiskCode(dbManager.getString(resultSet,5));
            utiTtyRecordDto.setTtyCode(dbManager.getString(resultSet,6));
            utiTtyRecordDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBUtiTtyRecordBase.findByPrimaryKey() success!");
        return utiTtyRecordDto;
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
        String statement = "Select SysTty," + 
                           " UserName," + 
                           " ComCode," + 
                           " Year," + 
                           " RiskCode," + 
                           " TtyCode," + 
                           " Flag From UtiTtyRecord Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiTtyRecordDto utiTtyRecordDto = null;
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

            utiTtyRecordDto = new UtiTtyRecordDto();
            utiTtyRecordDto.setSysTty(dbManager.getString(resultSet,1));
            utiTtyRecordDto.setUserName(dbManager.getString(resultSet,2));
            utiTtyRecordDto.setComCode(dbManager.getString(resultSet,3));
            utiTtyRecordDto.setYear(dbManager.getString(resultSet,4));
            utiTtyRecordDto.setRiskCode(dbManager.getString(resultSet,5));
            utiTtyRecordDto.setTtyCode(dbManager.getString(resultSet,6));
            utiTtyRecordDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(utiTtyRecordDto);
        }
        resultSet.close();
        log.info("DBUtiTtyRecordBase.findByConditions() success!");
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
        String statement = "Delete From UtiTtyRecord Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiTtyRecordBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiTtyRecord Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiTtyRecordBase.getCount() success!");
        return count;
    }
}
