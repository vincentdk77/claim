package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǳб��ձ��ı�����ݷ��ʶ������<br>
 * ������ 2007-07-05 14:54:46.671<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLkindItemBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLkindItemBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLkindItemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void insert(PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLkindItem (");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ItemCName,");
        buffer.append("ItemEName,");
        buffer.append("ItemFlag,");
        buffer.append("NewItemCode,");
        buffer.append("ValidStatus,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLkindItemDto.getRiskCode()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getItemCode()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getItemCName()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getItemEName()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getItemFlag()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getNewItemCode()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getValidStatus()).append("',");
            debugBuffer.append("'").append(prpLkindItemDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLkindItemDto.getRiskCode());
        dbManager.setString(2,prpLkindItemDto.getKindCode());
        dbManager.setString(3,prpLkindItemDto.getItemCode());
        dbManager.setString(4,prpLkindItemDto.getItemCName());
        dbManager.setString(5,prpLkindItemDto.getItemEName());
        dbManager.setString(6,prpLkindItemDto.getItemFlag());
        dbManager.setString(7,prpLkindItemDto.getNewItemCode());
        dbManager.setString(8,prpLkindItemDto.getValidStatus());
        dbManager.setString(9,prpLkindItemDto.getFlag());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLkindItem (");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ItemCName,");
        buffer.append("ItemEName,");
        buffer.append("ItemFlag,");
        buffer.append("NewItemCode,");
        buffer.append("ValidStatus,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLkindItemDto prpLkindItemDto = (PrpLkindItemDto)i.next();
            dbManager.setString(1,prpLkindItemDto.getRiskCode());
            dbManager.setString(2,prpLkindItemDto.getKindCode());
            dbManager.setString(3,prpLkindItemDto.getItemCode());
            dbManager.setString(4,prpLkindItemDto.getItemCName());
            dbManager.setString(5,prpLkindItemDto.getItemEName());
            dbManager.setString(6,prpLkindItemDto.getItemFlag());
            dbManager.setString(7,prpLkindItemDto.getNewItemCode());
            dbManager.setString(8,prpLkindItemDto.getValidStatus());
            dbManager.setString(9,prpLkindItemDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @throws Exception
     */
    public void delete(String riskCode,String kindCode,String itemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLkindItem ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(itemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,itemCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void update(PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLkindItem SET ");
        buffer.append("ItemCName = ?, ");
        buffer.append("ItemEName = ?, ");
        buffer.append("ItemFlag = ?, ");
        buffer.append("NewItemCode = ?, ");
        buffer.append("ValidStatus = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLkindItem SET ");
            debugBuffer.append("ItemCName = '" + prpLkindItemDto.getItemCName() + "', ");
            debugBuffer.append("ItemEName = '" + prpLkindItemDto.getItemEName() + "', ");
            debugBuffer.append("ItemFlag = '" + prpLkindItemDto.getItemFlag() + "', ");
            debugBuffer.append("NewItemCode = '" + prpLkindItemDto.getNewItemCode() + "', ");
            debugBuffer.append("ValidStatus = '" + prpLkindItemDto.getValidStatus() + "', ");
            debugBuffer.append("Flag = '" + prpLkindItemDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(prpLkindItemDto.getRiskCode()).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(prpLkindItemDto.getKindCode()).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(prpLkindItemDto.getItemCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLkindItemDto.getItemCName());
        dbManager.setString(2,prpLkindItemDto.getItemEName());
        dbManager.setString(3,prpLkindItemDto.getItemFlag());
        dbManager.setString(4,prpLkindItemDto.getNewItemCode());
        dbManager.setString(5,prpLkindItemDto.getValidStatus());
        dbManager.setString(6,prpLkindItemDto.getFlag());
        //���������ֶ�;
        dbManager.setString(7,prpLkindItemDto.getRiskCode());
        dbManager.setString(8,prpLkindItemDto.getKindCode());
        dbManager.setString(9,prpLkindItemDto.getItemCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param riskCode ���ִ���
     * @param kindCode �ձ����
     * @param itemCode �����Ŀ����
     * @return PrpLkindItemDto
     * @throws Exception
     */
    public PrpLkindItemDto findByPrimaryKey(String riskCode,String kindCode,String itemCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ItemCName,");
        buffer.append("ItemEName,");
        buffer.append("ItemFlag,");
        buffer.append("NewItemCode,");
        buffer.append("ValidStatus,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLkindItem ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RiskCode=").append("'").append(riskCode).append("' AND ");
            debugBuffer.append("KindCode=").append("'").append(kindCode).append("' AND ");
            debugBuffer.append("ItemCode=").append("'").append(itemCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RiskCode = ? And ");
        buffer.append("KindCode = ? And ");
        buffer.append("ItemCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,kindCode);
        dbManager.setString(3,itemCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLkindItemDto prpLkindItemDto = null;
        if(resultSet.next()){
            prpLkindItemDto = new PrpLkindItemDto();
            prpLkindItemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLkindItemDto.setKindCode(dbManager.getString(resultSet,2));
            prpLkindItemDto.setItemCode(dbManager.getString(resultSet,3));
            prpLkindItemDto.setItemCName(dbManager.getString(resultSet,4));
            prpLkindItemDto.setItemEName(dbManager.getString(resultSet,5));
            prpLkindItemDto.setItemFlag(dbManager.getString(resultSet,6));
            prpLkindItemDto.setNewItemCode(dbManager.getString(resultSet,7));
            prpLkindItemDto.setValidStatus(dbManager.getString(resultSet,8));
            prpLkindItemDto.setFlag(dbManager.getString(resultSet,9));
        }
        resultSet.close();
        return prpLkindItemDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("RiskCode,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("ItemCName,");
        buffer.append("ItemEName,");
        buffer.append("ItemFlag,");
        buffer.append("NewItemCode,");
        buffer.append("ValidStatus,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLkindItem WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrpLkindItemDto prpLkindItemDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLkindItemDto = new PrpLkindItemDto();
            prpLkindItemDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLkindItemDto.setKindCode(dbManager.getString(resultSet,2));
            prpLkindItemDto.setItemCode(dbManager.getString(resultSet,3));
            prpLkindItemDto.setItemCName(dbManager.getString(resultSet,4));
            prpLkindItemDto.setItemEName(dbManager.getString(resultSet,5));
            prpLkindItemDto.setItemFlag(dbManager.getString(resultSet,6));
            prpLkindItemDto.setNewItemCode(dbManager.getString(resultSet,7));
            prpLkindItemDto.setValidStatus(dbManager.getString(resultSet,8));
            prpLkindItemDto.setFlag(dbManager.getString(resultSet,9));
            collection.add(prpLkindItemDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLkindItem WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        String statement ;
          statement = "SELECT count(1) FROM PrpLkindItem WHERE ";
           statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
}
