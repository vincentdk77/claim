package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPprofitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prppprofit�Ż���Ϣ������ݷ��ʶ������<br>
 * ������ 2004-11-22 15:24:20.578<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPprofitBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log logger = LogFactory.getLog(DBPrpPprofitBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpPprofitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpPprofitDto prpPprofitDto
     * @throws Exception
     */
    public void insert(PrpPprofitDto prpPprofitDto) throws Exception{
        String mainStatement = " Insert Into PrpPprofit (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPprofitDto.getEndorseNo() + "'," +
                           "'" + prpPprofitDto.getPolicyNo() + "'," +
                           "'" + prpPprofitDto.getRiskCode() + "'," +
                           "'" + prpPprofitDto.getProfitType() + "'," +
                           "" + prpPprofitDto.getItemkindNo() + "," +
                           "'" + prpPprofitDto.getKindCode() + "'," +
                           "'" + prpPprofitDto.getCurrency() + "'," +
                           "'" + prpPprofitDto.getDiscount() + "'," +
                           "'" + prpPprofitDto.getTotalProfit() + "'," +
                           "'" + prpPprofitDto.getMinusFlag() + "'," +
                           "'" + prpPprofitDto.getHandlerCode() + "'," +
                           "'" + prpPprofitDto.getApproverCode() + "'," +
                           "'" + prpPprofitDto.getOperatorCode() + "'," +
                           "'" + prpPprofitDto.getInputDate() + "'," +
                           "'" + prpPprofitDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPprofitDto.getEndorseNo());
        dbManager.setString(2,prpPprofitDto.getPolicyNo());
        dbManager.setString(3,prpPprofitDto.getRiskCode());
        dbManager.setString(4,prpPprofitDto.getProfitType());
        dbManager.setInt(5,prpPprofitDto.getItemkindNo());
        dbManager.setString(6,prpPprofitDto.getKindCode());
        dbManager.setString(7,prpPprofitDto.getCurrency());
        dbManager.setDouble(8,prpPprofitDto.getDiscount());
        dbManager.setDouble(9,prpPprofitDto.getTotalProfit());
        dbManager.setString(10,prpPprofitDto.getMinusFlag());
        dbManager.setString(11,prpPprofitDto.getHandlerCode());
        dbManager.setString(12,prpPprofitDto.getApproverCode());
        dbManager.setString(13,prpPprofitDto.getOperatorCode());
        dbManager.setDateTime(14,prpPprofitDto.getInputDate());
        dbManager.setString(15,prpPprofitDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPprofitBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPprofitDto prpPprofitDto = (PrpPprofitDto)i.next();
            insert(prpPprofitDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param endorseNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemkindNo ����ձ����
     * @throws Exception
     */
    public void delete(String endorseNo,String profitType,int itemkindNo) throws Exception{
        String statement = " Delete From PrpPprofit" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPprofit Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ProfitType = '" + profitType + "' And " +
                           " ItemkindNo = " + itemkindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPprofitBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpPprofitDto prpPprofitDto
     * @throws Exception
     */
    public void update(PrpPprofitDto prpPprofitDto) throws Exception{
        String statement = " Update PrpPprofit Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " KindCode = ?," +
                           " Currency = ?," +
                           " Discount = ?," +
                           " TotalProfit = ?," +
                           " MinusFlag = ?," +
                           " HandlerCode = ?," +
                           " ApproverCode = ?," +
                           " OperatorCode = ?," +
                           " InputDate = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPprofit Set " +
                           " EndorseNo = '" + prpPprofitDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPprofitDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPprofitDto.getRiskCode() + "'," +
                           " ProfitType = '" + prpPprofitDto.getProfitType() + "'," +
                           " ItemkindNo = " + prpPprofitDto.getItemkindNo() + "," +
                           " KindCode = '" + prpPprofitDto.getKindCode() + "'," +
                           " Currency = '" + prpPprofitDto.getCurrency() + "'," +
                           " Discount = '" + prpPprofitDto.getDiscount() + "'," +
                           " TotalProfit = '" + prpPprofitDto.getTotalProfit() + "'," +
                           " MinusFlag = '" + prpPprofitDto.getMinusFlag() + "'," +
                           " HandlerCode = '" + prpPprofitDto.getHandlerCode() + "'," +
                           " ApproverCode = '" + prpPprofitDto.getApproverCode() + "'," +
                           " OperatorCode = '" + prpPprofitDto.getOperatorCode() + "'," +
                           " InputDate = '" + prpPprofitDto.getInputDate() + "'," +
                           " Flag = '" + prpPprofitDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPprofitDto.getEndorseNo() + "' And " +
                           " ProfitType = '" + prpPprofitDto.getProfitType() + "' And " +
                           " ItemkindNo = " + prpPprofitDto.getItemkindNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpPprofitDto.getPolicyNo());
        dbManager.setString(2,prpPprofitDto.getRiskCode());
        dbManager.setString(3,prpPprofitDto.getKindCode());
        dbManager.setString(4,prpPprofitDto.getCurrency());
        dbManager.setDouble(5,prpPprofitDto.getDiscount());
        dbManager.setDouble(6,prpPprofitDto.getTotalProfit());
        dbManager.setString(7,prpPprofitDto.getMinusFlag());
        dbManager.setString(8,prpPprofitDto.getHandlerCode());
        dbManager.setString(9,prpPprofitDto.getApproverCode());
        dbManager.setString(10,prpPprofitDto.getOperatorCode());
        dbManager.setDateTime(11,prpPprofitDto.getInputDate());
        dbManager.setString(12,prpPprofitDto.getFlag());
        //���������ֶ�;
        dbManager.setString(13,prpPprofitDto.getEndorseNo());
        dbManager.setString(14,prpPprofitDto.getProfitType());
        dbManager.setInt(15,prpPprofitDto.getItemkindNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPprofitBase.update() success!");
    }

    /**
     * ����������һ������
     * @param endorseNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemkindNo ����ձ����
     * @return PrpPprofitDto
     * @throws Exception
     */
    public PrpPprofitDto findByPrimaryKey(String endorseNo,String profitType,int itemkindNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag From PrpPprofit";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        PrpPprofitDto prpPprofitDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ProfitType = '" + profitType + "' And " +
                           " ItemkindNo = " + itemkindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPprofitDto = new PrpPprofitDto();
            prpPprofitDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPprofitDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPprofitDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPprofitDto.setProfitType(dbManager.getString(resultSet,4));
            prpPprofitDto.setItemkindNo(dbManager.getInt(resultSet,5));
            prpPprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpPprofitDto.setCurrency(dbManager.getString(resultSet,7));
            prpPprofitDto.setDiscount(dbManager.getDouble(resultSet,8));
            prpPprofitDto.setTotalProfit(dbManager.getDouble(resultSet,9));
            prpPprofitDto.setMinusFlag(dbManager.getString(resultSet,10));
            prpPprofitDto.setHandlerCode(dbManager.getString(resultSet,11));
            prpPprofitDto.setApproverCode(dbManager.getString(resultSet,12));
            prpPprofitDto.setOperatorCode(dbManager.getString(resultSet,13));
            prpPprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPprofitDto.setFlag(dbManager.getString(resultSet,15));
        }
        resultSet.close();
        logger.info("DBPrpPprofitBase.findByPrimaryKey() success!");
        return prpPprofitDto;
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
                           " RiskCode," +
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag From PrpPprofit Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPprofitDto prpPprofitDto = null;
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

            prpPprofitDto = new PrpPprofitDto();
            prpPprofitDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPprofitDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPprofitDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPprofitDto.setProfitType(dbManager.getString(resultSet,4));
            prpPprofitDto.setItemkindNo(dbManager.getInt(resultSet,5));
            prpPprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpPprofitDto.setCurrency(dbManager.getString(resultSet,7));
            prpPprofitDto.setDiscount(dbManager.getDouble(resultSet,8));
            prpPprofitDto.setTotalProfit(dbManager.getDouble(resultSet,9));
            prpPprofitDto.setMinusFlag(dbManager.getString(resultSet,10));
            prpPprofitDto.setHandlerCode(dbManager.getString(resultSet,11));
            prpPprofitDto.setApproverCode(dbManager.getString(resultSet,12));
            prpPprofitDto.setOperatorCode(dbManager.getString(resultSet,13));
            prpPprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPprofitDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpPprofitDto);
        }
        resultSet.close();
        logger.info("DBPrpPprofitBase.findByConditions() success!");
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
        String statement = "Delete From PrpPprofit Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPprofitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPprofit Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPprofitBase.getCount() success!");
        return count;
    }
}
