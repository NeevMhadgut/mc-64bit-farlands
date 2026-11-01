public class EntityCrit2FX extends EntityFX {
   private Entity a;
   private int au = 0;
   private int EntityThrowable = 0;
   private String aw;

   public EntityCrit2FX(World par1World, Entity par2Entity) {
      this(par1World, par2Entity, "crit");
   }

   public EntityCrit2FX(World par1World, Entity par2Entity, String par3Str) {
      super(par1World, par2Entity.o, par2Entity.y.b + par2Entity.J / 2.0F, par2Entity.q, par2Entity.r, par2Entity.s, par2Entity.t);
      this.a = par2Entity;
      this.EntityThrowable = 3;
      this.aw = par3Str;
      this.J_();
   }

   @Override
   public void renderParticle(Tessellator tessellator, double f, double f1, double f2, double f3, double f4, double f5) {
   }

   @Override
   public void J_() {
      for (int i = 0; i < 16; i++) {
         double d = this.U.nextFloat() * 2.0F - 1.0F;
         double d1 = this.U.nextFloat() * 2.0F - 1.0F;
         double d2 = this.U.nextFloat() * 2.0F - 1.0F;
         if (d * d + d1 * d1 + d2 * d2 <= 1.0) {
            double d3 = this.a.o + d * this.a.I / 4.0;
            double d4 = this.a.y.b + this.a.J / 2.0F + d1 * this.a.J / 4.0;
            double d5 = this.a.q + d2 * this.a.I / 4.0;
            this.k.a(this.aw, d3, d4, d5, d, d1 + 0.2, d2);
         }
      }

      this.au++;
      if (this.au >= this.EntityThrowable) {
         this.A();
      }
   }

   @Override
   public int n() {
      return 3;
   }
}
