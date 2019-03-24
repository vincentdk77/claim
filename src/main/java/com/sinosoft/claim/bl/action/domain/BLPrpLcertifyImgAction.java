package com.sinosoft.claim.bl.action.domain;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg的业务对象扩展类<br>
 * 创建于 2004-07-15 11:00:46.334<br>
 * JToolpad(1.2.10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLcertifyImgAction extends BLPrpLcertifyImgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyImgAction.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyImgAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto,String mode) throws Exception{
    }
    /**
     * 增加批量插入
     * @param dbManager
     * @param list
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,List list)throws Exception {
    	 DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
         //插入记录
         dbPrpLcertifyImg.insertAll(list);
    }
}
