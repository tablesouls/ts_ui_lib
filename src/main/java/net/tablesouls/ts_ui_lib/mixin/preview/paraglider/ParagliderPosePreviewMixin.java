package net.tablesouls.ts_ui_lib.mixin.preview.paraglider;

import net.minecraft.world.item.ItemStack;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tictim.paraglider.contents.item.ParagliderItem;

@Pseudo
@Mixin(value = ParagliderItem.class, remap = false)
public abstract class ParagliderPosePreviewMixin {
    @Inject(method = "isParagliding", at = @At("HEAD"), cancellable = true, remap = false)
    private void souls_combat_hud$suppressParaglidingPoseInPreview(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (PlayerModelPreviewRenderer.isPreviewHeldItem(stack)) {
            cir.setReturnValue(false);
        }
    }
}