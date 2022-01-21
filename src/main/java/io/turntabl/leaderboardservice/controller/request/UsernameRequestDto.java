package io.turntabl.leaderboardservice.controller.request;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class UsernameRequestDto {

    String username;
}
