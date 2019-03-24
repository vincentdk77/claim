package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_PropDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Prop�Ʋ���ʧ�ӿ����ݱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_PropBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLpeds_PropBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_PropBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpeds_PropDto prpLpeds_PropDto
     * @throws Exception
     */
    public void insert(PrpLpeds_PropDto prpLpeds_PropDto) throws Exception{
        String statement = " Insert Into PrpLpeds_Prop(" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " LossItemName," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " TransmitFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpeds_PropDto.getRegistNo());
        dbManager.setString(2,prpLpeds_PropDto.getRiskCode());
        dbManager.setString(3,prpLpeds_PropDto.getPolicyNo());
        dbManager.setInt(4,prpLpeds_PropDto.getItemKindNo());
        dbManager.setString(5,prpLpeds_PropDto.getKindCode());
        dbManager.setInt(6,prpLpeds_PropDto.getSerialNo());
        dbManager.setString(7,prpLpeds_PropDto.getLossItemName());
        dbManager.setString(8,prpLpeds_PropDto.getFeeTypeName());
        dbManager.setString(9,prpLpeds_PropDto.getCurrency());
        dbManager.setDouble(10,prpLpeds_PropDto.getUnitPrice());
        dbManager.setDouble(11,prpLpeds_PropDto.getLossQuantity());
        dbManager.setString(12,prpLpeds_PropDto.getUnit());
        dbManager.setDouble(13,prpLpeds_PropDto.getLossRate());
        dbManager.setDouble(14,prpLpeds_PropDto.getSumDefLoss());
        dbManager.setString(15,prpLpeds_PropDto.getRemark());
        dbManager.setString(16,prpLpeds_PropDto.getTransmitFlag());
        dbManager.setString(17,prpLpeds_PropDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_PropBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpeds_PropDto prpLpeds_PropDto = (PrpLpeds_PropDto)i.next();
            insert(prpLpeds_PropDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpeds_Prop Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLpeds_PropBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpeds_PropDto prpLpeds_PropDto
     * @throws Exception
     */
    public void update(PrpLpeds_PropDto prpLpeds_PropDto) throws Exception{
        String statement = " Update PrpLpeds_Prop Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " LossItemName = ?," + 
                           " FeeTypeName = ?," + 
                           " Currency = ?," + 
                           " UnitPrice = ?," + 
                           " LossQuantity = ?," + 
                           " Unit = ?," + 
                           " LossRate = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " TransmitFlag = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLpeds_PropDto.getRiskCode());
        dbManager.setString(2,prpLpeds_PropDto.getPolicyNo());
        dbManager.setInt(3,prpLpeds_PropDto.getItemKindNo());
        dbManager.setString(4,prpLpeds_PropDto.getKindCode());
        dbManager.setString(5,prpLpeds_PropDto.getLossItemName());
        dbManager.setString(6,prpLpeds_PropDto.getFeeTypeName());
        dbManager.setString(7,prpLpeds_PropDto.getCurrency());
        dbManager.setDouble(8,prpLpeds_PropDto.getUnitPrice());
        dbManager.setDouble(9,prpLpeds_PropDto.getLossQuantity());
        dbManager.setString(10,prpLpeds_PropDto.getUnit());
        dbManager.setDouble(11,prpLpeds_PropDto.getLossRate());
        dbManager.setDouble(12,prpLpeds_PropDto.getSumDefLoss());
        dbManager.setString(13,prpLpeds_PropDto.getRemark());
        dbManager.setString(14,prpLpeds_PropDto.getTransmitFlag());
        dbManager.setString(15,prpLpeds_PropDto.getFlag());
        //���������ֶ�;
        dbManager.setString(16,prpLpeds_PropDto.getRegistNo());
        dbManager.setInt(17,prpLpeds_PropDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_PropBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @param serialNo ���
     * @return PrpLpeds_PropDto
     * @throws Exception
     */
    public PrpLpeds_PropDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String statement = " Select RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " LossItemName," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " TransmitFlag," + 
                           " Flag From PrpLpeds_Prop Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLpeds_PropDto prpLpeds_PropDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpeds_PropDto = new PrpLpeds_PropDto();
            prpLpeds_PropDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_PropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_PropDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpeds_PropDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLpeds_PropDto.setKindCode(dbManager.getString(resultSet,5));
            prpLpeds_PropDto.setSerialNo(dbManager.getInt(resultSet,6));
            prpLpeds_PropDto.setLossItemName(dbManager.getString(resultSet,7));
            prpLpeds_PropDto.setFeeTypeName(dbManager.getString(resultSet,8));
            prpLpeds_PropDto.setCurrency(dbManager.getString(resultSet,9));
            prpLpeds_PropDto.setUnitPrice(dbManager.getDouble(resultSet,10));
            prpLpeds_PropDto.setLossQuantity(dbManager.getDouble(resultSet,11));
            prpLpeds_PropDto.setUnit(dbManager.getString(resultSet,12));
            prpLpeds_PropDto.setLossRate(dbManager.getDouble(resultSet,13));
            prpLpeds_PropDto.setSumDefLoss(dbManager.getDouble(resultSet,14));
            prpLpeds_PropDto.setRemark(dbManager.getString(resultSet,15));
            prpLpeds_PropDto.setTransmitFlag(dbManager.getString(resultSet,16));
            prpLpeds_PropDto.setFlag(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        log.info("DBPrpLpeds_PropBase.findByPrimaryKey() success!");
        return prpLpeds_PropDto;
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
        String statement = "Select RegistNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " SerialNo," + 
                           " LossItemName," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " TransmitFlag," + 
                           " Flag From PrpLpeds_Prop Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLpeds_PropDto prpLpeds_PropDto = null;
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

            prpLpeds_PropDto = new PrpLpeds_PropDto();
            prpLpeds_PropDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_PropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_PropDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpeds_PropDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLpeds_PropDto.setKindCode(dbManager.getString(resultSet,5));
            prpLpeds_PropDto.setSerialNo(dbManager.getInt(resultSet,6));
            prpLpeds_PropDto.setLossItemName(dbManager.getString(resultSet,7));
            prpLpeds_PropDto.setFeeTypeName(dbManager.getString(resultSet,8));
            prpLpeds_PropDto.setCurrency(dbManager.getString(resultSet,9));
            prpLpeds_PropDto.setUnitPrice(dbManager.getDouble(resultSet,10));
            prpLpeds_PropDto.setLossQuantity(dbManager.getDouble(resultSet,11));
            prpLpeds_PropDto.setUnit(dbManager.getString(resultSet,12));
            prpLpeds_PropDto.setLossRate(dbManager.getDouble(resultSet,13));
            prpLpeds_PropDto.setSumDefLoss(dbManager.getDouble(resultSet,14));
            prpLpeds_PropDto.setRemark(dbManager.getString(resultSet,15));
            prpLpeds_PropDto.setTransmitFlag(dbManager.getString(resultSet,16));
            prpLpeds_PropDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(prpLpeds_PropDto);
        }
        resultSet.close();
        log.info("DBPrpLpeds_PropBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpeds_Prop Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLpeds_PropBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLpeds_Prop Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLpeds_PropBase.getCount() success!");
        return count;
    }
}
