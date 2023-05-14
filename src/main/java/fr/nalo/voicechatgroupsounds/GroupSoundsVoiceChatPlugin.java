package fr.nalo.voicechatgroupsounds;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import de.maxhenkel.voicechat.api.Group;
import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.JoinGroupEvent;
import de.maxhenkel.voicechat.api.events.LeaveGroupEvent;
import de.maxhenkel.voicechat.api.events.PlayerStateChangedEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

public class GroupSoundsVoiceChatPlugin implements VoicechatPlugin {

    private Group group;
    private Set<UUID> players_in_group = new HashSet<>();

    /**
     * @return the unique ID for this voice chat plugin
     */
    @Override
    public String getPluginId() {
        return GroupSounds.MOD_ID;
    }

    /**
     * Called when the voice chat initializes the plugin.
     *
     * @param api the voice chat API
     */
    @Override
    public void initialize(VoicechatApi api) {
        GroupSounds.LOGGER.info("Group Sounds voice chat plugin initialized!");
    }

    /**
     * Called once by the voice chat to register all events.
     *
     * @param registration the event registration
     */
    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(JoinGroupEvent.class, this::onJoinGroupEvent);
        registration.registerEvent(LeaveGroupEvent.class, this::onLeaveGroupEvent);
        registration.registerEvent(PlayerStateChangedEvent.class, this::onPlayerStateChangedEvent);
    }

    public void onJoinGroupEvent(JoinGroupEvent event) {
        GroupSounds.LOGGER.info("Join group event");
    }

    public void onLeaveGroupEvent(LeaveGroupEvent event) {
        GroupSounds.LOGGER.info("Leave group event");
    }

    public void onPlayerStateChangedEvent(PlayerStateChangedEvent event) {
        GroupSounds.LOGGER.info("Player state changed event");
        if (this.group == null || event.getConnection() == null || event.isDisabled() == true)
            return;

        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;

        UUID player_uuid = event.getPlayerUuid();

        if (player_uuid.equals(player.getUUID())) {
            GroupSounds.LOGGER.info("User joined/leaved group");
            this.group = event.getConnection().getGroup();
            return;
        }

        if (this.players_in_group.contains(player_uuid) && event.getConnection().getGroup() == null) {
            GroupSounds.LOGGER.info("Player leaved group");
            this.players_in_group.remove(player_uuid);
            player.playSound(GroupSounds.soundLeaveGroupEvent);

        } else if (!this.players_in_group.contains(player_uuid)
                && this.group.equals(event.getConnection().getGroup())) {
            GroupSounds.LOGGER.info("Player joined group");
            this.players_in_group.add(player_uuid);
            player.playSound(GroupSounds.soundJoinGroupEvent);
        }

    }

}
