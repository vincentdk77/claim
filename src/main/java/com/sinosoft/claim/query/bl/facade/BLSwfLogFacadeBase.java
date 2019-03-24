package com.sinosoft.claim.query.bl.facade;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gyic.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfLog-工作流日志表（新增）的业务逻辑对象Facade基类<br>
 * 创建于 2005-03-18 17:53:38.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfLogFacadeBase{
    private static Log logger = LogFactory.getLog(BLSwfLogFacadeBase.class);

    /**
     * 构造函数
     */
    public BLSwfLogFacadeBase(){
    }

    /**
     * 插入一条数据
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void insert(SwfLogDto swfLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //插入记录
            blSwfLogAction.insert(dbManager,swfLogDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键删除一条数据
     * @param flowID 流程编号
     * @param logNo 序号
     * @throws Exception
     */
    public void delete(String flowID,int logNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //删除记录
            blSwfLogAction.delete(dbManager,flowID, logNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按条件删除数据
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //按条件删除记录
            blSwfLogAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param swfLogDto swfLogDto
     * @throws Exception
     */
    public void update(SwfLogDto swfLogDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //更新记录
            blSwfLogAction.update(dbManager,swfLogDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * 按主键查找一条数据
     * @param flowID 流程编号
     * @param logNo 序号
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByPrimaryKey(String flowID,int logNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //声明DTO
        SwfLogDto swfLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            swfLogDto = blSwfLogAction.findByPrimaryKey(dbManager,flowID, logNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfLogDto;
    }
    /**
     * 按报案号查找一条数据
     * @param flowID 流程编号
     * @param logNo 序号
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public SwfLogDto findByRegistNo(String registNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        //声明DTO
        SwfLogDto swfLogDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            swfLogDto = blSwfLogAction.findByRegistNo(dbManager,registNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return swfLogDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            pageRecord = blSwfLogAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按保单查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByPolicyNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByPolicyNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按保单查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findCompensateListByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findCompensateListByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按事故号查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByComBineNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByComBineNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按报案号查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByRegistNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findByRegistNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按报案号查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findBypolicyNo(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findBypolicyNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按条件查询多条数据(查询转储表和未转储表)
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findAllStatusByConditions(String swflogConditions,String swflogStoreCondition,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(swflogConditions.trim().length()==0){
        	swflogConditions = "1=1";
        }
        if(swflogStoreCondition.trim().length()==0){
        	swflogStoreCondition = "1=1";
        }
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            pageRecord = blSwfLogAction.findAllStatusByConditions(dbManager,swflogConditions,swflogStoreCondition,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection 包含swfLogDto的集合
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            //dbManager.open(AppConfig.get("sysconst.DBJNDI"));
        	dbManager.open(Constant.QUERY_DATA_SOURCE);
            collection = blSwfLogAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blSwfLogAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * 查勘退回工作流节点校验
     * @param flowID 流程编号
     * @param logNo 序号
     * @return swfLogDto swfLogDto
     * @throws Exception
     */
    public void checkFlowID(String flowID) throws Exception{
    	DBManager dbManager = new DBManager();
    	String conditions = "Flowid = '"+flowID+"' and Nodetype= 'compp' and Nodestatus = '4' and (submittime is not null or submittime <> '')";
		
//    	StringBuffer strBuffer = new StringBuffer();
//    	strBuffer.append("select 1                                                  ");                                                         
//    	strBuffer.append("  from swflog sw                                          ");                                                         
//    	strBuffer.append(" where sw.nodeType = 'compp'                              ");                                                         
//    	strBuffer.append("   and sw.NodeStatus in ('2', '3')                        ");                                                         
//    	strBuffer.append("   and (sw.flowStatus = '1' or sw.flowStatus = '2')       ");                                                         
//    	strBuffer.append("   and sw.businessno = '"+strCompensateNo+"'        "); 
//    	
    	
    	String conditions1 = " Flowid = '"+flowID+"' and  Nodetype= 'compp' and  Nodestatus  in  ('2','3') and   (flowStatus = '1' or flowStatus = '2')  ";
    	BLSwfLogFacade  facadeSwf = new BLSwfLogFacade();
		SwfLogDto swfLogDto = new SwfLogDto();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            Collection  tion = facadeSwf.findByConditions(conditions);
    		if(tion.size() > 0){
    	        throw new UserException(1,3,"0000","工作流"+flowID+"已经处于理算提交状态，不允许删除"); 
    		}
    		tion = facadeSwf.findByConditions(conditions1);
    		if(tion.size() > 0){
    	        throw new UserException(1,3,"0000","工作流"+flowID+"理算书处于核赔退回或正处理状态，首先要进行理算书删除操作"); 
    		}
    		
    		
    	}catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    /**
     * 按报案号查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findComBineListByCondition (String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());
        DBManager dbManager = new DBManager();
        BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blSwfLogAction.findBypolicyNo(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }
}
