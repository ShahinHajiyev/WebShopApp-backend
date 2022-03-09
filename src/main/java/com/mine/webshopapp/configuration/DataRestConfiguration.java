package com.mine.webshopapp.configuration;

import com.mine.webshopapp.entity.ProductCategoryEntity;
import com.mine.webshopapp.entity.ProductEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class DataRestConfiguration implements RepositoryRestConfigurer {

    //Class to make app READ-only
    //we just excluding some request types

    private EntityManager entityManager;

    @Autowired
    public DataRestConfiguration(EntityManager manager) {

        entityManager = manager;

    }

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


        //calling internal helper method

        config.exposeIdsFor(entityManager.getMetamodel()
                .getEntities().stream()
                .map(e -> e.getJavaType())
                .collect(Collectors.toList())
                .toArray(new Class[0]));
       //exposeId(config);
    }

/*    private void exposeId(RepositoryRestConfiguration config) {

        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntiityType : entities) {
            entityClasses.add(tempEntiityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }*/
}
