package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prplprepayԤ��ǼǱ�����ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLprepay extends DBPrpLprepayBase{
    private static Log log = LogFactory.getLog(DBPrpLprepay.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLprepay(DBManager dbManager){
        super(dbManager);
    }

    /**
     * ��������prplprepay��,prplregist���prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:���ӳ��ƺţ�����״̬������ʱ���ѯ�������ڲ�ѯ��������Ӱ���״̬
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT a.preCompensateNo,"+
                           "a.ClaimNo, "+
                           "a.PolicyNo, "+
                           "a.handlerCode, "+
                           "a.UnderWriteFlag, "+
                           "b.OperateDate, "+
                           "b.Status, "+
                           "b.RiskCode, "+
                           "c.LicenseNo From (select * from PrpLClaimStatus where NodeType='prepa') b LEFT JOIN PrpLprepay a ON a.precompensateno = b.BusinessNo LEFT JOIN (SELECT PrpLclaim.ClaimNo AS ClaimNo,PrpLclaim.RegistNo AS RegistNo,PrpLregist.LicenseNo AS LicenseNo from PrpLclaim LEFT JOIN PrpLregist on PrpLregist.RegistNo=PrpLclaim.RegistNo) c ON a.ClaimNo = c.ClaimNo where"+conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLprepayDto prpLprepayDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }
            prpLprepayDto = new PrpLprepayDto();
            prpLprepayDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepayDto.setClaimNo(dbManager.getString(resultSet,2));
            prpLprepayDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLprepayDto.setHandlerCode(dbManager.getString(resultSet,4));
            prpLprepayDto.setUnderWriteFlag(dbManager.getString(resultSet,5));
            prpLprepayDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLprepayDto.setStatus(dbManager.getString(resultSet,7));
            prpLprepayDto.setRiskCode(dbManager.getString(resultSet,8));
            collection.add(prpLprepayDto);
        }
        resultSet.close();
        log.info("DBPrpLprepay.findByConditions() success!");
        return collection;
    }


    /**
     * ��������prplprepay,prplclaimstatus���в�ѯ��������
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-09-07 Reason:ʵ�⸴�˲�ѯ����
     */
    public Collection findByApproveQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select prplprepay.preCompensateNo,"+
                           "prplprepay.PolicyNo, "+
                           "prplprepay.ClaimNo, "+
                           "prplprepay.OperatorCode, "+
                           "prplprepay.RiskCode, "+
                           "prplprepay.InputDate from prplprepay left join prplclaimstatus on prplclaimstatus.businessno = prplprepay.preCompensateNo and prplclaimstatus.nodetype='prepa' where "+conditions ;
        log.debug(statement);
        System.out.println("**********************Ԥ�⸴�˲�ѯ����::"+statement);
        Collection collection = new ArrayList();
        PrpLprepayDto prpLprepayDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }
            prpLprepayDto = new PrpLprepayDto();
            prpLprepayDto.setPreCompensateNo(dbManager.getString(resultSet,1));
            prpLprepayDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpLprepayDto.setClaimNo(dbManager.getString(resultSet,3));
            prpLprepayDto.setOperatorCode(dbManager.getString(resultSet,4));
            prpLprepayDto.setRiskCode(dbManager.getString(resultSet,5));
            prpLprepayDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            collection.add(prpLprepayDto);
        }
        resultSet.close();
        log.info("DBPrpLprepay.findByApproveConditions() success!");
        return collection;
    }

    /**
     * ����ʵ��
     * @param preCompensateNo��Ԥ�����
     * @param userCode������Ա����
     * @param underWriteFlag�������־
     * @throws Exception
     */
    public void approve(String preCompensateNo,String userCode,String underWriteFlag) throws Exception{
        String statement = " Update PrpLprepay  set ApproverCode = '"+userCode+"',UnderWriteFlag = '"+underWriteFlag+"' where preCompensateNo = '"+preCompensateNo+"'";
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.executePreparedUpdate();
        log.info("DBPrpLcompensateBase.delete() success!");
    }
}
