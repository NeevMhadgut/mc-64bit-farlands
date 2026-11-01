import org.lwjgl.opengl.GL11;

public class EntityFootStepFX extends EntityFX {
   private int a = 0;
   private int au = 0;
   private aaw EntityThrowable;

   public EntityFootStepFX(aaw par1RenderEngine, World par2World, double par3, double par5, double par7) {
      super(par2World, par3, par5, par7, 0.0, 0.0, 0.0);
      this.EntityThrowable = par1RenderEngine;
      this.r = this.s = this.t = 0.0;
      this.au = 200;
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.a + par2) / this.au);
      f *= f;
      float f1 = 2.0F - f * 2.0F;
      if (f1 > 1.0F) {
         f1 = 1.0F;
      }

      f1 *= 0.2F;
      GL11.glDisable(2896);
      float f2 = 0.125F;
      double f3 = this.o - ar;
      double f4 = this.p - as;
      double f5 = this.q - at;
      float f6 = this.k.getLightBrightness(MathHelper.d(this.o), MathHelper.c(this.p), MathHelper.d(this.q));
      this.EntityThrowable.b(this.EntityThrowable.b("/misc/footprint.png"));
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      par1Tessellator.b();
      par1Tessellator.a(f6, f6, f6, f1);
      par1Tessellator.a(f3 - f2, f4, f5 + f2, 0.0, 1.0);
      par1Tessellator.a(f3 + f2, f4, f5 + f2, 1.0, 1.0);
      par1Tessellator.a(f3 + f2, f4, f5 - f2, 1.0, 0.0);
      par1Tessellator.a(f3 - f2, f4, f5 - f2, 0.0, 0.0);
      par1Tessellator.a();
      GL11.glDisable(3042);
      GL11.glEnable(2896);
   }

   @Override
   public void J_() {
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
