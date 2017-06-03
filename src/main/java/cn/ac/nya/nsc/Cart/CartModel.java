package cn.ac.nya.nsc.Cart;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Created by drzzm on 2017.4.30.
 */
public class CartModel extends ModelBase {

    ModelRenderer Bottom;
    ModelRenderer Wheel1;
    ModelRenderer Wheel2;
    ModelRenderer Wheel3;
    ModelRenderer Wheel4;
    ModelRenderer Axle1;
    ModelRenderer Axle2;
    ModelRenderer Bearing1;
    ModelRenderer Bearing2;
    ModelRenderer Bearing3;
    ModelRenderer Bearing4;
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Left;
    ModelRenderer Right;

    public CartModel() {
        textureWidth = 128;
        textureHeight = 64;

        Bottom = new ModelRenderer(this, 64, 47);
        Bottom.addBox(0F, 0F, 0F, 14, 1, 16);
        Bottom.setRotationPoint(-7F, 20.1F, -8F);
        Bottom.setTextureSize(128, 64);
        Bottom.mirror = true;
        setRotation(Bottom, 0F, 0F, 0F);
        Wheel1 = new ModelRenderer(this, 0, 3);
        Wheel1.addBox(0F, 0F, 0F, 1, 2, 2);
        Wheel1.setRotationPoint(4F, 21.5F, -6F);
        Wheel1.setTextureSize(128, 64);
        Wheel1.mirror = true;
        setRotation(Wheel1, 0F, 0F, 0F);
        Wheel2 = new ModelRenderer(this, 12, 3);
        Wheel2.addBox(0F, 0F, 0F, 1, 2, 2);
        Wheel2.setRotationPoint(-5F, 21.5F, -6F);
        Wheel2.setTextureSize(128, 64);
        Wheel2.mirror = true;
        setRotation(Wheel2, 0F, 0F, 0F);
        Wheel3 = new ModelRenderer(this, 0, 3);
        Wheel3.addBox(0F, 0F, 0F, 1, 2, 2);
        Wheel3.setRotationPoint(4F, 21.5F, 4F);
        Wheel3.setTextureSize(128, 64);
        Wheel3.mirror = true;
        setRotation(Wheel3, 0F, 0F, 0F);
        Wheel4 = new ModelRenderer(this, 12, 3);
        Wheel4.addBox(0F, 0F, 0F, 1, 2, 2);
        Wheel4.setRotationPoint(-5F, 21.5F, 4F);
        Wheel4.setTextureSize(128, 64);
        Wheel4.mirror = true;
        setRotation(Wheel4, 0F, 0F, 0F);
        Axle1 = new ModelRenderer(this, 0, 0);
        Axle1.addBox(0F, 0F, 0F, 12, 1, 1);
        Axle1.setRotationPoint(-6F, 22F, -5.5F);
        Axle1.setTextureSize(128, 64);
        Axle1.mirror = true;
        setRotation(Axle1, 0F, 0F, 0F);
        Axle2 = new ModelRenderer(this, 0, 0);
        Axle2.addBox(0F, 0F, 0F, 12, 1, 1);
        Axle2.setRotationPoint(-6F, 22F, 4.5F);
        Axle2.setTextureSize(128, 64);
        Axle2.mirror = true;
        setRotation(Axle2, 0F, 0F, 0F);
        Bearing1 = new ModelRenderer(this, 0, 8);
        Bearing1.addBox(0F, 0F, 0F, 1, 2, 3);
        Bearing1.setRotationPoint(5.25F, 20.5F, -6.5F);
        Bearing1.setTextureSize(128, 64);
        Bearing1.mirror = true;
        setRotation(Bearing1, 0F, 0F, 0F);
        Bearing2 = new ModelRenderer(this, 12, 8);
        Bearing2.addBox(0F, 0F, 0F, 1, 2, 3);
        Bearing2.setRotationPoint(-6.3F, 20.5F, -6.5F);
        Bearing2.setTextureSize(128, 64);
        Bearing2.mirror = true;
        setRotation(Bearing2, 0F, 0F, 0F);
        Bearing3 = new ModelRenderer(this, 0, 8);
        Bearing3.addBox(0F, 0F, 0F, 1, 2, 3);
        Bearing3.setRotationPoint(5.3F, 20.5F, 3.5F);
        Bearing3.setTextureSize(128, 64);
        Bearing3.mirror = true;
        setRotation(Bearing3, 0F, 0F, 0F);
        Bearing4 = new ModelRenderer(this, 12, 8);
        Bearing4.addBox(0F, 0F, 0F, 1, 2, 3);
        Bearing4.setRotationPoint(-6.3F, 20.5F, 3.5F);
        Bearing4.setTextureSize(128, 64);
        Bearing4.mirror = true;
        setRotation(Bearing4, 0F, 0F, 0F);
        Front = new ModelRenderer(this, 64, 0);
        Front.addBox(0F, 0F, 0F, 14, 9, 1);
        Front.setRotationPoint(-7F, 12F, -8.1F);
        Front.setTextureSize(128, 64);
        Front.mirror = true;
        setRotation(Front, 0F, 0F, 0F);
        Back = new ModelRenderer(this, 79, 0);
        Back.addBox(0F, 0F, 0F, 14, 9, 1);
        Back.setRotationPoint(-7F, 12F, 7.1F);
        Back.setTextureSize(128, 64);
        Back.mirror = true;
        setRotation(Back, 0F, 0F, 0F);
        Left = new ModelRenderer(this, 81, 16);
        Left.addBox(0F, 0F, 0F, 1, 9, 16);
        Left.setRotationPoint(6.1F, 12F, -8F);
        Left.setTextureSize(128, 64);
        Left.mirror = true;
        setRotation(Left, 0F, 0F, 0F);
        Right = new ModelRenderer(this, 64, 16);
        Right.addBox(0F, 0F, 0F, 1, 9, 16);
        Right.setRotationPoint(-7.1F, 12F, -8F);
        Right.setTextureSize(128, 64);
        Right.mirror = true;
        setRotation(Right, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Bottom.render(f5);
        Wheel1.render(f5);
        Wheel2.render(f5);
        Wheel3.render(f5);
        Wheel4.render(f5);
        Axle1.render(f5);
        Axle2.render(f5);
        Bearing1.render(f5);
        Bearing2.render(f5);
        Bearing3.render(f5);
        Bearing4.render(f5);
        Front.render(f5);
        Back.render(f5);
        Left.render(f5);
        Right.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
