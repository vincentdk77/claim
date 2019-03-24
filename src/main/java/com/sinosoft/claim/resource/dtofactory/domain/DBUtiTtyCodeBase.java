package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyCodeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utittycode�ն����Լ�¼������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiTtyCodeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiTtyCodeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiTtyCodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void insert(UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        String statement = " Insert Into UtiTtyCode(" + 
                           " TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiTtyCodeDto.getTtyCode());
        dbManager.setString(2,utiTtyCodeDto.getSysTty());
        dbManager.setString(3,utiTtyCodeDto.getTtyType());
        dbManager.setString(4,utiTtyCodeDto.getTtyName());
        dbManager.setString(5,utiTtyCodeDto.getPrtType());
        dbManager.setString(6,utiTtyCodeDto.getPrtName());
        dbManager.setString(7,utiTtyCodeDto.getPrtMode());
        dbManager.setString(8,utiTtyCodeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyCodeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiTtyCodeDto utiTtyCodeDto = (UtiTtyCodeDto)i.next();
            insert(utiTtyCodeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param ttyCode �ն����
     * @throws Exception
     */
    public void delete(String ttyCode) throws Exception{
        String statement = " Delete From UtiTtyCode Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,ttyCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiTtyCodeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void update(UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        String statement = " Update UtiTtyCode Set SysTty = ?," + 
                           " TtyType = ?," + 
                           " TtyName = ?," + 
                           " PrtType = ?," + 
                           " PrtName = ?," + 
                           " PrtMode = ?," + 
                           " Flag = ? Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiTtyCodeDto.getSysTty());
        dbManager.setString(2,utiTtyCodeDto.getTtyType());
        dbManager.setString(3,utiTtyCodeDto.getTtyName());
        dbManager.setString(4,utiTtyCodeDto.getPrtType());
        dbManager.setString(5,utiTtyCodeDto.getPrtName());
        dbManager.setString(6,utiTtyCodeDto.getPrtMode());
        dbManager.setString(7,utiTtyCodeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(8,utiTtyCodeDto.getTtyCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyCodeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param ttyCode �ն����
     * @return UtiTtyCodeDto
     * @throws Exception
     */
    public UtiTtyCodeDto findByPrimaryKey(String ttyCode) throws Exception{
        String statement = " Select TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag From UtiTtyCode Where " +
                           " TtyCode = ?";
        UtiTtyCodeDto utiTtyCodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,ttyCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiTtyCodeDto = new UtiTtyCodeDto();
            utiTtyCodeDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyCodeDto.setSysTty(dbManager.getString(resultSet,2));
            utiTtyCodeDto.setTtyType(dbManager.getString(resultSet,3));
            utiTtyCodeDto.setTtyName(dbManager.getString(resultSet,4));
            utiTtyCodeDto.setPrtType(dbManager.getString(resultSet,5));
            utiTtyCodeDto.setPrtName(dbManager.getString(resultSet,6));
            utiTtyCodeDto.setPrtMode(dbManager.getString(resultSet,7));
            utiTtyCodeDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBUtiTtyCodeBase.findByPrimaryKey() success!");
        return utiTtyCodeDto;
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
        String statement = "Select TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag From UtiTtyCode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiTtyCodeDto utiTtyCodeDto = null;
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

            utiTtyCodeDto = new UtiTtyCodeDto();
            utiTtyCodeDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyCodeDto.setSysTty(dbManager.getString(resultSet,2));
            utiTtyCodeDto.setTtyType(dbManager.getString(resultSet,3));
            utiTtyCodeDto.setTtyName(dbManager.getString(resultSet,4));
            utiTtyCodeDto.setPrtType(dbManager.getString(resultSet,5));
            utiTtyCodeDto.setPrtName(dbManager.getString(resultSet,6));
            utiTtyCodeDto.setPrtMode(dbManager.getString(resultSet,7));
            utiTtyCodeDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(utiTtyCodeDto);
        }
        resultSet.close();
        log.info("DBUtiTtyCodeBase.findByConditions() success!");
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
        String statement = "Delete From UtiTtyCode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiTtyCodeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiTtyCode Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiTtyCodeBase.getCount() success!");
        return count;
    }
}
