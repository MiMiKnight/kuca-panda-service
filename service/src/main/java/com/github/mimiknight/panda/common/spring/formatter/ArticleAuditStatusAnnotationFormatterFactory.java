package com.github.mimiknight.panda.common.spring.formatter;

import com.github.mimiknight.panda.common.annotation.ArticleAuditStatusFormat;
import com.github.mimiknight.panda.common.enumeration.ArticleAuditStatusEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Component
public class ArticleAuditStatusAnnotationFormatterFactory implements AnnotationFormatterFactory<ArticleAuditStatusFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        HashSet<Class<?>> fieldTypes = new HashSet<>();
        fieldTypes.add(ArticleAuditStatusEnum.class);
        return fieldTypes;
    }

    @Override
    public Printer<ArticleAuditStatusEnum> getPrinter(ArticleAuditStatusFormat annotation, Class<?> fieldType) {
        return configureFormatterFrom(annotation, fieldType);
    }

    @Override
    public Parser<ArticleAuditStatusEnum> getParser(ArticleAuditStatusFormat annotation, Class<?> fieldType) {
        return configureFormatterFrom(annotation, fieldType);
    }

    private Formatter<ArticleAuditStatusEnum> configureFormatterFrom(ArticleAuditStatusFormat annotation, Class<?> fieldType) {
        return new ArticleAuditStatusFormatter();
    }

    private static class ArticleAuditStatusFormatter implements Formatter<ArticleAuditStatusEnum> {

        @Override
        public ArticleAuditStatusEnum parse(String text, Locale locale) throws ParseException {
            if (StringUtils.isEmpty(text)) {
                return null;
            }
            return ArticleAuditStatusEnum.valueOf(ArticleAuditStatusEnum.class, text);
        }

        @Override
        public String print(ArticleAuditStatusEnum value, Locale locale) {
            if (null == value) {
                return null;
            }
            return value.name().toLowerCase(locale) + "2";
        }
    }
}
