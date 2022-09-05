package com.mac.practice.util.factory.convertors;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class YesNoConvector implements AttributeConverter<Boolean, String> {

    private enum YesNoType {

        YES("Y", true),
        NO("N", false);

        private final String dbValue;
        private final boolean entityValue;

        YesNoType(String dbValue, boolean entityValue) {
            this.dbValue = dbValue;
            this.entityValue = entityValue;
        }

        private static YesNoType getByDbValue(String dbValue) {
            if (StringUtils.isEmpty(dbValue)) {

                return NO;
            }

            for (YesNoType type : values()) {

                if (Objects.equals(type.dbValue, dbValue)) {
                    return type;
                }
            }
            return NO;
        }

        private static YesNoType getByEntityValue(Boolean value){
            if (Objects.isNull(value)) {
                return NO;
            }
            for(YesNoType type : values()){
                if(Objects.equals(type.entityValue,value)){
                    return type;
                }
            }
            return NO;
        }
    }

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return YesNoType.getByEntityValue(aBoolean).dbValue;
    }

    @Override
    public Boolean convertToEntityAttribute(String dbValue) {
        return YesNoType.getByDbValue(dbValue).entityValue;
    }
}
