import java.util.Random;

public class EntityAIVillagerMate extends rc {
   private EntityVillager b;
   private EntityVillager c;
   private World d;
   private int e = 0;
   Village a;

   public EntityAIVillagerMate(EntityVillager par1EntityVillager) {
      this.b = par1EntityVillager;
      this.d = par1EntityVillager.k;
      this.a(3);
   }

   public boolean a() {
      if (this.b.EntityThrowable() != 0) {
         return false;
      }

      if (this.b.aO().nextInt(500) != 0) {
         return false;
      }

      this.a = this.d.A.findNearestVillage(MathHelper.d(this.b.o), MathHelper.c(this.b.p), MathHelper.d(this.b.q), 0);
      if (this.a == null) {
         return false;
      }

      if (!this.h()) {
         return false;
      }

      Entity entity = this.d.a(EntityVillager.class, this.b.y.b(8.0, 3.0, 8.0), this.b);
      if (entity == null) {
         return false;
      }

      this.c = (EntityVillager)entity;
      return this.c.EntityThrowable() == 0;
   }

   public void c() {
      this.e = 300;
      this.b.a(true);
   }

   public void d() {
      this.a = null;
      this.c = null;
      this.b.a(false);
   }

   public boolean b() {
      return this.e >= 0 && this.h() && this.b.EntityThrowable() == 0;
   }

   public void e() {
      this.e--;
      this.b.aJ().a(this.c, 10.0F, 30.0F);
      if (this.b.f(this.c) > 2.25) {
         this.b.aM().a(this.c, 0.25F);
      } else if (this.e == 0 && this.c.x_()) {
         this.i();
      }

      if (this.b.aO().nextInt(35) == 0) {
         this.a(this.b);
      }
   }

   private boolean h() {
      int i = (int)(this.a.c() * 0.35);
      return this.a.e() < i;
   }

   private void i() {
      EntityVillager entityvillager = new EntityVillager(this.d);
      this.c.d(6000);
      this.b.d(6000);
      entityvillager.d(-24000);
      entityvillager.d_(this.b.aO().nextInt(5));
      entityvillager.c(this.b.o, this.b.p, this.b.q, 0.0F, 0.0F);
      this.d.a(entityvillager);
      this.a(entityvillager);
   }

   private void a(EntityLiving par1EntityLiving) {
      Random random = par1EntityLiving.aO();

      for (int i = 0; i < 5; i++) {
         double d = random.nextGaussian() * 0.02;
         double d1 = random.nextGaussian() * 0.02;
         double d2 = random.nextGaussian() * 0.02;
         this.d
            .a(
               "heart",
               par1EntityLiving.o + random.nextFloat() * par1EntityLiving.I * 2.0F - par1EntityLiving.I,
               par1EntityLiving.p + 1.0 + random.nextFloat() * par1EntityLiving.J,
               par1EntityLiving.q + random.nextFloat() * par1EntityLiving.I * 2.0F - par1EntityLiving.I,
               d,
               d1,
               d2
            );
      }
   }
}
