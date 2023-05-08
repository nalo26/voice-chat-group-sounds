package fr.nalo.voicechatgroupsounds;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.JoinGroupEvent;
import de.maxhenkel.voicechat.api.events.LeaveGroupEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;

public class GroupSoundsVoiceChatPlugin implements VoicechatPlugin {

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
        // GroupSounds.LOGGER.info("Group Sounds voice chat plugin initialized!");
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
    }

    public void onJoinGroupEvent(JoinGroupEvent event) {
        GroupSounds.LOGGER.info("User join group");
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        player.playSound(GroupSounds.soundJoinGroupEvent);
    }

    public void onLeaveGroupEvent(LeaveGroupEvent event) {
        GroupSounds.LOGGER.info("User leave group");
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        player.playSound(GroupSounds.soundLeaveGroupEvent);
    }

}
