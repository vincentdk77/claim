package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCitemKindAgri�����ݷ��ʶ������<br>
 * ������ 2007-01-30 20:27:05.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemKindAgriBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpCitemKindAgriBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemKindAgriBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void insert(PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCitemKindAgri (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemKindNo,");
        buffer.append("UnitOutput,");
        buffer.append("UnitCost,");
        buffer.append("PropoRtion,");
        buffer.append("DepreciAtionRate,");
        buffer.append("UnitAmount,");
        buffer.append("GrossQuantity,");
        buffer.append("DiscountType,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("KindCode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpCitemKindAgriDto.getItemKindNo()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getUnitOutput()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getUnitCost()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getPropoRtion()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getDepreciAtionRate()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getUnitAmount()).append(",");
            debugBuffer.append("").append(prpCitemKindAgriDto.getGrossQuantity()).append(",");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getDiscountType()).append("',");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpCitemKindAgriDto.getKindCode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCitemKindAgriDto.getPolicyNo());
        dbManager.setString(2,prpCitemKindAgriDto.getRiskCode());
        dbManager.setLong(3,prpCitemKindAgriDto.getItemKindNo());
        dbManager.setDouble(4,prpCitemKindAgriDto.getUnitOutput());
        dbManager.setDouble(5,prpCitemKindAgriDto.getUnitCost());
        dbManager.setDouble(6,prpCitemKindAgriDto.getPropoRtion());
        dbManager.setDouble(7,prpCitemKindAgriDto.getDepreciAtionRate());
        dbManager.setDouble(8,prpCitemKindAgriDto.getUnitAmount());
        dbManager.setDouble(9,prpCitemKindAgriDto.getGrossQuantity());
        dbManager.setString(10,prpCitemKindAgriDto.getDiscountType());
        dbManager.setString(11,prpCitemKindAgriDto.getFlag());
        dbManager.setString(12,prpCitemKindAgriDto.getRemark());
        dbManager.setString(13,prpCitemKindAgriDto.getKindCode());
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
        buffer.append("INSERT INTO PrpCitemKindAgri (");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemKindNo,");
        buffer.append("UnitOutput,");
        buffer.append("UnitCost,");
        buffer.append("PropoRtion,");
        buffer.append("DepreciAtionRate,");
        buffer.append("UnitAmount,");
        buffer.append("GrossQuantity,");
        buffer.append("DiscountType,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("KindCode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCitemKindAgriDto prpCitemKindAgriDto = (PrpCitemKindAgriDto)i.next();
            dbManager.setString(1,prpCitemKindAgriDto.getPolicyNo());
            dbManager.setString(2,prpCitemKindAgriDto.getRiskCode());
            dbManager.setLong(3,prpCitemKindAgriDto.getItemKindNo());
            dbManager.setDouble(4,prpCitemKindAgriDto.getUnitOutput());
            dbManager.setDouble(5,prpCitemKindAgriDto.getUnitCost());
            dbManager.setDouble(6,prpCitemKindAgriDto.getPropoRtion());
            dbManager.setDouble(7,prpCitemKindAgriDto.getDepreciAtionRate());
            dbManager.setDouble(8,prpCitemKindAgriDto.getUnitAmount());
            dbManager.setDouble(9,prpCitemKindAgriDto.getGrossQuantity());
            dbManager.setString(10,prpCitemKindAgriDto.getDiscountType());
            dbManager.setString(11,prpCitemKindAgriDto.getFlag());
            dbManager.setString(12,prpCitemKindAgriDto.getRemark());
            dbManager.setString(13,prpCitemKindAgriDto.getKindCode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @throws Exception
     */
    public void delete(String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCitemKindAgri ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemKindNo=").append("").append(itemKindNo).append(" AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemKindNo = ? And ");
        buffer.append("KindCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemKindNo);
        dbManager.setString(3,kindCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCitemKindAgriDto prpCitemKindAgriDto
     * @throws Exception
     */
    public void update(PrpCitemKindAgriDto prpCitemKindAgriDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCitemKindAgri SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("UnitOutput = ?, ");
        buffer.append("UnitCost = ?, ");
        buffer.append("PropoRtion = ?, ");
        buffer.append("DepreciAtionRate = ?, ");
        buffer.append("UnitAmount = ?, ");
        buffer.append("GrossQuantity = ?, ");
        buffer.append("DiscountType = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("Remark = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCitemKindAgri SET ");
            debugBuffer.append("RiskCode = '" + prpCitemKindAgriDto.getRiskCode() + "', ");
            debugBuffer.append("UnitOutput = " + prpCitemKindAgriDto.getUnitOutput() + ", ");
            debugBuffer.append("UnitCost = " + prpCitemKindAgriDto.getUnitCost() + ", ");
            debugBuffer.append("PropoRtion = " + prpCitemKindAgriDto.getPropoRtion() + ", ");
            debugBuffer.append("DepreciAtionRate = " + prpCitemKindAgriDto.getDepreciAtionRate() + ", ");
            debugBuffer.append("UnitAmount = " + prpCitemKindAgriDto.getUnitAmount() + ", ");
            debugBuffer.append("GrossQuantity = " + prpCitemKindAgriDto.getGrossQuantity() + ", ");
            debugBuffer.append("DiscountType = '" + prpCitemKindAgriDto.getDiscountType() + "', ");
            debugBuffer.append("Flag = '" + prpCitemKindAgriDto.getFlag() + "', ");
            debugBuffer.append("Remark = '" + prpCitemKindAgriDto.getRemark() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(prpCitemKindAgriDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("ItemKindNo=").append("").append(prpCitemKindAgriDto.getItemKindNo()).append(" AND ");
            debugBuffer.append("KindCode=").append("'").append(prpCitemKindAgriDto.getKindCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemKindNo = ? And ");
        buffer.append("KindCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpCitemKindAgriDto.getRiskCode());
        dbManager.setDouble(2,prpCitemKindAgriDto.getUnitOutput());
        dbManager.setDouble(3,prpCitemKindAgriDto.getUnitCost());
        dbManager.setDouble(4,prpCitemKindAgriDto.getPropoRtion());
        dbManager.setDouble(5,prpCitemKindAgriDto.getDepreciAtionRate());
        dbManager.setDouble(6,prpCitemKindAgriDto.getUnitAmount());
        dbManager.setDouble(7,prpCitemKindAgriDto.getGrossQuantity());
        dbManager.setString(8,prpCitemKindAgriDto.getDiscountType());
        dbManager.setString(9,prpCitemKindAgriDto.getFlag());
        dbManager.setString(10,prpCitemKindAgriDto.getRemark());
        //���������ֶ�;
        dbManager.setString(11,prpCitemKindAgriDto.getPolicyNo());
        dbManager.setLong(12,prpCitemKindAgriDto.getItemKindNo());
        dbManager.setString(13,prpCitemKindAgriDto.getKindCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param policyNo PolicyNo
     * @param itemKindNo ItemKindNo
     * @param kindCode KindCode
     * @return PrpCitemKindAgriDto
     * @throws Exception
     */
    public PrpCitemKindAgriDto findByPrimaryKey(String policyNo,long itemKindNo,String kindCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("PolicyNo,");
        buffer.append("RiskCode,");
        buffer.append("ItemKindNo,");
        buffer.append("UnitOutput,");
        buffer.append("UnitCost,");
        buffer.append("PropoRtion,");
        buffer.append("DepreciAtionRate,");
        buffer.append("UnitAmount,");
        buffer.append("GrossQuantity,");
        buffer.append("DiscountType,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("KindCode ");
        buffer.append("FROM PrpCitemKindAgri ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PolicyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("ItemKindNo=").append("").append(itemKindNo).append(" AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PolicyNo = ? And ");
        buffer.append("ItemKindNo = ? And ");
        buffer.append("KindCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,itemKindNo);
        dbManager.setString(3,kindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        if(resultSet.next()){
            prpCitemKindAgriDto = new PrpCitemKindAgriDto();
            prpCitemKindAgriDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemKindAgriDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemKindAgriDto.setItemKindNo(dbManager.getLong(resultSet,3));
            prpCitemKindAgriDto.setUnitOutput(dbManager.getDouble(resultSet,4));
            prpCitemKindAgriDto.setUnitCost(dbManager.getDouble(resultSet,5));
            prpCitemKindAgriDto.setPropoRtion(dbManager.getDouble(resultSet,6));
            prpCitemKindAgriDto.setDepreciAtionRate(dbManager.getDouble(resultSet,7));
            prpCitemKindAgriDto.setUnitAmount(dbManager.getDouble(resultSet,8));
            prpCitemKindAgriDto.setGrossQuantity(dbManager.getDouble(resultSet,9));
            prpCitemKindAgriDto.setDiscountType(dbManager.getString(resultSet,10));
            prpCitemKindAgriDto.setFlag(dbManager.getString(resultSet,11));
            prpCitemKindAgriDto.setRemark(dbManager.getString(resultSet,12));
            prpCitemKindAgriDto.setKindCode(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        return prpCitemKindAgriDto;
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
        buffer.append("ItemKindNo,");
        buffer.append("UnitOutput,");
        buffer.append("UnitCost,");
        buffer.append("PropoRtion,");
        buffer.append("DepreciAtionRate,");
        buffer.append("UnitAmount,");
        buffer.append("GrossQuantity,");
        buffer.append("DiscountType,");
        buffer.append("Flag,");
        buffer.append("Remark,");
        buffer.append("KindCode, ");
        buffer.append("TimesAmount, " );
        buffer.append("DistributingRate ");
        buffer.append("FROM PrpCitemKindAgri WHERE ");
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
        PrpCitemKindAgriDto prpCitemKindAgriDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCitemKindAgriDto = new PrpCitemKindAgriDto();
            prpCitemKindAgriDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemKindAgriDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemKindAgriDto.setItemKindNo(dbManager.getLong(resultSet,3));
            prpCitemKindAgriDto.setUnitOutput(dbManager.getDouble(resultSet,4));
            prpCitemKindAgriDto.setUnitCost(dbManager.getDouble(resultSet,5));
            prpCitemKindAgriDto.setPropoRtion(dbManager.getDouble(resultSet,6));
            prpCitemKindAgriDto.setDepreciAtionRate(dbManager.getDouble(resultSet,7));
            prpCitemKindAgriDto.setUnitAmount(dbManager.getDouble(resultSet,8));
            prpCitemKindAgriDto.setGrossQuantity(dbManager.getDouble(resultSet,9));
            prpCitemKindAgriDto.setDiscountType(dbManager.getString(resultSet,10));
            prpCitemKindAgriDto.setFlag(dbManager.getString(resultSet,11));
            prpCitemKindAgriDto.setRemark(dbManager.getString(resultSet,12));
            prpCitemKindAgriDto.setKindCode(dbManager.getString(resultSet,13));
            prpCitemKindAgriDto.setTimesAmount(dbManager.getDouble(resultSet, 14));
            prpCitemKindAgriDto.setDistributingRate(dbManager.getDouble(resultSet, 15));
            collection.add(prpCitemKindAgriDto);
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
        buffer.append("DELETE FROM PrpCitemKindAgri WHERE ");
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
        statement="SELECT count(1) FROM PrpCitemKindAgri WHERE ";
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
