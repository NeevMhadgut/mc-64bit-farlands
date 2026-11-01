public abstract class EntityAITarget extends rc {
   protected EntityLiving c;
   protected float d;
   protected boolean e;
   private boolean a;
   private int b = 0;
   private int f = 0;
   private int g = 0;

   public EntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3) {
      this(par1EntityLiving, par2, par3, false);
   }

   public EntityAITarget(EntityLiving par1EntityLiving, float par2, boolean par3, boolean par4) {
      this.c = par1EntityLiving;
      this.d = par2;
      this.e = par3;
      this.a = par4;
   }

   public boolean b() {
      EntityLiving entityliving = this.c.aT();
      if (entityliving == null) {
         return false;
      }

      if (!entityliving.M()) {
         return false;
      }

      if (this.c.f(entityliving) > this.d * this.d) {
         return false;
      }

      if (this.e) {
         if (!this.c.aN().a(entityliving)) {
            if (++this.g > 60) {
               return false;
            }
         } else {
            this.g = 0;
         }
      }

      return true;
   }

   public void c() {
      this.b = 0;
      this.f = 0;
      this.g = 0;
   }

   public void d() {
      this.c.c((EntityLiving)null);
   }

   protected boolean a(EntityLiving par1EntityLiving, boolean par2) {
      if (par1EntityLiving == null) {
         return false;
      }

      if (par1EntityLiving == this.c) {
         return false;
      }

      if (!par1EntityLiving.M()) {
         return false;
      }

      if (!(par1EntityLiving.y.e <= this.c.y.b) && !(par1EntityLiving.y.b >= this.c.y.e)) {
         if (!this.c.a(par1EntityLiving.getClass())) {
            return false;
         }

         if (this.c instanceof wd && ((wd)this.c).G_()) {
            if (par1EntityLiving instanceof wd && ((wd)par1EntityLiving).G_()) {
               return false;
            }

            if (par1EntityLiving == ((wd)this.c).ah()) {
               return false;
            }
         } else if (par1EntityLiving instanceof EntityPlayer && !par2 && ((EntityPlayer)par1EntityLiving).aT.a) {
            return false;
         }

         if (!this.c.isWithinHomeDistance(MathHelper.d(par1EntityLiving.o), MathHelper.c(par1EntityLiving.p), MathHelper.d(par1EntityLiving.q))) {
            return false;
         }

         if (this.e && !this.c.aN().a(par1EntityLiving)) {
            return false;
         }

         if (this.a) {
            if (--this.f <= 0) {
               this.b = 0;
            }

            if (this.b == 0) {
               this.b = this.a(par1EntityLiving) ? 1 : 2;
            }

            if (this.b == 2) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean a(EntityLiving par1EntityLiving) {
      this.f = 10 + this.c.aO().nextInt(5);
      PathEntity pathentity = this.c.aM().a(par1EntityLiving);
      if (pathentity == null) {
         return false;
      }

      e pathpoint = pathentity.c();
      if (pathpoint == null) {
         return false;
      }

      long i = pathpoint.a - MathHelper.d(par1EntityLiving.o);
      long j = pathpoint.c - MathHelper.d(par1EntityLiving.q);
      return i * i + j * j <= 2.25;
   }
}
