package com.isa.jjdzr.data;

import com.isa.jjdzr.data.model.DataBean;
import java.util.List;

public interface DataProvider {
    List<DataBean> getData();
    List<String> getPlaces();
    List<DataBean> getIdRange(int[] range);
}
