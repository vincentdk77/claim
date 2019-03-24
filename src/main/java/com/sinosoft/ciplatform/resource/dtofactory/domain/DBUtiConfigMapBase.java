package com.sinosoft.ciplatform.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;

import com.sinosoft.ciplatform.dto.domain.UtiConfigMapDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ������ҵ��ƽ̨���ñ�����ݷ��ʶ������<br>
 * ������ 2010-09-01 10:52:44.328<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBUtiConfigMapBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBUtiConfigMapBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiConfigMapBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void insert(UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO UtiConfigMap (");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(utiConfigMapDto.getSystemName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getClassName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getMapName()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getKeyValue()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getValue()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getFlag()).append("',");
            debugBuffer.append("'").append(utiConfigMapDto.getInputDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,utiConfigMapDto.getSystemName());
        dbManager.setString(2,utiConfigMapDto.getClassName());
        dbManager.setString(3,utiConfigMapDto.getMapName());
        dbManager.setString(4,utiConfigMapDto.getKeyValue());
        dbManager.setString(5,utiConfigMapDto.getValue());
        dbManager.setString(6,utiConfigMapDto.getValidStatus());
        dbManager.setString(7,utiConfigMapDto.getFlag());
        dbManager.setDateTime(8,utiConfigMapDto.getInputDate());
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
        buffer.append("INSERT INTO UtiConfigMap (");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            UtiConfigMapDto utiConfigMapDto = (UtiConfigMapDto)i.next();
            dbManager.setString(1,utiConfigMapDto.getSystemName());
            dbManager.setString(2,utiConfigMapDto.getClassName());
            dbManager.setString(3,utiConfigMapDto.getMapName());
            dbManager.setString(4,utiConfigMapDto.getKeyValue());
            dbManager.setString(5,utiConfigMapDto.getValue());
            dbManager.setString(6,utiConfigMapDto.getValidStatus());
            dbManager.setString(7,utiConfigMapDto.getFlag());
            dbManager.setDateTime(8,utiConfigMapDto.getInputDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param systemName ϵͳ��
     * @param className ����
     * @param mapName HashMap��
     * @param keyValue ��
     * @throws Exception
     */
    public void delete(String systemName,String className,String mapName,String keyValue)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM UtiConfigMap ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(systemName).append("' AND ");
            debugBuffer.append("className=").append("'").append(className).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(mapName).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(keyValue).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,systemName);
        dbManager.setString(2,className);
        dbManager.setString(3,mapName);
        dbManager.setString(4,keyValue);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiConfigMapDto utiConfigMapDto
     * @throws Exception
     */
    public void update(UtiConfigMapDto utiConfigMapDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE UtiConfigMap SET ");
        buffer.append("value = ?, ");
        buffer.append("validStatus = ?, ");
        buffer.append("flag = ?, ");
        buffer.append("inputDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE UtiConfigMap SET ");
            debugBuffer.append("value = '" + utiConfigMapDto.getValue() + "', ");
            debugBuffer.append("validStatus = '" + utiConfigMapDto.getValidStatus() + "', ");
            debugBuffer.append("flag = '" + utiConfigMapDto.getFlag() + "', ");
            debugBuffer.append("inputDate = '" + utiConfigMapDto.getInputDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(utiConfigMapDto.getSystemName()).append("' AND ");
            debugBuffer.append("className=").append("'").append(utiConfigMapDto.getClassName()).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(utiConfigMapDto.getMapName()).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(utiConfigMapDto.getKeyValue()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,utiConfigMapDto.getValue());
        dbManager.setString(2,utiConfigMapDto.getValidStatus());
        dbManager.setString(3,utiConfigMapDto.getFlag());
        dbManager.setDateTime(4,utiConfigMapDto.getInputDate());
        //���������ֶ�;
        dbManager.setString(5,utiConfigMapDto.getSystemName());
        dbManager.setString(6,utiConfigMapDto.getClassName());
        dbManager.setString(7,utiConfigMapDto.getMapName());
        dbManager.setString(8,utiConfigMapDto.getKeyValue());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param systemName ϵͳ��
     * @param className ����
     * @param mapName HashMap��
     * @param keyValue ��
     * @return UtiConfigMapDto
     * @throws Exception
     */
    public UtiConfigMapDto findByPrimaryKey(String systemName,String className,String mapName,String keyValue)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append("FROM UtiConfigMap ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("systemName=").append("'").append(systemName).append("' AND ");
            debugBuffer.append("className=").append("'").append(className).append("' AND ");
            debugBuffer.append("mapName=").append("'").append(mapName).append("' AND ");
            debugBuffer.append("keyValue=").append("'").append(keyValue).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("systemName = ? And ");
        buffer.append("className = ? And ");
        buffer.append("mapName = ? And ");
        buffer.append("keyValue = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,systemName);
        dbManager.setString(2,className);
        dbManager.setString(3,mapName);
        dbManager.setString(4,keyValue);
        ResultSet resultSet = dbManager.executePreparedQuery();
        UtiConfigMapDto utiConfigMapDto = null;
        if(resultSet.next()){
            utiConfigMapDto = new UtiConfigMapDto();
            utiConfigMapDto.setSystemName(dbManager.getString(resultSet,1));
            utiConfigMapDto.setClassName(dbManager.getString(resultSet,2));
            utiConfigMapDto.setMapName(dbManager.getString(resultSet,3));
            utiConfigMapDto.setKeyValue(dbManager.getString(resultSet,4));
            utiConfigMapDto.setValue(dbManager.getString(resultSet,5));
            utiConfigMapDto.setValidStatus(dbManager.getString(resultSet,6));
            utiConfigMapDto.setFlag(dbManager.getString(resultSet,7));
            utiConfigMapDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
        }
        resultSet.close();
        return utiConfigMapDto;
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
        buffer.append("systemName,");
        buffer.append("className,");
        buffer.append("mapName,");
        buffer.append("keyValue,");
        buffer.append("value,");
        buffer.append("validStatus,");
        buffer.append("flag,");
        buffer.append("inputDate ");
        buffer.append("FROM UtiConfigMap WHERE ");
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
        UtiConfigMapDto utiConfigMapDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            utiConfigMapDto = new UtiConfigMapDto();
            utiConfigMapDto.setSystemName(dbManager.getString(resultSet,1));
            utiConfigMapDto.setClassName(dbManager.getString(resultSet,2));
            utiConfigMapDto.setMapName(dbManager.getString(resultSet,3));
            utiConfigMapDto.setKeyValue(dbManager.getString(resultSet,4));
            utiConfigMapDto.setValue(dbManager.getString(resultSet,5));
            utiConfigMapDto.setValidStatus(dbManager.getString(resultSet,6));
            utiConfigMapDto.setFlag(dbManager.getString(resultSet,7));
            utiConfigMapDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            collection.add(utiConfigMapDto);
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
        buffer.append("DELETE FROM UtiConfigMap WHERE ");
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
        buffer.append("SELECT count(*) FROM UtiConfigMap WHERE ");
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
