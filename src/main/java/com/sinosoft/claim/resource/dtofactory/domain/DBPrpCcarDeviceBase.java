package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDeviceDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardeviceͶ�������������豸��Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCcarDeviceBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCcarDeviceBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcarDeviceBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @throws Exception
     */
    public void insert(PrpCcarDeviceDto prpCcarDeviceDto) throws Exception{
        String statement = " Insert Into PrpCcarDevice(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DeviceName," + 
                           " Currency," + 
                           " Quantity," + 
                           " PurchasePrice," + 
                           " ActualValue," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCcarDeviceDto.getPolicyNo());
        dbManager.setString(2,prpCcarDeviceDto.getRiskCode());
        dbManager.setInt(3,prpCcarDeviceDto.getItemNo());
        dbManager.setInt(4,prpCcarDeviceDto.getSerialNo());
        dbManager.setString(5,prpCcarDeviceDto.getDeviceName());
        dbManager.setString(6,prpCcarDeviceDto.getCurrency());
        dbManager.setInt(7,prpCcarDeviceDto.getQuantity());
        dbManager.setDouble(8,prpCcarDeviceDto.getPurchasePrice());
        dbManager.setDouble(9,prpCcarDeviceDto.getActualValue());
        dbManager.setString(10,prpCcarDeviceDto.getRemark());
        dbManager.setString(11,prpCcarDeviceDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcarDeviceBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCcarDeviceDto prpCcarDeviceDto = (PrpCcarDeviceDto)i.next();
            insert(prpCcarDeviceDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ���յ�����
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCcarDevice Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCcarDeviceBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCcarDeviceDto prpCcarDeviceDto
     * @throws Exception
     */
    public void update(PrpCcarDeviceDto prpCcarDeviceDto) throws Exception{
        String statement = " Update PrpCcarDevice Set RiskCode = ?," + 
                           " ItemNo = ?," + 
                           " DeviceName = ?," + 
                           " Currency = ?," + 
                           " Quantity = ?," + 
                           " PurchasePrice = ?," + 
                           " ActualValue = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCcarDeviceDto.getRiskCode());
        dbManager.setInt(2,prpCcarDeviceDto.getItemNo());
        dbManager.setString(3,prpCcarDeviceDto.getDeviceName());
        dbManager.setString(4,prpCcarDeviceDto.getCurrency());
        dbManager.setInt(5,prpCcarDeviceDto.getQuantity());
        dbManager.setDouble(6,prpCcarDeviceDto.getPurchasePrice());
        dbManager.setDouble(7,prpCcarDeviceDto.getActualValue());
        dbManager.setString(8,prpCcarDeviceDto.getRemark());
        dbManager.setString(9,prpCcarDeviceDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpCcarDeviceDto.getPolicyNo());
        dbManager.setInt(11,prpCcarDeviceDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcarDeviceBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ���յ�����
     * @param serialNo ˳���
     * @return PrpCcarDeviceDto
     * @throws Exception
     */
    public PrpCcarDeviceDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DeviceName," + 
                           " Currency," + 
                           " Quantity," + 
                           " PurchasePrice," + 
                           " ActualValue," + 
                           " Remark," + 
                           " Flag From PrpCcarDevice Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCcarDeviceDto prpCcarDeviceDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCcarDeviceDto = new PrpCcarDeviceDto();
            prpCcarDeviceDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcarDeviceDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcarDeviceDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCcarDeviceDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcarDeviceDto.setDeviceName(dbManager.getString(resultSet,5));
            prpCcarDeviceDto.setCurrency(dbManager.getString(resultSet,6));
            prpCcarDeviceDto.setQuantity(dbManager.getInt(resultSet,7));
            prpCcarDeviceDto.setPurchasePrice(dbManager.getDouble(resultSet,8));
            prpCcarDeviceDto.setActualValue(dbManager.getDouble(resultSet,9));
            prpCcarDeviceDto.setRemark(dbManager.getString(resultSet,10));
            prpCcarDeviceDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBPrpCcarDeviceBase.findByPrimaryKey() success!");
        return prpCcarDeviceDto;
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
                           " ItemNo," + 
                           " SerialNo," + 
                           " DeviceName," + 
                           " Currency," + 
                           " Quantity," + 
                           " PurchasePrice," + 
                           " ActualValue," + 
                           " Remark," + 
                           " Flag From PrpCcarDevice Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCcarDeviceDto prpCcarDeviceDto = null;
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

            prpCcarDeviceDto = new PrpCcarDeviceDto();
            prpCcarDeviceDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcarDeviceDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcarDeviceDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCcarDeviceDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcarDeviceDto.setDeviceName(dbManager.getString(resultSet,5));
            prpCcarDeviceDto.setCurrency(dbManager.getString(resultSet,6));
            prpCcarDeviceDto.setQuantity(dbManager.getInt(resultSet,7));
            prpCcarDeviceDto.setPurchasePrice(dbManager.getDouble(resultSet,8));
            prpCcarDeviceDto.setActualValue(dbManager.getDouble(resultSet,9));
            prpCcarDeviceDto.setRemark(dbManager.getString(resultSet,10));
            prpCcarDeviceDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(prpCcarDeviceDto);
        }
        resultSet.close();
        log.info("DBPrpCcarDeviceBase.findByConditions() success!");
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
        String statement = "Delete From PrpCcarDevice Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCcarDeviceBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCcarDevice Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCcarDeviceBase.getCount() success!");
        return count;
    }
}
