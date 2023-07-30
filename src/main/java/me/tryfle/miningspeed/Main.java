package me.tryfle.miningspeed;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.Command;
import net.weavemc.loader.api.command.CommandBus;
import org.jetbrains.annotations.NotNull;

public class Main implements ModInitializer {

    public static boolean enabled = false;
    public static float fatigueFactor = 20;

    public static void setEnabled(boolean value) {
        enabled = value;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY +
                "SlowMining has been " + (enabled ? "enabled" : "disabled") + "."));
        System.out.println("[WeaveSlowMining] Debug setEnabled called with value: " + value);
    }
    public static void fatigueFactor(float secondFactor) {
        fatigueFactor = secondFactor;
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.GRAY +
                "Intensity factor set to: " + fatigueFactor));
    }

    @Override
    public void preInit() {
        System.out.println("[WeaveSlowMining] Initializing");
        CommandBus.register(new Command("slowmining") {
            @Override
            public void handle(@NotNull String[] args) {
                setEnabled(!enabled);
            }
        });

        CommandBus.register(new Command("slowminingfactor") {
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
    });
}}
