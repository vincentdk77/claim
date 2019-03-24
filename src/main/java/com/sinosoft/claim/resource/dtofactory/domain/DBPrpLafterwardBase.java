package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLafterwardDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLafterward-������ô��������ݷ��ʶ������<br>
 * ������ 2005-03-18 17:53:35.906<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLafterwardBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpLafterwardBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLafterwardBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void insert(PrpLafterwardDto prpLafterwardDto) throws Exception{
        String mainStatement = " Insert Into PrpLafterward (" + 
                           " ClaimNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " DealDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLafterwardDto.getClaimNo() + "'," + 
                           "" + prpLafterwardDto.getSerialNo() + "," + 
                           "'" + prpLafterwardDto.getKindCode() + "'," + 
                           "'" + prpLafterwardDto.getChargeCode() + "'," + 
                           "'" + prpLafterwardDto.getChargeName() + "'," + 
                           "'" + prpLafterwardDto.getCurrency() + "'," + 
                           "'" + prpLafterwardDto.getChargeAmount() + "'," + 
                           "'" + prpLafterwardDto.getSumRealPay() + "'," + 
                           "'" + prpLafterwardDto.getDealDate() + "'," + 
                           "'" + prpLafterwardDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLafterwardDto.getClaimNo());
        dbManager.setInt(2,prpLafterwardDto.getSerialNo());
        dbManager.setString(3,prpLafterwardDto.getKindCode());
        dbManager.setString(4,prpLafterwardDto.getChargeCode());
        dbManager.setString(5,prpLafterwardDto.getChargeName());
        dbManager.setString(6,prpLafterwardDto.getCurrency());
        dbManager.setDouble(7,prpLafterwardDto.getChargeAmount());
        dbManager.setDouble(8,prpLafterwardDto.getSumRealPay());
        dbManager.setDateTime(9,prpLafterwardDto.getDealDate());
        dbManager.setString(10,prpLafterwardDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLafterwardBase.insert() success!");
    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLafterward (" + 
                           " ClaimNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " DealDate," + 
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLafterwardDto prpLafterwardDto = (PrpLafterwardDto)i.next();
            dbManager.setString(1,prpLafterwardDto.getClaimNo());
            dbManager.setInt(2,prpLafterwardDto.getSerialNo());
            dbManager.setString(3,prpLafterwardDto.getKindCode());
            dbManager.setString(4,prpLafterwardDto.getChargeCode());
            dbManager.setString(5,prpLafterwardDto.getChargeName());
            dbManager.setString(6,prpLafterwardDto.getCurrency());
            dbManager.setDouble(7,prpLafterwardDto.getChargeAmount());
            dbManager.setDouble(8,prpLafterwardDto.getSumRealPay());
            dbManager.setDateTime(9,prpLafterwardDto.getDealDate());
            dbManager.setString(10,prpLafterwardDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLafterwardBase.insertAll() success!");
    }

    /**
     * ������ɾ��һ������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLafterward" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLafterward Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLafterwardBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void update(PrpLafterwardDto prpLafterwardDto) throws Exception{
        String statement = " Update PrpLafterward Set KindCode = ?," + 
                           " ChargeCode = ?," + 
                           " ChargeName = ?," + 
                           " Currency = ?," + 
                           " ChargeAmount = ?," + 
                           " SumRealPay = ?," + 
                           " DealDate = ?," + 
                           " Flag = ?" + 
	            		   " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLafterward Set " + 
                           " ClaimNo = '" + prpLafterwardDto.getClaimNo() + "'," + 
                           " SerialNo = " + prpLafterwardDto.getSerialNo() + "," + 
                           " KindCode = '" + prpLafterwardDto.getKindCode() + "'," + 
                           " ChargeCode = '" + prpLafterwardDto.getChargeCode() + "'," + 
                           " ChargeName = '" + prpLafterwardDto.getChargeName() + "'," + 
                           " Currency = '" + prpLafterwardDto.getCurrency() + "'," + 
                           " ChargeAmount = '" + prpLafterwardDto.getChargeAmount() + "'," + 
                           " SumRealPay = '" + prpLafterwardDto.getSumRealPay() + "'," + 
                           " DealDate = '" + prpLafterwardDto.getDealDate() + "'," + 
                           " Flag = '" + prpLafterwardDto.getFlag() + "'" + 
			               " Where " +
                           " ClaimNo = '" + prpLafterwardDto.getClaimNo() + "' And " + 
                           " SerialNo = " + prpLafterwardDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLafterwardDto.getKindCode());
        dbManager.setString(2,prpLafterwardDto.getChargeCode());
        dbManager.setString(3,prpLafterwardDto.getChargeName());
        dbManager.setString(4,prpLafterwardDto.getCurrency());
        dbManager.setDouble(5,prpLafterwardDto.getChargeAmount());
        dbManager.setDouble(6,prpLafterwardDto.getSumRealPay());
        dbManager.setDateTime(7,prpLafterwardDto.getDealDate());
        dbManager.setString(8,prpLafterwardDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpLafterwardDto.getClaimNo());
        dbManager.setInt(10,prpLafterwardDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLafterwardBase.update() success!");
    }

    /**
     * ����������һ������
     * @param claimNo �ⰸ��
     * @param serialNo ���
     * @return PrpLafterwardDto
     * @throws Exception
     */
    public PrpLafterwardDto findByPrimaryKey(String claimNo,int serialNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " DealDate," + 
                           " Flag From PrpLafterward";
        String statement = mainStatement + " Where " +
                           " ClaimNo = ? And " + 
                           " SerialNo = ?";
        PrpLafterwardDto prpLafterwardDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " ClaimNo = '" + claimNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLafterwardDto = new PrpLafterwardDto();
            prpLafterwardDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLafterwardDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLafterwardDto.setKindCode(dbManager.getString(resultSet,3));
            prpLafterwardDto.setChargeCode(dbManager.getString(resultSet,4));
            prpLafterwardDto.setChargeName(dbManager.getString(resultSet,5));
            prpLafterwardDto.setCurrency(dbManager.getString(resultSet,6));
            prpLafterwardDto.setChargeAmount(dbManager.getDouble(resultSet,7));
            prpLafterwardDto.setSumRealPay(dbManager.getDouble(resultSet,8));
            prpLafterwardDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLafterwardDto.setFlag(dbManager.getString(resultSet,10));
            logger.info("DBPrpLafterwardBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLafterwardBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLafterwardDto;
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
                           " SerialNo," + 
                           " KindCode," + 
                           " ChargeCode," + 
                           " ChargeName," + 
                           " Currency," + 
                           " ChargeAmount," + 
                           " SumRealPay," + 
                           " DealDate," + 
                           " Flag From PrpLafterward Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLafterwardDto prpLafterwardDto = null;
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

            prpLafterwardDto = new PrpLafterwardDto();
            prpLafterwardDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLafterwardDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLafterwardDto.setKindCode(dbManager.getString(resultSet,3));
            prpLafterwardDto.setChargeCode(dbManager.getString(resultSet,4));
            prpLafterwardDto.setChargeName(dbManager.getString(resultSet,5));
            prpLafterwardDto.setCurrency(dbManager.getString(resultSet,6));
            prpLafterwardDto.setChargeAmount(dbManager.getDouble(resultSet,7));
            prpLafterwardDto.setSumRealPay(dbManager.getDouble(resultSet,8));
            prpLafterwardDto.setDealDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLafterwardDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpLafterwardDto);
        }
        resultSet.close();
        logger.info("DBPrpLafterwardBase.findByConditions() success!");
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
        String statement = "Delete From PrpLafterward Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLafterwardBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLafterward Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLafterwardBase.getCount() success!");
        return count;
    }
}
