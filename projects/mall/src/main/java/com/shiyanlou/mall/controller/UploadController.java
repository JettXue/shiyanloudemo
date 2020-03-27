package com.shiyanlou.mall.controller;

import com.shiyanlou.mall.utils.Generations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Jettx
 * @date 3/23/2020 4:44 PM
 */
@Controller
public class UploadController {
    // 文件保存路径
    private final static String FILE_UPLOAD_PATH = "C:\\upload\\";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) return "上传失败";

        String suffixname = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("."));
        StringBuilder tmpname = Generations.generateFilename(suffixname);
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FILE_UPLOAD_PATH + tmpname);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败！";
        }
        return "上传成功，保存路径为: " + tmpname;
    }

    @GetMapping("upload")
    public String uploadHtml() {
        return "upload-test";
    }

    @RequestMapping("/downloadFile/{filepath}")
    private String downloadFile(HttpServletResponse response, @PathVariable("filepath") String filepath) {
        String downloadFilePath = "C:/upload/";//被下载的文件在服务器中的路径,
        String fileName = filepath;
        if(filepath.indexOf("/") != -1){
            downloadFilePath += filepath.substring(0, filepath.lastIndexOf("/"));
            fileName = filepath.substring(filepath.lastIndexOf("/"));//被下载文件的名称
        }

        File file = new File(downloadFilePath + fileName);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                return "下载成功";
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}
