package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcfeecoins�����ݷ��ʶ������<br>
 * ������ 2013-09-10 08:53:49.796<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLcfeecoinsBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLcfeecoinsBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcfeecoinsBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void insert(PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLcfeecoins (");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("currency,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("chiefFlag,");
        buffer.append("lossFeeType,");
        buffer.append("chargeCode,");
        buffer.append("chargeName,");
        buffer.append("sumpaid,");
        buffer.append("coinsSumpaid,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getBusinessNo()).append("',");
            debugBuffer.append("").append(prpLcfeecoinsDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getCurrency()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getCoinsCode()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getCoinsName()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getCoinsType()).append("',");
            debugBuffer.append("").append(prpLcfeecoinsDto.getCoinsRate()).append(",");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getChiefFlag()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getLossFeeType()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getChargeCode()).append("',");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getChargeName()).append("',");
            debugBuffer.append("").append(prpLcfeecoinsDto.getSumpaid()).append(",");
            debugBuffer.append("").append(prpLcfeecoinsDto.getCoinsSumpaid()).append(",");
            debugBuffer.append("'").append(prpLcfeecoinsDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLcfeecoinsDto.getBusinessNo());
        dbManager.setInt(2,prpLcfeecoinsDto.getSerialNo());
        dbManager.setString(3,prpLcfeecoinsDto.getRiskCode());
        dbManager.setString(4,prpLcfeecoinsDto.getPolicyNo());
        dbManager.setString(5,prpLcfeecoinsDto.getCurrency());
        dbManager.setString(6,prpLcfeecoinsDto.getCoinsCode());
        dbManager.setString(7,prpLcfeecoinsDto.getCoinsName());
        dbManager.setString(8,prpLcfeecoinsDto.getCoinsType());
        dbManager.setDouble(9,prpLcfeecoinsDto.getCoinsRate());
        dbManager.setString(10,prpLcfeecoinsDto.getChiefFlag());
        dbManager.setString(11,prpLcfeecoinsDto.getLossFeeType());
        dbManager.setString(12,prpLcfeecoinsDto.getChargeCode());
        dbManager.setString(13,prpLcfeecoinsDto.getChargeName());
        dbManager.setDouble(14,prpLcfeecoinsDto.getSumpaid());
        dbManager.setDouble(15,prpLcfeecoinsDto.getCoinsSumpaid());
        dbManager.setString(16,prpLcfeecoinsDto.getFlag());
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
        buffer.append("INSERT INTO PrpLcfeecoins (");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("currency,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("chiefFlag,");
        buffer.append("lossFeeType,");
        buffer.append("chargeCode,");
        buffer.append("chargeName,");
        buffer.append("sumpaid,");
        buffer.append("coinsSumpaid,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcfeecoinsDto prpLcfeecoinsDto = (PrpLcfeecoinsDto)i.next();
            dbManager.setString(1,prpLcfeecoinsDto.getBusinessNo());
            dbManager.setInt(2,prpLcfeecoinsDto.getSerialNo());
            dbManager.setString(3,prpLcfeecoinsDto.getRiskCode());
            dbManager.setString(4,prpLcfeecoinsDto.getPolicyNo());
            dbManager.setString(5,prpLcfeecoinsDto.getCurrency());
            dbManager.setString(6,prpLcfeecoinsDto.getCoinsCode());
            dbManager.setString(7,prpLcfeecoinsDto.getCoinsName());
            dbManager.setString(8,prpLcfeecoinsDto.getCoinsType());
            dbManager.setDouble(9,prpLcfeecoinsDto.getCoinsRate());
            dbManager.setString(10,prpLcfeecoinsDto.getChiefFlag());
            dbManager.setString(11,prpLcfeecoinsDto.getLossFeeType());
            dbManager.setString(12,prpLcfeecoinsDto.getChargeCode());
            dbManager.setString(13,prpLcfeecoinsDto.getChargeName());
            dbManager.setDouble(14,prpLcfeecoinsDto.getSumpaid());
            dbManager.setDouble(15,prpLcfeecoinsDto.getCoinsSumpaid());
            dbManager.setString(16,prpLcfeecoinsDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String businessNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLcfeecoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(businessNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void update(PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLcfeecoins SET ");
        buffer.append("riskCode = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("currency = ?, ");
        buffer.append("coinsCode = ?, ");
        buffer.append("coinsName = ?, ");
        buffer.append("coinsType = ?, ");
        buffer.append("coinsRate = ?, ");
        buffer.append("chiefFlag = ?, ");
        buffer.append("lossFeeType = ?, ");
        buffer.append("chargeCode = ?, ");
        buffer.append("chargeName = ?, ");
        buffer.append("sumpaid = ?, ");
        buffer.append("coinsSumpaid = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLcfeecoins SET ");
            debugBuffer.append("riskCode = '" + prpLcfeecoinsDto.getRiskCode() + "', ");
            debugBuffer.append("policyNo = '" + prpLcfeecoinsDto.getPolicyNo() + "', ");
            debugBuffer.append("currency = '" + prpLcfeecoinsDto.getCurrency() + "', ");
            debugBuffer.append("coinsCode = '" + prpLcfeecoinsDto.getCoinsCode() + "', ");
            debugBuffer.append("coinsName = '" + prpLcfeecoinsDto.getCoinsName() + "', ");
            debugBuffer.append("coinsType = '" + prpLcfeecoinsDto.getCoinsType() + "', ");
            debugBuffer.append("coinsRate = " + prpLcfeecoinsDto.getCoinsRate() + ", ");
            debugBuffer.append("chiefFlag = '" + prpLcfeecoinsDto.getChiefFlag() + "', ");
            debugBuffer.append("lossFeeType = '" + prpLcfeecoinsDto.getLossFeeType() + "', ");
            debugBuffer.append("chargeCode = '" + prpLcfeecoinsDto.getChargeCode() + "', ");
            debugBuffer.append("chargeName = '" + prpLcfeecoinsDto.getChargeName() + "', ");
            debugBuffer.append("sumpaid = " + prpLcfeecoinsDto.getSumpaid() + ", ");
            debugBuffer.append("coinsSumpaid = " + prpLcfeecoinsDto.getCoinsSumpaid() + ", ");
            debugBuffer.append("flag = '" + prpLcfeecoinsDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(prpLcfeecoinsDto.getBusinessNo()).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(prpLcfeecoinsDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLcfeecoinsDto.getRiskCode());
        dbManager.setString(2,prpLcfeecoinsDto.getPolicyNo());
        dbManager.setString(3,prpLcfeecoinsDto.getCurrency());
        dbManager.setString(4,prpLcfeecoinsDto.getCoinsCode());
        dbManager.setString(5,prpLcfeecoinsDto.getCoinsName());
        dbManager.setString(6,prpLcfeecoinsDto.getCoinsType());
        dbManager.setDouble(7,prpLcfeecoinsDto.getCoinsRate());
        dbManager.setString(8,prpLcfeecoinsDto.getChiefFlag());
        dbManager.setString(9,prpLcfeecoinsDto.getLossFeeType());
        dbManager.setString(10,prpLcfeecoinsDto.getChargeCode());
        dbManager.setString(11,prpLcfeecoinsDto.getChargeName());
        dbManager.setDouble(12,prpLcfeecoinsDto.getSumpaid());
        dbManager.setDouble(13,prpLcfeecoinsDto.getCoinsSumpaid());
        dbManager.setString(14,prpLcfeecoinsDto.getFlag());
        //���������ֶ�;
        dbManager.setString(15,prpLcfeecoinsDto.getBusinessNo());
        dbManager.setInt(16,prpLcfeecoinsDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @return PrpLcfeecoinsDto
     * @throws Exception
     */
    public PrpLcfeecoinsDto findByPrimaryKey(String businessNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("currency,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("chiefFlag,");
        buffer.append("lossFeeType,");
        buffer.append("chargeCode,");
        buffer.append("chargeName,");
        buffer.append("sumpaid,");
        buffer.append("coinsSumpaid,");
        buffer.append("flag ");
        buffer.append("FROM PrpLcfeecoins ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(businessNo).append("' AND ");
            debugBuffer.append("serialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ? And ");
        buffer.append("serialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        if(resultSet.next()){
            prpLcfeecoinsDto = new PrpLcfeecoinsDto();
            prpLcfeecoinsDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcfeecoinsDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcfeecoinsDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcfeecoinsDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcfeecoinsDto.setCurrency(dbManager.getString(resultSet,5));
            prpLcfeecoinsDto.setCoinsCode(dbManager.getString(resultSet,6));
            prpLcfeecoinsDto.setCoinsName(dbManager.getString(resultSet,7));
            prpLcfeecoinsDto.setCoinsType(dbManager.getString(resultSet,8));
            prpLcfeecoinsDto.setCoinsRate(dbManager.getDouble(resultSet,9));
            prpLcfeecoinsDto.setChiefFlag(dbManager.getString(resultSet,10));
            prpLcfeecoinsDto.setLossFeeType(dbManager.getString(resultSet,11));
            prpLcfeecoinsDto.setChargeCode(dbManager.getString(resultSet,12));
            prpLcfeecoinsDto.setChargeName(dbManager.getString(resultSet,13));
            prpLcfeecoinsDto.setSumpaid(dbManager.getDouble(resultSet,14));
            prpLcfeecoinsDto.setCoinsSumpaid(dbManager.getDouble(resultSet,15));
            prpLcfeecoinsDto.setFlag(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        return prpLcfeecoinsDto;
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
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("riskCode,");
        buffer.append("policyNo,");
        buffer.append("currency,");
        buffer.append("coinsCode,");
        buffer.append("coinsName,");
        buffer.append("coinsType,");
        buffer.append("coinsRate,");
        buffer.append("chiefFlag,");
        buffer.append("lossFeeType,");
        buffer.append("chargeCode,");
        buffer.append("chargeName,");
        buffer.append("sumpaid,");
        buffer.append("coinsSumpaid,");
        buffer.append("flag ");
        buffer.append("FROM PrpLcfeecoins WHERE ");
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
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLcfeecoinsDto = new PrpLcfeecoinsDto();
            prpLcfeecoinsDto.setBusinessNo(dbManager.getString(resultSet,1));
            prpLcfeecoinsDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLcfeecoinsDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcfeecoinsDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcfeecoinsDto.setCurrency(dbManager.getString(resultSet,5));
            prpLcfeecoinsDto.setCoinsCode(dbManager.getString(resultSet,6));
            prpLcfeecoinsDto.setCoinsName(dbManager.getString(resultSet,7));
            prpLcfeecoinsDto.setCoinsType(dbManager.getString(resultSet,8));
            prpLcfeecoinsDto.setCoinsRate(dbManager.getDouble(resultSet,9));
            prpLcfeecoinsDto.setChiefFlag(dbManager.getString(resultSet,10));
            prpLcfeecoinsDto.setLossFeeType(dbManager.getString(resultSet,11));
            prpLcfeecoinsDto.setChargeCode(dbManager.getString(resultSet,12));
            prpLcfeecoinsDto.setChargeName(dbManager.getString(resultSet,13));
            prpLcfeecoinsDto.setSumpaid(dbManager.getDouble(resultSet,14));
            prpLcfeecoinsDto.setCoinsSumpaid(dbManager.getDouble(resultSet,15));
            prpLcfeecoinsDto.setFlag(dbManager.getString(resultSet,16));
            collection.add(prpLcfeecoinsDto);
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
        buffer.append("DELETE FROM PrpLcfeecoins WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLcfeecoins WHERE ");
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
