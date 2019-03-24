package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.platform.dto.domain.PrpDriskDto;
import com.sinosoft.platform.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLog工作流日志表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfLogAction extends BLSwfLogActionBase {
    private static Log logger = LogFactory.getLog(BLSwfLogAction.class);

    /**
     * 构造函数
     */
    public BLSwfLogAction() {
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfLogDto swfLogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, SwfLogDto swfLogDto, String mode)
            throws Exception {
        if(swfLogDto==null){
            return ;
        }
        if(mode.equals("view")){
            
            PrpDriskDto prpDriskDto  = new DBPrpDrisk(dbManager).findByPrimaryKey(swfLogDto.getRiskCode());
            if(prpDriskDto!=null){
                swfLogDto.setRiskCodeName(prpDriskDto.getRiskCName());
            }else{
                swfLogDto.setRiskCodeName(swfLogDto.getRiskCode());
            }
        }
    }

    /**
     * 查询flowID的最大logno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxLogNo(DBManager dbManager, String flowID) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        int logNo = dbSwfLog.getMaxLogNo(flowID);
        return logNo;
    }
    
    /**
     * 查询flowID的最大logno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxNodeLogNo(DBManager dbManager, String flowID,String nodeType,String businessNo) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        int logNo = dbSwfLog.getMaxNodeLogNo(flowID,nodeType,businessNo);
        return logNo;
    }

    /**
     * 根据flowId查询最大节点的节点名称
     * @param dbManager DB管理器
     * @param flowID flowID
     * @return 节点名称
     * @throws Exception
     */
    public String getMaxNodeName(DBManager dbManager, String flowID) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        String nodeName = dbSwfLog.getMaxNodeName(flowID);
        return nodeName;
    }
    //add by kangzhen 061125 start
    public void updateStatus(DBManager dbManager,SwfLogDto swfLogDto) throws SQLException, Exception{
    	DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
    	dbSwfLog.updateStatus(swfLogDto);	
    }
    //add by kangzhen 061125 end

    /**
     * 按条件统计节点数据
     * @param dbManager DB管理器
     * @param conditions 统计节点条件
     * @return Collection 包含statDto的集合
     * @throws Exception
     */
    public Collection getNodeStatusStat(DBManager dbManager, String conditions)
            throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if (conditions.trim().length() == 0) {
            conditions = "1=1";
        }

        collection = dbSwfLog.getNodeStatusStat(conditions);
        return collection;
    }

    /**
     * 按条件统计节点数据
     * @param dbManager DB管理器
     * @param conditions 统计节点条件
     * @return Collection 包含statDto的集合
     * @throws Exception
     */
    public Collection getNodeUserStatusStat(DBManager dbManager,
            String conditions) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if (conditions.trim().length() == 0) {
            conditions = "1=1";
        }

        collection = dbSwfLog.getNodeUserStatusStat(conditions);
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findByConditions(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
            SwfLogDto swfLogDto = (SwfLogDto) iter.next();
            convertDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    
    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findAllStatusByConditions(DBManager dbManager, String swflogConditions,String swflogStoreCondition,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findAllStatusByConditions(dbManager, swflogConditions,swflogStoreCondition,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
            SwfLogDto swfLogDto = (SwfLogDto) iter.next();
            convertDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    //modify by liuyanmei add start 20051102 
    public void updateFlowStatus(DBManager dbManager,String flowId)
    throws SQLException,Exception
  {
     DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
     dbSwfLog.updateFlowStatus(dbManager,flowId);
  }
    //modify by liuyanmei  add start 20051102  
    /**
     * 查勘退回
     */
    public void updateStatusReurun(DBManager dbManager,SwfLogDto swfLogDto) throws SQLException, Exception{
    	DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
    	dbSwfLog.updateReturnStatus(swfLogDto);	
    } 
    
    public void updateNodeStatus(DBManager dbManager,String nodeStatus,String str) throws SQLException,Exception
    {
       DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
       dbSwfLog.updateNodeStatus(dbManager,nodeStatus,str);
    }
}
