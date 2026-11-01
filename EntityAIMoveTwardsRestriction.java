public class EntityAIMoveTwardsRestriction extends rc {
   private EntityCreature a;
   private double b;
   private double c;
   private double d;
   private float e;

   public EntityAIMoveTwardsRestriction(EntityCreature par1EntityCreature, float par2) {
      this.a = par1EntityCreature;
      this.e = par2;
      this.a(1);
   }

   public boolean a() {
      if (this.a.aU()) {
         return false;
      }

      ChunkCoordinates chunkcoordinates = this.a.aV();
      bo vec3d = RandomPositionGenerator.a(this.a, 16, 7, bo.b(chunkcoordinates.a, chunkcoordinates.b, chunkcoordinates.c));
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
}
