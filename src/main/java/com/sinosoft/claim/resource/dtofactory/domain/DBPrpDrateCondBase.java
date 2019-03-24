package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrateCondDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdratecond��������������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrateCondBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDrateCondBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrateCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void insert(PrpDrateCondDto prpDrateCondDto) throws Exception{
        String statement = " Insert Into PrpDrateCond(" + 
                           " RiskCode," + 
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrateCondDto.getRiskCode());
        dbManager.setDateTime(2,prpDrateCondDto.getValidDate());
        dbManager.setInt(3,prpDrateCondDto.getRatePeriod());
        dbManager.setString(4,prpDrateCondDto.getCondCode());
        dbManager.setString(5,prpDrateCondDto.getCondName());
        dbManager.setDouble(6,prpDrateCondDto.getLowerValue());
        dbManager.setDouble(7,prpDrateCondDto.getUpperValue());
        dbManager.setString(8,prpDrateCondDto.getValueCode());
        dbManager.setString(9,prpDrateCondDto.getValueName());
        dbManager.setInt(10,prpDrateCondDto.getStartpos());
        dbManager.setInt(11,prpDrateCondDto.getEndpos());
        dbManager.setString(12,prpDrateCondDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateCondBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrateCondDto prpDrateCondDto = (PrpDrateCondDto)i.next();
            insert(prpDrateCondDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param ratePeriod ��������
     * @param condCode ��������
     * @param valueCode ȡֵ����
     * @throws Exception
     */
    public void delete(String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        String statement = " Delete From PrpDrateCond Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,condCode);
        dbManager.setString(4,valueCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrateCondBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDrateCondDto prpDrateCondDto
     * @throws Exception
     */
    public void update(PrpDrateCondDto prpDrateCondDto) throws Exception{
        String statement = " Update PrpDrateCond Set ValidDate = ?," + 
                           " CondName = ?," + 
                           " LowerValue = ?," + 
                           " UpperValue = ?," + 
                           " ValueName = ?," + 
                           " Startpos = ?," + 
                           " Endpos = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpDrateCondDto.getValidDate());
        dbManager.setString(2,prpDrateCondDto.getCondName());
        dbManager.setDouble(3,prpDrateCondDto.getLowerValue());
        dbManager.setDouble(4,prpDrateCondDto.getUpperValue());
        dbManager.setString(5,prpDrateCondDto.getValueName());
        dbManager.setInt(6,prpDrateCondDto.getStartpos());
        dbManager.setInt(7,prpDrateCondDto.getEndpos());
        dbManager.setString(8,prpDrateCondDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpDrateCondDto.getRiskCode());
        dbManager.setInt(10,prpDrateCondDto.getRatePeriod());
        dbManager.setString(11,prpDrateCondDto.getCondCode());
        dbManager.setString(12,prpDrateCondDto.getValueCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrateCondBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param ratePeriod ��������
     * @param condCode ��������
     * @param valueCode ȡֵ����
     * @return PrpDrateCondDto
     * @throws Exception
     */
    public PrpDrateCondDto findByPrimaryKey(String riskCode,int ratePeriod,String condCode,String valueCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag From PrpDrateCond Where " +
                           " RiskCode = ? And " + 
                           " RatePeriod = ? And " + 
                           " CondCode = ? And " + 
                           " ValueCode = ?";
        PrpDrateCondDto prpDrateCondDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setInt(2,ratePeriod);
        dbManager.setString(3,condCode);
        dbManager.setString(4,valueCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrateCondDto = new PrpDrateCondDto();
            prpDrateCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
            prpDrateCondDto.setRatePeriod(dbManager.getInt(resultSet,3));
            prpDrateCondDto.setCondCode(dbManager.getString(resultSet,4));
            prpDrateCondDto.setCondName(dbManager.getString(resultSet,5));
            prpDrateCondDto.setLowerValue(dbManager.getDouble(resultSet,6));
            prpDrateCondDto.setUpperValue(dbManager.getDouble(resultSet,7));
            prpDrateCondDto.setValueCode(dbManager.getString(resultSet,8));
            prpDrateCondDto.setValueName(dbManager.getString(resultSet,9));
            prpDrateCondDto.setStartpos(dbManager.getInt(resultSet,10));
            prpDrateCondDto.setEndpos(dbManager.getInt(resultSet,11));
            prpDrateCondDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        log.info("DBPrpDrateCondBase.findByPrimaryKey() success!");
        return prpDrateCondDto;
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
                           " ValidDate," + 
                           " RatePeriod," + 
                           " CondCode," + 
                           " CondName," + 
                           " LowerValue," + 
                           " UpperValue," + 
                           " ValueCode," + 
                           " ValueName," + 
                           " Startpos," + 
                           " Endpos," + 
                           " Flag From PrpDrateCond Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrateCondDto prpDrateCondDto = null;
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

            prpDrateCondDto = new PrpDrateCondDto();
            prpDrateCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrateCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,2));
            prpDrateCondDto.setRatePeriod(dbManager.getInt(resultSet,3));
            prpDrateCondDto.setCondCode(dbManager.getString(resultSet,4));
            prpDrateCondDto.setCondName(dbManager.getString(resultSet,5));
            prpDrateCondDto.setLowerValue(dbManager.getDouble(resultSet,6));
            prpDrateCondDto.setUpperValue(dbManager.getDouble(resultSet,7));
            prpDrateCondDto.setValueCode(dbManager.getString(resultSet,8));
            prpDrateCondDto.setValueName(dbManager.getString(resultSet,9));
            prpDrateCondDto.setStartpos(dbManager.getInt(resultSet,10));
            prpDrateCondDto.setEndpos(dbManager.getInt(resultSet,11));
            prpDrateCondDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpDrateCondDto);
        }
        resultSet.close();
        log.info("DBPrpDrateCondBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrateCond Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrateCondBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDrateCond Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrateCondBase.getCount() success!");
        return count;
    }
}
