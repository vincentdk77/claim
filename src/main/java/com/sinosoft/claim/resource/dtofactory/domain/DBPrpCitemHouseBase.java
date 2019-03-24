package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemHouseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpCitemHouse�����ݷ��ʶ������<br>
 * ������ 2006-04-30 14:20:10.171<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemHouseBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCitemHouseBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemHouseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCitemHouseDto prpCitemHouseDto
     * @throws Exception
     */
    public void insert(PrpCitemHouseDto prpCitemHouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCitemHouse (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCitemHouseDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getItemNo()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getStructure()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getBuildArea()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getFlag()).append("',");
            debugBuffer.append("").append(prpCitemHouseDto.getUnitValue()).append(",");
            debugBuffer.append("").append(prpCitemHouseDto.getSumValue()).append(",");
            debugBuffer.append("'").append(prpCitemHouseDto.getBuildTime()).append("',");
            debugBuffer.append("'").append(prpCitemHouseDto.getUseAge()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCitemHouseDto.getPolicyNo());
        dbManager.setString(2,prpCitemHouseDto.getRiskCode());
        dbManager.setLong(3,prpCitemHouseDto.getItemNo());
        dbManager.setString(4,prpCitemHouseDto.getStructure());
        dbManager.setDouble(5,prpCitemHouseDto.getBuildArea());
        dbManager.setString(6,prpCitemHouseDto.getRemark());
        dbManager.setString(7,prpCitemHouseDto.getFlag());
        dbManager.setDouble(8,prpCitemHouseDto.getUnitValue());
        dbManager.setDouble(9,prpCitemHouseDto.getSumValue());
        dbManager.setDateTime(10,prpCitemHouseDto.getBuildTime());
        dbManager.setString(11,prpCitemHouseDto.getUseAge());
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
        buffer.append("INSERT INTO PrpCitemHouse (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCitemHouseDto prpCitemHouseDto = (PrpCitemHouseDto)i.next();
            dbManager.setString(1,prpCitemHouseDto.getPolicyNo());
            dbManager.setString(2,prpCitemHouseDto.getRiskCode());
            dbManager.setLong(3,prpCitemHouseDto.getItemNo());
            dbManager.setString(4,prpCitemHouseDto.getStructure());
            dbManager.setDouble(5,prpCitemHouseDto.getBuildArea());
            dbManager.setString(6,prpCitemHouseDto.getRemark());
            dbManager.setString(7,prpCitemHouseDto.getFlag());
            dbManager.setDouble(8,prpCitemHouseDto.getUnitValue());
            dbManager.setDouble(9,prpCitemHouseDto.getSumValue());
            dbManager.setDateTime(10,prpCitemHouseDto.getBuildTime());
            dbManager.setString(11,prpCitemHouseDto.getUseAge());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param policyNo PolicyNo
     * @param itemNo ItemNo
     * @throws Exception
     */
    public void delete(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCitemHouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCitemHouseDto prpCitemHouseDto
     * @throws Exception
     */
    public void update(PrpCitemHouseDto prpCitemHouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCitemHouse SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("Structure = ?, ");
        buffer.append("BuildArea = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("UnitValue = ?, ");
        buffer.append("SumValue = ?, ");
        buffer.append("BuildTime = ?, ");
        buffer.append("UseAge = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCitemHouse SET ");
            debugBuffer.append("RiskCode = '" + prpCitemHouseDto.getRiskCode() + "', ");
            debugBuffer.append("Structure = '" + prpCitemHouseDto.getStructure() + "', ");
            debugBuffer.append("BuildArea = " + prpCitemHouseDto.getBuildArea() + ", ");
            debugBuffer.append("Remark = '" + prpCitemHouseDto.getRemark() + "', ");
            debugBuffer.append("flag = '" + prpCitemHouseDto.getFlag() + "', ");
            debugBuffer.append("UnitValue = " + prpCitemHouseDto.getUnitValue() + ", ");
            debugBuffer.append("SumValue = " + prpCitemHouseDto.getSumValue() + ", ");
            debugBuffer.append("BuildTime = '" + prpCitemHouseDto.getBuildTime() + "', ");
            debugBuffer.append("UseAge = '" + prpCitemHouseDto.getUseAge() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCitemHouseDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(prpCitemHouseDto.getItemNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpCitemHouseDto.getRiskCode());
        dbManager.setString(2,prpCitemHouseDto.getStructure());
        dbManager.setDouble(3,prpCitemHouseDto.getBuildArea());
        dbManager.setString(4,prpCitemHouseDto.getRemark());
        dbManager.setString(5,prpCitemHouseDto.getFlag());
        dbManager.setDouble(6,prpCitemHouseDto.getUnitValue());
        dbManager.setDouble(7,prpCitemHouseDto.getSumValue());
        dbManager.setDateTime(8,prpCitemHouseDto.getBuildTime());
        dbManager.setString(9,prpCitemHouseDto.getUseAge());
        //���������ֶ�;
        dbManager.setString(10,prpCitemHouseDto.getPolicyNo());
        dbManager.setLong(11,prpCitemHouseDto.getItemNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param policyNo PolicyNo
     * @param itemNo ItemNo
     * @return PrpCitemHouseDto
     * @throws Exception
     */
    public PrpCitemHouseDto findByPrimaryKey(String policyNo,long itemNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append("FROM PrpCitemHouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemNo=").append("").append(itemNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCitemHouseDto prpCitemHouseDto = null;
        if(resultSet.next()){
            prpCitemHouseDto = new PrpCitemHouseDto();
            prpCitemHouseDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemHouseDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemHouseDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemHouseDto.setStructure(dbManager.getString(resultSet,4));
            prpCitemHouseDto.setBuildArea(dbManager.getDouble(resultSet,5));
            prpCitemHouseDto.setRemark(dbManager.getString(resultSet,6));
            prpCitemHouseDto.setFlag(dbManager.getString(resultSet,7));
            prpCitemHouseDto.setUnitValue(dbManager.getDouble(resultSet,8));
            prpCitemHouseDto.setSumValue(dbManager.getDouble(resultSet,9));
            prpCitemHouseDto.setBuildTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpCitemHouseDto.setUseAge(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpCitemHouseDto;
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
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemNo,");
        buffer.append("Structure,");
        buffer.append("BuildArea,");
        buffer.append("Remark,");
        buffer.append("flag,");
        buffer.append("UnitValue,");
        buffer.append("SumValue,");
        buffer.append("BuildTime,");
        buffer.append("UseAge ");
        buffer.append("FROM PrpCitemHouse WHERE ");
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
        PrpCitemHouseDto prpCitemHouseDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCitemHouseDto = new PrpCitemHouseDto();
            prpCitemHouseDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemHouseDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemHouseDto.setItemNo(dbManager.getLong(resultSet,3));
            prpCitemHouseDto.setStructure(dbManager.getString(resultSet,4));
            prpCitemHouseDto.setBuildArea(dbManager.getDouble(resultSet,5));
            prpCitemHouseDto.setRemark(dbManager.getString(resultSet,6));
            prpCitemHouseDto.setFlag(dbManager.getString(resultSet,7));
            prpCitemHouseDto.setUnitValue(dbManager.getDouble(resultSet,8));
            prpCitemHouseDto.setSumValue(dbManager.getDouble(resultSet,9));
            prpCitemHouseDto.setBuildTime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpCitemHouseDto.setUseAge(dbManager.getString(resultSet,11));
            collection.add(prpCitemHouseDto);
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
        buffer.append("DELETE FROM PrpCitemHouse WHERE ");
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
        String statement;
        statement="SELECT count(1) FROM PrpCitemHouse WHERE ";
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
