package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPayRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefpayrec���Ѻ��շ���ϵ��¼������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefPayRecBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJrefPayRecBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJrefPayRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void insert(PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        String statement = " Insert Into PrpJrefPayRec(" + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefPayRecDto.getCertiNo());
        dbManager.setInt(2,prpJrefPayRecDto.getSerialNo());
        dbManager.setString(3,prpJrefPayRecDto.getPayFlag());
        dbManager.setInt(4,prpJrefPayRecDto.getOrder02No());
        dbManager.setInt(5,prpJrefPayRecDto.getPayTimes());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPayRecBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefPayRecDto prpJrefPayRecDto = (PrpJrefPayRecDto)i.next();
            insert(prpJrefPayRecDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @throws Exception
     */
    public void delete(String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJrefPayRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefPayRecBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void update(PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        String statement = " Update PrpJrefPayRec Set PayFlag = ?," + 
                           " Order02No = ?," + 
                           " PayTimes = ? Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpJrefPayRecDto.getPayFlag());
        dbManager.setInt(2,prpJrefPayRecDto.getOrder02No());
        dbManager.setInt(3,prpJrefPayRecDto.getPayTimes());
        //���������ֶ�;
        dbManager.setString(4,prpJrefPayRecDto.getCertiNo());
        dbManager.setInt(5,prpJrefPayRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPayRecBase.update() success!");
    }

    /**
     * ����������һ������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @return PrpJrefPayRecDto
     * @throws Exception
     */
    public PrpJrefPayRecDto findByPrimaryKey(String certiNo,int serialNo) throws Exception{
        String statement = " Select CertiNo," + 
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes From PrpJrefPayRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJrefPayRecDto prpJrefPayRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefPayRecDto = new PrpJrefPayRecDto();
            prpJrefPayRecDto.setCertiNo(dbManager.getString(resultSet,1));
            prpJrefPayRecDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJrefPayRecDto.setPayFlag(dbManager.getString(resultSet,3));
            prpJrefPayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJrefPayRecDto.setPayTimes(dbManager.getInt(resultSet,5));
        }
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.findByPrimaryKey() success!");
        return prpJrefPayRecDto;
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
                           " SerialNo," + 
                           " PayFlag," + 
                           " Order02No," + 
                           " PayTimes From PrpJrefPayRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefPayRecDto prpJrefPayRecDto = null;
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

            prpJrefPayRecDto = new PrpJrefPayRecDto();
            prpJrefPayRecDto.setCertiNo(dbManager.getString(resultSet,1));
            prpJrefPayRecDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJrefPayRecDto.setPayFlag(dbManager.getString(resultSet,3));
            prpJrefPayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJrefPayRecDto.setPayTimes(dbManager.getInt(resultSet,5));
            collection.add(prpJrefPayRecDto);
        }
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJrefPayRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefPayRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJrefPayRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefPayRecBase.getCount() success!");
        return count;
    }
}
