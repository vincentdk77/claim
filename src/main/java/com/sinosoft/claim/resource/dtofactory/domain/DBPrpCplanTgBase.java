package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcplan�շѼƻ�������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCplanTgBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCplanTgBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCplanTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void insert(PrpCplanDto prpCplanDto) throws Exception{
        String statement = " Insert Into PrpCplanTg(" + 
                           " PolicyNo," + 
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCplanDto.getPolicyNo());
        dbManager.setString(2,prpCplanDto.getEndorseNo());
        dbManager.setInt(3,prpCplanDto.getSerialNo());
        dbManager.setInt(4,prpCplanDto.getPayNo());
        dbManager.setString(5,prpCplanDto.getPayReason());
        dbManager.setDateTime(6,prpCplanDto.getPlanDate());
        dbManager.setString(7,prpCplanDto.getCurrency());
        dbManager.setDouble(8,prpCplanDto.getPlanFee());
        dbManager.setDouble(9,prpCplanDto.getDelinquentFee());
        dbManager.setString(10,prpCplanDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCplanBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCplanDto prpCplanDto = (PrpCplanDto)i.next();
            insert(prpCplanDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param serialNo ���Ѵ������
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCplanTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCplanBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void update(PrpCplanDto prpCplanDto) throws Exception{
        String statement = " Update PrpCplanTg Set EndorseNo = ?," + 
                           " PayNo = ?," + 
                           " PayReason = ?," + 
                           " PlanDate = ?," + 
                           " Currency = ?," + 
                           " PlanFee = ?," + 
                           " DelinquentFee = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCplanDto.getEndorseNo());
        dbManager.setInt(2,prpCplanDto.getPayNo());
        dbManager.setString(3,prpCplanDto.getPayReason());
        dbManager.setDateTime(4,prpCplanDto.getPlanDate());
        dbManager.setString(5,prpCplanDto.getCurrency());
        dbManager.setDouble(6,prpCplanDto.getPlanFee());
        dbManager.setDouble(7,prpCplanDto.getDelinquentFee());
        dbManager.setString(8,prpCplanDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpCplanDto.getPolicyNo());
        dbManager.setInt(10,prpCplanDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCplanBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param serialNo ���Ѵ������
     * @return PrpCplanDto
     * @throws Exception
     */
    public PrpCplanDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag From PrpCplanTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCplanDto prpCplanDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCplanDto = new PrpCplanDto();
            prpCplanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCplanDto.setEndorseNo(dbManager.getString(resultSet,2));
            prpCplanDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCplanDto.setPayNo(dbManager.getInt(resultSet,4));
            prpCplanDto.setPayReason(dbManager.getString(resultSet,5));
            prpCplanDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCplanDto.setCurrency(dbManager.getString(resultSet,7));
            prpCplanDto.setPlanFee(dbManager.getDouble(resultSet,8));
            prpCplanDto.setDelinquentFee(dbManager.getDouble(resultSet,9));
            prpCplanDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpCplanBase.findByPrimaryKey() success!");
        return prpCplanDto;
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
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag From PrpCplanTg Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCplanDto prpCplanDto = null;
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

            prpCplanDto = new PrpCplanDto();
            prpCplanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCplanDto.setEndorseNo(dbManager.getString(resultSet,2));
            prpCplanDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCplanDto.setPayNo(dbManager.getInt(resultSet,4));
            prpCplanDto.setPayReason(dbManager.getString(resultSet,5));
            prpCplanDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCplanDto.setCurrency(dbManager.getString(resultSet,7));
            prpCplanDto.setPlanFee(dbManager.getDouble(resultSet,8));
            prpCplanDto.setDelinquentFee(dbManager.getDouble(resultSet,9));
            prpCplanDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpCplanDto);
        }
        resultSet.close();
        log.info("DBPrpCplanBase.findByConditions() success!");
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
        String statement = "Delete From PrpCplanTg Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCplanBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCplanTg Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCplanBase.getCount() success!");
        return count;
    }
}
