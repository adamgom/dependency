package com.isa.jjdzr.service;

import com.isa.jjdzr.data.model.DataBean;
import com.isa.jjdzr.interfaces.AdvancedFiltering;
import com.isa.jjdzr.interfaces.Filtering;
import java.util.List;

/**
 * General service to gat data from dummy database
 * @author  Adam Gomowski
 */

public interface DataFiltering {

    /**
     * Get all DataBean list stored in database
     *
     * @return DataBean list
     */
    List<DataBean> getAllDataBeans();

    /**
     * Get all places list used in database for beans
     *
     * @return list of places
     */
    List<String> getAllPlaces();

    /**
     * Get DataBean list stored in database filtered by id range
     *
     * @param filtering provides simple filter predicate related to range.
     *                  To be implemented by user
     * @return List of DataDean, depends on predicate list may be empty
     * @throws IllegalArgumentException if input range data is improper
     */
    List<DataBean> getDataBeans(Filtering filtering);

    /**
     * Get DataBean list stored in database filtered by id range
     *
     * @param advancedFiltering provides advanced filter predicate related to range
     *                          plus name, place and active properties. To be implemented
     *                          by user
     * @return List of DataDean, depends on predicates list may be empty
     * @throws IllegalArgumentException if input range data is improper
     */
    List<DataBean> getDataBeans(AdvancedFiltering advancedFiltering);

}
