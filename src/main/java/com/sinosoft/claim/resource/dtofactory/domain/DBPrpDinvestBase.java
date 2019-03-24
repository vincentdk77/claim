package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDinvestDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdinvestͶ��������Ͷ����Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDinvestBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDinvestBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDinvestBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void insert(PrpDinvestDto prpDinvestDto) throws Exception{
        String statement = " Insert Into PrpDinvest(" + 
                           " RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDinvestDto.getRiskCode());
        dbManager.setString(2,prpDinvestDto.getInvestType());
        dbManager.setString(3,prpDinvestDto.getInvestName());
        dbManager.setDouble(4,prpDinvestDto.getUnitAmount());
        dbManager.setDouble(5,prpDinvestDto.getUnitPremium());
        dbManager.setDouble(6,prpDinvestDto.getUnitInvestment());
        dbManager.setDouble(7,prpDinvestDto.getInterestRate());
        dbManager.setInt(8,prpDinvestDto.getInvestYear());
        dbManager.setString(9,prpDinvestDto.getValidStatus());
        dbManager.setString(10,prpDinvestDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDinvestBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDinvestDto prpDinvestDto = (PrpDinvestDto)i.next();
            insert(prpDinvestDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param investType Ͷ�����ʹ���
     * @throws Exception
     */
    public void delete(String riskCode,String investType) throws Exception{
        String statement = " Delete From PrpDinvest Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,investType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDinvestBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDinvestDto prpDinvestDto
     * @throws Exception
     */
    public void update(PrpDinvestDto prpDinvestDto) throws Exception{
        String statement = " Update PrpDinvest Set InvestName = ?," + 
                           " UnitAmount = ?," + 
                           " UnitPremium = ?," + 
                           " UnitInvestment = ?," + 
                           " InterestRate = ?," + 
                           " InvestYear = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDinvestDto.getInvestName());
        dbManager.setDouble(2,prpDinvestDto.getUnitAmount());
        dbManager.setDouble(3,prpDinvestDto.getUnitPremium());
        dbManager.setDouble(4,prpDinvestDto.getUnitInvestment());
        dbManager.setDouble(5,prpDinvestDto.getInterestRate());
        dbManager.setInt(6,prpDinvestDto.getInvestYear());
        dbManager.setString(7,prpDinvestDto.getValidStatus());
        dbManager.setString(8,prpDinvestDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpDinvestDto.getRiskCode());
        dbManager.setString(10,prpDinvestDto.getInvestType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDinvestBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param investType Ͷ�����ʹ���
     * @return PrpDinvestDto
     * @throws Exception
     */
    public PrpDinvestDto findByPrimaryKey(String riskCode,String investType) throws Exception{
        String statement = " Select RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag From PrpDinvest Where " +
                           " RiskCode = ? And " + 
                           " InvestType = ?";
        PrpDinvestDto prpDinvestDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,investType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDinvestDto = new PrpDinvestDto();
            prpDinvestDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDinvestDto.setInvestType(dbManager.getString(resultSet,2));
            prpDinvestDto.setInvestName(dbManager.getString(resultSet,3));
            prpDinvestDto.setUnitAmount(dbManager.getDouble(resultSet,4));
            prpDinvestDto.setUnitPremium(dbManager.getDouble(resultSet,5));
            prpDinvestDto.setUnitInvestment(dbManager.getDouble(resultSet,6));
            prpDinvestDto.setInterestRate(dbManager.getDouble(resultSet,7));
            prpDinvestDto.setInvestYear(dbManager.getInt(resultSet,8));
            prpDinvestDto.setValidStatus(dbManager.getString(resultSet,9));
            prpDinvestDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDinvestBase.findByPrimaryKey() success!");
        return prpDinvestDto;
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
        String statement = "Select RiskCode," + 
                           " InvestType," + 
                           " InvestName," + 
                           " UnitAmount," + 
                           " UnitPremium," + 
                           " UnitInvestment," + 
                           " InterestRate," + 
                           " InvestYear," + 
                           " ValidStatus," + 
                           " Flag From PrpDinvest Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDinvestDto prpDinvestDto = null;
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

            prpDinvestDto = new PrpDinvestDto();
            prpDinvestDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDinvestDto.setInvestType(dbManager.getString(resultSet,2));
            prpDinvestDto.setInvestName(dbManager.getString(resultSet,3));
            prpDinvestDto.setUnitAmount(dbManager.getDouble(resultSet,4));
            prpDinvestDto.setUnitPremium(dbManager.getDouble(resultSet,5));
            prpDinvestDto.setUnitInvestment(dbManager.getDouble(resultSet,6));
            prpDinvestDto.setInterestRate(dbManager.getDouble(resultSet,7));
            prpDinvestDto.setInvestYear(dbManager.getInt(resultSet,8));
            prpDinvestDto.setValidStatus(dbManager.getString(resultSet,9));
            prpDinvestDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDinvestDto);
        }
        resultSet.close();
        log.info("DBPrpDinvestBase.findByConditions() success!");
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
        String statement = "Delete From PrpDinvest Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDinvestBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDinvest Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDinvestBase.getCount() success!");
        return count;
    }
}
