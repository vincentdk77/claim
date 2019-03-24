package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFittings;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是prplcompensate赔款计算书表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLclaimFittingsAction extends BLPrpLclaimFittingsActionBase{
    private static Log log = LogFactory.getLog(BLPrpLclaimFittingsAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLclaimFittingsAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLclaimFittingsDto prpLclaimFittingsDto,String mode) throws Exception{
    }

    /**
     * 保存
     * @param Collection fittingsList
     * @throws SQLException
     * @throws Exception
     */
    public void save(DBManager dbManager,Collection fittingsList) throws SQLException,Exception
    {
      //创建数据库管理对象
      DBPrpLclaimFittings dbPrpLclaimFittings = null;
      PrpLclaimFittingsDto prpLclaimFittingsDto = null;
      String condition = "";
      boolean bDelete = false;
      
      //业务操作
      dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
      
      Iterator it = fittingsList.iterator();
      while(it.hasNext()){
      	prpLclaimFittingsDto = (PrpLclaimFittingsDto)it.next();
      	if("D".equals(prpLclaimFittingsDto.getStatus())){
      		dbPrpLclaimFittings.updateStatus(prpLclaimFittingsDto);
      		it.remove();
      	}else{
      		condition = " registNo = '" + prpLclaimFittingsDto.getRegistNo() + "'"+
      			" and lossItemCode = '" + prpLclaimFittingsDto.getLossItemCode() +"'"+
      			" and partId = '" + prpLclaimFittingsDto.getPartId() + "'";
      		dbPrpLclaimFittings.deleteByConditions(condition);
      	}
      	
      } 
      
      dbPrpLclaimFittings.insertAll(fittingsList);
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DBManager
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Add By sunhao 2004-08-24 Reason:增加新的查询方法
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
      DBPrpLclaimFittings dbPrpLclaimFittings = new DBPrpLclaimFittings(dbManager);
      Collection collection = null;

      if(conditions.trim().length()==0){
          conditions = "1=1";
      }

      collection = dbPrpLclaimFittings.findByConditions(conditions,pageNo,rowsPerPage);
      /* 取完数据删除 */
      //dbPrpLclaimFittings.deleteByConditions(conditions);
      return collection;
    }
}