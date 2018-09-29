package com.ovation.macro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lina.tools.CuteTools;

/**
 * 画面宏比对小工具
 * @author gulina
 *
 */
public class DiagramMacros {
	
	public static void main(String[] args){
		DiagramMacros diagramMacros = new DiagramMacros();
//		String path = diagramMacros.pathName("E:\\国核自仪\\宏\\画面宏\\宏库\\宏");
		String path = "E:\\国核自仪\\宏\\画面宏\\宏库\\宏";
//		List<File> fileList = diagramMacros.traverseFolder(path);
//		CuteTools.out(diagramMacros.piPei(path));
		 String a = "abcdefg<img src=\"0001.jpg\"/>hijklmnopq";
	        String reg = "<img[^>]*>";
	        a = a.replaceAll(reg, "替换标签");
	        System.out.println(a);
		/*List<Object> list = diagramMacros.listMacro(path);
		for(Object o:list){
			CuteTools.out(o);
		}*/
//		CuteTools.out(list.toString());
//		CuteTools.out(fileList.toString());
//		CuteTools.out(fileList.size());
	}
	public String pathName(String path){
		return path.replaceAll("\\", "\\\\");
	}
	/**
	 * 遍历path路径下所有文件
	 * @param path 文件路径
	 */
//	public List<File> traverseFolder(String path){
	public List<File> traverseFolder(String path){
		File file = new File(path);
		List<File> fileList = new ArrayList<File>();
		if(!file.exists()){
			CuteTools.out("该文件路径不存在！");
		}else{
			File[] files = file.listFiles();//获取该路径下所有文件
			if(files == null || files.length == 0){
				CuteTools.out("该文件夹为空！");
			}else{
				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				for(File f:files){
					if(f.getName().startsWith("MACRO")
							&& f.getName().endsWith(".src")){
						fileList.add(f);
						try {
							InputStreamReader input = new FileReader(f);
							BufferedReader reader = new BufferedReader(input);
							Map<String,Object> map = new HashMap<String,Object>();
							String line = null;
							boolean flag = true;
							while(((line = reader.readLine())!=null)&&flag){
								//判断是否以4开始
								if(line.toUpperCase().contains("$D VARIABLES")){
									String key = f.getName().split(".")[0];
									StringBuilder builder = new StringBuilder();
									while(flag){
										line = reader.readLine();
										if(line.contains("\"$D")){
											builder.append(line+"\n");											
										}else{
											flag = false;
										}
									}
									if(builder != null){
										map.put(key, builder);
										list.add(map);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
 		}
		return fileList;
	}
	
	public List listMacro(String path){
		File file = new File(path);
		List<File> fileList = new ArrayList<File>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		if(!file.exists()){
			CuteTools.out("该文件路径不存在！");
		}else{
			File[] files = file.listFiles();//获取该路径下所有文件
			if(files == null || files.length == 0){
				CuteTools.out("该文件夹为空！");
			}else{
				for(File f:files){
					if(f.getName().startsWith("MACRO")
							&& f.getName().endsWith(".src")){
						fileList.add(f);
						try {
							InputStreamReader input = new FileReader(f);
							BufferedReader reader = new BufferedReader(input);
							Map<String,Object> map = new HashMap<String,Object>();
							String line = null;
							boolean flag = true;
							while(((line = reader.readLine())!=null)&&flag){
								//判断是否以4开始
								if(line.toUpperCase().contains("$D VARIABLES")){
									String key = f.getName().split("\\.")[0];
//									String key = f.getName();
									StringBuilder builder = new StringBuilder();
									while(flag){
										line = reader.readLine();
										if(line.contains("\"$D")){
											builder.append(line+"\n");											
										}else{
											flag = false;
										}
									}
									if(builder != null){
										map.put(key, builder);
										list.add(map);
									}
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
 		}
		return list;
	}
	/**
	 * 正则匹配，将“$D……”前后的空格舍去，只保留中间的内容
	 * @param s
	 * @return
	 */
	public String piPei(String s){
		Pattern pattern = Pattern.compile("^\"$\"");
		Matcher matcher = pattern.matcher(s);
		
		return matcher.toString();
	}
}
