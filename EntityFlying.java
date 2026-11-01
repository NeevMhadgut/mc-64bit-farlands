public abstract class EntityFlying extends EntityLiving {
   public EntityFlying(World par1World) {
      super(par1World);
   }

   @Override
   protected void e(float f) {
   }

   @Override
   public void a_(float par1, float par2) {
      if (this.H()) {
         this.a((float)par1, (float)par2, 0.02F);
         this.b(this.r, this.s, this.t);
         this.r *= 0.8F;
         this.s *= 0.8F;
         this.t *= 0.8F;
      } else if (this.J()) {
         this.a((float)par1, (float)par2, 0.02F);
         this.b(this.r, this.s, this.t);
         this.r *= 0.5;
         this.s *= 0.5;
         this.t *= 0.5;
      } else {
         double f = 0.91;
         if (this.z) {
            f = 0.5460001;
            int i = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.y.b) - 1, MathHelper.d(this.q));
            if (i > 0) {
               f = Block.m[i].ce * 0.91;
            }
         }

         float f1 = (float)(0.1627714 / (f * f * f));
         this.a((float)par1, (float)par2, this.z ? 0.1F * f1 : 0.02F);
         f = 0.91;
         if (this.z) {
            f = 0.5460001;
            int j = this.k.getBlockId(MathHelper.d(this.o), MathHelper.c(this.y.b) - 1, MathHelper.d(this.q));
            if (j > 0) {
               f = Block.m[j].ce * 0.91;
            }
         }

         this.b(this.r, this.s, this.t);
         this.r *= f;
         this.s *= f;
         this.t *= f;
      }

      this.bL = this.bM;
      double d = this.o - this.l;
      double d1 = this.q - this.n;
      float f2 = MathHelper.a(d * d + d1 * d1) * 4.0F;
      if (f2 > 1.0F) {
         f2 = 1.0F;
      }

      this.bM = this.bM + (f2 - this.bM) * 0.4F;
      this.bN = this.bN + this.bM;
   }

   @Override
   public boolean p() {
      return false;
   }
}
