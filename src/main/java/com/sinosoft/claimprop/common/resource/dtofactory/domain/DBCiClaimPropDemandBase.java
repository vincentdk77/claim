package com.sinosoft.claimprop.common.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropDemandDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropDemand�����ݷ��ʶ������<br>
 * ������ 2017-01-24 15:00:05.656<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimPropDemandBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCiClaimPropDemandBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimPropDemandBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void insert(CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CiClaimPropDemand (");
        buffer.append("claimCode,");
        buffer.append("cancellationNo,");
        buffer.append("policyNo,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("registUploadFlag,");
        buffer.append("claimUploadFlag,");
        buffer.append("endCaseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("endAddcode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getCancellationNo()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getRegistUploadFlag()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getClaimUploadFlag()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getEndCaseUploadFlag()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getCancelUploadFlag()).append("',");
            debugBuffer.append("'").append(ciClaimPropDemandDto.getEndAddcode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,ciClaimPropDemandDto.getClaimCode());
        dbManager.setString(2,ciClaimPropDemandDto.getCancellationNo());
        dbManager.setString(3,ciClaimPropDemandDto.getPolicyNo());
        dbManager.setString(4,ciClaimPropDemandDto.getRegistNo());
        dbManager.setString(5,ciClaimPropDemandDto.getClaimNo());
        dbManager.setString(6,ciClaimPropDemandDto.getRegistUploadFlag());
        dbManager.setString(7,ciClaimPropDemandDto.getClaimUploadFlag());
        dbManager.setString(8,ciClaimPropDemandDto.getEndCaseUploadFlag());
        dbManager.setString(9,ciClaimPropDemandDto.getCancelUploadFlag());
        dbManager.setString(10,ciClaimPropDemandDto.getEndAddcode());
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
        buffer.append("INSERT INTO CiClaimPropDemand (");
        buffer.append("claimCode,");
        buffer.append("cancellationNo,");
        buffer.append("policyNo,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("registUploadFlag,");
        buffer.append("claimUploadFlag,");
        buffer.append("endCaseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("endAddcode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CiClaimPropDemandDto ciClaimPropDemandDto = (CiClaimPropDemandDto)i.next();
            dbManager.setString(1,ciClaimPropDemandDto.getClaimCode());
            dbManager.setString(2,ciClaimPropDemandDto.getCancellationNo());
            dbManager.setString(3,ciClaimPropDemandDto.getPolicyNo());
            dbManager.setString(4,ciClaimPropDemandDto.getRegistNo());
            dbManager.setString(5,ciClaimPropDemandDto.getClaimNo());
            dbManager.setString(6,ciClaimPropDemandDto.getRegistUploadFlag());
            dbManager.setString(7,ciClaimPropDemandDto.getClaimUploadFlag());
            dbManager.setString(8,ciClaimPropDemandDto.getEndCaseUploadFlag());
            dbManager.setString(9,ciClaimPropDemandDto.getCancelUploadFlag());
            dbManager.setString(10,ciClaimPropDemandDto.getEndAddcode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param claimCode claimCode
     * @throws Exception
     */
    public void delete(String claimCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CiClaimPropDemand ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(claimCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("claimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,claimCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param ciClaimPropDemandDto ciClaimPropDemandDto
     * @throws Exception
     */
    public void update(CiClaimPropDemandDto ciClaimPropDemandDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CiClaimPropDemand SET ");
        buffer.append("cancellationNo = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("registNo = ?, ");
        buffer.append("claimNo = ?, ");
        buffer.append("registUploadFlag = ?, ");
        buffer.append("claimUploadFlag = ?, ");
        buffer.append("endCaseUploadFlag = ?, ");
        buffer.append("cancelUploadFlag = ?, ");
        buffer.append("endAddcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CiClaimPropDemand SET ");
            debugBuffer.append("cancellationNo = '" + ciClaimPropDemandDto.getCancellationNo() + "', ");
            debugBuffer.append("policyNo = '" + ciClaimPropDemandDto.getPolicyNo() + "', ");
            debugBuffer.append("registNo = '" + ciClaimPropDemandDto.getRegistNo() + "', ");
            debugBuffer.append("claimNo = '" + ciClaimPropDemandDto.getClaimNo() + "', ");
            debugBuffer.append("registUploadFlag = '" + ciClaimPropDemandDto.getRegistUploadFlag() + "', ");
            debugBuffer.append("claimUploadFlag = '" + ciClaimPropDemandDto.getClaimUploadFlag() + "', ");
            debugBuffer.append("endCaseUploadFlag = '" + ciClaimPropDemandDto.getEndCaseUploadFlag() + "', ");
            debugBuffer.append("cancelUploadFlag = '" + ciClaimPropDemandDto.getCancelUploadFlag() + "', ");
            debugBuffer.append("endAddcode = '" + ciClaimPropDemandDto.getEndAddcode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(ciClaimPropDemandDto.getClaimCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("claimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,ciClaimPropDemandDto.getCancellationNo());
        dbManager.setString(2,ciClaimPropDemandDto.getPolicyNo());
        dbManager.setString(3,ciClaimPropDemandDto.getRegistNo());
        dbManager.setString(4,ciClaimPropDemandDto.getClaimNo());
        dbManager.setString(5,ciClaimPropDemandDto.getRegistUploadFlag());
        dbManager.setString(6,ciClaimPropDemandDto.getClaimUploadFlag());
        dbManager.setString(7,ciClaimPropDemandDto.getEndCaseUploadFlag());
        dbManager.setString(8,ciClaimPropDemandDto.getCancelUploadFlag());
        dbManager.setString(9,ciClaimPropDemandDto.getEndAddcode());
        //���������ֶ�;
        dbManager.setString(10,ciClaimPropDemandDto.getClaimCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param claimCode claimCode
     * @return CiClaimPropDemandDto
     * @throws Exception
     */
    public CiClaimPropDemandDto findByPrimaryKey(String claimCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("claimCode,");
        buffer.append("cancellationNo,");
        buffer.append("policyNo,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("registUploadFlag,");
        buffer.append("claimUploadFlag,");
        buffer.append("endCaseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("endAddcode ");
        buffer.append("FROM CiClaimPropDemand ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("claimCode=").append("'").append(claimCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("claimCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,claimCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        if(resultSet.next()){
            ciClaimPropDemandDto = new CiClaimPropDemandDto();
            ciClaimPropDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            ciClaimPropDemandDto.setCancellationNo(dbManager.getString(resultSet,2));
            ciClaimPropDemandDto.setPolicyNo(dbManager.getString(resultSet,3));
            ciClaimPropDemandDto.setRegistNo(dbManager.getString(resultSet,4));
            ciClaimPropDemandDto.setClaimNo(dbManager.getString(resultSet,5));
            ciClaimPropDemandDto.setRegistUploadFlag(dbManager.getString(resultSet,6));
            ciClaimPropDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,7));
            ciClaimPropDemandDto.setEndCaseUploadFlag(dbManager.getString(resultSet,8));
            ciClaimPropDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,9));
            ciClaimPropDemandDto.setEndAddcode(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return ciClaimPropDemandDto;
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
        buffer.append("claimCode,");
        buffer.append("cancellationNo,");
        buffer.append("policyNo,");
        buffer.append("registNo,");
        buffer.append("claimNo,");
        buffer.append("registUploadFlag,");
        buffer.append("claimUploadFlag,");
        buffer.append("endCaseUploadFlag,");
        buffer.append("cancelUploadFlag,");
        buffer.append("endAddcode ");
        buffer.append("FROM CiClaimPropDemand WHERE ");
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
        CiClaimPropDemandDto ciClaimPropDemandDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            ciClaimPropDemandDto = new CiClaimPropDemandDto();
            ciClaimPropDemandDto.setClaimCode(dbManager.getString(resultSet,1));
            ciClaimPropDemandDto.setCancellationNo(dbManager.getString(resultSet,2));
            ciClaimPropDemandDto.setPolicyNo(dbManager.getString(resultSet,3));
            ciClaimPropDemandDto.setRegistNo(dbManager.getString(resultSet,4));
            ciClaimPropDemandDto.setClaimNo(dbManager.getString(resultSet,5));
            ciClaimPropDemandDto.setRegistUploadFlag(dbManager.getString(resultSet,6));
            ciClaimPropDemandDto.setClaimUploadFlag(dbManager.getString(resultSet,7));
            ciClaimPropDemandDto.setEndCaseUploadFlag(dbManager.getString(resultSet,8));
            ciClaimPropDemandDto.setCancelUploadFlag(dbManager.getString(resultSet,9));
            ciClaimPropDemandDto.setEndAddcode(dbManager.getString(resultSet,10));
            collection.add(ciClaimPropDemandDto);
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
        buffer.append("DELETE FROM CiClaimPropDemand WHERE ");
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
        buffer.append("SELECT count(*) FROM CiClaimPropDemand WHERE ");
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
