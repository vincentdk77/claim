package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.ciplatform.dto.domain.CIClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CIClaimUploadLog-������Ϣ�ϴ�ƽ̨��־������ݷ��ʶ������<br>
 * ������ 2006-07-04 20:03:17.562<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCIClaimUploadLogBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBCIClaimUploadLogBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCIClaimUploadLogBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void insert(CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CIClaimUploadLog (");
        buffer.append("UploadNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCode,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("UploadDate,");
        buffer.append("Flag,");
        buffer.append("ErrorCode,");
        buffer.append("Errorname,");
        buffer.append("UploadWay ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getUploadNo()).append("',");
            debugBuffer.append("").append(cIClaimUploadLogDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getClaimCode()).append("',");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getUploadType()).append("',");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getUploadDate()).append("',");
            debugBuffer.append("").append(cIClaimUploadLogDto.getFlag()).append(",");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getErrorCode()).append("',");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getErrorname()).append("',");
            debugBuffer.append("'").append(cIClaimUploadLogDto.getUploadWay()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,cIClaimUploadLogDto.getUploadNo());
        dbManager.setInt(2,cIClaimUploadLogDto.getSerialNo());
        dbManager.setString(3,cIClaimUploadLogDto.getClaimCode());
        dbManager.setString(4,cIClaimUploadLogDto.getBusinessNo());
        dbManager.setString(5,cIClaimUploadLogDto.getUploadType());
        dbManager.setDateTime(6,cIClaimUploadLogDto.getUploadDate());
        dbManager.setInt(7,cIClaimUploadLogDto.getFlag());
        dbManager.setString(8,cIClaimUploadLogDto.getErrorCode());
        dbManager.setString(9,cIClaimUploadLogDto.getErrorname());
        dbManager.setString(10,cIClaimUploadLogDto.getUploadWay());
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
        buffer.append("INSERT INTO CIClaimUploadLog (");
        buffer.append("UploadNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCode,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("UploadDate,");
        buffer.append("Flag,");
        buffer.append("ErrorCode,");
        buffer.append("Errorname,");
        buffer.append("UploadWay ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CIClaimUploadLogDto cIClaimUploadLogDto = (CIClaimUploadLogDto)i.next();
            dbManager.setString(1,cIClaimUploadLogDto.getUploadNo());
            dbManager.prepareStatement(buffer.toString());
            dbManager.setInt(2,cIClaimUploadLogDto.getSerialNo());
            dbManager.setString(3,cIClaimUploadLogDto.getClaimCode());
            dbManager.setString(4,cIClaimUploadLogDto.getBusinessNo());
            dbManager.setString(5,cIClaimUploadLogDto.getUploadType());
            dbManager.setDateTime(6,cIClaimUploadLogDto.getUploadDate());
            dbManager.setInt(7,cIClaimUploadLogDto.getFlag());
            dbManager.setString(8,cIClaimUploadLogDto.getErrorCode());
            dbManager.setString(9,cIClaimUploadLogDto.getErrorname());
            dbManager.setString(10,cIClaimUploadLogDto.getUploadWay());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param uploadNo �ϴ����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String uploadNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CIClaimUploadLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,uploadNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param cIClaimUploadLogDto cIClaimUploadLogDto
     * @throws Exception
     */
    public void update(CIClaimUploadLogDto cIClaimUploadLogDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CIClaimUploadLog SET ");
        buffer.append("claimCode,");
        buffer.append("BusinessNo = ?, ");
        buffer.append("UploadType = ?, ");
        buffer.append("UploadDate = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("ErrorCode = ?, ");
        buffer.append("Errorname = ?, ");
        buffer.append("UploadWay = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CIClaimUploadLog SET ");
            debugBuffer.append("claimCode = '" + cIClaimUploadLogDto.getClaimCode() + "', ");
            debugBuffer.append("BusinessNo = '" + cIClaimUploadLogDto.getBusinessNo() + "', ");
            debugBuffer.append("UploadType = '" + cIClaimUploadLogDto.getUploadType() + "', ");
            debugBuffer.append("UploadDate = '" + cIClaimUploadLogDto.getUploadDate() + "', ");
            debugBuffer.append("Flag = " + cIClaimUploadLogDto.getFlag() + ", ");
            debugBuffer.append("ErrorCode = '" + cIClaimUploadLogDto.getErrorCode() + "', ");
            debugBuffer.append("Errorname = '" + cIClaimUploadLogDto.getErrorname() + "', ");
            debugBuffer.append("UploadWay = '" + cIClaimUploadLogDto.getErrorname() + "', ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Uploadno=").append("'").append(cIClaimUploadLogDto.getClaimCode()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(cIClaimUploadLogDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,cIClaimUploadLogDto.getClaimCode());
        dbManager.setString(2,cIClaimUploadLogDto.getBusinessNo());
        dbManager.setString(3,cIClaimUploadLogDto.getUploadType());
        dbManager.setDateTime(4,cIClaimUploadLogDto.getUploadDate());
        dbManager.setInt(5,cIClaimUploadLogDto.getFlag());
        dbManager.setString(6,cIClaimUploadLogDto.getErrorCode());
        dbManager.setString(7,cIClaimUploadLogDto.getErrorname());
        dbManager.setString(8,cIClaimUploadLogDto.getUploadWay());
        //���������ֶ�;
        dbManager.setString(9,cIClaimUploadLogDto.getUploadNo());
        dbManager.setInt(10,cIClaimUploadLogDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param uploadNo �ϴ����
     * @param serialNo ˳���
     * @return CIClaimUploadLogDto
     * @throws Exception
     */
    public CIClaimUploadLogDto findByPrimaryKey(String uploadNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("UploadNo,");
        buffer.append("SerialNo,");
        buffer.append("ClaimCode,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("UploadDate,");
        buffer.append("Flag,");
        buffer.append("ErrorCode,");
        buffer.append("Errorname,");
        buffer.append("UploadWay ");
        buffer.append("FROM CIClaimUploadLog ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("UploadNo=").append("'").append(uploadNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("UploadNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,uploadNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CIClaimUploadLogDto cIClaimUploadLogDto = null;
        if(resultSet.next()){
            cIClaimUploadLogDto = new CIClaimUploadLogDto();
            cIClaimUploadLogDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadLogDto.setSerialNo(dbManager.getInt(resultSet,2));
            cIClaimUploadLogDto.setClaimCode(dbManager.getString(resultSet,3));
            cIClaimUploadLogDto.setBusinessNo(dbManager.getString(resultSet,4));
            cIClaimUploadLogDto.setUploadType(dbManager.getString(resultSet,5));
            cIClaimUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            cIClaimUploadLogDto.setFlag(dbManager.getInt(resultSet,7));
            cIClaimUploadLogDto.setErrorCode(dbManager.getString(resultSet,8));
            cIClaimUploadLogDto.setErrorname(dbManager.getString(resultSet,9));
            cIClaimUploadLogDto.setUploadWay(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        return cIClaimUploadLogDto;
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
        buffer.append("SerialNo,");
        buffer.append("ClaimCode,");
        buffer.append("BusinessNo,");
        buffer.append("UploadType,");
        buffer.append("UploadDate,");
        buffer.append("Flag,");
        buffer.append("ErrorCode,");
        buffer.append("Errorname,");
        buffer.append("UploadWay ");
        buffer.append("FROM CIClaimUploadLog WHERE ");
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
        CIClaimUploadLogDto cIClaimUploadLogDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            cIClaimUploadLogDto = new CIClaimUploadLogDto();
            cIClaimUploadLogDto.setUploadNo(dbManager.getString(resultSet,1));
            cIClaimUploadLogDto.setSerialNo(dbManager.getInt(resultSet,2));
            cIClaimUploadLogDto.setClaimCode(dbManager.getString(resultSet,3));
            cIClaimUploadLogDto.setBusinessNo(dbManager.getString(resultSet,4));
            cIClaimUploadLogDto.setUploadType(dbManager.getString(resultSet,5));
            cIClaimUploadLogDto.setUploadDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            cIClaimUploadLogDto.setFlag(dbManager.getInt(resultSet,7));
            cIClaimUploadLogDto.setErrorCode(dbManager.getString(resultSet,8));
            cIClaimUploadLogDto.setErrorname(dbManager.getString(resultSet,9));
            cIClaimUploadLogDto.setUploadWay(dbManager.getString(resultSet,10));
            collection.add(cIClaimUploadLogDto);
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
        buffer.append("DELETE FROM CIClaimUploadLog WHERE ");
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
        buffer.append("SELECT count(*) FROM CIClaimUploadLog WHERE ");
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
