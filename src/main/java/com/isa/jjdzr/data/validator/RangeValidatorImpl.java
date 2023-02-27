package com.isa.jjdzr.data.validator;

import com.isa.jjdzr.data.model.DataBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class RangeValidatorImpl implements RangeValidator {

    private int maxId;

    public RangeValidatorImpl() {
        this.maxId = 0;
    }

    @Override
    public List<String> validateRange(int[] range) {
        // jeżeli tablica zawiera inną ilość danych niż 2, to zwracamy błąd od razu, dalsza walidacja nie ma sensu
        if (range.length != 2) {
            return List.of("Improper range input '" + Arrays.toString(range) + "'. Provide exactly two parameters");
        }

        List<String> errors = new ArrayList<>();

        // sprawdzenie pierwszego błędu, jeżeli wystąpił dodajemy informację do listy błędów
        if (range[0] < 1) {
            errors.add("'From' value must be 1 or higher");
        }

        // sprawdzenie drugiego błędu, jeżeli wystąpił dodajemy informację do listy błędów
        if (range[0] > range[1]) {
            errors.add("'To' value must be higher than 'From' value");
        }

        // jeżeli nie ustaliliśmy maxId, to zwracamy listę błędów
        if (maxId < 1) {
            return errors;
        }

        // jeżeli ustaliliśmy maxId, to sprawdzamy trzeci błąd, jeżeli wystąpił dodajemy informację do listy błędów
        if (range[1] > maxId) {
            errors.add("'To' value must be lower than max id '" + maxId + "' present in data");
        }

        return errors;
    }

    @Override
    public void setMaxId(List<DataBean> dataBeans) {
        Optional<DataBean> maxIdBean = dataBeans.stream().max(new CompareIds());
        this.maxId = maxIdBean.orElseThrow().getId();
    }

    static class CompareIds implements Comparator<DataBean> {

        @Override
        public int compare(DataBean o1, DataBean o2) {
            int id1 = o1.getId();
            int id2 = o2.getId();

            return Integer.compare(id1, id2);
        }
    }
}