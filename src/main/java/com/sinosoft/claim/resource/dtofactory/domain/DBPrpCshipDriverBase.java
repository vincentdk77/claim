package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCshipDriverDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcshipdriver�����մ�Ա��Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCshipDriverBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCshipDriverBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCshipDriverBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void insert(PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        String statement = " Insert Into PrpCshipDriver(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverTypeCode," + 
                           " Birthday," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " DrivingLicenseNo," + 
                           " ReceiveLicenseDate," + 
                           " DrivingShipType," + 
                           " DrivingYear," + 
                           " ChangelessFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCshipDriverDto.getPolicyNo());
        dbManager.setString(2,prpCshipDriverDto.getRiskCode());
        dbManager.setInt(3,prpCshipDriverDto.getItemNo());
        dbManager.setInt(4,prpCshipDriverDto.getSerialNo());
        dbManager.setString(5,prpCshipDriverDto.getDriverName());
        dbManager.setString(6,prpCshipDriverDto.getDriverSex());
        dbManager.setString(7,prpCshipDriverDto.getDriverTypeCode());
        dbManager.setDateTime(8,prpCshipDriverDto.getBirthday());
        dbManager.setString(9,prpCshipDriverDto.getDriverGrade());
        dbManager.setString(10,prpCshipDriverDto.getDriverSeaRoute());
        dbManager.setString(11,prpCshipDriverDto.getDrivingLicenseNo());
        dbManager.setDateTime(12,prpCshipDriverDto.getReceiveLicenseDate());
        dbManager.setString(13,prpCshipDriverDto.getDrivingShipType());
        dbManager.setInt(14,prpCshipDriverDto.getDrivingYear());
        dbManager.setString(15,prpCshipDriverDto.getChangelessFlag());
        dbManager.setString(16,prpCshipDriverDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCshipDriverBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCshipDriverDto prpCshipDriverDto = (PrpCshipDriverDto)i.next();
            insert(prpCshipDriverDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo Ͷ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCshipDriver Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCshipDriverBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void update(PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        String statement = " Update PrpCshipDriver Set RiskCode = ?," + 
                           " ItemNo = ?," + 
                           " DriverName = ?," + 
                           " DriverSex = ?," + 
                           " DriverTypeCode = ?," + 
                           " Birthday = ?," + 
                           " DriverGrade = ?," + 
                           " DriverSeaRoute = ?," + 
                           " DrivingLicenseNo = ?," + 
                           " ReceiveLicenseDate = ?," + 
                           " DrivingShipType = ?," + 
                           " DrivingYear = ?," + 
                           " ChangelessFlag = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCshipDriverDto.getRiskCode());
        dbManager.setInt(2,prpCshipDriverDto.getItemNo());
        dbManager.setString(3,prpCshipDriverDto.getDriverName());
        dbManager.setString(4,prpCshipDriverDto.getDriverSex());
        dbManager.setString(5,prpCshipDriverDto.getDriverTypeCode());
        dbManager.setDateTime(6,prpCshipDriverDto.getBirthday());
        dbManager.setString(7,prpCshipDriverDto.getDriverGrade());
        dbManager.setString(8,prpCshipDriverDto.getDriverSeaRoute());
        dbManager.setString(9,prpCshipDriverDto.getDrivingLicenseNo());
        dbManager.setDateTime(10,prpCshipDriverDto.getReceiveLicenseDate());
        dbManager.setString(11,prpCshipDriverDto.getDrivingShipType());
        dbManager.setInt(12,prpCshipDriverDto.getDrivingYear());
        dbManager.setString(13,prpCshipDriverDto.getChangelessFlag());
        dbManager.setString(14,prpCshipDriverDto.getFlag());
        //���������ֶ�;
        dbManager.setString(15,prpCshipDriverDto.getPolicyNo());
        dbManager.setInt(16,prpCshipDriverDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCshipDriverBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo Ͷ��������
     * @param serialNo ���
     * @return PrpCshipDriverDto
     * @throws Exception
     */
    public PrpCshipDriverDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverTypeCode," + 
                           " Birthday," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " DrivingLicenseNo," + 
                           " ReceiveLicenseDate," + 
                           " DrivingShipType," + 
                           " DrivingYear," + 
                           " ChangelessFlag," + 
                           " Flag From PrpCshipDriver Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCshipDriverDto prpCshipDriverDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCshipDriverDto = new PrpCshipDriverDto();
            prpCshipDriverDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCshipDriverDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCshipDriverDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCshipDriverDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCshipDriverDto.setDriverName(dbManager.getString(resultSet,5));
            prpCshipDriverDto.setDriverSex(dbManager.getString(resultSet,6));
            prpCshipDriverDto.setDriverTypeCode(dbManager.getString(resultSet,7));
            prpCshipDriverDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpCshipDriverDto.setDriverGrade(dbManager.getString(resultSet,9));
            prpCshipDriverDto.setDriverSeaRoute(dbManager.getString(resultSet,10));
            prpCshipDriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,11));
            prpCshipDriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpCshipDriverDto.setDrivingShipType(dbManager.getString(resultSet,13));
            prpCshipDriverDto.setDrivingYear(dbManager.getInt(resultSet,14));
            prpCshipDriverDto.setChangelessFlag(dbManager.getString(resultSet,15));
            prpCshipDriverDto.setFlag(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        log.info("DBPrpCshipDriverBase.findByPrimaryKey() success!");
        return prpCshipDriverDto;
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
                           " DriverName," + 
                           " DriverSex," + 
                           " DriverTypeCode," + 
                           " Birthday," + 
                           " DriverGrade," + 
                           " DriverSeaRoute," + 
                           " DrivingLicenseNo," + 
                           " ReceiveLicenseDate," + 
                           " DrivingShipType," + 
                           " DrivingYear," + 
                           " ChangelessFlag," + 
                           " Flag From PrpCshipDriver Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCshipDriverDto prpCshipDriverDto = null;
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

            prpCshipDriverDto = new PrpCshipDriverDto();
            prpCshipDriverDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCshipDriverDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCshipDriverDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCshipDriverDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCshipDriverDto.setDriverName(dbManager.getString(resultSet,5));
            prpCshipDriverDto.setDriverSex(dbManager.getString(resultSet,6));
            prpCshipDriverDto.setDriverTypeCode(dbManager.getString(resultSet,7));
            prpCshipDriverDto.setBirthday(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpCshipDriverDto.setDriverGrade(dbManager.getString(resultSet,9));
            prpCshipDriverDto.setDriverSeaRoute(dbManager.getString(resultSet,10));
            prpCshipDriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,11));
            prpCshipDriverDto.setReceiveLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,12));
            prpCshipDriverDto.setDrivingShipType(dbManager.getString(resultSet,13));
            prpCshipDriverDto.setDrivingYear(dbManager.getInt(resultSet,14));
            prpCshipDriverDto.setChangelessFlag(dbManager.getString(resultSet,15));
            prpCshipDriverDto.setFlag(dbManager.getString(resultSet,16));
            collection.add(prpCshipDriverDto);
        }
        resultSet.close();
        log.info("DBPrpCshipDriverBase.findByConditions() success!");
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
        String statement = "Delete From PrpCshipDriver Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCshipDriverBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCshipDriver Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCshipDriverBase.getCount() success!");
        return count;
    }
}
