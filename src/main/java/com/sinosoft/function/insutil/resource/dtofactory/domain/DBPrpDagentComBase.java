package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDagentComDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagentcom�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDagentComBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDagentComBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDagentComBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void insert(PrpDagentComDto prpDagentComDto) throws Exception{
        String statement = " Insert Into PrpDagentCom(" + 
                           " CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDagentComDto.getCentreCode());
        dbManager.setString(2,prpDagentComDto.getCentreName());
        dbManager.setString(3,prpDagentComDto.getUnitCode());
        dbManager.setString(4,prpDagentComDto.getUnitName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDagentComBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDagentComDto prpDagentComDto = (PrpDagentComDto)i.next();
            insert(prpDagentComDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param centreCode centrecode
     * @param unitCode unitcode
     * @throws Exception
     */
    public void delete(String centreCode,String unitCode) throws Exception{
        String statement = " Delete From PrpDagentCom Where " +
                           " CentreCode = ? And " + 
                           " UnitCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,centreCode);
        dbManager.setString(2,unitCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDagentComBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void update(PrpDagentComDto prpDagentComDto) throws Exception{
        String statement = " Update PrpDagentCom Set CentreName = ?," + 
                           " UnitName = ? Where " +
                           " CentreCode = ? And " + 
                           " UnitCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDagentComDto.getCentreName());
        dbManager.setString(2,prpDagentComDto.getUnitName());
        //���������ֶ�;
        dbManager.setString(3,prpDagentComDto.getCentreCode());
        dbManager.setString(4,prpDagentComDto.getUnitCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDagentComBase.update() success!");
    }

    /**
     * ����������һ������
     * @param centreCode centrecode
     * @param unitCode unitcode
     * @return PrpDagentComDto
     * @throws Exception
     */
    public PrpDagentComDto findByPrimaryKey(String centreCode,String unitCode) throws Exception{
        String statement = " Select CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName From PrpDagentCom Where " +
                           " CentreCode = ? And " + 
                           " UnitCode = ?";
        PrpDagentComDto prpDagentComDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,centreCode);
        dbManager.setString(2,unitCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDagentComDto = new PrpDagentComDto();
            prpDagentComDto.setCentreCode(dbManager.getString(resultSet,1));
            prpDagentComDto.setCentreName(dbManager.getString(resultSet,2));
            prpDagentComDto.setUnitCode(dbManager.getString(resultSet,3));
            prpDagentComDto.setUnitName(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpDagentComBase.findByPrimaryKey() success!");
        return prpDagentComDto;
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
        String statement = "Select CentreCode," + 
                           " CentreName," + 
                           " UnitCode," + 
                           " UnitName From PrpDagentCom Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDagentComDto prpDagentComDto = null;
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

            prpDagentComDto = new PrpDagentComDto();
            prpDagentComDto.setCentreCode(dbManager.getString(resultSet,1));
            prpDagentComDto.setCentreName(dbManager.getString(resultSet,2));
            prpDagentComDto.setUnitCode(dbManager.getString(resultSet,3));
            prpDagentComDto.setUnitName(dbManager.getString(resultSet,4));
            collection.add(prpDagentComDto);
        }
        resultSet.close();
        log.info("DBPrpDagentComBase.findByConditions() success!");
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
        String statement = "Delete From PrpDagentCom Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDagentComBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDagentCom Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDagentComBase.getCount() success!");
        return count;
    }
}
