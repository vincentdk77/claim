package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcheckLoss-�鿱�¹ʹ����������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:37.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcheckLossBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLcheckLossBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLcheckLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void insert(PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        String mainStatement = " Insert Into PrpLcheckLoss (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ReferSerialNo," + 
                           " KindCode," + 
                           " LossFeeType," + 
                           " LossFee," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLcheckLossDto.getRegistNo() + "'," + 
                           "'" + prpLcheckLossDto.getClaimNo() + "'," + 
                           "'" + prpLcheckLossDto.getRiskCode() + "'," + 
                           "'" + prpLcheckLossDto.getPolicyNo() + "'," + 
                           "" + prpLcheckLossDto.getSerialNo() + "," + 
                           "" + prpLcheckLossDto.getReferSerialNo() + "," + 
                           "'" + prpLcheckLossDto.getKindCode() + "'," + 
                           "'" + prpLcheckLossDto.getLossFeeType() + "'," + 
                           "'" + prpLcheckLossDto.getLossFee() + "'," + 
                           "'" + prpLcheckLossDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLcheckLossDto.getRegistNo());
        dbManager.setString(2,prpLcheckLossDto.getClaimNo());
        dbManager.setString(3,prpLcheckLossDto.getRiskCode());
        dbManager.setString(4,prpLcheckLossDto.getPolicyNo());
        dbManager.setInt(5,prpLcheckLossDto.getSerialNo());
        dbManager.setInt(6,prpLcheckLossDto.getReferSerialNo());
        dbManager.setString(7,prpLcheckLossDto.getKindCode());
        dbManager.setString(8,prpLcheckLossDto.getLossFeeType());
        dbManager.setDouble(9,prpLcheckLossDto.getLossFee());
        dbManager.setString(10,prpLcheckLossDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckLossBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLcheckLoss (" + 
                           " RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ReferSerialNo," + 
                           " KindCode," + 
                           " LossFeeType," + 
                           " LossFee," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)i.next();
            dbManager.setString(1,prpLcheckLossDto.getRegistNo());
            dbManager.setString(2,prpLcheckLossDto.getClaimNo());
            dbManager.setString(3,prpLcheckLossDto.getRiskCode());
            dbManager.setString(4,prpLcheckLossDto.getPolicyNo());
            dbManager.setInt(5,prpLcheckLossDto.getSerialNo());
            dbManager.setInt(6,prpLcheckLossDto.getReferSerialNo());
            dbManager.setString(7,prpLcheckLossDto.getKindCode());
            dbManager.setString(8,prpLcheckLossDto.getLossFeeType());
            dbManager.setDouble(9,prpLcheckLossDto.getLossFee());
            dbManager.setString(10,prpLcheckLossDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLcheckLossBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param registNo ���յǼǺ�
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String registNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLcheckLoss" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLcheckLoss Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLcheckLossBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLcheckLossDto prpLcheckLossDto
     * @throws Exception
     */
    public void update(PrpLcheckLossDto prpLcheckLossDto) throws Exception{
        String statement = " Update PrpLcheckLoss Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ReferSerialNo = ?," + 
                           " KindCode = ?," + 
                           " LossFeeType = ?," + 
                           " LossFee = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLcheckLoss Set " + 
                           " RegistNo = '" + prpLcheckLossDto.getRegistNo() + "'," + 
                           " ClaimNo = '" + prpLcheckLossDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLcheckLossDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLcheckLossDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLcheckLossDto.getSerialNo() + "," + 
                           " ReferSerialNo = " + prpLcheckLossDto.getReferSerialNo() + "," + 
                           " KindCode = '" + prpLcheckLossDto.getKindCode() + "'," + 
                           " LossFeeType = '" + prpLcheckLossDto.getLossFeeType() + "'," + 
                           " LossFee = '" + prpLcheckLossDto.getLossFee() + "'," + 
                           " Flag = '" + prpLcheckLossDto.getFlag() + "'" + 
			               " Where " +
                           " RegistNo = '" + prpLcheckLossDto.getRegistNo() + "' And " + 
                           " SerialNo = " + prpLcheckLossDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLcheckLossDto.getClaimNo());
        dbManager.setString(2,prpLcheckLossDto.getRiskCode());
        dbManager.setString(3,prpLcheckLossDto.getPolicyNo());
        dbManager.setInt(4,prpLcheckLossDto.getReferSerialNo());
        dbManager.setString(5,prpLcheckLossDto.getKindCode());
        dbManager.setString(6,prpLcheckLossDto.getLossFeeType());
        dbManager.setDouble(7,prpLcheckLossDto.getLossFee());
        dbManager.setString(8,prpLcheckLossDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpLcheckLossDto.getRegistNo());
        dbManager.setInt(10,prpLcheckLossDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLcheckLossBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ���յǼǺ�
     * @param serialNo ���
     * @return PrpLcheckLossDto
     * @throws Exception
     */
    public PrpLcheckLossDto findByPrimaryKey(String registNo,int serialNo) throws Exception{
        String mainStatement = " Select RegistNo," + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ReferSerialNo," + 
                           " KindCode," + 
                           " LossFeeType," + 
                           " LossFee," + 
                           " Flag From PrpLcheckLoss";
        String statement = mainStatement + " Where " +
                           " RegistNo = ? And " + 
                           " SerialNo = ?";
        PrpLcheckLossDto prpLcheckLossDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " RegistNo = '" + registNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLcheckLossDto = new PrpLcheckLossDto();
            prpLcheckLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckLossDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckLossDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckLossDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckLossDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcheckLossDto.setReferSerialNo(dbManager.getInt(resultSet,6));
            prpLcheckLossDto.setKindCode(dbManager.getString(resultSet,7));
            prpLcheckLossDto.setLossFeeType(dbManager.getString(resultSet,8));
            prpLcheckLossDto.setLossFee(dbManager.getDouble(resultSet,9));
            prpLcheckLossDto.setFlag(dbManager.getString(resultSet,10));
            logger.info("DBPrpLcheckLossBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLcheckLossBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLcheckLossDto;
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
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ReferSerialNo," + 
                           " KindCode," + 
                           " LossFeeType," + 
                           " LossFee," + 
                           " Flag From PrpLcheckLoss Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcheckLossDto prpLcheckLossDto = null;
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

            prpLcheckLossDto = new PrpLcheckLossDto();
            prpLcheckLossDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLcheckLossDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLcheckLossDto.setRiskCode(dbManager.getString(resultSet,3));
            prpLcheckLossDto.setPolicyNo(dbManager.getString(resultSet,4));
            prpLcheckLossDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpLcheckLossDto.setReferSerialNo(dbManager.getInt(resultSet,6));
            prpLcheckLossDto.setKindCode(dbManager.getString(resultSet,7));
            prpLcheckLossDto.setLossFeeType(dbManager.getString(resultSet,8));
            prpLcheckLossDto.setLossFee(dbManager.getDouble(resultSet,9));
            prpLcheckLossDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpLcheckLossDto);
        }
        resultSet.close();
        logger.info("DBPrpLcheckLossBase.findByConditions() success!");
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
        String statement = "Delete From PrpLcheckLoss Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLcheckLossBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLcheckLoss Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLcheckLossBase.getCount() success!");
        return count;
    }
}
