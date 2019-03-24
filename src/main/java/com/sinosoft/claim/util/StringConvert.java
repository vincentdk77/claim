package com.sinosoft.claim.util;

/****************************************************************************
 * DESC       ���ַ�����ش�������
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-08-23
 * MODIFYLIST ��  Name       Date            Reason/Contents
 ****************************************************************************/

import java.text.DecimalFormat;
import java.util.StringTokenizer;

import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.SysConfig;

/**
 *  ����������ش�������
 */
public class StringConvert {
	//��׼�Ļ��Ҹ�ʽ����׼
	private final static DecimalFormat nf = new DecimalFormat("###,##0.00");

	/**
	 * ������������ƴ������
	 * @param    strName   �ֶ���
	 * @param    strValue  ƥ��ֵ
	 * @param    strSign   ƥ�䷽ʽ
	 * @return   �����ִ�
	 * @throws com.sinosoft.utility.error.UserException 
	 */
	public static String convertDate(String strName, String strValue, String strSign) throws UserException, com.sinosoft.utility.error.UserException {
		String strReturn = "";
		String strDbType = SysConfig.getProperty("DBTYPE");
		if (strValue == null || strValue.equals("")) {
			return "";
		} else {
			if (strDbType.equals("ORACLE")) {
				strReturn = " and " + strName + strSign + "to_date('" + strValue.trim() + "','YYYY-MM-DD') ";
			} else {
				strReturn = " and " + strName + strSign + "'" + strValue.trim() + "' ";
			}
		}
		return strReturn;
	}

	/**
	 * �ַ�����������ƴ������
	 * @param    strName   �ֶ���
	 * @param    strValue  ƥ��ֵ
	 * @param    strSign   ƥ�䷽ʽ
	 * @return   �����ִ�
	 */
	public static String convertString(String strName, String strValue, String strSign) {
		String strReturn = "";
		if (strSign == null) {
			strSign = "=";
		}
		if (strValue == null || strValue.equals("")) {
			return "";
		} else {
			if (strSign.equals("=")) {
				strReturn = " and " + strName + "='" + strValue.trim() + "' ";
			} else if(strSign.equals("!=") || strSign.equals("<>")){
				strReturn = " and " + strName + "!='" + strValue.trim() + "' ";
			}else {
				strValue = replace(strValue, "*", "%");
				strReturn = " and " + strName + " like '%" + strValue.trim() + "%' ";
			}
			return strReturn;
		}
	}
	
	/**
	 * �ַ�����������ƴ������ Ĭ��ģ����ѯ
	 * @param    strName   �ֶ���
	 * @param    strValue  ƥ��ֵ
	 * @param    strSign   ƥ�䷽ʽ
	 * @return   �����ִ�
	 */
	public static String convertString1(String strName, String strValue, String strSign) {
		String strReturn = "";
		if (strSign == null) {
			strSign = "*";
		}
		if (strValue == null || strValue.equals("")) {
			return "";
		} else {
			if (strSign.equals("=")) {
				strReturn = " and " + strName + "='" + strValue.trim() + "' ";
			} else if(strSign.equals("!=") || strSign.equals("<>")){
				strReturn = " and " + strName + "!='" + strValue.trim() + "' ";
			}else {
				strValue = replace(strValue, "*", "%");
				strReturn = " and " + strName + " like '%" + strValue.trim() + "%' ";
			}
			return strReturn;
		}
	}
	
	public static String convertStringForEar(String strName, String strValue, String strSign) {
		String strReturn = "";
		if (strSign == null) {
			strSign = "=";
		}
		if (strValue == null || strValue.equals("")) {
			return "";
		} else {
			if (strSign.equals("=")) {
				strReturn = " and " + strName + "='" + strValue.trim() + "' ";
			} else if(strSign.equals("!=") || strSign.equals("<>")){
				strReturn = " and " + strName + "!='" + strValue.trim() + "' ";
			}else {
				strValue = replace(strValue, "*", "%");
				strReturn = " and " + strName + " like '" + strValue.trim() + "%' ";
			}
			return strReturn;
		}
	}

	/**
	 * �ַ��� ת����HTML��ʽ
	 * @param    strInValue�������ַ���
	 * @return   strOutValue:�����ַ���
	 */
	public static String toHTMLFormat(String strInValue) {
		String strOutValue = "";
		char c;
		for (int i = 0; i < strInValue.length(); i++) {
			c = strInValue.charAt(i);
			switch (c) {
			case '<':
				strOutValue += "&lt;";
				break;
			case '>':
				strOutValue += "&gt;";
				break;
			case '\n':
				strOutValue += "<br>";
				break;
			case '\r':
				break;
			case ' ':
				strOutValue += "&nbsp;";
				break;
			default:
				strOutValue += c;
				break;
			}
		}
		return strOutValue;
	}

