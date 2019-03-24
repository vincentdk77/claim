package com.sinosoft.AgriXZrequest.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CorrectRequest_Temp�����ݷ��ʶ������<br>
 * ������ 2015-10-28 08:24:42.281<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCorrectRequest_TempBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCorrectRequest_TempBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCorrectRequest_TempBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void insert(CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO CorrectRequest_Temp (");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(correctRequest_TempDto.getBatchNo()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getBusinessNo()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getFlag()).append("',");
            debugBuffer.append("'").append(correctRequest_TempDto.getBusinessType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,correctRequest_TempDto.getBatchNo());
        dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
        dbManager.setString(3,correctRequest_TempDto.getFlag());
        dbManager.setString(4,correctRequest_TempDto.getBusinessType());
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
        buffer.append("INSERT INTO CorrectRequest_Temp (");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CorrectRequest_TempDto correctRequest_TempDto = (CorrectRequest_TempDto)i.next();
            dbManager.setString(1,correctRequest_TempDto.getBatchNo());
            dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
            dbManager.setString(3,correctRequest_TempDto.getFlag());
            dbManager.setString(4,correctRequest_TempDto.getBusinessType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param batchNo batchNo
     * @throws Exception
     */
    public void delete(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM CorrectRequest_Temp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BatchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BatchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,batchNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param correctRequest_TempDto correctRequest_TempDto
     * @throws Exception
     */
    public void update(CorrectRequest_TempDto correctRequest_TempDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE CorrectRequest_Temp SET ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE CorrectRequest_Temp SET ");
            debugBuffer.append("Flag = '" + correctRequest_TempDto.getFlag() + "', ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("BusinessNo=").append("'").append(correctRequest_TempDto.getBusinessNo()).append("'");
            debugBuffer.append("And BusinessType=").append("'").append(correctRequest_TempDto.getBusinessType()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BusinessNo = ? ");
        buffer.append("And BusinessType = ? ");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,correctRequest_TempDto.getFlag());
        //���������ֶ�;
        dbManager.setString(2,correctRequest_TempDto.getBusinessNo());
        dbManager.setString(3,correctRequest_TempDto.getBusinessType());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param batchNo batchNo
     * @return CorrectRequest_TempDto
     * @throws Exception
     */
    public CorrectRequest_TempDto findByPrimaryKey(String batchNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append("FROM CorrectRequest_Temp ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("BatchNo=").append("'").append(batchNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("BatchNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,batchNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CorrectRequest_TempDto correctRequest_TempDto = null;
        if(resultSet.next()){
            correctRequest_TempDto = new CorrectRequest_TempDto();
            correctRequest_TempDto.setBatchNo(dbManager.getString(resultSet,1));
            correctRequest_TempDto.setBusinessNo(dbManager.getString(resultSet,2));
            correctRequest_TempDto.setFlag(dbManager.getString(resultSet,3));
            correctRequest_TempDto.setBusinessType(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        return correctRequest_TempDto;
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
        buffer.append("BatchNo,");
        buffer.append("BusinessNo,");
        buffer.append("Flag,");
        buffer.append("BusinessType ");
        buffer.append("FROM CorrectRequest_Temp WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //Ŀǰֻ��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        CorrectRequest_TempDto correctRequest_TempDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            correctRequest_TempDto = new CorrectRequest_TempDto();
            correctRequest_TempDto.setBatchNo(dbManager.getString(resultSet,1));
            correctRequest_TempDto.setBusinessNo(dbManager.getString(resultSet,2));
            correctRequest_TempDto.setFlag(dbManager.getString(resultSet,3));
            correctRequest_TempDto.setBusinessType(dbManager.getString(resultSet,4));
            collection.add(correctRequest_TempDto);
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
        buffer.append("DELETE FROM CorrectRequest_Temp WHERE ");
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
        buffer.append("SELECT count(*) FROM (SELECT * FROM CorrectRequest_Temp WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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
