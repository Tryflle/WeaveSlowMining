package me.tryfle.miningspeed;

import me.tryfle.miningspeed.commands.SlowMiningCommand;
import me.tryfle.miningspeed.commands.SlowMiningFactorCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;

public class Main implements ModInitializer {

    public static boolean enabled = false;
    public static float fatigueFactor = 20;

    public static void setEnabled(boolean value) {
        enabled = value;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "SlowMining has been " + (enabled ? "enabled" : "disabled") + "."));
    }
    public static void fatigueFactor(float secondFactor) {
        fatigueFactor = secondFactor;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY + "Intensity factor set to: " + fatigueFactor));
    }

    @Override
    public void preInit() {
        System.out.println("[WeaveSlowMining] Initializing");
        CommandBus.register(new SlowMiningCommand());
        CommandBus.register(new SlowMiningFactorCommand());
    }
}
