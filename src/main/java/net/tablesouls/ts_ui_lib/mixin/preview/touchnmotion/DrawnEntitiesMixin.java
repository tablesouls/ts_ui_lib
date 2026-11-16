package net.tablesouls.ts_ui_lib.mixin.preview.touchnmotion;

import net.minecraft.world.entity.Entity;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "strm.touchnmotion.interaction.DrawnEntities", remap = false)
public abstract class DrawnEntitiesMixin {

    @Inject(method = "inWorld", at = @At("HEAD"), cancellable = true, remap = false)
    private static void ts_ui_lib$notInWorldDuringPreview(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (PlayerModelPreviewRenderer.isRenderingPreview()) {
            cir.setReturnValue(false);
        }
    }
}