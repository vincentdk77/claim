package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterAutoClaimDetail;

/**
 * ���Ǵ�ҽ�������Զ�����״̬��ѯ���ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterAutoClaimDetailAction extends BLPrplinterAutoClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailAction.class);

    /**
     * ���캯��
     */
    public BLPrplinterAutoClaimDetailAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prplinterAutoClaimDetailDto[] prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterAutoClaimDetailDto[] prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //�����¼
        for(int i=0;i<prplinterAutoClaimDetailDto.length;i++){
        	dbPrplinterAutoClaimDetail.insert(prplinterAutoClaimDetailDto[i]);
        }
    }
}
