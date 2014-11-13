/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zols.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.zols.datastore.DataStore;
import org.zols.datastore.mongo.MongoDataStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.zols.web.interceptor.PagePopulationInterceptor;

@Configuration
@ComponentScan("org.zols")
public class ZolsConfiguration extends WebMvcConfigurerAdapter{
    
    @Autowired
    private PagePopulationInterceptor pagePopulationInterceptor; 

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(pagePopulationInterceptor);
    }
    
    @Bean
    public DataStore dataStore() {
        return new MongoDataStore();
    }
}
