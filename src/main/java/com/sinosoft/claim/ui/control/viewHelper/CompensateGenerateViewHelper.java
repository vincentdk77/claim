package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.sysframework.exceptionlog.UserException;

public abstract class CompensateGenerateViewHelper {
	/**
	 * ���ɻ����������㱨��
	 * 
	 * @param ��
	 * @throws UserException
	 * @throws Exception
	 */
	public abstract void compensateGenerate(HttpServletRequest httpServletRequest, CompensateDto compensateDto) throws UserException, Exception;
	
	
	/**
	 * ��������ʽ���и�ʽ�����
	 * @param pay
	 * @return
	 */
	protected String formatPay(double pay){
		return new DecimalFormat("#,##0.00").format(pay);
	}

	/**
	 * �������n���ո���ַ���
	 * @param n
	 * @return
	 */
	protected String space(int n){
		StringBuffer sb= new StringBuffer("");
		for (int i = 0; i < n; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
