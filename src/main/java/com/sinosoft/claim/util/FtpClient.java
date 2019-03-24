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
 * FTPClient类
 */
public class FtpClient {
    public static final int DELETE_SUCCESS = 250;

    public static final int CREATE_SUCCESS = 257;

    public static final int ASCII_MODE = 0;

    public static final int BIN_MODE = 1;

    private int mode = ASCII_MODE;

    private sun.net.ftp.FtpClient ftpClient; //内部实现所用的FTPClient

    private int bufferSize = 2048;

    /**
     * 构建一个默认的FTPClient
     */
    public FtpClient() {
        ftpClient = new sun.net.ftp.FtpClient();
    }

    /**
     * 打开FTP连接
     * 
     * @param site 站点
     * @throws IOException
     */
    public void open(String site) throws IOException {
        ftpClient.openServer(site);
    }

    /**
     * 打开FTP连接
     * 
     * @param site 站点
     * @param port 端口号
     * @throws IOException
     */
    public void open(String site, int port) throws IOException {
        ftpClient.openServer(site, port);
    }

    /**
     * 登陆
     * 
     * @param user 用户名
     * @param password 密码
     * @throws IOException
     */
    public void login(String user, String password) throws IOException {
        ftpClient.login(user, password);
    }

    /**
     * 设置传输模式
     * 
     * @param mode ASCII_MODE或BIN_MODE
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
     * 返回传输模式
     * 
     * @return ASCII_MODE或BIN_MODE
     */
    public int getMode() {
        return mode;
    }

    /**
     * 上传单个文件
     * 
     * @param localFileName 本地文件名
     * @param remoteFileName 服务器文件名
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
     * 下载单个文件
     * 
     * @param remoteFileName 服务器文件名
     * @param localFileName 本地文件名
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
     * 上传多个文件
     * 
     * @param localFileNames 本地文件名
     * @param remoteFileNames 服务器文件名
     * @throws Exception
     */
    public void mput(String[] localFileNames, String[] remoteFileNames) throws Exception {
        for (int i = 0; i < localFileNames.length; i++) {
            if (remoteFileNames.length < i || remoteFileNames[i] == null || remoteFileNames[i].trim().equals("")) {//没有名字时用本地文件名的名字
                put(localFileNames[i], localFileNames[i]);
            } else {
                put(localFileNames[i], remoteFileNames[i]);
            }
        }
    }

    /**
     * 下载多个文件
     * 
     * @param remoteFileNames 服务器文件名
     * @param localFileNames 本地文件名
     * @throws Exception
     */
    public void mget(String[] remoteFileNames, String[] localFileNames) throws Exception {
        for (int i = 0; i < remoteFileNames.length; i++) {
            if (localFileNames.length < i || localFileNames[i] == null || localFileNames[i].trim().equals("")) {//没有名字时用服务器上文件名的名字
                put(remoteFileNames[i], remoteFileNames[i]);
            } else {
                put(remoteFileNames[i], localFileNames[i]);
            }
        }
    }

    /**
     * 返回当前目录
     * 
     * @return 当前目录
     * @throws IOException
     */
    public String pwd() throws IOException {
        return ftpClient.pwd();
    }

    /**
     * 进入目录
     * 
     * @param dir 目录名
     * @throws IOException
     */
    public void cd(String dir) throws IOException {
        ftpClient.cd(dir);
    }

    /**
     * 建立多层目录
     * 
     * @param dir 多层目录名
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
     * 建立单层目录
     * 
     * @param dir 单层目录名
     * @return int 返回状态 成功返回CREATE_SUCCESS，否则其他
     * @throws IOException
     */
    public int mkdir(String dir) throws IOException {
        ftpClient.sendServer("MKD " + dir + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * 删除文件
     * 
     * @param file 文件名
     * @return int 返回状态 删除成功返回DELETE_SUCCESS，否则其他
     * @throws IOException
     */
    public int rm(String file) throws IOException {
        ftpClient.sendServer("DELE " + file + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * 删除空目录
     * 
     * @param dir 目录名
     * @return int 返回状态 删除成功返回DELETE_SUCCESS，否则其他
     * @throws IOException
     */
    public int rmdir(String dir) throws IOException {
        ftpClient.sendServer("RMD " + dir + "\r\n");
        return ftpClient.readServerResponse();
    }

    /**
     * 关闭FTP连接
     * 
     * @throws IOException
     */
    public void close() throws IOException {
        ftpClient.closeServer();
    }

    /**
     * 获取缓冲区大小
     * 
     * @return 缓冲区大小，以字节为单位
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * 设置缓冲区大小
     * 
     * @param bufferSize 缓冲区大小，以字节为单位
     */
    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    /**
     * 空指令
     * 
     * @throws IOException
     */
    public void noop() throws IOException {
        ftpClient.noop();
    }

    /**
     * 得到目录下的文件名列表
     * 
     * @param remoteDir 服务器目录名
     * @return 服务器目录下的文件名列表(不包含目录名）
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
            if(s.endsWith("无此文件或目录")){
                continue;
            }
            allFiles.add(s);
        }
        String[] names = new String[allFiles.size()];
        allFiles.toArray(names);
        return names;
    }
    /**
     * 获得文件FTP远程文件的输出流
     * @param filePath
     * @return
     * @throws Exception
     */
    public OutputStream getFileInputStream(String filePath)throws Exception{
    	
    	return ftpClient.put(filePath);
    }
}
