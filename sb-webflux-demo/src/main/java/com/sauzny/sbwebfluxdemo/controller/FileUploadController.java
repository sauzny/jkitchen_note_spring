package com.sauzny.sbwebfluxdemo.controller;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.sauzny.sbwebfluxdemo.entity.City;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class FileUploadController {

    @PostMapping(value="/form")
    public Mono<String> handleFormUpload(
    		@RequestPart String name,
    		@RequestPart City city,
    		@RequestPart FilePart filePart
    		) throws Exception {
    	//MyForm form = entity.getBody();
    	log.info("name：{}", name);
    	log.info("city：{}", city);
    	log.info("文件名字：{}", filePart.filename());
    	
    	Path tempFile = Files.createTempFile("test", filePart.filename());

        //NOTE 方法一
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    System.out.println("finish");
                })
            .subscribe();

    	
    	// 方法二、直接转换成文件
        // filePart.transferTo(new File("aaa"));
    	
    	return Mono.create(fileUploadSink -> fileUploadSink.success(filePart.filename()));
    }
}
