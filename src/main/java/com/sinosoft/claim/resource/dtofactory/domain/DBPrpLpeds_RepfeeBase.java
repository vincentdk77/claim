package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_RepfeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Repfee��������嵥�ӿ����ݱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_RepfeeBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLpeds_RepfeeBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_RepfeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @throws Exception
     */
    public void insert(PrpLpeds_RepfeeDto prpLpeds_RepfeeDto) throws Exception{
        String statement = " Insert Into PrpLpeds_Repfee(" + 
                           " RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " InsuredName," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " FrameNo," + 
                           " EngineNo," + 
                           " CarKindCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Currency," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpeds_RepfeeDto.getRegistNo());
        dbManager.setString(2,prpLpeds_RepfeeDto.getRiskCode());
        dbManager.setInt(3,prpLpeds_RepfeeDto.getSerialNo());
        dbManager.setString(4,prpLpeds_RepfeeDto.getInsuredName());
        dbManager.setString(5,prpLpeds_RepfeeDto.getPolicyNo());
        dbManager.setInt(6,prpLpeds_RepfeeDto.getItemKindNo());
        dbManager.setString(7,prpLpeds_RepfeeDto.getKindCode());
        dbManager.setString(8,prpLpeds_RepfeeDto.getLicenseNo());
        dbManager.setString(9,prpLpeds_RepfeeDto.getLicenseColorCode());
        dbManager.setString(10,prpLpeds_RepfeeDto.getFrameNo());
        dbManager.setString(11,prpLpeds_RepfeeDto.getEngineNo());
        dbManager.setString(12,prpLpeds_RepfeeDto.getCarKindCode());
        dbManager.setString(13,prpLpeds_RepfeeDto.getCompCode());
        dbManager.setString(14,prpLpeds_RepfeeDto.getCompName());
        dbManager.setString(15,prpLpeds_RepfeeDto.getCurrency());
        dbManager.setDouble(16,prpLpeds_RepfeeDto.getManHour());
        dbManager.setDouble(17,prpLpeds_RepfeeDto.getManHourUnitPrice());
        dbManager.setDouble(18,prpLpeds_RepfeeDto.getMaterialFee());
        dbManager.setString(19,prpLpeds_RepfeeDto.getTransmitFlag());
        dbManager.setString(20,prpLpeds_RepfeeDto.getRemark());
        dbManager.setString(21,prpLpeds_RepfeeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_RepfeeBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpeds_RepfeeDto prpLpeds_RepfeeDto = (PrpLpeds_RepfeeDto)i.next();
            insert(prpLpeds_RepfeeDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpeds_Repfee Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLpeds_RepfeeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpeds_RepfeeDto prpLpeds_RepfeeDto
     * @throws Exception
     */
    public void update(PrpLpeds_RepfeeDto prpLpeds_RepfeeDto) throws Exception{
        String statement = " Update PrpLpeds_Repfee Set RiskCode = ?," + 
                           " InsuredName = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " FrameNo = ?," + 
                           " EngineNo = ?," + 
                           " CarKindCode = ?," + 
                           " CompCode = ?," + 
                           " CompName = ?," + 
                           " Currency = ?," + 
                           " ManHour = ?," + 
                           " ManHourUnitPrice = ?," + 
                           " MaterialFee = ?," + 
                           " TransmitFlag = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLpeds_RepfeeDto.getRiskCode());
        dbManager.setString(2,prpLpeds_RepfeeDto.getInsuredName());
        dbManager.setString(3,prpLpeds_RepfeeDto.getPolicyNo());
        dbManager.setInt(4,prpLpeds_RepfeeDto.getItemKindNo());
        dbManager.setString(5,prpLpeds_RepfeeDto.getKindCode());
        dbManager.setString(6,prpLpeds_RepfeeDto.getLicenseNo());
        dbManager.setString(7,prpLpeds_RepfeeDto.getLicenseColorCode());
        dbManager.setString(8,prpLpeds_RepfeeDto.getFrameNo());
        dbManager.setString(9,prpLpeds_RepfeeDto.getEngineNo());
        dbManager.setString(10,prpLpeds_RepfeeDto.getCarKindCode());
        dbManager.setString(11,prpLpeds_RepfeeDto.getCompCode());
        dbManager.setString(12,prpLpeds_RepfeeDto.getCompName());
        dbManager.setString(13,prpLpeds_RepfeeDto.getCurrency());
        dbManager.setDouble(14,prpLpeds_RepfeeDto.getManHour());
        dbManager.setDouble(15,prpLpeds_RepfeeDto.getManHourUnitPrice());
        dbManager.setDouble(16,prpLpeds_RepfeeDto.getMaterialFee());
        dbManager.setString(17,prpLpeds_RepfeeDto.getTransmitFlag());
        dbManager.setString(18,prpLpeds_RepfeeDto.getRemark());
        dbManager.setString(19,prpLpeds_RepfeeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(20,prpLpeds_RepfeeDto.getRegistNo());
        dbManager.setInt(21,prpLpeds_RepfeeDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_RepfeeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @param serialNo ���
     * @return PrpLpeds_RepfeeDto
     * @throws Exception
     */
    public PrpLpeds_RepfeeDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String statement = " Select RegistNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " InsuredName," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " FrameNo," + 
                           " EngineNo," + 
                           " CarKindCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Currency," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Repfee Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLpeds_RepfeeDto prpLpeds_RepfeeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpeds_RepfeeDto = new PrpLpeds_RepfeeDto();
            prpLpeds_RepfeeDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_RepfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_RepfeeDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLpeds_RepfeeDto.setInsuredName(dbManager.getString(resultSet,4));
            prpLpeds_RepfeeDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpeds_RepfeeDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpeds_RepfeeDto.setKindCode(dbManager.getString(resultSet,7));
            prpLpeds_RepfeeDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLpeds_RepfeeDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLpeds_RepfeeDto.setFrameNo(dbManager.getString(resultSet,10));
            prpLpeds_RepfeeDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLpeds_RepfeeDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLpeds_RepfeeDto.setCompCode(dbManager.getString(resultSet,13));
            prpLpeds_RepfeeDto.setCompName(dbManager.getString(resultSet,14));
            prpLpeds_RepfeeDto.setCurrency(dbManager.getString(resultSet,15));
            prpLpeds_RepfeeDto.setManHour(dbManager.getDouble(resultSet,16));
            prpLpeds_RepfeeDto.setManHourUnitPrice(dbManager.getDouble(resultSet,17));
            prpLpeds_RepfeeDto.setMaterialFee(dbManager.getDouble(resultSet,18));
            prpLpeds_RepfeeDto.setTransmitFlag(dbManager.getString(resultSet,19));
            prpLpeds_RepfeeDto.setRemark(dbManager.getString(resultSet,20));
            prpLpeds_RepfeeDto.setFlag(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        log.info("DBPrpLpeds_RepfeeBase.findByPrimaryKey() success!");
        return prpLpeds_RepfeeDto;
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
                           " SerialNo," + 
                           " InsuredName," + 
                           " PolicyNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " LicenseNo," + 
                           " LicenseColorCode," + 
                           " FrameNo," + 
                           " EngineNo," + 
                           " CarKindCode," + 
                           " CompCode," + 
                           " CompName," + 
                           " Currency," + 
                           " ManHour," + 
                           " ManHourUnitPrice," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Repfee Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLpeds_RepfeeDto prpLpeds_RepfeeDto = null;
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

            prpLpeds_RepfeeDto = new PrpLpeds_RepfeeDto();
            prpLpeds_RepfeeDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_RepfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_RepfeeDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLpeds_RepfeeDto.setInsuredName(dbManager.getString(resultSet,4));
            prpLpeds_RepfeeDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpeds_RepfeeDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpeds_RepfeeDto.setKindCode(dbManager.getString(resultSet,7));
            prpLpeds_RepfeeDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLpeds_RepfeeDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLpeds_RepfeeDto.setFrameNo(dbManager.getString(resultSet,10));
            prpLpeds_RepfeeDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLpeds_RepfeeDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLpeds_RepfeeDto.setCompCode(dbManager.getString(resultSet,13));
            prpLpeds_RepfeeDto.setCompName(dbManager.getString(resultSet,14));
            prpLpeds_RepfeeDto.setCurrency(dbManager.getString(resultSet,15));
            prpLpeds_RepfeeDto.setManHour(dbManager.getDouble(resultSet,16));
            prpLpeds_RepfeeDto.setManHourUnitPrice(dbManager.getDouble(resultSet,17));
            prpLpeds_RepfeeDto.setMaterialFee(dbManager.getDouble(resultSet,18));
            prpLpeds_RepfeeDto.setTransmitFlag(dbManager.getString(resultSet,19));
            prpLpeds_RepfeeDto.setRemark(dbManager.getString(resultSet,20));
            prpLpeds_RepfeeDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpLpeds_RepfeeDto);
        }
        resultSet.close();
        log.info("DBPrpLpeds_RepfeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpeds_Repfee Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLpeds_RepfeeBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLpeds_Repfee Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLpeds_RepfeeBase.getCount() success!");
        return count;
    }
}
