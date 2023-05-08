package fr.nalo.voicechatgroupsounds;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupSounds implements ModInitializer {

	public static final String MOD_ID = "voicechat_group_sounds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ResourceLocation SOUND_JOIN_GROUP = new ResourceLocation("join_group");
	public static final ResourceLocation SOUND_LEAVE_GROUP = new ResourceLocation("leave_group");

	public static SoundEvent soundJoinGroupEvent = new SoundEvent(SOUND_JOIN_GROUP);
	public static SoundEvent soundLeaveGroupEvent = new SoundEvent(SOUND_LEAVE_GROUP);

	@Override
	public void onInitialize() {
		LOGGER.info("Group Sounds mod initialized!");

		Registry.register(Registry.SOUND_EVENT, SOUND_JOIN_GROUP, soundJoinGroupEvent);
		Registry.register(Registry.SOUND_EVENT, SOUND_LEAVE_GROUP, soundLeaveGroupEvent);
	}
}
