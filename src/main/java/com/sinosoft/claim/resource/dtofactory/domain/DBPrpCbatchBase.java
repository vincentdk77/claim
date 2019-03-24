package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCbatchDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcbatch����������������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCbatchBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCbatchBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCbatchBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void insert(PrpCbatchDto prpCbatchDto) throws Exception{
        String statement = " Insert Into PrpCbatch(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " VisaCode," + 
                           " BillStartNo," + 
                           " BillEndNo," + 
                           " BillCount," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCbatchDto.getPolicyNo());
        dbManager.setString(2,prpCbatchDto.getRiskCode());
        dbManager.setInt(3,prpCbatchDto.getSerialNo());
        dbManager.setString(4,prpCbatchDto.getVisaCode());
        dbManager.setString(5,prpCbatchDto.getBillStartNo());
        dbManager.setString(6,prpCbatchDto.getBillEndNo());
        dbManager.setInt(7,prpCbatchDto.getBillCount());
        dbManager.setString(8,prpCbatchDto.getCurrency());
        dbManager.setDouble(9,prpCbatchDto.getSumAmount());
        dbManager.setDouble(10,prpCbatchDto.getSumPremium());
        dbManager.setString(11,prpCbatchDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCbatchBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCbatchDto prpCbatchDto = (PrpCbatchDto)i.next();
            insert(prpCbatchDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCbatch Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCbatchBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCbatchDto prpCbatchDto
     * @throws Exception
     */
    public void update(PrpCbatchDto prpCbatchDto) throws Exception{
        String statement = " Update PrpCbatch Set RiskCode = ?," + 
                           " VisaCode = ?," + 
                           " BillStartNo = ?," + 
                           " BillEndNo = ?," + 
                           " BillCount = ?," + 
                           " Currency = ?," + 
                           " SumAmount = ?," + 
                           " SumPremium = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCbatchDto.getRiskCode());
        dbManager.setString(2,prpCbatchDto.getVisaCode());
        dbManager.setString(3,prpCbatchDto.getBillStartNo());
        dbManager.setString(4,prpCbatchDto.getBillEndNo());
        dbManager.setInt(5,prpCbatchDto.getBillCount());
        dbManager.setString(6,prpCbatchDto.getCurrency());
        dbManager.setDouble(7,prpCbatchDto.getSumAmount());
        dbManager.setDouble(8,prpCbatchDto.getSumPremium());
        dbManager.setString(9,prpCbatchDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpCbatchDto.getPolicyNo());
        dbManager.setInt(11,prpCbatchDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCbatchBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @return PrpCbatchDto
     * @throws Exception
     */
    public PrpCbatchDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " VisaCode," + 
                           " BillStartNo," + 
                           " BillEndNo," + 
                           " BillCount," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag From PrpCbatch Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCbatchDto prpCbatchDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCbatchDto = new PrpCbatchDto();
            prpCbatchDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCbatchDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCbatchDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCbatchDto.setVisaCode(dbManager.getString(resultSet,4));
            prpCbatchDto.setBillStartNo(dbManager.getString(resultSet,5));
            prpCbatchDto.setBillEndNo(dbManager.getString(resultSet,6));
            prpCbatchDto.setBillCount(dbManager.getInt(resultSet,7));
            prpCbatchDto.setCurrency(dbManager.getString(resultSet,8));
            prpCbatchDto.setSumAmount(dbManager.getDouble(resultSet,9));
            prpCbatchDto.setSumPremium(dbManager.getDouble(resultSet,10));
            prpCbatchDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpCbatchBase.findByPrimaryKey() success!");
        return prpCbatchDto;
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
                           " SerialNo," + 
                           " VisaCode," + 
                           " BillStartNo," + 
                           " BillEndNo," + 
                           " BillCount," + 
                           " Currency," + 
                           " SumAmount," + 
                           " SumPremium," + 
                           " Flag From PrpCbatch Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCbatchDto prpCbatchDto = null;
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

            prpCbatchDto = new PrpCbatchDto();
            prpCbatchDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCbatchDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCbatchDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCbatchDto.setVisaCode(dbManager.getString(resultSet,4));
            prpCbatchDto.setBillStartNo(dbManager.getString(resultSet,5));
            prpCbatchDto.setBillEndNo(dbManager.getString(resultSet,6));
            prpCbatchDto.setBillCount(dbManager.getInt(resultSet,7));
            prpCbatchDto.setCurrency(dbManager.getString(resultSet,8));
            prpCbatchDto.setSumAmount(dbManager.getDouble(resultSet,9));
            prpCbatchDto.setSumPremium(dbManager.getDouble(resultSet,10));
            prpCbatchDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpCbatchDto);
        }
        resultSet.close();
        log.info("DBPrpCbatchBase.findByConditions() success!");
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
        String statement = "Delete From PrpCbatch Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCbatchBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCbatch Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCbatchBase.getCount() success!");
        return count;
    }
}
