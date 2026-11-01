public class EntityAIMoveIndoors extends rc {
   private EntityCreature a;
   private VillageDoorInfo b;
   private long c = -1L;
   private long d = -1L;

   public EntityAIMoveIndoors(EntityCreature par1EntityCreature) {
      this.a = par1EntityCreature;
      this.a(1);
   }

   public boolean a() {
      if ((!this.a.k.m() || this.a.k.G()) && !this.a.k.t.e) {
         if (this.a.aO().nextInt(50) != 0) {
            return false;
         }

         if (this.c != -1L && this.a.f(this.c, this.a.p, this.d) < 4.0) {
            return false;
         }

         Village village = this.a.k.A.findNearestVillage(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q), 14);
         if (village == null) {
            return false;
         }

         this.b = village.findNearestDoorUnrestricted(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q));
         return this.b != null;
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.a.aM().e();
   }

   public void c() {
      this.c = -1L;
      if (this.a.f(this.b.getInsidePosX(), this.b.b, this.b.getInsidePosZ()) > 256.0) {
         bo vec3d = RandomPositionGenerator.a(this.a, 14, 3, bo.b(this.b.getInsidePosX() + 0.5, this.b.b(), this.b.getInsidePosZ() + 0.5));
         if (vec3d != null) {
            this.a.aM().a(vec3d.a, vec3d.b, vec3d.c, 0.3F);
         }
      } else {
         this.a.aM().a(this.b.getInsidePosX() + 0.5, this.b.b(), this.b.getInsidePosZ() + 0.5, 0.3F);
      }
   }

   public void d() {
      this.c = this.b.getInsidePosX();
      this.d = this.b.getInsidePosZ();
      this.b = null;
   }
}
