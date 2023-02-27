package com.isa.jjdzr.interfaces;

import com.isa.jjdzr.data.model.DataBean;
import java.util.function.Predicate;

/**
 * Advanced filtering interface related to id range. Extends basic
 * filtering interface
 *
 * @author Adam Gomowski
 */

public interface AdvancedFiltering extends Filtering{

    /**
     * provide predicate related to name, example:
     * return dataBean -> dataBean.getName().contains(nameToFound);
     */
    Predicate<DataBean> getByName();

    /**
     * provide predicate related to name, example:
     * return dataBean -> dataBean.getPlace().equals(placeToFound);
     */

    Predicate<DataBean> getByPlace();

    /**
     * provide predicate related to activity status, example:
     * return dataBean -> dataBean.isActive();
     */
    Predicate<DataBean> getActive();

}
