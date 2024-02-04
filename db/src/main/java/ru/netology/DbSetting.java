package ru.netology;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DbSetting {
    private String name;
    private String password;
    private boolean connect() {
        return !name.isEmpty() && !password.isEmpty();
    }
}