package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcfee-�������������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:36.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcfeeBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcfeeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcfeeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void insert(PrpLcfeeDto prpLcfeeDto) throws Exception{
        String mainStatement = " Insert Into PrpLcfee (" + 
                           " CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumPaid," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcfeeDto.getCompensateNo() + "'," + 
                           "'" + prpLcfeeDto.getRiskCode() + "'," + 
                           "'" + prpLcfeeDto.getPolicyNo() + "'," + 
                           "'" + prpLcfeeDto.getCurrency() + "'," + 
                           "'" + prpLcfeeDto.getSumPaid() + "'," + 
                           "'" + prpLcfeeDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcfeeDto.getCompensateNo());
        dbManager.setString(2,prpLcfeeDto.getRiskCode());
        dbManager.setString(3,prpLcfeeDto.getPolicyNo());
        dbManager.setString(4,prpLcfeeDto.getCurrency());
        dbManager.setDouble(5,prpLcfeeDto.getSumPaid());
        dbManager.setString(6,prpLcfeeDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcfeeBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcfee (" + 
                           " CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumPaid," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcfeeDto prpLcfeeDto = (PrpLcfeeDto)i.next();
            dbManager.setString(1,prpLcfeeDto.getCompensateNo());
            dbManager.setString(2,prpLcfeeDto.getRiskCode());
            dbManager.setString(3,prpLcfeeDto.getPolicyNo());
            dbManager.setString(4,prpLcfeeDto.getCurrency());
            dbManager.setDouble(5,prpLcfeeDto.getSumPaid());
            dbManager.setString(6,prpLcfeeDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcfeeBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @throws Exception
     */
    public void delete(String compensateNo,String policyNo,String currency) throws Exception{
        String statement = " Delete From PrpLcfee" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcfee Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " PolicyNo = '" + policyNo + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,policyNo);
        dbManager.setString(3,currency);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcfeeBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcfeeDto prpLcfeeDto
     * @throws Exception
     */
    public void update(PrpLcfeeDto prpLcfeeDto) throws Exception{
        String statement = " Update PrpLcfee Set RiskCode = ?," + 
                           " SumPaid = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " CompensateNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcfee Set " + 
                           " CompensateNo = '" + prpLcfeeDto.getCompensateNo() + "'," + 
                           " RiskCode = '" + prpLcfeeDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLcfeeDto.getPolicyNo() + "'," + 
                           " Currency = '" + prpLcfeeDto.getCurrency() + "'," + 
                           " SumPaid = '" + prpLcfeeDto.getSumPaid() + "'," + 
                           " Flag = '" + prpLcfeeDto.getFlag() + "'" + 
			               " Where " +
                           " CompensateNo = '" + prpLcfeeDto.getCompensateNo() + "' And " + 
                           " PolicyNo = '" + prpLcfeeDto.getPolicyNo() + "' And " + 
                           " Currency = '" + prpLcfeeDto.getCurrency() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLcfeeDto.getRiskCode());
        dbManager.setDouble(2,prpLcfeeDto.getSumPaid());
        dbManager.setString(3,prpLcfeeDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,prpLcfeeDto.getCompensateNo());
        dbManager.setString(5,prpLcfeeDto.getPolicyNo());
        dbManager.setString(6,prpLcfeeDto.getCurrency());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcfeeBase.update() success!");
    }

    /**
     * ����������һ������
     * @param compensateNo ���������
     * @param policyNo ������
     * @param currency �ұ����
     * @return PrpLcfeeDto
     * @throws Exception
     */
    public PrpLcfeeDto findByPrimaryKey(String compensateNo,String policyNo,String currency) throws Exception{
        String mainStatement = " Select CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumPaid," + 
                           " Flag From PrpLcfee";
        String statement = mainStatement + " Where " +
                           " CompensateNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " Currency = ?";
        PrpLcfeeDto prpLcfeeDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " CompensateNo = '" + compensateNo + "' And " + 
                           " PolicyNo = '" + policyNo + "' And " + 
                           " Currency = '" + currency + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,compensateNo);
        dbManager.setString(2,policyNo);
        dbManager.setString(3,currency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcfeeDto = new PrpLcfeeDto();
            prpLcfeeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcfeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLcfeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpLcfeeDto.setSumPaid(dbManager.getDouble(resultSet,5));
            prpLcfeeDto.setFlag(dbManager.getString(resultSet,6));
            logger.info("DBPrpLcfeeBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcfeeBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcfeeDto;
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
        String statement = "Select CompensateNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " Currency," + 
                           " SumPaid," + 
                           " Flag From PrpLcfee Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcfeeDto prpLcfeeDto = null;
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

            prpLcfeeDto = new PrpLcfeeDto();
            prpLcfeeDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLcfeeDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLcfeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLcfeeDto.setCurrency(dbManager.getString(resultSet,4));
            prpLcfeeDto.setSumPaid(dbManager.getDouble(resultSet,5));
            prpLcfeeDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpLcfeeDto);
        }
        resultSet.close();
        logger.info("DBPrpLcfeeBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcfee Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcfeeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcfee Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcfeeBase.getCount() success!");
        return count;
    }
}
