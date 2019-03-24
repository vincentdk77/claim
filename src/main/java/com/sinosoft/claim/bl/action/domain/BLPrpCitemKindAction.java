package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCitemKind;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcitemkind标的子险信息的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCitemKindAction extends BLPrpCitemKindActionBase{
    private static Log log = LogFactory.getLog(BLPrpCitemKindAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCitemKindAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCitemKindDto prpCitemKindDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCitemKindDto prpCitemKindDto,String mode) throws Exception{
    }
    /**
     * 按条件汇总 总保额
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return 总保额
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
