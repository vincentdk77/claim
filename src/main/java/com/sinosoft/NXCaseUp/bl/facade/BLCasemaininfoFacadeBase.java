package com.sinosoft.NXCaseUp.bl.facade;

import java.util.*;

import com.sinosoft.aip.webservice.server.CaseMainInfo;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasemaininfoDto;
import com.sinosoft.NXCaseUp.bl.action.domain.BLCasemaininfoAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEMAININFO��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasemaininfoFacadeBase{
    private static Logger logger = Logger.getLogger(BLCasemaininfoFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCasemaininfoFacadeBase(){
    }

    /**
     * ����һ������
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void insert(CaseMainInfo caseMainInfo )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //�����¼
            CasemaininfoDto casemaininfoDto = new CasemaininfoDto();
            casemaininfoDto.setComcode(caseMainInfo.getCompanyCode());
            casemaininfoDto.setPolicyno(caseMainInfo.getPolicyNumber());
            casemaininfoDto.setCaseno(caseMainInfo.getCaseNumber());
            casemaininfoDto.setClaimno(caseMainInfo.getClaimNumber());
            casemaininfoDto.setUnderwriteenddate(caseMainInfo.getAssessmentDate());
            casemaininfoDto.setEndcasedate(caseMainInfo.getSettlementDate());
            casemaininfoDto.setAsumpaid(caseMainInfo.getSetteledAmount());
            casemaininfoDto.setAsumfee(caseMainInfo.getSetteledDirectExpense());
            casemaininfoDto.setCasemoney(caseMainInfo.getClaimAmout());
            casemaininfoDto.setCasemoneyfee(caseMainInfo.getDirectExpense());
            casemaininfoDto.setPresumpaid(caseMainInfo.getPrepaidAmount());
            casemaininfoDto.setPresumfee(caseMainInfo.getPrepaidDirectExpense());
            casemaininfoDto.setDamageinsured(caseMainInfo.getSettledFamilyNumber());
            casemaininfoDto.setLossesnumber(caseMainInfo.getSettledObjectNumber());
            casemaininfoDto.setLossesunitcode(caseMainInfo.getMeasuremantUnit());
            casemaininfoDto.setReopenedtype(caseMainInfo.getReopenedType());
            casemaininfoDto.setTimes(caseMainInfo.getReopenedTimes());
            casemaininfoDto.setAffectedarea(caseMainInfo.getAffectedArea());
            casemaininfoDto.setLossarea(caseMainInfo.getLossArea());
            casemaininfoDto.setLawsuitflag(caseMainInfo.getLawsuitFlag());
            casemaininfoDto.setFarmercount(caseMainInfo.getFarmerCount());
            casemaininfoDto.setClaimcode(caseMainInfo.getClaimSequenceNo());
            casemaininfoDto.setDamagedarea(caseMainInfo.getDamagedArea());
            blCasemaininfoAction.insert(dbManager,casemaininfoDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ��һ������
     * @param comcode COMCODE
     * @throws Exception
     */
    public void delete(String comcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCasemaininfoAction.delete(dbManager,comcode);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCasemaininfoAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������(���������޷����)
     * @param casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public void update(CasemaininfoDto casemaininfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCasemaininfoAction.update(dbManager,casemaininfoDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����������һ������
     * @param comcode COMCODE
     * @return casemaininfoDto casemaininfoDto
     * @throws Exception
     */
    public CasemaininfoDto findByPrimaryKey(String comcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        //����DTO
        CasemaininfoDto casemaininfoDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            casemaininfoDto = blCasemaininfoAction.findByPrimaryKey(dbManager,comcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return casemaininfoDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCasemaininfoAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����casemaininfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCasemaininfoAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasemaininfoAction blCasemaininfoAction = new BLCasemaininfoAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCasemaininfoAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
