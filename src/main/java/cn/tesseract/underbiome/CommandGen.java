package cn.tesseract.underbiome;

import net.minecraft.CommandBase;
import net.minecraft.ICommandSender;
import net.minecraft.ServerPlayer;

public class CommandGen extends CommandBase {
    @Override
    public String getCommandName() {
        return "gen";
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        ServerPlayer player = getCommandSenderAsPlayer(sender);
        //new WorldGenIceSpike().generate(player.worldObj, player.worldObj.rand, (int) player.posX, (int) player.posY, (int) player.posZ);
    }
}
