package com.sinosoft.claimprop.common.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claimprop.common.dto.domain.CiClaimPropUploadLogDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CiClaimPropUploadLog�����ݷ��ʶ������<br>
 * ������ 2017-01-24 15:00:05.687<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCiClaimPropUploadLogBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCiClaimPropUploadLogBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCiClaimPropUploadLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void insert(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CiClaimPropUploadLog (");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("uploadType,");
        buffer.append("claimStatus,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("sendContext,");
        buffer.append("returnContext,");
        buffer.append("failReson,");
        buffer.append("triggerMode,");
        buffer.append("claimCode,");
        buffer.append("policyNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getBusinessNo()).append("',");
            debugBuffer.append("").append(ciClaimPropUploadLogDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getUploadType()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getClaimStatus()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getUploadDate()).append("',");
            debugBuffer.append("").append(ciClaimPropUploadLogDto.getFlag()).append(",");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getSendContext()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getReturnContext()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getFailReson()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getTriggerMode()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(ciClaimPropUploadLogDto.getPolicyNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,ciClaimPropUploadLogDto.getBusinessNo());
        dbManager.setInt(2,ciClaimPropUploadLogDto.getSerialNo());
        dbManager.setString(3,ciClaimPropUploadLogDto.getUploadType());
        dbManager.setString(4,ciClaimPropUploadLogDto.getClaimStatus());
        dbManager.setDateTime(5,ciClaimPropUploadLogDto.getUploadDate());
        dbManager.setInt(6,ciClaimPropUploadLogDto.getFlag());
        dbManager.setString(7,ciClaimPropUploadLogDto.getSendContext());
        dbManager.setString(8,ciClaimPropUploadLogDto.getReturnContext());
        dbManager.setString(9,ciClaimPropUploadLogDto.getFailReson());
        dbManager.setString(10,ciClaimPropUploadLogDto.getTriggerMode());
        dbManager.setString(11,ciClaimPropUploadLogDto.getClaimCode());
        dbManager.setString(12,ciClaimPropUploadLogDto.getPolicyNo());
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
        buffer.append("INSERT INTO CiClaimPropUploadLog (");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("uploadType,");
        buffer.append("claimStatus,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("sendContext,");
        buffer.append("returnContext,");
        buffer.append("failReson,");
        buffer.append("triggerMode,");
        buffer.append("claimCode,");
        buffer.append("policyNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CiClaimPropUploadLogDto ciClaimPropUploadLogDto = (CiClaimPropUploadLogDto)i.next();
            dbManager.setString(1,ciClaimPropUploadLogDto.getBusinessNo());
            dbManager.setInt(2,ciClaimPropUploadLogDto.getSerialNo());
            dbManager.setString(3,ciClaimPropUploadLogDto.getUploadType());
            dbManager.setString(4,ciClaimPropUploadLogDto.getClaimStatus());
            dbManager.setDateTime(5,ciClaimPropUploadLogDto.getUploadDate());
            dbManager.setInt(6,ciClaimPropUploadLogDto.getFlag());
            dbManager.setString(7,ciClaimPropUploadLogDto.getSendContext());
            dbManager.setString(8,ciClaimPropUploadLogDto.getReturnContext());
            dbManager.setString(9,ciClaimPropUploadLogDto.getFailReson());
            dbManager.setString(10,ciClaimPropUploadLogDto.getTriggerMode());
            dbManager.setString(11,ciClaimPropUploadLogDto.getClaimCode());
            dbManager.setString(12,ciClaimPropUploadLogDto.getPolicyNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param businessNo businessNo
     * @throws Exception
     */
    public void delete(String businessNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CiClaimPropUploadLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(businessNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param ciClaimPropUploadLogDto ciClaimPropUploadLogDto
     * @throws Exception
     */
    public void update(CiClaimPropUploadLogDto ciClaimPropUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CiClaimPropUploadLog SET ");
        buffer.append("serialNo = ?, ");
        buffer.append("uploadType = ?, ");
        buffer.append("claimStatus = ?, ");
        buffer.append("uploadDate = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("sendContext = ?, ");
        buffer.append("returnContext = ?, ");
        buffer.append("failReson = ?, ");
        buffer.append("triggerMode = ?, ");
        buffer.append("claimCode = ?, ");
        buffer.append("policyNo = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CiClaimPropUploadLog SET ");
            debugBuffer.append("serialNo = " + ciClaimPropUploadLogDto.getSerialNo() + ", ");
            debugBuffer.append("uploadType = '" + ciClaimPropUploadLogDto.getUploadType() + "', ");
            debugBuffer.append("claimStatus = '" + ciClaimPropUploadLogDto.getClaimStatus() + "', ");
            debugBuffer.append("uploadDate = '" + ciClaimPropUploadLogDto.getUploadDate() + "', ");
            debugBuffer.append("flag = " + ciClaimPropUploadLogDto.getFlag() + ", ");
            debugBuffer.append("sendContext = '" + ciClaimPropUploadLogDto.getSendContext() + "', ");
            debugBuffer.append("returnContext = '" + ciClaimPropUploadLogDto.getReturnContext() + "', ");
            debugBuffer.append("failReson = '" + ciClaimPropUploadLogDto.getFailReson() + "', ");
            debugBuffer.append("triggerMode = '" + ciClaimPropUploadLogDto.getTriggerMode() + "', ");
            debugBuffer.append("claimCode = '" + ciClaimPropUploadLogDto.getClaimCode() + "', ");
            debugBuffer.append("policyNo = '" + ciClaimPropUploadLogDto.getPolicyNo() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(ciClaimPropUploadLogDto.getBusinessNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setInt(1,ciClaimPropUploadLogDto.getSerialNo());
        dbManager.setString(2,ciClaimPropUploadLogDto.getUploadType());
        dbManager.setString(3,ciClaimPropUploadLogDto.getClaimStatus());
        dbManager.setDateTime(4,ciClaimPropUploadLogDto.getUploadDate());
        dbManager.setInt(5,ciClaimPropUploadLogDto.getFlag());
        dbManager.setString(6,ciClaimPropUploadLogDto.getSendContext());
        dbManager.setString(7,ciClaimPropUploadLogDto.getReturnContext());
        dbManager.setString(8,ciClaimPropUploadLogDto.getFailReson());
        dbManager.setString(9,ciClaimPropUploadLogDto.getTriggerMode());
        dbManager.setString(10,ciClaimPropUploadLogDto.getClaimCode());
        dbManager.setString(11,ciClaimPropUploadLogDto.getPolicyNo());
        //���������ֶ�;
        dbManager.setString(12,ciClaimPropUploadLogDto.getBusinessNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param businessNo businessNo
     * @return CiClaimPropUploadLogDto
     * @throws Exception
     */
    public CiClaimPropUploadLogDto findByPrimaryKey(String businessNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("uploadType,");
        buffer.append("claimStatus,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("sendContext,");
        buffer.append("returnContext,");
        buffer.append("failReson,");
        buffer.append("triggerMode,");
        buffer.append("claimCode,");
        buffer.append("policyNo ");
        buffer.append("FROM CiClaimPropUploadLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("businessNo=").append("'").append(businessNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("businessNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,businessNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        if(resultSet.next()){
            ciClaimPropUploadLogDto = new CiClaimPropUploadLogDto();
            ciClaimPropUploadLogDto.setBusinessNo(dbManager.getString(resultSet,1));
            ciClaimPropUploadLogDto.setSerialNo(dbManager.getInt(resultSet,2));
            ciClaimPropUploadLogDto.setUploadType(dbManager.getString(resultSet,3));
            ciClaimPropUploadLogDto.setClaimStatus(dbManager.getString(resultSet,4));
            ciClaimPropUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            ciClaimPropUploadLogDto.setFlag(dbManager.getInt(resultSet,6));
            ciClaimPropUploadLogDto.setSendContext(dbManager.getString(resultSet,7));
            ciClaimPropUploadLogDto.setReturnContext(dbManager.getString(resultSet,8));
            ciClaimPropUploadLogDto.setFailReson(dbManager.getString(resultSet,9));
            ciClaimPropUploadLogDto.setTriggerMode(dbManager.getString(resultSet,10));
            ciClaimPropUploadLogDto.setClaimCode(dbManager.getString(resultSet,11));
            ciClaimPropUploadLogDto.setPolicyNo(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return ciClaimPropUploadLogDto;
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
        buffer.append("businessNo,");
        buffer.append("serialNo,");
        buffer.append("uploadType,");
        buffer.append("claimStatus,");
        buffer.append("uploadDate,");
        buffer.append("flag,");
        buffer.append("sendContext,");
        buffer.append("returnContext,");
        buffer.append("failReson,");
        buffer.append("triggerMode,");
        buffer.append("claimCode,");
        buffer.append("policyNo ");
        buffer.append("FROM CiClaimPropUploadLog WHERE ");
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
        CiClaimPropUploadLogDto ciClaimPropUploadLogDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            ciClaimPropUploadLogDto = new CiClaimPropUploadLogDto();
            ciClaimPropUploadLogDto.setBusinessNo(dbManager.getString(resultSet,1));
            ciClaimPropUploadLogDto.setSerialNo(dbManager.getInt(resultSet,2));
            ciClaimPropUploadLogDto.setUploadType(dbManager.getString(resultSet,3));
            ciClaimPropUploadLogDto.setClaimStatus(dbManager.getString(resultSet,4));
            ciClaimPropUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            ciClaimPropUploadLogDto.setFlag(dbManager.getInt(resultSet,6));
            ciClaimPropUploadLogDto.setSendContext(dbManager.getString(resultSet,7));
            ciClaimPropUploadLogDto.setReturnContext(dbManager.getString(resultSet,8));
            ciClaimPropUploadLogDto.setFailReson(dbManager.getString(resultSet,9));
            ciClaimPropUploadLogDto.setTriggerMode(dbManager.getString(resultSet,10));
            ciClaimPropUploadLogDto.setClaimCode(dbManager.getString(resultSet,11));
            ciClaimPropUploadLogDto.setPolicyNo(dbManager.getString(resultSet,12));
            collection.add(ciClaimPropUploadLogDto);
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
        buffer.append("DELETE FROM CiClaimPropUploadLog WHERE ");
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
        buffer.append("SELECT count(*) FROM CiClaimPropUploadLog WHERE ");
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
