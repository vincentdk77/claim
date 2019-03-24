package com.sinosoft.function.insutil.bl.action.domain;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpMaxNoDto;
import com.sinosoft.function.insutil.resource.dtofactory.domain.DBPrpMaxNo;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpmaxno的业务对象扩展类<br>
 * 创建于 2004-4-5 15:16:33<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpMaxNoAction extends BLPrpMaxNoActionBase{
    private static Log log = LogFactory.getLog(BLPrpMaxNoAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpMaxNoAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpMaxNoDto prpMaxNoDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpMaxNoDto prpMaxNoDto,String mode) throws Exception{
    }

    /**
     * 存储单证数据
     * @param dbManager dbManager
     * @param prpMaxNoDto prpMaxNoDto
     * @param mode 模式
     * @throws Exception
     */
    public void save(DBManager dbManager,Collection collection)
        throws SQLException,Exception
    {
      Iterator iterator = collection.iterator();
      PrpMaxNoDto prpMaxNoDto = null;
      DBPrpMaxNo dbPrpMaxNo = new DBPrpMaxNo(dbManager);
      while (iterator.hasNext())
      {
        prpMaxNoDto = new PrpMaxNoDto();
        prpMaxNoDto = (PrpMaxNoDto)iterator.next();
        dbPrpMaxNo.delete(prpMaxNoDto.getGroupNo(),prpMaxNoDto.getTableName(),prpMaxNoDto.getMaxNo());
        dbPrpMaxNo.insert(prpMaxNoDto);
      }
    }
}
