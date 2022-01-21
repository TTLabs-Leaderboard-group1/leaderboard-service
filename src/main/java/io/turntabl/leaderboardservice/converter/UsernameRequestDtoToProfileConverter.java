package io.turntabl.leaderboardservice.converter;

import io.turntabl.leaderboardservice.controller.request.UsernameRequestDto;
import io.turntabl.leaderboardservice.model.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsernameRequestDtoToProfileConverter implements Converter<UsernameRequestDto, Profile> {
    @Override
    public Profile convert(UsernameRequestDto source) {
        Profile profile = new Profile();
        return profile.setId(source.getUsername());
    }
}
