package com.faceye.component.weixin.service.qrcode;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * 二维码生成
 * @author @haipenge 
 * @联系:haipenge@gmail.com
 * 创建时间:2015年7月7日
 */
public interface QRCodeService {

	/**
	 * 输出到流
	 * @todo
	 * @param source
	 * @param width
	 * @param height
	 * @param outputStream
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public void write2Stream(String source,int width,int height,OutputStream outputStream);
	
	/**
	 * 输出 buffered image
	 * @todo
	 * @param source
	 * @param width
	 * @param height
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public BufferedImage toBufferedImage(String source,int width,int height);
	
	/**
	 * 输出到文件
	 * @todo
	 * @param source
	 * @param width
	 * @param height
	 * @param filename
	 * @return
	 * @author:@haipenge
	 * 联系:haipenge@gmail.com
	 * 创建时间:2015年7月7日
	 */
	public boolean write2File(String source,int width,int height,String filename);
}
