package cc.yellowed.freezewand.instance;

import java.util.UUID;

public class Profile {

    private UUID uuid;
    private boolean frozen;

    public Profile(UUID uuid) {
        this.uuid = uuid;
        frozen = false;
    }

    public Profile(String uuid) {
        this(UUID.fromString(uuid));
    }


}
