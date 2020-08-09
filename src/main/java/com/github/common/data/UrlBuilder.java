package com.github.common.data;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class UrlBuilder {

    private UrlBuilder() { } //не сможем создать объект

    public static <T> String buildFullUrl(final String commonUrl, final Class<T> type) { // <T> -тип данных(общий дженерик_объект)
        return Optional.ofNullable(type)  //Optional -никогда не будет NullPointerExeption
//                        .ifPresent(); //метод проверяет если значение НЕ null, тут ->(type)
                          .map(annotation -> type.getAnnotation(PartialUrl.class))  //достаем Annotation
                          .map(PartialUrl::value)          // достаем value Annotation
                          .map(partialUrl -> String.format("%s/%s", commonUrl, partialUrl) ) // конкатенация значения value к commonUrl
//                        .get();  // отдать полный Url
                          .orElseThrow(() -> new IllegalStateException("Missing '@PartialUrl' in class!")); // выбросим Exeption, если в (type) прийдет null
    }

    public static <T> String buildWholeUrl(final String commonUrl, final Class<T> type) {

        if(type == null) {
            throw new IllegalStateException("Missing '@PartialUrl' in class!");
        }

        final PartialUrl partialUrlValue = type.getAnnotation(PartialUrl.class);   //достаем Annotation
        final String value = partialUrlValue.value();

        if(StringUtils.isNotEmpty(value)) {
            return String.format("%s/%s", commonUrl, value);
        }

        throw new IllegalStateException("Missing 'Common URL part!'");
    }
}
