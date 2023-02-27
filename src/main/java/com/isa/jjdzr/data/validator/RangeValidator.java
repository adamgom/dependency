package com.isa.jjdzr.data.validator;

import com.isa.jjdzr.data.model.DataBean;
import java.util.List;

public interface RangeValidator {
    List<String> validateRange(int[] range);
    void setMaxId(List<DataBean> dataBeans);
}
