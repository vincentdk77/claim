package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBWorkFlow;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimStatus;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfFlowMain;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;



/**
 * ���ⰸ��������ģ�崦��action
 * <p>Title: �������� ���ⰸ��������ģ�崦��acton</p>
 * <p>Description: �������� ���ⰸ��������ģ�崦��acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLWorkFlowCombineAction
{
  private static Log logger = LogFactory.getLog(BLWorkFlowCombineAction.class);

    /**
     * ���캯��
     */
    public BLWorkFlowCombineAction(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,WorkFlowDto workFlowDto) throws Exception{
       // DBWorkFlow dbWorkFlow = new DBWorkFlow(dbManager);
        //�����¼
        //dbWorkFlow.insert(workFlowDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //ɾ����¼
       // dbWorkFlow.delete(conditionNo, serialNo);
    }
    /**
     * ������ɾ��һ���ڵ�����wfLog
     * @param dbManager DBManager
     * @param flowID String
     * @param logNo int
     * @throws Exception
     */
    public void deleteNode(DBManager dbManager,String flowID,int logNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //ɾ����¼
        dbWorkFlow.deleteNode(dbManager,flowID, logNo);
    }


   /**
     * ��������ɾ�����й�����
     * @param dbManager DBManager
     * @param registNo
     * @throws Exception
     */
    public void deleteByRegistNo(DBManager dbManager,String registNo) throws Exception{

        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //ɾ����¼
        String flowId ="";
       String condition ="  businessno ='" + registNo +"' and nodeType='regis'";
       Collection swfLogList = new ArrayList();
       SwfLogDto swfLogDto = new SwfLogDto();
       DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
       DBSwfPathLog dbSwfPathLog  = new DBSwfPathLog (dbManager);
       DBSwfFlowMain dbSwfFlowMain  = new DBSwfFlowMain (dbManager);

       swfLogList =dbSwfLog.findByConditions(condition,0,0) ;
       Iterator it = swfLogList.iterator() ;
       while (it.hasNext() )
       { swfLogDto = (SwfLogDto)it.next();
         flowId = swfLogDto.getFlowID();
       }
       if (!flowId.equals(""))
       {
       String deleteStr = "flowid ='"+ flowId+"'";
       dbSwfPathLog.deleteByConditions(deleteStr) ;
       dbSwfLog.deleteByConditions(deleteStr) ;
       dbSwfFlowMain.delete(flowId)  ;

       }

    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //������ɾ����¼
        //dbWorkFlow.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param workFlowDto workFlowDto
     * @throws Exception
     */
    public void update(DBManager dbManager,WorkFlowDto workFlowDto) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //���¼�¼
        //dbWorkFlow.update(workFlowDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param modelNo ģ�����
     * @param pathNo ���̱߱���
     * @param conditionNo ��������
     * @param serialNo ���
     * @return workFlowDto workFlowDto
     * @throws Exception
     */
    public WorkFlowDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        //����DTO
        WorkFlowDto workFlowDto = null;
        //��ѯ����,��ֵ��DTO
        //workFlowDto = dbWorkFlow.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return workFlowDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

       // int count = dbWorkFlow.getCount(SqlUtils.getWherePartForGetCount(conditions));
       // collection = dbWorkFlow.findByConditions(conditions,pageNo,rowsPerPage);
       // PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);

       PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,collection);
       return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����workFlowDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

     //   collection = dbWorkFlow.findByConditions(conditions,0,0);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions)
        throws Exception{
        DBWorkFlow dbWorkFlow = new DBWorkFlow();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count=0;
       // int count = dbWorkFlow.getCount(conditions);
        return count;
    }

    /**
     * ����������
     * @param dbManager DBManager
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     */

    public String createFlow(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         String  flowID="";
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

       flowID= dbWorkFlow.createFlow(dbManager,workFlowDto);
        return flowID;
    }

    /**
     * �رչ�����
     * @param dbManager DB������
     * @param flowID ����������
     * @return //
     * @throws Exception
     */
    public void closeFlow(DBManager dbManager,String flowID)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

        dbWorkFlow.closeFlow(dbManager,flowID);
        return ;
    }

    /**
     * 3.4.3.   �ջع�����
     * @param dbManager DB������
     * @param workFlowDto workFlowDto
     * @return //
     * @throws Exception
     */
    public void recycleFlow(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

        dbWorkFlow.recycleFlow(dbManager,workFlowDto);
        return ;
    }
    /**
      * �رչ�����
      * @param dbManager DBManager
      * @param workFlowDto WorkFlowDto
      * @throws Exception
      */

   public void closeFlow(DBManager dbManager,WorkFlowDto workFlowDto)
       throws Exception{
       DBWorkFlow dbWorkFlow = new DBWorkFlow();
       dbWorkFlow.closeFlow(dbManager,workFlowDto);
       return ;
   }

   /**
    * �رղ�ת��������
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */
   public void closeAndStoreFlow(DBManager dbManager,WorkFlowDto workFlowDto)
   throws Exception{
	   DBWorkFlow dbWorkFlow = new DBWorkFlow();
       dbWorkFlow.closeAndStoreFlow(dbManager,workFlowDto);
       return ;
   }
   /**
    * ת��������
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */

 public void storeFlow(DBManager dbManager,WorkFlowDto workFlowDto)
     throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.storeFlow(dbManager,workFlowDto);
     return ;
 }
   /**
    * �ؿ�������
    * @param dbManager DBManager
    * @param workFlowDto WorkFlowDto
    * @throws Exception
    */

 public void reOpenFlow(DBManager dbManager,WorkFlowDto workFlowDto)
     throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.reOpenFlow(dbManager,workFlowDto);
     return ;
 }
   /**
        * �������ύ�ڵ���Ϣ
        * @param dbManager DBManager
        * @param workFlowDto WorkFlowDto
        * @throws Exception
        */

    public String submitNode(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         String  flowID="";
         DBWorkFlow dbWorkFlow = new DBWorkFlow();

       flowID= dbWorkFlow.submitNode(dbManager,workFlowDto);
        return flowID;
    }
    /**
     * ���������½ڵ���Ϣ
     * @param dbManager DBManager
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     */
    public void updateNode(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
         DBWorkFlow dbWorkFlow = new DBWorkFlow();
         dbWorkFlow.updateNode(dbManager,workFlowDto);
         return;
    }
