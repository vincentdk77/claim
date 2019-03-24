package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDdbsDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpddbs���ݿ�ά��������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDdbsBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDdbsBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDdbsBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDdbsDto prpDdbsDto
     * @throws Exception
     */
    public void insert(PrpDdbsDto prpDdbsDto) throws Exception{
        String statement = " Insert Into PrpDdbs(" + 
                           " ComCode," + 
                           " ComName," + 
                           " RiskCode," + 
                           " HostName," + 
                           " SvrName," + 
                           " DbsName," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDdbsDto.getComCode());
        dbManager.setString(2,prpDdbsDto.getComName());
        dbManager.setString(3,prpDdbsDto.getRiskCode());
        dbManager.setString(4,prpDdbsDto.getHostName());
        dbManager.setString(5,prpDdbsDto.getSvrName());
        dbManager.setString(6,prpDdbsDto.getDbsName());
        dbManager.setString(7,prpDdbsDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdbsBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDdbsDto prpDdbsDto = (PrpDdbsDto)i.next();
            insert(prpDdbsDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param comCode ��������
     * @param riskCode ����
     * @throws Exception
     */
    public void delete(String comCode,String riskCode) throws Exception{
        String statement = " Delete From PrpDdbs Where " +
                           " ComCode = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,comCode);
        dbManager.setString(2,riskCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDdbsBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDdbsDto prpDdbsDto
     * @throws Exception
     */
    public void update(PrpDdbsDto prpDdbsDto) throws Exception{
        String statement = " Update PrpDdbs Set ComName = ?," + 
                           " HostName = ?," + 
                           " SvrName = ?," + 
                           " DbsName = ?," + 
                           " Flag = ? Where " +
                           " ComCode = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDdbsDto.getComName());
        dbManager.setString(2,prpDdbsDto.getHostName());
        dbManager.setString(3,prpDdbsDto.getSvrName());
        dbManager.setString(4,prpDdbsDto.getDbsName());
        dbManager.setString(5,prpDdbsDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpDdbsDto.getComCode());
        dbManager.setString(7,prpDdbsDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDdbsBase.update() success!");
    }

    /**
     * ����������һ������
     * @param comCode ��������
     * @param riskCode ����
     * @return PrpDdbsDto
     * @throws Exception
     */
    public PrpDdbsDto findByPrimaryKey(String comCode,String riskCode) throws Exception{
        String statement = " Select ComCode," + 
                           " ComName," + 
                           " RiskCode," + 
                           " HostName," + 
                           " SvrName," + 
                           " DbsName," + 
                           " Flag From PrpDdbs Where " +
                           " ComCode = ? And " + 
                           " RiskCode = ?";
        PrpDdbsDto prpDdbsDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,comCode);
        dbManager.setString(2,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDdbsDto = new PrpDdbsDto();
            prpDdbsDto.setComCode(dbManager.getString(resultSet,1));
            prpDdbsDto.setComName(dbManager.getString(resultSet,2));
            prpDdbsDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDdbsDto.setHostName(dbManager.getString(resultSet,4));
            prpDdbsDto.setSvrName(dbManager.getString(resultSet,5));
            prpDdbsDto.setDbsName(dbManager.getString(resultSet,6));
            prpDdbsDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDdbsBase.findByPrimaryKey() success!");
        return prpDdbsDto;
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
        String statement = "Select ComCode," + 
                           " ComName," + 
                           " RiskCode," + 
                           " HostName," + 
                           " SvrName," + 
                           " DbsName," + 
                           " Flag From PrpDdbs Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDdbsDto prpDdbsDto = null;
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

            prpDdbsDto = new PrpDdbsDto();
            prpDdbsDto.setComCode(dbManager.getString(resultSet,1));
            prpDdbsDto.setComName(dbManager.getString(resultSet,2));
            prpDdbsDto.setRiskCode(dbManager.getString(resultSet,3));
            prpDdbsDto.setHostName(dbManager.getString(resultSet,4));
            prpDdbsDto.setSvrName(dbManager.getString(resultSet,5));
            prpDdbsDto.setDbsName(dbManager.getString(resultSet,6));
            prpDdbsDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDdbsDto);
        }
        resultSet.close();
        log.info("DBPrpDdbsBase.findByConditions() success!");
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
        String statement = "Delete From PrpDdbs Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDdbsBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpDdbs Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDdbsBase.getCount() success!");
        return count;
    }
}
