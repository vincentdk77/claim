package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitem���ձ����Ŀ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCitemBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCitemBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void insert(PrpCitemDto prpCitemDto) throws Exception{
        String statement = " Insert Into PrpCitem(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCitemDto.getPolicyNo());
        dbManager.setString(2,prpCitemDto.getRiskCode());
        dbManager.setInt(3,prpCitemDto.getItemNo());
        dbManager.setString(4,prpCitemDto.getItemCode());
        dbManager.setString(5,prpCitemDto.getItemName());
        dbManager.setDouble(6,prpCitemDto.getPlusRate());
        dbManager.setInt(7,prpCitemDto.getAddressNo());
        dbManager.setString(8,prpCitemDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCitemDto prpCitemDto = (PrpCitemDto)i.next();
            insert(prpCitemDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param itemNo ������
     * @throws Exception
     */
    public void delete(String policyNo,int itemNo) throws Exception{
        String statement = " Delete From PrpCitem Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCitemBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void update(PrpCitemDto prpCitemDto) throws Exception{
        String statement = " Update PrpCitem Set RiskCode = ?," + 
                           " ItemCode = ?," + 
                           " ItemName = ?," + 
                           " PlusRate = ?," + 
                           " AddressNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCitemDto.getRiskCode());
        dbManager.setString(2,prpCitemDto.getItemCode());
        dbManager.setString(3,prpCitemDto.getItemName());
        dbManager.setDouble(4,prpCitemDto.getPlusRate());
        dbManager.setInt(5,prpCitemDto.getAddressNo());
        dbManager.setString(6,prpCitemDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpCitemDto.getPolicyNo());
        dbManager.setInt(8,prpCitemDto.getItemNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param itemNo ������
     * @return PrpCitemDto
     * @throws Exception
     */
    public PrpCitemDto findByPrimaryKey(String policyNo,int itemNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag From PrpCitem Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        PrpCitemDto prpCitemDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCitemDto = new PrpCitemDto();
            prpCitemDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCitemDto.setItemCode(dbManager.getString(resultSet,4));
            prpCitemDto.setItemName(dbManager.getString(resultSet,5));
            prpCitemDto.setPlusRate(dbManager.getDouble(resultSet,6));
            prpCitemDto.setAddressNo(dbManager.getInt(resultSet,7));
            prpCitemDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpCitemBase.findByPrimaryKey() success!");
        return prpCitemDto;
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
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag From PrpCitem Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCitemDto prpCitemDto = null;
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

            prpCitemDto = new PrpCitemDto();
            prpCitemDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCitemDto.setItemCode(dbManager.getString(resultSet,4));
            prpCitemDto.setItemName(dbManager.getString(resultSet,5));
            prpCitemDto.setPlusRate(dbManager.getDouble(resultSet,6));
            prpCitemDto.setAddressNo(dbManager.getInt(resultSet,7));
            prpCitemDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpCitemDto);
        }
        resultSet.close();
        log.info("DBPrpCitemBase.findByConditions() success!");
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
        String statement = "Delete From PrpCitem Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCitemBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCitem Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCitemBase.getCount() success!");
        return count;
    }
}
