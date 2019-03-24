package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfModelUseģ��ʹ�����ã������������ݷ��ʶ������<br>
 * ������ 2005-04-26 15:20:31.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBSwfModelUseBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBSwfModelUseBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBSwfModelUseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void insert(SwfModelUseDto swfModelUseDto) throws Exception{
        String mainStatement = " Insert Into SwfModelUse (" + 
                           " ModelNo," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " ModelType," + 
                           " ModelStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
       
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + swfModelUseDto.getModelNo() + "," + 
                           "'" + swfModelUseDto.getRiskCode() + "'," + 
                           "'" + swfModelUseDto.getComCode() + "'," + 
                           "'" + swfModelUseDto.getModelType() + "'," + 
                           "'" + swfModelUseDto.getModelStatus() + "'," + 
                           "'" + swfModelUseDto.getFlag() + "')";
            logger.debug(debugStatement);
            
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,swfModelUseDto.getModelNo());
        dbManager.setString(2,swfModelUseDto.getRiskCode());
        dbManager.setString(3,swfModelUseDto.getComCode());
        dbManager.setString(4,swfModelUseDto.getModelType());
        dbManager.setString(5,swfModelUseDto.getModelStatus());
        dbManager.setString(6,swfModelUseDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfModelUseBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into SwfModelUse (" + 
                           " ModelNo," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " ModelType," + 
                           " ModelStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
           SwfModelUseDto swfModelUseDto = (SwfModelUseDto)i.next();
            dbManager.setInt(1,swfModelUseDto.getModelNo());
            dbManager.setString(2,swfModelUseDto.getRiskCode());
            dbManager.setString(3,swfModelUseDto.getComCode());
            dbManager.setString(4,swfModelUseDto.getModelType());
            dbManager.setString(5,swfModelUseDto.getModelStatus());
            dbManager.setString(6,swfModelUseDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBSwfModelUseBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @throws Exception
     */
    public void delete(int modelNo,String riskCode,String comCode) throws Exception{
        String statement = " Delete From SwfModelUse" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From SwfModelUse Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " RiskCode = '" + riskCode + "' And " + 
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,comCode);
        dbManager.executePreparedUpdate();
        logger.info("DBSwfModelUseBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param swfModelUseDto swfModelUseDto
     * @throws Exception
     */
    public void update(SwfModelUseDto swfModelUseDto) throws Exception{
        String statement = " Update SwfModelUse Set ModelType = ?," + 
                           " ModelStatus = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ModelNo = ? And " + 
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update SwfModelUse Set " + 
                           " ModelNo = " + swfModelUseDto.getModelNo() + "," + 
                           " RiskCode = '" + swfModelUseDto.getRiskCode() + "'," + 
                           " ComCode = '" + swfModelUseDto.getComCode() + "'," + 
                           " ModelType = '" + swfModelUseDto.getModelType() + "'," + 
                           " ModelStatus = '" + swfModelUseDto.getModelStatus() + "'," + 
                           " Flag = '" + swfModelUseDto.getFlag() + "'" + 
			               " Where " +
                           " ModelNo = " + swfModelUseDto.getModelNo() + " And " + 
                           " RiskCode = '" + swfModelUseDto.getRiskCode() + "' And " + 
                           " ComCode = '" + swfModelUseDto.getComCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,swfModelUseDto.getModelType());
        dbManager.setString(2,swfModelUseDto.getModelStatus());
        dbManager.setString(3,swfModelUseDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(4,swfModelUseDto.getModelNo());
        dbManager.setString(5,swfModelUseDto.getRiskCode());
        dbManager.setString(6,swfModelUseDto.getComCode());
        dbManager.executePreparedUpdate();

        logger.info("DBSwfModelUseBase.update() success!");
    }

    /**
     * ����������һ������
     * @param modelNo ģ����
     * @param riskCode ���ִ���
     * @param comCode ���ű���
     * @return SwfModelUseDto
     * @throws Exception
     */
    public SwfModelUseDto findByPrimaryKey(int modelNo,String riskCode,String comCode) throws Exception{
        String mainStatement = " Select ModelNo," + 
                           " RiskCode," + 
                           " ComCode," + 
                           " ModelType," + 
                           " ModelStatus," + 
                           " Flag From SwfModelUse";
        String statement = mainStatement + " Where " +
                           " ModelNo = ? And " + 
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        SwfModelUseDto swfModelUseDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ModelNo = " + modelNo + " And " + 
                           " RiskCode = '" + riskCode + "' And " + 
                           " ComCode = '" + comCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,modelNo);
        dbManager.setString(2,riskCode);
        dbManager.setString(3,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            swfModelUseDto = new SwfModelUseDto();
            swfModelUseDto.setModelNo(dbManager.getInt(resultSet,1));
            swfModelUseDto.setRiskCode(dbManager.getString(resultSet,2));
            swfModelUseDto.setComCode(dbManager.getString(resultSet,3));
            swfModelUseDto.setModelType(dbManager.getString(resultSet,4));
            swfModelUseDto.setModelStatus(dbManager.getString(resultSet,5));
            swfModelUseDto.setFlag(dbManager.getString(resultSet,6));
            logger.info("DBSwfModelUseBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBSwfModelUseBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return swfModelUseDto;
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
                           " RiskCode," + 
                           " ComCode," + 
                           " ModelType," + 
                           " ModelStatus," + 
                           " Flag From SwfModelUse Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        SwfModelUseDto swfModelUseDto = null;
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

            swfModelUseDto = new SwfModelUseDto();
            swfModelUseDto.setModelNo(dbManager.getInt(resultSet,1));
            swfModelUseDto.setRiskCode(dbManager.getString(resultSet,2));
            swfModelUseDto.setComCode(dbManager.getString(resultSet,3));
            swfModelUseDto.setModelType(dbManager.getString(resultSet,4));
            swfModelUseDto.setModelStatus(dbManager.getString(resultSet,5));
            swfModelUseDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(swfModelUseDto);
        }
        resultSet.close();
        logger.info("DBSwfModelUseBase.findByConditions() success!");
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
        String statement = "Delete From SwfModelUse Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBSwfModelUseBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from SwfModelUse Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBSwfModelUseBase.getCount() success!");
        return count;
    }
}
