package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_CompDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLpeds_Comp�����嵥�ӿ����ݱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_CompBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLpeds_CompBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpeds_CompBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void insert(PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        String statement = " Insert Into PrpLpeds_Comp(" + 
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
                           " PartDesc," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " Currency," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpeds_CompDto.getRegistNo());
        dbManager.setString(2,prpLpeds_CompDto.getRiskCode());
        dbManager.setInt(3,prpLpeds_CompDto.getSerialNo());
        dbManager.setString(4,prpLpeds_CompDto.getInsuredName());
        dbManager.setString(5,prpLpeds_CompDto.getPolicyNo());
        dbManager.setInt(6,prpLpeds_CompDto.getItemKindNo());
        dbManager.setString(7,prpLpeds_CompDto.getKindCode());
        dbManager.setString(8,prpLpeds_CompDto.getLicenseNo());
        dbManager.setString(9,prpLpeds_CompDto.getLicenseColorCode());
        dbManager.setString(10,prpLpeds_CompDto.getFrameNo());
        dbManager.setString(11,prpLpeds_CompDto.getEngineNo());
        dbManager.setString(12,prpLpeds_CompDto.getCarKindCode());
        dbManager.setString(13,prpLpeds_CompDto.getPartDesc());
        dbManager.setString(14,prpLpeds_CompDto.getCompCode());
        dbManager.setString(15,prpLpeds_CompDto.getCompName());
        dbManager.setInt(16,prpLpeds_CompDto.getQuantity());
        dbManager.setString(17,prpLpeds_CompDto.getCurrency());
        dbManager.setDouble(18,prpLpeds_CompDto.getManHourFee());
        dbManager.setDouble(19,prpLpeds_CompDto.getMaterialFee());
        dbManager.setString(20,prpLpeds_CompDto.getTransmitFlag());
        dbManager.setString(21,prpLpeds_CompDto.getRemark());
        dbManager.setString(22,prpLpeds_CompDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_CompBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpeds_CompDto prpLpeds_CompDto = (PrpLpeds_CompDto)i.next();
            insert(prpLpeds_CompDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLpeds_Comp Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLpeds_CompBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void update(PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        String statement = " Update PrpLpeds_Comp Set RiskCode = ?," + 
                           " InsuredName = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " KindCode = ?," + 
                           " LicenseNo = ?," + 
                           " LicenseColorCode = ?," + 
                           " FrameNo = ?," + 
                           " EngineNo = ?," + 
                           " CarKindCode = ?," + 
                           " PartDesc = ?," + 
                           " CompCode = ?," + 
                           " CompName = ?," + 
                           " Quantity = ?," + 
                           " Currency = ?," + 
                           " ManHourFee = ?," + 
                           " MaterialFee = ?," + 
                           " TransmitFlag = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLpeds_CompDto.getRiskCode());
        dbManager.setString(2,prpLpeds_CompDto.getInsuredName());
        dbManager.setString(3,prpLpeds_CompDto.getPolicyNo());
        dbManager.setInt(4,prpLpeds_CompDto.getItemKindNo());
        dbManager.setString(5,prpLpeds_CompDto.getKindCode());
        dbManager.setString(6,prpLpeds_CompDto.getLicenseNo());
        dbManager.setString(7,prpLpeds_CompDto.getLicenseColorCode());
        dbManager.setString(8,prpLpeds_CompDto.getFrameNo());
        dbManager.setString(9,prpLpeds_CompDto.getEngineNo());
        dbManager.setString(10,prpLpeds_CompDto.getCarKindCode());
        dbManager.setString(11,prpLpeds_CompDto.getPartDesc());
        dbManager.setString(12,prpLpeds_CompDto.getCompCode());
        dbManager.setString(13,prpLpeds_CompDto.getCompName());
        dbManager.setInt(14,prpLpeds_CompDto.getQuantity());
        dbManager.setString(15,prpLpeds_CompDto.getCurrency());
        dbManager.setDouble(16,prpLpeds_CompDto.getManHourFee());
        dbManager.setDouble(17,prpLpeds_CompDto.getMaterialFee());
        dbManager.setString(18,prpLpeds_CompDto.getTransmitFlag());
        dbManager.setString(19,prpLpeds_CompDto.getRemark());
        dbManager.setString(20,prpLpeds_CompDto.getFlag());
        //���������ֶ�;
        dbManager.setString(21,prpLpeds_CompDto.getRegistNo());
        dbManager.setInt(22,prpLpeds_CompDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLpeds_CompBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @param serialNo ���
     * @return PrpLpeds_CompDto
     * @throws Exception
     */
    public PrpLpeds_CompDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
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
                           " PartDesc," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " Currency," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Comp Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLpeds_CompDto prpLpeds_CompDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpeds_CompDto = new PrpLpeds_CompDto();
            prpLpeds_CompDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_CompDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_CompDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLpeds_CompDto.setInsuredName(dbManager.getString(resultSet,4));
            prpLpeds_CompDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpeds_CompDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpeds_CompDto.setKindCode(dbManager.getString(resultSet,7));
            prpLpeds_CompDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLpeds_CompDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLpeds_CompDto.setFrameNo(dbManager.getString(resultSet,10));
            prpLpeds_CompDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLpeds_CompDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLpeds_CompDto.setPartDesc(dbManager.getString(resultSet,13));
            prpLpeds_CompDto.setCompCode(dbManager.getString(resultSet,14));
            prpLpeds_CompDto.setCompName(dbManager.getString(resultSet,15));
            prpLpeds_CompDto.setQuantity(dbManager.getInt(resultSet,16));
            prpLpeds_CompDto.setCurrency(dbManager.getString(resultSet,17));
            prpLpeds_CompDto.setManHourFee(dbManager.getDouble(resultSet,18));
            prpLpeds_CompDto.setMaterialFee(dbManager.getDouble(resultSet,19));
            prpLpeds_CompDto.setTransmitFlag(dbManager.getString(resultSet,20));
            prpLpeds_CompDto.setRemark(dbManager.getString(resultSet,21));
            prpLpeds_CompDto.setFlag(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        log.info("DBPrpLpeds_CompBase.findByPrimaryKey() success!");
        return prpLpeds_CompDto;
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
                           " PartDesc," + 
                           " CompCode," + 
                           " CompName," + 
                           " Quantity," + 
                           " Currency," + 
                           " ManHourFee," + 
                           " MaterialFee," + 
                           " TransmitFlag," + 
                           " Remark," + 
                           " Flag From PrpLpeds_Comp Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLpeds_CompDto prpLpeds_CompDto = null;
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

            prpLpeds_CompDto = new PrpLpeds_CompDto();
            prpLpeds_CompDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLpeds_CompDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpeds_CompDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLpeds_CompDto.setInsuredName(dbManager.getString(resultSet,4));
            prpLpeds_CompDto.setPolicyNo(dbManager.getString(resultSet,5));
            prpLpeds_CompDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpeds_CompDto.setKindCode(dbManager.getString(resultSet,7));
            prpLpeds_CompDto.setLicenseNo(dbManager.getString(resultSet,8));
            prpLpeds_CompDto.setLicenseColorCode(dbManager.getString(resultSet,9));
            prpLpeds_CompDto.setFrameNo(dbManager.getString(resultSet,10));
            prpLpeds_CompDto.setEngineNo(dbManager.getString(resultSet,11));
            prpLpeds_CompDto.setCarKindCode(dbManager.getString(resultSet,12));
            prpLpeds_CompDto.setPartDesc(dbManager.getString(resultSet,13));
            prpLpeds_CompDto.setCompCode(dbManager.getString(resultSet,14));
            prpLpeds_CompDto.setCompName(dbManager.getString(resultSet,15));
            prpLpeds_CompDto.setQuantity(dbManager.getInt(resultSet,16));
            prpLpeds_CompDto.setCurrency(dbManager.getString(resultSet,17));
            prpLpeds_CompDto.setManHourFee(dbManager.getDouble(resultSet,18));
            prpLpeds_CompDto.setMaterialFee(dbManager.getDouble(resultSet,19));
            prpLpeds_CompDto.setTransmitFlag(dbManager.getString(resultSet,20));
            prpLpeds_CompDto.setRemark(dbManager.getString(resultSet,21));
            prpLpeds_CompDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpLpeds_CompDto);
        }
        resultSet.close();
        log.info("DBPrpLpeds_CompBase.findByConditions() success!");
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
        String statement = "Delete From PrpLpeds_Comp Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLpeds_CompBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLpeds_Comp Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLpeds_CompBase.getCount() success!");
        return count;
    }
}
