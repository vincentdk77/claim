package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLbackVisitQue--�ط���ѯ������ݷ��ʶ������<br>
 * ������ 2005-03-23 09:00:21.578<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLbackVisitQueBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLbackVisitQueBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLbackVisitQueBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void insert(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisitQue (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " QuestionCode," + 
                           " QuestionName," + 
                           " QuestionResult," + 
                           " QuestionRemark," + 
                           " QuestionType," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "" + prpLbackVisitQueDto.getBackVisitID() + "," + 
                           "'" + prpLbackVisitQueDto.getRegistNo() + "'," + 
                           "'" + prpLbackVisitQueDto.getBackVisitType() + "'," + 
                           "'" + prpLbackVisitQueDto.getQuestionCode() + "'," + 
                           "'" + prpLbackVisitQueDto.getQuestionName() + "'," + 
                           "'" + prpLbackVisitQueDto.getQuestionResult() + "'," + 
                           "'" + prpLbackVisitQueDto.getQuestionRemark() + "'," + 
                           "'" + prpLbackVisitQueDto.getQuestionType() + "'," + 
                           "'" + prpLbackVisitQueDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setInt(1,prpLbackVisitQueDto.getBackVisitID());
        dbManager.setString(2,prpLbackVisitQueDto.getRegistNo());
        dbManager.setString(3,prpLbackVisitQueDto.getBackVisitType());
        dbManager.setString(4,prpLbackVisitQueDto.getQuestionCode());
        dbManager.setString(5,prpLbackVisitQueDto.getQuestionName());
        dbManager.setString(6,prpLbackVisitQueDto.getQuestionResult());
        dbManager.setString(7,prpLbackVisitQueDto.getQuestionRemark());
        dbManager.setString(8,prpLbackVisitQueDto.getQuestionType());
        dbManager.setString(9,prpLbackVisitQueDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitQueBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLbackVisitQue (" + 
                           " BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " QuestionCode," + 
                           " QuestionName," + 
                           " QuestionResult," + 
                           " QuestionRemark," + 
                           " QuestionType," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLbackVisitQueDto prpLbackVisitQueDto = (PrpLbackVisitQueDto)i.next();
            dbManager.setInt(1,prpLbackVisitQueDto.getBackVisitID());
            dbManager.setString(2,prpLbackVisitQueDto.getRegistNo());
            dbManager.setString(3,prpLbackVisitQueDto.getBackVisitType());
            dbManager.setString(4,prpLbackVisitQueDto.getQuestionCode());
            dbManager.setString(5,prpLbackVisitQueDto.getQuestionName());
            dbManager.setString(6,prpLbackVisitQueDto.getQuestionResult());
            dbManager.setString(7,prpLbackVisitQueDto.getQuestionRemark());
            dbManager.setString(8,prpLbackVisitQueDto.getQuestionType());
            dbManager.setString(9,prpLbackVisitQueDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLbackVisitQueBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @throws Exception
     */
    public void delete(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        String statement = " Delete From PrpLbackVisitQue" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " QuestionCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLbackVisitQue Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "' And " + 
                           " QuestionCode = '" + questionCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        dbManager.setString(4,questionCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLbackVisitQueBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void update(PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        String statement = " Update PrpLbackVisitQue Set QuestionName = ?," + 
                           " QuestionResult = ?," + 
                           " QuestionRemark = ?," + 
                           " QuestionType = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " QuestionCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLbackVisitQue Set " + 
                           " BackVisitID = " + prpLbackVisitQueDto.getBackVisitID() + "," + 
                           " RegistNo = '" + prpLbackVisitQueDto.getRegistNo() + "'," + 
                           " BackVisitType = '" + prpLbackVisitQueDto.getBackVisitType() + "'," + 
                           " QuestionCode = '" + prpLbackVisitQueDto.getQuestionCode() + "'," + 
                           " QuestionName = '" + prpLbackVisitQueDto.getQuestionName() + "'," + 
                           " QuestionResult = '" + prpLbackVisitQueDto.getQuestionResult() + "'," + 
                           " QuestionRemark = '" + prpLbackVisitQueDto.getQuestionRemark() + "'," + 
                           " QuestionType = '" + prpLbackVisitQueDto.getQuestionType() + "'," + 
                           " Flag = '" + prpLbackVisitQueDto.getFlag() + "'" + 
			               " Where " +
                           " BackVisitID = " + prpLbackVisitQueDto.getBackVisitID() + " And " + 
                           " RegistNo = '" + prpLbackVisitQueDto.getRegistNo() + "' And " + 
                           " BackVisitType = '" + prpLbackVisitQueDto.getBackVisitType() + "' And " + 
                           " QuestionCode = '" + prpLbackVisitQueDto.getQuestionCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLbackVisitQueDto.getQuestionName());
        dbManager.setString(2,prpLbackVisitQueDto.getQuestionResult());
        dbManager.setString(3,prpLbackVisitQueDto.getQuestionRemark());
        dbManager.setString(4,prpLbackVisitQueDto.getQuestionType());
        dbManager.setString(5,prpLbackVisitQueDto.getFlag());
        //���������ֶ�;
        dbManager.setInt(6,prpLbackVisitQueDto.getBackVisitID());
        dbManager.setString(7,prpLbackVisitQueDto.getRegistNo());
        dbManager.setString(8,prpLbackVisitQueDto.getBackVisitType());
        dbManager.setString(9,prpLbackVisitQueDto.getQuestionCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLbackVisitQueBase.update() success!");
    }

    /**
     * ����������һ������
     * @param backVisitID �ͻ��طü�¼ID
     * @param registNo ��������
     * @param backVisitType ҵ������
     * @param questionCode �ط���Ŀ����
     * @return PrpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueDto findByPrimaryKey(int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        String mainStatement = " Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " QuestionCode," + 
                           " QuestionName," + 
                           " QuestionResult," + 
                           " QuestionRemark," + 
                           " QuestionType," + 
                           " Flag From PrpLbackVisitQue";
        String statement = mainStatement + " Where " +
                           " BackVisitID = ? And " + 
                           " RegistNo = ? And " + 
                           " BackVisitType = ? And " + 
                           " QuestionCode = ?";
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " BackVisitID = " + backVisitID + " And " + 
                           " RegistNo = '" + registNo + "' And " + 
                           " BackVisitType = '" + backVisitType + "' And " + 
                           " QuestionCode = '" + questionCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setInt(1,backVisitID);
        dbManager.setString(2,registNo);
        dbManager.setString(3,backVisitType);
        dbManager.setString(4,questionCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLbackVisitQueDto = new PrpLbackVisitQueDto();
            prpLbackVisitQueDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitQueDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitQueDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitQueDto.setQuestionCode(dbManager.getString(resultSet,4));
            prpLbackVisitQueDto.setQuestionName(dbManager.getString(resultSet,5));
            prpLbackVisitQueDto.setQuestionResult(dbManager.getString(resultSet,6));
            prpLbackVisitQueDto.setQuestionRemark(dbManager.getString(resultSet,7));
            prpLbackVisitQueDto.setQuestionType(dbManager.getString(resultSet,8));
            prpLbackVisitQueDto.setFlag(dbManager.getString(resultSet,9));
            logger.info("DBPrpLbackVisitQueBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLbackVisitQueBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLbackVisitQueDto;
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
        String statement = "Select BackVisitID," + 
                           " RegistNo," + 
                           " BackVisitType," + 
                           " QuestionCode," + 
                           " QuestionName," + 
                           " QuestionResult," + 
                           " QuestionRemark," + 
                           " QuestionType," + 
                           " Flag From PrpLbackVisitQue Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
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

            prpLbackVisitQueDto = new PrpLbackVisitQueDto();
            prpLbackVisitQueDto.setBackVisitID(dbManager.getInt(resultSet,1));
            prpLbackVisitQueDto.setRegistNo(dbManager.getString(resultSet,2));
            prpLbackVisitQueDto.setBackVisitType(dbManager.getString(resultSet,3));
            prpLbackVisitQueDto.setQuestionCode(dbManager.getString(resultSet,4));
            prpLbackVisitQueDto.setQuestionName(dbManager.getString(resultSet,5));
            prpLbackVisitQueDto.setQuestionResult(dbManager.getString(resultSet,6));
            prpLbackVisitQueDto.setQuestionRemark(dbManager.getString(resultSet,7));
            prpLbackVisitQueDto.setQuestionType(dbManager.getString(resultSet,8));
            prpLbackVisitQueDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpLbackVisitQueDto);
        }
        resultSet.close();
        logger.info("DBPrpLbackVisitQueBase.findByConditions() success!");
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
        String statement = "Delete From PrpLbackVisitQue Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLbackVisitQueBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLbackVisitQue Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLbackVisitQueBase.getCount() success!");
        return count;
    }
}
