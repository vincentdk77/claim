package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDexchDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdexch�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDexchBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDexchBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDexchBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void insert(PrpDexchDto prpDexchDto) throws Exception{
        String statement = " Insert Into PrpDexch(" + 
                           " ExchDate," + 
                           " Base," + 
                           " BaseCurrency," + 
                           " ExchCurrency," + 
                           " ExchRate," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setDateTime(1,prpDexchDto.getExchDate());
        dbManager.setDouble(2,prpDexchDto.getBase());
        dbManager.setString(3,prpDexchDto.getBaseCurrency());
        dbManager.setString(4,prpDexchDto.getExchCurrency());
        dbManager.setDouble(5,prpDexchDto.getExchRate());
        dbManager.setString(6,prpDexchDto.getValidStatus());
        dbManager.setString(7,prpDexchDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDexchBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDexchDto prpDexchDto = (PrpDexchDto)i.next();
            insert(prpDexchDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param exchDate exchdate
     * @param baseCurrency basecurrency
     * @param exchCurrency exchcurrency
     * @throws Exception
     */
    public void delete(DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        String statement = " Delete From PrpDexch Where " +
                           " ExchDate = ? And " + 
                           " BaseCurrency = ? And " + 
                           " ExchCurrency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setDateTime(1,exchDate);
        dbManager.setString(2,baseCurrency);
        dbManager.setString(3,exchCurrency);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDexchBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDexchDto prpDexchDto
     * @throws Exception
     */
    public void update(PrpDexchDto prpDexchDto) throws Exception{
        String statement = " Update PrpDexch Set Base = ?," + 
                           " ExchRate = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ExchDate = ? And " + 
                           " BaseCurrency = ? And " + 
                           " ExchCurrency = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setDouble(1,prpDexchDto.getBase());
        dbManager.setDouble(2,prpDexchDto.getExchRate());
        dbManager.setString(3,prpDexchDto.getValidStatus());
        dbManager.setString(4,prpDexchDto.getFlag());
        //���������ֶ�;
        dbManager.setDateTime(5,prpDexchDto.getExchDate());
        dbManager.setString(6,prpDexchDto.getBaseCurrency());
        dbManager.setString(7,prpDexchDto.getExchCurrency());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDexchBase.update() success!");
    }

    /**
     * ����������һ������
     * @param exchDate exchdate
     * @param baseCurrency basecurrency
     * @param exchCurrency exchcurrency
     * @return PrpDexchDto
     * @throws Exception
     */
    public PrpDexchDto findByPrimaryKey(DateTime exchDate,String baseCurrency,String exchCurrency) throws Exception{
        String statement = " Select ExchDate," + 
                           " Base," + 
                           " BaseCurrency," + 
                           " ExchCurrency," + 
                           " ExchRate," + 
                           " ValidStatus," + 
                           " Flag From PrpDexch Where " +
                           " ExchDate = ? And " + 
                           " BaseCurrency = ? And " + 
                           " ExchCurrency = ?";
        PrpDexchDto prpDexchDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setDateTime(1,exchDate);
        dbManager.setString(2,baseCurrency);
        dbManager.setString(3,exchCurrency);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDexchDto = new PrpDexchDto();
            prpDexchDto.setExchDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1));
            prpDexchDto.setBase(dbManager.getDouble(resultSet,2));
            prpDexchDto.setBaseCurrency(dbManager.getString(resultSet,3));
            prpDexchDto.setExchCurrency(dbManager.getString(resultSet,4));
            prpDexchDto.setExchRate(dbManager.getDouble(resultSet,5));
            prpDexchDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDexchDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDexchBase.findByPrimaryKey() success!");
        return prpDexchDto;
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
        String statement = "Select ExchDate," + 
                           " Base," + 
                           " BaseCurrency," + 
                           " ExchCurrency," + 
                           " ExchRate," + 
                           " ValidStatus," + 
                           " Flag From PrpDexch Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDexchDto prpDexchDto = null;
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

            prpDexchDto = new PrpDexchDto();
            prpDexchDto.setExchDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1));
            prpDexchDto.setBase(dbManager.getDouble(resultSet,2));
            prpDexchDto.setBaseCurrency(dbManager.getString(resultSet,3));
            prpDexchDto.setExchCurrency(dbManager.getString(resultSet,4));
            prpDexchDto.setExchRate(dbManager.getDouble(resultSet,5));
            prpDexchDto.setValidStatus(dbManager.getString(resultSet,6));
            prpDexchDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDexchDto);
        }
        resultSet.close();
        log.info("DBPrpDexchBase.findByConditions() success!");
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
        String statement = "Delete From PrpDexch Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDexchBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDexch Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDexchBase.getCount() success!");
        return count;
    }
}