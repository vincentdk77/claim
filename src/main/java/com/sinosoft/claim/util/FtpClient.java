package com.sinosoft.claim.util;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * FTPClient��
 */
public class FtpClient {
    public static final int DELETE_SUCCESS = 250;

    public static final int CREATE_SUCCESS = 257;

    public static final int ASCII_MODE = 0;

    public static final int BIN_MODE = 1;

    private int mode = ASCII_MODE;

    private sun.net.ftp.FtpClient ftpClient; //�ڲ�ʵ�����õ�FTPClient

    private int bufferSize = 2048;

    /**
     * ����һ��Ĭ�ϵ�FTPClient
     */
    public FtpClient() {
        ftpClient = new sun.net.ftp.FtpClient();
    }

    /**
     * ��FTP����
     * 
     * @param site վ��
     * @throws IOException
     */
    public void open(String site) throws IOException {
        ftpClient.openServer(site);
    }

    /**
     * ��FTP����
     * 
     * @param site վ��
     * @param port �˿ں�
     * @throws IOException
     */
    public void open(String site, int port) throws IOException {
        ftpClient.openServer(site, port);
    }

    /**
     * ��½
     * 
     * @param user �û���
     * @param password ����
     * @throws IOException
     */
    public void login(String user, String password) throws IOException {
        ftpClient.login(user, password);
    }

    /**
     * ���ô���ģʽ
     * 
     * @param mode ASCII_MODE��BIN_MODE
     * @throws IOException
     */
    public void setMode(int mode) throws IOException {
        switch (mode) {
            case ASCII_MODE:
                ftpClient.ascii();
                break;
            case BIN_MODE:
                ftpClient.binary();
                break;
            default:
                throw new IllegalArgumentException("mode must be ASCII_MODE or BIN_MODE!");
        }
        this.mode = mode;
    }

    /**
     * ���ش���ģʽ
     * 
     * @return ASCII_MODE��BIN_MODE
     */
    public int getMode() {
        return mode;
    }

