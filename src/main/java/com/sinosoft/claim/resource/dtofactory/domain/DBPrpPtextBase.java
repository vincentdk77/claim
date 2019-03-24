package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPtextDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpptext����������Ϣ�����ݷ��ʶ������<br>
 * ������ 2004-11-22 15:24:18.171<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPtextBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpPtextBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPtextBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void insert(PrpPtextDto prpPtextDto) throws Exception{
        String mainStatement = " Insert Into PrpPtext (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " LineNo," +
                           " EndorseText," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPtextDto.getEndorseNo() + "'," +
                           "'" + prpPtextDto.getPolicyNo() + "'," +
                           "" + prpPtextDto.getLineNo() + "," +
                           "'" + prpPtextDto.getEndorseText() + "'," +
                           "'" + prpPtextDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPtextDto.getEndorseNo());
        dbManager.setString(2,prpPtextDto.getPolicyNo());
        dbManager.setInt(3,prpPtextDto.getLineNo());
        dbManager.setString(4,prpPtextDto.getEndorseText());
        dbManager.setString(5,prpPtextDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPtextBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPtextDto prpPtextDto = (PrpPtextDto)i.next();
            insert(prpPtextDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @throws Exception
     */
    public void delete(String endorseNo,String policyNo,int lineNo) throws Exception{
        String statement = " Delete From PrpPtext" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " PolicyNo = ? And " +
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPtext Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " PolicyNo = '" + policyNo + "' And " +
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPtextBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpPtextDto prpPtextDto
     * @throws Exception
     */
    public void update(PrpPtextDto prpPtextDto) throws Exception{
        String statement = " Update PrpPtext Set EndorseText = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " PolicyNo = ? And " +
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPtext Set " +
                           " EndorseNo = '" + prpPtextDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPtextDto.getPolicyNo() + "'," +
                           " LineNo = " + prpPtextDto.getLineNo() + "," +
                           " EndorseText = '" + prpPtextDto.getEndorseText() + "'," +
                           " Flag = '" + prpPtextDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPtextDto.getEndorseNo() + "' And " +
                           " PolicyNo = '" + prpPtextDto.getPolicyNo() + "' And " +
                           " LineNo = " + prpPtextDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpPtextDto.getEndorseText());
        dbManager.setString(2,prpPtextDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpPtextDto.getEndorseNo());
        dbManager.setString(4,prpPtextDto.getPolicyNo());
        dbManager.setInt(5,prpPtextDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPtextBase.update() success!");
    }

    /**
     * ����������һ������
     * @param endorseNo �����Ŵ�
     * @param policyNo ���յ��Ŵ�
     * @param lineNo ���ĵ��к�
     * @return PrpPtextDto
     * @throws Exception
     */
    public PrpPtextDto findByPrimaryKey(String endorseNo,String policyNo,int lineNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " LineNo," +
                           " EndorseText," +
                           " Flag From PrpPtext";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " PolicyNo = ? And " +
                           " LineNo = ?";
        PrpPtextDto prpPtextDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " PolicyNo = '" + policyNo + "' And " +
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPtextDto = new PrpPtextDto();
            prpPtextDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPtextDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPtextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpPtextDto.setEndorseText(dbManager.getString(resultSet,4));
            prpPtextDto.setFlag(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        logger.info("DBPrpPtextBase.findByPrimaryKey() success!");
        return prpPtextDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " LineNo," +
                           " EndorseText," +
                           " Flag From PrpPtext Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPtextDto prpPtextDto = null;
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

            prpPtextDto = new PrpPtextDto();
            prpPtextDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPtextDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPtextDto.setLineNo(dbManager.getInt(resultSet,3));
            prpPtextDto.setEndorseText(dbManager.getString(resultSet,4));
            prpPtextDto.setFlag(dbManager.getString(resultSet,5));
            collection.add(prpPtextDto);
        }
        resultSet.close();
        logger.info("DBPrpPtextBase.findByConditions() success!");
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
        String statement = "Delete From PrpPtext Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPtextBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPtext Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPtextBase.getCount() success!");
        return count;
    }
}
