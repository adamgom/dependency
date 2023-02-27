package com.isa.jjdzr.service;

import com.isa.jjdzr.data.Data;
import com.isa.jjdzr.data.model.DataBean;
import com.isa.jjdzr.interfaces.AdvancedFiltering;
import com.isa.jjdzr.interfaces.Filtering;
import java.util.List;

public class DataFilteringService implements DataFiltering {

    private Data data;

    public DataFilteringService() {
        data = new Data();
    }

    @Override
    public List<DataBean> getAllDataBeans() {
        return data.getData();

    }

    @Override
    public List<DataBean> getDataBeans(Filtering filtering) {
        return data.getIdRange(filtering.getByIdRange());
    }

    @Override
    public List<DataBean> getDataBeans(AdvancedFiltering advancedFiltering) {
        return data
                .getIdRange(advancedFiltering.getByIdRange())
                .stream()
                .filter(advancedFiltering.getByName())
                .filter(advancedFiltering.getByPlace())
                .filter(advancedFiltering.getActive())
                .toList();
    }

    @Override
    public List<String> getAllPlaces() {
        return data.getPlaces();
    }
}
