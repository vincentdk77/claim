package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcargoDetailDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccargodetail�����ջ�����ϸ��Ϣ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCcargoDetailBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCcargoDetailBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcargoDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void insert(PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        String statement = " Insert Into PrpCcargoDetail(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " BatchNo," + 
                           " SerialNo," + 
                           " PolicyType," + 
                           " Conveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " CarryBillNo," + 
                           " DetailName," + 
                           " StartDate," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " Quantity," + 
                           " Currency," + 
                           " SumValue," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPremium," + 
                           " SettleFlag," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCcargoDetailDto.getPolicyNo());
        dbManager.setString(2,prpCcargoDetailDto.getRiskCode());
        dbManager.setInt(3,prpCcargoDetailDto.getBatchNo());
        dbManager.setInt(4,prpCcargoDetailDto.getSerialNo());
        dbManager.setString(5,prpCcargoDetailDto.getPolicyType());
        dbManager.setString(6,prpCcargoDetailDto.getConveyance());
        dbManager.setString(7,prpCcargoDetailDto.getBLNo());
        dbManager.setString(8,prpCcargoDetailDto.getVoyageNo());
        dbManager.setString(9,prpCcargoDetailDto.getCarryBillNo());
        dbManager.setString(10,prpCcargoDetailDto.getDetailName());
        dbManager.setDateTime(11,prpCcargoDetailDto.getStartDate());
        dbManager.setString(12,prpCcargoDetailDto.getStartSiteName());
        dbManager.setString(13,prpCcargoDetailDto.getViaSiteName());
        dbManager.setString(14,prpCcargoDetailDto.getEndSiteName());
        dbManager.setString(15,prpCcargoDetailDto.getQuantity());
        dbManager.setString(16,prpCcargoDetailDto.getCurrency());
        dbManager.setDouble(17,prpCcargoDetailDto.getSumValue());
        dbManager.setDouble(18,prpCcargoDetailDto.getSumAmount());
        dbManager.setDouble(19,prpCcargoDetailDto.getRate());
        dbManager.setDouble(20,prpCcargoDetailDto.getSumPremium());
        dbManager.setString(21,prpCcargoDetailDto.getSettleFlag());
        dbManager.setString(22,prpCcargoDetailDto.getRemark());
        dbManager.setString(23,prpCcargoDetailDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcargoDetailBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCcargoDetailDto prpCcargoDetailDto = (PrpCcargoDetailDto)i.next();
            insert(prpCcargoDetailDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ������/Э���
     * @param batchNo ����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(String policyNo,int batchNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCcargoDetail Where " +
                           " PolicyNo = ? And " + 
                           " BatchNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,batchNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCcargoDetailBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void update(PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        String statement = " Update PrpCcargoDetail Set RiskCode = ?," + 
                           " PolicyType = ?," + 
                           " Conveyance = ?," + 
                           " BLNo = ?," + 
                           " VoyageNo = ?," + 
                           " CarryBillNo = ?," + 
                           " DetailName = ?," + 
                           " StartDate = ?," + 
                           " StartSiteName = ?," + 
                           " ViaSiteName = ?," + 
                           " EndSiteName = ?," + 
                           " Quantity = ?," + 
                           " Currency = ?," + 
                           " SumValue = ?," + 
                           " SumAmount = ?," + 
                           " Rate = ?," + 
                           " SumPremium = ?," + 
                           " SettleFlag = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " BatchNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCcargoDetailDto.getRiskCode());
        dbManager.setString(2,prpCcargoDetailDto.getPolicyType());
        dbManager.setString(3,prpCcargoDetailDto.getConveyance());
        dbManager.setString(4,prpCcargoDetailDto.getBLNo());
        dbManager.setString(5,prpCcargoDetailDto.getVoyageNo());
        dbManager.setString(6,prpCcargoDetailDto.getCarryBillNo());
        dbManager.setString(7,prpCcargoDetailDto.getDetailName());
        dbManager.setDateTime(8,prpCcargoDetailDto.getStartDate());
        dbManager.setString(9,prpCcargoDetailDto.getStartSiteName());
        dbManager.setString(10,prpCcargoDetailDto.getViaSiteName());
        dbManager.setString(11,prpCcargoDetailDto.getEndSiteName());
        dbManager.setString(12,prpCcargoDetailDto.getQuantity());
        dbManager.setString(13,prpCcargoDetailDto.getCurrency());
        dbManager.setDouble(14,prpCcargoDetailDto.getSumValue());
        dbManager.setDouble(15,prpCcargoDetailDto.getSumAmount());
        dbManager.setDouble(16,prpCcargoDetailDto.getRate());
        dbManager.setDouble(17,prpCcargoDetailDto.getSumPremium());
        dbManager.setString(18,prpCcargoDetailDto.getSettleFlag());
        dbManager.setString(19,prpCcargoDetailDto.getRemark());
        dbManager.setString(20,prpCcargoDetailDto.getFlag());
        //���������ֶ�;
        dbManager.setString(21,prpCcargoDetailDto.getPolicyNo());
        dbManager.setInt(22,prpCcargoDetailDto.getBatchNo());
        dbManager.setInt(23,prpCcargoDetailDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcargoDetailBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ������/Э���
     * @param batchNo ����
     * @param serialNo ˳���
     * @return PrpCcargoDetailDto
     * @throws Exception
     */
    public PrpCcargoDetailDto findByPrimaryKey(String policyNo,int batchNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " BatchNo," + 
                           " SerialNo," + 
                           " PolicyType," + 
                           " Conveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " CarryBillNo," + 
                           " DetailName," + 
                           " StartDate," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " Quantity," + 
                           " Currency," + 
                           " SumValue," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPremium," + 
                           " SettleFlag," + 
                           " Remark," + 
                           " Flag From PrpCcargoDetail Where " +
                           " PolicyNo = ? And " + 
                           " BatchNo = ? And " + 
                           " SerialNo = ?";
        PrpCcargoDetailDto prpCcargoDetailDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,batchNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCcargoDetailDto = new PrpCcargoDetailDto();
            prpCcargoDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcargoDetailDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcargoDetailDto.setBatchNo(dbManager.getInt(resultSet,3));
            prpCcargoDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcargoDetailDto.setPolicyType(dbManager.getString(resultSet,5));
            prpCcargoDetailDto.setConveyance(dbManager.getString(resultSet,6));
            prpCcargoDetailDto.setBLNo(dbManager.getString(resultSet,7));
            prpCcargoDetailDto.setVoyageNo(dbManager.getString(resultSet,8));
            prpCcargoDetailDto.setCarryBillNo(dbManager.getString(resultSet,9));
            prpCcargoDetailDto.setDetailName(dbManager.getString(resultSet,10));
            prpCcargoDetailDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpCcargoDetailDto.setStartSiteName(dbManager.getString(resultSet,12));
            prpCcargoDetailDto.setViaSiteName(dbManager.getString(resultSet,13));
            prpCcargoDetailDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpCcargoDetailDto.setQuantity(dbManager.getString(resultSet,15));
            prpCcargoDetailDto.setCurrency(dbManager.getString(resultSet,16));
            prpCcargoDetailDto.setSumValue(dbManager.getDouble(resultSet,17));
            prpCcargoDetailDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpCcargoDetailDto.setRate(dbManager.getDouble(resultSet,19));
            prpCcargoDetailDto.setSumPremium(dbManager.getDouble(resultSet,20));
            prpCcargoDetailDto.setSettleFlag(dbManager.getString(resultSet,21));
            prpCcargoDetailDto.setRemark(dbManager.getString(resultSet,22));
            prpCcargoDetailDto.setFlag(dbManager.getString(resultSet,23));
        }
        resultSet.close();
        log.info("DBPrpCcargoDetailBase.findByPrimaryKey() success!");
        return prpCcargoDetailDto;
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
        String statement = "Select PolicyNo," + 
                           " RiskCode," + 
                           " BatchNo," + 
                           " SerialNo," + 
                           " PolicyType," + 
                           " Conveyance," + 
                           " BLNo," + 
                           " VoyageNo," + 
                           " CarryBillNo," + 
                           " DetailName," + 
                           " StartDate," + 
                           " StartSiteName," + 
                           " ViaSiteName," + 
                           " EndSiteName," + 
                           " Quantity," + 
                           " Currency," + 
                           " SumValue," + 
                           " SumAmount," + 
                           " Rate," + 
                           " SumPremium," + 
                           " SettleFlag," + 
                           " Remark," + 
                           " Flag From PrpCcargoDetail Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCcargoDetailDto prpCcargoDetailDto = null;
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

            prpCcargoDetailDto = new PrpCcargoDetailDto();
            prpCcargoDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcargoDetailDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcargoDetailDto.setBatchNo(dbManager.getInt(resultSet,3));
            prpCcargoDetailDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcargoDetailDto.setPolicyType(dbManager.getString(resultSet,5));
            prpCcargoDetailDto.setConveyance(dbManager.getString(resultSet,6));
            prpCcargoDetailDto.setBLNo(dbManager.getString(resultSet,7));
            prpCcargoDetailDto.setVoyageNo(dbManager.getString(resultSet,8));
            prpCcargoDetailDto.setCarryBillNo(dbManager.getString(resultSet,9));
            prpCcargoDetailDto.setDetailName(dbManager.getString(resultSet,10));
            prpCcargoDetailDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpCcargoDetailDto.setStartSiteName(dbManager.getString(resultSet,12));
            prpCcargoDetailDto.setViaSiteName(dbManager.getString(resultSet,13));
            prpCcargoDetailDto.setEndSiteName(dbManager.getString(resultSet,14));
            prpCcargoDetailDto.setQuantity(dbManager.getString(resultSet,15));
            prpCcargoDetailDto.setCurrency(dbManager.getString(resultSet,16));
            prpCcargoDetailDto.setSumValue(dbManager.getDouble(resultSet,17));
            prpCcargoDetailDto.setSumAmount(dbManager.getDouble(resultSet,18));
            prpCcargoDetailDto.setRate(dbManager.getDouble(resultSet,19));
            prpCcargoDetailDto.setSumPremium(dbManager.getDouble(resultSet,20));
            prpCcargoDetailDto.setSettleFlag(dbManager.getString(resultSet,21));
            prpCcargoDetailDto.setRemark(dbManager.getString(resultSet,22));
            prpCcargoDetailDto.setFlag(dbManager.getString(resultSet,23));
            collection.add(prpCcargoDetailDto);
        }
        resultSet.close();
        log.info("DBPrpCcargoDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpCcargoDetail Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCcargoDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCcargoDetail Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCcargoDetailBase.getCount() success!");
        return count;
    }
}
