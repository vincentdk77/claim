package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcmainsub��������������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmainSubBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCmainSubBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCmainSubBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void insert(PrpCmainSubDto prpCmainSubDto) throws Exception{
        String statement = " Insert Into PrpCmainSub(" + 
                           " PolicyNo," + 
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCmainSubDto.getPolicyNo());
        dbManager.setString(2,prpCmainSubDto.getMainPolicyNo());
        dbManager.setString(3,prpCmainSubDto.getEndorseNo());
        dbManager.setString(4,prpCmainSubDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCmainSubBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCmainSubDto prpCmainSubDto = (PrpCmainSubDto)i.next();
            insert(prpCmainSubDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param mainPolicyNo ����������
     * @throws Exception
     */
    public void delete(String policyNo,String mainPolicyNo) throws Exception{
        String statement = " Delete From PrpCmainSub Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,mainPolicyNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCmainSubBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void update(PrpCmainSubDto prpCmainSubDto) throws Exception{
        String statement = " Update PrpCmainSub Set EndorseNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCmainSubDto.getEndorseNo());
        dbManager.setString(2,prpCmainSubDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpCmainSubDto.getPolicyNo());
        dbManager.setString(4,prpCmainSubDto.getMainPolicyNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCmainSubBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param mainPolicyNo ����������
     * @return PrpCmainSubDto
     * @throws Exception
     */
    public PrpCmainSubDto findByPrimaryKey(String policyNo,String mainPolicyNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag From PrpCmainSub Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        PrpCmainSubDto prpCmainSubDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,mainPolicyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCmainSubDto = new PrpCmainSubDto();
            prpCmainSubDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainSubDto.setMainPolicyNo(dbManager.getString(resultSet,2));
            prpCmainSubDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpCmainSubDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpCmainSubBase.findByPrimaryKey() success!");
        return prpCmainSubDto;
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
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag," +
                           " startDate," +
                           " endDate From PrpCmainSub Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCmainSubDto prpCmainSubDto = null;
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

            prpCmainSubDto = new PrpCmainSubDto();
            prpCmainSubDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainSubDto.setMainPolicyNo(dbManager.getString(resultSet,2));
            prpCmainSubDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpCmainSubDto.setFlag(dbManager.getString(resultSet,4));
            prpCmainSubDto.setStartDate(dbManager.getDateTime(resultSet,5));
            prpCmainSubDto.setEndDate(dbManager.getDateTime(resultSet,6));
            collection.add(prpCmainSubDto);
        }
        resultSet.close();
        log.info("DBPrpCmainSubBase.findByConditions() success!");
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
        String statement = "Delete From PrpCmainSub Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCmainSubBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCmainSub Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCmainSubBase.getCount() success!");
        return count;
    }
}
