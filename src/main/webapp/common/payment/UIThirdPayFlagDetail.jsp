 <%--
****************************************************************************
* DESC       ��������֧����Ϣ�˻������ѯ�б�ҳ��
* Author     : ��Ԫ��Ŀ��
* CREATEDATE ��2013-10-14
* MODIFYLIST ��Name          Date          Reason/Contents
              zhongfen       2013-09-14
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<html>
   <head>
   <title>��ʾ�б�</title>
    <link rel="stylesheet" type="text/css" href="/newclaim/css/Standard.css">
  </head>
  <script type="text/javascript">
  function initBody(){
	window.moveTo(250,250);
  }
  </script>
  <body class="interface" onload="initBody();">
    <form name="fm" method="post">
    <table cellpadding="0" cellspacing="0" border="0" width="100%"><tr><td>
    <div class="Wscrollbar">
      <table class="common1" cellpadding="5" cellspacing="1" align="center">
        <tr class="listtitle" > 
          <td nowrap>״̬�� </td>
          <td nowrap>״̬�����</td>
          <td nowrap>״̬��˵��</td>
        </tr>                

        <tr class="listodd"><td>0</td><td align=center>���ύ            </td><td align=left>��¼�벢����֧����Ϣ������δ�ύ���</td></tr>
		<tr class="listodd"><td>1</td><td align=center>�����            </td><td align=left>֧����Ϣ�Ѿ��ύ��ˣ��ȴ����</td></tr>
		<tr class="listodd"><td>2</td><td align=center>��˲�ͨ��        </td><td align=left>֧����Ϣ���������˲�ͨ�������˻�</td></tr>
		<tr class="listodd"><td>3</td><td align=center>֧�����Ĵ�����    </td><td align=left>�������ʱ����ʾ֧����Ϣ�ѷ���֧�����ģ����ڴ�����״̬<br>�������ʱ����ʾΪ���������Ѿ���ϣ��ѷ���֧�����ģ����ڴ�����״̬</td></tr>
		<tr class="listodd"><td>4</td><td align=center>֧�������˻�      </td><td align=left>�������ʱ��֧�������ڷ�������ǰ��֧�����ķ��������Ѿ��˻أ���֧������ֱ���˻ص�����<br>�������ʱ��֧��������ȷ��ǰֱ���˻ص�����</td></tr>
		<tr class="listodd"><td>5</td><td align=center>�Ѵ�������      </td><td align=left>֧����Ϣ����֧�����Ĵ�����ȴ�����֧�����</td></tr>
		<tr class="listodd"><td>6</td><td align=center>������ͨ��������</td><td align=left>֧����Ϣ����֧�����Ĵ������ͨ���˲����֧����ˣ��ȴ��������ж�</td></tr>
		<tr class="listodd"><td>7</td><td align=center>���ύ����     </td><td align=left>֧����Ϣ�Ѿ��������жˣ��������ڴ��������</td></tr>
		<tr class="listodd"><td>8</td><td align=center>���д��          </td><td align=left>֧����Ϣ�����д���ʧ�ܣ�ֱ���˻ص�����</td></tr>
		<tr class="listodd"><td>9</td><td align=center>֧���ɹ�          </td><td align=left>�������ʱ����ʾ֧����Ϣ�����д���ɹ�<br>�������ʱ����ʾ֧������ȷ�ϳɹ�<br>������������ʱΪϵͳ�Զ������ɹ�</td></tr>
		<tr class="listodd"><td>a</td><td align=center>�����ո�������    </td><td align=left>��ʾ�������֧����Ϣ�ڻ����ո�ϵͳ�д�����</td></tr>
		<tr class="listodd"><td>b</td><td align=center>�����ո����ύ    </td><td align=left>��ʾ�������֧����Ϣ�ڻ����ո�ϵͳ���Ѵ�������δ�ύ֧������ȷ��</td></tr>
		<tr class="listodd"><td>c</td><td align=center>�����ո��˻�      </td><td align=left>��ʾ�������֧����Ϣ�ɻ����ո����˻�</td></tr>
		<tr class="listodd"><td>m</td><td align=center>Ĭ��֧���ɹ�      </td><td align=left>��ʾ����15��δ��ȷ״̬</td></tr>
		<tr class="listodd"><td>n</td><td align=center>�����˻�֧������      </td><td align=left>��ʾ���д��ʧ�ܣ����˻���֧�����ĵȴ�����</td></tr>
		<tr class="listodd"><td>10</td><td align=center>ͬ���ʽ�ɹ� </td><td align=left>֧����Ϣͬ���ʽ�ƽ̨�ɹ�</td></tr>
		<tr class="listodd"><td>11</td><td align=center>�ظ�����</td><td align=left>�����ظ�</td></tr>
		<tr class="listodd"><td>12</td><td align=center>ͬ���ʽ�ʧ��</td><td align=left>֧����Ϣͬ���ʽ�ƽ̨ʧ��</td></tr>
		<tr class="listodd"><td>13</td><td align=center>�ʽ�֧���ɹ�</td><td align=left>֧����Ϣ���ʽ�ƽ̨֧���ɹ�</td></tr>
		<tr class="listodd"><td>14</td><td align=center>�ʽ�֧����Ʊ </td><td align=left>֧����Ϣ���ʽ�ƽ̨֧������Ʊ</td></tr>
		<tr class="listodd"><td>15</td><td align=center>�ʽ��˻� </td><td align=left>֧����Ϣͬ���ʽ�ƽ̨��δ֧��ǰ�˻�</td></tr> 

  </table>
    </div>
    </td></tr></table>

    </form> 
    
  </body>
</html>