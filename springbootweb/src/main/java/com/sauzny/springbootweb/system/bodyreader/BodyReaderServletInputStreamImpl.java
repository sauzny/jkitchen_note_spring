package com.sauzny.springbootweb.system.bodyreader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class BodyReaderServletInputStreamImpl extends ServletInputStream{

	private final ByteArrayInputStream byteArrayInputStream;
	
	public BodyReaderServletInputStreamImpl(ByteArrayInputStream byteArrayInputStream) {
		this.byteArrayInputStream = byteArrayInputStream;
	}
	
	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setReadListener(ReadListener readListener) {
	}

	@Override
	public int read() throws IOException {
		return byteArrayInputStream.read();
	}

}