	/**
	 * �ַ����滻����
	 * @param strMain��ԭ����strFind�������ַ�����strReplaceWith���滻�ַ���
	 * @return �滻����ַ��������ԭ��Ϊ�ջ���Ϊ""���򷵻�""
	 */
	public static String replace(String strMain, String strFind, String strReplaceWith) {
		String strReturn = "";
		int intStartIndex = 0, intEndIndex = 0;

		if (strMain == null || strMain.equals(""))
			return "";

		while ((intEndIndex = strMain.indexOf(strFind, intStartIndex)) > -1) {
			strReturn = strReturn + strMain.substring(intStartIndex, intEndIndex) + strReplaceWith;
			intStartIndex = intEndIndex + strFind.length();
		}
		strReturn = strReturn + strMain.substring(intStartIndex, strMain.length());
		return strReturn;
	}

	/**
	 * �ַ���Сʱ���Ӹ�ʽ������
	 * @param strTime
	 * @return �滻����ַ��������ԭ��Ϊ�ջ���Ϊ""���򷵻�"00"
	 */
	public static String newString(String strTime) {
		String strReturn = "00";
		if (strTime != null) {
			if (strTime.trim().length() == 0) {
				strReturn = "00";
			}
			if (strTime.trim().length() == 1) {
				strReturn = "0" + strTime.trim();
			}
			if (strTime.trim().length() >= 2) {
				strReturn = strTime.trim();
			}
		}
		return strReturn;
	}

	/**
	 * �淶��ȷ�����ڸ�ʽ
	 * @param strTime
	 * @return �滻����ַ�����"00:00:00"
	 */
	public static String toStandardTime(String strTime) {
		String strReturn = "";
		if (strTime != null) {
			java.util.StringTokenizer t = new StringTokenizer(strTime, ":");
			while (t.hasMoreTokens()) {
				String strTemp = t.nextToken();
				if (strTemp.trim().length() == 1) {
					strTemp = "0" + strTemp.trim();
				} else if (strTemp.trim().length() >= 2) {
					strTemp = strTemp.trim().substring(0, 2);
				} else if (strTemp.trim().length() == 0) {
					strTemp = "00";
				}
				strReturn = strReturn + strTemp + ":";
			}
			if (strReturn.length() == 3) {
				strReturn = strReturn + "00:00";
			} else if (strReturn.length() == 6) {
				strReturn = strReturn + "00";
			} else if (strReturn.length() == 9) {
				strReturn = strReturn.substring(0, 8);
			} else if (strReturn.length() == 0) {
				strReturn = "00:00:00";
			}
		} else {
			strReturn = "00:00:00";
		}
		//int intColon = strReturn.length()
		return strReturn;
	}

	/**
	 * �淶String ��ʽ����###,###.00��Ǯ�ķ�ʽ
	 * @param strMoney
	 * @return �滻����ַ�����"��ֵ3λ��С��2λ"
	 */
	public static String formatToMoney(String strMoney) {
		if (strMoney == null || strMoney.equals("")) {
			return "0.00";
		}
		try {
			return formatToMoney(Double.parseDouble(strMoney));
		} catch (Exception e) {
			return strMoney;
		}
	}

	public static String formatToMoney(double d) {
		try {
			return nf.format(d);
		} catch (Exception e) {
			return String.valueOf(d);
		}
	}

	/**
	 * �ַ������
	 * @param    strInValue�������ַ���
	 * @return   strOutValue:�����ַ���
	 */
	public static String encode(String strInValue) {
		String strOutValue = "";
		char c;

		for (int i = 0; i < strInValue.length(); i++) {
			c = strInValue.charAt(i);
			switch (c) {
			case ':': //hardcode ͬCommon.js�� NAMEVALUEDELIMITER   //��������ֵ�ķָ���
				strOutValue += "��"; //hardcode
				break;
			case '|': //hardcode ͬCommon.js�� FIELDDELIMITER       //��֮��ķָ���
				strOutValue += "��";
				break;
			case '\n':
				strOutValue += "\\n";
				break;
			case '\r':
				strOutValue += "\\r";
				break;
			case '\"':
				strOutValue += "\\\"";
				break;
			case '\'':
				strOutValue += "\\\'";
				break;
			case '\b':
				strOutValue += "\\b";
				break;
			case '\t':
				strOutValue += "\\t";
				break;
			case '\f':
				strOutValue += "\\f";
				break;
			case '\\':
				strOutValue += "\\\\";
				break;
			case '<':
				strOutValue += "\\<";
				break;
			case '>':
				strOutValue += "\\>";
				break;
			default:
				strOutValue += c;
				break;
			}
		}
		return strOutValue;
	}

