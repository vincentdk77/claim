package com.sinosoft.NXCaseUp.bl.facade;

import java.util.*;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;
import com.sinosoft.NXCaseUp.bl.action.domain.BLCasefarmerAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEFARMER��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLCasefarmerFacadeBase{
    private static Logger logger = Logger.getLogger(BLCasefarmerFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCasefarmerFacadeBase(){
    }

    /**
     * ����һ������
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void insert(CaseDto caseDto )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        ClaimFarmerInfo claimFarmerInfo = null;
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            for(int i=0; i<caseDto.getFarmerInfoList().length; i++){
            	claimFarmerInfo = caseDto.getFarmerInfoList()[i];
            	 //�����¼
            	CasefarmerDto casefarmerDto = new CasefarmerDto();
                casefarmerDto.setFarmername(claimFarmerInfo.getFarmerName());
                casefarmerDto.setFarmeridnumber(claimFarmerInfo.getFarmerIDNumber());
                casefarmerDto.setFarmerphone(claimFarmerInfo.getFarmerTelephone());
                casefarmerDto.setInsureobiectnumber(claimFarmerInfo.getInsuredObjectNumber());
                casefarmerDto.setLossdegree(claimFarmerInfo.getLossDegree());
                casefarmerDto.setSettleamount(claimFarmerInfo.getSettledAmount());
                casefarmerDto.setSettlesumamount(claimFarmerInfo.getSettledSumAmount());
                casefarmerDto.setSerino(claimFarmerInfo.getSerialNo());
                casefarmerDto.setAffectedarea(claimFarmerInfo.getAffectedArea());
                casefarmerDto.setDamagedarea(claimFarmerInfo.getDamagedArea());
                casefarmerDto.setLossarea(claimFarmerInfo.getLossArea());
                casefarmerDto.setMeasuremantunit(claimFarmerInfo.getMeasuremantUnit());
                casefarmerDto.setCaseno(claimFarmerInfo.getCaseNumber());
                casefarmerDto.setFarmeridtype(claimFarmerInfo.getFarmerIDType());
                casefarmerDto.setSettleobjectnumber(claimFarmerInfo.getSettledObjectNumber());
                casefarmerDto.setPrepaidamount(claimFarmerInfo.getPrepaidAmount());
                blCasefarmerAction.insert(dbManager,casefarmerDto);
            }
           
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
     * @param farmername FARMERNAME
     * @throws Exception
     */
    public void delete(String farmername)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blCasefarmerAction.delete(dbManager,farmername);
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blCasefarmerAction.deleteByConditions(dbManager,conditions);
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
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void update(CasefarmerDto casefarmerDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blCasefarmerAction.update(dbManager,casefarmerDto);
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
     * @param farmername FARMERNAME
     * @return casefarmerDto casefarmerDto
     * @throws Exception
     */
    public CasefarmerDto findByPrimaryKey(String farmername)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        //����DTO
        CasefarmerDto casefarmerDto = null;
        try{
            dbManager.open("ddccDataSource");
            //��ѯ����,��ֵ��DTO
            casefarmerDto = blCasefarmerAction.findByPrimaryKey(dbManager,farmername);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return casefarmerDto;
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            pageRecord = blCasefarmerAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����casefarmerDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            collection = blCasefarmerAction.findByConditions(dbManager,conditions);
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
        BLCasefarmerAction blCasefarmerAction = new BLCasefarmerAction();
        try{
            dbManager.open("ddccDataSource");
            rowCount = blCasefarmerAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}
