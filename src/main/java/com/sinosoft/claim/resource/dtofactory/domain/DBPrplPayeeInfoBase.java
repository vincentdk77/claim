package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.claim.dto.domain.PrplPayeeInfoDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrplPayeeInfo�����ݷ��ʶ������<br>
 * ������ 2018-12-03 19:24:47.080<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrplPayeeInfoBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplPayeeInfoBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplPayeeInfoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void insert(PrplPayeeInfoDto prplPayeeInfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrplPayeeInfo (");
        buffer.append("receiverFullName,");
        buffer.append("receiverTypeOther,");
        buffer.append("receiverTypeOtherName,");
        buffer.append("certifNo,");
        buffer.append("certifType,");
        buffer.append("bank,");
        buffer.append("bankAccount,");
        buffer.append("bankType,");
        buffer.append("accountFlag,");
        buffer.append("accountType,");
        buffer.append("routeNum,");
        buffer.append("city,");
        buffer.append("province,");
        buffer.append("mobilePhone,");
        buffer.append("inputDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplPayeeInfoDto.getReceiverFullName()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getReceiverTypeOther()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getReceiverTypeOtherName()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getCertifNo()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getCertifType()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getBank()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getBankAccount()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getBankType()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getAccountFlag()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getAccountType()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getRouteNum()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getCity()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getProvince()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getMobilePhone()).append("',");
            debugBuffer.append("'").append(prplPayeeInfoDto.getInputDate()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplPayeeInfoDto.getReceiverFullName());
        dbManager.setString(2,prplPayeeInfoDto.getReceiverTypeOther());
        dbManager.setString(3,prplPayeeInfoDto.getReceiverTypeOtherName());
        dbManager.setString(4,prplPayeeInfoDto.getCertifNo());
        dbManager.setString(5,prplPayeeInfoDto.getCertifType());
        dbManager.setString(6,prplPayeeInfoDto.getBank());
        dbManager.setString(7,prplPayeeInfoDto.getBankAccount());
        dbManager.setString(8,prplPayeeInfoDto.getBankType());
        dbManager.setString(9,prplPayeeInfoDto.getAccountFlag());
        dbManager.setString(10,prplPayeeInfoDto.getAccountType());
        dbManager.setString(11,prplPayeeInfoDto.getRouteNum());
        dbManager.setString(12,prplPayeeInfoDto.getCity());
        dbManager.setString(13,prplPayeeInfoDto.getProvince());
        dbManager.setString(14,prplPayeeInfoDto.getMobilePhone());
        dbManager.setString(15,prplPayeeInfoDto.getInputDate());
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
        buffer.append("INSERT INTO PrplPayeeInfo (");
        buffer.append("receiverFullName,");
        buffer.append("receiverTypeOther,");
        buffer.append("receiverTypeOtherName,");
        buffer.append("certifNo,");
        buffer.append("certifType,");
        buffer.append("bank,");
        buffer.append("bankAccount,");
        buffer.append("bankType,");
        buffer.append("accountFlag,");
        buffer.append("accountType,");
        buffer.append("routeNum,");
        buffer.append("city,");
        buffer.append("province,");
        buffer.append("mobilePhone,");
        buffer.append("inputDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplPayeeInfoDto prplPayeeInfoDto = (PrplPayeeInfoDto)i.next();
            dbManager.setString(1,prplPayeeInfoDto.getReceiverFullName());
            dbManager.setString(2,prplPayeeInfoDto.getReceiverTypeOther());
            dbManager.setString(3,prplPayeeInfoDto.getReceiverTypeOtherName());
            dbManager.setString(4,prplPayeeInfoDto.getCertifNo());
            dbManager.setString(5,prplPayeeInfoDto.getCertifType());
            dbManager.setString(6,prplPayeeInfoDto.getBank());
            dbManager.setString(7,prplPayeeInfoDto.getBankAccount());
            dbManager.setString(8,prplPayeeInfoDto.getBankType());
            dbManager.setString(9,prplPayeeInfoDto.getAccountFlag());
            dbManager.setString(10,prplPayeeInfoDto.getAccountType());
            dbManager.setString(11,prplPayeeInfoDto.getRouteNum());
            dbManager.setString(12,prplPayeeInfoDto.getCity());
            dbManager.setString(13,prplPayeeInfoDto.getProvince());
            dbManager.setString(14,prplPayeeInfoDto.getMobilePhone());
            dbManager.setString(15,prplPayeeInfoDto.getInputDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param receiverFullName receiverFullName
     * @throws Exception
     */
    public void delete(String receiverFullName)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrplPayeeInfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("receiverFullName=").append("'").append(receiverFullName).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("receiverFullName = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,receiverFullName);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplPayeeInfoDto prplPayeeInfoDto
     * @throws Exception
     */
    public void update(PrplPayeeInfoDto prplPayeeInfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrplPayeeInfo SET ");
        buffer.append("receiverTypeOther = ?, ");
        buffer.append("receiverTypeOtherName = ?, ");
        buffer.append("certifNo = ?, ");
        buffer.append("certifType = ?, ");
        buffer.append("bank = ?, ");
        buffer.append("bankAccount = ?, ");
        buffer.append("bankType = ?, ");
        buffer.append("accountFlag = ?, ");
        buffer.append("accountType = ?, ");
        buffer.append("routeNum = ?, ");
        buffer.append("city = ?, ");
        buffer.append("province = ?, ");
        buffer.append("mobilePhone = ?, ");
        buffer.append("inputDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrplPayeeInfo SET ");
            debugBuffer.append("receiverTypeOther = '" + prplPayeeInfoDto.getReceiverTypeOther() + "', ");
            debugBuffer.append("receiverTypeOtherName = '" + prplPayeeInfoDto.getReceiverTypeOtherName() + "', ");
            debugBuffer.append("certifNo = '" + prplPayeeInfoDto.getCertifNo() + "', ");
            debugBuffer.append("certifType = '" + prplPayeeInfoDto.getCertifType() + "', ");
            debugBuffer.append("bank = '" + prplPayeeInfoDto.getBank() + "', ");
            debugBuffer.append("bankAccount = '" + prplPayeeInfoDto.getBankAccount() + "', ");
            debugBuffer.append("bankType = '" + prplPayeeInfoDto.getBankType() + "', ");
            debugBuffer.append("accountFlag = '" + prplPayeeInfoDto.getAccountFlag() + "', ");
            debugBuffer.append("accountType = '" + prplPayeeInfoDto.getAccountType() + "', ");
            debugBuffer.append("routeNum = '" + prplPayeeInfoDto.getRouteNum() + "', ");
            debugBuffer.append("city = '" + prplPayeeInfoDto.getCity() + "', ");
            debugBuffer.append("province = '" + prplPayeeInfoDto.getProvince() + "', ");
            debugBuffer.append("mobilePhone = '" + prplPayeeInfoDto.getMobilePhone() + "', ");
            debugBuffer.append("inputDate = '" + prplPayeeInfoDto.getInputDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("receiverFullName=").append("'").append(prplPayeeInfoDto.getReceiverFullName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("receiverFullName = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplPayeeInfoDto.getReceiverTypeOther());
        dbManager.setString(2,prplPayeeInfoDto.getReceiverTypeOtherName());
        dbManager.setString(3,prplPayeeInfoDto.getCertifNo());
        dbManager.setString(4,prplPayeeInfoDto.getCertifType());
        dbManager.setString(5,prplPayeeInfoDto.getBank());
        dbManager.setString(6,prplPayeeInfoDto.getBankAccount());
        dbManager.setString(7,prplPayeeInfoDto.getBankType());
        dbManager.setString(8,prplPayeeInfoDto.getAccountFlag());
        dbManager.setString(9,prplPayeeInfoDto.getAccountType());
        dbManager.setString(10,prplPayeeInfoDto.getRouteNum());
        dbManager.setString(11,prplPayeeInfoDto.getCity());
        dbManager.setString(12,prplPayeeInfoDto.getProvince());
        dbManager.setString(13,prplPayeeInfoDto.getMobilePhone());
        dbManager.setString(14,prplPayeeInfoDto.getInputDate());
        //���������ֶ�;
        dbManager.setString(15,prplPayeeInfoDto.getReceiverFullName());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param receiverFullName receiverFullName
     * @return PrplPayeeInfoDto
     * @throws Exception
     */
    public PrplPayeeInfoDto findByPrimaryKey(String receiverFullName)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("receiverFullName,");
        buffer.append("receiverTypeOther,");
        buffer.append("receiverTypeOtherName,");
        buffer.append("certifNo,");
        buffer.append("certifType,");
        buffer.append("bank,");
        buffer.append("bankAccount,");
        buffer.append("bankType,");
        buffer.append("accountFlag,");
        buffer.append("accountType,");
        buffer.append("routeNum,");
        buffer.append("city,");
        buffer.append("province,");
        buffer.append("mobilePhone,");
        buffer.append("inputDate ");
        buffer.append("FROM PrplPayeeInfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("receiverFullName=").append("'").append(receiverFullName).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("receiverFullName = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,receiverFullName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplPayeeInfoDto prplPayeeInfoDto = null;
        if(resultSet.next()){
            prplPayeeInfoDto = new PrplPayeeInfoDto();
            prplPayeeInfoDto.setReceiverFullName(dbManager.getString(resultSet,1));
            prplPayeeInfoDto.setReceiverTypeOther(dbManager.getString(resultSet,2));
            prplPayeeInfoDto.setReceiverTypeOtherName(dbManager.getString(resultSet,3));
            prplPayeeInfoDto.setCertifNo(dbManager.getString(resultSet,4));
            prplPayeeInfoDto.setCertifType(dbManager.getString(resultSet,5));
            prplPayeeInfoDto.setBank(dbManager.getString(resultSet,6));
            prplPayeeInfoDto.setBankAccount(dbManager.getString(resultSet,7));
            prplPayeeInfoDto.setBankType(dbManager.getString(resultSet,8));
            prplPayeeInfoDto.setAccountFlag(dbManager.getString(resultSet,9));
            prplPayeeInfoDto.setAccountType(dbManager.getString(resultSet,10));
            prplPayeeInfoDto.setRouteNum(dbManager.getString(resultSet,11));
            prplPayeeInfoDto.setCity(dbManager.getString(resultSet,12));
            prplPayeeInfoDto.setProvince(dbManager.getString(resultSet,13));
            prplPayeeInfoDto.setMobilePhone(dbManager.getString(resultSet,14));
            prplPayeeInfoDto.setInputDate(dbManager.getString(resultSet,15));
        }
        resultSet.close();
        return prplPayeeInfoDto;
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
        buffer.append("receiverFullName,");
        buffer.append("receiverTypeOther,");
        buffer.append("receiverTypeOtherName,");
        buffer.append("certifNo,");
        buffer.append("certifType,");
        buffer.append("bank,");
        buffer.append("bankAccount,");
        buffer.append("bankType,");
        buffer.append("accountFlag,");
        buffer.append("accountType,");
        buffer.append("routeNum,");
        buffer.append("city,");
        buffer.append("province,");
        buffer.append("mobilePhone,");
        buffer.append("inputDate ");
        buffer.append("FROM PrplPayeeInfo WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //System.err.println(buffer.toString());
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrplPayeeInfoDto prplPayeeInfoDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prplPayeeInfoDto = new PrplPayeeInfoDto();
            prplPayeeInfoDto.setReceiverFullName(dbManager.getString(resultSet,1));
            prplPayeeInfoDto.setReceiverTypeOther(dbManager.getString(resultSet,2));
            prplPayeeInfoDto.setReceiverTypeOtherName(dbManager.getString(resultSet,3));
            prplPayeeInfoDto.setCertifNo(dbManager.getString(resultSet,4));
            prplPayeeInfoDto.setCertifType(dbManager.getString(resultSet,5));
            prplPayeeInfoDto.setBank(dbManager.getString(resultSet,6));
            prplPayeeInfoDto.setBankAccount(dbManager.getString(resultSet,7));
            prplPayeeInfoDto.setBankType(dbManager.getString(resultSet,8));
            prplPayeeInfoDto.setAccountFlag(dbManager.getString(resultSet,9));
            prplPayeeInfoDto.setAccountType(dbManager.getString(resultSet,10));
            prplPayeeInfoDto.setRouteNum(dbManager.getString(resultSet,11));
            prplPayeeInfoDto.setCity(dbManager.getString(resultSet,12));
            prplPayeeInfoDto.setProvince(dbManager.getString(resultSet,13));
            prplPayeeInfoDto.setMobilePhone(dbManager.getString(resultSet,14));
            prplPayeeInfoDto.setInputDate(dbManager.getString(resultSet,15));
            collection.add(prplPayeeInfoDto);
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
        buffer.append("DELETE FROM PrplPayeeInfo WHERE ");
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
        buffer.append("SELECT count(*) FROM PrplPayeeInfo WHERE ");
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
