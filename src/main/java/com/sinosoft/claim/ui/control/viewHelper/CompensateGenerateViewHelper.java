package com.sinosoft.claim.ui.control.viewHelper;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.sysframework.exceptionlog.UserException;

public abstract class CompensateGenerateViewHelper {
	/**
	 * 生成机动车险理算报告
	 * 
	 * @param 无
	 * @throws UserException
	 * @throws Exception
	 */
	public abstract void compensateGenerate(HttpServletRequest httpServletRequest, CompensateDto compensateDto) throws UserException, Exception;
	
	
	/**
	 * 将赔款金额按格式进行格式化输出
	 * @param pay
	 * @return
	 */
	protected String formatPay(double pay){
		return new DecimalFormat("#,##0.00").format(pay);
	}

	/**
	 * 返回填充n个空格的字符串
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