	/**
	 * ���ַ�������ָ���ķָ��ַ����в��,���ش�ָ����ŵķָ�����ǰһ���ָ���֮����ַ���
	 * @param  strMain:���ַ�����strDelimiters:�ָ�����intSerialNo:�ָ������
	 * @return ָ����ŵķָ�����ǰһ���ָ���֮����ַ���,���û���ҵ��򷵻�""
	 */
	public static String decodeStr(String strMain, String strDelimiters, int intSerialNo) {
		int posStart = 0;
		int posEnd = 0;
		String strReturn = ""; //��Ϊ����ֵ���ַ���

		if (strMain.length() < strDelimiters.length())
			return ""; //�����ַ����ȷָ�������Ҫ�̵Ļ�,�򷵻ؿ��ַ���

		posStart = getPos(strMain, strDelimiters, intSerialNo - 1);
		if (posStart == -1) {
			posStart = 0;
		} else {
			posStart = posStart + strDelimiters.length();
		}

		posEnd = getPos(strMain, strDelimiters, intSerialNo);
		if (posEnd == -1) {
			posEnd = 0;
		}
		strReturn = strMain.substring(posStart, posEnd);
		return strReturn;
	}

	/**
	 * �ַ������
	 * @param    strInValue�������ַ���
	 * @return   strOutValue:�����ַ���
	 */
	public static String decode(String strInValue) {
		String strOutValue = strInValue;
		strOutValue = replace(strOutValue, "\\n", "\n");
		strOutValue = replace(strOutValue, "\\r", "\r");
		strOutValue = replace(strOutValue, "\\\\", "\\");
		strOutValue = replace(strOutValue, "\\b", "\b");
		strOutValue = replace(strOutValue, "\\t", "\t");
		strOutValue = replace(strOutValue, "\\\"", "\"");
		strOutValue = replace(strOutValue, "\\\'", "\'");
		strOutValue = replace(strOutValue, "\\f", "\f");
		strOutValue = replace(strOutValue, "\\<", "<");
		strOutValue = replace(strOutValue, "\\>", ">");
		return strOutValue;
	}

	/**
	 * ��ȡ�Ӵ��������г��� n �ε�λ��
	 * @param strMain:���ַ�����strSub:���ַ�����intTimes:���ִ���
	 * @return  λ��ֵ,����Ӵ���������û�г���ָ������,�򷵻�-1
	 */
	public static int getPos(String strMain, String strSub, int intTimes) {
		return getPos(strMain, strSub, 0, intTimes);
	}

	/**
	 * ��ȡ��ָ��λ�ÿ�ʼ�Ӵ��������г��� n �ε�λ��
	 * @param strMain:���ַ�����strSub:���ַ�����intStartIndex:��ʼλ�ã�intTimes:���ִ���
	 * @return  λ��ֵ,�������ʼλ�����Ӵ���������û�г���ָ������,�򷵻�-1
	 */
	public static int getPos(String strMain, String strSub, int intStartIndex, int intTimes) {
		int intCounter = 0; //ѭ������
		int intPosition = intStartIndex; //λ�ü�¼
		int intLength = strSub.length(); //�Ӵ�����

		if (intTimes <= 0)
			return -1;

		if (strMain.length() - 1 < intStartIndex)
			return -1;

		if (strSub.equals(""))
			return 0;

		while (intCounter < intTimes) {
			intPosition = strMain.indexOf(strSub, intPosition);
			if (intPosition == -1)
				return -1;

			intCounter++;
			intPosition += intLength;
		}
		return intPosition - intLength;
	}

	/**
	 * ���ַ�������ָ���ķָ��ַ����в��,���ز�ֺ���ַ�������
	 * @param  strIn:����ֵ��ַ�����strDelimiters:�ָ���
	 * @return �ַ�������
	 */
	public static String[] split(String strIn, String strDelimiters) throws Exception {
		int theIndex = 0;
		String[] arrReturn = null; //����ֵ�ַ�������
//		String strErrorMessage = ""; //������Ϣ
		int intCount = 0; //����Ĵ�С

		if (strIn == null || strIn.equals("") || strDelimiters == null || strDelimiters.equals("")) {
//			strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): ������ַ����ͷָ�����������Ϊ��";
			//throw new Exception(strErrorMessage);  //������ַ����ͷָ�����������Ϊ��
			return new String[0];
		}

		if (strIn.length() < strDelimiters.length()) {
//			strErrorMessage = "Str.split('" + strIn + "','" + strDelimiters + "'): ������ַ����ȷָ�������Ҫ��";
			//throw new Exception(strErrorMessage);  //������ַ����ȷָ�������Ҫ��
			return new String[0];
		}

		//�����ַ����ж��ٸ��ָ���
		String strTemp = strIn;
		while (strTemp != "" && strTemp != null) {
			theIndex = strTemp.indexOf(strDelimiters);
			if (theIndex == -1) {
				break;
			}
			intCount++;
			strTemp = strTemp.substring(theIndex + strDelimiters.length());
		}
		arrReturn = new String[++intCount];

		//�����ַ�������
		for (int i = 0; i < intCount - 1; i++) {
			theIndex = strIn.indexOf(strDelimiters);
			arrReturn[i] = strIn.substring(0, theIndex);
			strIn = strIn.substring(theIndex + strDelimiters.length());
		}
		arrReturn[intCount - 1] = strIn;

		return arrReturn;
	}

}
