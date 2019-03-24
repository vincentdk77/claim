package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoinsDetail�����ݷ��ʶ������<br>
 * ������ 2013-09-06 11:11:52.296<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCcoinsDetailBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpCcoinsDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcoinsDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void insert(PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpCcoinsDetail (");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("flag,");
        buffer.append("middleCostFee ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpCcoinsDetailDto.getPolicyNo()).append("',");
            debugBuffer.append("").append(prpCcoinsDetailDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpCcoinsDetailDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpCcoinsDetailDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpCcoinsDetailDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpCcoinsDetailDto.getCoinsAmount()).append(",");
            debugBuffer.append("").append(prpCcoinsDetailDto.getCoinsPremium()).append(",");
            debugBuffer.append("").append(prpCcoinsDetailDto.getAgentFee()).append(",");
            debugBuffer.append("").append(prpCcoinsDetailDto.getOperateFee()).append(",");
            debugBuffer.append("'").append(prpCcoinsDetailDto.getFlag()).append("',");
            debugBuffer.append("").append(prpCcoinsDetailDto.getMiddleCostFee()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpCcoinsDetailDto.getPolicyNo());
        dbManager.setLong(2,prpCcoinsDetailDto.getSerialNo());
        dbManager.setString(3,prpCcoinsDetailDto.getCoinsCode());
        dbManager.setString(4,prpCcoinsDetailDto.getCoinsName());
        dbManager.setString(5,prpCcoinsDetailDto.getCurrency());
        dbManager.setDouble(6,prpCcoinsDetailDto.getCoinsAmount());
        dbManager.setDouble(7,prpCcoinsDetailDto.getCoinsPremium());
        dbManager.setDouble(8,prpCcoinsDetailDto.getAgentFee());
        dbManager.setDouble(9,prpCcoinsDetailDto.getOperateFee());
        dbManager.setString(10,prpCcoinsDetailDto.getFlag());
        dbManager.setDouble(11,prpCcoinsDetailDto.getMiddleCostFee());
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
        buffer.append("INSERT INTO PrpCcoinsDetail (");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("flag,");
        buffer.append("middleCostFee ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpCcoinsDetailDto prpCcoinsDetailDto = (PrpCcoinsDetailDto)i.next();
            dbManager.setString(1,prpCcoinsDetailDto.getPolicyNo());
            dbManager.setLong(2,prpCcoinsDetailDto.getSerialNo());
            dbManager.setString(3,prpCcoinsDetailDto.getCoinsCode());
            dbManager.setString(4,prpCcoinsDetailDto.getCoinsName());
            dbManager.setString(5,prpCcoinsDetailDto.getCurrency());
            dbManager.setDouble(6,prpCcoinsDetailDto.getCoinsAmount());
            dbManager.setDouble(7,prpCcoinsDetailDto.getCoinsPremium());
            dbManager.setDouble(8,prpCcoinsDetailDto.getAgentFee());
            dbManager.setDouble(9,prpCcoinsDetailDto.getOperateFee());
            dbManager.setString(10,prpCcoinsDetailDto.getFlag());
            dbManager.setDouble(11,prpCcoinsDetailDto.getMiddleCostFee());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(String policyNo,long serialNo,String currency)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpCcoinsDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("policyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("currency=").append("'").append(currency).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("policyNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,serialNo);
        dbManager.setString(3,currency);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void update(PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpCcoinsDetail SET ");
        buffer.append("coinsCode = ?, ");
        buffer.append("coinsName = ?, ");
        buffer.append("coinsAmount = ?, ");
        buffer.append("coinsPremium = ?, ");
        buffer.append("agentFee = ?, ");
        buffer.append("operateFee = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("middleCostFee = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpCcoinsDetail SET ");
            debugBuffer.append("coinsCode = '" + prpCcoinsDetailDto.getCoinsCode() + "', ");
            debugBuffer.append("coinsName = '" + prpCcoinsDetailDto.getCoinsName() + "', ");
            debugBuffer.append("coinsAmount = " + prpCcoinsDetailDto.getCoinsAmount() + ", ");
            debugBuffer.append("coinsPremium = " + prpCcoinsDetailDto.getCoinsPremium() + ", ");
            debugBuffer.append("agentFee = " + prpCcoinsDetailDto.getAgentFee() + ", ");
            debugBuffer.append("operateFee = " + prpCcoinsDetailDto.getOperateFee() + ", ");
            debugBuffer.append("flag = '" + prpCcoinsDetailDto.getFlag() + "', ");
            debugBuffer.append("middleCostFee = " + prpCcoinsDetailDto.getMiddleCostFee() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("policyNo=").append("'").append(prpCcoinsDetailDto.getPolicyNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpCcoinsDetailDto.getSerialNo()).append(" AND ");
            debugBuffer.append("currency=").append("'").append(prpCcoinsDetailDto.getCurrency()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("policyNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpCcoinsDetailDto.getCoinsCode());
        dbManager.setString(2,prpCcoinsDetailDto.getCoinsName());
        dbManager.setDouble(3,prpCcoinsDetailDto.getCoinsAmount());
        dbManager.setDouble(4,prpCcoinsDetailDto.getCoinsPremium());
        dbManager.setDouble(5,prpCcoinsDetailDto.getAgentFee());
        dbManager.setDouble(6,prpCcoinsDetailDto.getOperateFee());
        dbManager.setString(7,prpCcoinsDetailDto.getFlag());
        dbManager.setDouble(8,prpCcoinsDetailDto.getMiddleCostFee());
        //���������ֶ�;
        dbManager.setString(9,prpCcoinsDetailDto.getPolicyNo());
        dbManager.setLong(10,prpCcoinsDetailDto.getSerialNo());
        dbManager.setString(11,prpCcoinsDetailDto.getCurrency());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @return PrpCcoinsDetailDto
     * @throws Exception
     */
    public PrpCcoinsDetailDto findByPrimaryKey(String policyNo,long serialNo,String currency)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("flag,");
        buffer.append("middleCostFee ");
        buffer.append("FROM PrpCcoinsDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("policyNo=").append("'").append(policyNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("currency=").append("'").append(currency).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("policyNo = ? And ");
        buffer.append("serialNo = ? And ");
        buffer.append("currency = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setLong(2,serialNo);
        dbManager.setString(3,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        if(resultSet.next()){
            prpCcoinsDetailDto = new PrpCcoinsDetailDto();
            prpCcoinsDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcoinsDetailDto.setSerialNo(dbManager.getLong(resultSet,2));
            prpCcoinsDetailDto.setCoinsCode(dbManager.getString(resultSet,3));
            prpCcoinsDetailDto.setCoinsName(dbManager.getString(resultSet,4));
            prpCcoinsDetailDto.setCurrency(dbManager.getString(resultSet,5));
            prpCcoinsDetailDto.setCoinsAmount(dbManager.getDouble(resultSet,6));
            prpCcoinsDetailDto.setCoinsPremium(dbManager.getDouble(resultSet,7));
            prpCcoinsDetailDto.setAgentFee(dbManager.getDouble(resultSet,8));
            prpCcoinsDetailDto.setOperateFee(dbManager.getDouble(resultSet,9));
            prpCcoinsDetailDto.setFlag(dbManager.getString(resultSet,10));
            prpCcoinsDetailDto.setMiddleCostFee(dbManager.getDouble(resultSet,11));
        }
        resultSet.close();
        return prpCcoinsDetailDto;
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
        buffer.append("policyNo,");
        buffer.append("serialNo,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("currency,");
        buffer.append("coinsAmount,");
        buffer.append("coinsPremium,");
        buffer.append("agentFee,");
        buffer.append("operateFee,");
        buffer.append("flag,");
        buffer.append("middleCostFee ");
        buffer.append("FROM PrpCcoinsDetail WHERE ");
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
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpCcoinsDetailDto = new PrpCcoinsDetailDto();
            prpCcoinsDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcoinsDetailDto.setSerialNo(dbManager.getLong(resultSet,2));
            prpCcoinsDetailDto.setCoinsCode(dbManager.getString(resultSet,3));
            prpCcoinsDetailDto.setCoinsName(dbManager.getString(resultSet,4));
            prpCcoinsDetailDto.setCurrency(dbManager.getString(resultSet,5));
            prpCcoinsDetailDto.setCoinsAmount(dbManager.getDouble(resultSet,6));
            prpCcoinsDetailDto.setCoinsPremium(dbManager.getDouble(resultSet,7));
            prpCcoinsDetailDto.setAgentFee(dbManager.getDouble(resultSet,8));
            prpCcoinsDetailDto.setOperateFee(dbManager.getDouble(resultSet,9));
            prpCcoinsDetailDto.setFlag(dbManager.getString(resultSet,10));
            prpCcoinsDetailDto.setMiddleCostFee(dbManager.getDouble(resultSet,11));
            collection.add(prpCcoinsDetailDto);
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
        buffer.append("DELETE FROM PrpCcoinsDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpCcoinsDetail WHERE ");
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
