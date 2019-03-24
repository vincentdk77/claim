package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimApprov-��������ת��ȷ�ϱ�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.234<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLclaimApprovBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLclaimApprovBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLclaimApprovBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void insert(PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        String mainStatement = " Insert Into PrpLclaimApprov (" + 
                           " RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLclaimApprovDto.getRegistNo() + "'," + 
                           "'" + prpLclaimApprovDto.getApproverCode() + "'," + 
                           "'" + prpLclaimApprovDto.getApprovDate() + "'," + 
                           "'" + prpLclaimApprovDto.getTransferStatus() + "'," + 
                           "'" + prpLclaimApprovDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLclaimApprovDto.getRegistNo());
        dbManager.setString(2,prpLclaimApprovDto.getApproverCode());
        dbManager.setDateTime(3,prpLclaimApprovDto.getApprovDate());
        dbManager.setString(4,prpLclaimApprovDto.getTransferStatus());
        dbManager.setString(5,prpLclaimApprovDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimApprovBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLclaimApprov (" + 
                           " RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimApprovDto prpLclaimApprovDto = (PrpLclaimApprovDto)i.next();
            dbManager.setString(1,prpLclaimApprovDto.getRegistNo());
            dbManager.setString(2,prpLclaimApprovDto.getApproverCode());
            dbManager.setDateTime(3,prpLclaimApprovDto.getApprovDate());
            dbManager.setString(4,prpLclaimApprovDto.getTransferStatus());
            dbManager.setString(5,prpLclaimApprovDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLclaimApprovBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @throws Exception
     */
    public void delete(String registNo) throws Exception{
        String statement = " Delete From PrpLclaimApprov" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLclaimApprov Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLclaimApprovBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLclaimApprovDto prpLclaimApprovDto
     * @throws Exception
     */
    public void update(PrpLclaimApprovDto prpLclaimApprovDto) throws Exception{
        String statement = " Update PrpLclaimApprov Set ApproverCode = ?," + 
                           " ApprovDate = ?," + 
                           " TransferStatus = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLclaimApprov Set " + 
                           " RegistNo = '" + prpLclaimApprovDto.getRegistNo() + "'," + 
                           " ApproverCode = '" + prpLclaimApprovDto.getApproverCode() + "'," + 
                           " ApprovDate = '" + prpLclaimApprovDto.getApprovDate() + "'," + 
                           " TransferStatus = '" + prpLclaimApprovDto.getTransferStatus() + "'," + 
                           " Flag = '" + prpLclaimApprovDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLclaimApprovDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLclaimApprovDto.getApproverCode());
        dbManager.setDateTime(2,prpLclaimApprovDto.getApprovDate());
        dbManager.setString(3,prpLclaimApprovDto.getTransferStatus());
        dbManager.setString(4,prpLclaimApprovDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpLclaimApprovDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLclaimApprovBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @return PrpLclaimApprovDto
     * @throws Exception
     */
    public PrpLclaimApprovDto findByPrimaryKey(String registNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag From PrpLclaimApprov";
        String statement = mainStatement + " Where " +
                           " RegistNo = ?";
        PrpLclaimApprovDto prpLclaimApprovDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLclaimApprovDto = new PrpLclaimApprovDto();
            prpLclaimApprovDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimApprovDto.setApproverCode(dbManager.getString(resultSet,2));
            prpLclaimApprovDto.setApprovDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLclaimApprovDto.setTransferStatus(dbManager.getString(resultSet,4));
            prpLclaimApprovDto.setFlag(dbManager.getString(resultSet,5));
            logger.info("DBPrpLclaimApprovBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLclaimApprovBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLclaimApprovDto;
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
        String statement = "Select RegistNo," + 
                           " ApproverCode," + 
                           " ApprovDate," + 
                           " TransferStatus," + 
                           " Flag From PrpLclaimApprov Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLclaimApprovDto prpLclaimApprovDto = null;
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

            prpLclaimApprovDto = new PrpLclaimApprovDto();
            prpLclaimApprovDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimApprovDto.setApproverCode(dbManager.getString(resultSet,2));
            prpLclaimApprovDto.setApprovDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLclaimApprovDto.setTransferStatus(dbManager.getString(resultSet,4));
            prpLclaimApprovDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpLclaimApprovDto);
        }
        resultSet.close();
        logger.info("DBPrpLclaimApprovBase.findByConditions() success!");
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
        String statement = "Delete From PrpLclaimApprov Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLclaimApprovBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLclaimApprov Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLclaimApprovBase.getCount() success!");
        return count;
    }
}
