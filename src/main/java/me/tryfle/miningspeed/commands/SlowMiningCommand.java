package me.tryfle.miningspeed.commands;

import net.weavemc.loader.api.command.Command;
import org.jetbrains.annotations.NotNull;

import static me.tryfle.miningspeed.Main.enabled;
import static me.tryfle.miningspeed.Main.setEnabled;

public class SlowMiningCommand extends Command {
    public SlowMiningCommand() {
        super("slowmining");
    }

    @Override
    public void handle(@NotNull String[] args) {
        setEnabled(!enabled);
    }
}
