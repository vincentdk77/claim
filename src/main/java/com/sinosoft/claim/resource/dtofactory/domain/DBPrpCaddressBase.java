package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCaddressDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcaddress���յ�ַ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCaddressBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpCaddressBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCaddressBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void insert(PrpCaddressDto prpCaddressDto) throws Exception{
        String statement = " Insert Into PrpCaddress(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCaddressDto.getPolicyNo());
        dbManager.setString(2,prpCaddressDto.getRiskCode());
        dbManager.setInt(3,prpCaddressDto.getAddressNo());
        dbManager.setString(4,prpCaddressDto.getAddressCode());
        dbManager.setString(5,prpCaddressDto.getAddressName());
        dbManager.setString(6,prpCaddressDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCaddressBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCaddressDto prpCaddressDto = (PrpCaddressDto)i.next();
            insert(prpCaddressDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param policyNo ��������
     * @param addressNo ��ַ���
     * @throws Exception
     */
    public void delete(String policyNo,int addressNo) throws Exception{
        String statement = " Delete From PrpCaddress Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,addressNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCaddressBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void update(PrpCaddressDto prpCaddressDto) throws Exception{
        String statement = " Update PrpCaddress Set RiskCode = ?," + 
                           " AddressCode = ?," + 
                           " AddressName = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpCaddressDto.getRiskCode());
        dbManager.setString(2,prpCaddressDto.getAddressCode());
        dbManager.setString(3,prpCaddressDto.getAddressName());
        dbManager.setString(4,prpCaddressDto.getFlag());
        //���������ֶ�;
        dbManager.setString(5,prpCaddressDto.getPolicyNo());
        dbManager.setInt(6,prpCaddressDto.getAddressNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCaddressBase.update() success!");
    }

    /**
     * ����������һ������
     * @param policyNo ��������
     * @param addressNo ��ַ���
     * @return PrpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto findByPrimaryKey(String policyNo,int addressNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag From PrpCaddress Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        PrpCaddressDto prpCaddressDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,addressNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCaddressDto = new PrpCaddressDto();
            prpCaddressDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCaddressDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCaddressDto.setAddressNo(dbManager.getInt(resultSet,3));
            prpCaddressDto.setAddressCode(dbManager.getString(resultSet,4));
            prpCaddressDto.setAddressName(dbManager.getString(resultSet,5));
            prpCaddressDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCaddressBase.findByPrimaryKey() success!");
        return prpCaddressDto;
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
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag From PrpCaddress Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCaddressDto prpCaddressDto = null;
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

            prpCaddressDto = new PrpCaddressDto();
            prpCaddressDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCaddressDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCaddressDto.setAddressNo(dbManager.getInt(resultSet,3));
            prpCaddressDto.setAddressCode(dbManager.getString(resultSet,4));
            prpCaddressDto.setAddressName(dbManager.getString(resultSet,5));
            prpCaddressDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCaddressDto);
        }
        resultSet.close();
        log.info("DBPrpCaddressBase.findByConditions() success!");
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
        String statement = "Delete From PrpCaddress Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCaddressBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCaddress Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCaddressBase.getCount() success!");
        return count;
    }
}
