package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcengage�ر�Լ��������ݷ��ʶ������<br>
 * ������ 2004-10-20 12:07:33.590<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCengageTgBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpCengageTgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCengageTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void insert(PrpCengageDto prpCengageDto) throws Exception{
        String mainStatement = " Insert Into PrpCengageTg (" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClauseCode," + 
                           " Clauses," + 
                           " TitleFlag," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpCengageDto.getPolicyNo() + "'," + 
                           "'" + prpCengageDto.getRiskCode() + "'," + 
                           "" + prpCengageDto.getSerialNo() + "," + 
                           "" + prpCengageDto.getLineNo() + "," + 
                           "'" + prpCengageDto.getClauseCode() + "'," + 
                           "'" + prpCengageDto.getClauses() + "'," + 
                           "'" + prpCengageDto.getTitleFlag() + "'," + 
                           "'" + prpCengageDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCengageDto.getPolicyNo());
        dbManager.setString(2,prpCengageDto.getRiskCode());
        dbManager.setInt(3,prpCengageDto.getSerialNo());
        dbManager.setInt(4,prpCengageDto.getLineNo());
        dbManager.setString(5,prpCengageDto.getClauseCode());
        dbManager.setString(6,prpCengageDto.getClauses());
        dbManager.setString(7,prpCengageDto.getTitleFlag());
        dbManager.setString(8,prpCengageDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpCengageBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCengageDto prpCengageDto = (PrpCengageDto)i.next();
            insert(prpCengageDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @param lineNo �����
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo,int lineNo) throws Exception{
        String statement = " Delete From PrpCengageTg" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpCengageTg Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpCengageBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCengageDto prpCengageDto
     * @throws Exception
     */
    public void update(PrpCengageDto prpCengageDto) throws Exception{
        String statement = " Update PrpCengageTg Set RiskCode = ?," + 
                           " ClauseCode = ?," + 
                           " Clauses = ?," + 
                           " TitleFlag = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpCengageTg Set " + 
                           " PolicyNo = '" + prpCengageDto.getPolicyNo() + "'," + 
                           " RiskCode = '" + prpCengageDto.getRiskCode() + "'," + 
                           " SerialNo = " + prpCengageDto.getSerialNo() + "," + 
                           " LineNo = " + prpCengageDto.getLineNo() + "," + 
                           " ClauseCode = '" + prpCengageDto.getClauseCode() + "'," + 
                           " Clauses = '" + prpCengageDto.getClauses() + "'," + 
                           " TitleFlag = '" + prpCengageDto.getTitleFlag() + "'," + 
                           " Flag = '" + prpCengageDto.getFlag() + "'" + 
			               " Where " +
                           " PolicyNo = '" + prpCengageDto.getPolicyNo() + "' And " + 
                           " SerialNo = " + prpCengageDto.getSerialNo() + " And " + 
                           " LineNo = " + prpCengageDto.getLineNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCengageDto.getRiskCode());
        dbManager.setString(2,prpCengageDto.getClauseCode());
        dbManager.setString(3,prpCengageDto.getClauses());
        dbManager.setString(4,prpCengageDto.getTitleFlag());
        dbManager.setString(5,prpCengageDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpCengageDto.getPolicyNo());
        dbManager.setInt(7,prpCengageDto.getSerialNo());
        dbManager.setInt(8,prpCengageDto.getLineNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpCengageBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ���
     * @param lineNo �����
     * @return PrpCengageDto
     * @throws Exception
     */
    public PrpCengageDto findByPrimaryKey(String policyNo,int serialNo,int lineNo) throws Exception{
        String mainStatement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClauseCode," + 
                           " Clauses," + 
                           " TitleFlag," + 
                           " Flag From PrpCengageTg";
        String statement = mainStatement + " Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " LineNo = ?";
        PrpCengageDto prpCengageDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " PolicyNo = '" + policyNo + "' And " + 
                           " SerialNo = " + serialNo + " And " + 
                           " LineNo = " + lineNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,lineNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCengageDto = new PrpCengageDto();
            prpCengageDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCengageDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCengageDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCengageDto.setLineNo(dbManager.getInt(resultSet,4));
            prpCengageDto.setClauseCode(dbManager.getString(resultSet,5));
            prpCengageDto.setClauses(dbManager.getString(resultSet,6));
            prpCengageDto.setTitleFlag(dbManager.getString(resultSet,7));
            prpCengageDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        logger.info("DBPrpCengageBase.findByPrimaryKey() success!");
        return prpCengageDto;
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
        String statement = "Select PolicyNo," + 
                           " RiskCode," + 
                           " SerialNo," + 
                           " LineNo," + 
                           " ClauseCode," + 
                           " Clauses," + 
                           " TitleFlag," + 
                           " Flag From PrpCengageTg Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpCengageDto prpCengageDto = null;
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

            prpCengageDto = new PrpCengageDto();
            prpCengageDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCengageDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCengageDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCengageDto.setLineNo(dbManager.getInt(resultSet,4));
            prpCengageDto.setClauseCode(dbManager.getString(resultSet,5));
            prpCengageDto.setClauses(dbManager.getString(resultSet,6));
            prpCengageDto.setTitleFlag(dbManager.getString(resultSet,7));
            prpCengageDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpCengageDto);
        }
        resultSet.close();
        logger.info("DBPrpCengageBase.findByConditions() success!");
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
        String statement = "Delete From PrpCengageTg Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpCengageBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCengageTg Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpCengageBase.getCount() success!");
        return count;
    }
}
