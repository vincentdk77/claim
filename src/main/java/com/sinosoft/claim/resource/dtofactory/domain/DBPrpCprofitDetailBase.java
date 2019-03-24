package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDetailDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcprofitdetail�Ż��ۿ���ϸ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCprofitDetailBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCprofitDetailBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCprofitDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void insert(PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        String statement = " Insert Into PrpCprofitDetail(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ProfitType," + 
                           " ProfitPeriod," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValue," + 
                           " ProfitRate," + 
                           " ChooseFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCprofitDetailDto.getPolicyNo());
        dbManager.setString(2,prpCprofitDetailDto.getRiskCode());
        dbManager.setString(3,prpCprofitDetailDto.getProfitType());
        dbManager.setInt(4,prpCprofitDetailDto.getProfitPeriod());
        dbManager.setInt(5,prpCprofitDetailDto.getItemKindNo());
        dbManager.setString(6,prpCprofitDetailDto.getKindCode());
        dbManager.setString(7,prpCprofitDetailDto.getKindName());
        dbManager.setString(8,prpCprofitDetailDto.getProfitCode());
        dbManager.setString(9,prpCprofitDetailDto.getProfitName());
        dbManager.setInt(10,prpCprofitDetailDto.getSerialNo());
        dbManager.setString(11,prpCprofitDetailDto.getCondition());
        dbManager.setDouble(12,prpCprofitDetailDto.getFieldValue());
        dbManager.setDouble(13,prpCprofitDetailDto.getProfitRate());
        dbManager.setString(14,prpCprofitDetailDto.getChooseFlag());
        dbManager.setString(15,prpCprofitDetailDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCprofitDetailBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCprofitDetailDto prpCprofitDetailDto = (PrpCprofitDetailDto)i.next();
            insert(prpCprofitDetailDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemKindNo ����������
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        String statement = " Delete From PrpCprofitDetail Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemKindNo = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemKindNo);
        dbManager.setString(4,profitCode);
        dbManager.setInt(5,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCprofitDetailBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void update(PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        String statement = " Update PrpCprofitDetail Set RiskCode = ?," + 
                           " ProfitPeriod = ?," + 
                           " KindCode = ?," + 
                           " KindName = ?," + 
                           " ProfitName = ?," + 
                           " Condition = ?," + 
                           " FieldValue = ?," + 
                           " ProfitRate = ?," + 
                           " ChooseFlag = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemKindNo = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCprofitDetailDto.getRiskCode());
        dbManager.setInt(2,prpCprofitDetailDto.getProfitPeriod());
        dbManager.setString(3,prpCprofitDetailDto.getKindCode());
        dbManager.setString(4,prpCprofitDetailDto.getKindName());
        dbManager.setString(5,prpCprofitDetailDto.getProfitName());
        dbManager.setString(6,prpCprofitDetailDto.getCondition());
        dbManager.setDouble(7,prpCprofitDetailDto.getFieldValue());
        dbManager.setDouble(8,prpCprofitDetailDto.getProfitRate());
        dbManager.setString(9,prpCprofitDetailDto.getChooseFlag());
        dbManager.setString(10,prpCprofitDetailDto.getFlag());
        //���������ֶ�;
        dbManager.setString(11,prpCprofitDetailDto.getPolicyNo());
        dbManager.setString(12,prpCprofitDetailDto.getProfitType());
        dbManager.setInt(13,prpCprofitDetailDto.getItemKindNo());
        dbManager.setString(14,prpCprofitDetailDto.getProfitCode());
        dbManager.setInt(15,prpCprofitDetailDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCprofitDetailBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ������
     * @param profitType �Ż��ۿ�����
     * @param itemKindNo ����������
     * @param profitCode �Ż��ۿ۴���
     * @param serialNo ���
     * @return PrpCprofitDetailDto
     * @throws Exception
     */
    public PrpCprofitDetailDto findByPrimaryKey(String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ProfitType," + 
                           " ProfitPeriod," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValue," + 
                           " ProfitRate," + 
                           " ChooseFlag," + 
                           " Flag From PrpCprofitDetail Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemKindNo = ? And " + 
                           " ProfitCode = ? And " + 
                           " SerialNo = ?";
        PrpCprofitDetailDto prpCprofitDetailDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemKindNo);
        dbManager.setString(4,profitCode);
        dbManager.setInt(5,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCprofitDetailDto = new PrpCprofitDetailDto();
            prpCprofitDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCprofitDetailDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCprofitDetailDto.setProfitType(dbManager.getString(resultSet,3));
            prpCprofitDetailDto.setProfitPeriod(dbManager.getInt(resultSet,4));
            prpCprofitDetailDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpCprofitDetailDto.setKindCode(dbManager.getString(resultSet,6));
            prpCprofitDetailDto.setKindName(dbManager.getString(resultSet,7));
            prpCprofitDetailDto.setProfitCode(dbManager.getString(resultSet,8));
            prpCprofitDetailDto.setProfitName(dbManager.getString(resultSet,9));
            prpCprofitDetailDto.setSerialNo(dbManager.getInt(resultSet,10));
            prpCprofitDetailDto.setCondition(dbManager.getString(resultSet,11));
            prpCprofitDetailDto.setFieldValue(dbManager.getDouble(resultSet,12));
            prpCprofitDetailDto.setProfitRate(dbManager.getDouble(resultSet,13));
            prpCprofitDetailDto.setChooseFlag(dbManager.getString(resultSet,14));
            prpCprofitDetailDto.setFlag(dbManager.getString(resultSet,15));
        }
        
        resultSet.close();
        log.info("DBPrpCprofitDetailBase.findByPrimaryKey() success!");
        return prpCprofitDetailDto;
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
                           " ProfitType," + 
                           " ProfitPeriod," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " KindName," + 
                           " ProfitCode," + 
                           " ProfitName," + 
                           " SerialNo," + 
                           " Condition," + 
                           " FieldValue," + 
                           " ProfitRate," + 
                           " ChooseFlag," + 
                           " Flag From PrpCprofitDetail Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCprofitDetailDto prpCprofitDetailDto = null;
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

            prpCprofitDetailDto = new PrpCprofitDetailDto();
            prpCprofitDetailDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCprofitDetailDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCprofitDetailDto.setProfitType(dbManager.getString(resultSet,3));
            prpCprofitDetailDto.setProfitPeriod(dbManager.getInt(resultSet,4));
            prpCprofitDetailDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpCprofitDetailDto.setKindCode(dbManager.getString(resultSet,6));
            prpCprofitDetailDto.setKindName(dbManager.getString(resultSet,7));
            prpCprofitDetailDto.setProfitCode(dbManager.getString(resultSet,8));
            prpCprofitDetailDto.setProfitName(dbManager.getString(resultSet,9));
            prpCprofitDetailDto.setSerialNo(dbManager.getInt(resultSet,10));
            prpCprofitDetailDto.setCondition(dbManager.getString(resultSet,11));
            prpCprofitDetailDto.setFieldValue(dbManager.getDouble(resultSet,12));
            prpCprofitDetailDto.setProfitRate(dbManager.getDouble(resultSet,13));
            prpCprofitDetailDto.setChooseFlag(dbManager.getString(resultSet,14));
            prpCprofitDetailDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpCprofitDetailDto);
        }
        resultSet.close();
        log.info("DBPrpCprofitDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpCprofitDetail Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCprofitDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCprofitDetail Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCprofitDetailBase.getCount() success!");
        return count;
    }
}
