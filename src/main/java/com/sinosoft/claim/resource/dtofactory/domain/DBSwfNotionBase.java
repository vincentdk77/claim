package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ǹ�����������������ݷ��ʶ������<br>
 * ������ 2005-04-05 10:45:03.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfNotionBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfNotionBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfNotionBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void insert(SwfNotionDto swfNotionDto) throws Exception{
        String mainStatement = " Insert Into SwfNotion (" + 
                           " FlowID," + 
                           " LogNo," + 
                           " LineNo," + 
                           " HandleText," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + swfNotionDto.getFlowID() + "'," + 
                           "" + swfNotionDto.getLogNo() + "," + 
                           "" + swfNotionDto.getLineNo() + "," + 
                           "'" + swfNotionDto.getHandleText() + "'," + 
                           "'" + swfNotionDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,swfNotionDto.getFlowID());
        dbManager.setInt(2,swfNotionDto.getLogNo());
        dbManager.setInt(3,swfNotionDto.getLineNo());
        dbManager.setString(4,swfNotionDto.getHandleText());
        dbManager.setString(5,swfNotionDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfNotionBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfNotion (" + 
                           " FlowID," + 
                           " LogNo," + 
                           " LineNo," + 
                           " HandleText," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            SwfNotionDto swfNotionDto = (SwfNotionDto)i.next();
            dbManager.setString(1,swfNotionDto.getFlowID());
            dbManager.setInt(2,swfNotionDto.getLogNo());
            dbManager.setInt(3,swfNotionDto.getLineNo());
            dbManager.setString(4,swfNotionDto.getHandleText());
            dbManager.setString(5,swfNotionDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfNotionBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String flowID,int logNo,int lineNo) throws Exception{
        String statement = " Delete From SwfNotion" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfNotion Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " LogNo = " + logNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,logNo);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfNotionBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfNotionDto swfNotionDto
     * @throws Exception
     */
    public void update(SwfNotionDto swfNotionDto) throws Exception{
        String statement = " Update SwfNotion Set HandleText = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfNotion Set " + 
                           " FlowID = '" + swfNotionDto.getFlowID() + "'," + 
                           " LogNo = " + swfNotionDto.getLogNo() + "," + 
                           " LineNo = " + swfNotionDto.getLineNo() + "," + 
                           " HandleText = '" + swfNotionDto.getHandleText() + "'," + 
                           " Flag = '" + swfNotionDto.getFlag() + "'" + 
			               " Where " +
                           " FlowID = '" + swfNotionDto.getFlowID() + "' And " + 
                           " LogNo = " + swfNotionDto.getLogNo() + " And " + 
                           " LineNo = " + swfNotionDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfNotionDto.getHandleText());
        dbManager.setString(2,swfNotionDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,swfNotionDto.getFlowID());
        dbManager.setInt(4,swfNotionDto.getLogNo());
        dbManager.setInt(5,swfNotionDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfNotionBase.update() success!");
    }

    /**
     * ����������һ������
     * @param flowID ������ID
     * @param logNo ��־���
     * @param lineNo �к�
     * @return SwfNotionDto
     * @throws Exception
     */
    public SwfNotionDto findByPrimaryKey(String flowID,int logNo,int lineNo) throws Exception{
        String mainStatement = " Select FlowID," + 
                           " LogNo," + 
                           " LineNo," + 
                           " HandleText," + 
                           " Flag From SwfNotion";
        String statement = mainStatement + " Where " +
                           " FlowID = ? And " + 
                           " LogNo = ? And " + 
                           " LineNo = ?";
        SwfNotionDto swfNotionDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " FlowID = '" + flowID + "' And " + 
                           " LogNo = " + logNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,flowID);
        dbManager.setInt(2,logNo);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfNotionDto = new SwfNotionDto();
            swfNotionDto.setFlowID(dbManager.getString(resultSet,1));
            swfNotionDto.setLogNo(dbManager.getInt(resultSet,2));
            swfNotionDto.setLineNo(dbManager.getInt(resultSet,3));
            swfNotionDto.setHandleText(dbManager.getString(resultSet,4));
            swfNotionDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBSwfNotionBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfNotionBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfNotionDto;
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
        String statement = "Select FlowID," + 
                           " LogNo," + 
                           " LineNo," + 
                           " HandleText," + 
                           " Flag From SwfNotion Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfNotionDto swfNotionDto = null;
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

            swfNotionDto = new SwfNotionDto();
            swfNotionDto.setFlowID(dbManager.getString(resultSet,1));
            swfNotionDto.setLogNo(dbManager.getInt(resultSet,2));
            swfNotionDto.setLineNo(dbManager.getInt(resultSet,3));
            swfNotionDto.setHandleText(dbManager.getString(resultSet,4));
            swfNotionDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(swfNotionDto);
        }
        resultSet.close();
        logger.info("DBSwfNotionBase.findByConditions() success!");
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
        String statement = "Delete From SwfNotion Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfNotionBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfNotion Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfNotionBase.getCount() success!");
        return count;
    }
}