/**
 * �ͷ����и��û���ռ����Ϣ
 * @param dbManager
 * @param workFlowDto
 * @throws Exception
 */
    public void freeAllHoldNode(DBManager dbManager,WorkFlowDto workFlowDto)
    throws Exception{
     DBWorkFlow dbWorkFlow = new DBWorkFlow();
     dbWorkFlow.freeAllHoldNode(dbManager,workFlowDto);
     return;
}
	
    /**
     * ����������������
     * @param dbManager DBManager DB������
     * @param workFlowDto WorkFlowDto
     * @throws Exception
     * @return String
     */
    public void deal(DBManager dbManager,WorkFlowDto workFlowDto)
        throws Exception{
    	
    	
    	ArrayList workFlowDtoList = workFlowDto.getWorkFlowDtoList();
    	for(int i=0;i<workFlowDtoList.size();i++){
    		WorkFlowDto workFlowDto2 = (WorkFlowDto)workFlowDtoList.get(i);
	       //DBWorkFlow dbWorkFlow = new DBWorkFlow();
	       //����������
	       if (workFlowDto2.getCreate() )
	       {
	         createFlow(dbManager,workFlowDto2);
	       }
	      //     �ؿ���������
	       if (workFlowDto2.getReOpen() )
	       {
	       	reOpenFlow(dbManager,workFlowDto2);
	       }
	       //�ύ-������ (���ύ�����޸ģ���)
	       if (workFlowDto2.getSubmit() )
	       {
	         submitNode(dbManager,workFlowDto2);
	       }
	       //�ж��ǲ����ͷ�����ռ�ŵĲ���
	       if (workFlowDto2.getFreeHoldNode () )
	       {
	         freeAllHoldNode(dbManager,workFlowDto2);
	       }
	       //�޸Ĺ�����
	       if (workFlowDto2.getUpdate() )
	       {
	         updateNode(dbManager,workFlowDto2);
	       }
	       //�ر�-������
	       if (workFlowDto2.getClose() )
	       {
	    	   closeAndStoreFlow(dbManager,workFlowDto2);
	       }
	       //�ջ�-������
	       if (workFlowDto2.getRecycle() )
	       {
	         recycleFlow(dbManager,workFlowDto2);
	       }
       }
    }

    /**
    * ���������ҵ�ǰϵͳ��ʹ�õĹ�������ģ�����
    * @param dbManager DB������
    * @param riskCode ���ֱ���
    * @param comCode ������������

    * @return modelNo
    * @throws Exception
    */
   public int getModelNo(DBManager dbManager,String riskCode,String comCode) throws Exception{

       int modelNo=-1;
       DBWorkFlow dbWorkFlow = new DBWorkFlow();
       //��ѯ����,��ֵ��DTO
       modelNo = dbWorkFlow.getModelNo(dbManager,riskCode,comCode);
       return modelNo;
   }

   /**
     * ������ͳ������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @throws Exception
     */
    public Collection getStatStatus(DBManager dbManager,String conditions) throws Exception{
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        return collection = dbSwfLog.getStatStatus(conditions);
    }

  /**
     * ɾ��ע��/�������񣨼�Ϊ�˻�ע��/��������add 2005-11-24
     * @param flowID ���̺�
     * @param logNo  ���
     * @throws Exception
     * */
    public void cancelBack(DBManager dbManager, String flowID, int logNo) throws Exception {
        String strSwfPathLog = " FlowID='" + flowID + "' and EndNodeNo=" + logNo;
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
        SwfPathLogDto swfPathLogDto = new SwfPathLogDto();
        SwfLogDto swfLogDto = new SwfLogDto();
        UIWorkFlowAction uiWorkFlowAction =new UIWorkFlowAction();
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);
        DBPrpLclaimStatus dbPrpLclaimStatus = new DBPrpLclaimStatus(dbManager);
        String notion = "";
        PrpDuserDto prpDuser = new PrpDuserDto();
        PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        
        //�ҵ�ע��/�����������
        ArrayList swfPathLogList = (ArrayList) dbSwfPathLog.findByConditions(strSwfPathLog);
        if (swfPathLogList != null && swfPathLogList.size() > 0) {
            swfPathLogDto = (SwfPathLogDto) swfPathLogList.get(0);
        } else {
            throw new Exception("�����������ⲻ�ܻ��ˣ��������ݣ�");
        }
        
        //�ҵ�����ע��/���������ڵ�
        swfLogDto = (SwfLogDto) dbSwfLog.findByPrimaryKey(flowID, swfPathLogDto.getStartNodeNo());
        String strPrpLclaimStatus = " BusinessNo='" + swfLogDto.getKeyOut() + "' and NodeType='claim'";
        ArrayList prpLclaimStatusList = (ArrayList) dbPrpLclaimStatus.findByConditions(strPrpLclaimStatus);
        if (prpLclaimStatusList != null && prpLclaimStatusList.size() > 0) {
            prpLclaimStatusDto = (PrpLclaimStatusDto) prpLclaimStatusList.get(0);
        }
       
        if (swfLogDto.getNodeType().equals("claim")) {
            swfLogDto.setNodeStatus("2");
            swfLogDto.setBusinessNo(swfLogDto.getKeyIn());
            if (prpLclaimStatusDto != null) {
                prpLclaimStatusDto.setStatus("2");
            }
        } else {
            swfLogDto.setNodeStatus("0");
            swfLogDto.setKeyOut(null);
            swfLogDto.setHandlerCode(null);
            swfLogDto.setHandlerName(null);
            swfLogDto.setSubmitTime(null);
        }
        
        //������־��Ϣ
        int maxLineNo=uiWorkFlowAction.getSwfNotionMaxLineNo(flowID,logNo);
        SwfNotionDto swfNotionDto = new SwfNotionDto();
        swfNotionDto.setFlowID(flowID);
        swfNotionDto.setLogNo(logNo);
        swfNotionDto.setLineNo(maxLineNo);
        notion = swfLogDto.getHandlerName() + "��" + swfLogDto.getNodeName() + "�ڵ�İ���" 
                 + swfLogDto.getKeyIn()
                 + "������";
        if (notion.length() >35) {
            notion=notion.substring(0,35)+"...";
        }
        
        swfNotionDto.setHandleText(notion);
        dbSwfNotion.insert(swfNotionDto);
        dbSwfLog.delete(flowID, logNo);
        dbSwfPathLog.delete(flowID, swfPathLogDto.getPathNo());
        dbSwfLog.update(swfLogDto);
        dbPrpLclaimStatus.update(prpLclaimStatusDto);
    }

}
