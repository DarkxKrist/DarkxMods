package darkx.darkxauth.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.Player;
import darkx.DarkxCore;
import darkx.darkxcore.lib.PacketIds;
import darkx.darkxcore.network.PacketDarkx;

public class PacketAuthQ extends PacketDarkx {

	private int packetId;
	
	public PacketAuthQ() {}
	
	public PacketAuthQ(int packetId) {
		this.packetId = packetId;
		this.isChunkDataPacket = false;
	}
	
	@Override
	public int getID() {
		return packetId;
	}

	@Override
	public void readData(DataInputStream data) throws IOException {}

	@Override
	public void writeData(DataOutputStream data) throws IOException {}
	
	@Override
	public void execute(INetworkManager network, Player player)
	{
		if (!FMLClientHandler.instance().getClient().isSingleplayer())
			DarkxCore.proxy.sendToServer(new PacketAuthA(PacketIds.AUTH_A, FMLClientHandler.instance().getClient().session.sessionId).getPacket());
	}
	
}