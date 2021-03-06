package com.teamabnormals.upgrade_aquatic.client.render.jellyfish;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.teamabnormals.upgrade_aquatic.client.model.jellyfish.ModelBoxJellyfish;
import com.teamabnormals.upgrade_aquatic.client.render.jellyfish.layer.JellyfishEmissiveLayer;
import com.teamabnormals.upgrade_aquatic.common.entities.jellyfish.EntityBoxJellyfish;
import com.teamabnormals.upgrade_aquatic.core.util.Reference;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BoxJellyfishRenderer extends AbstractJellyfishRenderer<EntityBoxJellyfish> {

	public BoxJellyfishRenderer(EntityRendererManager renderManager) {
		super(renderManager, new ModelBoxJellyfish<>(), 0.5F);
		this.addLayer(new JellyfishEmissiveLayer<>(this, this));
	}

	@Override
	public ResourceLocation getEntityTexture(EntityBoxJellyfish jellyfish) {
		return new ResourceLocation(Reference.MODID, "textures/entity/jellyfish/box/" + jellyfish.getBucketName() + "_jellyfish.png");
	}
	
	@Override
	public ResourceLocation getOverlayTexture(EntityBoxJellyfish jellyfish) {
		return new ResourceLocation(Reference.MODID, "textures/entity/jellyfish/box/" + jellyfish.getBucketName() + "_jellyfish_overlay.png");
	}
	
	@Override
	protected RenderType func_230042_a_(EntityBoxJellyfish jellyfish, boolean p_230042_2_, boolean p_230042_3_) {
		return RenderType.getEntityTranslucent(this.getEntityTexture(jellyfish));
	}
	
	@Override
	protected void preRenderCallback(EntityBoxJellyfish jellyfish, MatrixStack matrixStack, float partialTickTime) {
		float size = jellyfish.getSize();
		matrixStack.scale(size, size, size);
	}

}