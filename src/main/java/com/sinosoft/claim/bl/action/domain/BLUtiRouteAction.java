package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiRouteDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����UtiRoute·�����ñ��ҵ�������չ��<br>
 * ������ 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiRouteAction extends BLUtiRouteActionBase{
    private static Log log = LogFactory.getLog(BLUtiRouteAction.class.getName());

    /**
     * ���캯��
     */
    public BLUtiRouteAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param utiRouteDto utiRouteDto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,UtiRouteDto utiRouteDto,String mode) throws Exception{
    }
}
