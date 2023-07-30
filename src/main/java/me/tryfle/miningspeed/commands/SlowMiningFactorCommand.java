package me.tryfle.miningspeed.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.weavemc.loader.api.command.Command;
import org.jetbrains.annotations.NotNull;

import static me.tryfle.miningspeed.Main.*;

public class SlowMiningFactorCommand extends Command {
    public SlowMiningFactorCommand() {
        super("slowminingfactor");
    }

    @Override
    public void handle(@NotNull String[] args) {
        if (args.length == 1) {
            try {
                float secondFactor = Float.parseFloat(args[0]);
                fatigueFactor(secondFactor);
            } catch (NumberFormatException e) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid factor value. Usage: /slowminingfactor <value>"));
            }
        } else {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Usage: /slowminingfactor <value>"));
        }
    }
}
