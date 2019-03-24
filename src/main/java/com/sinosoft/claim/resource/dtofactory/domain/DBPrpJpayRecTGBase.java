package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRecDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrec�շѵǼǱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayRecTGBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJpayRecTGBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJpayRecTGBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void insert(PrpJpayRecDto prpJpayRecDto) throws Exception{
        String statement = " Insert Into PrpJpayRec(" +
                           " RiskCode," +
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpayRecDto.getRiskCode());
        dbManager.setString(2,prpJpayRecDto.getPolicyNo());
        dbManager.setString(3,prpJpayRecDto.getCertiNo());
        dbManager.setInt(4,prpJpayRecDto.getOrder02No());
        dbManager.setInt(5,prpJpayRecDto.getSerialNo());
        dbManager.setInt(6,prpJpayRecDto.getProfitNo());
        dbManager.setString(7,prpJpayRecDto.getPayReason());
        dbManager.setString(8,prpJpayRecDto.getCurrency1());
        dbManager.setDouble(9,prpJpayRecDto.getPayFee());
        dbManager.setDouble(10,prpJpayRecDto.getDelinquentFee());
        dbManager.setDateTime(11,prpJpayRecDto.getInputDate());
        dbManager.setString(12,prpJpayRecDto.getTransFlag());
        dbManager.setString(13,prpJpayRecDto.getCurrency2());
        dbManager.setDouble(14,prpJpayRecDto.getRealPayFee());
        dbManager.setDateTime(15,prpJpayRecDto.getRealPayDate());
        dbManager.setString(16,prpJpayRecDto.getComCode());
        dbManager.setString(17,prpJpayRecDto.getOperatorCode());
        dbManager.setString(18,prpJpayRecDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRecBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpayRecDto prpJpayRecDto = (PrpJpayRecDto)i.next();
            insert(prpJpayRecDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param certiNo ��������/��������
     * @param order02No �շ����
     * @throws Exception
     */
    public void delete(String certiNo,int order02No) throws Exception{
        String statement = " Delete From PrpJpayRec Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,order02No);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpayRecBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void update(PrpJpayRecDto prpJpayRecDto) throws Exception{
        String statement = " Update PrpJpayRec Set RiskCode = ?," +
                           " PolicyNo = ?," +
                           " SerialNo = ?," +
                           " ProfitNo = ?," +
                           " PayReason = ?," +
                           " Currency1 = ?," +
                           " PayFee = ?," +
                           " DelinquentFee = ?," +
                           " InputDate = ?," +
                           " TransFlag = ?," +
                           " Currency2 = ?," +
                           " RealPayFee = ?," +
                           " RealPayDate = ?," +
                           " ComCode = ?," +
                           " OperatorCode = ?," +
                           " Flag = ? Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpJpayRecDto.getRiskCode());
        dbManager.setString(2,prpJpayRecDto.getPolicyNo());
        dbManager.setInt(3,prpJpayRecDto.getSerialNo());
        dbManager.setInt(4,prpJpayRecDto.getProfitNo());
        dbManager.setString(5,prpJpayRecDto.getPayReason());
        dbManager.setString(6,prpJpayRecDto.getCurrency1());
        dbManager.setDouble(7,prpJpayRecDto.getPayFee());
        dbManager.setDouble(8,prpJpayRecDto.getDelinquentFee());
        dbManager.setDateTime(9,prpJpayRecDto.getInputDate());
        dbManager.setString(10,prpJpayRecDto.getTransFlag());
        dbManager.setString(11,prpJpayRecDto.getCurrency2());
        dbManager.setDouble(12,prpJpayRecDto.getRealPayFee());
        dbManager.setDateTime(13,prpJpayRecDto.getRealPayDate());
        dbManager.setString(14,prpJpayRecDto.getComCode());
        dbManager.setString(15,prpJpayRecDto.getOperatorCode());
        dbManager.setString(16,prpJpayRecDto.getFlag());
        //���������ֶ�;
        dbManager.setString(17,prpJpayRecDto.getCertiNo());
        dbManager.setInt(18,prpJpayRecDto.getOrder02No());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRecBase.update() success!");
    }

    /**
     * ����������һ������
     * @param certiNo ��������/��������
     * @param order02No �շ����
     * @return PrpJpayRecDto
     * @throws Exception
     */
    public PrpJpayRecDto findByPrimaryKey(String certiNo,int order02No) throws Exception{
        String statement = " Select RiskCode," +
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag From PrpJpayRec Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        PrpJpayRecDto prpJpayRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,order02No);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpayRecDto = new PrpJpayRecDto();
            prpJpayRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRecDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJpayRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJpayRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJpayRecDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRecDto.setPayFee(dbManager.getDouble(resultSet,9));
            prpJpayRecDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpayRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJpayRecDto.setRealPayFee(dbManager.getDouble(resultSet,14));
            prpJpayRecDto.setRealPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJpayRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJpayRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJpayRecDto.setFlag(dbManager.getString(resultSet,18));
        }
        resultSet.close();
        log.info("DBPrpJpayRecBase.findByPrimaryKey() success!");
        return prpJpayRecDto;
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
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag From PrpJpayRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpayRecDto prpJpayRecDto = null;
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

            prpJpayRecDto = new PrpJpayRecDto();
            prpJpayRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRecDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJpayRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJpayRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJpayRecDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRecDto.setPayFee(dbManager.getDouble(resultSet,9));
            prpJpayRecDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpayRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJpayRecDto.setRealPayFee(dbManager.getDouble(resultSet,14));
            prpJpayRecDto.setRealPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJpayRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJpayRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJpayRecDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(prpJpayRecDto);
        }
        resultSet.close();
        log.info("DBPrpJpayRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJpayRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpayRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJpayRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpayRecBase.getCount() success!");
        return count;
    }
}
