package com.akoca.exercise.dbconverters;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.AttributeConverter;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecurityAuthorityConverter implements AttributeConverter<Set<GrantedAuthority> , String> {

    private static final char AUTHORITY_DELIMITER = ',';

    @Override
    public String convertToDatabaseColumn(Set<GrantedAuthority> grantedAuthorities) {

        return Joiner.on(AUTHORITY_DELIMITER).skipNulls().join(grantedAuthorities);
    }

    @Override
    public Set<GrantedAuthority> convertToEntityAttribute(String s) {
        Stream<String> authoritiesInString =  Splitter.on(AUTHORITY_DELIMITER).omitEmptyStrings().trimResults().splitToStream(s);

        return authoritiesInString.map(SimpleGrantedAuthority :: new).collect(Collectors.toSet());
    }
}