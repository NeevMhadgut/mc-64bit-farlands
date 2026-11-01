import org.lwjgl.opengl.GL11;

public class EntityPickupFX extends EntityFX {
   private Entity a;
   private Entity au;
   private int EntityThrowable = 0;
   private int aw = 0;
   private float EntityAIAttackOnCollide;

   public EntityPickupFX(World par1World, Entity par2Entity, Entity par3Entity, float par4) {
      super(par1World, par2Entity.o, par2Entity.p, par2Entity.q, par2Entity.r, par2Entity.s, par2Entity.t);
      this.a = par2Entity;
      this.au = par3Entity;
      this.aw = 3;
      this.EntityAIAttackOnCollide = par4;
   }

   @Override
   public void renderParticle(Tessellator par1Tessellator, double par2, double par3, double par4, double par5, double par6, double par7) {
      float f = (float)((this.EntityThrowable + par2) / this.aw);
      f *= f;
      double d = this.a.o;
      double d1 = this.a.p;
      double d2 = this.a.q;
      double d3 = this.au.N + (this.au.o - this.au.N) * par2;
      double d4 = this.au.O + (this.au.p - this.au.O) * par2 + this.EntityAIAttackOnCollide;
      double d5 = this.au.P + (this.au.q - this.au.P) * par2;
      double d6 = d + (d3 - d) * f;
      double d7 = d1 + (d4 - d1) * f;
      double d8 = d2 + (d5 - d2) * f;
      long i = MathHelper.d(d6);
      int j = MathHelper.c(d7 + this.H / 2.0F);
      long k = MathHelper.d(d8);
      int l = this.b((float)par2);
      int i1 = l % 65536;
      int j1 = l / 65536;
      es.a(es.b, i1 / 1.0F, j1 / 1.0F);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      d6 -= ar;
      d7 -= as;
      d8 -= at;
      RenderManager.a.a(this.a, d6, d7, d8, this.a.u, (float)par2);
   }

   @Override
   public void J_() {
      this.EntityThrowable++;
      if (this.EntityThrowable == this.aw) {
         this.A();
      }
   }

   @Override
   public int n() {
      return 3;
   }
}
