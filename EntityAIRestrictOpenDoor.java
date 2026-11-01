public class EntityAIRestrictOpenDoor extends rc {
   private EntityCreature a;
   private VillageDoorInfo b;

   public EntityAIRestrictOpenDoor(EntityCreature par1EntityCreature) {
      this.a = par1EntityCreature;
   }

   public boolean a() {
      if (this.a.k.m()) {
         return false;
      }

      Village village = this.a.k.A.findNearestVillage(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q), 16);
      if (village == null) {
         return false;
      }

      this.b = village.findNearestDoor(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q));
      return this.b == null ? false : this.b.getInsideDistanceSquare(MathHelper.d(this.a.o), MathHelper.c(this.a.p), MathHelper.d(this.a.q)) < 2.25;
   }

   public boolean b() {
      return this.a.k.m() ? false : !this.b.g && this.b.isInside(MathHelper.d(this.a.o), MathHelper.d(this.a.q));
   }

   public void c() {
      this.a.aM().b(false);
      this.a.aM().c(false);
   }

   public void d() {
      this.a.aM().b(true);
      this.a.aM().c(true);
      this.b = null;
   }

   public void e() {
      this.b.e();
   }
}
