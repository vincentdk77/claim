package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLacciCheck--�⽡�յ��������ҵ�������չ�� <br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckAction extends BLPrpLacciCheckActionBase {
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckAction.class);

    /**
     * ���캯��
     */
    public BLPrpLacciCheckAction() {
        super();
    }

    /**
     * ת��Dto
     * 
     * @param dbManager dbManager
     * @param prpLacciCheckDto prpLacciCheckDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrpLacciCheckDto prpLacciCheckDto, String mode) throws Exception {
    }

    /**
     * ����һ������
     * 
     * @param dbManager DB������
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager, PrpLacciCheckDto prpLacciCheckDto) throws Exception {

        Collection result = super.findByConditions(dbManager, "RegistNo='" + prpLacciCheckDto.getRegistNo()
                + "' Order by Times desc");
        int times = 0;
        if (result.size() > 0) {
            times = ((PrpLacciCheckDto) result.iterator().next()).getTimes();
        }

        prpLacciCheckDto.setTimes(++times);

        BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
        PrpLregistDto prpLregistDto = blPrpLregistAction.findByPrimaryKey(dbManager, prpLacciCheckDto.getRegistNo());

        prpLacciCheckDto.setCheckNo(prpLacciCheckDto.getRegistNo() + "-"
                + StringUtils.newString("0", 3 - String.valueOf(prpLacciCheckDto.getTimes()).length())
                + prpLacciCheckDto.getTimes());
        prpLacciCheckDto.setRiskCode(prpLregistDto.getRiskCode());
        prpLacciCheckDto.setPolicyNo(prpLregistDto.getPolicyNo());
        prpLacciCheckDto.setApproverStatus("0");
        //�����¼
        super.insert(dbManager, prpLacciCheckDto);
    }

    /**
     * ��õ���ĳ�������ŵ����е�������ܺ�
     * @param dbManager
     * @param registNo
     * @return
     * @throws Exception
     */
    public double getAcciCheckFeeByRegistNo(DBManager dbManager, String registNo) throws Exception {
    	 DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
         //�����¼
         return dbPrpLacciCheck.getSumAcciCheckFeeByRegistNo(registNo);
    }

}
