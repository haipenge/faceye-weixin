package com.faceye.component.weixin.service.qrcode.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.faceye.component.weixin.service.qrcode.QRCodeService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

@Service
public class QRCodeServiceImpl implements QRCodeService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;
	private static final String format = "jpg";

	@Override
	public void write2Stream(String source, int width, int height, OutputStream outputStream) {
		// 二维码的图片格式
		BufferedImage image = this.toBufferedImage(source, width, height);
		try {
			if (!ImageIO.write(image, format, outputStream)) {
				logger.error(">>FaceYe --> Write 2 strea fail,format is:" + format);
			}
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
	}

	@Override
	public BufferedImage toBufferedImage(String source, int width, int height) {
		BufferedImage image = null;
		Hashtable hints = new Hashtable();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(source, BarcodeFormat.QR_CODE, width, height, hints);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) ? BLACK : WHITE);
				}
			}
		} catch (WriterException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		return image;
	}

	@Override
	public boolean write2File(String source, int width, int height, String filename) {
		boolean res = false;
		BufferedImage image = this.toBufferedImage(source, width, height);
		try {
			//@TODO '生成二维码图片地址，基于property配置。'
			if (ImageIO.write(image, format, new File(filename))) {
				res = true;
			}
		} catch (IOException e) {
			logger.error(">>FaceYe throws Exception: --->", e);
		}
		return res;
	}
}
