public class EntityAIAttackOnCollide extends rc {
   World a;
   EntityLiving b;
   EntityLiving c;
   int d = 0;
   float e;
   boolean f;
   PathEntity g;
   Class h;
   private int i;

   public EntityAIAttackOnCollide(EntityLiving par1EntityLiving, Class par2Class, float par3, boolean par4) {
      this(par1EntityLiving, par3, par4);
      this.h = par2Class;
   }

   public EntityAIAttackOnCollide(EntityLiving par1EntityLiving, float par2, boolean par3) {
      this.b = par1EntityLiving;
      this.a = par1EntityLiving.k;
      this.e = par2;
      this.f = par3;
      this.a(3);
   }

   public boolean a() {
      EntityLiving entityliving = this.b.aT();
      if (entityliving == null) {
         return false;
      }

      if (this.h != null && !this.h.isAssignableFrom(entityliving.getClass())) {
         return false;
      }

      this.c = entityliving;
      this.g = this.b.aM().a(this.c);
      return this.g != null;
   }

   public boolean b() {
      EntityLiving entityliving = this.b.aT();
      if (entityliving == null) {
         return false;
      } else if (!this.c.M()) {
         return false;
      } else {
         return !this.f ? !this.b.aM().e() : this.b.isWithinHomeDistance(MathHelper.d(this.c.o), MathHelper.c(this.c.p), MathHelper.d(this.c.q));
      }
   }

   public void c() {
      this.b.aM().a(this.g, this.e);
      this.i = 0;
   }

   public void d() {
      this.c = null;
      this.b.aM().f();
   }

   public void e() {
      this.b.aJ().a(this.c, 30.0F, 30.0F);
      if ((this.f || this.b.aN().a(this.c)) && --this.i <= 0) {
         this.i = 4 + this.b.aO().nextInt(7);
         this.b.aM().a(this.c, this.e);
      }

      this.d = Math.max(this.d - 1, 0);
      double d = this.b.I * 2.0F * (this.b.I * 2.0F);
      if (!(this.b.f(this.c.o, this.c.y.b, this.c.q) > d)) {
         if (this.d <= 0) {
            this.d = 20;
            this.b.c((Entity)this.c);
         }
      }
   }
}
