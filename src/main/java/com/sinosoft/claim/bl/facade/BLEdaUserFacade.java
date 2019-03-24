package com.sinosoft.claim.bl.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpDuserAction;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaUser-座席员信息表的业务对象Facade类<br>
 * 创建于 2005-06-22 14:56:52.395<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserFacade extends BLEdaUserFacadeBase{
    private static Log logger = LogFactory.getLog(BLEdaUserFacade.class);

    
    /**
     * 按主键查找一条数据
     * @param userCode  员工代码
     * @return PrpDuserDto PrpDuserDto
     * @throws Exception
     */
    public PrpDuserDto findPrpDUserByPrimaryKey(String userCode) throws Exception{
        DBManager dbManager = new DBManager();
     
        BLPrpDuserAction bLPrpDuserAction = new BLPrpDuserAction();
        
        //声明DTO
        PrpDuserDto prpDuserDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //查询数据,赋值给DTO
            prpDuserDto = bLPrpDuserAction.findByPrimaryKey(dbManager,userCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpDuserDto;
    }
    /**
     * 构造函数
     */
    public BLEdaUserFacade(){
        super();
    }
}
