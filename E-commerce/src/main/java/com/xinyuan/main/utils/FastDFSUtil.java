package com.xinyuan.main.utils;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: chenxin
 * @Date: 2019/1/1 12:30
 * @Description:
 */
public class FastDFSUtil {

    public static final String URL = "39.108.191.78";
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient storageClient;

    static {
        try {
            ClientGlobal.initByProperties("fdfs.properties");
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            storageClient = new StorageClient(trackerServer,null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     * @param file
     * @return 文件保存路径
     */
    public static String uploadFile(MultipartFile file){
        String[] str = null;
        String path = "";
        try {

            //mata list是表文件的描述
            NameValuePair[] mata_list = new NameValuePair[3];
            mata_list[0] = new NameValuePair("fileName",file.getName());
            mata_list[1] = new NameValuePair("fileExt",file.getContentType());
            mata_list[2] = new NameValuePair("fileSize",String.valueOf(file.getSize()));
            str = storageClient.upload_file(file.getBytes(), file.getContentType(), mata_list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        path = stringAppend(str);
        return path;
    }

    private static String stringAppend(String[] str){

        String path = URL;
        for (String target : str){
            path = path +"/"+ target;
        }
        return path;
    }
}
