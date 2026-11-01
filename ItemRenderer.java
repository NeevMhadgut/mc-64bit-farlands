import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class ItemRenderer {
   private Minecraft a;
   private ItemStack b = null;
   private float c = 0.0F;
   private float d = 0.0F;
   private RenderBlocks e = new RenderBlocks();
   private aal f;
   private int g = -1;

   public ItemRenderer(Minecraft par1Minecraft) {
      this.a = par1Minecraft;
      this.f = new aal(par1Minecraft.q, par1Minecraft.A, par1Minecraft.p);
   }

   public void a(EntityLiving par1EntityLiving, ItemStack par2ItemStack, int par3) {
      GL11.glPushMatrix();
      if (par2ItemStack.c < 256 && RenderBlocks.a(Block.m[par2ItemStack.c].d())) {
         GL11.glBindTexture(3553, this.a.p.b("/terrain.png"));
         this.e.a(Block.m[par2ItemStack.c], par2ItemStack.i(), 1.0F);
      } else {
         if (par2ItemStack.c < 256) {
            GL11.glBindTexture(3553, this.a.p.b("/terrain.png"));
         } else {
            GL11.glBindTexture(3553, this.a.p.b("/gui/items.png"));
         }

         Tessellator tessellator = Tessellator.a;
         int i = par1EntityLiving.b(par2ItemStack, par3);
         float f = (i % 16 * 16 + 0.0F) / 256.0F;
         float f1 = (i % 16 * 16 + 15.99F) / 256.0F;
         float f2 = (i / 16 * 16 + 0.0F) / 256.0F;
         float f3 = (i / 16 * 16 + 15.99F) / 256.0F;
         float f4 = 0.0F;
         float f5 = 0.3F;
         GL11.glEnable(32826);
         GL11.glTranslatef(-f4, -f5, 0.0F);
         float f6 = 1.5F;
         GL11.glScalef(f6, f6, f6);
         GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
         this.a(tessellator, f1, f2, f, f3);
         if (par2ItemStack != null && par2ItemStack.r() && par3 == 0) {
            GL11.glDepthFunc(514);
            GL11.glDisable(2896);
            this.a.p.b(this.a.p.b("%blur%/misc/glint.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(768, 1);
            float f7 = 0.76F;
            GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
            GL11.glMatrixMode(5890);
            GL11.glPushMatrix();
            float f8 = 0.125F;
            GL11.glScalef(f8, f8, f8);
            float f9 = (float)(System.currentTimeMillis() % 3000L) / 3000.0F * 8.0F;
            GL11.glTranslatef(f9, 0.0F, 0.0F);
            GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
            this.a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            f9 = (float)(System.currentTimeMillis() % 4873L) / 4873.0F * 8.0F;
            GL11.glTranslatef(-f9, 0.0F, 0.0F);
            GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
            this.a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glDepthFunc(515);
         }

         GL11.glDisable(32826);
      }

      GL11.glPopMatrix();
   }

   private void a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5) {
      float f = 1.0F;
      float f1 = 0.0625F;
      par1Tessellator.b();
      par1Tessellator.b(0.0F, 0.0F, 1.0F);
      par1Tessellator.a(0.0, 0.0, 0.0, par2, par5);
      par1Tessellator.a(f, 0.0, 0.0, par4, par5);
      par1Tessellator.a(f, 1.0, 0.0, par4, par3);
      par1Tessellator.a(0.0, 1.0, 0.0, par2, par3);
      par1Tessellator.a();
      par1Tessellator.b();
      par1Tessellator.b(0.0F, 0.0F, -1.0F);
      par1Tessellator.a(0.0, 1.0, 0.0F - f1, par2, par3);
      par1Tessellator.a(f, 1.0, 0.0F - f1, par4, par3);
      par1Tessellator.a(f, 0.0, 0.0F - f1, par4, par5);
      par1Tessellator.a(0.0, 0.0, 0.0F - f1, par2, par5);
      par1Tessellator.a();
      par1Tessellator.b();
      par1Tessellator.b(-1.0F, 0.0F, 0.0F);

      for (int i = 0; i < 16; i++) {
         float f2 = i / 16.0F;
         float f6 = par2 + (par4 - par2) * f2 - 0.001953125F;
         float f10 = f * f2;
         par1Tessellator.a(f10, 0.0, 0.0F - f1, f6, par5);
         par1Tessellator.a(f10, 0.0, 0.0, f6, par5);
         par1Tessellator.a(f10, 1.0, 0.0, f6, par3);
         par1Tessellator.a(f10, 1.0, 0.0F - f1, f6, par3);
      }

      par1Tessellator.a();
      par1Tessellator.b();
      par1Tessellator.b(1.0F, 0.0F, 0.0F);

      for (int j = 0; j < 16; j++) {
         float f3 = j / 16.0F;
         float f7 = par2 + (par4 - par2) * f3 - 0.001953125F;
         float f11 = f * f3 + 0.0625F;
         par1Tessellator.a(f11, 1.0, 0.0F - f1, f7, par3);
         par1Tessellator.a(f11, 1.0, 0.0, f7, par3);
         par1Tessellator.a(f11, 0.0, 0.0, f7, par5);
         par1Tessellator.a(f11, 0.0, 0.0F - f1, f7, par5);
      }

      par1Tessellator.a();
      par1Tessellator.b();
      par1Tessellator.b(0.0F, 1.0F, 0.0F);

      for (int k = 0; k < 16; k++) {
         float f4 = k / 16.0F;
         float f8 = par5 + (par3 - par5) * f4 - 0.001953125F;
         float f12 = f * f4 + 0.0625F;
         par1Tessellator.a(0.0, f12, 0.0, par2, f8);
         par1Tessellator.a(f, f12, 0.0, par4, f8);
         par1Tessellator.a(f, f12, 0.0F - f1, par4, f8);
         par1Tessellator.a(0.0, f12, 0.0F - f1, par2, f8);
      }

      par1Tessellator.a();
      par1Tessellator.b();
      par1Tessellator.b(0.0F, -1.0F, 0.0F);

      for (int l = 0; l < 16; l++) {
         float f5 = l / 16.0F;
         float f9 = par5 + (par3 - par5) * f5 - 0.001953125F;
         float f13 = f * f5;
         par1Tessellator.a(f, f13, 0.0, par4, f9);
         par1Tessellator.a(0.0, f13, 0.0, par2, f9);
         par1Tessellator.a(0.0, f13, 0.0F - f1, par2, f9);
         par1Tessellator.a(f, f13, 0.0F - f1, par4, f9);
      }

      par1Tessellator.a();
   }

   public void a(float par1) {
      float f = this.d + (this.c - this.d) * par1;
      EntityPlayerSP entityplayersp = this.a.h;
      float f1 = entityplayersp.x + (entityplayersp.v - entityplayersp.x) * par1;
      GL11.glPushMatrix();
      GL11.glRotatef(f1, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(entityplayersp.w + (entityplayersp.u - entityplayersp.w) * par1, 0.0F, 1.0F, 0.0F);
      tf.b();
      GL11.glPopMatrix();
      if (entityplayersp instanceof EntityPlayerSP) {
         EntityPlayerSP entityplayersp1 = entityplayersp;
         float f2 = entityplayersp1.GenLayerHills + (entityplayersp1.NoiseGeneratorPerlin - entityplayersp1.GenLayerHills) * par1;
         float i = entityplayersp1.MapGenVillage + (entityplayersp1.e - entityplayersp1.MapGenVillage) * par1;
      }

      ItemStack itemstack = this.b;
      float f3 = this.a.f.getLightBrightness(MathHelper.d(entityplayersp.o), MathHelper.c(entityplayersp.p), MathHelper.d(entityplayersp.q));
      f3 = 1.0F;
      int i = this.a.f.getLightBrightnessForSkyBlocks(MathHelper.d(entityplayersp.o), MathHelper.c(entityplayersp.p), MathHelper.d(entityplayersp.q), 0);
      int k = i % 65536;
      int l = i / 65536;
      es.a(es.b, k / 1.0F, l / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (itemstack != null) {
         int j = Item.e[itemstack.c].b(itemstack.i(), 0);
         float f8 = (j >> 16 & 0xFF) / 255.0F;
         float f13 = (j >> 8 & 0xFF) / 255.0F;
         float f19 = (j & 0xFF) / 255.0F;
         GL11.glColor4f(f3 * f8, f3 * f13, f3 * f19, 1.0F);
      } else {
         GL11.glColor4f(f3, f3, f3, 1.0F);
      }

      if (itemstack != null && itemstack.c == Item.bd.bQ) {
         GL11.glPushMatrix();
         float f5 = 0.8F;
         float f9 = entityplayersp.i(par1);
         float f14 = MathHelper.a(f9 * (float) Math.PI);
         float f20 = MathHelper.a(MathHelper.c(f9) * (float) Math.PI);
         GL11.glTranslatef(-f20 * 0.4F, MathHelper.a(MathHelper.c(f9) * (float) Math.PI * 2.0F) * 0.2F, -f14 * 0.2F);
         f9 = 1.0F - f1 / 45.0F + 0.1F;
         if (f9 < 0.0F) {
            f9 = 0.0F;
         }

         if (f9 > 1.0F) {
            f9 = 1.0F;
         }

         f9 = -MathHelper.b(f9 * (float) Math.PI) * 0.5F + 0.5F;
         GL11.glTranslatef(0.0F, 0.0F * f5 - (1.0F - f) * 1.2F - f9 * 0.5F + 0.04F, -0.9F * f5);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(f9 * -85.0F, 0.0F, 0.0F, 1.0F);
         GL11.glEnable(32826);
         GL11.glBindTexture(3553, this.a.p.a(this.a.h.Z, this.a.h.v_()));

         for (float var40 = 0.0F; var40 < 2.0F; var40++) {
            f20 = var40 * 2.0F - 1.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(-0.0F, -0.6F, 1.1F * f20);
            GL11.glRotatef(-45.0F * f20, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(59.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(-65.0F * f20, 0.0F, 1.0F, 0.0F);
            Render render1 = RenderManager.a.a(this.a.h);
            RenderPlayer renderplayer1 = (RenderPlayer)render1;
            float f34 = 1.0F;
            GL11.glScalef(f34, f34, f34);
            renderplayer1.b();
            GL11.glPopMatrix();
         }

         f14 = entityplayersp.i(par1);
         f20 = MathHelper.a(f14 * f14 * (float) Math.PI);
         float f27 = MathHelper.a(MathHelper.c(f14) * (float) Math.PI);
         GL11.glRotatef(-f20 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-f27 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-f27 * 80.0F, 1.0F, 0.0F, 0.0F);
         f14 = 0.38F;
         GL11.glScalef(f14, f14, f14);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
         f20 = 0.015625F;
         GL11.glScalef(f20, f20, f20);
         this.a.p.b(this.a.p.b("/misc/mapbg.png"));
         Tessellator tessellator = Tessellator.a;
         GL11.glNormal3f(0.0F, 0.0F, -1.0F);
         tessellator.b();
         byte byte0 = 7;
         tessellator.a(0 - byte0, 128 + byte0, 0.0, 0.0, 1.0);
         tessellator.a(128 + byte0, 128 + byte0, 0.0, 1.0, 1.0);
         tessellator.a(128 + byte0, 0 - byte0, 0.0, 1.0, 0.0);
         tessellator.a(0 - byte0, 0 - byte0, 0.0, 0.0, 0.0);
         tessellator.a();
         MapData mapdata = Item.bd.a(itemstack, this.a.f);
         this.f.a(this.a.h, this.a.p, mapdata);
         GL11.glPopMatrix();
      } else if (itemstack != null) {
         GL11.glPushMatrix();
         float f6 = 0.8F;
         if (entityplayersp.ai() > 0) {
            aaq enumaction = itemstack.m();
            if (enumaction == aaq.b || enumaction == aaq.c) {
               float f15 = entityplayersp.ai() - par1 + 1.0F;
               float f21 = 1.0F - f15 / itemstack.l();
               float f28 = f21;
               float f31 = 1.0F - f28;
               f31 = f31 * f31 * f31;
               f31 = f31 * f31 * f31;
               f31 = f31 * f31 * f31;
               float f35 = 1.0F - f31;
               GL11.glTranslatef(0.0F, MathHelper.e(MathHelper.b(f15 / 4.0F * (float) Math.PI) * 0.1F) * (f28 <= 0.2 ? 0 : 1), 0.0F);
               GL11.glTranslatef(f35 * 0.6F, -f35 * 0.5F, 0.0F);
               GL11.glRotatef(f35 * 90.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(f35 * 10.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(f35 * 30.0F, 0.0F, 0.0F, 1.0F);
            }
         } else {
            float f10 = entityplayersp.i(par1);
            float f16 = MathHelper.a(f10 * (float) Math.PI);
            float f22 = MathHelper.a(MathHelper.c(f10) * (float) Math.PI);
            GL11.glTranslatef(-f22 * 0.4F, MathHelper.a(MathHelper.c(f10) * (float) Math.PI * 2.0F) * 0.2F, -f16 * 0.2F);
         }

         GL11.glTranslatef(0.7F * f6, -0.65F * f6 - (1.0F - f) * 0.6F, -0.9F * f6);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable(32826);
         float f11 = entityplayersp.i(par1);
         float f17 = MathHelper.a(f11 * f11 * (float) Math.PI);
         float f23 = MathHelper.a(MathHelper.c(f11) * (float) Math.PI);
         GL11.glRotatef(-f17 * 20.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-f23 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-f23 * 80.0F, 1.0F, 0.0F, 0.0F);
         f11 = 0.4F;
         GL11.glScalef(f11, f11, f11);
         if (entityplayersp.ai() > 0) {
            aaq enumaction1 = itemstack.m();
            if (enumaction1 == aaq.d) {
               GL11.glTranslatef(-0.5F, 0.2F, 0.0F);
               GL11.glRotatef(30.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-80.0F, 1.0F, 0.0F, 0.0F);
               GL11.glRotatef(60.0F, 0.0F, 1.0F, 0.0F);
            } else if (enumaction1 == aaq.e) {
               GL11.glRotatef(-18.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-12.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(-8.0F, 1.0F, 0.0F, 0.0F);
               GL11.glTranslatef(-0.9F, 0.2F, 0.0F);
               float f24 = itemstack.l() - (entityplayersp.ai() - par1 + 1.0F);
               float f29 = f24 / 20.0F;
               f29 = (f29 * f29 + f29 * 2.0F) / 3.0F;
               if (f29 > 1.0F) {
                  f29 = 1.0F;
               }

               if (f29 > 0.1F) {
                  GL11.glTranslatef(0.0F, MathHelper.a((f24 - 0.1F) * 1.3F) * 0.01F * (f29 - 0.1F), 0.0F);
               }

               GL11.glTranslatef(0.0F, 0.0F, f29 * 0.1F);
               GL11.glRotatef(-335.0F, 0.0F, 0.0F, 1.0F);
               GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glTranslatef(0.0F, 0.5F, 0.0F);
               float f32 = 1.0F + f29 * 0.2F;
               GL11.glScalef(1.0F, 1.0F, f32);
               GL11.glTranslatef(0.0F, -0.5F, 0.0F);
               GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
               GL11.glRotatef(335.0F, 0.0F, 0.0F, 1.0F);
            }
         }

         if (itemstack.a().A_()) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if (itemstack.a().c()) {
            this.a(entityplayersp, itemstack, 0);
            int i1 = Item.e[itemstack.c].b(itemstack.i(), 1);
            float f25 = (i1 >> 16 & 0xFF) / 255.0F;
            float f30 = (i1 >> 8 & 0xFF) / 255.0F;
            float f33 = (i1 & 0xFF) / 255.0F;
            GL11.glColor4f(f3 * f25, f3 * f30, f3 * f33, 1.0F);
            this.a(entityplayersp, itemstack, 1);
         } else {
            this.a(entityplayersp, itemstack, 0);
         }

         GL11.glPopMatrix();
      } else {
         GL11.glPushMatrix();
         float f7 = 0.8F;
         float f12 = entityplayersp.i(par1);
         float f18 = MathHelper.a(f12 * (float) Math.PI);
         float f26 = MathHelper.a(MathHelper.c(f12) * (float) Math.PI);
         GL11.glTranslatef(-f26 * 0.3F, MathHelper.a(MathHelper.c(f12) * (float) Math.PI * 2.0F) * 0.4F, -f18 * 0.4F);
         GL11.glTranslatef(0.8F * f7, -0.75F * f7 - (1.0F - f) * 0.6F, -0.9F * f7);
         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
         GL11.glEnable(32826);
         f12 = entityplayersp.i(par1);
         f18 = MathHelper.a(f12 * f12 * (float) Math.PI);
         f26 = MathHelper.a(MathHelper.c(f12) * (float) Math.PI);
         GL11.glRotatef(f26 * 70.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-f18 * 20.0F, 0.0F, 0.0F, 1.0F);
         GL11.glBindTexture(3553, this.a.p.a(this.a.h.Z, this.a.h.v_()));
         GL11.glTranslatef(-1.0F, 3.6F, 3.5F);
         GL11.glRotatef(120.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(200.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
         GL11.glScalef(1.0F, 1.0F, 1.0F);
         GL11.glTranslatef(5.6F, 0.0F, 0.0F);
         Render render = RenderManager.a.a(this.a.h);
         RenderPlayer renderplayer = (RenderPlayer)render;
         f26 = 1.0F;
         GL11.glScalef(f26, f26, f26);
         renderplayer.b();
         GL11.glPopMatrix();
      }

      GL11.glDisable(32826);
      tf.a();
   }

   public void b(float par1) {
      GL11.glDisable(3008);
      if (this.a.h.T()) {
         int i = this.a.p.b("/terrain.png");
         GL11.glBindTexture(3553, i);
         this.d(par1);
      }

      if (this.a.h.N()) {
         long j = MathHelper.d(this.a.h.o);
         int l = MathHelper.c(this.a.h.p);
         long i1 = MathHelper.d(this.a.h.q);
         int j1 = this.a.p.b("/terrain.png");
         GL11.glBindTexture(3553, j1);
         int k1 = this.a.f.getBlockId(j, l, i1);
         if (this.a.f.isBlockNormalCube(j, l, i1)) {
            this.a(par1, Block.m[k1].a_(2));
         } else {
            for (int l1 = 0; l1 < 8; l1++) {
               float f = ((l1 >> 0) % 2 - 0.5F) * this.a.h.I * 0.9F;
               float f1 = ((l1 >> 1) % 2 - 0.5F) * this.a.h.J * 0.2F;
               float f2 = ((l1 >> 2) % 2 - 0.5F) * this.a.h.I * 0.9F;
               long i2 = MathHelper.d((double)((float)j + f));
               int j2 = MathHelper.c((double)(l + f1));
               long k2 = MathHelper.d((double)((float)i1 + f2));
               if (this.a.f.isBlockNormalCube(i2, j2, k2)) {
                  k1 = this.a.f.getBlockId(i2, j2, k2);
               }
            }
         }

         if (Block.m[k1] != null) {
            this.a(par1, Block.m[k1].a_(2));
         }
      }

      if (this.a.h.a(acn.g)) {
         int k = this.a.p.b("/misc/water.png");
         GL11.glBindTexture(3553, k);
         this.c(par1);
      }

      GL11.glEnable(3008);
   }

   private void a(float par1, int par2) {
      Tessellator tessellator = Tessellator.a;
      float f = this.a.h.a(par1);
      f = 0.1F;
      GL11.glColor4f(f, f, f, 0.5F);
      GL11.glPushMatrix();
      float f1 = -1.0F;
      float f2 = 1.0F;
      float f3 = -1.0F;
      float f4 = 1.0F;
      float f5 = -0.5F;
      float f6 = 0.0078125F;
      float f7 = par2 % 16 / 16.0F - f6;
      float f8 = (par2 % 16 + 0.99F) / 16.0F + f6;
      float f9 = par2 / 16 / 16.0F - f6;
      float f10 = (par2 / 16 + 0.99F) / 16.0F + f6;
      tessellator.b();
      tessellator.a(f1, f3, f5, f8, f10);
      tessellator.a(f2, f3, f5, f7, f10);
      tessellator.a(f2, f4, f5, f7, f9);
      tessellator.a(f1, f4, f5, f8, f9);
      tessellator.a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void c(float par1) {
      Tessellator tessellator = Tessellator.a;
      float f = this.a.h.a(par1);
      GL11.glColor4f(f, f, f, 0.5F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      float f1 = 4.0F;
      float f2 = -1.0F;
      float f3 = 1.0F;
      float f4 = -1.0F;
      float f5 = 1.0F;
      float f6 = -0.5F;
      float f7 = -this.a.h.u / 64.0F;
      float f8 = this.a.h.v / 64.0F;
      tessellator.b();
      tessellator.a(f2, f4, f6, f1 + f7, f1 + f8);
      tessellator.a(f3, f4, f6, 0.0F + f7, f1 + f8);
      tessellator.a(f3, f5, f6, 0.0F + f7, 0.0F + f8);
      tessellator.a(f2, f5, f6, f1 + f7, 0.0F + f8);
      tessellator.a();
      GL11.glPopMatrix();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   private void d(float par1) {
      Tessellator tessellator = Tessellator.a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      float f = 1.0F;

      for (int i = 0; i < 2; i++) {
         GL11.glPushMatrix();
         int j = Block.ar.bN + i * 16;
         int k = (j & 15) << 4;
         int l = j & 240;
         float f1 = k / 256.0F;
         float f2 = (k + 15.99F) / 256.0F;
         float f3 = l / 256.0F;
         float f4 = (l + 15.99F) / 256.0F;
         float f5 = (0.0F - f) / 2.0F;
         float f6 = f5 + f;
         float f7 = 0.0F - f / 2.0F;
         float f8 = f7 + f;
         float f9 = -0.5F;
         GL11.glTranslatef(-(i * 2 - 1) * 0.24F, -0.3F, 0.0F);
         GL11.glRotatef((i * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
         tessellator.b();
         tessellator.a(f5, f7, f9, f2, f4);
         tessellator.a(f6, f7, f9, f1, f4);
         tessellator.a(f6, f8, f9, f1, f3);
         tessellator.a(f5, f8, f9, f2, f3);
         tessellator.a();
         GL11.glPopMatrix();
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
   }

   public void a() {
      this.d = this.c;
      EntityPlayerSP entityplayersp = this.a.h;
      ItemStack itemstack = entityplayersp.ap.b();
      ItemStack itemstack1 = itemstack;
      boolean flag = this.g == entityplayersp.ap.c && itemstack1 == this.b;
      if (this.b == null && itemstack1 == null) {
         flag = true;
      }

      if (itemstack1 != null && this.b != null && itemstack1 != this.b && itemstack1.c == this.b.c && itemstack1.i() == this.b.i()) {
         this.b = itemstack1;
         flag = true;
      }

      float f = 0.4F;
      float f1 = flag ? 1.0F : 0.0F;
      float f2 = f1 - this.c;
      if (f2 < -f) {
         f2 = -f;
      }

      if (f2 > f) {
         f2 = f;
      }

      this.c += f2;
      if (this.c < 0.1F) {
         this.b = itemstack1;
         this.g = entityplayersp.ap.c;
      }
   }

   public void b() {
      this.c = 0.0F;
   }

   public void c() {
      this.c = 0.0F;
   }
}
