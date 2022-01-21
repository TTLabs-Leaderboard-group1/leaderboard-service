package io.turntabl.leaderboardservice.controller;

import io.turntabl.leaderboardservice.controller.request.UsernameRequestDto;
import io.turntabl.leaderboardservice.controller.response.ProfileDto;
import io.turntabl.leaderboardservice.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("v1/leaderboard")
public class LeaderboardController {

    private final LeaderboardFacade leaderboardFacade;

    @GetMapping
    public List<ProfileDto> getLeaderboard() {
        return leaderboardFacade.getLeaderboard();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDto createProfile (@RequestBody UsernameRequestDto usernameRequest) {
        return leaderboardFacade.createUserProfile(usernameRequest);
    }

    @GetMapping("/{language}")
    public List<ProfileDto> getLeaderboardByLanguage(@PathVariable String language){
        return leaderboardFacade.getLeaderboardByLanguage(language);
    }
}
