import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class RenderEndPortal extends aar {
   FloatBuffer a = GLAllocation.e(16);

   public void a(bw par1TileEntityEndPortal, double par2, double par4, double par6, float par8) {
      double f = this.b.j;
      double f1 = this.b.k;
      double f2 = this.b.l;
      GL11.glDisable(2896);
      Random random = new Random(31100L);
      double f3 = 0.75;

      for (int i = 0; i < 16; i++) {
         GL11.glPushMatrix();
         double f4 = 16 - i;
         double f5 = 0.0625;
         double f6 = 1.0 / (f4 + 1.0);
         if (i == 0) {
            this.a("/misc/tunnel.png");
            f6 = 0.1;
            f4 = 65.0;
            f5 = 0.125;
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
         }

         if (i == 1) {
            this.a("/misc/particlefield.png");
            GL11.glEnable(3042);
            GL11.glBlendFunc(1, 1);
            f5 = 0.5;
         }

         double f7 = -(par4 + f3);
         double f8 = f7 + ActiveRenderInfo.b;
         double f9 = f7 + f4 + ActiveRenderInfo.b;
         double f10d = par4 + f3 + f8 / f9;
         GL11.glTranslated(f, f10d, f2);
         GL11.glTexGeni(8192, 9472, 9217);
         GL11.glTexGeni(8193, 9472, 9217);
         GL11.glTexGeni(8194, 9472, 9217);
         GL11.glTexGeni(8195, 9472, 9216);
         GL11.glTexGen(8192, 9473, this.a(1.0F, 0.0F, 0.0F, 0.0F));
         GL11.glTexGen(8193, 9473, this.a(0.0F, 0.0F, 1.0F, 0.0F));
         GL11.glTexGen(8194, 9473, this.a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glTexGen(8195, 9474, this.a(0.0F, 1.0F, 0.0F, 0.0F));
         GL11.glEnable(3168);
         GL11.glEnable(3169);
         GL11.glEnable(3170);
         GL11.glEnable(3171);
         GL11.glPopMatrix();
         GL11.glMatrixMode(5890);
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glTranslated(0.0, System.currentTimeMillis() % 700000L / 700000.0, 0.0);
         GL11.glScaled(f5, f5, f5);
         GL11.glTranslated(0.5, 0.5, 0.0);
         GL11.glRotated((i * i * 4321 + i * 9) * 2.0, 0.0, 0.0, 1.0);
         GL11.glTranslated(-0.5, -0.5, 0.0);
         GL11.glTranslated(-f, -f2, -f1);
         f8 = f7 + ActiveRenderInfo.b;
         GL11.glTranslated(ActiveRenderInfo.a * f4 / f8, ActiveRenderInfo.c * f4 / f8, -f1);
         Tessellator tessellator = Tessellator.a;
         tessellator.b();
         double f10 = random.nextFloat() * 0.5F + 0.1F;
         double f11 = random.nextFloat() * 0.5F + 0.4F;
         double f12 = random.nextFloat() * 0.5F + 0.5F;
         if (i == 0) {
            f12 = 1.0;
            f11 = 1.0;
            f10 = 1.0;
         }

         tessellator.setColorRGBA_D(f10 * f6, f11 * f6, f12 * f6, 1.0);
         tessellator.a(par2, par4 + f3, par6);
         tessellator.a(par2, par4 + f3, par6 + 1.0);
         tessellator.a(par2 + 1.0, par4 + f3, par6 + 1.0);
         tessellator.a(par2 + 1.0, par4 + f3, par6);
         tessellator.a();
         GL11.glPopMatrix();
         GL11.glMatrixMode(5888);
      }

      GL11.glDisable(3042);
      GL11.glDisable(3168);
      GL11.glDisable(3169);
      GL11.glDisable(3170);
      GL11.glDisable(3171);
      GL11.glEnable(2896);
   }

   private FloatBuffer a(float par1, float par2, float par3, float par4) {
      ((Buffer)this.a).clear();
      this.a.put(par1).put(par2).put(par3).put(par4);
      ((Buffer)this.a).flip();
      return this.a;
   }

   public void a(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
      this.a((bw)par1TileEntity, par2, par4, par6, par8);
   }
}
