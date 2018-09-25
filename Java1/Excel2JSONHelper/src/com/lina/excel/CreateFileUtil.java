package com.lina.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CreateFileUtil {

    /**
     * ����.json��ʽ�ļ�
     */
    public static boolean createJsonFile(String jsonString, String filePath, String fileName) {
        // ����ļ������Ƿ�ɹ�
        boolean flag = true;

        // ƴ���ļ�����·��
        String fullPath = filePath + File.separator + fileName + ".json";

        // ����json��ʽ�ļ�
        try {
            // ��֤����һ�����ļ�
            File file = new File(fullPath);
            if (!file.getParentFile().exists()) { // �����Ŀ¼�����ڣ�������Ŀ¼
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // ����Ѵ���,ɾ�����ļ�
                file.delete();
            }
            file.createNewFile();

            // ��ʽ��json�ַ���
            jsonString = JsonFormatTool.formatJson(jsonString);

            // ����ʽ������ַ���д���ļ�
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }

        // �����Ƿ�ɹ��ı��
        return flag;
    }

}