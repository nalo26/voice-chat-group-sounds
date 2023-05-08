package fr.nalo.voicechatgroupsounds.mixin;

import fr.nalo.voicechatgroupsounds.GroupSounds;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ExampleMixin {

    @Inject(at = @At("HEAD"), method = "init")
    private void init(CallbackInfo info) {
        GroupSounds.LOGGER.info("Example mixin");
    }

}
