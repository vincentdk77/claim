package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SaBankBranch�����ݷ��ʶ������<br>
 * ������ 2014-06-08 15:30:26.546<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBSaBankBranchBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBSaBankBranchBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSaBankBranchBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void insert(SaBankBranchDto saBankBranchDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO SaBankBranch (");
        buffer.append("bankCode,");
        buffer.append("bankBranchCode,");
        buffer.append("bankBranchCName,");
        buffer.append("thirdType,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(saBankBranchDto.getBankCode()).append("',");
            debugBuffer.append("'").append(saBankBranchDto.getBankBranchCode()).append("',");
            debugBuffer.append("'").append(saBankBranchDto.getBankBranchCName()).append("',");
            debugBuffer.append("'").append(saBankBranchDto.getThirdType()).append("',");
            debugBuffer.append("'").append(saBankBranchDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(saBankBranchDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,saBankBranchDto.getBankCode());
        dbManager.setString(2,saBankBranchDto.getBankBranchCode());
        dbManager.setString(3,saBankBranchDto.getBankBranchCName());
        dbManager.setString(4,saBankBranchDto.getThirdType());
        dbManager.setString(5,saBankBranchDto.getValidStatus());
        dbManager.setString(6,saBankBranchDto.getFlag());
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
        buffer.append("INSERT INTO SaBankBranch (");
        buffer.append("bankCode,");
        buffer.append("bankBranchCode,");
        buffer.append("bankBranchCName,");
        buffer.append("thirdType,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SaBankBranchDto saBankBranchDto = (SaBankBranchDto)i.next();
            dbManager.setString(1,saBankBranchDto.getBankCode());
            dbManager.setString(2,saBankBranchDto.getBankBranchCode());
            dbManager.setString(3,saBankBranchDto.getBankBranchCName());
            dbManager.setString(4,saBankBranchDto.getThirdType());
            dbManager.setString(5,saBankBranchDto.getValidStatus());
            dbManager.setString(6,saBankBranchDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param bankCode bankCode
     * @throws Exception
     */
    public void delete(String bankCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM SaBankBranch ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("bankCode=").append("'").append(bankCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bankCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,bankCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param saBankBranchDto saBankBranchDto
     * @throws Exception
     */
    public void update(SaBankBranchDto saBankBranchDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE SaBankBranch SET ");
        buffer.append("bankBranchCode = ?, ");
        buffer.append("bankBranchCName = ?, ");
        buffer.append("thirdType = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE SaBankBranch SET ");
            debugBuffer.append("bankBranchCode = '" + saBankBranchDto.getBankBranchCode() + "', ");
            debugBuffer.append("bankBranchCName = '" + saBankBranchDto.getBankBranchCName() + "', ");
            debugBuffer.append("thirdType = '" + saBankBranchDto.getThirdType() + "', ");
            debugBuffer.append("validStatus = '" + saBankBranchDto.getValidStatus() + "', ");
            debugBuffer.append("flag = '" + saBankBranchDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("bankCode=").append("'").append(saBankBranchDto.getBankCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bankCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,saBankBranchDto.getBankBranchCode());
        dbManager.setString(2,saBankBranchDto.getBankBranchCName());
        dbManager.setString(3,saBankBranchDto.getThirdType());
        dbManager.setString(4,saBankBranchDto.getValidStatus());
        dbManager.setString(5,saBankBranchDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,saBankBranchDto.getBankCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param bankCode bankCode
     * @return SaBankBranchDto
     * @throws Exception
     */
    public SaBankBranchDto findByPrimaryKey(String bankCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("bankCode,");
        buffer.append("bankBranchCode,");
        buffer.append("bankBranchCName,");
        buffer.append("thirdType,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append("FROM SaBankBranch ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("bankCode=").append("'").append(bankCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bankCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,bankCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        SaBankBranchDto saBankBranchDto = null;
        if(resultSet.next()){
            saBankBranchDto = new SaBankBranchDto();
            saBankBranchDto.setBankCode(dbManager.getString(resultSet,1));
            saBankBranchDto.setBankBranchCode(dbManager.getString(resultSet,2));
            saBankBranchDto.setBankBranchCName(dbManager.getString(resultSet,3));
            saBankBranchDto.setThirdType(dbManager.getString(resultSet,4));
            saBankBranchDto.setValidStatus(dbManager.getString(resultSet,5));
            saBankBranchDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return saBankBranchDto;
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
        buffer.append("bankCode,");
        buffer.append("bankBranchCode,");
        buffer.append("bankBranchCName,");
        buffer.append("thirdType,");
        buffer.append("validStatus,");
        buffer.append("flag ");
        buffer.append("FROM SaBankBranch WHERE ");
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
        SaBankBranchDto saBankBranchDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            saBankBranchDto = new SaBankBranchDto();
            saBankBranchDto.setBankCode(dbManager.getString(resultSet,1));
            saBankBranchDto.setBankBranchCode(dbManager.getString(resultSet,2));
            saBankBranchDto.setBankBranchCName(dbManager.getString(resultSet,3));
            saBankBranchDto.setThirdType(dbManager.getString(resultSet,4));
            saBankBranchDto.setValidStatus(dbManager.getString(resultSet,5));
            saBankBranchDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(saBankBranchDto);
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
        buffer.append("DELETE FROM SaBankBranch WHERE ");
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
        buffer.append("SELECT count(*) FROM SaBankBranch WHERE ");
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
