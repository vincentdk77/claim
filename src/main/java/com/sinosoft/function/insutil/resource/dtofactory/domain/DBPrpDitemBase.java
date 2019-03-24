package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDitemDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpditem�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDitemBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDitemBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDitemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void insert(PrpDitemDto prpDitemDto) throws Exception{
        String statement = " Insert Into PrpDitem(" + 
                           " RiskCode," + 
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDitemDto.getRiskCode());
        dbManager.setString(2,prpDitemDto.getItemCode());
        dbManager.setString(3,prpDitemDto.getItemCName());
        dbManager.setString(4,prpDitemDto.getItemEName());
        dbManager.setString(5,prpDitemDto.getItemFlag());
        dbManager.setString(6,prpDitemDto.getNewItemCode());
        dbManager.setString(7,prpDitemDto.getValidStatus());
        dbManager.setString(8,prpDitemDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDitemBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDitemDto prpDitemDto = (PrpDitemDto)i.next();
            insert(prpDitemDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param itemCode itemcode
     * @throws Exception
     */
    public void delete(String riskCode,String itemCode) throws Exception{
        String statement = " Delete From PrpDitem Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,itemCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDitemBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDitemDto prpDitemDto
     * @throws Exception
     */
    public void update(PrpDitemDto prpDitemDto) throws Exception{
        String statement = " Update PrpDitem Set ItemCName = ?," + 
                           " ItemEName = ?," + 
                           " ItemFlag = ?," + 
                           " NewItemCode = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDitemDto.getItemCName());
        dbManager.setString(2,prpDitemDto.getItemEName());
        dbManager.setString(3,prpDitemDto.getItemFlag());
        dbManager.setString(4,prpDitemDto.getNewItemCode());
        dbManager.setString(5,prpDitemDto.getValidStatus());
        dbManager.setString(6,prpDitemDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpDitemDto.getRiskCode());
        dbManager.setString(8,prpDitemDto.getItemCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDitemBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param itemCode itemcode
     * @return PrpDitemDto
     * @throws Exception
     */
    public PrpDitemDto findByPrimaryKey(String riskCode,String itemCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDitem Where " +
                           " RiskCode = ? And " + 
                           " ItemCode = ?";
        PrpDitemDto prpDitemDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,itemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDitemDto = new PrpDitemDto();
            prpDitemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDitemDto.setItemCode(dbManager.getString(resultSet,2));
            prpDitemDto.setItemCName(dbManager.getString(resultSet,3));
            prpDitemDto.setItemEName(dbManager.getString(resultSet,4));
            prpDitemDto.setItemFlag(dbManager.getString(resultSet,5));
            prpDitemDto.setNewItemCode(dbManager.getString(resultSet,6));
            prpDitemDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDitemDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpDitemBase.findByPrimaryKey() success!");
        return prpDitemDto;
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
                           " ItemCode," + 
                           " ItemCName," + 
                           " ItemEName," + 
                           " ItemFlag," + 
                           " NewItemCode," + 
                           " ValidStatus," + 
                           " Flag From PrpDitem Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDitemDto prpDitemDto = null;
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

            prpDitemDto = new PrpDitemDto();
            prpDitemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDitemDto.setItemCode(dbManager.getString(resultSet,2));
            prpDitemDto.setItemCName(dbManager.getString(resultSet,3));
            prpDitemDto.setItemEName(dbManager.getString(resultSet,4));
            prpDitemDto.setItemFlag(dbManager.getString(resultSet,5));
            prpDitemDto.setNewItemCode(dbManager.getString(resultSet,6));
            prpDitemDto.setValidStatus(dbManager.getString(resultSet,7));
            prpDitemDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpDitemDto);
        }
        resultSet.close();
        log.info("DBPrpDitemBase.findByConditions() success!");
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
        String statement = "Delete From PrpDitem Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDitemBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDitem Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDitemBase.getCount() success!");
        return count;
    }
}
