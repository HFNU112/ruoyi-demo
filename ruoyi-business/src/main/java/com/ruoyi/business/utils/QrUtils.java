package com.ruoyi.business.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Qr quick response 二维码生成工具类
 * @Author Husp
 * @Date 2023/10/30 9:59
 */
public class QrUtils {

    /**
     * 二维码写入指定路径
     * @param weight 二维码图片宽度 单位：px
     * @param height 二维码图片高度 单位：px
     * @param margin 二维码图片边距 单位：px
     * @param content 二维码图片信息 单位：String
     * @param imageFile 图片路径
     */
    public static void writeToPath(int weight, int height, int margin, String content, String imageFile){
        try {
            BitMatrix bitMatrix = buildBitMatrix(weight, height, margin, content);
            Path path = FileSystems.getDefault().getPath(imageFile);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 二维码写入输出流
     * @param weight 二维码图片宽度 单位：px
     * @param height 二维码图片高度 单位：px
     * @param margin 二维码图片边距 单位：px
     * @param content 二维码图片信息 单位：String
     * @param outputStream 图片输出流
     */
    public static void writeToStream(int weight, int height, int margin, String content, OutputStream outputStream){
        try {
            BitMatrix bitMatrix = buildBitMatrix(weight, height, margin, content);
            MatrixToImageWriter.writeToStream(bitMatrix, "png",outputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 构造位矩阵
     * @param weight 二维码图片宽度 单位：px
     * @param height 二维码图片高度 单位：px
     * @param margin 二维码图片边距 单位：px
     * @param content 二维码图片信息 单位：String
     * @return 位矩阵
     */
    private static BitMatrix buildBitMatrix(int weight, int height, int margin, String content) throws WriterException {
        Map<EncodeHintType, Object> encodeHint = new HashMap<>();
        // 编码
        encodeHint.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());
        // 空白区域
        encodeHint.put(EncodeHintType.MARGIN, margin);
        // 纠错级别
        encodeHint.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        // 多种条形码格式
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, weight, height, encodeHint);
        return bitMatrix;
    }

}
