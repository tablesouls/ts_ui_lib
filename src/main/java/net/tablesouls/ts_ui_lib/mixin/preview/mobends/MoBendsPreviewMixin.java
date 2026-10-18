package net.tablesouls.ts_ui_lib.mixin.preview.mobends;

import net.minecraft.world.entity.LivingEntity;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "goblinbob.mobends.forge.compat.ModCompatManager", remap = false)
public abstract class MoBendsPreviewMixin {

    @Inject(method = "shouldDeferAnimation", at = @At("HEAD"),
            cancellable = true, remap = false, require = 0)
    private static void souls$deferForPreview(LivingEntity entity,
                                              CallbackInfoReturnable<Boolean> cir) {
        if (PlayerModelPreviewRenderer.isPreviewTarget(entity)) {
            cir.setReturnValue(true);
        }
    }
}