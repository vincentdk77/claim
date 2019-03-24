package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitemkind���������Ϣ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCitemKindTg extends DBPrpCitemKindTgBase{
    private static Log log = LogFactory.getLog(DBPrpCitemKindTg.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpCitemKindTg(DBManager dbManager){
        super(dbManager);
    }
    /**
     * ���������� �ܱ���
     * @param conditions ��ѯ����
     * @return �ܱ���
     * @throws Exception
     */
    public double getSumAmount(DBManager dbManager,String conditions) throws Exception{
        String statement = " Select sum(Amount) as Amount From prpcvirturlitemtg Where " + conditions;
        double sumAmount = 0.00;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
        	sumAmount = dbManager.getDouble(resultSet,"Amount");
        }
        resultSet.close();
        log.info("DBPrpCitemKind.getSumAmount() success!");
        return sumAmount;
    }
    
    public int getItemKindNo(DBManager dbManager,String conditions) throws Exception{
        String statement = " Select itemkindno as itemkindno From prpcitemkindtg Where " + conditions;
        int itemkindno = 0;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
        	itemkindno = dbManager.getInt(resultSet,"itemkindno");
        }
        resultSet.close();
        log.info("DBPrpCitemKind.getItemKindNo() success!");
        return itemkindno;
    }
    public String getItemDetailName(DBManager dbManager,String conditions) throws Exception{
        String statement = " Select ItemDetailName as ItemDetailName From prpcitemkindtg Where " + conditions;
        String itemDetailName = "";
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
        	itemDetailName = dbManager.getString(resultSet,"itemDetailName");
        }
        resultSet.close();
        log.info("DBPrpCitemKind.getItemKindNo() success!");
        return itemDetailName;
    }
}
