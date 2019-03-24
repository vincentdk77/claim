package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdeductCondDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDdeductCond-��������������ݷ��ʶ������<br>
 * ������ 2006-06-05 19:50:38.312<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDdeductCondBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpDdeductCondBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDdeductCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void insert(PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDdeductCond (");
        buffer.append("riskCode,");
        buffer.append("clauseType,");
        buffer.append("kindCode,");
        buffer.append("deductCondCode,");
        buffer.append("deductCondName,");
        buffer.append("deductRate,");
        buffer.append("deductible,");
        buffer.append("validDate,");
        buffer.append("flag,");
        buffer.append("DEDUCTPERIOD,");
        buffer.append("BaseTimes,");
        buffer.append("MaxDeductRate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpDdeductCondDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getClauseType()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getDeductCondCode()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getDeductCondName()).append("',");
            debugBuffer.append("").append(prpDdeductCondDto.getDeductRate()).append(",");
            debugBuffer.append("").append(prpDdeductCondDto.getDeductible()).append(",");
            debugBuffer.append("'").append(prpDdeductCondDto.getValidDate()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpDdeductCondDto.getDEDUCTPERIOD()).append("',");
            debugBuffer.append("").append(prpDdeductCondDto.getBaseTimes()).append(",");
            debugBuffer.append("").append(prpDdeductCondDto.getMaxDeductRate()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpDdeductCondDto.getRiskCode());
        dbManager.setString(2,prpDdeductCondDto.getClauseType());
        dbManager.setString(3,prpDdeductCondDto.getKindCode());
        dbManager.setString(4,prpDdeductCondDto.getDeductCondCode());
        dbManager.setString(5,prpDdeductCondDto.getDeductCondName());
        dbManager.setDouble(6,prpDdeductCondDto.getDeductRate());
        dbManager.setDouble(7,prpDdeductCondDto.getDeductible());
        dbManager.setDateTime(8,prpDdeductCondDto.getValidDate());
        dbManager.setString(9,prpDdeductCondDto.getFlag());
        dbManager.setString(10,prpDdeductCondDto.getDEDUCTPERIOD());
        dbManager.setInt(11,prpDdeductCondDto.getBaseTimes());
        dbManager.setDouble(12,prpDdeductCondDto.getMaxDeductRate());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpDdeductCond (");
        buffer.append("riskCode,");
        buffer.append("clauseType,");
        buffer.append("kindCode,");
        buffer.append("deductCondCode,");
        buffer.append("deductCondName,");
        buffer.append("deductRate,");
        buffer.append("deductible,");
        buffer.append("validDate,");
        buffer.append("flag,");
        buffer.append("DEDUCTPERIOD,");
        buffer.append("BaseTimes,");
        buffer.append("MaxDeductRate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpDdeductCondDto prpDdeductCondDto = (PrpDdeductCondDto)i.next();
            dbManager.setString(1,prpDdeductCondDto.getRiskCode());
            dbManager.setString(2,prpDdeductCondDto.getClauseType());
            dbManager.setString(3,prpDdeductCondDto.getKindCode());
            dbManager.setString(4,prpDdeductCondDto.getDeductCondCode());
            dbManager.setString(5,prpDdeductCondDto.getDeductCondName());
            dbManager.setDouble(6,prpDdeductCondDto.getDeductRate());
            dbManager.setDouble(7,prpDdeductCondDto.getDeductible());
            dbManager.setDateTime(8,prpDdeductCondDto.getValidDate());
            dbManager.setString(9,prpDdeductCondDto.getFlag());
            dbManager.setString(10,prpDdeductCondDto.getDEDUCTPERIOD());
            dbManager.setInt(11,prpDdeductCondDto.getBaseTimes());
            dbManager.setDouble(12,prpDdeductCondDto.getMaxDeductRate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @throws Exception
     */
    public void delete(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("clauseType=").append("'").append(clauseType).append("' AND ");
            debugBuffer.append("kindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("deductCondCode=").append("'").append(deductCondCode).append("' AND ");
            debugBuffer.append("DEDUCTPERIOD=").append("'").append(dEDUCTPERIOD).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("clauseType = ? And ");
        buffer.append("kindCode = ? And ");
        buffer.append("deductCondCode = ? And ");
        buffer.append("DEDUCTPERIOD = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,deductCondCode);
        dbManager.setString(5,dEDUCTPERIOD);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDdeductCondDto prpDdeductCondDto
     * @throws Exception
     */
    public void update(PrpDdeductCondDto prpDdeductCondDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpDdeductCond SET ");
        buffer.append("deductCondName = ?, ");
        buffer.append("deductRate = ?, ");
        buffer.append("deductible = ?, ");
        buffer.append("validDate = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("BaseTimes = ?, ");
        buffer.append("MaxDeductRate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpDdeductCond SET ");
            debugBuffer.append("deductCondName = '" + prpDdeductCondDto.getDeductCondName() + "', ");
            debugBuffer.append("deductRate = " + prpDdeductCondDto.getDeductRate() + ", ");
            debugBuffer.append("deductible = " + prpDdeductCondDto.getDeductible() + ", ");
            debugBuffer.append("validDate = '" + prpDdeductCondDto.getValidDate() + "', ");
            debugBuffer.append("flag = '" + prpDdeductCondDto.getFlag() + "', ");
            debugBuffer.append("BaseTimes = " + prpDdeductCondDto.getBaseTimes() + ", ");
            debugBuffer.append("MaxDeductRate = " + prpDdeductCondDto.getMaxDeductRate() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(prpDdeductCondDto.getRiskCode()).append("' AND ");
            debugBuffer.append("clauseType=").append("'").append(prpDdeductCondDto.getClauseType()).append("' AND ");
            debugBuffer.append("kindCode=").append("'").append(prpDdeductCondDto.getKindCode()).append("' AND ");
            debugBuffer.append("deductCondCode=").append("'").append(prpDdeductCondDto.getDeductCondCode()).append("' AND ");
            debugBuffer.append("DEDUCTPERIOD=").append("'").append(prpDdeductCondDto.getDEDUCTPERIOD()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("clauseType = ? And ");
        buffer.append("kindCode = ? And ");
        buffer.append("deductCondCode = ? And ");
        buffer.append("DEDUCTPERIOD = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpDdeductCondDto.getDeductCondName());
        dbManager.setDouble(2,prpDdeductCondDto.getDeductRate());
        dbManager.setDouble(3,prpDdeductCondDto.getDeductible());
        dbManager.setDateTime(4,prpDdeductCondDto.getValidDate());
        dbManager.setString(5,prpDdeductCondDto.getFlag());
        dbManager.setInt(6,prpDdeductCondDto.getBaseTimes());
        dbManager.setDouble(7,prpDdeductCondDto.getMaxDeductRate());
        //���������ֶ�;
        dbManager.setString(8,prpDdeductCondDto.getRiskCode());
        dbManager.setString(9,prpDdeductCondDto.getClauseType());
        dbManager.setString(10,prpDdeductCondDto.getKindCode());
        dbManager.setString(11,prpDdeductCondDto.getDeductCondCode());
        dbManager.setString(12,prpDdeductCondDto.getDEDUCTPERIOD());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param riskCode ����
     * @param clauseType �������
     * @param kindCode �ձ����
     * @param deductCondCode ������������
     * @param dEDUCTPERIOD ����
     * @return PrpDdeductCondDto
     * @throws Exception
     */
    public PrpDdeductCondDto findByPrimaryKey(String riskCode,String clauseType,String kindCode,String deductCondCode,String dEDUCTPERIOD)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("riskCode,");
        buffer.append("clauseType,");
        buffer.append("kindCode,");
        buffer.append("deductCondCode,");
        buffer.append("deductCondName,");
        buffer.append("deductRate,");
        buffer.append("deductible,");
        buffer.append("validDate,");
        buffer.append("flag,");
        buffer.append("DEDUCTPERIOD,");
        buffer.append("BaseTimes,");
        buffer.append("MaxDeductRate ");
        buffer.append("FROM PrpDdeductCond ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("riskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("clauseType=").append("'").append(clauseType).append("' AND ");
            debugBuffer.append("kindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("deductCondCode=").append("'").append(deductCondCode).append("' AND ");
            debugBuffer.append("DEDUCTPERIOD=").append("'").append(dEDUCTPERIOD).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("riskCode = ? And ");
        buffer.append("clauseType = ? And ");
        buffer.append("kindCode = ? And ");
        buffer.append("deductCondCode = ? And ");
        buffer.append("DEDUCTPERIOD = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,clauseType);
        dbManager.setString(3,kindCode);
        dbManager.setString(4,deductCondCode);
        dbManager.setString(5,dEDUCTPERIOD);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpDdeductCondDto prpDdeductCondDto = null;
        if(resultSet.next()){
            prpDdeductCondDto = new PrpDdeductCondDto();
            prpDdeductCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeductCondDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeductCondDto.setKindCode(dbManager.getString(resultSet,3));
            prpDdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,4));
            prpDdeductCondDto.setDeductCondName(dbManager.getString(resultSet,5));
            prpDdeductCondDto.setDeductRate(dbManager.getDouble(resultSet,6));
            prpDdeductCondDto.setDeductible(dbManager.getDouble(resultSet,7));
            prpDdeductCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDdeductCondDto.setFlag(dbManager.getString(resultSet,9));
            prpDdeductCondDto.setDEDUCTPERIOD(dbManager.getString(resultSet,10));
            prpDdeductCondDto.setBaseTimes(dbManager.getInt(resultSet,11));
            prpDdeductCondDto.setMaxDeductRate(dbManager.getDouble(resultSet,12));
        }
        resultSet.close();
        return prpDdeductCondDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("riskCode,");
        buffer.append("clauseType,");
        buffer.append("kindCode,");
        buffer.append("deductCondCode,");
        buffer.append("deductCondName,");
        buffer.append("deductRate,");
        buffer.append("deductible,");
        buffer.append("validDate,");
        buffer.append("flag,");
        buffer.append("DEDUCTPERIOD,");
        buffer.append("BaseTimes,");
        buffer.append("MaxDeductRate ");
        buffer.append("FROM PrpDdeductCond WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpDdeductCondDto prpDdeductCondDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpDdeductCondDto = new PrpDdeductCondDto();
            prpDdeductCondDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDdeductCondDto.setClauseType(dbManager.getString(resultSet,2));
            prpDdeductCondDto.setKindCode(dbManager.getString(resultSet,3));
            prpDdeductCondDto.setDeductCondCode(dbManager.getString(resultSet,4));
            prpDdeductCondDto.setDeductCondName(dbManager.getString(resultSet,5));
            prpDdeductCondDto.setDeductRate(dbManager.getDouble(resultSet,6));
            prpDdeductCondDto.setDeductible(dbManager.getDouble(resultSet,7));
            prpDdeductCondDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDdeductCondDto.setFlag(dbManager.getString(resultSet,9));
            prpDdeductCondDto.setDEDUCTPERIOD(dbManager.getString(resultSet,10));
            prpDdeductCondDto.setBaseTimes(dbManager.getInt(resultSet,11));
            prpDdeductCondDto.setMaxDeductRate(dbManager.getDouble(resultSet,12));
            collection.add(prpDdeductCondDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpDdeductCond WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
      String  statement ;
        statement = "SELECT count(1) FROM PrpDdeductCond WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
