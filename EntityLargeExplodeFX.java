import org.lwjgl.opengl.GL11;

public class EntityLargeExplodeFX extends EntityFX {
   private int a = 0;
   private int au = 0;
   private aaw EntityThrowable;
   private float aw;

   public EntityLargeExplodeFX(aaw par1RenderEngine, World par2World, double par3, double par5, double par7, double par9, double par11, double par13) {
      super(par2World, par3, par5, par7, 0.0, 0.0, 0.0);
      this.EntityThrowable = par1RenderEngine;
      this.au = 6 + this.U.nextInt(4);
      this.GenLayerHills = this.ap = this.aq = this.U.nextFloat() * 0.6F + 0.4F;
      this.aw = 1.0F - (float)par9 * 0.5F;
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      int i = (int)((this.a + (float)par2) * 15.0F / this.au);
      if (i <= 15) {
         this.EntityThrowable.b(this.EntityThrowable.b("/misc/explosion.png"));
         float f = i % 4 / 4.0F;
         float f1 = f + 0.24975F;
         float f2 = i / 4 / 4.0F;
         float f3 = f2 + 0.24975F;
         double f4 = 2.0 * this.aw;
         double f5 = this.l + (this.o - this.l) * par2 - ar;
         double f6 = this.m + (this.p - this.m) * par2 - as;
         double f7 = this.n + (this.q - this.n) * par2 - at;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(2896);
         tf.a();
         par1Tessellator.b();
         par1Tessellator.a(this.GenLayerHills, this.ap, this.aq, 1.0F);
         par1Tessellator.b(0.0F, 1.0F, 0.0F);
         par1Tessellator.b(240);
         par1Tessellator.a(f5 - par3 * f4 - par6 * f4, f6 - par4 * f4, f7 - par5 * f4 - par7 * f4, f1, f3);
         par1Tessellator.a(f5 - par3 * f4 + par6 * f4, f6 + par4 * f4, f7 - par5 * f4 + par7 * f4, f1, f2);
         par1Tessellator.a(f5 + par3 * f4 + par6 * f4, f6 + par4 * f4, f7 + par5 * f4 + par7 * f4, f, f2);
         par1Tessellator.a(f5 + par3 * f4 - par6 * f4, f6 - par4 * f4, f7 + par5 * f4 - par7 * f4, f, f3);
         par1Tessellator.a();
         GL11.glPolygonOffset(0.0F, 0.0F);
         GL11.glEnable(2896);
      }
   }

   @Override
   public int b(float par1) {
      return 61680;
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.a++;
      if (this.a == this.au) {
         this.A();
      }
   }

   @Override
   public int n() {
      return 3;
   }
}
