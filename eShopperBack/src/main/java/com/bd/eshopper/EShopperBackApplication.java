package com.bd.eshopper;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;



 /** 
 * 
 * @PropertySources(value ={
 * 
 * @PropertySource(value =
 * "classpath:application.properties",ignoreResourceNotFound = true),
 * 
 * @PropertySource(value =
 * "file:d:/application2.properties",ignoreResourceNotFound = true),
 * 
 * @PropertySource(value ={"file:${application1.properties"},
 * ignoreResourceNotFound = true) //@PropertySource(value
 * ="file:java:comp/env/configLocation", ignoreResourceNotFound = true),
 * //@PropertySource(value ="java:comp/env/configLocation",
 * ignoreResourceNotFound = true), })
 */
@SpringBootApplication
//@Configuration
//@PropertySources(value ={
//		@PropertySource( value ="classpath:application.properties",ignoreResourceNotFound = true),
//		@PropertySource( value ="file:${application.properties}",ignoreResourceNotFound = true)
//})
public class EShopperBackApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(EShopperBackApplication.class);

	static String springCfgLocation = null;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// This code is just an example to ilustrate the need of custom code.
		// Here it should be added your own way to get the value of the
		// `spring.config.location` property from JNDI or from whatever source.
		Context ctx;
System.out.println("-----------------------------------------------------------------");
log.info("----------------------------configure-------------------------------------");
		try {
			ctx = new InitialContext();
			springCfgLocation = (String) ctx.lookup("java:comp/env/APP_PROPERTIES");
			log.info("eShopper message [properties] = " + springCfgLocation);
			System.out.println("eShopper message [properties] = " + springCfgLocation);
		} catch (NamingException e) {
			System.out.println("eShopper message : " + e.getMessage());
			log.info("eShopper message : " + e.getMessage());
		}

		// Then add the property and the value of the `spring.config.location`
		// if(springCfgLocation != null) {
		//
		// //Affiche contenu application.properties
		// try {
		// FileInputStream fileInputStream = new
		// FileInputStream(springCfgLocation);
		// System.out.println("eShopper message [properties names] = " );
		// int content;
		// while ((content = fileInputStream.read()) != -1) {
		// // convert to char and display it
		// System.out.print((char) content);
		// }
		//
		// fileInputStream.close();
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }
		// application.properties(getProperties());

		return application;
	}

	Properties getProperties() {
		Properties props = new Properties();
		if (springCfgLocation != null)
			props.put("spring.config.location", springCfgLocation);	
		else
			log.info(EShopperBackApplication.class.getName() + " springCfgLocation null !");
		return props;
	}

	public static void main(String[] args) {
		log.info("Demarrage de l'appilcation ");
		EShopperBackApplication app = new EShopperBackApplication();

		SpringApplicationBuilder builder = new SpringApplicationBuilder();
		builder = app.configure(builder).sources(app.getClass()).properties(app.getProperties());
		builder.run(args);

		// SpringApplication app = new
		// SpringApplication(EShopperBackApplication.class);
		// app.setBannerMode(Mode.OFF);
		// app.run(args);
		// SpringApplication.run(EShopperBackApplication.class, args);

	}
	
	/**
	 * pour le fichier de application.properties il faut le configuré dans le le serveur 
	 * exemple :
	 * metre de fichier application.properties dans le /conf de tomcat
	 * dans le fichier context.xml de tomcat ajouter le jndi suivant ;
	 * <Environment name="APP_PROPERTIES" 
        description="The eShopper APP Properties File" override="false" 
        type="java.lang.String" 
        value="../conf/eShopperConf/application.properties" />
	 */
	
	/**
	 *  dans le fichier /conf/catalina.properties il faut ajouter "${catalina.home}/conf"  common.loader : 
	 *  common.loader="${catalina.base}/lib","${catalina.base}/lib/*.jar","${catalina.home}/lib","${catalina.home}/lib/*.jar","${catalina.home}/conf"
	 * cette commande permet de scanner le dossier conf et informer son contenu à l'application 
	 * */

}
