package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiMenuDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����utimenu�˵����Ʊ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiMenuBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBUtiMenuBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBUtiMenuBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void insert(UtiMenuDto utiMenuDto) throws Exception{
        String statement = " Insert Into UtiMenu(" + 
                           " MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiMenuDto.getMenuName());
        dbManager.setString(2,utiMenuDto.getHotKey());
        dbManager.setString(3,utiMenuDto.getRiskCode());
        dbManager.setString(4,utiMenuDto.getMenuItem());
        dbManager.setString(5,utiMenuDto.getMessage());
        dbManager.setString(6,utiMenuDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiMenuBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiMenuDto utiMenuDto = (UtiMenuDto)i.next();
            insert(utiMenuDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param menuName �˵���
     * @param hotKey �ȼ�
     * @param riskCode ����
     * @throws Exception
     */
    public void delete(String menuName,String hotKey,String riskCode) throws Exception{
        String statement = " Delete From UtiMenu Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,menuName);
        dbManager.setString(2,hotKey);
        dbManager.setString(3,riskCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiMenuBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void update(UtiMenuDto utiMenuDto) throws Exception{
        String statement = " Update UtiMenu Set MenuItem = ?," + 
                           " Message = ?," + 
                           " Flag = ? Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,utiMenuDto.getMenuItem());
        dbManager.setString(2,utiMenuDto.getMessage());
        dbManager.setString(3,utiMenuDto.getFlag());
        //���������ֶ�;
        dbManager.setString(4,utiMenuDto.getMenuName());
        dbManager.setString(5,utiMenuDto.getHotKey());
        dbManager.setString(6,utiMenuDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiMenuBase.update() success!");
    }

    /**
     * ����������һ������
     * @param menuName �˵���
     * @param hotKey �ȼ�
     * @param riskCode ����
     * @return UtiMenuDto
     * @throws Exception
     */
    public UtiMenuDto findByPrimaryKey(String menuName,String hotKey,String riskCode) throws Exception{
        String statement = " Select MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag From UtiMenu Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        UtiMenuDto utiMenuDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,menuName);
        dbManager.setString(2,hotKey);
        dbManager.setString(3,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiMenuDto = new UtiMenuDto();
            utiMenuDto.setMenuName(dbManager.getString(resultSet,1));
            utiMenuDto.setHotKey(dbManager.getString(resultSet,2));
            utiMenuDto.setRiskCode(dbManager.getString(resultSet,3));
            utiMenuDto.setMenuItem(dbManager.getString(resultSet,4));
            utiMenuDto.setMessage(dbManager.getString(resultSet,5));
            utiMenuDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBUtiMenuBase.findByPrimaryKey() success!");
        return utiMenuDto;
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
        String statement = "Select MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag From UtiMenu Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiMenuDto utiMenuDto = null;
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

            utiMenuDto = new UtiMenuDto();
            utiMenuDto.setMenuName(dbManager.getString(resultSet,1));
            utiMenuDto.setHotKey(dbManager.getString(resultSet,2));
            utiMenuDto.setRiskCode(dbManager.getString(resultSet,3));
            utiMenuDto.setMenuItem(dbManager.getString(resultSet,4));
            utiMenuDto.setMessage(dbManager.getString(resultSet,5));
            utiMenuDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(utiMenuDto);
        }
        resultSet.close();
        log.info("DBUtiMenuBase.findByConditions() success!");
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
        String statement = "Delete From UtiMenu Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiMenuBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiMenu Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiMenuBase.getCount() success!");
        return count;
    }
}
