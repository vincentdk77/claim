package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDidentifierDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdidentifier�����˴��������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDidentifierBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDidentifierBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDidentifierBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void insert(PrpDidentifierDto prpDidentifierDto) throws Exception{
        String statement = " Insert Into PrpDidentifier(" + 
                           " IdentifierCode," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " PortCode," + 
                           " PortName," + 
                           " IdentifierOrder," + 
                           " IdentifierName," + 
                           " IdentifierAddress," + 
                           " IdentifierType," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDidentifierDto.getIdentifierCode());
        dbManager.setString(2,prpDidentifierDto.getCountryCode());
        dbManager.setString(3,prpDidentifierDto.getCountryCName());
        dbManager.setString(4,prpDidentifierDto.getCountryEName());
        dbManager.setString(5,prpDidentifierDto.getPortCode());
        dbManager.setString(6,prpDidentifierDto.getPortName());
        dbManager.setInt(7,prpDidentifierDto.getIdentifierOrder());
        dbManager.setString(8,prpDidentifierDto.getIdentifierName());
        dbManager.setString(9,prpDidentifierDto.getIdentifierAddress());
        dbManager.setString(10,prpDidentifierDto.getIdentifierType());
        dbManager.setString(11,prpDidentifierDto.getValidStatus());
        dbManager.setString(12,prpDidentifierDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDidentifierDto prpDidentifierDto = (PrpDidentifierDto)i.next();
            insert(prpDidentifierDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param identifierCode �����˴���
     * @param portCode �ۿڴ���
     * @throws Exception
     */
    public void delete(String identifierCode,String portCode) throws Exception{
        String statement = " Delete From PrpDidentifier Where " +
                           " IdentifierCode = ? And " + 
                           " PortCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,identifierCode);
        dbManager.setString(2,portCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDidentifierBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDidentifierDto prpDidentifierDto
     * @throws Exception
     */
    public void update(PrpDidentifierDto prpDidentifierDto) throws Exception{
        String statement = " Update PrpDidentifier Set CountryCode = ?," + 
                           " CountryCName = ?," + 
                           " CountryEName = ?," + 
                           " PortName = ?," + 
                           " IdentifierOrder = ?," + 
                           " IdentifierName = ?," + 
                           " IdentifierAddress = ?," + 
                           " IdentifierType = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " IdentifierCode = ? And " + 
                           " PortCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDidentifierDto.getCountryCode());
        dbManager.setString(2,prpDidentifierDto.getCountryCName());
        dbManager.setString(3,prpDidentifierDto.getCountryEName());
        dbManager.setString(4,prpDidentifierDto.getPortName());
        dbManager.setInt(5,prpDidentifierDto.getIdentifierOrder());
        dbManager.setString(6,prpDidentifierDto.getIdentifierName());
        dbManager.setString(7,prpDidentifierDto.getIdentifierAddress());
        dbManager.setString(8,prpDidentifierDto.getIdentifierType());
        dbManager.setString(9,prpDidentifierDto.getValidStatus());
        dbManager.setString(10,prpDidentifierDto.getFlag());
        //���������ֶ�;
        dbManager.setString(11,prpDidentifierDto.getIdentifierCode());
        dbManager.setString(12,prpDidentifierDto.getPortCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDidentifierBase.update() success!");
    }

    /**
     * ����������һ������
     * @param identifierCode �����˴���
     * @param portCode �ۿڴ���
     * @return PrpDidentifierDto
     * @throws Exception
     */
    public PrpDidentifierDto findByPrimaryKey(String identifierCode,String portCode) throws Exception{
        String statement = " Select IdentifierCode," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " PortCode," + 
                           " PortName," + 
                           " IdentifierOrder," + 
                           " IdentifierName," + 
                           " IdentifierAddress," + 
                           " IdentifierType," + 
                           " ValidStatus," + 
                           " Flag From PrpDidentifier Where " +
                           " IdentifierCode = ? And " + 
                           " PortCode = ?";
        PrpDidentifierDto prpDidentifierDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,identifierCode);
        dbManager.setString(2,portCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDidentifierDto = new PrpDidentifierDto();
            prpDidentifierDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDto.setCountryCode(dbManager.getString(resultSet,2));
            prpDidentifierDto.setCountryCName(dbManager.getString(resultSet,3));
            prpDidentifierDto.setCountryEName(dbManager.getString(resultSet,4));
            prpDidentifierDto.setPortCode(dbManager.getString(resultSet,5));
            prpDidentifierDto.setPortName(dbManager.getString(resultSet,6));
            prpDidentifierDto.setIdentifierOrder(dbManager.getInt(resultSet,7));
            prpDidentifierDto.setIdentifierName(dbManager.getString(resultSet,8));
            prpDidentifierDto.setIdentifierAddress(dbManager.getString(resultSet,9));
            prpDidentifierDto.setIdentifierType(dbManager.getString(resultSet,10));
            prpDidentifierDto.setValidStatus(dbManager.getString(resultSet,11));
            prpDidentifierDto.setFlag(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        log.info("DBPrpDidentifierBase.findByPrimaryKey() success!");
        return prpDidentifierDto;
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
        String statement = "Select IdentifierCode," + 
                           " CountryCode," + 
                           " CountryCName," + 
                           " CountryEName," + 
                           " PortCode," + 
                           " PortName," + 
                           " IdentifierOrder," + 
                           " IdentifierName," + 
                           " IdentifierAddress," + 
                           " IdentifierType," + 
                           " ValidStatus," + 
                           " Flag From PrpDidentifier Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDidentifierDto prpDidentifierDto = null;
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

            prpDidentifierDto = new PrpDidentifierDto();
            prpDidentifierDto.setIdentifierCode(dbManager.getString(resultSet,1));
            prpDidentifierDto.setCountryCode(dbManager.getString(resultSet,2));
            prpDidentifierDto.setCountryCName(dbManager.getString(resultSet,3));
            prpDidentifierDto.setCountryEName(dbManager.getString(resultSet,4));
            prpDidentifierDto.setPortCode(dbManager.getString(resultSet,5));
            prpDidentifierDto.setPortName(dbManager.getString(resultSet,6));
            prpDidentifierDto.setIdentifierOrder(dbManager.getInt(resultSet,7));
            prpDidentifierDto.setIdentifierName(dbManager.getString(resultSet,8));
            prpDidentifierDto.setIdentifierAddress(dbManager.getString(resultSet,9));
            prpDidentifierDto.setIdentifierType(dbManager.getString(resultSet,10));
            prpDidentifierDto.setValidStatus(dbManager.getString(resultSet,11));
            prpDidentifierDto.setFlag(dbManager.getString(resultSet,12));
            collection.add(prpDidentifierDto);
        }
        resultSet.close();
        log.info("DBPrpDidentifierBase.findByConditions() success!");
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
        String statement = "Delete From PrpDidentifier Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDidentifierBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDidentifier Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDidentifierBase.getCount() success!");
        return count;
    }
}
