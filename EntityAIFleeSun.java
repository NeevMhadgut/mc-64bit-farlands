import java.util.Random;

public class EntityAIFleeSun extends rc {
   private EntityCreature a;
   private double b;
   private double c;
   private double d;
   private float e;
   private World f;

   public EntityAIFleeSun(EntityCreature par1EntityCreature, float par2) {
      this.a = par1EntityCreature;
      this.e = par2;
      this.f = par1EntityCreature.k;
      this.a(1);
   }

   public boolean a() {
      if (!this.f.m()) {
         return false;
      }

      if (!this.a.T()) {
         return false;
      }

      if (!this.f.canBlockSeeTheSky(MathHelper.d(this.a.o), (int)this.a.y.b, MathHelper.d(this.a.q))) {
         return false;
      }

      bo vec3d = this.h();
      if (vec3d == null) {
         return false;
      }

      this.b = vec3d.a;
      this.c = vec3d.b;
      this.d = vec3d.c;
      return true;
   }

   public boolean b() {
      return !this.a.aM().e();
   }

   public void c() {
      this.a.aM().a(this.b, this.c, this.d, this.e);
   }

   private bo h() {
      Random random = this.a.aO();

      for (int i = 0; i < 10; i++) {
         long j = MathHelper.d(this.a.o + random.nextInt(20) - 10.0);
         int k = MathHelper.c(this.a.y.b + random.nextInt(6) - 3.0);
         long l = MathHelper.d(this.a.q + random.nextInt(20) - 10.0);
         if (!this.f.canBlockSeeTheSky(j, k, l) && this.a.getBlockPathWeight(j, k, l) < 0.0F) {
            return bo.b(j, k, l);
         }
      }

      return null;
   }
}
