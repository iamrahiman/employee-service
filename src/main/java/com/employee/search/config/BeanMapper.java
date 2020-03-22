package com.employee.search.config;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import com.employee.search.dto.EmployeeDTO;
import com.employee.search.model.Employee;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class BeanMapper implements InitializingBean {
	


    /**
     * The mapper factory.
     */
    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    /**
     * The mapper facade.
     */
    private MapperFacade mapperFacade = mapperFactory.getMapperFacade();

    /**
     * Instantiates a new bean mapper.
     */
    public BeanMapper() {
        afterPropertiesSet();
    }

    @Override
    public void afterPropertiesSet() {

        mapperFactory.classMap(Employee.class, EmployeeDTO.class)
            .field("employeeID", "employeeID")
            .mapNulls(false).byDefault().register();

    }

    /**
     * Returns a new object of the given type with values mapped from source object.
     *
     * @param <S> the generic type
     * @param <D> the generic type
     * @param iSourceObject the source object
     * @param iDestinationClass the destination class
     * @return the d
     */
    public <S, D> D map(S iSourceObject, Class<D> iDestinationClass) {
        //Preconditions.checkNotNull(iSourceObject);
        return mapperFacade.map(iSourceObject, iDestinationClass);
    }


    /**
     * Returns a new list of objects of the given type with values mapped from source list.
     *
     * @param <S> the generic type
     * @param <D> the generic type
     * @param iSource the source
     * @param iDestinationClass the destination class
     * @return the list
     */
    public <S, D> List<D> mapAsList(List<S> iSource, Class<D> iDestinationClass) {
        List<D> response = Collections.emptyList();
        if (iSource != null && !iSource.isEmpty()) {
            response = mapperFacade.mapAsList(iSource, iDestinationClass);
        }
        return response;
    }



}
