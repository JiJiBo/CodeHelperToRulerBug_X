package com.rulerbug.firstlibrary.Utils;


import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;

public class ZxingUtils {
    public static Bitmap createQRCode(String content, int widthAndHeight) {
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();//定义二维码参数
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置字符
        hints.put(EncodeHintType.ERROR_CORRECTION, "Q"); // 容错级别设置 L,H,M,Q
        hints.put(EncodeHintType.MARGIN, "4"); // 空白边距设置
        try {
//    生成二维码
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, widthAndHeight, widthAndHeight, hints);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (matrix.get(x, y)) {
                        pixels[y * width + x] = Color.BLACK;
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

}