package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDrationDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdration���������ձ���������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDrationBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDrationBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDrationBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void insert(PrpDrationDto prpDrationDto) throws Exception{
        String statement = " Insert Into PrpDration(" + 
                           " RiskCode," + 
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDrationDto.getRiskCode());
        dbManager.setString(2,prpDrationDto.getRationType());
        dbManager.setString(3,prpDrationDto.getRationName());
        dbManager.setString(4,prpDrationDto.getItemCode());
        dbManager.setString(5,prpDrationDto.getKindCode());
        dbManager.setString(6,prpDrationDto.getCurrency());
        dbManager.setDouble(7,prpDrationDto.getAmount());
        dbManager.setDouble(8,prpDrationDto.getRate());
        dbManager.setDouble(9,prpDrationDto.getPremium());
        dbManager.setString(10,prpDrationDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDrationDto prpDrationDto = (PrpDrationDto)i.next();
            insert(prpDrationDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param rationType �������ʹ���
     * @param itemCode ������
     * @param kindCode �ձ����
     * @throws Exception
     */
    public void delete(String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        String statement = " Delete From PrpDration Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,rationType);
        dbManager.setString(3,itemCode);
        dbManager.setString(4,kindCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDrationBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDrationDto prpDrationDto
     * @throws Exception
     */
    public void update(PrpDrationDto prpDrationDto) throws Exception{
        String statement = " Update PrpDration Set RationName = ?," + 
                           " Currency = ?," + 
                           " Amount = ?," + 
                           " Rate = ?," + 
                           " Premium = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDrationDto.getRationName());
        dbManager.setString(2,prpDrationDto.getCurrency());
        dbManager.setDouble(3,prpDrationDto.getAmount());
        dbManager.setDouble(4,prpDrationDto.getRate());
        dbManager.setDouble(5,prpDrationDto.getPremium());
        dbManager.setString(6,prpDrationDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpDrationDto.getRiskCode());
        dbManager.setString(8,prpDrationDto.getRationType());
        dbManager.setString(9,prpDrationDto.getItemCode());
        dbManager.setString(10,prpDrationDto.getKindCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDrationBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param rationType �������ʹ���
     * @param itemCode ������
     * @param kindCode �ձ����
     * @return PrpDrationDto
     * @throws Exception
     */
    public PrpDrationDto findByPrimaryKey(String riskCode,String rationType,String itemCode,String kindCode) throws Exception{
        String statement = " Select RiskCode," + 
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag From PrpDration Where " +
                           " RiskCode = ? And " + 
                           " RationType = ? And " + 
                           " ItemCode = ? And " + 
                           " KindCode = ?";
        PrpDrationDto prpDrationDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,rationType);
        dbManager.setString(3,itemCode);
        dbManager.setString(4,kindCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDrationDto = new PrpDrationDto();
            prpDrationDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationDto.setRationType(dbManager.getString(resultSet,2));
            prpDrationDto.setRationName(dbManager.getString(resultSet,3));
            prpDrationDto.setItemCode(dbManager.getString(resultSet,4));
            prpDrationDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationDto.setCurrency(dbManager.getString(resultSet,6));
            prpDrationDto.setAmount(dbManager.getDouble(resultSet,7));
            prpDrationDto.setRate(dbManager.getDouble(resultSet,8));
            prpDrationDto.setPremium(dbManager.getDouble(resultSet,9));
            prpDrationDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpDrationBase.findByPrimaryKey() success!");
        return prpDrationDto;
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
                           " RationType," + 
                           " RationName," + 
                           " ItemCode," + 
                           " KindCode," + 
                           " Currency," + 
                           " Amount," + 
                           " Rate," + 
                           " Premium," + 
                           " Flag From PrpDration Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDrationDto prpDrationDto = null;
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

            prpDrationDto = new PrpDrationDto();
            prpDrationDto.setRiskCode(dbManager.getString(resultSet,1));
            prpDrationDto.setRationType(dbManager.getString(resultSet,2));
            prpDrationDto.setRationName(dbManager.getString(resultSet,3));
            prpDrationDto.setItemCode(dbManager.getString(resultSet,4));
            prpDrationDto.setKindCode(dbManager.getString(resultSet,5));
            prpDrationDto.setCurrency(dbManager.getString(resultSet,6));
            prpDrationDto.setAmount(dbManager.getDouble(resultSet,7));
            prpDrationDto.setRate(dbManager.getDouble(resultSet,8));
            prpDrationDto.setPremium(dbManager.getDouble(resultSet,9));
            prpDrationDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpDrationDto);
        }
        resultSet.close();
        log.info("DBPrpDrationBase.findByConditions() success!");
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
        String statement = "Delete From PrpDration Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDrationBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDration Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDrationBase.getCount() success!");
        return count;
    }
}
