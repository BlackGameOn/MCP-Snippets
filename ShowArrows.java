package BlackClient.mods.impl;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import BlackClient.Gui.HUD.ScreenPosition;
import BlackClient.mods.ModDraggable;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModOklar extends ModDraggable {

	@Override
	public int getWidth() {
		return 20;
	}

	@Override
	public int getHeight() {
		return 25;
	}

	@Override
	public void render(ScreenPosition pos) {
		if(this.getRemainingArrows() < 1) {
			font.drawString(this.getRemainingArrows() + "", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 15, Color.RED.getRGB());
		} else {
			font.drawString(this.getRemainingArrows() + "", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 15, Color.WHITE.getRGB());
		}
        this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), pos.getAbsoluteX() + 3, pos.getAbsoluteY() - 1);

	}
	
	
	@Override
	public void renderDummy(ScreenPosition pos) {
		if(this.getRemainingArrows() < 1) {
			font.drawString(this.getRemainingArrows() + "", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 15, Color.RED.getRGB());
		} else {
			font.drawString(this.getRemainingArrows() + "", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 15, Color.WHITE.getRGB());
		}
        this.mc.getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), pos.getAbsoluteX() + 3, pos.getAbsoluteY() - 1);

	}
	
	   private int getRemainingArrows() {
		      int i = 0;

		      for(ItemStack itemstack : this.mc.thePlayer.inventory.mainInventory) {
		         if(itemstack != null && itemstack.getItem().equals(Items.arrow)) {
		            i += itemstack.stackSize;
		         }
		      }

		      return i;
		   }
	
}
