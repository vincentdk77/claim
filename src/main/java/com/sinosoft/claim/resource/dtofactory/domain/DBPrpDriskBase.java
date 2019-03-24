package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDriskDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdrisk���ִ��������ݷ��ʶ������<br>
 * ������ 2004-08-25 16:51:29.092<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDriskBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpDriskBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDriskBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(PrpDriskDto prpDriskDto) throws Exception{
        String mainStatement = " Insert Into PrpDrisk (" +
                           " RiskCode," +
                           " RiskCName," +
                           " RiskEName," +
                           " ClassCode," +
                           " RiskType," +
                           " Calculator," +
                           " EndDateFlag," +
                           " RiskFlag," +
                           " StartHour," +
                           " NewRiskCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " ManageFlag," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpDriskDto.getRiskCode() + "'," +
                           "'" + prpDriskDto.getRiskCName() + "'," +
                           "'" + prpDriskDto.getRiskEName() + "'," +
                           "'" + prpDriskDto.getClassCode() + "'," +
                           "'" + prpDriskDto.getRiskType() + "'," +
                           "" + prpDriskDto.getCalculator() + "," +
                           "'" + prpDriskDto.getEndDateFlag() + "'," +
                           "'" + prpDriskDto.getRiskFlag() + "'," +
                           "" + prpDriskDto.getStartHour() + "," +
                           "'" + prpDriskDto.getNewRiskCode() + "'," +
                           "'" + prpDriskDto.getValidStatus() + "'," +
                           "'" + prpDriskDto.getArticleCode() + "'," +
                           "'" + prpDriskDto.getManageFlag() + "'," +
                           "'" + prpDriskDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDriskDto.getRiskCode());
        dbManager.setString(2,prpDriskDto.getRiskCName());
        dbManager.setString(3,prpDriskDto.getRiskEName());
        dbManager.setString(4,prpDriskDto.getClassCode());
        dbManager.setString(5,prpDriskDto.getRiskType());
        dbManager.setInt(6,prpDriskDto.getCalculator());
        dbManager.setString(7,prpDriskDto.getEndDateFlag());
        dbManager.setString(8,prpDriskDto.getRiskFlag());
        dbManager.setInt(9,prpDriskDto.getStartHour());
        dbManager.setString(10,prpDriskDto.getNewRiskCode());
        dbManager.setString(11,prpDriskDto.getValidStatus());
        dbManager.setString(12,prpDriskDto.getArticleCode());
        dbManager.setString(13,prpDriskDto.getManageFlag());
        dbManager.setString(14,prpDriskDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDriskBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDriskDto prpDriskDto = (PrpDriskDto)i.next();
            insert(prpDriskDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @throws Exception
     */
    public void delete(String riskCode) throws Exception{
        String statement = " Delete From PrpDrisk" +
	            		   " Where " +
                           " RiskCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpDrisk Where " +
                           " RiskCode = '" + riskCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpDriskBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(PrpDriskDto prpDriskDto) throws Exception{
        String statement = " Update PrpDrisk Set RiskCName = ?," +
                           " RiskEName = ?," +
                           " ClassCode = ?," +
                           " RiskType = ?," +
                           " Calculator = ?," +
                           " EndDateFlag = ?," +
                           " RiskFlag = ?," +
                           " StartHour = ?," +
                           " NewRiskCode = ?," +
                           " ValidStatus = ?," +
                           " ArticleCode = ?," +
                           " ManageFlag = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " RiskCode = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpDrisk Set " +
                           " RiskCode = '" + prpDriskDto.getRiskCode() + "'," +
                           " RiskCName = '" + prpDriskDto.getRiskCName() + "'," +
                           " RiskEName = '" + prpDriskDto.getRiskEName() + "'," +
                           " ClassCode = '" + prpDriskDto.getClassCode() + "'," +
                           " RiskType = '" + prpDriskDto.getRiskType() + "'," +
                           " Calculator = " + prpDriskDto.getCalculator() + "," +
                           " EndDateFlag = '" + prpDriskDto.getEndDateFlag() + "'," +
                           " RiskFlag = '" + prpDriskDto.getRiskFlag() + "'," +
                           " StartHour = " + prpDriskDto.getStartHour() + "," +
                           " NewRiskCode = '" + prpDriskDto.getNewRiskCode() + "'," +
                           " ValidStatus = '" + prpDriskDto.getValidStatus() + "'," +
                           " ArticleCode = '" + prpDriskDto.getArticleCode() + "'," +
                           " ManageFlag = '" + prpDriskDto.getManageFlag() + "'," +
                           " Flag = '" + prpDriskDto.getFlag() + "'" +
			               " Where " +
                           " RiskCode = '" + prpDriskDto.getRiskCode() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDriskDto.getRiskCName());
        dbManager.setString(2,prpDriskDto.getRiskEName());
        dbManager.setString(3,prpDriskDto.getClassCode());
        dbManager.setString(4,prpDriskDto.getRiskType());
        dbManager.setInt(5,prpDriskDto.getCalculator());
        dbManager.setString(6,prpDriskDto.getEndDateFlag());
        dbManager.setString(7,prpDriskDto.getRiskFlag());
        dbManager.setInt(8,prpDriskDto.getStartHour());
        dbManager.setString(9,prpDriskDto.getNewRiskCode());
        dbManager.setString(10,prpDriskDto.getValidStatus());
        dbManager.setString(11,prpDriskDto.getArticleCode());
        dbManager.setString(12,prpDriskDto.getManageFlag());
        dbManager.setString(13,prpDriskDto.getFlag());
        //���������ֶ�;
        dbManager.setString(14,prpDriskDto.getRiskCode());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpDriskBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @return PrpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(String riskCode) throws Exception{
        String mainStatement = " Select RiskCode," +
                           " RiskCName," +
                           " RiskEName," +
                           " ClassCode," +
                           " Calculator," +
                           " EndDateFlag," +
                           " RiskFlag," +
                           " StartHour," +
                           " NewRiskCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " ManageFlag," +
                           " Flag From PrpDrisk";
        String statement = mainStatement + " Where " +
                           " RiskCode = ?";
        PrpDriskDto prpDriskDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RiskCode = '" + riskCode + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDriskDto = new PrpDriskDto();
            prpDriskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDriskDto.setRiskCName(dbManager.getString(resultSet,2));
            prpDriskDto.setRiskEName(dbManager.getString(resultSet,3));
            prpDriskDto.setClassCode(dbManager.getString(resultSet,4));
             prpDriskDto.setCalculator(dbManager.getInt(resultSet,5));
            prpDriskDto.setEndDateFlag(dbManager.getString(resultSet,6));
            prpDriskDto.setRiskFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setStartHour(dbManager.getInt(resultSet,8));
            prpDriskDto.setNewRiskCode(dbManager.getString(resultSet,9));
            prpDriskDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDriskDto.setArticleCode(dbManager.getString(resultSet,11));
            prpDriskDto.setManageFlag(dbManager.getString(resultSet,12));
            prpDriskDto.setFlag(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        logger.info("DBPrpDriskBase.findByPrimaryKey() success!");
        return prpDriskDto;
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
        String statement = "Select RiskCode," +
                           " RiskCName," +
                           " RiskEName," +
                           " ClassCode," +
                           " Calculator," +
                           " EndDateFlag," +
                           " RiskFlag," +
                           " StartHour," +
                           " NewRiskCode," +
                           " ValidStatus," +
                           " ArticleCode," +
                           " ManageFlag," +
                           " Flag From PrpDrisk Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpDriskDto prpDriskDto = null;
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

            prpDriskDto = new PrpDriskDto();
            prpDriskDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDriskDto.setRiskCName(dbManager.getString(resultSet,2));
            prpDriskDto.setRiskEName(dbManager.getString(resultSet,3));
            prpDriskDto.setClassCode(dbManager.getString(resultSet,4));
            //prpDriskDto.setRiskType(dbManager.getString(resultSet,5));
            prpDriskDto.setCalculator(dbManager.getInt(resultSet,5));
            //prpDriskDto.setCalculateFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setEndDateFlag(dbManager.getString(resultSet,6));
            prpDriskDto.setRiskFlag(dbManager.getString(resultSet,7));
            prpDriskDto.setStartHour(dbManager.getInt(resultSet,8));
            prpDriskDto.setNewRiskCode(dbManager.getString(resultSet,9));
            prpDriskDto.setValidStatus(dbManager.getString(resultSet,10));
            prpDriskDto.setArticleCode(dbManager.getString(resultSet,11));
            prpDriskDto.setManageFlag(dbManager.getString(resultSet,12));
            prpDriskDto.setFlag(dbManager.getString(resultSet,13));
            collection.add(prpDriskDto);
        }
        resultSet.close();
        logger.info("DBPrpDriskBase.findByConditions() success!");
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
        String statement = "Delete From PrpDrisk Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpDriskBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDrisk Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpDriskBase.getCount() success!");
        return count;
    }
}
