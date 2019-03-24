package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitCondDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjprofitcond�Ż�����������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJprofitCondBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJprofitCondBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJprofitCondBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJprofitCondDto prpJprofitCondDto
     * @throws Exception
     */
    public void insert(PrpJprofitCondDto prpJprofitCondDto) throws Exception{
        String statement = " Insert Into PrpJprofitCond(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ProfitReason," + 
                           " InternetApply," + 
                           " UseNatureCode," + 
                           " CarKindCode," + 
                           " RenewalFlag," + 
                           " FieldEName," + 
                           " FieldValue," + 
                           " FieldEName1," + 
                           " FieldValue1," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJprofitCondDto.getPolicyNo());
        dbManager.setInt(2,prpJprofitCondDto.getSerialNo());
        dbManager.setString(3,prpJprofitCondDto.getProfitReason());
        dbManager.setString(4,prpJprofitCondDto.getInternetApply());
        dbManager.setString(5,prpJprofitCondDto.getUseNatureCode());
        dbManager.setString(6,prpJprofitCondDto.getCarKindCode());
        dbManager.setString(7,prpJprofitCondDto.getRenewalFlag());
        dbManager.setString(8,prpJprofitCondDto.getFieldEName());
        dbManager.setInt(9,prpJprofitCondDto.getFieldValue());
        dbManager.setString(10,prpJprofitCondDto.getFieldEName1());
        dbManager.setInt(11,prpJprofitCondDto.getFieldValue1());
        dbManager.setString(12,prpJprofitCondDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJprofitCondBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJprofitCondDto prpJprofitCondDto = (PrpJprofitCondDto)i.next();
            insert(prpJprofitCondDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ���յ��Ŵ�
     * @throws Exception
     */
    public void delete(String policyNo) throws Exception{
        String statement = " Delete From PrpJprofitCond Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJprofitCondBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJprofitCondDto prpJprofitCondDto
     * @throws Exception
     */
    public void update(PrpJprofitCondDto prpJprofitCondDto) throws Exception{
        String statement = " Update PrpJprofitCond Set SerialNo = ?," + 
                           " ProfitReason = ?," + 
                           " InternetApply = ?," + 
                           " UseNatureCode = ?," + 
                           " CarKindCode = ?," + 
                           " RenewalFlag = ?," + 
                           " FieldEName = ?," + 
                           " FieldValue = ?," + 
                           " FieldEName1 = ?," + 
                           " FieldValue1 = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setInt(1,prpJprofitCondDto.getSerialNo());
        dbManager.setString(2,prpJprofitCondDto.getProfitReason());
        dbManager.setString(3,prpJprofitCondDto.getInternetApply());
        dbManager.setString(4,prpJprofitCondDto.getUseNatureCode());
        dbManager.setString(5,prpJprofitCondDto.getCarKindCode());
        dbManager.setString(6,prpJprofitCondDto.getRenewalFlag());
        dbManager.setString(7,prpJprofitCondDto.getFieldEName());
        dbManager.setInt(8,prpJprofitCondDto.getFieldValue());
        dbManager.setString(9,prpJprofitCondDto.getFieldEName1());
        dbManager.setInt(10,prpJprofitCondDto.getFieldValue1());
        dbManager.setString(11,prpJprofitCondDto.getFlag());
        //���������ֶ�;
        dbManager.setString(12,prpJprofitCondDto.getPolicyNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJprofitCondBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ���յ��Ŵ�
     * @return PrpJprofitCondDto
     * @throws Exception
     */
    public PrpJprofitCondDto findByPrimaryKey(String policyNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " ProfitReason," + 
                           " InternetApply," + 
                           " UseNatureCode," + 
                           " CarKindCode," + 
                           " RenewalFlag," + 
                           " FieldEName," + 
                           " FieldValue," + 
                           " FieldEName1," + 
                           " FieldValue1," + 
                           " Flag From PrpJprofitCond Where " +
                           " PolicyNo = ?";
        PrpJprofitCondDto prpJprofitCondDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJprofitCondDto = new PrpJprofitCondDto();
            prpJprofitCondDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJprofitCondDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJprofitCondDto.setProfitReason(dbManager.getString(resultSet,3));
            prpJprofitCondDto.setInternetApply(dbManager.getString(resultSet,4));
            prpJprofitCondDto.setUseNatureCode(dbManager.getString(resultSet,5));
            prpJprofitCondDto.setCarKindCode(dbManager.getString(resultSet,6));
            prpJprofitCondDto.setRenewalFlag(dbManager.getString(resultSet,7));
            prpJprofitCondDto.setFieldEName(dbManager.getString(resultSet,8));
            prpJprofitCondDto.setFieldValue(dbManager.getInt(resultSet,9));
            prpJprofitCondDto.setFieldEName1(dbManager.getString(resultSet,10));
            prpJprofitCondDto.setFieldValue1(dbManager.getInt(resultSet,11));
            prpJprofitCondDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        log.info("DBPrpJprofitCondBase.findByPrimaryKey() success!");
        return prpJprofitCondDto;
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
                           " SerialNo," + 
                           " ProfitReason," + 
                           " InternetApply," + 
                           " UseNatureCode," + 
                           " CarKindCode," + 
                           " RenewalFlag," + 
                           " FieldEName," + 
                           " FieldValue," + 
                           " FieldEName1," + 
                           " FieldValue1," + 
                           " Flag From PrpJprofitCond Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJprofitCondDto prpJprofitCondDto = null;
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

            prpJprofitCondDto = new PrpJprofitCondDto();
            prpJprofitCondDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJprofitCondDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpJprofitCondDto.setProfitReason(dbManager.getString(resultSet,3));
            prpJprofitCondDto.setInternetApply(dbManager.getString(resultSet,4));
            prpJprofitCondDto.setUseNatureCode(dbManager.getString(resultSet,5));
            prpJprofitCondDto.setCarKindCode(dbManager.getString(resultSet,6));
            prpJprofitCondDto.setRenewalFlag(dbManager.getString(resultSet,7));
            prpJprofitCondDto.setFieldEName(dbManager.getString(resultSet,8));
            prpJprofitCondDto.setFieldValue(dbManager.getInt(resultSet,9));
            prpJprofitCondDto.setFieldEName1(dbManager.getString(resultSet,10));
            prpJprofitCondDto.setFieldValue1(dbManager.getInt(resultSet,11));
            prpJprofitCondDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpJprofitCondDto);
        }
        resultSet.close();
        log.info("DBPrpJprofitCondBase.findByConditions() success!");
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
        String statement = "Delete From PrpJprofitCond Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJprofitCondBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpJprofitCond Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJprofitCondBase.getCount() success!");
        return count;
    }
}
