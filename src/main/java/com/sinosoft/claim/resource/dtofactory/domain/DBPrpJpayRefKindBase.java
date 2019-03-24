package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefKindDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpayrefkind�ո����ձ��̯������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayRefKindBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJpayRefKindBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJpayRefKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void insert(PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        String statement = " Insert Into PrpJpayRefKind(" + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " PayReason," + 
                           " Currency1," + 
                           " PayRefFee," + 
                           " DelinquentFee," + 
                           " InputDate," + 
                           " Currency2," + 
                           " RealPayRefFee," + 
                           " RealPayRefDate," + 
                           " ComCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpayRefKindDto.getRiskCode());
        dbManager.setString(2,prpJpayRefKindDto.getPolicyNo());
        dbManager.setString(3,prpJpayRefKindDto.getCertiNo());
        dbManager.setInt(4,prpJpayRefKindDto.getSerialNo());
        dbManager.setString(5,prpJpayRefKindDto.getClauseType());
        dbManager.setString(6,prpJpayRefKindDto.getKindCode());
        dbManager.setString(7,prpJpayRefKindDto.getPayReason());
        dbManager.setString(8,prpJpayRefKindDto.getCurrency1());
        dbManager.setDouble(9,prpJpayRefKindDto.getPayRefFee());
        dbManager.setDouble(10,prpJpayRefKindDto.getDelinquentFee());
        dbManager.setDateTime(11,prpJpayRefKindDto.getInputDate());
        dbManager.setString(12,prpJpayRefKindDto.getCurrency2());
        dbManager.setDouble(13,prpJpayRefKindDto.getRealPayRefFee());
        dbManager.setDateTime(14,prpJpayRefKindDto.getRealPayRefDate());
        dbManager.setString(15,prpJpayRefKindDto.getComCode());
        dbManager.setString(16,prpJpayRefKindDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRefKindBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpayRefKindDto prpJpayRefKindDto = (PrpJpayRefKindDto)i.next();
            insert(prpJpayRefKindDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param kindCode �ձ����
     * @throws Exception
     */
    public void delete(String certiNo,int serialNo,String kindCode) throws Exception{
        String statement = " Delete From PrpJpayRefKind Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,kindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpayRefKindBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJpayRefKindDto prpJpayRefKindDto
     * @throws Exception
     */
    public void update(PrpJpayRefKindDto prpJpayRefKindDto) throws Exception{
        String statement = " Update PrpJpayRefKind Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ClauseType = ?," + 
                           " PayReason = ?," + 
                           " Currency1 = ?," + 
                           " PayRefFee = ?," + 
                           " DelinquentFee = ?," + 
                           " InputDate = ?," + 
                           " Currency2 = ?," + 
                           " RealPayRefFee = ?," + 
                           " RealPayRefDate = ?," + 
                           " ComCode = ?," + 
                           " Flag = ? Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpJpayRefKindDto.getRiskCode());
        dbManager.setString(2,prpJpayRefKindDto.getPolicyNo());
        dbManager.setString(3,prpJpayRefKindDto.getClauseType());
        dbManager.setString(4,prpJpayRefKindDto.getPayReason());
        dbManager.setString(5,prpJpayRefKindDto.getCurrency1());
        dbManager.setDouble(6,prpJpayRefKindDto.getPayRefFee());
        dbManager.setDouble(7,prpJpayRefKindDto.getDelinquentFee());
        dbManager.setDateTime(8,prpJpayRefKindDto.getInputDate());
        dbManager.setString(9,prpJpayRefKindDto.getCurrency2());
        dbManager.setDouble(10,prpJpayRefKindDto.getRealPayRefFee());
        dbManager.setDateTime(11,prpJpayRefKindDto.getRealPayRefDate());
        dbManager.setString(12,prpJpayRefKindDto.getComCode());
        dbManager.setString(13,prpJpayRefKindDto.getFlag());
        //���������ֶ�;
        dbManager.setString(14,prpJpayRefKindDto.getCertiNo());
        dbManager.setInt(15,prpJpayRefKindDto.getSerialNo());
        dbManager.setString(16,prpJpayRefKindDto.getKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRefKindBase.update() success!");
    }

    /**
     * ����������һ������
     * @param certiNo ��֤��
     * @param serialNo ���
     * @param kindCode �ձ����
     * @return PrpJpayRefKindDto
     * @throws Exception
     */
    public PrpJpayRefKindDto findByPrimaryKey(String certiNo,int serialNo,String kindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " PolicyNo," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " PayReason," + 
                           " Currency1," + 
                           " PayRefFee," + 
                           " DelinquentFee," + 
                           " InputDate," + 
                           " Currency2," + 
                           " RealPayRefFee," + 
                           " RealPayRefDate," + 
                           " ComCode," + 
                           " Flag From PrpJpayRefKind Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ? And " + 
                           " KindCode = ?";
        PrpJpayRefKindDto prpJpayRefKindDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,kindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpayRefKindDto = new PrpJpayRefKindDto();
            prpJpayRefKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRefKindDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRefKindDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRefKindDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJpayRefKindDto.setClauseType(dbManager.getString(resultSet,5));
            prpJpayRefKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpJpayRefKindDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRefKindDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRefKindDto.setPayRefFee(dbManager.getDouble(resultSet,9));
            prpJpayRefKindDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRefKindDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRefKindDto.setCurrency2(dbManager.getString(resultSet,12));
            prpJpayRefKindDto.setRealPayRefFee(dbManager.getDouble(resultSet,13));
            prpJpayRefKindDto.setRealPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpJpayRefKindDto.setComCode(dbManager.getString(resultSet,15));
            prpJpayRefKindDto.setFlag(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        log.info("DBPrpJpayRefKindBase.findByPrimaryKey() success!");
        return prpJpayRefKindDto;
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
                           " SerialNo," + 
                           " ClauseType," + 
                           " KindCode," + 
                           " PayReason," + 
                           " Currency1," + 
                           " PayRefFee," + 
                           " DelinquentFee," + 
                           " InputDate," + 
                           " Currency2," + 
                           " RealPayRefFee," + 
                           " RealPayRefDate," + 
                           " ComCode," + 
                           " Flag From PrpJpayRefKind Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpayRefKindDto prpJpayRefKindDto = null;
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

            prpJpayRefKindDto = new PrpJpayRefKindDto();
            prpJpayRefKindDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRefKindDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRefKindDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRefKindDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJpayRefKindDto.setClauseType(dbManager.getString(resultSet,5));
            prpJpayRefKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpJpayRefKindDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRefKindDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRefKindDto.setPayRefFee(dbManager.getDouble(resultSet,9));
            prpJpayRefKindDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRefKindDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRefKindDto.setCurrency2(dbManager.getString(resultSet,12));
            prpJpayRefKindDto.setRealPayRefFee(dbManager.getDouble(resultSet,13));
            prpJpayRefKindDto.setRealPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpJpayRefKindDto.setComCode(dbManager.getString(resultSet,15));
            prpJpayRefKindDto.setFlag(dbManager.getString(resultSet,16));
            collection.add(prpJpayRefKindDto);
        }
        resultSet.close();
        log.info("DBPrpJpayRefKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpJpayRefKind Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpayRefKindBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJpayRefKind Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpayRefKindBase.getCount() success!");
        return count;
    }
}
