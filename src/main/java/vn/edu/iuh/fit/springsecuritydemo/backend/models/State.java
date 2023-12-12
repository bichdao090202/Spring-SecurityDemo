package vn.edu.iuh.fit.springsecuritydemo.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {
    ACTIVE(1), INACTIVE(0), TERMINAL(-1);
    private int value;

}
