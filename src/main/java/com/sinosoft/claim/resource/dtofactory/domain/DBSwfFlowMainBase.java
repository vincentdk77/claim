package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����SwfFlowMain�����ݷ��ʶ������<br>
 * ������ 2006-12-08 10:02:04.125<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBSwfFlowMainBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBSwfFlowMainBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfFlowMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void insert(SwfFlowMainDto swfFlowMainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO SwfFlowMain (");
        buffer.append("flowID,");
        buffer.append("flowName,");
        buffer.append("flowStatus,");
        buffer.append("policyNo,");
        buffer.append("creatDate,");
        buffer.append("closeDate,");
        buffer.append("modelNo,");
        buffer.append("flag,");
        buffer.append("storeFlag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(swfFlowMainDto.getFlowID()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getFlowName()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getFlowStatus()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getPolicyNo()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getCreatDate()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getCloseDate()).append("',");
            debugBuffer.append("").append(swfFlowMainDto.getModelNo()).append(",");
            debugBuffer.append("'").append(swfFlowMainDto.getFlag()).append("',");
            debugBuffer.append("'").append(swfFlowMainDto.getStoreFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,swfFlowMainDto.getFlowID());
        dbManager.setString(2,swfFlowMainDto.getFlowName());
        dbManager.setString(3,swfFlowMainDto.getFlowStatus());
        dbManager.setString(4,swfFlowMainDto.getPolicyNo());
        dbManager.setDateTime(5,swfFlowMainDto.getCreatDate());
        dbManager.setDateTime(6,swfFlowMainDto.getCloseDate());
        dbManager.setInt(7,swfFlowMainDto.getModelNo());
        dbManager.setString(8,swfFlowMainDto.getFlag());
        dbManager.setString(9,swfFlowMainDto.getStoreFlag());
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
        buffer.append("INSERT INTO SwfFlowMain (");
        buffer.append("flowID,");
        buffer.append("flowName,");
        buffer.append("flowStatus,");
        buffer.append("policyNo,");
        buffer.append("creatDate,");
        buffer.append("closeDate,");
        buffer.append("modelNo,");
        buffer.append("flag,");
        buffer.append("storeFlag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfFlowMainDto swfFlowMainDto = (SwfFlowMainDto)i.next();
            dbManager.setString(1,swfFlowMainDto.getFlowID());
            dbManager.setString(2,swfFlowMainDto.getFlowName());
            dbManager.setString(3,swfFlowMainDto.getFlowStatus());
            dbManager.setString(4,swfFlowMainDto.getPolicyNo());
            dbManager.setDateTime(5,swfFlowMainDto.getCreatDate());
            dbManager.setDateTime(6,swfFlowMainDto.getCloseDate());
            dbManager.setInt(7,swfFlowMainDto.getModelNo());
            dbManager.setString(8,swfFlowMainDto.getFlag());
            dbManager.setString(9,swfFlowMainDto.getStoreFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param flowID flowID
     * @throws Exception
     */
    public void delete(String flowID)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM SwfFlowMain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfFlowMainDto swfFlowMainDto
     * @throws Exception
     */
    public void update(SwfFlowMainDto swfFlowMainDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE SwfFlowMain SET ");
        buffer.append("flowName = ?, ");
        buffer.append("flowStatus = ?, ");
        buffer.append("policyNo = ?, ");
        buffer.append("creatDate = ?, ");
        buffer.append("closeDate = ?, ");
        buffer.append("modelNo = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("storeFlag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE SwfFlowMain SET ");
            debugBuffer.append("flowName = '" + swfFlowMainDto.getFlowName() + "', ");
            debugBuffer.append("flowStatus = '" + swfFlowMainDto.getFlowStatus() + "', ");
            debugBuffer.append("policyNo = '" + swfFlowMainDto.getPolicyNo() + "', ");
            debugBuffer.append("creatDate = '" + swfFlowMainDto.getCreatDate() + "', ");
            debugBuffer.append("closeDate = '" + swfFlowMainDto.getCloseDate() + "', ");
            debugBuffer.append("modelNo = " + swfFlowMainDto.getModelNo() + ", ");
            debugBuffer.append("flag = '" + swfFlowMainDto.getFlag() + "', ");
            debugBuffer.append("storeFlag = '" + swfFlowMainDto.getStoreFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(swfFlowMainDto.getFlowID()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,swfFlowMainDto.getFlowName());
        dbManager.setString(2,swfFlowMainDto.getFlowStatus());
        dbManager.setString(3,swfFlowMainDto.getPolicyNo());
        dbManager.setDateTime(4,swfFlowMainDto.getCreatDate());
        dbManager.setDateTime(5,swfFlowMainDto.getCloseDate());
        dbManager.setInt(6,swfFlowMainDto.getModelNo());
        dbManager.setString(7,swfFlowMainDto.getFlag());
        dbManager.setString(8,swfFlowMainDto.getStoreFlag());
        //���������ֶ�;
        dbManager.setString(9,swfFlowMainDto.getFlowID());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param flowID flowID
     * @return SwfFlowMainDto
     * @throws Exception
     */
    public SwfFlowMainDto findByPrimaryKey(String flowID)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("flowID,");
        buffer.append("flowName,");
        buffer.append("flowStatus,");
        buffer.append("policyNo,");
        buffer.append("creatDate,");
        buffer.append("closeDate,");
        buffer.append("modelNo,");
        buffer.append("flag,");
        buffer.append("storeFlag ");
        buffer.append("FROM SwfFlowMain ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("flowID=").append("'").append(flowID).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("flowID = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,flowID);
        ResultSet resultSet = dbManager.executePreparedQuery();
        SwfFlowMainDto swfFlowMainDto = null;
        if(resultSet.next()){
            swfFlowMainDto = new SwfFlowMainDto();
            swfFlowMainDto.setFlowID(dbManager.getString(resultSet,1));
            swfFlowMainDto.setFlowName(dbManager.getString(resultSet,2));
            swfFlowMainDto.setFlowStatus(dbManager.getString(resultSet,3));
            swfFlowMainDto.setPolicyNo(dbManager.getString(resultSet,4));
            swfFlowMainDto.setCreatDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            swfFlowMainDto.setCloseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            swfFlowMainDto.setModelNo(dbManager.getInt(resultSet,7));
            swfFlowMainDto.setFlag(dbManager.getString(resultSet,8));
            swfFlowMainDto.setStoreFlag(dbManager.getString(resultSet,9));
        }else{
            logger.info("DBSwfFlowMainBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfFlowMainDto;
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
        buffer.append("flowID,");
        buffer.append("flowName,");
        buffer.append("flowStatus,");
        buffer.append("policyNo,");
        buffer.append("creatDate,");
        buffer.append("closeDate,");
        buffer.append("modelNo,");
        buffer.append("flag,");
        buffer.append("storeFlag ");
        buffer.append("FROM SwfFlowMain WHERE ");
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
        SwfFlowMainDto swfFlowMainDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            swfFlowMainDto = new SwfFlowMainDto();
            swfFlowMainDto.setFlowID(dbManager.getString(resultSet,1));
            swfFlowMainDto.setFlowName(dbManager.getString(resultSet,2));
            swfFlowMainDto.setFlowStatus(dbManager.getString(resultSet,3));
            swfFlowMainDto.setPolicyNo(dbManager.getString(resultSet,4));
            swfFlowMainDto.setCreatDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            swfFlowMainDto.setCloseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            swfFlowMainDto.setModelNo(dbManager.getInt(resultSet,7));
            swfFlowMainDto.setFlag(dbManager.getString(resultSet,8));
            swfFlowMainDto.setStoreFlag(dbManager.getString(resultSet,9));
            collection.add(swfFlowMainDto);
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
        buffer.append("DELETE FROM SwfFlowMain WHERE ");
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
         String statement ;
            statement = "SELECT count(1) FROM SwfFlowMain WHERE ";
              statement = SqlUtils.getWherePartForGetCount(statement);
              
        buffer.append(statement);
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
