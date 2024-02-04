package ru.netology;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class Db {
    private DbSetting dbSetting;
    private MyEntity myEntity;

    public Db(DbSetting dbSetting) {
        this.dbSetting = dbSetting;
        myEntity = new MyEntity("first");
        myEntity.setId(UUID.randomUUID());
    }
}