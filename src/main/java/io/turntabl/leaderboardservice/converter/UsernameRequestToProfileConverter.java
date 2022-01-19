package io.turntabl.leaderboardservice.converter;

import io.turntabl.leaderboardservice.controller.UsernameRequest;
import io.turntabl.leaderboardservice.model.Profile;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsernameRequestToProfileConverter implements Converter<UsernameRequest, Profile> {
    @Override
    public Profile convert(UsernameRequest source) {
        Profile profile = new Profile();
        return profile.setId(source.getUsername());
    }
}
