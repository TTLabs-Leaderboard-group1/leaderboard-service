package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.converter.ProfileToProfileDtoConverter;
import io.turntabl.leaderboardservice.converter.UsernameRequestDtoToProfileConverter;
import io.turntabl.leaderboardservice.model.Profile;
import io.turntabl.leaderboardservice.service.LeaderboardRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import io.turntabl.leaderboardservice.controller.request.UsernameRequestDto;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Component
public class LeaderboardFacade {

    private final LeaderboardRepositoryService leaderboardRepositoryService;
    private final ProfileToProfileDtoConverter profileToProfileDtoConverter;
    private final UsernameRequestDtoToProfileConverter usernameRequestToProfileConverter;

    public List<ProfileDto> getLeaderboard() {
        return leaderboardRepositoryService.getProfiles().stream()
                .sorted(comparing(Profile::getHonour).reversed())
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }

    public ProfileDto createUserProfile(UsernameRequestDto usernameRequest) {
        Profile profile = usernameRequestToProfileConverter.convert(usernameRequest);
        return profileToProfileDtoConverter.convert(leaderboardRepositoryService.saveProfile(profile));
    }

    public List<ProfileDto> getLeaderboardByLanguage(String language) {
        return leaderboardRepositoryService.getProfiles().stream()
                .filter(profile -> profile.getLanguageLevels().stream().anyMatch(languageLevelDto -> languageLevelDto.getName().equals(language)))
                .map(profileToProfileDtoConverter::convert)
                .collect(toList());
    }
}
