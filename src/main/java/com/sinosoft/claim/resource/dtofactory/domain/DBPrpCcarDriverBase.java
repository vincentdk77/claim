package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpccardriver������ʻԱ��ϵ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCcarDriverBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCcarDriverBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCcarDriverBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void insert(PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        String statement = " Insert Into PrpCcarDriver(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DrivingLicenseNo," + 
                           " ChangelessFlag," + 
                           " DriverName," + 
                           " Identifynumber," + 
                           " Sex," + 
                           " Age," + 
                           " Marriage," + 
                           " DriverAddress," + 
                           " Possessnature," + 
                           " BusinessSource," + 
                           " Peccancy," + 
                           " AcceptLicenseDate," + 
                           " Receivelicenseyear," + 
                           " DrivingYears," + 
                           " Causetroubletimes," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCcarDriverDto.getPolicyNo());
        dbManager.setString(2,prpCcarDriverDto.getRiskCode());
        dbManager.setInt(3,prpCcarDriverDto.getItemNo());
        dbManager.setInt(4,prpCcarDriverDto.getSerialNo());
        dbManager.setString(5,prpCcarDriverDto.getDrivingLicenseNo());
        dbManager.setString(6,prpCcarDriverDto.getChangelessFlag());
        dbManager.setString(7,prpCcarDriverDto.getDriverName());
        dbManager.setString(8,prpCcarDriverDto.getIdentifynumber());
        dbManager.setString(9,prpCcarDriverDto.getSex());
        dbManager.setInt(10,prpCcarDriverDto.getAge());
        dbManager.setString(11,prpCcarDriverDto.getMarriage());
        dbManager.setString(12,prpCcarDriverDto.getDriverAddress());
        dbManager.setString(13,prpCcarDriverDto.getPossessnature());
        dbManager.setString(14,prpCcarDriverDto.getBusinessSource());
        dbManager.setInt(15,prpCcarDriverDto.getPeccancy());
        dbManager.setDateTime(16,prpCcarDriverDto.getAcceptLicenseDate());
        dbManager.setInt(17,prpCcarDriverDto.getReceivelicenseyear());
        dbManager.setInt(18,prpCcarDriverDto.getDrivingYears());
        dbManager.setInt(19,prpCcarDriverDto.getCausetroubletimes());
        dbManager.setString(20,prpCcarDriverDto.getAwardLicenseOrgan());
        dbManager.setString(21,prpCcarDriverDto.getDrivingCarType());
        dbManager.setString(22,prpCcarDriverDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcarDriverBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCcarDriverDto prpCcarDriverDto = (PrpCcarDriverDto)i.next();
            insert(prpCcarDriverDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCcarDriver Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCcarDriverBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void update(PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        String statement = " Update PrpCcarDriver Set RiskCode = ?," + 
                           " ItemNo = ?," + 
                           " DrivingLicenseNo = ?," + 
                           " ChangelessFlag = ?," + 
                           " DriverName = ?," + 
                           " Identifynumber = ?," + 
                           " Sex = ?," + 
                           " Age = ?," + 
                           " Marriage = ?," + 
                           " DriverAddress = ?," + 
                           " Possessnature = ?," + 
                           " BusinessSource = ?," + 
                           " Peccancy = ?," + 
                           " AcceptLicenseDate = ?," + 
                           " Receivelicenseyear = ?," + 
                           " DrivingYears = ?," + 
                           " Causetroubletimes = ?," + 
                           " AwardLicenseOrgan = ?," + 
                           " DrivingCarType = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCcarDriverDto.getRiskCode());
        dbManager.setInt(2,prpCcarDriverDto.getItemNo());
        dbManager.setString(3,prpCcarDriverDto.getDrivingLicenseNo());
        dbManager.setString(4,prpCcarDriverDto.getChangelessFlag());
        dbManager.setString(5,prpCcarDriverDto.getDriverName());
        dbManager.setString(6,prpCcarDriverDto.getIdentifynumber());
        dbManager.setString(7,prpCcarDriverDto.getSex());
        dbManager.setInt(8,prpCcarDriverDto.getAge());
        dbManager.setString(9,prpCcarDriverDto.getMarriage());
        dbManager.setString(10,prpCcarDriverDto.getDriverAddress());
        dbManager.setString(11,prpCcarDriverDto.getPossessnature());
        dbManager.setString(12,prpCcarDriverDto.getBusinessSource());
        dbManager.setInt(13,prpCcarDriverDto.getPeccancy());
        dbManager.setDateTime(14,prpCcarDriverDto.getAcceptLicenseDate());
        dbManager.setInt(15,prpCcarDriverDto.getReceivelicenseyear());
        dbManager.setInt(16,prpCcarDriverDto.getDrivingYears());
        dbManager.setInt(17,prpCcarDriverDto.getCausetroubletimes());
        dbManager.setString(18,prpCcarDriverDto.getAwardLicenseOrgan());
        dbManager.setString(19,prpCcarDriverDto.getDrivingCarType());
        dbManager.setString(20,prpCcarDriverDto.getFlag());
        //���������ֶ�;
        dbManager.setString(21,prpCcarDriverDto.getPolicyNo());
        dbManager.setInt(22,prpCcarDriverDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCcarDriverBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ˳���
     * @return PrpCcarDriverDto
     * @throws Exception
     */
    public PrpCcarDriverDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " SerialNo," + 
                           " DrivingLicenseNo," + 
                           " ChangelessFlag," + 
                           " DriverName," + 
                           " Identifynumber," + 
                           " Sex," + 
                           " Age," + 
                           " Marriage," + 
                           " DriverAddress," + 
                           " Possessnature," + 
                           " BusinessSource," + 
                           " Peccancy," + 
                           " AcceptLicenseDate," + 
                           " Receivelicenseyear," + 
                           " DrivingYears," + 
                           " Causetroubletimes," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag From PrpCcarDriver Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCcarDriverDto prpCcarDriverDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCcarDriverDto = new PrpCcarDriverDto();
            prpCcarDriverDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcarDriverDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcarDriverDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCcarDriverDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcarDriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,5));
            prpCcarDriverDto.setChangelessFlag(dbManager.getString(resultSet,6));
            prpCcarDriverDto.setDriverName(dbManager.getString(resultSet,7));
            prpCcarDriverDto.setIdentifynumber(dbManager.getString(resultSet,8));
            prpCcarDriverDto.setSex(dbManager.getString(resultSet,9));
            prpCcarDriverDto.setAge(dbManager.getInt(resultSet,10));
            prpCcarDriverDto.setMarriage(dbManager.getString(resultSet,11));
            prpCcarDriverDto.setDriverAddress(dbManager.getString(resultSet,12));
            prpCcarDriverDto.setPossessnature(dbManager.getString(resultSet,13));
            prpCcarDriverDto.setBusinessSource(dbManager.getString(resultSet,14));
            prpCcarDriverDto.setPeccancy(dbManager.getInt(resultSet,15));
            prpCcarDriverDto.setAcceptLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpCcarDriverDto.setReceivelicenseyear(dbManager.getInt(resultSet,17));
            prpCcarDriverDto.setDrivingYears(dbManager.getInt(resultSet,18));
            prpCcarDriverDto.setCausetroubletimes(dbManager.getInt(resultSet,19));
            prpCcarDriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,20));
            prpCcarDriverDto.setDrivingCarType(dbManager.getString(resultSet,21));
            prpCcarDriverDto.setFlag(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        log.info("DBPrpCcarDriverBase.findByPrimaryKey() success!");
        return prpCcarDriverDto;
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
                           " DrivingLicenseNo," + 
                           " ChangelessFlag," + 
                           " DriverName," + 
                           " Identifynumber," + 
                           " Sex," + 
                           " Age," + 
                           " Marriage," + 
                           " DriverAddress," + 
                           " Possessnature," + 
                           " BusinessSource," + 
                           " Peccancy," + 
                           " AcceptLicenseDate," + 
                           " Receivelicenseyear," + 
                           " DrivingYears," + 
                           " Causetroubletimes," + 
                           " AwardLicenseOrgan," + 
                           " DrivingCarType," + 
                           " Flag From PrpCcarDriver Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCcarDriverDto prpCcarDriverDto = null;
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

            prpCcarDriverDto = new PrpCcarDriverDto();
            prpCcarDriverDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCcarDriverDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCcarDriverDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCcarDriverDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpCcarDriverDto.setDrivingLicenseNo(dbManager.getString(resultSet,5));
            prpCcarDriverDto.setChangelessFlag(dbManager.getString(resultSet,6));
            prpCcarDriverDto.setDriverName(dbManager.getString(resultSet,7));
            prpCcarDriverDto.setIdentifynumber(dbManager.getString(resultSet,8));
            prpCcarDriverDto.setSex(dbManager.getString(resultSet,9));
            prpCcarDriverDto.setAge(dbManager.getInt(resultSet,10));
            prpCcarDriverDto.setMarriage(dbManager.getString(resultSet,11));
            prpCcarDriverDto.setDriverAddress(dbManager.getString(resultSet,12));
            prpCcarDriverDto.setPossessnature(dbManager.getString(resultSet,13));
            prpCcarDriverDto.setBusinessSource(dbManager.getString(resultSet,14));
            prpCcarDriverDto.setPeccancy(dbManager.getInt(resultSet,15));
            prpCcarDriverDto.setAcceptLicenseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpCcarDriverDto.setReceivelicenseyear(dbManager.getInt(resultSet,17));
            prpCcarDriverDto.setDrivingYears(dbManager.getInt(resultSet,18));
            prpCcarDriverDto.setCausetroubletimes(dbManager.getInt(resultSet,19));
            prpCcarDriverDto.setAwardLicenseOrgan(dbManager.getString(resultSet,20));
            prpCcarDriverDto.setDrivingCarType(dbManager.getString(resultSet,21));
            prpCcarDriverDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpCcarDriverDto);
        }
        resultSet.close();
        log.info("DBPrpCcarDriverBase.findByConditions() success!");
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
        String statement = "Delete From PrpCcarDriver Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCcarDriverBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCcarDriver Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCcarDriverBase.getCount() success!");
        return count;
    }
}
