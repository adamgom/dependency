package com.isa.jjdzr.interfaces;

/**
 * Basic filtering interface related to id range
 * @author Adam Gomowski
 */

public interface Filtering {

    /**
     * provide proper filtering range. Range should be from 1 to max
     * id value in database. In case missing ids in database (gaps) and set
     * range within that gap filtering will not mach any data
     *
     * @throws IllegalArgumentException if input range data is improper
     */
    int[] getByIdRange();
}
