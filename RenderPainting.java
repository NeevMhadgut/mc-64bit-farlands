import java.util.Random;
import org.lwjgl.opengl.GL11;

public class RenderPainting extends Render {
   private Random a = new Random();

   public void a(EntityPainting par1EntityPainting, double par2, double par4, double par6, float par8, float par9) {
      this.a.setSeed(187L);
      GL11.glPushMatrix();
      GL11.glTranslatef((float)par2, (float)par4, (float)par6);
      GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);
      GL11.glEnable(32826);
      this.a("/art/RenderEndPortal.png");
      go enumart = par1EntityPainting.e;
      float f = 0.0625F;
      GL11.glScalef(f, f, f);
      this.a(par1EntityPainting, enumart.B, enumart.C, enumart.D, enumart.E);
      GL11.glDisable(32826);
      GL11.glPopMatrix();
   }

   private void a(EntityPainting par1EntityPainting, int par2, int par3, int par4, int par5) {
      float f = -par2 / 2.0F;
      float f1 = -par3 / 2.0F;
      float f2 = -0.5F;
      float f3 = 0.5F;

      for (int i = 0; i < par2 / 16; i++) {
         for (int j = 0; j < par3 / 16; j++) {
            float f4 = f + (i + 1) * 16;
            float f5 = f + i * 16;
            float f6 = f1 + (j + 1) * 16;
            float f7 = f1 + j * 16;
            this.a(par1EntityPainting, (f4 + f5) / 2.0F, (f6 + f7) / 2.0F);
            float f8 = (par4 + par2 - i * 16) / 256.0F;
            float f9 = (par4 + par2 - (i + 1) * 16) / 256.0F;
            float f10 = (par5 + par3 - j * 16) / 256.0F;
            float f11 = (par5 + par3 - (j + 1) * 16) / 256.0F;
            float f12 = 0.75F;
            float f13 = 0.8125F;
            float f14 = 0.0F;
            float f15 = 0.0625F;
            float f16 = 0.75F;
            float f17 = 0.8125F;
            float f18 = 0.001953125F;
            float f19 = 0.001953125F;
            float f20 = 0.7519531F;
            float f21 = 0.7519531F;
            float f22 = 0.0F;
            float f23 = 0.0625F;
            Tessellator tessellator = Tessellator.a;
            tessellator.b();
            tessellator.b(0.0F, 0.0F, -1.0F);
            tessellator.a(f4, f7, f2, f9, f10);
            tessellator.a(f5, f7, f2, f8, f10);
            tessellator.a(f5, f6, f2, f8, f11);
            tessellator.a(f4, f6, f2, f9, f11);
            tessellator.b(0.0F, 0.0F, 1.0F);
            tessellator.a(f4, f6, f3, f12, f14);
            tessellator.a(f5, f6, f3, f13, f14);
            tessellator.a(f5, f7, f3, f13, f15);
            tessellator.a(f4, f7, f3, f12, f15);
            tessellator.b(0.0F, 1.0F, 0.0F);
            tessellator.a(f4, f6, f2, f16, f18);
            tessellator.a(f5, f6, f2, f17, f18);
            tessellator.a(f5, f6, f3, f17, f19);
            tessellator.a(f4, f6, f3, f16, f19);
            tessellator.b(0.0F, -1.0F, 0.0F);
            tessellator.a(f4, f7, f3, f16, f18);
            tessellator.a(f5, f7, f3, f17, f18);
            tessellator.a(f5, f7, f2, f17, f19);
            tessellator.a(f4, f7, f2, f16, f19);
            tessellator.b(-1.0F, 0.0F, 0.0F);
            tessellator.a(f4, f6, f3, f21, f22);
            tessellator.a(f4, f7, f3, f21, f23);
            tessellator.a(f4, f7, f2, f20, f23);
            tessellator.a(f4, f6, f2, f20, f22);
            tessellator.b(1.0F, 0.0F, 0.0F);
            tessellator.a(f5, f6, f2, f21, f22);
            tessellator.a(f5, f7, f2, f21, f23);
            tessellator.a(f5, f7, f3, f20, f23);
            tessellator.a(f5, f6, f3, f20, f22);
            tessellator.a();
         }
      }
   }

   private void a(EntityPainting par1EntityPainting, float par2, float par3) {
      long i = MathHelper.d(par1EntityPainting.o);
      int j = MathHelper.c(par1EntityPainting.p + par3 / 16.0F);
      long k = MathHelper.d(par1EntityPainting.q);
      if (par1EntityPainting.a == 0) {
         i = MathHelper.d(par1EntityPainting.o + par2 / 16.0F);
      }

      if (par1EntityPainting.a == 1) {
         k = MathHelper.d(par1EntityPainting.q - par2 / 16.0F);
      }

      if (par1EntityPainting.a == 2) {
         i = MathHelper.d(par1EntityPainting.o - par2 / 16.0F);
      }

      if (par1EntityPainting.a == 3) {
         k = MathHelper.d(par1EntityPainting.q + par2 / 16.0F);
      }

      int l = this.e.g.getLightBrightnessForSkyBlocks(i, j, k, 0);
      int i1 = l % 65536;
      int j1 = l / 65536;
      es.a(es.b, i1, j1);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
   }

   @Override
   public void a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
      this.a((EntityPainting)par1Entity, par2, par4, par6, par8, par9);
   }
}
