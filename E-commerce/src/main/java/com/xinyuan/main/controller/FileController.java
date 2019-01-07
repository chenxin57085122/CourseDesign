package com.xinyuan.main.controller;

import com.xinyuan.main.utils.FastDFSUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: chenxin
 * @Date: 2019/1/7 12:39
 * @Description:
 */
@RestController
@RequestMapping("/file")
public class FileController {

    /**
     *
     * 功能描述: 上传文件，
     *
     * @param:
     * @return: 文件访问地址
     * @auther: chenxin
     * @date: 2019/1/7 12:42
     */

    @PostMapping("/upload")
    public String upload(@RequestBody MultipartFile multipartFile){
        return FastDFSUtil.uploadFile(multipartFile);
    }
}
