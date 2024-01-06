package br.com.onsys.util;


import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ManterEmpresaClassUtil <T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static String getCanonicalNamePorTipoGenericsSadc(Class <?> clazz) throws Exception{
		try {
					
			Type tipo = clazz.getGenericSuperclass();
		 	
			if(tipo instanceof ParameterizedType) {
				ParameterizedType ptT = (ParameterizedType) clazz.getGenericSuperclass();
				Type[] type = ptT.getActualTypeArguments();
				return type[0].toString().replaceFirst("class ", "");
			} else {

				Type type = clazz.getGenericSuperclass();
				String classe = "";
				if(type.getTypeName().indexOf("Service") != -1) {
					classe = type.getTypeName().
							substring(type.getTypeName().lastIndexOf(".") + 1, type.getTypeName().indexOf("Service"));
				} else {
					classe = type.getTypeName().
							substring(type.getTypeName().lastIndexOf(".") + 1, type.getTypeName().indexOf("Negocio"));
				}

				return "br.com.bb.amb.models." + classe;
				
				//recursive = true
				/*
				List <File> files = (List<File>) FileUtils.listFiles(root, null, true);

				for (File file : files) {
					if (file.getName().equals(fileName)) {
						return file.getAbsolutePath().
								substring(file.getAbsolutePath().indexOf("br/"),file.getAbsolutePath().indexOf(".java") ).replace("/", ".");
					}
				}
				 */
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public static String getCanonicalNamePorTipoGenericsSadc(Class <?> clazz,String pacote) throws Exception{
		try {
					
			Type tipo = clazz.getGenericSuperclass();
		 	
			if(tipo instanceof ParameterizedType) {
				ParameterizedType ptT = (ParameterizedType) clazz.getGenericSuperclass();
				Type[] type = ptT.getActualTypeArguments();
				return type[0].toString().replaceFirst("class ", "");
			} else {

				Type type = clazz.getGenericSuperclass();
				String classe = "";
				if(type.getTypeName().indexOf("Model") != -1) {
					classe = type.getTypeName().
							substring(type.getTypeName().lastIndexOf(".") + 1, type.getTypeName().indexOf("Model"));
				}

				return pacote + "." + classe;
				
			}
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	
	public static String getCanonicalNamePorTipoGenerics(Class <?> clazz) throws Exception{
		try {
					
			Type tipo = clazz.getGenericSuperclass();
		 	
			if(tipo instanceof ParameterizedType) {
				ParameterizedType ptT = (ParameterizedType) clazz.getGenericSuperclass();
				Type[] type = ptT.getActualTypeArguments();
				return type[0].toString().replaceFirst("class ", "");
			} else {

				Type type = clazz.getGenericSuperclass();
				String classe = "";
				if(type.getTypeName().indexOf("Service") != -1) {
					classe = type.getTypeName().
							substring(type.getTypeName().lastIndexOf(".") + 1, type.getTypeName().indexOf("Service"));
				} else {
					classe = type.getTypeName().
							substring(type.getTypeName().lastIndexOf(".") + 1, type.getTypeName().indexOf("Negocio"));
				}

				String path = new File(".").getCanonicalPath().replace("target", "");
				File root = new File(path + "src");
				String fileName = classe+".java";

				//recursive = true
				List <File> files = (List<File>) FileUtils.listFiles(root, null, true);

				for (File file : files) {
					if (file.getName().equals(fileName)) {
						return file.getAbsolutePath().
								substring(file.getAbsolutePath().indexOf("br/"),file.getAbsolutePath().indexOf(".java") ).replace("/", ".");
					}
				}

			}
		} catch (Exception e) {
			throw e;
		}
		return null;
		
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getAnotacaoObjectClass(Class clazz) throws Exception{
		try {
		
			Annotation anota = clazz.getAnnotation(Class.forName("org.springframework.ldap.odm.annotations.Entry"));
			
			int indexInicio = anota.toString().indexOf("objectClasses=["); 
			int indexFim = anota.toString().lastIndexOf("])"); 
			
			return anota.toString().substring(indexInicio + 15, indexFim); 
		
		} catch (Exception e) {
			throw e;
		}
		
	}
	
}
