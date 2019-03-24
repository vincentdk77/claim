package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcitemkind���������Ϣ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemKindAction extends BLPrpCitemKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemKindAction.class.getName());

    /**
     * ���캯��
     */
    public BLPrpCitemKindAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpCitemKindDto prpCitemKindDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemKindDto prpCitemKindDto,String mode) throws Exception{
    }
    /**
     * ���������� �ܱ���
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return �ܱ���
     * @throws Exception
     */
    public double getSumAmount(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        double sumAmount = 0.00;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        sumAmount = dbPrpCitemKind.getSumAmount(dbManager,conditions);
        return sumAmount;
    }
    
    public int getItemKindNo(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        int itemkindno = 0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        itemkindno = dbPrpCitemKind.getItemKindNo(dbManager,conditions);
        return itemkindno;
    }
    public String getItemDetailName(DBManager dbManager,String conditions) throws Exception{
        DBPrpCitemKind dbPrpCitemKind = new DBPrpCitemKind(dbManager);
        String itemDetailName = "";
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        itemDetailName = dbPrpCitemKind.getItemDetailName(dbManager,conditions);
        return itemDetailName;
    }
}
