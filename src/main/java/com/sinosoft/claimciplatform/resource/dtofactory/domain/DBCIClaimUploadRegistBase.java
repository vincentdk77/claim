package com.sinosoft.claimciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.domain.CIClaimUploadRegistDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����������Ϣƽ̨�ϴ�ע�������ݷ��ʶ������<br>
 * ������ 2006-06-28 18:16:00.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadRegistBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimUploadRegistBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimUploadRegistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void insert(CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIClaimUploadRegist (");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getUploadNo()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getUploadType()).append("',");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getRegistDate()).append("',");
            debugBuffer.append("").append(cIClaimUploadRegistDto.getFailTimes()).append(",");
            debugBuffer.append("'").append(cIClaimUploadRegistDto.getTriggerMode()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIClaimUploadRegistDto.getUploadNo());
        dbManager.setString(2,cIClaimUploadRegistDto.getBusinessNo());
        dbManager.setString(3,cIClaimUploadRegistDto.getUploadType());
        dbManager.setDateTime(4,cIClaimUploadRegistDto.getRegistDate());
        dbManager.setInt(5,cIClaimUploadRegistDto.getFailTimes());
        dbManager.setString(6,cIClaimUploadRegistDto.getTriggerMode());
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
        buffer.append("INSERT INTO CIClaimUploadRegist (");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIClaimUploadRegistDto cIClaimUploadRegistDto = (CIClaimUploadRegistDto)i.next();
            dbManager.setString(1,cIClaimUploadRegistDto.getUploadNo());
            dbManager.setString(2,cIClaimUploadRegistDto.getBusinessNo());
            dbManager.setString(3,cIClaimUploadRegistDto.getUploadType());
            dbManager.setDateTime(4,cIClaimUploadRegistDto.getRegistDate());
            dbManager.setInt(5,cIClaimUploadRegistDto.getFailTimes());
            dbManager.setString(6,cIClaimUploadRegistDto.getTriggerMode());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param uploadNo �ϴ����
     * @throws Exception
     */
    public void delete(String uploadNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimUploadRegist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,uploadNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param cIClaimUploadRegistDto cIClaimUploadRegistDto
     * @throws Exception
     */
    public void update(CIClaimUploadRegistDto cIClaimUploadRegistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimUploadRegist SET ");
        buffer.append("BusinessNo = ?, ");
        buffer.append("UploadType = ?, ");
        buffer.append("RegistDate = ?, ");
        buffer.append("FailTimes = ?, ");
        buffer.append("TriggerMode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimUploadRegist SET ");
            debugBuffer.append("BusinessNo = '" + cIClaimUploadRegistDto.getBusinessNo() + "', ");
            debugBuffer.append("UploadType = '" + cIClaimUploadRegistDto.getUploadType() + "', ");
            debugBuffer.append("RegistDate = '" + cIClaimUploadRegistDto.getRegistDate() + "', ");
            debugBuffer.append("FailTimes = " + cIClaimUploadRegistDto.getFailTimes() + ", ");
            debugBuffer.append("TriggerMode = '" + cIClaimUploadRegistDto.getTriggerMode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(cIClaimUploadRegistDto.getUploadNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,cIClaimUploadRegistDto.getBusinessNo());
        dbManager.setString(2,cIClaimUploadRegistDto.getUploadType());
        dbManager.setDateTime(3,cIClaimUploadRegistDto.getRegistDate());
        dbManager.setInt(4,cIClaimUploadRegistDto.getFailTimes());
        dbManager.setString(5,cIClaimUploadRegistDto.getTriggerMode());
        //���������ֶ�;
        dbManager.setString(6,cIClaimUploadRegistDto.getUploadNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param uploadNo �ϴ����
     * @return CIClaimUploadRegistDto
     * @throws Exception
     */
    public CIClaimUploadRegistDto findByPrimaryKey(String uploadNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append("FROM CIClaimUploadRegist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,uploadNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        if(resultSet.next()){
            cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
            cIClaimUploadRegistDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadRegistDto.setBusinessNo(dbManager.getString(resultSet,2));
            cIClaimUploadRegistDto.setUploadType(dbManager.getString(resultSet,3));
            cIClaimUploadRegistDto.setRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            cIClaimUploadRegistDto.setFailTimes(dbManager.getInt(resultSet,5));
            cIClaimUploadRegistDto.setTriggerMode(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        return cIClaimUploadRegistDto;
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
        buffer.append("UploadNo,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("RegistDate,");
        buffer.append("FailTimes,");
        buffer.append("TriggerMode ");
        buffer.append("FROM CIClaimUploadRegist WHERE ");
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
        CIClaimUploadRegistDto cIClaimUploadRegistDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIClaimUploadRegistDto = new CIClaimUploadRegistDto();
            cIClaimUploadRegistDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadRegistDto.setBusinessNo(dbManager.getString(resultSet,2));
            cIClaimUploadRegistDto.setUploadType(dbManager.getString(resultSet,3));
            cIClaimUploadRegistDto.setRegistDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,4));
            cIClaimUploadRegistDto.setFailTimes(dbManager.getInt(resultSet,5));
            cIClaimUploadRegistDto.setTriggerMode(dbManager.getString(resultSet,6));
            collection.add(cIClaimUploadRegistDto);
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
        buffer.append("DELETE FROM CIClaimUploadRegist WHERE ");
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
        buffer.append("SELECT count(*) FROM CIClaimUploadRegist WHERE ");
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
