package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ������ݷ��ʶ������<br>
 * ������ 2005-06-22 14:56:42.040<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaUserBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBEdaUserBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBEdaUserBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void insert(EdaUserDto edaUserDto) throws Exception{
        String mainStatement = " Insert Into EdaUser (" + 
                           " EdaUserCode," + 
                           " EdaUserName," + 
                           " UserCode," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + edaUserDto.getEdaUserCode() + "'," + 
                           "'" + edaUserDto.getEdaUserName() + "'," + 
                           "'" + edaUserDto.getUserCode() + "'," + 
                           "'" + edaUserDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,edaUserDto.getEdaUserCode());
        dbManager.setString(2,edaUserDto.getEdaUserName());
        dbManager.setString(3,edaUserDto.getUserCode());
        dbManager.setString(4,edaUserDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaUserBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            EdaUserDto edaUserDto = (EdaUserDto)i.next();
            insert(edaUserDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param edaUserCode ��ϯԱ����
     * @throws Exception
     */
    public void delete(String edaUserCode) throws Exception{
        String statement = " Delete From EdaUser" + 
	            		   " Where " +
                           " EdaUserCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From EdaUser Where " +
                           " EdaUserCode = '" + edaUserCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,edaUserCode);
        dbManager.executePreparedUpdate();
        logger.info("DBEdaUserBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void update(EdaUserDto edaUserDto) throws Exception{
        String statement = " Update EdaUser Set EdaUserName = ?," + 
                           " UserCode = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " EdaUserCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update EdaUser Set " + 
                           " EdaUserCode = '" + edaUserDto.getEdaUserCode() + "'," + 
                           " EdaUserName = '" + edaUserDto.getEdaUserName() + "'," + 
                           " UserCode = '" + edaUserDto.getUserCode() + "'," + 
                           " Flag = '" + edaUserDto.getFlag() + "'" + 
			               " Where " +
                           " EdaUserCode = '" + edaUserDto.getEdaUserCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,edaUserDto.getEdaUserName());
        dbManager.setString(2,edaUserDto.getUserCode());
        dbManager.setString(3,edaUserDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,edaUserDto.getEdaUserCode());
        dbManager.executePreparedUpdate();

        logger.info("DBEdaUserBase.update() success!");
    }

    /**
     * ����������һ������
     * @param edaUserCode ��ϯԱ����
     * @return EdaUserDto
     * @throws Exception
     */
    public EdaUserDto findByPrimaryKey(String edaUserCode) throws Exception{
    	 
    	String mainStatement = " Select EdaUserCode," + 
                           " EdaUserName," + 
                           " UserCode," + 
                           " Flag From EdaUser";
        String statement = mainStatement + " Where " +
                           " EdaUserCode = ?";
        
        EdaUserDto edaUserDto = null;
        
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EdaUserCode = '" + edaUserCode + "'";
            logger.debug(debugStatement);
        }
      
        
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,edaUserCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            edaUserDto = new EdaUserDto();
            edaUserDto.setEdaUserCode(dbManager.getString(resultSet,1));
            edaUserDto.setEdaUserName(dbManager.getString(resultSet,2));
            edaUserDto.setUserCode(dbManager.getString(resultSet,3));
            edaUserDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        logger.info("DBEdaUserBase.findByPrimaryKey() success!");
        return edaUserDto;
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
        String statement = "Select EdaUserCode," + 
                           " EdaUserName," + 
                           " UserCode," + 
                           " Flag From EdaUser Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        EdaUserDto edaUserDto = null;
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

            edaUserDto = new EdaUserDto();
            edaUserDto.setEdaUserCode(dbManager.getString(resultSet,1));
            edaUserDto.setEdaUserName(dbManager.getString(resultSet,2));
            edaUserDto.setUserCode(dbManager.getString(resultSet,3));
            edaUserDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(edaUserDto);
        }
        resultSet.close();
        logger.info("DBEdaUserBase.findByConditions() success!");
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
        String statement = "Delete From EdaUser Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBEdaUserBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from EdaUser Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBEdaUserBase.getCount() success!");
        return count;
    }
}
