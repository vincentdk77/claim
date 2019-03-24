package com.sinosoft.claim.query.bl.facade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是SwfLog工作流日志表的业务对象Facade类<br>
 * 创建于 2004-08-09 19:54:55.307<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfLogFacade extends BLSwfLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogFacade.class);

    /**
     * 构造函数
     */
    public BLSwfLogFacade(){
        super();
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxLogNo(String flowID)
        throws Exception{

        int LogNo=0;

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            LogNo = blSwfLogAction.getMaxLogNo(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return LogNo;
    }
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getMaxNodeLogNo(String flowID,String nodeType,String businessNo)
        throws Exception{

        int LogNo=0;

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            LogNo = blSwfLogAction.getMaxNodeLogNo(dbManager,flowID,nodeType,businessNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return LogNo;
    }
    
    /**
     * 根据flowId查询最大节点的节点名称
     * @param flowID flowID
     * @return 节点名称
     * @throws Exception
     */
    public String getMaxNodeName(String flowID)
        throws Exception{

    	String nodeName = "";

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            nodeName = blSwfLogAction.getMaxNodeName(dbManager,flowID);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nodeName;
    }
    //add by kangzhen 061125 start
    public void updateStatus(SwfLogDto swfLogDto) throws SQLException, Exception{
    	DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            blSwfLogAction.updateStatus(dbManager,swfLogDto);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    //add by kangzhen 061125 end

    /**
        * 按条件统计节点数据
        * @param conditions 统计节点条件
        * @return Collection 包含statDto的集合
        * @throws Exception
        */
       public Collection getNodeStatusStat(String conditions) throws Exception{

       DBManager dbManager = new DBManager();
        Collection nodeStatusDtoList = new ArrayList();
        try
        {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //由于pagerecorder的问题，目前用collection
          nodeStatusDtoList = (Collection)blSwfLogAction.getNodeStatusStat(dbManager,conditions);

        }

        catch (Exception ex) {
          throw ex;
        }
        finally
        {
          dbManager.close();
        }
        return nodeStatusDtoList;
       }



  /**
        * 按条件统计节点数据用户
        * @param conditions 统计节点条件
        * @return Collection 包含statDto的集合
        * @throws Exception
        */
       public Collection getNodeUserStatusStat(String conditions) throws Exception{

       DBManager dbManager = new DBManager();
        Collection nodeStatusDtoList = new ArrayList();
        try
        {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //由于pagerecorder的问题，目前用collection
          nodeStatusDtoList = (Collection)blSwfLogAction.getNodeUserStatusStat(dbManager,conditions);

        }

        catch (Exception ex) {
          throw ex;
        }
        finally
        {
          dbManager.close();
        }
        return nodeStatusDtoList;
       }
 
       //modify by liuyanmei add 20051102 start 
       
       public void updateFlowStatus(String flowId) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfLogAction.updateFlowStatus(dbManager,flowId);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
//modify by liuyanmei add 20051102 end 
       
       /**
        * 查勘退回
        */
       public void updateStatusReurun(SwfLogDto swfLogDto) throws SQLException, Exception{
       	DBManager dbManager = new DBManager();
           BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
           try{
               dbManager.open(AppConfig.get("sysconst.DBJNDI"));
               dbManager.beginTransaction();
                blSwfLogAction.updateStatusReurun(dbManager,swfLogDto);
				String conditions = "FlowID = '"+swfLogDto.getFlowID()+"' and NodeNo= 2";
				SwfLogDto swfLogDto1 = new SwfLogDto();
				Collection tion = this.findByConditions(conditions);
			    for (Iterator ite = tion.iterator(); ite.hasNext();){
			    	swfLogDto1 = (SwfLogDto)ite.next();
			      }
				swfLogDto1.setNodeStatus("2");
				swfLogDto1.setFlowStatus("2");
				swfLogDto1.setSubmitTime("");
				blSwfLogAction.updateStatusReurun(dbManager,swfLogDto1);
				String conditionss = "FlowID = '"+swfLogDto.getFlowID()+"' and NodeNo= 10  and nodestatus <> 0 ";
				String conditionsss = "FlowID = '"+swfLogDto.getFlowID()+"' and NodeNo= 12  and nodestatus = 0 ";
				SwfLogDto swfLogDto11 = new SwfLogDto();
				Collection tion1 = this.findByConditions(conditionss);
				Collection tion2 = this.findByConditions(conditionsss);
			    for (Iterator ite = tion1.iterator(); ite.hasNext();){
			    	swfLogDto11 = (SwfLogDto)ite.next();
			      }
				
				swfLogDto11.setNodeStatus("2");
				swfLogDto11.setFlowStatus("2");
				swfLogDto11.setSubmitTime("");
				if(tion2.size() > 0){
				blSwfLogAction.updateStatusReurun(dbManager,swfLogDto11);
				}
               dbManager.commitTransaction();
           }catch(Exception exception){
               dbManager.rollbackTransaction();
               throw exception;
           }finally{
               dbManager.close();
           }
       }   


}
