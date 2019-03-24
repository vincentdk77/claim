package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelMainDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfModelMain-ģ�����������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfModelMainBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfModelMainBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfModelMainBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfModelMainDto swfModelMainDto
     * @throws Exception
     */
    public void insert(SwfModelMainDto swfModelMainDto) throws Exception{
        String mainStatement = " Insert Into SwfModelMain (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " AuthorCode," + 
                           " RightId," + 
                           " CreateDate," + 
                           " ModifyDate," + 
                           " ModelType," + 
                           " ModelAttr," + 
                           " ModelStatus," + 
                           " CloseService," + 
                           " ActiveService," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + swfModelMainDto.getModelNo() + "," + 
                           "'" + swfModelMainDto.getModelName() + "'," + 
                           "'" + swfModelMainDto.getAuthorCode() + "'," + 
                           "'" + swfModelMainDto.getRightId() + "'," + 
                           "'" + swfModelMainDto.getCreateDate() + "'," + 
                           "'" + swfModelMainDto.getModifyDate() + "'," + 
                           "'" + swfModelMainDto.getModelType() + "'," + 
                           "'" + swfModelMainDto.getModelAttr() + "'," + 
                           "'" + swfModelMainDto.getModelStatus() + "'," + 
                           "'" + swfModelMainDto.getCloseService() + "'," + 
                           "'" + swfModelMainDto.getActiveService() + "'," + 
                           "'" + swfModelMainDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,swfModelMainDto.getModelNo());
        dbManager.setString(2,swfModelMainDto.getModelName());
        dbManager.setString(3,swfModelMainDto.getAuthorCode());
        dbManager.setString(4,swfModelMainDto.getRightId());
        dbManager.setDateTime(5,swfModelMainDto.getCreateDate());
        dbManager.setDateTime(6,swfModelMainDto.getModifyDate());
        dbManager.setString(7,swfModelMainDto.getModelType());
        dbManager.setString(8,swfModelMainDto.getModelAttr());
        dbManager.setString(9,swfModelMainDto.getModelStatus());
        dbManager.setString(10,swfModelMainDto.getCloseService());
        dbManager.setString(11,swfModelMainDto.getActiveService());
        dbManager.setString(12,swfModelMainDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfModelMainBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfModelMain (" + 
                           " ModelNo," + 
                           " ModelName," + 
                           " AuthorCode," + 
                           " RightId," + 
                           " CreateDate," + 
                           " ModifyDate," + 
                           " ModelType," + 
                           " ModelAttr," + 
                           " ModelStatus," + 
                           " CloseService," + 
                           " ActiveService," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfModelMainDto swfModelMainDto = (SwfModelMainDto)i.next();
            dbManager.setInt(1,swfModelMainDto.getModelNo());
            dbManager.setString(2,swfModelMainDto.getModelName());
            dbManager.setString(3,swfModelMainDto.getAuthorCode());
            dbManager.setString(4,swfModelMainDto.getRightId());
            dbManager.setDateTime(5,swfModelMainDto.getCreateDate());
            dbManager.setDateTime(6,swfModelMainDto.getModifyDate());
            dbManager.setString(7,swfModelMainDto.getModelType());
            dbManager.setString(8,swfModelMainDto.getModelAttr());
            dbManager.setString(9,swfModelMainDto.getModelStatus());
            dbManager.setString(10,swfModelMainDto.getCloseService());
            dbManager.setString(11,swfModelMainDto.getActiveService());
            dbManager.setString(12,swfModelMainDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfModelMainBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param modelNo ModelNo
     * @throws Exception
     */
    public void delete(int modelNo) throws Exception{
        String statement = " Delete From SwfModelMain" + 
	            		   " Where " +
                           " ModelNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfModelMain Where " +
                           " ModelNo = " + modelNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfModelMainBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfModelMainDto swfModelMainDto
     * @throws Exception
     */
    public void update(SwfModelMainDto swfModelMainDto) throws Exception{
        String statement = " Update SwfModelMain Set ModelName = ?," + 
                           " AuthorCode = ?," + 
                           " RightId = ?," + 
                           " CreateDate = ?," + 
                           " ModifyDate = ?," + 
                           " ModelType = ?," + 
                           " ModelAttr = ?," + 
                           " ModelStatus = ?," + 
                           " CloseService = ?," + 
                           " ActiveService = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ModelNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfModelMain Set " + 
                           " ModelNo = " + swfModelMainDto.getModelNo() + "," + 
                           " ModelName = '" + swfModelMainDto.getModelName() + "'," + 
                           " AuthorCode = '" + swfModelMainDto.getAuthorCode() + "'," + 
                           " RightId = '" + swfModelMainDto.getRightId() + "'," + 
                           " CreateDate = '" + swfModelMainDto.getCreateDate() + "'," + 
                           " ModifyDate = '" + swfModelMainDto.getModifyDate() + "'," + 
                           " ModelType = '" + swfModelMainDto.getModelType() + "'," + 
                           " ModelAttr = '" + swfModelMainDto.getModelAttr() + "'," + 
                           " ModelStatus = '" + swfModelMainDto.getModelStatus() + "'," + 
                           " CloseService = '" + swfModelMainDto.getCloseService() + "'," + 
                           " ActiveService = '" + swfModelMainDto.getActiveService() + "'," + 
                           " Flag = '" + swfModelMainDto.getFlag() + "'" + 
			               " Where " +
                           " ModelNo = " + swfModelMainDto.getModelNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfModelMainDto.getModelName());
        dbManager.setString(2,swfModelMainDto.getAuthorCode());
        dbManager.setString(3,swfModelMainDto.getRightId());
        dbManager.setDateTime(4,swfModelMainDto.getCreateDate());
        dbManager.setDateTime(5,swfModelMainDto.getModifyDate());
        dbManager.setString(6,swfModelMainDto.getModelType());
        dbManager.setString(7,swfModelMainDto.getModelAttr());
        dbManager.setString(8,swfModelMainDto.getModelStatus());
        dbManager.setString(9,swfModelMainDto.getCloseService());
        dbManager.setString(10,swfModelMainDto.getActiveService());
        dbManager.setString(11,swfModelMainDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(12,swfModelMainDto.getModelNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfModelMainBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelNo ModelNo
     * @return SwfModelMainDto
     * @throws Exception
     */
    public SwfModelMainDto findByPrimaryKey(int modelNo) throws Exception{
        String mainStatement = " Select ModelNo," + 
                           " ModelName," + 
                           " AuthorCode," + 
                           " RightId," + 
                           " CreateDate," + 
                           " ModifyDate," + 
                           " ModelType," + 
                           " ModelAttr," + 
                           " ModelStatus," + 
                           " CloseService," + 
                           " ActiveService," + 
                           " Flag From SwfModelMain";
        String statement = mainStatement + " Where " +
                           " ModelNo = ?";
        SwfModelMainDto swfModelMainDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ModelNo = " + modelNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfModelMainDto = new SwfModelMainDto();
            swfModelMainDto.setModelNo(dbManager.getInt(resultSet,1));
            swfModelMainDto.setModelName(dbManager.getString(resultSet,2));
            swfModelMainDto.setAuthorCode(dbManager.getString(resultSet,3));
            swfModelMainDto.setRightId(dbManager.getString(resultSet,4));
            swfModelMainDto.setCreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            swfModelMainDto.setModifyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            swfModelMainDto.setModelType(dbManager.getString(resultSet,7));
            swfModelMainDto.setModelAttr(dbManager.getString(resultSet,8));
            swfModelMainDto.setModelStatus(dbManager.getString(resultSet,9));
            swfModelMainDto.setCloseService(dbManager.getString(resultSet,10));
            swfModelMainDto.setActiveService(dbManager.getString(resultSet,11));
            swfModelMainDto.setFlag(dbManager.getString(resultSet,12));
            logger.info("DBSwfModelMainBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfModelMainBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfModelMainDto;
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
        String statement = "Select ModelNo," + 
                           " ModelName," + 
                           " AuthorCode," + 
                           " RightId," + 
                           " CreateDate," + 
                           " ModifyDate," + 
                           " ModelType," + 
                           " ModelAttr," + 
                           " ModelStatus," + 
                           " CloseService," + 
                           " ActiveService," + 
                           " Flag From SwfModelMain Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfModelMainDto swfModelMainDto = null;
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

            swfModelMainDto = new SwfModelMainDto();
            swfModelMainDto.setModelNo(dbManager.getInt(resultSet,1));
            swfModelMainDto.setModelName(dbManager.getString(resultSet,2));
            swfModelMainDto.setAuthorCode(dbManager.getString(resultSet,3));
            swfModelMainDto.setRightId(dbManager.getString(resultSet,4));
            swfModelMainDto.setCreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            swfModelMainDto.setModifyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            swfModelMainDto.setModelType(dbManager.getString(resultSet,7));
            swfModelMainDto.setModelAttr(dbManager.getString(resultSet,8));
            swfModelMainDto.setModelStatus(dbManager.getString(resultSet,9));
            swfModelMainDto.setCloseService(dbManager.getString(resultSet,10));
            swfModelMainDto.setActiveService(dbManager.getString(resultSet,11));
            swfModelMainDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(swfModelMainDto);
        }
        resultSet.close();
        logger.info("DBSwfModelMainBase.findByConditions() success!");
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
        String statement = "Delete From SwfModelMain Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfModelMainBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfModelMain Where " + conditions;
       statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfModelMainBase.getCount() success!");
        return count;
    }
}
