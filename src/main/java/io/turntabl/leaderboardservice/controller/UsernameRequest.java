package io.turntabl.leaderboardservice.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UsernameRequest {
    private String username;
}
