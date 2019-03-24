package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLptextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLptext-Ԥ�����ֱ�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.796<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLptextBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLptextBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLptextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void insert(PrpLptextDto prpLptextDto) throws Exception{
        String mainStatement = " Insert Into PrpLptext (" + 
                           " PreCompensateNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLptextDto.getPreCompensateNo() + "'," + 
                           "" + prpLptextDto.getLineNo() + "," + 
                           "'" + prpLptextDto.getContext() + "'," + 
                           "'" + prpLptextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLptextDto.getPreCompensateNo());
        dbManager.setInt(2,prpLptextDto.getLineNo());
        dbManager.setString(3,prpLptextDto.getContext());
        dbManager.setString(4,prpLptextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLptextBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLptext (" + 
                           " PreCompensateNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLptextDto prpLptextDto = (PrpLptextDto)i.next();
            dbManager.setString(1,prpLptextDto.getPreCompensateNo());
            dbManager.setInt(2,prpLptextDto.getLineNo());
            dbManager.setString(3,prpLptextDto.getContext());
            dbManager.setString(4,prpLptextDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLptextBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @param lineNo �к�
     * @throws Exception
     */
    public void delete(String preCompensateNo,int lineNo) throws Exception{
        String statement = " Delete From PrpLptext" + 
	            		   " Where " +
                           " PreCompensateNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLptext Where " +
                           " PreCompensateNo = '" + preCompensateNo + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,preCompensateNo);
        dbManager.setInt(2,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLptextBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLptextDto prpLptextDto
     * @throws Exception
     */
    public void update(PrpLptextDto prpLptextDto) throws Exception{
        String statement = " Update PrpLptext Set Context = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PreCompensateNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLptext Set " + 
                           " PreCompensateNo = '" + prpLptextDto.getPreCompensateNo() + "'," + 
                           " LineNo = " + prpLptextDto.getLineNo() + "," + 
                           " Context = '" + prpLptextDto.getContext() + "'," + 
                           " Flag = '" + prpLptextDto.getFlag() + "'" + 
			               " Where " +
                           " PreCompensateNo = '" + prpLptextDto.getPreCompensateNo() + "' And " + 
                           " LineNo = " + prpLptextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLptextDto.getContext());
        dbManager.setString(2,prpLptextDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpLptextDto.getPreCompensateNo());
        dbManager.setInt(4,prpLptextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLptextBase.update() success!");
    }

    /**
     * ����������һ������
     * @param preCompensateNo Ԥ��ǼǺ�
     * @param lineNo �к�
     * @return PrpLptextDto
     * @throws Exception
     */
    public PrpLptextDto findByPrimaryKey(String preCompensateNo,int lineNo) throws Exception{
        String mainStatement = " Select PreCompensateNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLptext";
        String statement = mainStatement + " Where " +
                           " PreCompensateNo = ? And " + 
                           " LineNo = ?";
        PrpLptextDto prpLptextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PreCompensateNo = '" + preCompensateNo + "' And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,preCompensateNo);
        dbManager.setInt(2,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLptextDto = new PrpLptextDto();
            prpLptextDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLptextDto.setLineNo(dbManager.getInt(resultSet,2));
            prpLptextDto.setContext(dbManager.getString(resultSet,3));
            prpLptextDto.setFlag(dbManager.getString(resultSet,4));
            logger.info("DBPrpLptextBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLptextBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLptextDto;
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
        String statement = "Select PreCompensateNo," + 
                           " LineNo," + 
                           " Context," + 
                           " Flag From PrpLptext Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLptextDto prpLptextDto = null;
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

            prpLptextDto = new PrpLptextDto();
            prpLptextDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLptextDto.setLineNo(dbManager.getInt(resultSet,2));
            prpLptextDto.setContext(dbManager.getString(resultSet,3));
            prpLptextDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpLptextDto);
        }
        resultSet.close();
        logger.info("DBPrpLptextBase.findByConditions() success!");
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
        String statement = "Delete From PrpLptext Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLptextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLptext Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLptextBase.getCount() success!");
        return count;
    }
}
