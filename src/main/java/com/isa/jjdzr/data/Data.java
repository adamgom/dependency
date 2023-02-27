package com.isa.jjdzr.data;

import com.isa.jjdzr.data.model.DataBean;
import com.isa.jjdzr.data.validator.RangeValidator;
import com.isa.jjdzr.data.validator.RangeValidatorImpl;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Data implements DataProvider {

    private static final String PLACE_1 = "Crimson Peak";
    private static final String PLACE_2 = "White Castle";
    private static final String PLACE_3 = "Northern Swamps";
    private static final String PLACE_4 = "Eastern Deserts";
    private static final String PLACE_5 = "Bottomless Abyss";
    List<DataBean> dataValues;

    RangeValidator rangeValidator;

    public Data(RangeValidator rangeValidator) {
        dataValues = List.of(
                new DataBean(1, "Kracossell", PLACE_1, true),
                new DataBean(2, "Gargantrtiz", PLACE_1, false),
                new DataBean(3, "Torgruela", PLACE_2, false),
                new DataBean(4, "Gogmaelliott", PLACE_3, true),
                new DataBean(5, "Mcdoth", PLACE_2, true),
                new DataBean(6, "Ricella Rosenedwards", PLACE_4, true),
                new DataBean(7, "Poweslight", PLACE_3, false),
                new DataBean(8, "Thomaya", PLACE_5, true),
                new DataBean(9, "Grrlexander", PLACE_1, false),
                new DataBean(10, "Brownthumpa", PLACE_4, false),
                new DataBean(11, "Lawsonano", PLACE_5, true),
                new DataBean(12, "Horsesimpson", PLACE_3, true),
                new DataBean(13, "Silverhun", PLACE_5, false),
                new DataBean(14, "Cookbell", PLACE_2, false),
                new DataBean(15, "Rowizz Bagwood", PLACE_4, true),
                new DataBean(16, "Wilsoniel", PLACE_1, true),
                new DataBean(17, "Harrithumper", PLACE_3, false),
                new DataBean(18, "Dracthomas Fergusondall", PLACE_4, false),
                new DataBean(19, "Torresiel", PLACE_5, false),
                new DataBean(20, "Rainturner", PLACE_2, true));

        this.rangeValidator = rangeValidator;
    }

    public Data() {
        this(new RangeValidatorImpl());
    }

    public List<DataBean> getData() {
        return dataValues;
    }

    public List<String> getPlaces() {
        return List.of(PLACE_1, PLACE_2, PLACE_3, PLACE_4, PLACE_5);
    }

    public List<DataBean> getIdRange(int[] range) {
        validateRange(range);

        Predicate<DataBean> filterPredicateParameter =
                dataBean -> dataBean.getId() >= range[0] && dataBean.getId() <= range[1];

        return dataValues.stream()
                .filter(filterPredicateParameter)
                .collect(Collectors.toList());
    }

    private void validateRange(int[] range) {
        // ustalamy maksymalną wartość id w danych
        rangeValidator.setMaxId(dataValues);

        // walidujemy dane wejściowe dot. przedziału id
        List<String> errors = rangeValidator.validateRange(range);

        // jeżeli są jakieś błędy to zbieramy je w całość, wyrzucamy wyjątek z odpowiednią informacją i kończymy program
        if (!errors.isEmpty()) {
            String errorList = String.join(", ", errors);
            throw new IllegalArgumentException("Data input error. Errors found: " + errorList);
        }
    }
}
