package net.tablesouls.ts_ui_lib.mixin.preview.paraglider;

import net.minecraft.world.item.ItemStack;
import net.tablesouls.ts_ui_lib.client.preview.PlayerModelPreviewRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tictim.paraglider.impl.DefaultParagliderItemCapability;

@Pseudo
@Mixin(value = DefaultParagliderItemCapability.class, remap = false)
public abstract class ParagliderItemPreviewMixin {
    @Inject(method = "isParagliding(Lnet/minecraft/world/item/ItemStack;)Z",
            at = @At("HEAD"), cancellable = true, remap = false, require = 0)
    private void ts_ui_lib$suppressParaglidingPoseInPreview(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (PlayerModelPreviewRenderer.isPreviewHeldItem(stack)) {
            cir.setReturnValue(false);
        }
    }
}