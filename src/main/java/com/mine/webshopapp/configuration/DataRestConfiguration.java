package com.mine.webshopapp.configuration;

import com.mine.webshopapp.entity.ProductCategoryEntity;
import com.mine.webshopapp.entity.ProductEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {

    //Class to make app READ-only
    //we just excluding some request types


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] excludedRequests = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};

        config.getExposureConfiguration()
                .forDomainType(ProductEntity.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests));

        config.getExposureConfiguration()
                .forDomainType(ProductCategoryEntity.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(excludedRequests));

    }
}
