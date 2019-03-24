package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterClaimApp;

/**
 * ����������������Ϣ��ҵ�������չ��<br>
 * ������ JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterClaimAppAction extends BLPrpLinterClaimAppActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterClaimAppAction.class);

    /**
     * ���캯��
     */
    public BLPrpLinterClaimAppAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param prpLinterClaimAppDto prpLinterClaimAppDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterClaimAppDto prpLinterClaimAppDto,String mode)
            throws Exception{
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLinterClaimAppDto[] prpLinterClaimAppDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterClaimAppDto[] prpLinterClaimAppDto)
            throws Exception{
        DBPrpLinterClaimApp dbPrpLinterClaimApp = new DBPrpLinterClaimApp(dbManager);
        //�����¼
        for(int i=0;i<prpLinterClaimAppDto.length;i++){
        	dbPrpLinterClaimApp.insert(prpLinterClaimAppDto[i]);
        }
    }
}
