package com.sauzny.sbutilsdemo.resouce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class SpringLoadResource {

	// 获取各种文件
	
	@SuppressWarnings("unused")
	public void demo() throws IOException {
		
		// 文件地址
		UrlResource urlResource = new UrlResource("");
		// 文件地址
		ClassPathResource classPathResource = new ClassPathResource("");
		// 文件地址
		FileSystemResource fileSystemResource = new FileSystemResource("");
		
		Properties prop = PropertiesLoaderUtils.loadProperties(fileSystemResource);
		prop.load(fileSystemResource.getInputStream());
		String ip = prop.getProperty("redis.ip");
		
		// application + 文件路径
		// ServletContextResource servletContextResource = new ServletContextResource(application， "");
		
		// 
		InputStream is = new FileInputStream("");  
		InputStreamResource inputStreamResource = new InputStreamResource(is);
		
		// 
		//ByteArrayResource byteArrayResource = new ByteArrayResource();

		// resource + charset
		//EncodedResource encodedResource = new EncodedResource();
		
		// JBoss 使用
		// VfsResource vfsResource = new VfsResource("");
		
		// 支持“classpath:”和“file:”的地址前缀
		// 有 getURL, getFile, isFileURL, isJarURL, extractJarFileURL
		File f =  ResourceUtils.getFile("classpath:sqlscript/eventLogDataMigration.sql");
		
		
	}
}
