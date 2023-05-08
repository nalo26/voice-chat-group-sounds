package fr.nalo.voicechatgroupsounds;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupSounds implements ModInitializer {

	public static final String MOD_ID = "voicechat_group_sounds";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Example mod initialized!");
	}
}
