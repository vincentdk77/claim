package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDportDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdport�ۿڴ�������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDportBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDportBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDportBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void insert(PrpDportDto prpDportDto) throws Exception{
        String statement = " Insert Into PrpDport(" + 
                           " PortCode," + 
                           " PortCName," + 
                           " PortEName," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " NewPortCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDportDto.getPortCode());
        dbManager.setString(2,prpDportDto.getPortCName());
        dbManager.setString(3,prpDportDto.getPortEName());
        dbManager.setString(4,prpDportDto.getCountryCode());
        dbManager.setString(5,prpDportDto.getCountryCName());
        dbManager.setString(6,prpDportDto.getCountryEName());
        dbManager.setString(7,prpDportDto.getNewPortCode());
        dbManager.setString(8,prpDportDto.getValidStatus());
        dbManager.setString(9,prpDportDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDportBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDportDto prpDportDto = (PrpDportDto)i.next();
            insert(prpDportDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param portCode �ۿڴ���
     * @throws Exception
     */
    public void delete(String portCode) throws Exception{
        String statement = " Delete From PrpDport Where " +
                           " PortCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,portCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDportBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void update(PrpDportDto prpDportDto) throws Exception{
        String statement = " Update PrpDport Set PortCName = ?," + 
                           " PortEName = ?," + 
                           " CountryCode = ?," + 
                           " CountryCName = ?," + 
                           " CountryEName = ?," + 
                           " NewPortCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " PortCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDportDto.getPortCName());
        dbManager.setString(2,prpDportDto.getPortEName());
        dbManager.setString(3,prpDportDto.getCountryCode());
        dbManager.setString(4,prpDportDto.getCountryCName());
        dbManager.setString(5,prpDportDto.getCountryEName());
        dbManager.setString(6,prpDportDto.getNewPortCode());
        dbManager.setString(7,prpDportDto.getValidStatus());
        dbManager.setString(8,prpDportDto.getFlag());
        //���������ֶ�;
        dbManager.setString(9,prpDportDto.getPortCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDportBase.update() success!");
    }

    /**
     * ����������һ������
     * @param portCode �ۿڴ���
     * @return PrpDportDto
     * @throws Exception
     */
    public PrpDportDto findByPrimaryKey(String portCode) throws Exception{
        String statement = " Select PortCode," + 
                           " PortCName," + 
                           " PortEName," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " NewPortCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDport Where " +
                           " PortCode = ?";
        PrpDportDto prpDportDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,portCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDportDto = new PrpDportDto();
            prpDportDto.setPortCode(dbManager.getString(resultSet,1));
            prpDportDto.setPortCName(dbManager.getString(resultSet,2));
            prpDportDto.setPortEName(dbManager.getString(resultSet,3));
            prpDportDto.setCountryCode(dbManager.getString(resultSet,4));
            prpDportDto.setCountryCName(dbManager.getString(resultSet,5));
            prpDportDto.setCountryEName(dbManager.getString(resultSet,6));
            prpDportDto.setNewPortCode(dbManager.getString(resultSet,7));
            prpDportDto.setValidStatus(dbManager.getString(resultSet,8));
            prpDportDto.setFlag(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        log.info("DBPrpDportBase.findByPrimaryKey() success!");
        return prpDportDto;
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
        String statement = "Select PortCode," + 
                           " PortCName," + 
                           " PortEName," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " NewPortCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDport Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDportDto prpDportDto = null;
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

            prpDportDto = new PrpDportDto();
            prpDportDto.setPortCode(dbManager.getString(resultSet,1));
            prpDportDto.setPortCName(dbManager.getString(resultSet,2));
            prpDportDto.setPortEName(dbManager.getString(resultSet,3));
            prpDportDto.setCountryCode(dbManager.getString(resultSet,4));
            prpDportDto.setCountryCName(dbManager.getString(resultSet,5));
            prpDportDto.setCountryEName(dbManager.getString(resultSet,6));
            prpDportDto.setNewPortCode(dbManager.getString(resultSet,7));
            prpDportDto.setValidStatus(dbManager.getString(resultSet,8));
            prpDportDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpDportDto);
        }
        resultSet.close();
        log.info("DBPrpDportBase.findByConditions() success!");
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
        String statement = "Delete From PrpDport Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDportBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDport Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDportBase.getCount() success!");
        return count;
    }
}