    /**
     * �ϴ������ļ�
     * 
     * @param localFileName �����ļ���
     * @param remoteFileName �������ļ���
     * @throws Exception
     */
    public void put(String localFileName, String remoteFileName) throws Exception {
        OutputStream out = null;
        BufferedInputStream in = null;
        try {
            out = ftpClient.put(remoteFileName);
            in = new BufferedInputStream(new FileInputStream(localFileName));
            byte[] buff = new byte[bufferSize];
            int nch;
            while ((nch = in.read(buff, 0, buff.length)) != -1) {
                out.write(buff, 0, nch);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * ���ص����ļ�
     * 
     * @param remoteFileName �������ļ���
     * @param localFileName �����ļ���
     * @throws Exception
     */
    public void get(String remoteFileName, String localFileName) throws Exception {
        OutputStream out = null;
        InputStream in = null;
        try {
            in = ftpClient.get(remoteFileName);
            out = new BufferedOutputStream(new FileOutputStream(localFileName));
            byte[] buff = new byte[bufferSize];
            int nch;
            while ((nch = in.read(buff, 0, buff.length)) != -1) {
                out.write(buff, 0, nch);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * �ϴ�����ļ�
     * 
     * @param localFileNames �����ļ���
     * @param remoteFileNames �������ļ���
     * @throws Exception
     */
    public void mput(String[] localFileNames, String[] remoteFileNames) throws Exception {
        for (int i = 0; i < localFileNames.length; i++) {
            if (remoteFileNames.length < i || remoteFileNames[i] == null || remoteFileNames[i].trim().equals("")) {//û������ʱ�ñ����ļ���������
                put(localFileNames[i], localFileNames[i]);
            } else {
                put(localFileNames[i], remoteFileNames[i]);
            }
        }
    }

    /**
     * ���ض���ļ�
     * 
     * @param remoteFileNames �������ļ���
     * @param localFileNames �����ļ���
     * @throws Exception
     */
    public void mget(String[] remoteFileNames, String[] localFileNames) throws Exception {
        for (int i = 0; i < remoteFileNames.length; i++) {
            if (localFileNames.length < i || localFileNames[i] == null || localFileNames[i].trim().equals("")) {//û������ʱ�÷��������ļ���������
                put(remoteFileNames[i], remoteFileNames[i]);
            } else {
                put(remoteFileNames[i], localFileNames[i]);
            }
        }
    }

    /**
     * ���ص�ǰĿ¼
     * 
     * @return ��ǰĿ¼
     * @throws IOException
     */
    public String pwd() throws IOException {
        return ftpClient.pwd();
    }

    /**
     * ����Ŀ¼
     * 
     * @param dir Ŀ¼��
     * @throws IOException
     */
    public void cd(String dir) throws IOException {
        ftpClient.cd(dir);
    }

    /**
     * �������Ŀ¼
     * 
     * @param dir ���Ŀ¼��
     * @throws IOException
     */
    public void mkdirs(String dir) throws IOException {
        String pwd = pwd();
        dir = StringUtils.replace(dir, "\\", "/");
        String[] dirs = StringUtils.split(dir, "/");
        for (int i = 0; i < dirs.length; i++) {
            String theDir = dirs[i];
            if (theDir.equals("")) {
                cd("/");
                continue;
            }
            mkdir(theDir);
            cd(theDir);
        }
        cd(pwd);
    }

    /**
     * ��������Ŀ¼
     * 
     * @param dir ����Ŀ¼��
     * @return int ����״̬ �ɹ�����CREATE_SUCCESS����������
     * @throws IOException
     */
    public int mkdir(String dir) throws IOException {
        ftpClient.sendServer("MKD " + dir + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * ɾ���ļ�
     * 
     * @param file �ļ���
     * @return int ����״̬ ɾ���ɹ�����DELETE_SUCCESS����������
     * @throws IOException
     */
    public int rm(String file) throws IOException {
        ftpClient.sendServer("DELE " + file + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * ɾ����Ŀ¼
     * 
     * @param dir Ŀ¼��
     * @return int ����״̬ ɾ���ɹ�����DELETE_SUCCESS����������
     * @throws IOException
     */
    public int rmdir(String dir) throws IOException {
        ftpClient.sendServer("RMD " + dir + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * �ر�FTP����
     * 
     * @throws IOException
     */
    public void close() throws IOException {
        ftpClient.closeServer();
    }

    /**
     * ��ȡ��������С
     * 
     * @return ��������С�����ֽ�Ϊ��λ
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * ���û�������С
     * 
     * @param bufferSize ��������С�����ֽ�Ϊ��λ
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    /**
     * ��ָ��
     * 
     * @throws IOException
     */
    public void noop() throws IOException {
        ftpClient.noop();
    }

    /**
     * �õ�Ŀ¼�µ��ļ����б�
     * 
     * @param remoteDir ������Ŀ¼��
     * @return ������Ŀ¼�µ��ļ����б�(������Ŀ¼����
     * @throws IOException
     */
    public String[] getNameList(String remoteDir) throws IOException {
        BufferedReader dr;
        try {
            dr = new BufferedReader(new InputStreamReader(ftpClient.nameList(remoteDir + "\r")));
        } catch (IOException e) {
            return new String[0];
        }
        ArrayList allFiles = new ArrayList();
        String s = "";
        while ((s = dr.readLine()) != null) {
            if(s.endsWith("�޴��ļ���Ŀ¼")){
                continue;
            }
            allFiles.add(s);
        }
        String[] names = new String[allFiles.size()];
        allFiles.toArray(names);
        return names;
    }
    /**
     * ����ļ�FTPԶ���ļ��������
     * @param filePath
     * @return
     * @throws Exception
     */
    public OutputStream getFileInputStream(String filePath)throws Exception{
    	
    	return ftpClient.put(filePath);
    }
}
