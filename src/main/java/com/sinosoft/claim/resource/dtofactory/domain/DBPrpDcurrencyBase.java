package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcurrencyDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcurrency�ұ���������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcurrencyBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDcurrencyBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcurrencyBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void insert(PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        String statement = " Insert Into PrpDcurrency(" +
                           " CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDcurrencyDto.getCurrencyCode());
        dbManager.setString(2,prpDcurrencyDto.getCurrencyCName());
        dbManager.setString(3,prpDcurrencyDto.getCurrencyEName());
        dbManager.setString(4,prpDcurrencyDto.getNewCurrencyCode());
        dbManager.setString(5,prpDcurrencyDto.getValidStatus());
        dbManager.setString(6,prpDcurrencyDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcurrencyBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto)i.next();
            insert(prpDcurrencyDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param currencyCode �ұ����
     * @throws Exception
     */
    public void delete(String currencyCode) throws Exception{
        String statement = " Delete From PrpDcurrency Where " +
                           " CurrencyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,currencyCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDcurrencyBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDcurrencyDto prpDcurrencyDto
     * @throws Exception
     */
    public void update(PrpDcurrencyDto prpDcurrencyDto) throws Exception{
        String statement = " Update PrpDcurrency Set CurrencyCName = ?," +
                           " CurrencyEName = ?," +
                           " NewCurrencyCode = ?," +
                           " ValidStatus = ?," +
                           " Flag = ? Where " +
                           " CurrencyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDcurrencyDto.getCurrencyCName());
        dbManager.setString(2,prpDcurrencyDto.getCurrencyEName());
        dbManager.setString(3,prpDcurrencyDto.getNewCurrencyCode());
        dbManager.setString(4,prpDcurrencyDto.getValidStatus());
        dbManager.setString(5,prpDcurrencyDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpDcurrencyDto.getCurrencyCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDcurrencyBase.update() success!");
    }

    /**
     * ����������һ������
     * @param currencyCode �ұ����
     * @return PrpDcurrencyDto
     * @throws Exception
     */
    public PrpDcurrencyDto findByPrimaryKey(String currencyCode) throws Exception{
        String statement = " Select CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag From PrpDcurrency Where " +
                           " CurrencyCode = ?";
        PrpDcurrencyDto prpDcurrencyDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,currencyCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDcurrencyDto = new PrpDcurrencyDto();
            prpDcurrencyDto.setCurrencyCode(dbManager.getString(resultSet,1));
            prpDcurrencyDto.setCurrencyCName(dbManager.getString(resultSet,2));
            prpDcurrencyDto.setCurrencyEName(dbManager.getString(resultSet,3));
            prpDcurrencyDto.setNewCurrencyCode(dbManager.getString(resultSet,4));
            prpDcurrencyDto.setValidStatus(dbManager.getString(resultSet,5));
            prpDcurrencyDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpDcurrencyBase.findByPrimaryKey() success!");
        return prpDcurrencyDto;
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
        String statement = "Select CurrencyCode," +
                           " CurrencyCName," +
                           " CurrencyEName," +
                           " NewCurrencyCode," +
                           " ValidStatus," +
                           " Flag From PrpDcurrency Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDcurrencyDto prpDcurrencyDto = null;
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

            prpDcurrencyDto = new PrpDcurrencyDto();
            prpDcurrencyDto.setCurrencyCode(dbManager.getString(resultSet,1));
            prpDcurrencyDto.setCurrencyCName(dbManager.getString(resultSet,2));
            prpDcurrencyDto.setCurrencyEName(dbManager.getString(resultSet,3));
            prpDcurrencyDto.setNewCurrencyCode(dbManager.getString(resultSet,4));
            prpDcurrencyDto.setValidStatus(dbManager.getString(resultSet,5));
            prpDcurrencyDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpDcurrencyDto);
        }
        resultSet.close();
        log.info("DBPrpDcurrencyBase.findByConditions() success!");
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
        String statement = "Delete From PrpDcurrency Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDcurrencyBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDcurrency Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDcurrencyBase.getCount() success!");
        return count;
    }
}
