package com.demo.web;

import com.demo.utils.AliyunOSSUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        // 获取上传文件的名称
        System.out.println(multipartFile.getOriginalFilename());
        // 获取上传文件类型
        System.out.println(multipartFile.getContentType());
        // 上传表单中的name属性
        System.out.println(multipartFile.getName());
        // 获取上传文件的大小
        System.out.println(multipartFile.getSize());
        String filename = multipartFile.getOriginalFilename();
        // 使用 JDK 提供的 UUID 类，获取随机数串
        UUID uuid = UUID.randomUUID();
        // 获取原文件的扩展名 如：.mp4  .mp3  .jpg
        String ext = filename.substring(filename.lastIndexOf("."));
        // 9d67ec15-8e44-4cf8-8e94-ab6d0ffd7d53.mp3
        filename = uuid + ext;
        // 将文件保存到某个位置
        multipartFile.transferTo(new File("e:/" + multipartFile.getOriginalFilename()));
        return AliyunOSSUtils.uploadFile(multipartFile.getInputStream(), filename);
    }
}
/*
    雪花算法（Snowflake）是一种由Twitter开源的分布式唯一ID生成算法，
    它为分布式系统提供了一种生成全局唯一且有序递增ID的解决方案。
    雪花算法生成的ID是一个64位的整数，通过其结构可以确保在分布式环境中生成的ID既唯一又有序。

    1 -                    41                         -  5      5   -      12
    0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 00000 - 000000000000
    ● 符号位：1位，固定为 0，因为ID一般为正数。
    ● 时间戳：41位，表示自某个固定时间点（即“纪元”时间）以来的毫秒数。这个时间戳保证了ID的时间有序性和唯一性，
        因为随着时间的推移，时间戳会不断增加，从而确保每个ID都是唯一的。时间戳部分还允许算法支持长达数十年的唯一性。
    ● 数据中心ID：5位，用于区分不同的数据中心。根据数据中心的地理位置、业务需求等因素来分配数据中心ID，并确保每个数据中心的ID都是唯一的。
    ● 机器ID：5位，用于区分同一数据中心内的不同机器或进程。使得在同一台机器上运行的不同应用程序实例可以使用不同的工作机器ID来生成唯一的ID。
    ● 序列号：12位，用于在同一毫秒内生成多个唯一ID。这部分可以支持每个节点每毫秒产生4096个唯一的ID，解决了在同一毫秒内需要生成多个ID时的冲突问题。

*/