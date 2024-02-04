package ru.netology;
import lombok.*;
import java.util.UUID;

@RequiredArgsConstructor
@Setter
@Getter
@ToString
public class MyEntity {
    @NonNull private String name;
    private UUID id;
}
