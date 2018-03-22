package com.karson.school.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

 

@Configuration
public class SpringMongoConfig {  
		  
	    @Value("${spring.data.mongodb.host}")  
	    private String MONGO_IP;  
	    @Value("${spring.data.mongodb.port}")  
	    private int MONGO_PORT;  
	    @Value("${spring.data.mongodb.database}") 
	    private String DATABASENAME;
	    @Value("${spring.data.mongodb.username}") 
	    private String username;
	    @Value("${spring.data.mongodb.password}") 
	    private String password;
	 
	    @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        MappingMongoConverter mongoConverter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory()), new MongoMappingContext());
	        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null)); // typeKey 设置为 null。默认的无参构造为 _class
	        return new MongoTemplate(mongoDbFactory(), mongoConverter);
	    }
	    @Bean
	 
	    public MongoDbFactory mongoDbFactory() throws Exception {
	  	 
	    	      ServerAddress server = new ServerAddress(MONGO_IP, MONGO_PORT);
	    	      List<MongoCredential> credentials = new ArrayList<MongoCredential>();
	    		  MongoCredential mongoCredential = MongoCredential.createCredential(username, DATABASENAME, password.toCharArray());
	    		  credentials.add(mongoCredential);
	    		  MongoClient mongoClient =  new MongoClient(server,credentials);
	    		  return new SimpleMongoDbFactory(mongoClient,DATABASENAME);
	    	
	    	    
	    }
 
}