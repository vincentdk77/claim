package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcaseNo-�ⰸ�ű�����ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcaseNoBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcaseNoBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcaseNoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void insert(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        String mainStatement = " Insert Into PrpLcaseNo (" + 
                           " CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcaseNoDto.getCertiNo() + "'," + 
                           "'" + prpLcaseNoDto.getCertiType() + "'," + 
                           "'" + prpLcaseNoDto.getCaseNo() + "'," + 
                           "'" + prpLcaseNoDto.getFlag() + "'," + 
                           "'" + prpLcaseNoDto.getClaimNo() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcaseNoDto.getCertiNo());
        dbManager.setString(2,prpLcaseNoDto.getCertiType());
        dbManager.setString(3,prpLcaseNoDto.getCaseNo());
        dbManager.setString(4,prpLcaseNoDto.getFlag());
        dbManager.setString(5,prpLcaseNoDto.getClaimNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcaseNoBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcaseNo (" + 
                           " CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcaseNoDto prpLcaseNoDto = (PrpLcaseNoDto)i.next();
            dbManager.setString(1,prpLcaseNoDto.getCertiNo());
            dbManager.setString(2,prpLcaseNoDto.getCertiType());
            dbManager.setString(3,prpLcaseNoDto.getCaseNo());
            dbManager.setString(4,prpLcaseNoDto.getFlag());
            dbManager.setString(5,prpLcaseNoDto.getClaimNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcaseNoBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @throws Exception
     */
    public void delete(String certiNo,String certiType,String caseNo) throws Exception{
        String statement = " Delete From PrpLcaseNo" + 
	            		   " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcaseNo Where " +
                           " CertiNo = '" + certiNo + "' And " + 
                           " CertiType = '" + certiType + "' And " + 
                           " CaseNo = '" + caseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setString(3,caseNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcaseNoBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void update(PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        String statement = " Update PrpLcaseNo Set Flag = ?," + 
                           " ClaimNo = ?" + 
	            		   " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcaseNo Set " + 
                           " CertiNo = '" + prpLcaseNoDto.getCertiNo() + "'," + 
                           " CertiType = '" + prpLcaseNoDto.getCertiType() + "'," + 
                           " CaseNo = '" + prpLcaseNoDto.getCaseNo() + "'," + 
                           " Flag = '" + prpLcaseNoDto.getFlag() + "'," + 
                           " ClaimNo = '" + prpLcaseNoDto.getClaimNo() + "'" + 
			               " Where " +
                           " CertiNo = '" + prpLcaseNoDto.getCertiNo() + "' And " + 
                           " CertiType = '" + prpLcaseNoDto.getCertiType() + "' And " + 
                           " CaseNo = '" + prpLcaseNoDto.getCaseNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLcaseNoDto.getFlag());
        dbManager.setString(2,prpLcaseNoDto.getClaimNo());
        //���������ֶ�;
        dbManager.setString(3,prpLcaseNoDto.getCertiNo());
        dbManager.setString(4,prpLcaseNoDto.getCertiType());
        dbManager.setString(5,prpLcaseNoDto.getCaseNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcaseNoBase.update() success!");
    }

    /**
     * ����������һ������
     * @param certiNo ��֤��
     * @param certiType ��֤����
     * @param caseNo �ⰸ��
     * @return PrpLcaseNoDto
     * @throws Exception
     */
    public PrpLcaseNoDto findByPrimaryKey(String certiNo,String certiType,String caseNo) throws Exception{
        String mainStatement = " Select CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo From PrpLcaseNo";
        String statement = mainStatement + " Where " +
                           " CertiNo = ? And " + 
                           " CertiType = ? And " + 
                           " CaseNo = ?";
        PrpLcaseNoDto prpLcaseNoDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CertiNo = '" + certiNo + "' And " + 
                           " CertiType = '" + certiType + "' And " + 
                           " CaseNo = '" + caseNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setString(2,certiType);
        dbManager.setString(3,caseNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcaseNoDto = new PrpLcaseNoDto();
            prpLcaseNoDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLcaseNoDto.setCertiType(dbManager.getString(resultSet,2));
            prpLcaseNoDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcaseNoDto.setFlag(dbManager.getString(resultSet,4));
            prpLcaseNoDto.setClaimNo(dbManager.getString(resultSet,5));
            logger.info("DBPrpLcaseNoBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcaseNoBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcaseNoDto;
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
        String statement = "Select CertiNo," + 
                           " CertiType," + 
                           " CaseNo," + 
                           " Flag," + 
                           " ClaimNo From PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcaseNoDto prpLcaseNoDto = null;
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

            prpLcaseNoDto = new PrpLcaseNoDto();
            prpLcaseNoDto.setCertiNo(dbManager.getString(resultSet,1));
            prpLcaseNoDto.setCertiType(dbManager.getString(resultSet,2));
            prpLcaseNoDto.setCaseNo(dbManager.getString(resultSet,3));
            prpLcaseNoDto.setFlag(dbManager.getString(resultSet,4));
            prpLcaseNoDto.setClaimNo(dbManager.getString(resultSet,5));
            collection.add(prpLcaseNoDto);
        }
        resultSet.close();
        logger.info("DBPrpLcaseNoBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcaseNoBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcaseNo Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcaseNoBase.getCount() success!");
        return count;
    }
}
