package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLdoc-���ⵥ֤��Ϣ������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.296<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLdocBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLdocBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLdocBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void insert(PrpLdocDto prpLdocDto) throws Exception{
        String mainStatement = " Insert Into PrpLdoc (" + 
                           " ClaimNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " DocCount," + 
                           " SignInDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLdocDto.getClaimNo() + "'," + 
                           "'" + prpLdocDto.getDocCode() + "'," + 
                           "'" + prpLdocDto.getDocName() + "'," + 
                           "" + prpLdocDto.getDocCount() + "," + 
                           "'" + prpLdocDto.getSignInDate() + "'," + 
                           "'" + prpLdocDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLdocDto.getClaimNo());
        dbManager.setString(2,prpLdocDto.getDocCode());
        dbManager.setString(3,prpLdocDto.getDocName());
        dbManager.setInt(4,prpLdocDto.getDocCount());
        dbManager.setDateTime(5,prpLdocDto.getSignInDate());
        dbManager.setString(6,prpLdocDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLdocBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLdoc (" + 
                           " ClaimNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " DocCount," + 
                           " SignInDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLdocDto prpLdocDto = (PrpLdocDto)i.next();
            dbManager.setString(1,prpLdocDto.getClaimNo());
            dbManager.setString(2,prpLdocDto.getDocCode());
            dbManager.setString(3,prpLdocDto.getDocName());
            dbManager.setInt(4,prpLdocDto.getDocCount());
            dbManager.setDateTime(5,prpLdocDto.getSignInDate());
            dbManager.setString(6,prpLdocDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLdocBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param claimNo �ⰸ����
     * @param docCode ��֤����
     * @throws Exception
     */
    public void delete(String claimNo,String docCode) throws Exception{
        String statement = " Delete From PrpLdoc" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " DocCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLdoc Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " DocCode = '" + docCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,docCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLdocBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void update(PrpLdocDto prpLdocDto) throws Exception{
        String statement = " Update PrpLdoc Set DocName = ?," + 
                           " DocCount = ?," + 
                           " SignInDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " DocCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLdoc Set " + 
                           " ClaimNo = '" + prpLdocDto.getClaimNo() + "'," + 
                           " DocCode = '" + prpLdocDto.getDocCode() + "'," + 
                           " DocName = '" + prpLdocDto.getDocName() + "'," + 
                           " DocCount = " + prpLdocDto.getDocCount() + "," + 
                           " SignInDate = '" + prpLdocDto.getSignInDate() + "'," + 
                           " Flag = '" + prpLdocDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLdocDto.getClaimNo() + "' And " + 
                           " DocCode = '" + prpLdocDto.getDocCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLdocDto.getDocName());
        dbManager.setInt(2,prpLdocDto.getDocCount());
        dbManager.setDateTime(3,prpLdocDto.getSignInDate());
        dbManager.setString(4,prpLdocDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpLdocDto.getClaimNo());
        dbManager.setString(6,prpLdocDto.getDocCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLdocBase.update() success!");
    }

    /**
     * ����������һ������
     * @param claimNo �ⰸ����
     * @param docCode ��֤����
     * @return PrpLdocDto
     * @throws Exception
     */
    public PrpLdocDto findByPrimaryKey(String claimNo,String docCode) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " DocCount," + 
                           " SignInDate," + 
                           " Flag From PrpLdoc";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " DocCode = ?";
        PrpLdocDto prpLdocDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " DocCode = '" + docCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.setString(2,docCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLdocDto = new PrpLdocDto();
            prpLdocDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLdocDto.setDocCode(dbManager.getString(resultSet,2));
            prpLdocDto.setDocName(dbManager.getString(resultSet,3));
            prpLdocDto.setDocCount(dbManager.getInt(resultSet,4));
            prpLdocDto.setSignInDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLdocDto.setFlag(dbManager.getString(resultSet,6));
            logger.info("DBPrpLdocBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLdocBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLdocDto;
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
        String statement = "Select ClaimNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " DocCount," + 
                           " SignInDate," + 
                           " Flag From PrpLdoc Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLdocDto prpLdocDto = null;
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

            prpLdocDto = new PrpLdocDto();
            prpLdocDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLdocDto.setDocCode(dbManager.getString(resultSet,2));
            prpLdocDto.setDocName(dbManager.getString(resultSet,3));
            prpLdocDto.setDocCount(dbManager.getInt(resultSet,4));
            prpLdocDto.setSignInDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,5));
            prpLdocDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpLdocDto);
        }
        resultSet.close();
        logger.info("DBPrpLdocBase.findByConditions() success!");
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
        String statement = "Delete From PrpLdoc Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLdocBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLdoc Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLdocBase.getCount() success!");
        return count;
    }
}
