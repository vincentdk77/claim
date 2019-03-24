package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyImg单证及影像表的数据访问对象类<br>
 * 创建于 2004-11-08 09:50:06.786<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcertifyImg extends DBPrpLcertifyImgBase{
    private static Log logger = LogFactory.getLog(DBPrpLcertifyImg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertifyImg(DBManager dbManager){
        super(dbManager);
    }
    
    /**
     * 取的prplcertifyImg表中serialNo最大值
     * @param String 查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxSerialNo(String conditions) 
        throws Exception {
        int maxSerialNo = 0;
        String statement = "Select Max(SerialNo) from PrpLcertifyImg Where " + conditions;
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
         
        if (resultSet.next()) {
            maxSerialNo = dbManager.getInt(resultSet,1);    
        }
        
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.getCount() success!");
        return maxSerialNo;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditionsNew(String conditions) throws Exception{
        String statement = "select DISTINCT(typecode), picname from prplcertifyimg where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
            prpLcertifyImgDto = new PrpLcertifyImgDto();
            prpLcertifyImgDto.setTypeCode(dbManager.getString(resultSet,1));
            prpLcertifyImgDto.setPicName(dbManager.getString(resultSet,2));
            collection.add(prpLcertifyImgDto);
        }
        resultSet.close();
        logger.info("DBPrpLcertifyImgBase.findByConditions() success!");
        return collection;
    }
}
