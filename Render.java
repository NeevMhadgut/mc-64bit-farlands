import org.lwjgl.opengl.GL11;

public abstract class Render {
   protected RenderManager e;
   private ho a = new xg();
   protected RenderBlocks f = new RenderBlocks();
   protected float g = 0.0F;
   protected float h = 1.0F;

   public abstract void a(Entity var1, double var2, double var4, double var6, float var8, float var9);

   protected void a(String par1Str) {
      aaw renderengine = this.e.e;
      renderengine.b(renderengine.b(par1Str));
   }

   protected boolean a(String par1Str, String par2Str) {
      aaw renderengine = this.e.e;
      int i = renderengine.a(par1Str, par2Str);
      if (i >= 0) {
         renderengine.b(i);
         return true;
      } else {
         return false;
      }
   }

   private void a(Entity par1Entity, double par2, double par4, double par6, float par8) {
      GL11.glDisable(2896);
      int i = Block.ar.bN;
      int j = (i & 15) << 4;
      int k = i & 240;
      float f = j / 256.0F;
      float f2 = (j + 15.99F) / 256.0F;
      float f4 = k / 256.0F;
      float f6 = (k + 15.99F) / 256.0F;
      GL11.glPushMatrix();
      GL11.glTranslated(par2, par4, par6);
      float f8 = par1Entity.I * 1.4F;
      GL11.glScalef(f8, f8, f8);
      this.a("/terrain.png");
      Tessellator tessellator = Tessellator.a;
      float f9 = 0.5F;
      float f10 = 0.0F;
      float f11 = par1Entity.J / f8;
      float f12 = (float)(par1Entity.p - par1Entity.y.b);
      GL11.glRotatef(-this.e.i, 0.0F, 1.0F, 0.0F);
      GL11.glTranslatef(0.0F, 0.0F, -0.3F + (int)f11 * 0.02F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      float f13 = 0.0F;
      int l = 0;
      tessellator.b();

      while (f11 > 0.0F) {
         float f1;
         float f3;
         float f5;
         float f7;
         if (l % 2 == 0) {
            f1 = j / 256.0F;
            f3 = (j + 15.99F) / 256.0F;
            f5 = k / 256.0F;
            f7 = (k + 15.99F) / 256.0F;
         } else {
            f1 = j / 256.0F;
            f3 = (j + 15.99F) / 256.0F;
            f5 = (k + 16) / 256.0F;
            f7 = (k + 16 + 15.99F) / 256.0F;
         }

         if (l / 2 % 2 == 0) {
            float f14 = f3;
            f3 = f1;
            f1 = f14;
         }

         tessellator.a(f9 - f10, 0.0F - f12, f13, f3, f7);
         tessellator.a(-f9 - f10, 0.0F - f12, f13, f1, f7);
         tessellator.a(-f9 - f10, 1.4F - f12, f13, f1, f5);
         tessellator.a(f9 - f10, 1.4F - f12, f13, f3, f5);
         f11 -= 0.45F;
         f12 -= 0.45F;
         f9 *= 0.9F;
         f13 += 0.03F;
         l++;
      }

      tessellator.a();
      GL11.glPopMatrix();
      GL11.glEnable(2896);
   }

   private void c(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      aaw renderengine = this.e.e;
      renderengine.b(renderengine.b("%clamp%/misc/shadow.png"));
      World world = this.b();
      GL11.glDepthMask(false);
      float f = this.g;
      if (par1Entity instanceof EntityLiving) {
         EntityLiving entityliving = (EntityLiving)par1Entity;
         f *= entityliving.bd();
         if (entityliving instanceof EntityAnimal) {
            EntityAnimal entityanimal = (EntityAnimal)entityliving;
            if (entityanimal.bi()) {
               f *= 0.5F;
            }
         }
      }

      double d = par1Entity.N + (par1Entity.o - par1Entity.N);
      double d1 = par1Entity.O + (par1Entity.p - par1Entity.O) * par9 + par1Entity.h_();
      double d2 = par1Entity.P + (par1Entity.q - par1Entity.P);
      long i = MathHelper.d(d - f);
      long j = MathHelper.d(d + f);
      int k = MathHelper.c(d1 - f);
      int l = MathHelper.c(d1);
      long i1 = MathHelper.d(d2 - f);
      long j1 = MathHelper.d(d2 + f);
      double d3 = par2 - d;
      double d4 = par4 - d1;
      double d5 = par6 - d2;
      Tessellator tessellator = Tessellator.a;
      tessellator.b();

      for (long k1 = i; k1 >= i && k1 <= j; k1++) {
         for (int l1 = k; l1 >= k && l1 <= l; l1++) {
            for (long i2 = i1; i2 >= i1 && i2 <= j1; i2++) {
               int j2 = world.getBlockId(k1, l1 - 1, i2);
               if (j2 > 0 && world.getBlockLightValue(k1, l1, i2) > 3) {
                  this.renderShadowOnBlock(Block.m[j2], par2, par4 + par1Entity.h_(), par6, k1, l1, i2, par8, f, d3, d4 + par1Entity.h_(), d5);
               }
            }
         }
      }

      tessellator.a();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glDepthMask(true);
   }

   private World b() {
      return this.e.g;
   }

   private void renderShadowOnBlock(
      Block par1Block, double par2, double par4, double par6, long par8, int par9, long par10, float par11, float par12, double par13, double par15, double par17
   ) {
      Tessellator tessellator = Tessellator.a;
      if (par1Block.b()) {
         double d = (par11 - (par4 - (par9 + par15)) / 2.0) * 0.5 * this.b().getLightBrightness(par8, par9, par10);
         if (!(d < 0.0)) {
            if (d > 1.0) {
               d = 1.0;
            }

            tessellator.a(1.0F, 1.0F, 1.0F, (float)d);
            double d1 = par8 + par1Block.bV + par13;
            double d2 = par8 + par1Block.bY + par13;
            double d3 = par9 + par1Block.bW + par15 + 0.015625;
            double d4 = par10 + par1Block.bX + par17;
            double d5 = par10 + par1Block.IChunkProvider + par17;
            float f = (float)((par2 - d1) / 2.0 / par12 + 0.5);
            float f1 = (float)((par2 - d2) / 2.0 / par12 + 0.5);
            float f2 = (float)((par6 - d4) / 2.0 / par12 + 0.5);
            float f3 = (float)((par6 - d5) / 2.0 / par12 + 0.5);
            tessellator.a(d1, d3, d4, f, f2);
            tessellator.a(d1, d3, d5, f, f3);
            tessellator.a(d2, d3, d5, f1, f3);
            tessellator.a(d2, d3, d4, f1, f2);
         }
      }
   }

   public static void a(AxisAlignedBB par0AxisAlignedBB, double par1, double par3, double par5) {
      GL11.glDisable(3553);
      Tessellator tessellator = Tessellator.a;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      tessellator.b();
      tessellator.b(par1, par3, par5);
      tessellator.b(0.0F, 0.0F, -1.0F);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.b(0.0F, 0.0F, 1.0F);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.b(0.0F, -1.0F, 0.0F);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.b(0.0F, 1.0F, 0.0F);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.b(-1.0F, 0.0F, 0.0F);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.b(1.0F, 0.0F, 0.0F);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.b(0.0, 0.0, 0.0);
      tessellator.a();
      GL11.glEnable(3553);
   }

   public static void a(AxisAlignedBB par0AxisAlignedBB) {
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.a, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.c);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.e, par0AxisAlignedBB.f);
      tessellator.a(par0AxisAlignedBB.d, par0AxisAlignedBB.b, par0AxisAlignedBB.f);
      tessellator.a();
   }

   public void a(RenderManager par1RenderManager) {
      this.e = par1RenderManager;
   }

   public void b(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      if (this.e.k.j && this.g > 0.0F) {
         double d = this.e.a(par1Entity.o, par1Entity.p, par1Entity.q);
         float f = (float)((1.0 - d / 256.0) * this.h);
         if (f > 0.0F) {
            this.c(par1Entity, par2, par4, par6, f, par9);
         }
      }

      if (par1Entity.T()) {
         this.a(par1Entity, par2, par4, par6, par9);
      }
   }

   public nl a() {
      return this.e.a();
   }
}
