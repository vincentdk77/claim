package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDareaGroupDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdareagroup�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDareaGroupBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDareaGroupBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDareaGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void insert(PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        String statement = " Insert Into PrpDareaGroup(" + 
                           " RiskCode," + 
                           " ComCode," + 
                           " AreaGroup," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDareaGroupDto.getRiskCode());
        dbManager.setString(2,prpDareaGroupDto.getComCode());
        dbManager.setString(3,prpDareaGroupDto.getAreaGroup());
        dbManager.setString(4,prpDareaGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDareaGroupBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDareaGroupDto prpDareaGroupDto = (PrpDareaGroupDto)i.next();
            insert(prpDareaGroupDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param comCode comcode
     * @throws Exception
     */
    public void delete(String riskCode,String comCode) throws Exception{
        String statement = " Delete From PrpDareaGroup Where " +
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,comCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDareaGroupBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void update(PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        String statement = " Update PrpDareaGroup Set AreaGroup = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDareaGroupDto.getAreaGroup());
        dbManager.setString(2,prpDareaGroupDto.getFlag());
        //���������ֶ�;
        dbManager.setString(3,prpDareaGroupDto.getRiskCode());
        dbManager.setString(4,prpDareaGroupDto.getComCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDareaGroupBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param comCode comcode
     * @return PrpDareaGroupDto
     * @throws Exception
     */
    public PrpDareaGroupDto findByPrimaryKey(String riskCode,String comCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ComCode," + 
                           " AreaGroup," + 
                           " Flag From PrpDareaGroup Where " +
                           " RiskCode = ? And " + 
                           " ComCode = ?";
        PrpDareaGroupDto prpDareaGroupDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDareaGroupDto = new PrpDareaGroupDto();
            prpDareaGroupDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDareaGroupDto.setComCode(dbManager.getString(resultSet,2));
            prpDareaGroupDto.setAreaGroup(dbManager.getString(resultSet,3));
            prpDareaGroupDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpDareaGroupBase.findByPrimaryKey() success!");
        return prpDareaGroupDto;
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
        String statement = "Select RiskCode," + 
                           " ComCode," + 
                           " AreaGroup," + 
                           " Flag From PrpDareaGroup Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDareaGroupDto prpDareaGroupDto = null;
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

            prpDareaGroupDto = new PrpDareaGroupDto();
            prpDareaGroupDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDareaGroupDto.setComCode(dbManager.getString(resultSet,2));
            prpDareaGroupDto.setAreaGroup(dbManager.getString(resultSet,3));
            prpDareaGroupDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpDareaGroupDto);
        }
        resultSet.close();
        log.info("DBPrpDareaGroupBase.findByConditions() success!");
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
        String statement = "Delete From PrpDareaGroup Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDareaGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDareaGroup Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDareaGroupBase.getCount() success!");
        return count;
    }
}