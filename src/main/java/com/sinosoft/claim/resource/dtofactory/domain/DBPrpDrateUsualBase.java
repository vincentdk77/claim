package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateUsualDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateusual���ʴ��������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateUsualBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDrateUsualBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrateUsualBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void insert(PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        String statement = " Insert Into PrpDrateUsual(" + 
                           " RiskCode," + 
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrateUsualDto.getRiskCode());
        dbManager.setInt(2,prpDrateUsualDto.getRatePeriod());
        dbManager.setDateTime(3,prpDrateUsualDto.getValidDate());
        dbManager.setString(4,prpDrateUsualDto.getRateCode());
        dbManager.setDouble(5,prpDrateUsualDto.getBasePremium());
        dbManager.setDouble(6,prpDrateUsualDto.getRate());
        dbManager.setString(7,prpDrateUsualDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateUsualBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateUsualDto prpDrateUsualDto = (PrpDrateUsualDto)i.next();
            insert(prpDrateUsualDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param ratePeriod ��������
     * @param rateCode ���ʴ���
     * @throws Exception
     */
    public void delete(String riskCode,int ratePeriod,String rateCode) throws Exception{
        String statement = " Delete From PrpDrateUsual Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,rateCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateUsualBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDrateUsualDto prpDrateUsualDto
     * @throws Exception
     */
    public void update(PrpDrateUsualDto prpDrateUsualDto) throws Exception{
        String statement = " Update PrpDrateUsual Set ValidDate = ?," + 
                           " BasePremium = ?," + 
                           " Rate = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpDrateUsualDto.getValidDate());
        dbManager.setDouble(2,prpDrateUsualDto.getBasePremium());
        dbManager.setDouble(3,prpDrateUsualDto.getRate());
        dbManager.setString(4,prpDrateUsualDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpDrateUsualDto.getRiskCode());
        dbManager.setInt(6,prpDrateUsualDto.getRatePeriod());
        dbManager.setString(7,prpDrateUsualDto.getRateCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateUsualBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param ratePeriod ��������
     * @param rateCode ���ʴ���
     * @return PrpDrateUsualDto
     * @throws Exception
     */
    public PrpDrateUsualDto findByPrimaryKey(String riskCode,int ratePeriod,String rateCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag From PrpDrateUsual Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " RateCode = ?";
        PrpDrateUsualDto prpDrateUsualDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,rateCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateUsualDto = new PrpDrateUsualDto();
            prpDrateUsualDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateUsualDto.setRatePeriod(dbManager.getInt(resultSet,2));
            prpDrateUsualDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpDrateUsualDto.setRateCode(dbManager.getString(resultSet,4));
            prpDrateUsualDto.setBasePremium(dbManager.getDouble(resultSet,5));
            prpDrateUsualDto.setRate(dbManager.getDouble(resultSet,6));
            prpDrateUsualDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDrateUsualBase.findByPrimaryKey() success!");
        return prpDrateUsualDto;
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
                           " RatePeriod," + 
                           " ValidDate," + 
                           " RateCode," + 
                           " BasePremium," + 
                           " Rate," + 
                           " Flag From PrpDrateUsual Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateUsualDto prpDrateUsualDto = null;
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

            prpDrateUsualDto = new PrpDrateUsualDto();
            prpDrateUsualDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateUsualDto.setRatePeriod(dbManager.getInt(resultSet,2));
            prpDrateUsualDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpDrateUsualDto.setRateCode(dbManager.getString(resultSet,4));
            prpDrateUsualDto.setBasePremium(dbManager.getDouble(resultSet,5));
            prpDrateUsualDto.setRate(dbManager.getDouble(resultSet,6));
            prpDrateUsualDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDrateUsualDto);
        }
        resultSet.close();
        log.info("DBPrpDrateUsualBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrateUsual Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateUsualBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrateUsual Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateUsualBase.getCount() success!");
        return count;
    }
}
