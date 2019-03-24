package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDdeductcondDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddeductcond�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdeductcondBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDdeductcondBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDdeductcondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDdeductcondDto prpDdeductcondDto
     * @throws Exception
     */
    public void insert(PrpDdeductcondDto prpDdeductcondDto) throws Exception{
        String statement = " Insert Into PrpDdeductcond(" + 
                           " RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " DeductCondCode," + 
                           " DeductCondName," + 
                           " DeductRate," + 
                           " Deductible," + 
                           " ValidDate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDdeductcondDto.getRiskCode());
        dbManager.setString(2,prpDdeductcondDto.getClauseType());
        dbManager.setString(3,prpDdeductcondDto.getKindCode());
        dbManager.setString(4,prpDdeductcondDto.getDeductCondCode());
        dbManager.setString(5,prpDdeductcondDto.getDeductCondName());
        dbManager.setDouble(6,prpDdeductcondDto.getDeductRate());
        dbManager.setDouble(7,prpDdeductcondDto.getDeductible());
        dbManager.setDateTime(8,prpDdeductcondDto.getValidDate());
        dbManager.setString(9,prpDdeductcondDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdeductcondBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDdeductcondDto prpDdeductcondDto = (PrpDdeductcondDto)i.next();
            insert(prpDdeductcondDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param deductCondCode deductcondcode
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String deductCondCode) throws Exception{
        String statement = " Delete From PrpDdeductcond Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " DeductCondCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,deductCondCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDdeductcondBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDdeductcondDto prpDdeductcondDto
     * @throws Exception
     */
    public void update(PrpDdeductcondDto prpDdeductcondDto) throws Exception{
        String statement = " Update PrpDdeductcond Set DeductCondName = ?," + 
                           " DeductRate = ?," + 
                           " Deductible = ?," + 
                           " ValidDate = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " DeductCondCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDdeductcondDto.getDeductCondName());
        dbManager.setDouble(2,prpDdeductcondDto.getDeductRate());
        dbManager.setDouble(3,prpDdeductcondDto.getDeductible());
        dbManager.setDateTime(4,prpDdeductcondDto.getValidDate());
        dbManager.setString(5,prpDdeductcondDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpDdeductcondDto.getRiskCode());
        dbManager.setString(7,prpDdeductcondDto.getClauseType());
        dbManager.setString(8,prpDdeductcondDto.getKindCode());
        dbManager.setString(9,prpDdeductcondDto.getDeductCondCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdeductcondBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param clauseType clausetype
     * @param kindCode kindcode
     * @param deductCondCode deductcondcode
     * @return PrpDdeductcondDto
     * @throws Exception
     */
    public PrpDdeductcondDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String deductCondCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " DeductCondCode," + 
                           " DeductCondName," + 
                           " DeductRate," + 
                           " Deductible," + 
                           " ValidDate," + 
                           " Flag From PrpDdeductcond Where " +
                           " RiskCode = ? And " + 
                           " ClauseType = ? And " + 
                           " KindCode = ? And " + 
                           " DeductCondCode = ?";
        PrpDdeductcondDto prpDdeductcondDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,deductCondCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDdeductcondDto = new PrpDdeductcondDto();
            prpDdeductcondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeductcondDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeductcondDto.setKindCode(dbManager.getString(resultSet,3));
            prpDdeductcondDto.setDeductCondCode(dbManager.getString(resultSet,4));
            prpDdeductcondDto.setDeductCondName(dbManager.getString(resultSet,5));
            prpDdeductcondDto.setDeductRate(dbManager.getDouble(resultSet,6));
            prpDdeductcondDto.setDeductible(dbManager.getDouble(resultSet,7));
            prpDdeductcondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDdeductcondDto.setFlag(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        log.info("DBPrpDdeductcondBase.findByPrimaryKey() success!");
        return prpDdeductcondDto;
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
                           " ClauseType," + 
                           " KindCode," + 
                           " DeductCondCode," + 
                           " DeductCondName," + 
                           " DeductRate," + 
                           " Deductible," + 
                           " ValidDate," + 
                           " Flag From PrpDdeductcond Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDdeductcondDto prpDdeductcondDto = null;
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

            prpDdeductcondDto = new PrpDdeductcondDto();
            prpDdeductcondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeductcondDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeductcondDto.setKindCode(dbManager.getString(resultSet,3));
            prpDdeductcondDto.setDeductCondCode(dbManager.getString(resultSet,4));
            prpDdeductcondDto.setDeductCondName(dbManager.getString(resultSet,5));
            prpDdeductcondDto.setDeductRate(dbManager.getDouble(resultSet,6));
            prpDdeductcondDto.setDeductible(dbManager.getDouble(resultSet,7));
            prpDdeductcondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDdeductcondDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpDdeductcondDto);
        }
        resultSet.close();
        log.info("DBPrpDdeductcondBase.findByConditions() success!");
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
        String statement = "Delete From PrpDdeductcond Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDdeductcondBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDdeductcond Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDdeductcondBase.getCount() success!");
        return count;
    }
}
