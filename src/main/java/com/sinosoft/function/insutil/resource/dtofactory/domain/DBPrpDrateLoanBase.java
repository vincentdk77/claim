package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDrateLoanDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrateloan�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateLoanBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDrateLoanBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrateLoanBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDrateLoanDto prpDrateLoanDto
     * @throws Exception
     */
    public void insert(PrpDrateLoanDto prpDrateLoanDto) throws Exception{
        String statement = " Insert Into PrpDrateLoan(" + 
                           " Period," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " Years," + 
                           " Coefficient," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpDrateLoanDto.getPeriod());
        dbManager.setString(2,prpDrateLoanDto.getClassCode());
        dbManager.setString(3,prpDrateLoanDto.getRiskCode());
        dbManager.setString(4,prpDrateLoanDto.getKindCode());
        dbManager.setString(5,prpDrateLoanDto.getKindName());
        dbManager.setString(6,prpDrateLoanDto.getComCode());
        dbManager.setInt(7,prpDrateLoanDto.getYears());
        dbManager.setDouble(8,prpDrateLoanDto.getCoefficient());
        dbManager.setDateTime(9,prpDrateLoanDto.getValidDate());
        dbManager.setString(10,prpDrateLoanDto.getValidStatus());
        dbManager.setString(11,prpDrateLoanDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateLoanBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateLoanDto prpDrateLoanDto = (PrpDrateLoanDto)i.next();
            insert(prpDrateLoanDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param period period
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param comCode comcode
     * @param years years
     * @throws Exception
     */
    public void delete(int period,String riskCode,String kindCode,String comCode,int years) throws Exception{
        String statement = " Delete From PrpDrateLoan Where " +
                           " Period = ? And " + 
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " ComCode = ? And " + 
                           " Years = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,period);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,comCode);
        dbManager.setInt(5,years);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateLoanBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDrateLoanDto prpDrateLoanDto
     * @throws Exception
     */
    public void update(PrpDrateLoanDto prpDrateLoanDto) throws Exception{
        String statement = " Update PrpDrateLoan Set ClassCode = ?," + 
                           " KindName = ?," + 
                           " Coefficient = ?," + 
                           " ValidDate = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " Period = ? And " + 
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " ComCode = ? And " + 
                           " Years = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDrateLoanDto.getClassCode());
        dbManager.setString(2,prpDrateLoanDto.getKindName());
        dbManager.setDouble(3,prpDrateLoanDto.getCoefficient());
        dbManager.setDateTime(4,prpDrateLoanDto.getValidDate());
        dbManager.setString(5,prpDrateLoanDto.getValidStatus());
        dbManager.setString(6,prpDrateLoanDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(7,prpDrateLoanDto.getPeriod());
        dbManager.setString(8,prpDrateLoanDto.getRiskCode());
        dbManager.setString(9,prpDrateLoanDto.getKindCode());
        dbManager.setString(10,prpDrateLoanDto.getComCode());
        dbManager.setInt(11,prpDrateLoanDto.getYears());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateLoanBase.update() success!");
    }

    /**
     * ����������һ������
     * @param period period
     * @param riskCode riskcode
     * @param kindCode kindcode
     * @param comCode comcode
     * @param years years
     * @return PrpDrateLoanDto
     * @throws Exception
     */
    public PrpDrateLoanDto findByPrimaryKey(int period,String riskCode,String kindCode,String comCode,int years) throws Exception{
        String statement = " Select Period," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " Years," + 
                           " Coefficient," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDrateLoan Where " +
                           " Period = ? And " + 
                           " RiskCode = ? And " + 
                           " KindCode = ? And " + 
                           " ComCode = ? And " + 
                           " Years = ?";
        PrpDrateLoanDto prpDrateLoanDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,period);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,comCode);
        dbManager.setInt(5,years);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateLoanDto = new PrpDrateLoanDto();
            prpDrateLoanDto.setPeriod(dbManager.getInt(resultSet,1));
            prpDrateLoanDto.setClassCode(dbManager.getString(resultSet,2));
            prpDrateLoanDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDrateLoanDto.setKindCode(dbManager.getString(resultSet,4));
            prpDrateLoanDto.setKindName(dbManager.getString(resultSet,5));
            prpDrateLoanDto.setComCode(dbManager.getString(resultSet,6));
            prpDrateLoanDto.setYears(dbManager.getInt(resultSet,7));
            prpDrateLoanDto.setCoefficient(dbManager.getDouble(resultSet,8));
            prpDrateLoanDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpDrateLoanDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDrateLoanDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpDrateLoanBase.findByPrimaryKey() success!");
        return prpDrateLoanDto;
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
        String statement = "Select Period," + 
                           " ClassCode," + 
                           " RiskCode," + 
                           " KindCode," + 
                           " KindName," + 
                           " ComCode," + 
                           " Years," + 
                           " Coefficient," + 
                           " ValidDate," + 
                           " ValidStatus," + 
                           " Flag From PrpDrateLoan Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateLoanDto prpDrateLoanDto = null;
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

            prpDrateLoanDto = new PrpDrateLoanDto();
            prpDrateLoanDto.setPeriod(dbManager.getInt(resultSet,1));
            prpDrateLoanDto.setClassCode(dbManager.getString(resultSet,2));
            prpDrateLoanDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDrateLoanDto.setKindCode(dbManager.getString(resultSet,4));
            prpDrateLoanDto.setKindName(dbManager.getString(resultSet,5));
            prpDrateLoanDto.setComCode(dbManager.getString(resultSet,6));
            prpDrateLoanDto.setYears(dbManager.getInt(resultSet,7));
            prpDrateLoanDto.setCoefficient(dbManager.getDouble(resultSet,8));
            prpDrateLoanDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpDrateLoanDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDrateLoanDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpDrateLoanDto);
        }
        resultSet.close();
        log.info("DBPrpDrateLoanBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrateLoan Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateLoanBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDrateLoan Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateLoanBase.getCount() success!");
        return count;
    }
}
