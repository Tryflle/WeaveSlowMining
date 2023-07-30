package me.tryfle.miningspeed.mixins;

import me.tryfle.miningspeed.Main;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin {
    @Inject(method = "getArmSwingAnimationEnd", at = @At("HEAD"), cancellable = true)
    public void iHateJava(CallbackInfoReturnable<Integer> ci) {
        if (Main.enabled) {
            ci.setReturnValue((int) Main.fatigueFactor);
        }
    }
}