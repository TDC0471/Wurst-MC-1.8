/*
 * Copyright � 2014 - 2017 | Wurst-Imperium | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.features.mods;

import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import tk.wurst_client.events.listeners.UpdateListener;

@Mod.Info(
	description = "While this is active, other people will think you are\n"
		+ "derping around.",
	name = "Derp",
	noCheatCompatible = false,
	tags = "Retarded",
	help = "Mods/Derp")
@Mod.Bypasses
public class DerpMod extends Mod implements UpdateListener
{
	@Override
	public void onEnable()
	{
		wurst.events.add(UpdateListener.class, this);
	}
	
	@Override
	public void onUpdate()
	{
		float yaw = mc.player.rotationYaw + (float)(Math.random() * 360 - 180);
		float pitch = (float)(Math.random() * 180 - 90);
		mc.player.connection.sendPacket(
			new Rotation(yaw, pitch, mc.player.onGround));
	}
	
	@Override
	public void onDisable()
	{
		wurst.events.remove(UpdateListener.class, this);
	}
}
