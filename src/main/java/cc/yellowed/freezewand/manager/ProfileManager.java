package cc.yellowed.freezewand.manager;

import cc.yellowed.freezewand.instance.Profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private static Map<UUID, Profile> profileMap = new HashMap<>();

    public static void register(UUID uuid) {
        if (!profileMap.containsKey(uuid)) {
            profileMap.put(uuid, new Profile(uuid));
        }
    }


}
