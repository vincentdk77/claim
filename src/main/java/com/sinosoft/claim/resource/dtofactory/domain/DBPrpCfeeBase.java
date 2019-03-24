package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCfeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcfee��������ѱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCfeeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCfeeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCfeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void insert(PrpCfeeDto prpCfeeDto) throws Exception{
        String statement = " Insert Into PrpCfee(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCfeeDto.getPolicyNo());
        dbManager.setString(2,prpCfeeDto.getRiskCode());
        dbManager.setString(3,prpCfeeDto.getCurrency());
        dbManager.setDouble(4,prpCfeeDto.getAmount());
        dbManager.setDouble(5,prpCfeeDto.getPremium());
        dbManager.setString(6,prpCfeeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCfeeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCfeeDto prpCfeeDto = (PrpCfeeDto)i.next();
            insert(prpCfeeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(String policyNo,String currency) throws Exception{
        String statement = " Delete From PrpCfee Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,currency);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCfeeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCfeeDto prpCfeeDto
     * @throws Exception
     */
    public void update(PrpCfeeDto prpCfeeDto) throws Exception{
        String statement = " Update PrpCfee Set RiskCode = ?," + 
                           " Amount = ?," + 
                           " Premium = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCfeeDto.getRiskCode());
        dbManager.setDouble(2,prpCfeeDto.getAmount());
        dbManager.setDouble(3,prpCfeeDto.getPremium());
        dbManager.setString(4,prpCfeeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpCfeeDto.getPolicyNo());
        dbManager.setString(6,prpCfeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCfeeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param currency �ұ����
     * @return PrpCfeeDto
     * @throws Exception
     */
    public PrpCfeeDto findByPrimaryKey(String policyNo,String currency) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpCfee Where " +
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        PrpCfeeDto prpCfeeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCfeeDto = new PrpCfeeDto();
            prpCfeeDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCfeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpCfeeDto.setAmount(dbManager.getDouble(resultSet,4));
            prpCfeeDto.setPremium(dbManager.getDouble(resultSet,5));
            prpCfeeDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCfeeBase.findByPrimaryKey() success!");
        return prpCfeeDto;
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
                           " RiskCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Premium," + 
                           " Flag From PrpCfee Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCfeeDto prpCfeeDto = null;
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

            prpCfeeDto = new PrpCfeeDto();
            prpCfeeDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCfeeDto.setCurrency(dbManager.getString(resultSet,3));
            prpCfeeDto.setAmount(dbManager.getDouble(resultSet,4));
            prpCfeeDto.setPremium(dbManager.getDouble(resultSet,5));
            prpCfeeDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCfeeDto);
        }
        resultSet.close();
        log.info("DBPrpCfeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpCfee Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCfeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCfee Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCfeeBase.getCount() success!");
        return count;
    }
}
