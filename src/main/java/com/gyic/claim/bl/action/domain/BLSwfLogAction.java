package com.gyic.claim.bl.action.domain;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.gyic.claim.dto.domain.PrplcombineSwfLogDto;
import com.sinosoft.platform.dto.domain.PrpDriskDto;
import com.sinosoft.platform.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����SwfLog��������־���ҵ�������չ��<br>
 * ������ 2004-08-09 19:54:55.006<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfLogAction extends BLSwfLogActionBase {
    private static Log logger = LogFactory.getLog(BLSwfLogAction.class);

    /**
     * ���캯��
     */
    public BLSwfLogAction() {
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param swfLogDto swfLogDto
     * @param mode ģʽ
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
     * �ϲ������޸�ת��Dto
     * @param dbManager dbManager
     * @param swfLogDto swfLogDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertComBineDto(DBManager dbManager, PrplcombineSwfLogDto swfLogDto, String mode)
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
     * ��ѯflowID�����logno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxLogNo(DBManager dbManager, String flowID) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        int logNo = dbSwfLog.getMaxLogNo(flowID);
        return logNo;
    }
    
    /**
     * ��ѯflowID�����logno��ֵ
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return flowID
     * @throws Exception
     */
    public int getMaxNodeLogNo(DBManager dbManager, String flowID,String nodeType,String businessNo) throws Exception {
        DBSwfLog dbSwfLog = new DBSwfLog(dbManager);

        int logNo = dbSwfLog.getMaxNodeLogNo(flowID,nodeType,businessNo);
        return logNo;
    }

    /**
     * ����flowId��ѯ���ڵ�Ľڵ�����
     * @param dbManager DB������
     * @param flowID flowID
     * @return �ڵ�����
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
     * ������ͳ�ƽڵ�����
     * @param dbManager DB������
     * @param conditions ͳ�ƽڵ�����
     * @return Collection ����statDto�ļ���
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
     * ������ͳ�ƽڵ�����
     * @param dbManager DB������
     * @param conditions ͳ�ƽڵ�����
     * @return Collection ����statDto�ļ���
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
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
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
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByPolicyNo(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findByPolicyNo(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
            SwfLogDto swfLogDto = (SwfLogDto) iter.next();
            convertDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    /**
     * ���¹ʺŲ�ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByComBineNo(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findByComBineNo(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
        	PrplcombineSwfLogDto swfLogDto = (PrplcombineSwfLogDto) iter.next();
        	convertComBineDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    /**
     * �������Ų�ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByRegistNo(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findByRegistNo(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
        	PrplcombineSwfLogDto swfLogDto = (PrplcombineSwfLogDto) iter.next();
        	convertComBineDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    /**
     * �������Ų�ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findBypolicyNo(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findBypolicyNo(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
        	PrplcombineSwfLogDto swfLogDto = (PrplcombineSwfLogDto) iter.next();
        	convertComBineDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
    /**
     * �������Ų�ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findCompensateListByConditions(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findCompensateListByConditions(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
        	PrplcombineSwfLogDto swfLogDto = (PrplcombineSwfLogDto) iter.next();
        	convertComBineDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
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
     * �鿱�˻�
     */
    public void updateStatusReurun(DBManager dbManager,SwfLogDto swfLogDto) throws SQLException, Exception{
    	DBSwfLog dbSwfLog = new DBSwfLog(dbManager);
    	dbSwfLog.updateReturnStatus(swfLogDto);	
    } 
    /**
     * �������Ų�ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findComBineListByCondition(DBManager dbManager, String conditions,
            int pageNo, int rowsPerPage) throws Exception {
        PageRecord pageRecord = super.findComBineListByCondition(dbManager, conditions,
                pageNo, rowsPerPage);
        for (Iterator iter = pageRecord.getResult().iterator(); iter.hasNext();) {
        	PrplcombineSwfLogDto swfLogDto = (PrplcombineSwfLogDto) iter.next();
        	convertComBineDto(dbManager, swfLogDto, "view");
        }
        return pageRecord;
    }
}
